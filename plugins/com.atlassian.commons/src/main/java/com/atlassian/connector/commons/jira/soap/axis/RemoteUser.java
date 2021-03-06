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
/*     */ public class RemoteUser
/*     */   extends RemoteEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String email;
/*     */   private String fullname;
/*     */   private String name;
/*     */   
/*     */   public RemoteUser(String email, String fullname, String name) {
/*  24 */     this.email = email;
/*  25 */     this.fullname = fullname;
/*  26 */     this.name = name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmail() {
/*  36 */     return this.email;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmail(String email) {
/*  46 */     this.email = email;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFullname() {
/*  56 */     return this.fullname;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFullname(String fullname) {
/*  66 */     this.fullname = fullname;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  76 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String name) {
/*  86 */     this.name = name;
/*     */   }
/*     */   
/*  89 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  92 */     if (!(obj instanceof RemoteUser)) {
/*  93 */       return false;
/*     */     }
/*  95 */     RemoteUser other = (RemoteUser)obj;
/*  96 */     if (obj == null) {
/*  97 */       return false;
/*     */     }
/*  99 */     if (this == obj) {
/* 100 */       return true;
/*     */     }
/* 102 */     if (this.__equalsCalc != null) {
/* 103 */       return (this.__equalsCalc == obj);
/*     */     }
/* 105 */     this.__equalsCalc = obj;
/*     */     
/* 107 */     boolean _equals = (super.equals(obj) && ((
/* 108 */       this.email == null && other.getEmail() == null) || (
/* 109 */       this.email != null && 
/* 110 */       this.email.equals(other.getEmail()))) && ((
/* 111 */       this.fullname == null && other.getFullname() == null) || (
/* 112 */       this.fullname != null && 
/* 113 */       this.fullname.equals(other.getFullname()))) && ((
/* 114 */       this.name == null && other.getName() == null) || (
/* 115 */       this.name != null && 
/* 116 */       this.name.equals(other.getName()))));
/* 117 */     this.__equalsCalc = null;
/* 118 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 124 */     if (this.__hashCodeCalc) {
/* 125 */       return 0;
/*     */     }
/* 127 */     this.__hashCodeCalc = true;
/* 128 */     int _hashCode = super.hashCode();
/* 129 */     if (getEmail() != null) {
/* 130 */       _hashCode += getEmail().hashCode();
/*     */     }
/* 132 */     if (getFullname() != null) {
/* 133 */       _hashCode += getFullname().hashCode();
/*     */     }
/* 135 */     if (getName() != null) {
/* 136 */       _hashCode += getName().hashCode();
/*     */     }
/* 138 */     this.__hashCodeCalc = false;
/* 139 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 144 */   private static TypeDesc typeDesc = new TypeDesc(RemoteUser.class, true);
/*     */   
/*     */   static {
/* 147 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"));
/* 148 */     ElementDesc elemField = new ElementDesc();
/* 149 */     elemField.setFieldName("email");
/* 150 */     elemField.setXmlName(new QName("", "email"));
/* 151 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 152 */     elemField.setNillable(true);
/* 153 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 154 */     elemField = new ElementDesc();
/* 155 */     elemField.setFieldName("fullname");
/* 156 */     elemField.setXmlName(new QName("", "fullname"));
/* 157 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 158 */     elemField.setNillable(true);
/* 159 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 160 */     elemField = new ElementDesc();
/* 161 */     elemField.setFieldName("name");
/* 162 */     elemField.setXmlName(new QName("", "name"));
/* 163 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 164 */     elemField.setNillable(true);
/* 165 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 172 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 182 */     return 
/* 183 */       (Serializer)new BeanSerializer(
/* 184 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 194 */     return 
/* 195 */       (Deserializer)new BeanDeserializer(
/* 196 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteUser() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteUser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */