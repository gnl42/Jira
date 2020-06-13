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
/*     */ public class RemoteConfiguration
/*     */   implements Serializable
/*     */ {
/*     */   private boolean allowAttachments;
/*     */   private boolean allowExternalUserManagment;
/*     */   private boolean allowIssueLinking;
/*     */   private boolean allowSubTasks;
/*     */   private boolean allowTimeTracking;
/*     */   private boolean allowUnassignedIssues;
/*     */   private boolean allowVoting;
/*     */   private boolean allowWatching;
/*     */   private int timeTrackingDaysPerWeek;
/*     */   private int timeTrackingHoursPerDay;
/*     */   
/*     */   public RemoteConfiguration(boolean allowAttachments, boolean allowExternalUserManagment, boolean allowIssueLinking, boolean allowSubTasks, boolean allowTimeTracking, boolean allowUnassignedIssues, boolean allowVoting, boolean allowWatching, int timeTrackingDaysPerWeek, int timeTrackingHoursPerDay) {
/*  45 */     this.allowAttachments = allowAttachments;
/*  46 */     this.allowExternalUserManagment = allowExternalUserManagment;
/*  47 */     this.allowIssueLinking = allowIssueLinking;
/*  48 */     this.allowSubTasks = allowSubTasks;
/*  49 */     this.allowTimeTracking = allowTimeTracking;
/*  50 */     this.allowUnassignedIssues = allowUnassignedIssues;
/*  51 */     this.allowVoting = allowVoting;
/*  52 */     this.allowWatching = allowWatching;
/*  53 */     this.timeTrackingDaysPerWeek = timeTrackingDaysPerWeek;
/*  54 */     this.timeTrackingHoursPerDay = timeTrackingHoursPerDay;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowAttachments() {
/*  64 */     return this.allowAttachments;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllowAttachments(boolean allowAttachments) {
/*  74 */     this.allowAttachments = allowAttachments;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowExternalUserManagment() {
/*  84 */     return this.allowExternalUserManagment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllowExternalUserManagment(boolean allowExternalUserManagment) {
/*  94 */     this.allowExternalUserManagment = allowExternalUserManagment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowIssueLinking() {
/* 104 */     return this.allowIssueLinking;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllowIssueLinking(boolean allowIssueLinking) {
/* 114 */     this.allowIssueLinking = allowIssueLinking;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowSubTasks() {
/* 124 */     return this.allowSubTasks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllowSubTasks(boolean allowSubTasks) {
/* 134 */     this.allowSubTasks = allowSubTasks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowTimeTracking() {
/* 144 */     return this.allowTimeTracking;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllowTimeTracking(boolean allowTimeTracking) {
/* 154 */     this.allowTimeTracking = allowTimeTracking;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowUnassignedIssues() {
/* 164 */     return this.allowUnassignedIssues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllowUnassignedIssues(boolean allowUnassignedIssues) {
/* 174 */     this.allowUnassignedIssues = allowUnassignedIssues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowVoting() {
/* 184 */     return this.allowVoting;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllowVoting(boolean allowVoting) {
/* 194 */     this.allowVoting = allowVoting;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowWatching() {
/* 204 */     return this.allowWatching;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllowWatching(boolean allowWatching) {
/* 214 */     this.allowWatching = allowWatching;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTimeTrackingDaysPerWeek() {
/* 224 */     return this.timeTrackingDaysPerWeek;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeTrackingDaysPerWeek(int timeTrackingDaysPerWeek) {
/* 234 */     this.timeTrackingDaysPerWeek = timeTrackingDaysPerWeek;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTimeTrackingHoursPerDay() {
/* 244 */     return this.timeTrackingHoursPerDay;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeTrackingHoursPerDay(int timeTrackingHoursPerDay) {
/* 254 */     this.timeTrackingHoursPerDay = timeTrackingHoursPerDay;
/*     */   }
/*     */   
/* 257 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/* 260 */     if (!(obj instanceof RemoteConfiguration)) {
/* 261 */       return false;
/*     */     }
/* 263 */     RemoteConfiguration other = (RemoteConfiguration)obj;
/* 264 */     if (obj == null) {
/* 265 */       return false;
/*     */     }
/* 267 */     if (this == obj) {
/* 268 */       return true;
/*     */     }
/* 270 */     if (this.__equalsCalc != null) {
/* 271 */       return (this.__equalsCalc == obj);
/*     */     }
/* 273 */     this.__equalsCalc = obj;
/*     */     
/* 275 */     boolean _equals = 
/* 276 */       (this.allowAttachments == other.isAllowAttachments() && 
/* 277 */       this.allowExternalUserManagment == other.isAllowExternalUserManagment() && 
/* 278 */       this.allowIssueLinking == other.isAllowIssueLinking() && 
/* 279 */       this.allowSubTasks == other.isAllowSubTasks() && 
/* 280 */       this.allowTimeTracking == other.isAllowTimeTracking() && 
/* 281 */       this.allowUnassignedIssues == other.isAllowUnassignedIssues() && 
/* 282 */       this.allowVoting == other.isAllowVoting() && 
/* 283 */       this.allowWatching == other.isAllowWatching() && 
/* 284 */       this.timeTrackingDaysPerWeek == other.getTimeTrackingDaysPerWeek() && 
/* 285 */       this.timeTrackingHoursPerDay == other.getTimeTrackingHoursPerDay());
/* 286 */     this.__equalsCalc = null;
/* 287 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 293 */     if (this.__hashCodeCalc) {
/* 294 */       return 0;
/*     */     }
/* 296 */     this.__hashCodeCalc = true;
/* 297 */     int _hashCode = 1;
/* 298 */     _hashCode += (isAllowAttachments() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 299 */     _hashCode += (isAllowExternalUserManagment() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 300 */     _hashCode += (isAllowIssueLinking() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 301 */     _hashCode += (isAllowSubTasks() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 302 */     _hashCode += (isAllowTimeTracking() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 303 */     _hashCode += (isAllowUnassignedIssues() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 304 */     _hashCode += (isAllowVoting() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 305 */     _hashCode += (isAllowWatching() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 306 */     _hashCode += getTimeTrackingDaysPerWeek();
/* 307 */     _hashCode += getTimeTrackingHoursPerDay();
/* 308 */     this.__hashCodeCalc = false;
/* 309 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 314 */   private static TypeDesc typeDesc = new TypeDesc(RemoteConfiguration.class, true);
/*     */   
/*     */   static {
/* 317 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteConfiguration"));
/* 318 */     ElementDesc elemField = new ElementDesc();
/* 319 */     elemField.setFieldName("allowAttachments");
/* 320 */     elemField.setXmlName(new QName("", "allowAttachments"));
/* 321 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 322 */     elemField.setNillable(false);
/* 323 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 324 */     elemField = new ElementDesc();
/* 325 */     elemField.setFieldName("allowExternalUserManagment");
/* 326 */     elemField.setXmlName(new QName("", "allowExternalUserManagment"));
/* 327 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 328 */     elemField.setNillable(false);
/* 329 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 330 */     elemField = new ElementDesc();
/* 331 */     elemField.setFieldName("allowIssueLinking");
/* 332 */     elemField.setXmlName(new QName("", "allowIssueLinking"));
/* 333 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 334 */     elemField.setNillable(false);
/* 335 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 336 */     elemField = new ElementDesc();
/* 337 */     elemField.setFieldName("allowSubTasks");
/* 338 */     elemField.setXmlName(new QName("", "allowSubTasks"));
/* 339 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 340 */     elemField.setNillable(false);
/* 341 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 342 */     elemField = new ElementDesc();
/* 343 */     elemField.setFieldName("allowTimeTracking");
/* 344 */     elemField.setXmlName(new QName("", "allowTimeTracking"));
/* 345 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 346 */     elemField.setNillable(false);
/* 347 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 348 */     elemField = new ElementDesc();
/* 349 */     elemField.setFieldName("allowUnassignedIssues");
/* 350 */     elemField.setXmlName(new QName("", "allowUnassignedIssues"));
/* 351 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 352 */     elemField.setNillable(false);
/* 353 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 354 */     elemField = new ElementDesc();
/* 355 */     elemField.setFieldName("allowVoting");
/* 356 */     elemField.setXmlName(new QName("", "allowVoting"));
/* 357 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 358 */     elemField.setNillable(false);
/* 359 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 360 */     elemField = new ElementDesc();
/* 361 */     elemField.setFieldName("allowWatching");
/* 362 */     elemField.setXmlName(new QName("", "allowWatching"));
/* 363 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 364 */     elemField.setNillable(false);
/* 365 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 366 */     elemField = new ElementDesc();
/* 367 */     elemField.setFieldName("timeTrackingDaysPerWeek");
/* 368 */     elemField.setXmlName(new QName("", "timeTrackingDaysPerWeek"));
/* 369 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
/* 370 */     elemField.setNillable(false);
/* 371 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 372 */     elemField = new ElementDesc();
/* 373 */     elemField.setFieldName("timeTrackingHoursPerDay");
/* 374 */     elemField.setXmlName(new QName("", "timeTrackingHoursPerDay"));
/* 375 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
/* 376 */     elemField.setNillable(false);
/* 377 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 384 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 394 */     return 
/* 395 */       (Serializer)new BeanSerializer(
/* 396 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 406 */     return 
/* 407 */       (Deserializer)new BeanDeserializer(
/* 408 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteConfiguration() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteConfiguration.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */