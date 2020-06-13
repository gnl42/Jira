/*    */ package com.atlassian.connector.commons.crucible.api.model;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.crucible.api.model.Reviewer;
/*    */ import java.util.Comparator;
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
/*    */ public class ByReviewerDisplayNameComparator
/*    */   implements Comparator<Reviewer>
/*    */ {
/*    */   public int compare(Reviewer o1, Reviewer o2) {
/* 19 */     String dn1 = o1.getDisplayName();
/* 20 */     String dn2 = o2.getDisplayName();
/* 21 */     return dn1.compareTo(dn2);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\crucible\api\model\ByReviewerDisplayNameComparator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */