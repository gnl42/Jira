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
/*    */ 
/*    */ public class UserCfg
/*    */   implements User
/*    */ {
/* 22 */   private String username = "";
/* 23 */   private String password = "";
/*    */   private boolean passwordStored;
/*    */   
/*    */   public UserCfg(String username, String password, boolean passwordStored) {
/* 27 */     this.username = username;
/* 28 */     this.password = password;
/* 29 */     this.passwordStored = passwordStored;
/*    */   }
/*    */   
/*    */   public UserCfg(String username, String password) {
/* 33 */     this(username, password, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public UserCfg() {}
/*    */   
/*    */   public UserCfg getClone() {
/* 40 */     return new UserCfg(this.username, this.password, this.passwordStored);
/*    */   }
/*    */   
/*    */   public String getUsername() {
/* 44 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String userName) {
/* 48 */     this.username = userName;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 52 */     this.password = password;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 56 */     return this.password;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setPasswordStored(boolean passwordStored) {
/* 61 */     this.passwordStored = passwordStored;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isPasswordStored() {
/* 66 */     return this.passwordStored;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 71 */     if (this == o) {
/* 72 */       return true;
/*    */     }
/* 74 */     if (o == null || getClass() != o.getClass()) {
/* 75 */       return false;
/*    */     }
/*    */     
/* 78 */     UserCfg userCfg = (UserCfg)o;
/*    */     
/* 80 */     if (this.passwordStored != userCfg.passwordStored) {
/* 81 */       return false;
/*    */     }
/* 83 */     if ((this.password != null) ? !this.password.equals(userCfg.password) : (userCfg.password != null)) {
/* 84 */       return false;
/*    */     }
/* 86 */     if ((this.username != null) ? !this.username.equals(userCfg.username) : (userCfg.username != null)) {
/* 87 */       return false;
/*    */     }
/*    */     
/* 90 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 95 */     int result = (this.username != null) ? this.username.hashCode() : 0;
/* 96 */     result = 31 * result + ((this.password != null) ? this.password.hashCode() : 0);
/* 97 */     result = 31 * result + (this.passwordStored ? 1 : 0);
/* 98 */     return result;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\UserCfg.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */