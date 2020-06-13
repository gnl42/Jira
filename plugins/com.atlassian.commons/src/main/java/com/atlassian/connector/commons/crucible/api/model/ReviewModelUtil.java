/*    */ package com.atlassian.connector.commons.crucible.api.model;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Comment;
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.VersionedComment;
/*    */ import org.jetbrains.annotations.Nullable;
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
/*    */ 
/*    */ 
/*    */ public final class ReviewModelUtil
/*    */ {
/*    */   @Nullable
/*    */   public static VersionedComment getParentVersionedComment(Comment comment) {
/* 28 */     while (comment != null && !(comment instanceof VersionedComment)) {
/* 29 */       comment = comment.getParentComment();
/*    */     }
/* 31 */     return (VersionedComment)comment;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\crucible\api\model\ReviewModelUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */