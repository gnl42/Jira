package com.atlassian.theplugin.commons.cfg;

import com.atlassian.theplugin.commons.remoteapi.ServerData;

public interface ConfigurationListener {
  void configurationUpdated(ProjectConfiguration paramProjectConfiguration);
  
  void projectUnregistered();
  
  void serverConnectionDataChanged(ServerId paramServerId);
  
  void serverNameChanged(ServerId paramServerId);
  
  void serverAdded(ServerData paramServerData);
  
  void serverRemoved(ServerData paramServerData);
  
  void serverEnabled(ServerData paramServerData);
  
  void serverDisabled(ServerId paramServerId);
  
  void serverDataChanged(ServerData paramServerData);
  
  void jiraServersChanged(ProjectConfiguration paramProjectConfiguration);
  
  void bambooServersChanged(ProjectConfiguration paramProjectConfiguration);
  
  void crucibleServersChanged(ProjectConfiguration paramProjectConfiguration);
  
  void fisheyeServersChanged(ProjectConfiguration paramProjectConfiguration);
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\ConfigurationListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */