package com.atlassian.connector.commons.jira;

import com.atlassian.connector.commons.api.ConnectionCfg;
import com.atlassian.connector.commons.jira.beans.JIRASavedFilter;
import com.atlassian.connector.commons.jira.beans.JiraFilter;
import com.atlassian.connector.commons.jira.rss.JIRAException;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
import com.atlassian.theplugin.commons.remoteapi.jira.JiraCaptchaRequiredException;
import java.util.List;

public interface JIRASessionPartTwo {
  List<JIRAIssue> getIssues(JiraFilter paramJiraFilter, String paramString1, String paramString2, int paramInt1, int paramInt2) throws JIRAException;
  
  List<JIRAIssue> getSavedFilterIssues(JIRASavedFilter paramJIRASavedFilter, String paramString1, String paramString2, int paramInt1, int paramInt2) throws JIRAException;
  
  List<JIRAIssue> getIssues(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) throws JIRAException;
  
  JIRAIssue getIssue(String paramString) throws JIRAException;
  
  void login() throws JIRAException, JiraCaptchaRequiredException;
  
  boolean isLoggedIn(ConnectionCfg paramConnectionCfg);
  
  void testConnection() throws RemoteApiException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JIRASessionPartTwo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */