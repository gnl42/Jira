/*    */ package com.atlassian.connector.commons.jira.rss;
/*    */ 
/*    */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*    */ import com.atlassian.connector.commons.jira.JIRAIssue;
/*    */ import com.atlassian.connector.commons.jira.JIRASessionPartTwo;
/*    */ import com.atlassian.connector.commons.jira.beans.JIRASavedFilter;
/*    */ import com.atlassian.connector.commons.jira.beans.JiraFilter;
/*    */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*    */ import com.atlassian.theplugin.commons.remoteapi.jira.JiraCaptchaRequiredException;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JiraRssAutoRenewClient
/*    */   implements JIRASessionPartTwo
/*    */ {
/*    */   private final JIRARssClient rssClient;
/*    */   private Date lastUsed;
/*    */   
/*    */   public JiraRssAutoRenewClient(JIRARssClient rssClient) {
/* 39 */     this.rssClient = rssClient;
/*    */   }
/*    */   
/*    */   public void login() throws JIRAException, JiraCaptchaRequiredException {
/* 43 */     this.rssClient.login();
/*    */   }
/*    */   
/*    */   public void testConnection() throws RemoteApiException {
/* 47 */     this.rssClient.testConnection();
/*    */   }
/*    */   
/*    */   public boolean isLoggedIn(ConnectionCfg server) {
/* 51 */     return (this.rssClient != null && this.rssClient.isLoggedIn(server));
/*    */   }
/*    */   
/*    */   public List<JIRAIssue> getIssues(JiraFilter filter, String sortBy, String sortOrder, int start, int max) throws JIRAException {
/* 55 */     return this.rssClient.getIssues(filter, sortBy, sortOrder, start, max);
/*    */   }
/*    */   
/*    */   public List<JIRAIssue> getIssues(String jql, String sort, String sortOrder, int start, int size) throws JIRAException {
/* 59 */     return this.rssClient.getIssues(jql, sort, sortOrder, start, size);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<JIRAIssue> getSavedFilterIssues(JIRASavedFilter filter, String sortBy, String sortOrder, int start, int max) throws JIRAException {
/* 83 */     return this.rssClient.getSavedFilterIssues(filter, sortBy, sortOrder, start, max);
/*    */   }
/*    */   
/*    */   public JIRAIssue getIssue(String issueKey) throws JIRAException {
/* 87 */     return this.rssClient.getIssue(issueKey);
/*    */   }
/*    */   
/*    */   public Date getLastUsed() {
/* 91 */     return this.lastUsed;
/*    */   }
/*    */   
/*    */   public void setLastUsed(Date lastUsed) {
/* 95 */     this.lastUsed = lastUsed;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\rss\JiraRssAutoRenewClient.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */