package com.atlassian.theplugin.commons.cfg;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PrivateConfigurationDao {
  @Nullable
  PrivateServerCfgInfo load(ServerId paramServerId) throws ServerCfgFactoryException;
  
  void save(@NotNull PrivateServerCfgInfo paramPrivateServerCfgInfo) throws ServerCfgFactoryException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\PrivateConfigurationDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */