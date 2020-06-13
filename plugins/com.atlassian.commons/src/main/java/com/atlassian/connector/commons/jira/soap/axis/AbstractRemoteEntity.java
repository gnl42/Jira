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
/*     */ public abstract class AbstractRemoteEntity
/*     */   implements Serializable {
/*     */   private String id;
/*     */   
/*     */   public AbstractRemoteEntity(String id) {
/*  18 */     this.id = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/*  28 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setId(String id) {
/*  38 */     this.id = id;
/*     */   }
/*     */   
/*  41 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  44 */     if (!(obj instanceof AbstractRemoteEntity)) {
/*  45 */       return false;
/*     */     }
/*  47 */     AbstractRemoteEntity other = (AbstractRemoteEntity)obj;
/*  48 */     if (obj == null) {
/*  49 */       return false;
/*     */     }
/*  51 */     if (this == obj) {
/*  52 */       return true;
/*     */     }
/*  54 */     if (this.__equalsCalc != null) {
/*  55 */       return (this.__equalsCalc == obj);
/*     */     }
/*  57 */     this.__equalsCalc = obj;
/*     */     
/*  59 */     boolean _equals = 
/*  60 */       ((this.id == null && other.getId() == null) || (
/*  61 */       this.id != null && 
/*  62 */       this.id.equals(other.getId())));
/*  63 */     this.__equalsCalc = null;
/*  64 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/*  70 */     if (this.__hashCodeCalc) {
/*  71 */       return 0;
/*     */     }
/*  73 */     this.__hashCodeCalc = true;
/*  74 */     int _hashCode = 1;
/*  75 */     if (getId() != null) {
/*  76 */       _hashCode += getId().hashCode();
/*     */     }
/*  78 */     this.__hashCodeCalc = false;
/*  79 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  84 */   private static TypeDesc typeDesc = new TypeDesc(AbstractRemoteEntity.class, true);
/*     */   
/*     */   static {
/*  87 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "AbstractRemoteEntity"));
/*  88 */     ElementDesc elemField = new ElementDesc();
/*  89 */     elemField.setFieldName("id");
/*  90 */     elemField.setXmlName(new QName("", "id"));
/*  91 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/*  92 */     elemField.setNillable(true);
/*  93 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 100 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 110 */     return 
/* 111 */       (Serializer)new BeanSerializer(
/* 112 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 122 */     return 
/* 123 */       (Deserializer)new BeanDeserializer(
/* 124 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public AbstractRemoteEntity() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\AbstractRemoteEntity.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */