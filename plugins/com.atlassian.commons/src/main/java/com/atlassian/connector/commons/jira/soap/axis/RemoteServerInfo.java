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
/*     */ public class RemoteServerInfo
/*     */   implements Serializable
/*     */ {
/*     */   private String baseUrl;
/*     */   private Calendar buildDate;
/*     */   private String buildNumber;
/*     */   private String edition;
/*     */   private RemoteTimeInfo serverTime;
/*     */   private String version;
/*     */   
/*     */   public RemoteServerInfo(String baseUrl, Calendar buildDate, String buildNumber, String edition, RemoteTimeInfo serverTime, String version) {
/*  33 */     this.baseUrl = baseUrl;
/*  34 */     this.buildDate = buildDate;
/*  35 */     this.buildNumber = buildNumber;
/*  36 */     this.edition = edition;
/*  37 */     this.serverTime = serverTime;
/*  38 */     this.version = version;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBaseUrl() {
/*  48 */     return this.baseUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseUrl(String baseUrl) {
/*  58 */     this.baseUrl = baseUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getBuildDate() {
/*  68 */     return this.buildDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuildDate(Calendar buildDate) {
/*  78 */     this.buildDate = buildDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBuildNumber() {
/*  88 */     return this.buildNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuildNumber(String buildNumber) {
/*  98 */     this.buildNumber = buildNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEdition() {
/* 108 */     return this.edition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEdition(String edition) {
/* 118 */     this.edition = edition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteTimeInfo getServerTime() {
/* 128 */     return this.serverTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServerTime(RemoteTimeInfo serverTime) {
/* 138 */     this.serverTime = serverTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVersion() {
/* 148 */     return this.version;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVersion(String version) {
/* 158 */     this.version = version;
/*     */   }
/*     */   
/* 161 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/* 164 */     if (!(obj instanceof RemoteServerInfo)) {
/* 165 */       return false;
/*     */     }
/* 167 */     RemoteServerInfo other = (RemoteServerInfo)obj;
/* 168 */     if (obj == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this == obj) {
/* 172 */       return true;
/*     */     }
/* 174 */     if (this.__equalsCalc != null) {
/* 175 */       return (this.__equalsCalc == obj);
/*     */     }
/* 177 */     this.__equalsCalc = obj;
/*     */     
/* 179 */     boolean _equals = 
/* 180 */       (((this.baseUrl == null && other.getBaseUrl() == null) || (
/* 181 */       this.baseUrl != null && 
/* 182 */       this.baseUrl.equals(other.getBaseUrl()))) && ((
/* 183 */       this.buildDate == null && other.getBuildDate() == null) || (
/* 184 */       this.buildDate != null && 
/* 185 */       this.buildDate.equals(other.getBuildDate()))) && ((
/* 186 */       this.buildNumber == null && other.getBuildNumber() == null) || (
/* 187 */       this.buildNumber != null && 
/* 188 */       this.buildNumber.equals(other.getBuildNumber()))) && ((
/* 189 */       this.edition == null && other.getEdition() == null) || (
/* 190 */       this.edition != null && 
/* 191 */       this.edition.equals(other.getEdition()))) && ((
/* 192 */       this.serverTime == null && other.getServerTime() == null) || (
/* 193 */       this.serverTime != null && 
/* 194 */       this.serverTime.equals(other.getServerTime()))) && ((
/* 195 */       this.version == null && other.getVersion() == null) || (
/* 196 */       this.version != null && 
/* 197 */       this.version.equals(other.getVersion()))));
/* 198 */     this.__equalsCalc = null;
/* 199 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 205 */     if (this.__hashCodeCalc) {
/* 206 */       return 0;
/*     */     }
/* 208 */     this.__hashCodeCalc = true;
/* 209 */     int _hashCode = 1;
/* 210 */     if (getBaseUrl() != null) {
/* 211 */       _hashCode += getBaseUrl().hashCode();
/*     */     }
/* 213 */     if (getBuildDate() != null) {
/* 214 */       _hashCode += getBuildDate().hashCode();
/*     */     }
/* 216 */     if (getBuildNumber() != null) {
/* 217 */       _hashCode += getBuildNumber().hashCode();
/*     */     }
/* 219 */     if (getEdition() != null) {
/* 220 */       _hashCode += getEdition().hashCode();
/*     */     }
/* 222 */     if (getServerTime() != null) {
/* 223 */       _hashCode += getServerTime().hashCode();
/*     */     }
/* 225 */     if (getVersion() != null) {
/* 226 */       _hashCode += getVersion().hashCode();
/*     */     }
/* 228 */     this.__hashCodeCalc = false;
/* 229 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 234 */   private static TypeDesc typeDesc = new TypeDesc(RemoteServerInfo.class, true);
/*     */   
/*     */   static {
/* 237 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteServerInfo"));
/* 238 */     ElementDesc elemField = new ElementDesc();
/* 239 */     elemField.setFieldName("baseUrl");
/* 240 */     elemField.setXmlName(new QName("", "baseUrl"));
/* 241 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 242 */     elemField.setNillable(true);
/* 243 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 244 */     elemField = new ElementDesc();
/* 245 */     elemField.setFieldName("buildDate");
/* 246 */     elemField.setXmlName(new QName("", "buildDate"));
/* 247 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
/* 248 */     elemField.setNillable(true);
/* 249 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 250 */     elemField = new ElementDesc();
/* 251 */     elemField.setFieldName("buildNumber");
/* 252 */     elemField.setXmlName(new QName("", "buildNumber"));
/* 253 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 254 */     elemField.setNillable(true);
/* 255 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 256 */     elemField = new ElementDesc();
/* 257 */     elemField.setFieldName("edition");
/* 258 */     elemField.setXmlName(new QName("", "edition"));
/* 259 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 260 */     elemField.setNillable(true);
/* 261 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 262 */     elemField = new ElementDesc();
/* 263 */     elemField.setFieldName("serverTime");
/* 264 */     elemField.setXmlName(new QName("", "serverTime"));
/* 265 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteTimeInfo"));
/* 266 */     elemField.setNillable(true);
/* 267 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 268 */     elemField = new ElementDesc();
/* 269 */     elemField.setFieldName("version");
/* 270 */     elemField.setXmlName(new QName("", "version"));
/* 271 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 272 */     elemField.setNillable(true);
/* 273 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 280 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 290 */     return 
/* 291 */       (Serializer)new BeanSerializer(
/* 292 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 302 */     return 
/* 303 */       (Deserializer)new BeanDeserializer(
/* 304 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteServerInfo() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteServerInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */