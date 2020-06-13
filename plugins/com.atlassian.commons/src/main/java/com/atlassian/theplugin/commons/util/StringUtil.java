/*     */ package com.atlassian.theplugin.commons.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import org.apache.commons.codec.binary.Base64;
/*     */ import org.jetbrains.annotations.Nullable;
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
/*     */ public final class StringUtil
/*     */ {
/*     */   private static final int BUFFER_SIZE = 4096;
/*     */   
/*     */   public static String getFirstLine(@Nullable String s) {
/*  34 */     if (s == null) {
/*  35 */       return null;
/*     */     }
/*  37 */     int index = s.indexOf("\n");
/*  38 */     if (index == -1) {
/*  39 */       return s;
/*     */     }
/*  41 */     return s.substring(0, index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized String decode(String str2decode) {
/*  48 */     if (str2decode.length() == 0) {
/*  49 */       return "";
/*     */     }
/*     */     try {
/*  52 */       Base64 base64 = new Base64();
/*  53 */       byte[] passwordBytes = base64.decode(str2decode.getBytes("UTF-8"));
/*  54 */       if (passwordBytes == null || passwordBytes.length == 0) {
/*  55 */         throw new IllegalArgumentException("Cannot decode string due to not supported characters or becuase it is not encoded");
/*     */       }
/*     */ 
/*     */       
/*  59 */       return new String(passwordBytes, "UTF-8");
/*  60 */     } catch (UnsupportedEncodingException e) {
/*     */ 
/*     */       
/*  63 */       throw new RuntimeException("UTF-8 is not supported", e);
/*     */     }
/*  65 */     catch (ArrayIndexOutOfBoundsException e) {
/*  66 */       throw new IllegalArgumentException(
/*  67 */           "Cannot decode string due to not supported characters or becuase it is not encoded", e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static synchronized String encode(String str2encode) {
/*     */     try {
/*  73 */       Base64 base64 = new Base64();
/*  74 */       byte[] bytes = base64.encode(str2encode.getBytes("UTF-8"));
/*  75 */       return new String(bytes);
/*  76 */     } catch (UnsupportedEncodingException e) {
/*     */ 
/*     */       
/*  79 */       throw new RuntimeException("UTF-8 is not supported", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String slurp(InputStream in) throws IOException {
/*  85 */     StringBuilder out = new StringBuilder();
/*  86 */     byte[] b = new byte[4096];
/*  87 */     for (int n = in.read(b); n != -1; n = in.read(b)) {
/*  88 */       out.append(new String(b, 0, n));
/*     */     }
/*  90 */     return out.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String removeLeadingAndTrailingSlashes(String text) {
/*  99 */     if (text == null) {
/* 100 */       return null;
/*     */     }
/*     */     
/* 103 */     text = removePrefixSlashes(text);
/* 104 */     text = removeSuffixSlashes(text);
/*     */     
/* 106 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String removePrefixSlashes(String text) {
/* 115 */     if (text == null) {
/* 116 */       return null;
/*     */     }
/*     */     
/* 119 */     while (text.startsWith("/")) {
/* 120 */       text = text.substring(1, text.length());
/*     */     }
/*     */     
/* 123 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String removeSuffixSlashes(String text) {
/* 132 */     if (text == null) {
/* 133 */       return null;
/*     */     }
/*     */     
/* 136 */     while (text.endsWith("/")) {
/* 137 */       text = text.substring(0, text.length() - 1);
/*     */     }
/*     */     
/* 140 */     return text;
/*     */   }
/*     */   
/*     */   public static String generateJiraLogTimeString(long secondsSpent) {
/* 144 */     StringBuilder timeLog = new StringBuilder();
/* 145 */     long totalSeconds = secondsSpent;
/* 146 */     long remainingTime = 0L;
/* 147 */     long weeks = totalSeconds / 604800L;
/* 148 */     remainingTime = totalSeconds - weeks * 604800L;
/* 149 */     long days = remainingTime / 86400L;
/* 150 */     remainingTime -= days * 86400L;
/* 151 */     long hours = remainingTime / 3600L;
/* 152 */     remainingTime -= hours * 3600L;
/* 153 */     long minutes = remainingTime / 60L;
/*     */ 
/*     */     
/* 156 */     if (weeks > 0L) {
/* 157 */       timeLog.append(" ").append(weeks).append("w");
/*     */     }
/*     */     
/* 160 */     if (days > 0L) {
/* 161 */       timeLog.append(" ").append(days).append("d");
/*     */     }
/*     */     
/* 164 */     if (hours > 0L) {
/* 165 */       timeLog.append(" ").append(hours).append("h");
/*     */     }
/*     */     
/* 168 */     if (minutes > 0L) {
/* 169 */       timeLog.append(" ").append(minutes).append("m");
/*     */     }
/*     */     
/* 172 */     return timeLog.toString().trim();
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\common\\util\StringUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */