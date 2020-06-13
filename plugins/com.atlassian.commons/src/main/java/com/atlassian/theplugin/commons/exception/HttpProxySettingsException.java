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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HttpProxySettingsException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 2091368578815429676L;
/*    */   
/*    */   public HttpProxySettingsException(String message, Throwable throwable) {
/* 33 */     super(message, throwable);
/*    */   }
/*    */   
/*    */   public HttpProxySettingsException(String message) {
/* 37 */     super(message);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\exception\HttpProxySettingsException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */