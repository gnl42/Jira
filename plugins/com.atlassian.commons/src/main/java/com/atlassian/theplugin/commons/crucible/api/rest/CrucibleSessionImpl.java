/*      */ package com.atlassian.theplugin.commons.crucible.api.rest;
/*      */ 
/*      */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*      */ import com.atlassian.theplugin.commons.VersionedVirtualFile;
/*      */ import com.atlassian.theplugin.commons.crucible.api.CrucibleSession;
/*      */ import com.atlassian.theplugin.commons.crucible.api.PathAndRevision;
/*      */ import com.atlassian.theplugin.commons.crucible.api.UploadItem;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.BasicProject;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.BasicReview;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.Comment;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CrucibleAction;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CrucibleFileInfo;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CrucibleVersionInfo;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CustomFieldDef;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CustomFilter;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.ExtendedCrucibleProject;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.GeneralComment;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.NewReviewItem;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.PatchAnchorData;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.PermId;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.PredefinedFilter;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.Repository;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.Reviewer;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.RevisionData;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.State;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.SvnRepository;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.User;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.VersionedComment;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.changes.Changes;
/*      */ import com.atlassian.theplugin.commons.exception.IncorrectVersionException;
/*      */ import com.atlassian.theplugin.commons.remoteapi.CaptchaRequiredException;
/*      */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*      */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginException;
/*      */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginFailedException;
/*      */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiMalformedUrlException;
/*      */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiSessionExpiredException;
/*      */ import com.atlassian.theplugin.commons.remoteapi.rest.AbstractHttpSession;
/*      */ import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;
/*      */ import com.atlassian.theplugin.commons.util.Logger;
/*      */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*      */ import com.atlassian.theplugin.commons.util.ProductVersionUtil;
/*      */ import com.atlassian.theplugin.commons.util.StringUtil;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.net.MalformedURLException;
/*      */ import java.net.URLEncoder;
/*      */ import java.net.UnknownHostException;
/*      */ import java.text.ParseException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.httpclient.Header;
/*      */ import org.apache.commons.httpclient.HttpMethod;
/*      */ import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
/*      */ import org.apache.commons.httpclient.methods.multipart.FilePart;
/*      */ import org.apache.commons.httpclient.methods.multipart.Part;
/*      */ import org.apache.commons.httpclient.methods.multipart.PartSource;
/*      */ import org.apache.commons.lang.StringUtils;
/*      */ import org.jdom.Document;
/*      */ import org.jdom.Element;
/*      */ import org.jdom.JDOMException;
/*      */ import org.jdom.xpath.XPath;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class CrucibleSessionImpl
/*      */   extends AbstractHttpSession
/*      */   implements CrucibleSession
/*      */ {
/*   95 */   private static final CrucibleVersionInfo MIN_VERSION_SUPPORTING_POST_LOGIN = new CrucibleVersionInfo("2.4", null);
/*      */   
/*      */   private static final String AUTH_SERVICE = "/rest-service/auth-v1";
/*      */   
/*      */   private static final String REVIEW_SERVICE = "/rest-service/reviews-v1";
/*      */   
/*      */   private static final String PROJECTS_SERVICE = "/rest-service/projects-v1";
/*      */   
/*      */   private static final String REPOSITORIES_SERVICE = "/rest-service/repositories-v1";
/*      */   
/*      */   private static final String SEARCH_SERVICE = "/rest-service/search-v1";
/*      */   
/*      */   private static final String USER_SERVICE = "/rest-service/users-v1";
/*      */   
/*      */   private static final String LOGIN = "/login";
/*      */   
/*      */   private static final String REVIEWS_IN_STATES = "?state=";
/*      */   
/*      */   private static final String FILTERED_REVIEWS = "/filter";
/*      */   
/*      */   private static final String SEARCH_REVIEWS = "/search";
/*      */   
/*      */   private static final String SEARCH_REVIEWS_QUERY = "?path=";
/*      */   
/*      */   private static final String DETAIL_REVIEW_INFO = "/details";
/*      */   
/*      */   private static final String ACTIONS = "/actions";
/*      */   
/*      */   private static final String TRANSITIONS = "/transitions";
/*      */   
/*      */   private static final String REVIEWERS = "/reviewers";
/*      */   
/*      */   private static final String REVIEW_ITEMS = "/reviewitems";
/*      */   
/*      */   private static final String REVISIONS = "/revisions";
/*      */   
/*      */   private static final String METRICS = "/metrics";
/*      */   
/*      */   private static final String VERSION = "/versionInfo";
/*      */   
/*      */   private static final String COMMENTS = "/comments";
/*      */   
/*      */   private static final String GENERAL_COMMENTS = "/comments/general";
/*      */   
/*      */   private static final String VERSIONED_COMMENTS = "/comments/versioned";
/*      */   
/*      */   private static final String REPLIES = "/replies";
/*      */   
/*      */   private static final String APPROVE_ACTION = "action:approveReview";
/*      */   
/*      */   private static final String SUBMIT_ACTION = "action:submitReview";
/*      */   
/*      */   private static final String SUMMARIZE_ACTION = "action:summarizeReview";
/*      */   
/*      */   private static final String ABANDON_ACTION = "action:abandonReview";
/*      */   
/*      */   private static final String CLOSE_ACTION = "action:closeReview";
/*      */   
/*      */   private static final String RECOVER_ACTION = "action:recoverReview";
/*      */   
/*      */   private static final String REOPEN_ACTION = "action:reopenReview";
/*      */   
/*      */   private static final String REJECT_ACTION = "action:rejectReview";
/*      */   
/*      */   private static final String TRANSITION_ACTION = "/transition?action=";
/*      */   
/*      */   private static final String PUBLISH_COMMENTS = "/publish";
/*      */   
/*      */   private static final String COMPLETE_ACTION = "/complete";
/*      */   
/*      */   private static final String UNCOMPLETE_ACTION = "/uncomplete";
/*      */   
/*      */   private static final String ADD_CHANGESET = "/addChangeset";
/*      */   
/*      */   private static final String ADD_REVISIONS = "/reviewitems/revisions";
/*      */   
/*      */   private static final String ADD_PATCH = "/addPatch";
/*      */   
/*      */   private static final String ADD_FILE = "/addFile";
/*      */   
/*      */   private static final String MARK_READ = "/markAsRead";
/*      */   
/*      */   private static final String MARK_LEAVE_UNREAD = "/markAsLeaveUnread";
/*      */   
/*      */   private static final String MARK_ALL_READ = "/markAllAsRead";
/*      */   
/*      */   private static final String PROJECT_EXPAND_ALLOWED_REVIEWERS = "?expand=allowedReviewers";
/*      */   
/*      */   private static final String CHANGES = "/changes/";
/*      */   
/*      */   private static final String REVIEWS_FOR_ISSUE = "/reviewsForIssue";
/*      */   
/*      */   private String authToken;
/*      */   
/*  189 */   private final Map<String, Repository> repositories = new HashMap<String, Repository>();
/*      */   
/*  191 */   private final Map<String, List<CustomFieldDef>> metricsDefinitions = new HashMap<String, List<CustomFieldDef>>();
/*      */ 
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   private volatile CrucibleVersionInfo crucibleVersionInfo;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean loginCalled = false;
/*      */ 
/*      */ 
/*      */   
/*      */   private final Logger logger;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CrucibleSessionImpl(ConnectionCfg serverData, HttpSessionCallback callback, Logger logger) throws RemoteApiMalformedUrlException {
/*  210 */     super(serverData, callback);
/*  211 */     this.logger = logger;
/*      */   }
/*      */   
/*      */   public void login() throws RemoteApiLoginException {
/*  215 */     this.loginCalled = true;
/*      */   }
/*      */   
/*      */   public void login(String name, char[] aPassword) throws RemoteApiLoginException {
/*  219 */     login();
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean isPostLoginSupported() throws RemoteApiException {
/*  224 */     CrucibleVersionInfo cvi = getCrucibleVersionInfo();
/*  225 */     return (cvi.compareTo(MIN_VERSION_SUPPORTING_POST_LOGIN) >= 0);
/*      */   }
/*      */ 
/*      */   
/*      */   private void realLogin() throws RemoteApiLoginException {
/*      */     try {
/*  231 */       Document doc = retrieveLoginResponse();
/*  232 */       String exception = getExceptionMessages(doc);
/*  233 */       if (exception != null) {
/*  234 */         throw new RemoteApiLoginFailedException(exception);
/*      */       }
/*  236 */       XPath xpath = XPath.newInstance("/loginResult/token");
/*  237 */       List<?> elements = xpath.selectNodes(doc);
/*  238 */       if (elements == null) {
/*  239 */         throw new RemoteApiLoginException("Server did not return any authentication token");
/*      */       }
/*  241 */       if (elements.size() != 1) {
/*  242 */         throw new RemoteApiLoginException("Server returned unexpected number of authentication tokens (" + 
/*  243 */             elements.size() + ")");
/*      */       }
/*  245 */       this.authToken = ((Element)elements.get(0)).getText();
/*  246 */     } catch (MalformedURLException e) {
/*  247 */       throw new RemoteApiLoginException("Malformed server URL: " + getBaseUrl(), e);
/*  248 */     } catch (UnknownHostException e) {
/*  249 */       throw new RemoteApiLoginException("Unknown host: " + e.getMessage(), e);
/*  250 */     } catch (IOException e) {
/*  251 */       if (e.getCause() != null && e.getCause().getMessage().contains("maximum")) {
/*  252 */         throw new CaptchaRequiredException(e);
/*      */       }
/*  254 */       throw new RemoteApiLoginException(String.valueOf(getBaseUrl()) + ":" + e.getMessage(), e);
/*  255 */     } catch (JDOMException e) {
/*  256 */       throw new RemoteApiLoginException("Server:" + getBaseUrl() + " returned malformed response", e);
/*  257 */     } catch (RemoteApiSessionExpiredException e) {
/*  258 */       throw new RemoteApiLoginException("Remote session expired on server:" + getBaseUrl(), e);
/*  259 */     } catch (IllegalArgumentException e) {
/*  260 */       throw new RemoteApiLoginException("Malformed server URL: " + getBaseUrl(), e);
/*  261 */     } catch (RemoteApiLoginException e) {
/*  262 */       throw e;
/*  263 */     } catch (RemoteApiException e) {
/*  264 */       throw new RemoteApiLoginException(e.getMessage(), e);
/*      */     } 
/*      */   }
/*      */   
/*      */   private Document retrieveLoginResponse() throws IOException, JDOMException, RemoteApiException {
/*  269 */     String loginUrl, username = getUsername();
/*  270 */     String password = getPassword();
/*  271 */     if (username == null || password == null) {
/*  272 */       throw new RemoteApiLoginException("Corrupted configuration. Username or Password null");
/*      */     }
/*  274 */     String loginUrlPrefix = String.valueOf(getBaseUrl()) + "/rest-service/auth-v1" + "/login";
/*      */     
/*  276 */     if (isPostLoginSupported()) {
/*  277 */       Map<String, String> form = MiscUtil.buildHashMap();
/*  278 */       form.put("userName", username);
/*  279 */       form.put("password", password);
/*  280 */       return retrievePostResponseWithForm(loginUrlPrefix, form, true);
/*      */     } 
/*      */     
/*      */     try {
/*  284 */       loginUrl = String.valueOf(loginUrlPrefix) + "?userName=" + URLEncoder.encode(username, "UTF-8") + "&password=" + 
/*  285 */         URLEncoder.encode(password, "UTF-8");
/*  286 */     } catch (UnsupportedEncodingException e) {
/*      */       
/*  288 */       throw new RuntimeException("URLEncoding problem: " + e.getMessage());
/*      */     } 
/*      */     
/*  291 */     return retrieveGetResponse(loginUrl);
/*      */   }
/*      */ 
/*      */   
/*      */   public void logout() {
/*  296 */     this.loginCalled = false;
/*  297 */     if (this.authToken != null) {
/*  298 */       this.authToken = null;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public CrucibleVersionInfo getServerVersion() throws RemoteApiException {
/*  304 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/versionInfo";
/*      */     try {
/*  306 */       Document doc = retrieveGetResponse(requestUrl);
/*      */       
/*  308 */       XPath xpath = XPath.newInstance("versionInfo");
/*      */       
/*  310 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/*  312 */       if (elements != null && !elements.isEmpty()) {
/*  313 */         Iterator<Element> iterator = elements.iterator(); if (iterator.hasNext()) { Element element = iterator.next();
/*  314 */           this.crucibleVersionInfo = CrucibleRestXmlHelper.parseVersionNode(element);
/*  315 */           return this.crucibleVersionInfo; }
/*      */       
/*      */       } 
/*      */       
/*  319 */       throw new RemoteApiException("No version info found in server response");
/*  320 */     } catch (UnknownHostException e) {
/*  321 */       throw new RemoteApiException("Unknown host: " + e.getMessage(), e);
/*  322 */     } catch (IOException e) {
/*  323 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  324 */     } catch (JDOMException e) {
/*  325 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  328 */       return null;
/*      */     } 
/*      */   }
/*      */   private void updateMetricsMetadata(BasicReview review) {
/*      */     try {
/*  333 */       getMetrics(review.getMetricsVersion());
/*  334 */     } catch (RemoteApiException remoteApiException) {}
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<BasicReview> getReviewsInStates(List<State> states) throws RemoteApiException {
/*  340 */     if (!isLoggedIn()) {
/*  341 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*  344 */     StringBuilder sb = new StringBuilder();
/*  345 */     sb.append(getBaseUrl());
/*  346 */     sb.append("/rest-service/reviews-v1");
/*  347 */     sb.append("/details");
/*  348 */     if (states != null && states.size() != 0) {
/*  349 */       sb.append("?state=");
/*  350 */       for (Iterator<State> stateIterator = states.iterator(); stateIterator.hasNext(); ) {
/*  351 */         State state = stateIterator.next();
/*  352 */         sb.append(state.value());
/*  353 */         if (stateIterator.hasNext()) {
/*  354 */           sb.append(",");
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*      */     try {
/*  360 */       Document doc = retrieveGetResponse(sb.toString());
/*      */       
/*  362 */       XPath xpath = XPath.newInstance("/detailedReviews/detailedReviewData");
/*      */ 
/*      */       
/*  365 */       List<Element> elements = xpath.selectNodes(doc);
/*  366 */       List<BasicReview> reviews = new ArrayList<BasicReview>();
/*      */       
/*  368 */       if (elements != null && !elements.isEmpty()) {
/*  369 */         for (Element element : elements) {
/*  370 */           reviews.add(parseBasicReview(element));
/*      */         }
/*      */       }
/*  373 */       for (BasicReview review : reviews) {
/*  374 */         updateMetricsMetadata(review);
/*      */       }
/*  376 */       return reviews;
/*  377 */     } catch (IOException e) {
/*  378 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  379 */     } catch (JDOMException e) {
/*  380 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  383 */       return null;
/*      */     } 
/*      */   }
/*      */   public List<BasicReview> getAllReviews() throws RemoteApiException {
/*  387 */     return getReviewsInStates((List<State>)null);
/*      */   }
/*      */   
/*      */   public List<BasicReview> getReviewsForFilter(PredefinedFilter filter) throws RemoteApiException {
/*  391 */     if (!isLoggedIn()) {
/*  392 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*      */     try {
/*  396 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/filter" + "/" + filter.getFilterUrl() + 
/*  397 */         "/details";
/*  398 */       Document doc = retrieveGetResponse(url);
/*      */       
/*  400 */       XPath xpath = XPath.newInstance("/detailedReviews/detailedReviewData");
/*      */ 
/*      */       
/*  403 */       List<Element> elements = xpath.selectNodes(doc);
/*  404 */       List<BasicReview> reviews = new ArrayList<BasicReview>();
/*      */       
/*  406 */       if (elements != null && !elements.isEmpty()) {
/*  407 */         for (Element element : elements) {
/*  408 */           reviews.add(parseBasicReview(element));
/*      */         }
/*      */       }
/*  411 */       for (BasicReview review : reviews) {
/*  412 */         updateMetricsMetadata(review);
/*      */       }
/*  414 */       return reviews;
/*  415 */     } catch (IOException e) {
/*  416 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  417 */     } catch (JDOMException e) {
/*  418 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  421 */       return null;
/*      */     } 
/*      */   }
/*      */   private boolean checkCustomFiltersAsGet() {
/*  425 */     if (this.crucibleVersionInfo == null) {
/*      */       try {
/*  427 */         getServerVersion();
/*  428 */       } catch (RemoteApiException remoteApiException) {
/*  429 */         return false;
/*      */       } 
/*      */     }
/*      */     try {
/*  433 */       ProductVersionUtil version = new ProductVersionUtil(this.crucibleVersionInfo.getReleaseNumber());
/*  434 */       if (version.greater(new ProductVersionUtil("1.6.3"))) {
/*  435 */         return true;
/*      */       }
/*  437 */     } catch (IncorrectVersionException incorrectVersionException) {
/*  438 */       return false;
/*      */     } 
/*  440 */     return false;
/*      */   }
/*      */   
/*      */   public CrucibleVersionInfo getCrucibleVersionInfo() throws RemoteApiException {
/*  444 */     if (this.crucibleVersionInfo != null) {
/*  445 */       return this.crucibleVersionInfo;
/*      */     }
/*  447 */     return getServerVersion();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean checkContentUrlAvailable() {
/*  452 */     if (this.crucibleVersionInfo == null) {
/*      */       try {
/*  454 */         getServerVersion();
/*  455 */       } catch (RemoteApiException remoteApiException) {
/*  456 */         return false;
/*      */       } 
/*      */     }
/*      */     try {
/*  460 */       ProductVersionUtil version = new ProductVersionUtil(this.crucibleVersionInfo.getReleaseNumber());
/*  461 */       if (version.greater(new ProductVersionUtil("1.6.6.0"))) {
/*  462 */         return true;
/*      */       }
/*  464 */     } catch (IncorrectVersionException incorrectVersionException) {
/*  465 */       return false;
/*      */     } 
/*  467 */     return false;
/*      */   }
/*      */   
/*      */   public boolean shouldTrimWikiMarkers() {
/*  471 */     if (this.crucibleVersionInfo == null) {
/*      */       try {
/*  473 */         getServerVersion();
/*  474 */       } catch (RemoteApiException remoteApiException) {
/*  475 */         return false;
/*      */       } 
/*      */     }
/*      */     try {
/*  479 */       ProductVersionUtil version = new ProductVersionUtil(this.crucibleVersionInfo.getReleaseNumber());
/*  480 */       if (version.greater(new ProductVersionUtil("2.1"))) {
/*  481 */         return true;
/*      */       }
/*  483 */     } catch (IncorrectVersionException incorrectVersionException) {
/*  484 */       return false;
/*      */     } 
/*  486 */     return false;
/*      */   }
/*      */   
/*      */   public List<BasicReview> getReviewsForCustomFilter(CustomFilter filter) throws RemoteApiException {
/*  490 */     if (!isLoggedIn()) {
/*  491 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*      */     try {
/*      */       Document doc;
/*  496 */       if (checkCustomFiltersAsGet()) {
/*  497 */         doc = getReviewsForCustomFilterAsGet(filter);
/*      */       } else {
/*  499 */         doc = getReviewsForCustomFilterAsPost(filter);
/*      */       } 
/*      */       
/*  502 */       XPath xpath = XPath.newInstance("/detailedReviews/detailedReviewData");
/*      */ 
/*      */       
/*  505 */       List<Element> elements = xpath.selectNodes(doc);
/*  506 */       List<BasicReview> reviews = new ArrayList<BasicReview>();
/*      */       
/*  508 */       if (elements != null && !elements.isEmpty()) {
/*  509 */         for (Element element : elements) {
/*  510 */           reviews.add(parseBasicReview(element));
/*      */         }
/*      */       }
/*  513 */       for (BasicReview review : reviews) {
/*  514 */         updateMetricsMetadata(review);
/*      */       }
/*  516 */       return reviews;
/*  517 */     } catch (JDOMException e) {
/*  518 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  521 */       return null;
/*      */     } 
/*      */   }
/*      */   private Document getReviewsForCustomFilterAsPost(CustomFilter filter) throws RemoteApiException {
/*  525 */     Document request = CrucibleRestXmlHelper.prepareCustomFilter(filter);
/*      */     try {
/*  527 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/filter" + "/details";
/*  528 */       return retrievePostResponse(url, request);
/*  529 */     } catch (IOException e) {
/*  530 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  531 */     } catch (JDOMException e) {
/*  532 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  535 */       return null;
/*      */     } 
/*      */   }
/*      */   private Document getReviewsForCustomFilterAsGet(CustomFilter filter) throws RemoteApiException {
/*      */     try {
/*  540 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/filter" + "/details";
/*  541 */       String urlFilter = filter.getFilterUrl();
/*  542 */       if (!StringUtils.isEmpty(urlFilter)) {
/*  543 */         url = String.valueOf(url) + "?" + urlFilter;
/*      */       }
/*      */       
/*  546 */       return retrieveGetResponse(url);
/*  547 */     } catch (IOException e) {
/*  548 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  549 */     } catch (JDOMException e) {
/*  550 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  553 */       return null;
/*      */     } 
/*      */   }
/*      */   public List<BasicReview> getAllReviewsForFile(String repoName, String path) throws RemoteApiException {
/*  557 */     if (!isLoggedIn()) {
/*  558 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*      */     try {
/*  562 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/search" + "/" + URLEncoder.encode(repoName, "UTF-8") + 
/*  563 */         "/details" + "?path=" + URLEncoder.encode(path, "UTF-8");
/*  564 */       Document doc = retrieveGetResponse(url);
/*      */       
/*  566 */       XPath xpath = XPath.newInstance("/detailedReviews/detailedReviewData");
/*      */ 
/*      */       
/*  569 */       List<Element> elements = xpath.selectNodes(doc);
/*  570 */       List<BasicReview> reviews = new ArrayList<BasicReview>();
/*      */       
/*  572 */       if (elements != null && !elements.isEmpty()) {
/*  573 */         for (Element element : elements) {
/*  574 */           reviews.add(parseBasicReview(element));
/*      */         }
/*      */       }
/*  577 */       for (BasicReview review : reviews) {
/*  578 */         updateMetricsMetadata(review);
/*      */       }
/*  580 */       return reviews;
/*  581 */     } catch (IOException e) {
/*  582 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  583 */     } catch (JDOMException e) {
/*  584 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  587 */       return null;
/*      */     } 
/*      */   }
/*      */   public Review getReview(PermId permId) throws RemoteApiException {
/*  591 */     if (!isLoggedIn()) {
/*  592 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*      */     try {
/*  596 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/details";
/*  597 */       Document doc = retrieveGetResponse(url);
/*      */       
/*  599 */       XPath xpath = XPath.newInstance("/detailedReviewData");
/*      */ 
/*      */       
/*  602 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/*  604 */       if (elements != null && !elements.isEmpty()) {
/*  605 */         Iterator<Element> iterator = elements.iterator(); if (iterator.hasNext()) { Element element = iterator.next();
/*  606 */           return prepareFullDetailReview(element); }
/*      */       
/*      */       } 
/*  609 */       return null;
/*  610 */     } catch (IOException e) {
/*  611 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  612 */     } catch (JDOMException e) {
/*  613 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  616 */       return null;
/*      */     } 
/*      */   }
/*      */   public void fillRepositoryData(CrucibleFileInfo fileInfo) throws RemoteApiException {
/*  620 */     String repoName = fileInfo.getRepositoryName();
/*  621 */     if (repoName == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  626 */     String[] repoNameTokens = repoName.split(":");
/*      */     
/*  628 */     if (!this.repositories.containsKey(repoName)) {
/*  629 */       Repository repository1 = getRepository((repoNameTokens.length > 1) ? repoNameTokens[1] : repoNameTokens[0]);
/*  630 */       this.repositories.put(repoName, repository1);
/*      */     } 
/*  632 */     Repository repository = this.repositories.get(repoName);
/*  633 */     if (repository != null && repository instanceof SvnRepository) {
/*  634 */       String repoPath = String.valueOf(((SvnRepository)repository).getUrl()) + "/" + ((SvnRepository)repository).getPath() + "/";
/*  635 */       VersionedVirtualFile oldDescriptor = fileInfo.getOldFileDescriptor();
/*  636 */       if (!oldDescriptor.getUrl().equals("")) {
/*  637 */         oldDescriptor.setRepoUrl(repoPath);
/*      */       }
/*  639 */       VersionedVirtualFile newDescriptor = fileInfo.getFileDescriptor();
/*  640 */       if (!newDescriptor.getUrl().equals("")) {
/*  641 */         newDescriptor.setRepoUrl(repoPath);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private BasicReview parseBasicReview(Element element) throws RemoteApiException {
/*      */     try {
/*  648 */       return CrucibleRestXmlHelper.parseBasicReview(getBaseUrl(), element, shouldTrimWikiMarkers());
/*  649 */     } catch (ParseException e) {
/*  650 */       throw new RemoteApiException(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   private Review prepareFullDetailReview(Element element) throws RemoteApiException {
/*      */     Review review;
/*      */     try {
/*  657 */       review = CrucibleRestXmlHelper.parseFullReview(
/*  658 */           getBaseUrl(), getUsername(), element, shouldTrimWikiMarkers());
/*  659 */     } catch (ParseException e) {
/*  660 */       throw new RemoteApiException(e);
/*      */     } 
/*      */     
/*  663 */     for (CrucibleFileInfo fileInfo : review.getFiles()) {
/*  664 */       fillRepositoryData(fileInfo);
/*      */     }
/*  666 */     return review;
/*      */   }
/*      */   
/*      */   private Changes prepareChanges(Element element) throws RemoteApiException {
/*  670 */     return CrucibleRestXmlHelper.parseChangesNode(element);
/*      */   }
/*      */   
/*      */   public List<Reviewer> getReviewers(PermId permId) throws RemoteApiException {
/*  674 */     if (!isLoggedIn()) {
/*  675 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*  678 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/reviewers";
/*      */     try {
/*  680 */       Document doc = retrieveGetResponse(requestUrl);
/*      */       
/*  682 */       XPath xpath = XPath.newInstance("/reviewers/reviewer");
/*      */       
/*  684 */       List<Element> elements = xpath.selectNodes(doc);
/*  685 */       List<Reviewer> reviewers = new ArrayList<Reviewer>();
/*      */       
/*  687 */       if (elements != null && !elements.isEmpty()) {
/*  688 */         for (Element element : elements) {
/*  689 */           reviewers.add(CrucibleRestXmlHelper.parseReviewerNode(element));
/*      */         }
/*      */       }
/*  692 */       return reviewers;
/*  693 */     } catch (IOException e) {
/*  694 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  695 */     } catch (JDOMException e) {
/*  696 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  699 */       return null;
/*      */     } 
/*      */   }
/*      */   public List<User> getUsers() throws RemoteApiException {
/*  703 */     if (!isLoggedIn()) {
/*  704 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*  707 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/users-v1";
/*      */     try {
/*  709 */       Document doc = retrieveGetResponse(requestUrl);
/*      */       
/*  711 */       XPath xpath = XPath.newInstance("/users/userData");
/*      */       
/*  713 */       List<Element> elements = xpath.selectNodes(doc);
/*  714 */       List<User> users = new ArrayList<User>();
/*      */       
/*  716 */       if (elements != null && !elements.isEmpty()) {
/*  717 */         for (Element element : elements) {
/*      */           
/*  719 */           User u = CrucibleRestXmlHelper.parseUserNode(element);
/*  720 */           if (u.getDisplayName().equals("")) {
/*  721 */             u = new User(u.getUsername(), u.getUsername());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  734 */           users.add(u);
/*      */         } 
/*      */       }
/*  737 */       return users;
/*  738 */     } catch (IOException e) {
/*  739 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  740 */     } catch (JDOMException e) {
/*  741 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  744 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<BasicProject> getProjects() throws RemoteApiException {
/*  754 */     if (!isLoggedIn()) {
/*  755 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*  758 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/projects-v1";
/*      */     
/*      */     try {
/*  761 */       Document doc = retrieveGetResponse(requestUrl);
/*      */       
/*  763 */       XPath xpath = XPath.newInstance("/projects/projectData");
/*      */       
/*  765 */       List<Element> elements = xpath.selectNodes(doc);
/*  766 */       List<BasicProject> projects = new ArrayList<BasicProject>();
/*      */       
/*  768 */       if (elements != null && !elements.isEmpty()) {
/*  769 */         for (Element element : elements) {
/*  770 */           projects.add(CrucibleRestXmlHelper.parseBasicProjectNode(element));
/*      */         }
/*      */       }
/*  773 */       return projects;
/*  774 */     } catch (IOException e) {
/*  775 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  776 */     } catch (JDOMException e) {
/*  777 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  780 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExtendedCrucibleProject getProject(String key) throws RemoteApiException {
/*  790 */     if (!isLoggedIn()) {
/*  791 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*  794 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/projects-v1" + "/" + key + "?expand=allowedReviewers";
/*      */     
/*      */     try {
/*  797 */       Document doc = retrieveGetResponse(requestUrl);
/*      */       
/*  799 */       XPath xpath = XPath.newInstance("/projectData");
/*      */       
/*  801 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/*  803 */       if (elements != null && !elements.isEmpty()) {
/*  804 */         Iterator<Element> iterator = elements.iterator(); if (iterator.hasNext()) { Element element = iterator.next();
/*  805 */           return CrucibleRestXmlHelper.parseProjectNode(element); }
/*      */       
/*      */       } 
/*  808 */     } catch (IOException e) {
/*  809 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  810 */     } catch (JDOMException e) {
/*  811 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */     
/*  814 */     return null;
/*      */   }
/*      */   
/*      */   public List<Repository> getRepositories() throws RemoteApiException {
/*  818 */     if (!isLoggedIn()) {
/*  819 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*  822 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/repositories-v1";
/*      */     try {
/*  824 */       Document doc = retrieveGetResponse(requestUrl);
/*      */       
/*  826 */       XPath xpath = XPath.newInstance("/repositories/repoData");
/*      */       
/*  828 */       List<Element> elements = xpath.selectNodes(doc);
/*  829 */       List<Repository> myRepositories = new ArrayList<Repository>();
/*      */       
/*  831 */       if (elements != null && !elements.isEmpty()) {
/*  832 */         for (Element element : elements) {
/*  833 */           myRepositories.add(CrucibleRestXmlHelper.parseRepositoryNode(element));
/*      */         }
/*      */       }
/*  836 */       return myRepositories;
/*  837 */     } catch (IOException e) {
/*  838 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  839 */     } catch (JDOMException e) {
/*  840 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/*  843 */       return null;
/*      */     } 
/*      */   }
/*      */   public Repository getRepository(String repoName) throws RemoteApiException {
/*  847 */     if (!isLoggedIn()) {
/*  848 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*  851 */     List<Repository> myRepositories = getRepositories();
/*  852 */     for (Repository repository : myRepositories) {
/*  853 */       if (repository.getName().equals(repoName)) {
/*  854 */         if (repository.getType().equals("svn")) {
/*  855 */           String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/repositories-v1" + "/" + repoName + "/svn";
/*      */           try {
/*  857 */             Document doc = retrieveGetResponse(requestUrl);
/*  858 */             XPath xpath = XPath.newInstance("/svnRepositoryData");
/*      */             
/*  860 */             List<Element> elements = xpath.selectNodes(doc);
/*  861 */             if (elements != null && !elements.isEmpty()) {
/*  862 */               Iterator<Element> iterator = elements.iterator(); if (iterator.hasNext()) { Element element = iterator.next();
/*  863 */                 return (Repository)CrucibleRestXmlHelper.parseSvnRepositoryNode(element); }
/*      */             
/*      */             } 
/*  866 */           } catch (IOException e) {
/*  867 */             throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  868 */           } catch (JDOMException e) {
/*  869 */             throwMalformedResponseReturned(e);
/*      */           }  continue;
/*      */         } 
/*  872 */         return repository;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  877 */     return null;
/*      */   }
/*      */   
/*      */   public Set<CrucibleFileInfo> getFiles(PermId id) throws RemoteApiException {
/*  881 */     if (!isLoggedIn()) {
/*  882 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*  885 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + id.getId() + "/reviewitems";
/*      */     try {
/*  887 */       Document doc = retrieveGetResponse(requestUrl);
/*      */       
/*  889 */       XPath xpath = XPath.newInstance("reviewItems/reviewItem");
/*      */       
/*  891 */       List<Element> elements = xpath.selectNodes(doc);
/*  892 */       Set<CrucibleFileInfo> reviewItems = new HashSet<CrucibleFileInfo>();
/*      */       
/*  894 */       if (elements != null && !elements.isEmpty()) {
/*  895 */         for (Element element : elements) {
/*  896 */           CrucibleFileInfo fileInfo = CrucibleRestXmlHelper.parseReviewItemNode(element);
/*  897 */           fillRepositoryData(fileInfo);
/*  898 */           reviewItems.add(fileInfo);
/*      */         } 
/*      */       }
/*  901 */       return reviewItems;
/*  902 */     } catch (IOException e) {
/*  903 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  904 */     } catch (JDOMException e) {
/*  905 */       throwMalformedResponseReturned(e);
/*  906 */     } catch (ParseException e) {
/*  907 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*      */     } 
/*      */     
/*  910 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<VersionedComment> getVersionedComments(Review review, CrucibleFileInfo reviewItem) throws RemoteApiException {
/*  941 */     if (!isLoggedIn()) {
/*  942 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*  945 */     String requestUrl = 
/*  946 */       String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + review.getPermId().getId() + "/reviewitems" + "/" + 
/*  947 */       reviewItem.getPermId().getId() + "/comments";
/*      */     try {
/*  949 */       Document doc = retrieveGetResponse(requestUrl);
/*      */       
/*  951 */       XPath xpath = XPath.newInstance("comments/versionedLineCommentData");
/*      */       
/*  953 */       List<Element> elements = xpath.selectNodes(doc);
/*  954 */       List<VersionedComment> comments = new ArrayList<VersionedComment>();
/*      */       
/*  956 */       if (elements != null && !elements.isEmpty()) {
/*  957 */         Map<PermId, CrucibleFileInfo> reviewItemMap = Collections.singletonMap(reviewItem.getPermId(), 
/*  958 */             reviewItem);
/*  959 */         for (Element element : elements) {
/*  960 */           VersionedComment c = CrucibleRestXmlHelper.parseVersionedCommentNode(review, reviewItemMap, 
/*  961 */               getUsername(), element, shouldTrimWikiMarkers());
/*  962 */           if (c != null) {
/*  963 */             comments.add(c);
/*      */           }
/*      */         } 
/*      */       } 
/*  967 */       return comments;
/*  968 */     } catch (IOException e) {
/*  969 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*  970 */     } catch (JDOMException e) {
/*  971 */       throwMalformedResponseReturned(e);
/*  972 */     } catch (ParseException e) {
/*  973 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*      */     } 
/*      */     
/*  976 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Comment addGeneralComment(Review review, Comment comment) throws RemoteApiException {
/* 1041 */     if (!isLoggedIn()) {
/* 1042 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1045 */     Document request = CrucibleRestXmlHelper.prepareGeneralComment(comment);
/*      */     
/* 1047 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + review.getPermId().getId() + "/comments";
/*      */     try {
/* 1049 */       Document doc = retrievePostResponse(requestUrl, request);
/*      */       
/* 1051 */       XPath xpath = XPath.newInstance("generalCommentData");
/*      */       
/* 1053 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1055 */       if (elements != null && !elements.isEmpty()) {
/* 1056 */         Iterator<Element> iterator = elements.iterator(); if (iterator.hasNext()) { Element element = iterator.next();
/* 1057 */           return (Comment)CrucibleRestXmlHelper.parseGeneralCommentNode(review, null, getUsername(), element, 
/* 1058 */               shouldTrimWikiMarkers()); }
/*      */       
/*      */       } 
/* 1061 */       return null;
/* 1062 */     } catch (IOException e) {
/* 1063 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1064 */     } catch (JDOMException e) {
/* 1065 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1068 */       return null;
/*      */     } 
/*      */   }
/*      */   public void removeComment(PermId id, Comment comment) throws RemoteApiException {
/* 1072 */     if (!isLoggedIn()) {
/* 1073 */       throwNotLoggedIn();
/*      */     }
/* 1075 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + id.getId() + "/comments" + "/" + 
/* 1076 */       comment.getPermId().getId();
/*      */     try {
/* 1078 */       retrieveDeleteResponse(requestUrl, false);
/* 1079 */     } catch (IOException e) {
/* 1080 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1081 */     } catch (JDOMException e) {
/* 1082 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void updateComment(PermId id, Comment comment) throws RemoteApiException {
/* 1087 */     if (!isLoggedIn()) {
/* 1088 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1091 */     Document request = CrucibleRestXmlHelper.prepareGeneralComment(comment);
/* 1092 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + id.getId() + "/comments" + "/" + 
/* 1093 */       comment.getPermId().getId();
/*      */     
/*      */     try {
/* 1096 */       retrievePostResponse(requestUrl, request, false);
/* 1097 */     } catch (JDOMException e) {
/* 1098 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void publishComment(PermId reviewId, PermId commentId) throws RemoteApiException {
/* 1103 */     if (!isLoggedIn()) {
/* 1104 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1107 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + reviewId.getId() + "/publish";
/* 1108 */     if (commentId != null) {
/* 1109 */       requestUrl = String.valueOf(requestUrl) + "/" + commentId.getId();
/*      */     }
/*      */     
/*      */     try {
/* 1113 */       retrievePostResponse(requestUrl, "", false);
/* 1114 */     } catch (JDOMException e) {
/* 1115 */       throwMalformedResponseReturned(e);
/* 1116 */     } catch (RemoteApiSessionExpiredException e) {
/* 1117 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public VersionedComment addVersionedComment(Review review, PermId riId, VersionedComment comment) throws RemoteApiException {
/* 1123 */     if (!isLoggedIn()) {
/* 1124 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1127 */     Document request = CrucibleRestXmlHelper.prepareVersionedComment(riId, comment);
/* 1128 */     String requestUrl = 
/* 1129 */       String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + review.getPermId().getId() + "/reviewitems" + "/" + riId.getId() + 
/* 1130 */       "/comments";
/*      */     try {
/* 1132 */       Document doc = retrievePostResponse(requestUrl, request);
/* 1133 */       XPath xpath = XPath.newInstance("versionedLineCommentData");
/*      */       
/* 1135 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1137 */       if (elements != null && !elements.isEmpty()) {
/* 1138 */         Iterator<Element> iterator = elements.iterator(); if (iterator.hasNext()) { Element element = iterator.next();
/* 1139 */           Map<PermId, CrucibleFileInfo> fileInfoMap = Collections.singletonMap(comment.getCrucibleFileInfo()
/* 1140 */               .getPermId(), comment.getCrucibleFileInfo());
/* 1141 */           return CrucibleRestXmlHelper.parseVersionedCommentNode(review, fileInfoMap, 
/* 1142 */               getUsername(), element, shouldTrimWikiMarkers()); }
/*      */       
/*      */       } 
/* 1145 */       return null;
/* 1146 */     } catch (IOException e) {
/* 1147 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1148 */     } catch (JDOMException e) {
/* 1149 */       throwMalformedResponseReturned(e);
/* 1150 */     } catch (ParseException e) {
/* 1151 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/*      */     } 
/*      */     
/* 1154 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   public Comment addReply(Review review, Comment reply) throws RemoteApiException {
/* 1160 */     if (!isLoggedIn()) {
/* 1161 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1164 */     Comment parentComment = reply.getParentComment();
/* 1165 */     if (parentComment == null) {
/* 1166 */       throw new RemoteApiException("Reply must have a parent comment defined");
/*      */     }
/*      */     
/* 1169 */     Document request = CrucibleRestXmlHelper.prepareGeneralComment(reply);
/*      */     
/* 1171 */     PermId permId = review.getPermId();
/* 1172 */     if (permId == null) {
/* 1173 */       throw new RemoteApiException("Review must have permId defined");
/*      */     }
/* 1175 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/comments" + "/" + 
/* 1176 */       parentComment.getPermId().getId() + "/replies";
/*      */     
/*      */     try {
/* 1179 */       Document doc = retrievePostResponse(requestUrl, request);
/*      */       
/* 1181 */       XPath xpath = XPath.newInstance("generalCommentData");
/*      */       
/* 1183 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1185 */       if (elements != null && !elements.isEmpty()) {
/* 1186 */         Iterator<Element> iterator = elements.iterator(); if (iterator.hasNext()) { Element element = iterator.next();
/* 1187 */           GeneralComment receivedReply = 
/* 1188 */             CrucibleRestXmlHelper.parseGeneralCommentNode(review, parentComment, 
/* 1189 */               getUsername(), element, shouldTrimWikiMarkers());
/* 1190 */           if (receivedReply != null) {
/* 1191 */             receivedReply.setReply(true);
/*      */           }
/* 1193 */           return (Comment)receivedReply; }
/*      */       
/*      */       } 
/* 1196 */       return null;
/* 1197 */     } catch (IOException e) {
/* 1198 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1199 */     } catch (JDOMException e) {
/* 1200 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1203 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void updateReply(PermId id, PermId cId, PermId rId, Comment comment) throws RemoteApiException {
/* 1208 */     if (!isLoggedIn()) {
/* 1209 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1212 */     Document request = CrucibleRestXmlHelper.prepareGeneralComment(comment);
/*      */     
/* 1214 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + id.getId() + "/comments" + "/" + cId.getId() + "/replies" + 
/* 1215 */       "/" + rId.getId();
/*      */     
/*      */     try {
/* 1218 */       retrievePostResponse(requestUrl, request, false);
/* 1219 */     } catch (JDOMException e) {
/* 1220 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public BasicReview createReview(Review review) throws RemoteApiException {
/* 1226 */     if (!isLoggedIn()) {
/* 1227 */       throwNotLoggedIn();
/*      */     }
/* 1229 */     return createReviewFromPatch(review, (String)null);
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public BasicReview createSnippetReview(Review review, String snippet, String filename) throws RemoteApiException {
/* 1234 */     if (!isLoggedIn()) {
/* 1235 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1238 */     Document request = CrucibleRestXmlHelper.prepareCreateSnippetReviewNode(review, snippet, filename);
/*      */     try {
/* 1240 */       Document doc = retrievePostResponse(String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1", request);
/*      */       
/* 1242 */       XPath xpath = XPath.newInstance("/reviewData");
/*      */       
/* 1244 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1246 */       if (elements != null && !elements.isEmpty()) {
/* 1247 */         return parseBasicReview(elements.iterator().next());
/*      */       }
/* 1249 */       return null;
/* 1250 */     } catch (IOException e) {
/* 1251 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1252 */     } catch (JDOMException e) {
/* 1253 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1256 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   public BasicReview createReviewFromPatch(Review review, String patch) throws RemoteApiException {
/* 1263 */     if (!isLoggedIn()) {
/* 1264 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1267 */     Document request = CrucibleRestXmlHelper.prepareCreateReviewNode(review, patch);
/*      */     
/* 1269 */     StringBuilder txtHolder = new StringBuilder();
/*      */     try {
/* 1271 */       Document doc = retrievePostResponse(String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1", request, txtHolder);
/*      */       
/* 1273 */       XPath xpath = XPath.newInstance("/reviewData");
/*      */       
/* 1275 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1277 */       if (elements != null && !elements.isEmpty()) {
/* 1278 */         return parseBasicReview(elements.iterator().next());
/*      */       }
/* 1280 */       return null;
/* 1281 */     } catch (IOException e) {
/* 1282 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1283 */     } catch (JDOMException e) {
/* 1284 */       throwMalformedResponseReturned(e, txtHolder.toString());
/*      */ 
/*      */       
/* 1287 */       return null;
/*      */     } 
/*      */   }
/*      */   @Nullable
/*      */   public BasicReview createReviewFromPatch(Review review, String patch, PatchAnchorData anchorData) throws RemoteApiException {
/* 1292 */     if (!isLoggedIn()) {
/* 1293 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1296 */     Document request = CrucibleRestXmlHelper.prepareCreateReviewNode(review, patch);
/* 1297 */     if (getCrucibleVersionInfo().isVersion24OrGrater() && anchorData != null)
/*      */     {
/* 1299 */       CrucibleRestXmlHelper.addAnchorData(request, anchorData);
/*      */     }
/*      */     
/* 1302 */     StringBuilder txtHolder = new StringBuilder();
/*      */     try {
/* 1304 */       Document doc = retrievePostResponse(String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1", request, txtHolder);
/*      */       
/* 1306 */       XPath xpath = XPath.newInstance("/reviewData");
/*      */       
/* 1308 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1310 */       if (elements != null && !elements.isEmpty()) {
/* 1311 */         return parseBasicReview(elements.iterator().next());
/*      */       }
/* 1313 */       return null;
/* 1314 */     } catch (IOException e) {
/* 1315 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1316 */     } catch (JDOMException e) {
/* 1317 */       throwMalformedResponseReturned(e, txtHolder.toString());
/*      */ 
/*      */       
/* 1320 */       return null;
/*      */     } 
/*      */   }
/*      */   private List<Element> getReviewData(Document doc) throws JDOMException {
/* 1324 */     XPath xpath = XPath.newInstance("/reviewData");
/*      */     
/* 1326 */     List<Element> elements = xpath.selectNodes(doc);
/* 1327 */     return elements;
/*      */   }
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   public BasicReview createReviewFromUpload(Review review, Collection<UploadItem> uploadItems) throws RemoteApiException {
/* 1333 */     if (!isLoggedIn()) {
/* 1334 */       throwNotLoggedIn();
/*      */     }
/* 1336 */     BasicReview newReview = createReviewFromPatch(review, (String)null);
/*      */     
/*      */     try {
/* 1339 */       String urlString = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + newReview.getPermId().getId() + "/addFile";
/* 1340 */       for (UploadItem uploadItem : uploadItems) {
/* 1341 */         String bogusOld = "[--item is empty--]";
/* 1342 */         String bogusNew = "[--item deleted--]";
/*      */         
/* 1344 */         byte[] oldContent = uploadItem.getOldContent();
/* 1345 */         byte[] newContent = uploadItem.getNewContent();
/*      */         
/* 1347 */         if (oldContent == null) {
/* 1348 */           oldContent = bogusOld.getBytes();
/*      */         }
/* 1350 */         if (newContent == null) {
/* 1351 */           newContent = bogusNew.getBytes();
/*      */         }
/*      */         
/* 1354 */         ByteArrayPartSource targetOldFile = new ByteArrayPartSource(uploadItem.getFileName(), oldContent);
/* 1355 */         ByteArrayPartSource targetNewFile = new ByteArrayPartSource(uploadItem.getFileName(), newContent);
/*      */         
/* 1357 */         Part[] parts = { (Part)new FilePart("file", (PartSource)targetNewFile), (Part)new FilePart("diffFile", (PartSource)targetOldFile) };
/*      */         
/* 1359 */         retrievePostResponse(urlString, parts, true);
/*      */       } 
/* 1361 */     } catch (JDOMException e) {
/* 1362 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */     
/* 1365 */     return newReview;
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public BasicReview createReviewFromRevision(Review review, List<String> revisions) throws RemoteApiException {
/* 1370 */     if (!isLoggedIn()) {
/* 1371 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1374 */     Document request = CrucibleRestXmlHelper.prepareCreateReviewNode(review, revisions);
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1379 */       Document doc = retrievePostResponse(String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1", request);
/* 1380 */       XPath xpath = XPath.newInstance("/reviewData");
/*      */       
/* 1382 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1384 */       if (elements != null && !elements.isEmpty()) {
/* 1385 */         return parseBasicReview(elements.iterator().next());
/*      */       }
/* 1387 */       return null;
/* 1388 */     } catch (IOException e) {
/* 1389 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1390 */     } catch (JDOMException e) {
/* 1391 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1394 */       return null;
/*      */     } 
/*      */   }
/*      */   public byte[] getFileContent(String contentUrl) throws RemoteApiException {
/* 1398 */     return getFileContent(contentUrl, false);
/*      */   }
/*      */   
/*      */   public byte[] getFileContent(String contentUrl, boolean ignoreBase) throws RemoteApiException {
/* 1402 */     if (!isLoggedIn()) {
/* 1403 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1406 */     if (StringUtils.isBlank(contentUrl)) {
/* 1407 */       throw new RemoteApiException("Content URL is blank");
/*      */     }
/*      */     
/* 1410 */     String requestUrl = ignoreBase ? contentUrl : (String.valueOf(getBaseUrl()) + contentUrl);
/*      */     try {
/* 1412 */       return doConditionalGet(requestUrl);
/* 1413 */     } catch (IOException e) {
/* 1414 */       throw new RemoteApiException(String.valueOf(requestUrl) + ": " + e.getMessage(), e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public List<CrucibleAction> getAvailableActions(PermId permId) throws RemoteApiException {
/* 1419 */     if (!isLoggedIn()) {
/* 1420 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1423 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/actions";
/*      */     try {
/* 1425 */       Document doc = retrieveGetResponse(requestUrl);
/*      */       
/* 1427 */       XPath xpath = XPath.newInstance("/actions/actionData");
/*      */       
/* 1429 */       List<Element> elements = xpath.selectNodes(doc);
/* 1430 */       return CrucibleRestXmlHelper.parseActions(elements);
/* 1431 */     } catch (IOException e) {
/* 1432 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1433 */     } catch (JDOMException e) {
/* 1434 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1437 */       return null;
/*      */     } 
/*      */   }
/*      */   public List<CrucibleAction> getAvailableTransitions(PermId permId) throws RemoteApiException {
/* 1441 */     if (!isLoggedIn()) {
/* 1442 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1445 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/transitions";
/*      */     try {
/* 1447 */       Document doc = retrieveGetResponse(requestUrl);
/*      */       
/* 1449 */       XPath xpath = XPath.newInstance("/transitions/actionData");
/*      */       
/* 1451 */       List<Element> elements = xpath.selectNodes(doc);
/* 1452 */       return CrucibleRestXmlHelper.parseActions(elements);
/* 1453 */     } catch (IOException e) {
/* 1454 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1455 */     } catch (JDOMException e) {
/* 1456 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1459 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   public BasicReview addRevisionsToReview(PermId permId, String repository, Collection<String> revisions) throws RemoteApiException {
/* 1466 */     return addChangesetRevisionsToReview(permId, repository, revisions);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   public BasicReview addFileRevisionsToReview(PermId permId, String repository, List<PathAndRevision> revisions) throws RemoteApiException {
/* 1473 */     if (!isLoggedIn()) {
/* 1474 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1477 */     if (!getServerVersion().isVersion21OrGreater()) {
/* 1478 */       throw new RemoteApiException("Crucible 2.1 or newer is required");
/*      */     }
/*      */     
/* 1481 */     Document request = CrucibleRestXmlHelper.prepareRevisionDataNode(repository, revisions);
/*      */     
/*      */     try {
/* 1484 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/reviewitems/revisions";
/* 1485 */       Document doc = retrievePostResponse(url, request);
/*      */       
/* 1487 */       XPath xpath = XPath.newInstance("/detailedReviewData");
/*      */       
/* 1489 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1491 */       if (elements != null && !elements.isEmpty()) {
/* 1492 */         return parseBasicReview(elements.iterator().next());
/*      */       }
/* 1494 */       return null;
/* 1495 */     } catch (IOException e) {
/* 1496 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1497 */     } catch (JDOMException e) {
/* 1498 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1501 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   private BasicReview addChangesetRevisionsToReview(PermId permId, String repository, Collection<String> revisions) throws RemoteApiException {
/* 1508 */     if (!isLoggedIn()) {
/* 1509 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1512 */     Document request = CrucibleRestXmlHelper.prepareAddChangesetNode(repository, revisions);
/*      */     
/*      */     try {
/* 1515 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/addChangeset";
/* 1516 */       Document doc = retrievePostResponse(url, request);
/*      */       
/* 1518 */       XPath xpath = XPath.newInstance("/reviewData");
/*      */       
/* 1520 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1522 */       if (elements != null && !elements.isEmpty()) {
/* 1523 */         return parseBasicReview(elements.iterator().next());
/*      */       }
/* 1525 */       return null;
/* 1526 */     } catch (IOException e) {
/* 1527 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1528 */     } catch (JDOMException e) {
/* 1529 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1532 */       return null;
/*      */     } 
/*      */   }
/*      */   public void addFileToReview(PermId permId, NewReviewItem newReviewItem) throws RemoteApiException {
/* 1536 */     if (!isLoggedIn()) {
/* 1537 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1540 */     if (!getServerVersion().isVersion21OrGreater()) {
/* 1541 */       throw new RemoteApiException("Crucible 2.1 or newer is required");
/*      */     }
/*      */     
/* 1544 */     Document request = CrucibleRestXmlHelper.prepareAddItemNode(newReviewItem);
/*      */     
/*      */     try {
/* 1547 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/reviewitems";
/* 1548 */       retrievePostResponse(url, request);
/*      */ 
/*      */       
/*      */       return;
/* 1552 */     } catch (IOException e) {
/* 1553 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1554 */     } catch (JDOMException e) {
/* 1555 */       throwMalformedResponseReturned(e);
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   public BasicReview addPatchToReview(PermId permId, String repository, String patch) throws RemoteApiException {
/* 1563 */     if (!isLoggedIn()) {
/* 1564 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1567 */     Document request = CrucibleRestXmlHelper.prepareAddPatchNode(repository, patch);
/*      */     
/*      */     try {
/* 1570 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/addPatch";
/* 1571 */       Document doc = retrievePostResponse(url, request);
/*      */       
/* 1573 */       XPath xpath = XPath.newInstance("/reviewData");
/*      */       
/* 1575 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1577 */       if (elements != null && !elements.isEmpty()) {
/* 1578 */         return parseBasicReview(elements.iterator().next());
/*      */       }
/* 1580 */       return null;
/* 1581 */     } catch (IOException e) {
/* 1582 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1583 */     } catch (JDOMException e) {
/* 1584 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1587 */       return null;
/*      */     } 
/*      */   }
/*      */   public void addItemsToReview(PermId permId, Collection<UploadItem> uploadItems) throws RemoteApiException {
/* 1591 */     if (!isLoggedIn()) {
/* 1592 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*      */     try {
/* 1596 */       String urlString = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/addFile";
/* 1597 */       for (UploadItem uploadItem : uploadItems) {
/* 1598 */         ByteArrayPartSource targetOldFile = 
/* 1599 */           new ByteArrayPartSource(uploadItem.getFileName(), uploadItem.getOldContent());
/* 1600 */         ByteArrayPartSource targetNewFile = 
/* 1601 */           new ByteArrayPartSource(uploadItem.getFileName(), uploadItem.getNewContent());
/*      */         
/* 1603 */         Part[] parts = {
/* 1604 */             (Part)new FilePart("file", (PartSource)targetNewFile, 
/* 1605 */               uploadItem.getNewContentType(), uploadItem.getNewCharset()), 
/* 1606 */             (Part)new FilePart("diffFile", (PartSource)targetOldFile, 
/* 1607 */               uploadItem.getOldContentType(), uploadItem.getOldCharset())
/*      */           };
/* 1609 */         retrievePostResponse(urlString, parts, true);
/*      */       } 
/* 1611 */     } catch (JDOMException e) {
/* 1612 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addReviewers(PermId permId, Set<String> users) throws RemoteApiException {
/* 1617 */     if (!isLoggedIn()) {
/* 1618 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1621 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/reviewers";
/* 1622 */     String reviewers = "";
/* 1623 */     for (String user : users) {
/* 1624 */       if (reviewers.length() > 0) {
/* 1625 */         reviewers = String.valueOf(reviewers) + ",";
/*      */       }
/* 1627 */       reviewers = String.valueOf(reviewers) + user;
/*      */     } 
/*      */     
/*      */     try {
/* 1631 */       retrievePostResponse(requestUrl, reviewers, false);
/* 1632 */     } catch (JDOMException e) {
/* 1633 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void removeReviewer(PermId permId, String username) throws RemoteApiException {
/* 1638 */     if (!isLoggedIn()) {
/* 1639 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1642 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/reviewers" + "/" + username;
/*      */     try {
/* 1644 */       retrieveDeleteResponse(requestUrl, false);
/* 1645 */     } catch (IOException e) {
/* 1646 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1647 */     } catch (JDOMException e) {
/* 1648 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void throwMalformedResponseReturned(JDOMException e) throws RemoteApiException {
/* 1653 */     throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": Server returned malformed response", e);
/*      */   }
/*      */   
/*      */   private void throwMalformedResponseReturned(JDOMException e, String responseText) throws RemoteApiException {
/* 1657 */     throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": Server returned malformed response: \n\n" + responseText + "\n\n", e);
/*      */   }
/*      */   
/*      */   private static void throwNotLoggedIn() {
/* 1661 */     throw new IllegalStateException("Calling method without calling login() first");
/*      */   }
/*      */   
/*      */   public void markCommentRead(PermId reviewId, PermId commentId) throws RemoteApiException {
/* 1665 */     if (!isLoggedIn()) {
/* 1666 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1669 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + reviewId.getId() + 
/* 1670 */       "/comments" + "/" + commentId.getId() + "/markAsRead";
/*      */     
/*      */     try {
/* 1673 */       retrievePostResponse(requestUrl, "", false);
/* 1674 */     } catch (JDOMException e) {
/* 1675 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void markCommentLeaveRead(PermId reviewId, PermId commentId) throws RemoteApiException {
/* 1680 */     if (!isLoggedIn()) {
/* 1681 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1684 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + reviewId.getId() + 
/* 1685 */       "/comments" + "/" + commentId.getId() + "/markAsLeaveUnread";
/*      */     
/*      */     try {
/* 1688 */       retrievePostResponse(requestUrl, "", false);
/* 1689 */     } catch (JDOMException e) {
/* 1690 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void markAllCommentsRead(PermId reviewId) throws RemoteApiException {
/* 1695 */     if (!isLoggedIn()) {
/* 1696 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1699 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + reviewId.getId() + "/comments" + "/markAllAsRead";
/*      */     
/*      */     try {
/* 1702 */       retrievePostResponse(requestUrl, "", false);
/* 1703 */     } catch (JDOMException e) {
/* 1704 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   public BasicReview changeReviewState(PermId permId, CrucibleAction action) throws RemoteApiException {
/* 1712 */     if (!isLoggedIn()) {
/* 1713 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1716 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/transition?action=" + action.getId();
/*      */     try {
/* 1718 */       Document doc = retrievePostResponse(requestUrl, "", true);
/*      */       
/* 1720 */       XPath xpath = XPath.newInstance("reviewData");
/*      */       
/* 1722 */       List<Element> elements = xpath.selectNodes(doc);
/* 1723 */       Review review = null;
/*      */       
/* 1725 */       if (elements != null && !elements.isEmpty()) {
/* 1726 */         Iterator<Element> iterator = elements.iterator(); if (iterator.hasNext()) { Element element = iterator.next();
/* 1727 */           return parseBasicReview(element); }
/*      */       
/*      */       } 
/* 1730 */       return (BasicReview)review;
/* 1731 */     } catch (JDOMException e) {
/* 1732 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1735 */       return null;
/*      */     } 
/*      */   }
/*      */   public void completeReview(PermId permId, boolean complete) throws RemoteApiException {
/* 1739 */     if (!isLoggedIn()) {
/* 1740 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1743 */     String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId();
/* 1744 */     if (complete) {
/* 1745 */       requestUrl = String.valueOf(requestUrl) + "/complete";
/*      */     } else {
/* 1747 */       requestUrl = String.valueOf(requestUrl) + "/uncomplete";
/*      */     } 
/*      */     
/*      */     try {
/* 1751 */       retrievePostResponse(requestUrl, "", false);
/* 1752 */     } catch (JDOMException e) {
/* 1753 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public BasicReview closeReview(PermId permId, String summarizeMessage) throws RemoteApiException {
/* 1759 */     if (!isLoggedIn()) {
/* 1760 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*      */     try {
/*      */       Document doc;
/* 1765 */       if (summarizeMessage != null && !"".equals(summarizeMessage)) {
/* 1766 */         Document request = CrucibleRestXmlHelper.prepareCloseReviewSummaryNode(summarizeMessage);
/* 1767 */         String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/close";
/* 1768 */         doc = retrievePostResponse(requestUrl, request);
/*      */       } else {
/* 1770 */         String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/transition?action=" + 
/* 1771 */           "action:closeReview";
/* 1772 */         doc = retrievePostResponse(requestUrl, "", true);
/*      */       } 
/*      */       
/* 1775 */       XPath xpath = XPath.newInstance("reviewData");
/*      */       
/* 1777 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1779 */       if (elements != null && !elements.isEmpty()) {
/* 1780 */         return parseBasicReview(elements.get(0));
/*      */       }
/* 1782 */       return null;
/* 1783 */     } catch (IOException e) {
/* 1784 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1785 */     } catch (JDOMException e) {
/* 1786 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1789 */       return null;
/*      */     } 
/*      */   }
/*      */   public List<CustomFieldDef> getMetrics(int version) throws RemoteApiException {
/* 1793 */     String key = Integer.toString(version);
/* 1794 */     if (!this.metricsDefinitions.containsKey(key)) {
/*      */       
/* 1796 */       if (!isLoggedIn()) {
/* 1797 */         throwNotLoggedIn();
/*      */       }
/*      */       
/* 1800 */       String requestUrl = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/metrics" + "/" + Integer.toString(version);
/*      */       try {
/* 1802 */         Document doc = retrieveGetResponse(requestUrl);
/*      */         
/* 1804 */         XPath xpath = XPath.newInstance("metrics/metricsData");
/*      */         
/* 1806 */         List<Element> elements = xpath.selectNodes(doc);
/* 1807 */         List<CustomFieldDef> metrics = new ArrayList<CustomFieldDef>();
/*      */         
/* 1809 */         if (elements != null && !elements.isEmpty()) {
/* 1810 */           for (Element element : elements) {
/* 1811 */             metrics.add(CrucibleRestXmlHelper.parseMetricsNode(element));
/*      */           }
/*      */         }
/* 1814 */         this.metricsDefinitions.put(key, metrics);
/* 1815 */       } catch (IOException e) {
/* 1816 */         throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1817 */       } catch (JDOMException e) {
/* 1818 */         throwMalformedResponseReturned(e);
/*      */       } 
/*      */     } 
/* 1821 */     return this.metricsDefinitions.get(key);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void adjustHttpHeader(HttpMethod method) {
/* 1826 */     method.addRequestHeader(new Header("Authorization", getAuthHeaderValue()));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void preprocessResult(Document doc) throws JDOMException, RemoteApiSessionExpiredException {}
/*      */ 
/*      */ 
/*      */   
/*      */   protected void preprocessMethodResult(HttpMethod method) {}
/*      */ 
/*      */   
/*      */   private String getAuthHeaderValue() {
/* 1839 */     return "Basic " + StringUtil.encode(String.valueOf(getUsername()) + ":" + getPassword());
/*      */   }
/*      */   
/*      */   private static String getExceptionMessages(Document doc) throws JDOMException {
/* 1843 */     XPath xpath = XPath.newInstance("/loginResult/error");
/*      */     
/* 1845 */     List<Element> elements = xpath.selectNodes(doc);
/*      */     
/* 1847 */     if (elements != null && elements.size() > 0) {
/* 1848 */       StringBuffer exceptionMsg = new StringBuffer();
/* 1849 */       for (Element e : elements) {
/* 1850 */         exceptionMsg.append(e.getText());
/* 1851 */         exceptionMsg.append("\n");
/*      */       } 
/* 1853 */       return exceptionMsg.toString();
/*      */     } 
/*      */     
/* 1856 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isLoggedIn() throws RemoteApiLoginException {
/* 1861 */     if (!this.loginCalled) {
/* 1862 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1866 */     realLogin();
/* 1867 */     return (this.authToken != null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   public BasicReview addRevisionsToReviewItems(PermId permId, Collection<RevisionData> revisions) throws RemoteApiException {
/* 1874 */     if (!isLoggedIn()) {
/* 1875 */       throwNotLoggedIn();
/*      */     }
/*      */     
/* 1878 */     Document request = CrucibleRestXmlHelper.prepareRevisions(revisions);
/*      */     
/*      */     try {
/* 1881 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/reviews-v1" + "/" + permId.getId() + "/reviewitems" + "/revisions";
/* 1882 */       Document doc = retrievePostResponse(url, request);
/*      */       
/* 1884 */       XPath xpath = XPath.newInstance("/detailedReviewData");
/*      */ 
/*      */       
/* 1887 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1889 */       if (elements != null && !elements.isEmpty()) {
/* 1890 */         Iterator<Element> iterator = elements.iterator(); if (iterator.hasNext()) { Element element = iterator.next();
/* 1891 */           return parseBasicReview(element); }
/*      */       
/*      */       } 
/* 1894 */       return null;
/* 1895 */     } catch (IOException e) {
/* 1896 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1897 */     } catch (JDOMException e) {
/* 1898 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1901 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public Changes getChanges(@NotNull String repository, @Nullable String oldestCsid, boolean includeOldest, @Nullable String newestCsid, boolean includeNewest, @Nullable Integer max) throws RemoteApiException {
/* 1908 */     if (!isLoggedIn()) {
/* 1909 */       throwNotLoggedIn();
/*      */     }
/*      */     
/*      */     try {
/* 1913 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/repositories-v1" + "/changes/" + repository + "/?";
/* 1914 */       if (oldestCsid != null) {
/* 1915 */         url = String.valueOf(url) + "oldestCsid=" + oldestCsid + "&includeOldest=" + Boolean.toString(includeOldest) + "&";
/*      */       }
/* 1917 */       if (newestCsid != null) {
/* 1918 */         url = String.valueOf(url) + "newestCsid=" + newestCsid + "&includeNewest=" + Boolean.toString(includeNewest) + "&";
/*      */       }
/* 1920 */       if (max != null) {
/* 1921 */         url = String.valueOf(url) + "max=" + max.toString() + "&";
/*      */       }
/*      */       
/* 1924 */       Document doc = retrieveGetResponse(url);
/*      */       
/* 1926 */       XPath xpath = XPath.newInstance("/changes");
/*      */ 
/*      */       
/* 1929 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1931 */       if (elements != null && !elements.isEmpty()) {
/* 1932 */         Iterator<Element> iterator = elements.iterator(); if (iterator.hasNext()) { Element element = iterator.next();
/* 1933 */           return prepareChanges(element); }
/*      */       
/*      */       } 
/*      */       
/* 1937 */       xpath = XPath.newInstance("/error");
/* 1938 */       Element errorNode = (Element)xpath.selectSingleNode(doc);
/* 1939 */       if (errorNode != null) {
/* 1940 */         CrucibleRestXmlHelper.parseErrorAndThrowIt(errorNode);
/*      */       }
/* 1942 */     } catch (IOException e) {
/* 1943 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1944 */     } catch (JDOMException e) {
/* 1945 */       throwMalformedResponseReturned(e);
/*      */     } 
/*      */     
/* 1948 */     throw new RemoteApiException("No changes returned by server.");
/*      */   }
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public List<BasicReview> getReviewsForIssue(@NotNull String jiraIssueKey, @NotNull int maxReturn) throws RemoteApiException, RemoteApiSessionExpiredException {
/* 1954 */     if (!isLoggedIn()) {
/* 1955 */       throwNotLoggedIn();
/*      */     }
/* 1957 */     List<BasicReview> reviews = new ArrayList<BasicReview>();
/*      */     
/*      */     try {
/* 1960 */       String url = String.valueOf(getBaseUrl()) + "/rest-service/search-v1" + "/reviewsForIssue" + "/?jiraKey=" + 
/* 1961 */         URLEncoder.encode(jiraIssueKey, "UTF-8") + "&maxReturn=" + maxReturn;
/* 1962 */       Document doc = retrieveGetResponse(url);
/*      */       
/* 1964 */       XPath xpath = XPath.newInstance("/detailedReviews/detailedReviewData");
/*      */ 
/*      */       
/* 1967 */       List<Element> elements = xpath.selectNodes(doc);
/*      */       
/* 1969 */       if (elements != null && !elements.isEmpty()) {
/* 1970 */         for (Element element : elements) {
/* 1971 */           reviews.add(parseBasicReview(element));
/*      */         }
/*      */       }
/* 1974 */       for (BasicReview review : reviews) {
/* 1975 */         updateMetricsMetadata(review);
/*      */       }
/* 1977 */       return reviews;
/* 1978 */     } catch (IOException e) {
/* 1979 */       throw new RemoteApiException(String.valueOf(getBaseUrl()) + ": " + e.getMessage(), e);
/* 1980 */     } catch (JDOMException e) {
/* 1981 */       throwMalformedResponseReturned(e);
/*      */ 
/*      */       
/* 1984 */       return reviews;
/*      */     } 
/*      */   }
/*      */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\rest\CrucibleSessionImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */