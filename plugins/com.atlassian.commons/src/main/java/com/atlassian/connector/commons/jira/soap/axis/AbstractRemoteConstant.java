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
/*     */ 
/*     */ 
/*     */ public abstract class AbstractRemoteConstant
/*     */   extends AbstractNamedRemoteEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String description;
/*     */   private String icon;
/*     */   
/*     */   public AbstractRemoteConstant(String id, String name, String description, String icon) {
/*  26 */     super(id, name);
/*  27 */     this.description = description;
/*  28 */     this.icon = icon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  38 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String description) {
/*  48 */     this.description = description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIcon() {
/*  58 */     return this.icon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIcon(String icon) {
/*  68 */     this.icon = icon;
/*     */   }
/*     */   
/*  71 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  74 */     if (!(obj instanceof AbstractRemoteConstant)) {
/*  75 */       return false;
/*     */     }
/*  77 */     AbstractRemoteConstant other = (AbstractRemoteConstant)obj;
/*  78 */     if (obj == null) {
/*  79 */       return false;
/*     */     }
/*  81 */     if (this == obj) {
/*  82 */       return true;
/*     */     }
/*  84 */     if (this.__equalsCalc != null) {
/*  85 */       return (this.__equalsCalc == obj);
/*     */     }
/*  87 */     this.__equalsCalc = obj;
/*     */     
/*  89 */     boolean _equals = (super.equals(obj) && ((
/*  90 */       this.description == null && other.getDescription() == null) || (
/*  91 */       this.description != null && 
/*  92 */       this.description.equals(other.getDescription()))) && ((
/*  93 */       this.icon == null && other.getIcon() == null) || (
/*  94 */       this.icon != null && 
/*  95 */       this.icon.equals(other.getIcon()))));
/*  96 */     this.__equalsCalc = null;
/*  97 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 103 */     if (this.__hashCodeCalc) {
/* 104 */       return 0;
/*     */     }
/* 106 */     this.__hashCodeCalc = true;
/* 107 */     int _hashCode = super.hashCode();
/* 108 */     if (getDescription() != null) {
/* 109 */       _hashCode += getDescription().hashCode();
/*     */     }
/* 111 */     if (getIcon() != null) {
/* 112 */       _hashCode += getIcon().hashCode();
/*     */     }
/* 114 */     this.__hashCodeCalc = false;
/* 115 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 120 */   private static TypeDesc typeDesc = new TypeDesc(AbstractRemoteConstant.class, true);
/*     */   
/*     */   static {
/* 123 */     typeDesc.setXmlType(
/* 124 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "AbstractRemoteConstant"));
/* 125 */     ElementDesc elemField = new ElementDesc();
/* 126 */     elemField.setFieldName("description");
/* 127 */     elemField.setXmlName(new QName("", "description"));
/* 128 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 129 */     elemField.setNillable(true);
/* 130 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 131 */     elemField = new ElementDesc();
/* 132 */     elemField.setFieldName("icon");
/* 133 */     elemField.setXmlName(new QName("", "icon"));
/* 134 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 135 */     elemField.setNillable(true);
/* 136 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 143 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 153 */     return 
/* 154 */       (Serializer)new BeanSerializer(
/* 155 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 165 */     return 
/* 166 */       (Deserializer)new BeanDeserializer(
/* 167 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public AbstractRemoteConstant() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\AbstractRemoteConstant.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */