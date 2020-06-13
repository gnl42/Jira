/*     */ package com.atlassian.theplugin.commons.crucible.api.model;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.VersionedFileInfo;
/*     */ import com.atlassian.theplugin.commons.VersionedVirtualFile;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
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
/*     */ public class CrucibleFileInfo
/*     */   implements VersionedFileInfo
/*     */ {
/*     */   @Nullable
/*     */   private VersionedVirtualFile fileDescriptor;
/*     */   @Nullable
/*     */   private VersionedVirtualFile oldFileDescriptor;
/*     */   private String repositoryName;
/*     */   private FileType fileType;
/*     */   private String authorName;
/*     */   private Date commitDate;
/*     */   private CommitType commitType;
/*     */   private RepositoryType repositoryType;
/*     */   private PermId permId;
/*     */   private List<VersionedComment> versionedComments;
/*     */   private static final int HASH_NUMBER = 31;
/*     */   
/*     */   public CrucibleFileInfo() {}
/*     */   
/*     */   public CrucibleFileInfo(@Nullable VersionedVirtualFile fileDescriptor, @Nullable VersionedVirtualFile oldFileDescriptor, @NotNull PermId permId) {
/*  50 */     this.fileDescriptor = fileDescriptor;
/*  51 */     this.oldFileDescriptor = oldFileDescriptor;
/*  52 */     this.permId = permId;
/*  53 */     this.versionedComments = new ArrayList<VersionedComment>();
/*     */   }
/*     */   
/*     */   public List<VersionedComment> getVersionedComments() {
/*  57 */     return this.versionedComments;
/*     */   }
/*     */   
/*     */   public void setVersionedComments(List<VersionedComment> versionedComments) {
/*  61 */     this.versionedComments = versionedComments;
/*     */   }
/*     */   
/*     */   public int getNumberOfCommentsDefects() {
/*  65 */     if (this.versionedComments == null) {
/*  66 */       return 0;
/*     */     }
/*  68 */     int counter = 0;
/*  69 */     for (VersionedComment comment : this.versionedComments) {
/*  70 */       if (comment.isDefectRaised()) {
/*  71 */         counter++;
/*     */       }
/*  73 */       for (Comment reply : comment.getReplies()) {
/*  74 */         if (reply.isDefectRaised()) {
/*  75 */           counter++;
/*     */         }
/*     */       } 
/*     */     } 
/*  79 */     return counter;
/*     */   }
/*     */   
/*     */   public int getNumberOfCommentsDefects(String userName) {
/*  83 */     if (this.versionedComments == null) {
/*  84 */       return 0;
/*     */     }
/*     */     
/*  87 */     int counter = 0;
/*  88 */     for (VersionedComment comment : this.versionedComments) {
/*  89 */       if (comment.isDefectRaised() && comment.getAuthor().getUsername().equals(userName)) {
/*  90 */         counter++;
/*     */       }
/*  92 */       for (Comment reply : comment.getReplies()) {
/*  93 */         if (reply.isDefectRaised() && reply.getAuthor().getUsername().equals(userName)) {
/*  94 */           counter++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  99 */     return counter;
/*     */   }
/*     */   
/*     */   public int getNumberOfCommentsDrafts() {
/* 103 */     if (this.versionedComments == null) {
/* 104 */       return 0;
/*     */     }
/* 106 */     int counter = 0;
/* 107 */     for (VersionedComment comment : this.versionedComments) {
/* 108 */       if (comment.isDraft()) {
/* 109 */         counter++;
/*     */       }
/* 111 */       counter += comment.getNumberOfDraftReplies();
/*     */     } 
/* 113 */     return counter;
/*     */   }
/*     */   
/*     */   public int getNumberOfCommentsDrafts(String userName) {
/* 117 */     if (this.versionedComments == null) {
/* 118 */       return 0;
/*     */     }
/*     */     
/* 121 */     int counter = 0;
/* 122 */     for (VersionedComment comment : this.versionedComments) {
/* 123 */       if (comment.isDraft() && comment.getAuthor().getUsername().equals(userName)) {
/* 124 */         counter++;
/*     */       }
/* 126 */       for (Comment reply : comment.getReplies()) {
/* 127 */         if (reply.isDraft() && reply.getAuthor().getUsername().equals(userName)) {
/* 128 */           counter++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     return counter;
/*     */   }
/*     */   
/*     */   public int getNumberOfLineComments() {
/* 137 */     if (this.versionedComments == null) {
/* 138 */       return 0;
/*     */     }
/*     */     
/* 141 */     int counter = 0;
/* 142 */     for (VersionedComment comment : this.versionedComments) {
/* 143 */       if (comment.isFromLineInfo() || comment.isToLineInfo()) {
/* 144 */         counter++;
/*     */       }
/*     */     } 
/*     */     
/* 148 */     return counter;
/*     */   }
/*     */   
/*     */   public int getNumberOfUnreadComments() {
/* 152 */     if (this.versionedComments == null) {
/* 153 */       return 0;
/*     */     }
/*     */     
/* 156 */     int counter = 0;
/* 157 */     for (VersionedComment comment : this.versionedComments) {
/* 158 */       if (comment.isEffectivelyUnread()) {
/* 159 */         counter++;
/*     */       }
/* 161 */       counter += comment.getNumberOfUnreadReplies();
/*     */     } 
/*     */     
/* 164 */     return counter;
/*     */   }
/*     */   
/*     */   public int getNumberOfComments(String userName) {
/* 168 */     if (this.versionedComments == null) {
/* 169 */       return 0;
/*     */     }
/*     */     
/* 172 */     int counter = 0;
/* 173 */     for (VersionedComment comment : this.versionedComments) {
/* 174 */       if (comment.getAuthor().getUsername().equals(userName)) {
/* 175 */         counter++;
/*     */       }
/* 177 */       for (Comment reply : comment.getReplies()) {
/* 178 */         if (reply.getAuthor().getUsername().equals(userName)) {
/* 179 */           counter++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     return counter;
/*     */   }
/*     */   
/*     */   public int getNumberOfComments() {
/* 188 */     if (this.versionedComments == null) {
/* 189 */       return 0;
/*     */     }
/* 191 */     int n = this.versionedComments.size();
/* 192 */     for (VersionedComment c : this.versionedComments) {
/* 193 */       n += c.getNumReplies();
/*     */     }
/* 195 */     return n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VersionedVirtualFile getOldFileDescriptor() {
/* 204 */     return this.oldFileDescriptor;
/*     */   }
/*     */   
/*     */   public PermId getPermId() {
/* 208 */     return this.permId;
/*     */   }
/*     */   
/*     */   public void setOldFileDescriptor(VersionedVirtualFile oldFileDescriptor) {
/* 212 */     this.oldFileDescriptor = oldFileDescriptor;
/*     */   }
/*     */   
/*     */   public void setFileDescriptor(VersionedVirtualFile fileDescriptor) {
/* 216 */     this.fileDescriptor = fileDescriptor;
/*     */   }
/*     */   
/*     */   public VersionedVirtualFile getFileDescriptor() {
/* 220 */     return this.fileDescriptor;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 225 */     VersionedVirtualFile oldFile = getOldFileDescriptor();
/* 226 */     VersionedVirtualFile newFile = getFileDescriptor();
/* 227 */     if (oldFile != null && oldFile.getUrl().length() > 0 && 
/* 228 */       newFile != null && newFile.getUrl().length() > 0)
/* 229 */       return String.valueOf(oldFile.getUrl()) + " (mod)"; 
/* 230 */     if (oldFile != null && oldFile.getUrl().length() > 0)
/* 231 */       return String.valueOf(oldFile.getUrl()) + " (del)"; 
/* 232 */     if (newFile != null && newFile.getUrl().length() > 0) {
/* 233 */       return String.valueOf(newFile.getUrl()) + " (new)";
/*     */     }
/* 235 */     return "(unknown state)";
/*     */   }
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
/*     */   public String getRepositoryName() {
/* 257 */     return this.repositoryName;
/*     */   }
/*     */   
/*     */   public void setRepositoryName(String repositoryName) {
/* 261 */     this.repositoryName = repositoryName;
/*     */   }
/*     */   
/*     */   public FileType getFileType() {
/* 265 */     return this.fileType;
/*     */   }
/*     */   
/*     */   public void setFileType(FileType fileType) {
/* 269 */     this.fileType = fileType;
/*     */   }
/*     */   
/*     */   public String getAuthorName() {
/* 273 */     return this.authorName;
/*     */   }
/*     */   
/*     */   public void setAuthorName(String authorName) {
/* 277 */     this.authorName = authorName;
/*     */   }
/*     */   
/*     */   public Date getCommitDate() {
/* 281 */     return this.commitDate;
/*     */   }
/*     */   
/*     */   public void setCommitDate(Date commitDate) {
/* 285 */     this.commitDate = commitDate;
/*     */   }
/*     */   
/*     */   public CommitType getCommitType() {
/* 289 */     return this.commitType;
/*     */   }
/*     */   
/*     */   public void addComment(VersionedComment comment) {
/* 293 */     this.versionedComments.add(comment);
/*     */   }
/*     */   
/*     */   public void setCommitType(CommitType commitType) {
/* 297 */     this.commitType = commitType;
/*     */   }
/*     */   
/*     */   public void setFilePermId(PermId aPermId) {
/* 301 */     this.permId = aPermId;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 306 */     if (this == o) {
/* 307 */       return true;
/*     */     }
/* 309 */     if (o == null || getClass() != o.getClass()) {
/* 310 */       return false;
/*     */     }
/*     */     
/* 313 */     CrucibleFileInfo that = (CrucibleFileInfo)o;
/*     */     
/* 315 */     if (this.fileType != that.fileType) {
/* 316 */       return false;
/*     */     }
/* 318 */     if (!this.permId.equals(that.permId)) {
/* 319 */       return false;
/*     */     }
/* 321 */     if ((this.repositoryName != null) ? !this.repositoryName.equals(that.repositoryName) : (that.repositoryName != null)) {
/* 322 */       return false;
/*     */     }
/* 324 */     if ((this.oldFileDescriptor != null) ? !this.oldFileDescriptor.equals(that.oldFileDescriptor) : (that.oldFileDescriptor != null)) {
/* 325 */       return false;
/*     */     }
/* 327 */     if ((this.fileDescriptor != null) ? !this.fileDescriptor.equals(that.fileDescriptor) : (that.fileDescriptor != null)) {
/* 328 */       return false;
/*     */     }
/*     */     
/* 331 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 337 */     int result = (this.repositoryName != null) ? this.repositoryName.hashCode() : 0;
/* 338 */     result = 31 * result + ((this.fileDescriptor != null) ? this.fileDescriptor.hashCode() : 0);
/* 339 */     result = 31 * result + ((this.oldFileDescriptor != null) ? this.oldFileDescriptor.hashCode() : 0);
/* 340 */     result = 31 * result + ((this.fileType != null) ? this.fileType.hashCode() : 0);
/* 341 */     result = 31 * result + this.permId.hashCode();
/* 342 */     return result;
/*     */   }
/*     */   
/*     */   public RepositoryType getRepositoryType() {
/* 346 */     return this.repositoryType;
/*     */   }
/*     */   
/*     */   public void setRepositoryType(RepositoryType repositoryType) {
/* 350 */     this.repositoryType = repositoryType;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\CrucibleFileInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */