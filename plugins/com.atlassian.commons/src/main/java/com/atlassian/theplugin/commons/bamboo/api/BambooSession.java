package com.atlassian.theplugin.commons.bamboo.api;

import com.atlassian.theplugin.commons.bamboo.BambooBuild;
import com.atlassian.theplugin.commons.bamboo.BambooJobImpl;
import com.atlassian.theplugin.commons.bamboo.BambooPlan;
import com.atlassian.theplugin.commons.bamboo.BambooProject;
import com.atlassian.theplugin.commons.bamboo.BuildDetails;
import com.atlassian.theplugin.commons.bamboo.BuildIssue;
import com.atlassian.theplugin.commons.cfg.SubscribedPlan;
import com.atlassian.theplugin.commons.exception.ServerPasswordNotProvidedException;
import com.atlassian.theplugin.commons.remoteapi.ProductSession;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface BambooSession extends ProductSession {
  int getBamboBuildNumber() throws RemoteApiException;
  
  @NotNull
  List<BambooProject> listProjectNames() throws RemoteApiException;
  
  @NotNull
  Collection<BambooPlan> getPlanList() throws ServerPasswordNotProvidedException, RemoteApiException;
  
  @NotNull
  BambooBuild getLatestBuildForPlan(@NotNull String paramString, int paramInt) throws RemoteApiException;
  
  @NotNull
  BambooBuild getBuildForPlanAndNumber(@NotNull String paramString, int paramInt1, int paramInt2) throws RemoteApiException;
  
  @NotNull
  List<String> getFavouriteUserPlans() throws RemoteApiException;
  
  @NotNull
  Collection<BambooBuild> getSubscribedPlansResults(Collection<SubscribedPlan> paramCollection, boolean paramBoolean, int paramInt) throws RemoteApiException;
  
  @NotNull
  BuildDetails getBuildResultDetails(@NotNull String paramString, int paramInt) throws RemoteApiException;
  
  void addLabelToBuild(@NotNull String paramString1, int paramInt, String paramString2) throws RemoteApiException;
  
  void addCommentToBuild(@NotNull String paramString1, int paramInt, String paramString2) throws RemoteApiException;
  
  void executeBuild(@NotNull String paramString) throws RemoteApiException;
  
  String getBuildLogs(@NotNull String paramString, int paramInt) throws RemoteApiException;
  
  Collection<BambooBuild> getRecentBuildsForPlan(@NotNull String paramString, int paramInt) throws RemoteApiException;
  
  Collection<BambooBuild> getRecentBuildsForUser(int paramInt) throws RemoteApiException;
  
  @NotNull
  BambooBuild getLatestBuildForPlanNew(@NotNull String paramString1, @Nullable String paramString2, boolean paramBoolean, int paramInt) throws RemoteApiException;
  
  @NotNull
  Collection<BuildIssue> getIssuesForBuild(@NotNull String paramString, int paramInt) throws RemoteApiException;
  
  @NotNull
  BambooPlan getPlanDetails(@NotNull String paramString) throws RemoteApiException;
  
  List<BambooJobImpl> getJobsForPlan(String paramString) throws RemoteApiException;
  
  @NotNull
  Collection<String> getBranchKeys(String paramString, boolean paramBoolean1, boolean paramBoolean2) throws RemoteApiException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\api\BambooSession.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */