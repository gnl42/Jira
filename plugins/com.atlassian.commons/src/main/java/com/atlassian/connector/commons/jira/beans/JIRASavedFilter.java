package com.atlassian.connector.commons.jira.beans;

import java.net.URI;

public interface JIRASavedFilter extends JiraFilter {
  String getAuthor();
  
  String getProject();
  
  URI getSearchUrl();
  
  URI getViewUrl();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRASavedFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */