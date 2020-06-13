/*    */ package com.atlassian.connector.commons.jira.beans;
/*    */ 
/*    */ import java.util.HashMap;
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
/*    */ public class JIRASecurityLevelBean
/*    */   extends AbstractJIRAConstantBean
/*    */ {
/*    */   public JIRASecurityLevelBean() {}
/*    */   
/*    */   public JIRASecurityLevelBean(Long id, String name) {
/* 29 */     super(id.longValue(), name, null);
/*    */   }
/*    */   
/*    */   public JIRASecurityLevelBean(JIRASecurityLevelBean other) {
/* 33 */     this(other.getMap());
/*    */   }
/*    */   
/*    */   public JIRASecurityLevelBean(HashMap<String, String> map) {
/* 37 */     super(map);
/*    */   }
/*    */   
/*    */   public HashMap<String, String> getMap() {
/* 41 */     return super.getMap();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getQueryStringFragment() {
/* 47 */     return null;
/*    */   }
/*    */   
/*    */   public JIRAQueryFragment getClone() {
/* 51 */     return new JIRASecurityLevelBean(this);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRASecurityLevelBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */