/*    */ package com.atlassian.theplugin.commons.crucible.api.model.changes;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*    */ import java.util.Collection;
/*    */ import java.util.Date;
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
/*    */ public final class Change
/*    */ {
/*    */   private final String author;
/*    */   private final Date date;
/*    */   private final String csid;
/*    */   private final String comment;
/*    */   private final Link link;
/*    */   private final List<Revision> revisions;
/*    */   
/*    */   public String getAuthor() {
/* 29 */     return this.author;
/*    */   }
/*    */   
/*    */   public Date getDate() {
/* 33 */     return this.date;
/*    */   }
/*    */   public String getCsid() {
/* 36 */     return this.csid;
/*    */   }
/*    */   public String getComment() {
/* 39 */     return this.comment;
/*    */   }
/*    */   public Link getLink() {
/* 42 */     return this.link;
/*    */   }
/*    */   public List<Revision> getRevisions() {
/* 45 */     return this.revisions;
/*    */   }
/*    */   
/*    */   public Change(String author, Date date, String csid, Link link, String comment, Collection<Revision> revisions) {
/* 49 */     this.author = author;
/* 50 */     this.date = date;
/* 51 */     this.csid = csid;
/* 52 */     this.link = link;
/* 53 */     this.comment = comment;
/* 54 */     if (revisions == null) {
/* 55 */       this.revisions = MiscUtil.buildArrayList();
/*    */     } else {
/* 57 */       this.revisions = MiscUtil.buildArrayList(revisions);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\changes\Change.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */