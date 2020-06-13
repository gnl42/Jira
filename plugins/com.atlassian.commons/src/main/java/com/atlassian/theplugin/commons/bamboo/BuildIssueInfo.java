/*    */ package com.atlassian.theplugin.commons.bamboo;
/*    */ 
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BuildIssueInfo
/*    */   implements BuildIssue
/*    */ {
/*    */   private final String issueKey;
/*    */   private final String issueUrl;
/*    */   
/*    */   public BuildIssueInfo(@NotNull String issueKey, @NotNull String issueUrl) {
/* 16 */     this.issueKey = issueKey;
/* 17 */     this.issueUrl = issueUrl;
/*    */   }
/*    */   
/*    */   public String getIssueKey() {
/* 21 */     return this.issueKey;
/*    */   }
/*    */   
/*    */   public String getIssueUrl() {
/* 25 */     return this.issueUrl;
/*    */   }
/*    */   
/*    */   public String getServerUrl() {
/* 29 */     int keyPos = this.issueUrl.indexOf("/browse/" + this.issueKey);
/* 30 */     if (keyPos == -1) {
/* 31 */       return null;
/*    */     }
/* 33 */     return this.issueUrl.substring(0, keyPos);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BuildIssueInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */