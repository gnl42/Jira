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
/*    */ public class RemoteApiMalformedUrlException
/*    */   extends RemoteApiException
/*    */ {
/*    */   private static final long serialVersionUID = 3783282730078381957L;
/*    */   
/*    */   public RemoteApiMalformedUrlException(String message) {
/* 30 */     super(message);
/*    */   }
/*    */   
/*    */   public RemoteApiMalformedUrlException(Throwable throwable) {
/* 34 */     super(throwable);
/*    */   }
/*    */   
/*    */   public RemoteApiMalformedUrlException(String message, Throwable throwable) {
/* 38 */     super(message, throwable);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\remoteapi\RemoteApiMalformedUrlException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */