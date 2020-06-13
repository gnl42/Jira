/*     */ package com.atlassian.connector.commons.jira.soap.axis;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Calendar;
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
/*     */ public class RemoteAttachment
/*     */   extends AbstractRemoteEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String author;
/*     */   private Calendar created;
/*     */   private String filename;
/*     */   private Long filesize;
/*     */   private String mimetype;
/*     */   
/*     */   public RemoteAttachment(String id, String author, Calendar created, String filename, Long filesize, String mimetype) {
/*  33 */     super(id);
/*  34 */     this.author = author;
/*  35 */     this.created = created;
/*  36 */     this.filename = filename;
/*  37 */     this.filesize = filesize;
/*  38 */     this.mimetype = mimetype;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthor() {
/*  48 */     return this.author;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthor(String author) {
/*  58 */     this.author = author;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getCreated() {
/*  68 */     return this.created;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreated(Calendar created) {
/*  78 */     this.created = created;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFilename() {
/*  88 */     return this.filename;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFilename(String filename) {
/*  98 */     this.filename = filename;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getFilesize() {
/* 108 */     return this.filesize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFilesize(Long filesize) {
/* 118 */     this.filesize = filesize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMimetype() {
/* 128 */     return this.mimetype;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMimetype(String mimetype) {
/* 138 */     this.mimetype = mimetype;
/*     */   }
/*     */   
/* 141 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/* 144 */     if (!(obj instanceof RemoteAttachment)) {
/* 145 */       return false;
/*     */     }
/* 147 */     RemoteAttachment other = (RemoteAttachment)obj;
/* 148 */     if (obj == null) {
/* 149 */       return false;
/*     */     }
/* 151 */     if (this == obj) {
/* 152 */       return true;
/*     */     }
/* 154 */     if (this.__equalsCalc != null) {
/* 155 */       return (this.__equalsCalc == obj);
/*     */     }
/* 157 */     this.__equalsCalc = obj;
/*     */     
/* 159 */     boolean _equals = (super.equals(obj) && ((
/* 160 */       this.author == null && other.getAuthor() == null) || (
/* 161 */       this.author != null && 
/* 162 */       this.author.equals(other.getAuthor()))) && ((
/* 163 */       this.created == null && other.getCreated() == null) || (
/* 164 */       this.created != null && 
/* 165 */       this.created.equals(other.getCreated()))) && ((
/* 166 */       this.filename == null && other.getFilename() == null) || (
/* 167 */       this.filename != null && 
/* 168 */       this.filename.equals(other.getFilename()))) && ((
/* 169 */       this.filesize == null && other.getFilesize() == null) || (
/* 170 */       this.filesize != null && 
/* 171 */       this.filesize.equals(other.getFilesize()))) && ((
/* 172 */       this.mimetype == null && other.getMimetype() == null) || (
/* 173 */       this.mimetype != null && 
/* 174 */       this.mimetype.equals(other.getMimetype()))));
/* 175 */     this.__equalsCalc = null;
/* 176 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 182 */     if (this.__hashCodeCalc) {
/* 183 */       return 0;
/*     */     }
/* 185 */     this.__hashCodeCalc = true;
/* 186 */     int _hashCode = super.hashCode();
/* 187 */     if (getAuthor() != null) {
/* 188 */       _hashCode += getAuthor().hashCode();
/*     */     }
/* 190 */     if (getCreated() != null) {
/* 191 */       _hashCode += getCreated().hashCode();
/*     */     }
/* 193 */     if (getFilename() != null) {
/* 194 */       _hashCode += getFilename().hashCode();
/*     */     }
/* 196 */     if (getFilesize() != null) {
/* 197 */       _hashCode += getFilesize().hashCode();
/*     */     }
/* 199 */     if (getMimetype() != null) {
/* 200 */       _hashCode += getMimetype().hashCode();
/*     */     }
/* 202 */     this.__hashCodeCalc = false;
/* 203 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 208 */   private static TypeDesc typeDesc = new TypeDesc(RemoteAttachment.class, true);
/*     */   
/*     */   static {
/* 211 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteAttachment"));
/* 212 */     ElementDesc elemField = new ElementDesc();
/* 213 */     elemField.setFieldName("author");
/* 214 */     elemField.setXmlName(new QName("", "author"));
/* 215 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 216 */     elemField.setNillable(true);
/* 217 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 218 */     elemField = new ElementDesc();
/* 219 */     elemField.setFieldName("created");
/* 220 */     elemField.setXmlName(new QName("", "created"));
/* 221 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
/* 222 */     elemField.setNillable(true);
/* 223 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 224 */     elemField = new ElementDesc();
/* 225 */     elemField.setFieldName("filename");
/* 226 */     elemField.setXmlName(new QName("", "filename"));
/* 227 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 228 */     elemField.setNillable(true);
/* 229 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 230 */     elemField = new ElementDesc();
/* 231 */     elemField.setFieldName("filesize");
/* 232 */     elemField.setXmlName(new QName("", "filesize"));
/* 233 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 234 */     elemField.setNillable(true);
/* 235 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 236 */     elemField = new ElementDesc();
/* 237 */     elemField.setFieldName("mimetype");
/* 238 */     elemField.setXmlName(new QName("", "mimetype"));
/* 239 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 240 */     elemField.setNillable(true);
/* 241 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 248 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 258 */     return 
/* 259 */       (Serializer)new BeanSerializer(
/* 260 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 270 */     return 
/* 271 */       (Deserializer)new BeanDeserializer(
/* 272 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteAttachment() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteAttachment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */