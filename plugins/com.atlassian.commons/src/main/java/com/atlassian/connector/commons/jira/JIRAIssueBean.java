/*     */ package com.atlassian.connector.commons.jira;
/*     */ 
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAComment;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRACommentBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAComponentBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAConstant;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAPriorityBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRASecurityLevelBean;
/*     */ import com.atlassian.connector.commons.jira.beans.JIRAVersionBean;
/*     */ import com.atlassian.connector.commons.jira.soap.axis.RemoteIssue;
/*     */ import com.atlassian.jira.rest.client.IssueRestClient;
/*     */ import com.atlassian.jira.rest.client.domain.BasicComponent;
/*     */ import com.atlassian.jira.rest.client.domain.BasicIssueType;
/*     */ import com.atlassian.jira.rest.client.domain.BasicPriority;
/*     */ import com.atlassian.jira.rest.client.domain.BasicResolution;
/*     */ import com.atlassian.jira.rest.client.domain.BasicStatus;
/*     */ import com.atlassian.jira.rest.client.domain.BasicUser;
/*     */ import com.atlassian.jira.rest.client.domain.Comment;
/*     */ import com.atlassian.jira.rest.client.domain.Field;
/*     */ import com.atlassian.jira.rest.client.domain.Issue;
/*     */ import com.atlassian.jira.rest.client.domain.IssueLink;
/*     */ import com.atlassian.jira.rest.client.domain.IssueType;
/*     */ import com.atlassian.jira.rest.client.domain.Priority;
/*     */ import com.atlassian.jira.rest.client.domain.Status;
/*     */ import com.atlassian.jira.rest.client.domain.Subtask;
/*     */ import com.atlassian.jira.rest.client.domain.Version;
/*     */ import com.atlassian.jira.rest.client.internal.json.JsonParseUtil;
/*     */ import com.google.common.base.Objects;
/*     */ import com.google.common.base.Optional;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.text.DateFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.codehaus.jettison.json.JSONArray;
/*     */ import org.codehaus.jettison.json.JSONException;
/*     */ import org.codehaus.jettison.json.JSONObject;
/*     */ import org.jdom.Element;
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
/*     */ public class JIRAIssueBean
/*     */   implements JIRAIssue
/*     */ {
/*     */   private Long id;
/*     */   private String serverUrl;
/*     */   private String key;
/*     */   private String summary;
/*     */   private String status;
/*     */   private String statusUrl;
/*     */   private String type;
/*     */   private String typeUrl;
/*     */   private String priority;
/*     */   private String priorityUrl;
/*     */   private String description;
/*     */   private String wikiDescription;
/*     */   private String projectKey;
/*     */   private JIRAConstant statusConstant;
/*     */   private JIRAConstant typeConstant;
/*     */   private JIRAPriorityBean priorityConstant;
/*     */   private String assignee;
/*     */   private String assigneeId;
/*     */   private String reporter;
/*     */   private String reporterId;
/*     */   private String resolution;
/*     */   private String created;
/*     */   private String updated;
/*     */   private long statusId;
/*     */   private long priorityId;
/*     */   private long typeId;
/*     */   private List<JIRAConstant> affectsVersions;
/*     */   private List<JIRAConstant> fixVersions;
/*     */   private List<JIRAConstant> components;
/*     */   private List<String> subTaskList;
/*     */   private boolean thisIsASubTask;
/*     */   private Map<String, Map<String, List<String>>> issueLinks;
/*     */   private String parentIssueKey;
/*     */   private String originalEstimate;
/*     */   private String remainingEstimate;
/*     */   private String timeSpent;
/*     */   private List<JIRAComment> commentsList;
/*     */   private Object apiIssueObject;
/*     */   private String originalEstimateInSeconds;
/*     */   private String remainingEstimateInSeconds;
/*     */   private String timeSpentInSeconds;
/*     */   private JIRASecurityLevelBean securityLevel;
/*     */   private String environment;
/* 108 */   private List<JiraCustomField> basicCustomFields = new ArrayList<JiraCustomField>(); private Locale locale;
/*     */   private static final int ONE_EFF = 31;
/*     */   
/*     */   public JIRAIssueBean() {
/* 112 */     this.locale = Locale.US;
/*     */   }
/*     */   
/*     */   public JIRAIssueBean(JIRAIssue issue) {
/* 116 */     this.locale = issue.getLocale();
/* 117 */     this.id = issue.getId();
/* 118 */     this.serverUrl = issue.getServerUrl();
/* 119 */     this.key = issue.getKey();
/* 120 */     this.summary = issue.getSummary();
/* 121 */     this.status = issue.getStatus();
/* 122 */     this.statusUrl = issue.getStatusTypeUrl();
/* 123 */     this.type = issue.getType();
/* 124 */     this.typeUrl = issue.getTypeIconUrl();
/* 125 */     this.priority = issue.getPriority();
/* 126 */     this.priorityUrl = issue.getPriorityIconUrl();
/* 127 */     this.description = issue.getDescription();
/* 128 */     this.wikiDescription = issue.getWikiDescription();
/* 129 */     this.projectKey = issue.getProjectKey();
/* 130 */     this.statusConstant = issue.getStatusConstant();
/* 131 */     this.typeConstant = issue.getTypeConstant();
/* 132 */     this.priorityConstant = issue.getPriorityConstant();
/* 133 */     this.assignee = issue.getAssignee();
/* 134 */     this.assigneeId = issue.getAssigneeId();
/* 135 */     this.reporter = issue.getReporter();
/* 136 */     this.reporterId = issue.getReporterId();
/* 137 */     this.resolution = issue.getResolution();
/* 138 */     this.created = issue.getCreated();
/* 139 */     this.updated = issue.getUpdated();
/* 140 */     this.statusId = issue.getStatusId();
/* 141 */     this.priorityId = issue.getPriorityId();
/* 142 */     this.typeId = issue.getTypeId();
/* 143 */     this.affectsVersions = issue.getAffectsVersions();
/* 144 */     this.fixVersions = issue.getFixVersions();
/* 145 */     this.components = issue.getComponents();
/* 146 */     this.subTaskList = issue.getSubTaskKeys();
/* 147 */     this.thisIsASubTask = issue.isSubTask();
/* 148 */     this.issueLinks = issue.getIssueLinks();
/* 149 */     this.parentIssueKey = issue.getParentIssueKey();
/* 150 */     this.originalEstimate = issue.getOriginalEstimate();
/* 151 */     this.remainingEstimate = issue.getRemainingEstimate();
/* 152 */     this.timeSpent = issue.getTimeSpent();
/* 153 */     this.commentsList = issue.getComments();
/* 154 */     this.apiIssueObject = issue.getApiIssueObject();
/* 155 */     this.originalEstimateInSeconds = issue.getOriginalEstimateInSeconds();
/* 156 */     this.remainingEstimateInSeconds = issue.getRemainingEstimateInSeconds();
/* 157 */     this.timeSpentInSeconds = issue.getTimeSpentInSeconds();
/* 158 */     this.securityLevel = issue.getSecurityLevel();
/* 159 */     this.environment = issue.getEnvironment();
/* 160 */     this.basicCustomFields = issue.getCustomFields();
/*     */   }
/*     */   
/*     */   public JIRAIssueBean(String serverUrl, Element e, Locale locale) {
/* 164 */     this.locale = locale;
/* 165 */     this.summary = getTextSafely(e, "summary");
/* 166 */     this.key = getTextSafely(e, "key");
/* 167 */     this.id = new Long(getAttributeSafely(e, "key", "id"));
/* 168 */     updateProjectKey();
/* 169 */     this.status = getTextSafely(e, "status");
/* 170 */     this.statusUrl = getAttributeSafely(e, "status", "iconUrl");
/*     */     try {
/* 172 */       this.statusId = Long.parseLong(getAttributeSafely(e, "status", "id"));
/* 173 */     } catch (NumberFormatException numberFormatException) {
/* 174 */       this.statusId = 0L;
/*     */     } 
/* 176 */     this.priority = getTextSafely(e, "priority", "Unknown");
/* 177 */     this.priorityUrl = getAttributeSafely(e, "priority", "iconUrl");
/*     */     try {
/* 179 */       this.priorityId = Long.parseLong(getAttributeSafely(e, "priority", "id"));
/* 180 */     } catch (NumberFormatException numberFormatException) {
/* 181 */       this.priorityId = 0L;
/*     */     } 
/* 183 */     this.description = getTextSafely(e, "description");
/* 184 */     this.environment = getTextSafely(e, "environment");
/*     */     
/* 186 */     this.type = getTextSafely(e, "type");
/* 187 */     this.typeUrl = getAttributeSafely(e, "type", "iconUrl");
/*     */     try {
/* 189 */       this.typeId = Long.parseLong(getAttributeSafely(e, "type", "id"));
/* 190 */     } catch (NumberFormatException numberFormatException) {
/* 191 */       this.typeId = 0L;
/*     */     } 
/* 193 */     this.assignee = getTextSafely(e, "assignee");
/* 194 */     this.assigneeId = getAttributeSafely(e, "assignee", "username");
/* 195 */     this.reporter = getTextSafely(e, "reporter");
/* 196 */     this.reporterId = getAttributeSafely(e, "reporter", "username");
/* 197 */     this.created = getTextSafely(e, "created");
/* 198 */     this.updated = getTextSafely(e, "updated");
/* 199 */     this.resolution = getTextSafely(e, "resolution");
/*     */     
/* 201 */     this.parentIssueKey = getTextSafely(e, "parent");
/* 202 */     this.thisIsASubTask = (this.parentIssueKey != null);
/* 203 */     this.subTaskList = new ArrayList<String>();
/* 204 */     Element subtasks = e.getChild("subtasks");
/* 205 */     if (subtasks != null) {
/* 206 */       for (Object subtask : subtasks.getChildren("subtask")) {
/* 207 */         String subTaskKey = ((Element)subtask).getText();
/* 208 */         if (subTaskKey != null) {
/* 209 */           this.subTaskList.add(subTaskKey);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 214 */     Element issueLinksElement = e.getChild("issuelinks");
/* 215 */     if (issueLinksElement != null) {
/* 216 */       this.issueLinks = new HashMap<String, Map<String, List<String>>>();
/* 217 */       for (Object issueLinkTypeObj : issueLinksElement.getChildren("issuelinktype")) {
/* 218 */         Element issueLinkType = (Element)issueLinkTypeObj;
/* 219 */         String linkName = getTextSafely(issueLinkType, "name");
/* 220 */         Map<String, List<String>> map = new HashMap<String, List<String>>(); byte b; int i; String[] arrayOfString;
/* 221 */         for (i = (arrayOfString = new String[] { "outwardlinks", "inwardlinks" }, ).length, b = 0; b < i; ) { String direction = arrayOfString[b];
/* 222 */           Element outwardLinks = issueLinkType.getChild(direction);
/* 223 */           if (outwardLinks != null) {
/* 224 */             String linkDescription = outwardLinks.getAttributeValue("description");
/* 225 */             List<String> issueLinkList = new ArrayList<String>();
/* 226 */             map.put(linkDescription, issueLinkList);
/* 227 */             for (Object issueLinkObj : outwardLinks.getChildren("issuelink")) {
/* 228 */               Element issueLink = (Element)issueLinkObj;
/* 229 */               String issueKey = getTextSafely(issueLink, "issuekey");
/* 230 */               if (issueKey != null)
/*     */               {
/* 232 */                 issueLinkList.add(issueKey);
/*     */               }
/*     */             } 
/* 235 */             this.issueLinks.put(linkName, map);
/*     */           }  b++; }
/*     */       
/*     */       } 
/*     */     } 
/* 240 */     this.originalEstimate = getTextSafely(e, "timeoriginalestimate");
/* 241 */     this.remainingEstimate = getTextSafely(e, "timeestimate");
/* 242 */     this.timeSpent = getTextSafely(e, "timespent");
/* 243 */     this.originalEstimateInSeconds = getAttributeSafely(e, "timeoriginalestimate", "seconds");
/* 244 */     this.remainingEstimateInSeconds = getAttributeSafely(e, "timeestimate", "seconds");
/* 245 */     this.timeSpentInSeconds = getAttributeSafely(e, "timespent", "seconds");
/* 246 */     this.serverUrl = serverUrl;
/*     */     
/* 248 */     Element comments = e.getChild("comments");
/* 249 */     if (comments != null) {
/* 250 */       this.commentsList = new ArrayList<JIRAComment>();
/* 251 */       for (Object comment : comments.getChildren("comment")) {
/* 252 */         Element el = (Element)comment;
/* 253 */         String commentId = el.getAttributeValue("id", "-1");
/* 254 */         String author = el.getAttributeValue("author", "Unknown");
/* 255 */         String text = el.getText();
/* 256 */         String creationDate = el.getAttributeValue("created", "Unknown");
/*     */         
/* 258 */         Calendar cal = Calendar.getInstance();
/* 259 */         DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z (z)", locale);
/*     */         try {
/* 261 */           cal.setTime(df.parse(creationDate));
/* 262 */         } catch (ParseException parseException) {
/*     */           
/* 264 */           df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", locale);
/*     */           try {
/* 266 */             cal.setTime(df.parse(creationDate));
/* 267 */           } catch (ParseException parseException1) {}
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 272 */         this.commentsList.add(new JIRACommentBean(commentId, author, text, cal));
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     Element customfields = e.getChild("customfields");
/* 277 */     if (customfields != null && customfields.getChildren().size() > 0) {
/* 278 */       for (Object fieldElement : customfields.getChildren()) {
/* 279 */         this.basicCustomFields.add((new JiraCustomFieldImpl.Builder((Element)fieldElement)).build());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public JIRAIssueBean(String url, RemoteIssue remoteIssue) {
/* 285 */     this.serverUrl = url;
/* 286 */     this.id = Long.valueOf(remoteIssue.getId());
/* 287 */     this.key = remoteIssue.getKey();
/* 288 */     this.summary = remoteIssue.getSummary();
/* 289 */     this.status = remoteIssue.getStatus();
/* 290 */     this.environment = remoteIssue.getEnvironment();
/*     */     
/* 292 */     this.type = remoteIssue.getType();
/*     */     
/* 294 */     this.priority = remoteIssue.getPriority();
/*     */     
/* 296 */     this.wikiDescription = remoteIssue.getDescription();
/* 297 */     this.projectKey = remoteIssue.getProject();
/*     */ 
/*     */ 
/*     */     
/* 301 */     this.assignee = remoteIssue.getAssignee();
/*     */     
/* 303 */     this.reporter = remoteIssue.getReporter();
/*     */     
/* 305 */     this.resolution = remoteIssue.getResolution();
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
/*     */   public JIRAIssueBean(String url, Issue issue) {
/* 324 */     this.locale = Locale.US;
/*     */     
/* 326 */     this.apiIssueObject = issue;
/* 327 */     this.serverUrl = url;
/* 328 */     this.id = issue.getId();
/* 329 */     this.key = issue.getKey();
/* 330 */     this.projectKey = issue.getProject().getKey();
/* 331 */     this.thisIsASubTask = issue.getIssueType().isSubtask();
/* 332 */     if (this.thisIsASubTask && 
/* 333 */       issue.getField("parent") != null) {
/* 334 */       Object parent = issue.getField("parent").getValue();
/* 335 */       if (parent instanceof JSONObject) {
/* 336 */         this.parentIssueKey = JsonParseUtil.getOptionalString((JSONObject)parent, "key");
/*     */       }
/*     */     } 
/*     */     
/* 340 */     this.summary = issue.getSummary();
/* 341 */     this.description = getHtmlDescription(issue);
/* 342 */     this.wikiDescription = issue.getDescription();
/* 343 */     BasicIssueType issueType = issue.getIssueType();
/* 344 */     this.type = issueType.getName();
/* 345 */     Long issueTypeId = issueType.getId();
/* 346 */     if (issueType instanceof IssueType) {
/* 347 */       this.typeUrl = ((IssueType)issueType).getIconUri().toString();
/*     */     }
/* 349 */     this.typeId = (issueTypeId != null) ? issueTypeId.longValue() : -1L;
/* 350 */     BasicStatus s = issue.getStatus();
/* 351 */     this.statusId = s.getId().longValue();
/* 352 */     this.status = s.getName();
/* 353 */     if (s instanceof Status) {
/* 354 */       this.statusUrl = ((Status)s).getIconUrl().toString();
/*     */     }
/*     */     
/* 357 */     BasicResolution res = issue.getResolution();
/* 358 */     this.resolution = (res != null) ? res.getName() : "Unresolved";
/*     */     
/* 360 */     BasicUser ass = issue.getAssignee();
/* 361 */     if (ass != null) {
/* 362 */       this.assigneeId = ass.getName();
/* 363 */       this.assignee = ass.getDisplayName();
/*     */     } 
/* 365 */     BasicUser rep = issue.getReporter();
/* 366 */     if (rep != null) {
/* 367 */       this.reporterId = rep.getName();
/* 368 */       this.reporter = rep.getDisplayName();
/*     */     } 
/*     */     
/* 371 */     BasicPriority prio = issue.getPriority();
/* 372 */     if (prio != null) {
/* 373 */       Long prioId = prio.getId();
/* 374 */       this.priorityId = (prioId != null) ? prioId.longValue() : -1L;
/* 375 */       this.priority = prio.getName();
/* 376 */       if (prio instanceof Priority) {
/* 377 */         this.priorityUrl = ((Priority)prio).getIconUri().toString();
/*     */       }
/*     */     } 
/* 380 */     DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.US);
/* 381 */     this.created = df.format(issue.getCreationDate().toDate());
/* 382 */     this.updated = df.format(issue.getUpdateDate().toDate());
/* 383 */     this.subTaskList = Lists.newArrayList();
/* 384 */     Iterable<Subtask> subtasks = issue.getSubtasks();
/* 385 */     if (subtasks != null) {
/* 386 */       for (Subtask subtask : subtasks) {
/* 387 */         this.subTaskList.add(subtask.getIssueKey());
/*     */       }
/*     */     }
/* 390 */     this.components = Lists.newArrayList();
/* 391 */     Iterable<BasicComponent> components = issue.getComponents();
/* 392 */     if (components != null) {
/* 393 */       for (BasicComponent component : components) {
/* 394 */         this.components.add(new JIRAComponentBean(component.getId().longValue(), component.getName()));
/*     */       }
/*     */     }
/* 397 */     this.affectsVersions = Lists.newArrayList();
/* 398 */     Iterable<Version> aVersions = issue.getAffectedVersions();
/* 399 */     if (aVersions != null) {
/* 400 */       for (Version v : aVersions) {
/* 401 */         this.affectsVersions.add(new JIRAVersionBean(v.getId().longValue(), v.getName(), v.isReleased()));
/*     */       }
/*     */     }
/* 404 */     this.fixVersions = Lists.newArrayList();
/* 405 */     Iterable<Version> fVersions = issue.getFixVersions();
/* 406 */     if (fVersions != null) {
/* 407 */       for (Version v : fVersions) {
/* 408 */         this.fixVersions.add(new JIRAVersionBean(v.getId().longValue(), v.getName(), v.isReleased()));
/*     */       }
/*     */     }
/* 411 */     this.issueLinks = Maps.newHashMap();
/* 412 */     Iterable<IssueLink> links = issue.getIssueLinks();
/* 413 */     if (links != null) {
/* 414 */       for (IssueLink link : links) {
/* 415 */         String linkName = link.getIssueLinkType().getName();
/* 416 */         Map<String, List<String>> map = this.issueLinks.get(linkName);
/* 417 */         if (map == null) {
/* 418 */           map = Maps.newHashMap();
/*     */         }
/* 420 */         String description = link.getIssueLinkType().getDescription();
/* 421 */         List<String> issueKeys = map.get(description);
/* 422 */         if (issueKeys == null) {
/* 423 */           issueKeys = Lists.newArrayList();
/*     */         }
/* 425 */         issueKeys.add(link.getTargetIssueKey());
/* 426 */         map.put(description, issueKeys);
/*     */         
/* 428 */         this.issueLinks.put(linkName, map);
/*     */       } 
/*     */     }
/*     */     
/* 432 */     Iterable<Comment> comments = issue.getComments();
/* 433 */     if (comments != null) {
/* 434 */       this.commentsList = Lists.newArrayList();
/* 435 */       for (Comment comment : comments) {
/* 436 */         Long cmtId = comment.getId();
/* 437 */         BasicUser commentAuthor = comment.getAuthor();
/* 438 */         Calendar created = comment.getCreationDate().toGregorianCalendar();
/* 439 */         created.setTimeZone(comment.getCreationDate().getZone().toTimeZone());
/* 440 */         this.commentsList.add(new JIRACommentBean(
/* 441 */               (cmtId != null) ? cmtId.toString() : "", 
/* 442 */               (commentAuthor != null) ? commentAuthor.getName() : null, 
/* 443 */               getHtmlBodyForComment(issue, comment), created));
/*     */       } 
/*     */     } 
/*     */     
/* 447 */     JSONObject rfs = getRenderedFields(issue.getRawObject());
/* 448 */     if (rfs != null) {
/* 449 */       JSONObject timetracking = JsonParseUtil.getOptionalJsonObject(rfs, "timetracking");
/* 450 */       if (timetracking != null) {
/* 451 */         this.originalEstimate = JsonParseUtil.getOptionalString(timetracking, "originalEstimate");
/* 452 */         this.remainingEstimate = JsonParseUtil.getOptionalString(timetracking, "remainingEstimate");
/* 453 */         this.timeSpent = JsonParseUtil.getOptionalString(timetracking, "timeSpent");
/*     */         try {
/* 455 */           this.originalEstimateInSeconds = ((Long)Optional.fromNullable(JsonParseUtil.getOptionalLong(timetracking, "originalEstimateSeconds")).or(Long.valueOf(0L))).toString();
/* 456 */           this.remainingEstimateInSeconds = ((Long)Optional.fromNullable(JsonParseUtil.getOptionalLong(timetracking, "remainingEstimateSeconds")).or(Long.valueOf(0L))).toString();
/* 457 */           this.timeSpentInSeconds = ((Long)Optional.fromNullable(JsonParseUtil.getOptionalLong(timetracking, "timeSpentSeconds")).or(Long.valueOf(0L))).toString();
/* 458 */         } catch (JSONException jSONException) {}
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 463 */     JSONObject editmeta = JsonParseUtil.getOptionalJsonObject(issue.getRawObject(), "editmeta");
/* 464 */     JSONObject fields = (editmeta != null) ? JsonParseUtil.getOptionalJsonObject(editmeta, "fields") : null;
/* 465 */     this.basicCustomFields = Lists.newArrayList();
/* 466 */     if (fields != null) {
/* 467 */       for (Field field : issue.getFields()) {
/* 468 */         if (!field.getId().startsWith("customfield_")) {
/*     */           continue;
/*     */         }
/*     */         try {
/* 472 */           this.basicCustomFields.add((new JiraCustomFieldImpl.Builder((JSONObject)fields.get(field.getId()), field)).build());
/* 473 */         } catch (JSONException jSONException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String getHtmlDescription(Issue issue) {
/* 481 */     JSONObject rf = getRenderedFields(issue.getRawObject());
/* 482 */     if (rf == null) {
/* 483 */       return issue.getDescription();
/*     */     }
/* 485 */     String result = JsonParseUtil.getOptionalString(rf, "description");
/* 486 */     return (result != null) ? result : issue.getDescription();
/*     */   }
/*     */   
/*     */   private String getHtmlBodyForComment(Issue issue, Comment comment) {
/* 490 */     JSONObject rf = getRenderedFields(issue.getRawObject());
/*     */     
/* 492 */     if (rf == null) {
/* 493 */       return comment.getBody();
/*     */     }
/*     */     
/*     */     try {
/* 497 */       JSONArray array = rf.getJSONObject("comment").getJSONArray("comments");
/* 498 */       for (int i = 0; i < array.length(); i++) {
/* 499 */         JSONObject element = (JSONObject)array.get(i);
/* 500 */         if (Objects.equal(Long.valueOf(element.getLong("id")), comment.getId())) {
/* 501 */           return element.getString("body");
/*     */         }
/*     */       } 
/* 504 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 507 */     return comment.getBody();
/*     */   }
/*     */   
/*     */   private static JSONObject getRenderedFields(JSONObject issue) {
/* 511 */     if (issue == null) {
/* 512 */       return null;
/*     */     }
/* 514 */     return JsonParseUtil.getOptionalJsonObject(issue, IssueRestClient.Expandos.RENDERED_FIELDS.getFieldName());
/*     */   }
/*     */   
/*     */   public JIRAPriorityBean getPriorityConstant() {
/* 518 */     return this.priorityConstant;
/*     */   }
/*     */   
/*     */   public void setPriority(JIRAPriorityBean priority) {
/* 522 */     this.priority = priority.getName();
/* 523 */     this.priorityConstant = priority;
/*     */   }
/*     */   
/*     */   public JIRAIssueBean(Map params) {
/* 527 */     this.summary = (String)params.get("summary");
/* 528 */     this.status = (String)params.get("status");
/* 529 */     this.key = (String)params.get("key");
/* 530 */     this.id = new Long(params.get("key").toString());
/* 531 */     updateProjectKey();
/* 532 */     this.description = (String)params.get("description");
/* 533 */     this.type = (String)params.get("type");
/* 534 */     this.priority = (String)params.get("priority");
/*     */   }
/*     */   
/*     */   private void updateProjectKey() {
/* 538 */     if (this.key != null) {
/* 539 */       if (this.key.contains("-")) {
/* 540 */         this.projectKey = this.key.substring(0, this.key.indexOf("-"));
/*     */       } else {
/* 542 */         this.projectKey = this.key;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private String getTextSafely(Element e, String name, String defaultName) {
/* 548 */     String text = getTextSafely(e, name);
/*     */     
/* 550 */     return (text != null) ? text : defaultName;
/*     */   }
/*     */   
/*     */   private String getTextSafely(Element e, String name) {
/* 554 */     Element child = e.getChild(name);
/*     */     
/* 556 */     if (child == null) {
/* 557 */       return null;
/*     */     }
/*     */     
/* 560 */     return child.getText();
/*     */   }
/*     */   
/*     */   private String getAttributeSafely(Element e, String elementName, String attributeName) {
/* 564 */     Element child = e.getChild(elementName);
/*     */     
/* 566 */     if (child == null || child.getAttribute(attributeName) == null) {
/* 567 */       return null;
/*     */     }
/*     */     
/* 570 */     return child.getAttributeValue(attributeName);
/*     */   }
/*     */   
/*     */   public String getServerUrl() {
/* 574 */     return this.serverUrl;
/*     */   }
/*     */   
/*     */   public String getProjectUrl() {
/* 578 */     return String.valueOf(getServerUrl()) + "/browse/" + getProjectKey();
/*     */   }
/*     */   
/*     */   public String getIssueUrl() {
/* 582 */     return String.valueOf(getServerUrl()) + "/browse/" + getKey();
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getId() {
/* 587 */     return this.id;
/*     */   }
/*     */   
/*     */   public boolean isSubTask() {
/* 591 */     return this.thisIsASubTask;
/*     */   }
/*     */   
/*     */   public Map<String, Map<String, List<String>>> getIssueLinks() {
/* 595 */     return this.issueLinks;
/*     */   }
/*     */   
/*     */   public String getParentIssueKey() {
/* 599 */     return this.parentIssueKey;
/*     */   }
/*     */   
/*     */   public List<String> getSubTaskKeys() {
/* 603 */     return this.subTaskList;
/*     */   }
/*     */   
/*     */   public String getProjectKey() {
/* 607 */     return this.projectKey;
/*     */   }
/*     */   
/*     */   public String getStatus() {
/* 611 */     return this.status;
/*     */   }
/*     */   
/*     */   public String getStatusTypeUrl() {
/* 615 */     return this.statusUrl;
/*     */   }
/*     */   
/*     */   public String getPriority() {
/* 619 */     return this.priority;
/*     */   }
/*     */   
/*     */   public String getPriorityIconUrl() {
/* 623 */     return this.priorityUrl;
/*     */   }
/*     */   
/*     */   public String getKey() {
/* 627 */     return this.key;
/*     */   }
/*     */   
/*     */   public void setKey(String key) {
/* 631 */     this.key = key;
/*     */   }
/*     */   
/*     */   public String getSummary() {
/* 635 */     return this.summary;
/*     */   }
/*     */   
/*     */   public String getEnvironment() {
/* 639 */     return this.environment;
/*     */   }
/*     */   
/*     */   public String getType() {
/* 643 */     return this.type;
/*     */   }
/*     */   
/*     */   public String getTypeIconUrl() {
/* 647 */     return this.typeUrl;
/*     */   }
/*     */   
/*     */   public void setTypeIconUrl(String newTypeUrl) {
/* 651 */     this.typeUrl = newTypeUrl;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 655 */     return this.description;
/*     */   }
/*     */   
/*     */   public String getWikiDescription() {
/* 659 */     return this.wikiDescription;
/*     */   }
/*     */   
/*     */   public void setSummary(String summary) {
/* 663 */     this.summary = summary;
/*     */   }
/*     */   
/*     */   public void setProjectKey(String projectKey) {
/* 667 */     this.projectKey = projectKey;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 671 */     this.description = description;
/*     */   }
/*     */   
/*     */   public JIRAConstant getTypeConstant() {
/* 675 */     return this.typeConstant;
/*     */   }
/*     */   
/*     */   public void setType(JIRAConstant type) {
/* 679 */     this.type = type.getName();
/* 680 */     this.typeConstant = type;
/*     */   }
/*     */   
/*     */   public JIRAConstant getStatusConstant() {
/* 684 */     return this.statusConstant;
/*     */   }
/*     */   
/*     */   public void setStatus(JIRAConstant status) {
/* 688 */     this.status = status.getName();
/* 689 */     this.statusConstant = status;
/*     */   }
/*     */   
/*     */   public String getAssignee() {
/* 693 */     return this.assignee;
/*     */   }
/*     */   
/*     */   public void setAssignee(String assignee) {
/* 697 */     this.assignee = assignee;
/*     */   }
/*     */   
/*     */   public long getPriorityId() {
/* 701 */     return this.priorityId;
/*     */   }
/*     */   
/*     */   public long getStatusId() {
/* 705 */     return this.statusId;
/*     */   }
/*     */   
/*     */   public long getTypeId() {
/* 709 */     return this.typeId;
/*     */   }
/*     */   
/*     */   public String getReporter() {
/* 713 */     return this.reporter;
/*     */   }
/*     */   
/*     */   public void setReporter(String reporter) {
/* 717 */     this.reporter = reporter;
/*     */   }
/*     */   
/*     */   public String getResolution() {
/* 721 */     return this.resolution;
/*     */   }
/*     */   
/*     */   public void setResolution(String resolution) {
/* 725 */     this.resolution = resolution;
/*     */   }
/*     */   
/*     */   public String getCreated() {
/* 729 */     return this.created;
/*     */   }
/*     */   
/*     */   public void setCreated(String created) {
/* 733 */     this.created = created;
/*     */   }
/*     */   
/*     */   public String getUpdated() {
/* 737 */     return this.updated;
/*     */   }
/*     */   
/*     */   public void setUpdated(String updated) {
/* 741 */     this.updated = updated;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 746 */     if (this == o) {
/* 747 */       return true;
/*     */     }
/* 749 */     if (o == null || getClass() != o.getClass()) {
/* 750 */       return false;
/*     */     }
/*     */     
/* 753 */     JIRAIssueBean that = (JIRAIssueBean)o;
/*     */     
/* 755 */     return !((this.key != null) ? !this.key.equals(that.key) : (that.key != null));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 762 */     int result = 0;
/*     */     
/* 764 */     result = 31 * result + ((this.key != null) ? this.key.hashCode() : 0);
/* 765 */     return result;
/*     */   }
/*     */   
/*     */   public String getAssigneeId() {
/* 769 */     return this.assigneeId;
/*     */   }
/*     */   
/*     */   public void setAssigneeId(String assigneeId) {
/* 773 */     this.assigneeId = assigneeId;
/*     */   }
/*     */   
/*     */   public String getReporterId() {
/* 777 */     return this.reporterId;
/*     */   }
/*     */   
/*     */   public void setReporterId(String reporterId) {
/* 781 */     this.reporterId = reporterId;
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getAffectsVersions() {
/* 785 */     return this.affectsVersions;
/*     */   }
/*     */   
/*     */   public void setAffectsVersions(List<JIRAConstant> affectsVersions) {
/* 789 */     this.affectsVersions = affectsVersions;
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getFixVersions() {
/* 793 */     return this.fixVersions;
/*     */   }
/*     */   
/*     */   public void setFixVersions(List<JIRAConstant> fixVersions) {
/* 797 */     this.fixVersions = fixVersions;
/*     */   }
/*     */   
/*     */   public List<JIRAConstant> getComponents() {
/* 801 */     return this.components;
/*     */   }
/*     */   
/*     */   public void setComponents(List<JIRAConstant> components) {
/* 805 */     this.components = components;
/*     */   }
/*     */   
/*     */   public String getOriginalEstimate() {
/* 809 */     return this.originalEstimate;
/*     */   }
/*     */   
/*     */   public void setOriginalEstimate(String originalEstimate) {
/* 813 */     this.originalEstimate = originalEstimate;
/*     */   }
/*     */   
/*     */   public String getOriginalEstimateInSeconds() {
/* 817 */     return this.originalEstimateInSeconds;
/*     */   }
/*     */   
/*     */   public String getRemainingEstimate() {
/* 821 */     return this.remainingEstimate;
/*     */   }
/*     */   
/*     */   public String getRemainingEstimateInSeconds() {
/* 825 */     return this.remainingEstimateInSeconds;
/*     */   }
/*     */   
/*     */   public void setRemainingEstimate(String remainingEstimate) {
/* 829 */     this.remainingEstimate = remainingEstimate;
/*     */   }
/*     */   
/*     */   public String getTimeSpent() {
/* 833 */     return this.timeSpent;
/*     */   }
/*     */   
/*     */   public String getTimeSpentInSeconds() {
/* 837 */     return this.timeSpentInSeconds;
/*     */   }
/*     */   
/*     */   public void setTimeSpent(String timeSpent) {
/* 841 */     this.timeSpent = timeSpent;
/*     */   }
/*     */   
/*     */   public List<JIRAComment> getComments() {
/* 845 */     return this.commentsList;
/*     */   }
/*     */   
/*     */   public Object getApiIssueObject() {
/* 849 */     return this.apiIssueObject;
/*     */   }
/*     */   
/*     */   public void setApiIssueObject(Object o) {
/* 853 */     this.apiIssueObject = o;
/*     */   }
/*     */   
/*     */   public JIRASecurityLevelBean getSecurityLevel() {
/* 857 */     return this.securityLevel;
/*     */   }
/*     */   
/*     */   public List<JiraCustomField> getCustomFields() {
/* 861 */     return this.basicCustomFields;
/*     */   }
/*     */   
/*     */   public void setSecurityLevel(JIRASecurityLevelBean securityLevelBean) {
/* 865 */     this.securityLevel = securityLevelBean;
/*     */   }
/*     */   
/*     */   public Locale getLocale() {
/* 869 */     return this.locale;
/*     */   }
/*     */   
/*     */   public boolean usesRest() {
/* 873 */     return this.apiIssueObject instanceof Issue;
/*     */   }
/*     */   
/*     */   public void setWikiDescription(String wikiDescription) {
/* 877 */     this.wikiDescription = wikiDescription;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JIRAIssueBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */