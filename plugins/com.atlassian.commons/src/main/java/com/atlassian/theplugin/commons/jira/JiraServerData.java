/*    */ package com.atlassian.theplugin.commons.jira;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.cfg.Server;
/*    */ import com.atlassian.theplugin.commons.cfg.UserCfg;
/*    */ import com.atlassian.theplugin.commons.remoteapi.ServerData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JiraServerData
/*    */   extends ServerData
/*    */ {
/*    */   public JiraServerData(Server server) {
/* 15 */     super(server);
/*    */   }
/*    */   
/*    */   public JiraServerData(Builder builder) {
/* 19 */     super(builder);
/*    */   }
/*    */   
/*    */   public JiraServerData(Server server, UserCfg defaultUser) {
/* 23 */     super(server, defaultUser);
/*    */   }
/*    */   
/*    */   public static class Builder
/*    */     extends ServerData.Builder {
/*    */     public Builder(Server server) {
/* 29 */       super(server);
/*    */     }
/*    */     
/*    */     public Builder(Server server, UserCfg defaultUser) {
/* 33 */       super(server, defaultUser);
/*    */     }
/*    */ 
/*    */     
/*    */     public JiraServerData build() {
/* 38 */       return new JiraServerData(this);
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\jira\JiraServerData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */