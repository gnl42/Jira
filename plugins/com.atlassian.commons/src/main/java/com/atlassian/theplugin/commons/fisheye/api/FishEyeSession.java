package com.atlassian.theplugin.commons.fisheye.api;

import com.atlassian.theplugin.commons.fisheye.api.model.FisheyePathHistoryItem;
import com.atlassian.theplugin.commons.fisheye.api.model.changeset.Changeset;
import com.atlassian.theplugin.commons.fisheye.api.model.changeset.ChangesetIdList;
import com.atlassian.theplugin.commons.remoteapi.ProductSession;
import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
import java.util.Collection;
import java.util.Date;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface FishEyeSession extends ProductSession {
  Collection<String> getRepositories() throws RemoteApiException;
  
  Collection<FisheyePathHistoryItem> getPathHistory(String paramString1, String paramString2) throws RemoteApiException;
  
  @NotNull
  ChangesetIdList getChangesetList(@NotNull String paramString1, @Nullable String paramString2, @Nullable Date paramDate1, @Nullable Date paramDate2, @Nullable Integer paramInteger) throws RemoteApiException;
  
  @NotNull
  Changeset getChangeset(@NotNull String paramString1, @NotNull String paramString2) throws RemoteApiException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\fisheye\api\FishEyeSession.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */