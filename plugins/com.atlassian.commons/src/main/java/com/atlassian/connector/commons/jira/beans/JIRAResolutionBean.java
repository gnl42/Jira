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
/*    */ public class JIRAResolutionBean
/*    */   extends AbstractJIRAConstantBean
/*    */ {
/*    */   public JIRAResolutionBean(Map<String, String> map) {
/* 24 */     super(map);
/*    */   }
/*    */   
/*    */   public JIRAResolutionBean(long id, String name) {
/* 28 */     super(id, name, null);
/*    */   }
/*    */   
/*    */   public JIRAResolutionBean(JIRAResolutionBean other) {
/* 32 */     this(other.getMap());
/*    */   }
/*    */   
/*    */   public String getQueryStringFragment() {
/* 36 */     return "resolution=" + this.id;
/*    */   }
/*    */   
/*    */   public JIRAResolutionBean getClone() {
/* 40 */     return new JIRAResolutionBean(this);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAResolutionBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */