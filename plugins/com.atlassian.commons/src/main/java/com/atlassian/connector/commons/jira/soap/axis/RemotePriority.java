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
/*     */ public class RemotePriority
/*     */   extends AbstractRemoteConstant
/*     */   implements Serializable
/*     */ {
/*     */   private String color;
/*     */   
/*     */   public RemotePriority(String id, String name, String description, String icon, String color) {
/*  27 */     super(id, name, description, icon);
/*  28 */     this.color = color;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getColor() {
/*  38 */     return this.color;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(String color) {
/*  48 */     this.color = color;
/*     */   }
/*     */   
/*  51 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  54 */     if (!(obj instanceof RemotePriority)) {
/*  55 */       return false;
/*     */     }
/*  57 */     RemotePriority other = (RemotePriority)obj;
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
/*  70 */       this.color == null && other.getColor() == null) || (
/*  71 */       this.color != null && 
/*  72 */       this.color.equals(other.getColor()))));
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
/*  85 */     if (getColor() != null) {
/*  86 */       _hashCode += getColor().hashCode();
/*     */     }
/*  88 */     this.__hashCodeCalc = false;
/*  89 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  94 */   private static TypeDesc typeDesc = new TypeDesc(RemotePriority.class, true);
/*     */   
/*     */   static {
/*  97 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePriority"));
/*  98 */     ElementDesc elemField = new ElementDesc();
/*  99 */     elemField.setFieldName("color");
/* 100 */     elemField.setXmlName(new QName("", "color"));
/* 101 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 102 */     elemField.setNillable(true);
/* 103 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 110 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 120 */     return 
/* 121 */       (Serializer)new BeanSerializer(
/* 122 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 132 */     return 
/* 133 */       (Deserializer)new BeanDeserializer(
/* 134 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemotePriority() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemotePriority.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */