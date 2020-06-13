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
/*    */ public class NewReviewItemNotification
/*    */   extends AbstractReviewNotification
/*    */ {
/*    */   public NewReviewItemNotification(Review review) {
/* 24 */     super(review);
/*    */   }
/*    */ 
/*    */   
/*    */   public CrucibleNotificationType getType() {
/* 29 */     return CrucibleNotificationType.NEW_REVIEW_ITEM;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPresentationMessage() {
/* 34 */     return "New review item added";
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\NewReviewItemNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */