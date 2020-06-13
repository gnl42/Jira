/*    */ package com.atlassian.connector.commons.jira;
/*    */ 
/*    */ import com.atlassian.connector.commons.jira.beans.AbstractJIRAConstantBean;
/*    */ import com.atlassian.connector.commons.jira.beans.JIRAQueryFragment;
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
/*    */ public class JIRAActionBean
/*    */   extends AbstractJIRAConstantBean
/*    */   implements JIRAAction
/*    */ {
/*    */   public JIRAActionBean(long id, String name) {
/* 23 */     super(id, name, null);
/*    */   }
/*    */   
/*    */   public JIRAActionBean(JIRAActionBean other) {
/* 27 */     this(other.id, other.name);
/*    */   }
/*    */   
/*    */   public String getQueryStringFragment() {
/* 31 */     return "action=" + this.id;
/*    */   }
/*    */   
/*    */   public JIRAActionBean getClone() {
/* 35 */     return new JIRAActionBean(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 40 */     return this.name;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JIRAActionBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */