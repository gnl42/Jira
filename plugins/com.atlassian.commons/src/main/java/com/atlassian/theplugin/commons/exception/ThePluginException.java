/*    */ package com.atlassian.theplugin.commons.exception;
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
/*    */ public class ThePluginException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 1809913885448081088L;
/*    */   
/*    */   public ThePluginException(String message) {
/* 27 */     super(message);
/*    */   }
/*    */   
/*    */   public ThePluginException(String message, Throwable throwable) {
/* 31 */     super(message, throwable);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\exception\ThePluginException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */