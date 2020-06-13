/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
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
/*    */ public class ExtendedCrucibleProject
/*    */   extends BasicProject
/*    */ {
/*    */   private final Collection<String> allowedReviewers;
/*    */   
/*    */   public ExtendedCrucibleProject(@NotNull String id, @NotNull String key, @NotNull String name) {
/* 28 */     this(id, key, name, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public ExtendedCrucibleProject(@NotNull String id, @NotNull String key, @NotNull String name, @Nullable Collection<String> allowedReviewers) {
/* 33 */     this(id, key, name, allowedReviewers, null, null, true, null, true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ExtendedCrucibleProject(@NotNull String id, @NotNull String key, @NotNull String name, @Nullable Collection<String> allowedReviewers, @Nullable Collection<String> defaultReviewers, @Nullable String defaultRepository, boolean allowJoin, Integer defaultDuration, boolean moderatorEnabled) {
/* 40 */     super(id, key, name, defaultReviewers, defaultRepository, allowJoin, defaultDuration, moderatorEnabled);
/* 41 */     this.allowedReviewers = allowedReviewers;
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Collection<String> getAllowedReviewers() {
/* 46 */     return this.allowedReviewers;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\ExtendedCrucibleProject.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */