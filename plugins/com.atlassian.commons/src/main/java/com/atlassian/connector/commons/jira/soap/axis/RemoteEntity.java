/*    */ package com.atlassian.connector.commons.jira.soap.axis;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.xml.namespace.QName;
/*    */ import org.apache.axis.description.TypeDesc;
/*    */ import org.apache.axis.encoding.Deserializer;
/*    */ import org.apache.axis.encoding.Serializer;
/*    */ import org.apache.axis.encoding.ser.BeanDeserializer;
/*    */ import org.apache.axis.encoding.ser.BeanSerializer;
/*    */ 
/*    */ public class RemoteEntity
/*    */   implements Serializable
/*    */ {
/* 14 */   private Object __equalsCalc = null;
/*    */   
/*    */   public synchronized boolean equals(Object obj) {
/* 17 */     if (!(obj instanceof RemoteEntity)) {
/* 18 */       return false;
/*    */     }
/* 20 */     (RemoteEntity)obj;
/* 21 */     if (obj == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     if (this == obj) {
/* 25 */       return true;
/*    */     }
/* 27 */     if (this.__equalsCalc != null) {
/* 28 */       return (this.__equalsCalc == obj);
/*    */     }
/* 30 */     this.__equalsCalc = obj;
/*    */     
/* 32 */     boolean _equals = true;
/* 33 */     this.__equalsCalc = null;
/* 34 */     return _equals;
/*    */   }
/*    */   
/*    */   private boolean __hashCodeCalc = false;
/*    */   
/*    */   public synchronized int hashCode() {
/* 40 */     if (this.__hashCodeCalc) {
/* 41 */       return 0;
/*    */     }
/* 43 */     this.__hashCodeCalc = true;
/* 44 */     int _hashCode = 1;
/* 45 */     this.__hashCodeCalc = false;
/* 46 */     return _hashCode;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 51 */   private static TypeDesc typeDesc = new TypeDesc(RemoteEntity.class, true);
/*    */   
/*    */   static {
/* 54 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteEntity"));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TypeDesc getTypeDesc() {
/* 61 */     return typeDesc;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 71 */     return 
/* 72 */       (Serializer)new BeanSerializer(
/* 73 */         _javaType, _xmlType, typeDesc);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 83 */     return 
/* 84 */       (Deserializer)new BeanDeserializer(
/* 85 */         _javaType, _xmlType, typeDesc);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteEntity.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */