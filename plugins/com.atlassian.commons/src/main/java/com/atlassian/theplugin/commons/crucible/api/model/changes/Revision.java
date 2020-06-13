/*    */ package com.atlassian.theplugin.commons.crucible.api.model.changes;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
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
/*    */ public final class Revision
/*    */ {
/*    */   private final List<Link> links;
/*    */   private final String revision;
/*    */   private final String path;
/*    */   
/*    */   public List<Link> getLink() {
/* 27 */     return this.links;
/*    */   }
/*    */   
/*    */   public String getRevision() {
/* 31 */     return this.revision;
/*    */   }
/*    */   
/*    */   public String getPath() {
/* 35 */     return this.path;
/*    */   }
/*    */   
/*    */   public Revision(String revision, String path, Collection<Link> links) {
/* 39 */     this.revision = revision;
/* 40 */     this.path = path;
/* 41 */     if (links == null) {
/* 42 */       this.links = MiscUtil.buildArrayList();
/*    */     } else {
/* 44 */       this.links = MiscUtil.buildArrayList(links);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\changes\Revision.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */