/*    */ package com.atlassian.theplugin.commons.remoteapi;
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
/*    */ public class RemoteApiSessionExpiredException
/*    */   extends RemoteApiException
/*    */ {
/*    */   private static final long serialVersionUID = -4881606643316502502L;
/*    */   
/*    */   public RemoteApiSessionExpiredException(String message) {
/* 30 */     super(message);
/*    */   }
/*    */   
/*    */   public RemoteApiSessionExpiredException(String message, Throwable throwable) {
/* 34 */     super(message, throwable);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\remoteapi\RemoteApiSessionExpiredException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */