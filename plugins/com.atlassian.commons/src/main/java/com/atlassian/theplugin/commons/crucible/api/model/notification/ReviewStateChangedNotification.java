/*    */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.State;
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
/*    */ public class ReviewStateChangedNotification
/*    */   extends AbstractReviewNotification
/*    */ {
/*    */   public ReviewStateChangedNotification(Review review, State oldState) {
/* 24 */     super(review);
/*    */   }
/*    */ 
/*    */   
/*    */   public CrucibleNotificationType getType() {
/* 29 */     return CrucibleNotificationType.REVIEW_STATE_CHANGED;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPresentationMessage() {
/* 34 */     return "Review changed state to " + this.review.getState().getDisplayName();
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\ReviewStateChangedNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */