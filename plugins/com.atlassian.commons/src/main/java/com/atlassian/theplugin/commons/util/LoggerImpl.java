/*     */ package com.atlassian.theplugin.commons.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class LoggerImpl
/*     */   implements Logger
/*     */ {
/*     */   private static Logger singleton;
/*     */   public static final String LOGGER_CATEGORY = "com.atlassian.theplugin";
/*     */   private static boolean debug;
/*     */   private static boolean verbose;
/*     */   public static final int LOG_ERR = 0;
/*     */   public static final int LOG_WARN = 1;
/*     */   public static final int LOG_INFO = 2;
/*     */   public static final int LOG_VERBOSE = 3;
/*     */   public static final int LOG_DEBUG = 4;
/*     */   
/*     */   public boolean isDebugEnabled() {
/*  30 */     return debug;
/*     */   }
/*     */   
/*     */   public static Logger getInstance() {
/*  34 */     if (singleton != null) {
/*  35 */       return singleton;
/*     */     }
/*  37 */     System.out.println("Logger not initialized");
/*  38 */     return new NullLogger();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setInstance(Logger instance) {
/*  54 */     singleton = instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setDebug(boolean debug) {
/*  68 */     LoggerImpl.debug = debug;
/*     */   }
/*     */   
/*     */   public static boolean isDebug() {
/*  72 */     return debug;
/*     */   }
/*     */   
/*     */   public static boolean isVerbose() {
/*  76 */     return verbose;
/*     */   }
/*     */   
/*     */   public static void setVerbose(boolean verbose) {
/*  80 */     LoggerImpl.verbose = verbose;
/*     */   }
/*     */   
/*     */   public void error(String msg) {
/*  84 */     log(0, msg, null);
/*     */   }
/*     */   
/*     */   public void error(String msg, Throwable t) {
/*  88 */     log(0, msg, t);
/*     */   }
/*     */   
/*     */   public void error(Throwable t) {
/*  92 */     log(0, (t != null) ? t.getMessage() : "Exception", t);
/*     */   }
/*     */   
/*     */   public void warn(String msg) {
/*  96 */     log(1, msg, null);
/*     */   }
/*     */   
/*     */   public void warn(String msg, Throwable t) {
/* 100 */     log(1, msg, t);
/*     */   }
/*     */   
/*     */   public void warn(Throwable t) {
/* 104 */     log(1, (t != null) ? t.getMessage() : "Exception", t);
/*     */   }
/*     */ 
/*     */   
/*     */   public void info(String msg) {
/* 109 */     log(2, msg, null);
/*     */   }
/*     */   
/*     */   public void info(String msg, Throwable t) {
/* 113 */     log(2, msg, t);
/*     */   }
/*     */   
/*     */   public void info(Throwable t) {
/* 117 */     log(2, (t != null) ? t.getMessage() : "Exception", t);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void verbose(String msg) {
/* 123 */     log(3, msg, null);
/*     */   }
/*     */   
/*     */   public void verbose(String msg, Throwable t) {
/* 127 */     log(3, msg, t);
/*     */   }
/*     */   
/*     */   public void verbose(Throwable t) {
/* 131 */     log(3, (t != null) ? t.getMessage() : "Exception", t);
/*     */   }
/*     */   
/*     */   public void debug(String msg) {
/* 135 */     log(4, msg, null);
/*     */   }
/*     */   
/*     */   public void debug(String msg, Throwable t) {
/* 139 */     log(4, msg, t);
/*     */   }
/*     */   
/*     */   public void debug(Throwable t) {
/* 143 */     log(4, (t != null) ? t.getMessage() : "Exception", t);
/*     */   }
/*     */   
/*     */   public static boolean canIgnore(int level) {
/* 147 */     if (!debug && level == 4) {
/* 148 */       return true;
/*     */     }
/* 150 */     return (!verbose && !debug && level == 3);
/*     */   }
/*     */   
/*     */   static class NullLogger extends LoggerImpl {
/*     */     public void log(int level, String msg, Throwable t) {}
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\common\\util\LoggerImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */