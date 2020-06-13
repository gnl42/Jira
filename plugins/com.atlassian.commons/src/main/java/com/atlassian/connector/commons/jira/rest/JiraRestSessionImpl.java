/*     */ package com.atlassian.connector.commons.jira.rest;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import com.atlassian.connector.commons.jira.JIRAAction;
/*     */ import com.atlassian.connector.commons.jira.JIRAActionBean;
/*     */ import com.atlassian.connector.commons.jira.JIRAActionField;
/*     */ import com.atlassian.connector.commons.jira.JIRAActionFieldBean;
/*     */ import com.atlassian.connector.commons.jira.JIRAIssue;
/*     */ import com.atlassian.connector.commons.jira.JIRAIssueBean;
/*     */ import com.atlassian.connector.commons.jira.JIRASessionPartOne;
/*     */ import com.atlassian.connector.commons.jira.JIRASessionPartTwo;
/*     */ import com.atlassian.connector.commons.jira.JiraUserNotFoundException;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAAttachment;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAComment;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAComponentBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAConstant;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAIssueTypeBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAPriorityBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAProject;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAProjectBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAQueryFragment;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAResolutionBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRASavedFilter;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRASavedFilterBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRASecurityLevelBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAStatusBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAUserBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAVersionBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JiraFilter;
/*     */ import com.atlassian.connector.commons.jira.rss.JIRAException;
/*     */ import com.atlassian.jira.rest.client.AuthenticationHandler;
/*     */ import com.atlassian.jira.rest.client.GetCreateIssueMetadataOptionsBuilder;
/*     */ import com.atlassian.jira.rest.client.IssueRestClient;
/*     */ import com.atlassian.jira.rest.client.JiraRestClient;
/*     */ import com.atlassian.jira.rest.client.NullProgressMonitor;
/*     */ import com.atlassian.jira.rest.client.OptionalIterable;
/*     */ import com.atlassian.jira.rest.client.ProgressMonitor;
/*     */ import com.atlassian.jira.rest.client.RestClientException;
/*     */ import com.atlassian.jira.rest.client.auth.AnonymousAuthenticationHandler;
/*     */ import com.atlassian.jira.rest.client.auth.BasicHttpAuthenticationHandler;
/*     */ import com.atlassian.jira.rest.client.domain.Attachment;
/*     */ import com.atlassian.jira.rest.client.domain.Authentication;
/*     */ import com.atlassian.jira.rest.client.domain.BasicComponent;
/*     */ import com.atlassian.jira.rest.client.domain.BasicIssue;
/*     */ import com.atlassian.jira.rest.client.domain.BasicProject;
/*     */ import com.atlassian.jira.rest.client.domain.CimFieldInfo;
/*     */ import com.atlassian.jira.rest.client.domain.CimIssueType;
/*     */ import com.atlassian.jira.rest.client.domain.CimProject;
/*     */ import com.atlassian.jira.rest.client.domain.Comment;
/*     */ import com.atlassian.jira.rest.client.domain.FavouriteFilter;
/*     */ import com.atlassian.jira.rest.client.domain.Issue;
/*     */ import com.atlassian.jira.rest.client.domain.IssueFieldId;
/*     */ import com.atlassian.jira.rest.client.domain.IssueType;
/*     */ import com.atlassian.jira.rest.client.domain.Priority;
/*     */ import com.atlassian.jira.rest.client.domain.Resolution;
/*     */ import com.atlassian.jira.rest.client.domain.SearchResult;
/*     */ import com.atlassian.jira.rest.client.domain.SecurityLevel;
/*     */ import com.atlassian.jira.rest.client.domain.SessionCookie;
/*     */ import com.atlassian.jira.rest.client.domain.Status;
/*     */ import com.atlassian.jira.rest.client.domain.Transition;
/*     */ import com.atlassian.jira.rest.client.domain.User;
/*     */ import com.atlassian.jira.rest.client.domain.Version;
/*     */ import com.atlassian.jira.rest.client.domain.input.ComplexIssueInputFieldValue;
/*     */ import com.atlassian.jira.rest.client.domain.input.FieldInput;
/*     */ import com.atlassian.jira.rest.client.domain.input.IssueInputBuilder;
/*     */ import com.atlassian.jira.rest.client.domain.input.TransitionInput;
/*     */ import com.atlassian.jira.rest.client.domain.input.WorklogInputBuilder;
/*     */ import com.atlassian.jira.rest.client.internal.jersey.JerseyJiraRestClientBuilder;
/*     */ import com.atlassian.jira.rest.client.internal.json.JsonParseUtil;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.ServerData;
/*     */ import com.atlassian.theplugin.commons.remoteapi.jira.JiraCaptchaRequiredException;
/*     */ import com.atlassian.theplugin.commons.util.HttpConfigurableAdapter;
/*     */ import com.google.common.base.Optional;
/*     */ import com.google.common.base.Predicate;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.sun.jersey.api.client.Client;
/*     */ import com.sun.jersey.api.client.ClientResponse;
/*     */ import com.sun.jersey.api.client.UniformInterfaceException;
/*     */ import com.sun.jersey.api.client.filter.Filterable;
/*     */ import com.sun.jersey.client.apache.config.ApacheHttpClientConfig;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.apache.commons.httpclient.Cookie;
/*     */ import org.apache.commons.httpclient.auth.AuthScope;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.codehaus.jettison.json.JSONException;
/*     */ import org.codehaus.jettison.json.JSONObject;
/*     */ import org.joda.time.DateTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JiraRestSessionImpl
/*     */   implements JIRASessionPartOne, JIRASessionPartTwo
/*     */ {
/*     */   private final ConnectionCfg server;
/*     */   private final HttpConfigurableAdapter proxyInfo;
/*     */   private final JiraRestClient restClient;
/* 112 */   final NullProgressMonitor pm = new NullProgressMonitor();
/* 113 */   private Authentication authentication = null;
/* 114 */   private ApacheHttpClientConfig apacheClientConfig = null;
/*     */   
/*     */   public JiraRestSessionImpl(ConnectionCfg server, HttpConfigurableAdapter proxyInfo) throws URISyntaxException {
/* 117 */     this.server = server;
/* 118 */     this.proxyInfo = proxyInfo;
/*     */     
/* 120 */     if (((ServerData)server).isUseSessionCookies()) {
/* 121 */       this.restClient = (new JerseyJiraRestClientBuilder())
/* 122 */         .header("User-Agent", "Atlassian IntelliJ IDEA Connector")
/* 123 */         .queryParam("requestSource", "intellij-ide-connector")
/* 124 */         .create(new URI(server.getUrl()), (AuthenticationHandler)new AnonymousAuthenticationHandler()
/*     */           {
/*     */             public void configure(ApacheHttpClientConfig config) {
/* 127 */               super.configure(config);
/* 128 */               JiraRestSessionImpl.this.setupApacheClient(config);
/*     */             }
/*     */ 
/*     */             
/*     */             public void configure(Filterable filterable, Client client) {
/* 133 */               super.configure(filterable, client);
/* 134 */               JiraRestSessionImpl.this.setupApacheClient(JiraRestSessionImpl.this.apacheClientConfig);
/*     */             }
/*     */           });
/*     */     } else {
/* 138 */       this.restClient = (new JerseyJiraRestClientBuilder())
/* 139 */         .header("User-Agent", "Atlassian IntelliJ IDEA Connector")
/* 140 */         .queryParam("requestSource", "intellij-ide-connector")
/* 141 */         .create(new URI(server.getUrl()), (AuthenticationHandler)new BasicHttpAuthenticationHandler(server.getUsername(), server.getPassword())
/*     */           {
/*     */             public void configure(ApacheHttpClientConfig config) {
/* 144 */               config.getProperties().put("com.sun.jersey.impl.client.httpclient.handleCookies", Boolean.valueOf(true));
/* 145 */               config.getState().getHttpState().setCookiePolicy(0);
/* 146 */               super.configure(config);
/* 147 */               config.getProperties().put("com.sun.jersey.impl.client.httpclient.preemptiveAuthentication", Boolean.valueOf(false));
/*     */               
/* 149 */               JiraRestSessionImpl.this.setupApacheClient(config);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void configure(Filterable filterable, Client client) {
/* 155 */               super.configure(filterable, client);
/* 156 */               JiraRestSessionImpl.this.setupApacheClient(JiraRestSessionImpl.this.apacheClientConfig);
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 161 */     if (proxyInfo != null && proxyInfo.isUseHttpProxy()) {
/* 162 */       this.restClient.getTransportClient().getProperties().put(
/* 163 */           "com.sun.jersey.impl.client.httpclient.proxyURI", "http://" + proxyInfo.getProxyHost() + ":" + proxyInfo.getProxyPort());
/*     */     }
/* 165 */     if (((ServerData)server).isUseSessionCookies()) {
/* 166 */       this.restClient.getTransportClient().getProperties().put("com.sun.jersey.impl.client.httpclient.handleCookies", Boolean.valueOf(true));
/* 167 */       this.restClient.getTransportClient().getClientHandler().getHttpClient().getParams().setCookiePolicy("compatibility");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean supportsRest() throws JIRAException {
/*     */     try {
/* 173 */       return (this.restClient.getMetadataClient().getServerInfo((ProgressMonitor)this.pm).getBuildNumber() >= 700);
/* 174 */     } catch (Exception exception) {
/* 175 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void login(final String userName, final String password) throws RemoteApiException {
/* 180 */     wrapWithRemoteApiException(new Callable<Void>() {
/*     */           public Void call() throws Exception {
/* 182 */             JiraRestSessionImpl.this.authentication = JiraRestSessionImpl.this.restClient.getSessionClient().login(userName, password, (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 183 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void logout() {
/* 189 */     this.authentication = null;
/*     */   }
/*     */   
/*     */   public List<JIRAProject> getProjects() throws RemoteApiException {
/* 193 */     return wrapWithRemoteApiException(new Callable<List<JIRAProject>>() {
/*     */           public List<JIRAProject> call() throws Exception {
/* 195 */             Iterable<BasicProject> projects = JiraRestSessionImpl.this.restClient.getProjectClient().getAllProjects((ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 196 */             List<JIRAProject> result = Lists.newArrayList();
/* 197 */             for (BasicProject project : projects) {
/* 198 */               Long id = project.getId();
/* 199 */               result.add(new JIRAProjectBean((id != null) ? id.longValue() : -1L, project.getKey(), project.getName()));
/*     */             } 
/* 201 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getIssueTypes() throws RemoteApiException {
/* 207 */     return getIssueTypes(false);
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getSubtaskIssueTypes() throws RemoteApiException {
/* 211 */     return getIssueTypes(true);
/*     */   }
/*     */   
/*     */   private List<JIRAConstant> getIssueTypes(final boolean subtasks) throws RemoteApiException {
/* 215 */     return wrapWithRemoteApiException(new Callable<List<JIRAConstant>>() {
/*     */           public List<JIRAConstant> call() throws Exception {
/* 217 */             Iterable<IssueType> issueTypes = JiraRestSessionImpl.this.restClient.getMetadataClient().getIssueTypes((ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 218 */             List<JIRAConstant> result = Lists.newArrayList();
/* 219 */             for (IssueType type : issueTypes) {
/* 220 */               Long id = type.getId();
/* 221 */               if (type.isSubtask() != subtasks || id == null) {
/*     */                 continue;
/*     */               }
/* 224 */               result.add(new JIRAIssueTypeBean(id.longValue(), type.getName(), type.getIconUri().toURL()));
/*     */             } 
/* 226 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getIssueTypesForProject(long projectId, String projectKey) throws RemoteApiException {
/* 232 */     return getIssueTypesForProject(projectKey, false);
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getSubtaskIssueTypesForProject(long projectId, String projectKey) throws RemoteApiException {
/* 236 */     return getIssueTypesForProject(projectKey, true);
/*     */   }
/*     */   
/*     */   private List<JIRAConstant> getIssueTypesForProject(final String projectKey, final boolean subtasks) throws RemoteApiException {
/* 240 */     return wrapWithRemoteApiException(new Callable<List<JIRAConstant>>() {
/*     */           public List<JIRAConstant> call() throws Exception {
/* 242 */             OptionalIterable<IssueType> issueTypes = JiraRestSessionImpl.this.restClient.getProjectClient().getProject(projectKey, (ProgressMonitor)JiraRestSessionImpl.this.pm).getIssueTypes();
/* 243 */             List<JIRAConstant> result = Lists.newArrayList();
/* 244 */             for (IssueType issueType : issueTypes) {
/* 245 */               if (subtasks != issueType.isSubtask()) {
/*     */                 continue;
/*     */               }
/* 248 */               Long id = issueType.getId();
/* 249 */               result.add(new JIRAIssueTypeBean((id != null) ? id.longValue() : -1L, issueType.getName(), issueType.getIconUri().toURL()));
/*     */             } 
/* 251 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getStatuses() throws RemoteApiException {
/* 257 */     return wrapWithRemoteApiException(new Callable<List<JIRAConstant>>() {
/*     */           public List<JIRAConstant> call() throws Exception {
/* 259 */             Iterable<Status> statuses = JiraRestSessionImpl.this.restClient.getMetadataClient().getStatuses((ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 260 */             List<JIRAConstant> result = Lists.newArrayList();
/* 261 */             for (Status status : statuses) {
/* 262 */               Long id = status.getId();
/* 263 */               result.add(new JIRAStatusBean((id != null) ? id.longValue() : -1L, status.getName(), status.getIconUrl().toURL()));
/*     */             } 
/* 265 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAComponentBean> getComponents(final String projectKey) throws RemoteApiException {
/* 271 */     return wrapWithRemoteApiException(new Callable<List<JIRAComponentBean>>() {
/*     */           public List<JIRAComponentBean> call() throws Exception {
/* 273 */             Iterable<BasicComponent> components = JiraRestSessionImpl.this.restClient.getProjectClient().getProject(projectKey, (ProgressMonitor)JiraRestSessionImpl.this.pm).getComponents();
/* 274 */             List<JIRAComponentBean> result = Lists.newArrayList();
/* 275 */             for (BasicComponent component : components) {
/* 276 */               Long id = component.getId();
/* 277 */               result.add(new JIRAComponentBean((id != null) ? id.longValue() : -1L, component.getName()));
/*     */             } 
/* 279 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAVersionBean> getVersions(final String projectKey) throws RemoteApiException {
/* 285 */     return wrapWithRemoteApiException(new Callable<List<JIRAVersionBean>>() {
/*     */           public List<JIRAVersionBean> call() throws Exception {
/* 287 */             Iterable<Version> versions = JiraRestSessionImpl.this.restClient.getProjectClient().getProject(projectKey, (ProgressMonitor)JiraRestSessionImpl.this.pm).getVersions();
/* 288 */             List<JIRAVersionBean> result = Lists.newArrayList();
/* 289 */             for (Version version : versions) {
/* 290 */               Long id = version.getId();
/* 291 */               result.add(new JIRAVersionBean((id != null) ? id.longValue() : -1L, version.getName(), version.isReleased()));
/*     */             } 
/* 293 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAPriorityBean> getPriorities() throws RemoteApiException {
/* 299 */     return wrapWithRemoteApiException(new Callable<List<JIRAPriorityBean>>() {
/*     */           public List<JIRAPriorityBean> call() throws Exception {
/* 301 */             Iterable<Priority> priorities = JiraRestSessionImpl.this.restClient.getMetadataClient().getPriorities((ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 302 */             List<JIRAPriorityBean> result = Lists.newArrayList();
/* 303 */             int order = 0;
/* 304 */             for (Priority priority : priorities) {
/* 305 */               Long id = priority.getId();
/* 306 */               result.add(new JIRAPriorityBean((id != null) ? id.longValue() : -1L, order++, priority.getName(), priority.getIconUri().toURL()));
/*     */             } 
/* 308 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAResolutionBean> getResolutions() throws RemoteApiException {
/* 314 */     return wrapWithRemoteApiException(new Callable<List<JIRAResolutionBean>>() {
/*     */           public List<JIRAResolutionBean> call() throws Exception {
/* 316 */             Iterable<Resolution> resolutions = JiraRestSessionImpl.this.restClient.getMetadataClient().getResolutions((ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 317 */             List<JIRAResolutionBean> result = Lists.newArrayList();
/* 318 */             for (Resolution status : resolutions) {
/* 319 */               Long id = status.getId();
/* 320 */               result.add(new JIRAResolutionBean((id != null) ? id.longValue() : -1L, status.getName()));
/*     */             } 
/* 322 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAQueryFragment> getSavedFilters() throws RemoteApiException {
/* 328 */     return wrapWithRemoteApiException(new Callable<List<JIRAQueryFragment>>() {
/*     */           public List<JIRAQueryFragment> call() throws Exception {
/* 330 */             Iterable<FavouriteFilter> filters = JiraRestSessionImpl.this.restClient.getSearchClient().getFavouriteFilters(JiraRestSessionImpl.this.pm);
/* 331 */             List<JIRAQueryFragment> result = Lists.newArrayList();
/* 332 */             for (FavouriteFilter filter : filters) {
/* 333 */               Long id = filter.getId();
/* 334 */               String jql = filter.getJql();
/* 335 */               jql = (jql != null) ? jql.replace("\\\"", "\"") : "";
/* 336 */               result.add(new JIRASavedFilterBean(filter.getName(), (id != null) ? id.longValue() : -1L, jql, filter.getSearchUrl(), filter.getViewUrl()));
/*     */             } 
/* 338 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAAction> getAvailableActions(final JIRAIssue issue) throws RemoteApiException {
/* 344 */     return wrapWithRemoteApiException(new Callable<List<JIRAAction>>() {
/*     */           public List<JIRAAction> call() throws Exception {
/* 346 */             List<JIRAAction> result = Lists.newArrayList();
/* 347 */             Iterable<Transition> transitions = JiraRestSessionImpl.this.restClient.getIssueClient().getTransitions((Issue)issue.getApiIssueObject(), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 348 */             for (Transition transition : transitions) {
/* 349 */               result.add(new JIRAActionBean(transition.getId(), transition.getName()));
/*     */             }
/* 351 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAActionField> getFieldsForAction(final JIRAIssue issue, final JIRAAction action) throws RemoteApiException {
/* 357 */     return wrapWithRemoteApiException(new Callable<List<JIRAActionField>>() {
/*     */           public List<JIRAActionField> call() throws Exception {
/* 359 */             Iterable<Transition> transitions = JiraRestSessionImpl.this.restClient.getIssueClient().getTransitions((Issue)issue.getApiIssueObject(), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 360 */             List<JIRAActionField> result = Lists.newArrayList();
/* 361 */             for (Transition transition : transitions) {
/* 362 */               if (transition.getId() != action.getId()) {
/*     */                 continue;
/*     */               }
/* 365 */               for (Transition.Field field : transition.getFields()) {
/* 366 */                 JIRAActionFieldBean f = new JIRAActionFieldBean(field.getId(), field.getName());
/* 367 */                 result.add(f);
/*     */               } 
/*     */               break;
/*     */             } 
/* 371 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void progressWorkflowAction(final JIRAIssue issue, final JIRAAction action, final List<JIRAActionField> fields) throws RemoteApiException {
/* 377 */     final List<FieldInput> fieldValues = Lists.newArrayList();
/* 378 */     if (fields == null || fields.size() == 0) {
/* 379 */       wrapWithRemoteApiException(new Callable() {
/*     */             public Object call() throws Exception {
/* 381 */               TransitionInput t = new TransitionInput((int)action.getId(), fieldValues);
/* 382 */               JiraRestSessionImpl.this.restClient.getIssueClient().transition((Issue)issue.getApiIssueObject(), t, (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 383 */               return null;
/*     */             }
/*     */           });
/*     */     } else {
/* 387 */       wrapWithRemoteApiException(new Callable() {
/*     */             public Object call() throws Exception {
/* 389 */               Issue iszju = JiraRestSessionImpl.this.restClient.getIssueClient().getIssue(issue.getKey(), (Iterable)ImmutableList.of(IssueRestClient.Expandos.EDITMETA), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 390 */               fieldValues.addAll(JiraRestSessionImpl.this.generateFieldValues(issue, iszju, fields));
/* 391 */               TransitionInput t = new TransitionInput((int)action.getId(), fieldValues);
/* 392 */               JiraRestSessionImpl.this.restClient.getIssueClient().transition((Issue)issue.getApiIssueObject(), t, (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 393 */               return null;
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setField(JIRAIssue issue, String fieldId, String value) throws RemoteApiException {
/* 400 */     JIRAActionFieldBean f = new JIRAActionFieldBean(fieldId, null);
/* 401 */     f.addValue(value);
/* 402 */     setFields(issue, (List<JIRAActionField>)ImmutableList.of(f));
/*     */   }
/*     */   
/*     */   public void setField(JIRAIssue issue, String fieldId, String[] values) throws RemoteApiException {
/* 406 */     JIRAActionFieldBean f = new JIRAActionFieldBean(fieldId, null); byte b; int i; String[] arrayOfString;
/* 407 */     for (i = (arrayOfString = values).length, b = 0; b < i; ) { String value = arrayOfString[b];
/* 408 */       f.addValue(value); b++; }
/*     */     
/* 410 */     setFields(issue, (List<JIRAActionField>)ImmutableList.of(f));
/*     */   }
/*     */   
/*     */   public void setFields(final JIRAIssue issue, final List<JIRAActionField> fields) throws RemoteApiException {
/* 414 */     wrapWithRemoteApiException(new Callable() {
/*     */           public Object call() throws Exception {
/* 416 */             Issue iszju = JiraRestSessionImpl.this.restClient.getIssueClient().getIssue(issue.getKey(), (Iterable)ImmutableList.of(IssueRestClient.Expandos.EDITMETA), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 417 */             JiraRestSessionImpl.this.restClient.getIssueClient().update(iszju, JiraRestSessionImpl.this.generateFieldValues(issue, iszju, fields), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 418 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private Collection<FieldInput> generateFieldValues(JIRAIssue issue, Issue iszju, List<JIRAActionField> fieldValues) throws RemoteApiException {
/* 424 */     JSONObject editmeta = JsonParseUtil.getOptionalJsonObject(iszju.getRawObject(), "editmeta");
/* 425 */     if (editmeta == null) {
/* 426 */       throw new RemoteApiException("Unable to retrieve issue's editmeta information");
/*     */     }
/* 428 */     JSONObject fields = JsonParseUtil.getOptionalJsonObject(editmeta, "fields");
/*     */     try {
/* 430 */       if (fields != null) {
/* 431 */         List<FieldInput> result = Lists.newArrayList();
/* 432 */         for (JIRAActionField field : fieldValues) {
/* 433 */           JSONObject fieldDef = JsonParseUtil.getOptionalJsonObject(fields, field.getFieldId());
/* 434 */           FieldInput fieldInput = null;
/* 435 */           if (fieldDef != null) {
/* 436 */             fieldInput = field.generateFieldValue(issue, fieldDef);
/* 437 */           } else if (field.getFieldId().equals("resolution")) {
/* 438 */             fieldInput = new FieldInput("resolution", new ComplexIssueInputFieldValue((Map)ImmutableMap.of("id", field.getValues().get(0))));
/*     */           } 
/* 440 */           if (fieldInput != null) {
/* 441 */             result.add(fieldInput);
/*     */           }
/*     */         } 
/* 444 */         return result;
/*     */       } 
/* 446 */     } catch (JSONException e) {
/* 447 */       throw new RemoteApiException("Unable to generate field values", e);
/*     */     } 
/* 449 */     return null;
/*     */   }
/*     */   
/*     */   public JIRAUserBean getUser(final String loginName) throws RemoteApiException, JiraUserNotFoundException {
/* 453 */     return wrapWithRemoteApiException(new Callable<JIRAUserBean>() {
/*     */           public JIRAUserBean call() throws Exception {
/* 455 */             User user = JiraRestSessionImpl.this.restClient.getUserClient().getUser(loginName, (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 456 */             return new JIRAUserBean(-1L, user.getDisplayName(), user.getName()) {
/*     */                 public String getQueryStringFragment() {
/* 458 */                   return null;
/*     */                 }
/*     */                 
/*     */                 public JIRAQueryFragment getClone() {
/* 462 */                   return null;
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAComment> getComments(JIRAIssue issue) throws RemoteApiException {
/* 470 */     if (issue.getComments() == null) {
/* 471 */       return Lists.newArrayList();
/*     */     }
/* 473 */     return issue.getComments();
/*     */   }
/*     */   
/*     */   public Collection<JIRAAttachment> getIssueAttachements(final JIRAIssue issue) throws RemoteApiException {
/* 477 */     return wrapWithRemoteApiException(new Callable<Collection<JIRAAttachment>>()
/*     */         {
/*     */           public Collection<JIRAAttachment> call() throws Exception {
/* 480 */             Issue iszju = JiraRestSessionImpl.this.restClient.getIssueClient().getIssue(issue.getKey(), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 481 */             List<JIRAAttachment> result = Lists.newArrayList();
/* 482 */             Iterable<Attachment> attachments = iszju.getAttachments();
/* 483 */             if (attachments != null) {
/* 484 */               for (Attachment attachment : attachments) {
/* 485 */                 Long id = attachment.getId();
/* 486 */                 JIRAAttachment a = new JIRAAttachment(
/* 487 */                     (id != null) ? id.toString() : "-1", attachment.getAuthor().getName(), attachment.getFilename(), 
/* 488 */                     attachment.getSize(), attachment.getMimeType(), attachment.getCreationDate().toGregorianCalendar());
/* 489 */                 result.add(a);
/*     */               } 
/*     */             }
/* 492 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRASecurityLevelBean> getSecurityLevels(final String projectKey) throws RemoteApiException {
/* 498 */     return wrapWithRemoteApiException(new Callable<List<JIRASecurityLevelBean>>() {
/*     */           public List<JIRASecurityLevelBean> call() throws Exception {
/* 500 */             GetCreateIssueMetadataOptionsBuilder builder = new GetCreateIssueMetadataOptionsBuilder();
/* 501 */             builder.withExpandedIssueTypesFields().withProjectKeys(new String[] { this.val$projectKey });
/* 502 */             Iterable<CimProject> metadata = JiraRestSessionImpl.this.restClient.getIssueClient().getCreateIssueMetadata(builder.build(), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 503 */             if (metadata == null || !metadata.iterator().hasNext()) {
/* 504 */               return Lists.newArrayList();
/*     */             }
/* 506 */             CimProject project = metadata.iterator().next();
/* 507 */             Map<Long, JIRASecurityLevelBean> levels = Maps.newHashMap();
/* 508 */             for (CimIssueType type : project.getIssueTypes()) {
/* 509 */               Map<String, CimFieldInfo> fields = type.getFields();
/* 510 */               CimFieldInfo security = fields.get("security");
/* 511 */               if (security != null) {
/* 512 */                 Iterable<Object> allowedValues = security.getAllowedValues();
/* 513 */                 if (allowedValues == null) {
/*     */                   continue;
/*     */                 }
/* 516 */                 for (Object lvl : allowedValues) {
/* 517 */                   SecurityLevel secLevel = (SecurityLevel)lvl;
/* 518 */                   Long id = secLevel.getId();
/* 519 */                   if (!levels.containsKey(id)) {
/* 520 */                     levels.put(id, new JIRASecurityLevelBean(id, secLevel.getName()));
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/* 525 */             return Lists.newArrayList(levels.values());
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public List<JIRAProject> getProjectsForIssueCreation() throws RemoteApiException {
/* 531 */     return wrapWithRemoteApiException(new Callable<List<JIRAProject>>() {
/*     */           public List<JIRAProject> call() throws Exception {
/* 533 */             GetCreateIssueMetadataOptionsBuilder builder = new GetCreateIssueMetadataOptionsBuilder();
/* 534 */             Iterable<CimProject> metadata = JiraRestSessionImpl.this.restClient.getIssueClient().getCreateIssueMetadata(builder.build(), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 535 */             if (metadata == null || !metadata.iterator().hasNext()) {
/* 536 */               return Lists.newArrayList();
/*     */             }
/* 538 */             List<JIRAProject> result = Lists.newArrayList();
/* 539 */             for (CimProject cimProject : metadata) {
/* 540 */               Long id = cimProject.getId();
/* 541 */               if (id == null) {
/*     */                 continue;
/*     */               }
/* 544 */               JIRAProjectBean jIRAProjectBean = new JIRAProjectBean(id.longValue(), cimProject.getKey(), cimProject.getName());
/* 545 */               result.add(jIRAProjectBean);
/*     */             } 
/* 547 */             return result;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public List<JIRAIssue> getIssues(JiraFilter filter, String sortBy, String sortOrder, int start, int max) throws JIRAException {
/* 554 */     return getIssues(filter.getJql(), sortBy, sortOrder, start, max);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<JIRAIssue> getSavedFilterIssues(JIRASavedFilter filter, String sortBy, String sortOrder, int start, int max) throws JIRAException {
/* 559 */     return getIssues(filter.getJql(), sortBy, sortOrder, start, max);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<JIRAIssue> getIssues(final String jql, final String sortBy, final String sortOrder, final int start, final int max) throws JIRAException {
/* 565 */     return wrapWithJiraException(new Callable<List<JIRAIssue>>() {
/*     */           public List<JIRAIssue> call() throws Exception {
/* 567 */             String sort = 
/* 568 */               jql.toLowerCase().contains("order by") ? 
/* 569 */               "" : (
/* 570 */               (StringUtils.isNotEmpty(sortBy) && StringUtils.isNotEmpty(sortOrder)) ? (
/* 571 */               " order by " + sortBy + " " + sortOrder) : 
/* 572 */               "");
/* 573 */             SearchResult result = JiraRestSessionImpl.this.restClient.getSearchClient().searchJqlWithFullIssues(String.valueOf(jql) + sort, max, start, (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 574 */             List<JIRAIssue> list = Lists.newArrayList();
/* 575 */             for (BasicIssue issue : result.getIssues()) {
/* 576 */               JIRAIssueBean bean = new JIRAIssueBean(JiraRestSessionImpl.this.server.getUrl(), (Issue)issue);
/* 577 */               list.add(bean);
/*     */             } 
/* 579 */             return list;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public JIRAIssue getIssue(final String issueKey) throws JIRAException {
/* 585 */     return wrapWithJiraException(new Callable<JIRAIssue>() {
/*     */           public JIRAIssue call() throws Exception {
/* 587 */             Issue issue = JiraRestSessionImpl.this.restClient.getIssueClient().getIssue(issueKey, 
/* 588 */                 (Iterable)ImmutableList.of(IssueRestClient.Expandos.RENDERED_FIELDS, IssueRestClient.Expandos.EDITMETA), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 589 */             return (JIRAIssue)new JIRAIssueBean(JiraRestSessionImpl.this.server.getUrl(), issue);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public JIRAIssue getIssueDetails(JIRAIssue issue) throws RemoteApiException {
/*     */     try {
/* 596 */       return getIssue(issue.getKey());
/* 597 */     } catch (JIRAException e) {
/* 598 */       throw new RemoteApiException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void logWork(final JIRAIssue issue, final String timeSpent, final Calendar startDate, final String comment, final boolean updateEstimate, final String newEstimate) throws RemoteApiException {
/* 605 */     wrapWithRemoteApiException(new Callable() {
/*     */           public Object call() throws Exception {
/* 607 */             Issue iszju = JiraRestSessionImpl.this.restClient.getIssueClient().getIssue(issue.getKey(), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 608 */             WorklogInputBuilder builder = new WorklogInputBuilder(iszju.getSelf());
/* 609 */             builder.setStartDate(new DateTime(startDate));
/* 610 */             builder.setTimeSpent(timeSpent);
/* 611 */             if (updateEstimate) {
/* 612 */               if (newEstimate != null) {
/* 613 */                 builder.setAdjustEstimateNew(newEstimate);
/*     */               } else {
/* 615 */                 builder.setAdjustEstimateAuto();
/*     */               } 
/*     */             } else {
/* 618 */               builder.setAdjustEstimateLeave();
/*     */             } 
/* 620 */             builder.setComment(comment);
/* 621 */             JiraRestSessionImpl.this.restClient.getIssueClient().addWorklog(iszju.getWorklogUri(), builder.build(), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 622 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void addComment(final String issueKey, final String comment) throws RemoteApiException {
/* 628 */     wrapWithRemoteApiException(new Callable() {
/*     */           public Object call() throws Exception {
/* 630 */             Issue issue = JiraRestSessionImpl.this.restClient.getIssueClient().getIssue(issueKey, (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 631 */             JiraRestSessionImpl.this.restClient.getIssueClient().addComment((ProgressMonitor)JiraRestSessionImpl.this.pm, issue.getCommentsUri(), Comment.valueOf(comment));
/* 632 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void addAttachment(final String issueKey, final String name, final byte[] content) throws RemoteApiException {
/* 638 */     wrapWithRemoteApiException(new Callable() {
/*     */           public Object call() throws Exception {
/* 640 */             Issue issue = JiraRestSessionImpl.this.restClient.getIssueClient().getIssue(issueKey, (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 641 */             JiraRestSessionImpl.this.restClient.getIssueClient().addAttachment((ProgressMonitor)JiraRestSessionImpl.this.pm, issue.getAttachmentsUri(), new ByteArrayInputStream(content), name);
/* 642 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public JIRAIssue createIssue(JIRAIssue issue) throws RemoteApiException {
/* 648 */     return createIssueOrSubtask(null, issue);
/*     */   }
/*     */   
/*     */   public JIRAIssue createSubtask(JIRAIssue parent, JIRAIssue issue) throws RemoteApiException {
/* 652 */     return createIssueOrSubtask(parent, issue);
/*     */   }
/*     */   
/*     */   private JIRAIssue createIssueOrSubtask(final JIRAIssue parent, final JIRAIssue issue) throws RemoteApiException {
/* 656 */     final BasicIssue newIssue = wrapWithRemoteApiException(new Callable<BasicIssue>() {
/*     */           public BasicIssue call() throws Exception {
/* 658 */             GetCreateIssueMetadataOptionsBuilder metaBuilder = (
/* 659 */               new GetCreateIssueMetadataOptionsBuilder())
/* 660 */               .withProjectKeys(new String[] { this.val$issue.getProjectKey()
/* 661 */                 }).withIssueTypeIds(new Long[] { Long.valueOf(this.val$issue.getTypeConstant().getId())
/* 662 */                 }).withExpandedIssueTypesFields();
/*     */             
/* 664 */             Iterable<CimProject> metadata = JiraRestSessionImpl.this.restClient.getIssueClient().getCreateIssueMetadata(metaBuilder.build(), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 665 */             String message = "Invalid issue creation metadata";
/* 666 */             if (metadata == null) {
/* 667 */               throw new RemoteApiException(message);
/*     */             }
/* 669 */             Optional<CimProject> cimProjectOptional = Iterables.tryFind(metadata, new Predicate<CimProject>() {
/*     */                   public boolean apply(CimProject input) {
/* 671 */                     return (input != null && input.getKey().equals(issue.getProjectKey()));
/*     */                   }
/*     */                 });
/* 674 */             if (!cimProjectOptional.isPresent()) {
/* 675 */               throw new RemoteApiException(message);
/*     */             }
/* 677 */             Optional<CimIssueType> issueTypeOptional = Iterables.tryFind(((CimProject)cimProjectOptional.get()).getIssueTypes(), new Predicate<CimIssueType>() {
/*     */                   public boolean apply(CimIssueType input) {
/* 679 */                     return (input != null && input.getId().longValue() == issue.getTypeConstant().getId());
/*     */                   }
/*     */                 });
/* 682 */             if (!issueTypeOptional.isPresent()) {
/* 683 */               throw new RemoteApiException(message);
/*     */             }
/* 685 */             CimIssueType typeMeta = (CimIssueType)issueTypeOptional.get();
/* 686 */             IssueInputBuilder builder = new IssueInputBuilder(issue.getProjectKey(), Long.valueOf(issue.getTypeConstant().getId()), issue.getSummary());
/* 687 */             List<JIRAConstant> components = issue.getComponents();
/* 688 */             List<JIRAConstant> affectsVersions = issue.getAffectsVersions();
/* 689 */             List<JIRAConstant> fixVersions = issue.getFixVersions();
/* 690 */             if (JiraRestSessionImpl.this.has(typeMeta, IssueFieldId.COMPONENTS_FIELD) && components != null && components.size() > 0) {
/* 691 */               List<String> comps = Lists.newArrayList();
/* 692 */               for (JIRAConstant component : components) {
/* 693 */                 comps.add(component.getName());
/*     */               }
/* 695 */               builder.setComponentsNames(comps);
/*     */             } 
/* 697 */             if (JiraRestSessionImpl.this.has(typeMeta, IssueFieldId.AFFECTS_VERSIONS_FIELD) && affectsVersions != null && affectsVersions.size() > 0) {
/* 698 */               List<String> versions = Lists.newArrayList();
/* 699 */               for (JIRAConstant version : affectsVersions) {
/* 700 */                 versions.add(version.getName());
/*     */               }
/* 702 */               builder.setAffectedVersionsNames(versions);
/*     */             } 
/* 704 */             if (JiraRestSessionImpl.this.has(typeMeta, IssueFieldId.FIX_VERSIONS_FIELD) && fixVersions != null && fixVersions.size() > 0) {
/* 705 */               List<String> versions = Lists.newArrayList();
/* 706 */               for (JIRAConstant version : fixVersions) {
/* 707 */                 versions.add(version.getName());
/*     */               }
/* 709 */               builder.setFixVersionsNames(versions);
/*     */             } 
/* 711 */             if (JiraRestSessionImpl.this.has(typeMeta, IssueFieldId.PRIORITY_FIELD)) {
/* 712 */               builder.setPriorityId(Long.valueOf(issue.getPriorityConstant().getId()));
/*     */             }
/* 714 */             if (JiraRestSessionImpl.this.has(typeMeta, IssueFieldId.DESCRIPTION_FIELD)) {
/* 715 */               builder.setDescription(issue.getDescription());
/*     */             }
/* 717 */             if (JiraRestSessionImpl.this.has(typeMeta, IssueFieldId.ASSIGNEE_FIELD) && issue.getAssigneeId() != null) {
/* 718 */               builder.setAssigneeName(issue.getAssigneeId());
/*     */             }
/* 720 */             String originalEstimate = issue.getOriginalEstimate();
/* 721 */             if (JiraRestSessionImpl.this.has(typeMeta, IssueFieldId.TIMETRACKING_FIELD) && originalEstimate != null && originalEstimate.length() > 0) {
/* 722 */               builder.setFieldValue(IssueFieldId.TIMETRACKING_FIELD.id, 
/* 723 */                   new ComplexIssueInputFieldValue(
/* 724 */                     (Map)ImmutableMap.of("originalEstimate", originalEstimate)));
/*     */             }
/* 726 */             JIRASecurityLevelBean securityLevel = issue.getSecurityLevel();
/* 727 */             if (securityLevel != null && securityLevel.getId() > 0L) {
/* 728 */               builder.setFieldValue("security", 
/* 729 */                   new ComplexIssueInputFieldValue(
/* 730 */                     (Map)ImmutableMap.of("id", Long.valueOf(securityLevel.getId()).toString())));
/*     */             }
/* 732 */             if (parent != null) {
/* 733 */               builder.setFieldValue("parent", 
/* 734 */                   new ComplexIssueInputFieldValue((Map)ImmutableMap.of("key", parent.getKey())));
/*     */             }
/* 736 */             return JiraRestSessionImpl.this.restClient.getIssueClient().createIssue(builder.build(), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/*     */           }
/*     */         });
/* 739 */     return wrapWithRemoteApiException(new Callable<JIRAIssue>() {
/*     */           public JIRAIssue call() throws Exception {
/* 741 */             Issue issue = JiraRestSessionImpl.this.restClient.getIssueClient().getIssue(newIssue.getKey(), 
/* 742 */                 (Iterable)ImmutableList.of(IssueRestClient.Expandos.RENDERED_FIELDS, IssueRestClient.Expandos.EDITMETA), (ProgressMonitor)JiraRestSessionImpl.this.pm);
/* 743 */             return (JIRAIssue)new JIRAIssueBean(JiraRestSessionImpl.this.server.getUrl(), issue);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private boolean has(CimIssueType meta, IssueFieldId id) {
/* 749 */     return (meta.getField(id) != null);
/*     */   }
/*     */   
/*     */   public void login() throws JIRAException, JiraCaptchaRequiredException {
/* 753 */     throw new JIRAException("Not implemented");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLoggedIn(ConnectionCfg server) {
/* 758 */     return false;
/*     */   }
/*     */   
/*     */   public void testConnection() throws RemoteApiException {
/* 762 */     login(this.server.getUsername(), this.server.getPassword());
/*     */   }
/*     */   
/*     */   public boolean isLoggedIn() {
/* 766 */     return isLoggedIn(this.server);
/*     */   }
/*     */   
/*     */   private <T> T wrapWithJiraException(Callable<T> c) throws JIRAException {
/*     */     try {
/* 771 */       return doCall(c);
/* 772 */     } catch (RestClientException e) {
/* 773 */       if (e.getCause() instanceof UniformInterfaceException && (
/* 774 */         (UniformInterfaceException)e.getCause()).getResponse().getStatus() == ClientResponse.Status.UNAUTHORIZED.getStatusCode()) {
/*     */         
/*     */         try {
/* 777 */           this.authentication = this.restClient.getSessionClient().login(this.server.getUsername(), this.server.getPassword(), (ProgressMonitor)this.pm);
/* 778 */           return doCall(c);
/* 779 */         } catch (Exception e1) {
/* 780 */           throw new JIRAException(String.valueOf(getConnectionCfgString()) + "\n\n" + e1.getMessage(), e1);
/*     */         } 
/*     */       }
/* 783 */       throw new JIRAException(String.valueOf(getConnectionCfgString()) + "\n\n" + e.getMessage(), e);
/* 784 */     } catch (Exception e) {
/* 785 */       throw new JIRAException(String.valueOf(getConnectionCfgString()) + "\n\n" + e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private <T> T wrapWithRemoteApiException(Callable<T> c) throws RemoteApiException {
/*     */     try {
/* 791 */       return doCall(c);
/* 792 */     } catch (RestClientException e) {
/* 793 */       if (e.getCause() instanceof UniformInterfaceException && (
/* 794 */         (UniformInterfaceException)e.getCause()).getResponse().getStatus() == ClientResponse.Status.UNAUTHORIZED.getStatusCode()) {
/*     */         
/*     */         try {
/* 797 */           this.authentication = this.restClient.getSessionClient().login(this.server.getUsername(), this.server.getPassword(), (ProgressMonitor)this.pm);
/* 798 */           return doCall(c);
/* 799 */         } catch (Exception e1) {
/* 800 */           throw new RemoteApiException(String.valueOf(getConnectionCfgString()) + "\n\n" + e1.getMessage(), e1);
/*     */         } 
/*     */       }
/* 803 */       throw new RemoteApiException(String.valueOf(getConnectionCfgString()) + "\n\n" + e.getMessage(), e);
/* 804 */     } catch (Exception e) {
/* 805 */       throw new RemoteApiException(String.valueOf(getConnectionCfgString()) + "\n\n" + e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private <T> T doCall(Callable<T> c) throws Exception {
/* 810 */     setSessionCookies();
/* 811 */     T res = c.call();
/* 812 */     getSessionCookies();
/* 813 */     return res;
/*     */   }
/*     */   
/*     */   private void setSessionCookies() {
/* 817 */     if (this.apacheClientConfig != null) {
/* 818 */       if (this.authentication == null) {
/* 819 */         this.authentication = this.restClient.getSessionClient().login(this.server.getUsername(), this.server.getPassword(), (ProgressMonitor)this.pm);
/*     */       }
/* 821 */       synchronized (this) {
/* 822 */         if (this.authentication != null) {
/* 823 */           Cookie cookie = new Cookie();
/* 824 */           cookie.setName(this.authentication.getSession().getName());
/* 825 */           cookie.setValue(this.authentication.getSession().getValue());
/* 826 */           cookie.setPath("/");
/* 827 */           int idx = this.server.getUrl().indexOf("//");
/* 828 */           String domain = (idx > 0) ? this.server.getUrl().substring(idx + 2) : this.server.getUrl();
/* 829 */           cookie.setDomain(domain);
/* 830 */           this.apacheClientConfig.getState().getHttpState().addCookie(cookie);
/*     */         } else {
/* 832 */           this.apacheClientConfig.getState().getHttpState().clearCookies();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private synchronized void getSessionCookies() {
/* 839 */     if (this.apacheClientConfig == null) {
/*     */       return;
/*     */     }
/*     */     
/* 843 */     Cookie[] cookies = this.apacheClientConfig.getState().getHttpState().getCookies(); byte b; int i; Cookie[] arrayOfCookie1;
/* 844 */     for (i = (arrayOfCookie1 = cookies).length, b = 0; b < i; ) { Cookie cookie = arrayOfCookie1[b];
/* 845 */       if (cookie.getName().toLowerCase().equals("jsessionid"))
/* 846 */         this.authentication = new Authentication(null, new SessionCookie(cookie.getName(), cookie.getValue())); 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   private void setupApacheClient(ApacheHttpClientConfig config) {
/* 852 */     this.apacheClientConfig = config;
/* 853 */     if (this.proxyInfo != null && this.proxyInfo.isUseHttpProxy() && this.proxyInfo.isProxyAuthentication()) {
/* 854 */       config.getState().setProxyCredentials(AuthScope.ANY_REALM, this.proxyInfo.getProxyHost(), 
/* 855 */           this.proxyInfo.getProxyPort(), this.proxyInfo.getProxyLogin(), this.proxyInfo.getPlainProxyPassword());
/*     */     }
/*     */   }
/*     */   
/*     */   private String getConnectionCfgString() {
/* 860 */     return String.valueOf(notNullString(this.server.getUsername())) + (
/* 861 */       (this.server.getPassword() != null) ? (
/* 862 */       ":[password " + this.server.getPassword().length() + " chars]") : 
/* 863 */       "<null>") + 
/*     */       
/* 865 */       "@" + this.server.getUrl();
/*     */   }
/*     */   
/*     */   private static String notNullString(String str) {
/* 869 */     if (str == null) {
/* 870 */       return "<null>";
/*     */     }
/* 872 */     return str;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\rest\JiraRestSessionImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */