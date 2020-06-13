/*    */ package com.atlassian.theplugin.commons.cfg;
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
/*    */ public class ProjectId
/*    */ {
/*    */   private final String internal;
/*    */   
/*    */   public ProjectId(String string) {
/* 23 */     if (string == null) {
/* 24 */       throw new NullPointerException();
/*    */     }
/* 26 */     this.internal = string;
/*    */   }
/*    */   
/*    */   public ProjectId() {
/* 30 */     this.internal = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 35 */     if (this == o) {
/* 36 */       return true;
/*    */     }
/* 38 */     if (!(o instanceof ProjectId)) {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (this.internal == null) {
/* 43 */       return (this == o);
/*    */     }
/*    */     
/* 46 */     ProjectId projectId = (ProjectId)o;
/*    */     
/* 48 */     if (!this.internal.equals(projectId.internal)) {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 57 */     if (this.internal == null) {
/* 58 */       return super.hashCode();
/*    */     }
/* 60 */     return this.internal.hashCode();
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\ProjectId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */