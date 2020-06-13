package com.atlassian.connector.commons.jira.soap.axis;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JiraSoapService extends Remote {
  RemoteComment getComment(String paramString, long paramLong) throws RemoteException, RemoteException;
  
  RemoteGroup createGroup(String paramString1, String paramString2, RemoteUser paramRemoteUser) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemoteSecurityLevel getSecurityLevel(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteException;
  
  RemoteServerInfo getServerInfo(String paramString) throws RemoteException;
  
  RemoteGroup getGroup(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemoteUser createUser(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemoteUser getUser(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException;
  
  String login(String paramString1, String paramString2) throws RemoteException, RemoteAuthenticationException, RemoteException;
  
  RemoteIssue getIssue(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemoteIssue createIssue(String paramString, RemoteIssue paramRemoteIssue) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemoteNamedObject[] getAvailableActions(String paramString1, String paramString2) throws RemoteException, RemoteException;
  
  RemoteIssue updateIssue(String paramString1, String paramString2, RemoteFieldValue[] paramArrayOfRemoteFieldValue) throws RemoteException, RemoteException;
  
  RemoteConfiguration getConfiguration(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemoteComponent[] getComponents(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemoteProject updateProject(String paramString, RemoteProject paramRemoteProject) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemoteProject getProjectByKey(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemotePriority[] getPriorities(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException;
  
  RemoteResolution[] getResolutions(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException;
  
  RemoteIssueType[] getIssueTypes(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException;
  
  RemoteStatus[] getStatuses(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException;
  
  RemoteIssueType[] getSubTaskIssueTypes(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException;
  
  RemoteProjectRole[] getProjectRoles(String paramString) throws RemoteException, RemoteException;
  
  RemoteProjectRole getProjectRole(String paramString, long paramLong) throws RemoteException, RemoteException;
  
  RemoteProjectRoleActors getProjectRoleActors(String paramString, RemoteProjectRole paramRemoteProjectRole, RemoteProject paramRemoteProject) throws RemoteException, RemoteException;
  
  RemoteRoleActors getDefaultRoleActors(String paramString, RemoteProjectRole paramRemoteProjectRole) throws RemoteException, RemoteException;
  
  void removeAllRoleActorsByNameAndType(String paramString1, String paramString2, String paramString3) throws RemoteException, RemoteException;
  
  void removeAllRoleActorsByProject(String paramString, RemoteProject paramRemoteProject) throws RemoteException, RemoteException;
  
  void deleteProjectRole(String paramString, RemoteProjectRole paramRemoteProjectRole, boolean paramBoolean) throws RemoteException, RemoteException;
  
  void updateProjectRole(String paramString, RemoteProjectRole paramRemoteProjectRole) throws RemoteException, RemoteException;
  
  RemoteProjectRole createProjectRole(String paramString, RemoteProjectRole paramRemoteProjectRole) throws RemoteException, RemoteException;
  
  boolean isProjectRoleNameUnique(String paramString1, String paramString2) throws RemoteException, RemoteException;
  
  void addActorsToProjectRole(String paramString1, String[] paramArrayOfString, RemoteProjectRole paramRemoteProjectRole, RemoteProject paramRemoteProject, String paramString2) throws RemoteException, RemoteException;
  
  void removeActorsFromProjectRole(String paramString1, String[] paramArrayOfString, RemoteProjectRole paramRemoteProjectRole, RemoteProject paramRemoteProject, String paramString2) throws RemoteException, RemoteException;
  
  void addDefaultActorsToProjectRole(String paramString1, String[] paramArrayOfString, RemoteProjectRole paramRemoteProjectRole, String paramString2) throws RemoteException, RemoteException;
  
  void removeDefaultActorsFromProjectRole(String paramString1, String[] paramArrayOfString, RemoteProjectRole paramRemoteProjectRole, String paramString2) throws RemoteException, RemoteException;
  
  RemoteScheme[] getAssociatedNotificationSchemes(String paramString, RemoteProjectRole paramRemoteProjectRole) throws RemoteException, RemoteException;
  
  RemoteScheme[] getAssociatedPermissionSchemes(String paramString, RemoteProjectRole paramRemoteProjectRole) throws RemoteException, RemoteException;
  
  RemoteField[] getCustomFields(String paramString) throws RemoteException, RemoteException;
  
  RemoteComment[] getComments(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemoteFilter[] getFavouriteFilters(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  void archiveVersion(String paramString1, String paramString2, String paramString3, boolean paramBoolean) throws RemoteException, RemoteException;
  
  RemoteVersion[] getVersions(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemoteProject createProject(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, RemotePermissionScheme paramRemotePermissionScheme, RemoteScheme paramRemoteScheme1, RemoteScheme paramRemoteScheme2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  void addComment(String paramString1, String paramString2, RemoteComment paramRemoteComment) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemoteField[] getFieldsForEdit(String paramString1, String paramString2) throws RemoteException, RemoteException;
  
  RemoteIssueType[] getIssueTypesForProject(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException;
  
  RemoteIssueType[] getSubTaskIssueTypesForProject(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException;
  
  void addUserToGroup(String paramString, RemoteGroup paramRemoteGroup, RemoteUser paramRemoteUser) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  void removeUserFromGroup(String paramString, RemoteGroup paramRemoteGroup, RemoteUser paramRemoteUser) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  boolean logout(String paramString) throws RemoteException;
  
  RemoteProject getProjectById(String paramString, long paramLong) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemoteProject getProjectWithSchemesById(String paramString, long paramLong) throws RemoteException, RemoteException;
  
  void deleteProject(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  void releaseVersion(String paramString1, String paramString2, RemoteVersion paramRemoteVersion) throws RemoteException, RemoteException;
  
  RemoteSecurityLevel[] getSecurityLevels(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteException;
  
  void deleteIssue(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemoteIssue createIssueWithSecurityLevel(String paramString, RemoteIssue paramRemoteIssue, long paramLong) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  boolean addAttachmentsToIssue(String paramString1, String paramString2, String[] paramArrayOfString, byte[][] paramArrayOfbyte) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemoteAttachment[] getAttachmentsFromIssue(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  boolean hasPermissionToEditComment(String paramString, RemoteComment paramRemoteComment) throws RemoteException, RemoteException;
  
  RemoteComment editComment(String paramString, RemoteComment paramRemoteComment) throws RemoteException, RemoteException;
  
  RemoteField[] getFieldsForAction(String paramString1, String paramString2, String paramString3) throws RemoteException, RemoteException;
  
  RemoteIssue progressWorkflowAction(String paramString1, String paramString2, String paramString3, RemoteFieldValue[] paramArrayOfRemoteFieldValue) throws RemoteException, RemoteException;
  
  RemoteIssue getIssueById(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemoteWorklog addWorklogWithNewRemainingEstimate(String paramString1, String paramString2, RemoteWorklog paramRemoteWorklog, String paramString3) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException;
  
  RemoteWorklog addWorklogAndAutoAdjustRemainingEstimate(String paramString1, String paramString2, RemoteWorklog paramRemoteWorklog) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException;
  
  RemoteWorklog addWorklogAndRetainRemainingEstimate(String paramString1, String paramString2, RemoteWorklog paramRemoteWorklog) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException;
  
  void deleteWorklogWithNewRemainingEstimate(String paramString1, String paramString2, String paramString3) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException;
  
  void deleteWorklogAndAutoAdjustRemainingEstimate(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException;
  
  void deleteWorklogAndRetainRemainingEstimate(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException;
  
  void updateWorklogWithNewRemainingEstimate(String paramString1, RemoteWorklog paramRemoteWorklog, String paramString2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException;
  
  void updateWorklogAndAutoAdjustRemainingEstimate(String paramString, RemoteWorklog paramRemoteWorklog) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException;
  
  void updateWorklogAndRetainRemainingEstimate(String paramString, RemoteWorklog paramRemoteWorklog) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException;
  
  RemoteWorklog[] getWorklogs(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException;
  
  boolean hasPermissionToCreateWorklog(String paramString1, String paramString2) throws RemoteException, RemoteValidationException, RemoteException;
  
  boolean hasPermissionToDeleteWorklog(String paramString1, String paramString2) throws RemoteException, RemoteValidationException, RemoteException;
  
  boolean hasPermissionToUpdateWorklog(String paramString1, String paramString2) throws RemoteException, RemoteValidationException, RemoteException;
  
  RemoteScheme[] getNotificationSchemes(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemotePermissionScheme[] getPermissionSchemes(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemotePermissionScheme createPermissionScheme(String paramString1, String paramString2, String paramString3) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  void deletePermissionScheme(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemotePermissionScheme addPermissionTo(String paramString, RemotePermissionScheme paramRemotePermissionScheme, RemotePermission paramRemotePermission, RemoteEntity paramRemoteEntity) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemotePermissionScheme deletePermissionFrom(String paramString, RemotePermissionScheme paramRemotePermissionScheme, RemotePermission paramRemotePermission, RemoteEntity paramRemoteEntity) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemotePermission[] getAllPermissions(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  long getIssueCountForFilter(String paramString1, String paramString2) throws RemoteException, RemoteException;
  
  RemoteIssue[] getIssuesFromTextSearch(String paramString1, String paramString2) throws RemoteException, RemoteException;
  
  RemoteIssue[] getIssuesFromTextSearchWithProject(String paramString1, String[] paramArrayOfString, String paramString2, int paramInt) throws RemoteException, RemoteException;
  
  void deleteUser(String paramString1, String paramString2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemoteGroup updateGroup(String paramString, RemoteGroup paramRemoteGroup) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  void deleteGroup(String paramString1, String paramString2, String paramString3) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  void refreshCustomFields(String paramString) throws RemoteException, RemoteException;
  
  RemoteProject[] getProjectsNoSchemes(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemoteVersion addVersion(String paramString1, String paramString2, RemoteVersion paramRemoteVersion) throws RemoteException, RemoteException;
  
  RemoteFilter[] getSavedFilters(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  boolean addBase64EncodedAttachmentsToIssue(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemoteProject createProjectFromObject(String paramString, RemoteProject paramRemoteProject) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException;
  
  RemoteScheme[] getSecuritySchemes(String paramString) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException;
  
  RemoteIssue[] getIssuesFromFilter(String paramString1, String paramString2) throws RemoteException, RemoteException;
  
  RemoteIssue[] getIssuesFromFilterWithLimit(String paramString1, String paramString2, int paramInt1, int paramInt2) throws RemoteException, RemoteException;
  
  RemoteIssue[] getIssuesFromTextSearchWithLimit(String paramString1, String paramString2, int paramInt1, int paramInt2) throws RemoteException, RemoteException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\JiraSoapService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */