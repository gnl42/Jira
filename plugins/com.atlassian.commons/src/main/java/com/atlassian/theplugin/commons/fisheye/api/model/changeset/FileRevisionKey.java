/*    */ package com.atlassian.theplugin.commons.fisheye.api.model.changeset;
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
/*    */ public final class FileRevisionKey
/*    */ {
/*    */   private final String rev;
/*    */   private final String path;
/*    */   
/*    */   public FileRevisionKey(String rev, String path) {
/* 20 */     this.rev = rev;
/* 21 */     this.path = path;
/*    */   }
/*    */   
/*    */   public String getRev() {
/* 25 */     return this.rev;
/*    */   }
/*    */   public String getPath() {
/* 28 */     return this.path;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\fisheye\api\model\changeset\FileRevisionKey.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */