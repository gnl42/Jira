package com.atlassian.connector.cfg;

import com.atlassian.theplugin.commons.ServerType;
import com.atlassian.theplugin.commons.bamboo.BambooServerData;
import com.atlassian.theplugin.commons.cfg.ConfigurationListener;
import com.atlassian.theplugin.commons.cfg.ServerCfg;
import com.atlassian.theplugin.commons.cfg.ServerId;
import com.atlassian.theplugin.commons.jira.JiraServerData;
import com.atlassian.theplugin.commons.remoteapi.ServerData;
import java.util.Collection;
import org.jetbrains.annotations.Nullable;

public interface ProjectCfgManager {
  @Nullable
  JiraServerData getDefaultJiraServer();
  
  @Nullable
  ServerData getDefaultCrucibleServer();
  
  @Nullable
  ServerData getDefaultFishEyeServer();
  
  String getDefaultCrucibleRepo();
  
  String getDefaultCrucibleProject();
  
  String getDefaultFishEyeRepo();
  
  String getFishEyeProjectPath();
  
  ServerData findServer(String paramString, Collection<ServerData> paramCollection);
  
  @Deprecated
  ServerCfg getServer(ServerId paramServerId);
  
  void addProjectConfigurationListener(ConfigurationListener paramConfigurationListener);
  
  boolean removeProjectConfigurationListener(ConfigurationListener paramConfigurationListener);
  
  boolean isDefaultJiraServerValid();
  
  Collection<ServerData> getAllFishEyeServerss();
  
  Collection<ServerData> getAllEnabledServerss(ServerType paramServerType);
  
  Collection<ServerData> getAllServerss(ServerType paramServerType);
  
  JiraServerData getJiraServerr(ServerId paramServerId);
  
  Collection<BambooServerData> getAllEnabledBambooServerss();
  
  ServerData getServerr(ServerId paramServerId);
  
  @Nullable
  ServerData getEnabledServerr(ServerId paramServerId);
  
  JiraServerData getEnabledJiraServerr(ServerId paramServerId);
  
  ServerData getCrucibleServerr(ServerId paramServerId);
  
  ServerData getEnabledCrucibleServerr(ServerId paramServerId);
  
  Collection<ServerData> getAllServerss();
  
  Collection<ServerData> getAllJiraServerss();
  
  Collection<ServerData> getAllCrucibleServerss();
  
  Collection<JiraServerData> getAllEnabledJiraServerss();
  
  Collection<ServerData> getAllEnabledCrucibleServerss();
  
  Collection<ServerData> getAllEnabledServerss();
  
  Collection<BambooServerData> getAllBambooServerss();
  
  @Deprecated
  Collection<ServerCfg> getAllEnabledServers(ServerType paramServerType);
  
  Collection<ServerData> getAllEnabledCrucibleServersContainingFisheye();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\cfg\ProjectCfgManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */