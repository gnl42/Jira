/*    */ package com.atlassian.theplugin.commons;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VirtualFileSystem
/*    */ {
/*    */   private static final int HASH_INT = 31;
/*    */   
/*    */   public boolean equals(Object o) {
/* 30 */     if (this == o) {
/* 31 */       return true;
/*    */     }
/*    */     
/* 34 */     if (o == null || getClass() != o.getClass()) {
/* 35 */       return false;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 45 */     int result = super.hashCode();
/* 46 */     result *= 31;
/* 47 */     return result;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\VirtualFileSystem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */