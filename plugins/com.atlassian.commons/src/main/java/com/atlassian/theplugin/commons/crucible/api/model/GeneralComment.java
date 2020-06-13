/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
/*    */ 
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
/*    */ public class GeneralComment
/*    */   extends Comment
/*    */ {
/*    */   private static final int HASH_INT = 31;
/*    */   
/*    */   public GeneralComment(Review review, @Nullable Comment parentComment) {
/* 26 */     super(review, parentComment);
/*    */   }
/*    */   
/*    */   public GeneralComment(Comment bean) {
/* 30 */     super(bean);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Comment createReplyBean(Comment reply) {
/* 35 */     return new GeneralComment(reply);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 40 */     if (this == o) {
/* 41 */       return true;
/*    */     }
/* 43 */     if (o == null || getClass() != o.getClass()) {
/* 44 */       return false;
/*    */     }
/* 46 */     if (!super.equals(o)) {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 55 */     int result = super.hashCode();
/* 56 */     result = 31 * result + ((getReplies() != null) ? getReplies().hashCode() : 0);
/* 57 */     return result;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\GeneralComment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */