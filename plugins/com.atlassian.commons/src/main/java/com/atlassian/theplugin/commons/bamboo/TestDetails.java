package com.atlassian.theplugin.commons.bamboo;

public interface TestDetails {
  String getTestClassName();
  
  String getTestMethodName();
  
  double getTestDuration();
  
  TestResult getTestResult();
  
  String getErrors();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\TestDetails.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */