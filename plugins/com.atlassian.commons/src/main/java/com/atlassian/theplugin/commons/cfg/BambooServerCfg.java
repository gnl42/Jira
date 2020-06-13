/*     */ package com.atlassian.theplugin.commons.cfg;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.ServerType;
/*     */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*     */ import java.util.Collection;
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
/*     */ public class BambooServerCfg
/*     */   extends ServerCfg
/*     */ {
/*     */   private boolean isUseFavourites;
/*     */   private boolean showBranches;
/*     */   private boolean myBranchesOnly;
/*     */   private boolean isBamboo2;
/*  30 */   private Collection<SubscribedPlan> plans = MiscUtil.buildArrayList();
/*     */   private int timezoneOffset;
/*     */   
/*     */   public BambooServerCfg(String name, ServerIdImpl serverId) {
/*  34 */     super(true, name, serverId);
/*     */   }
/*     */   
/*     */   public BambooServerCfg(String name, String url, ServerIdImpl serverId) {
/*  38 */     super(true, name, url, serverId);
/*     */   }
/*     */   
/*     */   public BambooServerCfg(boolean enabled, String name, ServerIdImpl serverId) {
/*  42 */     super(enabled, name, serverId);
/*  43 */     this.showBranches = true;
/*     */   }
/*     */   
/*     */   public BambooServerCfg(BambooServerCfg other) {
/*  47 */     super(other);
/*  48 */     this.isUseFavourites = other.isUseFavourites();
/*  49 */     this.showBranches = other.isShowBranches();
/*  50 */     this.myBranchesOnly = other.isMyBranchesOnly();
/*  51 */     this.isBamboo2 = other.isBamboo2();
/*     */     
/*  53 */     this.plans = MiscUtil.buildArrayList(other.getPlans());
/*  54 */     this.timezoneOffset = other.timezoneOffset;
/*     */   }
/*     */ 
/*     */   
/*     */   public ServerType getServerType() {
/*  59 */     return ServerType.BAMBOO_SERVER;
/*     */   }
/*     */   
/*     */   public boolean isDontUseBasicAuth() {
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isUseSessionCookies() {
/*  67 */     return false;
/*     */   }
/*     */   
/*     */   public UserCfg getBasicHttpUser() {
/*  71 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isUseFavourites() {
/*  75 */     return this.isUseFavourites;
/*     */   }
/*     */   
/*     */   public Collection<SubscribedPlan> getSubscribedPlans() {
/*  79 */     return this.plans;
/*     */   }
/*     */   
/*     */   public void clearSubscribedPlans() {
/*  83 */     this.plans.clear();
/*     */   }
/*     */   
/*     */   public void setUseFavourites(boolean useFavourites) {
/*  87 */     this.isUseFavourites = useFavourites;
/*     */   }
/*     */   
/*     */   public void setShowBranches(boolean showBranches) {
/*  91 */     this.showBranches = showBranches;
/*     */   }
/*     */   
/*     */   public void setMyBranchesOnly(boolean myBranchesOnly) {
/*  95 */     this.myBranchesOnly = myBranchesOnly;
/*     */   }
/*     */   
/*     */   public int getTimezoneOffset() {
/*  99 */     return this.timezoneOffset;
/*     */   }
/*     */   
/*     */   public void setTimezoneOffset(int timezoneOffset) {
/* 103 */     this.timezoneOffset = timezoneOffset;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 108 */     if (!super.equals(o)) {
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if (this == o) {
/* 113 */       return true;
/*     */     }
/* 115 */     if (!(o instanceof BambooServerCfg)) {
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     BambooServerCfg that = (BambooServerCfg)o;
/*     */     
/* 121 */     if (this.isUseFavourites != that.isUseFavourites) {
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     if (this.showBranches != that.showBranches) {
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     if (this.myBranchesOnly != that.myBranchesOnly) {
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     if (!this.plans.equals(that.plans)) {
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     if (this.timezoneOffset != that.timezoneOffset) {
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 146 */     int result = super.hashCode();
/* 147 */     result = 31 * result + (this.isUseFavourites ? 1 : 0);
/* 148 */     result = 31 * result + (this.showBranches ? 1 : 0);
/* 149 */     result = 31 * result + (this.myBranchesOnly ? 1 : 0);
/* 150 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 155 */     StringBuilder builder = new StringBuilder("Bamboo Server [");
/* 156 */     builder.append(super.toString());
/* 157 */     builder.append("]");
/* 158 */     return builder.toString();
/*     */   }
/*     */   
/*     */   public void setIsBamboo2(boolean b) {
/* 162 */     this.isBamboo2 = b;
/*     */   }
/*     */   
/*     */   public boolean isBamboo2() {
/* 166 */     return this.isBamboo2;
/*     */   }
/*     */   
/*     */   public boolean isShowBranches() {
/* 170 */     return this.showBranches;
/*     */   }
/*     */   
/*     */   public boolean isMyBranchesOnly() {
/* 174 */     return this.myBranchesOnly;
/*     */   }
/*     */   
/*     */   public Collection<SubscribedPlan> getPlans() {
/* 178 */     return this.plans;
/*     */   }
/*     */   
/*     */   public void setPlans(Collection<SubscribedPlan> plans) {
/* 182 */     this.plans = plans;
/*     */   }
/*     */ 
/*     */   
/*     */   public BambooServerCfg getClone() {
/* 187 */     return new BambooServerCfg(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/* 193 */     super.readResolve();
/* 194 */     if (this.plans == null) {
/* 195 */       this.plans = MiscUtil.buildArrayList();
/*     */     }
/* 197 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PrivateServerCfgInfo createPrivateProjectConfiguration() {
/* 202 */     return new PrivateBambooServerCfgInfo(getServerId(), isEnabled(), isUseDefaultCredentials(), 
/* 203 */         getUsername(), isPasswordStored() ? getPassword() : null, getTimezoneOffset(), false, false, "", "", isShared(), 
/* 204 */         getPlans(), this.isUseFavourites);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mergePrivateConfiguration(PrivateServerCfgInfo psci) {
/* 209 */     super.mergePrivateConfiguration(psci);
/* 210 */     if (psci != null)
/*     */       try {
/* 212 */         setTimezoneOffset(((PrivateBambooServerCfgInfo)psci).getTimezoneOffset());
/* 213 */         setPlans(((PrivateBambooServerCfgInfo)psci).getPlans());
/* 214 */         this.isUseFavourites = ((PrivateBambooServerCfgInfo)psci).isUseFavourites();
/* 215 */       } catch (ClassCastException classCastException) {} 
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\BambooServerCfg.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */