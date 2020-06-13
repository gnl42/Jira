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
/*     */ import com.atlassian.connector.commons.jira.rest.JiraRestSessionImpl;
/*     */ import com.atlassian.connector.commons.jira.rss.JIRAException;
/*     */ import com.atlassian.theplugin.commons.ServerType;
/*     */ import com.atlassian.theplugin.commons.configuration.ConfigurationFactory;
/*     */ import com.atlassian.theplugin.commons.jira.JiraServerData;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.util.HttpConfigurableAdapter;
/*     */ import com.atlassian.theplugin.commons.util.Logger;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ 
/*     */ 
/*     */ public class JiraRESTFacade2Impl
/*     */   implements JIRAServerFacade2, JiraRESTSupportTester
/*     */ {
/*     */   private static Logger logger;
/*     */   private final Map<ConnectionCfg, JiraRestSessionImpl> sessions;
/*     */   
/*     */   public JiraRESTFacade2Impl() {
/*  41 */     this.sessions = new HashMap<ConnectionCfg, JiraRestSessionImpl>();
/*     */   }
/*     */   public void reset() {
/*  44 */     this.sessions.clear();
/*     */   }
/*     */   
/*     */   public boolean usesRest(JiraServerData jiraServerData) {
/*     */     try {
/*  49 */       return get((ConnectionCfg)jiraServerData).supportsRest();
/*  50 */     } catch (JIRAException jIRAException) {
/*  51 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setLogger(Logger logger) {
/*  56 */     JiraRESTFacade2Impl.logger = logger;
/*     */   }
/*     */   
/*     */   public boolean supportsRest(ConnectionCfg server) throws JIRAException {
/*  60 */     JiraRestSessionImpl session = get(server);
/*  61 */     return session.supportsRest();
/*     */   }
/*     */   
/*     */   public List<JIRAIssue> getIssues(ConnectionCfg server, JiraFilter filter, String sort, String sortOrder, int start, int size) throws JIRAException {
/*  65 */     JiraRestSessionImpl session = get(server);
/*  66 */     return session.getIssues(filter, sort, sortOrder, start, size);
/*     */   }
/*     */   
/*     */   public List<JIRAIssue> getIssues(JiraServerData server, String query, String sort, String sortOrder, int start, int size) throws JIRAException {
/*  70 */     JiraRestSessionImpl session = get((ConnectionCfg)server);
/*  71 */     return session.getIssues(query, sort, sortOrder, start, size);
/*     */   }
/*     */   
/*     */   public List<JIRAIssue> getSavedFilterIssues(ConnectionCfg server, JIRASavedFilter filter, String sort, String sortOrder, int start, int size) throws JIRAException {
/*  75 */     JiraRestSessionImpl session = get(server);
/*  76 */     return session.getSavedFilterIssues(filter, sort, sortOrder, start, size);
/*     */   }
/*     */   
/*     */   public List<JIRAProject> getProjects(final ConnectionCfg server) throws JIRAException {
/*  80 */     return withJiraException(new Callable<List<JIRAProject>>() {
/*     */           public List<JIRAProject> call() throws Exception {
/*  82 */             return JiraRESTFacade2Impl.this.get(server).getProjects();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAProject> getProjectsForIssueCreation(final ConnectionCfg server) throws JIRAException {
/*  88 */     return withJiraException(new Callable<List<JIRAProject>>() {
/*     */           public List<JIRAProject> call() throws Exception {
/*  90 */             return JiraRESTFacade2Impl.this.get(server).getProjectsForIssueCreation();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getStatuses(final ConnectionCfg server) throws JIRAException {
/*  96 */     return withJiraException(new Callable<List<JIRAConstant>>() {
/*     */           public List<JIRAConstant> call() throws Exception {
/*  98 */             return JiraRESTFacade2Impl.this.get(server).getStatuses();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getIssueTypes(final ConnectionCfg server) throws JIRAException {
/* 104 */     return withJiraException(new Callable<List<JIRAConstant>>() {
/*     */           public List<JIRAConstant> call() throws Exception {
/* 106 */             return JiraRESTFacade2Impl.this.get(server).getIssueTypes();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public List<JIRAConstant> getIssueTypesForProject(final ConnectionCfg server, final long projectId, final String projectKey) throws JIRAException {
/* 113 */     return withJiraException(new Callable<List<JIRAConstant>>() {
/*     */           public List<JIRAConstant> call() throws Exception {
/* 115 */             return JiraRESTFacade2Impl.this.get(server).getIssueTypesForProject(projectId, projectKey);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getSubtaskIssueTypes(final ConnectionCfg server) throws JIRAException {
/* 121 */     return withJiraException(new Callable<List<JIRAConstant>>() {
/*     */           public List<JIRAConstant> call() throws Exception {
/* 123 */             return JiraRESTFacade2Impl.this.get(server).getSubtaskIssueTypes();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public List<JIRAConstant> getSubtaskIssueTypesForProject(final ConnectionCfg server, final long projectId, final String projectKey) throws JIRAException {
/* 130 */     return withJiraException(new Callable<List<JIRAConstant>>() {
/*     */           public List<JIRAConstant> call() throws Exception {
/* 132 */             return JiraRESTFacade2Impl.this.get(server).getSubtaskIssueTypesForProject(projectId, projectKey);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAQueryFragment> getSavedFilters(final ConnectionCfg server) throws JIRAException {
/* 138 */     return withJiraException(new Callable<List<JIRAQueryFragment>>() {
/*     */           public List<JIRAQueryFragment> call() throws Exception {
/* 140 */             return JiraRESTFacade2Impl.this.get(server).getSavedFilters();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAComponentBean> getComponents(final ConnectionCfg server, final String projectKey) throws JIRAException {
/* 146 */     return withJiraException(new Callable<List<JIRAComponentBean>>() {
/*     */           public List<JIRAComponentBean> call() throws Exception {
/* 148 */             return JiraRESTFacade2Impl.this.get(server).getComponents(projectKey);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAVersionBean> getVersions(final ConnectionCfg server, final String projectKey) throws JIRAException {
/* 154 */     return withJiraException(new Callable<List<JIRAVersionBean>>() {
/*     */           public List<JIRAVersionBean> call() throws Exception {
/* 156 */             return JiraRESTFacade2Impl.this.get(server).getVersions(projectKey);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAPriorityBean> getPriorities(final ConnectionCfg server) throws JIRAException {
/* 162 */     return withJiraException(new Callable<List<JIRAPriorityBean>>() {
/*     */           public List<JIRAPriorityBean> call() throws Exception {
/* 164 */             return JiraRESTFacade2Impl.this.get(server).getPriorities();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAResolutionBean> getResolutions(final ConnectionCfg server) throws JIRAException {
/* 170 */     return withJiraException(new Callable<List<JIRAResolutionBean>>() {
/*     */           public List<JIRAResolutionBean> call() throws Exception {
/* 172 */             return JiraRESTFacade2Impl.this.get(server).getResolutions();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAAction> getAvailableActions(final ConnectionCfg server, final JIRAIssue issue) throws JIRAException {
/* 178 */     return withJiraException(new Callable<List<JIRAAction>>() {
/*     */           public List<JIRAAction> call() throws Exception {
/* 180 */             return JiraRESTFacade2Impl.this.get(server).getAvailableActions(issue);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAActionField> getFieldsForAction(final ConnectionCfg server, final JIRAIssue issue, final JIRAAction action) throws JIRAException {
/* 186 */     return withJiraException(new Callable<List<JIRAActionField>>() {
/*     */           public List<JIRAActionField> call() throws Exception {
/* 188 */             return JiraRESTFacade2Impl.this.get(server).getFieldsForAction(issue, action);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void progressWorkflowAction(final ConnectionCfg server, final JIRAIssue issue, final JIRAAction action) throws JIRAException {
/* 194 */     withJiraException(new Callable() {
/*     */           public Object call() throws Exception {
/* 196 */             JiraRESTFacade2Impl.this.get(server).progressWorkflowAction(issue, action, null);
/* 197 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void progressWorkflowAction(final ConnectionCfg server, final JIRAIssue issue, final JIRAAction action, final List<JIRAActionField> fields) throws JIRAException {
/* 203 */     withJiraException(new Callable() {
/*     */           public Object call() throws Exception {
/* 205 */             JiraRESTFacade2Impl.this.get(server).progressWorkflowAction(issue, action, fields);
/* 206 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void addComment(final ConnectionCfg server, final String issueKey, final String comment) throws JIRAException {
/* 212 */     withJiraException(new Callable() {
/*     */           public Object call() throws Exception {
/* 214 */             JiraRESTFacade2Impl.this.get(server).addComment(issueKey, comment);
/* 215 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void addAttachment(final ConnectionCfg server, final String issueKey, final String name, final byte[] content) throws JIRAException {
/* 221 */     withJiraException(new Callable() {
/*     */           public Object call() throws Exception {
/* 223 */             JiraRESTFacade2Impl.this.get(server).addAttachment(issueKey, name, content);
/* 224 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public JIRAIssue createIssue(final ConnectionCfg server, final JIRAIssue issue) throws JIRAException {
/* 230 */     return withJiraException(new Callable<JIRAIssue>() {
/*     */           public JIRAIssue call() throws Exception {
/* 232 */             return JiraRESTFacade2Impl.this.get(server).createIssue(issue);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public JIRAIssue createSubtask(final JiraServerData server, final JIRAIssue parent, final JIRAIssue issue) throws JIRAException {
/* 238 */     return withJiraException(new Callable<JIRAIssue>() {
/*     */           public JIRAIssue call() throws Exception {
/* 240 */             return JiraRESTFacade2Impl.this.get((ConnectionCfg)server).createSubtask(parent, issue);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public JIRAIssue getIssue(ConnectionCfg server, String key) throws JIRAException {
/* 246 */     return get(server).getIssue(key);
/*     */   }
/*     */   
/*     */   public JIRAIssue getIssueDetails(final ConnectionCfg server, final JIRAIssue issue) throws JIRAException {
/* 250 */     return withJiraException(new Callable<JIRAIssue>() {
/*     */           public JIRAIssue call() throws Exception {
/* 252 */             return JiraRESTFacade2Impl.this.get(server).getIssueDetails(issue);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void logWork(final ConnectionCfg server, final JIRAIssue issue, final String timeSpent, final Calendar startDate, final String comment, final boolean updateEstimate, final String newEstimate) throws JIRAException {
/* 260 */     withJiraException(new Callable() {
/*     */           public Object call() throws Exception {
/* 262 */             JiraRESTFacade2Impl.this.get(server).logWork(issue, timeSpent, startDate, comment, updateEstimate, newEstimate);
/* 263 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void setField(final ConnectionCfg server, final JIRAIssue issue, final String fieldId, final String value) throws JIRAException {
/* 269 */     withJiraException(new Callable() {
/*     */           public Object call() throws Exception {
/* 271 */             JiraRESTFacade2Impl.this.get(server).setField(issue, fieldId, value);
/* 272 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void setField(final ConnectionCfg server, final JIRAIssue issue, final String fieldId, final String[] values) throws JIRAException {
/* 278 */     withJiraException(new Callable() {
/*     */           public Object call() throws Exception {
/* 280 */             JiraRESTFacade2Impl.this.get(server).setField(issue, fieldId, values);
/* 281 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void setFields(final ConnectionCfg server, final JIRAIssue issue, final List<JIRAActionField> fields) throws JIRAException {
/* 287 */     withJiraException(new Callable() {
/*     */           public Object call() throws Exception {
/* 289 */             JiraRESTFacade2Impl.this.get(server).setFields(issue, fields);
/* 290 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public JIRAUserBean getUser(final ConnectionCfg server, final String loginName) throws JIRAException, JiraUserNotFoundException {
/* 296 */     return withJiraException(new Callable<JIRAUserBean>() {
/*     */           public JIRAUserBean call() throws Exception {
/* 298 */             return JiraRESTFacade2Impl.this.get(server).getUser(loginName);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAComment> getComments(final ConnectionCfg server, final JIRAIssue issue) throws JIRAException {
/* 304 */     return withJiraException(new Callable<List<JIRAComment>>() {
/*     */           public List<JIRAComment> call() throws Exception {
/* 306 */             return JiraRESTFacade2Impl.this.get(server).getComments(issue);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public Collection<JIRAAttachment> getIssueAttachements(final ConnectionCfg server, final JIRAIssue issue) throws JIRAException {
/* 312 */     return withJiraException(new Callable<Collection<JIRAAttachment>>() {
/*     */           public Collection<JIRAAttachment> call() throws Exception {
/* 314 */             return JiraRESTFacade2Impl.this.get(server).getIssueAttachements(issue);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRASecurityLevelBean> getSecurityLevels(final ConnectionCfg server, final String projectKey) throws JIRAException {
/* 320 */     return withJiraException(new Callable<List<JIRASecurityLevelBean>>() {
/*     */           public List<JIRASecurityLevelBean> call() throws Exception {
/* 322 */             return JiraRESTFacade2Impl.this.get(server).getSecurityLevels(projectKey);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void testServerConnection(ConnectionCfg server) throws RemoteApiException {
/*     */     try {
/* 329 */       get(server).testConnection();
/* 330 */     } catch (JIRAException e) {
/* 331 */       throw new RemoteApiException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ServerType getServerType() {
/* 336 */     return ServerType.JIRA_SERVER;
/*     */   }
/*     */ 
/*     */   
/*     */   private JiraRestSessionImpl get(ConnectionCfg connectionCfg) throws JIRAException {
/* 341 */     JiraRestSessionImpl session = this.sessions.get(connectionCfg);
/* 342 */     if (session == null) {
/* 343 */       boolean useIdeaProxySettings = 
/* 344 */         ConfigurationFactory.getConfiguration().getGeneralConfigurationData().getUseIdeaProxySettings();
/* 345 */       HttpConfigurableAdapter proxyInfo = ConfigurationFactory.getConfiguration().transientGetHttpConfigurable();
/*     */       
/*     */       try {
/* 348 */         session = new JiraRestSessionImpl(connectionCfg, useIdeaProxySettings ? proxyInfo : null);
/* 349 */       } catch (URISyntaxException e) {
/* 350 */         throw new JIRAException(e.getMessage());
/*     */       } 
/* 352 */       this.sessions.put(connectionCfg, session);
/*     */     } 
/* 354 */     return session;
/*     */   }
/*     */   
/*     */   private <T> T withJiraException(Callable<T> callable) throws JIRAException {
/*     */     try {
/* 359 */       return callable.call();
/* 360 */     } catch (Exception e) {
/* 361 */       throw new JIRAException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JiraRESTFacade2Impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */