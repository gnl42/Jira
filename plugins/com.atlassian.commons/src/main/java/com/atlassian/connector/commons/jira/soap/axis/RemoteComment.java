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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RemoteComment
/*     */   implements Serializable
/*     */ {
/*     */   private String author;
/*     */   private String body;
/*     */   private Calendar created;
/*     */   private String groupLevel;
/*     */   private String id;
/*     */   private String roleLevel;
/*     */   private String updateAuthor;
/*     */   private Calendar updated;
/*     */   
/*     */   public RemoteComment(String author, String body, Calendar created, String groupLevel, String id, String roleLevel, String updateAuthor, Calendar updated) {
/*  39 */     this.author = author;
/*  40 */     this.body = body;
/*  41 */     this.created = created;
/*  42 */     this.groupLevel = groupLevel;
/*  43 */     this.id = id;
/*  44 */     this.roleLevel = roleLevel;
/*  45 */     this.updateAuthor = updateAuthor;
/*  46 */     this.updated = updated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthor() {
/*  56 */     return this.author;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthor(String author) {
/*  66 */     this.author = author;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBody() {
/*  76 */     return this.body;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBody(String body) {
/*  86 */     this.body = body;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getCreated() {
/*  96 */     return this.created;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreated(Calendar created) {
/* 106 */     this.created = created;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGroupLevel() {
/* 116 */     return this.groupLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupLevel(String groupLevel) {
/* 126 */     this.groupLevel = groupLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 136 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setId(String id) {
/* 146 */     this.id = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRoleLevel() {
/* 156 */     return this.roleLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRoleLevel(String roleLevel) {
/* 166 */     this.roleLevel = roleLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateAuthor() {
/* 176 */     return this.updateAuthor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateAuthor(String updateAuthor) {
/* 186 */     this.updateAuthor = updateAuthor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getUpdated() {
/* 196 */     return this.updated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdated(Calendar updated) {
/* 206 */     this.updated = updated;
/*     */   }
/*     */   
/* 209 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/* 212 */     if (!(obj instanceof RemoteComment)) {
/* 213 */       return false;
/*     */     }
/* 215 */     RemoteComment other = (RemoteComment)obj;
/* 216 */     if (obj == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (this == obj) {
/* 220 */       return true;
/*     */     }
/* 222 */     if (this.__equalsCalc != null) {
/* 223 */       return (this.__equalsCalc == obj);
/*     */     }
/* 225 */     this.__equalsCalc = obj;
/*     */     
/* 227 */     boolean _equals = 
/* 228 */       (((this.author == null && other.getAuthor() == null) || (
/* 229 */       this.author != null && 
/* 230 */       this.author.equals(other.getAuthor()))) && ((
/* 231 */       this.body == null && other.getBody() == null) || (
/* 232 */       this.body != null && 
/* 233 */       this.body.equals(other.getBody()))) && ((
/* 234 */       this.created == null && other.getCreated() == null) || (
/* 235 */       this.created != null && 
/* 236 */       this.created.equals(other.getCreated()))) && ((
/* 237 */       this.groupLevel == null && other.getGroupLevel() == null) || (
/* 238 */       this.groupLevel != null && 
/* 239 */       this.groupLevel.equals(other.getGroupLevel()))) && ((
/* 240 */       this.id == null && other.getId() == null) || (
/* 241 */       this.id != null && 
/* 242 */       this.id.equals(other.getId()))) && ((
/* 243 */       this.roleLevel == null && other.getRoleLevel() == null) || (
/* 244 */       this.roleLevel != null && 
/* 245 */       this.roleLevel.equals(other.getRoleLevel()))) && ((
/* 246 */       this.updateAuthor == null && other.getUpdateAuthor() == null) || (
/* 247 */       this.updateAuthor != null && 
/* 248 */       this.updateAuthor.equals(other.getUpdateAuthor()))) && ((
/* 249 */       this.updated == null && other.getUpdated() == null) || (
/* 250 */       this.updated != null && 
/* 251 */       this.updated.equals(other.getUpdated()))));
/* 252 */     this.__equalsCalc = null;
/* 253 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 259 */     if (this.__hashCodeCalc) {
/* 260 */       return 0;
/*     */     }
/* 262 */     this.__hashCodeCalc = true;
/* 263 */     int _hashCode = 1;
/* 264 */     if (getAuthor() != null) {
/* 265 */       _hashCode += getAuthor().hashCode();
/*     */     }
/* 267 */     if (getBody() != null) {
/* 268 */       _hashCode += getBody().hashCode();
/*     */     }
/* 270 */     if (getCreated() != null) {
/* 271 */       _hashCode += getCreated().hashCode();
/*     */     }
/* 273 */     if (getGroupLevel() != null) {
/* 274 */       _hashCode += getGroupLevel().hashCode();
/*     */     }
/* 276 */     if (getId() != null) {
/* 277 */       _hashCode += getId().hashCode();
/*     */     }
/* 279 */     if (getRoleLevel() != null) {
/* 280 */       _hashCode += getRoleLevel().hashCode();
/*     */     }
/* 282 */     if (getUpdateAuthor() != null) {
/* 283 */       _hashCode += getUpdateAuthor().hashCode();
/*     */     }
/* 285 */     if (getUpdated() != null) {
/* 286 */       _hashCode += getUpdated().hashCode();
/*     */     }
/* 288 */     this.__hashCodeCalc = false;
/* 289 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 294 */   private static TypeDesc typeDesc = new TypeDesc(RemoteComment.class, true);
/*     */   
/*     */   static {
/* 297 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComment"));
/* 298 */     ElementDesc elemField = new ElementDesc();
/* 299 */     elemField.setFieldName("author");
/* 300 */     elemField.setXmlName(new QName("", "author"));
/* 301 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 302 */     elemField.setNillable(true);
/* 303 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 304 */     elemField = new ElementDesc();
/* 305 */     elemField.setFieldName("body");
/* 306 */     elemField.setXmlName(new QName("", "body"));
/* 307 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 308 */     elemField.setNillable(true);
/* 309 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 310 */     elemField = new ElementDesc();
/* 311 */     elemField.setFieldName("created");
/* 312 */     elemField.setXmlName(new QName("", "created"));
/* 313 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
/* 314 */     elemField.setNillable(true);
/* 315 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 316 */     elemField = new ElementDesc();
/* 317 */     elemField.setFieldName("groupLevel");
/* 318 */     elemField.setXmlName(new QName("", "groupLevel"));
/* 319 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 320 */     elemField.setNillable(true);
/* 321 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 322 */     elemField = new ElementDesc();
/* 323 */     elemField.setFieldName("id");
/* 324 */     elemField.setXmlName(new QName("", "id"));
/* 325 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 326 */     elemField.setNillable(true);
/* 327 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 328 */     elemField = new ElementDesc();
/* 329 */     elemField.setFieldName("roleLevel");
/* 330 */     elemField.setXmlName(new QName("", "roleLevel"));
/* 331 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 332 */     elemField.setNillable(true);
/* 333 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 334 */     elemField = new ElementDesc();
/* 335 */     elemField.setFieldName("updateAuthor");
/* 336 */     elemField.setXmlName(new QName("", "updateAuthor"));
/* 337 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 338 */     elemField.setNillable(true);
/* 339 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 340 */     elemField = new ElementDesc();
/* 341 */     elemField.setFieldName("updated");
/* 342 */     elemField.setXmlName(new QName("", "updated"));
/* 343 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
/* 344 */     elemField.setNillable(true);
/* 345 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 352 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 362 */     return 
/* 363 */       (Serializer)new BeanSerializer(
/* 364 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 374 */     return 
/* 375 */       (Deserializer)new BeanDeserializer(
/* 376 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteComment() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteComment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */