/*    */ package com.atlassian.theplugin.commons.bamboo;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.cfg.BambooServerCfg;
/*    */ import com.atlassian.theplugin.commons.cfg.Server;
/*    */ import com.atlassian.theplugin.commons.cfg.SubscribedPlan;
/*    */ import com.atlassian.theplugin.commons.cfg.UserCfg;
/*    */ import com.atlassian.theplugin.commons.remoteapi.ServerData;
/*    */ import java.util.Collection;
/*    */ import org.jetbrains.annotations.NotNull;
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
/*    */ 
/*    */ public class BambooServerData
/*    */   extends ServerData
/*    */ {
/*    */   public BambooServerData(@NotNull BambooServerCfg server) {
/* 32 */     super((Server)server);
/*    */   }
/*    */   
/*    */   public BambooServerData(Builder builder) {
/* 36 */     super(builder);
/*    */   }
/*    */ 
/*    */   
/*    */   public BambooServerData(BambooServerCfg server, UserCfg defaultUser) {
/* 41 */     super((Server)server, defaultUser);
/*    */   }
/*    */   
/*    */   public static class Builder
/*    */     extends ServerData.Builder {
/*    */     public Builder(Server server) {
/* 47 */       super(server);
/*    */     }
/*    */     
/*    */     public Builder(Server server, UserCfg defaultUser) {
/* 51 */       super(server, defaultUser);
/*    */     }
/*    */ 
/*    */     
/*    */     public BambooServerData build() {
/* 56 */       return new BambooServerData(this);
/*    */     }
/*    */ 
/*    */     
/*    */     protected Server getServer() {
/* 61 */       return super.getServer();
/*    */     } }
/*    */   
/*    */   public Collection<SubscribedPlan> getPlans() {
/* 65 */     return getServer().getPlans();
/*    */   }
/*    */   
/*    */   public boolean isUseFavourites() {
/* 69 */     return getServer().isUseFavourites();
/*    */   }
/*    */   
/*    */   public int getTimezoneOffset() {
/* 73 */     return getServer().getTimezoneOffset();
/*    */   }
/*    */   
/*    */   public boolean isBamboo2() {
/* 77 */     return getServer().isBamboo2();
/*    */   }
/*    */   
/*    */   public boolean isShowBranches() {
/* 81 */     return getServer().isShowBranches();
/*    */   }
/*    */   
/*    */   public boolean isMyBranchesOnly() {
/* 85 */     return getServer().isMyBranchesOnly();
/*    */   }
/*    */ 
/*    */   
/*    */   protected BambooServerCfg getServer() {
/* 90 */     return (BambooServerCfg)super.getServer();
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BambooServerData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */