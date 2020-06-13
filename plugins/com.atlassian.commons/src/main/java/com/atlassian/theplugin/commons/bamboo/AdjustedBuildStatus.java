/*    */ package com.atlassian.theplugin.commons.bamboo;
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
/*    */ public enum AdjustedBuildStatus
/*    */ {
/* 20 */   SUCCESS(
/* 21 */     "Succeeded"),
/* 22 */   FAILURE(
/* 23 */     "Failed"),
/* 24 */   DISABLED("Disabled"),
/* 25 */   UNKNOWN(
/* 26 */     "Unknown");
/*    */   
/*    */   private String name;
/*    */   
/*    */   AdjustedBuildStatus(String name) {
/* 31 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 35 */     return this.name;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\AdjustedBuildStatus.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */