/*     */ package com.atlassian.theplugin.commons.crucible.api.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
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
/*     */ 
/*     */ 
/*     */ public class BasicProject
/*     */   implements Serializable
/*     */ {
/*     */   private final String id;
/*     */   private final String key;
/*     */   private final String name;
/*     */   private final Collection<String> defaultReviewers;
/*     */   private final String defaultRepository;
/*     */   private final boolean joiningAllowed;
/*     */   private final Integer defaultDuration;
/*     */   private final boolean moderatorEnabled;
/*     */   private static final int HASH_INT = 31;
/*     */   
/*     */   public BasicProject(@NotNull String id, @NotNull String key, @NotNull String name) {
/*  39 */     this(id, key, name, null, null, true, null, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicProject(@NotNull String id, @NotNull String key, @NotNull String name, @Nullable Collection<String> defaultReviewers, @Nullable String defaultRepository, boolean allowJoin, Integer defaultDuration, boolean moderatorEnabled) {
/*  45 */     this.id = id;
/*  46 */     this.key = key;
/*  47 */     this.name = name;
/*  48 */     this.defaultReviewers = defaultReviewers;
/*  49 */     this.defaultRepository = defaultRepository;
/*  50 */     this.joiningAllowed = allowJoin;
/*  51 */     this.defaultDuration = defaultDuration;
/*  52 */     this.moderatorEnabled = moderatorEnabled;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getId() {
/*  57 */     return this.id;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getKey() {
/*  62 */     return this.key;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getName() {
/*  67 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  72 */     if (this == o) {
/*  73 */       return true;
/*     */     }
/*  75 */     if (o == null || getClass() != o.getClass()) {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     BasicProject that = (BasicProject)o;
/*     */     
/*  81 */     if ((this.id != null) ? !this.id.equals(that.id) : (that.id != null)) {
/*  82 */       return false;
/*     */     }
/*  84 */     if ((this.key != null) ? !this.key.equals(that.key) : (that.key != null)) {
/*  85 */       return false;
/*     */     }
/*  87 */     if ((this.name != null) ? !this.name.equals(that.name) : (that.name != null)) {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  97 */     int result = (this.id != null) ? this.id.hashCode() : 0;
/*  98 */     result = 31 * result + ((this.key != null) ? this.key.hashCode() : 0);
/*  99 */     result = 31 * result + ((this.name != null) ? this.name.hashCode() : 0);
/* 100 */     return result;
/*     */   }
/*     */   
/*     */   public Collection<String> getDefaultReviewers() {
/* 104 */     return this.defaultReviewers;
/*     */   }
/*     */   
/*     */   public String getDefaultRepository() {
/* 108 */     return this.defaultRepository;
/*     */   }
/*     */   
/*     */   public boolean isJoiningAllowed() {
/* 112 */     return this.joiningAllowed;
/*     */   }
/*     */   
/*     */   public Integer getDefaultDuration() {
/* 116 */     return this.defaultDuration;
/*     */   }
/*     */   
/*     */   public boolean isModeratorEnabled() {
/* 120 */     return this.moderatorEnabled;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\BasicProject.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */