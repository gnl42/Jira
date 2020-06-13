package com.atlassian.connector.commons.jira;

import com.atlassian.jira.rest.client.domain.input.FieldInput;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public interface FieldValueGenerator {
  FieldInput generateJrJcFieldValue(JIRAIssue paramJIRAIssue, JIRAActionField paramJIRAActionField, JSONObject paramJSONObject) throws JSONException, RemoteApiException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\FieldValueGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */