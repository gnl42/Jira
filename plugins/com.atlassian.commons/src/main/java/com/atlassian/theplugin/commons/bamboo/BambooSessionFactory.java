package com.atlassian.theplugin.commons.bamboo;

import com.atlassian.connector.commons.api.ConnectionCfg;
import com.atlassian.theplugin.commons.bamboo.api.BambooSession;
import com.atlassian.theplugin.commons.remoteapi.ProductSession;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiMalformedUrlException;
import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;

public interface BambooSessionFactory {
  BambooSession createSession(ConnectionCfg paramConnectionCfg, HttpSessionCallback paramHttpSessionCallback) throws RemoteApiException;
  
  ProductSession createLoginSession(ConnectionCfg paramConnectionCfg, HttpSessionCallback paramHttpSessionCallback) throws RemoteApiMalformedUrlException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BambooSessionFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */