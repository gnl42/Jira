/*     */ package com.atlassian.theplugin.commons.bamboo;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
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
/*     */ public final class BambooBuildInfo
/*     */   implements BambooBuild
/*     */ {
/*     */   private final Date pollingTime;
/*     */   private final ConnectionCfg server;
/*     */   @Nullable
/*     */   private final String projectName;
/*     */   @Nullable
/*     */   private final String projectKey;
/*     */   private final String planName;
/*     */   @NotNull
/*     */   private final String planKey;
/*     */   @Nullable
/*     */   private final String masterPlanKey;
/*     */   private final boolean enabled;
/*     */   @NotNull
/*     */   private final BuildStatus status;
/*     */   @Nullable
/*     */   private final Integer number;
/*     */   @Nullable
/*     */   private final String reason;
/*     */   private final String relativeBuildDate;
/*     */   @Nullable
/*     */   private final String durationDescription;
/*     */   private final String testSummary;
/*     */   private final String commitComment;
/*     */   private final int testsPassedCount;
/*     */   private final int testsFailedCount;
/*     */   private final Throwable exception;
/*     */   private final String errorMessage;
/*     */   @Nullable
/*     */   private final Date startDate;
/*     */   private final Date completionDate;
/*     */   private final Set<String> commiters;
/*     */   @Nullable
/*     */   private final PlanState planState;
/*     */   
/*     */   public BambooBuildInfo(@NotNull String planKey, @Nullable String planName, @Nullable String masterPlanKey, @NotNull ConnectionCfg serverData, @NotNull Date pollingTime, @Nullable String projectName, boolean isEnabled, @Nullable Integer number, @NotNull BuildStatus status, @Nullable PlanState planState, @Nullable String reason, @Nullable Date startDate, @Nullable String testSummary, @Nullable String commitComment, int testsPassedCount, int testsFailedCount, @Nullable Date completionDate, @Nullable String errorMessage, Throwable exception, @Nullable String relativeBuildDate, @Nullable String durationDescription, @Nullable Collection<String> commiters) {
/*  74 */     this.masterPlanKey = masterPlanKey;
/*  75 */     String[] split = planKey.split("-");
/*  76 */     this.projectKey = (split.length > 0) ? split[0] : null;
/*  77 */     this.exception = exception;
/*  78 */     this.pollingTime = new Date(pollingTime.getTime());
/*  79 */     this.planKey = planKey;
/*  80 */     this.planName = planName;
/*  81 */     this.planState = planState;
/*  82 */     this.server = serverData;
/*  83 */     this.projectName = projectName;
/*  84 */     this.enabled = isEnabled;
/*  85 */     this.number = number;
/*  86 */     this.status = status;
/*  87 */     this.reason = reason;
/*  88 */     this.testSummary = testSummary;
/*  89 */     this.commitComment = commitComment;
/*  90 */     this.testsPassedCount = testsPassedCount;
/*  91 */     this.testsFailedCount = testsFailedCount;
/*  92 */     this.errorMessage = errorMessage;
/*  93 */     this.relativeBuildDate = relativeBuildDate;
/*  94 */     this.durationDescription = durationDescription;
/*  95 */     this.startDate = (startDate != null) ? new Date(startDate.getTime()) : null;
/*  96 */     this.completionDate = (completionDate != null) ? new Date(completionDate.getTime()) : null;
/*  97 */     if (commiters != null) {
/*  98 */       this.commiters = new TreeSet<String>(commiters);
/*     */     } else {
/* 100 */       this.commiters = new HashSet<String>();
/*     */     } 
/*     */   }
/*     */   
/*     */   public ConnectionCfg getServer() {
/* 105 */     return this.server;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Date getCompletionDate() {
/* 110 */     return (this.completionDate == null) ? null : new Date(this.completionDate.getTime());
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getProjectKey() {
/* 115 */     return this.projectKey;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getMasterPlanKey() {
/* 120 */     return this.masterPlanKey;
/*     */   }
/*     */   
/*     */   public String getServerUrl() {
/* 124 */     return this.server.getUrl();
/*     */   }
/*     */   
/*     */   public String getBuildUrl() {
/* 128 */     return String.valueOf(getServerUrl()) + "/browse/" + this.planKey;
/*     */   }
/*     */   
/*     */   public String getResultUrl() {
/* 132 */     String url = String.valueOf(getServerUrl()) + "/browse/" + this.planKey;
/* 133 */     if (getStatus() != BuildStatus.UNKNOWN && this.number != null) {
/* 134 */       url = String.valueOf(url) + "-" + this.number;
/*     */     }
/*     */     
/* 137 */     return url;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getProjectName() {
/* 142 */     return this.projectName;
/*     */   }
/*     */   
/*     */   public String getPlanName() {
/* 146 */     return this.planName;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getPlanKey() {
/* 151 */     return this.planKey;
/*     */   }
/*     */   
/*     */   public boolean getEnabled() {
/* 155 */     return this.enabled;
/*     */   }
/*     */   
/*     */   public boolean isValid() {
/* 159 */     return (this.number != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumber() throws UnsupportedOperationException {
/* 167 */     if (this.number == null) {
/* 168 */       throw new UnsupportedOperationException("This build has no number information");
/*     */     }
/* 170 */     return this.number.intValue();
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getReason() {
/* 175 */     return this.reason;
/*     */   }
/*     */   
/*     */   public String getRelativeBuildDate() {
/* 179 */     return this.relativeBuildDate;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getDurationDescription() {
/* 184 */     return this.durationDescription;
/*     */   }
/*     */   
/*     */   public String getTestSummary() {
/* 188 */     return this.testSummary;
/*     */   }
/*     */   
/*     */   public String getCommitComment() {
/* 192 */     return this.commitComment;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public BuildStatus getStatus() {
/* 197 */     return this.status;
/*     */   }
/*     */   
/*     */   public String getErrorMessage() {
/* 201 */     return this.errorMessage;
/*     */   }
/*     */   
/*     */   public Throwable getException() {
/* 205 */     return this.exception;
/*     */   }
/*     */   
/*     */   public int getTestsPassed() {
/* 209 */     return this.testsPassedCount;
/*     */   }
/*     */   
/*     */   public int getTestsFailed() {
/* 213 */     return this.testsFailedCount;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Date getStartDate() {
/* 218 */     return (this.startDate != null) ? new Date(this.startDate.getTime()) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 223 */     return String.valueOf(this.projectName) + 
/* 224 */       " " + this.planName + 
/* 225 */       " " + this.planKey + 
/* 226 */       " " + this.status + 
/* 227 */       " " + this.reason + 
/* 228 */       " " + this.startDate + 
/* 229 */       " " + this.durationDescription + 
/* 230 */       " " + this.testSummary + 
/* 231 */       " " + this.commitComment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMyBuild() {
/* 238 */     return this.commiters.contains(this.server.getUsername());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> getCommiters() {
/* 245 */     return this.commiters;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Date getPollingTime() {
/* 250 */     return new Date(this.pollingTime.getTime());
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public PlanState getPlanState() {
/* 255 */     return this.planState;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 261 */     int result = 1;
/* 262 */     result = 31 * result + ((this.number == null) ? 0 : this.number.hashCode());
/* 263 */     result = 31 * result + this.planKey.hashCode();
/* 264 */     result = 31 * result + ((this.planName == null) ? 0 : this.planName.hashCode());
/* 265 */     result = 31 * result + ((this.projectName == null) ? 0 : this.projectName.hashCode());
/* 266 */     result = 31 * result + ((this.server == null) ? 0 : this.server.hashCode());
/* 267 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 272 */     if (this == obj) {
/* 273 */       return true;
/*     */     }
/* 275 */     if (obj == null) {
/* 276 */       return false;
/*     */     }
/* 278 */     if (getClass() != obj.getClass()) {
/* 279 */       return false;
/*     */     }
/*     */     
/* 282 */     BambooBuildInfo other = (BambooBuildInfo)obj;
/*     */     
/* 284 */     if (this.number == null) {
/* 285 */       if (other.number != null) {
/* 286 */         return false;
/*     */       }
/* 288 */     } else if (!this.number.equals(other.number)) {
/* 289 */       return false;
/*     */     } 
/* 291 */     if (!this.planKey.equals(other.planKey)) {
/* 292 */       return false;
/*     */     }
/* 294 */     if (this.planName == null) {
/* 295 */       if (other.planName != null) {
/* 296 */         return false;
/*     */       }
/* 298 */     } else if (!this.planName.equals(other.planName)) {
/* 299 */       return false;
/*     */     } 
/* 301 */     if (this.projectName == null) {
/* 302 */       if (other.projectName != null) {
/* 303 */         return false;
/*     */       }
/* 305 */     } else if (!this.projectName.equals(other.projectName)) {
/* 306 */       return false;
/*     */     } 
/* 308 */     if (this.server == null) {
/* 309 */       if (other.server != null) {
/* 310 */         return false;
/*     */       }
/* 312 */     } else if (!this.server.equals(other.server)) {
/* 313 */       return false;
/*     */     } 
/* 315 */     return true;
/*     */   }
/*     */   
/*     */   public static class Builder
/*     */   {
/*     */     private final String planKey;
/*     */     private final String planName;
/*     */     @Nullable
/*     */     private String masterPlanKey;
/*     */     private final ConnectionCfg serverData;
/*     */     private final String projectName;
/*     */     private final Integer buildNumber;
/*     */     @NotNull
/*     */     private final BuildStatus buildState;
/*     */     private boolean isEnabled = true;
/*     */     private String message;
/*     */     private Date startTime;
/*     */     private Collection<String> commiters;
/*     */     @NotNull
/* 334 */     private Date pollingTime = new Date();
/*     */     private String buildReason;
/*     */     @Nullable
/*     */     private String testSummary;
/*     */     @Nullable
/*     */     private String commitComment;
/*     */     private int testsPassedCount;
/*     */     private int testsFailedCount;
/*     */     private Date completionTime;
/*     */     @Nullable
/*     */     private String relativeBuildDate;
/*     */     @Nullable
/*     */     private String durationDescription;
/*     */     private Throwable exception;
/*     */     @Nullable
/*     */     private PlanState planState;
/*     */     
/*     */     public Builder(@NotNull String planKey, @NotNull ConnectionCfg serverData, @NotNull BuildStatus state) {
/* 352 */       this.planKey = planKey;
/* 353 */       this.serverData = serverData;
/* 354 */       this.buildState = state;
/* 355 */       this.planName = null;
/* 356 */       this.projectName = null;
/* 357 */       this.buildNumber = null;
/*     */     }
/*     */ 
/*     */     
/*     */     public Builder(@NotNull String planKey, @Nullable String planName, @NotNull ConnectionCfg serverData, @Nullable String projectName, @Nullable Integer buildNumber, @NotNull BuildStatus state) {
/* 362 */       this.planKey = planKey;
/* 363 */       this.planName = planName;
/* 364 */       this.serverData = serverData;
/* 365 */       this.projectName = projectName;
/* 366 */       this.buildNumber = buildNumber;
/* 367 */       this.buildState = state;
/*     */     }
/*     */     
/*     */     public Builder masterPlanKey(String aMasterPlanKey) {
/* 371 */       this.masterPlanKey = aMasterPlanKey;
/* 372 */       return this;
/*     */     }
/*     */     
/*     */     public Builder enabled(boolean aIsEnabled) {
/* 376 */       this.isEnabled = aIsEnabled;
/* 377 */       return this;
/*     */     }
/*     */     
/*     */     public Builder reason(String aReason) {
/* 381 */       this.buildReason = aReason;
/* 382 */       return this;
/*     */     }
/*     */     
/*     */     public Builder errorMessage(String aMessage) {
/* 386 */       this.message = aMessage;
/* 387 */       return this;
/*     */     }
/*     */     
/*     */     public Builder errorMessage(String aMessage, Throwable aException) {
/* 391 */       this.message = aMessage;
/* 392 */       this.exception = aException;
/* 393 */       return this;
/*     */     }
/*     */     
/*     */     public Builder startTime(Date aStartTime) {
/* 397 */       this.startTime = aStartTime;
/* 398 */       return this;
/*     */     }
/*     */     
/*     */     public Builder completionTime(Date aCompletionTime) {
/* 402 */       this.completionTime = aCompletionTime;
/* 403 */       return this;
/*     */     }
/*     */     
/*     */     public Builder commiters(Collection<String> aCommiters) {
/* 407 */       this.commiters = aCommiters;
/* 408 */       return this;
/*     */     }
/*     */     
/*     */     public Builder testSummary(@Nullable String aTestSummary) {
/* 412 */       this.testSummary = aTestSummary;
/* 413 */       return this;
/*     */     }
/*     */     
/*     */     public Builder commitComment(@Nullable String aCommitComment) {
/* 417 */       this.commitComment = aCommitComment;
/* 418 */       return this;
/*     */     }
/*     */     
/*     */     public Builder pollingTime(@NotNull Date aPollingTime) {
/* 422 */       this.pollingTime = aPollingTime;
/* 423 */       return this;
/*     */     }
/*     */     
/*     */     public Builder testsPassedCount(int aTestsPassedCount) {
/* 427 */       this.testsPassedCount = aTestsPassedCount;
/* 428 */       return this;
/*     */     }
/*     */     
/*     */     public Builder testsFailedCount(int aTestsFailedCount) {
/* 432 */       this.testsFailedCount = aTestsFailedCount;
/* 433 */       return this;
/*     */     }
/*     */     
/*     */     public Builder relativeBuildDate(@Nullable String aRelativeBuildDate) {
/* 437 */       this.relativeBuildDate = aRelativeBuildDate;
/* 438 */       return this;
/*     */     }
/*     */     
/*     */     public Builder durationDescription(@Nullable String aDurationDescription) {
/* 442 */       this.durationDescription = aDurationDescription;
/* 443 */       return this;
/*     */     }
/*     */     
/*     */     public Builder planState(PlanState aPlanState) {
/* 447 */       this.planState = aPlanState;
/* 448 */       return this;
/*     */     }
/*     */     
/*     */     public BambooBuildInfo build() {
/* 452 */       return new BambooBuildInfo(
/* 453 */           this.planKey, this.planName, this.masterPlanKey, this.serverData, this.pollingTime, this.projectName, this.isEnabled, this.buildNumber, 
/* 454 */           this.buildState, this.planState, this.buildReason, this.startTime, this.testSummary, this.commitComment, this.testsPassedCount, 
/* 455 */           this.testsFailedCount, this.completionTime, this.message, this.exception, this.relativeBuildDate, this.durationDescription, this.commiters);
/*     */     }
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BambooBuildInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */