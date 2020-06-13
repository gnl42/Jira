/*     */ package com.atlassian.connector.commons.jira;
/*     */ 
/*     */ import com.atlassian.jira.rest.client.domain.Field;
/*     */ import com.atlassian.jira.rest.client.domain.input.FieldInput;
/*     */ import com.atlassian.jira.rest.client.internal.json.JsonParseUtil;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.codehaus.jettison.json.JSONException;
/*     */ import org.codehaus.jettison.json.JSONObject;
/*     */ import org.jdom.Attribute;
/*     */ import org.jdom.Element;
/*     */ import org.joda.time.DateTime;
/*     */ import org.joda.time.format.DateTimeFormat;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JiraCustomFieldImpl
/*     */   implements JiraCustomField
/*     */ {
/*     */   private String id;
/*  41 */   protected List<String> values = new ArrayList<String>();
/*  42 */   private BasicKeyType typeKey = BasicKeyType.UNSUPPORTED;
/*     */   private String name;
/*     */   
/*     */   protected JiraCustomFieldImpl(Builder builder) {
/*  46 */     this(builder.id, builder.name, builder.values, builder.typeKey);
/*     */   }
/*     */   
/*     */   protected JiraCustomFieldImpl(String id, String name, List<String> values, BasicKeyType typeKey) {
/*  50 */     this.id = id;
/*  51 */     if (values != null) {
/*  52 */       this.values.addAll(values);
/*     */     }
/*  54 */     this.typeKey = typeKey;
/*  55 */     this.name = name;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSupported() {
/*  60 */     return !BasicKeyType.UNSUPPORTED.equals(this.typeKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/*  66 */     return this.id;
/*     */   }
/*     */   
/*     */   public BasicKeyType getTypeKey() {
/*  70 */     return this.typeKey;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getValues() {
/*  75 */     return this.values;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  79 */     return this.name;
/*     */   }
/*     */   
/*     */   public String getFormattedValue() {
/*  83 */     return (this.values.size() > 0) ? this.values.get(0) : "";
/*     */   }
/*     */   
/*     */   public enum BasicKeyType {
/*  87 */     NUMERIC("com.atlassian.jira.plugin.system.customfieldtypes:float"),
/*  88 */     TEXT("com.atlassian.jira.plugin.system.customfieldtypes:textfield"),
/*  89 */     TEXT_AREA("com.atlassian.jira.plugin.system.customfieldtypes:textarea"),
/*  90 */     URL("com.atlassian.jira.plugin.system.customfieldtypes:url"),
/*  91 */     DATE_PICKER(
/*  92 */       "com.atlassian.jira.plugin.system.customfieldtypes:datepicker"),
/*  93 */     UNSUPPORTED("");
/*     */     
/*     */     private final String keyValue;
/*     */     
/*     */     BasicKeyType(String key) {
/*  98 */       this.keyValue = key;
/*     */     }
/*     */     
/*     */     public String getKeyValue() {
/* 102 */       return this.keyValue; } public static BasicKeyType getValueOf(String key) {
/*     */       byte b;
/*     */       int i;
/*     */       BasicKeyType[] arrayOfBasicKeyType;
/* 106 */       for (i = (arrayOfBasicKeyType = values()).length, b = 0; b < i; ) { BasicKeyType type = arrayOfBasicKeyType[b];
/* 107 */         if (type.getKeyValue().equalsIgnoreCase(key))
/* 108 */           return type; 
/*     */         b++; }
/*     */       
/* 111 */       return UNSUPPORTED;
/*     */     }
/*     */     
/*     */     public FieldInput generateJrJcFieldValue(JIRAActionField field) {
/* 115 */       if (UNSUPPORTED == this)
/*     */       {
/*     */         
/* 118 */         return null;
/*     */       }
/* 120 */       List<String> values = field.getValues();
/* 121 */       if (values != null && values.size() > 0) {
/* 122 */         String str = values.get(0);
/* 123 */         if (NUMERIC == this)
/* 124 */           return new FieldInput(field.getFieldId(), Float.valueOf((str != null && str.length() > 0) ? Float.valueOf(str).floatValue() : 0.0F)); 
/* 125 */         if (DATE_PICKER == this) {
/* 126 */           if (StringUtils.isEmpty(str)) {
/* 127 */             return new FieldInput(field.getFieldId(), null);
/*     */           }
/* 129 */           DateTime dt = DateTimeFormat.forPattern("dd/MMM/yy").withLocale(Locale.US).parseDateTime(str);
/* 130 */           return new FieldInput(field.getFieldId(), JsonParseUtil.formatDate(dt));
/*     */         } 
/*     */         
/* 133 */         return new FieldInput(field.getFieldId(), str);
/*     */       } 
/* 135 */       return new FieldInput(field.getFieldId(), null);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Builder {
/*     */     private JiraCustomFieldImpl.BasicKeyType typeKey;
/*     */     private String id;
/*     */     private String name;
/* 143 */     private List<String> values = new ArrayList<String>();
/*     */     
/*     */     public Builder(JSONObject meta, Field field) throws JSONException {
/* 146 */       JSONObject schema = meta.getJSONObject("schema");
/* 147 */       this.typeKey = JiraCustomFieldImpl.BasicKeyType.getValueOf(schema.getString("custom"));
/* 148 */       this.name = meta.getString("name");
/* 149 */       String type = schema.getString("type");
/* 150 */       this.id = field.getId();
/* 151 */       this.values = Lists.newArrayList();
/* 152 */       if ("array".equals(type)) {
/*     */ 
/*     */         
/* 155 */         this.values.add("[Custom field not supported]");
/*     */ 
/*     */       
/*     */       }
/* 159 */       else if (this.typeKey == JiraCustomFieldImpl.BasicKeyType.UNSUPPORTED) {
/* 160 */         this.values.add("[Custom field not supported]");
/*     */       } else {
/* 162 */         Object value = field.getValue();
/* 163 */         if (value != null) {
/* 164 */           this.values.add(value.toString());
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Builder(Element e) {
/* 171 */       if (e != null) {
/* 172 */         Attribute keyAttribute = e.getAttribute("key");
/* 173 */         if (keyAttribute != null && keyAttribute.getValue() != null) {
/* 174 */           this.typeKey = JiraCustomFieldImpl.BasicKeyType.getValueOf(keyAttribute.getValue());
/*     */         }
/* 176 */         Attribute idAttribute = e.getAttribute("id");
/* 177 */         if (idAttribute != null && idAttribute.getValue() != null) {
/* 178 */           this.id = idAttribute.getValue();
/*     */         }
/* 180 */         Element nameElement = e.getChild("customfieldname");
/* 181 */         if (nameElement != null && nameElement.getText() != null) {
/* 182 */           this.name = nameElement.getText();
/*     */         }
/*     */         
/* 185 */         Element valuesElement = e.getChild("customfieldvalues");
/* 186 */         if (valuesElement != null) {
/* 187 */           for (int i = 0; i < valuesElement.getChildren().size(); i++) {
/* 188 */             Element singleValueElement = valuesElement.getChildren().get(i);
/* 189 */             if (singleValueElement != null && singleValueElement.getValue() != null) {
/* 190 */               this.values.add(singleValueElement.getValue());
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public JiraCustomField build() {
/* 199 */       switch (this.typeKey) {
/*     */         case null:
/* 201 */           return new JiraDatePickerCustomField(this);
/*     */ 
/*     */         
/*     */         case URL:
/* 205 */           return new JiraUrlCustomField(this);
/*     */       } 
/* 207 */       return new JiraCustomFieldImpl(this);
/*     */     }
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JiraCustomFieldImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */