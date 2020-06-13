package com.atlassian.theplugin.commons.bamboo;

import java.util.List;
import org.jetbrains.annotations.Nullable;

public interface BuildDetails {
  @Deprecated
  @Nullable
  String getVcsRevisionKey();
  
  List<TestDetails> getSuccessfulTestDetails();
  
  List<TestDetails> getFailedTestDetails();
  
  List<BambooChangeSet> getCommitInfo();
  
  List<BambooJob> getJobs();
  
  List<BambooJob> getEnabledJobs();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BuildDetails.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */