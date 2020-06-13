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
/*    */ public class JIRAComponentBean
/*    */   extends AbstractJIRAConstantBean
/*    */ {
/*    */   public JIRAComponentBean(Map<String, String> map) {
/* 23 */     super(map);
/*    */   }
/*    */   
/*    */   public JIRAComponentBean(long id, String name) {
/* 27 */     super(id, name, null);
/*    */   }
/*    */   
/*    */   public JIRAComponentBean(JIRAComponentBean other) {
/* 31 */     this(other.getMap());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getQueryStringFragment() {
/* 36 */     return "component=" + getId();
/*    */   }
/*    */   
/*    */   public JIRAComponentBean getClone() {
/* 40 */     return new JIRAComponentBean(this);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAComponentBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */