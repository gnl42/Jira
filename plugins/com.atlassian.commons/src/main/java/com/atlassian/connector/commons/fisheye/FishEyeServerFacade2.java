package com.atlassian.connector.commons.fisheye;

import com.atlassian.connector.commons.api.ConnectionCfg;
import com.atlassian.theplugin.commons.exception.ServerPasswordNotProvidedException;
import com.atlassian.theplugin.commons.fisheye.api.FishEyeSession;
import com.atlassian.theplugin.commons.fisheye.api.model.FisheyePathHistoryItem;
import com.atlassian.theplugin.commons.remoteapi.ProductServerFacade;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
import java.util.Collection;

public interface FishEyeServerFacade2 extends ProductServerFacade {
  FishEyeSession getSession(ConnectionCfg paramConnectionCfg) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Collection<String> getRepositories(ConnectionCfg paramConnectionCfg) throws RemoteApiException;
  
  @Deprecated
  Collection<FisheyePathHistoryItem> getPathHistory(ConnectionCfg paramConnectionCfg, String paramString1, String paramString2) throws RemoteApiException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\fisheye\FishEyeServerFacade2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */