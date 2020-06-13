/*    */ package com.atlassian.theplugin.commons.configuration;
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
/*    */ public class JiraConfigurationBean
/*    */ {
/*    */   private static final int JIRA_DEFAULT_ISSUE_PAGE_SIZE = 25;
/* 23 */   private int pageSize = 25;
/*    */   
/*    */   private boolean synchronizeWithIntelliJTasks = false;
/*    */   
/*    */   private boolean showIssueTooltips = true;
/*    */   private static final int HASHCODE_MAGIC = 31;
/*    */   
/*    */   public JiraConfigurationBean() {}
/*    */   
/*    */   public JiraConfigurationBean(JiraConfigurationBean cfg) {
/* 33 */     this.pageSize = cfg.getPageSize();
/* 34 */     this.synchronizeWithIntelliJTasks = cfg.synchronizeWithIntelliJTasks;
/* 35 */     this.showIssueTooltips = cfg.showIssueTooltips;
/*    */   }
/*    */   
/*    */   public int getPageSize() {
/* 39 */     return this.pageSize;
/*    */   }
/*    */   
/*    */   public void setPageSize(int pageSize) {
/* 43 */     this.pageSize = pageSize;
/*    */   }
/*    */   
/*    */   public boolean isShowIssueTooltips() {
/* 47 */     return this.showIssueTooltips;
/*    */   }
/*    */   
/*    */   public void setShowIssueTooltips(boolean showIssueTooltips) {
/* 51 */     this.showIssueTooltips = showIssueTooltips;
/*    */   }
/*    */   
/*    */   public boolean isSynchronizeWithIntelliJTasks() {
/* 55 */     return this.synchronizeWithIntelliJTasks;
/*    */   }
/*    */   
/*    */   public void setSynchronizeWithIntelliJTasks(boolean synchronizeWithIntelliJTasks) {
/* 59 */     this.synchronizeWithIntelliJTasks = synchronizeWithIntelliJTasks;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 64 */     if (this == o) {
/* 65 */       return true;
/*    */     }
/* 67 */     if (o == null || getClass() != o.getClass()) {
/* 68 */       return false;
/*    */     }
/*    */     
/* 71 */     JiraConfigurationBean that = (JiraConfigurationBean)o;
/*    */     
/* 73 */     if (this.pageSize != that.pageSize) {
/* 74 */       return false;
/*    */     }
/* 76 */     if (this.synchronizeWithIntelliJTasks != that.synchronizeWithIntelliJTasks) {
/* 77 */       return false;
/*    */     }
/* 79 */     if (this.showIssueTooltips != that.showIssueTooltips) {
/* 80 */       return false;
/*    */     }
/* 82 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 87 */     int result = this.pageSize;
/* 88 */     result = 31 * result + (this.synchronizeWithIntelliJTasks ? 1 : 0);
/* 89 */     result = 31 * result + (this.showIssueTooltips ? 1 : 0);
/* 90 */     return result;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\configuration\JiraConfigurationBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */