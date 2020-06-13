/*    */ package com.atlassian.theplugin.commons;
/*    */ 
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.SwingUtilities;
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
/*    */ public class DefaultSwingUiTaskExecutor
/*    */   implements UiTaskExecutor
/*    */ {
/*    */   public void execute(final UiTask uiTask) {
/* 22 */     (new Thread(new Runnable() {
/*    */           public void run() {
/*    */             try {
/* 25 */               uiTask.run();
/* 26 */             } catch (Exception e) {
/*    */               
/* 28 */               e.printStackTrace();
/* 29 */               SwingUtilities.invokeLater(new Runnable() {
/*    */                     public void run() {
/* 31 */                       uiTask.onError();
/* 32 */                       JOptionPane.showMessageDialog(uiTask.getComponent(), "Error while " + uiTask.getLastAction(), 
/* 33 */                           "Error", 0);
/*    */                     }
/*    */                   });
/*    */               return;
/*    */             } 
/* 38 */             SwingUtilities.invokeLater(new Runnable() {
/*    */                   public void run() {
/*    */                     try {
/* 41 */                       uiTask.onSuccess();
/* 42 */                     } catch (Exception e) {
/*    */                       
/* 44 */                       e.printStackTrace();
/* 45 */                       JOptionPane.showMessageDialog(uiTask.getComponent(), "Error while " + uiTask.getLastAction(), 
/* 46 */                           "Error", 0);
/*    */                     } 
/*    */                   }
/*    */                 });
/*    */           }
/* 51 */         })).start();
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\DefaultSwingUiTaskExecutor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */