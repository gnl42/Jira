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
/*     */ 
/*     */ 
/*     */ public class RemoteSecurityLevel
/*     */   extends AbstractNamedRemoteEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String description;
/*     */   
/*     */   public RemoteSecurityLevel(String id, String name, String description) {
/*  23 */     super(id, name);
/*  24 */     this.description = description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  34 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String description) {
/*  44 */     this.description = description;
/*     */   }
/*     */   
/*  47 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  50 */     if (!(obj instanceof RemoteSecurityLevel)) {
/*  51 */       return false;
/*     */     }
/*  53 */     RemoteSecurityLevel other = (RemoteSecurityLevel)obj;
/*  54 */     if (obj == null) {
/*  55 */       return false;
/*     */     }
/*  57 */     if (this == obj) {
/*  58 */       return true;
/*     */     }
/*  60 */     if (this.__equalsCalc != null) {
/*  61 */       return (this.__equalsCalc == obj);
/*     */     }
/*  63 */     this.__equalsCalc = obj;
/*     */     
/*  65 */     boolean _equals = (super.equals(obj) && ((
/*  66 */       this.description == null && other.getDescription() == null) || (
/*  67 */       this.description != null && 
/*  68 */       this.description.equals(other.getDescription()))));
/*  69 */     this.__equalsCalc = null;
/*  70 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/*  76 */     if (this.__hashCodeCalc) {
/*  77 */       return 0;
/*     */     }
/*  79 */     this.__hashCodeCalc = true;
/*  80 */     int _hashCode = super.hashCode();
/*  81 */     if (getDescription() != null) {
/*  82 */       _hashCode += getDescription().hashCode();
/*     */     }
/*  84 */     this.__hashCodeCalc = false;
/*  85 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  90 */   private static TypeDesc typeDesc = new TypeDesc(RemoteSecurityLevel.class, true);
/*     */   
/*     */   static {
/*  93 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteSecurityLevel"));
/*  94 */     ElementDesc elemField = new ElementDesc();
/*  95 */     elemField.setFieldName("description");
/*  96 */     elemField.setXmlName(new QName("", "description"));
/*  97 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/*  98 */     elemField.setNillable(true);
/*  99 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 106 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 116 */     return 
/* 117 */       (Serializer)new BeanSerializer(
/* 118 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 128 */     return 
/* 129 */       (Deserializer)new BeanDeserializer(
/* 130 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteSecurityLevel() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteSecurityLevel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */