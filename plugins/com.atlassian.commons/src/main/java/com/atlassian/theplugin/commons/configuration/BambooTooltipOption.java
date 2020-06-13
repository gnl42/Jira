/*    */ package com.atlassian.theplugin.commons.configuration;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BambooTooltipOption
/*    */ {
/* 27 */   ALL_FAULIRES_AND_FIRST_SUCCESS {
/*    */     public String toString() {
/* 29 */       return "All build failures and first build success";
/*    */     }
/*    */   },
/*    */   
/* 33 */   FIRST_FAILURE_AND_FIRST_SUCCESS {
/*    */     public String toString() {
/* 35 */       return "First build failure and first build success";
/*    */     }
/*    */   },
/*    */   
/* 39 */   NEVER {
/*    */     public String toString() {
/* 41 */       return "Never";
/*    */     } }; public static BambooTooltipOption valueOfAlias(String optionText) {
/*    */     byte b;
/*    */     int i;
/*    */     BambooTooltipOption[] arrayOfBambooTooltipOption;
/* 46 */     for (i = (arrayOfBambooTooltipOption = values()).length, b = 0; b < i; ) { BambooTooltipOption option = arrayOfBambooTooltipOption[b];
/* 47 */       if (option.toString().equals(optionText))
/* 48 */         return option; 
/*    */       b++; }
/*    */     
/* 51 */     return null;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\configuration\BambooTooltipOption.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */