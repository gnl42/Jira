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
/*     */ import com.atlassian.connector.commons.jira.soap.AxisSessionCallback;
/*     */ import com.atlassian.theplugin.commons.ServerType;
/*     */ import com.atlassian.theplugin.commons.jira.JiraServerData;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;
/*     */ import com.atlassian.theplugin.commons.util.Logger;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
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
/*     */ public final class JIRAServerFacade2Impl
/*     */   implements JIRAServerFacade2
/*     */ {
/*     */   private static Logger logger;
/*     */   private JIRASoapAndXmlServerFacade2Impl soapAndXmlFacade;
/*     */   private JiraRESTFacade2Impl restFacade;
/*  56 */   private final Set<ConnectionCfg> restCapable = new HashSet<ConnectionCfg>();
/*  57 */   private final Set<ConnectionCfg> notRestCapable = new HashSet<ConnectionCfg>();
/*     */   
/*     */   JIRAServerFacade2 worker;
/*     */   
/*     */   public JIRAServerFacade2Impl(HttpSessionCallback callback, AxisSessionCallback axisCallback) {
/*  62 */     this.soapAndXmlFacade = new JIRASoapAndXmlServerFacade2Impl(callback, axisCallback);
/*  63 */     this.restFacade = new JiraRESTFacade2Impl();
/*     */     
/*  65 */     this.worker = (JIRAServerFacade2)Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { JIRAServerFacade2.class
/*  66 */         }, new InvocationHandler() {
/*     */           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
/*  68 */             ConnectionCfg connection = (ConnectionCfg)args[0];
/*  69 */             boolean useRest = JIRAServerFacade2Impl.this.restCapable.contains(connection);
/*  70 */             boolean useSoapAndXml = JIRAServerFacade2Impl.this.notRestCapable.contains(connection);
/*     */             try {
/*  72 */               if (!useRest && !useSoapAndXml) {
/*     */                 try {
/*  74 */                   if (JIRAServerFacade2Impl.this.restFacade.supportsRest(connection)) {
/*  75 */                     JIRAServerFacade2Impl.this.restCapable.add(connection);
/*  76 */                     useRest = true;
/*     */                   } else {
/*  78 */                     JIRAServerFacade2Impl.this.notRestCapable.add(connection);
/*     */                   } 
/*  80 */                 } catch (JIRAException e) {
/*  81 */                   Class[] exceptionTypes = method.getExceptionTypes(); byte b; int i; Class[] arrayOfClass1;
/*  82 */                   for (i = (arrayOfClass1 = exceptionTypes).length, b = 0; b < i; ) { Class<?> exceptionType = arrayOfClass1[b];
/*  83 */                     if (exceptionType.isAssignableFrom(JIRAException.class))
/*  84 */                       throw e; 
/*     */                     b++; }
/*     */                   
/*  87 */                   throw new RemoteApiException(e);
/*     */                 } 
/*     */               }
/*  90 */               if (useRest) {
/*  91 */                 return method.invoke(JIRAServerFacade2Impl.this.restFacade, args);
/*     */               }
/*  93 */               return method.invoke(JIRAServerFacade2Impl.this.soapAndXmlFacade, args);
/*  94 */             } catch (InvocationTargetException e) {
/*  95 */               throw e.getCause();
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 103 */     this.restFacade.reset();
/* 104 */     this.soapAndXmlFacade.reset();
/* 105 */     this.restCapable.clear();
/* 106 */     this.notRestCapable.clear();
/*     */   }
/*     */   
/*     */   public boolean usesRest(JiraServerData jiraServerData) {
/* 110 */     return this.worker.usesRest(jiraServerData);
/*     */   }
/*     */   
/*     */   public static void setLogger(Logger logger) {
/* 114 */     JIRASoapAndXmlServerFacade2Impl.setLogger(logger);
/* 115 */     JiraRESTFacade2Impl.setLogger(logger);
/*     */   }
/*     */   
/*     */   public ServerType getServerType() {
/* 119 */     return ServerType.JIRA_SERVER;
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
/*     */   public List<JIRAIssue> getIssues(ConnectionCfg httpConnectionCfg, JiraFilter filter, String sort, String sortOrder, int start, int size) throws JIRAException {
/* 132 */     return this.worker.getIssues(httpConnectionCfg, filter, sort, sortOrder, start, size);
/*     */   }
/*     */   
/*     */   public List<JIRAIssue> getIssues(JiraServerData server, String query, String sort, String sortOrder, int start, int size) throws JIRAException {
/* 136 */     return this.worker.getIssues(server, query, sort, sortOrder, start, size);
/*     */   }
/*     */   
/*     */   public List<JIRAIssue> getSavedFilterIssues(ConnectionCfg httpConnectionCfg, JIRASavedFilter filter, String sort, String sortOrder, int start, int size) throws JIRAException {
/* 140 */     return this.worker.getSavedFilterIssues(httpConnectionCfg, filter, sort, sortOrder, start, size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<JIRAProject> getProjects(ConnectionCfg httpConnectionCfg) throws JIRAException {
/* 148 */     return this.worker.getProjects(httpConnectionCfg);
/*     */   }
/*     */   
/*     */   public List<JIRAProject> getProjectsForIssueCreation(ConnectionCfg httpConnectionCfg) throws JIRAException {
/* 152 */     return this.worker.getProjectsForIssueCreation(httpConnectionCfg);
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getStatuses(ConnectionCfg httpConnectionCfg) throws JIRAException {
/* 156 */     return this.worker.getStatuses(httpConnectionCfg);
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getIssueTypes(ConnectionCfg httpConnectionCfg) throws JIRAException {
/* 160 */     return this.worker.getIssueTypes(httpConnectionCfg);
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getIssueTypesForProject(ConnectionCfg httpConnectionCfg, long projectId, String project) throws JIRAException {
/* 164 */     return this.worker.getIssueTypesForProject(httpConnectionCfg, projectId, project);
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getSubtaskIssueTypes(ConnectionCfg httpConnectionCfg) throws JIRAException {
/* 168 */     return this.worker.getSubtaskIssueTypes(httpConnectionCfg);
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getSubtaskIssueTypesForProject(ConnectionCfg httpConnectionCfg, long projectId, String project) throws JIRAException {
/* 172 */     return this.worker.getSubtaskIssueTypesForProject(httpConnectionCfg, projectId, project);
/*     */   }
/*     */   
/*     */   public List<JIRAQueryFragment> getSavedFilters(ConnectionCfg httpConnectionCfg) throws JIRAException {
/* 176 */     return this.worker.getSavedFilters(httpConnectionCfg);
/*     */   }
/*     */   
/*     */   public List<JIRAComponentBean> getComponents(ConnectionCfg httpConnectionCfg, String projectKey) throws JIRAException {
/* 180 */     return this.worker.getComponents(httpConnectionCfg, projectKey);
/*     */   }
/*     */   
/*     */   public List<JIRAVersionBean> getVersions(ConnectionCfg httpConnectionCfg, String projectKey) throws JIRAException {
/* 184 */     return this.worker.getVersions(httpConnectionCfg, projectKey);
/*     */   }
/*     */   
/*     */   public List<JIRAPriorityBean> getPriorities(ConnectionCfg httpConnectionCfg) throws JIRAException {
/* 188 */     return this.worker.getPriorities(httpConnectionCfg);
/*     */   }
/*     */   
/*     */   public List<JIRAResolutionBean> getResolutions(ConnectionCfg httpConnectionCfg) throws JIRAException {
/* 192 */     return this.worker.getResolutions(httpConnectionCfg);
/*     */   }
/*     */   
/*     */   public List<JIRAAction> getAvailableActions(ConnectionCfg httpConnectionCfg, JIRAIssue issue) throws JIRAException {
/* 196 */     return this.worker.getAvailableActions(httpConnectionCfg, issue);
/*     */   }
/*     */   
/*     */   public List<JIRAActionField> getFieldsForAction(ConnectionCfg httpConnectionCfg, JIRAIssue issue, JIRAAction action) throws JIRAException {
/* 200 */     return this.worker.getFieldsForAction(httpConnectionCfg, issue, action);
/*     */   }
/*     */   
/*     */   public void progressWorkflowAction(ConnectionCfg httpConnectionCfg, JIRAIssue issue, JIRAAction action) throws JIRAException {
/* 204 */     this.worker.progressWorkflowAction(httpConnectionCfg, issue, action);
/*     */   }
/*     */   
/*     */   public void progressWorkflowAction(ConnectionCfg httpConnectionCfg, JIRAIssue issue, JIRAAction action, List<JIRAActionField> fields) throws JIRAException {
/* 208 */     this.worker.progressWorkflowAction(httpConnectionCfg, issue, action, fields);
/*     */   }
/*     */   
/*     */   public void addComment(ConnectionCfg httpConnectionCfg, String issueKey, String comment) throws JIRAException {
/* 212 */     this.worker.addComment(httpConnectionCfg, issueKey, comment);
/*     */   }
/*     */   
/*     */   public void addAttachment(ConnectionCfg httpConnectionCfg, String issueKey, String name, byte[] content) throws JIRAException {
/* 216 */     this.worker.addAttachment(httpConnectionCfg, issueKey, name, content);
/*     */   }
/*     */   
/*     */   public JIRAIssue createIssue(ConnectionCfg httpConnectionCfg, JIRAIssue issue) throws JIRAException {
/* 220 */     return this.worker.createIssue(httpConnectionCfg, issue);
/*     */   }
/*     */   
/*     */   public JIRAIssue createSubtask(JiraServerData jiraServerData, JIRAIssue parent, JIRAIssue issue) throws JIRAException {
/* 224 */     return this.worker.createSubtask(jiraServerData, parent, issue);
/*     */   }
/*     */   
/*     */   public JIRAIssue getIssue(ConnectionCfg httpConnectionCfg, String key) throws JIRAException {
/* 228 */     return this.worker.getIssue(httpConnectionCfg, key);
/*     */   }
/*     */   
/*     */   public JIRAIssue getIssueDetails(ConnectionCfg httpConnectionCfg, JIRAIssue issue) throws JIRAException {
/* 232 */     return this.worker.getIssueDetails(httpConnectionCfg, issue);
/*     */   }
/*     */   
/*     */   public void logWork(ConnectionCfg httpConnectionCfg, JIRAIssue issue, String timeSpent, Calendar startDate, String comment, boolean updateEstimate, String newEstimate) throws JIRAException {
/* 236 */     this.worker.logWork(httpConnectionCfg, issue, timeSpent, startDate, comment, updateEstimate, newEstimate);
/*     */   }
/*     */   
/*     */   public void setField(ConnectionCfg httpConnectionCfg, JIRAIssue issue, String fieldId, String value) throws JIRAException {
/* 240 */     this.worker.setField(httpConnectionCfg, issue, fieldId, value);
/*     */   }
/*     */   
/*     */   public void setField(ConnectionCfg httpConnectionCfg, JIRAIssue issue, String fieldId, String[] values) throws JIRAException {
/* 244 */     this.worker.setField(httpConnectionCfg, issue, fieldId, values);
/*     */   }
/*     */   
/*     */   public void setFields(ConnectionCfg httpConnectionCfg, JIRAIssue issue, List<JIRAActionField> fields) throws JIRAException {
/* 248 */     this.worker.setFields(httpConnectionCfg, issue, fields);
/*     */   }
/*     */   
/*     */   public JIRAUserBean getUser(ConnectionCfg httpConnectionCfg, String loginName) throws JIRAException, JiraUserNotFoundException {
/* 252 */     return this.worker.getUser(httpConnectionCfg, loginName);
/*     */   }
/*     */   
/*     */   public List<JIRAComment> getComments(ConnectionCfg httpConnectionCfg, JIRAIssue issue) throws JIRAException {
/* 256 */     return this.worker.getComments(httpConnectionCfg, issue);
/*     */   }
/*     */   
/*     */   public Collection<JIRAAttachment> getIssueAttachements(ConnectionCfg httpConnectionCfg, JIRAIssue issue) throws JIRAException {
/* 260 */     return this.worker.getIssueAttachements(httpConnectionCfg, issue);
/*     */   }
/*     */   
/*     */   public List<JIRASecurityLevelBean> getSecurityLevels(ConnectionCfg connectionCfg, String projectKey) throws JIRAException {
/* 264 */     return this.worker.getSecurityLevels(connectionCfg, projectKey);
/*     */   }
/*     */   
/*     */   public void testServerConnection(ConnectionCfg httpConnectionCfg) throws RemoteApiException {
/* 268 */     this.worker.testServerConnection(httpConnectionCfg);
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JIRAServerFacade2Impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */