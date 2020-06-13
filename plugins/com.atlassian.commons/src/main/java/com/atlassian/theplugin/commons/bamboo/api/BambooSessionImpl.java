/*      */ package com.atlassian.theplugin.commons.bamboo.api;
/*      */ 
/*      */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*      */ import com.atlassian.theplugin.commons.BambooFileInfo;
/*      */ import com.atlassian.theplugin.commons.bamboo.BambooBuild;
/*      */ import com.atlassian.theplugin.commons.bamboo.BambooBuildInfo;
/*      */ import com.atlassian.theplugin.commons.bamboo.BambooChangeSet;
/*      */ import com.atlassian.theplugin.commons.bamboo.BambooChangeSetImpl;
/*      */ import com.atlassian.theplugin.commons.bamboo.BambooJob;
/*      */ import com.atlassian.theplugin.commons.bamboo.BambooJobImpl;
/*      */ import com.atlassian.theplugin.commons.bamboo.BambooPlan;
/*      */ import com.atlassian.theplugin.commons.bamboo.BambooProject;
/*      */ import com.atlassian.theplugin.commons.bamboo.BambooProjectInfo;
/*      */ import com.atlassian.theplugin.commons.bamboo.BuildDetails;
/*      */ import com.atlassian.theplugin.commons.bamboo.BuildDetailsInfo;
/*      */ import com.atlassian.theplugin.commons.bamboo.BuildIssue;
/*      */ import com.atlassian.theplugin.commons.bamboo.BuildIssueInfo;
/*      */ import com.atlassian.theplugin.commons.bamboo.BuildStatus;
/*      */ import com.atlassian.theplugin.commons.bamboo.TestDetails;
/*      */ import com.atlassian.theplugin.commons.bamboo.TestDetailsInfo;
/*      */ import com.atlassian.theplugin.commons.bamboo.TestResult;
/*      */ import com.atlassian.theplugin.commons.cfg.SubscribedPlan;
/*      */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiBadServerVersionException;
/*      */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*      */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginException;
/*      */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiMalformedUrlException;
/*      */ import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;
/*      */ import com.atlassian.theplugin.commons.util.Logger;
/*      */ import com.atlassian.theplugin.commons.util.LoggerImpl;
/*      */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*      */ import com.atlassian.theplugin.commons.util.UrlUtil;
/*      */ import com.atlassian.theplugin.commons.util.XmlUtil;
/*      */ import com.google.common.collect.Lists;
/*      */ import java.io.IOException;
/*      */ import java.text.ParseException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.Set;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import org.apache.commons.lang.StringEscapeUtils;
/*      */ import org.apache.commons.lang.StringUtils;
/*      */ import org.jdom.Document;
/*      */ import org.jdom.Element;
/*      */ import org.jdom.JDOMException;
/*      */ import org.jdom.xpath.XPath;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ import org.joda.time.DateTime;
/*      */ import org.joda.time.format.DateTimeFormat;
/*      */ import org.joda.time.format.DateTimeFormatter;
/*      */ import org.joda.time.format.ISODateTimeFormat;
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
/*      */ public class BambooSessionImpl
/*      */   extends LoginBambooSession
/*      */   implements BambooSession
/*      */ {
/*      */   private final Logger loger;
/*      */   private static final String LIST_PROJECT_ACTION = "/api/rest/listProjectNames.action";
/*      */   private static final String LIST_PLAN_ACTION = "/api/rest/listBuildNames.action";
/*      */   private static final String LATEST_BUILD_FOR_PLAN_ACTION = "/api/rest/getLatestBuildResults.action";
/*      */   private static final String LATEST_BUILD_FOR_PLAN = "/rest/api/latest/result/";
/*      */   private static final String PLAN_STATE = "/rest/api/latest/plan/";
/*      */   private static final String GET_BUILD_ACTION = "/rest/api/latest/build/";
/*      */   private static final String GET_BUILD_DETAILS = "/rest/api/latest/result/";
/*      */   private static final String GET_ISSUES_SUFFIX = "?expand=jiraIssues";
/*      */   private static final String BUILD_QUEUE_SERVICE = "/rest/api/latest/queue/";
/*      */   private static final String RECENT_BUILDS_FOR_PLAN_ACTION = "/api/rest/getRecentlyCompletedBuildResultsForBuild.action";
/*      */   private static final String RECENT_BUILDS_FOR_USER_ACTION = "/api/rest/getLatestBuildsByUser.action";
/*      */   private static final String LATEST_USER_BUILDS_ACTION = "/api/rest/getLatestUserBuilds.action";
/*      */   private static final String GET_BUILD_DETAILS_ACTION = "/api/rest/getBuildResultsDetails.action";
/*      */   private static final String ADD_LABEL_ACTION = "/api/rest/addLabelToBuildResults.action";
/*      */   private static final String ADD_COMMENT_ACTION = "/api/rest/addCommentToBuildResults.action";
/*      */   private static final String EXECUTE_BUILD_ACTION = "/api/rest/executeBuild.action";
/*      */   private static final String GET_BAMBOO_BUILD_NUMBER_ACTION = "/api/rest/getBambooBuildNumber.action";
/*      */   private static final String GET_BUILD_BY_NUMBER_ACTION = "/rest/api/latest/build";
/*      */   private static final String BUILD_NUMBER_INFO = "/rest/api/latest/info";
/*      */   private static final String LIST_PLANS = "/rest/api/latest/plan?expand=plans&max-results=5000";
/*      */   private static final String BUILD_COMPLETED_DATE_ELEM = "buildCompletedDate";
/*      */   private static final String BUILD_SUCCESSFUL = "Successful";
/*      */   private static final String BUILD_FAILED = "Failed";
/*      */   private final ConnectionCfg serverData;
/*      */   private static final int BAMBOO_23_BUILD_NUMBER = 1308;
/*      */   private static final int BAMBOO_2_6_BUILD_NUMBER = 1839;
/*      */   private static final int BAMBOO_2_6_3_BUILD_NUMBER = 1904;
/*      */   private static final int BAMBOO_2_7_2_BUILD_NUMBER = 2101;
/*      */   private static final int BAMBOO_4_0_BUILD_NUMBER = 2906;
/*      */   private static final int BAMBOO_5_0_BUILD_NUMBER = 3600;
/*      */   private static final String CANNOT_PARSE_BUILD_TIME = "Cannot parse buildTime.";
/*      */   private static final String INVALID_SERVER_RESPONSE = "Invalid server response";
/*      */   private Integer serverBuildNumber;
/*      */   
/*      */   public BambooSessionImpl(ConnectionCfg serverData, HttpSessionCallback callback, Logger logger) throws RemoteApiMalformedUrlException {
/*  152 */     super(serverData, callback);
/*  153 */     this.serverData = serverData;
/*  154 */     this.loger = logger;
/*      */   }
/*      */   
/*      */   private int getBamboBuildNumberImpl() throws RemoteApiException {
/*  158 */     String queryUrl = String.valueOf(getBaseUrl()) + "/api/rest/getBambooBuildNumber.action" + "?auth=" + UrlUtil.encodeUrl(this.authToken);
/*      */     
/*      */     try {
/*  161 */       Document doc = retrieveGetResponse(queryUrl);
/*      */       
/*  163 */       String exception = getExceptionMessages(doc);
/*  164 */       if (exception != null)
/*      */       {
/*  166 */         return -1;
/*      */       }
/*      */       
/*  169 */       XPath xpath = XPath.newInstance("/response/bambooBuildNumber");
/*  170 */       Element element = (Element)xpath.selectSingleNode(doc);
/*  171 */       if (element != null) {
/*  172 */         String bNo = element.getText();
/*  173 */         return Integer.parseInt(bNo);
/*      */       } 
/*  175 */       return -1;
/*  176 */     } catch (JDOMException e) {
/*  177 */       throw new RemoteApiException("Server returned malformed response", e);
/*  178 */     } catch (IOException e) {
/*  179 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/*      */   }
/*      */   
/*      */   private int getBamboBuildNumberImplNew() throws RemoteApiException {
/*  184 */     String queryUrl = String.valueOf(getBaseUrl()) + "/rest/api/latest/info" + "?auth=" + UrlUtil.encodeUrl(this.authToken);
/*      */     
/*      */     try {
/*  187 */       Document doc = retrieveGetResponse(queryUrl);
/*      */       
/*  189 */       String exception = getExceptionMessages(doc);
/*  190 */       if (exception != null)
/*      */       {
/*  192 */         return -1;
/*      */       }
/*      */ 
/*      */       
/*  196 */       XPath xpath = XPath.newInstance("/info/buildNumber");
/*  197 */       Element element = (Element)xpath.selectSingleNode(doc);
/*  198 */       if (element != null) {
/*  199 */         String bNo = element.getText();
/*  200 */         return Integer.parseInt(bNo);
/*      */       } 
/*  202 */       return -1;
/*  203 */     } catch (JDOMException e) {
/*  204 */       throw new RemoteApiException("Server returned malformed response", e);
/*  205 */     } catch (IOException e) {
/*  206 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   public List<BambooProject> listProjectNames() throws RemoteApiException {
/*  212 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/api/rest/listProjectNames.action" + "?auth=" + UrlUtil.encodeUrl(this.authToken);
/*      */     
/*  214 */     List<BambooProject> projects = new ArrayList<BambooProject>();
/*      */     try {
/*  216 */       Document doc = retrieveGetResponse(buildResultUrl);
/*  217 */       XPath xpath = XPath.newInstance("/response/project");
/*      */       
/*  219 */       List<Element> elements = xpath.selectNodes(doc);
/*  220 */       if (elements != null) {
/*  221 */         for (Element element : elements) {
/*  222 */           String name = element.getChild("name").getText();
/*  223 */           String key = element.getChild("key").getText();
/*  224 */           projects.add(new BambooProjectInfo(name, key));
/*      */         } 
/*      */       }
/*  227 */     } catch (JDOMException e) {
/*  228 */       throw new RemoteApiException("Server returned malformed response", e);
/*  229 */     } catch (IOException e) {
/*  230 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/*      */     
/*  233 */     return projects;
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   private List<BambooPlan> listPlanNames() throws RemoteApiException {
/*  238 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/api/rest/listBuildNames.action" + "?auth=" + UrlUtil.encodeUrl(this.authToken);
/*      */     
/*  240 */     List<BambooPlan> plans = new ArrayList<BambooPlan>();
/*      */     try {
/*  242 */       Document doc = retrieveGetResponse(buildResultUrl);
/*  243 */       XPath xpath = XPath.newInstance("/response/build");
/*      */       
/*  245 */       List<Element> elements = xpath.selectNodes(doc);
/*  246 */       if (elements != null) {
/*  247 */         for (Element element : elements) {
/*  248 */           String enabledValue = element.getAttributeValue("enabled");
/*  249 */           boolean enabled = true;
/*  250 */           if (enabledValue != null) {
/*  251 */             enabled = Boolean.parseBoolean(enabledValue);
/*      */           }
/*  253 */           String name = element.getChild("name").getText();
/*  254 */           String key = element.getChild("key").getText();
/*  255 */           BambooPlan plan = new BambooPlan(name, key, null, enabled);
/*  256 */           plans.add(plan);
/*      */         } 
/*      */       }
/*  259 */     } catch (JDOMException e) {
/*  260 */       throw new RemoteApiException("Server returned malformed response", e);
/*  261 */     } catch (IOException e) {
/*  262 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/*      */     
/*  265 */     return plans;
/*      */   }
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   private List<BambooPlan> listPlanNames_40() throws RemoteApiException {
/*  271 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/rest/api/latest/plan?expand=plans&max-results=5000";
/*      */     
/*  273 */     List<BambooPlan> plans = new ArrayList<BambooPlan>();
/*      */     try {
/*  275 */       Document doc = retrieveGetResponse(buildResultUrl);
/*      */       
/*  277 */       XPath xpath = XPath.newInstance("/plans/plans/plan");
/*      */       
/*  279 */       List<Element> elements = xpath.selectNodes(doc);
/*  280 */       if (elements != null) {
/*  281 */         for (Element element : elements) {
/*  282 */           String enabledValue = element.getAttributeValue("enabled");
/*  283 */           boolean enabled = true;
/*  284 */           if (enabledValue != null) {
/*  285 */             enabled = Boolean.parseBoolean(enabledValue);
/*      */           }
/*  287 */           String name = element.getAttributeValue("name");
/*      */ 
/*      */           
/*  290 */           String key = element.getAttributeValue("key");
/*  291 */           BambooPlan plan = new BambooPlan(name, key, null, enabled);
/*  292 */           plans.add(plan);
/*      */         } 
/*      */       }
/*  295 */     } catch (JDOMException e) {
/*  296 */       throw new RemoteApiException("Server returned malformed response", e);
/*  297 */     } catch (IOException e) {
/*  298 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/*      */     
/*  301 */     return plans;
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
/*      */   @NotNull
/*      */   public BambooBuild getLatestBuildForPlan(@NotNull String planKey, int timezoneOffset) throws RemoteApiException {
/*  316 */     List<BambooPlan> planList = listPlanNames();
/*  317 */     Boolean isEnabled = isPlanEnabled(planList, planKey);
/*  318 */     return getLatestBuildForPlan(planKey, (isEnabled != null) ? isEnabled.booleanValue() : true, timezoneOffset);
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public static Boolean isPlanEnabled(@NotNull Collection<BambooPlan> allPlans, @NotNull String planKey) {
/*  323 */     for (BambooPlan bambooPlan : allPlans) {
/*  324 */       if (planKey.equals(bambooPlan.getKey())) {
/*  325 */         return Boolean.valueOf(bambooPlan.isEnabled());
/*      */       }
/*      */     } 
/*  328 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public BambooBuild getLatestBuildForPlan(@NotNull String planKey, boolean isPlanEnabled, int timezoneOffset) throws RemoteApiException {
/*  334 */     return (BambooBuild)getLatestBuildBuilderForPlan(planKey, timezoneOffset).enabled(isPlanEnabled).build();
/*      */   }
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public BambooBuildInfo.Builder getLatestBuildBuilderForPlan(@NotNull String planKey, int timezoneOffset) throws RemoteApiException {
/*  340 */     String buildResultUrl = 
/*  341 */       String.valueOf(getBaseUrl()) + "/api/rest/getLatestBuildResults.action" + "?auth=" + UrlUtil.encodeUrl(this.authToken) + "&buildKey=" + 
/*  342 */       UrlUtil.encodeUrl(planKey);
/*      */     
/*      */     try {
/*  345 */       Document doc = retrieveGetResponse(buildResultUrl);
/*  346 */       String exception = getExceptionMessages(doc);
/*  347 */       if (exception != null) {
/*  348 */         return constructBuildErrorInfo(planKey, exception, new Date());
/*      */       }
/*      */ 
/*      */       
/*  352 */       List<Element> elements = XPath.newInstance("/response").selectNodes(doc);
/*  353 */       if (elements != null && !elements.isEmpty()) {
/*  354 */         Element e = elements.iterator().next();
/*  355 */         Set<String> commiters = constructBuildCommiters(e);
/*  356 */         return constructBuilderItem(e, new Date(), planKey, commiters, timezoneOffset);
/*      */       } 
/*  358 */       return constructBuildErrorInfo(planKey, "Malformed server reply: no response element", new Date());
/*      */     }
/*  360 */     catch (IOException e) {
/*  361 */       return constructBuildErrorInfo(planKey, e.getMessage(), e, new Date());
/*  362 */     } catch (JDOMException e) {
/*  363 */       return constructBuildErrorInfo(planKey, "Server returned malformed response", (Throwable)e, new Date());
/*  364 */     } catch (RemoteApiException e) {
/*  365 */       return constructBuildErrorInfo(planKey, e.getMessage(), (Throwable)e, new Date());
/*      */     } 
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
/*      */   @NotNull
/*      */   public BambooBuildInfo.Builder getLatestBuildBuilderForPlan_40(@NotNull String planKey, int timezoneOffset) throws RemoteApiException {
/*  379 */     String buildResultUrl = 
/*  380 */       String.valueOf(getBaseUrl()) + "/rest/api/latest/result/" + UrlUtil.encodeUrl(planKey) + "?expand=" + 
/*  381 */       UrlUtil.encodeUrl("results[0].result");
/*      */     
/*      */     try {
/*  384 */       Document doc = retrieveGetResponse(buildResultUrl);
/*  385 */       String exception = getExceptionMessages(doc);
/*  386 */       if (exception != null) {
/*  387 */         return constructBuildErrorInfo(planKey, exception, new Date());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  392 */       List<Element> elements = XPath.newInstance("/results/results/result").selectNodes(doc);
/*  393 */       if (elements != null && !elements.isEmpty()) {
/*  394 */         Element e = elements.iterator().next();
/*      */         
/*  396 */         String buildNumber = e.getAttributeValue("number");
/*  397 */         Set<String> commiters = getCommitersForBuild_40(planKey, buildNumber);
/*  398 */         return constructBuilderItem_40(e, new Date(), planKey, commiters, timezoneOffset);
/*      */       } 
/*      */       
/*  401 */       elements = XPath.newInstance("/results/results").selectNodes(doc);
/*  402 */       if (elements != null && !elements.isEmpty()) {
/*  403 */         Element e = elements.iterator().next();
/*      */         
/*  405 */         String size = e.getAttributeValue("size");
/*  406 */         if (size != null && size.length() > 0 && "0".equals(size)) {
/*  407 */           return (new BambooBuildInfo.Builder(planKey, this.serverData, BuildStatus.UNKNOWN)).pollingTime(
/*  408 */               new Date()).reason("Never built");
/*      */         }
/*      */       } 
/*      */       
/*  412 */       return constructBuildErrorInfo(planKey, "Malformed server reply: no response element", new Date());
/*      */     
/*      */     }
/*  415 */     catch (IOException e) {
/*  416 */       return constructBuildErrorInfo(planKey, e.getMessage(), e, new Date());
/*  417 */     } catch (JDOMException e) {
/*  418 */       return constructBuildErrorInfo(planKey, "Server returned malformed response", (Throwable)e, new Date());
/*  419 */     } catch (RemoteApiException e) {
/*  420 */       return constructBuildErrorInfo(planKey, e.getMessage(), (Throwable)e, new Date());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> getCommitersForBuild_40(@NotNull String planKey, @NotNull String buildNumber) throws RemoteApiException {
/*  427 */     String buildResultUrl = 
/*  428 */       String.valueOf(getBaseUrl()) + "/rest/api/latest/result/" + UrlUtil.encodeUrl(planKey) + "/" + buildNumber + "?expand=changes";
/*      */     
/*  430 */     Set<String> commiters = new HashSet<String>();
/*      */     
/*      */     try {
/*  433 */       Document doc = retrieveGetResponse(buildResultUrl);
/*      */       
/*  435 */       List<Element> elements = XPath.newInstance("/result/changes/change").selectNodes(doc);
/*      */       
/*  437 */       if (!elements.isEmpty()) {
/*  438 */         for (Element commiter : elements) {
/*  439 */           commiters.add(commiter.getAttributeValue("author"));
/*      */         }
/*      */       }
/*  442 */       return commiters;
/*  443 */     } catch (JDOMException e) {
/*  444 */       throw new RemoteApiException("Server returned malformed response", e);
/*  445 */     } catch (IOException e) {
/*  446 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   public BambooPlan getPlanDetails(@NotNull String planKey) throws RemoteApiException {
/*  452 */     String planUrl = String.valueOf(getBaseUrl()) + "/rest/api/latest/plan/" + UrlUtil.encodeUrl(planKey);
/*      */     
/*      */     try {
/*  455 */       Document doc = retrieveGetResponse(planUrl);
/*      */       
/*  457 */       List<Element> elements = XPath.newInstance("/plan").selectNodes(doc);
/*  458 */       if (elements != null && !elements.isEmpty()) {
/*  459 */         Element e = elements.iterator().next();
/*  460 */         return constructPlanItem(e, Boolean.TRUE.booleanValue());
/*      */       } 
/*  462 */       throw new RemoteApiException("Malformed server reply: no 'plan' element");
/*      */     }
/*  464 */     catch (JDOMException e) {
/*  465 */       throw new RemoteApiException("Server returned malformed response", e);
/*  466 */     } catch (IOException e) {
/*  467 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
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
/*      */   @NotNull
/*      */   public BambooBuild getLatestBuildForPlanNew(@NotNull String planKey, @Nullable String masterPlanKey, boolean isPlanEnabled, int timezoneOffset) throws RemoteApiException {
/*  484 */     String planUrl = String.valueOf(getBaseUrl()) + "/rest/api/latest/plan/" + UrlUtil.encodeUrl(planKey);
/*      */     
/*      */     try {
/*  487 */       Document doc = retrieveGetResponse(planUrl);
/*      */ 
/*      */       
/*  490 */       List<Element> elements = XPath.newInstance("/plan").selectNodes(doc);
/*  491 */       if (elements != null && !elements.isEmpty()) {
/*  492 */         BambooBuildInfo.Builder latestBuildBuilderForPlan; Element e = elements.iterator().next();
/*  493 */         BambooPlan plan = constructPlanItem(e, isPlanEnabled);
/*      */ 
/*      */ 
/*      */         
/*  497 */         if (getBamboBuildNumber() >= 2906) {
/*  498 */           latestBuildBuilderForPlan = getLatestBuildBuilderForPlan_40(planKey, timezoneOffset);
/*      */         } else {
/*  500 */           latestBuildBuilderForPlan = getLatestBuildBuilderForPlan(planKey, timezoneOffset);
/*      */         } 
/*  502 */         latestBuildBuilderForPlan.planState(plan.getState());
/*  503 */         latestBuildBuilderForPlan.enabled(isPlanEnabled);
/*  504 */         latestBuildBuilderForPlan.masterPlanKey(masterPlanKey);
/*  505 */         return (BambooBuild)latestBuildBuilderForPlan.build();
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  515 */       return (BambooBuild)constructBuildErrorInfo(planKey, "Malformed server reply: no 'plan' element", new Date()).build();
/*      */     }
/*  517 */     catch (IOException e) {
/*  518 */       return (BambooBuild)constructBuildErrorInfo(planKey, e.getMessage(), e, new Date()).build();
/*  519 */     } catch (JDOMException e) {
/*  520 */       return (BambooBuild)constructBuildErrorInfo(planKey, "Server returned malformed response", (Throwable)e, new Date()).build();
/*  521 */     } catch (RemoteApiException e) {
/*  522 */       return (BambooBuild)constructBuildErrorInfo(planKey, e.getMessage(), (Throwable)e, new Date()).build();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public BambooBuild getBuildForPlanAndNumber(@NotNull String planKey, int buildNumber, int timezoneOffset) throws RemoteApiException {
/*      */     String buildResultUrl, nodePath;
/*  531 */     Collection<BambooBuild> recentBuilds = getRecentBuildsForPlan(planKey, timezoneOffset);
/*      */     try {
/*  533 */       for (BambooBuild recentBuild : recentBuilds) {
/*  534 */         if (recentBuild.getNumber() == buildNumber) {
/*  535 */           return recentBuild;
/*      */         }
/*      */       } 
/*  538 */     } catch (UnsupportedOperationException unsupportedOperationException) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  543 */     int bambooBuild = getBamboBuildNumber();
/*  544 */     if (bambooBuild < 1308) {
/*  545 */       throw new RemoteApiBadServerVersionException("Bamboo version 2.3 or newer required");
/*      */     }
/*      */ 
/*      */     
/*  549 */     if (bambooBuild < 1904) {
/*  550 */       buildResultUrl = String.valueOf(getBaseUrl()) + 
/*  551 */         "/rest/api/latest/build" + "/" + UrlUtil.encodeUrl(planKey) + 
/*  552 */         "/" + buildNumber + "?auth=" + UrlUtil.encodeUrl(this.authToken);
/*  553 */       nodePath = "/build";
/*      */     } else {
/*  555 */       buildResultUrl = String.valueOf(getBaseUrl()) + 
/*  556 */         "/rest/api/latest/result/" + UrlUtil.encodeUrl(planKey) + "-" + buildNumber;
/*  557 */       nodePath = "/result";
/*      */     } 
/*      */     
/*      */     try {
/*  561 */       Document doc = retrieveGetResponse(buildResultUrl);
/*  562 */       String exception = getExceptionMessages(doc);
/*  563 */       if (exception != null) {
/*  564 */         return (BambooBuild)constructBuildErrorInfo(buildResultUrl, exception, new Date()).build();
/*      */       }
/*      */ 
/*      */       
/*  568 */       List<Element> elements = XPath.newInstance(nodePath).selectNodes(doc);
/*  569 */       Element el = elements.get(0);
/*  570 */       return constructBuildItemFromNewApi(el, new Date(), planKey);
/*      */     }
/*  572 */     catch (IOException e) {
/*  573 */       throw new RemoteApiException(e);
/*  574 */     } catch (JDOMException e) {
/*  575 */       throw new RemoteApiException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Collection<BambooBuild> getRecentBuildsForPlan(@NotNull String planKey, int timezoneOffset) throws RemoteApiException {
/*  581 */     if (getBamboBuildNumber() >= 2906) {
/*  582 */       return getBuildsCollection_40(planKey, timezoneOffset);
/*      */     }
/*  584 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/api/rest/getRecentlyCompletedBuildResultsForBuild.action" + "?auth=" + UrlUtil.encodeUrl(this.authToken) + 
/*  585 */       "&buildKey=" + UrlUtil.encodeUrl(planKey);
/*  586 */     return getBuildsCollection(buildResultUrl, planKey, timezoneOffset);
/*      */   }
/*      */ 
/*      */   
/*      */   public Collection<BambooBuild> getRecentBuildsForUser(int timezoneOffset) throws RemoteApiException {
/*  591 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/api/rest/getLatestBuildsByUser.action" + "?auth=" + UrlUtil.encodeUrl(this.authToken) + 
/*  592 */       "&username=" + UrlUtil.encodeUrl(getUsername());
/*  593 */     return getBuildsCollection(buildResultUrl, getUsername(), timezoneOffset);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private Collection<BambooBuild> getBuildsCollection(@NotNull String url, @NotNull String planKey, int timezoneOffset) throws RemoteApiException {
/*  599 */     Date pollingTime = new Date();
/*  600 */     List<BambooBuild> builds = new ArrayList<BambooBuild>();
/*      */     try {
/*  602 */       Document doc = retrieveGetResponse(url);
/*  603 */       String exception = getExceptionMessages(doc);
/*  604 */       if (exception != null) {
/*  605 */         builds.add(constructBuildErrorInfo(url, exception, new Date()).build());
/*  606 */         return builds;
/*      */       } 
/*      */ 
/*      */       
/*  610 */       List<Element> elements = XPath.newInstance("/response/build").selectNodes(doc);
/*  611 */       if (elements == null || elements.isEmpty()) {
/*  612 */         builds.add(constructBuildErrorInfo(url, "Malformed server reply: no response element", new Date()).build());
/*      */       } else {
/*  614 */         for (Element element : elements) {
/*  615 */           Set<String> commiters = constructBuildCommiters(element);
/*  616 */           builds.add(constructBuilderItem(element, pollingTime, planKey, commiters, timezoneOffset).enabled(true)
/*  617 */               .build());
/*      */         } 
/*      */       } 
/*  620 */     } catch (IOException e) {
/*  621 */       builds.add(constructBuildErrorInfo(planKey, e.getMessage(), e, pollingTime).build());
/*  622 */     } catch (JDOMException e) {
/*  623 */       builds.add(constructBuildErrorInfo(planKey, "Server returned malformed response", (Throwable)e, pollingTime).build());
/*  624 */     } catch (RemoteApiException e) {
/*  625 */       builds.add(constructBuildErrorInfo(planKey, e.getMessage(), (Throwable)e, pollingTime).build());
/*      */     } 
/*  627 */     return builds;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private Collection<BambooBuild> getBuildsCollection_40(@NotNull String planKey, int timezoneOffset) throws RemoteApiException {
/*  633 */     String url = String.valueOf(getBaseUrl()) + "/rest/api/latest/result/" + UrlUtil.encodeUrl(planKey) + "?expand=" + 
/*  634 */       UrlUtil.encodeUrl("results[0:10].result");
/*      */     
/*  636 */     Date pollingTime = new Date();
/*  637 */     List<BambooBuild> builds = new ArrayList<BambooBuild>();
/*      */     
/*      */     try {
/*  640 */       Document doc = retrieveGetResponse(url);
/*      */       
/*  642 */       String exception = getExceptionMessages(doc);
/*  643 */       if (exception != null) {
/*  644 */         builds.add(constructBuildErrorInfo(url, exception, new Date()).build());
/*  645 */         return builds;
/*      */       } 
/*      */       
/*  648 */       List<Element> elements = XPath.newInstance("/results/results/result").selectNodes(doc);
/*  649 */       if (elements == null || elements.isEmpty()) {
/*  650 */         builds.add(constructBuildErrorInfo(url, "Malformed server reply: no response element", new Date()).build());
/*      */       } else {
/*  652 */         for (Element element : elements) {
/*  653 */           Set<String> commiters = constructBuildCommiters(element);
/*  654 */           builds.add(constructBuilderItem_40(element, pollingTime, planKey, commiters, timezoneOffset).enabled(true)
/*  655 */               .build());
/*      */         } 
/*      */       } 
/*  658 */     } catch (IOException e) {
/*  659 */       builds.add(constructBuildErrorInfo(planKey, e.getMessage(), e, pollingTime).build());
/*  660 */     } catch (JDOMException e) {
/*  661 */       builds.add(constructBuildErrorInfo(planKey, "Server returned malformed response", (Throwable)e, pollingTime).build());
/*  662 */     } catch (RemoteApiException e) {
/*  663 */       builds.add(constructBuildErrorInfo(planKey, e.getMessage(), (Throwable)e, pollingTime).build());
/*      */     } 
/*  665 */     return builds;
/*      */   }
/*      */ 
/*      */   
/*      */   private Set<String> constructBuildCommiters(Element element) throws JDOMException {
/*  670 */     Set<String> commiters = new HashSet<String>();
/*      */     
/*  672 */     List<Element> commitElements = XPath.newInstance("commits/commit").selectNodes(element);
/*  673 */     if (!commitElements.isEmpty()) {
/*  674 */       for (Element commiter : commitElements) {
/*  675 */         commiters.add(commiter.getAttributeValue("author"));
/*      */       }
/*      */     }
/*  678 */     return commiters;
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   public List<String> getFavouriteUserPlans() throws RemoteApiException {
/*  683 */     List<String> builds = new ArrayList<String>();
/*  684 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/api/rest/getLatestUserBuilds.action" + "?auth=" + UrlUtil.encodeUrl(this.authToken);
/*      */     
/*      */     try {
/*  687 */       Document doc = retrieveGetResponse(buildResultUrl);
/*  688 */       String exception = getExceptionMessages(doc);
/*  689 */       if (exception != null) {
/*  690 */         return builds;
/*      */       }
/*      */       
/*  693 */       XPath xpath = XPath.newInstance("/response/build");
/*      */       
/*  695 */       List<Element> elements = xpath.selectNodes(doc);
/*  696 */       if (elements != null) {
/*  697 */         for (Element element : elements) {
/*  698 */           builds.add(element.getChildText("key"));
/*      */         }
/*  700 */         return builds;
/*      */       } 
/*  702 */       return builds;
/*      */     }
/*  704 */     catch (IOException iOException) {
/*  705 */       return builds;
/*  706 */     } catch (JDOMException jDOMException) {
/*  707 */       return builds;
/*      */     } 
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   public List<String> getFavouriteUserPlansNew() throws RemoteApiException {
/*  713 */     List<String> builds = new ArrayList<String>();
/*  714 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/rest/api/latest/plan/" + "?favourite&expand=plans";
/*      */     
/*      */     try {
/*  717 */       Document doc = retrieveGetResponse(buildResultUrl);
/*  718 */       String exception = getExceptionMessages(doc);
/*  719 */       if (exception != null) {
/*  720 */         return builds;
/*      */       }
/*      */       
/*  723 */       XPath xpath = XPath.newInstance("/plans/plans/plan");
/*      */       
/*  725 */       List<Element> elements = xpath.selectNodes(doc);
/*  726 */       if (elements != null) {
/*  727 */         for (Element element : elements) {
/*  728 */           builds.add(element.getAttributeValue("key"));
/*      */         }
/*  730 */         return builds;
/*      */       } 
/*  732 */       return builds;
/*      */     }
/*  734 */     catch (IOException iOException) {
/*  735 */       return builds;
/*  736 */     } catch (JDOMException jDOMException) {
/*  737 */       return builds;
/*      */     } 
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   private BuildDetails getBuildResultDetailsOld(@NotNull String planKey, int buildNumber) throws RemoteApiException {
/*  743 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/api/rest/getBuildResultsDetails.action" + "?auth=" + UrlUtil.encodeUrl(this.authToken) + 
/*  744 */       "&buildKey=" + UrlUtil.encodeUrl(planKey) + "&buildNumber=" + buildNumber;
/*      */     
/*      */     try {
/*  747 */       BuildDetailsInfo build = new BuildDetailsInfo();
/*  748 */       Document doc = retrieveGetResponse(buildResultUrl);
/*  749 */       String exception = getExceptionMessages(doc);
/*  750 */       if (exception != null) {
/*  751 */         throw new RemoteApiException(exception);
/*      */       }
/*      */ 
/*      */       
/*  755 */       List<Element> responseElements = XPath.newInstance("/response").selectNodes(doc);
/*  756 */       for (Element element : responseElements) {
/*  757 */         String vcsRevisionKey = element.getAttributeValue("vcsRevisionKey");
/*  758 */         if (vcsRevisionKey != null) {
/*  759 */           build.setVcsRevisionKey(vcsRevisionKey);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  764 */       List<Element> commitElements = XPath.newInstance("/response/commits/commit").selectNodes(doc);
/*  765 */       if (!commitElements.isEmpty()) {
/*  766 */         int i = 1;
/*  767 */         for (Element element : commitElements) {
/*  768 */           BambooChangeSetImpl cInfo = new BambooChangeSetImpl();
/*  769 */           cInfo.setAuthor(element.getAttributeValue("author"));
/*  770 */           cInfo.setCommitDate(parseCommitTime(element.getAttributeValue("date")));
/*  771 */           cInfo.setComment(getChildText(element, "comment"));
/*      */           
/*  773 */           String path = "/response/commits/commit[" + i++ + "]/files/file";
/*  774 */           XPath filesPath = XPath.newInstance(path);
/*      */           
/*  776 */           List<Element> fileElements = filesPath.selectNodes(doc);
/*  777 */           for (Element file : fileElements) {
/*  778 */             BambooFileInfo fileInfo = new BambooFileInfo(file.getAttributeValue("name"), 
/*  779 */                 file.getAttributeValue("revision"));
/*  780 */             cInfo.addCommitFile(fileInfo);
/*      */           } 
/*  782 */           build.addCommitInfo(cInfo);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  787 */       List<Element> sucTestResElements = XPath.newInstance("/response/successfulTests/testResult")
/*  788 */         .selectNodes(doc);
/*  789 */       for (Element element : sucTestResElements) {
/*  790 */         double duration; TestDetailsInfo tInfo = new TestDetailsInfo();
/*  791 */         tInfo.setTestClassName(element.getAttributeValue("testClass"));
/*  792 */         tInfo.setTestMethodName(element.getAttributeValue("testMethod"));
/*      */         
/*      */         try {
/*  795 */           duration = Double.valueOf(element.getAttributeValue("duration")).doubleValue();
/*  796 */         } catch (NumberFormatException numberFormatException) {
/*      */           
/*  798 */           duration = 0.0D;
/*      */         } 
/*  800 */         tInfo.setTestDuration(duration);
/*  801 */         tInfo.setTestResult(TestResult.TEST_SUCCEED);
/*  802 */         build.addSuccessfulTest((TestDetails)tInfo);
/*      */       } 
/*      */ 
/*      */       
/*  806 */       List<Element> failedTestResElements = XPath.newInstance("/response/failedTests/testResult")
/*  807 */         .selectNodes(doc);
/*  808 */       if (!failedTestResElements.isEmpty()) {
/*  809 */         int i = 1;
/*  810 */         for (Element element : failedTestResElements) {
/*  811 */           double duration; TestDetailsInfo tInfo = new TestDetailsInfo();
/*  812 */           tInfo.setTestClassName(element.getAttributeValue("testClass"));
/*  813 */           tInfo.setTestMethodName(element.getAttributeValue("testMethod"));
/*      */           
/*      */           try {
/*  816 */             duration = Double.valueOf(element.getAttributeValue("duration")).doubleValue();
/*  817 */           } catch (NumberFormatException numberFormatException) {
/*      */             
/*  819 */             duration = 0.0D;
/*      */           } 
/*  821 */           tInfo.setTestDuration(duration);
/*  822 */           tInfo.setTestResult(TestResult.TEST_FAILED);
/*      */           
/*  824 */           String path = "/response/failedTests/testResult[" + i++ + "]/errors/error";
/*  825 */           XPath errorPath = XPath.newInstance(path);
/*      */           
/*  827 */           List<Element> errorElements = errorPath.selectNodes(doc);
/*  828 */           for (Element error : errorElements) {
/*  829 */             tInfo.setTestErrors(error.getText());
/*      */           }
/*  831 */           build.addFailedTest((TestDetails)tInfo);
/*      */         } 
/*      */       } 
/*      */       
/*  835 */       return (BuildDetails)build;
/*  836 */     } catch (JDOMException e) {
/*  837 */       throw new RemoteApiException("Server returned malformed response", e);
/*  838 */     } catch (IOException e) {
/*  839 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
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
/*      */   public int getBamboBuildNumber() throws RemoteApiException {
/*  856 */     if (this.serverBuildNumber != null) {
/*  857 */       return this.serverBuildNumber.intValue();
/*      */     }
/*      */     
/*      */     try {
/*  861 */       this.serverBuildNumber = Integer.valueOf(getBamboBuildNumberImpl());
/*  862 */     } catch (RemoteApiException remoteApiException) {
/*  863 */       this.loger.info("Old Bamboo API is not available. Server error or Bamboo 4.0+ detected.");
/*  864 */       this.serverBuildNumber = Integer.valueOf(getBamboBuildNumberImplNew());
/*      */     } 
/*  866 */     return this.serverBuildNumber.intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BuildDetails getBuildResultDetails(@NotNull String planKey, int buildNumber) throws RemoteApiException {
/*  873 */     int bamboBuildNumber = getBamboBuildNumber();
/*  874 */     if (bamboBuildNumber >= 1839 && bamboBuildNumber <= 1904)
/*  875 */       return getBuildResultDetailsMoreRestish(planKey, buildNumber); 
/*  876 */     if (bamboBuildNumber > 1904 && bamboBuildNumber <= 2101)
/*  877 */       return getBuildResultDetailsNew(planKey, buildNumber); 
/*  878 */     if (bamboBuildNumber > 2101) {
/*  879 */       return getBuildResultDetails3x(planKey, buildNumber);
/*      */     }
/*  881 */     return getBuildResultDetailsOld(planKey, buildNumber);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BuildDetails getBuildResultDetails3x(String planKey, int buildNumber) throws RemoteApiException {
/*  888 */     List<BambooJobImpl> jobs = getJobsForPlan(planKey);
/*      */     
/*  890 */     BuildDetailsInfo build = new BuildDetailsInfo();
/*      */     
/*  892 */     for (BambooJobImpl job : jobs) {
/*      */       
/*  894 */       build.addJob((BambooJob)job);
/*      */       
/*  896 */       if (!job.isEnabled()) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/*  901 */       String url = getBaseUrl() + 
/*  902 */         "/rest/api/latest/result/" + 
/*  903 */         job.getKey() + 
/*  904 */         "-" + 
/*  905 */         buildNumber + 
/*  906 */         "?" + 
/*  907 */         "expand=testResults.allTests.testResult.errors";
/*      */       
/*      */       try {
/*  910 */         Document doc = retrieveGetResponse(url);
/*  911 */         String exception = getExceptionMessages(doc);
/*  912 */         if (exception != null) {
/*  913 */           throw new RemoteApiException(exception);
/*      */         }
/*      */ 
/*      */         
/*  917 */         List<Element> testResElements = XPath.newInstance("/result/testResults/allTests/testResult")
/*  918 */           .selectNodes(doc);
/*  919 */         for (Element element : testResElements) {
/*  920 */           TestDetailsInfo tInfo = new TestDetailsInfo();
/*  921 */           tInfo.setTestClassName(element.getAttributeValue("className"));
/*  922 */           tInfo.setTestMethodName(element.getAttributeValue("methodName"));
/*      */           try {
/*  924 */             tInfo.setTestResult(parseTestResult(element.getAttributeValue("status")));
/*  925 */           } catch (ParseException e1) {
/*  926 */             this.loger.warn("Cannot parse test result element:\n" + XmlUtil.toPrettyFormatedString(element), e1);
/*      */             continue;
/*      */           } 
/*  929 */           tInfo.setTestDuration(parseDuration(element.getChild("duration")));
/*      */           
/*  931 */           StringBuilder errorBuilder = new StringBuilder();
/*  932 */           XPath errorPath = XPath.newInstance("errors/error");
/*      */           
/*  934 */           List<Element> errorElements = errorPath.selectNodes(element);
/*  935 */           for (Element errorElement : errorElements) {
/*  936 */             String errorEntry = errorElement.getChildText("message");
/*  937 */             if (errorEntry != null) {
/*  938 */               errorBuilder.append(errorEntry).append('\n');
/*      */             }
/*      */           } 
/*  941 */           tInfo.setTestErrors(errorBuilder.toString());
/*      */           
/*  943 */           switch (tInfo.getTestResult()) {
/*      */             case null:
/*  945 */               build.addFailedTest((TestDetails)tInfo);
/*  946 */               job.addFailedTest(tInfo);
/*      */             
/*      */             case TEST_SUCCEED:
/*  949 */               build.addSuccessfulTest((TestDetails)tInfo);
/*  950 */               job.addSuccessfulTest(tInfo);
/*      */           } 
/*      */ 
/*      */ 
/*      */         
/*      */         } 
/*  956 */         Element changesElement = doc.getRootElement().getChild("changes");
/*  957 */         if (changesElement != null) {
/*  958 */           build.setCommitInfo(parseChangeSets(changesElement));
/*      */         }
/*      */       }
/*  961 */       catch (JDOMException e) {
/*  962 */         throw new RemoteApiException("Server returned malformed response", e);
/*  963 */       } catch (IOException e) {
/*  964 */         throw new RemoteApiException(e.getMessage(), e);
/*  965 */       } catch (ParseException e) {
/*  966 */         throw new RemoteApiException("Server returned malformed response", e);
/*      */       } 
/*      */     } 
/*      */     
/*  970 */     return (BuildDetails)build;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   private BuildDetails getBuildResultDetailsNew(@NotNull String planKey, int buildNumber) throws RemoteApiException {
/*  977 */     List<BambooJobImpl> jobs = getJobsForPlan(planKey);
/*      */     
/*  979 */     BuildDetailsInfo build = new BuildDetailsInfo();
/*      */     
/*  981 */     for (BambooJobImpl job : jobs) {
/*      */       
/*  983 */       build.addJob((BambooJob)job);
/*      */       
/*  985 */       if (!job.isEnabled()) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/*  990 */       String url = getBaseUrl() + 
/*  991 */         "/rest/api/latest/result/" + 
/*  992 */         job.getKey() + 
/*  993 */         "-" + 
/*  994 */         buildNumber + 
/*  995 */         "?" + 
/*  996 */         "expand=testResults.all.testResult.errors";
/*      */       
/*      */       try {
/*  999 */         Document doc = retrieveGetResponse(url);
/* 1000 */         String exception = getExceptionMessages(doc);
/* 1001 */         if (exception != null) {
/* 1002 */           throw new RemoteApiException(exception);
/*      */         }
/*      */ 
/*      */         
/* 1006 */         List<Element> testResElements = XPath.newInstance("/result/testResults/all/testResult")
/* 1007 */           .selectNodes(doc);
/* 1008 */         for (Element element : testResElements) {
/* 1009 */           TestDetailsInfo tInfo = new TestDetailsInfo();
/* 1010 */           tInfo.setTestClassName(element.getAttributeValue("className"));
/* 1011 */           tInfo.setTestMethodName(element.getAttributeValue("methodName"));
/*      */           try {
/* 1013 */             tInfo.setTestResult(parseTestResult(element.getAttributeValue("status")));
/* 1014 */           } catch (ParseException e1) {
/* 1015 */             this.loger.warn("Cannot parse test result element:\n" + XmlUtil.toPrettyFormatedString(element), e1);
/*      */             continue;
/*      */           } 
/* 1018 */           tInfo.setTestDuration(parseDuration(element.getChild("duration")));
/*      */           
/* 1020 */           StringBuilder errorBuilder = new StringBuilder();
/* 1021 */           XPath errorPath = XPath.newInstance("errors/error");
/*      */           
/* 1023 */           List<Element> errorElements = errorPath.selectNodes(element);
/* 1024 */           for (Element errorElement : errorElements) {
/* 1025 */             String errorEntry = errorElement.getChildText("message");
/* 1026 */             if (errorEntry != null) {
/* 1027 */               errorBuilder.append(errorEntry).append('\n');
/*      */             }
/*      */           } 
/* 1030 */           tInfo.setTestErrors(errorBuilder.toString());
/*      */           
/* 1032 */           switch (tInfo.getTestResult()) {
/*      */             case null:
/* 1034 */               build.addFailedTest((TestDetails)tInfo);
/* 1035 */               job.addFailedTest(tInfo);
/*      */             
/*      */             case TEST_SUCCEED:
/* 1038 */               build.addSuccessfulTest((TestDetails)tInfo);
/* 1039 */               job.addSuccessfulTest(tInfo);
/*      */           } 
/*      */ 
/*      */ 
/*      */         
/*      */         } 
/* 1045 */         Element changesElement = doc.getRootElement().getChild("changes");
/* 1046 */         if (changesElement != null) {
/* 1047 */           build.setCommitInfo(parseChangeSets(changesElement));
/*      */         }
/*      */       }
/* 1050 */       catch (JDOMException e) {
/* 1051 */         throw new RemoteApiException("Server returned malformed response", e);
/* 1052 */       } catch (IOException e) {
/* 1053 */         throw new RemoteApiException(e.getMessage(), e);
/* 1054 */       } catch (ParseException e) {
/* 1055 */         throw new RemoteApiException("Server returned malformed response", e);
/*      */       } 
/*      */     } 
/*      */     
/* 1059 */     return (BuildDetails)build;
/*      */   }
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   BuildDetails getBuildResultDetailsMoreRestish(@NotNull String planKey, int buildNumber) throws RemoteApiException {
/* 1065 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/rest/api/latest/build" + "/" + UrlUtil.encodeUrl(planKey) + 
/* 1066 */       "/" + buildNumber + "?auth=" + UrlUtil.encodeUrl(this.authToken) + 
/* 1067 */       "&expand=testResults.all.testResult.errors&expand=changes.change.files";
/*      */     
/*      */     try {
/* 1070 */       BuildDetailsInfo build = new BuildDetailsInfo();
/* 1071 */       Document doc = retrieveGetResponse(buildResultUrl);
/* 1072 */       String exception = getExceptionMessages(doc);
/* 1073 */       if (exception != null) {
/* 1074 */         throw new RemoteApiException(exception);
/*      */       }
/*      */ 
/*      */       
/* 1078 */       List<Element> testResElements = XPath.newInstance("/build/testResults/all/testResult")
/* 1079 */         .selectNodes(doc);
/* 1080 */       for (Element element : testResElements) {
/* 1081 */         TestDetailsInfo tInfo = new TestDetailsInfo();
/* 1082 */         tInfo.setTestClassName(element.getAttributeValue("className"));
/* 1083 */         tInfo.setTestMethodName(element.getAttributeValue("methodName"));
/*      */         try {
/* 1085 */           tInfo.setTestResult(parseTestResult(element.getAttributeValue("status")));
/* 1086 */         } catch (ParseException e1) {
/* 1087 */           this.loger.warn("Cannot parse test result element:\n" + XmlUtil.toPrettyFormatedString(element), e1);
/*      */           continue;
/*      */         } 
/* 1090 */         tInfo.setTestDuration(parseDuration(element.getChild("duration")));
/*      */         
/* 1092 */         StringBuilder errorBuilder = new StringBuilder();
/* 1093 */         XPath errorPath = XPath.newInstance("errors/error");
/*      */         
/* 1095 */         List<Element> errorElements = errorPath.selectNodes(element);
/* 1096 */         for (Element errorElement : errorElements) {
/* 1097 */           String errorEntry = errorElement.getChildText("message");
/* 1098 */           if (errorEntry != null) {
/* 1099 */             errorBuilder.append(errorEntry).append('\n');
/*      */           }
/*      */         } 
/* 1102 */         tInfo.setTestErrors(errorBuilder.toString());
/*      */         
/* 1104 */         switch (tInfo.getTestResult()) {
/*      */           case null:
/* 1106 */             build.addFailedTest((TestDetails)tInfo);
/*      */           
/*      */           case TEST_SUCCEED:
/* 1109 */             build.addSuccessfulTest((TestDetails)tInfo);
/*      */         } 
/*      */ 
/*      */ 
/*      */       
/*      */       } 
/* 1115 */       Element changesElement = doc.getRootElement().getChild("changes");
/* 1116 */       if (changesElement != null) {
/* 1117 */         build.setCommitInfo(parseChangeSets(changesElement));
/*      */       }
/* 1119 */       return (BuildDetails)build;
/* 1120 */     } catch (JDOMException e) {
/* 1121 */       throw new RemoteApiException("Server returned malformed response", e);
/* 1122 */     } catch (IOException e) {
/* 1123 */       throw new RemoteApiException(e.getMessage(), e);
/* 1124 */     } catch (ParseException e) {
/* 1125 */       throw new RemoteApiException("Server returned malformed response", e);
/*      */     } 
/*      */   }
/*      */   
/*      */   List<BambooChangeSet> parseChangeSets(Element changesElement) throws RemoteApiException {
/* 1130 */     List<BambooChangeSet> changeSets = MiscUtil.buildArrayList();
/* 1131 */     List<Element> changeElements = XmlUtil.getChildElements(changesElement, "change");
/* 1132 */     for (Element changeElement : changeElements) {
/* 1133 */       BambooChangeSetImpl cInfo = new BambooChangeSetImpl();
/* 1134 */       cInfo.setAuthor(changeElement.getAttributeValue("author"));
/* 1135 */       String dateStr = changeElement.getChildText("date");
/* 1136 */       if (dateStr == null) {
/* 1137 */         throw new RemoteApiException("change element does not have mandatory date element");
/*      */       }
/* 1139 */       cInfo.setCommitDate(parseNewApiBuildTime(dateStr));
/* 1140 */       cInfo.setComment(getChildText(changeElement, "comment"));
/* 1141 */       Element filesElement = changeElement.getChild("files");
/* 1142 */       if (filesElement != null) {
/* 1143 */         List<Element> fileElements = XmlUtil.getChildElements(filesElement, "file");
/* 1144 */         for (Element fileElement : fileElements) {
/* 1145 */           BambooFileInfo fileInfo = new BambooFileInfo(getChildText(fileElement, "name").trim(), 
/* 1146 */               getChildText(fileElement, "revision").trim());
/* 1147 */           cInfo.addCommitFile(fileInfo);
/*      */         } 
/*      */       } 
/*      */       
/* 1151 */       changeSets.add(cInfo);
/*      */     } 
/* 1153 */     return changeSets;
/*      */   }
/*      */   
/*      */   private double parseDuration(Element durationElement) throws ParseException {
/* 1157 */     if (durationElement == null) {
/* 1158 */       throw new ParseException("null duration element", 0);
/*      */     }
/*      */     
/* 1161 */     String durationStr = durationElement.getText();
/*      */     
/*      */     try {
/* 1164 */       return Double.valueOf(durationStr).doubleValue() / 1000.0D;
/* 1165 */     } catch (NumberFormatException numberFormatException) {
/* 1166 */       throw new ParseException("Cannot parse duration element as floating point number [" + durationStr + "]", 0);
/*      */     } 
/*      */   }
/*      */   
/*      */   private TestResult parseTestResult(String attributeValue) throws ParseException {
/* 1171 */     if ("failed".equals(attributeValue))
/* 1172 */       return TestResult.TEST_FAILED; 
/* 1173 */     if ("successful".equals(attributeValue)) {
/* 1174 */       return TestResult.TEST_SUCCEED;
/*      */     }
/* 1176 */     throw new ParseException("Invalid test result [" + attributeValue + "]", 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addLabelToBuild(@NotNull String planKey, int buildNumber, String buildLabel) throws RemoteApiException {
/* 1184 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/api/rest/addLabelToBuildResults.action" + "?auth=" + UrlUtil.encodeUrl(this.authToken) + 
/* 1185 */       "&buildKey=" + UrlUtil.encodeUrl(planKey) + "&buildNumber=" + buildNumber + "&label=" + 
/* 1186 */       UrlUtil.encodeUrl(buildLabel);
/*      */     
/*      */     try {
/* 1189 */       Document doc = retrieveGetResponse(buildResultUrl);
/* 1190 */       String exception = getExceptionMessages(doc);
/* 1191 */       if (exception != null) {
/* 1192 */         throw new RemoteApiException(exception);
/*      */       }
/* 1194 */     } catch (JDOMException e) {
/* 1195 */       throw new RemoteApiException("Server returned malformed response", e);
/* 1196 */     } catch (IOException e) {
/* 1197 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCommentToBuild(@NotNull String planKey, int buildNumber, String buildComment) throws RemoteApiException {
/* 1207 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/api/rest/addCommentToBuildResults.action" + "?auth=" + UrlUtil.encodeUrl(this.authToken) + 
/* 1208 */       "&buildKey=" + UrlUtil.encodeUrl(planKey) + "&buildNumber=" + buildNumber + "&content=" + 
/* 1209 */       UrlUtil.encodeUrl(buildComment);
/*      */     
/*      */     try {
/* 1212 */       Document doc = retrieveGetResponse(buildResultUrl);
/* 1213 */       String exception = getExceptionMessages(doc);
/* 1214 */       if (exception != null) {
/* 1215 */         throw new RemoteApiException(exception);
/*      */       }
/* 1217 */     } catch (JDOMException e) {
/* 1218 */       throw new RemoteApiException("Server returned malformed response", e);
/* 1219 */     } catch (IOException e) {
/* 1220 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void executeBuild(@NotNull String planKey) throws RemoteApiException {
/* 1226 */     if (getBamboBuildNumber() >= 2101) {
/* 1227 */       executeBuildNewApi(planKey);
/*      */     } else {
/* 1229 */       executeBuildOldApi(planKey);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void executeBuildOldApi(String planKey) throws RemoteApiException {
/* 1236 */     String buildResultUrl = String.valueOf(getBaseUrl()) + "/api/rest/executeBuild.action" + "?auth=" + UrlUtil.encodeUrl(this.authToken) + "&buildKey=" + 
/* 1237 */       UrlUtil.encodeUrl(planKey);
/*      */     
/*      */     try {
/* 1240 */       Document doc = retrieveGetResponse(buildResultUrl);
/* 1241 */       String exception = getExceptionMessages(doc);
/* 1242 */       if (exception != null) {
/* 1243 */         throw new RemoteApiException(exception);
/*      */       }
/* 1245 */     } catch (JDOMException e) {
/* 1246 */       throw new RemoteApiException("Server returned malformed response", e);
/* 1247 */     } catch (IOException e) {
/* 1248 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void executeBuildNewApi(String planKey) throws RemoteApiException {
/* 1254 */     String url = String.valueOf(getBaseUrl()) + "/rest/api/latest/queue/" + UrlUtil.encodeUrl(planKey);
/*      */     
/*      */     try {
/* 1257 */       retrievePostResponse(url, "", false);
/* 1258 */     } catch (JDOMException e) {
/* 1259 */       throw new RemoteApiException("Server returned malformed response", e);
/*      */     } 
/*      */   }
/*      */   
/*      */   BambooBuildInfo.Builder constructBuildErrorInfo(String planKey, String message, Date lastPollingTime) {
/* 1264 */     return (new BambooBuildInfo.Builder(planKey, null, this.serverData, null, null, BuildStatus.UNKNOWN)).pollingTime(
/* 1265 */         lastPollingTime).errorMessage(message);
/*      */   }
/*      */   
/*      */   BambooBuildInfo.Builder constructBuildErrorInfo(String planKey, String message, Throwable exception, Date lastPollingTime) {
/* 1269 */     return (new BambooBuildInfo.Builder(planKey, null, this.serverData, null, null, BuildStatus.UNKNOWN)).pollingTime(
/* 1270 */         lastPollingTime).errorMessage(message, exception);
/*      */   }
/*      */   
/*      */   private int parseInt(String number) throws RemoteApiException {
/*      */     try {
/* 1275 */       return Integer.parseInt(number);
/* 1276 */     } catch (NumberFormatException ex) {
/* 1277 */       throw new RemoteApiException("Invalid number", ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   private double parseDouble(String number) throws RemoteApiException {
/*      */     try {
/* 1283 */       return Double.parseDouble(number);
/* 1284 */     } catch (NumberFormatException ex) {
/* 1285 */       throw new RemoteApiException("Invalid double", ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   private BambooPlan constructPlanItem(Element planNode, boolean isEnabledDefault) throws RemoteApiException {
/* 1290 */     String name = planNode.getAttributeValue("name");
/* 1291 */     String key = planNode.getAttributeValue("key");
/*      */     
/* 1293 */     String projectName = planNode.getChildText("projectName");
/* 1294 */     String projectKey = planNode.getChildText("projectKey");
/*      */ 
/*      */     
/* 1297 */     boolean isFavourite = Boolean.parseBoolean(planNode.getChildText("isFavourite"));
/*      */     
/* 1299 */     Integer averageBuildTime = Integer.valueOf((new Double(parseDouble(planNode.getChildText("averageBuildTimeInSeconds")))).intValue());
/* 1300 */     boolean isInQueue = Boolean.parseBoolean(planNode.getChildText("isInBuildQueue"));
/*      */     
/* 1302 */     String isBuildingString = planNode.getChildText("isBuilding");
/*      */ 
/*      */     
/* 1305 */     if (isBuildingString == null && isInQueue) {
/* 1306 */       isBuildingString = "true";
/*      */     }
/* 1308 */     boolean isBuilding = Boolean.parseBoolean(isBuildingString);
/*      */     
/* 1310 */     String isEnabledString = planNode.getAttributeValue("enabled");
/* 1311 */     if (isEnabledString == null) {
/* 1312 */       isEnabledString = Boolean.toString(isEnabledDefault);
/*      */     }
/* 1314 */     boolean isEnabled = Boolean.parseBoolean(isEnabledString);
/*      */     
/* 1316 */     return new BambooPlan(name, key, null, isEnabled, Boolean.valueOf(isFavourite), projectName, projectKey, averageBuildTime, isInQueue, 
/* 1317 */         isBuilding);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BambooBuildInfo.Builder constructBuilderItem(Element buildItemNode, Date lastPollingTime, String aPlanKey, Set<String> commiters, int timezoneOffset) throws RemoteApiException {
/*      */     BambooBuildInfo.Builder builder;
/* 1326 */     if (!buildItemNode.getChildren().iterator().hasNext()) {
/* 1327 */       builder = (
/* 1328 */         new BambooBuildInfo.Builder(aPlanKey, this.serverData, BuildStatus.UNKNOWN)).pollingTime(
/* 1329 */           lastPollingTime).reason("Never built");
/*      */     } else {
/*      */       
/* 1332 */       String planKey = getChildText(buildItemNode, "buildKey");
/* 1333 */       String buildName = getChildText(buildItemNode, "buildName");
/* 1334 */       String projectName = getChildText(buildItemNode, "projectName");
/* 1335 */       int buildNumber = parseInt(getChildText(buildItemNode, "buildNumber"));
/* 1336 */       String relativeBuildDate = getChildText(buildItemNode, "buildRelativeBuildDate");
/* 1337 */       Date startTime = 
/* 1338 */         parseBuildDate(getChildText(buildItemNode, "buildTime"), "Cannot parse buildTime.", timezoneOffset);
/* 1339 */       String buildCompletedDateStr = getChildText(buildItemNode, "buildCompletedDate");
/* 1340 */       Date completionTime = 
/* 1341 */         (buildCompletedDateStr != null && buildCompletedDateStr.length() > 0) ? parseDateUniversal(
/* 1342 */           buildCompletedDateStr, "buildCompletedDate", timezoneOffset) : 
/*      */         
/* 1344 */         startTime;
/* 1345 */       String durationDescription = getChildText(buildItemNode, "buildDurationDescription");
/*      */       
/* 1347 */       String stateStr = getChildText(buildItemNode, "buildState");
/* 1348 */       builder = (
/* 1349 */         new BambooBuildInfo.Builder(planKey, buildName, this.serverData, projectName, Integer.valueOf(buildNumber), getStatus(stateStr)))
/* 1350 */         .pollingTime(lastPollingTime).reason(getChildText(buildItemNode, "buildReason"))
/* 1351 */         .startTime(startTime).testSummary(getChildText(buildItemNode, "buildTestSummary")).commitComment(
/* 1352 */           getChildText(buildItemNode, "buildCommitComment")).testsPassedCount(
/* 1353 */           parseInt(getChildText(buildItemNode, "successfulTestCount"))).testsFailedCount(
/* 1354 */           parseInt(getChildText(buildItemNode, "failedTestCount"))).completionTime(completionTime)
/* 1355 */         .relativeBuildDate(relativeBuildDate).durationDescription(durationDescription)
/* 1356 */         .commiters(commiters);
/*      */     } 
/* 1358 */     return builder;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BambooBuildInfo.Builder constructBuilderItem_40(Element buildItemNode, Date lastPollingTime, String aPlanKey, Set<String> commiters, int timezoneOffset) throws RemoteApiException {
/*      */     BambooBuildInfo.Builder builder;
/* 1368 */     if (!buildItemNode.getChildren().iterator().hasNext()) {
/* 1369 */       builder = (
/* 1370 */         new BambooBuildInfo.Builder(aPlanKey, this.serverData, BuildStatus.UNKNOWN)).pollingTime(
/* 1371 */           lastPollingTime).reason("Never built");
/*      */     } else {
/*      */       
/* 1374 */       String planKey = aPlanKey;
/* 1375 */       String buildName = getChildText(buildItemNode, "planName");
/* 1376 */       String projectName = getChildText(buildItemNode, "projectName");
/* 1377 */       int buildNumber = parseInt(buildItemNode.getAttributeValue("number"));
/* 1378 */       String relativeBuildDate = getChildText(buildItemNode, "buildRelativeTime");
/* 1379 */       Date startTime = parseNewApiBuildTime(getChildText(buildItemNode, "buildStartedTime"));
/* 1380 */       Date completionTime = parseNewApiBuildTime(getChildText(buildItemNode, "buildCompletedTime"));
/*      */       
/* 1382 */       String durationDescription = getChildText(buildItemNode, "buildDurationDescription");
/*      */       
/* 1384 */       String stateStr = buildItemNode.getAttributeValue("state");
/*      */       
/* 1386 */       builder = (
/* 1387 */         new BambooBuildInfo.Builder(planKey, buildName, this.serverData, projectName, Integer.valueOf(buildNumber), getStatus(stateStr)))
/* 1388 */         .pollingTime(lastPollingTime)
/* 1389 */         .reason(getBuildReason_40(getChildText(buildItemNode, "buildReason")))
/* 1390 */         .startTime(startTime).testSummary(getChildText(buildItemNode, "buildTestSummary")).commitComment(
/* 1391 */           getChildText(buildItemNode, "buildCommitComment")).testsPassedCount(
/* 1392 */           parseInt(getChildText(buildItemNode, "successfulTestCount"))).testsFailedCount(
/* 1393 */           parseInt(getChildText(buildItemNode, "failedTestCount"))).completionTime(completionTime)
/* 1394 */         .relativeBuildDate(relativeBuildDate).durationDescription(durationDescription)
/* 1395 */         .commiters(commiters);
/*      */     } 
/* 1397 */     return builder;
/*      */   }
/*      */ 
/*      */   
/*      */   private String getBuildReason_40(String reasonOriginal) {
/* 1402 */     Pattern pattern = Pattern.compile("(.*)<a([^>]+)>(.+)</a>");
/*      */     
/* 1404 */     Matcher m = pattern.matcher(reasonOriginal);
/* 1405 */     if (m.find()) {
/* 1406 */       return StringEscapeUtils.unescapeHtml(String.valueOf(m.group(1)) + m.group(3));
/*      */     }
/*      */ 
/*      */     
/* 1410 */     return reasonOriginal;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private BambooBuild constructBuildItemFromNewApi(Element el, Date pollingTime, String planKey) throws RemoteApiException {
/* 1416 */     BambooPlan plan = getPlanDetails(planKey);
/*      */     
/* 1418 */     BambooBuildInfo.Builder builder = 
/* 1419 */       new BambooBuildInfo.Builder(planKey, plan.getName(), this.serverData, plan.getProjectName(), 
/* 1420 */         Integer.valueOf(parseInt(el.getAttributeValue("number"))), getStatus(el.getAttributeValue("state")));
/*      */     
/* 1422 */     builder.testsFailedCount(parseInt(getChildText(el, "failedTestCount")));
/* 1423 */     builder.testsPassedCount(parseInt(getChildText(el, "successfulTestCount")));
/* 1424 */     builder.startTime(parseNewApiBuildTime(getChildText(el, "buildStartedTime")));
/* 1425 */     builder.completionTime(parseNewApiBuildTime(getChildText(el, "buildCompletedTime")));
/* 1426 */     builder.durationDescription(getChildText(el, "buildDurationDescription"));
/* 1427 */     builder.reason(getChildText(el, "buildReason"));
/* 1428 */     builder.pollingTime(pollingTime);
/* 1429 */     builder.planState(plan.getState());
/*      */     
/* 1431 */     return (BambooBuild)builder.build();
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   private BuildStatus getStatus(@Nullable String stateStr) {
/* 1436 */     if ("Successful".equalsIgnoreCase(stateStr))
/* 1437 */       return BuildStatus.SUCCESS; 
/* 1438 */     if ("Failed".equalsIgnoreCase(stateStr)) {
/* 1439 */       return BuildStatus.FAILURE;
/*      */     }
/* 1441 */     return BuildStatus.UNKNOWN;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private Date parseDateUniversal(@Nullable String dateStr, @NotNull String element, int timezoneOffset) throws RemoteApiException {
/* 1447 */     if (dateStr != null) {
/* 1448 */       if (dateStr.indexOf('T') != -1)
/*      */       {
/* 1450 */         return parseCommitTime(dateStr);
/*      */       }
/*      */       
/* 1453 */       return parseBuildDate(dateStr, "Cannot parse " + element, timezoneOffset);
/*      */     } 
/*      */     
/* 1456 */     throw new RemoteApiException(String.valueOf(element) + " cannot be found");
/*      */   }
/*      */   
/* 1459 */   private static DateTimeFormatter buildDateFormat = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
/*      */   
/* 1461 */   private static DateTimeFormatter commitDateFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
/*      */   
/* 1463 */   private static DateTimeFormatter newApiDateFormat = ISODateTimeFormat.dateTime();
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
/*      */   @Nullable
/*      */   private Date parseBuildDate(String date, String errorMessage, int timezoneOffset) {
/*      */     try {
/* 1481 */       DateTime dateTime = buildDateFormat.parseDateTime(date);
/*      */ 
/*      */       
/* 1484 */       return dateTime.plusHours(timezoneOffset).toDate();
/* 1485 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 1486 */       LoggerImpl.getInstance().debug("Cannot parse build date: " + errorMessage);
/* 1487 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   private Date parseCommitTime(String date) throws RemoteApiException {
/*      */     try {
/* 1493 */       return commitDateFormat.parseDateTime(date).toDate();
/* 1494 */     } catch (IllegalArgumentException e) {
/* 1495 */       throw new RemoteApiException("Cannot parse date/time string [" + date + "]", e);
/*      */     } 
/*      */   }
/*      */   
/*      */   private Date parseNewApiBuildTime(String dateTime) throws RemoteApiException {
/*      */     try {
/* 1501 */       return newApiDateFormat.parseDateTime(dateTime).toDate();
/* 1502 */     } catch (IllegalArgumentException e) {
/* 1503 */       throw new RemoteApiException("Cannot parse date/time string [" + dateTime + "]", e);
/*      */     } 
/*      */   }
/*      */   
/*      */   private String getChildText(Element node, String childName) {
/* 1508 */     Element child = node.getChild(childName);
/* 1509 */     if (child == null) {
/* 1510 */       return "";
/*      */     }
/* 1512 */     return child.getText();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getBuildLogs(@NotNull String planKey, int buildNumber) throws RemoteApiException {
/* 1517 */     String buildResultUrl = null;
/*      */ 
/*      */     
/* 1520 */     if (getBamboBuildNumber() > 1904) {
/*      */       
/* 1522 */       List<BambooJobImpl> jobs = getJobsForPlan(planKey);
/*      */       
/* 1524 */       if (jobs.size() > 1) {
/* 1525 */         throw new RemoteApiException("Logs are only available for Plans with a single Job.");
/*      */       }
/*      */       
/* 1528 */       if (jobs.size() == 1 && ((BambooJobImpl)jobs.get(0)).isEnabled())
/*      */       {
/* 1530 */         String jobKey = ((BambooJobImpl)jobs.get(0)).getKey();
/*      */         
/* 1532 */         buildResultUrl = getBaseUrl() + 
/* 1533 */           "/download/" + 
/* 1534 */           jobKey + 
/* 1535 */           "/build_logs/" + 
/* 1536 */           jobKey + 
/* 1537 */           "-" + 
/* 1538 */           buildNumber + 
/* 1539 */           ".log";
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 1544 */       buildResultUrl = getBaseUrl() + 
/* 1545 */         "/download/" + 
/* 1546 */         UrlUtil.encodeUrl(planKey) + 
/* 1547 */         "/build_logs/" + 
/* 1548 */         UrlUtil.encodeUrl(planKey) + 
/* 1549 */         "-" + 
/* 1550 */         buildNumber + 
/* 1551 */         ".log";
/*      */     } 
/*      */ 
/*      */     
/* 1555 */     if (buildResultUrl != null && buildResultUrl.length() > 0) {
/*      */       try {
/* 1557 */         return doUnconditionalGetForTextNonXmlResource(buildResultUrl);
/* 1558 */       } catch (IOException e) {
/* 1559 */         throw new RemoteApiException(e.getMessage(), e);
/*      */       } 
/*      */     }
/*      */     
/* 1563 */     return null;
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   public Collection<String> getBranchKeys(String planKey, boolean useFavourites, boolean myBranchesOnly) throws RemoteApiException {
/* 1568 */     List<String> branches = Lists.newArrayList();
/* 1569 */     String my = myBranchesOnly ? "&my" : "";
/* 1570 */     String url = String.valueOf(getBaseUrl()) + "/rest/api/latest/plan/" + UrlUtil.encodeUrl(planKey) + "?expand=branches.branch" + my;
/*      */     try {
/* 1572 */       Document doc = retrieveGetResponse(url);
/* 1573 */       String exception = getExceptionMessages(doc);
/* 1574 */       if (exception != null) {
/* 1575 */         throw new RemoteApiException(exception);
/*      */       }
/* 1577 */       XPath xpath = XPath.newInstance("/plan/branches/branch");
/*      */       
/* 1579 */       List<Element> elements = xpath.selectNodes(doc);
/* 1580 */       if (elements != null) {
/* 1581 */         for (Element element : elements) {
/* 1582 */           if (useFavourites) {
/* 1583 */             String favourite = getChildText(element, "isFavourite");
/* 1584 */             if (StringUtils.equals(favourite, "false")) {
/*      */               continue;
/*      */             }
/*      */           } 
/* 1588 */           String branchKey = element.getAttributeValue("key");
/* 1589 */           branches.add(branchKey);
/*      */         } 
/*      */       }
/* 1592 */     } catch (IOException e) {
/* 1593 */       throw new RemoteApiException(e.getMessage(), e);
/* 1594 */     } catch (JDOMException e) {
/* 1595 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/* 1597 */     return branches;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<BambooJobImpl> getJobsForPlan(String planKey) throws RemoteApiException {
/* 1602 */     List<BambooJobImpl> jobs = new ArrayList<BambooJobImpl>();
/*      */     
/* 1604 */     String url = String.valueOf(getBaseUrl()) + "/rest/api/latest/plan/" + UrlUtil.encodeUrl(planKey) + "?expand=stages.stage.plans";
/*      */     
/*      */     try {
/* 1607 */       Document doc = retrieveGetResponse(url);
/* 1608 */       String exception = getExceptionMessages(doc);
/* 1609 */       if (exception != null) {
/* 1610 */         throw new RemoteApiException(exception);
/*      */       }
/*      */       
/* 1613 */       XPath xpath = XPath.newInstance("/plan/stages/stage/plans/plan");
/*      */       
/* 1615 */       List<Element> elements = xpath.selectNodes(doc);
/* 1616 */       if (elements != null) {
/* 1617 */         for (Element element : elements) {
/* 1618 */           String key = element.getAttributeValue("key");
/* 1619 */           String shortKey = element.getAttributeValue("shortKey");
/* 1620 */           String name = element.getAttributeValue("name");
/* 1621 */           String shortName = element.getAttributeValue("shortName");
/*      */           
/* 1623 */           BambooJobImpl job = new BambooJobImpl(key, shortKey, name, shortName);
/* 1624 */           String enabled = element.getAttributeValue("enabled");
/*      */ 
/*      */           
/* 1627 */           if (enabled != null && enabled.equalsIgnoreCase("false")) {
/* 1628 */             job.setEnabled(false);
/*      */           } else {
/* 1630 */             job.setEnabled(true);
/*      */           } 
/*      */           
/* 1633 */           jobs.add(job);
/*      */         } 
/*      */       }
/*      */       
/* 1637 */       return jobs;
/* 1638 */     } catch (IOException e) {
/* 1639 */       throw new RemoteApiException(e.getMessage(), e);
/* 1640 */     } catch (JDOMException e) {
/* 1641 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public Collection<BuildIssue> getIssuesForBuild(@NotNull String planKey, int buildNumber) throws RemoteApiException {
/* 1646 */     int bambooBuild = getBamboBuildNumber();
/* 1647 */     if (bambooBuild < 1401) {
/* 1648 */       throw new RemoteApiBadServerVersionException("Bamboo build 1401 or newer required");
/*      */     }
/*      */     
/* 1651 */     String planUrl = String.valueOf(getBaseUrl()) + (
/* 1652 */       (bambooBuild <= 1904) ? "/rest/api/latest/build/" : "/rest/api/latest/result/") + 
/* 1653 */       UrlUtil.encodeUrl(String.valueOf(planKey) + "-" + buildNumber) + 
/* 1654 */       "?expand=jiraIssues" + "&auth=" + UrlUtil.encodeUrl(this.authToken);
/*      */     
/*      */     try {
/* 1657 */       Document doc = retrieveGetResponse(planUrl);
/*      */       
/* 1659 */       List<BuildIssue> issues = new ArrayList<BuildIssue>();
/*      */       
/* 1661 */       List<Element> jiraIssuesNode = (bambooBuild <= 1904) ? 
/* 1662 */         XPath.newInstance("build/jiraIssues").selectNodes(doc) : 
/* 1663 */         XPath.newInstance("result/jiraIssues").selectNodes(doc);
/*      */       
/* 1665 */       if (jiraIssuesNode == null) {
/* 1666 */         throw new RemoteApiException("Invalid server response");
/*      */       }
/* 1668 */       if (jiraIssuesNode.size() != 1) {
/* 1669 */         throw new RemoteApiException("Invalid server response");
/*      */       }
/*      */       
/* 1672 */       List<Element> issuesNodes = XPath.newInstance("issue").selectNodes(jiraIssuesNode.get(0));
/* 1673 */       if (issuesNodes == null) {
/* 1674 */         throw new RemoteApiException("Invalid server response");
/*      */       }
/* 1676 */       for (Element element : issuesNodes) {
/* 1677 */         Element url = element.getChild("url");
/* 1678 */         if (url == null) {
/* 1679 */           LoggerImpl.getInstance().error("getIssuesForBuild: \"url\" node of the \"issue\" element is null");
/*      */           continue;
/*      */         } 
/* 1682 */         BuildIssueInfo buildIssueInfo = new BuildIssueInfo(element.getAttributeValue("key"), url.getAttributeValue("href"));
/* 1683 */         issues.add(buildIssueInfo);
/*      */       } 
/* 1685 */       return issues;
/* 1686 */     } catch (JDOMException e) {
/* 1687 */       throw new RemoteApiException(e.getMessage(), e);
/* 1688 */     } catch (IOException e) {
/* 1689 */       throw new RemoteApiException(e.getMessage(), e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public Collection<BambooPlan> getPlanList() throws RemoteApiException {
/*      */     List<BambooPlan> plans;
/* 1698 */     if (getBamboBuildNumber() >= 2906) {
/* 1699 */       plans = listPlanNames_40();
/*      */     } else {
/* 1701 */       plans = listPlanNames();
/*      */     } 
/*      */     
/*      */     try {
/*      */       List<String> favPlans;
/* 1706 */       if (getBamboBuildNumber() > 1904) {
/* 1707 */         favPlans = getFavouriteUserPlansNew();
/*      */       } else {
/* 1709 */         favPlans = getFavouriteUserPlans();
/*      */       } 
/* 1711 */       for (String fav : favPlans) {
/* 1712 */         for (ListIterator<BambooPlan> it = plans.listIterator(); it.hasNext(); ) {
/* 1713 */           BambooPlan plan = it.next();
/* 1714 */           if (plan.getKey().equalsIgnoreCase(fav)) {
/* 1715 */             it.set(plan.withFavourite(true));
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/* 1720 */     } catch (RemoteApiException remoteApiException) {}
/*      */ 
/*      */     
/* 1723 */     return plans;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public Collection<BambooBuild> getSubscribedPlansResults(Collection<SubscribedPlan> plans, boolean isUseFavourities, int timezoneOffset) throws RemoteApiLoginException {
/* 1730 */     Collection<BambooBuild> builds = new ArrayList<BambooBuild>();
/*      */     
/* 1732 */     Collection<BambooPlan> plansForServer = null;
/* 1733 */     RemoteApiException exception = null;
/*      */     try {
/* 1735 */       plansForServer = getPlanList();
/* 1736 */     } catch (RemoteApiException e) {
/*      */       
/* 1738 */       this.loger.warn("Cannot fetch plan list from Bamboo server [" + getUrl() + "]");
/* 1739 */       exception = e;
/*      */     } 
/*      */     
/* 1742 */     if (isUseFavourities) {
/* 1743 */       if (plansForServer != null) {
/* 1744 */         for (BambooPlan bambooPlan : plansForServer) {
/* 1745 */           if (bambooPlan.isFavourite()) {
/* 1746 */             if (isLoggedIn()) {
/*      */               try {
/* 1748 */                 BambooBuildInfo bambooBuildInfo = 
/* 1749 */                   getLatestBuildBuilderForPlan(bambooPlan.getKey(), timezoneOffset).enabled(
/* 1750 */                     bambooPlan.isEnabled()).build();
/* 1751 */                 builds.add(bambooBuildInfo);
/* 1752 */               } catch (RemoteApiException remoteApiException) {
/*      */                 
/* 1754 */                 this.loger.warn("Cannot fetch latest build for plan [" + bambooPlan.getKey() + 
/* 1755 */                     "] from Bamboo server [" + getUrl() + "]");
/*      */               }  continue;
/*      */             } 
/* 1758 */             builds.add(constructBuildErrorInfo(bambooPlan.getKey(), 
/* 1759 */                   (exception == null) ? "" : exception.getMessage(), (Throwable)exception, new Date()).build());
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } else {
/*      */       
/* 1765 */       for (SubscribedPlan plan : plans) {
/* 1766 */         if (isLoggedIn()) {
/*      */           try {
/* 1768 */             Boolean isEnabled = (plansForServer != null) ? isPlanEnabled(
/* 1769 */                 plansForServer, plan.getKey()) : null;
/* 1770 */             BambooBuildInfo bambooBuildInfo = 
/* 1771 */               getLatestBuildBuilderForPlan(plan.getKey(), timezoneOffset).enabled(
/* 1772 */                 (isEnabled != null) ? isEnabled.booleanValue() : true).build();
/* 1773 */             builds.add(bambooBuildInfo);
/* 1774 */           } catch (RemoteApiException remoteApiException) {}
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/* 1779 */         builds.add(constructBuildErrorInfo(plan.getKey(), (exception == null) ? "" : exception.getMessage(), 
/* 1780 */               (Throwable)exception, new Date()).build());
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1785 */     return builds;
/*      */   }
/*      */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\api\BambooSessionImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */