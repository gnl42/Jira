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
/*     */ public class Version
/*     */   implements Serializable
/*     */ {
/*     */   public static final String SPECIAL_DEV_VERSION = "${project.version}, SVN:${buildNumber}";
/*     */   private static final long serialVersionUID = 1846608052207718100L;
/*     */   private transient VersionNumber versionNumber;
/*     */   private final String version;
/*  30 */   public static final Version NULL_VERSION = initNullVersion(); private static final String PATTERN = "^(\\d+)\\.(\\d+)\\.(\\d+)((-(ALPHA|BETA|SNAPSHOT))?+)((-(\\d+))?+), SVN:(\\d+)$";
/*     */   private static final int MAJOR_TOKEN_GRP = 1;
/*     */   
/*     */   private static Version initNullVersion() {
/*  34 */     Version result = null;
/*     */     try {
/*  36 */       result = new Version("0.0.0, SVN:0");
/*  37 */     } catch (IncorrectVersionException e) {
/*  38 */       e.printStackTrace();
/*     */     } 
/*  40 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final int MINOR_TOKEN_GRP = 2;
/*     */   private static final int MICRO_TOKEN_GRP = 3;
/*     */   
/*     */   public Version(String version) throws IncorrectVersionException {
/*  48 */     this.version = version;
/*  49 */     parseVersionString(version);
/*     */   }
/*     */   private static final int ALPHANUM_TOKEN_GRP = 6; private static final int ALPHANUM_VERSION_GRP = 9; private static final int BUILD_TOKEN_GRP = 10;
/*     */   public Version() throws IncorrectVersionException {
/*  53 */     this(NULL_VERSION.getVersion());
/*     */   }
/*     */   
/*     */   public String getVersion() {
/*  57 */     return this.version;
/*     */   }
/*     */   
/*     */   private void parseVersionString(String aVersion) throws IncorrectVersionException {
/*  61 */     if (!aVersion.equals("${project.version}, SVN:${buildNumber}")) {
/*  62 */       tokenize(aVersion.toUpperCase());
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
/*  77 */     Scanner s = new Scanner(aVersion);
/*  78 */     s.findInLine("^(\\d+)\\.(\\d+)\\.(\\d+)((-(ALPHA|BETA|SNAPSHOT))?+)((-(\\d+))?+), SVN:(\\d+)$");
/*     */     try {
/*  80 */       MatchResult result = s.match();
/*  81 */       this.versionNumber = new VersionNumber(
/*  82 */           Integer.valueOf(result.group(1)).intValue(), 
/*  83 */           Integer.valueOf(result.group(2)).intValue(), 
/*  84 */           Integer.valueOf(result.group(3)).intValue(), 
/*  85 */           result.group(6), 
/*  86 */           result.group(9), 
/*  87 */           Integer.valueOf(result.group(10)).intValue());
/*  88 */     } catch (IllegalStateException ex) {
/*  89 */       throw new IncorrectVersionException("Version (" + aVersion + ") does not match pattern (\"" + "^(\\d+)\\.(\\d+)\\.(\\d+)((-(ALPHA|BETA|SNAPSHOT))?+)((-(\\d+))?+), SVN:(\\d+)$" + 
/*  90 */           "\")", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object that) {
/*  96 */     if (this == that) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (that == null || getClass() != that.getClass()) {
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     Version thatVersion = (Version)that;
/*     */     
/* 105 */     if ((this.version != null) ? !this.version.equals(thatVersion.version) : (thatVersion.version != null)) {
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 114 */     return (this.version != null) ? this.version.hashCode() : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     return this.version;
/*     */   }
/*     */   
/*     */   public boolean greater(Version other) {
/* 123 */     if (other == null) {
/* 124 */       return false;
/*     */     }
/* 126 */     if (other.version.equals("${project.version}, SVN:${buildNumber}")) {
/* 127 */       return false;
/*     */     }
/* 129 */     if (this.version.equals("${project.version}, SVN:${buildNumber}")) {
/* 130 */       return true;
/*     */     }
/* 132 */     return getVersionNumber().greater(other.getVersionNumber());
/*     */   }
/*     */   
/*     */   private VersionNumber getVersionNumber() {
/* 136 */     return this.versionNumber;
/*     */   }
/*     */   
/*     */   private static class VersionNumber
/*     */   {
/*     */     private int major;
/*     */     private int minor;
/*     */     private int micro;
/*     */     private int buildNo;
/*     */     private AlphaNum alphaNum;
/* 146 */     private int alphaNumValue = 0;
/*     */     private static final int PRIME = 31;
/*     */     
/*     */     public enum AlphaNum
/*     */     {
/* 151 */       SNAPSHOT, ALPHA, BETA, NONE;
/*     */     }
/*     */ 
/*     */     
/*     */     public VersionNumber(int major, int minor, int micro, String alphaNum, String alphaNumValue, int buildNo) throws IncorrectVersionException {
/* 156 */       this.major = major;
/* 157 */       this.minor = minor;
/* 158 */       this.micro = micro;
/* 159 */       this.buildNo = buildNo;
/*     */       
/* 161 */       if (alphaNum == null) {
/* 162 */         this.alphaNum = AlphaNum.NONE;
/*     */       } else {
/*     */         try {
/* 165 */           this.alphaNum = AlphaNum.valueOf(alphaNum);
/*     */           
/* 167 */           if (alphaNumValue != null) {
/* 168 */             this.alphaNumValue = Integer.valueOf(alphaNumValue).intValue();
/*     */           }
/* 170 */         } catch (IllegalArgumentException illegalArgumentException) {
/* 171 */           throw new IncorrectVersionException("Unknown version alphanum: " + alphaNum);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean greater(VersionNumber other) {
/* 177 */       if (other == null) {
/* 178 */         return false;
/*     */       }
/*     */       
/* 181 */       if (this.major > other.major) {
/* 182 */         return true;
/*     */       }
/* 184 */       if (this.major == other.major && this.minor > other.minor) {
/* 185 */         return true;
/*     */       }
/* 187 */       if (this.major == other.major && this.minor == other.minor && this.micro > other.micro) {
/* 188 */         return true;
/*     */       }
/* 190 */       if (this.major == other.major && this.minor == other.minor && this.micro == other.micro) {
/* 191 */         return (this.buildNo > other.buildNo);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 196 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object o) {
/* 201 */       if (this == o) {
/* 202 */         return true;
/*     */       }
/* 204 */       if (o == null || getClass() != o.getClass()) {
/* 205 */         return false;
/*     */       }
/*     */       
/* 208 */       VersionNumber that = (VersionNumber)o;
/*     */       
/* 210 */       if (this.major != that.major) {
/* 211 */         return false;
/*     */       }
/* 213 */       if (this.micro != that.micro) {
/* 214 */         return false;
/*     */       }
/* 216 */       if (this.minor != that.minor) {
/* 217 */         return false;
/*     */       }
/* 219 */       if (this.alphaNum != that.alphaNum) {
/* 220 */         return false;
/*     */       }
/*     */       
/* 223 */       if (this.alphaNumValue != that.alphaNumValue) {
/* 224 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 228 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 234 */       int result = this.major;
/* 235 */       result = 31 * result + this.minor;
/* 236 */       result = 31 * result + this.micro;
/* 237 */       result = 31 * result + ((this.alphaNum != null) ? this.alphaNum.hashCode() : 0);
/* 238 */       return result;
/*     */     }
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\common\\util\Version.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */