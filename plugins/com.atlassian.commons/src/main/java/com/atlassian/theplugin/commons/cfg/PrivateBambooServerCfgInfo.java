/*    */ package com.atlassian.theplugin.commons.cfg;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class PrivateBambooServerCfgInfo
/*    */   extends PrivateServerCfgInfo {
/*    */   protected final int timezoneOffset;
/* 10 */   private Collection<SubscribedPlan> plans = MiscUtil.buildArrayList();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final boolean useFavourites;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PrivateBambooServerCfgInfo(ServerIdImpl serverId, boolean enabled, boolean useDefaultCredentials, String username, String password, int timezoneOffset, boolean useSessionCookies, boolean useHttpBasic, String basicUsername, String basicPassword, boolean global, Collection<SubscribedPlan> plans, boolean useFavourites) {
/* 22 */     super(serverId, enabled, useDefaultCredentials, username, password, useSessionCookies, useHttpBasic, basicUsername, basicPassword, global);
/* 23 */     this.timezoneOffset = timezoneOffset;
/* 24 */     if (plans == null) {
/* 25 */       plans = new ArrayList<SubscribedPlan>();
/*    */     } else {
/* 27 */       this.plans = plans;
/*    */     } 
/* 29 */     this.useFavourites = useFavourites;
/*    */   }
/*    */   
/*    */   public int getTimezoneOffset() {
/* 33 */     return this.timezoneOffset;
/*    */   }
/*    */   
/*    */   public Collection<SubscribedPlan> getPlans() {
/* 37 */     if (this.plans == null) {
/* 38 */       this.plans = new ArrayList<SubscribedPlan>();
/*    */     }
/* 40 */     return this.plans;
/*    */   }
/*    */   
/*    */   public void setPlans(Collection<SubscribedPlan> plans) {
/* 44 */     this.plans = plans;
/*    */   }
/*    */   
/*    */   public boolean isUseFavourites() {
/* 48 */     return this.useFavourites;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\PrivateBambooServerCfgInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */