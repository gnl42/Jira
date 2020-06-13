/*    */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Comment;
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*    */ 
/*    */ public abstract class AbstractCommentNotification extends AbstractReviewNotification {
/*    */   private final Comment comment;
/*    */   
/*    */   public AbstractCommentNotification(Review review, Comment comment) {
/* 10 */     super(review);
/*    */     
/* 12 */     this.comment = comment;
/*    */   }
/*    */   
/*    */   public Comment getComment() {
/* 16 */     return this.comment;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\AbstractCommentNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */