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
/*     */ public class RemotePermissionMapping
/*     */   implements Serializable {
/*     */   private RemotePermission permission;
/*     */   private RemoteEntity[] remoteEntities;
/*     */   
/*     */   public RemotePermissionMapping(RemotePermission permission, RemoteEntity[] remoteEntities) {
/*  21 */     this.permission = permission;
/*  22 */     this.remoteEntities = remoteEntities;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemotePermission getPermission() {
/*  32 */     return this.permission;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPermission(RemotePermission permission) {
/*  42 */     this.permission = permission;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteEntity[] getRemoteEntities() {
/*  52 */     return this.remoteEntities;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRemoteEntities(RemoteEntity[] remoteEntities) {
/*  62 */     this.remoteEntities = remoteEntities;
/*     */   }
/*     */   
/*  65 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  68 */     if (!(obj instanceof RemotePermissionMapping)) {
/*  69 */       return false;
/*     */     }
/*  71 */     RemotePermissionMapping other = (RemotePermissionMapping)obj;
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
/*  84 */       (((this.permission == null && other.getPermission() == null) || (
/*  85 */       this.permission != null && 
/*  86 */       this.permission.equals(other.getPermission()))) && ((
/*  87 */       this.remoteEntities == null && other.getRemoteEntities() == null) || (
/*  88 */       this.remoteEntities != null && 
/*  89 */       Arrays.equals((Object[])this.remoteEntities, (Object[])other.getRemoteEntities()))));
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
/* 102 */     if (getPermission() != null) {
/* 103 */       _hashCode += getPermission().hashCode();
/*     */     }
/* 105 */     if (getRemoteEntities() != null) {
/* 106 */       int i = 0;
/* 107 */       for (; i < Array.getLength(getRemoteEntities()); 
/* 108 */         i++) {
/* 109 */         Object obj = Array.get(getRemoteEntities(), i);
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
/* 122 */   private static TypeDesc typeDesc = new TypeDesc(RemotePermissionMapping.class, true);
/*     */   
/*     */   static {
/* 125 */     typeDesc.setXmlType(
/* 126 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionMapping"));
/* 127 */     ElementDesc elemField = new ElementDesc();
/* 128 */     elemField.setFieldName("permission");
/* 129 */     elemField.setXmlName(new QName("", "permission"));
/* 130 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermission"));
/* 131 */     elemField.setNillable(true);
/* 132 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 133 */     elemField = new ElementDesc();
/* 134 */     elemField.setFieldName("remoteEntities");
/* 135 */     elemField.setXmlName(new QName("", "remoteEntities"));
/* 136 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteEntity"));
/* 137 */     elemField.setNillable(true);
/* 138 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 145 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 155 */     return 
/* 156 */       (Serializer)new BeanSerializer(
/* 157 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 167 */     return 
/* 168 */       (Deserializer)new BeanDeserializer(
/* 169 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemotePermissionMapping() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemotePermissionMapping.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */