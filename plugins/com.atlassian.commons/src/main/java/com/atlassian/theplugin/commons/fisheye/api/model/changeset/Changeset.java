/*    */ package com.atlassian.theplugin.commons.fisheye.api.model.changeset;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*    */ import java.util.ArrayList;
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
/*    */ public final class Changeset
/*    */ {
/*    */   private final String csid;
/*    */   private final String branch;
/*    */   private final String author;
/*    */   private final Date date;
/*    */   private final String comment;
/*    */   private final ArrayList<FileRevisionKey> revisionKeys;
/*    */   
/*    */   public Changeset(Date date, String csid, String branch, String author, String comment, List<FileRevisionKey> keys) {
/* 29 */     this.date = date;
/* 30 */     this.csid = csid;
/* 31 */     this.branch = branch;
/* 32 */     this.author = author;
/* 33 */     this.comment = comment;
/* 34 */     if (keys == null) {
/* 35 */       this.revisionKeys = MiscUtil.buildArrayList();
/*    */     } else {
/* 37 */       this.revisionKeys = MiscUtil.buildArrayList(keys);
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getCsid() {
/* 42 */     return this.csid;
/*    */   }
/*    */   public String getBranch() {
/* 45 */     return this.branch;
/*    */   }
/*    */   public String getAuthor() {
/* 48 */     return this.author;
/*    */   }
/*    */   public Date getDate() {
/* 51 */     return this.date;
/*    */   }
/*    */   
/*    */   public String getComment() {
/* 55 */     return this.comment;
/*    */   }
/*    */   
/*    */   public List<FileRevisionKey> getRevisionKeys() {
/* 59 */     return this.revisionKeys;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\fisheye\api\model\changeset\Changeset.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */