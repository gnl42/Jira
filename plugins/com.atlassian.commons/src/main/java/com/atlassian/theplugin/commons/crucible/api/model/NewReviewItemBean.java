/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
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
/*    */ public class NewReviewItemBean
/*    */   implements NewReviewItem
/*    */ {
/*    */   private String repositoryName;
/*    */   private String fromPath;
/*    */   private String fromRevision;
/*    */   private String toPath;
/*    */   private String toRevision;
/*    */   
/*    */   public String getRepositoryName() {
/* 30 */     return this.repositoryName;
/*    */   }
/*    */   
/*    */   public void setRepositoryName(String repositoryName) {
/* 34 */     this.repositoryName = repositoryName;
/*    */   }
/*    */   
/*    */   public String getFromPath() {
/* 38 */     return this.fromPath;
/*    */   }
/*    */   
/*    */   public void setFromPath(String fromPath) {
/* 42 */     this.fromPath = fromPath;
/*    */   }
/*    */   
/*    */   public String getFromRevision() {
/* 46 */     return this.fromRevision;
/*    */   }
/*    */   
/*    */   public void setFromRevision(String fromRevision) {
/* 50 */     this.fromRevision = fromRevision;
/*    */   }
/*    */   
/*    */   public String getToPath() {
/* 54 */     return this.toPath;
/*    */   }
/*    */   
/*    */   public void setToPath(String toPath) {
/* 58 */     this.toPath = toPath;
/*    */   }
/*    */   
/*    */   public String getToRevision() {
/* 62 */     return this.toRevision;
/*    */   }
/*    */   
/*    */   public void setToRevision(String toRevision) {
/* 66 */     this.toRevision = toRevision;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\NewReviewItemBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */