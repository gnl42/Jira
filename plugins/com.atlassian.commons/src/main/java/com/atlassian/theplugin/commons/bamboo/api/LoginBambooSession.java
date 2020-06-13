/*     */ package com.atlassian.theplugin.commons.bamboo.api;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import com.atlassian.theplugin.commons.exception.HttpProxySettingsException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.CaptchaRequiredException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.ProductSession;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginFailedException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiMalformedUrlException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiSessionExpiredException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.AbstractHttpSession;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.List;
/*     */ import org.apache.commons.httpclient.HttpMethod;
/*     */ import org.apache.commons.httpclient.methods.PostMethod;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.JDOMException;
/*     */ import org.jdom.xpath.XPath;
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
/*     */ public class LoginBambooSession
/*     */   extends AbstractHttpSession
/*     */   implements ProductSession
/*     */ {
/*     */   protected String authToken;
/*     */   private static final String AUTHENTICATION_ERROR_MESSAGE = "User not authenticated yet, or session timed out";
/*     */   private static final String LOGIN_ACTION = "/api/rest/login.action";
/*     */   private static final String LOGOUT_ACTION = "/api/rest/logout.action";
/*     */   
/*     */   public LoginBambooSession(ConnectionCfg serverData, HttpSessionCallback callback) throws RemoteApiMalformedUrlException {
/*  56 */     super(serverData, callback);
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
/*     */   public void login(final String name, char[] aPassword) throws RemoteApiLoginException {
/*  77 */     String host = null;
/*     */     
/*  79 */     if (name == null || aPassword == null) {
/*  80 */       throw new RemoteApiLoginException("Corrupted configuration. Username or Password null");
/*     */     }
/*  82 */     final String pass = String.valueOf(aPassword);
/*     */     
/*  84 */     String loginUrl = String.valueOf(getBaseUrl()) + "/api/rest/login.action";
/*     */     
/*     */     try {
/*     */       try {
/*  88 */         host = (new URL(getBaseUrl())).getHost();
/*  89 */       } catch (MalformedURLException e) {
/*  90 */         throw new RemoteApiException(e.getMessage(), e);
/*     */       } 
/*     */       
/*  93 */       this.callback.getHttpClient(getServer()).getState().clearCookies();
/*  94 */       Document doc = retrievePostResponseInternalImpl(loginUrl, new AbstractHttpSession.PostMethodPreparer() {
/*     */             public void prepare(PostMethod login) throws UnsupportedEncodingException {
/*  96 */               login.addRequestHeader("Accept", "application/xml;q=0.9,*/*");
/*  97 */               login.addParameter("os_username", name);
/*  98 */               login.addParameter("os_password", pass);
/*  99 */               login.addParameter("username", name);
/* 100 */               login.addParameter("password", pass);
/*     */             }
/* 102 */           }true, 0, null);
/*     */       
/* 104 */       String exception = getExceptionMessages(doc);
/* 105 */       if (exception != null) {
/* 106 */         throw new RemoteApiLoginFailedException(exception);
/*     */       }
/*     */ 
/*     */       
/* 110 */       List<Element> elements = XPath.newInstance("/response/auth").selectNodes(doc);
/* 111 */       if (elements == null || elements.size() == 0) {
/* 112 */         throw new RemoteApiLoginException("Server did not return any authentication token");
/*     */       }
/* 114 */       if (elements.size() != 1) {
/* 115 */         throw new RemoteApiLoginException("Server returned unexpected number of authentication tokens (" + 
/* 116 */             elements.size() + ")");
/*     */       }
/* 118 */       this.authToken = ((Element)elements.get(0)).getText();
/* 119 */     } catch (RemoteApiLoginFailedException e) {
/* 120 */       throw e;
/* 121 */     } catch (RemoteApiException e) {
/* 122 */       if (e.getCause() != null && e.getCause().getMessage().contains("maximum"))
/* 123 */         throw new CaptchaRequiredException(e); 
/* 124 */       if (e.getCause() instanceof java.net.UnknownHostException)
/* 125 */         throw new RemoteApiLoginException("Unknown host: " + host, e); 
/* 126 */       if (e.getCause() instanceof MalformedURLException) {
/* 127 */         throw new RemoteApiLoginException("Malformed server URL: " + getBaseUrl(), e);
/*     */       }
/*     */       
/* 130 */       throw new RemoteApiLoginException(e.getMessage(), e);
/* 131 */     } catch (JDOMException e) {
/* 132 */       throw new RemoteApiLoginException("Server returned malformed response", e);
/* 133 */     } catch (IllegalArgumentException e) {
/* 134 */       throw new RemoteApiLoginException("Malformed server URL: " + getBaseUrl(), e);
/* 135 */     } catch (HttpProxySettingsException e) {
/* 136 */       throw new RemoteApiLoginException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void logout() {
/* 147 */     if (!isLoggedIn()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 152 */       String logoutUrl = String.valueOf(getBaseUrl()) + "/api/rest/logout.action" + "?auth=" + URLEncoder.encode(this.authToken, "UTF-8");
/* 153 */       retrieveGetResponse(logoutUrl);
/* 154 */     } catch (UnsupportedEncodingException e) {
/* 155 */       throw new RuntimeException("URLEncoding problem", e);
/* 156 */     } catch (IOException iOException) {
/*     */     
/* 158 */     } catch (JDOMException jDOMException) {
/*     */     
/* 160 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {}
/*     */ 
/*     */ 
/*     */     
/* 164 */     this.authToken = null;
/*     */   }
/*     */   
/*     */   public boolean isLoggedIn() {
/* 168 */     return (this.authToken != null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void preprocessResult(Document doc) throws JDOMException, RemoteApiSessionExpiredException {
/* 173 */     String error = getExceptionMessages(doc);
/* 174 */     if (error != null && 
/* 175 */       error.startsWith("User not authenticated yet, or session timed out")) {
/* 176 */       throw new RemoteApiSessionExpiredException("Session expired.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preprocessMethodResult(HttpMethod method) {}
/*     */ 
/*     */   
/*     */   protected static String getExceptionMessages(Document doc) throws JDOMException {
/* 186 */     XPath xpath = XPath.newInstance("/errors/error");
/*     */     
/* 188 */     List<Element> elements = xpath.selectNodes(doc);
/*     */     
/* 190 */     if (elements != null && elements.size() > 0) {
/* 191 */       StringBuffer exceptionMsg = new StringBuffer();
/* 192 */       for (Element e : elements) {
/* 193 */         exceptionMsg.append(e.getText());
/* 194 */         exceptionMsg.append("\n");
/*     */       } 
/* 196 */       return exceptionMsg.toString();
/*     */     } 
/*     */     
/* 199 */     return null;
/*     */   }
/*     */   
/*     */   protected void adjustHttpHeader(HttpMethod method) {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\api\LoginBambooSession.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */