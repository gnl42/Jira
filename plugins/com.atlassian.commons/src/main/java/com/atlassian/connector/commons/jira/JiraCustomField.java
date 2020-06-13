package com.atlassian.connector.commons.jira;

import java.util.List;

public interface JiraCustomField {
  String getId();
  
  JiraCustomFieldImpl.BasicKeyType getTypeKey();
  
  List<String> getValues();
  
  String getName();
  
  String getFormattedValue();
  
  boolean isSupported();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JiraCustomField.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */