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
/*    */ public enum BuildStatus
/*    */ {
/* 20 */   SUCCESS(
/*    */ 
/*    */     
/* 23 */     "Succeeded"),
/* 24 */   FAILURE(
/*    */ 
/*    */     
/* 27 */     "Failed"),
/* 28 */   UNKNOWN(
/*    */ 
/*    */     
/* 31 */     "Unknown");
/*    */   
/*    */   private String name;
/*    */   
/*    */   BuildStatus(String name) {
/* 36 */     this.name = name;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 41 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 45 */     return this.name;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BuildStatus.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */