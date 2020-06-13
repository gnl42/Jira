/*     */ package com.atlassian.theplugin.commons.crucible.api.model;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.Set;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.joda.time.DateTime;
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
/*     */ public class BasicReview
/*     */ {
/*     */   private Set<Reviewer> reviewers;
/*  32 */   private Set<CrucibleAction> transitions = MiscUtil.buildHashSet();
/*  33 */   private Set<CrucibleAction> actions = MiscUtil.buildHashSet();
/*     */   
/*     */   @NotNull
/*     */   private User author;
/*     */   
/*     */   private User creator;
/*     */   private String description;
/*     */   @Nullable
/*     */   private User moderator;
/*     */   private String name;
/*     */   @Nullable
/*     */   private PermId parentReview;
/*     */   private PermId permId;
/*     */   @NotNull
/*     */   private String projectKey;
/*     */   private String repoName;
/*     */   private State state;
/*     */   private boolean allowReviewerToJoin;
/*     */   private int metricsVersion;
/*     */   private Date createDate;
/*     */   private Date closeDate;
/*     */   @Nullable
/*     */   private DateTime dueDate;
/*     */   private String summary;
/*     */   private final String serverUrl;
/*     */   private final ReviewType type;
/*     */   
/*     */   public BasicReview(@NotNull ReviewType type, @NotNull String serverUrl, @NotNull String projectKey, @NotNull User author, @Nullable User moderator) {
/*  61 */     this.type = type;
/*  62 */     this.serverUrl = serverUrl;
/*  63 */     this.projectKey = projectKey;
/*  64 */     this.author = author;
/*  65 */     this.moderator = moderator;
/*     */   }
/*     */   
/*     */   public ReviewType getType() {
/*  69 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setReviewers(Set<Reviewer> reviewers) {
/*  73 */     this.reviewers = reviewers;
/*     */   }
/*     */   
/*     */   public void setTransitions(@NotNull Collection<CrucibleAction> transitions) {
/*  77 */     this.transitions = MiscUtil.buildHashSet(transitions);
/*     */   }
/*     */   
/*     */   public void setActions(@NotNull Set<CrucibleAction> actions) {
/*  81 */     this.actions = MiscUtil.buildHashSet(actions);
/*     */   }
/*     */   
/*     */   public void setAuthor(@NotNull User author) {
/*  85 */     this.author = author;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getServerUrl() {
/*  90 */     return this.serverUrl;
/*     */   }
/*     */   
/*     */   public Set<Reviewer> getReviewers() {
/*  94 */     return this.reviewers;
/*     */   }
/*     */   
/*     */   public Set<CrucibleAction> getTransitions() {
/*  98 */     return this.transitions;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Set<CrucibleAction> getActions() {
/* 103 */     return this.actions;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCompleted() {
/* 108 */     for (Reviewer reviewer : this.reviewers) {
/* 109 */       if (!reviewer.isCompleted()) {
/* 110 */         return false;
/*     */       }
/*     */     } 
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public User getAuthor() {
/* 118 */     return this.author;
/*     */   }
/*     */   
/*     */   public User getCreator() {
/* 122 */     return this.creator;
/*     */   }
/*     */   
/*     */   public void setCreator(User value) {
/* 126 */     this.creator = value;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 130 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String value) {
/* 134 */     this.description = value;
/*     */   }
/*     */   
/*     */   public User getModerator() {
/* 138 */     return this.moderator;
/*     */   }
/*     */   
/*     */   public void setModerator(User value) {
/* 142 */     this.moderator = value;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 146 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String value) {
/* 150 */     this.name = value;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public PermId getParentReview() {
/* 155 */     return this.parentReview;
/*     */   }
/*     */   
/*     */   public void setParentReview(PermId value) {
/* 159 */     this.parentReview = value;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public PermId getPermId() {
/* 164 */     return this.permId;
/*     */   }
/*     */   
/*     */   public void setPermId(PermId value) {
/* 168 */     this.permId = value;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getProjectKey() {
/* 173 */     return this.projectKey;
/*     */   }
/*     */   
/*     */   public void setProjectKey(@NotNull String value) {
/* 177 */     this.projectKey = value;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getRepoName() {
/* 182 */     return this.repoName;
/*     */   }
/*     */   
/*     */   public void setRepoName(String value) {
/* 186 */     this.repoName = value;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public State getState() {
/* 191 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(State value) {
/* 195 */     this.state = value;
/*     */   }
/*     */   
/*     */   public boolean isAllowReviewerToJoin() {
/* 199 */     return this.allowReviewerToJoin;
/*     */   }
/*     */   
/*     */   public void setAllowReviewerToJoin(boolean allowReviewerToJoin) {
/* 203 */     this.allowReviewerToJoin = allowReviewerToJoin;
/*     */   }
/*     */   
/*     */   public int getMetricsVersion() {
/* 207 */     return this.metricsVersion;
/*     */   }
/*     */   
/*     */   public void setMetricsVersion(int metricsVersion) {
/* 211 */     this.metricsVersion = metricsVersion;
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 215 */     return this.createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date createDate) {
/* 219 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */   public Date getCloseDate() {
/* 223 */     return this.closeDate;
/*     */   }
/*     */   
/*     */   public void setCloseDate(Date closeDate) {
/* 227 */     this.closeDate = closeDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 232 */     if (this == o) {
/* 233 */       return true;
/*     */     }
/* 235 */     if (o == null || getClass() != o.getClass()) {
/* 236 */       return false;
/*     */     }
/*     */     
/* 239 */     BasicReview that = (BasicReview)o;
/*     */     
/* 241 */     return !((this.permId != null) ? !this.permId.equals(that.permId) : (that.permId != null));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 247 */     int result = (this.permId != null) ? this.permId.hashCode() : 0;
/* 248 */     return result;
/*     */   }
/*     */   
/*     */   public String getSummary() {
/* 252 */     return this.summary;
/*     */   }
/*     */   
/*     */   public void setSummary(String summary) {
/* 256 */     this.summary = summary;
/*     */   }
/*     */   
/*     */   public void setDueDate(DateTime dueDate) {
/* 260 */     this.dueDate = dueDate;
/*     */   }
/*     */   
/*     */   public DateTime getDueDate() {
/* 264 */     return this.dueDate;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\BasicReview.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */