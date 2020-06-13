package com.atlassian.theplugin.commons.cfg;

import com.atlassian.theplugin.commons.ServerType;

public interface Server {
  ServerIdImpl getServerId();
  
  String getName();
  
  String getUrl();
  
  boolean isEnabled();
  
  boolean isUseDefaultCredentials();
  
  String getUsername();
  
  String getPassword();
  
  ServerType getServerType();
  
  boolean isDontUseBasicAuth();
  
  UserCfg getBasicHttpUser();
  
  boolean isShared();
  
  void setShared(boolean paramBoolean);
  
  boolean isUseSessionCookies();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\Server.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */