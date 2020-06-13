/*     */ package com.atlassian.theplugin.commons.crucible.api.model;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class CrucibleVersionInfo
/*     */   implements Serializable, Comparable<CrucibleVersionInfo>
/*     */ {
/*     */   private final String buildDate;
/*     */   private final String releaseNumber;
/*     */   private Integer major;
/*     */   private Integer minor;
/*     */   private Integer maintanance;
/*     */   private String build;
/*     */   
/*     */   public CrucibleVersionInfo(String releaseNumber, String buildDate) {
/*  37 */     this.buildDate = buildDate;
/*  38 */     this.releaseNumber = releaseNumber;
/*  39 */     tokenizeVersionAndSetFields(releaseNumber);
/*     */   }
/*     */   
/*     */   public String getBuildDate() {
/*  43 */     return this.buildDate;
/*     */   }
/*     */   
/*     */   public String getReleaseNumber() {
/*  47 */     return this.releaseNumber;
/*     */   }
/*     */   
/*     */   public boolean isVersion2OrGreater() {
/*  51 */     return (this.major != null && this.major.intValue() >= 2);
/*     */   }
/*     */   
/*     */   public boolean isVersion21OrGreater() {
/*  55 */     if (this.major == null || this.minor == null) {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (this.major.intValue() > 2 || (this.major.intValue() == 2 && this.minor.intValue() >= 1)) {
/*  60 */       return true;
/*     */     }
/*     */     
/*  63 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVersion24OrGrater() {
/*  68 */     if (this.major == null || this.minor == null) {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     if (this.major.intValue() > 2 || (this.major.intValue() == 2 && this.minor.intValue() >= 4)) {
/*  73 */       return true;
/*     */     }
/*     */     
/*  76 */     return false;
/*     */   }
/*     */   private void tokenizeVersionAndSetFields(String number) {
/*  79 */     String[] tokens = number.split("[.]");
/*     */     
/*  81 */     this.major = null;
/*  82 */     this.minor = null;
/*  83 */     this.maintanance = null;
/*  84 */     this.build = null;
/*     */     
/*     */     try {
/*  87 */       if (tokens.length > 0) {
/*  88 */         this.major = Integer.valueOf(tokens[0]);
/*  89 */         if (tokens.length > 1) {
/*  90 */           this.minor = Integer.valueOf(tokens[1]);
/*  91 */           if (tokens.length > 2) {
/*  92 */             this.maintanance = Integer.valueOf(tokens[2]);
/*  93 */             if (tokens.length > 3) {
/*  94 */               this.build = tokens[3];
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*  99 */     } catch (NumberFormatException numberFormatException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getMajor() {
/* 105 */     return this.major;
/*     */   }
/*     */   
/*     */   public Integer getMinor() {
/* 109 */     return this.minor;
/*     */   }
/*     */   
/*     */   public Integer getMaintanance() {
/* 113 */     return this.maintanance;
/*     */   }
/*     */   
/*     */   public String getBuild() {
/* 117 */     return this.build;
/*     */   }
/*     */   
/*     */   private int compareInts(Integer a, Integer b) {
/* 121 */     if (a == null && b != null)
/* 122 */       return -1; 
/* 123 */     if (a != null && b == null)
/* 124 */       return 1; 
/* 125 */     if (a == null && b == null) {
/* 126 */       return 0;
/*     */     }
/* 128 */     return a.compareTo(b);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(CrucibleVersionInfo o) {
/* 133 */     int r = compareInts(this.major, o.major);
/* 134 */     if (r == 0) {
/* 135 */       r = compareInts(this.minor, o.minor);
/* 136 */       if (r == 0) {
/* 137 */         return compareInts(this.maintanance, o.maintanance);
/*     */       }
/* 139 */       return r;
/*     */     } 
/*     */     
/* 142 */     return r;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 148 */     StringBuilder sb = new StringBuilder();
/* 149 */     if (this.major != null) {
/* 150 */       sb.append(this.major);
/* 151 */       if (this.minor != null) {
/* 152 */         sb.append(".");
/* 153 */         sb.append(this.minor);
/* 154 */         if (this.maintanance != null) {
/* 155 */           sb.append(".");
/* 156 */           sb.append(this.maintanance);
/* 157 */           if (this.build != null) {
/* 158 */             sb.append(".");
/* 159 */             sb.append(this.build);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 164 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\CrucibleVersionInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */