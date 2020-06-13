/*     */ package com.atlassian.theplugin.commons.util;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
/*     */ import java.net.URLEncoder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class UrlUtil
/*     */ {
/*     */   public static String addHttpPrefix(String address) {
/*  39 */     if (address == null)
/*  40 */       return null; 
/*  41 */     if (address.trim().length() == 0)
/*  42 */       return address; 
/*  43 */     if (!address.trim().startsWith("http://") && !address.trim().startsWith("https://")) {
/*  44 */       return "http://" + address.trim();
/*     */     }
/*  46 */     return address;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String removeUrlTrailingSlashes(String address) {
/*  51 */     if (address == null) {
/*  52 */       return null;
/*     */     }
/*     */     try {
/*  55 */       URL url = new URL(address);
/*  56 */       if (url.getHost().length() == 0) {
/*  57 */         return address;
/*     */       }
/*  59 */     } catch (MalformedURLException malformedURLException) {
/*  60 */       return address;
/*     */     } 
/*     */     
/*  63 */     while (address.endsWith("/")) {
/*  64 */       address = address.substring(0, address.length() - 1);
/*     */     }
/*  66 */     return address;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validateUrl(String urlString) throws MalformedURLException {
/*  72 */     if (urlString == null || urlString.length() == 0) {
/*  73 */       throw new MalformedURLException("Malformed URL: null or empty");
/*     */     }
/*     */     
/*     */     try {
/*  77 */       URL url = new URL(urlString);
/*     */ 
/*     */       
/*  80 */       if (url.getHost().length() == 0) {
/*  81 */         throw new MalformedURLException("Url must contain valid host.");
/*     */       }
/*     */       
/*  84 */       if (url.getPort() >= 65534) {
/*  85 */         throw new MalformedURLException("Url port invalid");
/*     */       }
/*     */ 
/*     */       
/*  89 */       url.toURI();
/*  90 */     } catch (URISyntaxException e) {
/*  91 */       throw new MalformedURLException("Malformed URL: " + e.getMessage());
/*  92 */     } catch (MalformedURLException e) {
/*  93 */       throw new MalformedURLException("Malformed URL: " + e.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isUrlValid(String urlString) {
/*     */     try {
/* 103 */       validateUrl(urlString);
/* 104 */     } catch (MalformedURLException malformedURLException) {
/* 105 */       return false;
/*     */     } 
/*     */     
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   public static String encodeUrl(String string) {
/*     */     try {
/* 113 */       return URLEncoder.encode(string, "UTF-8");
/* 114 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 115 */       throw new AssertionError("UTF-8 is not supported on this platform. In theory it should not happen, but ...");
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
/*     */   public static String adjustUrlPath(String urlPath, String serverUrl) {
/* 127 */     String[] serverTokens = serverUrl.split("/");
/* 128 */     String[] pathTokens = urlPath.split("/");
/*     */     
/* 130 */     if (serverTokens.length > 0 && pathTokens.length > 0 && 
/* 131 */       serverTokens[serverTokens.length - 1].equals(pathTokens[0])) {
/* 132 */       urlPath = urlPath.substring(pathTokens[0].length(), urlPath.length());
/*     */     }
/*     */     
/* 135 */     return urlPath;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\common\\util\UrlUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */