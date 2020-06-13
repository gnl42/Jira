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
/*    */ public class CaptchaRequiredException
/*    */   extends RemoteApiLoginException
/*    */ {
/*    */   public CaptchaRequiredException(Throwable throwable) {
/* 19 */     super("Due to multiple failed login attempts, you have been temporarily banned from using the remote API. To re-enable the remote API please log into your server via the web interface.", throwable);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\remoteapi\CaptchaRequiredException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */