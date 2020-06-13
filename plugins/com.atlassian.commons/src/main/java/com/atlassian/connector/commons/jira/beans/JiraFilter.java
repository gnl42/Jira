package com.atlassian.connector.commons.jira.beans;

import java.util.List;

public interface JiraFilter extends JIRAQueryFragment {
  String getJql();
  
  String getOldStyleQueryString();
  
  List<JIRAQueryFragment> getQueryFragments();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JiraFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */