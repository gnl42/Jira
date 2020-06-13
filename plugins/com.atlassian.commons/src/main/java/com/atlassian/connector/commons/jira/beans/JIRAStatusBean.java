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
/*    */ public class JIRAStatusBean
/*    */   extends AbstractJIRAConstantBean
/*    */ {
/*    */   public JIRAStatusBean(Map<String, String> map) {
/* 24 */     super(map);
/*    */   }
/*    */   
/*    */   public JIRAStatusBean(long id, String name, URL iconUrl) {
/* 28 */     super(id, name, iconUrl);
/*    */   }
/*    */   
/*    */   public JIRAStatusBean(JIRAStatusBean other) {
/* 32 */     this(other.getMap());
/*    */   }
/*    */   
/*    */   public String getQueryStringFragment() {
/* 36 */     return "status=" + getId();
/*    */   }
/*    */   
/*    */   public JIRAStatusBean getClone() {
/* 40 */     return new JIRAStatusBean(this);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAStatusBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */