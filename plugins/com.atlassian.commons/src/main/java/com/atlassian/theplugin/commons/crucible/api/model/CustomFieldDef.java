package com.atlassian.theplugin.commons.crucible.api.model;

import java.util.List;

public interface CustomFieldDef {
  CustomFieldValueType getType();
  
  int getConfigVersion();
  
  String getFieldScope();
  
  String getName();
  
  String getLabel();
  
  CustomFieldValue getDefaultValue();
  
  List<CustomFieldValue> getValues();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\CustomFieldDef.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */