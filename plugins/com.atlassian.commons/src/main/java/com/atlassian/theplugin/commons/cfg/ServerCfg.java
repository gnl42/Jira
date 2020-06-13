/*     */ package com.atlassian.theplugin.commons.cfg;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.ServerType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ServerCfg
/*     */   implements Server
/*     */ {
/*     */   private static final int HASHCODE_MAGIC = 31;
/*     */   private ServerIdImpl serverId;
/*     */   private boolean isEnabled;
/*     */   private boolean deleted;
/*     */   private String name;
/*     */   private String url;
/*     */   private String username;
/*     */   private String password;
/*     */   private boolean isPasswordStored;
/*     */   private boolean useDefaultCredentials;
/*     */   private boolean shared;
/*     */   
/*     */   public ServerCfg(boolean enabled, String name, ServerIdImpl serverId) {
/*  24 */     this(enabled, name, "", serverId);
/*     */   }
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
/*     */   public ServerCfg(boolean enabled, String name, String url, ServerIdImpl serverId) {
/*  39 */     this.url = "";
/*  40 */     this.username = "";
/*  41 */     this.password = "";
/*     */ 
/*     */ 
/*     */     
/*  45 */     this.shared = false; this.isEnabled = enabled; this.name = name; this.serverId = serverId; this.url = url; } protected ServerCfg(ServerCfg other) { this.url = ""; this.username = ""; this.password = ""; this.shared = false;
/*     */ 
/*     */ 
/*     */     
/*  49 */     this.serverId = other.getServerId();
/*  50 */     this.isEnabled = other.isEnabled();
/*  51 */     this.name = other.getName();
/*  52 */     this.url = other.getUrl();
/*  53 */     this.username = other.getUsername();
/*  54 */     this.password = other.getPassword();
/*  55 */     this.isPasswordStored = other.isPasswordStored();
/*  56 */     this.useDefaultCredentials = other.useDefaultCredentials;
/*  57 */     this.shared = other.shared;
/*  58 */     this.deleted = other.deleted; }
/*     */ 
/*     */   
/*     */   public boolean isUseDefaultCredentials() {
/*  62 */     return this.useDefaultCredentials;
/*     */   }
/*     */   
/*     */   public void setUseDefaultCredentials(boolean useDefaultCredentials) {
/*  66 */     this.useDefaultCredentials = useDefaultCredentials;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/*  71 */     if (this.username == null) {
/*  72 */       this.username = "";
/*     */     }
/*  74 */     if (this.password == null) {
/*  75 */       this.password = "";
/*     */     }
/*  77 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPassword() {
/*  82 */     return this.password;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract ServerType getServerType();
/*     */   
/*     */   public String getUsername() {
/*  89 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/*  93 */     this.isEnabled = (enabled && !this.deleted);
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  97 */     this.name = name;
/*     */   }
/*     */   
/*     */   public void setServerId(ServerIdImpl serverId) {
/* 101 */     this.serverId = serverId;
/*     */   }
/*     */   
/*     */   public void setUrl(String url) {
/* 105 */     this.url = url;
/*     */   }
/*     */   
/*     */   public void setUsername(String username) {
/* 109 */     this.username = username;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/* 113 */     this.password = password;
/*     */   }
/*     */   
/*     */   public void setPasswordStored(boolean passwordStored) {
/* 117 */     this.isPasswordStored = passwordStored;
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/* 121 */     return (this.isEnabled && !this.deleted);
/*     */   }
/*     */   
/*     */   public boolean isDeleted() {
/* 125 */     return this.deleted;
/*     */   }
/*     */   
/*     */   public void setDeleted(boolean deleted) {
/* 129 */     this.deleted = deleted;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 133 */     return this.name;
/*     */   }
/*     */   
/*     */   public ServerIdImpl getServerId() {
/* 137 */     return this.serverId;
/*     */   }
/*     */   
/*     */   public String getUrl() {
/* 141 */     return this.url;
/*     */   }
/*     */   
/*     */   public boolean isPasswordStored() {
/* 145 */     return this.isPasswordStored;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 150 */     if (this == o) {
/* 151 */       return true;
/*     */     }
/* 153 */     if (!(o instanceof ServerCfg)) {
/* 154 */       return false;
/*     */     }
/*     */     
/* 157 */     ServerCfg serverCfg = (ServerCfg)o;
/*     */     
/* 159 */     if (this.isEnabled != serverCfg.isEnabled) {
/* 160 */       return false;
/*     */     }
/*     */     
/* 163 */     if (this.deleted != serverCfg.deleted) {
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     if (this.isPasswordStored != serverCfg.isPasswordStored) {
/* 168 */       return false;
/*     */     }
/*     */     
/* 171 */     if (this.shared != serverCfg.shared) {
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     if (this.useDefaultCredentials != serverCfg.useDefaultCredentials) {
/* 176 */       return false;
/*     */     }
/* 178 */     if ((this.name != null) ? !this.name.equals(serverCfg.name) : (serverCfg.name != null)) {
/* 179 */       return false;
/*     */     }
/* 181 */     if ((this.password != null) ? !this.password.equals(serverCfg.password) : (serverCfg.password != null)) {
/* 182 */       return false;
/*     */     }
/* 184 */     if ((this.serverId != null) ? !this.serverId.equals(serverCfg.serverId) : (serverCfg.serverId != null)) {
/* 185 */       return false;
/*     */     }
/* 187 */     if ((this.url != null) ? !this.url.equals(serverCfg.url) : (serverCfg.url != null)) {
/* 188 */       return false;
/*     */     }
/* 190 */     if ((this.username != null) ? !this.username.equals(serverCfg.username) : (serverCfg.username != null)) {
/* 191 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 196 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 202 */     int result = this.isEnabled ? 1 : 0;
/* 203 */     result = 31 * result + ((this.name != null) ? this.name.hashCode() : 0);
/* 204 */     result = 31 * result + ((this.serverId != null) ? this.serverId.hashCode() : 0);
/* 205 */     result = 31 * result + ((this.url != null) ? this.url.hashCode() : 0);
/* 206 */     result = 31 * result + ((this.username != null) ? this.username.hashCode() : 0);
/* 207 */     result = 31 * result + ((this.password != null) ? this.password.hashCode() : 0);
/* 208 */     result = 31 * result + (this.isPasswordStored ? 1 : 0);
/* 209 */     result = 31 * result + (this.shared ? 1 : 0);
/* 210 */     result = 31 * result + (this.deleted ? 1 : 0);
/* 211 */     result = 31 * result + (this.useDefaultCredentials ? 1 : 0);
/* 212 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract ServerCfg getClone();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/* 224 */     return (getPassword() != null && getPassword().length() != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 229 */     StringBuilder builder = new StringBuilder();
/* 230 */     builder.append("name = ");
/* 231 */     builder.append(getName());
/* 232 */     builder.append(", url = ");
/* 233 */     builder.append(getUrl());
/* 234 */     return builder.toString();
/*     */   }
/*     */   
/*     */   public PrivateServerCfgInfo createPrivateProjectConfiguration() {
/* 238 */     return new PrivateServerCfgInfo(getServerId(), isEnabled(), isUseDefaultCredentials(), 
/* 239 */         getUsername(), isPasswordStored() ? getPassword() : null, 
/* 240 */         isUseSessionCookies(), false, null, null, this.shared);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mergePrivateConfiguration(PrivateServerCfgInfo psci) {
/* 245 */     if (psci != null) {
/* 246 */       setUsername(psci.getUsername());
/* 247 */       setEnabled(psci.isEnabled());
/* 248 */       setUseDefaultCredentials(psci.isUseDefaultCredentials());
/* 249 */       setShared(psci.isShared());
/* 250 */       String pwd = psci.getPassword();
/* 251 */       if (pwd != null) {
/* 252 */         setPassword(pwd);
/* 253 */         setPasswordStored(true);
/*     */       } else {
/* 255 */         setPasswordStored(false);
/*     */       } 
/*     */     } else {
/* 258 */       setPasswordStored(false);
/* 259 */       setEnabled(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   public FishEyeServer asFishEyeServer() {
/* 264 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isShared() {
/* 268 */     return this.shared;
/*     */   }
/*     */   
/*     */   public void setShared(boolean shared) {
/* 272 */     this.shared = shared;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\ServerCfg.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */