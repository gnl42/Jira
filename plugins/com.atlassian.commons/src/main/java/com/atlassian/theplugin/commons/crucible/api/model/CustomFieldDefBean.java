/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CustomFieldDefBean
/*    */   implements CustomFieldDef
/*    */ {
/*    */   private CustomFieldValueType type;
/*    */   private int configVersion;
/*    */   private String fieldScope;
/*    */   private String name;
/*    */   private String label;
/*    */   private CustomFieldValue defaultValue;
/* 32 */   private List<CustomFieldValue> values = new ArrayList<CustomFieldValue>();
/*    */ 
/*    */   
/*    */   public CustomFieldValueType getType() {
/* 36 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(CustomFieldValueType type) {
/* 40 */     this.type = type;
/*    */   }
/*    */   
/*    */   public int getConfigVersion() {
/* 44 */     return this.configVersion;
/*    */   }
/*    */   
/*    */   public void setConfigVersion(int configVersion) {
/* 48 */     this.configVersion = configVersion;
/*    */   }
/*    */   
/*    */   public String getFieldScope() {
/* 52 */     return this.fieldScope;
/*    */   }
/*    */   
/*    */   public void setFieldScope(String fieldScope) {
/* 56 */     this.fieldScope = fieldScope;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 60 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 64 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getLabel() {
/* 68 */     return this.label;
/*    */   }
/*    */   
/*    */   public void setLabel(String label) {
/* 72 */     this.label = label;
/*    */   }
/*    */   
/*    */   public CustomFieldValue getDefaultValue() {
/* 76 */     return this.defaultValue;
/*    */   }
/*    */   
/*    */   public void setDefaultValue(CustomFieldValue defaultValue) {
/* 80 */     this.defaultValue = defaultValue;
/*    */   }
/*    */   
/*    */   public List<CustomFieldValue> getValues() {
/* 84 */     return this.values;
/*    */   }
/*    */   
/*    */   public void setValues(List<CustomFieldValue> values) {
/* 88 */     this.values = values;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\CustomFieldDefBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */