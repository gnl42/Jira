package com.atlassian.connector.commons.jira.soap;

import com.atlassian.connector.commons.api.ConnectionCfg;
import java.rmi.Remote;

public interface AxisSessionCallback {
  void configureRemoteService(Remote paramRemote, ConnectionCfg paramConnectionCfg);
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\AxisSessionCallback.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */