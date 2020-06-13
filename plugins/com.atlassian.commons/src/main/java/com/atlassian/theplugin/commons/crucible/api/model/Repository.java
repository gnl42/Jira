/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.jetbrains.annotations.NotNull;
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
/*    */ public class Repository
/*    */   implements Serializable
/*    */ {
/*    */   public static final String PLUGIN_TYPE = "plugin";
/*    */   private final String name;
/*    */   private final String type;
/*    */   private final boolean enabled;
/*    */   
/*    */   public Repository(String name, String type, boolean enabled) {
/* 32 */     this.name = name;
/* 33 */     this.type = type;
/* 34 */     this.enabled = enabled;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String getName() {
/* 39 */     return this.name;
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public String getType() {
/* 44 */     return this.type;
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 48 */     return this.enabled;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 54 */     int result = 1;
/* 55 */     result = 31 * result + (this.enabled ? 1231 : 1237);
/* 56 */     result = 31 * result + ((this.name == null) ? 0 : this.name.hashCode());
/* 57 */     result = 31 * result + ((this.type == null) ? 0 : this.type.hashCode());
/* 58 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 63 */     if (this == obj) {
/* 64 */       return true;
/*    */     }
/* 66 */     if (obj == null) {
/* 67 */       return false;
/*    */     }
/* 69 */     if (getClass() != obj.getClass()) {
/* 70 */       return false;
/*    */     }
/* 72 */     Repository other = (Repository)obj;
/* 73 */     if (this.enabled != other.enabled) {
/* 74 */       return false;
/*    */     }
/* 76 */     if (this.name == null) {
/* 77 */       if (other.name != null) {
/* 78 */         return false;
/*    */       }
/* 80 */     } else if (!this.name.equals(other.name)) {
/* 81 */       return false;
/*    */     } 
/* 83 */     if (this.type == null) {
/* 84 */       if (other.type != null) {
/* 85 */         return false;
/*    */       }
/* 87 */     } else if (!this.type.equals(other.type)) {
/* 88 */       return false;
/*    */     } 
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\Repository.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */