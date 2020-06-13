/*    */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Comment;
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*    */ 
/*    */ public abstract class AbstractUpdatedCommentNotification extends AbstractCommentNotification {
/*    */   private final boolean wasDraft;
/*    */   
/*    */   public AbstractUpdatedCommentNotification(Review review, Comment comment, boolean wasDraft) {
/* 10 */     super(review, comment);
/* 11 */     this.wasDraft = wasDraft;
/*    */   }
/*    */   
/*    */   public boolean wasDraft() {
/* 15 */     return this.wasDraft;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\AbstractUpdatedCommentNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */