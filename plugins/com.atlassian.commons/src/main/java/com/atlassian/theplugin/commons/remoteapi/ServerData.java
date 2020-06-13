/*     */ package com.atlassian.theplugin.commons.remoteapi;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import com.atlassian.theplugin.commons.ServerType;
/*     */ import com.atlassian.theplugin.commons.cfg.Server;
/*     */ import com.atlassian.theplugin.commons.cfg.ServerId;
/*     */ import com.atlassian.theplugin.commons.cfg.UserCfg;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ServerData
/*     */   extends ConnectionCfg
/*     */ {
/*     */   private final Server server;
/*     */   private boolean useProxy = false;
/*     */   private UserCfg basicUser;
/*     */   private UserCfg proxyUser;
/*     */   private boolean useBasicUser = false;
/*     */   private boolean useSessionCookies = false;
/*     */   
/*     */   public ServerData(Builder builder) {
/*  43 */     super((builder.server != null && builder.server.getServerId() != null) ? builder.server.getServerId().getId() : "", (builder.server != null) ? builder.server.getUrl() : "", builder.useDefaultUser ? builder.defaultUser.getUsername() : ((builder.server != null) ? builder.server.getUsername() : ""), builder.useDefaultUser ? builder.defaultUser.getPassword() : ((builder.server != null) ? builder.server.getPassword() : ""));
/*  44 */     this.server = builder.server;
/*  45 */     this.basicUser = builder.basicUser;
/*  46 */     this.useProxy = builder.useProxyUser;
/*  47 */     this.proxyUser = builder.proxyUser;
/*  48 */     this.useBasicUser = builder.useBasicUser;
/*  49 */     this.useSessionCookies = builder.useSessionCookies;
/*     */   }
/*     */   
/*     */   private ServerData(ServerData that) {
/*  53 */     super(that.getId(), that.getUrl(), that.getUsername(), that.getPassword());
/*  54 */     this.server = that.server;
/*  55 */     this.useProxy = that.useProxy;
/*  56 */     this.basicUser = that.basicUser;
/*  57 */     this.proxyUser = that.proxyUser;
/*  58 */     this.useBasicUser = that.useBasicUser;
/*  59 */     this.useSessionCookies = that.useSessionCookies;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Builder
/*     */   {
/*     */     protected final Server server;
/*     */     protected UserCfg defaultUser;
/*     */     protected UserCfg basicUser;
/*     */     protected UserCfg proxyUser;
/*     */     protected boolean useDefaultUser = false;
/*     */     protected boolean useProxyUser = false;
/*     */     private boolean useBasicUser;
/*     */     private boolean useSessionCookies = false;
/*     */     
/*     */     public Builder(Server server) {
/*  75 */       this.server = server;
/*  76 */       this.basicUser = server.getBasicHttpUser();
/*  77 */       this.useBasicUser = !server.isDontUseBasicAuth();
/*  78 */       this.useDefaultUser = server.isUseDefaultCredentials();
/*  79 */       this.useSessionCookies = server.isUseSessionCookies();
/*     */     }
/*     */     public Builder(Server server, UserCfg defaultUser) {
/*  82 */       this(server);
/*  83 */       this.defaultUser = defaultUser;
/*     */     }
/*     */     
/*     */     protected Server getServer() {
/*  87 */       return this.server;
/*     */     }
/*     */     
/*     */     public void basicUser(UserCfg basicUsr) {
/*  91 */       this.basicUser = basicUsr;
/*     */     }
/*     */     
/*     */     public void defaultUser(UserCfg defaultUsr) {
/*  95 */       this.defaultUser = defaultUsr;
/*     */     }
/*     */     
/*     */     public void proxyUser(UserCfg proxyUsr) {
/*  99 */       this.proxyUser = proxyUsr;
/*     */     }
/*     */     
/*     */     public void useDefaultUser(boolean useDefault) {
/* 103 */       this.useDefaultUser = useDefault;
/*     */     }
/*     */     
/*     */     public void useProxyUser(boolean useProxy) {
/* 107 */       this.useProxyUser = useProxy;
/*     */     }
/*     */     
/*     */     public void useBasicUser(boolean useBasic) {
/* 111 */       this.useBasicUser = useBasic;
/*     */     }
/*     */     public ServerData build() {
/* 114 */       return new ServerData(this);
/*     */     }
/*     */     
/*     */     public void setUseSessionCookies(boolean useSessionCookies) {
/* 118 */       this.useSessionCookies = useSessionCookies;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ServerData(Server server) {
/* 126 */     super((server != null) ? ((server.getServerId() != null) ? server.getServerId().getId() : "") : "", (server != null) ? server.getUrl() : "", (server != null) ? server.getUsername() : "", (server != null) ? server.getPassword() : "");
/* 127 */     this.server = server;
/* 128 */     if (server != null) {
/* 129 */       this.useBasicUser = !server.isDontUseBasicAuth();
/* 130 */       this.basicUser = server.getBasicHttpUser();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ServerData(Server server, UserCfg defaultUser) {
/* 138 */     super((server != null && server.getServerId() != null) ? server.getServerId().getId() : "", (server != null) ? server.getUrl() : "", (defaultUser != null) ? defaultUser.getUsername() : ((server != null) ? server.getUsername() : ""), (defaultUser != null) ? defaultUser.getPassword() : ((server != null) ? server.getPassword() : ""));
/* 139 */     this.server = server;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Server getServer() {
/* 144 */     return this.server;
/*     */   }
/*     */   
/*     */   public String getUsername() {
/* 148 */     return super.getUsername();
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 152 */     return super.getPassword();
/*     */   }
/*     */   
/*     */   public String getUrl() {
/* 156 */     return this.server.getUrl();
/*     */   }
/*     */   
/*     */   public ServerId getServerId() {
/* 160 */     return (ServerId)this.server.getServerId();
/*     */   }
/*     */   
/*     */   public String getName() {
/* 164 */     return this.server.getName();
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/* 168 */     return this.server.isEnabled();
/*     */   }
/*     */   
/*     */   public ServerType getServerType() {
/* 172 */     return this.server.getServerType();
/*     */   }
/*     */   
/*     */   public boolean isUseProxy() {
/* 176 */     return this.useProxy;
/*     */   }
/*     */   
/*     */   public UserCfg getBasicUser() {
/* 180 */     return this.basicUser;
/*     */   }
/*     */   
/*     */   public UserCfg getProxyUser() {
/* 184 */     return this.proxyUser;
/*     */   }
/*     */   
/*     */   public boolean isUseBasicUser() {
/* 188 */     return this.useBasicUser;
/*     */   }
/*     */   
/*     */   public boolean isUseSessionCookies() {
/* 192 */     return this.useSessionCookies;
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
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 209 */     if (this == o) {
/* 210 */       return true;
/*     */     }
/* 212 */     if (o == null || !(o instanceof ServerData)) {
/* 213 */       return false;
/*     */     }
/*     */     
/* 216 */     ServerData that = (ServerData)o;
/*     */     
/* 218 */     if ((getServerId() != null) ? !getServerId().equals(that.getServerId()) : (that.getServerId() != null)) {
/* 219 */       return false;
/*     */     }
/* 221 */     if ((getUrl() != null) ? !getUrl().equals(that.getUrl()) : (that.getUrl() != null)) {
/* 222 */       return false;
/*     */     }
/*     */     
/* 225 */     if (getPassword() == null) {
/* 226 */       if (that.getPassword() != null) {
/* 227 */         return false;
/*     */       }
/* 229 */     } else if (!getPassword().equals(that.getPassword())) {
/* 230 */       return false;
/*     */     } 
/*     */     
/* 233 */     if (getUsername() == null) {
/* 234 */       if (that.getUsername() != null) {
/* 235 */         return false;
/*     */       }
/* 237 */     } else if (!getUsername().equals(that.getUsername())) {
/* 238 */       return false;
/*     */     } 
/* 240 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 250 */     int result = (getServerId() != null) ? getServerId().hashCode() : 0;
/* 251 */     result = 31 * result + super.hashCode();
/* 252 */     result = 31 * result + ((getUrl() != null) ? getUrl().hashCode() : 0);
/* 253 */     return result;
/*     */   }
/*     */   
/*     */   public ConnectionCfg toConnectionCfg() {
/* 257 */     return new ServerData(this);
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\remoteapi\ServerData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */