/*    */ package com.atlassian.connector.commons.jira.soap;
/*    */ 
/*    */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*    */ import com.atlassian.theplugin.commons.cfg.UserCfg;
/*    */ import com.atlassian.theplugin.commons.remoteapi.ServerData;
/*    */ import java.rmi.Remote;
/*    */ import org.apache.axis.client.Stub;
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
/*    */ 
/*    */ 
/*    */ public class AxisSessionCallbackImpl
/*    */   implements AxisSessionCallback
/*    */ {
/*    */   public void configureRemoteService(Remote remote, ConnectionCfg connectionCfg) {
/* 32 */     if (connectionCfg instanceof ServerData && ((ServerData)connectionCfg).isUseBasicUser()) {
/* 33 */       UserCfg basicUser = ((ServerData)connectionCfg).getBasicUser();
/* 34 */       if (basicUser != null) {
/* 35 */         ((Stub)remote)._setProperty("javax.xml.rpc.security.auth.username", basicUser.getUsername());
/* 36 */         ((Stub)remote)._setProperty("javax.xml.rpc.security.auth.password", basicUser.getPassword());
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\AxisSessionCallbackImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */