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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RemoteWorklog
/*     */   implements Serializable
/*     */ {
/*     */   private String author;
/*     */   private String comment;
/*     */   private Calendar created;
/*     */   private String groupLevel;
/*     */   private String id;
/*     */   private String roleLevelId;
/*     */   private Calendar startDate;
/*     */   private String timeSpent;
/*     */   private long timeSpentInSeconds;
/*     */   private String updateAuthor;
/*     */   private Calendar updated;
/*     */   
/*     */   public RemoteWorklog(String author, String comment, Calendar created, String groupLevel, String id, String roleLevelId, Calendar startDate, String timeSpent, long timeSpentInSeconds, String updateAuthor, Calendar updated) {
/*  48 */     this.author = author;
/*  49 */     this.comment = comment;
/*  50 */     this.created = created;
/*  51 */     this.groupLevel = groupLevel;
/*  52 */     this.id = id;
/*  53 */     this.roleLevelId = roleLevelId;
/*  54 */     this.startDate = startDate;
/*  55 */     this.timeSpent = timeSpent;
/*  56 */     this.timeSpentInSeconds = timeSpentInSeconds;
/*  57 */     this.updateAuthor = updateAuthor;
/*  58 */     this.updated = updated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthor() {
/*  68 */     return this.author;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthor(String author) {
/*  78 */     this.author = author;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getComment() {
/*  88 */     return this.comment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComment(String comment) {
/*  98 */     this.comment = comment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getCreated() {
/* 108 */     return this.created;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreated(Calendar created) {
/* 118 */     this.created = created;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGroupLevel() {
/* 128 */     return this.groupLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupLevel(String groupLevel) {
/* 138 */     this.groupLevel = groupLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 148 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setId(String id) {
/* 158 */     this.id = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRoleLevelId() {
/* 168 */     return this.roleLevelId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRoleLevelId(String roleLevelId) {
/* 178 */     this.roleLevelId = roleLevelId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getStartDate() {
/* 188 */     return this.startDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartDate(Calendar startDate) {
/* 198 */     this.startDate = startDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTimeSpent() {
/* 208 */     return this.timeSpent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeSpent(String timeSpent) {
/* 218 */     this.timeSpent = timeSpent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTimeSpentInSeconds() {
/* 228 */     return this.timeSpentInSeconds;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeSpentInSeconds(long timeSpentInSeconds) {
/* 238 */     this.timeSpentInSeconds = timeSpentInSeconds;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateAuthor() {
/* 248 */     return this.updateAuthor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateAuthor(String updateAuthor) {
/* 258 */     this.updateAuthor = updateAuthor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getUpdated() {
/* 268 */     return this.updated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdated(Calendar updated) {
/* 278 */     this.updated = updated;
/*     */   }
/*     */   
/* 281 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/* 284 */     if (!(obj instanceof RemoteWorklog)) {
/* 285 */       return false;
/*     */     }
/* 287 */     RemoteWorklog other = (RemoteWorklog)obj;
/* 288 */     if (obj == null) {
/* 289 */       return false;
/*     */     }
/* 291 */     if (this == obj) {
/* 292 */       return true;
/*     */     }
/* 294 */     if (this.__equalsCalc != null) {
/* 295 */       return (this.__equalsCalc == obj);
/*     */     }
/* 297 */     this.__equalsCalc = obj;
/*     */     
/* 299 */     boolean _equals = 
/* 300 */       (((this.author == null && other.getAuthor() == null) || (
/* 301 */       this.author != null && 
/* 302 */       this.author.equals(other.getAuthor()))) && ((
/* 303 */       this.comment == null && other.getComment() == null) || (
/* 304 */       this.comment != null && 
/* 305 */       this.comment.equals(other.getComment()))) && ((
/* 306 */       this.created == null && other.getCreated() == null) || (
/* 307 */       this.created != null && 
/* 308 */       this.created.equals(other.getCreated()))) && ((
/* 309 */       this.groupLevel == null && other.getGroupLevel() == null) || (
/* 310 */       this.groupLevel != null && 
/* 311 */       this.groupLevel.equals(other.getGroupLevel()))) && ((
/* 312 */       this.id == null && other.getId() == null) || (
/* 313 */       this.id != null && 
/* 314 */       this.id.equals(other.getId()))) && ((
/* 315 */       this.roleLevelId == null && other.getRoleLevelId() == null) || (
/* 316 */       this.roleLevelId != null && 
/* 317 */       this.roleLevelId.equals(other.getRoleLevelId()))) && ((
/* 318 */       this.startDate == null && other.getStartDate() == null) || (
/* 319 */       this.startDate != null && 
/* 320 */       this.startDate.equals(other.getStartDate()))) && ((
/* 321 */       this.timeSpent == null && other.getTimeSpent() == null) || (
/* 322 */       this.timeSpent != null && 
/* 323 */       this.timeSpent.equals(other.getTimeSpent()))) && 
/* 324 */       this.timeSpentInSeconds == other.getTimeSpentInSeconds() && ((
/* 325 */       this.updateAuthor == null && other.getUpdateAuthor() == null) || (
/* 326 */       this.updateAuthor != null && 
/* 327 */       this.updateAuthor.equals(other.getUpdateAuthor()))) && ((
/* 328 */       this.updated == null && other.getUpdated() == null) || (
/* 329 */       this.updated != null && 
/* 330 */       this.updated.equals(other.getUpdated()))));
/* 331 */     this.__equalsCalc = null;
/* 332 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 338 */     if (this.__hashCodeCalc) {
/* 339 */       return 0;
/*     */     }
/* 341 */     this.__hashCodeCalc = true;
/* 342 */     int _hashCode = 1;
/* 343 */     if (getAuthor() != null) {
/* 344 */       _hashCode += getAuthor().hashCode();
/*     */     }
/* 346 */     if (getComment() != null) {
/* 347 */       _hashCode += getComment().hashCode();
/*     */     }
/* 349 */     if (getCreated() != null) {
/* 350 */       _hashCode += getCreated().hashCode();
/*     */     }
/* 352 */     if (getGroupLevel() != null) {
/* 353 */       _hashCode += getGroupLevel().hashCode();
/*     */     }
/* 355 */     if (getId() != null) {
/* 356 */       _hashCode += getId().hashCode();
/*     */     }
/* 358 */     if (getRoleLevelId() != null) {
/* 359 */       _hashCode += getRoleLevelId().hashCode();
/*     */     }
/* 361 */     if (getStartDate() != null) {
/* 362 */       _hashCode += getStartDate().hashCode();
/*     */     }
/* 364 */     if (getTimeSpent() != null) {
/* 365 */       _hashCode += getTimeSpent().hashCode();
/*     */     }
/* 367 */     _hashCode += (new Long(getTimeSpentInSeconds())).hashCode();
/* 368 */     if (getUpdateAuthor() != null) {
/* 369 */       _hashCode += getUpdateAuthor().hashCode();
/*     */     }
/* 371 */     if (getUpdated() != null) {
/* 372 */       _hashCode += getUpdated().hashCode();
/*     */     }
/* 374 */     this.__hashCodeCalc = false;
/* 375 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 380 */   private static TypeDesc typeDesc = new TypeDesc(RemoteWorklog.class, true);
/*     */   
/*     */   static {
/* 383 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog"));
/* 384 */     ElementDesc elemField = new ElementDesc();
/* 385 */     elemField.setFieldName("author");
/* 386 */     elemField.setXmlName(new QName("", "author"));
/* 387 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 388 */     elemField.setNillable(true);
/* 389 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 390 */     elemField = new ElementDesc();
/* 391 */     elemField.setFieldName("comment");
/* 392 */     elemField.setXmlName(new QName("", "comment"));
/* 393 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 394 */     elemField.setNillable(true);
/* 395 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 396 */     elemField = new ElementDesc();
/* 397 */     elemField.setFieldName("created");
/* 398 */     elemField.setXmlName(new QName("", "created"));
/* 399 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
/* 400 */     elemField.setNillable(true);
/* 401 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 402 */     elemField = new ElementDesc();
/* 403 */     elemField.setFieldName("groupLevel");
/* 404 */     elemField.setXmlName(new QName("", "groupLevel"));
/* 405 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 406 */     elemField.setNillable(true);
/* 407 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 408 */     elemField = new ElementDesc();
/* 409 */     elemField.setFieldName("id");
/* 410 */     elemField.setXmlName(new QName("", "id"));
/* 411 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 412 */     elemField.setNillable(true);
/* 413 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 414 */     elemField = new ElementDesc();
/* 415 */     elemField.setFieldName("roleLevelId");
/* 416 */     elemField.setXmlName(new QName("", "roleLevelId"));
/* 417 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 418 */     elemField.setNillable(true);
/* 419 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 420 */     elemField = new ElementDesc();
/* 421 */     elemField.setFieldName("startDate");
/* 422 */     elemField.setXmlName(new QName("", "startDate"));
/* 423 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
/* 424 */     elemField.setNillable(true);
/* 425 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 426 */     elemField = new ElementDesc();
/* 427 */     elemField.setFieldName("timeSpent");
/* 428 */     elemField.setXmlName(new QName("", "timeSpent"));
/* 429 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 430 */     elemField.setNillable(true);
/* 431 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 432 */     elemField = new ElementDesc();
/* 433 */     elemField.setFieldName("timeSpentInSeconds");
/* 434 */     elemField.setXmlName(new QName("", "timeSpentInSeconds"));
/* 435 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 436 */     elemField.setNillable(false);
/* 437 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 438 */     elemField = new ElementDesc();
/* 439 */     elemField.setFieldName("updateAuthor");
/* 440 */     elemField.setXmlName(new QName("", "updateAuthor"));
/* 441 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 442 */     elemField.setNillable(true);
/* 443 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 444 */     elemField = new ElementDesc();
/* 445 */     elemField.setFieldName("updated");
/* 446 */     elemField.setXmlName(new QName("", "updated"));
/* 447 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
/* 448 */     elemField.setNillable(true);
/* 449 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 456 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 466 */     return 
/* 467 */       (Serializer)new BeanSerializer(
/* 468 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 478 */     return 
/* 479 */       (Deserializer)new BeanDeserializer(
/* 480 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteWorklog() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteWorklog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */