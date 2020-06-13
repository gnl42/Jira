package com.atlassian.theplugin.commons.crucible.api.model.notification;

import com.atlassian.theplugin.commons.crucible.api.model.PermId;
import org.jetbrains.annotations.NotNull;

public interface CrucibleNotification {
  CrucibleNotificationType getType();
  
  PermId getId();
  
  @NotNull
  String getItemUrl();
  
  String getPresentationMessage();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\CrucibleNotification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */