/*    */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Comment;
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommentReadUnreadStateChangedNotification
/*    */   extends AbstractCommentNotification
/*    */ {
/*    */   public CommentReadUnreadStateChangedNotification(Review review, Comment comment) {
/* 14 */     super(review, comment);
/*    */   }
/*    */ 
/*    */   
/*    */   public CrucibleNotificationType getType() {
/* 19 */     return CrucibleNotificationType.COMMENT_READ_UNREAD_STATE_CHANGED;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPresentationMessage() {
/* 24 */     return "Comment state changed to " + getComment().getReadState();
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\CommentReadUnreadStateChangedNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */