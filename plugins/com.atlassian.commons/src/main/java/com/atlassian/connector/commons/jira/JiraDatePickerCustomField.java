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
/*    */ public class JiraDatePickerCustomField
/*    */   extends JiraCustomFieldImpl
/*    */ {
/*    */   private static final String OUTPUT_FORMAT = "dd/MMM/yy";
/*    */   private static final String INPUT_FORMAT = "W, d M y H:m:s z";
/*    */   
/*    */   public JiraDatePickerCustomField(JiraCustomFieldImpl.Builder builder) {
/* 29 */     super(builder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getFormattedValue() {
/* 35 */     String formattedText = "";
/* 36 */     if (this.values.size() > 0) {
/* 37 */       formattedText = JiraTimeFormatter.formatDateFromJiraTimeString(this.values.get(0), Locale.US);
/*    */     }
/*    */     
/* 40 */     return formattedText;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JiraDatePickerCustomField.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */