package com.atlassian.theplugin.commons.crucible.api.model;

import com.atlassian.theplugin.commons.cfg.ServerIdImpl;

public interface CustomFilter extends CrucibleFilter {
  public static final String AUTHOR = "author";
  
  public static final String CREATOR = "creator";
  
  public static final String MODERATOR = "moderator";
  
  public static final String REVIEWER = "reviewer";
  
  public static final String PROJECT = "project";
  
  public static final String STATES = "states";
  
  public static final String COMPLETE = "complete";
  
  public static final String ORROLES = "orRoles";
  
  public static final String ALLCOMPLETE = "allReviewersComplete";
  
  String getTitle();
  
  State[] getState();
  
  String getAuthor();
  
  String getModerator();
  
  String getCreator();
  
  String getReviewer();
  
  Boolean isComplete();
  
  Boolean isAllReviewersComplete();
  
  String getProjectKey();
  
  boolean isOrRoles();
  
  boolean isEnabled();
  
  ServerIdImpl getServerId();
  
  String getStates();
  
  boolean isEmpty();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\CustomFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */