/*     */ package com.atlassian.theplugin.commons.bamboo;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class BambooPlan
/*     */   implements Serializable
/*     */ {
/*     */   private final String name;
/*     */   private final String key;
/*     */   private final String materPlanKey;
/*     */   private final boolean favourite;
/*     */   private final boolean enabled;
/*     */   private final String projectName;
/*     */   private final String projectKey;
/*     */   private final Integer averageBuildTime;
/*     */   private final PlanState state;
/*     */   
/*     */   public BambooPlan(String name, String key, String masterPlanKey) {
/*  36 */     this(name, key, masterPlanKey, true);
/*     */   }
/*     */   
/*     */   public BambooPlan(String name, String key, String masterPlanKey, boolean isEnabled) {
/*  40 */     this(name, key, masterPlanKey, isEnabled, false);
/*     */   }
/*     */   
/*     */   public BambooPlan(String name, String key, String masterPlanKey, boolean isEnabled, boolean isFavourite) {
/*  44 */     this(name, key, masterPlanKey, isEnabled, Boolean.valueOf(isFavourite), "", "", null, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BambooPlan(String name, String key, String masterPlanKey, boolean isEnabled, Boolean isFavourite, String projectName, String projectKey, Integer averageBuildTime, boolean inQueue, boolean building) {
/*  50 */     this.name = name;
/*  51 */     this.key = key;
/*  52 */     this.materPlanKey = masterPlanKey;
/*  53 */     this.enabled = isEnabled;
/*  54 */     this.favourite = isFavourite.booleanValue();
/*  55 */     this.projectName = projectName;
/*  56 */     this.projectKey = projectKey;
/*  57 */     this.averageBuildTime = averageBuildTime;
/*     */     
/*  59 */     if (building) {
/*  60 */       this.state = PlanState.BUILDING;
/*  61 */     } else if (inQueue) {
/*  62 */       this.state = PlanState.IN_QUEUE;
/*     */     } else {
/*  64 */       this.state = PlanState.STANDING;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  70 */     return this.name;
/*     */   }
/*     */   
/*     */   public String getKey() {
/*  74 */     return this.key;
/*     */   }
/*     */   
/*     */   public String getMaterPlanKey() {
/*  78 */     return this.materPlanKey;
/*     */   }
/*     */   
/*     */   public boolean isFavourite() {
/*  82 */     return this.favourite;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BambooPlan withFavourite(boolean isFavourite) {
/*  93 */     return new BambooPlan(this.name, this.key, this.materPlanKey, this.enabled, isFavourite);
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/*  97 */     return this.enabled;
/*     */   }
/*     */   
/*     */   public String getProjectName() {
/* 101 */     return this.projectName;
/*     */   }
/*     */   
/*     */   public String getProjectKey() {
/* 105 */     return this.projectKey;
/*     */   }
/*     */   
/*     */   public Integer getAverageBuildTime() {
/* 109 */     return this.averageBuildTime;
/*     */   }
/*     */   
/*     */   public PlanState getState() {
/* 113 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 118 */     if (this == o) {
/* 119 */       return true;
/*     */     }
/* 121 */     if (!(o instanceof BambooPlan)) {
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     BambooPlan that = (BambooPlan)o;
/*     */ 
/*     */     
/* 128 */     if ((this.key != null) ? !this.key.equals(that.key) : (that.key != null)) {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 137 */     return (this.key != null) ? this.key.hashCode() : 0;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BambooPlan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */