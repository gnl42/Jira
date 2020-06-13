/*    */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.PermId;
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
/*    */ public abstract class AbstractReviewNotification
/*    */   implements CrucibleNotification
/*    */ {
/*    */   protected Review review;
/*    */   
/*    */   public AbstractReviewNotification(Review review) {
/* 27 */     this.review = review;
/*    */   }
/*    */   
/*    */   public abstract CrucibleNotificationType getType();
/*    */   
/*    */   public PermId getId() {
/* 33 */     return this.review.getPermId();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String getItemUrl() {
/* 38 */     String baseUrl = this.review.getServerUrl();
/* 39 */     while (baseUrl.length() > 0 && baseUrl.charAt(baseUrl.length() - 1) == '/')
/*    */     {
/* 41 */       baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
/*    */     }
/* 43 */     return String.valueOf(baseUrl) + "/cru/" + this.review.getPermId().getId();
/*    */   }
/*    */   
/*    */   public abstract String getPresentationMessage();
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\AbstractReviewNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */