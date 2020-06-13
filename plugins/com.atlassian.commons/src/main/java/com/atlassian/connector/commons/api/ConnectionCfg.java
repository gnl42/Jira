/*    */ package com.atlassian.connector.commons.api;
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
/*    */ public class ConnectionCfg
/*    */ {
/*    */   private final String url;
/*    */   private final String username;
/*    */   private final String password;
/*    */   private final String id;
/*    */   
/*    */   public ConnectionCfg(String id, String url, String username, String password) {
/* 21 */     this.url = url;
/* 22 */     this.username = username;
/* 23 */     this.password = password;
/* 24 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 28 */     return this.url;
/*    */   }
/*    */   
/*    */   public String getUsername() {
/* 32 */     return this.username;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 36 */     return this.password;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 40 */     return this.id;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 46 */     int result = 1;
/* 47 */     result = 31 * result + ((this.id == null) ? 0 : this.id.hashCode());
/* 48 */     result = 31 * result + ((this.password == null) ? 0 : this.password.hashCode());
/* 49 */     result = 31 * result + ((this.url == null) ? 0 : this.url.hashCode());
/* 50 */     result = 31 * result + ((this.username == null) ? 0 : this.username.hashCode());
/* 51 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 56 */     if (this == obj) {
/* 57 */       return true;
/*    */     }
/* 59 */     if (obj == null) {
/* 60 */       return false;
/*    */     }
/* 62 */     if (getClass() != obj.getClass()) {
/* 63 */       return false;
/*    */     }
/* 65 */     ConnectionCfg other = (ConnectionCfg)obj;
/* 66 */     if (this.id == null) {
/* 67 */       if (other.id != null) {
/* 68 */         return false;
/*    */       }
/* 70 */     } else if (!this.id.equals(other.id)) {
/* 71 */       return false;
/*    */     } 
/* 73 */     if (this.password == null) {
/* 74 */       if (other.password != null) {
/* 75 */         return false;
/*    */       }
/* 77 */     } else if (!this.password.equals(other.password)) {
/* 78 */       return false;
/*    */     } 
/* 80 */     if (this.url == null) {
/* 81 */       if (other.url != null) {
/* 82 */         return false;
/*    */       }
/* 84 */     } else if (!this.url.equals(other.url)) {
/* 85 */       return false;
/*    */     } 
/* 87 */     if (this.username == null) {
/* 88 */       if (other.username != null) {
/* 89 */         return false;
/*    */       }
/* 91 */     } else if (!this.username.equals(other.username)) {
/* 92 */       return false;
/*    */     } 
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\api\ConnectionCfg.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */