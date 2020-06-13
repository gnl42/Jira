/*    */ package com.atlassian.connector.commons.jira.beans;
/*    */ 
/*    */ import java.net.URL;
/*    */ import java.util.Map;
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
/*    */ public class JIRAIssueTypeBean
/*    */   extends AbstractJIRAConstantBean
/*    */ {
/*    */   private boolean subTask = false;
/*    */   
/*    */   public JIRAIssueTypeBean(Map<String, String> map) {
/* 25 */     super(map);
/* 26 */     this.subTask = Boolean.valueOf(map.get("subTask")).booleanValue();
/*    */   }
/*    */   
/*    */   public JIRAIssueTypeBean(long id, String name, URL iconUrl) {
/* 30 */     super(id, name, iconUrl);
/*    */   }
/*    */   
/*    */   public JIRAIssueTypeBean(JIRAIssueTypeBean other) {
/* 34 */     this(other.getMap());
/*    */   }
/*    */   
/*    */   public String getQueryStringFragment() {
/* 38 */     return "type=" + getId();
/*    */   }
/*    */   
/*    */   public JIRAIssueTypeBean getClone() {
/* 42 */     return new JIRAIssueTypeBean(this);
/*    */   }
/*    */   
/*    */   public boolean isSubTask() {
/* 46 */     return this.subTask;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAIssueTypeBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */