/*     */ package com.atlassian.theplugin.commons.crucible.api.model;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class User
/*     */   implements Serializable
/*     */ {
/*     */   private static final int HASH_MAGIC = 31;
/*     */   @NotNull
/*     */   protected String userName;
/*     */   @Nullable
/*     */   protected String displayName;
/*     */   @Nullable
/*     */   private String avatarUrl;
/*     */   
/*     */   public User(String userName) {
/*  40 */     this.userName = userName;
/*     */   }
/*     */   
/*     */   public User(@NotNull String userName, @Nullable String displayName) {
/*  44 */     this(userName, displayName, null);
/*     */   }
/*     */   
/*     */   public User(@NotNull String userName, @Nullable String displayName, @Nullable String avatarUrl) {
/*  48 */     this.userName = userName;
/*  49 */     this.displayName = displayName;
/*  50 */     this.avatarUrl = avatarUrl;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getAvatarUrl() {
/*  55 */     return this.avatarUrl;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getUsername() {
/*  60 */     return this.userName;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getDisplayName() {
/*  65 */     if (this.displayName == null) {
/*  66 */       return this.userName;
/*     */     }
/*  68 */     return this.displayName;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  73 */     if (this == o) {
/*  74 */       return true;
/*     */     }
/*  76 */     if (o == null || getClass() != o.getClass()) {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     User userBean = (User)o;
/*     */     
/*  82 */     if ((this.displayName != null) ? !this.displayName.equals(userBean.displayName) : (userBean.displayName != null)) {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if ((this.userName != null) ? !this.userName.equals(userBean.userName) : (userBean.userName != null)) {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     int result = (this.userName != null) ? this.userName.hashCode() : 0;
/*  97 */     result = 31 * result + ((this.displayName != null) ? this.displayName.hashCode() : 0);
/*  98 */     return result;
/*     */   }
/*     */   
/*     */   public int compareTo(User that) {
/* 102 */     return this.userName.compareTo(that.getUsername());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 107 */     return "User [[" + this.userName + "], [" + this.displayName + "]]";
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\User.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */