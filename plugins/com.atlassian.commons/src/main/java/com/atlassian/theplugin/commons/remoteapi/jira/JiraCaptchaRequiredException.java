/*    */ package com.atlassian.theplugin.commons.remoteapi.jira;
/*    */ 
/*    */ import com.atlassian.connector.commons.jira.rss.JIRAException;
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
/*    */ public class JiraCaptchaRequiredException
/*    */   extends JIRAException
/*    */ {
/*    */   public JiraCaptchaRequiredException(String message) {
/* 26 */     super(message);
/*    */   }
/*    */   
/*    */   public JiraCaptchaRequiredException(String message, Throwable throwable) {
/* 30 */     super(message, throwable);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\remoteapi\jira\JiraCaptchaRequiredException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */