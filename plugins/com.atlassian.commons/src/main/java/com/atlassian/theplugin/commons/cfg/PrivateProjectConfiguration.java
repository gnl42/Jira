/*    */ package com.atlassian.theplugin.commons.cfg;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*    */ import java.util.Collection;
/*    */ import java.util.Set;
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
/*    */ public class PrivateProjectConfiguration
/*    */ {
/*    */   public Collection<PrivateServerCfgInfo> getPrivateServerCfgInfos() {
/* 26 */     return this.privateServerCfgInfos;
/*    */   }
/*    */   
/* 29 */   private Set<PrivateServerCfgInfo> privateServerCfgInfos = MiscUtil.buildHashSet();
/*    */   
/*    */   public void add(@NotNull PrivateServerCfgInfo info) {
/* 32 */     this.privateServerCfgInfos.add(info);
/*    */   }
/*    */   
/*    */   public PrivateServerCfgInfo getPrivateServerCfgInfo(ServerId serverId) {
/* 36 */     for (PrivateServerCfgInfo privateServerCfgInfo : this.privateServerCfgInfos) {
/* 37 */       if (privateServerCfgInfo.getServerId().equals(serverId)) {
/* 38 */         return privateServerCfgInfo;
/*    */       }
/*    */     } 
/* 41 */     return null;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\PrivateProjectConfiguration.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */