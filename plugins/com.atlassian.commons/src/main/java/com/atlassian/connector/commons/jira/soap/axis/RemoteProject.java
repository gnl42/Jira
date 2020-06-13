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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RemoteProject
/*     */   extends AbstractNamedRemoteEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String description;
/*     */   private RemoteScheme issueSecurityScheme;
/*     */   private String key;
/*     */   private String lead;
/*     */   private RemoteScheme notificationScheme;
/*     */   private RemotePermissionScheme permissionScheme;
/*     */   private String projectUrl;
/*     */   private String url;
/*     */   
/*     */   public RemoteProject(String id, String name, String description, RemoteScheme issueSecurityScheme, String key, String lead, RemoteScheme notificationScheme, RemotePermissionScheme permissionScheme, String projectUrl, String url) {
/*  44 */     super(id, name);
/*  45 */     this.description = description;
/*  46 */     this.issueSecurityScheme = issueSecurityScheme;
/*  47 */     this.key = key;
/*  48 */     this.lead = lead;
/*  49 */     this.notificationScheme = notificationScheme;
/*  50 */     this.permissionScheme = permissionScheme;
/*  51 */     this.projectUrl = projectUrl;
/*  52 */     this.url = url;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  62 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String description) {
/*  72 */     this.description = description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteScheme getIssueSecurityScheme() {
/*  82 */     return this.issueSecurityScheme;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIssueSecurityScheme(RemoteScheme issueSecurityScheme) {
/*  92 */     this.issueSecurityScheme = issueSecurityScheme;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKey() {
/* 102 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(String key) {
/* 112 */     this.key = key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLead() {
/* 122 */     return this.lead;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLead(String lead) {
/* 132 */     this.lead = lead;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteScheme getNotificationScheme() {
/* 142 */     return this.notificationScheme;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotificationScheme(RemoteScheme notificationScheme) {
/* 152 */     this.notificationScheme = notificationScheme;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemotePermissionScheme getPermissionScheme() {
/* 162 */     return this.permissionScheme;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPermissionScheme(RemotePermissionScheme permissionScheme) {
/* 172 */     this.permissionScheme = permissionScheme;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getProjectUrl() {
/* 182 */     return this.projectUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProjectUrl(String projectUrl) {
/* 192 */     this.projectUrl = projectUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUrl() {
/* 202 */     return this.url;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUrl(String url) {
/* 212 */     this.url = url;
/*     */   }
/*     */   
/* 215 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/* 218 */     if (!(obj instanceof RemoteProject)) {
/* 219 */       return false;
/*     */     }
/* 221 */     RemoteProject other = (RemoteProject)obj;
/* 222 */     if (obj == null) {
/* 223 */       return false;
/*     */     }
/* 225 */     if (this == obj) {
/* 226 */       return true;
/*     */     }
/* 228 */     if (this.__equalsCalc != null) {
/* 229 */       return (this.__equalsCalc == obj);
/*     */     }
/* 231 */     this.__equalsCalc = obj;
/*     */     
/* 233 */     boolean _equals = (super.equals(obj) && ((
/* 234 */       this.description == null && other.getDescription() == null) || (
/* 235 */       this.description != null && 
/* 236 */       this.description.equals(other.getDescription()))) && ((
/* 237 */       this.issueSecurityScheme == null && other.getIssueSecurityScheme() == null) || (
/* 238 */       this.issueSecurityScheme != null && 
/* 239 */       this.issueSecurityScheme.equals(other.getIssueSecurityScheme()))) && ((
/* 240 */       this.key == null && other.getKey() == null) || (
/* 241 */       this.key != null && 
/* 242 */       this.key.equals(other.getKey()))) && ((
/* 243 */       this.lead == null && other.getLead() == null) || (
/* 244 */       this.lead != null && 
/* 245 */       this.lead.equals(other.getLead()))) && ((
/* 246 */       this.notificationScheme == null && other.getNotificationScheme() == null) || (
/* 247 */       this.notificationScheme != null && 
/* 248 */       this.notificationScheme.equals(other.getNotificationScheme()))) && ((
/* 249 */       this.permissionScheme == null && other.getPermissionScheme() == null) || (
/* 250 */       this.permissionScheme != null && 
/* 251 */       this.permissionScheme.equals(other.getPermissionScheme()))) && ((
/* 252 */       this.projectUrl == null && other.getProjectUrl() == null) || (
/* 253 */       this.projectUrl != null && 
/* 254 */       this.projectUrl.equals(other.getProjectUrl()))) && ((
/* 255 */       this.url == null && other.getUrl() == null) || (
/* 256 */       this.url != null && 
/* 257 */       this.url.equals(other.getUrl()))));
/* 258 */     this.__equalsCalc = null;
/* 259 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 265 */     if (this.__hashCodeCalc) {
/* 266 */       return 0;
/*     */     }
/* 268 */     this.__hashCodeCalc = true;
/* 269 */     int _hashCode = super.hashCode();
/* 270 */     if (getDescription() != null) {
/* 271 */       _hashCode += getDescription().hashCode();
/*     */     }
/* 273 */     if (getIssueSecurityScheme() != null) {
/* 274 */       _hashCode += getIssueSecurityScheme().hashCode();
/*     */     }
/* 276 */     if (getKey() != null) {
/* 277 */       _hashCode += getKey().hashCode();
/*     */     }
/* 279 */     if (getLead() != null) {
/* 280 */       _hashCode += getLead().hashCode();
/*     */     }
/* 282 */     if (getNotificationScheme() != null) {
/* 283 */       _hashCode += getNotificationScheme().hashCode();
/*     */     }
/* 285 */     if (getPermissionScheme() != null) {
/* 286 */       _hashCode += getPermissionScheme().hashCode();
/*     */     }
/* 288 */     if (getProjectUrl() != null) {
/* 289 */       _hashCode += getProjectUrl().hashCode();
/*     */     }
/* 291 */     if (getUrl() != null) {
/* 292 */       _hashCode += getUrl().hashCode();
/*     */     }
/* 294 */     this.__hashCodeCalc = false;
/* 295 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 300 */   private static TypeDesc typeDesc = new TypeDesc(RemoteProject.class, true);
/*     */   
/*     */   static {
/* 303 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"));
/* 304 */     ElementDesc elemField = new ElementDesc();
/* 305 */     elemField.setFieldName("description");
/* 306 */     elemField.setXmlName(new QName("", "description"));
/* 307 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 308 */     elemField.setNillable(true);
/* 309 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 310 */     elemField = new ElementDesc();
/* 311 */     elemField.setFieldName("issueSecurityScheme");
/* 312 */     elemField.setXmlName(new QName("", "issueSecurityScheme"));
/* 313 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteScheme"));
/* 314 */     elemField.setNillable(true);
/* 315 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 316 */     elemField = new ElementDesc();
/* 317 */     elemField.setFieldName("key");
/* 318 */     elemField.setXmlName(new QName("", "key"));
/* 319 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 320 */     elemField.setNillable(true);
/* 321 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 322 */     elemField = new ElementDesc();
/* 323 */     elemField.setFieldName("lead");
/* 324 */     elemField.setXmlName(new QName("", "lead"));
/* 325 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 326 */     elemField.setNillable(true);
/* 327 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 328 */     elemField = new ElementDesc();
/* 329 */     elemField.setFieldName("notificationScheme");
/* 330 */     elemField.setXmlName(new QName("", "notificationScheme"));
/* 331 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteScheme"));
/* 332 */     elemField.setNillable(true);
/* 333 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 334 */     elemField = new ElementDesc();
/* 335 */     elemField.setFieldName("permissionScheme");
/* 336 */     elemField.setXmlName(new QName("", "permissionScheme"));
/* 337 */     elemField.setXmlType(
/* 338 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"));
/* 339 */     elemField.setNillable(true);
/* 340 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 341 */     elemField = new ElementDesc();
/* 342 */     elemField.setFieldName("projectUrl");
/* 343 */     elemField.setXmlName(new QName("", "projectUrl"));
/* 344 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 345 */     elemField.setNillable(true);
/* 346 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 347 */     elemField = new ElementDesc();
/* 348 */     elemField.setFieldName("url");
/* 349 */     elemField.setXmlName(new QName("", "url"));
/* 350 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 351 */     elemField.setNillable(true);
/* 352 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 359 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 369 */     return 
/* 370 */       (Serializer)new BeanSerializer(
/* 371 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 381 */     return 
/* 382 */       (Deserializer)new BeanDeserializer(
/* 383 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteProject() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteProject.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */