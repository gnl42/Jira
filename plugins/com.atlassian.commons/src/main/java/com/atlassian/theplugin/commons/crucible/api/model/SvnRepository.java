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
/*    */ public class SvnRepository
/*    */   extends Repository
/*    */ {
/*    */   private final String url;
/*    */   private final String path;
/*    */   
/*    */   public SvnRepository(String name, String type, boolean enabled, String url, String path) {
/* 25 */     super(name, type, enabled);
/* 26 */     this.url = url;
/* 27 */     this.path = path;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 31 */     return this.url;
/*    */   }
/*    */   
/*    */   public String getPath() {
/* 35 */     return this.path;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\SvnRepository.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */