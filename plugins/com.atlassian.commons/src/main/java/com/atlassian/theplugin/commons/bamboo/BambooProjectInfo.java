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
/*    */ 
/*    */ 
/*    */ public class BambooProjectInfo
/*    */   implements BambooProject
/*    */ {
/*    */   private final String name;
/*    */   private final String key;
/*    */   
/*    */   public BambooProjectInfo(String name, String key) {
/* 27 */     this.name = name;
/* 28 */     this.key = key;
/*    */   }
/*    */   
/*    */   public String getProjectName() {
/* 32 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getProjectKey() {
/* 36 */     return this.key;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BambooProjectInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */