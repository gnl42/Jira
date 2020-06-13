/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
/*    */ 
/*    */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*    */ import com.atlassian.connector.commons.crucible.CrucibleServerFacade2;
/*    */ import com.atlassian.theplugin.commons.exception.ServerPasswordNotProvidedException;
/*    */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class CrucibleUserCacheImpl
/*    */   implements CrucibleUserCache
/*    */ {
/* 15 */   private final Map<ConnectionCfg, Map<String, User>> serverMap = new HashMap<ConnectionCfg, Map<String, User>>();
/*    */ 
/*    */   
/*    */   public User getUser(@NotNull CrucibleServerFacade2 facade, ConnectionCfg server, String userId, boolean fetchIfNotExist) {
/* 19 */     Map<String, User> userMap = this.serverMap.get(server);
/* 20 */     if (userMap == null && fetchIfNotExist) {
/* 21 */       List<User> users; userMap = new HashMap<String, User>();
/* 22 */       this.serverMap.put(server, userMap);
/*    */       
/*    */       try {
/* 25 */         users = facade.getUsers(server);
/* 26 */       } catch (RemoteApiException remoteApiException) {
/* 27 */         return null;
/* 28 */       } catch (ServerPasswordNotProvidedException serverPasswordNotProvidedException) {
/* 29 */         return null;
/*    */       } 
/* 31 */       for (User u : users) {
/* 32 */         userMap.put(u.getUsername(), u);
/*    */       }
/*    */     } 
/* 35 */     if (userMap != null) {
/* 36 */       return userMap.get(userId);
/*    */     }
/* 38 */     return null;
/*    */   }
/*    */   
/*    */   public void addUser(ConnectionCfg server, User user) {
/* 42 */     Map<String, User> userMap = this.serverMap.get(server);
/* 43 */     if (userMap == null) {
/* 44 */       userMap = new HashMap<String, User>();
/* 45 */       this.serverMap.put(server, userMap);
/*    */     } 
/* 47 */     userMap.put(user.getUsername(), user);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\CrucibleUserCacheImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */