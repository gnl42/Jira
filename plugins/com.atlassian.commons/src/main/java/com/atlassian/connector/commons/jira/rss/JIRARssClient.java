/*     */ package com.atlassian.connector.commons.jira.rss;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import com.atlassian.connector.commons.jira.JIRAIssue;
/*     */ import com.atlassian.connector.commons.jira.JIRAIssueBean;
/*     */ import com.atlassian.connector.commons.jira.JIRASessionPartTwo;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRASavedFilter;
/*     */ import com.atlassian.connector.commons.jira.beans.JiraFilter;
/*     */ import com.atlassian.connector.commons.jira.cache.CachedIconLoader;
/*     */ import com.atlassian.theplugin.commons.cfg.UserCfg;
/*     */ import com.atlassian.theplugin.commons.remoteapi.CaptchaRequiredException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiMalformedUrlException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiSessionExpiredException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.ServerData;
/*     */ import com.atlassian.theplugin.commons.remoteapi.ServiceUnavailableException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.jira.JiraCaptchaRequiredException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.jira.JiraServiceUnavailableException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.AbstractHttpSession;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;
/*     */ import com.atlassian.theplugin.commons.util.StringUtil;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.httpclient.Cookie;
/*     */ import org.apache.commons.httpclient.Header;
/*     */ import org.apache.commons.httpclient.HttpMethod;
/*     */ import org.apache.commons.httpclient.auth.AuthenticationException;
/*     */ import org.apache.commons.httpclient.methods.PostMethod;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.JDOMException;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JIRARssClient
/*     */   extends AbstractHttpSession
/*     */   implements JIRASessionPartTwo
/*     */ {
/*     */   private final ConnectionCfg httpConnectionCfg;
/*     */   private boolean login = false;
/*     */   private boolean jira4x = true;
/*     */   
/*     */   public JIRARssClient(ConnectionCfg httpConnectionCfg, HttpSessionCallback callback) throws RemoteApiMalformedUrlException {
/*  70 */     super(httpConnectionCfg, callback);
/*  71 */     this.httpConnectionCfg = httpConnectionCfg;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void adjustHttpHeader(HttpMethod method) {
/*  76 */     if (this.httpConnectionCfg instanceof ServerData && ((ServerData)this.httpConnectionCfg).isUseBasicUser()) {
/*  77 */       method.addRequestHeader(new Header("Authorization", getAuthBasicHeaderValue()));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preprocessResult(Document doc) throws JDOMException, RemoteApiSessionExpiredException {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preprocessMethodResult(HttpMethod method) throws RemoteApiException, ServiceUnavailableException {
/*     */     try {
/*  89 */       if (this.login && method != null && method.getStatusLine() != null) {
/*  90 */         if (method.getStatusCode() == 404) {
/*  91 */           this.jira4x = false;
/*  92 */         } else if (method.getResponseHeader("Content-Type") != null && 
/*  93 */           method.getResponseHeader("Content-Type").getValue().startsWith("application/json")) {
/*     */           
/*  95 */           String json = "";
/*  96 */           if (method instanceof PostMethod) {
/*  97 */             json = new String(((PostMethod)method).getResponseBody(1024));
/*     */           } else {
/*  99 */             json = method.getResponseBodyAsString();
/*     */           } 
/* 101 */           if (json != null && json.contains("\"captchaFailure\":true")) {
/* 102 */             throw new CaptchaRequiredException(null);
/*     */           }
/* 104 */           if (json != null && json.contains("\"loginFailedByPermissions\":true")) {
/* 105 */             throw new JiraServiceUnavailableException("You don't have permission to login");
/*     */           }
/*     */         } 
/*     */       }
/* 109 */     } catch (IOException e) {
/* 110 */       throw new RemoteApiException("Cannot parse method result.", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private String getAuthBasicHeaderValue() {
/* 116 */     UserCfg basicUser = ((ServerData)this.httpConnectionCfg).getBasicUser();
/*     */     
/* 118 */     if (basicUser != null && basicUser.getUsername() != null && basicUser.getPassword() != null) {
/* 119 */       return "Basic " + StringUtil.encode(String.valueOf(basicUser.getUsername()) + ":" + basicUser.getPassword());
/*     */     }
/*     */     
/* 122 */     return "";
/*     */   }
/*     */   
/*     */   private Locale getLocale(Element channel) {
/* 126 */     Locale locale = Locale.US;
/* 127 */     Element language = channel.getChild("language");
/* 128 */     if (language != null) {
/* 129 */       String[] parsedLocale = language.getText().split("-");
/* 130 */       if (parsedLocale != null && parsedLocale.length > 1) {
/* 131 */         locale = new Locale(parsedLocale[0], parsedLocale[1]);
/*     */       }
/*     */     } 
/* 134 */     return locale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<JIRAIssue> getIssues(JiraFilter filter, String sortBy, String sortOrder, int start, int max) throws JIRAException {
/* 142 */     StringBuilder url = 
/* 143 */       new StringBuilder(String.valueOf(getBaseUrl()) + "/sr/jira.issueviews:searchrequest-xml/temp/SearchRequest.xml?");
/*     */     
/* 145 */     url.append(filter.getOldStyleQueryString());
/*     */     
/* 147 */     url.append("&sorter/field=").append(sortBy);
/* 148 */     url.append("&sorter/order=").append(sortOrder);
/* 149 */     url.append("&pager/start=").append(start);
/* 150 */     url.append("&tempMax=").append(max);
/*     */ 
/*     */     
/*     */     try {
/* 154 */       Document doc = retrieveGetResponse(url.toString());
/* 155 */       Element root = doc.getRootElement();
/* 156 */       Element channel = root.getChild("channel");
/*     */       
/* 158 */       if (channel != null && !channel.getChildren("item").isEmpty()) {
/* 159 */         return makeIssues(channel.getChildren("item"), getLocale(channel));
/*     */       }
/* 161 */       return Collections.emptyList();
/* 162 */     } catch (AuthenticationException e) {
/* 163 */       throw new JIRAException("Authentication error", e);
/* 164 */     } catch (IOException e) {
/* 165 */       throw new JIRAException("Connection error: " + e.getMessage(), e);
/* 166 */     } catch (JDOMException e) {
/* 167 */       throw new JIRAException(e.getMessage(), e);
/* 168 */     } catch (RemoteApiSessionExpiredException e) {
/* 169 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAIssue> getIssues(String jql, String sort, String sortOrder, int start, int size) throws JIRAException {
/* 174 */     throw new JIRAException("Not implemented");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<JIRAIssue> getSavedFilterIssues(JIRASavedFilter filter, String sortBy, String sortOrder, int start, int max) throws JIRAException {
/* 231 */     StringBuilder url = new StringBuilder(String.valueOf(getBaseUrl()) + "/sr/jira.issueviews:searchrequest-xml/");
/*     */     
/* 233 */     if (filter.getOldStyleQueryString() != null) {
/* 234 */       url.append(filter.getQueryStringFragment())
/* 235 */         .append("/SearchRequest-")
/* 236 */         .append(filter.getOldStyleQueryString())
/* 237 */         .append(".xml");
/*     */     }
/*     */     
/* 240 */     url.append("?sorter/field=").append(sortBy);
/* 241 */     url.append("&sorter/order=").append(sortOrder);
/* 242 */     url.append("&pager/start=").append(start);
/* 243 */     url.append("&tempMax=").append(max);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 248 */       Document doc = retrieveGetResponse(url.toString());
/* 249 */       Element root = doc.getRootElement();
/* 250 */       Element channel = root.getChild("channel");
/* 251 */       if (channel != null && !channel.getChildren("item").isEmpty()) {
/* 252 */         return makeIssues(channel.getChildren("item"), getLocale(channel));
/*     */       }
/* 254 */       return Collections.emptyList();
/* 255 */     } catch (IOException e) {
/* 256 */       throw new JIRAException(e.getMessage(), e);
/* 257 */     } catch (JDOMException e) {
/* 258 */       throw new JIRAException(e.getMessage(), e);
/* 259 */     } catch (RemoteApiSessionExpiredException e) {
/* 260 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JIRAIssue getIssue(String issueKey) throws JIRAException {
/* 267 */     StringBuffer url = new StringBuffer(String.valueOf(getBaseUrl()) + "/si/jira.issueviews:issue-xml/");
/* 268 */     url.append(issueKey).append('/').append(issueKey).append(".xml");
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 273 */       Document doc = retrieveGetResponse(url.toString());
/* 274 */       Element root = doc.getRootElement();
/* 275 */       Element channel = root.getChild("channel");
/* 276 */       if (channel != null) {
/*     */         
/* 278 */         List<Element> items = channel.getChildren("item");
/* 279 */         if (!items.isEmpty())
/*     */         {
/* 281 */           return makeIssues(items, getLocale(channel)).get(0);
/*     */         }
/*     */       } 
/* 284 */       throw new JIRAException("Cannot parse response from JIRA: " + doc.toString());
/* 285 */     } catch (IOException e) {
/* 286 */       throw new JIRAException(e.getMessage(), e);
/* 287 */     } catch (JDOMException e) {
/* 288 */       throw new JIRAException(e.getMessage(), e);
/* 289 */     } catch (RemoteApiSessionExpiredException e) {
/* 290 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<JIRAIssue> makeIssues(@NotNull List<Element> issueElements, Locale locale) {
/* 295 */     List<JIRAIssue> result = new ArrayList<JIRAIssue>(issueElements.size());
/* 296 */     for (Element issueElement : issueElements) {
/* 297 */       JIRAIssueBean jiraIssue = new JIRAIssueBean(this.httpConnectionCfg.getUrl(), issueElement, locale);
/* 298 */       CachedIconLoader.loadIcon(jiraIssue.getTypeIconUrl());
/* 299 */       CachedIconLoader.loadIcon(jiraIssue.getPriorityIconUrl());
/* 300 */       CachedIconLoader.loadIcon(jiraIssue.getStatusTypeUrl());
/* 301 */       result.add(jiraIssue);
/*     */     } 
/* 303 */     return result;
/*     */   }
/*     */   
/*     */   public void testConnection() throws RemoteApiException {
/*     */     try {
/* 308 */       login();
/* 309 */     } catch (JIRAException e) {
/* 310 */       throw new RemoteApiException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void login() throws JIRAException, JiraCaptchaRequiredException {
/*     */     try {
/* 320 */       this.login = true;
/* 321 */       Map<String, String> loginParams = new HashMap<String, String>();
/* 322 */       loginParams.put("os_username", this.httpConnectionCfg.getUsername());
/* 323 */       loginParams.put("os_password", this.httpConnectionCfg.getPassword());
/* 324 */       loginParams.put("os_destination", "/success");
/*     */       
/* 326 */       if (this.jira4x) {
/* 327 */         retrievePostResponseWithForm(String.valueOf(this.httpConnectionCfg.getUrl()) + "/rest/gadget/1.0/login", loginParams, false);
/*     */       }
/* 329 */       if (!this.jira4x) {
/* 330 */         retrievePostResponseWithForm(String.valueOf(this.httpConnectionCfg.getUrl()) + "/secure/Dashboard.jspa", loginParams, false);
/*     */       }
/*     */     }
/* 333 */     catch (JDOMException e) {
/* 334 */       throw new JIRAException(e.getMessage());
/* 335 */     } catch (CaptchaRequiredException e) {
/* 336 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 337 */     } catch (RemoteApiException e) {
/* 338 */       throw new JIRAException(e.getMessage());
/*     */     } finally {
/* 340 */       this.login = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isLoggedIn(ConnectionCfg server) {
/* 345 */     Cookie[] cookies = this.callback.getCookiesHeaders(server);
/* 346 */     return (cookies != null && cookies.length > 0);
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\rss\JIRARssClient.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */