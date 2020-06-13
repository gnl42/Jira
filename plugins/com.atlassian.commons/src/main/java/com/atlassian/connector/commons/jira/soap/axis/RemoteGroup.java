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
/*     */ public class RemoteGroup
/*     */   extends RemoteEntity implements Serializable {
/*     */   private String name;
/*     */   private RemoteUser[] users;
/*     */   
/*     */   public RemoteGroup(String name, RemoteUser[] users) {
/*  21 */     this.name = name;
/*  22 */     this.users = users;
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
/*     */   public RemoteUser[] getUsers() {
/*  52 */     return this.users;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsers(RemoteUser[] users) {
/*  62 */     this.users = users;
/*     */   }
/*     */   
/*  65 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  68 */     if (!(obj instanceof RemoteGroup)) {
/*  69 */       return false;
/*     */     }
/*  71 */     RemoteGroup other = (RemoteGroup)obj;
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
/*  83 */     boolean _equals = (super.equals(obj) && ((
/*  84 */       this.name == null && other.getName() == null) || (
/*  85 */       this.name != null && 
/*  86 */       this.name.equals(other.getName()))) && ((
/*  87 */       this.users == null && other.getUsers() == null) || (
/*  88 */       this.users != null && 
/*  89 */       Arrays.equals((Object[])this.users, (Object[])other.getUsers()))));
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
/* 101 */     int _hashCode = super.hashCode();
/* 102 */     if (getName() != null) {
/* 103 */       _hashCode += getName().hashCode();
/*     */     }
/* 105 */     if (getUsers() != null) {
/* 106 */       int i = 0;
/* 107 */       for (; i < Array.getLength(getUsers()); 
/* 108 */         i++) {
/* 109 */         Object obj = Array.get(getUsers(), i);
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
/* 122 */   private static TypeDesc typeDesc = new TypeDesc(RemoteGroup.class, true);
/*     */   
/*     */   static {
/* 125 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup"));
/* 126 */     ElementDesc elemField = new ElementDesc();
/* 127 */     elemField.setFieldName("name");
/* 128 */     elemField.setXmlName(new QName("", "name"));
/* 129 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 130 */     elemField.setNillable(true);
/* 131 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 132 */     elemField = new ElementDesc();
/* 133 */     elemField.setFieldName("users");
/* 134 */     elemField.setXmlName(new QName("", "users"));
/* 135 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"));
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
/*     */   public RemoteGroup() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteGroup.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */