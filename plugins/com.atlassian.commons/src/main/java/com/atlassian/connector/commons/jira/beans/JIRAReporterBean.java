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
/*    */ public class JIRAReporterBean
/*    */   extends JIRAUserBean
/*    */ {
/*    */   public JIRAReporterBean() {}
/*    */   
/*    */   public JIRAReporterBean(long id, String name, String value) {
/* 26 */     super(id, name, value);
/*    */   }
/*    */   
/*    */   public JIRAReporterBean(Map<String, String> map) {
/* 30 */     super(map);
/*    */   }
/*    */   
/*    */   public JIRAReporterBean(JIRAReporterBean other) {
/* 34 */     this(other.getMap());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getQueryStringFragment() {
/* 39 */     return "reporter=" + getValue();
/*    */   }
/*    */   
/*    */   public JIRAReporterBean getClone() {
/* 43 */     return new JIRAReporterBean(this);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAReporterBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */