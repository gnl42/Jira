/*    */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
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
/*    */ public class NewReviewNotification
/*    */   extends AbstractReviewNotification
/*    */ {
/*    */   public NewReviewNotification(Review review) {
/* 24 */     super(review);
/*    */   }
/*    */ 
/*    */   
/*    */   public CrucibleNotificationType getType() {
/* 29 */     return CrucibleNotificationType.NEW_REVIEW;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPresentationMessage() {
/* 34 */     return this.review.getName();
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\NewReviewNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */