/*     */ package com.atlassian.theplugin.commons;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.commons.io.FilenameUtils;
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
/*     */ public class VersionedVirtualFile
/*     */ {
/*     */   private String revision;
/*     */   private String url;
/*     */   private String repoUrl;
/*     */   private String contentUrl;
/*     */   private static final int HASH_NUMBER = 13;
/*     */   
/*     */   public VersionedVirtualFile(String path, String revision) {
/*  35 */     this.revision = revision;
/*  36 */     this.url = path;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] contentsToByteArray() throws IOException {
/*  42 */     return new byte[0];
/*     */   }
/*     */   
/*     */   public String getRevision() {
/*  46 */     return this.revision;
/*     */   }
/*     */   
/*     */   public void setRevision(String revision) {
/*  50 */     this.revision = revision;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  54 */     return FilenameUtils.getName(getUrl());
/*     */   }
/*     */   
/*     */   public String getUrl() {
/*  58 */     return this.url;
/*     */   }
/*     */   
/*     */   public void setUrl(String url) {
/*  62 */     this.url = url;
/*     */   }
/*     */   
/*     */   public String getRepoUrl() {
/*  66 */     return this.repoUrl;
/*     */   }
/*     */   
/*     */   public void setRepoUrl(String repoUrl) {
/*  70 */     this.repoUrl = repoUrl;
/*     */   }
/*     */   
/*     */   public String getAbsoluteUrl() {
/*  74 */     return String.valueOf((this.repoUrl != null) ? this.repoUrl : "") + this.url;
/*     */   }
/*     */   
/*     */   public String getContentUrl() {
/*  78 */     return this.contentUrl;
/*     */   }
/*     */   
/*     */   public void setContentUrl(String contentUrl) {
/*  82 */     this.contentUrl = contentUrl;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o) {
/*  86 */     if (this == o) {
/*  87 */       return true;
/*     */     }
/*  89 */     if (o == null || getClass() != o.getClass()) {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     VersionedVirtualFile that = (VersionedVirtualFile)o;
/*     */     
/*  95 */     if ((this.url != null) ? !this.url.equals(that.url) : (that.url != null)) {
/*  96 */       return false;
/*     */     }
/*  98 */     if ((this.revision != null) ? !this.revision.equals(that.revision) : (that.revision != null)) {
/*  99 */       return false;
/*     */     }
/* 101 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 107 */     int result = (this.url != null) ? this.url.hashCode() : 0;
/* 108 */     result = 13 * result + ((this.revision != null) ? this.revision.hashCode() : 0);
/* 109 */     return result;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\VersionedVirtualFile.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */