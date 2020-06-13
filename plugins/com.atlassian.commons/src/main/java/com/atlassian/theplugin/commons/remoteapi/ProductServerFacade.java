package com.atlassian.theplugin.commons.remoteapi;

import com.atlassian.connector.commons.api.ConnectionCfg;
import com.atlassian.theplugin.commons.ServerType;

public interface ProductServerFacade {
  void testServerConnection(ConnectionCfg paramConnectionCfg) throws RemoteApiException;
  
  ServerType getServerType();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\remoteapi\ProductServerFacade.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */