/*    */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Comment;
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
/*    */ 
/*    */ public class NewCommentNotification
/*    */   extends AbstractCommentNotification
/*    */ {
/*    */   public NewCommentNotification(@NotNull Review review, @NotNull Comment comment) {
/* 26 */     super(review, comment);
/*    */   }
/*    */ 
/*    */   
/*    */   public CrucibleNotificationType getType() {
/* 31 */     return CrucibleNotificationType.NEW_COMMENT;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPresentationMessage() {
/* 36 */     return "New comment added by " + getComment().getAuthor().getDisplayName();
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\NewCommentNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */