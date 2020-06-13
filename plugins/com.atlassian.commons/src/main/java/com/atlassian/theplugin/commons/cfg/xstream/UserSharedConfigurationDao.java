package com.atlassian.theplugin.commons.cfg.xstream;

import com.atlassian.theplugin.commons.cfg.ServerCfg;
import com.atlassian.theplugin.commons.cfg.ServerCfgFactoryException;
import com.atlassian.theplugin.commons.cfg.SharedServerList;
import java.util.Collection;

public interface UserSharedConfigurationDao {
  void save(SharedServerList paramSharedServerList, Collection<ServerCfg> paramCollection) throws ServerCfgFactoryException;
  
  SharedServerList load() throws ServerCfgFactoryException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\xstream\UserSharedConfigurationDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */