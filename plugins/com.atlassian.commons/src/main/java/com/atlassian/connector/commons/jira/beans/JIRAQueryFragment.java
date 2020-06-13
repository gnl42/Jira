package com.atlassian.connector.commons.jira.beans;

import java.util.HashMap;

public interface JIRAQueryFragment {
  String getQueryStringFragment();
  
  long getId();
  
  String getName();
  
  HashMap<String, String> getMap();
  
  JIRAQueryFragment getClone();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAQueryFragment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */