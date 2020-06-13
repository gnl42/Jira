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
/*     */ public class RemoteRoleActor
/*     */   implements Serializable
/*     */ {
/*     */   private String descriptor;
/*     */   private String parameter;
/*     */   private RemoteProjectRole projectRole;
/*     */   private String type;
/*     */   private RemoteUser[] users;
/*     */   
/*     */   public RemoteRoleActor(String descriptor, String parameter, RemoteProjectRole projectRole, String type, RemoteUser[] users) {
/*  30 */     this.descriptor = descriptor;
/*  31 */     this.parameter = parameter;
/*  32 */     this.projectRole = projectRole;
/*  33 */     this.type = type;
/*  34 */     this.users = users;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescriptor() {
/*  44 */     return this.descriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescriptor(String descriptor) {
/*  54 */     this.descriptor = descriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParameter() {
/*  64 */     return this.parameter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String parameter) {
/*  74 */     this.parameter = parameter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteProjectRole getProjectRole() {
/*  84 */     return this.projectRole;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProjectRole(RemoteProjectRole projectRole) {
/*  94 */     this.projectRole = projectRole;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 104 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String type) {
/* 114 */     this.type = type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteUser[] getUsers() {
/* 124 */     return this.users;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsers(RemoteUser[] users) {
/* 134 */     this.users = users;
/*     */   }
/*     */   
/* 137 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/* 140 */     if (!(obj instanceof RemoteRoleActor)) {
/* 141 */       return false;
/*     */     }
/* 143 */     RemoteRoleActor other = (RemoteRoleActor)obj;
/* 144 */     if (obj == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this == obj) {
/* 148 */       return true;
/*     */     }
/* 150 */     if (this.__equalsCalc != null) {
/* 151 */       return (this.__equalsCalc == obj);
/*     */     }
/* 153 */     this.__equalsCalc = obj;
/*     */     
/* 155 */     boolean _equals = 
/* 156 */       (((this.descriptor == null && other.getDescriptor() == null) || (
/* 157 */       this.descriptor != null && 
/* 158 */       this.descriptor.equals(other.getDescriptor()))) && ((
/* 159 */       this.parameter == null && other.getParameter() == null) || (
/* 160 */       this.parameter != null && 
/* 161 */       this.parameter.equals(other.getParameter()))) && ((
/* 162 */       this.projectRole == null && other.getProjectRole() == null) || (
/* 163 */       this.projectRole != null && 
/* 164 */       this.projectRole.equals(other.getProjectRole()))) && ((
/* 165 */       this.type == null && other.getType() == null) || (
/* 166 */       this.type != null && 
/* 167 */       this.type.equals(other.getType()))) && ((
/* 168 */       this.users == null && other.getUsers() == null) || (
/* 169 */       this.users != null && 
/* 170 */       Arrays.equals((Object[])this.users, (Object[])other.getUsers()))));
/* 171 */     this.__equalsCalc = null;
/* 172 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 178 */     if (this.__hashCodeCalc) {
/* 179 */       return 0;
/*     */     }
/* 181 */     this.__hashCodeCalc = true;
/* 182 */     int _hashCode = 1;
/* 183 */     if (getDescriptor() != null) {
/* 184 */       _hashCode += getDescriptor().hashCode();
/*     */     }
/* 186 */     if (getParameter() != null) {
/* 187 */       _hashCode += getParameter().hashCode();
/*     */     }
/* 189 */     if (getProjectRole() != null) {
/* 190 */       _hashCode += getProjectRole().hashCode();
/*     */     }
/* 192 */     if (getType() != null) {
/* 193 */       _hashCode += getType().hashCode();
/*     */     }
/* 195 */     if (getUsers() != null) {
/* 196 */       int i = 0;
/* 197 */       for (; i < Array.getLength(getUsers()); 
/* 198 */         i++) {
/* 199 */         Object obj = Array.get(getUsers(), i);
/* 200 */         if (obj != null && 
/* 201 */           !obj.getClass().isArray()) {
/* 202 */           _hashCode += obj.hashCode();
/*     */         }
/*     */       } 
/*     */     } 
/* 206 */     this.__hashCodeCalc = false;
/* 207 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 212 */   private static TypeDesc typeDesc = new TypeDesc(RemoteRoleActor.class, true);
/*     */   
/*     */   static {
/* 215 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteRoleActor"));
/* 216 */     ElementDesc elemField = new ElementDesc();
/* 217 */     elemField.setFieldName("descriptor");
/* 218 */     elemField.setXmlName(new QName("", "descriptor"));
/* 219 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 220 */     elemField.setNillable(true);
/* 221 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 222 */     elemField = new ElementDesc();
/* 223 */     elemField.setFieldName("parameter");
/* 224 */     elemField.setXmlName(new QName("", "parameter"));
/* 225 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 226 */     elemField.setNillable(true);
/* 227 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 228 */     elemField = new ElementDesc();
/* 229 */     elemField.setFieldName("projectRole");
/* 230 */     elemField.setXmlName(new QName("", "projectRole"));
/* 231 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"));
/* 232 */     elemField.setNillable(true);
/* 233 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 234 */     elemField = new ElementDesc();
/* 235 */     elemField.setFieldName("type");
/* 236 */     elemField.setXmlName(new QName("", "type"));
/* 237 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 238 */     elemField.setNillable(true);
/* 239 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 240 */     elemField = new ElementDesc();
/* 241 */     elemField.setFieldName("users");
/* 242 */     elemField.setXmlName(new QName("", "users"));
/* 243 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"));
/* 244 */     elemField.setNillable(true);
/* 245 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 252 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 262 */     return 
/* 263 */       (Serializer)new BeanSerializer(
/* 264 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 274 */     return 
/* 275 */       (Deserializer)new BeanDeserializer(
/* 276 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteRoleActor() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteRoleActor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */