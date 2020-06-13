/*    */ package com.atlassian.theplugin.commons;
/*    */ 
/*    */ import java.awt.Component;
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
/*    */ public abstract class UiTaskAdapter
/*    */   implements UiTask
/*    */ {
/*    */   private final String actionName;
/*    */   private final Component component;
/*    */   
/*    */   public UiTaskAdapter(String actionName, Component component) {
/* 26 */     this.actionName = actionName;
/* 27 */     this.component = component;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onSuccess() {}
/*    */ 
/*    */   
/*    */   public void onError() {}
/*    */   
/*    */   public String getLastAction() {
/* 37 */     return this.actionName;
/*    */   }
/*    */   
/*    */   public Component getComponent() {
/* 41 */     return this.component;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\UiTaskAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */