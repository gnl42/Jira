/*    */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Comment;
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*    */ 
/*    */ public class UpdatedCommentNotification extends AbstractUpdatedCommentNotification {
/*    */   public UpdatedCommentNotification(Review review, Comment comment, boolean wasDraft) {
/*  8 */     super(review, comment, wasDraft);
/*    */   }
/*    */ 
/*    */   
/*    */   public CrucibleNotificationType getType() {
/* 13 */     return CrucibleNotificationType.UPDATED_COMMENT;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPresentationMessage() {
/* 18 */     return "Comment updated by " + getComment().getAuthor().getDisplayName();
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\UpdatedCommentNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */