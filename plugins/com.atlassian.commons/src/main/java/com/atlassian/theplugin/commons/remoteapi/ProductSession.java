package com.atlassian.theplugin.commons.remoteapi;

public interface ProductSession {
  void login(String paramString, char[] paramArrayOfchar) throws RemoteApiLoginException;
  
  void logout();
  
  boolean isLoggedIn() throws RemoteApiLoginException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\remoteapi\ProductSession.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */