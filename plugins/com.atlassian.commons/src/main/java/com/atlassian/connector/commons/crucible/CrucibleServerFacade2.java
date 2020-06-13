package com.atlassian.connector.commons.crucible;

import com.atlassian.connector.commons.api.ConnectionCfg;
import com.atlassian.theplugin.commons.crucible.api.CrucibleSession;
import com.atlassian.theplugin.commons.crucible.api.PathAndRevision;
import com.atlassian.theplugin.commons.crucible.api.UploadItem;
import com.atlassian.theplugin.commons.crucible.api.model.BasicProject;
import com.atlassian.theplugin.commons.crucible.api.model.BasicReview;
import com.atlassian.theplugin.commons.crucible.api.model.Comment;
import com.atlassian.theplugin.commons.crucible.api.model.CrucibleFileInfo;
import com.atlassian.theplugin.commons.crucible.api.model.CrucibleVersionInfo;
import com.atlassian.theplugin.commons.crucible.api.model.CustomFieldDef;
import com.atlassian.theplugin.commons.crucible.api.model.CustomFilter;
import com.atlassian.theplugin.commons.crucible.api.model.NewReviewItem;
import com.atlassian.theplugin.commons.crucible.api.model.PermId;
import com.atlassian.theplugin.commons.crucible.api.model.PredefinedFilter;
import com.atlassian.theplugin.commons.crucible.api.model.Repository;
import com.atlassian.theplugin.commons.crucible.api.model.Review;
import com.atlassian.theplugin.commons.crucible.api.model.Reviewer;
import com.atlassian.theplugin.commons.crucible.api.model.User;
import com.atlassian.theplugin.commons.crucible.api.model.VersionedComment;
import com.atlassian.theplugin.commons.exception.ServerPasswordNotProvidedException;
import com.atlassian.theplugin.commons.remoteapi.ProductServerFacade;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CrucibleServerFacade2 extends ProductServerFacade {
  CrucibleSession getSession(ConnectionCfg paramConnectionCfg) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Review createReview(ConnectionCfg paramConnectionCfg, Review paramReview) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Review createReviewFromRevision(ConnectionCfg paramConnectionCfg, Review paramReview, List<String> paramList) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Review addRevisionsToReview(ConnectionCfg paramConnectionCfg, PermId paramPermId, String paramString, Collection<String> paramCollection) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Review addFileRevisionsToReview(ConnectionCfg paramConnectionCfg, PermId paramPermId, String paramString, List<PathAndRevision> paramList) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void addFileToReview(ConnectionCfg paramConnectionCfg, PermId paramPermId, NewReviewItem paramNewReviewItem) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Review addPatchToReview(ConnectionCfg paramConnectionCfg, PermId paramPermId, String paramString1, String paramString2) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  List<Reviewer> getReviewers(ConnectionCfg paramConnectionCfg, PermId paramPermId) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void addReviewers(ConnectionCfg paramConnectionCfg, PermId paramPermId, Set<String> paramSet) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void removeReviewer(ConnectionCfg paramConnectionCfg, PermId paramPermId, String paramString) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void setReviewers(@NotNull ConnectionCfg paramConnectionCfg, @NotNull PermId paramPermId, @NotNull Collection<String> paramCollection) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Review closeReview(ConnectionCfg paramConnectionCfg, PermId paramPermId, String paramString) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void completeReview(ConnectionCfg paramConnectionCfg, PermId paramPermId, boolean paramBoolean) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  List<BasicReview> getReviewsForFilter(ConnectionCfg paramConnectionCfg, PredefinedFilter paramPredefinedFilter) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  List<BasicReview> getReviewsForCustomFilter(ConnectionCfg paramConnectionCfg, CustomFilter paramCustomFilter) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Review getReview(ConnectionCfg paramConnectionCfg, PermId paramPermId) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Review createReviewFromPatch(ConnectionCfg paramConnectionCfg, Review paramReview, String paramString) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Set<CrucibleFileInfo> getFiles(ConnectionCfg paramConnectionCfg, PermId paramPermId) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  List<VersionedComment> getVersionedComments(ConnectionCfg paramConnectionCfg, Review paramReview, CrucibleFileInfo paramCrucibleFileInfo) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Comment addGeneralComment(ConnectionCfg paramConnectionCfg, Review paramReview, Comment paramComment) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  VersionedComment addVersionedComment(ConnectionCfg paramConnectionCfg, Review paramReview, PermId paramPermId, VersionedComment paramVersionedComment) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void updateComment(ConnectionCfg paramConnectionCfg, PermId paramPermId, Comment paramComment) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void publishComment(ConnectionCfg paramConnectionCfg, PermId paramPermId1, PermId paramPermId2) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void publishAllCommentsForReview(ConnectionCfg paramConnectionCfg, PermId paramPermId) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Comment addReply(ConnectionCfg paramConnectionCfg, Comment paramComment) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void removeComment(ConnectionCfg paramConnectionCfg, PermId paramPermId, Comment paramComment) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  List<User> getUsers(ConnectionCfg paramConnectionCfg) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  List<BasicProject> getProjects(ConnectionCfg paramConnectionCfg) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  List<Repository> getRepositories(ConnectionCfg paramConnectionCfg) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Repository getRepository(ConnectionCfg paramConnectionCfg, String paramString) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  List<CustomFieldDef> getMetrics(ConnectionCfg paramConnectionCfg, int paramInt) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  @Nullable
  String getDisplayName(@NotNull ConnectionCfg paramConnectionCfg, @NotNull String paramString);
  
  @Deprecated
  boolean checkContentUrlAvailable(ConnectionCfg paramConnectionCfg) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Review createReviewFromUpload(ConnectionCfg paramConnectionCfg, Review paramReview, Collection<UploadItem> paramCollection) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  Review addItemsToReview(ConnectionCfg paramConnectionCfg, PermId paramPermId, Collection<UploadItem> paramCollection) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void markCommentRead(@NotNull ConnectionCfg paramConnectionCfg, PermId paramPermId1, PermId paramPermId2) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void markCommentLeaveUnread(@NotNull ConnectionCfg paramConnectionCfg, PermId paramPermId1, PermId paramPermId2) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  void markAllCommentsRead(@NotNull ConnectionCfg paramConnectionCfg, PermId paramPermId) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  @Deprecated
  CrucibleVersionInfo getServerVersion(ConnectionCfg paramConnectionCfg) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  List<BasicReview> getAllReviewsForFile(ConnectionCfg paramConnectionCfg, String paramString1, String paramString2) throws RemoteApiException, ServerPasswordNotProvidedException;
  
  List<BasicReview> getReviewsForIssue(ConnectionCfg paramConnectionCfg, String paramString, int paramInt) throws RemoteApiException, ServerPasswordNotProvidedException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\crucible\CrucibleServerFacade2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */