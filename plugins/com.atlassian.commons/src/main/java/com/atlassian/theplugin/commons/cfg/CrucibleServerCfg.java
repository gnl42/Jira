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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrucibleServerCfg
/*     */   extends ServerCfg
/*     */ {
/*     */   private boolean isFisheyeInstance;
/*     */   private static final int HASHCODE_MAGIC = 31;
/*     */   private FishEyeServer fishEyeView;
/*     */   
/*     */   public CrucibleServerCfg(boolean enabled, String name, ServerIdImpl serverId) {
/*  30 */     super(enabled, name, serverId);
/*     */   }
/*     */   
/*     */   private FishEyeServer getFishEyeView() {
/*  34 */     if (this.fishEyeView == null) {
/*  35 */       this.fishEyeView = new FishEyeServer() {
/*     */           public ServerIdImpl getServerId() {
/*  37 */             return CrucibleServerCfg.this.getServerId();
/*     */           }
/*     */           public String getPassword() {
/*  40 */             return CrucibleServerCfg.this.getPassword();
/*     */           }
/*     */           public String getName() {
/*  43 */             return CrucibleServerCfg.this.getName();
/*     */           }
/*     */           public String getUsername() {
/*  46 */             return CrucibleServerCfg.this.getUsername();
/*     */           }
/*     */           public String getUrl() {
/*  49 */             return CrucibleServerCfg.this.getUrl();
/*     */           }
/*     */           public boolean isEnabled() {
/*  52 */             return CrucibleServerCfg.this.isEnabled();
/*     */           }
/*     */           public boolean isUseDefaultCredentials() {
/*  55 */             return CrucibleServerCfg.this.isUseDefaultCredentials();
/*     */           }
/*     */           public ServerType getServerType() {
/*  58 */             return ServerType.FISHEYE_SERVER;
/*     */           }
/*     */           public boolean isDontUseBasicAuth() {
/*  61 */             return false;
/*     */           }
/*     */           public boolean isUseSessionCookies() {
/*  64 */             return false;
/*     */           }
/*     */           public UserCfg getBasicHttpUser() {
/*  67 */             return null;
/*     */           }
/*     */           public boolean isShared() {
/*  70 */             return false;
/*     */           }
/*     */           
/*     */           public void setShared(boolean shared) {}
/*     */         };
/*     */     }
/*  76 */     return this.fishEyeView;
/*     */   }
/*     */   
/*     */   public CrucibleServerCfg(String name, ServerIdImpl serverId) {
/*  80 */     super(true, name, serverId);
/*     */   }
/*     */   
/*     */   public CrucibleServerCfg(CrucibleServerCfg other) {
/*  84 */     super(other);
/*  85 */     this.isFisheyeInstance = other.isFisheyeInstance();
/*     */   }
/*     */ 
/*     */   
/*     */   public ServerType getServerType() {
/*  90 */     return ServerType.CRUCIBLE_SERVER;
/*     */   }
/*     */   
/*     */   public boolean isDontUseBasicAuth() {
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isUseSessionCookies() {
/*  98 */     return false;
/*     */   }
/*     */   
/*     */   public UserCfg getBasicHttpUser() {
/* 102 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 107 */     if (!super.equals(o)) {
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     if (this == o) {
/* 112 */       return true;
/*     */     }
/* 114 */     if (!(o instanceof CrucibleServerCfg)) {
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     CrucibleServerCfg that = (CrucibleServerCfg)o;
/*     */     
/* 120 */     if (this.isFisheyeInstance != that.isFisheyeInstance) {
/* 121 */       return false;
/*     */     }
/* 123 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 128 */     int result = super.hashCode();
/* 129 */     result = 31 * result + (this.isFisheyeInstance ? 1 : 0);
/* 130 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 136 */     StringBuilder builder = new StringBuilder("Crucible Server [");
/* 137 */     builder.append(super.toString());
/* 138 */     builder.append("]");
/* 139 */     return builder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public CrucibleServerCfg getClone() {
/* 144 */     return new CrucibleServerCfg(this);
/*     */   }
/*     */   
/*     */   public boolean isFisheyeInstance() {
/* 148 */     return this.isFisheyeInstance;
/*     */   }
/*     */   
/*     */   public void setFisheyeInstance(boolean fisheyeInstance) {
/* 152 */     this.isFisheyeInstance = fisheyeInstance;
/*     */   }
/*     */ 
/*     */   
/*     */   public FishEyeServer asFishEyeServer() {
/* 157 */     if (this.isFisheyeInstance) {
/* 158 */       return getFishEyeView();
/*     */     }
/* 160 */     return null;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\CrucibleServerCfg.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */