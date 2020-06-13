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
/*    */ public class ReviewDataChangedNotification
/*    */   extends AbstractReviewNotification
/*    */ {
/*    */   public ReviewDataChangedNotification(Review review) {
/* 23 */     super(review);
/*    */   }
/*    */ 
/*    */   
/*    */   public CrucibleNotificationType getType() {
/* 28 */     return CrucibleNotificationType.REVIEW_DATA_CHANGED;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPresentationMessage() {
/* 33 */     return "Review data changed";
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\ReviewDataChangedNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */