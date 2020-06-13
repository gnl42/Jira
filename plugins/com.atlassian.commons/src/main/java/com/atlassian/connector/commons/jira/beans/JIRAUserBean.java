/*    */ package com.atlassian.connector.commons.jira.beans;
/*    */ 
/*    */ import java.util.HashMap;
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
/*    */ public abstract class JIRAUserBean
/*    */   extends AbstractJIRAConstantBean
/*    */ {
/* 23 */   protected String value = "";
/*    */ 
/*    */   
/*    */   public JIRAUserBean() {}
/*    */ 
/*    */   
/*    */   public JIRAUserBean(long id, String name, String value) {
/* 30 */     super(id, name, null);
/* 31 */     this.value = value;
/*    */   }
/*    */   
/*    */   public JIRAUserBean(Map<String, String> map) {
/* 35 */     super(map);
/* 36 */     this.value = map.get("value");
/*    */   }
/*    */   
/*    */   public HashMap<String, String> getMap() {
/* 40 */     HashMap<String, String> map = super.getMap();
/* 41 */     map.put("value", getValue());
/* 42 */     return map;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 46 */     return this.value;
/*    */   }
/*    */   
/*    */   public abstract String getQueryStringFragment();
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAUserBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */