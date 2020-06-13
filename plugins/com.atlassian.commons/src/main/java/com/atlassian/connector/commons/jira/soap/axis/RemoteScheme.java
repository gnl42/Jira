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
/*     */ public class RemoteScheme
/*     */   implements Serializable
/*     */ {
/*     */   private String description;
/*     */   private Long id;
/*     */   private String name;
/*     */   private String type;
/*     */   
/*     */   public RemoteScheme(String description, Long id, String name, String type) {
/*  27 */     this.description = description;
/*  28 */     this.id = id;
/*  29 */     this.name = name;
/*  30 */     this.type = type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  40 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String description) {
/*  50 */     this.description = description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  60 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setId(Long id) {
/*  70 */     this.id = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  80 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String name) {
/*  90 */     this.name = name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 100 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String type) {
/* 110 */     this.type = type;
/*     */   }
/*     */   
/* 113 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/* 116 */     if (!(obj instanceof RemoteScheme)) {
/* 117 */       return false;
/*     */     }
/* 119 */     RemoteScheme other = (RemoteScheme)obj;
/* 120 */     if (obj == null) {
/* 121 */       return false;
/*     */     }
/* 123 */     if (this == obj) {
/* 124 */       return true;
/*     */     }
/* 126 */     if (this.__equalsCalc != null) {
/* 127 */       return (this.__equalsCalc == obj);
/*     */     }
/* 129 */     this.__equalsCalc = obj;
/*     */     
/* 131 */     boolean _equals = 
/* 132 */       (((this.description == null && other.getDescription() == null) || (
/* 133 */       this.description != null && 
/* 134 */       this.description.equals(other.getDescription()))) && ((
/* 135 */       this.id == null && other.getId() == null) || (
/* 136 */       this.id != null && 
/* 137 */       this.id.equals(other.getId()))) && ((
/* 138 */       this.name == null && other.getName() == null) || (
/* 139 */       this.name != null && 
/* 140 */       this.name.equals(other.getName()))) && ((
/* 141 */       this.type == null && other.getType() == null) || (
/* 142 */       this.type != null && 
/* 143 */       this.type.equals(other.getType()))));
/* 144 */     this.__equalsCalc = null;
/* 145 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 151 */     if (this.__hashCodeCalc) {
/* 152 */       return 0;
/*     */     }
/* 154 */     this.__hashCodeCalc = true;
/* 155 */     int _hashCode = 1;
/* 156 */     if (getDescription() != null) {
/* 157 */       _hashCode += getDescription().hashCode();
/*     */     }
/* 159 */     if (getId() != null) {
/* 160 */       _hashCode += getId().hashCode();
/*     */     }
/* 162 */     if (getName() != null) {
/* 163 */       _hashCode += getName().hashCode();
/*     */     }
/* 165 */     if (getType() != null) {
/* 166 */       _hashCode += getType().hashCode();
/*     */     }
/* 168 */     this.__hashCodeCalc = false;
/* 169 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 174 */   private static TypeDesc typeDesc = new TypeDesc(RemoteScheme.class, true);
/*     */   
/*     */   static {
/* 177 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteScheme"));
/* 178 */     ElementDesc elemField = new ElementDesc();
/* 179 */     elemField.setFieldName("description");
/* 180 */     elemField.setXmlName(new QName("", "description"));
/* 181 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 182 */     elemField.setNillable(true);
/* 183 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 184 */     elemField = new ElementDesc();
/* 185 */     elemField.setFieldName("id");
/* 186 */     elemField.setXmlName(new QName("", "id"));
/* 187 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 188 */     elemField.setNillable(true);
/* 189 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 190 */     elemField = new ElementDesc();
/* 191 */     elemField.setFieldName("name");
/* 192 */     elemField.setXmlName(new QName("", "name"));
/* 193 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 194 */     elemField.setNillable(true);
/* 195 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 196 */     elemField = new ElementDesc();
/* 197 */     elemField.setFieldName("type");
/* 198 */     elemField.setXmlName(new QName("", "type"));
/* 199 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 200 */     elemField.setNillable(true);
/* 201 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 208 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 218 */     return 
/* 219 */       (Serializer)new BeanSerializer(
/* 220 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 230 */     return 
/* 231 */       (Deserializer)new BeanDeserializer(
/* 232 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteScheme() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteScheme.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */