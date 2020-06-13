/*    */ package com.atlassian.theplugin.commons.crucible.api;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
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
/*    */ 
/*    */ public class CrucibleException
/*    */   extends RemoteApiException
/*    */ {
/*    */   private static final long serialVersionUID = -7182791443222497268L;
/*    */   
/*    */   public CrucibleException(String message) {
/* 36 */     super(message);
/*    */   }
/*    */   
/*    */   public CrucibleException(Throwable throwable) {
/* 40 */     super(throwable);
/*    */   }
/*    */   
/*    */   public CrucibleException(String message, Throwable throwable) {
/* 44 */     super(message, throwable);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\CrucibleException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */