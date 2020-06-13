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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RemotePermissionScheme
/*     */   extends RemoteScheme
/*     */   implements Serializable
/*     */ {
/*     */   private RemotePermissionMapping[] permissionMappings;
/*     */   
/*     */   public RemotePermissionScheme(String description, Long id, String name, String type, RemotePermissionMapping[] permissionMappings) {
/*  27 */     super(description, id, name, type);
/*  28 */     this.permissionMappings = permissionMappings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemotePermissionMapping[] getPermissionMappings() {
/*  38 */     return this.permissionMappings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPermissionMappings(RemotePermissionMapping[] permissionMappings) {
/*  48 */     this.permissionMappings = permissionMappings;
/*     */   }
/*     */   
/*  51 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  54 */     if (!(obj instanceof RemotePermissionScheme)) {
/*  55 */       return false;
/*     */     }
/*  57 */     RemotePermissionScheme other = (RemotePermissionScheme)obj;
/*  58 */     if (obj == null) {
/*  59 */       return false;
/*     */     }
/*  61 */     if (this == obj) {
/*  62 */       return true;
/*     */     }
/*  64 */     if (this.__equalsCalc != null) {
/*  65 */       return (this.__equalsCalc == obj);
/*     */     }
/*  67 */     this.__equalsCalc = obj;
/*     */     
/*  69 */     boolean _equals = (super.equals(obj) && ((
/*  70 */       this.permissionMappings == null && other.getPermissionMappings() == null) || (
/*  71 */       this.permissionMappings != null && 
/*  72 */       Arrays.equals((Object[])this.permissionMappings, (Object[])other.getPermissionMappings()))));
/*  73 */     this.__equalsCalc = null;
/*  74 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/*  80 */     if (this.__hashCodeCalc) {
/*  81 */       return 0;
/*     */     }
/*  83 */     this.__hashCodeCalc = true;
/*  84 */     int _hashCode = super.hashCode();
/*  85 */     if (getPermissionMappings() != null) {
/*  86 */       int i = 0;
/*  87 */       for (; i < Array.getLength(getPermissionMappings()); 
/*  88 */         i++) {
/*  89 */         Object obj = Array.get(getPermissionMappings(), i);
/*  90 */         if (obj != null && 
/*  91 */           !obj.getClass().isArray()) {
/*  92 */           _hashCode += obj.hashCode();
/*     */         }
/*     */       } 
/*     */     } 
/*  96 */     this.__hashCodeCalc = false;
/*  97 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 102 */   private static TypeDesc typeDesc = new TypeDesc(RemotePermissionScheme.class, true);
/*     */   
/*     */   static {
/* 105 */     typeDesc.setXmlType(
/* 106 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"));
/* 107 */     ElementDesc elemField = new ElementDesc();
/* 108 */     elemField.setFieldName("permissionMappings");
/* 109 */     elemField.setXmlName(new QName("", "permissionMappings"));
/* 110 */     elemField.setXmlType(
/* 111 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionMapping"));
/* 112 */     elemField.setNillable(true);
/* 113 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 120 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 130 */     return 
/* 131 */       (Serializer)new BeanSerializer(
/* 132 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 142 */     return 
/* 143 */       (Deserializer)new BeanDeserializer(
/* 144 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemotePermissionScheme() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemotePermissionScheme.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */