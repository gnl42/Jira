package com.atlassian.theplugin.commons.configuration;

import com.atlassian.theplugin.commons.util.HttpConfigurableAdapter;

public interface PluginConfiguration {
  void setConfiguration(PluginConfiguration paramPluginConfiguration);
  
  GeneralConfigurationBean getGeneralConfigurationData();
  
  void setGeneralConfigurationData(GeneralConfigurationBean paramGeneralConfigurationBean);
  
  void transientSetHttpConfigurable(HttpConfigurableAdapter paramHttpConfigurableAdapter);
  
  HttpConfigurableAdapter transientGetHttpConfigurable();
  
  BambooConfigurationBean getBambooConfigurationData();
  
  CrucibleConfigurationBean getCrucibleConfigurationData();
  
  JiraConfigurationBean getJIRAConfigurationData();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\configuration\PluginConfiguration.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */