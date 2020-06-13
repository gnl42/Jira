/*     */ package com.atlassian.theplugin.commons.crucible.api.model;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*     */ import java.util.Map;
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
/*     */ public final class CrucibleAction
/*     */ {
/*  23 */   private static Map<String, CrucibleAction> nameMap = MiscUtil.buildHashMap();
/*     */   
/*  25 */   public static final CrucibleAction VIEW = new CrucibleAction("View review", "action:viewReview");
/*  26 */   public static final CrucibleAction CREATE = new CrucibleAction("Create review", "action:createReview");
/*  27 */   public static final CrucibleAction ABANDON = new CrucibleAction("Abandon review", "action:abandonReview");
/*  28 */   public static final CrucibleAction SUBMIT = new CrucibleAction("Submit review", "action:submitReview");
/*  29 */   public static final CrucibleAction APPROVE = new CrucibleAction("Approve review", "action:approveReview");
/*  30 */   public static final CrucibleAction REJECT = new CrucibleAction("Reject review", "action:rejectReview");
/*  31 */   public static final CrucibleAction SUMMARIZE = new CrucibleAction("Summarize review", "action:summarizeReview");
/*  32 */   public static final CrucibleAction CLOSE = new CrucibleAction("Close review", "action:closeReview");
/*  33 */   public static final CrucibleAction REOPEN = new CrucibleAction("Reopen review", "action:reopenReview");
/*  34 */   public static final CrucibleAction RECOVER = new CrucibleAction("Recover review", "action:recoverReview");
/*  35 */   public static final CrucibleAction COMPLETE = new CrucibleAction("Complete review", "action:completeReview");
/*  36 */   public static final CrucibleAction UNCOMPLETE = new CrucibleAction("Uncomplete review", "action:uncompleteReview");
/*  37 */   public static final CrucibleAction COMMENT = new CrucibleAction("Comment", "action:commentOnReview");
/*  38 */   public static final CrucibleAction MODIFY_FILES = new CrucibleAction("Modify files", "action:modifyReviewFiles");
/*  39 */   public static final CrucibleAction DELETE = new CrucibleAction("Delete review", "action:deleteReview");
/*  40 */   public static final CrucibleAction REOPEN_SNIPPET = new CrucibleAction("Reopen snippet", "action:reopenSnippet");
/*  41 */   public static final CrucibleAction CLOSE_SNIPPET = new CrucibleAction("Close snippet", "action:closeSnippet");
/*  42 */   public static final CrucibleAction CREATE_SNIPPET = new CrucibleAction("Create snippet", "action:createSnippet");
/*     */   
/*     */   private final String displayName;
/*     */   
/*     */   private final String id;
/*     */   
/*     */   public CrucibleAction(String displayName, String id) {
/*  49 */     this.displayName = displayName;
/*  50 */     this.id = id;
/*  51 */     nameMap.put(id, this);
/*     */   }
/*     */   
/*     */   public String getDisplayName() {
/*  55 */     return this.displayName;
/*     */   }
/*     */   
/*     */   public String getId() {
/*  59 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  64 */     return String.valueOf(this.id) + " (" + this.displayName + ")";
/*     */   }
/*     */   
/*     */   public static CrucibleAction fromValue(String v) {
/*  68 */     CrucibleAction crucibleAction = nameMap.get(v);
/*  69 */     if (crucibleAction != null) {
/*  70 */       return crucibleAction;
/*     */     }
/*  72 */     throw new IllegalArgumentException(v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  78 */     int result = 1;
/*  79 */     result = 31 * result + ((this.displayName == null) ? 0 : this.displayName.hashCode());
/*  80 */     result = 31 * result + ((this.id == null) ? 0 : this.id.hashCode());
/*  81 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  86 */     if (this == obj) {
/*  87 */       return true;
/*     */     }
/*  89 */     if (obj == null) {
/*  90 */       return false;
/*     */     }
/*  92 */     if (getClass() != obj.getClass()) {
/*  93 */       return false;
/*     */     }
/*  95 */     CrucibleAction other = (CrucibleAction)obj;
/*  96 */     if (this.displayName == null) {
/*  97 */       if (other.displayName != null) {
/*  98 */         return false;
/*     */       }
/* 100 */     } else if (!this.displayName.equals(other.displayName)) {
/* 101 */       return false;
/*     */     } 
/* 103 */     if (this.id == null) {
/* 104 */       if (other.id != null) {
/* 105 */         return false;
/*     */       }
/* 107 */     } else if (!this.id.equals(other.id)) {
/* 108 */       return false;
/*     */     } 
/* 110 */     return true;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\CrucibleAction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */