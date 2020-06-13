/*     */ package com.atlassian.connector.commons.jira;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAAttachment;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAComment;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAComponentBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAConstant;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAPriorityBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAProject;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAQueryFragment;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAResolutionBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRASavedFilter;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRASecurityLevelBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAUserBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAVersionBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JiraFilter;
/*     */ import com.atlassian.connector.commons.jira.rss.JIRAException;
/*     */ import com.atlassian.connector.commons.jira.rss.JIRARssClient;
/*     */ import com.atlassian.connector.commons.jira.rss.JiraRssAutoRenewClient;
/*     */ import com.atlassian.connector.commons.jira.soap.AxisSessionCallback;
/*     */ import com.atlassian.connector.commons.jira.soap.JIRASoapSessionImpl;
/*     */ import com.atlassian.theplugin.commons.ServerType;
/*     */ import com.atlassian.theplugin.commons.jira.JiraServerData;
/*     */ import com.atlassian.theplugin.commons.remoteapi.CaptchaRequiredException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.jira.JiraCaptchaRequiredException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;
/*     */ import com.atlassian.theplugin.commons.util.Logger;
/*     */ import java.net.MalformedURLException;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.rpc.ServiceException;
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
/*     */ public final class JIRASoapAndXmlServerFacade2Impl
/*     */   implements JIRAServerFacade2
/*     */ {
/*     */   private final HttpSessionCallback callback;
/*     */   private final AxisSessionCallback axisCallback;
/*     */   private static Logger logger;
/*  61 */   private final Map<String, JiraRssAutoRenewClient> rssSessions = new HashMap<String, JiraRssAutoRenewClient>();
/*  62 */   private final Map<String, JIRASessionPartOne> soapSessions = new HashMap<String, JIRASessionPartOne>();
/*     */   
/*     */   private static final long ONE_MINUTE = 60000L;
/*     */   
/*     */   private String getSessionKey(ConnectionCfg httpConnectionCfg) {
/*  67 */     return String.valueOf(httpConnectionCfg.getUrl()) + "_" + httpConnectionCfg.getUsername() + "_" + httpConnectionCfg.getPassword();
/*     */   }
/*     */   
/*     */   public JIRASoapAndXmlServerFacade2Impl(HttpSessionCallback callback, AxisSessionCallback axisCallback) {
/*  71 */     this.callback = callback;
/*  72 */     this.axisCallback = axisCallback;
/*     */   }
/*     */   
/*     */   public void reset() {
/*  76 */     this.rssSessions.clear();
/*  77 */     this.soapSessions.clear();
/*     */   }
/*     */   
/*     */   public boolean usesRest(JiraServerData jiraServerData) {
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public static void setLogger(Logger logger) {
/*  85 */     JIRASoapAndXmlServerFacade2Impl.logger = logger;
/*     */   }
/*     */   private synchronized JIRASessionPartOne getSoapSession(ConnectionCfg connectionCfg) throws RemoteApiException {
/*     */     JIRASoapSessionImpl jIRASoapSessionImpl;
/*  89 */     String key = getSessionKey(connectionCfg);
/*     */     
/*  91 */     JIRASessionPartOne session = this.soapSessions.get(key);
/*  92 */     if (session == null || (
/*  93 */       (JIRASoapSessionImpl)session).getLastUsed().getTime() < (new Date()).getTime() - 60000L) {
/*  94 */       if (session != null) {
/*  95 */         this.soapSessions.remove(key);
/*     */       }
/*     */       
/*     */       try {
/*  99 */         jIRASoapSessionImpl = new JIRASoapSessionImpl(logger, connectionCfg, this.axisCallback);
/* 100 */       } catch (MalformedURLException e) {
/* 101 */         throw new RemoteApiException(e);
/* 102 */       } catch (ServiceException e) {
/* 103 */         throw new RemoteApiException(e);
/*     */       } 
/*     */       
/* 106 */       jIRASoapSessionImpl.login(connectionCfg.getUsername(), connectionCfg.getPassword());
/* 107 */       this.soapSessions.put(key, jIRASoapSessionImpl);
/*     */     } 
/* 109 */     return (JIRASessionPartOne)jIRASoapSessionImpl;
/*     */   }
/*     */   
/*     */   private synchronized JiraRssAutoRenewClient getRssSession(ConnectionCfg server) throws RemoteApiException {
/* 113 */     String key = getSessionKey(server);
/*     */     
/* 115 */     JiraRssAutoRenewClient session = this.rssSessions.get(key);
/*     */ 
/*     */ 
/*     */     
/* 119 */     if (session == null || session.getLastUsed().getTime() < (new Date()).getTime() - 60000L) {
/*     */ 
/*     */       
/* 122 */       JIRARssClient client = new JIRARssClient(server, this.callback);
/*     */       
/*     */       try {
/* 125 */         this.callback.disposeClient(server);
/* 126 */         client.login();
/* 127 */       } catch (JiraCaptchaRequiredException e) {
/* 128 */         throw new CaptchaRequiredException(e);
/* 129 */       } catch (JIRAException e) {
/* 130 */         throw new RemoteApiException(e);
/*     */       } 
/*     */       
/* 133 */       session = new JiraRssAutoRenewClient(client);
/* 134 */       this.rssSessions.put(key, session);
/*     */     } 
/* 136 */     session.setLastUsed(new Date());
/* 137 */     return session;
/*     */   }
/*     */   
/*     */   private synchronized void removeRssSession(ConnectionCfg server) {
/* 141 */     this.rssSessions.remove(getSessionKey(server));
/*     */   }
/*     */ 
/*     */   
/*     */   public void testServerConnection(ConnectionCfg httpConnectionCfg) throws RemoteApiException {
/*     */     JIRASoapSessionImpl jIRASoapSessionImpl;
/*     */     try {
/* 148 */       jIRASoapSessionImpl = new JIRASoapSessionImpl(logger, httpConnectionCfg, this.axisCallback);
/* 149 */     } catch (MalformedURLException e) {
/* 150 */       throw new RemoteApiException(e);
/* 151 */     } catch (ServiceException e) {
/* 152 */       throw new RemoteApiLoginException(e.getMessage(), e);
/*     */     } 
/* 154 */     jIRASoapSessionImpl.login(httpConnectionCfg.getUsername(), httpConnectionCfg.getPassword());
/*     */   }
/*     */   
/*     */   public ServerType getServerType() {
/* 158 */     return ServerType.JIRA_SERVER;
/*     */   }
/*     */   
/*     */   public List<JIRAIssue> getIssues(ConnectionCfg httpConnectionCfg, JiraFilter filter, String sort, String sortOrder, int start, int size) throws JIRAException {
/*     */     try {
/* 163 */       JiraRssAutoRenewClient rss = getRssSession(httpConnectionCfg);
/* 164 */       return rss.getIssues(filter, sort, sortOrder, start, size);
/* 165 */     } catch (CaptchaRequiredException e) {
/* 166 */       removeRssSession(httpConnectionCfg);
/* 167 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 168 */     } catch (RemoteApiException e) {
/* 169 */       removeRssSession(httpConnectionCfg);
/* 170 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAIssue> getIssues(JiraServerData server, String query, String sort, String sortOrder, int start, int size) throws JIRAException {
/* 175 */     throw new JIRAException("Not implemented");
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
/*     */   public List<JIRAIssue> getSavedFilterIssues(ConnectionCfg httpConnectionCfg, JIRASavedFilter filter, String sort, String sortOrder, int start, int size) throws JIRAException {
/*     */     try {
/* 220 */       JiraRssAutoRenewClient rss = getRssSession(httpConnectionCfg);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 229 */       return rss.getSavedFilterIssues(filter, sort, sortOrder, start, size);
/*     */     }
/* 231 */     catch (CaptchaRequiredException e) {
/* 232 */       removeRssSession(httpConnectionCfg);
/* 233 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 234 */     } catch (RemoteApiException e) {
/* 235 */       removeRssSession(httpConnectionCfg);
/* 236 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public JIRAIssue getIssue(ConnectionCfg httpConnectionCfg, String key) throws JIRAException {
/*     */     try {
/* 242 */       JiraRssAutoRenewClient rss = getRssSession(httpConnectionCfg);
/* 243 */       return rss.getIssue(key);
/* 244 */     } catch (CaptchaRequiredException e) {
/* 245 */       removeRssSession(httpConnectionCfg);
/* 246 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 247 */     } catch (RemoteApiException e) {
/* 248 */       removeRssSession(httpConnectionCfg);
/* 249 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAProject> getProjects(ConnectionCfg server) throws JIRAException {
/*     */     try {
/* 255 */       JIRASessionPartOne soap = getSoapSession(server);
/* 256 */       return soap.getProjects();
/* 257 */     } catch (CaptchaRequiredException e) {
/* 258 */       removeRssSession(server);
/* 259 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 260 */     } catch (RemoteApiException e) {
/* 261 */       this.soapSessions.remove(getSessionKey(server));
/*     */       try {
/* 263 */         if (e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 264 */           JIRASessionPartOne soap = null;
/* 265 */           soap = getSoapSession(server);
/* 266 */           return soap.getProjects();
/*     */         } 
/* 268 */       } catch (RemoteApiException remoteApiException) {
/* 269 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 271 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<JIRAProject> getProjectsForIssueCreation(ConnectionCfg httpConnectionCfg) throws JIRAException {
/* 277 */     return getProjects(httpConnectionCfg);
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getIssueTypes(ConnectionCfg httpConnectionCfg) throws JIRAException {
/*     */     try {
/* 282 */       JIRASessionPartOne soap = getSoapSession(httpConnectionCfg);
/* 283 */       return soap.getIssueTypes();
/* 284 */     } catch (CaptchaRequiredException e) {
/* 285 */       removeRssSession(httpConnectionCfg);
/* 286 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 287 */     } catch (RemoteApiException e) {
/* 288 */       this.soapSessions.remove(getSessionKey(httpConnectionCfg));
/*     */       try {
/* 290 */         if (e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 291 */           JIRASessionPartOne soap = getSoapSession(httpConnectionCfg);
/* 292 */           return soap.getIssueTypes();
/*     */         } 
/* 294 */       } catch (RemoteApiException remoteApiException) {
/* 295 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 297 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<JIRAConstant> getIssueTypesForProject(ConnectionCfg httpConnectionCfg, long projectId, String projectKey) throws JIRAException {
/*     */     try {
/* 304 */       JIRASessionPartOne soap = getSoapSession(httpConnectionCfg);
/* 305 */       return soap.getIssueTypesForProject(projectId, projectKey);
/* 306 */     } catch (CaptchaRequiredException e) {
/* 307 */       removeRssSession(httpConnectionCfg);
/* 308 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 309 */     } catch (RemoteApiException e) {
/* 310 */       this.soapSessions.remove(getSessionKey(httpConnectionCfg));
/*     */       try {
/* 312 */         if (e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 313 */           JIRASessionPartOne soap = getSoapSession(httpConnectionCfg);
/* 314 */           return soap.getIssueTypesForProject(projectId, projectKey);
/*     */         } 
/* 316 */       } catch (RemoteApiException remoteApiException) {
/* 317 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 319 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getSubtaskIssueTypes(ConnectionCfg httpConnectionCfg) throws JIRAException {
/*     */     try {
/* 325 */       JIRASessionPartOne soap = getSoapSession(httpConnectionCfg);
/* 326 */       return soap.getSubtaskIssueTypes();
/* 327 */     } catch (CaptchaRequiredException e) {
/* 328 */       removeRssSession(httpConnectionCfg);
/* 329 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 330 */     } catch (RemoteApiException e) {
/* 331 */       this.soapSessions.remove(getSessionKey(httpConnectionCfg));
/*     */       try {
/* 333 */         if (e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 334 */           JIRASessionPartOne soap = getSoapSession(httpConnectionCfg);
/* 335 */           return soap.getSubtaskIssueTypes();
/*     */         } 
/* 337 */       } catch (RemoteApiException remoteApiException) {
/* 338 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 340 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<JIRAConstant> getSubtaskIssueTypesForProject(ConnectionCfg connectionCfg, long projectId, String projectKey) throws JIRAException {
/*     */     try {
/* 347 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 348 */       return soap.getSubtaskIssueTypesForProject(projectId, projectKey);
/* 349 */     } catch (CaptchaRequiredException e) {
/* 350 */       removeRssSession(connectionCfg);
/* 351 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 352 */     } catch (RemoteApiException e) {
/* 353 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 355 */         if (e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 356 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 357 */           return soap.getSubtaskIssueTypesForProject(projectId, projectKey);
/*     */         } 
/* 359 */       } catch (RemoteApiException remoteApiException) {
/* 360 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 362 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getStatuses(ConnectionCfg connection) throws JIRAException {
/*     */     try {
/* 368 */       JIRASessionPartOne soap = getSoapSession(connection);
/* 369 */       return soap.getStatuses();
/* 370 */     } catch (CaptchaRequiredException e) {
/* 371 */       removeRssSession(connection);
/* 372 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 373 */     } catch (RemoteApiException e) {
/* 374 */       this.soapSessions.remove(getSessionKey(connection));
/*     */       try {
/* 376 */         if (e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 377 */           JIRASessionPartOne soap = getSoapSession(connection);
/* 378 */           return soap.getStatuses();
/*     */         } 
/* 380 */       } catch (RemoteApiException remoteApiException) {
/* 381 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 383 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addComment(ConnectionCfg connectionCfg, String issueKey, String comment) throws JIRAException {
/*     */     try {
/* 389 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 390 */       soap.addComment(issueKey, comment);
/* 391 */     } catch (CaptchaRequiredException e) {
/* 392 */       removeRssSession(connectionCfg);
/* 393 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 394 */     } catch (RemoteApiException e) {
/* 395 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 397 */         if (e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 398 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 399 */           soap.addComment(issueKey, comment);
/*     */         } 
/* 401 */       } catch (RemoteApiException remoteApiException) {
/* 402 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 404 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAttachment(ConnectionCfg connectionCfg, String issueKey, String name, byte[] content) throws JIRAException {
/*     */     try {
/* 411 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 412 */       soap.addAttachment(issueKey, name, content);
/* 413 */     } catch (CaptchaRequiredException e) {
/* 414 */       removeRssSession(connectionCfg);
/* 415 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 416 */     } catch (RemoteApiException e) {
/* 417 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 419 */         if (e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 420 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 421 */           soap.addAttachment(issueKey, name, content);
/*     */         } 
/* 423 */       } catch (RemoteApiException remoteApiException) {
/* 424 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 426 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public JIRAIssue createIssue(ConnectionCfg connectionCfg, JIRAIssue issue) throws JIRAException {
/*     */     try {
/* 432 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 433 */       JIRAIssue i = soap.createIssue(issue);
/* 434 */       return getIssue(connectionCfg, i.getKey());
/* 435 */     } catch (CaptchaRequiredException e) {
/* 436 */       removeRssSession(connectionCfg);
/* 437 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 438 */     } catch (RemoteApiException e) {
/* 439 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 441 */         if (e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 442 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 443 */           JIRAIssue i = soap.createIssue(issue);
/* 444 */           return getIssue(connectionCfg, i.getKey());
/*     */         } 
/* 446 */       } catch (RemoteApiException remoteApiException) {
/* 447 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 449 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public JIRAIssue createSubtask(JiraServerData jiraServerData, JIRAIssue parent, JIRAIssue issue) throws JIRAException {
/* 454 */     throw new JIRAException("SOAP JIRA API does not support issue subtask creation");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void logWork(ConnectionCfg connectionCfg, JIRAIssue issue, String timeSpent, Calendar startDate, String comment, boolean updateEstimate, String newEstimate) throws JIRAException {
/*     */     try {
/* 461 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 462 */       soap.logWork(issue, timeSpent, startDate, comment, updateEstimate, newEstimate);
/* 463 */     } catch (CaptchaRequiredException e) {
/* 464 */       removeRssSession(connectionCfg);
/* 465 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 466 */     } catch (RemoteApiException e) {
/* 467 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 469 */         if (e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 470 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 471 */           soap.logWork(issue, timeSpent, startDate, comment, updateEstimate, newEstimate);
/*     */         } 
/* 473 */       } catch (RemoteApiException remoteApiException) {
/* 474 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 476 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAComponentBean> getComponents(ConnectionCfg connectionCfg, String projectKey) throws JIRAException {
/*     */     try {
/* 482 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 483 */       return soap.getComponents(projectKey);
/* 484 */     } catch (CaptchaRequiredException e) {
/* 485 */       removeRssSession(connectionCfg);
/* 486 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 487 */     } catch (RemoteApiException e) {
/* 488 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 490 */         if (e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 491 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 492 */           return soap.getComponents(projectKey);
/*     */         } 
/* 494 */       } catch (RemoteApiException remoteApiException) {
/* 495 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 497 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAVersionBean> getVersions(ConnectionCfg connectionCfg, String projectKey) throws JIRAException {
/*     */     try {
/* 503 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 504 */       return soap.getVersions(projectKey);
/* 505 */     } catch (CaptchaRequiredException e) {
/* 506 */       removeRssSession(connectionCfg);
/* 507 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 508 */     } catch (RemoteApiException e) {
/* 509 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/* 510 */       if (e == null) {
/* 511 */         logger.warn("PL-1710: e is null");
/* 512 */       } else if (e.getMessage() == null) {
/* 513 */         logger.warn("PL-1710: e.getMessage() is null");
/*     */       } 
/*     */       try {
/* 516 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 517 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 518 */           return soap.getVersions(projectKey);
/*     */         } 
/* 520 */       } catch (RemoteApiException remoteApiException) {
/* 521 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 523 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAPriorityBean> getPriorities(ConnectionCfg connectionCfg) throws JIRAException {
/*     */     try {
/* 529 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 530 */       return soap.getPriorities();
/* 531 */     } catch (CaptchaRequiredException e) {
/* 532 */       removeRssSession(connectionCfg);
/* 533 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 534 */     } catch (RemoteApiException e) {
/* 535 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 537 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 538 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 539 */           return soap.getPriorities();
/*     */         } 
/* 541 */       } catch (RemoteApiException remoteApiException) {
/* 542 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 544 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAResolutionBean> getResolutions(ConnectionCfg connectionCfg) throws JIRAException {
/*     */     try {
/* 550 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 551 */       return soap.getResolutions();
/* 552 */     } catch (CaptchaRequiredException e) {
/* 553 */       removeRssSession(connectionCfg);
/* 554 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 555 */     } catch (RemoteApiException e) {
/* 556 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 558 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 559 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 560 */           return soap.getResolutions();
/*     */         } 
/* 562 */       } catch (RemoteApiException remoteApiException) {
/* 563 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 565 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAQueryFragment> getSavedFilters(ConnectionCfg connectionCfg) throws JIRAException {
/*     */     try {
/* 571 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 572 */       return soap.getSavedFilters();
/* 573 */     } catch (CaptchaRequiredException e) {
/* 574 */       removeRssSession(connectionCfg);
/* 575 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 576 */     } catch (RemoteApiException e) {
/* 577 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 579 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 580 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 581 */           return soap.getSavedFilters();
/*     */         } 
/* 583 */       } catch (RemoteApiException remoteApiException) {
/* 584 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 586 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAAction> getAvailableActions(ConnectionCfg connectionCfg, JIRAIssue issue) throws JIRAException {
/*     */     try {
/* 592 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 593 */       return soap.getAvailableActions(issue);
/* 594 */     } catch (CaptchaRequiredException e) {
/* 595 */       removeRssSession(connectionCfg);
/* 596 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 597 */     } catch (RemoteApiException e) {
/* 598 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 600 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 601 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 602 */           return soap.getAvailableActions(issue);
/*     */         } 
/* 604 */       } catch (RemoteApiException remoteApiException) {
/* 605 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 607 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<JIRAActionField> getFieldsForAction(ConnectionCfg connectionCfg, JIRAIssue issue, JIRAAction action) throws JIRAException {
/*     */     try {
/* 614 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 615 */       return soap.getFieldsForAction(issue, action);
/* 616 */     } catch (CaptchaRequiredException e) {
/* 617 */       removeRssSession(connectionCfg);
/* 618 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 619 */     } catch (RemoteApiException e) {
/* 620 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 622 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 623 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 624 */           return soap.getFieldsForAction(issue, action);
/*     */         } 
/* 626 */       } catch (RemoteApiException remoteApiException) {
/* 627 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 629 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setField(ConnectionCfg connectionCfg, JIRAIssue issue, String fieldId, String value) throws JIRAException {
/*     */     try {
/* 636 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 637 */       soap.setField(issue, fieldId, value);
/* 638 */     } catch (CaptchaRequiredException e) {
/* 639 */       removeRssSession(connectionCfg);
/* 640 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 641 */     } catch (RemoteApiException e) {
/* 642 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 644 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 645 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 646 */           soap.setField(issue, fieldId, value);
/*     */         } 
/* 648 */       } catch (RemoteApiException remoteApiException) {
/* 649 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 651 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setField(ConnectionCfg connectionCfg, JIRAIssue issue, String fieldId, String[] values) throws JIRAException {
/*     */     try {
/* 658 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 659 */       soap.setField(issue, fieldId, values);
/* 660 */     } catch (CaptchaRequiredException e) {
/* 661 */       removeRssSession(connectionCfg);
/* 662 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 663 */     } catch (RemoteApiException e) {
/* 664 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 666 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 667 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 668 */           soap.setField(issue, fieldId, values);
/*     */         } 
/* 670 */       } catch (RemoteApiException remoteApiException) {
/* 671 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 673 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFields(ConnectionCfg connectionCfg, JIRAIssue issue, List<JIRAActionField> fields) throws JIRAException {
/*     */     try {
/* 679 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 680 */       soap.setFields(issue, fields);
/* 681 */     } catch (CaptchaRequiredException e) {
/* 682 */       removeRssSession(connectionCfg);
/* 683 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 684 */     } catch (RemoteApiException e) {
/* 685 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 687 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 688 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 689 */           soap.setFields(issue, fields);
/*     */         } 
/* 691 */       } catch (RemoteApiException remoteApiException) {
/* 692 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 694 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<JIRAComment> getComments(ConnectionCfg connectionCfg, JIRAIssue issue) throws JIRAException {
/*     */     try {
/* 701 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 702 */       return soap.getComments(issue);
/* 703 */     } catch (CaptchaRequiredException e) {
/* 704 */       removeRssSession(connectionCfg);
/* 705 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 706 */     } catch (RemoteApiException e) {
/* 707 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 709 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 710 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 711 */           return soap.getComments(issue);
/*     */         } 
/* 713 */       } catch (RemoteApiException remoteApiException) {
/* 714 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 716 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<JIRAAttachment> getIssueAttachements(ConnectionCfg connectionCfg, JIRAIssue issue) throws JIRAException {
/*     */     try {
/* 723 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 724 */       return soap.getIssueAttachements(issue);
/* 725 */     } catch (CaptchaRequiredException e) {
/* 726 */       removeRssSession(connectionCfg);
/* 727 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 728 */     } catch (RemoteApiException e) {
/* 729 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 731 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 732 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 733 */           return soap.getIssueAttachements(issue);
/*     */         } 
/* 735 */       } catch (RemoteApiException remoteApiException) {
/* 736 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 738 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void progressWorkflowAction(ConnectionCfg connectionCfg, JIRAIssue issue, JIRAAction action) throws JIRAException {
/* 744 */     progressWorkflowAction(connectionCfg, issue, action, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void progressWorkflowAction(ConnectionCfg connectionCfg, JIRAIssue issue, JIRAAction action, List<JIRAActionField> fields) throws JIRAException {
/*     */     try {
/* 750 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 751 */       soap.progressWorkflowAction(issue, action, fields);
/* 752 */     } catch (CaptchaRequiredException e) {
/* 753 */       removeRssSession(connectionCfg);
/* 754 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 755 */     } catch (RemoteApiException e) {
/* 756 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 758 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 759 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 760 */           soap.progressWorkflowAction(issue, action, fields);
/*     */         } 
/* 762 */       } catch (RemoteApiException remoteApiException) {
/* 763 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 765 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public JIRAIssue getIssueDetails(ConnectionCfg connectionCfg, JIRAIssue issue) throws JIRAException {
/*     */     try {
/* 771 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 772 */       return soap.getIssueDetails(issue);
/* 773 */     } catch (CaptchaRequiredException e) {
/* 774 */       removeRssSession(connectionCfg);
/* 775 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 776 */     } catch (RemoteApiException e) {
/* 777 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 779 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 780 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 781 */           return soap.getIssueDetails(issue);
/*     */         } 
/* 783 */       } catch (RemoteApiException remoteApiException) {
/* 784 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 786 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public JIRAUserBean getUser(ConnectionCfg connectionCfg, String loginName) throws JIRAException, JiraUserNotFoundException {
/*     */     try {
/* 793 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 794 */       return soap.getUser(loginName);
/* 795 */     } catch (CaptchaRequiredException e) {
/* 796 */       removeRssSession(connectionCfg);
/* 797 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 798 */     } catch (RemoteApiException e) {
/* 799 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 801 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 802 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 803 */           return soap.getUser(loginName);
/*     */         } 
/* 805 */       } catch (RemoteApiException remoteApiException) {
/* 806 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 808 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRASecurityLevelBean> getSecurityLevels(ConnectionCfg connectionCfg, String projectKey) throws JIRAException {
/*     */     try {
/* 814 */       JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 815 */       return soap.getSecurityLevels(projectKey);
/* 816 */     } catch (CaptchaRequiredException e) {
/* 817 */       removeRssSession(connectionCfg);
/* 818 */       throw new JiraCaptchaRequiredException(e.getMessage());
/* 819 */     } catch (RemoteApiException e) {
/* 820 */       this.soapSessions.remove(getSessionKey(connectionCfg));
/*     */       try {
/* 822 */         if (e != null && e.getMessage().contains("User not authenticated yet, or session timed out.")) {
/* 823 */           JIRASessionPartOne soap = getSoapSession(connectionCfg);
/* 824 */           return soap.getSecurityLevels(projectKey);
/*     */         } 
/* 826 */       } catch (RemoteApiException remoteApiException) {
/* 827 */         throw new JIRAException(e.getMessage(), e);
/*     */       } 
/* 829 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JIRASoapAndXmlServerFacade2Impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */