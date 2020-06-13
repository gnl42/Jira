/*     */ package com.atlassian.connector.commons.jira.soap.axis;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Arrays;
/*     */ import javax.xml.namespace.QName;
/*     */ import org.apache.axis.description.ElementDesc;
/*     */ import org.apache.axis.description.FieldDesc;
/*     */ import org.apache.axis.description.TypeDesc;
/*     */ import org.apache.axis.encoding.Deserializer;
/*     */ import org.apache.axis.encoding.Serializer;
/*     */ import org.apache.axis.encoding.ser.BeanDeserializer;
/*     */ import org.apache.axis.encoding.ser.BeanSerializer;
/*     */ 
/*     */ 
/*     */ public class RemoteCustomFieldValue
/*     */   implements Serializable
/*     */ {
/*     */   private String customfieldId;
/*     */   private String key;
/*     */   private String[] values;
/*     */   
/*     */   public RemoteCustomFieldValue(String customfieldId, String key, String[] values) {
/*  24 */     this.customfieldId = customfieldId;
/*  25 */     this.key = key;
/*  26 */     this.values = values;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomfieldId() {
/*  36 */     return this.customfieldId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomfieldId(String customfieldId) {
/*  46 */     this.customfieldId = customfieldId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKey() {
/*  56 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(String key) {
/*  66 */     this.key = key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getValues() {
/*  76 */     return this.values;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValues(String[] values) {
/*  86 */     this.values = values;
/*     */   }
/*     */   
/*  89 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  92 */     if (!(obj instanceof RemoteCustomFieldValue)) {
/*  93 */       return false;
/*     */     }
/*  95 */     RemoteCustomFieldValue other = (RemoteCustomFieldValue)obj;
/*  96 */     if (obj == null) {
/*  97 */       return false;
/*     */     }
/*  99 */     if (this == obj) {
/* 100 */       return true;
/*     */     }
/* 102 */     if (this.__equalsCalc != null) {
/* 103 */       return (this.__equalsCalc == obj);
/*     */     }
/* 105 */     this.__equalsCalc = obj;
/*     */     
/* 107 */     boolean _equals = 
/* 108 */       (((this.customfieldId == null && other.getCustomfieldId() == null) || (
/* 109 */       this.customfieldId != null && 
/* 110 */       this.customfieldId.equals(other.getCustomfieldId()))) && ((
/* 111 */       this.key == null && other.getKey() == null) || (
/* 112 */       this.key != null && 
/* 113 */       this.key.equals(other.getKey()))) && ((
/* 114 */       this.values == null && other.getValues() == null) || (
/* 115 */       this.values != null && 
/* 116 */       Arrays.equals((Object[])this.values, (Object[])other.getValues()))));
/* 117 */     this.__equalsCalc = null;
/* 118 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 124 */     if (this.__hashCodeCalc) {
/* 125 */       return 0;
/*     */     }
/* 127 */     this.__hashCodeCalc = true;
/* 128 */     int _hashCode = 1;
/* 129 */     if (getCustomfieldId() != null) {
/* 130 */       _hashCode += getCustomfieldId().hashCode();
/*     */     }
/* 132 */     if (getKey() != null) {
/* 133 */       _hashCode += getKey().hashCode();
/*     */     }
/* 135 */     if (getValues() != null) {
/* 136 */       int i = 0;
/* 137 */       for (; i < Array.getLength(getValues()); 
/* 138 */         i++) {
/* 139 */         Object obj = Array.get(getValues(), i);
/* 140 */         if (obj != null && 
/* 141 */           !obj.getClass().isArray()) {
/* 142 */           _hashCode += obj.hashCode();
/*     */         }
/*     */       } 
/*     */     } 
/* 146 */     this.__hashCodeCalc = false;
/* 147 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 152 */   private static TypeDesc typeDesc = new TypeDesc(RemoteCustomFieldValue.class, true);
/*     */   
/*     */   static {
/* 155 */     typeDesc.setXmlType(
/* 156 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteCustomFieldValue"));
/* 157 */     ElementDesc elemField = new ElementDesc();
/* 158 */     elemField.setFieldName("customfieldId");
/* 159 */     elemField.setXmlName(new QName("", "customfieldId"));
/* 160 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 161 */     elemField.setNillable(true);
/* 162 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 163 */     elemField = new ElementDesc();
/* 164 */     elemField.setFieldName("key");
/* 165 */     elemField.setXmlName(new QName("", "key"));
/* 166 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 167 */     elemField.setNillable(true);
/* 168 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 169 */     elemField = new ElementDesc();
/* 170 */     elemField.setFieldName("values");
/* 171 */     elemField.setXmlName(new QName("", "values"));
/* 172 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 173 */     elemField.setNillable(true);
/* 174 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 181 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 191 */     return 
/* 192 */       (Serializer)new BeanSerializer(
/* 193 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 203 */     return 
/* 204 */       (Deserializer)new BeanDeserializer(
/* 205 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteCustomFieldValue() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteCustomFieldValue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */