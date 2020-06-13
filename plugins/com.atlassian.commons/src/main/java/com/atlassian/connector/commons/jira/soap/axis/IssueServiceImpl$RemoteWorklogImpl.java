/*     */ package com.atlassian.connector.commons.jira.soap.axis;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Calendar;
/*     */ import javax.xml.namespace.QName;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IssueServiceImpl$RemoteWorklogImpl
/*     */   extends RemoteWorklog
/*     */   implements Serializable
/*     */ {
/*     */   public IssueServiceImpl$RemoteWorklogImpl(String author, String comment, Calendar created, String groupLevel, String id, String roleLevelId, Calendar startDate, String timeSpent, long timeSpentInSeconds, String updateAuthor, Calendar updated) {
/*  38 */     super(author, comment, created, groupLevel, id, roleLevelId, startDate, timeSpent, timeSpentInSeconds, updateAuthor, updated);
/*     */   }
/*     */   
/*  41 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/*  44 */     if (!(obj instanceof IssueServiceImpl$RemoteWorklogImpl)) {
/*  45 */       return false;
/*     */     }
/*  47 */     (IssueServiceImpl$RemoteWorklogImpl)obj;
/*  48 */     if (obj == null) {
/*  49 */       return false;
/*     */     }
/*  51 */     if (this == obj) {
/*  52 */       return true;
/*     */     }
/*  54 */     if (this.__equalsCalc != null) {
/*  55 */       return (this.__equalsCalc == obj);
/*     */     }
/*  57 */     this.__equalsCalc = obj;
/*     */     
/*  59 */     boolean _equals = super.equals(obj);
/*  60 */     this.__equalsCalc = null;
/*  61 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/*  67 */     if (this.__hashCodeCalc) {
/*  68 */       return 0;
/*     */     }
/*  70 */     this.__hashCodeCalc = true;
/*  71 */     int _hashCode = super.hashCode();
/*  72 */     this.__hashCodeCalc = false;
/*  73 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  78 */   private static TypeDesc typeDesc = new TypeDesc(IssueServiceImpl$RemoteWorklogImpl.class, true);
/*     */   
/*     */   static {
/*  81 */     typeDesc.setXmlType(new QName("http://service.soap.rpc.jira.atlassian.com", 
/*  82 */           "IssueServiceImpl$RemoteWorklogImpl"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/*  89 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/*  99 */     return 
/* 100 */       (Serializer)new BeanSerializer(
/* 101 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 111 */     return 
/* 112 */       (Deserializer)new BeanDeserializer(
/* 113 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public IssueServiceImpl$RemoteWorklogImpl() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\IssueServiceImpl$RemoteWorklogImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */