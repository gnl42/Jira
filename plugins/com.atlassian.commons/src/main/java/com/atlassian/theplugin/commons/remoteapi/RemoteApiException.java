/*    */ package com.atlassian.theplugin.commons.remoteapi;
/*    */ 
/*    */ import org.jetbrains.annotations.Nullable;
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
/*    */ public class RemoteApiException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = -8518437777396192588L;
/*    */   private final String serverStackTrace;
/*    */   
/*    */   @Nullable
/*    */   public String getServerStackTrace() {
/* 33 */     return this.serverStackTrace;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RemoteApiException(String message) {
/* 39 */     super(message);
/* 40 */     this.serverStackTrace = null;
/*    */   }
/*    */   
/*    */   public RemoteApiException(String message, @Nullable String serverStackTrace) {
/* 44 */     super(message);
/* 45 */     this.serverStackTrace = serverStackTrace;
/*    */   }
/*    */   
/*    */   public RemoteApiException(Throwable throwable) {
/* 49 */     super(throwable);
/* 50 */     this.serverStackTrace = null;
/*    */   }
/*    */   
/*    */   public RemoteApiException(String message, Throwable throwable) {
/* 54 */     super(message, throwable);
/* 55 */     this.serverStackTrace = null;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\remoteapi\RemoteApiException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */