/*    */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Comment;
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*    */ 
/*    */ public class RemovedCommentNotification
/*    */   extends AbstractCommentNotification {
/*    */   public RemovedCommentNotification(Review review, Comment comment) {
/*  9 */     super(review, comment);
/*    */   }
/*    */ 
/*    */   
/*    */   public CrucibleNotificationType getType() {
/* 14 */     return CrucibleNotificationType.REMOVED_COMMENT;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPresentationMessage() {
/* 19 */     return "Comment removed by " + getComment().getAuthor().getDisplayName();
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\RemovedCommentNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */