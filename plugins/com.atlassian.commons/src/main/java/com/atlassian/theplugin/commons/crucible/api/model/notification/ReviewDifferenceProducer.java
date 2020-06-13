/*     */ package com.atlassian.theplugin.commons.crucible.api.model.notification;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.Comment;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.CrucibleAction;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.CrucibleFileInfo;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.Reviewer;
/*     */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
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
/*     */ public class ReviewDifferenceProducer
/*     */ {
/*     */   private final Review oldReview;
/*     */   private final Review newReview;
/*  26 */   private final List<CrucibleNotification> notifications = new ArrayList<CrucibleNotification>();
/*     */   private boolean shortEqual;
/*     */   private boolean filesEqual;
/*     */   private int changes;
/*     */   
/*     */   public ReviewDifferenceProducer(@NotNull Review oldReview, @NotNull Review newReview) {
/*  32 */     this.oldReview = oldReview;
/*  33 */     this.newReview = newReview;
/*     */   }
/*     */   
/*     */   public boolean isShortEqual() {
/*  37 */     return this.shortEqual;
/*     */   }
/*     */   
/*     */   public boolean isFilesEqual() {
/*  41 */     return this.filesEqual;
/*     */   }
/*     */   
/*     */   public int getCommentChangesCount() {
/*  45 */     return this.changes;
/*     */   }
/*     */   
/*     */   public List<CrucibleNotification> getDiff() {
/*  49 */     this.notifications.clear();
/*  50 */     if (MiscUtil.isModified(this.oldReview.getDescription(), this.newReview.getDescription())) {
/*  51 */       this.notifications.add(new BasisReviewDetailsChangedNotification(this.newReview, 
/*  52 */             CrucibleNotificationType.STATEMENT_OF_OBJECTIVES_CHANGED, "Statement of Objectives has been changed"));
/*     */     }
/*  54 */     if (MiscUtil.isModified(this.oldReview.getName(), this.newReview.getName())) {
/*  55 */       this.notifications.add(new BasisReviewDetailsChangedNotification(this.newReview, CrucibleNotificationType.NAME_CHANGED, 
/*  56 */             "Review name has been changed"));
/*     */     }
/*     */     
/*  59 */     if (MiscUtil.isModified(this.oldReview.getModerator(), this.newReview.getModerator())) {
/*  60 */       this.notifications.add(new BasisReviewDetailsChangedNotification(this.newReview, CrucibleNotificationType.MODERATOR_CHANGED, 
/*  61 */             "Moderator has changed"));
/*     */     }
/*     */     
/*  64 */     if (MiscUtil.isModified(this.oldReview.getAuthor(), this.newReview.getAuthor())) {
/*  65 */       this.notifications.add(new BasisReviewDetailsChangedNotification(this.newReview, CrucibleNotificationType.AUTHOR_CHANGED, 
/*  66 */             "Author has changed"));
/*     */     }
/*     */     
/*  69 */     if (MiscUtil.isModified(this.oldReview.getSummary(), this.newReview.getSummary())) {
/*  70 */       this.notifications.add(new BasisReviewDetailsChangedNotification(this.newReview, CrucibleNotificationType.SUMMARY_CHANGED, 
/*  71 */             "Summary has been changed"));
/*     */     }
/*     */     
/*  74 */     if (MiscUtil.isModified(this.oldReview.getProjectKey(), this.newReview.getProjectKey())) {
/*  75 */       this.notifications.add(new BasisReviewDetailsChangedNotification(this.newReview, CrucibleNotificationType.PROJECT_CHANGED, 
/*  76 */             "Project has been changed"));
/*     */     }
/*     */     
/*  79 */     if (MiscUtil.isModified(this.oldReview.getDueDate(), this.newReview.getDueDate())) {
/*  80 */       this.notifications.add(new BasisReviewDetailsChangedNotification(this.newReview, CrucibleNotificationType.DUE_DATE_CHANGED, 
/*  81 */             "Due date has been changed"));
/*     */     }
/*     */     
/*  84 */     processReviewers();
/*     */     
/*  86 */     this.shortEqual = isShortContentEqual();
/*  87 */     if (!this.shortEqual) {
/*  88 */       this.notifications.add(new ReviewDataChangedNotification(this.newReview));
/*     */     }
/*  90 */     this.filesEqual = areFilesEqual();
/*     */     
/*  92 */     this.changes = checkComments(this.oldReview, this.newReview, true);
/*     */     
/*  94 */     return this.notifications;
/*     */   }
/*     */   
/*     */   private boolean isShortContentEqual() {
/*  98 */     if (!stateChanged() && 
/*  99 */       areActionsEqual() && 
/* 100 */       this.oldReview.isAllowReviewerToJoin() == this.newReview.isAllowReviewerToJoin() && 
/* 101 */       this.oldReview.getMetricsVersion() == this.newReview.getMetricsVersion() && 
/* 102 */       areObjectsEqual(this.oldReview.getCloseDate(), this.newReview.getCloseDate()) && 
/* 103 */       areObjectsEqual(this.oldReview.getCreateDate(), this.newReview.getCreateDate()) && 
/* 104 */       areObjectsEqual(this.oldReview.getCreator(), this.newReview.getCreator()) && 
/* 105 */       areObjectsEqual(this.oldReview.getParentReview(), this.newReview.getParentReview()) && 
/* 106 */       areObjectsEqual(this.oldReview.getRepoName(), this.newReview.getRepoName()) && 
/* 107 */       areTransitionsEqual()) return true; 
/*     */     return false;
/*     */   }
/*     */   private boolean areFilesEqual() {
/* 111 */     Set<CrucibleFileInfo> l = this.oldReview.getFiles();
/* 112 */     Set<CrucibleFileInfo> r = this.newReview.getFiles();
/*     */     
/* 114 */     if (l == null && r == null) {
/* 115 */       return true;
/*     */     }
/* 117 */     if (l == null || r == null) {
/* 118 */       return false;
/*     */     }
/* 120 */     boolean areFilesEqual = l.equals(r);
/* 121 */     if (!areFilesEqual) {
/* 122 */       for (CrucibleFileInfo crucibleFileInfo : r) {
/* 123 */         if (!l.contains(crucibleFileInfo)) {
/* 124 */           this.notifications.add(new NewReviewItemNotification(this.newReview));
/*     */         }
/*     */       } 
/* 127 */       for (CrucibleFileInfo crucibleFileInfo : l) {
/* 128 */         if (!r.contains(crucibleFileInfo)) {
/* 129 */           this.notifications.add(new RemovedReviewItemNotification(this.oldReview));
/*     */         }
/*     */       } 
/*     */     } 
/* 133 */     return areFilesEqual;
/*     */   }
/*     */   
/*     */   private boolean areActionsEqual() {
/* 137 */     Set<CrucibleAction> l = this.oldReview.getActions();
/* 138 */     Set<CrucibleAction> r = this.newReview.getActions();
/* 139 */     return areObjectsEqual(l, r);
/*     */   }
/*     */   
/*     */   private boolean areTransitionsEqual() {
/* 143 */     Set<CrucibleAction> l = this.oldReview.getTransitions();
/* 144 */     Set<CrucibleAction> r = this.newReview.getTransitions();
/* 145 */     return areObjectsEqual(l, r);
/*     */   }
/*     */   
/*     */   private static <T> boolean areObjectsEqual(T oldReview, T newReview) {
/* 149 */     return MiscUtil.isEqual(oldReview, newReview);
/*     */   }
/*     */   
/*     */   private boolean stateChanged() {
/* 153 */     if (!MiscUtil.isEqual(this.oldReview.getState(), this.newReview.getState())) {
/* 154 */       this.notifications.add(new ReviewStateChangedNotification(this.newReview, this.oldReview.getState()));
/* 155 */       return true;
/*     */     } 
/* 157 */     return false;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private Collection<String> buildReviewerSet(@Nullable Set<Reviewer> reviewers) {
/* 162 */     if (reviewers == null) {
/* 163 */       return null;
/*     */     }
/* 165 */     Set<String> res = new HashSet<String>(reviewers.size() * 2);
/* 166 */     for (Reviewer reviewer : reviewers) {
/* 167 */       res.add(reviewer.getUsername());
/*     */     }
/* 169 */     return res;
/*     */   }
/*     */   
/*     */   private void processReviewers() {
/* 173 */     boolean allCompleted = true;
/* 174 */     boolean atLeastOneChanged = false;
/*     */     
/* 176 */     Set<Reviewer> oldReviewers = this.oldReview.getReviewers();
/* 177 */     Set<Reviewer> newReviewers = this.newReview.getReviewers();
/*     */     
/* 179 */     Collection<String> oldR = buildReviewerSet(oldReviewers);
/* 180 */     Collection<String> newR = buildReviewerSet(newReviewers);
/*     */     
/* 182 */     if (MiscUtil.isModified(oldR, newR)) {
/* 183 */       this.notifications.add(new BasisReviewDetailsChangedNotification(this.newReview, CrucibleNotificationType.REVIEWERS_CHANGED, 
/* 184 */             "Reviewers have been changed"));
/*     */     }
/*     */     
/* 187 */     if (oldReviewers == null || newReviewers == null) {
/*     */       return;
/*     */     }
/*     */     
/* 191 */     for (Reviewer reviewer : newReviewers) {
/* 192 */       for (Reviewer oldReviewer : oldReviewers) {
/* 193 */         if (reviewer.getUsername().equals(oldReviewer.getUsername()) && 
/* 194 */           reviewer.isCompleted() != oldReviewer.isCompleted()) {
/* 195 */           this.notifications.add(new ReviewerCompletedNotification(this.newReview, reviewer));
/* 196 */           atLeastOneChanged = true;
/*     */         } 
/*     */       } 
/*     */       
/* 200 */       if (!reviewer.isCompleted()) {
/* 201 */         allCompleted = false;
/*     */       }
/*     */     } 
/* 204 */     if (allCompleted && atLeastOneChanged) {
/* 205 */       this.notifications.add(new ReviewCompletedNotification(this.newReview));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private int checkComments(Review anOldReview, Review aNewReview, boolean checkFiles) {
/* 211 */     int commentChanges = 0;
/*     */     
/* 213 */     Set<Comment> allOldComments = getAllCommentsRecursively(anOldReview.getGeneralComments());
/*     */     
/* 215 */     Set<Comment> allNewComments = getAllCommentsRecursively(aNewReview.getGeneralComments());
/*     */     
/* 217 */     for (Comment comment : allNewComments) {
/* 218 */       Comment existing = null;
/* 219 */       for (Comment oldComment : allOldComments) {
/* 220 */         if (comment.getPermId().getId().equals(oldComment.getPermId().getId())) {
/* 221 */           existing = oldComment;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 226 */       if (existing == null || 
/* 227 */         commentContentsDiffer(existing, comment) || 
/* 228 */         existing.getReadState() != comment.getReadState()) {
/* 229 */         commentChanges++;
/* 230 */         if (existing == null) {
/* 231 */           this.notifications.add(new NewCommentNotification(aNewReview, comment)); continue;
/*     */         } 
/* 233 */         if (commentContentsDiffer(existing, comment)) {
/* 234 */           this.notifications.add(new UpdatedCommentNotification(aNewReview, comment, existing.isDraft()));
/*     */         }
/* 236 */         checkAndNotifyReadUnreadStateChange(aNewReview, comment, existing);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 241 */     Set<Comment> deletedGen = getDeletedComments(allOldComments, allNewComments);
/* 242 */     for (Comment gc : deletedGen) {
/* 243 */       commentChanges++;
/* 244 */       this.notifications.add(new RemovedCommentNotification(aNewReview, gc));
/*     */     } 
/*     */     
/* 247 */     if (checkFiles) {
/* 248 */       int versionedChanges = 0;
/* 249 */       for (CrucibleFileInfo fileInfo : aNewReview.getFiles()) {
/* 250 */         allNewComments = getAllCommentsRecursively(fileInfo.getVersionedComments());
/* 251 */         for (Comment comment : allNewComments) {
/*     */           
/* 253 */           if (comment == null) {
/*     */             continue;
/*     */           }
/* 256 */           Comment existing = null;
/* 257 */           for (CrucibleFileInfo oldFile : anOldReview.getFiles()) {
/* 258 */             if (oldFile.getPermId().equals(fileInfo.getPermId())) {
/* 259 */               allOldComments = getAllCommentsRecursively(oldFile.getVersionedComments());
/* 260 */               for (Comment oldComment : allOldComments) {
/*     */                 
/* 262 */                 if (comment.getPermId() == null || oldComment == null || oldComment.getPermId() == null) {
/*     */                   continue;
/*     */                 }
/* 265 */                 if (comment.getPermId().getId().equals(oldComment.getPermId().getId())) {
/* 266 */                   existing = oldComment;
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/* 272 */           if (existing == null || 
/* 273 */             commentContentsDiffer(existing, comment) || 
/* 274 */             existing.getReadState() != comment.getReadState()) {
/* 275 */             versionedChanges++;
/* 276 */             if (existing == null) {
/* 277 */               this.notifications.add(new NewCommentNotification(aNewReview, comment)); continue;
/*     */             } 
/* 279 */             if (commentContentsDiffer(existing, comment)) {
/* 280 */               this.notifications.add(new UpdatedCommentNotification(aNewReview, comment, existing.isDraft()));
/*     */             }
/* 282 */             checkAndNotifyReadUnreadStateChange(aNewReview, comment, existing);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 288 */       for (CrucibleFileInfo oldFile : anOldReview.getFiles()) {
/* 289 */         for (CrucibleFileInfo newFile : aNewReview.getFiles()) {
/* 290 */           if (oldFile.getPermId().equals(newFile.getPermId())) {
/* 291 */             Set<Comment> oldVersionedComments = getAllCommentsRecursively(oldFile.getVersionedComments());
/* 292 */             Set<Comment> newVersionedComments = getAllCommentsRecursively(newFile.getVersionedComments());
/* 293 */             Set<Comment> deletedVcs = getDeletedComments(oldVersionedComments, newVersionedComments);
/* 294 */             for (Comment vc : deletedVcs) {
/* 295 */               versionedChanges++;
/* 296 */               this.notifications.add(new RemovedCommentNotification(aNewReview, vc));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 302 */       if (versionedChanges > 0) {
/* 303 */         commentChanges += versionedChanges;
/* 304 */         this.filesEqual = false;
/*     */       } 
/*     */     } 
/* 307 */     return commentChanges;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   private <T extends Comment> Set<Comment> getAllCommentsRecursively(@NotNull List<T> generalComments) {
/* 312 */     Set<Comment> result = MiscUtil.buildHashSet();
/* 313 */     for (Comment comment : generalComments) {
/* 314 */       result.add(comment);
/* 315 */       List<Comment> replies = comment.getReplies();
/* 316 */       if (replies != null && replies.size() > 0) {
/* 317 */         result.addAll(getAllCommentsRecursively(replies));
/*     */       }
/*     */     } 
/* 320 */     return result;
/*     */   }
/*     */   
/*     */   private void checkAndNotifyReadUnreadStateChange(Review aNewReview, Comment comment, Comment existing) {
/* 324 */     if (existing.getReadState() != comment.getReadState()) {
/* 325 */       this.notifications.add(new CommentReadUnreadStateChangedNotification(aNewReview, comment));
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean commentContentsDiffer(Comment existing, Comment comment) {
/* 330 */     if (existing.getMessage().equals(comment.getMessage()) && 
/* 331 */       existing.isDefectRaised() == comment.isDefectRaised() && 
/* 332 */       existing.isDraft() == comment.isDraft()) return false; 
/*     */     return true;
/*     */   }
/*     */   private <T extends Comment> Set<T> getDeletedComments(Collection<T> org, Collection<T> modified) {
/* 336 */     Set<T> deletedList = MiscUtil.buildHashSet();
/*     */     
/* 338 */     for (Comment comment : org) {
/* 339 */       boolean found = false;
/* 340 */       for (Comment comment1 : modified) {
/* 341 */         if (comment1 != null && comment1.getPermId() != null && comment != null && 
/* 342 */           comment1.getPermId().equals(comment.getPermId())) {
/* 343 */           found = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 347 */       if (!found) {
/* 348 */         deletedList.add((T)comment);
/*     */       }
/*     */     } 
/*     */     
/* 352 */     return deletedList;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\notification\ReviewDifferenceProducer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */