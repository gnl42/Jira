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
/*     */ 
/*     */ 
/*     */ public class RemoteIssueType
/*     */   extends AbstractRemoteConstant
/*     */   implements Serializable
/*     */ {
/*     */   private boolean subTask;
/*     */   
/*     */   public RemoteIssueType(String id, String name, String description, String icon, boolean subTask) {
/*  27 */     super(id, name, description, icon);
/*  28 */     this.subTask = subTask;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSubTask() {
/*  38 */     return this.subTask;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSubTask(boolean subTask) {
/*  48 */     this.subTask = subTask;
/*     */   }
/*     */   
/*  51 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  54 */     if (!(obj instanceof RemoteIssueType)) {
/*  55 */       return false;
/*     */     }
/*  57 */     RemoteIssueType other = (RemoteIssueType)obj;
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
/*  69 */     boolean _equals = (super.equals(obj) && 
/*  70 */       this.subTask == other.isSubTask());
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
/*  83 */     _hashCode += (isSubTask() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/*  84 */     this.__hashCodeCalc = false;
/*  85 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  90 */   private static TypeDesc typeDesc = new TypeDesc(RemoteIssueType.class, true);
/*     */   
/*     */   static {
/*  93 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssueType"));
/*  94 */     ElementDesc elemField = new ElementDesc();
/*  95 */     elemField.setFieldName("subTask");
/*  96 */     elemField.setXmlName(new QName("", "subTask"));
/*  97 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/*  98 */     elemField.setNillable(false);
/*  99 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 106 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 116 */     return 
/* 117 */       (Serializer)new BeanSerializer(
/* 118 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 128 */     return 
/* 129 */       (Deserializer)new BeanDeserializer(
/* 130 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteIssueType() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteIssueType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */