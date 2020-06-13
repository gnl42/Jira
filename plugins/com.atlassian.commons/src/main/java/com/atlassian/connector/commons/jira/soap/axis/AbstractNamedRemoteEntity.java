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
/*     */ public abstract class AbstractNamedRemoteEntity
/*     */   extends AbstractRemoteEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String name;
/*     */   
/*     */   public AbstractNamedRemoteEntity(String id, String name) {
/*  21 */     super(id);
/*  22 */     this.name = name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  32 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String name) {
/*  42 */     this.name = name;
/*     */   }
/*     */   
/*  45 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  48 */     if (!(obj instanceof AbstractNamedRemoteEntity)) {
/*  49 */       return false;
/*     */     }
/*  51 */     AbstractNamedRemoteEntity other = (AbstractNamedRemoteEntity)obj;
/*  52 */     if (obj == null) {
/*  53 */       return false;
/*     */     }
/*  55 */     if (this == obj) {
/*  56 */       return true;
/*     */     }
/*  58 */     if (this.__equalsCalc != null) {
/*  59 */       return (this.__equalsCalc == obj);
/*     */     }
/*  61 */     this.__equalsCalc = obj;
/*     */     
/*  63 */     boolean _equals = (super.equals(obj) && ((
/*  64 */       this.name == null && other.getName() == null) || (
/*  65 */       this.name != null && 
/*  66 */       this.name.equals(other.getName()))));
/*  67 */     this.__equalsCalc = null;
/*  68 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/*  74 */     if (this.__hashCodeCalc) {
/*  75 */       return 0;
/*     */     }
/*  77 */     this.__hashCodeCalc = true;
/*  78 */     int _hashCode = super.hashCode();
/*  79 */     if (getName() != null) {
/*  80 */       _hashCode += getName().hashCode();
/*     */     }
/*  82 */     this.__hashCodeCalc = false;
/*  83 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  88 */   private static TypeDesc typeDesc = new TypeDesc(AbstractNamedRemoteEntity.class, true);
/*     */   
/*     */   static {
/*  91 */     typeDesc.setXmlType(
/*  92 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "AbstractNamedRemoteEntity"));
/*  93 */     ElementDesc elemField = new ElementDesc();
/*  94 */     elemField.setFieldName("name");
/*  95 */     elemField.setXmlName(new QName("", "name"));
/*  96 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/*  97 */     elemField.setNillable(true);
/*  98 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 105 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 115 */     return 
/* 116 */       (Serializer)new BeanSerializer(
/* 117 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 127 */     return 
/* 128 */       (Deserializer)new BeanDeserializer(
/* 129 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public AbstractNamedRemoteEntity() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\AbstractNamedRemoteEntity.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */