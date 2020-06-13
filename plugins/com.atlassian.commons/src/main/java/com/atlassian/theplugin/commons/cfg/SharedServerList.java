/*    */ package com.atlassian.theplugin.commons.cfg;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.HashSet;
/*    */ import java.util.LinkedList;
/*    */ import java.util.Set;
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
/*    */ public class SharedServerList
/*    */   extends ArrayList<ServerCfg>
/*    */ {
/*    */   public static SharedServerList merge(SharedServerList currentConfig, SharedServerList loadedFromFile, Collection<ServerCfg> allServers) {
/* 26 */     LinkedList<ServerCfg> sharedList = new LinkedList<ServerCfg>();
/* 27 */     HashSet<String> storedIds = new HashSet<String>();
/* 28 */     HashSet<String> deletedIds = new HashSet<String>();
/* 29 */     SharedServerList newList = new SharedServerList();
/*    */ 
/*    */     
/* 32 */     Set<String> nonShared = new HashSet<String>();
/* 33 */     for (ServerCfg s : allServers) {
/* 34 */       if (!s.isShared()) {
/* 35 */         nonShared.add(s.getServerId().getId());
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 40 */     sharedList.addAll(currentConfig);
/* 41 */     sharedList.addAll(loadedFromFile);
/*    */     
/* 43 */     for (ServerCfg server : sharedList) {
/* 44 */       String uuid = server.getServerId().toString();
/* 45 */       if (server.getUrl() != null && server.getUrl().length() > 0 && !storedIds.contains(uuid) && !deletedIds.contains(uuid)) {
/* 46 */         if (server.isDeleted()) {
/* 47 */           deletedIds.add(uuid); continue;
/* 48 */         }  if (!nonShared.contains(server.getServerId().getId())) {
/* 49 */           newList.add(server);
/* 50 */           storedIds.add(uuid);
/*    */         } 
/*    */       } 
/*    */     } 
/* 54 */     return newList;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\SharedServerList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */