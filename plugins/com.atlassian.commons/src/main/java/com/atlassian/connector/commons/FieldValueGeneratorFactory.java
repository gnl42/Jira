package com.atlassian.connector.commons;

import com.atlassian.connector.commons.jira.FieldValueGenerator;
import com.atlassian.connector.commons.jira.JIRAActionField;
import org.codehaus.jettison.json.JSONObject;

public interface FieldValueGeneratorFactory {
  FieldValueGenerator get(JIRAActionField paramJIRAActionField, JSONObject paramJSONObject);
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\FieldValueGeneratorFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */