package com.atlassian.theplugin.commons.util;

public interface Logger {
  boolean isDebugEnabled();
  
  void error(String paramString);
  
  void error(String paramString, Throwable paramThrowable);
  
  void error(Throwable paramThrowable);
  
  void warn(String paramString);
  
  void warn(String paramString, Throwable paramThrowable);
  
  void warn(Throwable paramThrowable);
  
  void info(String paramString);
  
  void info(String paramString, Throwable paramThrowable);
  
  void info(Throwable paramThrowable);
  
  void verbose(String paramString);
  
  void verbose(String paramString, Throwable paramThrowable);
  
  void verbose(Throwable paramThrowable);
  
  void debug(String paramString);
  
  void debug(String paramString, Throwable paramThrowable);
  
  void debug(Throwable paramThrowable);
  
  void log(int paramInt, String paramString, Throwable paramThrowable);
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\common\\util\Logger.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */