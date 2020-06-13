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
/*     */ public class RemoteProjectRoleActors
/*     */   extends RemoteRoleActors
/*     */   implements Serializable
/*     */ {
/*     */   private RemoteProject project;
/*     */   
/*     */   public RemoteProjectRoleActors(RemoteProjectRole projectRole, RemoteRoleActor[] roleActors, RemoteUser[] users, RemoteProject project) {
/*  25 */     super(projectRole, roleActors, users);
/*  26 */     this.project = project;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteProject getProject() {
/*  36 */     return this.project;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProject(RemoteProject project) {
/*  46 */     this.project = project;
/*     */   }
/*     */   
/*  49 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  52 */     if (!(obj instanceof RemoteProjectRoleActors)) {
/*  53 */       return false;
/*     */     }
/*  55 */     RemoteProjectRoleActors other = (RemoteProjectRoleActors)obj;
/*  56 */     if (obj == null) {
/*  57 */       return false;
/*     */     }
/*  59 */     if (this == obj) {
/*  60 */       return true;
/*     */     }
/*  62 */     if (this.__equalsCalc != null) {
/*  63 */       return (this.__equalsCalc == obj);
/*     */     }
/*  65 */     this.__equalsCalc = obj;
/*     */     
/*  67 */     boolean _equals = (super.equals(obj) && ((
/*  68 */       this.project == null && other.getProject() == null) || (
/*  69 */       this.project != null && 
/*  70 */       this.project.equals(other.getProject()))));
/*  71 */     this.__equalsCalc = null;
/*  72 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/*  78 */     if (this.__hashCodeCalc) {
/*  79 */       return 0;
/*     */     }
/*  81 */     this.__hashCodeCalc = true;
/*  82 */     int _hashCode = super.hashCode();
/*  83 */     if (getProject() != null) {
/*  84 */       _hashCode += getProject().hashCode();
/*     */     }
/*  86 */     this.__hashCodeCalc = false;
/*  87 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  92 */   private static TypeDesc typeDesc = new TypeDesc(RemoteProjectRoleActors.class, true);
/*     */   
/*     */   static {
/*  95 */     typeDesc.setXmlType(
/*  96 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRoleActors"));
/*  97 */     ElementDesc elemField = new ElementDesc();
/*  98 */     elemField.setFieldName("project");
/*  99 */     elemField.setXmlName(new QName("", "project"));
/* 100 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"));
/* 101 */     elemField.setNillable(true);
/* 102 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 109 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 119 */     return 
/* 120 */       (Serializer)new BeanSerializer(
/* 121 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 131 */     return 
/* 132 */       (Deserializer)new BeanDeserializer(
/* 133 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteProjectRoleActors() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteProjectRoleActors.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */