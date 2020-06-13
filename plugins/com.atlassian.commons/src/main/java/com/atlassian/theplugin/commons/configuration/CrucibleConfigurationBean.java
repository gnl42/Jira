/*     */ package com.atlassian.theplugin.commons.configuration;
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
/*     */ public class CrucibleConfigurationBean
/*     */ {
/*     */   public static final int MIN_SCHEDULE_TIME_MINUTES = 1;
/*     */   private CrucibleTooltipOption crucibleTooltipOption;
/*     */   private static final int DEFAULT_POLLING_INTERVAL_MIN = 10;
/*  23 */   private int pollTime = 10;
/*     */   private static final int HASHCODE_MAGIC = 31;
/*     */   private static final int DEFAULT_REVIEW_CREATION_TIMEOUT = 5;
/*     */   private static final int MIN_REVIEW_CREATION_TIMEOUT = 1;
/*  27 */   private int reviewCreationTimeout = 5;
/*     */   public static final int DEFAULT_REVIEW_FILE_CACHE_SIZE = 10;
/*     */   public static final int MIN_REVIEW_FILE_CACHE_SIZE = 10;
/*     */   public static final int MAX_REVIEW_FILE_CACHE_SIZE = 128;
/*  31 */   private int reviewFileCacheSize = 10;
/*     */ 
/*     */   
/*     */   public CrucibleConfigurationBean() {}
/*     */   
/*     */   public CrucibleConfigurationBean(CrucibleConfigurationBean cfg) {
/*  37 */     this.crucibleTooltipOption = cfg.getCrucibleTooltipOption();
/*  38 */     this.pollTime = cfg.getPollTime();
/*  39 */     this.reviewCreationTimeout = cfg.getReviewCreationTimeout();
/*  40 */     this.reviewFileCacheSize = cfg.getReviewFileCacheSize();
/*     */   }
/*     */   
/*     */   public int getPollTime() {
/*  44 */     return this.pollTime;
/*     */   }
/*     */   
/*     */   public void setPollTime(int pollTime) {
/*  48 */     this.pollTime = (pollTime > 1) ? pollTime : 1;
/*     */   }
/*     */   
/*     */   public int getReviewCreationTimeout() {
/*  52 */     return this.reviewCreationTimeout;
/*     */   }
/*     */   
/*     */   public void setReviewCreationTimeout(int reviewCreationTimeout) {
/*  56 */     this.reviewCreationTimeout = (reviewCreationTimeout > 1) ? 
/*  57 */       reviewCreationTimeout : 1;
/*     */   }
/*     */   
/*     */   public CrucibleTooltipOption getCrucibleTooltipOption() {
/*  61 */     return this.crucibleTooltipOption;
/*     */   }
/*     */   
/*     */   public void setCrucibleTooltipOption(CrucibleTooltipOption crucibleTooltipOption) {
/*  65 */     this.crucibleTooltipOption = crucibleTooltipOption;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  70 */     if (this == o) {
/*  71 */       return true;
/*     */     }
/*  73 */     if (!(o instanceof CrucibleConfigurationBean)) {
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     CrucibleConfigurationBean that = (CrucibleConfigurationBean)o;
/*     */     
/*  79 */     if (this.pollTime != that.pollTime) {
/*  80 */       return false;
/*     */     }
/*  82 */     if (this.reviewCreationTimeout != that.reviewCreationTimeout) {
/*  83 */       return false;
/*     */     }
/*  85 */     if (this.crucibleTooltipOption != that.crucibleTooltipOption) {
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     if (this.reviewFileCacheSize != that.reviewFileCacheSize) {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  99 */     int result = (this.crucibleTooltipOption != null) ? this.crucibleTooltipOption.hashCode() : 0;
/* 100 */     result = 31 * result + this.pollTime;
/* 101 */     result = 31 * result + this.reviewCreationTimeout;
/* 102 */     result = 31 * result + this.reviewFileCacheSize;
/* 103 */     return result;
/*     */   }
/*     */   
/*     */   public void setReviewFileCacheSize(int cacheSize) {
/* 107 */     this.reviewFileCacheSize = (cacheSize > 10 && cacheSize < 128) ? 
/* 108 */       cacheSize : 10;
/*     */   }
/*     */   
/*     */   public int getReviewFileCacheSize() {
/* 112 */     return this.reviewFileCacheSize;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\configuration\CrucibleConfigurationBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */