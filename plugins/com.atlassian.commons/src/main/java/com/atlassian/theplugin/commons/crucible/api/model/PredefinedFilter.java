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
/*    */ public enum PredefinedFilter
/*    */   implements CrucibleFilter
/*    */ {
/* 20 */   ToReview("toReview", "To Review", true),
/* 21 */   RequireMyApproval("requireMyApproval", "Require My Approval", true),
/* 22 */   ToSummarize("toSummarize", "To Summarize", true),
/* 23 */   OutForReview("outForReview", "Out For Review", true),
/* 24 */   Drafts("drafts", "Drafts", true),
/* 25 */   Open("open", "Open", true),
/* 26 */   Closed("closed", "Closed", true),
/* 27 */   Abandoned("trash", "Abandoned", true),
/* 28 */   OpenInIde("nonexistingurl", "Open in IDE", false);
/*    */   
/*    */   private String filterUrl;
/*    */   
/*    */   private String filterName;
/*    */   
/*    */   private boolean remote;
/*    */ 
/*    */   
/*    */   PredefinedFilter(String filterUrl, String filterName, boolean remote) {
/* 38 */     this.filterUrl = filterUrl;
/* 39 */     this.filterName = filterName;
/* 40 */     this.remote = remote;
/*    */   }
/*    */   
/*    */   public String getFilterUrl() {
/* 44 */     return this.filterUrl;
/*    */   }
/*    */   
/*    */   public String getFilterName() {
/* 48 */     return this.filterName;
/*    */   }
/*    */   
/*    */   public boolean isRemote() {
/* 52 */     return this.remote;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\PredefinedFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */