package com.atlassian.connector.commons.jira;

import com.atlassian.connector.commons.jira.beans.JIRAAttachment;
import com.atlassian.connector.commons.jira.beans.JIRAComment;
import com.atlassian.connector.commons.jira.beans.JIRAComponentBean;
import com.atlassian.connector.commons.jira.beans.JIRAConstant;
import com.atlassian.connector.commons.jira.beans.JIRAPriorityBean;
import com.atlassian.connector.commons.jira.beans.JIRAProject;
import com.atlassian.connector.commons.jira.beans.JIRAQueryFragment;
import com.atlassian.connector.commons.jira.beans.JIRAResolutionBean;
import com.atlassian.connector.commons.jira.beans.JIRASecurityLevelBean;
import com.atlassian.connector.commons.jira.beans.JIRAUserBean;
import com.atlassian.connector.commons.jira.beans.JIRAVersionBean;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public interface JIRASessionPartOne {
  void login(String paramString1, String paramString2) throws RemoteApiException;
  
  void logout();
  
  void logWork(JIRAIssue paramJIRAIssue, String paramString1, Calendar paramCalendar, String paramString2, boolean paramBoolean, String paramString3) throws RemoteApiException;
  
  void addComment(String paramString1, String paramString2) throws RemoteApiException;
  
  void addAttachment(String paramString1, String paramString2, byte[] paramArrayOfbyte) throws RemoteApiException;
  
  JIRAIssue createIssue(JIRAIssue paramJIRAIssue) throws RemoteApiException;
  
  JIRAIssue getIssueDetails(JIRAIssue paramJIRAIssue) throws RemoteApiException;
  
  List<JIRAProject> getProjects() throws RemoteApiException;
  
  List<JIRAConstant> getIssueTypes() throws RemoteApiException;
  
  List<JIRAConstant> getIssueTypesForProject(long paramLong, String paramString) throws RemoteApiException;
  
  List<JIRAConstant> getSubtaskIssueTypes() throws RemoteApiException;
  
  List<JIRAConstant> getSubtaskIssueTypesForProject(long paramLong, String paramString) throws RemoteApiException;
  
  List<JIRAConstant> getStatuses() throws RemoteApiException;
  
  List<JIRAComponentBean> getComponents(String paramString) throws RemoteApiException;
  
  List<JIRAVersionBean> getVersions(String paramString) throws RemoteApiException;
  
  List<JIRAPriorityBean> getPriorities() throws RemoteApiException;
  
  List<JIRAResolutionBean> getResolutions() throws RemoteApiException;
  
  List<JIRAQueryFragment> getSavedFilters() throws RemoteApiException;
  
  List<JIRAAction> getAvailableActions(JIRAIssue paramJIRAIssue) throws RemoteApiException;
  
  List<JIRAActionField> getFieldsForAction(JIRAIssue paramJIRAIssue, JIRAAction paramJIRAAction) throws RemoteApiException;
  
  void progressWorkflowAction(JIRAIssue paramJIRAIssue, JIRAAction paramJIRAAction, List<JIRAActionField> paramList) throws RemoteApiException;
  
  void setField(JIRAIssue paramJIRAIssue, String paramString1, String paramString2) throws RemoteApiException;
  
  void setField(JIRAIssue paramJIRAIssue, String paramString, String[] paramArrayOfString) throws RemoteApiException;
  
  void setFields(JIRAIssue paramJIRAIssue, List<JIRAActionField> paramList) throws RemoteApiException;
  
  JIRAUserBean getUser(String paramString) throws RemoteApiException, JiraUserNotFoundException;
  
  List<JIRAComment> getComments(JIRAIssue paramJIRAIssue) throws RemoteApiException;
  
  boolean isLoggedIn();
  
  Collection<JIRAAttachment> getIssueAttachements(JIRAIssue paramJIRAIssue) throws RemoteApiException;
  
  List<JIRASecurityLevelBean> getSecurityLevels(String paramString) throws RemoteApiException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JIRASessionPartOne.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */