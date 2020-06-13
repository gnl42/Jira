/*    */ package com.atlassian.theplugin.commons.configuration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BambooConfigurationBean
/*    */ {
/*    */   private BambooTooltipOption bambooTooltipOption;
/*    */   private static final int DEFAULT_POLLING_INTERVAL_MIN = 10;
/* 27 */   private int pollTime = 10;
/*    */   
/*    */   private static final int HASHCODE_MAGIC = 31;
/*    */   private boolean onlyMyBuilds = false;
/*    */   
/*    */   public BambooConfigurationBean() {}
/*    */   
/*    */   public BambooConfigurationBean(BambooConfigurationBean cfg) {
/* 35 */     this.bambooTooltipOption = cfg.getBambooTooltipOption();
/* 36 */     this.pollTime = cfg.getPollTime();
/* 37 */     this.onlyMyBuilds = cfg.isOnlyMyBuilds();
/*    */   }
/*    */   
/*    */   public boolean isOnlyMyBuilds() {
/* 41 */     return this.onlyMyBuilds;
/*    */   }
/*    */   
/*    */   public void setOnlyMyBuilds(boolean onlyMyBuilds) {
/* 45 */     this.onlyMyBuilds = onlyMyBuilds;
/*    */   }
/*    */   
/*    */   public int getPollTime() {
/* 49 */     return this.pollTime;
/*    */   }
/*    */   
/*    */   public void setPollTime(int pollTime) {
/* 53 */     this.pollTime = pollTime;
/*    */   }
/*    */   
/*    */   public BambooTooltipOption getBambooTooltipOption() {
/* 57 */     return this.bambooTooltipOption;
/*    */   }
/*    */   
/*    */   public void setBambooTooltipOption(BambooTooltipOption bambooTooltipOption) {
/* 61 */     this.bambooTooltipOption = bambooTooltipOption;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 66 */     if (this == o) {
/* 67 */       return true;
/*    */     }
/* 69 */     if (!(o instanceof BambooConfigurationBean)) {
/* 70 */       return false;
/*    */     }
/*    */     
/* 73 */     BambooConfigurationBean that = (BambooConfigurationBean)o;
/*    */     
/* 75 */     if (this.pollTime != that.pollTime) {
/* 76 */       return false;
/*    */     }
/*    */     
/* 79 */     if (this.bambooTooltipOption != that.bambooTooltipOption) {
/* 80 */       return false;
/*    */     }
/*    */     
/* 83 */     if (this.onlyMyBuilds != that.onlyMyBuilds) {
/* 84 */       return false;
/*    */     }
/*    */     
/* 87 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 93 */     int result = (this.bambooTooltipOption != null) ? this.bambooTooltipOption.hashCode() : 0;
/* 94 */     result = 31 * result + this.pollTime;
/* 95 */     result = 31 * result + (this.onlyMyBuilds ? 1 : 0);
/*    */     
/* 97 */     return result;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\configuration\BambooConfigurationBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */