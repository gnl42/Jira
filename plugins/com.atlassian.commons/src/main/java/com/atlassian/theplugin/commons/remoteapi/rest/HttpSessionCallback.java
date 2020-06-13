package com.atlassian.theplugin.commons.remoteapi.rest;

import com.atlassian.connector.commons.api.ConnectionCfg;
import com.atlassian.theplugin.commons.exception.HttpProxySettingsException;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;

public interface HttpSessionCallback {
  HttpClient getHttpClient(ConnectionCfg paramConnectionCfg) throws HttpProxySettingsException;
  
  void configureHttpMethod(AbstractHttpSession paramAbstractHttpSession, HttpMethod paramHttpMethod);
  
  void disposeClient(ConnectionCfg paramConnectionCfg);
  
  Cookie[] getCookiesHeaders(ConnectionCfg paramConnectionCfg);
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\remoteapi\rest\HttpSessionCallback.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */