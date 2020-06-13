package com.atlassian.connector.commons.api;

import com.atlassian.theplugin.commons.bamboo.BambooBuild;
import com.atlassian.theplugin.commons.bamboo.BambooPlan;
import com.atlassian.theplugin.commons.bamboo.BambooProject;
import com.atlassian.theplugin.commons.bamboo.BuildDetails;
import com.atlassian.theplugin.commons.bamboo.BuildIssue;
import com.atlassian.theplugin.commons.bamboo.api.BambooSession;
import com.atlassian.theplugin.commons.cfg.SubscribedPlan;
import com.atlassian.theplugin.commons.exception.ServerPasswordNotProvidedException;
import com.atlassian.theplugin.commons.remoteapi.ProductServerFacade;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public interface BambooServerFacade2 extends ProductServerFacade {
  BambooSession getSession(ConnectionCfg paramConnectionCfg) throws RemoteApiException;
  
  Collection<BambooProject> getProjectList(ConnectionCfg paramConnectionCfg) throws ServerPasswordNotProvidedException, RemoteApiException;
  
  Collection<BambooPlan> getPlanList(ConnectionCfg paramConnectionCfg) throws ServerPasswordNotProvidedException, RemoteApiException;
  
  Collection<BambooBuild> getSubscribedPlansResults(ConnectionCfg paramConnectionCfg, Collection<SubscribedPlan> paramCollection, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt) throws ServerPasswordNotProvidedException, RemoteApiException;
  
  BuildDetails getBuildDetails(ConnectionCfg paramConnectionCfg, @NotNull String paramString, int paramInt) throws ServerPasswordNotProvidedException, RemoteApiException;
  
  void addLabelToBuild(ConnectionCfg paramConnectionCfg, @NotNull String paramString1, int paramInt, String paramString2) throws ServerPasswordNotProvidedException, RemoteApiException;
  
  void addCommentToBuild(ConnectionCfg paramConnectionCfg, @NotNull String paramString1, int paramInt, String paramString2) throws ServerPasswordNotProvidedException, RemoteApiException;
  
  void executeBuild(ConnectionCfg paramConnectionCfg, @NotNull String paramString) throws ServerPasswordNotProvidedException, RemoteApiException;
  
  String getBuildLogs(ConnectionCfg paramConnectionCfg, @NotNull String paramString, int paramInt) throws ServerPasswordNotProvidedException, RemoteApiException;
  
  Collection<BambooBuild> getRecentBuildsForPlans(ConnectionCfg paramConnectionCfg, String paramString, int paramInt) throws ServerPasswordNotProvidedException;
  
  Collection<BambooBuild> getRecentBuildsForUser(ConnectionCfg paramConnectionCfg, int paramInt) throws ServerPasswordNotProvidedException;
  
  BambooBuild getBuildForPlanAndNumber(ConnectionCfg paramConnectionCfg, @NotNull String paramString, int paramInt1, int paramInt2) throws ServerPasswordNotProvidedException, RemoteApiException;
  
  Collection<BuildIssue> getIssuesForBuild(ConnectionCfg paramConnectionCfg, @NotNull String paramString, int paramInt) throws ServerPasswordNotProvidedException, RemoteApiException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\api\BambooServerFacade2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */