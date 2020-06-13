package com.atlassian.theplugin.commons.bamboo;

import java.util.List;

public interface BambooJob {
  String getKey();
  
  String getShortKey();
  
  String getName();
  
  String getShortName();
  
  boolean isEnabled();
  
  List<TestDetails> getFailedTests();
  
  List<TestDetails> getSuccessfulTests();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BambooJob.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */