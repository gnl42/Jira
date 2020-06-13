/*    */ package com.atlassian.theplugin.commons.crucible.api.model.changes;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
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
/*    */ public final class Changes
/*    */ {
/*    */   private final boolean olderChangeSetsExist;
/*    */   private final boolean newerChangeSetsExist;
/*    */   private final List<Change> changes;
/*    */   
/*    */   public Changes(boolean olderExist, boolean newestExist, @NotNull Collection<Change> changes) {
/* 27 */     this.olderChangeSetsExist = olderExist;
/* 28 */     this.newerChangeSetsExist = newestExist;
/* 29 */     this.changes = MiscUtil.buildArrayList(changes);
/*    */   }
/*    */   
/*    */   public boolean isOlderChangeSetsExist() {
/* 33 */     return this.olderChangeSetsExist;
/*    */   }
/*    */   
/*    */   public boolean isNewerChangeSetsExist() {
/* 37 */     return this.newerChangeSetsExist;
/*    */   }
/*    */   
/*    */   public List<Change> getChanges() {
/* 41 */     return this.changes;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\changes\Changes.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */