package com.atlassian.theplugin.commons;

import java.util.TimerTask;

public interface SchedulableChecker {
  TimerTask newTimerTask();
  
  boolean canSchedule();
  
  long getInterval();
  
  void resetListenersState();
  
  String getName();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\SchedulableChecker.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */