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
/*     */ public class RemoteFieldValue
/*     */   implements Serializable {
/*     */   private String id;
/*     */   private String[] values;
/*     */   
/*     */   public RemoteFieldValue(String id, String[] values) {
/*  21 */     this.id = id;
/*  22 */     this.values = values;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/*  32 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setId(String id) {
/*  42 */     this.id = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getValues() {
/*  52 */     return this.values;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValues(String[] values) {
/*  62 */     this.values = values;
/*     */   }
/*     */   
/*  65 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  68 */     if (!(obj instanceof RemoteFieldValue)) {
/*  69 */       return false;
/*     */     }
/*  71 */     RemoteFieldValue other = (RemoteFieldValue)obj;
/*  72 */     if (obj == null) {
/*  73 */       return false;
/*     */     }
/*  75 */     if (this == obj) {
/*  76 */       return true;
/*     */     }
/*  78 */     if (this.__equalsCalc != null) {
/*  79 */       return (this.__equalsCalc == obj);
/*     */     }
/*  81 */     this.__equalsCalc = obj;
/*     */     
/*  83 */     boolean _equals = 
/*  84 */       (((this.id == null && other.getId() == null) || (
/*  85 */       this.id != null && 
/*  86 */       this.id.equals(other.getId()))) && ((
/*  87 */       this.values == null && other.getValues() == null) || (
/*  88 */       this.values != null && 
/*  89 */       Arrays.equals((Object[])this.values, (Object[])other.getValues()))));
/*  90 */     this.__equalsCalc = null;
/*  91 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/*  97 */     if (this.__hashCodeCalc) {
/*  98 */       return 0;
/*     */     }
/* 100 */     this.__hashCodeCalc = true;
/* 101 */     int _hashCode = 1;
/* 102 */     if (getId() != null) {
/* 103 */       _hashCode += getId().hashCode();
/*     */     }
/* 105 */     if (getValues() != null) {
/* 106 */       int i = 0;
/* 107 */       for (; i < Array.getLength(getValues()); 
/* 108 */         i++) {
/* 109 */         Object obj = Array.get(getValues(), i);
/* 110 */         if (obj != null && 
/* 111 */           !obj.getClass().isArray()) {
/* 112 */           _hashCode += obj.hashCode();
/*     */         }
/*     */       } 
/*     */     } 
/* 116 */     this.__hashCodeCalc = false;
/* 117 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 122 */   private static TypeDesc typeDesc = new TypeDesc(RemoteFieldValue.class, true);
/*     */   
/*     */   static {
/* 125 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteFieldValue"));
/* 126 */     ElementDesc elemField = new ElementDesc();
/* 127 */     elemField.setFieldName("id");
/* 128 */     elemField.setXmlName(new QName("", "id"));
/* 129 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 130 */     elemField.setNillable(true);
/* 131 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 132 */     elemField = new ElementDesc();
/* 133 */     elemField.setFieldName("values");
/* 134 */     elemField.setXmlName(new QName("", "values"));
/* 135 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 136 */     elemField.setNillable(true);
/* 137 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 144 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 154 */     return 
/* 155 */       (Serializer)new BeanSerializer(
/* 156 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 166 */     return 
/* 167 */       (Deserializer)new BeanDeserializer(
/* 168 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteFieldValue() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteFieldValue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */