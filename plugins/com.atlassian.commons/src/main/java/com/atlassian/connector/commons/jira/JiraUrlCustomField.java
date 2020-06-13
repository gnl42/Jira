/*    */ package com.atlassian.connector.commons.jira;
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
/*    */ public class JiraUrlCustomField
/*    */   extends JiraCustomFieldImpl
/*    */ {
/*    */   public JiraUrlCustomField(JiraCustomFieldImpl.Builder builder) {
/* 24 */     super(builder);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getFormattedValue() {
/* 29 */     String value = "";
/* 30 */     if (this.values.size() > 0) {
/* 31 */       value = this.values.get(0);
/*    */     }
/*    */     
/* 34 */     return value;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JiraUrlCustomField.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */