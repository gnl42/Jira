/*    */ package com.atlassian.connector.commons.jira;
/*    */ 
/*    */ import java.util.Locale;
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
/*    */ public class JiraDateTimeCustomField
/*    */   extends JiraCustomFieldImpl
/*    */ {
/*    */   protected JiraDateTimeCustomField(JiraCustomFieldImpl.Builder builder) {
/* 27 */     super(builder);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getFormattedValue() {
/* 32 */     String formattedText = "";
/* 33 */     if (this.values.size() > 0) {
/* 34 */       formattedText = JiraTimeFormatter.formatDateTimeFromJiraTimeString(this.values.get(0), Locale.US);
/*    */     }
/*    */     
/* 37 */     return formattedText;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JiraDateTimeCustomField.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */