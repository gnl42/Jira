/*    */ package com.atlassian.theplugin.commons.cfg;
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
/*    */ public final class SubscribedPlan
/*    */ {
/*    */   private final String key;
/*    */   private boolean grouped;
/*    */   
/*    */   public SubscribedPlan(SubscribedPlan cfg) {
/* 28 */     this.key = cfg.getKey();
/* 29 */     this.grouped = cfg.isGrouped();
/*    */   }
/*    */   
/*    */   public SubscribedPlan(String key, boolean grouped) {
/* 33 */     this.key = key;
/* 34 */     this.grouped = grouped;
/*    */   }
/*    */   
/*    */   public SubscribedPlan(String key) {
/* 38 */     this(key, false);
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 42 */     return this.key;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 47 */     if (this == o) {
/* 48 */       return true;
/*    */     }
/* 50 */     if (o == null || getClass() != o.getClass()) {
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     SubscribedPlan that = (SubscribedPlan)o;
/*    */     
/* 56 */     if (this.grouped != that.grouped) {
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     if (!this.key.equals(that.key)) {
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 69 */     int result = this.key.hashCode();
/* 70 */     result = 31 * result + (this.grouped ? 1 : 0);
/* 71 */     return result;
/*    */   }
/*    */   
/*    */   public boolean isGrouped() {
/* 75 */     return this.grouped;
/*    */   }
/*    */   
/*    */   public void setGrouped(boolean grouped) {
/* 79 */     this.grouped = grouped;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\SubscribedPlan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */