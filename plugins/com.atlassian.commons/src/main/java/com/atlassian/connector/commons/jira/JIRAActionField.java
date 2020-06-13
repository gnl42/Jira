package com.atlassian.connector.commons.jira;

import com.atlassian.connector.commons.jira.beans.JIRAConstant;
import com.atlassian.jira.rest.client.domain.input.FieldInput;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
import java.util.List;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public interface JIRAActionField extends JIRAConstant {
  String getFieldId();
  
  List<String> getValues();
  
  void setValues(List<String> paramList);
  
  void addValue(String paramString);
  
  String getName();
  
  FieldInput generateFieldValue(JIRAIssue paramJIRAIssue, JSONObject paramJSONObject) throws JSONException, RemoteApiException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JIRAActionField.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */