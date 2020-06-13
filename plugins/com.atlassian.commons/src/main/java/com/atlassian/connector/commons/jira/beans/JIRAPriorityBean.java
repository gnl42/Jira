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
/*    */ 
/*    */ public class JIRAPriorityBean
/*    */   extends AbstractJIRAConstantBean
/*    */ {
/*    */   private int order;
/*    */   
/*    */   public JIRAPriorityBean(Map<String, String> map) {
/* 26 */     super(map);
/*    */   }
/*    */   
/*    */   public JIRAPriorityBean(long id, int order, String name, URL iconUrl) {
/* 30 */     super(id, name, iconUrl);
/* 31 */     this.order = order;
/*    */   }
/*    */   
/*    */   public JIRAPriorityBean(JIRAPriorityBean other) {
/* 35 */     super(other.getMap());
/*    */   }
/*    */   
/*    */   public String getQueryStringFragment() {
/* 39 */     return "priority=" + getId();
/*    */   }
/*    */   
/*    */   public JIRAPriorityBean getClone() {
/* 43 */     return new JIRAPriorityBean(this);
/*    */   }
/*    */   
/*    */   public int getOrder() {
/* 47 */     return this.order;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAPriorityBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */