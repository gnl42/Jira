/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public class PermId
/*    */   implements Serializable
/*    */ {
/*    */   private final String id;
/*    */   
/*    */   public PermId(String id) {
/* 30 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 34 */     return this.id;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 39 */     return this.id;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 44 */     if (this == o) {
/* 45 */       return true;
/*    */     }
/* 47 */     if (o == null || getClass() != o.getClass()) {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     PermId that = (PermId)o;
/*    */     
/* 53 */     if ((this.id != null) ? !this.id.equals(that.id) : (that.id != null)) {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 62 */     return (this.id != null) ? this.id.hashCode() : 0;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\PermId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */