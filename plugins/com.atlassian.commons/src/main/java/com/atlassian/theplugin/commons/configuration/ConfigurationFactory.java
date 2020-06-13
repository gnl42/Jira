/*    */ package com.atlassian.theplugin.commons.configuration;
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
/*    */ public abstract class ConfigurationFactory
/*    */ {
/*    */   private static PluginConfiguration pluginConfiguration;
/*    */   
/*    */   public static PluginConfiguration getConfiguration() {
/* 29 */     return pluginConfiguration;
/*    */   }
/*    */   
/*    */   public static void setConfiguration(PluginConfiguration newConfiguration) {
/* 33 */     pluginConfiguration = newConfiguration;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\configuration\ConfigurationFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */