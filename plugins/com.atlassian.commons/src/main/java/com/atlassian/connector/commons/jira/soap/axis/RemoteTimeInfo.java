/*     */ package com.atlassian.connector.commons.jira.soap.axis;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class RemoteTimeInfo
/*     */   implements Serializable
/*     */ {
/*     */   private String serverTime;
/*     */   private String timeZoneId;
/*     */   
/*     */   public RemoteTimeInfo(String serverTime, String timeZoneId) {
/*  21 */     this.serverTime = serverTime;
/*  22 */     this.timeZoneId = timeZoneId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServerTime() {
/*  32 */     return this.serverTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServerTime(String serverTime) {
/*  42 */     this.serverTime = serverTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTimeZoneId() {
/*  52 */     return this.timeZoneId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeZoneId(String timeZoneId) {
/*  62 */     this.timeZoneId = timeZoneId;
/*     */   }
/*     */   
/*  65 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  68 */     if (!(obj instanceof RemoteTimeInfo)) {
/*  69 */       return false;
/*     */     }
/*  71 */     RemoteTimeInfo other = (RemoteTimeInfo)obj;
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
/*  84 */       (((this.serverTime == null && other.getServerTime() == null) || (
/*  85 */       this.serverTime != null && 
/*  86 */       this.serverTime.equals(other.getServerTime()))) && ((
/*  87 */       this.timeZoneId == null && other.getTimeZoneId() == null) || (
/*  88 */       this.timeZoneId != null && 
/*  89 */       this.timeZoneId.equals(other.getTimeZoneId()))));
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
/* 102 */     if (getServerTime() != null) {
/* 103 */       _hashCode += getServerTime().hashCode();
/*     */     }
/* 105 */     if (getTimeZoneId() != null) {
/* 106 */       _hashCode += getTimeZoneId().hashCode();
/*     */     }
/* 108 */     this.__hashCodeCalc = false;
/* 109 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 114 */   private static TypeDesc typeDesc = new TypeDesc(RemoteTimeInfo.class, true);
/*     */   
/*     */   static {
/* 117 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteTimeInfo"));
/* 118 */     ElementDesc elemField = new ElementDesc();
/* 119 */     elemField.setFieldName("serverTime");
/* 120 */     elemField.setXmlName(new QName("", "serverTime"));
/* 121 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 122 */     elemField.setNillable(true);
/* 123 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 124 */     elemField = new ElementDesc();
/* 125 */     elemField.setFieldName("timeZoneId");
/* 126 */     elemField.setXmlName(new QName("", "timeZoneId"));
/* 127 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 128 */     elemField.setNillable(true);
/* 129 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 136 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 146 */     return 
/* 147 */       (Serializer)new BeanSerializer(
/* 148 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 158 */     return 
/* 159 */       (Deserializer)new BeanDeserializer(
/* 160 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteTimeInfo() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteTimeInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */