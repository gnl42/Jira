package com.atlassian.theplugin.commons.crucible.api.model;

public interface NewReviewItem {
  String getRepositoryName();
  
  String getFromPath();
  
  String getFromRevision();
  
  String getToPath();
  
  String getToRevision();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\NewReviewItem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */