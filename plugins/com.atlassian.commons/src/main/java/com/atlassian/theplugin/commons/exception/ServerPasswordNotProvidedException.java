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
/*    */ public class ServerPasswordNotProvidedException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 7341075432154812914L;
/*    */   
/*    */   public ServerPasswordNotProvidedException(Throwable e) {
/* 29 */     super("Server password not provided", e);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\exception\ServerPasswordNotProvidedException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */