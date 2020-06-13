package com.atlassian.theplugin.commons.cfg;

import com.atlassian.theplugin.commons.remoteapi.ServerData;

public abstract class ConfigurationListenerAdapter implements ConfigurationListener {
  public void configurationUpdated(ProjectConfiguration aProjectConfiguration) {}
  
  public void projectUnregistered() {}
  
  public void serverDataChanged(ServerData serverData) {}
  
  public void serverConnectionDataChanged(ServerId serverId) {}
  
  public void serverNameChanged(ServerId serverId) {}
  
  public void serverAdded(ServerData serverData) {}
  
  public void serverRemoved(ServerData serverData) {}
  
  public void serverEnabled(ServerData serverData) {}
  
  public void serverDisabled(ServerId serverId) {}
  
  public void jiraServersChanged(ProjectConfiguration newConfiguration) {}
  
  public void bambooServersChanged(ProjectConfiguration newConfiguration) {}
  
  public void crucibleServersChanged(ProjectConfiguration newConfiguration) {}
  
  public void fisheyeServersChanged(ProjectConfiguration newConfiguration) {}
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\ConfigurationListenerAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */