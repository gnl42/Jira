package com.atlassian.theplugin.commons;

import java.awt.Component;

public interface UiTask {
  void run() throws Exception;
  
  void onSuccess();
  
  void onError();
  
  String getLastAction();
  
  Component getComponent();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\UiTask.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */