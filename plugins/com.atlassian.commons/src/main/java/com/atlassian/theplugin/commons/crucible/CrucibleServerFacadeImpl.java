/*     */ package com.atlassian.theplugin.commons.crucible;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import com.atlassian.connector.commons.crucible.CrucibleServerFacade2;
/*     */ import com.atlassian.theplugin.commons.ServerType;
/*     */ import com.atlassian.theplugin.commons.crucible.api.CrucibleLoginException;
/*     */ import com.atlassian.theplugin.commons.crucible.api.CrucibleSession;
/*     */ import com.atlassian.theplugin.commons.crucible.api.PathAndRevision;
/*     */ import com.atlassian.theplugin.commons.crucible.api.UploadItem;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.BasicProject;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.BasicReview;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.Comment;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.CrucibleFileInfo;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.CrucibleUserCache;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.CrucibleVersionInfo;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.CustomFieldDef;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.CustomFilter;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.GeneralComment;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.NewReviewItem;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.PatchAnchorData;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.PermId;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.PredefinedFilter;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.Repository;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.Reviewer;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.User;
/*     */ import com.atlassian.theplugin.commons.crucible.api.model.VersionedComment;
/*     */ import com.atlassian.theplugin.commons.crucible.api.rest.CrucibleSessionImpl;
/*     */ import com.atlassian.theplugin.commons.exception.ServerPasswordNotProvidedException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiMalformedUrlException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.HttpSessionCallback;
/*     */ import com.atlassian.theplugin.commons.util.Logger;
/*     */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*     */ import com.atlassian.theplugin.commons.util.UrlUtil;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class CrucibleServerFacadeImpl
/*     */   implements CrucibleServerFacade2
/*     */ {
/*  61 */   private final Map<String, CrucibleSession> sessions = new HashMap<String, CrucibleSession>();
/*     */   
/*     */   private CrucibleUserCache userCache;
/*     */   
/*     */   private HttpSessionCallback callback;
/*     */   
/*     */   private final Logger logger;
/*     */ 
/*     */   
/*     */   public CrucibleServerFacadeImpl(@NotNull Logger logger, CrucibleUserCache userCache, @NotNull HttpSessionCallback callback) {
/*  71 */     this.logger = logger;
/*  72 */     this.userCache = userCache;
/*  73 */     this.callback = callback;
/*     */   }
/*     */   
/*     */   public void setUserCache(CrucibleUserCache newCache) {
/*  77 */     this.userCache = newCache;
/*     */   }
/*     */   
/*     */   public ServerType getServerType() {
/*  81 */     return ServerType.CRUCIBLE_SERVER;
/*     */   }
/*     */   
/*     */   public synchronized CrucibleSession getSession(ConnectionCfg server) throws RemoteApiException, ServerPasswordNotProvidedException {
/*     */     CrucibleSessionImpl crucibleSessionImpl;
/*  86 */     String key = String.valueOf(server.getUrl()) + server.getUsername() + server.getPassword();
/*  87 */     CrucibleSession session = this.sessions.get(key);
/*  88 */     if (session == null) {
/*     */       try {
/*  90 */         crucibleSessionImpl = new CrucibleSessionImpl(server, this.callback, this.logger);
/*     */         
/*  92 */         if (!crucibleSessionImpl.isLoggedIn()) {
/*  93 */           crucibleSessionImpl.login();
/*     */         }
/*  95 */         this.sessions.put(key, crucibleSessionImpl);
/*  96 */       } catch (RemoteApiMalformedUrlException e) {
/*  97 */         if (server.getPassword().length() > 0 || !UrlUtil.isUrlValid(server.getUrl())) {
/*  98 */           throw e;
/*     */         }
/*     */ 
/*     */         
/* 102 */         throw new ServerPasswordNotProvidedException(e);
/*     */       } 
/*     */     }
/*     */     
/* 106 */     return (CrucibleSession)crucibleSessionImpl;
/*     */   }
/*     */   
/*     */   private void fixUserName(ConnectionCfg server, Comment comment) {
/* 110 */     User u = comment.getAuthor();
/* 111 */     if (u.getDisplayName() == null || u.getDisplayName().length() == 0) {
/* 112 */       User newU = this.userCache.getUser(this, server, u.getUsername(), true);
/* 113 */       if (newU != null) {
/* 114 */         comment.setAuthor(newU);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getDisplayName(@NotNull ConnectionCfg server, @NotNull String username) {
/* 121 */     User user = this.userCache.getUser(this, server, username, true);
/* 122 */     return (user != null) ? user.getDisplayName() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public User getUser(@NotNull ConnectionCfg server, String username) {
/* 129 */     return this.userCache.getUser(this, server, username, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicProject getProject(@NotNull ConnectionCfg server, @NotNull String projectKey) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 137 */     List<BasicProject> projects = getProjects(server);
/* 138 */     for (BasicProject project : projects) {
/* 139 */       if (project.getKey().equals(projectKey)) {
/* 140 */         return project;
/*     */       }
/*     */     } 
/* 143 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkContentUrlAvailable(ConnectionCfg server) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 148 */     CrucibleSession session = getSession(server);
/* 149 */     return session.checkContentUrlAvailable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Review createReviewFromUpload(@NotNull ConnectionCfg server, @NotNull Review review, @NotNull Collection<UploadItem> uploadItems) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 155 */     CrucibleSession session = getSession(server);
/* 156 */     return getFullReview(session.createReviewFromUpload(review, uploadItems), session);
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
/*     */   public void testServerConnection(ConnectionCfg connectionCfg) throws RemoteApiException {
/* 168 */     CrucibleSessionImpl crucibleSessionImpl = new CrucibleSessionImpl(connectionCfg, this.callback, this.logger);
/* 169 */     crucibleSessionImpl.login();
/* 170 */     crucibleSessionImpl.isLoggedIn();
/*     */     try {
/* 172 */       crucibleSessionImpl.getServerVersion();
/* 173 */     } catch (RemoteApiException e) {
/*     */ 
/*     */       
/* 176 */       if (e.getCause() != null && e.getCause().getMessage() != null && 
/* 177 */         e.getCause().getMessage().startsWith("HTTP 500")) {
/* 178 */         throw new CrucibleLoginException("Atlassian Connector for IntelliJ IDEA detected a Crucible version older\nthan 1.6. Unfortunately, the plugin will not\nwork with this version of Crucible.\nDetailed error message is\n" + 
/*     */             
/* 180 */             e.getCause().getMessage() + "\n");
/*     */       }
/*     */       
/* 183 */       throw e;
/*     */     } 
/* 185 */     crucibleSessionImpl.logout();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   private Review getFullReview(@Nullable BasicReview basicReview, CrucibleSession session) throws RemoteApiException {
/* 196 */     if (basicReview == null) {
/* 197 */       return null;
/*     */     }
/* 199 */     return session.getReview(basicReview.getPermId());
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
/*     */   public Review createReview(ConnectionCfg server, Review review) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 213 */     CrucibleSession session = getSession(server);
/* 214 */     return getFullReview(session.createReview(review), session);
/*     */   }
/*     */ 
/*     */   
/*     */   public Review createReviewFromRevision(ConnectionCfg server, Review review, List<String> revisions) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 219 */     CrucibleSession session = getSession(server);
/* 220 */     return getFullReview(session.createReviewFromRevision(review, revisions), session);
/*     */   }
/*     */ 
/*     */   
/*     */   public Review addRevisionsToReview(ConnectionCfg server, PermId permId, String repository, Collection<String> revisions) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 225 */     CrucibleSession session = getSession(server);
/* 226 */     Review review = null;
/* 227 */     if (!revisions.isEmpty()) {
/* 228 */       review = getFullReview(session.addRevisionsToReview(permId, repository, revisions), session);
/*     */     }
/* 230 */     return review;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Review addFileRevisionsToReview(ConnectionCfg server, PermId permId, String repository, List<PathAndRevision> revisions) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 237 */     CrucibleSession session = getSession(server);
/* 238 */     Review review = null;
/* 239 */     if (!revisions.isEmpty()) {
/* 240 */       review = getFullReview(session.addFileRevisionsToReview(permId, repository, revisions), session);
/*     */     }
/* 242 */     return review;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addFileToReview(ConnectionCfg server, PermId permId, NewReviewItem newReviewItem) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 247 */     CrucibleSession session = getSession(server);
/* 248 */     session.addFileToReview(permId, newReviewItem);
/*     */   }
/*     */ 
/*     */   
/*     */   public CrucibleVersionInfo getServerVersion(ConnectionCfg server) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 253 */     CrucibleSession session = getSession(server);
/* 254 */     return session.getServerVersion();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<BasicReview> getAllReviewsForFile(ConnectionCfg server, String repoName, String filePath) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 259 */     CrucibleSession session = getSession(server);
/* 260 */     return session.getAllReviewsForFile(repoName, filePath);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<BasicReview> getReviewsForIssue(ConnectionCfg server, String jiraIssueKey, int maxReturn) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 265 */     CrucibleSession session = getSession(server);
/* 266 */     return session.getReviewsForIssue(jiraIssueKey, maxReturn);
/*     */   }
/*     */ 
/*     */   
/*     */   public Review addPatchToReview(ConnectionCfg server, PermId permId, String repository, String patch) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 271 */     CrucibleSession session = getSession(server);
/* 272 */     return getFullReview(session.addPatchToReview(permId, repository, patch), session);
/*     */   }
/*     */ 
/*     */   
/*     */   public Review addItemsToReview(ConnectionCfg server, PermId permId, Collection<UploadItem> items) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 277 */     CrucibleSession session = getSession(server);
/* 278 */     session.addItemsToReview(permId, items);
/* 279 */     return session.getReview(permId);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addReviewers(ConnectionCfg server, PermId permId, Set<String> userNames) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 284 */     CrucibleSession session = getSession(server);
/* 285 */     session.addReviewers(permId, userNames);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeReviewer(ConnectionCfg server, PermId permId, String userName) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 290 */     CrucibleSession session = getSession(server);
/* 291 */     session.removeReviewer(permId, userName);
/*     */   }
/*     */   
/*     */   private boolean contains(Set<Reviewer> reviewers, String username) {
/* 295 */     for (Reviewer reviewer : reviewers) {
/* 296 */       if (reviewer.getUsername().equals(username)) {
/* 297 */         return true;
/*     */       }
/*     */     } 
/* 300 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setReviewers(@NotNull ConnectionCfg server, @NotNull PermId permId, @NotNull Collection<String> aUsernames) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 305 */     Set<String> reviewersForAdd = MiscUtil.buildHashSet();
/* 306 */     Set<String> reviewersForRemove = MiscUtil.buildHashSet();
/* 307 */     Review review = getReview(server, permId);
/*     */     
/* 309 */     Set<String> usernames = MiscUtil.buildHashSet(aUsernames);
/*     */     
/* 311 */     for (String username : usernames) {
/* 312 */       if (!contains(review.getReviewers(), username)) {
/* 313 */         reviewersForAdd.add(username);
/*     */       }
/*     */     } 
/*     */     
/* 317 */     for (Reviewer reviewer : review.getReviewers()) {
/* 318 */       if (!usernames.contains(reviewer.getUsername())) {
/* 319 */         reviewersForRemove.add(reviewer.getUsername());
/*     */       }
/*     */     } 
/*     */     
/* 323 */     if (!reviewersForAdd.isEmpty()) {
/* 324 */       addReviewers(server, permId, reviewersForAdd);
/*     */     }
/* 326 */     if (!reviewersForRemove.isEmpty()) {
/* 327 */       for (String reviewer : reviewersForRemove) {
/* 328 */         removeReviewer(server, permId, reviewer);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Review closeReview(ConnectionCfg server, PermId permId, String summary) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 336 */     CrucibleSession session = getSession(server);
/* 337 */     return getFullReview(session.closeReview(permId, summary), session);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void completeReview(ConnectionCfg server, PermId permId, boolean complete) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 343 */     CrucibleSession session = getSession(server);
/* 344 */     session.completeReview(permId, complete);
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
/*     */   public Review createReviewFromPatch(ConnectionCfg server, Review review, String patch) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 361 */     CrucibleSession session = getSession(server);
/* 362 */     return getFullReview(session.createReviewFromPatch(review, patch), session);
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
/*     */   public Review createReviewFromPatch(ConnectionCfg server, Review review, String patch, PatchAnchorData anchorData) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 380 */     CrucibleSession session = getSession(server);
/* 381 */     return getFullReview(session.createReviewFromPatch(review, patch, anchorData), session);
/*     */   }
/*     */   
/*     */   public Set<CrucibleFileInfo> getFiles(ConnectionCfg server, PermId permId) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 385 */     CrucibleSession session = getSession(server);
/* 386 */     return session.getFiles(permId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<VersionedComment> getVersionedComments(ConnectionCfg server, Review review, CrucibleFileInfo reviewItem) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 397 */     CrucibleSession session = getSession(server);
/* 398 */     return session.getVersionedComments(review, reviewItem);
/*     */   }
/*     */ 
/*     */   
/*     */   public Comment addGeneralComment(ConnectionCfg server, Review review, Comment comment) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 403 */     CrucibleSession session = getSession(server);
/* 404 */     GeneralComment newComment = (GeneralComment)session.addGeneralComment(review, comment);
/* 405 */     if (newComment != null) {
/* 406 */       fixUserName(server, (Comment)newComment);
/*     */     }
/* 408 */     return (Comment)newComment;
/*     */   }
/*     */ 
/*     */   
/*     */   public VersionedComment addVersionedComment(ConnectionCfg server, Review review, PermId riId, VersionedComment comment) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 413 */     CrucibleSession session = getSession(server);
/* 414 */     VersionedComment newComment = session.addVersionedComment(review, riId, comment);
/* 415 */     if (newComment != null) {
/* 416 */       fixUserName(server, (Comment)newComment);
/*     */     }
/* 418 */     return newComment;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateComment(ConnectionCfg server, PermId id, Comment comment) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 423 */     CrucibleSession session = getSession(server);
/* 424 */     session.updateComment(id, comment);
/*     */   }
/*     */ 
/*     */   
/*     */   public void publishComment(ConnectionCfg server, PermId reviewId, PermId commentId) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 429 */     CrucibleSession session = getSession(server);
/* 430 */     session.publishComment(reviewId, commentId);
/*     */   }
/*     */ 
/*     */   
/*     */   public void publishAllCommentsForReview(ConnectionCfg server, PermId reviewId) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 435 */     CrucibleSession session = getSession(server);
/* 436 */     session.publishComment(reviewId, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Comment addReply(ConnectionCfg server, Comment reply) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 441 */     CrucibleSession session = getSession(server);
/* 442 */     GeneralComment newReply = (GeneralComment)session.addReply(reply.getReview(), reply);
/* 443 */     if (newReply != null) {
/* 444 */       fixUserName(server, (Comment)newReply);
/*     */     }
/* 446 */     return (Comment)newReply;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeComment(ConnectionCfg server, PermId id, Comment comment) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 451 */     CrucibleSession session = getSession(server);
/* 452 */     session.removeComment(id, comment);
/*     */   }
/*     */   
/*     */   public List<User> getUsers(ConnectionCfg server) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 456 */     CrucibleSession session = getSession(server);
/* 457 */     return session.getUsers();
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
/*     */   public List<BasicProject> getProjects(ConnectionCfg server) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 471 */     CrucibleSession session = getSession(server);
/* 472 */     return session.getProjects();
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
/*     */   public List<Repository> getRepositories(ConnectionCfg server) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 486 */     CrucibleSession session = getSession(server);
/* 487 */     return session.getRepositories();
/*     */   }
/*     */ 
/*     */   
/*     */   public Repository getRepository(ConnectionCfg server, String repoName) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 492 */     CrucibleSession session = getSession(server);
/* 493 */     return session.getRepository(repoName);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<CustomFieldDef> getMetrics(ConnectionCfg server, int version) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 498 */     CrucibleSession session = getSession(server);
/* 499 */     return session.getMetrics(version);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<BasicReview> getReviewsForFilter(ConnectionCfg server, PredefinedFilter filter) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 504 */     CrucibleSession session = getSession(server);
/* 505 */     return session.getReviewsForFilter(filter);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<BasicReview> getReviewsForCustomFilter(ConnectionCfg server, CustomFilter filter) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 510 */     CrucibleSession session = getSession(server);
/* 511 */     return session.getReviewsForCustomFilter(filter);
/*     */   }
/*     */ 
/*     */   
/*     */   public Review getReview(ConnectionCfg server, PermId permId) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 516 */     CrucibleSession session = getSession(server);
/* 517 */     return session.getReview(permId);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Reviewer> getReviewers(ConnectionCfg server, PermId permId) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 522 */     CrucibleSession session = getSession(server);
/* 523 */     return session.getReviewers(permId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCallback(HttpSessionCallback callback) {
/* 533 */     this.callback = callback;
/*     */   }
/*     */ 
/*     */   
/*     */   public void markCommentRead(@NotNull ConnectionCfg server, PermId reviewId, PermId commentId) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 538 */     CrucibleSession session = getSession(server);
/* 539 */     session.markCommentRead(reviewId, commentId);
/*     */   }
/*     */ 
/*     */   
/*     */   public void markCommentLeaveUnread(@NotNull ConnectionCfg server, PermId reviewId, PermId commentId) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 544 */     CrucibleSession session = getSession(server);
/* 545 */     session.markCommentLeaveRead(reviewId, commentId);
/*     */   }
/*     */ 
/*     */   
/*     */   public void markAllCommentsRead(@NotNull ConnectionCfg server, PermId reviewId) throws RemoteApiException, ServerPasswordNotProvidedException {
/* 550 */     CrucibleSession session = getSession(server);
/* 551 */     session.markAllCommentsRead(reviewId);
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\CrucibleServerFacadeImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */