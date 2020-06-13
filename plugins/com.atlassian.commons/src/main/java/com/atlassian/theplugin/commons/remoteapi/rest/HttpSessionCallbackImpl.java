/*    */ package com.atlassian.theplugin.commons.remoteapi.rest;
/*    */ 
/*    */ import org.apache.commons.httpclient.HttpMethod;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class HttpSessionCallbackImpl
/*    */   implements HttpSessionCallback
/*    */ {
/*    */   public void configureHttpMethod(AbstractHttpSession session, HttpMethod method) {
/* 13 */     session.adjustHttpHeader(method);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\remoteapi\rest\HttpSessionCallbackImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */