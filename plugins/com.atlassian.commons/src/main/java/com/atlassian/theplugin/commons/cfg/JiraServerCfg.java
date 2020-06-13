/*     */ package com.atlassian.theplugin.commons.cfg;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.ServerType;
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
/*     */ public class JiraServerCfg
/*     */   extends ServerCfg
/*     */ {
/*     */   private static final int HASHCODE_MAGIC = 31;
/*     */   private boolean dontUseBasicAuth = true;
/*     */   private UserCfg basicHttpUser;
/*     */   private boolean useSessionCookies = false;
/*     */   
/*     */   public JiraServerCfg(String name, ServerIdImpl serverId, boolean dontUseBasicAuth) {
/*  27 */     super(true, name, serverId);
/*  28 */     this.dontUseBasicAuth = dontUseBasicAuth;
/*     */   }
/*     */   
/*     */   public JiraServerCfg(JiraServerCfg other) {
/*  32 */     super(other);
/*  33 */     this.dontUseBasicAuth = other.dontUseBasicAuth;
/*  34 */     this.basicHttpUser = other.basicHttpUser;
/*  35 */     this.useSessionCookies = other.useSessionCookies;
/*     */   }
/*     */   
/*     */   public JiraServerCfg(boolean enabled, String name, ServerIdImpl serverId, boolean dontUseBasicAuth, boolean useSessionCookies) {
/*  39 */     super(enabled, name, serverId);
/*  40 */     this.dontUseBasicAuth = dontUseBasicAuth;
/*  41 */     this.useSessionCookies = useSessionCookies;
/*     */   }
/*     */   
/*     */   public JiraServerCfg(boolean enabled, String name, String url, ServerIdImpl serverId, boolean dontUseBasicAuth, boolean useSessionCookies) {
/*  45 */     super(enabled, name, url, serverId);
/*  46 */     this.dontUseBasicAuth = dontUseBasicAuth;
/*  47 */     this.useSessionCookies = useSessionCookies;
/*     */   }
/*     */ 
/*     */   
/*     */   public ServerType getServerType() {
/*  52 */     return ServerType.JIRA_SERVER;
/*     */   }
/*     */ 
/*     */   
/*     */   public JiraServerCfg getClone() {
/*  57 */     return new JiraServerCfg(this);
/*     */   }
/*     */   
/*     */   public boolean isDontUseBasicAuth() {
/*  61 */     return this.dontUseBasicAuth;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDontUseBasicAuth(boolean dontUseBasicAuth) {
/*  66 */     this.dontUseBasicAuth = dontUseBasicAuth;
/*     */   }
/*     */   
/*     */   public void setBasicHttpUser(UserCfg userCfg) {
/*  70 */     this.basicHttpUser = userCfg;
/*     */   }
/*     */   
/*     */   public UserCfg getBasicHttpUser() {
/*  74 */     return this.basicHttpUser;
/*     */   }
/*     */   
/*     */   public boolean isUseSessionCookies() {
/*  78 */     return this.useSessionCookies;
/*     */   }
/*     */   
/*     */   public void setUseSessionCookies(boolean useSessionCookies) {
/*  82 */     this.useSessionCookies = useSessionCookies;
/*     */   }
/*     */ 
/*     */   
/*     */   public PrivateServerCfgInfo createPrivateProjectConfiguration() {
/*  87 */     return new PrivateServerCfgInfo(getServerId(), isEnabled(), isUseDefaultCredentials(), 
/*  88 */         getUsername(), isPasswordStored() ? getPassword() : null, this.useSessionCookies, 
/*  89 */         !this.dontUseBasicAuth, 
/*  90 */         (this.basicHttpUser != null) ? this.basicHttpUser.getUsername() : "", 
/*  91 */         (this.basicHttpUser != null) ? this.basicHttpUser.getPassword() : "", 
/*  92 */         isShared());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mergePrivateConfiguration(PrivateServerCfgInfo psci) {
/*  98 */     super.mergePrivateConfiguration(psci);
/*  99 */     if (psci != null) {
/* 100 */       setUseSessionCookies(psci.isUseSessionCookies());
/* 101 */       setDontUseBasicAuth(!psci.isUseHttpBasic());
/* 102 */       setBasicHttpUser(new UserCfg(psci.getBasicUsername(), psci.getBasicPassword()));
/*     */     } else {
/* 104 */       setUseSessionCookies(false);
/* 105 */       setDontUseBasicAuth(true);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 111 */     if (this == o) {
/* 112 */       return true;
/*     */     }
/* 114 */     if (o == null || getClass() != o.getClass()) {
/* 115 */       return false;
/*     */     }
/* 117 */     if (!super.equals(o)) {
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     JiraServerCfg that = (JiraServerCfg)o;
/*     */     
/* 123 */     if (this.useSessionCookies != that.useSessionCookies) {
/* 124 */       return false;
/*     */     }
/* 126 */     if (this.dontUseBasicAuth != that.dontUseBasicAuth) {
/* 127 */       return false;
/*     */     }
/* 129 */     if ((this.basicHttpUser != null) ? !this.basicHttpUser.equals(that.basicHttpUser) : (that.basicHttpUser != null)) {
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 138 */     int result = super.hashCode();
/* 139 */     result = 31 * result + (this.useSessionCookies ? 1 : 0);
/* 140 */     result = 31 * result + (this.dontUseBasicAuth ? 1 : 0);
/* 141 */     result = 31 * result + ((this.basicHttpUser != null) ? this.basicHttpUser.hashCode() : 0);
/* 142 */     return result;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\JiraServerCfg.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */