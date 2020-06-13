/*    */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*    */ import org.jetbrains.annotations.NotNull;
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
/*    */ public class BasisReviewDetailsChangedNotification
/*    */   extends AbstractReviewNotification
/*    */ {
/*    */   private final CrucibleNotificationType notificationType;
/*    */   private final String message;
/*    */   
/*    */   public BasisReviewDetailsChangedNotification(@NotNull Review review, @NotNull CrucibleNotificationType notificationType, @NotNull String message) {
/* 27 */     super(review);
/* 28 */     this.notificationType = notificationType;
/* 29 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public CrucibleNotificationType getType() {
/* 34 */     return this.notificationType;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPresentationMessage() {
/* 39 */     return this.message;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\BasisReviewDetailsChangedNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */