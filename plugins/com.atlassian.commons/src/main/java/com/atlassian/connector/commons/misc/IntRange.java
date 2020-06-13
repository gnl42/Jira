/*    */ package com.atlassian.connector.commons.misc;
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
/*    */ public final class IntRange
/*    */ {
/*    */   private final int min;
/*    */   private final int max;
/*    */   private static final int MAGIC = 31;
/*    */   
/*    */   public IntRange(int number) {
/* 24 */     this.min = number;
/* 25 */     this.max = number;
/*    */   }
/*    */   
/*    */   public boolean isSingleNumber() {
/* 29 */     return (this.min == this.max);
/*    */   }
/*    */   
/*    */   public IntRange(int min, int max) {
/* 33 */     if (min > max) {
/* 34 */       throw new IllegalArgumentException("Lower bound [" + min + "] cannot be greater than upper bound [" + max + "]");
/*    */     }
/* 36 */     this.max = max;
/* 37 */     this.min = min;
/*    */   }
/*    */   
/*    */   public int getMin() {
/* 41 */     return this.min;
/*    */   }
/*    */   
/*    */   public int getMax() {
/* 45 */     return this.max;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 50 */     if (isSingleNumber()) {
/* 51 */       return "[" + this.min + "]";
/*    */     }
/* 53 */     return "[" + this.min + "-" + this.max + "]";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 59 */     if (this == o) {
/* 60 */       return true;
/*    */     }
/* 62 */     if (o == null || getClass() != o.getClass()) {
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     IntRange intRange = (IntRange)o;
/*    */     
/* 68 */     if (this.max != intRange.max) {
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     if (this.min != intRange.min) {
/* 73 */       return false;
/*    */     }
/*    */     
/* 76 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 81 */     int result = this.min;
/* 82 */     result = 31 * result + this.max;
/* 83 */     return result;
/*    */   }
/*    */   
/*    */   public String toNiceString() {
/* 87 */     if (isSingleNumber()) {
/* 88 */       return String.valueOf(this.min);
/*    */     }
/* 90 */     return String.valueOf(this.min) + " - " + this.max;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\misc\IntRange.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */