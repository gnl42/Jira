package com.atlassian.connector.commons.jira;

import com.atlassian.connector.commons.api.ConnectionCfg;
import com.atlassian.connector.commons.jira.beans.JIRAAttachment;
import com.atlassian.connector.commons.jira.beans.JIRAComment;
import com.atlassian.connector.commons.jira.beans.JIRAComponentBean;
import com.atlassian.connector.commons.jira.beans.JIRAConstant;
import com.atlassian.connector.commons.jira.beans.JIRAPriorityBean;
import com.atlassian.connector.commons.jira.beans.JIRAProject;
import com.atlassian.connector.commons.jira.beans.JIRAQueryFragment;
import com.atlassian.connector.commons.jira.beans.JIRAResolutionBean;
import com.atlassian.connector.commons.jira.beans.JIRASavedFilter;
import com.atlassian.connector.commons.jira.beans.JIRASecurityLevelBean;
import com.atlassian.connector.commons.jira.beans.JIRAUserBean;
import com.atlassian.connector.commons.jira.beans.JIRAVersionBean;
import com.atlassian.connector.commons.jira.beans.JiraFilter;
import com.atlassian.connector.commons.jira.rss.JIRAException;
import com.atlassian.theplugin.commons.jira.JiraServerData;
import com.atlassian.theplugin.commons.remoteapi.ProductServerFacade;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public interface JIRAServerFacade2 extends ProductServerFacade {
  List<JIRAIssue> getIssues(ConnectionCfg paramConnectionCfg, JiraFilter paramJiraFilter, String paramString1, String paramString2, int paramInt1, int paramInt2) throws JIRAException;
  
  List<JIRAIssue> getSavedFilterIssues(ConnectionCfg paramConnectionCfg, JIRASavedFilter paramJIRASavedFilter, String paramString1, String paramString2, int paramInt1, int paramInt2) throws JIRAException;
  
  List<JIRAProject> getProjects(ConnectionCfg paramConnectionCfg) throws JIRAException;
  
  List<JIRAProject> getProjectsForIssueCreation(ConnectionCfg paramConnectionCfg) throws JIRAException;
  
  List<JIRAConstant> getStatuses(ConnectionCfg paramConnectionCfg) throws JIRAException;
  
  List<JIRAConstant> getIssueTypes(ConnectionCfg paramConnectionCfg) throws JIRAException;
  
  List<JIRAConstant> getIssueTypesForProject(ConnectionCfg paramConnectionCfg, long paramLong, String paramString) throws JIRAException;
  
  List<JIRAConstant> getSubtaskIssueTypes(ConnectionCfg paramConnectionCfg) throws JIRAException;
  
  List<JIRAConstant> getSubtaskIssueTypesForProject(ConnectionCfg paramConnectionCfg, long paramLong, String paramString) throws JIRAException;
  
  List<JIRAQueryFragment> getSavedFilters(ConnectionCfg paramConnectionCfg) throws JIRAException;
  
  List<JIRAComponentBean> getComponents(ConnectionCfg paramConnectionCfg, String paramString) throws JIRAException;
  
  List<JIRAVersionBean> getVersions(ConnectionCfg paramConnectionCfg, String paramString) throws JIRAException;
  
  List<JIRAPriorityBean> getPriorities(ConnectionCfg paramConnectionCfg) throws JIRAException;
  
  List<JIRAResolutionBean> getResolutions(ConnectionCfg paramConnectionCfg) throws JIRAException;
  
  List<JIRAAction> getAvailableActions(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue) throws JIRAException;
  
  List<JIRAActionField> getFieldsForAction(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue, JIRAAction paramJIRAAction) throws JIRAException;
  
  void progressWorkflowAction(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue, JIRAAction paramJIRAAction) throws JIRAException;
  
  void progressWorkflowAction(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue, JIRAAction paramJIRAAction, List<JIRAActionField> paramList) throws JIRAException;
  
  void addComment(ConnectionCfg paramConnectionCfg, String paramString1, String paramString2) throws JIRAException;
  
  void addAttachment(ConnectionCfg paramConnectionCfg, String paramString1, String paramString2, byte[] paramArrayOfbyte) throws JIRAException;
  
  JIRAIssue createIssue(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue) throws JIRAException;
  
  JIRAIssue createSubtask(JiraServerData paramJiraServerData, JIRAIssue paramJIRAIssue1, JIRAIssue paramJIRAIssue2) throws JIRAException;
  
  JIRAIssue getIssue(ConnectionCfg paramConnectionCfg, String paramString) throws JIRAException;
  
  JIRAIssue getIssueDetails(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue) throws JIRAException;
  
  void logWork(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue, String paramString1, Calendar paramCalendar, String paramString2, boolean paramBoolean, String paramString3) throws JIRAException;
  
  void setField(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue, String paramString1, String paramString2) throws JIRAException;
  
  void setField(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue, String paramString, String[] paramArrayOfString) throws JIRAException;
  
  void setFields(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue, List<JIRAActionField> paramList) throws JIRAException;
  
  JIRAUserBean getUser(ConnectionCfg paramConnectionCfg, String paramString) throws JIRAException, JiraUserNotFoundException;
  
  List<JIRAComment> getComments(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue) throws JIRAException;
  
  Collection<JIRAAttachment> getIssueAttachements(ConnectionCfg paramConnectionCfg, JIRAIssue paramJIRAIssue) throws JIRAException;
  
  List<JIRASecurityLevelBean> getSecurityLevels(ConnectionCfg paramConnectionCfg, String paramString) throws JIRAException;
  
  void reset();
  
  boolean usesRest(JiraServerData paramJiraServerData);
  
  List<JIRAIssue> getIssues(JiraServerData paramJiraServerData, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) throws JIRAException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JIRAServerFacade2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */