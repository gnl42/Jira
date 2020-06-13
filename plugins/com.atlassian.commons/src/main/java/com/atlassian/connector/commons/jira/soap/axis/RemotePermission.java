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
/*     */ public class RemotePermission
/*     */   implements Serializable
/*     */ {
/*     */   private String name;
/*     */   private Long permission;
/*     */   
/*     */   public RemotePermission(String name, Long permission) {
/*  21 */     this.name = name;
/*  22 */     this.permission = permission;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getPermission() {
/*  52 */     return this.permission;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPermission(Long permission) {
/*  62 */     this.permission = permission;
/*     */   }
/*     */   
/*  65 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  68 */     if (!(obj instanceof RemotePermission)) {
/*  69 */       return false;
/*     */     }
/*  71 */     RemotePermission other = (RemotePermission)obj;
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
/*  84 */       (((this.name == null && other.getName() == null) || (
/*  85 */       this.name != null && 
/*  86 */       this.name.equals(other.getName()))) && ((
/*  87 */       this.permission == null && other.getPermission() == null) || (
/*  88 */       this.permission != null && 
/*  89 */       this.permission.equals(other.getPermission()))));
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
/* 102 */     if (getName() != null) {
/* 103 */       _hashCode += getName().hashCode();
/*     */     }
/* 105 */     if (getPermission() != null) {
/* 106 */       _hashCode += getPermission().hashCode();
/*     */     }
/* 108 */     this.__hashCodeCalc = false;
/* 109 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 114 */   private static TypeDesc typeDesc = new TypeDesc(RemotePermission.class, true);
/*     */   
/*     */   static {
/* 117 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermission"));
/* 118 */     ElementDesc elemField = new ElementDesc();
/* 119 */     elemField.setFieldName("name");
/* 120 */     elemField.setXmlName(new QName("", "name"));
/* 121 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 122 */     elemField.setNillable(true);
/* 123 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 124 */     elemField = new ElementDesc();
/* 125 */     elemField.setFieldName("permission");
/* 126 */     elemField.setXmlName(new QName("", "permission"));
/* 127 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
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
/*     */   public RemotePermission() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemotePermission.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */