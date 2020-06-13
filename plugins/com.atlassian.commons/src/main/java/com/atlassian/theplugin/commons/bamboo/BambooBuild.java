package com.atlassian.theplugin.commons.bamboo;

import com.atlassian.connector.commons.api.ConnectionCfg;
import java.util.Date;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface BambooBuild {
  ConnectionCfg getServer();
  
  String getServerUrl();
  
  @Nullable
  String getProjectName();
  
  String getBuildUrl();
  
  String getPlanName();
  
  @Nullable
  String getProjectKey();
  
  @Nullable
  String getMasterPlanKey();
  
  @NotNull
  String getPlanKey();
  
  boolean getEnabled();
  
  boolean isValid();
  
  int getNumber() throws UnsupportedOperationException;
  
  String getResultUrl();
  
  @NotNull
  BuildStatus getStatus();
  
  @Nullable
  PlanState getPlanState();
  
  @Nullable
  String getErrorMessage();
  
  @Nullable
  String getTestSummary();
  
  int getTestsPassed();
  
  int getTestsFailed();
  
  @Nullable
  String getReason();
  
  @Nullable
  String getDurationDescription();
  
  @Nullable
  Date getStartDate();
  
  @Nullable
  Date getCompletionDate();
  
  String getRelativeBuildDate();
  
  boolean isMyBuild();
  
  Set<String> getCommiters();
  
  @NotNull
  Date getPollingTime();
  
  @Nullable
  Throwable getException();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BambooBuild.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */