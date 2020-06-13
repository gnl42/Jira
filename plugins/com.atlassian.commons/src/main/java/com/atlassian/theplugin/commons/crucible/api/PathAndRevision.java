/*    */ package com.atlassian.theplugin.commons.crucible.api;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PathAndRevision
/*    */ {
/*    */   private String path;
/*    */   private List<String> revisions;
/*    */   
/*    */   public PathAndRevision() {
/* 16 */     this.revisions = new ArrayList<String>();
/*    */   }
/*    */   
/*    */   public PathAndRevision(String path, List<String> revisions) {
/* 20 */     this.path = path;
/* 21 */     this.revisions = revisions;
/*    */   }
/*    */   
/*    */   public String getPath() {
/* 25 */     return this.path;
/*    */   }
/*    */   
/*    */   public void setPath(String path) {
/* 29 */     this.path = path;
/*    */   }
/*    */   
/*    */   public List<String> getRevisions() {
/* 33 */     return this.revisions;
/*    */   }
/*    */   
/*    */   public void setRevisions(List<String> revisions) {
/* 37 */     this.revisions = revisions;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\PathAndRevision.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */