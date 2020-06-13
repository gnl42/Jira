/*     */ package com.atlassian.theplugin.commons.util;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.exception.IncorrectVersionException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Scanner;
/*     */ import java.util.regex.MatchResult;
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
/*     */ public class ProductVersionUtil
/*     */   implements Serializable
/*     */ {
/*     */   public static final String SPECIAL_DEV_VERSION = "${project.version}, SVN:${buildNumber}";
/*     */   private static final long serialVersionUID = 1846608052207718100L;
/*     */   private transient VersionNumber versionNumber;
/*  31 */   public static final ProductVersionUtil NULL_VERSION = initNullVersion();
/*     */   private final String version;
/*     */   private static final String PATTERN = "^(\\d+)\\.(\\d+)(\\.(\\d+))?(\\.(\\d+))?(.+)?$";
/*     */   
/*     */   private static ProductVersionUtil initNullVersion() {
/*  36 */     ProductVersionUtil result = null;
/*     */     try {
/*  38 */       result = new ProductVersionUtil("0.0.0.0");
/*  39 */     } catch (IncorrectVersionException e) {
/*  40 */       e.printStackTrace();
/*     */     } 
/*  42 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final int MAJOR_TOKEN_GRP = 1;
/*     */   private static final int MINOR_TOKEN_GRP = 2;
/*     */   
/*     */   public ProductVersionUtil(String version) throws IncorrectVersionException {
/*  50 */     this.version = version;
/*  51 */     parseVersionString(version);
/*     */   }
/*     */   private static final int MICRO_TOKEN_GRP = 4; private static final int NANO_TOKEN_GRP = 6;
/*     */   public ProductVersionUtil() throws IncorrectVersionException {
/*  55 */     this(NULL_VERSION.getVersion());
/*     */   }
/*     */   
/*     */   public String getVersion() {
/*  59 */     return this.version;
/*     */   }
/*     */   
/*     */   private void parseVersionString(String aVersion) throws IncorrectVersionException {
/*  63 */     if (!aVersion.equals("${project.version}, SVN:${buildNumber}")) {
/*  64 */       tokenize(aVersion.toUpperCase());
/*     */     }
/*     */   }
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
/*     */   private void tokenize(String aVersion) throws IncorrectVersionException {
/*  79 */     Scanner s = new Scanner(aVersion);
/*  80 */     s.findInLine("^(\\d+)\\.(\\d+)(\\.(\\d+))?(\\.(\\d+))?(.+)?$");
/*     */     try {
/*  82 */       MatchResult result = s.match();
/*  83 */       this.versionNumber = new VersionNumber(Integer.valueOf(result.group(1)).intValue(), 
/*  84 */           Integer.valueOf(result.group(2)).intValue(), 
/*  85 */           (result.group(4) != null) ? Integer.valueOf(result.group(4)).intValue() : -1, 
/*  86 */           (result.group(6) != null) ? Integer.valueOf(result.group(6)).intValue() : -1);
/*  87 */     } catch (IllegalStateException ex) {
/*  88 */       throw new IncorrectVersionException("Version (" + aVersion + ") does not match pattern (\"" + "^(\\d+)\\.(\\d+)(\\.(\\d+))?(\\.(\\d+))?(.+)?$" + 
/*  89 */           "\")", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object that) {
/*  95 */     if (this == that) {
/*  96 */       return true;
/*     */     }
/*  98 */     if (that == null || getClass() != that.getClass()) {
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     ProductVersionUtil thatVersion = (ProductVersionUtil)that;
/*     */     
/* 104 */     if ((this.version != null) ? !this.version.equals(thatVersion.version) : (thatVersion.version != null)) {
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 113 */     return (this.version != null) ? this.version.hashCode() : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 118 */     return this.version;
/*     */   }
/*     */   
/*     */   public boolean greater(ProductVersionUtil other) {
/* 122 */     if (other == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     if (other.version.equals("${project.version}, SVN:${buildNumber}")) {
/* 126 */       return false;
/*     */     }
/* 128 */     if (this.version.equals("${project.version}, SVN:${buildNumber}")) {
/* 129 */       return true;
/*     */     }
/* 131 */     return getVersionNumber().greater(other.getVersionNumber());
/*     */   }
/*     */   
/*     */   private VersionNumber getVersionNumber() {
/* 135 */     return this.versionNumber;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class VersionNumber
/*     */   {
/*     */     private final int major;
/*     */     
/*     */     private final int minor;
/*     */     
/*     */     private final int micro;
/*     */     
/*     */     private final int nano;
/*     */     private static final int PRIME = 31;
/*     */     
/*     */     public VersionNumber(int major, int minor, int micro, int nano) throws IncorrectVersionException {
/* 151 */       this.major = major;
/* 152 */       this.minor = minor;
/* 153 */       this.micro = micro;
/* 154 */       this.nano = nano;
/*     */     }
/*     */     
/*     */     public boolean greater(VersionNumber other) {
/* 158 */       if (other == null) {
/* 159 */         return false;
/*     */       }
/*     */       
/* 162 */       if (this.major > other.major) {
/* 163 */         return true;
/*     */       }
/* 165 */       if (this.major == other.major && this.minor > other.minor) {
/* 166 */         return true;
/*     */       }
/* 168 */       if (this.major == other.major && this.minor == other.minor && this.micro > other.micro) {
/* 169 */         return true;
/*     */       }
/* 171 */       if (this.major == other.major && this.minor == other.minor && this.micro == other.micro && this.nano > other.nano) {
/* 172 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 177 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object o) {
/* 182 */       if (this == o) {
/* 183 */         return true;
/*     */       }
/* 185 */       if (o == null || getClass() != o.getClass()) {
/* 186 */         return false;
/*     */       }
/*     */       
/* 189 */       VersionNumber that = (VersionNumber)o;
/*     */       
/* 191 */       if (this.major != that.major) {
/* 192 */         return false;
/*     */       }
/* 194 */       if (this.micro != that.micro) {
/* 195 */         return false;
/*     */       }
/* 197 */       if (this.minor != that.minor) {
/* 198 */         return false;
/*     */       }
/* 200 */       if (this.nano != that.nano) {
/* 201 */         return false;
/*     */       }
/*     */       
/* 204 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 210 */       int result = this.major;
/* 211 */       result = 31 * result + this.minor;
/* 212 */       result = 31 * result + this.micro;
/* 213 */       result = 31 * result + this.nano;
/* 214 */       return result;
/*     */     }
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\common\\util\ProductVersionUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */