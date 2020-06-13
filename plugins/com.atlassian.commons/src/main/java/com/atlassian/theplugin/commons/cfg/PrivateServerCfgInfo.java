/*     */ package com.atlassian.theplugin.commons.cfg;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PrivateServerCfgInfo
/*     */ {
/*     */   protected final ServerIdImpl serverId;
/*     */   protected final boolean isEnabled;
/*     */   protected final String username;
/*     */   protected final String password;
/*     */   protected boolean useHttpBasic = false;
/*     */   protected boolean useSessionCookies = false;
/*     */   protected final String basicUsername;
/*     */   protected final String basicPassword;
/*     */   protected final boolean useDefaultCredentials;
/*     */   private static final int HASHCODE_MAGIC = 31;
/*     */   protected boolean shared;
/*     */   
/*     */   public PrivateServerCfgInfo(ServerIdImpl serverId, boolean enabled, boolean useDefaultCredentials, String username, String password, boolean useSessionCookies, boolean useHttpBasic, String basicUsername, String basicPassword, boolean shared) {
/*  34 */     this.serverId = serverId;
/*  35 */     this.isEnabled = enabled;
/*  36 */     this.useDefaultCredentials = useDefaultCredentials;
/*  37 */     this.username = username;
/*  38 */     this.password = password;
/*     */     
/*  40 */     this.useSessionCookies = useSessionCookies;
/*  41 */     this.useHttpBasic = useHttpBasic;
/*  42 */     this.basicUsername = basicUsername;
/*  43 */     this.basicPassword = basicPassword;
/*  44 */     this.shared = shared;
/*     */   }
/*     */   
/*     */   public ServerId getServerId() {
/*  48 */     return this.serverId;
/*     */   }
/*     */   
/*     */   public String getUsername() {
/*  52 */     return this.username;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/*  56 */     return this.password;
/*     */   }
/*     */   
/*     */   public boolean isUseSessionCookies() {
/*  60 */     return this.useSessionCookies;
/*     */   }
/*     */   
/*     */   public boolean isUseHttpBasic() {
/*  64 */     return this.useHttpBasic;
/*     */   }
/*     */   
/*     */   public String getBasicUsername() {
/*  68 */     return this.basicUsername;
/*     */   }
/*     */   
/*     */   public String getBasicPassword() {
/*  72 */     return this.basicPassword;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  77 */     if (this == o) {
/*  78 */       return true;
/*     */     }
/*  80 */     if (o == null || getClass() != o.getClass()) {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     PrivateServerCfgInfo that = (PrivateServerCfgInfo)o;
/*     */     
/*  86 */     if ((this.serverId != null) ? !this.serverId.equals(that.serverId) : (that.serverId != null)) {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  95 */     int result = (this.serverId != null) ? this.serverId.hashCode() : 0;
/*  96 */     result = 31 * result + (this.isEnabled ? 1 : 0);
/*  97 */     result = 31 * result + ((this.username != null) ? this.username.hashCode() : 0);
/*  98 */     result = 31 * result + ((this.password != null) ? this.password.hashCode() : 0);
/*  99 */     result = 31 * result + (this.useSessionCookies ? 1 : 0);
/* 100 */     result = 31 * result + (this.useHttpBasic ? 1 : 0);
/* 101 */     result = 31 * result + ((this.basicUsername != null) ? this.basicUsername.hashCode() : 0);
/* 102 */     result = 31 * result + ((this.basicPassword != null) ? this.basicPassword.hashCode() : 0);
/* 103 */     result = 31 * result + (this.useDefaultCredentials ? 1 : 0);
/* 104 */     return result;
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/* 108 */     return this.isEnabled;
/*     */   }
/*     */   
/*     */   public boolean isUseDefaultCredentials() {
/* 112 */     return this.useDefaultCredentials;
/*     */   }
/*     */   
/*     */   public boolean isShared() {
/* 116 */     return this.shared;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\PrivateServerCfgInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */