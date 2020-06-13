package com.atlassian.theplugin.commons.util;

public interface HttpConfigurableAdapter {
  boolean isKeepProxyPassowrd();
  
  boolean isProxyAuthentication();
  
  boolean isUseHttpProxy();
  
  String getPlainProxyPassword();
  
  String getProxyLogin();
  
  int getProxyPort();
  
  String getProxyHost();
  
  Object getHTTPProxySettingsDialog();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\common\\util\HttpConfigurableAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */