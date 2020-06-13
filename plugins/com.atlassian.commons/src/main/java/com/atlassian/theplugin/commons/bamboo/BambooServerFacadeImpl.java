/*     */ package com.atlassian.theplugin.commons.bamboo;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.BambooServerFacade2;
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import com.atlassian.theplugin.commons.ServerType;
/*     */ import com.atlassian.theplugin.commons.bamboo.api.AutoRenewBambooSession;
/*     */ import com.atlassian.theplugin.commons.bamboo.api.BambooSession;
/*     */ import com.atlassian.theplugin.commons.bamboo.api.BambooSessionImpl;
/*     */ import com.atlassian.theplugin.commons.bamboo.api.LoginBambooSession;
/*     */ import com.atlassian.theplugin.commons.cfg.SubscribedPlan;
/*     */ import com.atlassian.theplugin.commons.exception.ServerPasswordNotProvidedException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.ProductSession;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginFailedException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiMalformedUrlException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;
/*     */ import com.atlassian.theplugin.commons.util.Logger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import org.jetbrains.annotations.NotNull;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public final class BambooServerFacadeImpl
/*     */   implements BambooServerFacade2
/*     */ {
/*  51 */   private final Map<String, BambooSession> sessions = new WeakHashMap<String, BambooSession>();
/*     */   
/*     */   private final Logger logger;
/*     */   
/*     */   private final BambooSessionFactory bambooSessionFactory;
/*     */   
/*     */   private final HttpSessionCallback callback;
/*     */   
/*     */   public BambooServerFacadeImpl(Logger loger, @NotNull BambooSessionFactory factory, @NotNull HttpSessionCallback callback) {
/*  60 */     this.logger = loger;
/*  61 */     this.callback = callback;
/*  62 */     this.bambooSessionFactory = factory;
/*     */   }
/*     */   
/*     */   public BambooServerFacadeImpl(Logger loger, HttpSessionCallback callback) {
/*  66 */     this(loger, new SimpleBambooSessionFactory(loger), callback);
/*     */   }
/*     */   
/*     */   public ServerType getServerType() {
/*  70 */     return ServerType.BAMBOO_SERVER;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized BambooSession getSession(ConnectionCfg server) throws RemoteApiException {
/*  75 */     String key = String.valueOf(server.getUsername()) + server.getUrl() + server.getPassword() + server.getId();
/*  76 */     BambooSession session = this.sessions.get(key);
/*  77 */     if (session == null) {
/*  78 */       session = this.bambooSessionFactory.createSession(server, this.callback);
/*  79 */       this.sessions.put(key, session);
/*     */     } 
/*  81 */     if (!session.isLoggedIn()) {
/*  82 */       session.login(server.getUsername(), server.getPassword().toCharArray());
/*     */     }
/*  84 */     return session;
/*     */   }
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
/*     */   public void testServerConnection(ConnectionCfg httpConnectionCfg) throws RemoteApiException {
/*  98 */     ProductSession apiHandler = this.bambooSessionFactory.createLoginSession(httpConnectionCfg, this.callback);
/*  99 */     apiHandler.login(httpConnectionCfg.getUsername(), httpConnectionCfg.getPassword().toCharArray());
/* 100 */     apiHandler.logout();
/*     */   }
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
/*     */   public Collection<BambooProject> getProjectList(ConnectionCfg bambooServer) throws ServerPasswordNotProvidedException, RemoteApiException {
/*     */     try {
/* 114 */       return getSession(bambooServer).listProjectNames();
/* 115 */     } catch (RemoteApiException e) {
/* 116 */       this.logger.error("Bamboo exception: " + e.getMessage(), (Throwable)e);
/* 117 */       throw e;
/*     */     } 
/*     */   }
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
/*     */   public Collection<BambooPlan> getPlanList(ConnectionCfg bambooServer) throws ServerPasswordNotProvidedException, RemoteApiException {
/* 131 */     BambooSession api = getSession(bambooServer);
/* 132 */     return api.getPlanList();
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Collection<BambooBuild> getSubscribedPlansResultsOld(ConnectionCfg bambooServer, Collection<SubscribedPlan> plans, boolean isUseFavourities, int timezoneOffset) throws ServerPasswordNotProvidedException, RemoteApiException {
/* 160 */     Collection<BambooBuild> builds = new ArrayList<BambooBuild>();
/*     */     
/* 162 */     BambooSession api = null;
/*     */     try {
/* 164 */       api = getSession(bambooServer);
/* 165 */       Throwable connectionError = null;
/* 166 */     } catch (RemoteApiLoginFailedException e) {
/* 167 */       if (bambooServer.getPassword().length() > 0) {
/* 168 */         this.logger.error("Bamboo login exception: " + e.getMessage());
/* 169 */         RemoteApiLoginFailedException remoteApiLoginFailedException = e;
/* 170 */         throw e;
/*     */       } 
/* 172 */       throw new ServerPasswordNotProvidedException(e);
/*     */     }
/* 174 */     catch (RemoteApiLoginException e) {
/* 175 */       throw e;
/* 176 */     } catch (RemoteApiException e) {
/* 177 */       this.logger.error("Bamboo exception: " + e.getMessage());
/* 178 */       RemoteApiException remoteApiException1 = e;
/* 179 */       if (!isUseFavourities) {
/* 180 */         for (SubscribedPlan plan : plans) {
/* 181 */           builds.add(constructBuildErrorInfo(bambooServer, plan.getKey(), null, (remoteApiException1 == null) ? "" : 
/* 182 */                 remoteApiException1.getMessage(), (Throwable)remoteApiException1));
/*     */         }
/*     */       }
/* 185 */       return builds;
/*     */     } 
/*     */     
/* 188 */     return api.getSubscribedPlansResults(plans, isUseFavourities, timezoneOffset);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<BambooBuild> getSubscribedPlansResults(ConnectionCfg connectionCfg, Collection<SubscribedPlan> plans, boolean isUseFavourities, boolean isShowBranches, boolean myBranchesOnly, int timezoneOffset) throws ServerPasswordNotProvidedException, RemoteApiException {
/* 194 */     BambooSession session = getSession(connectionCfg);
/* 195 */     if (session.getBamboBuildNumber() >= 1401) {
/* 196 */       return getSubscribedPlansResultsNew(
/* 197 */           connectionCfg, plans, isUseFavourities, (
/* 198 */           isShowBranches && session.getBamboBuildNumber() >= 3600), 
/* 199 */           myBranchesOnly, 
/* 200 */           timezoneOffset);
/*     */     }
/* 202 */     return getSubscribedPlansResultsOld(connectionCfg, plans, isUseFavourities, timezoneOffset);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Collection<BambooBuild> getSubscribedPlansResultsNew(ConnectionCfg bambooServer, Collection<SubscribedPlan> plans, boolean isUseFavourities, boolean isShowBranches, boolean myBranchesOnly, int timezoneOffset) throws ServerPasswordNotProvidedException, RemoteApiLoginException {
/*     */     RemoteApiException remoteApiException;
/* 229 */     Collection<BambooBuild> builds = new ArrayList<BambooBuild>();
/*     */ 
/*     */     
/* 232 */     BambooSession api = null;
/*     */     try {
/* 234 */       api = getSession(bambooServer);
/* 235 */       Throwable connectionError = null;
/* 236 */     } catch (RemoteApiLoginFailedException e) {
/* 237 */       if (bambooServer.getPassword().length() > 0) {
/* 238 */         this.logger.error("Bamboo login exception: " + e.getMessage());
/* 239 */         RemoteApiLoginFailedException remoteApiLoginFailedException = e;
/* 240 */         throw e;
/*     */       } 
/* 242 */       throw new ServerPasswordNotProvidedException(e);
/*     */     }
/* 244 */     catch (RemoteApiLoginException e) {
/* 245 */       throw e;
/* 246 */     } catch (RemoteApiException e) {
/* 247 */       this.logger.error("Bamboo exception: " + e.getMessage());
/* 248 */       remoteApiException = e;
/*     */     } 
/*     */     
/* 251 */     Collection<BambooPlan> plansForServer = null;
/*     */     try {
/* 253 */       plansForServer = getPlanList(bambooServer);
/* 254 */     } catch (RemoteApiException remoteApiException1) {
/*     */       
/* 256 */       this.logger.warn("Cannot fetch plan list from Bamboo server [" + bambooServer.getUrl() + "]");
/*     */     } 
/*     */     
/* 259 */     if (isUseFavourities) {
/* 260 */       if (plansForServer != null) {
/* 261 */         for (BambooPlan bambooPlan : plansForServer) {
/* 262 */           if (bambooPlan.isFavourite()) {
/* 263 */             String key = bambooPlan.getKey();
/* 264 */             if (api != null && api.isLoggedIn()) {
/*     */               try {
/* 266 */                 if (isShowBranches) {
/* 267 */                   Collection<String> branches = api.getBranchKeys(key, isUseFavourities, myBranchesOnly);
/* 268 */                   branches.add(key);
/* 269 */                   for (String branch : branches) {
/* 270 */                     BambooBuild bambooBuild = api.getLatestBuildForPlanNew(branch, key.equals(branch) ? null : key, bambooPlan.isEnabled(), timezoneOffset);
/* 271 */                     builds.add(bambooBuild);
/*     */                   }  continue;
/*     */                 } 
/* 274 */                 BambooBuild buildInfo = api.getLatestBuildForPlanNew(key, null, bambooPlan.isEnabled(), timezoneOffset);
/* 275 */                 builds.add(buildInfo);
/*     */               }
/* 277 */               catch (RemoteApiException remoteApiException1) {
/*     */                 
/* 279 */                 this.logger.warn("Cannot fetch latest build for plan [" + key + 
/* 280 */                     "] from Bamboo server [" + bambooServer.getUrl() + "]");
/*     */               }  continue;
/*     */             } 
/* 283 */             builds.add(constructBuildErrorInfo(bambooServer, key, 
/* 284 */                   bambooPlan.getName(), (remoteApiException == null) ? "" : 
/* 285 */                   remoteApiException.getMessage(), (Throwable)remoteApiException));
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } else {
/*     */       
/* 291 */       for (SubscribedPlan plan : plans) {
/* 292 */         String key = plan.getKey();
/* 293 */         if (api != null && api.isLoggedIn()) {
/*     */           try {
/* 295 */             Boolean planEnabled = (plansForServer != null) ? 
/* 296 */               BambooSessionImpl.isPlanEnabled(plansForServer, key) : 
/* 297 */               null;
/* 298 */             if (isShowBranches) {
/* 299 */               Collection<String> branches = api.getBranchKeys(key, isUseFavourities, myBranchesOnly);
/* 300 */               branches.add(key);
/* 301 */               for (String branch : branches) {
/* 302 */                 BambooBuild bambooBuild = api.getLatestBuildForPlanNew(branch, key.equals(branch) ? null : key, (planEnabled != null && planEnabled.booleanValue()), timezoneOffset);
/* 303 */                 builds.add(bambooBuild);
/*     */               }  continue;
/*     */             } 
/* 306 */             BambooBuild buildInfo = api.getLatestBuildForPlanNew(key, null, (planEnabled != null && planEnabled.booleanValue()), timezoneOffset);
/* 307 */             builds.add(buildInfo);
/*     */           }
/* 309 */           catch (RemoteApiException remoteApiException1) {
/*     */ 
/*     */             
/* 312 */             this.logger.warn("Cannot fetch latest build for plan [" + key + "] from Bamboo server [" + 
/* 313 */                 bambooServer.getUrl() + "]");
/*     */           }  continue;
/*     */         } 
/* 316 */         builds.add(constructBuildErrorInfo(bambooServer, key, null, (remoteApiException == null) ? "" : 
/* 317 */               remoteApiException.getMessage(), (Throwable)remoteApiException));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 322 */     return builds;
/*     */   }
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
/*     */   
/*     */   public Collection<BambooBuild> getRecentBuildsForPlans(ConnectionCfg bambooServer, String planKey, int timezoneOffset) throws ServerPasswordNotProvidedException {
/*     */     BambooSession api;
/* 344 */     Collection<BambooBuild> builds = new ArrayList<BambooBuild>();
/*     */ 
/*     */     
/*     */     try {
/* 348 */       api = getSession(bambooServer);
/* 349 */     } catch (RemoteApiLoginFailedException e) {
/*     */       
/* 351 */       if (bambooServer.getPassword().length() > 0) {
/* 352 */         this.logger.error("Bamboo login exception: " + e.getMessage());
/* 353 */         builds.add(constructBuildErrorInfo(bambooServer, planKey, null, e.getMessage(), (Throwable)e));
/* 354 */         return builds;
/*     */       } 
/* 356 */       throw new ServerPasswordNotProvidedException(e);
/*     */     }
/* 358 */     catch (RemoteApiException e) {
/* 359 */       this.logger.error("Bamboo exception: " + e.getMessage());
/* 360 */       builds.add(constructBuildErrorInfo(bambooServer, planKey, null, e.getMessage(), (Throwable)e));
/* 361 */       return builds;
/*     */     } 
/*     */     
/*     */     try {
/* 365 */       builds.addAll(api.getRecentBuildsForPlan(planKey, timezoneOffset));
/* 366 */     } catch (RemoteApiException e) {
/* 367 */       this.logger.error("Bamboo exception: " + e.getMessage());
/* 368 */       builds.add(constructBuildErrorInfo(bambooServer, planKey, null, e.getMessage(), (Throwable)e));
/*     */     } 
/*     */     
/* 371 */     return builds;
/*     */   }
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
/*     */   public Collection<BambooBuild> getRecentBuildsForUser(ConnectionCfg bambooServer, int timezoneOffset) throws ServerPasswordNotProvidedException {
/*     */     BambooSession api;
/* 392 */     Collection<BambooBuild> builds = new ArrayList<BambooBuild>();
/*     */ 
/*     */     
/*     */     try {
/* 396 */       api = getSession(bambooServer);
/* 397 */     } catch (RemoteApiLoginFailedException e) {
/* 398 */       if (bambooServer.getPassword().length() > 0) {
/* 399 */         this.logger.error("Bamboo login exception: " + e.getMessage());
/* 400 */         builds.add(constructBuildErrorInfo(bambooServer, "", null, e.getMessage(), (Throwable)e));
/* 401 */         return builds;
/*     */       } 
/* 403 */       throw new ServerPasswordNotProvidedException(e);
/*     */     }
/* 405 */     catch (RemoteApiException e) {
/* 406 */       this.logger.error("Bamboo exception: " + e.getMessage());
/* 407 */       builds.add(constructBuildErrorInfo(bambooServer, "", null, e.getMessage(), (Throwable)e));
/* 408 */       return builds;
/*     */     } 
/*     */     
/*     */     try {
/* 412 */       builds.addAll(api.getRecentBuildsForUser(timezoneOffset));
/* 413 */     } catch (RemoteApiException e) {
/* 414 */       this.logger.error("Bamboo exception: " + e.getMessage());
/* 415 */       builds.add(constructBuildErrorInfo(bambooServer, "", null, e.getMessage(), (Throwable)e));
/*     */     } 
/*     */     
/* 418 */     return builds;
/*     */   }
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
/*     */   public BuildDetails getBuildDetails(ConnectionCfg bambooServer, @NotNull String planKey, int buildNumber) throws ServerPasswordNotProvidedException, RemoteApiException {
/*     */     try {
/* 433 */       BambooSession api = getSession(bambooServer);
/* 434 */       return api.getBuildResultDetails(planKey, buildNumber);
/* 435 */     } catch (RemoteApiException e) {
/* 436 */       this.logger.info("Bamboo exception: " + e.getMessage());
/* 437 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BambooBuild getBuildForPlanAndNumber(ConnectionCfg bambooServer, @NotNull String planKey, int buildNumber, int timezoneOffset) throws ServerPasswordNotProvidedException, RemoteApiException {
/*     */     try {
/* 445 */       BambooSession api = getSession(bambooServer);
/* 446 */       return api.getBuildForPlanAndNumber(planKey, buildNumber, timezoneOffset);
/* 447 */     } catch (RemoteApiException e) {
/* 448 */       this.logger.info("Bamboo exception: " + e.getMessage());
/* 449 */       throw e;
/*     */     } 
/*     */   }
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
/*     */   public void addLabelToBuild(ConnectionCfg bambooServer, @NotNull String planKey, int buildNumber, String buildLabel) throws ServerPasswordNotProvidedException, RemoteApiException {
/*     */     try {
/* 465 */       BambooSession api = getSession(bambooServer);
/* 466 */       api.addLabelToBuild(planKey, buildNumber, buildLabel);
/* 467 */     } catch (RemoteApiException e) {
/* 468 */       this.logger.info("Bamboo exception: " + e.getMessage());
/* 469 */       throw e;
/*     */     } 
/*     */   }
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
/*     */   public void addCommentToBuild(ConnectionCfg bambooServer, @NotNull String planKey, int buildNumber, String buildComment) throws ServerPasswordNotProvidedException, RemoteApiException {
/*     */     try {
/* 485 */       BambooSession api = getSession(bambooServer);
/* 486 */       api.addCommentToBuild(planKey, buildNumber, buildComment);
/* 487 */     } catch (RemoteApiException e) {
/* 488 */       this.logger.info("Bamboo exception: " + e.getMessage());
/* 489 */       throw e;
/*     */     } 
/*     */   }
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
/*     */   public void executeBuild(ConnectionCfg bambooServer, @NotNull String buildKey) throws ServerPasswordNotProvidedException, RemoteApiException {
/*     */     try {
/* 505 */       BambooSession api = getSession(bambooServer);
/* 506 */       api.executeBuild(buildKey);
/* 507 */     } catch (RemoteApiException e) {
/* 508 */       this.logger.info("Bamboo exception: " + e.getMessage());
/* 509 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getBuildLogs(ConnectionCfg bambooServer, @NotNull String planKey, int buildNumber) throws ServerPasswordNotProvidedException, RemoteApiException {
/*     */     try {
/* 516 */       BambooSession api = getSession(bambooServer);
/* 517 */       return api.getBuildLogs(planKey, buildNumber);
/* 518 */     } catch (RemoteApiException e) {
/* 519 */       this.logger.info("Bamboo exception: " + e.getMessage());
/* 520 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<BuildIssue> getIssuesForBuild(ConnectionCfg bambooServer, @NotNull String planKey, int buildNumber) throws ServerPasswordNotProvidedException, RemoteApiException {
/*     */     try {
/* 527 */       BambooSession api = getSession(bambooServer);
/* 528 */       return api.getIssuesForBuild(planKey, buildNumber);
/* 529 */     } catch (RemoteApiException e) {
/* 530 */       this.logger.info("Bamboo exception: " + e.getMessage());
/* 531 */       throw e;
/*     */     } 
/*     */   }
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
/*     */   public Collection<String> getFavouritePlans(ConnectionCfg bambooServer) throws ServerPasswordNotProvidedException, RemoteApiException {
/*     */     try {
/* 548 */       return getSession(bambooServer).getFavouriteUserPlans();
/* 549 */     } catch (RemoteApiException e) {
/* 550 */       this.logger.error("Bamboo exception: " + e.getMessage());
/* 551 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private BambooBuild constructBuildErrorInfo(ConnectionCfg server, @NotNull String planKey, String planName, String message, Throwable exception) {
/* 557 */     return (new BambooBuildInfo.Builder(planKey, null, server, planName, null, BuildStatus.UNKNOWN)).errorMessage(
/* 558 */         message, exception).pollingTime(new Date()).build();
/*     */   }
/*     */   
/*     */   private static class SimpleBambooSessionFactory
/*     */     implements BambooSessionFactory {
/*     */     private final Logger logger;
/*     */     
/*     */     SimpleBambooSessionFactory(Logger logger) {
/* 566 */       this.logger = logger;
/*     */     }
/*     */ 
/*     */     
/*     */     public BambooSession createSession(ConnectionCfg serverData, HttpSessionCallback callback) throws RemoteApiException {
/* 571 */       return (BambooSession)new AutoRenewBambooSession(serverData, callback, this.logger);
/*     */     }
/*     */ 
/*     */     
/*     */     public ProductSession createLoginSession(ConnectionCfg serverData, HttpSessionCallback callback) throws RemoteApiMalformedUrlException {
/* 576 */       return (ProductSession)new LoginBambooSession(serverData, callback);
/*     */     }
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BambooServerFacadeImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */