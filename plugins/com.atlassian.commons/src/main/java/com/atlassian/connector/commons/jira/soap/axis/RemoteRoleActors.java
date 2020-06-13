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
/*     */ public class RemoteRoleActors
/*     */   implements Serializable
/*     */ {
/*     */   private RemoteProjectRole projectRole;
/*     */   private RemoteRoleActor[] roleActors;
/*     */   private RemoteUser[] users;
/*     */   
/*     */   public RemoteRoleActors(RemoteProjectRole projectRole, RemoteRoleActor[] roleActors, RemoteUser[] users) {
/*  24 */     this.projectRole = projectRole;
/*  25 */     this.roleActors = roleActors;
/*  26 */     this.users = users;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteProjectRole getProjectRole() {
/*  36 */     return this.projectRole;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProjectRole(RemoteProjectRole projectRole) {
/*  46 */     this.projectRole = projectRole;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteRoleActor[] getRoleActors() {
/*  56 */     return this.roleActors;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRoleActors(RemoteRoleActor[] roleActors) {
/*  66 */     this.roleActors = roleActors;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteUser[] getUsers() {
/*  76 */     return this.users;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsers(RemoteUser[] users) {
/*  86 */     this.users = users;
/*     */   }
/*     */   
/*  89 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  92 */     if (!(obj instanceof RemoteRoleActors)) {
/*  93 */       return false;
/*     */     }
/*  95 */     RemoteRoleActors other = (RemoteRoleActors)obj;
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
/* 107 */     boolean _equals = 
/* 108 */       (((this.projectRole == null && other.getProjectRole() == null) || (
/* 109 */       this.projectRole != null && 
/* 110 */       this.projectRole.equals(other.getProjectRole()))) && ((
/* 111 */       this.roleActors == null && other.getRoleActors() == null) || (
/* 112 */       this.roleActors != null && 
/* 113 */       Arrays.equals((Object[])this.roleActors, (Object[])other.getRoleActors()))) && ((
/* 114 */       this.users == null && other.getUsers() == null) || (
/* 115 */       this.users != null && 
/* 116 */       Arrays.equals((Object[])this.users, (Object[])other.getUsers()))));
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
/* 128 */     int _hashCode = 1;
/* 129 */     if (getProjectRole() != null) {
/* 130 */       _hashCode += getProjectRole().hashCode();
/*     */     }
/* 132 */     if (getRoleActors() != null) {
/* 133 */       int i = 0;
/* 134 */       for (; i < Array.getLength(getRoleActors()); 
/* 135 */         i++) {
/* 136 */         Object obj = Array.get(getRoleActors(), i);
/* 137 */         if (obj != null && 
/* 138 */           !obj.getClass().isArray()) {
/* 139 */           _hashCode += obj.hashCode();
/*     */         }
/*     */       } 
/*     */     } 
/* 143 */     if (getUsers() != null) {
/* 144 */       int i = 0;
/* 145 */       for (; i < Array.getLength(getUsers()); 
/* 146 */         i++) {
/* 147 */         Object obj = Array.get(getUsers(), i);
/* 148 */         if (obj != null && 
/* 149 */           !obj.getClass().isArray()) {
/* 150 */           _hashCode += obj.hashCode();
/*     */         }
/*     */       } 
/*     */     } 
/* 154 */     this.__hashCodeCalc = false;
/* 155 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 160 */   private static TypeDesc typeDesc = new TypeDesc(RemoteRoleActors.class, true);
/*     */   
/*     */   static {
/* 163 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteRoleActors"));
/* 164 */     ElementDesc elemField = new ElementDesc();
/* 165 */     elemField.setFieldName("projectRole");
/* 166 */     elemField.setXmlName(new QName("", "projectRole"));
/* 167 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"));
/* 168 */     elemField.setNillable(true);
/* 169 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 170 */     elemField = new ElementDesc();
/* 171 */     elemField.setFieldName("roleActors");
/* 172 */     elemField.setXmlName(new QName("", "roleActors"));
/* 173 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteRoleActor"));
/* 174 */     elemField.setNillable(true);
/* 175 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 176 */     elemField = new ElementDesc();
/* 177 */     elemField.setFieldName("users");
/* 178 */     elemField.setXmlName(new QName("", "users"));
/* 179 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"));
/* 180 */     elemField.setNillable(true);
/* 181 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 188 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 198 */     return 
/* 199 */       (Serializer)new BeanSerializer(
/* 200 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 210 */     return 
/* 211 */       (Deserializer)new BeanDeserializer(
/* 212 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteRoleActors() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteRoleActors.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */