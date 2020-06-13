package com.atlassian.connector.commons.jira;

import com.atlassian.connector.commons.api.ConnectionCfg;
import com.atlassian.connector.commons.jira.rss.JIRAException;

public interface JiraRESTSupportTester {
  boolean supportsRest(ConnectionCfg paramConnectionCfg) throws JIRAException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JiraRESTSupportTester.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */