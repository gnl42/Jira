/*     */ package com.atlassian.connector.commons.jira.soap;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import com.atlassian.connector.commons.jira.JIRAAction;
/*     */ import com.atlassian.connector.commons.jira.JIRAActionBean;
/*     */ import com.atlassian.connector.commons.jira.JIRAActionField;
/*     */ import com.atlassian.connector.commons.jira.JIRAActionFieldBean;
/*     */ import com.atlassian.connector.commons.jira.JIRAIssue;
/*     */ import com.atlassian.connector.commons.jira.JIRAIssueBean;
/*     */ import com.atlassian.connector.commons.jira.JIRASessionPartOne;
/*     */ import com.atlassian.connector.commons.jira.JiraUserNotFoundException;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAAttachment;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAComment;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRACommentBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAComponentBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAConstant;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAIssueTypeBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAPriorityBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAProject;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAProjectBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAQueryFragment;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAResolutionBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRASavedFilterBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRASecurityLevelBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAStatusBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAUserBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAVersionBean;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.JiraSoapService;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.JiraSoapServiceServiceLocator;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteAttachment;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteComment;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteComponent;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteField;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteFieldValue;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteFilter;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteIssue;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteIssueType;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteNamedObject;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemotePriority;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteProject;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteResolution;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteSecurityLevel;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteStatus;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteUser;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteVersion;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteWorklog;
/*     */ import com.atlassian.theplugin.commons.configuration.ConfigurationFactory;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.AbstractHttpSession;
/*     */ import com.atlassian.theplugin.commons.util.HttpConfigurableAdapter;
/*     */ import com.atlassian.theplugin.commons.util.Logger;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.rmi.Remote;
/*     */ import java.rmi.RemoteException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import javax.xml.rpc.ServiceException;
/*     */ import org.apache.axis.AxisProperties;
/*     */ import org.apache.commons.codec.binary.Base64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JIRASoapSessionImpl
/*     */   implements JIRASessionPartOne
/*     */ {
/*     */   private String token;
/*     */   private final JiraSoapService service;
/*     */   private final ConnectionCfg httpConnectionCfg;
/*     */   private boolean loggedIn;
/*     */   private final Logger logger;
/*  82 */   private Date lastUsed = new Date();
/*     */ 
/*     */   
/*     */   public Date getLastUsed() {
/*  86 */     return this.lastUsed;
/*     */   }
/*     */   
/*     */   public void setLastUsed(Date lastUsed) {
/*  90 */     this.lastUsed = lastUsed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setAxisProperty(String name, String value) {
/*  98 */     if (value == null) {
/*  99 */       if (AxisProperties.getProperty(name) != null) {
/*     */         try {
/* 101 */           AxisProperties.setProperty(name, "");
/* 102 */         } catch (NullPointerException e) {
/* 103 */           this.logger.info("Setting AXIS property " + name + " to empty", e);
/*     */         } 
/*     */       }
/*     */     } else {
/* 107 */       AxisProperties.setProperty(name, value);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setSystemProperty(String name, String value) {
/* 113 */     if (value == null) {
/*     */       
/*     */       try {
/* 116 */         System.setProperty(name, "");
/* 117 */       } catch (NullPointerException e) {
/* 118 */         this.logger.info("Setting system property " + name + " to empty", e);
/*     */       } 
/*     */     } else {
/*     */       
/* 122 */       System.setProperty(name, value);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setProxy() {
/* 127 */     boolean useIdeaProxySettings = 
/* 128 */       ConfigurationFactory.getConfiguration().getGeneralConfigurationData().getUseIdeaProxySettings();
/* 129 */     HttpConfigurableAdapter proxyInfo = ConfigurationFactory.getConfiguration().transientGetHttpConfigurable();
/* 130 */     String host = null;
/* 131 */     String port = null;
/* 132 */     String user = null;
/* 133 */     String password = null;
/* 134 */     if (useIdeaProxySettings && proxyInfo.isUseHttpProxy()) {
/* 135 */       host = proxyInfo.getProxyHost();
/* 136 */       port = String.valueOf(proxyInfo.getProxyPort());
/* 137 */       if (proxyInfo.isProxyAuthentication()) {
/* 138 */         user = proxyInfo.getProxyLogin();
/* 139 */         password = proxyInfo.getPlainProxyPassword();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     setAxisProperty("http.proxyHost", host);
/* 150 */     setAxisProperty("http.proxyPort", port);
/*     */     
/* 152 */     setSystemProperty("http.proxyHost", host);
/* 153 */     setSystemProperty("http.proxyPort", port);
/*     */     
/* 155 */     setAxisProperty("http.proxyUser", user);
/* 156 */     setSystemProperty("http.proxyUser", user);
/*     */     
/* 158 */     setAxisProperty("http.proxyPassword", password);
/* 159 */     setSystemProperty("http.proxyPassword", password);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JIRASoapSessionImpl(Logger logger, ConnectionCfg connectionCfg, AxisSessionCallback callback) throws ServiceException, MalformedURLException {
/* 165 */     this.logger = logger;
/* 166 */     URL portAddress = new URL(String.valueOf(connectionCfg.getUrl()) + "/rpc/soap/jirasoapservice-v2");
/* 167 */     JiraSoapServiceServiceLocator loc = new JiraSoapServiceServiceLocator();
/* 168 */     AbstractHttpSession.setUrl(portAddress);
/* 169 */     this.service = loc.getJirasoapserviceV2(portAddress);
/*     */     
/* 171 */     if (callback != null) {
/* 172 */       callback.configureRemoteService((Remote)this.service, connectionCfg);
/*     */     }
/*     */     
/* 175 */     setProxy();
/*     */     
/* 177 */     this.httpConnectionCfg = connectionCfg;
/*     */   }
/*     */   
/*     */   public void login(String userName, String password) throws RemoteApiException {
/*     */     try {
/* 182 */       this.token = this.service.login(userName, password);
/* 183 */     } catch (RemoteAuthenticationException e) {
/* 184 */       if (e != null && e.getFaultString() != null && 
/* 185 */         e.getFaultString().contains("The maximum number of failed login attempts")) {
/* 186 */         throw new RemoteApiLoginException("Due to multiple failed login attempts, you have been temporarily banned from using the remote API.\nTo re-enable the remote API please log into your server via the web interface", 
/*     */             
/* 188 */             e);
/*     */       }
/* 190 */       throw new RemoteApiLoginException("Authentication failed", e);
/*     */     }
/* 192 */     catch (RemoteException e) {
/* 193 */       throw new RemoteApiException(e.toString());
/*     */     } 
/* 195 */     this.loggedIn = true;
/*     */   }
/*     */   
/*     */   public void logout() {
/*     */     try {
/* 200 */       if (this.service.logout(this.token)) {
/* 201 */         this.token = null;
/* 202 */         this.loggedIn = false;
/*     */       } 
/* 204 */     } catch (RemoteException remoteException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void logWork(JIRAIssue issue, String timeSpent, Calendar startDate, String comment, boolean updateEstimate, String newEstimate) throws RemoteApiException {
/* 212 */     RemoteWorklog workLog = new RemoteWorklog();
/* 213 */     workLog.setStartDate(startDate);
/* 214 */     workLog.setTimeSpent(timeSpent);
/* 215 */     if (comment != null) {
/* 216 */       workLog.setComment(comment);
/*     */     }
/*     */     try {
/* 219 */       if (updateEstimate) {
/* 220 */         if (newEstimate != null) {
/* 221 */           this.service.addWorklogWithNewRemainingEstimate(this.token, issue.getKey(), workLog, newEstimate);
/*     */         } else {
/* 223 */           this.service.addWorklogAndAutoAdjustRemainingEstimate(this.token, issue.getKey(), workLog);
/*     */         } 
/*     */       } else {
/* 226 */         this.service.addWorklogAndRetainRemainingEstimate(this.token, issue.getKey(), workLog);
/*     */       } 
/* 228 */     } catch (RemoteException e) {
/* 229 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public JIRAIssue createIssue(JIRAIssue issue) throws RemoteApiException {
/* 234 */     RemoteIssue remoteIssue = new RemoteIssue();
/*     */     
/* 236 */     remoteIssue.setProject(issue.getProjectKey());
/* 237 */     remoteIssue.setType(String.valueOf(issue.getTypeConstant().getId()));
/* 238 */     remoteIssue.setSummary(issue.getSummary());
/* 239 */     if (issue.getPriorityConstant().getId() != -1000L) {
/* 240 */       remoteIssue.setPriority(String.valueOf(issue.getPriorityConstant().getId()));
/*     */     }
/*     */     
/* 243 */     if (issue.getDescription() != null) {
/* 244 */       remoteIssue.setDescription(issue.getDescription());
/*     */     }
/* 246 */     if (issue.getAssignee() != null) {
/* 247 */       remoteIssue.setAssignee(issue.getAssignee());
/*     */     }
/*     */     
/* 250 */     List<JIRAConstant> components = issue.getComponents();
/* 251 */     if (components != null && components.size() > 0) {
/* 252 */       RemoteComponent[] remoteComponents = new RemoteComponent[components.size()];
/* 253 */       int i = 0;
/* 254 */       for (JIRAConstant component : components) {
/* 255 */         remoteComponents[i] = new RemoteComponent(String.valueOf(component.getId()), component.getName());
/* 256 */         i++;
/*     */       } 
/* 258 */       remoteIssue.setComponents(remoteComponents);
/*     */     } 
/*     */     
/* 261 */     List<JIRAConstant> versions = issue.getAffectsVersions();
/* 262 */     if (versions != null && versions.size() > 0) {
/* 263 */       RemoteVersion[] remoteVersions = new RemoteVersion[versions.size()];
/* 264 */       int i = 0;
/* 265 */       for (JIRAConstant version : versions) {
/* 266 */         remoteVersions[i] = new RemoteVersion();
/* 267 */         remoteVersions[i].setId(String.valueOf(version.getId()));
/* 268 */         i++;
/*     */       } 
/* 270 */       remoteIssue.setAffectsVersions(remoteVersions);
/*     */     } 
/*     */     
/* 273 */     List<JIRAConstant> fixVersions = issue.getFixVersions();
/* 274 */     if (fixVersions != null && fixVersions.size() > 0) {
/* 275 */       RemoteVersion[] remoteFixVersions = new RemoteVersion[fixVersions.size()];
/* 276 */       int i = 0;
/* 277 */       for (JIRAConstant version : fixVersions) {
/* 278 */         remoteFixVersions[i] = new RemoteVersion();
/* 279 */         remoteFixVersions[i].setId(String.valueOf(version.getId()));
/* 280 */         i++;
/*     */       } 
/* 282 */       remoteIssue.setFixVersions(remoteFixVersions);
/*     */     } 
/*     */     
/*     */     try {
/* 286 */       remoteIssue = this.service.createIssue(this.token, remoteIssue);
/* 287 */     } catch (RemoteException e) {
/* 288 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */ 
/*     */     
/* 292 */     JIRAIssueBean retVal = new JIRAIssueBean(this.httpConnectionCfg.getUrl(), remoteIssue);
/*     */     
/* 294 */     retVal.setKey(remoteIssue.getKey());
/* 295 */     return (JIRAIssue)retVal;
/*     */   }
/*     */   
/*     */   public JIRAIssue getIssueDetails(JIRAIssue issue) throws RemoteApiException {
/* 299 */     RemoteSecurityLevel securityLevel = null;
/*     */     
/*     */     try {
/* 302 */       securityLevel = this.service.getSecurityLevel(this.token, issue.getKey());
/* 303 */     } catch (RemoteException e) {
/* 304 */       if (this.logger != null) {
/* 305 */         this.logger.warn(
/* 306 */             "Soap method 'getSecurityLevel' thrown exception. Probably there is no 'SecurityLevel' on JIRA (non enterprise version of JIRA).", 
/* 307 */             e);
/*     */       }
/* 309 */     } catch (ClassCastException e) {
/* 310 */       if (this.logger != null) {
/* 311 */         this.logger.warn(
/* 312 */             "Soap method 'getSecurityLevel' thrown ClassCastException. Probably some JIRA error.", e);
/*     */       }
/* 314 */     } catch (Exception e) {
/*     */       
/* 316 */       if (e instanceof org.xml.sax.SAXException && this.logger != null) {
/* 317 */         this.logger.warn(
/* 318 */             "Soap method 'getSecurityLevel' thrown SAXException. Probably some JIRA error.", e);
/*     */       }
/* 320 */       throw new RemoteApiException(e);
/*     */     } 
/*     */     
/*     */     try {
/* 324 */       RemoteIssue rIssue = this.service.getIssue(this.token, issue.getKey());
/*     */ 
/*     */       
/* 327 */       if (rIssue == null) {
/* 328 */         throw new RemoteApiException("Unable to retrieve issue details");
/*     */       }
/* 330 */       JIRAIssueBean issueBean = new JIRAIssueBean(issue);
/*     */       
/* 332 */       if (securityLevel != null) {
/* 333 */         issueBean.setSecurityLevel(
/* 334 */             new JIRASecurityLevelBean(Long.valueOf(securityLevel.getId()), securityLevel.getName()));
/*     */       }
/*     */       
/* 337 */       issueBean.setWikiDescription(rIssue.getDescription());
/*     */       
/* 339 */       RemoteVersion[] aVers = rIssue.getAffectsVersions();
/* 340 */       List<JIRAConstant> av = new ArrayList<JIRAConstant>(); byte b1; int i; RemoteVersion[] arrayOfRemoteVersion1;
/* 341 */       for (i = (arrayOfRemoteVersion1 = aVers).length, b1 = 0; b1 < i; ) { RemoteVersion v = arrayOfRemoteVersion1[b1];
/* 342 */         av.add(new JIRAVersionBean(Long.valueOf(v.getId()).longValue(), v.getName(), v.isReleased())); b1++; }
/*     */       
/* 344 */       issueBean.setAffectsVersions(av);
/*     */       
/* 346 */       RemoteVersion[] fVers = rIssue.getFixVersions();
/* 347 */       List<JIRAConstant> fv = new ArrayList<JIRAConstant>(); byte b2; int j; RemoteVersion[] arrayOfRemoteVersion2;
/* 348 */       for (j = (arrayOfRemoteVersion2 = fVers).length, b2 = 0; b2 < j; ) { RemoteVersion v = arrayOfRemoteVersion2[b2];
/* 349 */         fv.add(new JIRAVersionBean(Long.valueOf(v.getId()).longValue(), v.getName(), v.isReleased())); b2++; }
/*     */       
/* 351 */       issueBean.setFixVersions(fv);
/*     */       
/* 353 */       RemoteComponent[] comps = rIssue.getComponents();
/* 354 */       List<JIRAConstant> c = new ArrayList<JIRAConstant>(); byte b3; int k; RemoteComponent[] arrayOfRemoteComponent1;
/* 355 */       for (k = (arrayOfRemoteComponent1 = comps).length, b3 = 0; b3 < k; ) { RemoteComponent rc = arrayOfRemoteComponent1[b3];
/* 356 */         c.add(new JIRAComponentBean(Long.valueOf(rc.getId()).longValue(), rc.getName())); b3++; }
/*     */       
/* 358 */       issueBean.setComponents(c);
/*     */       
/* 360 */       issueBean.setProjectKey(rIssue.getProject());
/* 361 */       issueBean.setSummary(rIssue.getSummary());
/*     */       
/* 363 */       issueBean.setApiIssueObject(rIssue);
/*     */       
/* 365 */       return (JIRAIssue)issueBean;
/*     */     }
/* 367 */     catch (RemoteException e) {
/* 368 */       throw new RemoteApiException(e.toString(), e);
/* 369 */     } catch (ClassCastException e) {
/* 370 */       throw new RemoteApiException(e.toString(), e);
/* 371 */     } catch (Exception e) {
/*     */ 
/*     */ 
/*     */       
/* 375 */       if (e instanceof org.xml.sax.SAXException && this.logger != null) {
/* 376 */         this.logger.warn("Soap method 'getIssue' thrown SAXException. Probably some JIRA error or weird JIRA SOAP plugin.", 
/* 377 */             e);
/*     */       }
/* 379 */       throw new RemoteApiException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addComment(String issueKey, String comment) throws RemoteApiException {
/*     */     try {
/* 386 */       RemoteComment rComment = new RemoteComment();
/* 387 */       rComment.setBody(comment);
/* 388 */       this.service.addComment(this.token, issueKey, rComment);
/* 389 */     } catch (RemoteException e) {
/* 390 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAttachment(String issueKey, String name, byte[] content) throws RemoteApiException {
/* 395 */     String[] encodedContents = { new String((new Base64()).encode(content)) };
/* 396 */     String[] names = { name };
/*     */     try {
/* 398 */       this.service.addBase64EncodedAttachmentsToIssue(this.token, issueKey, names, encodedContents);
/* 399 */     } catch (RemoteException e) {
/* 400 */       if (e.toString().startsWith("java.lang.OutOfMemoryError")) {
/* 401 */         throw new RemoteApiException("Attachment size is too large, try uploading directly from web browser", e);
/*     */       }
/* 403 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAProject> getProjects() throws RemoteApiException {
/*     */     try {
/* 409 */       RemoteProject[] projects = this.service.getProjectsNoSchemes(this.token);
/* 410 */       List<JIRAProject> projectList = new ArrayList<JIRAProject>(projects.length);
/* 411 */       if (projects != null) {
/* 412 */         byte b; int i; RemoteProject[] arrayOfRemoteProject; for (i = (arrayOfRemoteProject = projects).length, b = 0; b < i; ) { RemoteProject p = arrayOfRemoteProject[b];
/* 413 */           JIRAProjectBean project = new JIRAProjectBean();
/*     */           
/* 415 */           project.setName(p.getName());
/* 416 */           project.setKey(p.getKey());
/* 417 */           project.setDescription(p.getDescription());
/* 418 */           project.setUrl(p.getUrl());
/* 419 */           project.setLead(p.getLead());
/* 420 */           project.setId(Long.valueOf(p.getId()).longValue());
/*     */           
/* 422 */           projectList.add(project);
/*     */           b++; }
/*     */       
/*     */       } 
/* 426 */       return projectList;
/* 427 */     } catch (RemoteException e) {
/* 428 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<JIRAConstant> issueTableToList(RemoteIssueType[] types) throws MalformedURLException {
/* 433 */     List<JIRAConstant> typesList = new ArrayList<JIRAConstant>();
/* 434 */     if (types != null) {
/* 435 */       byte b; int i; RemoteIssueType[] arrayOfRemoteIssueType; for (i = (arrayOfRemoteIssueType = types).length, b = 0; b < i; ) { RemoteIssueType type = arrayOfRemoteIssueType[b];
/* 436 */         typesList.add(new JIRAIssueTypeBean(Long.valueOf(type.getId()).longValue(), type.getName(), new URL(type.getIcon()))); b++; }
/*     */     
/*     */     } 
/* 439 */     return typesList;
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getIssueTypes() throws RemoteApiException {
/*     */     try {
/* 444 */       return issueTableToList(this.service.getIssueTypes(this.token));
/* 445 */     } catch (RemoteException e) {
/* 446 */       throw new RemoteApiException(e.toString(), e);
/* 447 */     } catch (MalformedURLException e) {
/* 448 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<JIRAConstant> getIssueTypesForProject(long projectId, String projectKey) throws RemoteApiException {
/*     */     try {
/* 455 */       return issueTableToList(this.service.getIssueTypesForProject(this.token, Long.valueOf(projectId).toString()));
/* 456 */     } catch (RemoteException e) {
/* 457 */       throw new RemoteApiException(e.toString(), e);
/* 458 */     } catch (MalformedURLException e) {
/* 459 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getSubtaskIssueTypes() throws RemoteApiException {
/*     */     try {
/* 465 */       return issueTableToList(this.service.getSubTaskIssueTypes(this.token));
/* 466 */     } catch (RemoteException e) {
/* 467 */       throw new RemoteApiException(e.toString(), e);
/* 468 */     } catch (MalformedURLException e) {
/* 469 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<JIRAConstant> getSubtaskIssueTypesForProject(long projectId, String projectKey) throws RemoteApiException {
/*     */     try {
/* 476 */       return issueTableToList(this.service.getSubTaskIssueTypesForProject(this.token, Long.valueOf(projectId).toString()));
/* 477 */     } catch (RemoteException e) {
/* 478 */       throw new RemoteApiException(e.toString(), e);
/* 479 */     } catch (MalformedURLException e) {
/* 480 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getStatuses() throws RemoteApiException {
/*     */     try {
/* 486 */       RemoteStatus[] statuses = this.service.getStatuses(this.token);
/*     */       
/* 488 */       List<JIRAConstant> statusesList = new ArrayList<JIRAConstant>();
/* 489 */       if (statuses != null) {
/* 490 */         byte b; int i; RemoteStatus[] arrayOfRemoteStatus; for (i = (arrayOfRemoteStatus = statuses).length, b = 0; b < i; ) { RemoteStatus status = arrayOfRemoteStatus[b];
/* 491 */           statusesList.add(new JIRAStatusBean(
/* 492 */                 Long.valueOf(status.getId()).longValue(), status.getName(), new URL(status.getIcon()))); b++; }
/*     */       
/*     */       } 
/* 495 */       return statusesList;
/* 496 */     } catch (RemoteException e) {
/* 497 */       throw new RemoteApiException(e.toString(), e);
/* 498 */     } catch (MalformedURLException e) {
/* 499 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAComponentBean> getComponents(String projectKey) throws RemoteApiException {
/*     */     try {
/* 505 */       RemoteComponent[] components = this.service.getComponents(this.token, projectKey);
/*     */       
/* 507 */       List<JIRAComponentBean> componentsList = new ArrayList<JIRAComponentBean>();
/* 508 */       if (components != null) {
/* 509 */         byte b; int i; RemoteComponent[] arrayOfRemoteComponent; for (i = (arrayOfRemoteComponent = components).length, b = 0; b < i; ) { RemoteComponent c = arrayOfRemoteComponent[b];
/* 510 */           componentsList.add(new JIRAComponentBean(Long.valueOf(c.getId()).longValue(), c.getName())); b++; }
/*     */       
/*     */       } 
/* 513 */       return componentsList;
/* 514 */     } catch (RemoteException e) {
/* 515 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAVersionBean> getVersions(String projectKey) throws RemoteApiException {
/*     */     try {
/* 521 */       RemoteVersion[] versions = this.service.getVersions(this.token, projectKey);
/*     */       
/* 523 */       List<JIRAVersionBean> versionsList = new ArrayList<JIRAVersionBean>();
/* 524 */       if (versions != null) {
/* 525 */         byte b; int i; RemoteVersion[] arrayOfRemoteVersion; for (i = (arrayOfRemoteVersion = versions).length, b = 0; b < i; ) { RemoteVersion v = arrayOfRemoteVersion[b];
/* 526 */           versionsList.add(new JIRAVersionBean(Long.valueOf(v.getId()).longValue(), v.getName(), v.isReleased())); b++; }
/*     */       
/*     */       } 
/* 529 */       return versionsList;
/* 530 */     } catch (RemoteException e) {
/* 531 */       throw new RemoteApiException(
/* 532 */           (e.toString() != null) ? e.toString() : ("Cannot fetch project '" + projectKey + "' versions"), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAPriorityBean> getPriorities() throws RemoteApiException {
/*     */     try {
/* 538 */       RemotePriority[] priorities = this.service.getPriorities(this.token);
/*     */       
/* 540 */       List<JIRAPriorityBean> prioritiesList = new ArrayList<JIRAPriorityBean>();
/* 541 */       int i = 0;
/* 542 */       if (priorities != null) {
/* 543 */         byte b; int j; RemotePriority[] arrayOfRemotePriority; for (j = (arrayOfRemotePriority = priorities).length, b = 0; b < j; ) { RemotePriority p = arrayOfRemotePriority[b];
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 548 */           prioritiesList.add(new JIRAPriorityBean(Long.valueOf(p.getId()).longValue(), i, p.getName(), new URL(p.getIcon())));
/* 549 */           i++; b++; }
/*     */       
/*     */       } 
/* 552 */       return prioritiesList;
/* 553 */     } catch (RemoteException e) {
/* 554 */       throw new RemoteApiException(e.toString(), e);
/* 555 */     } catch (MalformedURLException e) {
/* 556 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAResolutionBean> getResolutions() throws RemoteApiException {
/*     */     try {
/* 562 */       RemoteResolution[] resolutions = this.service.getResolutions(this.token);
/*     */       
/* 564 */       List<JIRAResolutionBean> resolutionsList = new ArrayList<JIRAResolutionBean>();
/* 565 */       if (resolutions != null) {
/* 566 */         byte b; int i; RemoteResolution[] arrayOfRemoteResolution; for (i = (arrayOfRemoteResolution = resolutions).length, b = 0; b < i; ) { RemoteResolution p = arrayOfRemoteResolution[b];
/* 567 */           resolutionsList.add(new JIRAResolutionBean(Long.valueOf(p.getId()).longValue(), p.getName())); b++; }
/*     */       
/*     */       } 
/* 570 */       return resolutionsList;
/* 571 */     } catch (RemoteException e) {
/* 572 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAQueryFragment> getSavedFilters() throws RemoteApiException {
/*     */     try {
/* 578 */       RemoteFilter[] filters = this.service.getSavedFilters(this.token);
/*     */       
/* 580 */       List<JIRAQueryFragment> filtersList = new ArrayList<JIRAQueryFragment>((filters != null) ? filters.length : 0);
/* 581 */       if (filters != null) {
/* 582 */         byte b; int i; RemoteFilter[] arrayOfRemoteFilter; for (i = (arrayOfRemoteFilter = filters).length, b = 0; b < i; ) { RemoteFilter f = arrayOfRemoteFilter[b];
/* 583 */           if (f != null)
/*     */           {
/*     */             
/* 586 */             filtersList.add(new JIRASavedFilterBean(f.getName(), Long.valueOf(f.getId()).longValue())); }  b++; }
/*     */       
/*     */       } 
/* 589 */       return filtersList;
/* 590 */     } catch (RemoteException e) {
/* 591 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setField(JIRAIssue issue, String fieldId, String value) throws RemoteApiException {
/* 597 */     setField(issue, fieldId, new String[] { value });
/*     */   }
/*     */   
/*     */   public void setField(JIRAIssue issue, String fieldId, String[] values) throws RemoteApiException {
/* 601 */     RemoteFieldValue v = new RemoteFieldValue();
/* 602 */     RemoteFieldValue[] vTable = { v };
/* 603 */     v.setId(fieldId);
/* 604 */     v.setValues(values);
/*     */     try {
/* 606 */       this.service.updateIssue(this.token, issue.getKey(), vTable);
/* 607 */     } catch (RemoteException e) {
/* 608 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFields(JIRAIssue issue, List<JIRAActionField> fields) throws RemoteApiException {
/* 613 */     RemoteFieldValue[] vTable = new RemoteFieldValue[fields.size()];
/* 614 */     int i = 0;
/* 615 */     for (JIRAActionField field : fields) {
/* 616 */       vTable[i] = new RemoteFieldValue();
/* 617 */       vTable[i].setId(field.getFieldId());
/* 618 */       vTable[i].setValues((String[])field.getValues().toArray((Object[])new String[field.getValues().size()]));
/* 619 */       i++;
/*     */     } 
/*     */     try {
/* 622 */       this.service.updateIssue(this.token, issue.getKey(), vTable);
/* 623 */     } catch (RemoteException e) {
/* 624 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAAction> getAvailableActions(JIRAIssue issue) throws RemoteApiException {
/*     */     try {
/* 630 */       RemoteNamedObject[] actions = this.service.getAvailableActions(this.token, issue.getKey());
/* 631 */       List<JIRAAction> actionList = new ArrayList<JIRAAction>((actions != null) ? actions.length : 0);
/* 632 */       if (actions != null) {
/* 633 */         byte b; int i; RemoteNamedObject[] arrayOfRemoteNamedObject; for (i = (arrayOfRemoteNamedObject = actions).length, b = 0; b < i; ) { RemoteNamedObject action = arrayOfRemoteNamedObject[b];
/* 634 */           actionList.add(new JIRAActionBean(Long.valueOf(action.getId()).longValue(), action.getName())); b++; }
/*     */       
/*     */       } 
/* 637 */       return actionList;
/* 638 */     } catch (RemoteException e) {
/* 639 */       throw new RemoteApiException(e.toString(), e);
/* 640 */     } catch (ClassCastException e) {
/* 641 */       throw new RemoteApiException(e.toString(), e);
/* 642 */     } catch (Exception e) {
/*     */       
/* 644 */       if (e instanceof org.xml.sax.SAXException && this.logger != null) {
/* 645 */         this.logger.warn(
/* 646 */             "Soap method 'getSecurityLevel' thrown SAXException. Probably some JIRA error.", e);
/*     */       }
/* 648 */       throw new RemoteApiException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRASecurityLevelBean> getSecurityLevels(String projectKey) throws RemoteApiException {
/* 653 */     List<JIRASecurityLevelBean> levels = new ArrayList<JIRASecurityLevelBean>();
/*     */     try {
/* 655 */       RemoteSecurityLevel[] remoteSecurityLevels = this.service.getSecurityLevels(this.token, projectKey); byte b; int i; RemoteSecurityLevel[] arrayOfRemoteSecurityLevel1;
/* 656 */       for (i = (arrayOfRemoteSecurityLevel1 = remoteSecurityLevels).length, b = 0; b < i; ) { RemoteSecurityLevel remoteLevel = arrayOfRemoteSecurityLevel1[b];
/* 657 */         levels.add(new JIRASecurityLevelBean(Long.valueOf(remoteLevel.getId()), remoteLevel.getName())); b++; }
/*     */     
/* 659 */     } catch (RemoteException e) {
/* 660 */       throw new RemoteApiException(e);
/*     */     } 
/*     */     
/* 663 */     return levels;
/*     */   }
/*     */   
/*     */   public List<JIRAActionField> getFieldsForAction(JIRAIssue issue, JIRAAction action) throws RemoteApiException {
/*     */     try {
/* 668 */       RemoteField[] fields = this.service.getFieldsForAction(
/* 669 */           this.token, issue.getKey(), Long.valueOf(action.getId()).toString());
/* 670 */       List<JIRAActionField> fieldList = new ArrayList<JIRAActionField>(fields.length); byte b; int i; RemoteField[] arrayOfRemoteField1;
/* 671 */       for (i = (arrayOfRemoteField1 = fields).length, b = 0; b < i; ) { RemoteField f = arrayOfRemoteField1[b];
/* 672 */         fieldList.add(new JIRAActionFieldBean(f.getId(), f.getName())); b++; }
/*     */       
/* 674 */       return fieldList;
/* 675 */     } catch (RemoteException e) {
/* 676 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void progressWorkflowAction(JIRAIssue issue, JIRAAction action, List<JIRAActionField> fields) throws RemoteApiException {
/*     */     try {
/* 683 */       if (fields == null) {
/* 684 */         RemoteFieldValue[] dummyValues = new RemoteFieldValue[0];
/* 685 */         this.service.progressWorkflowAction(this.token, issue.getKey(), String.valueOf(action.getId()), dummyValues);
/*     */       } else {
/*     */         
/* 688 */         CopyOnWriteArrayList<JIRAActionField> safeFields = new CopyOnWriteArrayList<JIRAActionField>(fields);
/*     */         
/* 690 */         for (JIRAActionField field : safeFields) {
/* 691 */           if (field.getValues() == null) {
/* 692 */             safeFields.remove(field);
/*     */           }
/*     */         } 
/*     */         
/* 696 */         int i = 0;
/* 697 */         RemoteFieldValue[] values = new RemoteFieldValue[safeFields.size()];
/*     */         
/* 699 */         for (JIRAActionField field : safeFields) {
/* 700 */           List<String> fieldValues = field.getValues();
/* 701 */           String[] fieldValueTable = fieldValues.<String>toArray(new String[fieldValues.size()]);
/* 702 */           values[i] = new RemoteFieldValue(field.getFieldId(), fieldValueTable);
/* 703 */           i++;
/*     */         } 
/* 705 */         this.service.progressWorkflowAction(this.token, issue.getKey(), String.valueOf(action.getId()), values);
/*     */       } 
/* 707 */     } catch (RemoteException e) {
/* 708 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<JIRAComment> getComments(JIRAIssue issue) throws RemoteApiException {
/*     */     try {
/* 714 */       RemoteComment[] comments = this.service.getComments(this.token, issue.getKey());
/* 715 */       if (comments == null) {
/* 716 */         throw new RemoteApiException("Unable to retrieve comments");
/*     */       }
/*     */       
/* 719 */       List<JIRAComment> commentsList = new ArrayList<JIRAComment>(comments.length); byte b; int i; RemoteComment[] arrayOfRemoteComment1;
/* 720 */       for (i = (arrayOfRemoteComment1 = comments).length, b = 0; b < i; ) { RemoteComment c = arrayOfRemoteComment1[b];
/* 721 */         commentsList.add(new JIRACommentBean(c.getId(), c.getAuthor(), c.getBody(), c.getCreated())); b++; }
/*     */       
/* 723 */       return commentsList;
/* 724 */     } catch (RemoteException e) {
/* 725 */       throw new RemoteApiException(e.toString(), e);
/* 726 */     } catch (IllegalArgumentException e) {
/*     */       
/* 728 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public JIRAUserBean getUser(String loginName) throws RemoteApiException, JiraUserNotFoundException {
/*     */     try {
/* 734 */       RemoteUser ru = this.service.getUser(this.token, loginName);
/* 735 */       if (ru == null) {
/* 736 */         throw new JiraUserNotFoundException("User Name for " + loginName + " not found");
/*     */       }
/* 738 */       return new JIRAUserBean(-1L, ru.getFullname(), ru.getName())
/*     */         {
/*     */           public String getQueryStringFragment() {
/* 741 */             return null;
/*     */           }
/*     */           
/*     */           public JIRAQueryFragment getClone() {
/* 745 */             return null;
/*     */           }
/*     */         };
/* 748 */     } catch (RemoteException e) {
/* 749 */       throw new RemoteApiException(e.toString(), e);
/* 750 */     } catch (ClassCastException e) {
/* 751 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isLoggedIn() {
/* 756 */     return this.loggedIn;
/*     */   }
/*     */   
/*     */   public Collection<JIRAAttachment> getIssueAttachements(JIRAIssue issue) throws RemoteApiException {
/*     */     try {
/* 761 */       RemoteAttachment[] attachements = this.service.getAttachmentsFromIssue(this.token, issue.getKey());
/*     */       
/* 763 */       List<JIRAAttachment> attachmentList = new ArrayList<JIRAAttachment>((attachements != null) ? attachements.length : 0);
/* 764 */       if (attachements != null) {
/* 765 */         byte b; int i; RemoteAttachment[] arrayOfRemoteAttachment; for (i = (arrayOfRemoteAttachment = attachements).length, b = 0; b < i; ) { RemoteAttachment a = arrayOfRemoteAttachment[b];
/* 766 */           attachmentList.add(new JIRAAttachment(a.getId(), 
/* 767 */                 a.getAuthor(), a.getFilename(), a.getFilesize().longValue(), 
/* 768 */                 a.getMimetype(), a.getCreated())); b++; }
/*     */       
/*     */       } 
/* 771 */       return attachmentList;
/* 772 */     } catch (RemoteException e) {
/* 773 */       throw new RemoteApiException(e.toString(), e);
/* 774 */     } catch (ClassCastException e) {
/* 775 */       throw new RemoteApiException("Soap axis remote request failed to properly cast response while acquiring issue attachments", 
/* 776 */           e);
/* 777 */     } catch (Exception e) {
/* 778 */       if (e.getMessage().contains("Bad types")) {
/* 779 */         throw new RemoteApiException("Soap axis remote request failed to properly cast response while acquiring issue attachments", 
/* 780 */             e);
/*     */       }
/* 782 */       throw new RemoteApiException(e.toString(), e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\JIRASoapSessionImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */