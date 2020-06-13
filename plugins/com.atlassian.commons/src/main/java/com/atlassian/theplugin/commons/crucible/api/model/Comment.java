/*     */ package com.atlassian.theplugin.commons.crucible.api.model;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public abstract class Comment
/*     */ {
/*     */   private PermId permId;
/*     */   
/*     */   public enum ReadState
/*     */   {
/*  30 */     UNKNOWN("Unknown"), READ("Read"), UNREAD("Not read"), LEAVE_UNREAD("Leave unread");
/*     */     
/*     */     private final String name;
/*     */     
/*     */     ReadState(String name) {
/*  35 */       this.name = name;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  40 */       return this.name;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  45 */   private String message = null;
/*     */   private boolean draft = false;
/*     */   private boolean deleted = false;
/*     */   private boolean defectRaised = false;
/*     */   private boolean defectApproved = false;
/*  50 */   private User author = null;
/*  51 */   private Date createDate = new Date();
/*     */   
/*     */   private ReadState readState;
/*  54 */   private List<Comment> replies = new ArrayList<Comment>();
/*     */   
/*     */   private boolean isReply = false;
/*     */   
/*  58 */   private final Map<String, CustomField> customFields = new HashMap<String, CustomField>();
/*     */   
/*     */   private static final int HASH_INT = 31;
/*     */   
/*     */   private final Review review;
/*     */   @Nullable
/*     */   private final Comment parentComment;
/*     */   
/*     */   public Comment(Review review, @Nullable Comment parentComment) {
/*  67 */     this.review = review;
/*  68 */     this.parentComment = parentComment;
/*     */   }
/*     */ 
/*     */   
/*     */   public Comment(Comment bean) {
/*  73 */     this.review = bean.getReview();
/*  74 */     this.parentComment = bean.parentComment;
/*  75 */     setPermId(bean.getPermId());
/*  76 */     setMessage(bean.getMessage());
/*  77 */     setDraft(bean.isDraft());
/*  78 */     setCreateDate(bean.getCreateDate());
/*  79 */     setDefectApproved(bean.isDefectApproved());
/*  80 */     setDefectRaised(bean.isDefectRaised());
/*  81 */     setDeleted(bean.isDeleted());
/*  82 */     setAuthor(bean.getAuthor());
/*  83 */     setAuthor(bean.getAuthor());
/*  84 */     setReply(bean.isReply());
/*  85 */     setReadState(bean.getReadState());
/*     */     
/*  87 */     if (bean.getCustomFields() != null) {
/*  88 */       for (Map.Entry<String, CustomField> entry : bean.getCustomFields().entrySet()) {
/*  89 */         getCustomFields().put(entry.getKey(), new CustomFieldBean(entry.getValue()));
/*     */       }
/*     */     }
/*     */     
/*  93 */     if (bean.getReplies() != null) {
/*  94 */       for (Comment reply : bean.getReplies()) {
/*  95 */         this.replies.add(createReplyBean(reply));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected abstract Comment createReplyBean(Comment paramComment);
/*     */   
/*     */   @Nullable
/*     */   public Comment getParentComment() {
/* 104 */     return this.parentComment;
/*     */   }
/*     */   
/*     */   public Review getReview() {
/* 108 */     return this.review;
/*     */   }
/*     */   
/*     */   public PermId getPermId() {
/* 112 */     return this.permId;
/*     */   }
/*     */   
/*     */   public void setPermId(PermId permId) {
/* 116 */     this.permId = permId;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/* 120 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String message) {
/* 124 */     this.message = message;
/*     */   }
/*     */   
/*     */   public boolean isDraft() {
/* 128 */     return this.draft;
/*     */   }
/*     */   
/*     */   public void setDraft(boolean draft) {
/* 132 */     this.draft = draft;
/*     */   }
/*     */   
/*     */   public boolean isDeleted() {
/* 136 */     return this.deleted;
/*     */   }
/*     */   
/*     */   public void setDeleted(boolean deleted) {
/* 140 */     this.deleted = deleted;
/*     */   }
/*     */   
/*     */   public boolean isDefectRaised() {
/* 144 */     return this.defectRaised;
/*     */   }
/*     */   
/*     */   public void setDefectRaised(boolean defectRaised) {
/* 148 */     this.defectRaised = defectRaised;
/*     */   }
/*     */   
/*     */   public boolean isDefectApproved() {
/* 152 */     return this.defectApproved;
/*     */   }
/*     */   
/*     */   public boolean isReply() {
/* 156 */     return this.isReply;
/*     */   }
/*     */   
/*     */   public void setReply(boolean reply) {
/* 160 */     this.isReply = reply;
/*     */   }
/*     */   
/*     */   public void setReplies(List<Comment> replies) {
/* 164 */     if (replies == null) {
/* 165 */       this.replies = new ArrayList<Comment>();
/*     */     } else {
/* 167 */       this.replies = replies;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addReply(Comment comment) {
/* 172 */     this.replies.add(comment);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeReply(@Nullable Comment reply) {
/* 181 */     return this.replies.remove(reply);
/*     */   }
/*     */   
/*     */   public List<Comment> getReplies() {
/* 185 */     return this.replies;
/*     */   }
/*     */   
/*     */   public void setDefectApproved(boolean defectApproved) {
/* 189 */     this.defectApproved = defectApproved;
/*     */   }
/*     */   
/*     */   public User getAuthor() {
/* 193 */     return this.author;
/*     */   }
/*     */   
/*     */   public void setAuthor(User author) {
/* 197 */     this.author = author;
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 201 */     return new Date(this.createDate.getTime());
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date createDate) {
/* 205 */     if (createDate != null) {
/* 206 */       this.createDate = new Date(createDate.getTime());
/*     */     }
/*     */   }
/*     */   
/*     */   public Map<String, CustomField> getCustomFields() {
/* 211 */     return this.customFields;
/*     */   }
/*     */   
/*     */   public ReadState getReadState() {
/* 215 */     return this.readState;
/*     */   }
/*     */   
/*     */   public void setReadState(ReadState readState) {
/* 219 */     this.readState = readState;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 224 */     return getMessage();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 229 */     if (this == o) {
/* 230 */       return true;
/*     */     }
/* 232 */     if (o == null || getClass() != o.getClass()) {
/* 233 */       return false;
/*     */     }
/*     */     
/* 236 */     Comment that = (Comment)o;
/*     */     
/* 238 */     if (!MiscUtil.isEqual(this.review.getPermId(), that.review.getPermId())) {
/* 239 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 249 */     if (!MiscUtil.isEqual(this.parentComment, that.parentComment)) {
/* 250 */       return false;
/*     */     }
/*     */     
/* 253 */     if (this.defectApproved != that.defectApproved) {
/* 254 */       return false;
/*     */     }
/* 256 */     if (this.defectRaised != that.defectRaised) {
/* 257 */       return false;
/*     */     }
/* 259 */     if (this.deleted != that.deleted) {
/* 260 */       return false;
/*     */     }
/* 262 */     if (this.draft != that.draft) {
/* 263 */       return false;
/*     */     }
/* 265 */     if (this.isReply != that.isReply) {
/* 266 */       return false;
/*     */     }
/* 268 */     if ((this.author != null) ? !this.author.equals(that.author) : (that.author != null)) {
/* 269 */       return false;
/*     */     }
/* 271 */     if ((this.createDate != null) ? !this.createDate.equals(that.createDate) : (that.createDate != null)) {
/* 272 */       return false;
/*     */     }
/* 274 */     if ((this.customFields != null) ? !this.customFields.equals(that.customFields) : (that.customFields != null)) {
/* 275 */       return false;
/*     */     }
/* 277 */     if ((this.message != null) ? !this.message.equals(that.message) : (that.message != null)) {
/* 278 */       return false;
/*     */     }
/* 280 */     if ((this.permId != null) ? !this.permId.equals(that.permId) : (that.permId != null)) {
/* 281 */       return false;
/*     */     }
/*     */     
/* 284 */     if ((this.readState != null) ? !this.readState.equals(that.readState) : (that.readState != null)) {
/* 285 */       return false;
/*     */     }
/*     */     
/* 288 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 294 */     int result = (this.permId != null) ? this.permId.hashCode() : 0;
/* 295 */     result = 31 * result + ((this.message != null) ? this.message.hashCode() : 0);
/* 296 */     result = 31 * result + (this.draft ? 1 : 0);
/* 297 */     result = 31 * result + (this.deleted ? 1 : 0);
/* 298 */     result = 31 * result + (this.defectRaised ? 1 : 0);
/* 299 */     result = 31 * result + (this.defectApproved ? 1 : 0);
/* 300 */     result = 31 * result + ((this.author != null) ? this.author.hashCode() : 0);
/* 301 */     result = 31 * result + ((this.createDate != null) ? this.createDate.hashCode() : 0);
/* 302 */     result = 31 * result + (this.isReply ? 1 : 0);
/* 303 */     result = 31 * result + ((this.customFields != null) ? this.customFields.hashCode() : 0);
/* 304 */     result = 31 * result + ((this.readState != null) ? this.readState.ordinal() : 0);
/* 305 */     return result;
/*     */   }
/*     */   
/*     */   public int getNumReplies() {
/* 309 */     int res = this.replies.size();
/* 310 */     for (Comment reply : this.replies) {
/* 311 */       res += reply.getNumReplies();
/*     */     }
/* 313 */     return res;
/*     */   }
/*     */   
/*     */   public int getNumberOfUnreadReplies() {
/* 317 */     int counter = 0;
/* 318 */     for (Comment reply : this.replies) {
/* 319 */       if (reply.isEffectivelyUnread()) {
/* 320 */         counter++;
/*     */       }
/* 322 */       counter += reply.getNumberOfUnreadReplies();
/*     */     } 
/* 324 */     return counter;
/*     */   }
/*     */   
/*     */   public int getNumberOfDraftReplies() {
/* 328 */     int counter = 0;
/* 329 */     for (Comment reply : this.replies) {
/* 330 */       if (reply.isDraft()) {
/* 331 */         counter++;
/*     */       }
/* 333 */       counter += reply.getNumberOfDraftReplies();
/*     */     } 
/* 335 */     return counter;
/*     */   }
/*     */   
/*     */   public boolean isEffectivelyUnread() {
/* 339 */     return !(getReadState() != ReadState.UNREAD && getReadState() != ReadState.LEAVE_UNREAD);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasDraftParents() {
/* 344 */     if (this.parentComment == null) {
/* 345 */       return false;
/*     */     }
/* 347 */     return !(!this.parentComment.isDraft() && !this.parentComment.hasDraftParents());
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\Comment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */