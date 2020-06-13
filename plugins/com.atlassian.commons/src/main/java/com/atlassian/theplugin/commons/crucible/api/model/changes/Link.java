/*    */ package com.atlassian.theplugin.commons.crucible.api.model.changes;
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
/*    */ public final class Link
/*    */ {
/*    */   private final String href;
/*    */   private final String rel;
/*    */   
/*    */   public String getHref() {
/* 21 */     return this.href;
/*    */   }
/*    */   
/*    */   public Link(String rel, String href) {
/* 25 */     this.rel = rel;
/* 26 */     this.href = href;
/*    */   }
/*    */   
/*    */   public String getRel() {
/* 30 */     return this.rel;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\changes\Link.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */