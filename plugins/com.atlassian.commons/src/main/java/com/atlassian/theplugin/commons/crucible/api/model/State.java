/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
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
/*    */ public enum State
/*    */ {
/* 20 */   DRAFT("Draft", "Draft"),
/* 21 */   APPROVAL("Approval", "Pending Approval"),
/* 22 */   REVIEW("Review", "Under Review"),
/* 23 */   SUMMARIZE("Summarize", "Summarize"),
/* 24 */   CLOSED("Closed", "Closed"),
/* 25 */   ABANDONED("Abandoned", "Abandoned"),
/* 26 */   REJECTED("Rejected", "Rejected"),
/* 27 */   UNKNOWN("Unknown", "Review Needs Fixing"),
/* 28 */   OPEN_SNIPPET(
/* 29 */     "OpenSnippet", "Open Snippet"),
/* 30 */   CLOSED_SNIPPET("ClosedSnippet", "Closed Snippet"),
/* 31 */   DEAD("Dead", "Dead");
/*    */   
/*    */   private final String value;
/*    */   private String displayName;
/*    */   
/*    */   State(String v, String displayName) {
/* 37 */     this.value = v;
/* 38 */     this.displayName = displayName;
/*    */   }
/*    */   
/*    */   public String value() {
/* 42 */     return this.value;
/*    */   }
/*    */   
/*    */   public String getDisplayName() {
/* 46 */     return this.displayName; } public static State fromValue(String v) {
/*    */     byte b;
/*    */     int i;
/*    */     State[] arrayOfState;
/* 50 */     for (i = (arrayOfState = values()).length, b = 0; b < i; ) { State c = arrayOfState[b];
/* 51 */       if (c.value.equals(v))
/* 52 */         return c; 
/*    */       b++; }
/*    */     
/* 55 */     throw new IllegalArgumentException(v);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\State.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */