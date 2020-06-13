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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RemoteStatus
/*    */   extends AbstractRemoteConstant
/*    */   implements Serializable
/*    */ {
/*    */   public RemoteStatus(String id, String name, String description, String icon) {
/* 24 */     super(id, name, description, icon);
/*    */   }
/*    */   
/* 27 */   private Object __equalsCalc = null;
/*    */   
/*    */   public synchronized boolean equals(Object obj) {
/* 30 */     if (!(obj instanceof RemoteStatus)) {
/* 31 */       return false;
/*    */     }
/* 33 */     (RemoteStatus)obj;
/* 34 */     if (obj == null) {
/* 35 */       return false;
/*    */     }
/* 37 */     if (this == obj) {
/* 38 */       return true;
/*    */     }
/* 40 */     if (this.__equalsCalc != null) {
/* 41 */       return (this.__equalsCalc == obj);
/*    */     }
/* 43 */     this.__equalsCalc = obj;
/*    */     
/* 45 */     boolean _equals = super.equals(obj);
/* 46 */     this.__equalsCalc = null;
/* 47 */     return _equals;
/*    */   }
/*    */   
/*    */   private boolean __hashCodeCalc = false;
/*    */   
/*    */   public synchronized int hashCode() {
/* 53 */     if (this.__hashCodeCalc) {
/* 54 */       return 0;
/*    */     }
/* 56 */     this.__hashCodeCalc = true;
/* 57 */     int _hashCode = super.hashCode();
/* 58 */     this.__hashCodeCalc = false;
/* 59 */     return _hashCode;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 64 */   private static TypeDesc typeDesc = new TypeDesc(RemoteStatus.class, true);
/*    */   
/*    */   static {
/* 67 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteStatus"));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TypeDesc getTypeDesc() {
/* 74 */     return typeDesc;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 84 */     return 
/* 85 */       (Serializer)new BeanSerializer(
/* 86 */         _javaType, _xmlType, typeDesc);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 96 */     return 
/* 97 */       (Deserializer)new BeanDeserializer(
/* 98 */         _javaType, _xmlType, typeDesc);
/*    */   }
/*    */   
/*    */   public RemoteStatus() {}
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteStatus.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */