/*    */ package com.atlassian.connector.commons.jira;
/*    */ 
/*    */ import com.atlassian.connector.commons.FieldValueGeneratorFactory;
/*    */ import com.atlassian.connector.commons.jira.beans.AbstractJIRAConstantBean;
/*    */ import com.atlassian.connector.commons.jira.beans.JIRAQueryFragment;
/*    */ import com.atlassian.jira.rest.client.domain.input.FieldInput;
/*    */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.codehaus.jettison.json.JSONException;
/*    */ import org.codehaus.jettison.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JIRAActionFieldBean
/*    */   extends AbstractJIRAConstantBean
/*    */   implements JIRAActionField
/*    */ {
/*    */   private String fieldId;
/* 32 */   private List<String> fieldValues = new ArrayList<String>();
/*    */   
/*    */   private static FieldValueGeneratorFactory generatorFactory;
/*    */   
/*    */   public JIRAActionFieldBean(String fieldId, String name) {
/* 37 */     super(fieldId.hashCode(), name, null);
/* 38 */     this.fieldId = fieldId;
/*    */   }
/*    */   
/*    */   public JIRAActionFieldBean(JIRAActionField other) {
/* 42 */     this(other.getFieldId(), other.getName());
/*    */   }
/*    */   
/*    */   public static void setGeneratorFactory(FieldValueGeneratorFactory generatorFactory) {
/* 46 */     JIRAActionFieldBean.generatorFactory = generatorFactory;
/*    */   }
/*    */   
/*    */   public String getFieldId() {
/* 50 */     return this.fieldId;
/*    */   }
/*    */   
/*    */   public void addValue(String val) {
/* 54 */     this.fieldValues.add(val);
/*    */   }
/*    */   
/*    */   public List<String> getValues() {
/* 58 */     return this.fieldValues;
/*    */   }
/*    */   
/*    */   public void setValues(List<String> values) {
/* 62 */     this.fieldValues = values;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getQueryStringFragment() {
/* 67 */     return String.valueOf(this.fieldId) + "=";
/*    */   }
/*    */   
/*    */   public JIRAActionFieldBean getClone() {
/* 71 */     return new JIRAActionFieldBean(this);
/*    */   }
/*    */   
/*    */   public FieldInput generateFieldValue(JIRAIssue issue, JSONObject fieldDef) throws JSONException, RemoteApiException {
/* 75 */     if (generatorFactory == null) {
/* 76 */       throw new RemoteApiException("Field Value Generator Factory not set");
/*    */     }
/*    */     
/* 79 */     FieldValueGenerator generator = generatorFactory.get(this, fieldDef);
/* 80 */     return generator.generateJrJcFieldValue(issue, this, fieldDef);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JIRAActionFieldBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */