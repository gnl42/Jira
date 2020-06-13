/*     */ package com.atlassian.theplugin.commons.fisheye.api.rest;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import com.atlassian.theplugin.commons.crucible.api.rest.CrucibleRestXmlHelper;
/*     */ import com.atlassian.theplugin.commons.fisheye.api.FishEyeSession;
/*     */ import com.atlassian.theplugin.commons.fisheye.api.model.FisheyePathHistoryItem;
/*     */ import com.atlassian.theplugin.commons.fisheye.api.model.changeset.Changeset;
/*     */ import com.atlassian.theplugin.commons.fisheye.api.model.changeset.ChangesetIdList;
/*     */ import com.atlassian.theplugin.commons.fisheye.api.model.changeset.FileRevisionKey;
/*     */ import com.atlassian.theplugin.commons.remoteapi.CaptchaRequiredException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginFailedException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiMalformedUrlException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiSessionExpiredException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.AbstractHttpSession;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;
/*     */ import com.atlassian.theplugin.commons.util.LoggerImpl;
/*     */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*     */ import com.atlassian.theplugin.commons.util.UrlUtil;
/*     */ import com.atlassian.theplugin.commons.util.XmlUtil;
/*     */ import java.io.IOException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.httpclient.HttpMethod;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.lang.time.DateFormatUtils;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.JDOMException;
/*     */ import org.jdom.xpath.XPath;
/*     */ import org.joda.time.format.DateTimeFormat;
/*     */ import org.joda.time.format.DateTimeFormatter;
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
/*     */ public class FishEyeRestSession
/*     */   extends AbstractHttpSession
/*     */   implements FishEyeSession
/*     */ {
/*     */   private static final String REST_BASE_URL = "/api/rest/";
/*     */   static final String LOGIN_ACTION = "/api/rest/login";
/*     */   static final String LOGOUT_ACTION = "/api/rest/logout";
/*     */   static final String LIST_REPOSITORIES_ACTION = "/api/rest/repositories";
/*     */   public static final String REVISION_DATA = "/rest-service-fe/revisionData-v1/";
/*     */   public static final String LIST_HISTORY_ACTION = "/rest-service-fe/revisionData-v1/pathHistory/";
/*     */   public static final String CHANGESET_LIST_ACTION = "/rest-service-fe/revisionData-v1/changesetList/";
/*     */   public static final String CHANGESET_ACTION = "/rest-service-fe/revisionData-v1/changeset/";
/*     */   private String authToken;
/*     */   private boolean loggedIn;
/*     */   private static final String EXCEPTION_ENCOUNTERED_WHILE_LOGOUT = "Exception encountered while logout:";
/*     */   private static final String CALLING_METHOD_WITHOUT_CALLING_LOGIN_FIRST = "Calling method without calling login() first";
/*     */   public static final String SERVER_RETURNED_MALFORMED_RESPONSE = "Server returned malformed response";
/*     */   
/*     */   public FishEyeRestSession(ConnectionCfg server, HttpSessionCallback callback) throws RemoteApiMalformedUrlException {
/*  88 */     super(server, callback);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void adjustHttpHeader(HttpMethod method) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preprocessResult(Document doc) throws JDOMException, RemoteApiSessionExpiredException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preprocessMethodResult(HttpMethod method) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void login(String name, char[] aPassword) throws RemoteApiLoginException {
/* 114 */     if (StringUtils.isBlank(name) && (aPassword == null || aPassword.length == 0)) {
/* 115 */       this.loggedIn = true;
/* 116 */       this.authToken = null;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 122 */     if (name == null || aPassword == null) {
/* 123 */       throw new RemoteApiLoginException("Corrupted configuration. Username or Password null");
/*     */     }
/* 125 */     String loginUrl = String.valueOf(getBaseUrl()) + "/api/rest/login" + "?username=" + UrlUtil.encodeUrl(name) + "&password=" + 
/* 126 */       UrlUtil.encodeUrl(String.valueOf(aPassword));
/*     */     
/*     */     try {
/* 129 */       Document doc = retrieveGetResponse(loginUrl);
/* 130 */       String exception = getExceptionMessages(doc);
/* 131 */       if (exception != null) {
/* 132 */         if (exception.contains("maximum")) {
/* 133 */           throw new CaptchaRequiredException(null);
/*     */         }
/* 135 */         throw new RemoteApiLoginFailedException(exception);
/*     */       } 
/*     */ 
/*     */       
/* 139 */       List<Element> elements = XPath.newInstance("/response/string").selectNodes(doc);
/* 140 */       if (elements == null || elements.size() == 0) {
/* 141 */         throw new RemoteApiLoginException("Server did not return any authentication token");
/*     */       }
/* 143 */       if (elements.size() != 1) {
/* 144 */         throw new RemoteApiLoginException("Server returned unexpected number of authentication tokens (" + 
/* 145 */             elements.size() + ")");
/*     */       }
/* 147 */       this.authToken = ((Element)elements.get(0)).getText();
/* 148 */       this.loggedIn = true;
/* 149 */     } catch (MalformedURLException e) {
/* 150 */       throw new RemoteApiLoginException("Malformed server URL: " + getBaseUrl(), e);
/* 151 */     } catch (UnknownHostException e) {
/* 152 */       throw new RemoteApiLoginException("Unknown host: " + e.getMessage(), e);
/* 153 */     } catch (IOException e) {
/* 154 */       throw new RemoteApiLoginException(e.getMessage(), e);
/* 155 */     } catch (JDOMException e) {
/* 156 */       throw new RemoteApiLoginException("Server returned malformed response", e);
/* 157 */     } catch (RemoteApiSessionExpiredException e) {
/* 158 */       throw new RemoteApiLoginException("Session expired", e);
/* 159 */     } catch (IllegalArgumentException e) {
/* 160 */       throw new RemoteApiLoginException("Malformed server URL: " + getBaseUrl(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String getExceptionMessages(Document doc) throws JDOMException {
/* 165 */     if (doc.getRootElement() != null && doc.getRootElement().getName().equals("error")) {
/* 166 */       return doc.getRootElement().getText();
/*     */     }
/*     */     
/* 169 */     return null;
/*     */   }
/*     */   
/*     */   public void logout() {
/* 173 */     if (!isLoggedIn() || this.authToken == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 178 */       String logoutUrl = String.valueOf(getBaseUrl()) + "/api/rest/logout" + "?auth=" + UrlUtil.encodeUrl(this.authToken);
/* 179 */       retrieveGetResponse(logoutUrl);
/* 180 */     } catch (IOException e) {
/* 181 */       LoggerImpl.getInstance().error("Exception encountered while logout:" + e.getMessage(), e);
/* 182 */     } catch (JDOMException e) {
/* 183 */       LoggerImpl.getInstance().error("Exception encountered while logout:" + e.getMessage(), (Throwable)e);
/* 184 */     } catch (RemoteApiSessionExpiredException e) {
/* 185 */       LoggerImpl.getInstance().debug("Exception encountered while logout:" + e.getMessage(), (Throwable)e);
/*     */     } 
/*     */     
/* 188 */     this.authToken = null;
/* 189 */     this.loggedIn = false;
/*     */   }
/*     */   
/*     */   public boolean isLoggedIn() {
/* 193 */     return this.loggedIn;
/*     */   }
/*     */   
/*     */   public List<String> getRepositories() throws RemoteApiException {
/* 197 */     if (!isLoggedIn()) {
/* 198 */       throw new IllegalStateException("Calling method without calling login() first");
/*     */     }
/*     */     
/* 201 */     String requestUrl = String.valueOf(getBaseUrl()) + "/api/rest/repositories";
/*     */     try {
/* 203 */       Document doc = retrieveGetResponse(requestUrl);
/*     */       
/* 205 */       XPath xpath = XPath.newInstance("/response/string");
/*     */       
/* 207 */       List<Element> elements = xpath.selectNodes(doc);
/* 208 */       List<String> myRepositories = new ArrayList<String>();
/*     */       
/* 210 */       if (elements != null && !elements.isEmpty()) {
/* 211 */         for (Element element : elements) {
/* 212 */           myRepositories.add(element.getText());
/*     */         }
/*     */       }
/* 215 */       return myRepositories;
/* 216 */     } catch (IOException e) {
/* 217 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 218 */     } catch (JDOMException e) {
/* 219 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + "Server returned malformed response", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<FisheyePathHistoryItem> getPathHistory(String repo, String path) throws RemoteApiException {
/* 225 */     if (!isLoggedIn()) {
/* 226 */       throw new IllegalStateException("Calling method without calling login() first");
/*     */     }
/*     */     
/* 229 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service-fe/revisionData-v1/pathHistory/" + repo + "?path=" + UrlUtil.encodeUrl(path);
/*     */     try {
/* 231 */       Document doc = retrieveGetResponse(requestUrl);
/*     */       
/* 233 */       XPath xpath = XPath.newInstance("/fileRevisionList");
/*     */       
/* 235 */       List<Element> elements = xpath.selectNodes(doc);
/* 236 */       if (elements == null || elements.size() != 1)
/*     */       {
/* 238 */         throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + "Server returned malformed response");
/*     */       }
/* 240 */       xpath = XPath.newInstance("/fileRevisionList/fileRevision");
/*     */       
/* 242 */       elements = xpath.selectNodes(doc);
/* 243 */       List<FisheyePathHistoryItem> list = new ArrayList<FisheyePathHistoryItem>();
/*     */       
/* 245 */       if (elements != null && !elements.isEmpty()) {
/* 246 */         for (Element element : elements) {
/* 247 */           list.add(new FisheyePathHistoryItem(element));
/*     */         }
/*     */       }
/* 250 */       return list;
/* 251 */     } catch (IOException e) {
/* 252 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 253 */     } catch (JDOMException e) {
/* 254 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + "Server returned malformed response", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ChangesetIdList getChangesetList(String repository, String path, Date start, Date end, Integer maxReturn) throws RemoteApiException {
/* 261 */     if (!isLoggedIn()) {
/* 262 */       throw new IllegalStateException("Calling method without calling login() first");
/*     */     }
/*     */     
/* 265 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service-fe/revisionData-v1/changesetList/" + repository + "?";
/* 266 */     if (path != null) {
/* 267 */       requestUrl = String.valueOf(requestUrl) + "path=" + path + "&";
/*     */     }
/* 269 */     if (start != null) {
/* 270 */       requestUrl = String.valueOf(requestUrl) + "start=" + DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(start) + "&";
/*     */     }
/* 272 */     if (end != null) {
/* 273 */       requestUrl = String.valueOf(requestUrl) + "end=" + DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(end) + "&";
/*     */     }
/* 275 */     if (maxReturn != null) {
/* 276 */       requestUrl = String.valueOf(requestUrl) + "maxReturn=" + maxReturn + "&";
/*     */     }
/*     */     
/*     */     try {
/* 280 */       Document doc = retrieveGetResponse(requestUrl);
/*     */       
/* 282 */       XPath xpath = XPath.newInstance("/changesetIdList");
/* 283 */       List<Element> elements = xpath.selectNodes(doc);
/* 284 */       if (elements == null || elements.size() != 1)
/*     */       {
/* 286 */         throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + "Server returned malformed response");
/*     */       }
/* 288 */       xpath = XPath.newInstance("/changesetIdList/csid");
/* 289 */       elements = xpath.selectNodes(doc);
/*     */       
/* 291 */       List<String> list = MiscUtil.buildArrayList();
/*     */       
/* 293 */       if (elements != null && !elements.isEmpty()) {
/* 294 */         for (Element element : elements) {
/* 295 */           list.add(element.getTextNormalize());
/*     */         }
/*     */       }
/* 298 */       return new ChangesetIdList(list);
/* 299 */     } catch (IOException e) {
/* 300 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 301 */     } catch (JDOMException e) {
/* 302 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + "Server returned malformed response", e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Changeset getChangeset(String repository, String csid) throws RemoteApiException {
/* 307 */     if (!isLoggedIn()) {
/* 308 */       throw new IllegalStateException("Calling method without calling login() first");
/*     */     }
/*     */     
/* 311 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service-fe/revisionData-v1/changeset/" + repository + "/" + csid;
/*     */     
/*     */     try {
/* 314 */       Document doc = retrieveGetResponse(requestUrl);
/*     */       
/* 316 */       XPath xpath = XPath.newInstance("/changeset");
/* 317 */       Element changesetElement = (Element)xpath.selectSingleNode(doc);
/* 318 */       if (changesetElement == null)
/*     */       {
/* 320 */         throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + "Server returned malformed response");
/*     */       }
/* 322 */       return parseChangeset(changesetElement);
/* 323 */     } catch (IOException e) {
/* 324 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 325 */     } catch (JDOMException e) {
/* 326 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + "Server returned malformed response", e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private Changeset parseChangeset(Element changesetElement) {
/* 331 */     String csid = changesetElement.getAttributeValue("csid");
/* 332 */     String author = changesetElement.getAttributeValue("author");
/* 333 */     String comment = CrucibleRestXmlHelper.getChildText(changesetElement, "comment");
/* 334 */     Date date = parseDateTime(changesetElement.getAttributeValue("date"));
/* 335 */     String branch = changesetElement.getAttributeValue("branch");
/* 336 */     List<FileRevisionKey> keys = MiscUtil.buildArrayList();
/*     */     
/* 338 */     for (Element element : XmlUtil.getChildElements(changesetElement, "fileRevisionKey")) {
/* 339 */       keys.add(parseFileRevisionKey(element));
/*     */     }
/*     */     
/* 342 */     return new Changeset(date, csid, branch, author, comment, keys);
/*     */   }
/*     */   
/*     */   private FileRevisionKey parseFileRevisionKey(Element element) {
/* 346 */     return new FileRevisionKey(element.getAttributeValue("rev"), element.getAttributeValue("path"));
/*     */   }
/*     */   
/* 349 */   private static final DateTimeFormatter CHANGESET_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
/*     */   
/* 351 */   private static final DateTimeFormatter CHANGESET1_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
/*     */   
/*     */   public static Date parseDateTime(String date) {
/* 354 */     if (date != null && !date.equals("")) {
/*     */       try {
/* 356 */         return CHANGESET_TIME_FORMAT.parseDateTime(date).toDate();
/* 357 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 358 */         return CHANGESET1_TIME_FORMAT.parseDateTime(date).toDate();
/*     */       } 
/*     */     }
/* 361 */     return null;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\fisheye\api\rest\FishEyeRestSession.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */