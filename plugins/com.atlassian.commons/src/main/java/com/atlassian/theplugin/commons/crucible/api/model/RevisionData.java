/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.Set;
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
/*    */ public final class RevisionData
/*    */ {
/*    */   private final Set<String> revisions;
/*    */   private final String source;
/*    */   private final String path;
/*    */   
/*    */   public RevisionData(@NotNull String source, @NotNull String path, @NotNull Collection<String> revisions) {
/* 29 */     this.source = source;
/* 30 */     this.path = path;
/* 31 */     this.revisions = MiscUtil.buildHashSet();
/* 32 */     this.revisions.addAll(revisions);
/*    */   }
/*    */   
/*    */   public String getSource() {
/* 36 */     return this.source;
/*    */   }
/*    */   
/*    */   public String getPath() {
/* 40 */     return this.path;
/*    */   }
/*    */   
/*    */   public Set<String> getRevisions() {
/* 44 */     return Collections.unmodifiableSet(this.revisions);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\RevisionData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */