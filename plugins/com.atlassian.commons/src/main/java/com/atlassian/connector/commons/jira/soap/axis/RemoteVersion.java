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
/*     */ public class RemoteVersion
/*     */   extends AbstractNamedRemoteEntity
/*     */   implements Serializable
/*     */ {
/*     */   private boolean archived;
/*     */   private Calendar releaseDate;
/*     */   private boolean released;
/*     */   private Long sequence;
/*     */   
/*     */   public RemoteVersion(String id, String name, boolean archived, Calendar releaseDate, boolean released, Long sequence) {
/*  32 */     super(id, name);
/*  33 */     this.archived = archived;
/*  34 */     this.releaseDate = releaseDate;
/*  35 */     this.released = released;
/*  36 */     this.sequence = sequence;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isArchived() {
/*  46 */     return this.archived;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setArchived(boolean archived) {
/*  56 */     this.archived = archived;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getReleaseDate() {
/*  66 */     return this.releaseDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReleaseDate(Calendar releaseDate) {
/*  76 */     this.releaseDate = releaseDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReleased() {
/*  86 */     return this.released;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReleased(boolean released) {
/*  96 */     this.released = released;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getSequence() {
/* 106 */     return this.sequence;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(Long sequence) {
/* 116 */     this.sequence = sequence;
/*     */   }
/*     */   
/* 119 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/* 122 */     if (!(obj instanceof RemoteVersion)) {
/* 123 */       return false;
/*     */     }
/* 125 */     RemoteVersion other = (RemoteVersion)obj;
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
/* 137 */     boolean _equals = (super.equals(obj) && 
/* 138 */       this.archived == other.isArchived() && ((
/* 139 */       this.releaseDate == null && other.getReleaseDate() == null) || (
/* 140 */       this.releaseDate != null && 
/* 141 */       this.releaseDate.equals(other.getReleaseDate()))) && 
/* 142 */       this.released == other.isReleased() && ((
/* 143 */       this.sequence == null && other.getSequence() == null) || (
/* 144 */       this.sequence != null && 
/* 145 */       this.sequence.equals(other.getSequence()))));
/* 146 */     this.__equalsCalc = null;
/* 147 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 153 */     if (this.__hashCodeCalc) {
/* 154 */       return 0;
/*     */     }
/* 156 */     this.__hashCodeCalc = true;
/* 157 */     int _hashCode = super.hashCode();
/* 158 */     _hashCode += (isArchived() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 159 */     if (getReleaseDate() != null) {
/* 160 */       _hashCode += getReleaseDate().hashCode();
/*     */     }
/* 162 */     _hashCode += (isReleased() ? Boolean.TRUE : Boolean.FALSE).hashCode();
/* 163 */     if (getSequence() != null) {
/* 164 */       _hashCode += getSequence().hashCode();
/*     */     }
/* 166 */     this.__hashCodeCalc = false;
/* 167 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 172 */   private static TypeDesc typeDesc = new TypeDesc(RemoteVersion.class, true);
/*     */   
/*     */   static {
/* 175 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteVersion"));
/* 176 */     ElementDesc elemField = new ElementDesc();
/* 177 */     elemField.setFieldName("archived");
/* 178 */     elemField.setXmlName(new QName("", "archived"));
/* 179 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 180 */     elemField.setNillable(false);
/* 181 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 182 */     elemField = new ElementDesc();
/* 183 */     elemField.setFieldName("releaseDate");
/* 184 */     elemField.setXmlName(new QName("", "releaseDate"));
/* 185 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
/* 186 */     elemField.setNillable(true);
/* 187 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 188 */     elemField = new ElementDesc();
/* 189 */     elemField.setFieldName("released");
/* 190 */     elemField.setXmlName(new QName("", "released"));
/* 191 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 192 */     elemField.setNillable(false);
/* 193 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 194 */     elemField = new ElementDesc();
/* 195 */     elemField.setFieldName("sequence");
/* 196 */     elemField.setXmlName(new QName("", "sequence"));
/* 197 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 198 */     elemField.setNillable(true);
/* 199 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 206 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 216 */     return 
/* 217 */       (Serializer)new BeanSerializer(
/* 218 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 228 */     return 
/* 229 */       (Deserializer)new BeanDeserializer(
/* 230 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteVersion() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteVersion.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */