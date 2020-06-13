package com.atlassian.connector.commons.jira;

import com.atlassian.connector.commons.jira.beans.JIRAComment;
import com.atlassian.connector.commons.jira.beans.JIRAConstant;
import com.atlassian.connector.commons.jira.beans.JIRAPriorityBean;
import com.atlassian.connector.commons.jira.beans.JIRASecurityLevelBean;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface JIRAIssue {
  String getServerUrl();
  
  String getProjectUrl();
  
  String getIssueUrl();
  
  Long getId();
  
  String getKey();
  
  String getProjectKey();
  
  String getStatus();
  
  String getStatusTypeUrl();
  
  String getSummary();
  
  String getEnvironment();
  
  String getType();
  
  String getTypeIconUrl();
  
  String getPriority();
  
  String getPriorityIconUrl();
  
  String getDescription();
  
  String getWikiDescription();
  
  JIRAConstant getTypeConstant();
  
  JIRAConstant getStatusConstant();
  
  JIRAPriorityBean getPriorityConstant();
  
  String getAssignee();
  
  String getAssigneeId();
  
  String getReporter();
  
  String getReporterId();
  
  String getResolution();
  
  String getCreated();
  
  String getUpdated();
  
  boolean isSubTask();
  
  String getParentIssueKey();
  
  List<String> getSubTaskKeys();
  
  Map<String, Map<String, List<String>>> getIssueLinks();
  
  long getPriorityId();
  
  long getStatusId();
  
  long getTypeId();
  
  void setAssignee(String paramString);
  
  List<JIRAConstant> getAffectsVersions();
  
  List<JIRAConstant> getFixVersions();
  
  List<JIRAConstant> getComponents();
  
  void setAffectsVersions(List<JIRAConstant> paramList);
  
  void setFixVersions(List<JIRAConstant> paramList);
  
  void setComponents(List<JIRAConstant> paramList);
  
  String getOriginalEstimate();
  
  String getOriginalEstimateInSeconds();
  
  void setOriginalEstimate(String paramString);
  
  String getRemainingEstimate();
  
  String getRemainingEstimateInSeconds();
  
  void setRemainingEstimate(String paramString);
  
  String getTimeSpent();
  
  String getTimeSpentInSeconds();
  
  void setTimeSpent(String paramString);
  
  List<JIRAComment> getComments();
  
  Object getApiIssueObject();
  
  void setApiIssueObject(Object paramObject);
  
  JIRASecurityLevelBean getSecurityLevel();
  
  List<JiraCustomField> getCustomFields();
  
  Locale getLocale();
  
  boolean usesRest();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JIRAIssue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */