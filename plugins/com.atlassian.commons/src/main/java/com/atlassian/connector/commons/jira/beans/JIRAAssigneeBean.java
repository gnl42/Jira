/*    */ package com.atlassian.connector.commons.jira.beans;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ public class JIRAAssigneeBean
/*    */   extends JIRAUserBean
/*    */ {
/*    */   public JIRAAssigneeBean() {}
/*    */   
/*    */   public JIRAAssigneeBean(long id, String name, String value) {
/* 26 */     super(id, name, value);
/*    */   }
/*    */   
/*    */   public JIRAAssigneeBean(String name, String value) {
/* 30 */     super(-1L, name, value);
/*    */   }
/*    */   public JIRAAssigneeBean(Map<String, String> map) {
/* 33 */     super(map);
/*    */   }
/*    */   
/*    */   public JIRAAssigneeBean(JIRAAssigneeBean other) {
/* 37 */     this(other.getMap());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getQueryStringFragment() {
/* 42 */     return getValue().equalsIgnoreCase("unassigned") ? ("assigneeSelect=" + getValue()) : ("assignee=" + getValue());
/*    */   }
/*    */   
/*    */   public JIRAAssigneeBean getClone() {
/* 46 */     return new JIRAAssigneeBean(this);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAAssigneeBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */