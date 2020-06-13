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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RemoteField
/*    */   extends AbstractNamedRemoteEntity
/*    */   implements Serializable
/*    */ {
/*    */   public RemoteField(String id, String name) {
/* 20 */     super(id, name);
/*    */   }
/*    */   
/* 23 */   private Object __equalsCalc = null;
/*    */   
/*    */   public synchronized boolean equals(Object obj) {
/* 26 */     if (!(obj instanceof RemoteField)) {
/* 27 */       return false;
/*    */     }
/* 29 */     (RemoteField)obj;
/* 30 */     if (obj == null) {
/* 31 */       return false;
/*    */     }
/* 33 */     if (this == obj) {
/* 34 */       return true;
/*    */     }
/* 36 */     if (this.__equalsCalc != null) {
/* 37 */       return (this.__equalsCalc == obj);
/*    */     }
/* 39 */     this.__equalsCalc = obj;
/*    */     
/* 41 */     boolean _equals = super.equals(obj);
/* 42 */     this.__equalsCalc = null;
/* 43 */     return _equals;
/*    */   }
/*    */   
/*    */   private boolean __hashCodeCalc = false;
/*    */   
/*    */   public synchronized int hashCode() {
/* 49 */     if (this.__hashCodeCalc) {
/* 50 */       return 0;
/*    */     }
/* 52 */     this.__hashCodeCalc = true;
/* 53 */     int _hashCode = super.hashCode();
/* 54 */     this.__hashCodeCalc = false;
/* 55 */     return _hashCode;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 60 */   private static TypeDesc typeDesc = new TypeDesc(RemoteField.class, true);
/*    */   
/*    */   static {
/* 63 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteField"));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TypeDesc getTypeDesc() {
/* 70 */     return typeDesc;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 80 */     return 
/* 81 */       (Serializer)new BeanSerializer(
/* 82 */         _javaType, _xmlType, typeDesc);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 92 */     return 
/* 93 */       (Deserializer)new BeanDeserializer(
/* 94 */         _javaType, _xmlType, typeDesc);
/*    */   }
/*    */   
/*    */   public RemoteField() {}
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteField.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */