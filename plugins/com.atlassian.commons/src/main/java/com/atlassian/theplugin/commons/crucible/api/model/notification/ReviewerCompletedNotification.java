/*    */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Reviewer;
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
/*    */ public class ReviewerCompletedNotification
/*    */   extends AbstractReviewNotification
/*    */ {
/*    */   private final Reviewer reviewer;
/*    */   
/*    */   public ReviewerCompletedNotification(Review review, Reviewer reviewer) {
/* 26 */     super(review);
/* 27 */     this.reviewer = reviewer;
/*    */   }
/*    */ 
/*    */   
/*    */   public CrucibleNotificationType getType() {
/* 32 */     return CrucibleNotificationType.REVIEWER_COMPLETED;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPresentationMessage() {
/* 37 */     return "Reviewer " + this.reviewer.getDisplayName() + " " + (this.reviewer.isCompleted() ? "completed" : " uncompleted") + 
/* 38 */       " review";
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\ReviewerCompletedNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */