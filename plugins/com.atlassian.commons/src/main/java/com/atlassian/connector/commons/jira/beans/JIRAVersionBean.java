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
/*    */ public class JIRAVersionBean
/*    */   extends AbstractJIRAConstantBean
/*    */ {
/*    */   protected boolean released;
/*    */   
/*    */   public JIRAVersionBean(Map<String, String> map) {
/* 25 */     super(map);
/* 26 */     this.released = Boolean.valueOf(map.get("released")).booleanValue();
/*    */   }
/*    */   
/*    */   public JIRAVersionBean(long id, String name, boolean released) {
/* 30 */     this.released = released;
/* 31 */     this.id = id;
/* 32 */     this.name = name;
/*    */   }
/*    */   
/*    */   public JIRAVersionBean(JIRAVersionBean other) {
/* 36 */     this(other.getMap());
/*    */   }
/*    */   
/*    */   public boolean isReleased() {
/* 40 */     return this.released;
/*    */   }
/*    */   
/*    */   public void setReleased(boolean released) {
/* 44 */     this.released = released;
/*    */   }
/*    */   
/*    */   public String getQueryStringFragment() {
/* 48 */     return "version=" + getId();
/*    */   }
/*    */   
/*    */   public JIRAVersionBean getClone() {
/* 52 */     return new JIRAVersionBean(this);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAVersionBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */