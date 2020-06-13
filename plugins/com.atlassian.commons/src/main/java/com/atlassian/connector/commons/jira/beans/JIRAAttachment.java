/*    */ package com.atlassian.connector.commons.jira.beans;
/*    */ 
/*    */ import java.util.Calendar;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JIRAAttachment
/*    */ {
/*    */   private final String id;
/*    */   private final String author;
/*    */   private final String filename;
/*    */   private final Long filesize;
/*    */   private final String mimetype;
/*    */   private final Calendar created;
/*    */   
/*    */   public JIRAAttachment(String id, String author, String filename, long filesize, String mimetype, Calendar created) {
/* 35 */     this.id = id;
/* 36 */     this.author = author;
/* 37 */     this.filename = filename;
/* 38 */     this.filesize = Long.valueOf(filesize);
/* 39 */     this.mimetype = mimetype;
/* 40 */     this.created = created;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 44 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getAuthor() {
/* 48 */     return this.author;
/*    */   }
/*    */   
/*    */   public String getFilename() {
/* 52 */     return this.filename;
/*    */   }
/*    */   
/*    */   public Long getFilesize() {
/* 56 */     return this.filesize;
/*    */   }
/*    */   
/*    */   public String getMimetype() {
/* 60 */     return this.mimetype;
/*    */   }
/*    */   
/*    */   public Calendar getCreated() {
/* 64 */     return this.created;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAAttachment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */