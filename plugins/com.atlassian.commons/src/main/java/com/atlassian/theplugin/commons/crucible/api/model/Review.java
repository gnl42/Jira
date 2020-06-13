/*     */ package com.atlassian.theplugin.commons.crucible.api.model;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
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
/*     */ public class Review
/*     */   extends BasicReview
/*     */ {
/*  34 */   private Set<CrucibleFileInfo> files = Collections.emptySet();
/*  35 */   private List<Comment> generalComments = Collections.emptyList();
/*     */ 
/*     */   
/*     */   public Review(@NotNull String serverUrl, @NotNull String projectKey, @NotNull User author, @Nullable User moderator) {
/*  39 */     this(ReviewType.REVIEW, serverUrl, projectKey, author, moderator);
/*     */   }
/*     */ 
/*     */   
/*     */   public Review(@NotNull ReviewType type, @NotNull String serverUrl, @NotNull String projectKey, @NotNull User author, @Nullable User moderator) {
/*  44 */     super(type, serverUrl, projectKey, author, moderator);
/*     */   }
/*     */   
/*     */   public void setGeneralComments(@NotNull List<Comment> generalComments) {
/*  48 */     this.generalComments = generalComments;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public List<Comment> getGeneralComments() {
/*  53 */     return this.generalComments;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeGeneralComment(Comment generalComment) {
/*  63 */     if (!generalComment.isReply()) {
/*  64 */       this.generalComments.remove(generalComment);
/*     */     } else {
/*  66 */       for (Comment comment : this.generalComments) {
/*  67 */         if (comment.getReplies().remove(generalComment)) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeVersionedComment(VersionedComment comment, CrucibleFileInfo file) {
/*  76 */     CrucibleFileInfo f = getFileByPermId(file.getPermId());
/*     */     
/*  78 */     if (!comment.isReply()) {
/*  79 */       if (f != null) {
/*  80 */         f.getVersionedComments().remove(comment);
/*     */       }
/*     */     }
/*  83 */     else if (f != null) {
/*  84 */       for (VersionedComment versionedComment : f.getVersionedComments()) {
/*  85 */         if (versionedComment.getReplies().remove(comment)) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFilesAndVersionedComments(Collection<CrucibleFileInfo> aFiles, List<VersionedComment> commentList) {
/*  95 */     this.files = (aFiles != null) ? new HashSet<CrucibleFileInfo>(aFiles) : null;
/*     */     
/*  97 */     if (this.files != null && commentList != null) {
/*  98 */       for (VersionedComment comment : commentList) {
/*  99 */         comment.getCrucibleFileInfo().addComment(comment);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public CrucibleFileInfo getFileByPermId(PermId id) {
/* 107 */     for (CrucibleFileInfo f : getFiles()) {
/* 108 */       if (f.getPermId().equals(id)) {
/* 109 */         return f;
/*     */       }
/*     */     } 
/* 112 */     return null;
/*     */   }
/*     */   
/*     */   public Set<CrucibleFileInfo> getFiles() {
/* 116 */     return this.files;
/*     */   }
/*     */   
/*     */   public void setFiles(@NotNull Set<CrucibleFileInfo> files) {
/* 120 */     this.files = files;
/*     */   }
/*     */   
/*     */   public int getNumberOfGeneralCommentsDrafts() {
/* 124 */     int num = 0;
/* 125 */     for (Comment comment : getGeneralComments()) {
/* 126 */       if (comment.isDraft()) {
/* 127 */         num++;
/*     */       }
/* 129 */       num += comment.getNumberOfDraftReplies();
/*     */     } 
/* 131 */     return num;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public int getNumberOfGeneralCommentsDrafts(String userName) {
/* 141 */     int num = 0;
/* 142 */     for (Comment comment : getGeneralComments()) {
/* 143 */       if (comment.isDraft() && comment.getAuthor().getUsername().equals(userName)) {
/* 144 */         num++;
/*     */       }
/* 146 */       num += comment.getNumberOfDraftReplies();
/* 147 */       for (Comment reply : comment.getReplies()) {
/* 148 */         if (reply.isDraft() && reply.getAuthor().getUsername().equals(userName)) {
/* 149 */           num++;
/*     */         }
/*     */       } 
/*     */     } 
/* 153 */     return num;
/*     */   }
/*     */   
/*     */   public int getNumberOfGeneralCommentsDefects() {
/* 157 */     int num = 0;
/* 158 */     for (Comment comment : getGeneralComments()) {
/* 159 */       if (comment.isDefectRaised()) {
/* 160 */         num++;
/*     */       }
/* 162 */       for (Comment reply : comment.getReplies()) {
/* 163 */         if (reply.isDefectRaised()) {
/* 164 */           num++;
/*     */         }
/*     */       } 
/*     */     } 
/* 168 */     return num;
/*     */   }
/*     */   
/*     */   public int getNumberOfGeneralCommentsDefects(String userName) {
/* 172 */     int num = 0;
/* 173 */     for (Comment comment : getGeneralComments()) {
/* 174 */       if (comment.isDefectRaised() && comment.getAuthor().getUsername().equals(userName)) {
/* 175 */         num++;
/*     */       }
/* 177 */       for (Comment reply : comment.getReplies()) {
/* 178 */         if (reply.isDefectRaised() && reply.getAuthor().getUsername().equals(userName)) {
/* 179 */           num++;
/*     */         }
/*     */       } 
/*     */     } 
/* 183 */     return num;
/*     */   }
/*     */   
/*     */   public int getNumberOfGeneralComments() {
/* 187 */     int num = getGeneralComments().size();
/* 188 */     for (Comment comment : getGeneralComments()) {
/* 189 */       num += comment.getReplies().size();
/*     */     }
/* 191 */     return num;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfVersionedComments() {
/* 198 */     int num = 0;
/* 199 */     for (CrucibleFileInfo file : getFiles()) {
/* 200 */       num += file.getNumberOfComments();
/*     */     }
/* 202 */     return num;
/*     */   }
/*     */   
/*     */   public int getNumberOfVersionedComments(String userName) {
/* 206 */     int num = 0;
/* 207 */     for (CrucibleFileInfo file : getFiles()) {
/* 208 */       num += file.getNumberOfComments(userName);
/*     */     }
/* 210 */     return num;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumberOfUnreadComments() {
/* 215 */     List<Comment> allComments = new ArrayList<Comment>();
/* 216 */     allComments.addAll(getGeneralComments());
/* 217 */     for (CrucibleFileInfo file : getFiles()) {
/* 218 */       allComments.addAll((Collection)file.getVersionedComments());
/*     */     }
/* 220 */     int result = 0;
/*     */     
/* 222 */     for (Comment comment : allComments) {
/* 223 */       if (comment.getReadState() == Comment.ReadState.UNREAD || 
/* 224 */         comment.getReadState() == Comment.ReadState.LEAVE_UNREAD) {
/* 225 */         result++;
/*     */       }
/* 227 */       for (Comment reply : comment.getReplies()) {
/* 228 */         if (reply.getReadState() == Comment.ReadState.UNREAD || 
/* 229 */           reply.getReadState() == Comment.ReadState.LEAVE_UNREAD) {
/* 230 */           result++;
/*     */         }
/*     */       } 
/*     */     } 
/* 234 */     return result;
/*     */   }
/*     */   
/*     */   public int getNumberOfVersionedCommentsDefects() {
/* 238 */     int num = 0;
/* 239 */     for (CrucibleFileInfo file : getFiles()) {
/* 240 */       num += file.getNumberOfCommentsDefects();
/*     */     }
/* 242 */     return num;
/*     */   }
/*     */   
/*     */   public int getNumberOfVersionedCommentsDefects(String userName) {
/* 246 */     int num = 0;
/* 247 */     for (CrucibleFileInfo file : getFiles()) {
/* 248 */       num += file.getNumberOfCommentsDefects(userName);
/*     */     }
/* 250 */     return num;
/*     */   }
/*     */   
/*     */   public int getNumberOfVersionedCommentsDrafts() {
/* 254 */     int num = 0;
/* 255 */     for (CrucibleFileInfo file : getFiles()) {
/* 256 */       num += file.getNumberOfCommentsDrafts();
/*     */     }
/* 258 */     return num;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public int getNumberOfVersionedCommentsDrafts(String userName) {
/* 268 */     int num = 0;
/* 269 */     for (CrucibleFileInfo file : getFiles()) {
/* 270 */       num += file.getNumberOfCommentsDrafts(userName);
/*     */     }
/* 272 */     return num;
/*     */   }
/*     */   
/*     */   public int getNumberOfGeneralComments(String userName) {
/* 276 */     int num = 0;
/* 277 */     for (Comment comment : getGeneralComments()) {
/* 278 */       if (comment.getAuthor().getUsername().equals(userName)) {
/* 279 */         num++;
/*     */       }
/* 281 */       for (Comment reply : comment.getReplies()) {
/* 282 */         if (reply.getAuthor().getUsername().equals(userName)) {
/* 283 */           num++;
/*     */         }
/*     */       } 
/*     */     } 
/* 287 */     return num;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\Review.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */