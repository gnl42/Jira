/*    */ package com.atlassian.theplugin.commons.fisheye;
/*    */ 
/*    */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*    */ import com.atlassian.connector.commons.fisheye.FishEyeServerFacade2;
/*    */ import com.atlassian.theplugin.commons.ServerType;
/*    */ import com.atlassian.theplugin.commons.fisheye.api.FishEyeSession;
/*    */ import com.atlassian.theplugin.commons.fisheye.api.model.FisheyePathHistoryItem;
/*    */ import com.atlassian.theplugin.commons.fisheye.api.rest.FishEyeRestSession;
/*    */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*    */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiMalformedUrlException;
/*    */ import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;
/*    */ import java.util.Collection;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FishEyeServerFacadeImpl
/*    */   implements FishEyeServerFacade2
/*    */ {
/*    */   private static FishEyeServerFacadeImpl instance;
/*    */   private final HttpSessionCallback callback;
/*    */   
/*    */   public FishEyeServerFacadeImpl(HttpSessionCallback callback) {
/* 23 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public void testServerConnection(ConnectionCfg serverCfg) throws RemoteApiException {
/* 27 */     FishEyeSession fishEyeSession = getSession(serverCfg);
/* 28 */     fishEyeSession.login(serverCfg.getUsername(), serverCfg.getPassword().toCharArray());
/*    */ 
/*    */     
/* 31 */     fishEyeSession.getRepositories();
/*    */     
/* 33 */     fishEyeSession.logout();
/*    */   }
/*    */   
/*    */   public ServerType getServerType() {
/* 37 */     return ServerType.FISHEYE_SERVER;
/*    */   }
/*    */   
/*    */   public static synchronized FishEyeServerFacadeImpl getInstance(HttpSessionCallback callback) {
/* 41 */     if (instance == null) {
/* 42 */       instance = new FishEyeServerFacadeImpl(callback);
/*    */     }
/*    */     
/* 45 */     return instance;
/*    */   }
/*    */   
/*    */   public FishEyeSession getSession(ConnectionCfg server) throws RemoteApiMalformedUrlException {
/* 49 */     return (FishEyeSession)new FishEyeRestSession(server, this.callback);
/*    */   }
/*    */ 
/*    */   
/*    */   public Collection<String> getRepositories(ConnectionCfg server) throws RemoteApiException {
/* 54 */     FishEyeSession fishEyeSession = getSession(server);
/*    */ 
/*    */     
/* 57 */     fishEyeSession.login(server.getUsername(), server.getPassword().toCharArray());
/* 58 */     Collection<String> repositories = fishEyeSession.getRepositories();
/* 59 */     fishEyeSession.logout();
/* 60 */     return repositories;
/*    */   }
/*    */ 
/*    */   
/*    */   public Collection<FisheyePathHistoryItem> getPathHistory(ConnectionCfg server, String repo, String path) throws RemoteApiException {
/* 65 */     FishEyeSession fishEyeSession = getSession(server);
/*    */ 
/*    */     
/* 68 */     fishEyeSession.login(server.getUsername(), server.getPassword().toCharArray());
/* 69 */     Collection<FisheyePathHistoryItem> items = fishEyeSession.getPathHistory(repo, path);
/* 70 */     fishEyeSession.logout();
/* 71 */     return items;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\fisheye\FishEyeServerFacadeImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */