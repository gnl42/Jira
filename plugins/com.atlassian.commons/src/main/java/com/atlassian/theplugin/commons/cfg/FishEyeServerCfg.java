/*    */ package com.atlassian.theplugin.commons.cfg;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.ServerType;
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
/*    */ public class FishEyeServerCfg
/*    */   extends ServerCfg
/*    */   implements FishEyeServer
/*    */ {
/*    */   public FishEyeServerCfg(boolean enabled, String name, ServerIdImpl serverId) {
/* 22 */     super(enabled, name, serverId);
/*    */   }
/*    */ 
/*    */   
/*    */   protected FishEyeServerCfg(FishEyeServerCfg other) {
/* 27 */     super(other);
/*    */   }
/*    */   
/*    */   public FishEyeServerCfg(String name, ServerIdImpl serverId) {
/* 31 */     this(true, name, serverId);
/*    */   }
/*    */ 
/*    */   
/*    */   public ServerType getServerType() {
/* 36 */     return ServerType.FISHEYE_SERVER;
/*    */   }
/*    */   
/*    */   public boolean isDontUseBasicAuth() {
/* 40 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isUseSessionCookies() {
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public UserCfg getBasicHttpUser() {
/* 48 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public FishEyeServerCfg getClone() {
/* 53 */     return new FishEyeServerCfg(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public FishEyeServer asFishEyeServer() {
/* 58 */     return this;
/*    */   }
/*    */   
/*    */   public ProjectId getProjectId() {
/* 62 */     return null;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\FishEyeServerCfg.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */