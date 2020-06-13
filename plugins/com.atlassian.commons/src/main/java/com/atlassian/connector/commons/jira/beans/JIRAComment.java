package com.atlassian.connector.commons.jira.beans;

import java.util.Calendar;

public interface JIRAComment {
  String getId();
  
  String getAuthor();
  
  String getAuthorFullName();
  
  void setAuthorFullName(String paramString);
  
  String getBody();
  
  Calendar getCreationDate();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAComment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */