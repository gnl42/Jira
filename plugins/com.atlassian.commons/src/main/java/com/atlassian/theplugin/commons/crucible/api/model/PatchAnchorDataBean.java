/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PatchAnchorDataBean
/*    */   implements PatchAnchorData
/*    */ {
/*    */   private String path;
/*    */   private String stripCount;
/*    */   private String repositoryName;
/*    */   
/*    */   public PatchAnchorDataBean(String repoName, String path, String stripCount) {
/* 13 */     this.repositoryName = repoName;
/* 14 */     this.path = path;
/* 15 */     this.stripCount = stripCount;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPath() {
/* 20 */     return this.path;
/*    */   }
/*    */   
/*    */   public void setPath(String path) {
/* 24 */     this.path = path;
/*    */   }
/*    */   
/*    */   public String getStripCount() {
/* 28 */     return this.stripCount;
/*    */   }
/*    */   
/*    */   public void setStripCount(String stripCount) {
/* 32 */     this.stripCount = stripCount;
/*    */   }
/*    */   
/*    */   public String getRepositoryName() {
/* 36 */     return this.repositoryName;
/*    */   }
/*    */   
/*    */   public void setRepositoryName(String repositoryName) {
/* 40 */     this.repositoryName = repositoryName;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\PatchAnchorDataBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */