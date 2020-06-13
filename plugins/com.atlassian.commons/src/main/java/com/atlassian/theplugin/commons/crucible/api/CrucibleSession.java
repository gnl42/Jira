package com.atlassian.theplugin.commons.crucible.api;

import com.atlassian.theplugin.commons.crucible.api.model.BasicProject;
import com.atlassian.theplugin.commons.crucible.api.model.BasicReview;
import com.atlassian.theplugin.commons.crucible.api.model.Comment;
import com.atlassian.theplugin.commons.crucible.api.model.CrucibleAction;
import com.atlassian.theplugin.commons.crucible.api.model.CrucibleFileInfo;
import com.atlassian.theplugin.commons.crucible.api.model.CrucibleVersionInfo;
import com.atlassian.theplugin.commons.crucible.api.model.CustomFieldDef;
import com.atlassian.theplugin.commons.crucible.api.model.CustomFilter;
import com.atlassian.theplugin.commons.crucible.api.model.ExtendedCrucibleProject;
import com.atlassian.theplugin.commons.crucible.api.model.NewReviewItem;
import com.atlassian.theplugin.commons.crucible.api.model.PatchAnchorData;
import com.atlassian.theplugin.commons.crucible.api.model.PermId;
import com.atlassian.theplugin.commons.crucible.api.model.PredefinedFilter;
import com.atlassian.theplugin.commons.crucible.api.model.Repository;
import com.atlassian.theplugin.commons.crucible.api.model.Review;
import com.atlassian.theplugin.commons.crucible.api.model.Reviewer;
import com.atlassian.theplugin.commons.crucible.api.model.RevisionData;
import com.atlassian.theplugin.commons.crucible.api.model.State;
import com.atlassian.theplugin.commons.crucible.api.model.User;
import com.atlassian.theplugin.commons.crucible.api.model.VersionedComment;
import com.atlassian.theplugin.commons.crucible.api.model.changes.Changes;
import com.atlassian.theplugin.commons.remoteapi.ProductSession;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiLoginException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CrucibleSession extends ProductSession {
  void login() throws RemoteApiLoginException;
  
  void logout();
  
  CrucibleVersionInfo getServerVersion() throws RemoteApiException;
  
  @Nullable
  BasicReview createReview(Review paramReview) throws RemoteApiException;
  
  @Nullable
  BasicReview createSnippetReview(Review paramReview, String paramString1, String paramString2) throws RemoteApiException;
  
  @Nullable
  BasicReview createReviewFromPatch(Review paramReview, String paramString, PatchAnchorData paramPatchAnchorData) throws RemoteApiException;
  
  @Nullable
  BasicReview createReviewFromPatch(Review paramReview, String paramString) throws RemoteApiException;
  
  @Nullable
  BasicReview createReviewFromRevision(Review paramReview, List<String> paramList) throws RemoteApiException;
  
  List<CrucibleAction> getAvailableActions(PermId paramPermId) throws RemoteApiException;
  
  List<CrucibleAction> getAvailableTransitions(PermId paramPermId) throws RemoteApiException;
  
  @Nullable
  BasicReview addRevisionsToReview(PermId paramPermId, String paramString, Collection<String> paramCollection) throws RemoteApiException;
  
  BasicReview addRevisionsToReviewItems(PermId paramPermId, Collection<RevisionData> paramCollection) throws RemoteApiException;
  
  @Nullable
  BasicReview addFileRevisionsToReview(PermId paramPermId, String paramString, List<PathAndRevision> paramList) throws RemoteApiException;
  
  void addFileToReview(PermId paramPermId, NewReviewItem paramNewReviewItem) throws RemoteApiException;
  
  @Nullable
  BasicReview addPatchToReview(PermId paramPermId, String paramString1, String paramString2) throws RemoteApiException;
  
  void addReviewers(PermId paramPermId, Set<String> paramSet) throws RemoteApiException;
  
  void removeReviewer(PermId paramPermId, String paramString) throws RemoteApiException;
  
  BasicReview changeReviewState(PermId paramPermId, CrucibleAction paramCrucibleAction) throws RemoteApiException;
  
  @Nullable
  BasicReview closeReview(PermId paramPermId, String paramString) throws RemoteApiException;
  
  void completeReview(PermId paramPermId, boolean paramBoolean) throws RemoteApiException;
  
  List<BasicReview> getReviewsInStates(List<State> paramList) throws RemoteApiException;
  
  List<BasicReview> getAllReviews() throws RemoteApiException;
  
  List<BasicReview> getReviewsForFilter(PredefinedFilter paramPredefinedFilter) throws RemoteApiException;
  
  List<BasicReview> getReviewsForCustomFilter(CustomFilter paramCustomFilter) throws RemoteApiException;
  
  List<BasicReview> getAllReviewsForFile(String paramString1, String paramString2) throws RemoteApiException;
  
  Review getReview(PermId paramPermId) throws RemoteApiException;
  
  List<Reviewer> getReviewers(PermId paramPermId) throws RemoteApiException;
  
  List<User> getUsers() throws RemoteApiException;
  
  List<BasicProject> getProjects() throws RemoteApiException;
  
  ExtendedCrucibleProject getProject(String paramString) throws RemoteApiException;
  
  List<Repository> getRepositories() throws RemoteApiException;
  
  Repository getRepository(String paramString) throws RemoteApiException;
  
  Set<CrucibleFileInfo> getFiles(PermId paramPermId) throws RemoteApiException;
  
  List<VersionedComment> getVersionedComments(Review paramReview, CrucibleFileInfo paramCrucibleFileInfo) throws RemoteApiException;
  
  Comment addGeneralComment(Review paramReview, Comment paramComment) throws RemoteApiException;
  
  VersionedComment addVersionedComment(Review paramReview, PermId paramPermId, VersionedComment paramVersionedComment) throws RemoteApiException;
  
  void removeComment(PermId paramPermId, Comment paramComment) throws RemoteApiException;
  
  void updateComment(PermId paramPermId, Comment paramComment) throws RemoteApiException;
  
  void publishComment(PermId paramPermId1, PermId paramPermId2) throws RemoteApiException;
  
  @Nullable
  Comment addReply(Review paramReview, Comment paramComment) throws RemoteApiException;
  
  void updateReply(PermId paramPermId1, PermId paramPermId2, PermId paramPermId3, Comment paramComment) throws RemoteApiException;
  
  List<CustomFieldDef> getMetrics(int paramInt) throws RemoteApiException;
  
  boolean isLoggedIn() throws RemoteApiLoginException;
  
  @Nullable
  BasicReview createReviewFromUpload(Review paramReview, Collection<UploadItem> paramCollection) throws RemoteApiException;
  
  byte[] getFileContent(String paramString, boolean paramBoolean) throws RemoteApiException;
  
  byte[] getFileContent(String paramString) throws RemoteApiException;
  
  boolean checkContentUrlAvailable();
  
  void addItemsToReview(PermId paramPermId, Collection<UploadItem> paramCollection) throws RemoteApiException;
  
  void markCommentRead(PermId paramPermId1, PermId paramPermId2) throws RemoteApiException;
  
  void markCommentLeaveRead(PermId paramPermId1, PermId paramPermId2) throws RemoteApiException;
  
  void markAllCommentsRead(PermId paramPermId) throws RemoteApiException;
  
  @NotNull
  Changes getChanges(@NotNull String paramString1, @Nullable String paramString2, boolean paramBoolean1, @Nullable String paramString3, boolean paramBoolean2, @Nullable Integer paramInteger) throws RemoteApiException;
  
  List<BasicReview> getReviewsForIssue(@NotNull String paramString, @NotNull int paramInt) throws RemoteApiException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\CrucibleSession.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */