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
/*    */ public class JIRACommentBean
/*    */   implements JIRAComment
/*    */ {
/*    */   private String id;
/*    */   private String author;
/*    */   private String authorFullName;
/*    */   private String body;
/*    */   private Calendar created;
/*    */   
/*    */   public JIRACommentBean(String id, String author, String body, Calendar created) {
/* 29 */     this.id = id;
/* 30 */     this.author = author;
/* 31 */     this.authorFullName = author;
/* 32 */     this.body = body;
/* 33 */     this.created = created;
/*    */   }
/*    */   public String getId() {
/* 36 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getAuthor() {
/* 40 */     return this.author;
/*    */   }
/*    */   
/*    */   public void setAuthorFullName(String authorFullName) {
/* 44 */     this.authorFullName = authorFullName;
/*    */   }
/*    */   
/*    */   public String getAuthorFullName() {
/* 48 */     return this.authorFullName;
/*    */   }
/*    */   
/*    */   public String getBody() {
/* 52 */     return this.body;
/*    */   }
/*    */   
/*    */   public Calendar getCreationDate() {
/* 56 */     return this.created;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRACommentBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */