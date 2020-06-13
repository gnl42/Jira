/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
/*    */ 
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
/*    */ public class Reviewer
/*    */   extends User
/*    */ {
/*    */   private final boolean completed;
/*    */   
/*    */   public Reviewer(@NotNull String userName, boolean completed) {
/* 26 */     super(userName);
/* 27 */     this.completed = completed;
/*    */   }
/*    */   
/*    */   public Reviewer(@NotNull String userName, String displayName, boolean completed) {
/* 31 */     this(userName, displayName, completed, (String)null);
/*    */   }
/*    */   
/*    */   public Reviewer(@NotNull String userName, String displayName, boolean completed, String avatarUrl) {
/* 35 */     super(userName, displayName, avatarUrl);
/* 36 */     this.completed = completed;
/*    */   }
/*    */   
/*    */   public Reviewer(@NotNull String userName, String displayName) {
/* 40 */     this(userName, displayName, false);
/*    */   }
/*    */   
/*    */   public boolean isCompleted() {
/* 44 */     return this.completed;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 50 */     int result = super.hashCode();
/* 51 */     result = 31 * result + (this.completed ? 1231 : 1237);
/* 52 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 57 */     if (this == obj) {
/* 58 */       return true;
/*    */     }
/* 60 */     if (!super.equals(obj)) {
/* 61 */       return false;
/*    */     }
/* 63 */     if (getClass() != obj.getClass()) {
/* 64 */       return false;
/*    */     }
/* 66 */     Reviewer other = (Reviewer)obj;
/* 67 */     if (this.completed != other.completed) {
/* 68 */       return false;
/*    */     }
/* 70 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 75 */     return "Reviewer [[" + this.userName + "], [" + this.displayName + "], " + this.completed + "]";
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\Reviewer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */