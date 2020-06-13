/*     */ package com.atlassian.connector.commons.misc;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.jetbrains.annotations.NotNull;
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
/*     */ public class IntRanges
/*     */ {
/*     */   @NotNull
/*     */   private final ArrayList<IntRange> ranges;
/*     */   
/*  29 */   private static final Comparator<IntRange> COMPARATOR = new Comparator<IntRange>() {
/*     */       public int compare(IntRange o1, IntRange o2) {
/*  31 */         return o1.getMin() - o2.getMin();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntRanges(@NotNull List<IntRange> ranges) {
/*  39 */     this.ranges = new ArrayList<IntRange>(ranges);
/*  40 */     if (this.ranges.isEmpty()) {
/*  41 */       throw new IllegalArgumentException("Cannot create ranges object from the empty list");
/*     */     }
/*  43 */     Collections.sort(this.ranges, COMPARATOR);
/*     */   }
/*     */   
/*     */   public IntRanges(@NotNull IntRange... ranges) {
/*  47 */     if (ranges.length == 0) {
/*  48 */       throw new IllegalArgumentException("Cannot create ranges object from the empty list");
/*     */     }
/*  50 */     this.ranges = new ArrayList<IntRange>(Arrays.asList(ranges));
/*  51 */     Collections.sort(this.ranges, COMPARATOR);
/*     */   }
/*     */   
/*     */   public int getTotalMin() {
/*  55 */     return ((IntRange)this.ranges.get(0)).getMin();
/*     */   }
/*     */   
/*     */   public int getTotalMax() {
/*  59 */     return ((IntRange)this.ranges.get(this.ranges.size() - 1)).getMax();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public List<IntRange> getRanges() {
/*  64 */     return Collections.unmodifiableList(this.ranges);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  69 */     if (this == o) {
/*  70 */       return true;
/*     */     }
/*  72 */     if (o == null || getClass() != o.getClass()) {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     IntRanges intRanges = (IntRanges)o;
/*     */ 
/*     */     
/*  79 */     if (!this.ranges.equals(intRanges.ranges)) {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  88 */     return this.ranges.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  93 */     return "[" + StringUtils.join(this.ranges, ',') + "]";
/*     */   }
/*     */   
/*     */   public String toNiceString() {
/*  97 */     StringBuilder sb = new StringBuilder();
/*  98 */     for (Iterator<IntRange> it = this.ranges.iterator(); it.hasNext(); ) {
/*  99 */       sb.append(((IntRange)it.next()).toNiceString());
/* 100 */       if (it.hasNext()) {
/* 101 */         sb.append(", ");
/*     */       }
/*     */     } 
/* 104 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\misc\IntRanges.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */