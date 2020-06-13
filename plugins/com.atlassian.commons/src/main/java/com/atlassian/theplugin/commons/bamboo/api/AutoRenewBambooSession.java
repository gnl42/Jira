/*     */ package com.atlassian.theplugin.commons.bamboo.api;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import com.atlassian.theplugin.commons.bamboo.BambooBuild;
/*     */ import com.atlassian.theplugin.commons.bamboo.BambooJobImpl;
/*     */ import com.atlassian.theplugin.commons.bamboo.BambooPlan;
/*     */ import com.atlassian.theplugin.commons.bamboo.BambooProject;
/*     */ import com.atlassian.theplugin.commons.bamboo.BuildDetails;
/*     */ import com.atlassian.theplugin.commons.bamboo.BuildIssue;
/*     */ import com.atlassian.theplugin.commons.cfg.SubscribedPlan;
/*     */ import com.atlassian.theplugin.commons.exception.ServerPasswordNotProvidedException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiSessionExpiredException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;
/*     */ import com.atlassian.theplugin.commons.util.Logger;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
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
/*     */ public class AutoRenewBambooSession
/*     */   implements BambooSession
/*     */ {
/*     */   private final BambooSession delegate;
/*     */   private String userName;
/*     */   private char[] password;
/*     */   
/*     */   public AutoRenewBambooSession(ConnectionCfg serverCfg, HttpSessionCallback callback, Logger logger) throws RemoteApiException {
/*  46 */     this.delegate = new BambooSessionImpl(serverCfg, callback, logger);
/*     */   }
/*     */   
/*     */   AutoRenewBambooSession(BambooSession bambooSession) throws RemoteApiException {
/*  50 */     this.delegate = bambooSession;
/*     */   }
/*     */   
/*     */   public void addCommentToBuild(@NotNull String planKey, int buildNumber, String buildComment) throws RemoteApiException {
/*     */     try {
/*  55 */       this.delegate.addCommentToBuild(planKey, buildNumber, buildComment);
/*  56 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/*  57 */       this.delegate.login(this.userName, this.password);
/*  58 */       this.delegate.addCommentToBuild(planKey, buildNumber, buildComment);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void executeBuild(@NotNull String buildKey) throws RemoteApiException {
/*     */     try {
/*  64 */       this.delegate.executeBuild(buildKey);
/*  65 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/*  66 */       this.delegate.login(this.userName, this.password);
/*  67 */       this.delegate.executeBuild(buildKey);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addLabelToBuild(@NotNull String planKey, int buildNumber, String buildLabel) throws RemoteApiException {
/*     */     try {
/*  73 */       this.delegate.addLabelToBuild(planKey, buildNumber, buildLabel);
/*  74 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/*  75 */       this.delegate.login(this.userName, this.password);
/*  76 */       this.delegate.addLabelToBuild(planKey, buildNumber, buildLabel);
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public BuildDetails getBuildResultDetails(@NotNull String planKey, int buildNumber) throws RemoteApiException {
/*     */     try {
/*  83 */       return this.delegate.getBuildResultDetails(planKey, buildNumber);
/*  84 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/*  85 */       this.delegate.login(this.userName, this.password);
/*  86 */       return this.delegate.getBuildResultDetails(planKey, buildNumber);
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public List<String> getFavouriteUserPlans() throws RemoteApiException {
/*     */     try {
/*  93 */       return this.delegate.getFavouriteUserPlans();
/*  94 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/*  95 */       this.delegate.login(this.userName, this.password);
/*  96 */       return this.delegate.getFavouriteUserPlans();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public BambooBuild getLatestBuildForPlan(@NotNull String planKey, int timezoneOffset) throws RemoteApiException {
/*     */     try {
/* 104 */       return this.delegate.getLatestBuildForPlan(planKey, timezoneOffset);
/* 105 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 106 */       this.delegate.login(this.userName, this.password);
/* 107 */       return this.delegate.getLatestBuildForPlan(planKey, timezoneOffset);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public BambooBuild getBuildForPlanAndNumber(@NotNull String planKey, int buildNumber, int timezoneOffset) throws RemoteApiException {
/*     */     try {
/* 115 */       return this.delegate.getBuildForPlanAndNumber(planKey, buildNumber, timezoneOffset);
/* 116 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 117 */       this.delegate.login(this.userName, this.password);
/* 118 */       return this.delegate.getBuildForPlanAndNumber(planKey, buildNumber, timezoneOffset);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isLoggedIn() throws RemoteApiLoginException {
/* 123 */     return this.delegate.isLoggedIn();
/*     */   }
/*     */   
/*     */   public String getBuildLogs(@NotNull String planKey, int buildNumber) throws RemoteApiException {
/*     */     try {
/* 128 */       return this.delegate.getBuildLogs(planKey, buildNumber);
/* 129 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 130 */       this.delegate.login(this.userName, this.password);
/* 131 */       return this.delegate.getBuildLogs(planKey, buildNumber);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<BambooBuild> getRecentBuildsForPlan(@NotNull String planKey, int timezoneOffset) throws RemoteApiException {
/*     */     try {
/* 138 */       return this.delegate.getRecentBuildsForPlan(planKey, timezoneOffset);
/* 139 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 140 */       this.delegate.login(this.userName, this.password);
/* 141 */       return this.delegate.getRecentBuildsForPlan(planKey, timezoneOffset);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<BambooBuild> getRecentBuildsForUser(int timezoneOffset) throws RemoteApiException {
/*     */     try {
/* 148 */       return this.delegate.getRecentBuildsForUser(timezoneOffset);
/* 149 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 150 */       this.delegate.login(this.userName, this.password);
/* 151 */       return this.delegate.getRecentBuildsForUser(timezoneOffset);
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Collection<BuildIssue> getIssuesForBuild(@NotNull String planKey, int buildNumber) throws RemoteApiException {
/*     */     try {
/* 158 */       return this.delegate.getIssuesForBuild(planKey, buildNumber);
/* 159 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 160 */       this.delegate.login(this.userName, this.password);
/* 161 */       return this.delegate.getIssuesForBuild(planKey, buildNumber);
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public BambooPlan getPlanDetails(@NotNull String planKey) throws RemoteApiException {
/*     */     try {
/* 168 */       return this.delegate.getPlanDetails(planKey);
/* 169 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 170 */       this.delegate.login(this.userName, this.password);
/* 171 */       return this.delegate.getPlanDetails(planKey);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public BambooBuild getLatestBuildForPlanNew(@NotNull String planKey, @Nullable String masterPlanKey, boolean isPlanEnabled, int timezoneOffset) throws RemoteApiException {
/*     */     try {
/* 179 */       return this.delegate.getLatestBuildForPlanNew(planKey, masterPlanKey, isPlanEnabled, timezoneOffset);
/* 180 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 181 */       this.delegate.login(this.userName, this.password);
/* 182 */       return this.delegate.getLatestBuildForPlanNew(planKey, masterPlanKey, isPlanEnabled, timezoneOffset);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public Collection<BambooPlan> getPlanList() throws ServerPasswordNotProvidedException, RemoteApiException {
/*     */     try {
/* 190 */       return this.delegate.getPlanList();
/* 191 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 192 */       this.delegate.login(this.userName, this.password);
/* 193 */       return this.delegate.getPlanList();
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public List<BambooProject> listProjectNames() throws RemoteApiException {
/*     */     try {
/* 200 */       return this.delegate.listProjectNames();
/* 201 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 202 */       this.delegate.login(this.userName, this.password);
/* 203 */       return this.delegate.listProjectNames();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void login(String name, char[] aPassword) throws RemoteApiLoginException {
/* 208 */     this.userName = name;
/* 209 */     this.password = new char[aPassword.length];
/* 210 */     System.arraycopy(aPassword, 0, this.password, 0, aPassword.length);
/* 211 */     this.delegate.login(name, aPassword);
/*     */   }
/*     */   
/*     */   public void logout() {
/* 215 */     this.delegate.logout();
/*     */   }
/*     */   
/*     */   public int getBamboBuildNumber() throws RemoteApiException {
/*     */     try {
/* 220 */       return this.delegate.getBamboBuildNumber();
/* 221 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 222 */       this.delegate.login(this.userName, this.password);
/* 223 */       return this.delegate.getBamboBuildNumber();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public Collection<BambooBuild> getSubscribedPlansResults(Collection<SubscribedPlan> plans, boolean isUseFavourities, int timezoneOffset) throws RemoteApiException {
/*     */     try {
/* 231 */       return this.delegate.getSubscribedPlansResults(plans, isUseFavourities, timezoneOffset);
/* 232 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 233 */       this.delegate.login(this.userName, this.password);
/* 234 */       return this.delegate.getSubscribedPlansResults(plans, isUseFavourities, timezoneOffset);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<BambooJobImpl> getJobsForPlan(String planKey) throws RemoteApiException {
/*     */     try {
/* 240 */       return this.delegate.getJobsForPlan(planKey);
/* 241 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 242 */       this.delegate.login(this.userName, this.password);
/* 243 */       return this.delegate.getJobsForPlan(planKey);
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Collection<String> getBranchKeys(String planKey, boolean useFavourites, boolean myBranchesOnly) throws RemoteApiException {
/*     */     try {
/* 250 */       return this.delegate.getBranchKeys(planKey, useFavourites, myBranchesOnly);
/* 251 */     } catch (RemoteApiSessionExpiredException remoteApiSessionExpiredException) {
/* 252 */       this.delegate.login(this.userName, this.password);
/* 253 */       return this.delegate.getBranchKeys(planKey, useFavourites, myBranchesOnly);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\api\AutoRenewBambooSession.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */