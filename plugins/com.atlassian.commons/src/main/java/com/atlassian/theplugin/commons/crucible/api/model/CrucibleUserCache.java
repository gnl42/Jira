package com.atlassian.theplugin.commons.crucible.api.model;

import com.atlassian.connector.commons.api.ConnectionCfg;
import com.atlassian.connector.commons.crucible.CrucibleServerFacade2;
import org.jetbrains.annotations.NotNull;

public interface CrucibleUserCache {
  User getUser(@NotNull CrucibleServerFacade2 paramCrucibleServerFacade2, ConnectionCfg paramConnectionCfg, String paramString, boolean paramBoolean);
  
  void addUser(ConnectionCfg paramConnectionCfg, User paramUser);
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\CrucibleUserCache.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */