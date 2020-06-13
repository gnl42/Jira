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
/*    */ public class JIRAFixForVersionBean
/*    */   extends JIRAVersionBean
/*    */ {
/*    */   public JIRAFixForVersionBean(Map<String, String> map) {
/* 24 */     super(map);
/*    */   }
/*    */   
/*    */   public JIRAFixForVersionBean(long id, String name, boolean released) {
/* 28 */     super(id, name, released);
/*    */   }
/*    */   
/*    */   public JIRAFixForVersionBean(JIRAFixForVersionBean other) {
/* 32 */     super(other.getId(), other.getName(), other.isReleased());
/*    */   }
/*    */   public JIRAFixForVersionBean(JIRAVersionBean other) {
/* 35 */     super(other.getId(), other.getName(), other.isReleased());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getQueryStringFragment() {
/* 40 */     return "fixfor=" + getId();
/*    */   }
/*    */ 
/*    */   
/*    */   public JIRAFixForVersionBean getClone() {
/* 45 */     return new JIRAFixForVersionBean(this);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAFixForVersionBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */