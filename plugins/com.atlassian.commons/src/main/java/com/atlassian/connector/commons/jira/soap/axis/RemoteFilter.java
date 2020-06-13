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
/*     */ 
/*     */ 
/*     */ public class RemoteFilter
/*     */   extends AbstractNamedRemoteEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String author;
/*     */   private String description;
/*     */   private String project;
/*     */   private String xml;
/*     */   
/*     */   public RemoteFilter(String id, String name, String author, String description, String project, String xml) {
/*  32 */     super(id, name);
/*  33 */     this.author = author;
/*  34 */     this.description = description;
/*  35 */     this.project = project;
/*  36 */     this.xml = xml;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthor() {
/*  46 */     return this.author;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthor(String author) {
/*  56 */     this.author = author;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  66 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String description) {
/*  76 */     this.description = description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getProject() {
/*  86 */     return this.project;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProject(String project) {
/*  96 */     this.project = project;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXml() {
/* 106 */     return this.xml;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXml(String xml) {
/* 116 */     this.xml = xml;
/*     */   }
/*     */   
/* 119 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/* 122 */     if (!(obj instanceof RemoteFilter)) {
/* 123 */       return false;
/*     */     }
/* 125 */     RemoteFilter other = (RemoteFilter)obj;
/* 126 */     if (obj == null) {
/* 127 */       return false;
/*     */     }
/* 129 */     if (this == obj) {
/* 130 */       return true;
/*     */     }
/* 132 */     if (this.__equalsCalc != null) {
/* 133 */       return (this.__equalsCalc == obj);
/*     */     }
/* 135 */     this.__equalsCalc = obj;
/*     */     
/* 137 */     boolean _equals = (super.equals(obj) && ((
/* 138 */       this.author == null && other.getAuthor() == null) || (
/* 139 */       this.author != null && 
/* 140 */       this.author.equals(other.getAuthor()))) && ((
/* 141 */       this.description == null && other.getDescription() == null) || (
/* 142 */       this.description != null && 
/* 143 */       this.description.equals(other.getDescription()))) && ((
/* 144 */       this.project == null && other.getProject() == null) || (
/* 145 */       this.project != null && 
/* 146 */       this.project.equals(other.getProject()))) && ((
/* 147 */       this.xml == null && other.getXml() == null) || (
/* 148 */       this.xml != null && 
/* 149 */       this.xml.equals(other.getXml()))));
/* 150 */     this.__equalsCalc = null;
/* 151 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 157 */     if (this.__hashCodeCalc) {
/* 158 */       return 0;
/*     */     }
/* 160 */     this.__hashCodeCalc = true;
/* 161 */     int _hashCode = super.hashCode();
/* 162 */     if (getAuthor() != null) {
/* 163 */       _hashCode += getAuthor().hashCode();
/*     */     }
/* 165 */     if (getDescription() != null) {
/* 166 */       _hashCode += getDescription().hashCode();
/*     */     }
/* 168 */     if (getProject() != null) {
/* 169 */       _hashCode += getProject().hashCode();
/*     */     }
/* 171 */     if (getXml() != null) {
/* 172 */       _hashCode += getXml().hashCode();
/*     */     }
/* 174 */     this.__hashCodeCalc = false;
/* 175 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 180 */   private static TypeDesc typeDesc = new TypeDesc(RemoteFilter.class, true);
/*     */   
/*     */   static {
/* 183 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteFilter"));
/* 184 */     ElementDesc elemField = new ElementDesc();
/* 185 */     elemField.setFieldName("author");
/* 186 */     elemField.setXmlName(new QName("", "author"));
/* 187 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 188 */     elemField.setNillable(true);
/* 189 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 190 */     elemField = new ElementDesc();
/* 191 */     elemField.setFieldName("description");
/* 192 */     elemField.setXmlName(new QName("", "description"));
/* 193 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 194 */     elemField.setNillable(true);
/* 195 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 196 */     elemField = new ElementDesc();
/* 197 */     elemField.setFieldName("project");
/* 198 */     elemField.setXmlName(new QName("", "project"));
/* 199 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 200 */     elemField.setNillable(true);
/* 201 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 202 */     elemField = new ElementDesc();
/* 203 */     elemField.setFieldName("xml");
/* 204 */     elemField.setXmlName(new QName("", "xml"));
/* 205 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 206 */     elemField.setNillable(true);
/* 207 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 214 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 224 */     return 
/* 225 */       (Serializer)new BeanSerializer(
/* 226 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 236 */     return 
/* 237 */       (Deserializer)new BeanDeserializer(
/* 238 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteFilter() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */