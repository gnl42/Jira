/*    */ package com.atlassian.connector.commons.jira;
/*    */ 
/*    */ import java.text.DateFormat;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Locale;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class JiraTimeFormatter
/*    */ {
/*    */   public static String formatShortTimeFromJiraTimeString(String dateString, Locale locale) {
/*    */     String t;
/* 19 */     DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z (z)", locale);
/* 20 */     DateFormat ds = DateFormat.getDateTimeInstance(3, 3);
/*    */     
/* 22 */     if (dateString == null) {
/* 23 */       return "";
/*    */     }
/*    */     try {
/* 26 */       t = ds.format(df.parse(dateString));
/* 27 */     } catch (ParseException parseException) {
/*    */       
/* 29 */       df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", locale);
/*    */       try {
/* 31 */         t = ds.format(df.parse(dateString));
/* 32 */       } catch (ParseException parseException1) {
/* 33 */         t = "Invalid";
/*    */       } 
/*    */     } 
/*    */     
/* 37 */     return t;
/*    */   }
/*    */   public static String formatDateTimeFromJiraTimeString(String dateString, Locale locale) {
/*    */     String t;
/* 41 */     DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z (z)", locale);
/* 42 */     DateFormat ds = new SimpleDateFormat("dd/MMM/yy HH:mm");
/*    */     
/*    */     try {
/* 45 */       t = ds.format(df.parse(dateString));
/* 46 */     } catch (ParseException parseException) {
/*    */       
/* 48 */       df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", locale);
/*    */       try {
/* 50 */         t = ds.format(df.parse(dateString));
/* 51 */       } catch (ParseException parseException1) {
/* 52 */         t = "Invalid";
/*    */       } 
/*    */     } 
/*    */     
/* 56 */     return t;
/*    */   }
/*    */   public static String formatDateFromJiraTimeString(String dateString, Locale locale) {
/*    */     String t;
/* 60 */     DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z (z)", locale);
/* 61 */     DateFormat ds = new SimpleDateFormat("dd/MMM/yy", locale);
/*    */     
/*    */     try {
/* 64 */       t = ds.format(df.parse(dateString));
/* 65 */     } catch (ParseException parseException) {
/*    */       
/* 67 */       df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", locale);
/*    */       try {
/* 69 */         t = ds.format(df.parse(dateString));
/* 70 */       } catch (ParseException parseException1) {
/* 71 */         df = new SimpleDateFormat("yyyy-MM-dd", locale);
/*    */         try {
/* 73 */           t = ds.format(df.parse(dateString));
/* 74 */         } catch (ParseException parseException2) {
/* 75 */           t = "Invalid";
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 80 */     return t;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\JiraTimeFormatter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */