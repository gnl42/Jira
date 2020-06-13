/*    */ package com.atlassian.connector.commons.jira.soap.axis;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Serializable;
/*    */ import javax.xml.namespace.QName;
/*    */ import org.apache.axis.description.TypeDesc;
/*    */ import org.apache.axis.encoding.Deserializer;
/*    */ import org.apache.axis.encoding.SerializationContext;
/*    */ import org.apache.axis.encoding.Serializer;
/*    */ import org.apache.axis.encoding.ser.BeanDeserializer;
/*    */ import org.apache.axis.encoding.ser.BeanSerializer;
/*    */ 
/*    */ public class RemoteValidationException
/*    */   extends RemoteException implements Serializable {
/* 15 */   private Object __equalsCalc = null;
/*    */   
/*    */   public synchronized boolean equals(Object obj) {
/* 18 */     if (!(obj instanceof RemoteValidationException)) {
/* 19 */       return false;
/*    */     }
/* 21 */     (RemoteValidationException)obj;
/* 22 */     if (obj == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     if (this == obj) {
/* 26 */       return true;
/*    */     }
/* 28 */     if (this.__equalsCalc != null) {
/* 29 */       return (this.__equalsCalc == obj);
/*    */     }
/* 31 */     this.__equalsCalc = obj;
/*    */     
/* 33 */     boolean _equals = super.equals(obj);
/* 34 */     this.__equalsCalc = null;
/* 35 */     return _equals;
/*    */   }
/*    */   
/*    */   private boolean __hashCodeCalc = false;
/*    */   
/*    */   public synchronized int hashCode() {
/* 41 */     if (this.__hashCodeCalc) {
/* 42 */       return 0;
/*    */     }
/* 44 */     this.__hashCodeCalc = true;
/* 45 */     int _hashCode = super.hashCode();
/* 46 */     this.__hashCodeCalc = false;
/* 47 */     return _hashCode;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 52 */   private static TypeDesc typeDesc = new TypeDesc(RemoteValidationException.class, true);
/*    */   
/*    */   static {
/* 55 */     typeDesc.setXmlType(
/* 56 */         new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TypeDesc getTypeDesc() {
/* 63 */     return typeDesc;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 73 */     return 
/* 74 */       (Serializer)new BeanSerializer(
/* 75 */         _javaType, _xmlType, typeDesc);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 85 */     return 
/* 86 */       (Deserializer)new BeanDeserializer(
/* 87 */         _javaType, _xmlType, typeDesc);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void writeDetails(QName qname, SerializationContext context) throws IOException {
/* 96 */     context.serialize(qname, null, this);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteValidationException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */