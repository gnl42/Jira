/*    */ package com.atlassian.connector.commons.misc;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*    */ import java.util.ArrayList;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class IntRangesParser
/*    */ {
/*    */   @NotNull
/*    */   public static IntRanges parse(@NotNull String rangesStr) throws NumberFormatException {
/* 29 */     if (rangesStr == null) {
/* 30 */       throw new IllegalArgumentException("Parameter cannot be null");
/*    */     }
/* 32 */     rangesStr = rangesStr.trim();
/* 33 */     if (rangesStr.length() == 0) {
/* 34 */       throw new NumberFormatException("Cannot parse [" + rangesStr + "] into " + IntRanges.class.getName());
/*    */     }
/* 36 */     String[] tokens = rangesStr.split(",");
/* 37 */     ArrayList<IntRange> res = MiscUtil.buildArrayList(); byte b; int i; String[] arrayOfString1;
/* 38 */     for (i = (arrayOfString1 = tokens).length, b = 0; b < i; ) { String nontrimmedtoken = arrayOfString1[b];
/* 39 */       String token = nontrimmedtoken.trim();
/*    */       try {
/* 41 */         int index = token.lastIndexOf('-');
/* 42 */         if (index < 1) {
/* 43 */           res.add(new IntRange(Integer.parseInt(token)));
/*    */         } else {
/*    */           
/* 46 */           int index2 = token.lastIndexOf('-', index - 1);
/* 47 */           if (index2 > 0) {
/* 48 */             index = index2;
/*    */           }
/*    */           
/* 51 */           int min = Integer.parseInt(token.substring(0, index).trim());
/* 52 */           int max = Integer.parseInt(token.substring(index + 1).trim());
/* 53 */           if (min > max) {
/* 54 */             throw new NumberFormatException("The lower bound of the range [" + min + "] cannot be greater than" + 
/* 55 */                 "the upper bound of the range [" + max + "]");
/*    */           }
/* 57 */           res.add(new IntRange(min, max));
/*    */         } 
/* 59 */       } catch (NumberFormatException e) {
/* 60 */         NumberFormatException ex = new NumberFormatException(
/* 61 */             "Cannot parse [" + rangesStr + "] into " + IntRanges.class.getName());
/* 62 */         ex.initCause(e);
/* 63 */         throw ex;
/*    */       }  b++; }
/*    */     
/* 66 */     return new IntRanges(res);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\misc\IntRangesParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */