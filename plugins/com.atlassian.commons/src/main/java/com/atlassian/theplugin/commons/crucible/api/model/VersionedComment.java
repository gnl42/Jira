/*     */ package com.atlassian.theplugin.commons.crucible.api.model;
/*     */ 
/*     */ import com.atlassian.connector.commons.misc.IntRanges;
/*     */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*     */ import java.util.Map;
/*     */ import org.jetbrains.annotations.NotNull;
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
/*     */ 
/*     */ 
/*     */ public class VersionedComment
/*     */   extends Comment
/*     */ {
/*     */   private PermId reviewItemId;
/*     */   private int fromStartLine;
/*     */   private int fromEndLine;
/*     */   private boolean fromLineInfo;
/*     */   private int toStartLine;
/*     */   private int toEndLine;
/*     */   private boolean toLineInfo;
/*     */   private IntRanges toLineRanges;
/*     */   private IntRanges fromLineRanges;
/*     */   private Map<String, IntRanges> lineRanges;
/*     */   @NotNull
/*     */   private final CrucibleFileInfo crucibleFileInfo;
/*     */   private static final int HASH_INT = 31;
/*     */   
/*     */   public VersionedComment(VersionedComment bean) {
/*  49 */     super(bean);
/*  50 */     if (bean.isFromLineInfo()) {
/*  51 */       setFromLineInfo(true);
/*  52 */       setFromStartLine(bean.getFromStartLine());
/*  53 */       setFromEndLine(bean.getFromEndLine());
/*     */     } 
/*  55 */     if (bean.isToLineInfo()) {
/*  56 */       setToLineInfo(true);
/*  57 */       setToStartLine(bean.getToStartLine());
/*  58 */       setToEndLine(bean.getToEndLine());
/*     */     } 
/*  60 */     this.crucibleFileInfo = bean.crucibleFileInfo;
/*     */   }
/*     */   
/*     */   public VersionedComment(Review review, @NotNull CrucibleFileInfo crucibleFileInfo) {
/*  64 */     super(review, null);
/*  65 */     this.crucibleFileInfo = crucibleFileInfo;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public CrucibleFileInfo getCrucibleFileInfo() {
/*  70 */     return this.crucibleFileInfo;
/*     */   }
/*     */   
/*     */   public PermId getReviewItemId() {
/*  74 */     return this.reviewItemId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setReviewItemId(PermId reviewItemId) {
/*  82 */     this.reviewItemId = reviewItemId;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public int getFromStartLine() {
/*  87 */     return this.fromStartLine;
/*     */   }
/*     */   
/*     */   public void setFromStartLine(int startLine) {
/*  91 */     this.fromStartLine = startLine;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public int getFromEndLine() {
/*  96 */     return this.fromEndLine;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public IntRanges getFromLineRanges() {
/* 101 */     return this.fromLineRanges;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Comment createReplyBean(Comment reply) {
/* 106 */     return new GeneralComment(reply);
/*     */   }
/*     */   
/*     */   public void setFromLineRanges(IntRanges fromLineRanges) {
/* 110 */     this.fromLineRanges = fromLineRanges;
/* 111 */     setFromLineInfo(true);
/* 112 */     setFromStartLine(fromLineRanges.getTotalMin());
/* 113 */     setFromEndLine(fromLineRanges.getTotalMax());
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public IntRanges getToLineRanges() {
/* 118 */     return this.toLineRanges;
/*     */   }
/*     */   
/*     */   public Map<String, IntRanges> getLineRanges() {
/* 122 */     return this.lineRanges;
/*     */   }
/*     */   
/*     */   public void setLineRanges(Map<String, IntRanges> lineRanges) {
/* 126 */     this.lineRanges = lineRanges;
/*     */   }
/*     */   
/*     */   public void setToLineRanges(IntRanges toLineRanges) {
/* 130 */     this.toLineRanges = toLineRanges;
/* 131 */     setToLineInfo(true);
/* 132 */     setToStartLine(toLineRanges.getTotalMin());
/* 133 */     setToEndLine(toLineRanges.getTotalMax());
/*     */   }
/*     */   
/*     */   public void setFromEndLine(int endLine) {
/* 137 */     this.fromEndLine = endLine;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public int getToStartLine() {
/* 142 */     return this.toStartLine;
/*     */   }
/*     */   
/*     */   public void setToStartLine(int startLine) {
/* 146 */     this.toStartLine = startLine;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public int getToEndLine() {
/* 151 */     return this.toEndLine;
/*     */   }
/*     */   
/*     */   public void setToEndLine(int endLine) {
/* 155 */     this.toEndLine = endLine;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public boolean isFromLineInfo() {
/* 160 */     return this.fromLineInfo;
/*     */   }
/*     */   
/*     */   public void setFromLineInfo(boolean fromLineInfo) {
/* 164 */     this.fromLineInfo = fromLineInfo;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public boolean isToLineInfo() {
/* 169 */     return this.toLineInfo;
/*     */   }
/*     */   
/*     */   public void setToLineInfo(boolean toLineInfo) {
/* 173 */     this.toLineInfo = toLineInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 180 */     int result = super.hashCode();
/* 181 */     result = 31 * result + ((this.lineRanges != null) ? this.lineRanges.hashCode() : 0);
/* 182 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 187 */     if (this == obj) {
/* 188 */       return true;
/*     */     }
/* 190 */     if (!super.equals(obj)) {
/* 191 */       return false;
/*     */     }
/* 193 */     if (!(obj instanceof VersionedComment)) {
/* 194 */       return false;
/*     */     }
/* 196 */     VersionedComment other = (VersionedComment)obj;
/* 197 */     if (!MiscUtil.isEqual(this.crucibleFileInfo, other.crucibleFileInfo)) {
/* 198 */       return false;
/*     */     }
/*     */     
/* 201 */     if (this.fromEndLine != other.fromEndLine) {
/* 202 */       return false;
/*     */     }
/* 204 */     if (this.fromLineInfo != other.fromLineInfo) {
/* 205 */       return false;
/*     */     }
/*     */     
/* 208 */     if (!MiscUtil.isEqual(this.fromLineRanges, other.fromLineRanges)) {
/* 209 */       return false;
/*     */     }
/*     */     
/* 212 */     if (this.fromStartLine != other.fromStartLine) {
/* 213 */       return false;
/*     */     }
/*     */     
/* 216 */     if (!MiscUtil.isEqual(this.lineRanges, other.lineRanges)) {
/* 217 */       return false;
/*     */     }
/*     */     
/* 220 */     if (!MiscUtil.isEqual(this.reviewItemId, other.reviewItemId)) {
/* 221 */       return false;
/*     */     }
/*     */     
/* 224 */     if (this.toEndLine != other.toEndLine) {
/* 225 */       return false;
/*     */     }
/* 227 */     if (this.toLineInfo != other.toLineInfo) {
/* 228 */       return false;
/*     */     }
/*     */     
/* 231 */     if (!MiscUtil.isEqual(this.toLineRanges, other.toLineRanges)) {
/* 232 */       return false;
/*     */     }
/*     */     
/* 235 */     if (this.toStartLine != other.toStartLine) {
/* 236 */       return false;
/*     */     }
/* 238 */     return true;
/*     */   }
/*     */   
/*     */   public boolean deepEquals(Object o) {
/* 242 */     if (this == o) {
/* 243 */       return true;
/*     */     }
/* 245 */     if (!(o instanceof VersionedComment)) {
/* 246 */       return false;
/*     */     }
/* 248 */     if (!super.equals(o)) {
/* 249 */       return false;
/*     */     }
/*     */     
/* 252 */     VersionedComment that = (VersionedComment)o;
/*     */     
/* 254 */     if (this.fromEndLine != that.fromEndLine) {
/* 255 */       return false;
/*     */     }
/* 257 */     if (this.fromLineInfo != that.fromLineInfo) {
/* 258 */       return false;
/*     */     }
/* 260 */     if (this.fromStartLine != that.fromStartLine) {
/* 261 */       return false;
/*     */     }
/* 263 */     if (this.toEndLine != that.toEndLine) {
/* 264 */       return false;
/*     */     }
/* 266 */     if (this.toLineInfo != that.toLineInfo) {
/* 267 */       return false;
/*     */     }
/* 269 */     if (this.toStartLine != that.toStartLine) {
/* 270 */       return false;
/*     */     }
/*     */     
/* 273 */     if (lineRangesNotEqual(that.lineRanges)) {
/* 274 */       return false;
/*     */     }
/*     */     
/* 277 */     if ((getReplies() != null) ? !getReplies().equals(that.getReplies()) : (that.getReplies() != null)) {
/* 278 */       return false;
/*     */     }
/* 280 */     if (!this.reviewItemId.equals(that.reviewItemId)) {
/* 281 */       return false;
/*     */     }
/*     */     
/* 284 */     if (getReplies().size() != that.getReplies().size()) {
/* 285 */       return false;
/*     */     }
/*     */     
/* 288 */     for (Comment vc : getReplies()) {
/* 289 */       boolean found = false;
/* 290 */       for (Comment tvc : that.getReplies()) {
/* 291 */         if (vc.getPermId() == tvc.getPermId() && ((VersionedComment)vc).deepEquals(vc)) {
/* 292 */           found = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 296 */       if (!found) {
/* 297 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 301 */     return true;
/*     */   }
/*     */   
/*     */   private boolean lineRangesNotEqual(Map<String, IntRanges> thatLineRanges) {
/* 305 */     if (this.lineRanges == null && thatLineRanges == null) {
/* 306 */       return true;
/*     */     }
/* 308 */     if (this.lineRanges == null) {
/* 309 */       return false;
/*     */     }
/* 311 */     if (thatLineRanges == null) {
/* 312 */       return false;
/*     */     }
/* 314 */     return this.lineRanges.equals(thatLineRanges);
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\VersionedComment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */