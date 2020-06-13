/*     */ package com.atlassian.theplugin.commons.util;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.joda.time.Period;
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
/*     */ public abstract class DateUtil
/*     */ {
/*     */   private static final String PRIOR_TEXT = "ago";
/*     */   public static final int SECONDS_IN_MINUTE = 60;
/*     */   public static final int MILISECONDS_IN_SECOND = 1000;
/*     */   
/*     */   public static String getRelativePastDate(Date someDate) {
/*  37 */     if (someDate != null) {
/*  38 */       return getRelativePastDate(new Date(), someDate);
/*     */     }
/*  40 */     return "Unknown";
/*     */   }
/*     */   
/*     */   public static String getRelativePastDate(Date comparedTo, Date someDate) {
/*  44 */     if (someDate != null) {
/*  45 */       Period period = new Period(someDate.getTime(), comparedTo.getTime());
/*  46 */       StringBuffer buffer = new StringBuffer();
/*     */       
/*  48 */       int years = period.getYears();
/*  49 */       if (years > 0) {
/*  50 */         return formatRelativeDateItem(buffer, years, " year");
/*     */       }
/*     */       
/*  53 */       int months = period.getMonths();
/*  54 */       if (months > 0) {
/*  55 */         return formatRelativeDateItem(buffer, months, " month");
/*     */       }
/*     */       
/*  58 */       int weeks = period.getWeeks();
/*  59 */       if (weeks > 0) {
/*  60 */         return formatRelativeDateItem(buffer, weeks, " week");
/*     */       }
/*     */       
/*  63 */       int days = period.getDays();
/*  64 */       if (days > 0) {
/*  65 */         return formatRelativeDateItem(buffer, days, " day");
/*     */       }
/*     */       
/*  68 */       int hours = period.getHours();
/*  69 */       if (hours > 0) {
/*  70 */         return formatRelativeDateItem(buffer, hours, " hour");
/*     */       }
/*  72 */       int minutes = period.getMinutes();
/*  73 */       if (minutes > 0) {
/*  74 */         return formatRelativeDateItem(buffer, minutes, " minute");
/*     */       }
/*     */       
/*  77 */       int seconds = period.getSeconds();
/*  78 */       if (seconds > 0) {
/*  79 */         return formatRelativeDateItem(buffer, seconds, " second");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  86 */       return "< 1 second ago";
/*     */     } 
/*     */     
/*  89 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String formatRelativeDateItem(StringBuffer buffer, int numberOfItems, String item) {
/*  95 */     buffer.append(numberOfItems).append(item);
/*  96 */     if (numberOfItems > 1) {
/*  97 */       buffer.append("s");
/*     */     }
/*  99 */     buffer.append(" ago");
/* 100 */     return buffer.toString();
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\common\\util\DateUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */