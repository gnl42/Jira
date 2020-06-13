/*      */ package com.atlassian.theplugin.commons.crucible.api.rest;
/*      */ 
/*      */ import com.atlassian.connector.commons.misc.IntRanges;
/*      */ import com.atlassian.connector.commons.misc.IntRangesParser;
/*      */ import com.atlassian.theplugin.commons.VersionedVirtualFile;
/*      */ import com.atlassian.theplugin.commons.crucible.CrucibleVersion;
/*      */ import com.atlassian.theplugin.commons.crucible.api.PathAndRevision;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.BasicProject;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.BasicReview;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.Comment;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CommitType;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CrucibleAction;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CrucibleFileInfo;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CrucibleVersionInfo;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CustomField;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CustomFieldBean;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CustomFieldDefBean;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CustomFieldValue;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CustomFieldValueType;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.CustomFilter;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.ExtendedCrucibleProject;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.FileType;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.GeneralComment;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.NewReviewItem;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.PatchAnchorData;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.PermId;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.Repository;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.RepositoryType;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.Review;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.ReviewType;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.Reviewer;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.RevisionData;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.State;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.SvnRepository;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.User;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.VersionedComment;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.changes.Change;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.changes.Changes;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.changes.Link;
/*      */ import com.atlassian.theplugin.commons.crucible.api.model.changes.Revision;
/*      */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*      */ import com.atlassian.theplugin.commons.util.LoggerImpl;
/*      */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*      */ import com.atlassian.theplugin.commons.util.XmlUtil;
/*      */ import java.text.ParseException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.lang.StringUtils;
/*      */ import org.jdom.CDATA;
/*      */ import org.jdom.Content;
/*      */ import org.jdom.Document;
/*      */ import org.jdom.Element;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ import org.joda.time.DateTime;
/*      */ import org.joda.time.format.DateTimeFormat;
/*      */ import org.joda.time.format.DateTimeFormatter;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class CrucibleRestXmlHelper
/*      */ {
/*      */   private static final String CDATA_END = "]]>";
/*      */   private static final String PRESERVE_OLD = "{preserve-old}";
/*      */   
/*      */   @NotNull
/*      */   public static String getChildText(Element node, String childName) {
/*   97 */     Element child = node.getChild(childName);
/*   98 */     if (child != null) {
/*   99 */       return child.getText();
/*      */     }
/*  101 */     return "";
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public static String getChildTextOrNull(Element node, String childName) {
/*  106 */     Element child = node.getChild(childName);
/*  107 */     if (child != null) {
/*  108 */       return child.getText();
/*      */     }
/*  110 */     return null;
/*      */   }
/*      */   
/*      */   public static BasicProject parseBasicProjectNode(Element projectNode) {
/*  114 */     String defaultDuration = getChildText(projectNode, "defaultDuration");
/*  115 */     return new BasicProject(
/*  116 */         getChildText(projectNode, "id"), 
/*  117 */         getChildText(projectNode, "key"), 
/*  118 */         getChildText(projectNode, "name"), 
/*  119 */         parseUserNames(projectNode.getChild("defaultReviewers")), 
/*  120 */         getChildText(projectNode, "defaultRepositoryName"), 
/*  121 */         Boolean.parseBoolean(getChildText(projectNode, "allowReviewersToJoin")), 
/*  122 */         !StringUtils.isEmpty(defaultDuration) ? Integer.valueOf(Integer.parseInt(defaultDuration)) : null, 
/*  123 */         Boolean.parseBoolean(getChildText(projectNode, "moderatorEnabled")));
/*      */   }
/*      */   
/*      */   public static ExtendedCrucibleProject parseProjectNode(Element projectNode) {
/*  127 */     String defaultDuration = getChildText(projectNode, "defaultDuration");
/*  128 */     return new ExtendedCrucibleProject(
/*  129 */         getChildText(projectNode, "id"), 
/*  130 */         getChildText(projectNode, "key"), 
/*  131 */         getChildText(projectNode, "name"), 
/*  132 */         parseUserNames(projectNode.getChild("allowedReviewers")), 
/*  133 */         parseUserNames(projectNode.getChild("defaultReviewers")), 
/*  134 */         getChildText(projectNode, "defaultRepositoryName"), 
/*  135 */         Boolean.parseBoolean(getChildText(projectNode, "allowReviewersToJoin")), 
/*  136 */         !StringUtils.isEmpty(defaultDuration) ? Integer.valueOf(Integer.parseInt(defaultDuration)) : null, 
/*  137 */         Boolean.parseBoolean(getChildText(projectNode, "moderatorEnabled")));
/*      */   }
/*      */   
/*      */   public static Repository parseRepositoryNode(Element repoNode) {
/*  141 */     return new Repository(
/*  142 */         getChildText(repoNode, "name"), 
/*  143 */         getChildText(repoNode, "type"), 
/*  144 */         Boolean.parseBoolean(getChildText(repoNode, "enabled")));
/*      */   }
/*      */   
/*      */   public static SvnRepository parseSvnRepositoryNode(Element repoNode) {
/*  148 */     return new SvnRepository(
/*  149 */         getChildText(repoNode, "name"), 
/*  150 */         getChildText(repoNode, "type"), 
/*  151 */         Boolean.parseBoolean(getChildText(repoNode, "enabled")), 
/*  152 */         getChildText(repoNode, "url"), 
/*  153 */         getChildText(repoNode, "path"));
/*      */   }
/*      */   
/*      */   public static User parseUserNode(Element repoNode) {
/*  157 */     CrucibleVersion version = CrucibleVersion.CRUCIBLE_15;
/*  158 */     Element userName = repoNode.getChild("userName");
/*  159 */     if (userName != null && !"".equals(userName.getText())) {
/*  160 */       version = CrucibleVersion.CRUCIBLE_16;
/*      */     }
/*  162 */     if (version == CrucibleVersion.CRUCIBLE_15) {
/*  163 */       return new User(repoNode.getText(), repoNode.getText());
/*      */     }
/*  165 */     return new User(getChildText(repoNode, "userName"), 
/*  166 */         getChildText(repoNode, "displayName"), getChildText(repoNode, "avatarUrl"));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public static CrucibleAction parseActionNode(Element element) throws ParseException {
/*  177 */     String name = element.getChildText("name");
/*  178 */     if (name == null) {
/*  179 */       throw new ParseException("Cannot parse action node - missing [name] element", 0);
/*      */     }
/*      */     try {
/*  182 */       return CrucibleAction.fromValue(name);
/*  183 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  184 */       String displayName = element.getChildText("displayName");
/*  185 */       if (displayName != null) {
/*  186 */         return new CrucibleAction(displayName, name);
/*      */       }
/*  188 */       throw new ParseException("Cannot parse action node " + XmlUtil.toPrettyFormatedString(element), 0);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static Reviewer parseReviewerNode(Element reviewerNode) {
/*  193 */     CrucibleVersion version = CrucibleVersion.CRUCIBLE_15;
/*  194 */     Element userName = reviewerNode.getChild("userName");
/*  195 */     if (userName != null && !userName.getText().equals("")) {
/*  196 */       version = CrucibleVersion.CRUCIBLE_16;
/*      */     }
/*  198 */     if (version == CrucibleVersion.CRUCIBLE_15) {
/*  199 */       return new Reviewer(reviewerNode.getText(), 
/*  200 */           reviewerNode.getText());
/*      */     }
/*  202 */     return new Reviewer(
/*  203 */         getChildText(reviewerNode, "userName"), 
/*  204 */         getChildText(reviewerNode, "displayName"), 
/*  205 */         Boolean.parseBoolean(getChildText(reviewerNode, "completed")), 
/*  206 */         getChildText(reviewerNode, "avatarUrl"));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   private static Collection<String> parseUserNames(Element userNamesNode) {
/*  213 */     if (userNamesNode != null) {
/*  214 */       Collection<String> userNamesList = new ArrayList<String>();
/*  215 */       for (Element userName : XmlUtil.getChildElements(userNamesNode, "userName")) {
/*  216 */         userNamesList.add(userName.getText());
/*      */       }
/*      */       
/*  219 */       return userNamesList;
/*      */     } 
/*  221 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public static BasicReview parseBasicReview(String serverUrl, Element reviewNode, boolean trimWikiMarkers) throws ParseException {
/*  226 */     String projectKey = getChildText(reviewNode, "projectKey");
/*  227 */     User author = parseUserNode(reviewNode.getChild("author"));
/*  228 */     User creator = parseUserNode(reviewNode.getChild("creator"));
/*  229 */     ReviewType reviewType = parseReviewType(reviewNode.getChildText("type"));
/*      */     
/*  231 */     User moderator = (reviewNode.getChild("moderator") != null) ? 
/*  232 */       parseUserNode(reviewNode.getChild("moderator")) : null;
/*      */     
/*  234 */     BasicReview review = new BasicReview(reviewType, serverUrl, projectKey, author, moderator);
/*  235 */     review.setCreator(creator);
/*  236 */     fillAlwaysPresentReviewData(review, reviewNode, serverUrl, trimWikiMarkers);
/*  237 */     fillMoreDetailedReviewData(review, reviewNode, trimWikiMarkers);
/*      */ 
/*      */ 
/*      */     
/*  241 */     return review;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Review parseFullReview(String serverUrl, String myUsername, Element reviewNode, boolean trimWikiMarkers) throws ParseException {
/*  246 */     String projectKey = getChildText(reviewNode, "projectKey");
/*  247 */     User author = parseUserNode(reviewNode.getChild("author"));
/*      */     
/*  249 */     User moderator = (reviewNode.getChild("moderator") != null) ? 
/*  250 */       parseUserNode(reviewNode.getChild("moderator")) : null;
/*      */     
/*  252 */     User creator = (reviewNode.getChild("creator") != null) ? 
/*  253 */       parseUserNode(reviewNode.getChild("creator")) : null;
/*  254 */     ReviewType reviewType = parseReviewType(reviewNode.getChildText("type"));
/*      */     
/*  256 */     Review review = new Review(reviewType, serverUrl, projectKey, author, moderator);
/*  257 */     review.setCreator(creator);
/*  258 */     fillAlwaysPresentReviewData((BasicReview)review, reviewNode, serverUrl, trimWikiMarkers);
/*  259 */     fillMoreDetailedReviewData((BasicReview)review, reviewNode, trimWikiMarkers);
/*      */ 
/*      */     
/*  262 */     List<Element> generalCommentsNode = XmlUtil.getChildElements(reviewNode, "generalComments");
/*  263 */     for (Element generalComment : generalCommentsNode) {
/*  264 */       List<Element> generalCommentsDataNode = XmlUtil.getChildElements(generalComment, "generalCommentData");
/*  265 */       List<Comment> generalComments = new ArrayList<Comment>();
/*      */       
/*  267 */       for (Element generalCommentData : generalCommentsDataNode) {
/*  268 */         GeneralComment generalComment1 = parseGeneralCommentNode(review, null, myUsername, generalCommentData, trimWikiMarkers);
/*  269 */         if (generalComment1 != null) {
/*  270 */           generalComments.add(generalComment1);
/*      */         }
/*      */       } 
/*  273 */       review.setGeneralComments(generalComments);
/*      */     } 
/*      */ 
/*      */     
/*  277 */     List<Element> fileNode = XmlUtil.getChildElements(reviewNode, "reviewItems");
/*  278 */     LinkedHashMap<PermId, CrucibleFileInfo> files = new LinkedHashMap<PermId, CrucibleFileInfo>();
/*  279 */     if (fileNode.size() > 0) {
/*  280 */       for (Element element : fileNode) {
/*  281 */         List<Element> fileElements = XmlUtil.getChildElements(element, "reviewItem");
/*  282 */         for (Element file : fileElements) {
/*  283 */           CrucibleFileInfo fileInfo = parseReviewItemNode(file);
/*  284 */           files.put(fileInfo.getPermId(), fileInfo);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  290 */     List<Element> versionedComments = XmlUtil.getChildElements(reviewNode, "versionedComments");
/*  291 */     List<VersionedComment> comments = new ArrayList<VersionedComment>();
/*  292 */     for (Element element : versionedComments) {
/*  293 */       List<Element> versionedCommentsData = XmlUtil.getChildElements(element, "versionedLineCommentData");
/*  294 */       for (Element versionedElementData : versionedCommentsData) {
/*      */         
/*  296 */         VersionedComment c = parseVersionedCommentNode(review, files, myUsername, versionedElementData, 
/*  297 */             trimWikiMarkers);
/*  298 */         if (c != null) {
/*  299 */           comments.add(c);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  304 */     review.setFilesAndVersionedComments(files.values(), comments);
/*  305 */     return review;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void fillAlwaysPresentReviewData(BasicReview review, Element reviewNode, String serverUrl, boolean trimWikiMarkers) throws ParseException {
/*  310 */     review.setCreateDate(parseDateTime(getChildText(reviewNode, "createDate")));
/*  311 */     review.setCloseDate(parseDateTime(getChildText(reviewNode, "closeDate")));
/*  312 */     String soo = getChildText(reviewNode, "description");
/*  313 */     if (trimWikiMarkers) {
/*  314 */       soo = removeWikiMarkers(soo);
/*      */     }
/*  316 */     review.setDescription(soo);
/*  317 */     review.setName(getChildText(reviewNode, "name"));
/*  318 */     review.setRepoName(getChildText(reviewNode, "repoName"));
/*      */     
/*  320 */     String stateString = getChildText(reviewNode, "state");
/*  321 */     if (!"".equals(stateString)) {
/*  322 */       review.setState(State.fromValue(stateString));
/*      */     }
/*  324 */     review.setAllowReviewerToJoin(Boolean.parseBoolean(getChildText(reviewNode, "allowReviewersToJoin")));
/*      */     
/*  326 */     String dueDateStr = getChildTextOrNull(reviewNode, "dueDate");
/*  327 */     if (dueDateStr != null) {
/*  328 */       review.setDueDate(parseJodaDateTime(dueDateStr));
/*      */     }
/*      */     
/*  331 */     if (reviewNode.getChild("permaId") != null) {
/*  332 */       PermId permId = new PermId(reviewNode.getChild("permaId").getChild("id").getText());
/*  333 */       review.setPermId(permId);
/*      */     } 
/*  335 */     review.setSummary(getChildText(reviewNode, "summary"));
/*      */     
/*      */     try {
/*  338 */       review.setMetricsVersion(Integer.valueOf(getChildText(reviewNode, "metricsVersion")).intValue());
/*  339 */     } catch (NumberFormatException numberFormatException) {
/*  340 */       review.setMetricsVersion(-1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static List<CrucibleAction> parseActions(List<Element> elements) {
/*  345 */     List<CrucibleAction> res = new ArrayList<CrucibleAction>();
/*      */     
/*  347 */     if (elements != null && !elements.isEmpty()) {
/*  348 */       for (Element element : elements) {
/*      */         try {
/*  350 */           res.add(parseActionNode(element));
/*  351 */         } catch (ParseException e) {
/*  352 */           LoggerImpl.getInstance().warn(e);
/*      */         } 
/*      */       } 
/*      */     }
/*  356 */     return res;
/*      */   }
/*      */   
/*      */   private static void fillMoreDetailedReviewData(BasicReview review, Element reviewNode, boolean trimWikiMarkers) {
/*  360 */     List<Element> reviewersNode = XmlUtil.getChildElements(reviewNode, "reviewers");
/*  361 */     Set<Reviewer> reviewers = new HashSet<Reviewer>();
/*  362 */     for (Element reviewer : reviewersNode) {
/*  363 */       List<Element> reviewerNode = XmlUtil.getChildElements(reviewer, "reviewer");
/*  364 */       for (Element element : reviewerNode) {
/*  365 */         reviewers.add(parseReviewerNode(element));
/*      */       }
/*      */     } 
/*  368 */     review.setReviewers(reviewers);
/*      */     
/*  370 */     List<CrucibleAction> transitions = new ArrayList<CrucibleAction>();
/*  371 */     Element transitionsNode = reviewNode.getChild("transitions");
/*  372 */     if (transitionsNode != null) {
/*  373 */       List<Element> transDataNodes = XmlUtil.getChildElements(transitionsNode, "transitionData");
/*  374 */       transitions.addAll(parseActions(transDataNodes));
/*      */     } 
/*      */     
/*  377 */     review.setTransitions(transitions);
/*      */     
/*  379 */     Set<CrucibleAction> actions = new HashSet<CrucibleAction>();
/*  380 */     Element actionsNode = reviewNode.getChild("actions");
/*  381 */     if (actionsNode != null) {
/*  382 */       List<Element> actionDataNodes = XmlUtil.getChildElements(actionsNode, "actionData");
/*  383 */       actions.addAll(parseActions(actionDataNodes));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  392 */     review.setActions(actions);
/*      */   }
/*      */   
/*      */   public static Element addTag(Element root, String tagName, String tagValue) {
/*  396 */     Element newElement = new Element(tagName);
/*  397 */     newElement.addContent(tagValue);
/*  398 */     getContent(root).add(newElement);
/*  399 */     return newElement;
/*      */   }
/*      */   
/*      */   private static String escapeForCdata(String source) {
/*  403 */     if (source == null) {
/*  404 */       return null;
/*      */     }
/*      */     
/*  407 */     StringBuffer sb = new StringBuffer();
/*      */ 
/*      */     
/*  410 */     int oldIndex = 0; int index;
/*  411 */     while ((index = source.indexOf("]]>", oldIndex)) > -1) {
/*  412 */       sb.append(source.substring(oldIndex, index));
/*  413 */       oldIndex = index + "]]>".length();
/*  414 */       sb.append("&#x5D;&#x5D;>");
/*      */     } 
/*      */     
/*  417 */     sb.append(source.substring(oldIndex));
/*  418 */     return sb.toString();
/*      */   }
/*      */   
/*      */   public static Document prepareCreateReviewNode(Review review, String patch) {
/*  422 */     Element root = new Element("createReview");
/*  423 */     Document doc = new Document(root);
/*      */     
/*  425 */     getContent(root).add(prepareReviewNodeElement((BasicReview)review, true));
/*      */     
/*  427 */     if (patch != null) {
/*  428 */       Element patchData = new Element("patch");
/*  429 */       getContent(root).add(patchData);
/*      */       
/*  431 */       CDATA patchT = new CDATA(escapeForCdata(patch));
/*  432 */       patchData.setContent((Content)patchT);
/*      */     } 
/*  434 */     return doc;
/*      */   }
/*      */   
/*      */   public static Document prepareCreateSnippetReviewNode(Review review, String snippet, String filename) {
/*  438 */     Element root = new Element("createReview");
/*  439 */     Document doc = new Document(root);
/*      */     
/*  441 */     getContent(root).add(prepareSnippetReviewNodeElement((BasicReview)review));
/*      */     
/*  443 */     Element patchData = new Element("snippet");
/*  444 */     getContent(root).add(patchData);
/*      */     
/*  446 */     CDATA patchT = new CDATA(escapeForCdata(snippet));
/*  447 */     patchData.setContent((Content)patchT);
/*      */     
/*  449 */     Element filenameT = new Element("filename");
/*  450 */     getContent(root).add(filenameT);
/*  451 */     filenameT.setText(filename);
/*  452 */     return doc;
/*      */   }
/*      */   
/*      */   public static Document prepareCloseReviewSummaryNode(String message) {
/*  456 */     Element root = new Element("closeReviewSummary");
/*  457 */     Document doc = new Document(root);
/*      */     
/*  459 */     if (message != null) {
/*  460 */       Element messageData = new Element("summary");
/*  461 */       getContent(root).add(messageData);
/*      */       
/*  463 */       CDATA patchT = new CDATA(escapeForCdata(message));
/*  464 */       messageData.setContent((Content)patchT);
/*      */     } 
/*  466 */     return doc;
/*      */   }
/*      */   
/*      */   public static Document prepareCreateReviewNode(Review review, List<String> revisions) {
/*  470 */     Element root = new Element("createReview");
/*  471 */     Document doc = new Document(root);
/*      */     
/*  473 */     getContent(root).add(prepareReviewNodeElement((BasicReview)review, false));
/*      */     
/*  475 */     if (!revisions.isEmpty()) {
/*  476 */       Element changes = new Element("changesets");
/*  477 */       addTag(changes, "repository", review.getRepoName());
/*  478 */       getContent(root).add(changes);
/*  479 */       for (String revision : revisions) {
/*  480 */         Element rev = new Element("changesetData");
/*  481 */         getContent(changes).add(rev);
/*  482 */         addTag(rev, "id", revision);
/*      */       } 
/*      */     } 
/*  485 */     return doc;
/*      */   }
/*      */   
/*      */   public static Element prepareRevisionData(RevisionData revData) {
/*  489 */     Element root = new Element("revisionData");
/*  490 */     Element source = new Element("source");
/*  491 */     source.addContent(revData.getSource());
/*  492 */     getContent(root).add(source);
/*      */     
/*  494 */     Element path = new Element("path");
/*  495 */     path.addContent(revData.getPath());
/*  496 */     getContent(root).add(path);
/*      */     
/*  498 */     for (String revision : revData.getRevisions()) {
/*  499 */       Element rev = new Element("rev");
/*  500 */       rev.addContent(revision);
/*  501 */       getContent(root).add(rev);
/*      */     } 
/*  503 */     return root;
/*      */   }
/*      */   
/*      */   public static Document prepareRevisions(Collection<RevisionData> revisions) {
/*  507 */     Element root = new Element("revisions");
/*  508 */     Document doc = new Document(root);
/*      */     
/*  510 */     if (!revisions.isEmpty()) {
/*  511 */       for (RevisionData revData : revisions) {
/*  512 */         getContent(root).add(prepareRevisionData(revData));
/*      */       }
/*      */     }
/*  515 */     return doc;
/*      */   }
/*      */   
/*      */   public static Document prepareRevisionDataNode(String repository, List<PathAndRevision> files) {
/*  519 */     Element root = new Element("revisions");
/*  520 */     Document doc = new Document(root);
/*      */     
/*  522 */     for (PathAndRevision file : files) {
/*  523 */       Element revData = new Element("revisionData");
/*  524 */       for (String revision : file.getRevisions()) {
/*  525 */         addTag(revData, "rev", revision);
/*      */       }
/*  527 */       addTag(revData, "source", repository);
/*  528 */       addTag(revData, "path", file.getPath());
/*  529 */       getContent(root).add(revData);
/*      */     } 
/*  531 */     addTag(root, "repository", repository);
/*      */     
/*  533 */     return doc;
/*      */   }
/*      */   
/*      */   public static Document prepareAddChangesetNode(String repoName, Collection<String> revisions) {
/*  537 */     Element root = new Element("addChangeset");
/*  538 */     Document doc = new Document(root);
/*      */     
/*  540 */     addTag(root, "repository", repoName);
/*      */     
/*  542 */     if (!revisions.isEmpty()) {
/*  543 */       Element changes = new Element("changesets");
/*  544 */       getContent(root).add(changes);
/*  545 */       for (String revision : revisions) {
/*  546 */         Element rev = new Element("changesetData");
/*  547 */         getContent(changes).add(rev);
/*  548 */         addTag(rev, "id", revision);
/*      */       } 
/*      */     } 
/*  551 */     return doc;
/*      */   }
/*      */   
/*      */   public static Document prepareAddPatchNode(String repoName, String patch) {
/*  555 */     Element root = new Element("addPatch");
/*  556 */     Document doc = new Document(root);
/*      */     
/*  558 */     addTag(root, "repository", repoName);
/*      */     
/*  560 */     if (patch != null) {
/*  561 */       Element patchData = new Element("patch");
/*  562 */       getContent(root).add(patchData);
/*  563 */       CDATA patchT = new CDATA(escapeForCdata(patch));
/*  564 */       patchData.setContent((Content)patchT);
/*      */     } 
/*  566 */     return doc;
/*      */   }
/*      */   
/*      */   public static Document prepareAddItemNode(NewReviewItem item) {
/*  570 */     Element root = new Element("reviewItem");
/*  571 */     Document doc = new Document(root);
/*      */     
/*  573 */     addTag(root, "repositoryName", item.getRepositoryName());
/*  574 */     addTag(root, "fromPath", item.getFromPath());
/*  575 */     addTag(root, "fromRevision", item.getFromRevision());
/*  576 */     addTag(root, "toPath", item.getToPath());
/*  577 */     addTag(root, "toRevision", item.getToRevision());
/*      */     
/*  579 */     return doc;
/*      */   }
/*      */   
/*      */   public static Document prepareReviewNode(BasicReview review) {
/*  583 */     Element reviewData = prepareReviewNodeElement(review, false);
/*  584 */     return new Document(reviewData);
/*      */   }
/*      */   
/*      */   private static Element prepareReviewNodeElement(BasicReview review, boolean addType) {
/*  588 */     Element reviewData = new Element("reviewData");
/*      */     
/*  590 */     Element authorElement = new Element("author");
/*  591 */     getContent(reviewData).add(authorElement);
/*  592 */     addTag(authorElement, "userName", review.getAuthor().getUsername());
/*      */     
/*  594 */     Element creatorElement = new Element("creator");
/*  595 */     getContent(reviewData).add(creatorElement);
/*  596 */     addTag(creatorElement, "userName", review.getCreator().getUsername());
/*      */     
/*  598 */     Element moderatorElement = new Element("moderator");
/*  599 */     getContent(reviewData).add(moderatorElement);
/*  600 */     addTag(moderatorElement, "userName", review.getModerator().getUsername());
/*      */     
/*  602 */     addTag(reviewData, "description", review.getDescription());
/*  603 */     addTag(reviewData, "name", review.getName());
/*  604 */     addTag(reviewData, "projectKey", review.getProjectKey());
/*      */     
/*  606 */     if (review.getState() != null) {
/*  607 */       addTag(reviewData, "state", review.getState().value());
/*      */     }
/*  609 */     addTag(reviewData, "allowReviewersToJoin", Boolean.toString(review.isAllowReviewerToJoin()));
/*  610 */     if (review.getPermId() != null) {
/*  611 */       Element permIdElement = new Element("permaId");
/*  612 */       getContent(reviewData).add(permIdElement);
/*  613 */       addTag(permIdElement, "id", review.getPermId().getId());
/*      */     } 
/*      */     
/*  616 */     if (addType) {
/*  617 */       addTag(reviewData, "type", "REVIEW");
/*      */     }
/*      */     
/*  620 */     return reviewData;
/*      */   }
/*      */   
/*      */   private static Element prepareSnippetReviewNodeElement(BasicReview review) {
/*  624 */     Element reviewData = new Element("reviewData");
/*      */     
/*  626 */     Element authorElement = new Element("creator");
/*  627 */     getContent(reviewData).add(authorElement);
/*  628 */     addTag(authorElement, "userName", review.getAuthor().getUsername());
/*      */     
/*  630 */     addTag(reviewData, "description", review.getDescription());
/*  631 */     addTag(reviewData, "name", review.getName());
/*  632 */     addTag(reviewData, "projectKey", review.getProjectKey());
/*  633 */     if (review.getState() != null) {
/*  634 */       addTag(reviewData, "state", review.getState().value());
/*      */     }
/*  636 */     if (review.getPermId() != null) {
/*  637 */       Element permIdElement = new Element("permaId");
/*  638 */       getContent(reviewData).add(permIdElement);
/*  639 */       addTag(permIdElement, "id", review.getPermId().getId());
/*      */     } 
/*      */     
/*  642 */     return reviewData;
/*      */   }
/*      */   
/*      */   private static PermId parsePermId(Element permIdNode) throws ParseException {
/*  646 */     if (permIdNode != null) {
/*  647 */       Element childId = permIdNode.getChild("id");
/*  648 */       if (childId != null && childId.getText() != null && childId.getText().length() > 0)
/*  649 */         return new PermId(childId.getText()); 
/*  650 */       if (permIdNode.getText() != null && permIdNode.getText().length() > 0) {
/*  651 */         return new PermId(permIdNode.getText());
/*      */       }
/*      */     } 
/*  654 */     throw new ParseException("PermId not defined", 0);
/*      */   }
/*      */   
/*      */   public static CrucibleFileInfo parseReviewItemNode(Element reviewItemNode) throws ParseException {
/*  658 */     CrucibleFileInfo reviewItem = new CrucibleFileInfo(
/*  659 */         new VersionedVirtualFile(
/*  660 */           getChildText(reviewItemNode, "toPath"), 
/*  661 */           getChildText(reviewItemNode, "toRevision")), 
/*      */         
/*  663 */         new VersionedVirtualFile(
/*  664 */           getChildText(reviewItemNode, "fromPath"), 
/*  665 */           getChildText(reviewItemNode, "fromRevision")), 
/*      */         
/*  667 */         parsePermId(reviewItemNode.getChild("permId")));
/*      */ 
/*      */     
/*  670 */     String fromContentUrl = getChildText(reviewItemNode, "fromContentUrl");
/*  671 */     if (!"".equals(fromContentUrl)) {
/*  672 */       reviewItem.getOldFileDescriptor().setContentUrl(fromContentUrl);
/*      */     }
/*  674 */     String toContentUrl = getChildText(reviewItemNode, "toContentUrl");
/*  675 */     if (!"".equals(toContentUrl)) {
/*  676 */       reviewItem.getFileDescriptor().setContentUrl(toContentUrl);
/*      */     }
/*      */     
/*  679 */     String c = getChildText(reviewItemNode, "commitType");
/*  680 */     if (!"".equals(c)) {
/*  681 */       reviewItem.setCommitType(CommitType.valueOf(c));
/*      */       
/*  683 */       if (reviewItem.getCommitType() == CommitType.Added && 
/*  684 */         !"".equals(reviewItem.getOldFileDescriptor().getRevision()) && 
/*  685 */         !"".equals(reviewItem.getFileDescriptor().getRevision())) {
/*  686 */         reviewItem.setCommitType(CommitType.Moved);
/*      */       
/*      */       }
/*      */     }
/*  690 */     else if (!"".equals(reviewItem.getOldFileDescriptor().getRevision()) && 
/*  691 */       !"".equals(reviewItem.getFileDescriptor().getRevision())) {
/*  692 */       reviewItem.setCommitType(CommitType.Modified);
/*      */     }
/*  694 */     else if ("".equals(reviewItem.getOldFileDescriptor().getRevision()) && 
/*  695 */       !"".equals(reviewItem.getFileDescriptor().getRevision())) {
/*  696 */       reviewItem.setCommitType(CommitType.Added);
/*      */     }
/*  698 */     else if ("".equals(reviewItem.getOldFileDescriptor().getRevision()) && 
/*  699 */       !"".equals(reviewItem.getFileDescriptor().getRevision())) {
/*  700 */       reviewItem.setCommitType(CommitType.Deleted);
/*      */     } else {
/*  702 */       reviewItem.setCommitType(CommitType.Unknown);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  707 */     reviewItem.setRepositoryName(getChildText(reviewItemNode, "repositoryName"));
/*  708 */     if (reviewItem.getRepositoryName().startsWith(RepositoryType.UPLOAD.name())) {
/*  709 */       reviewItem.setRepositoryType(RepositoryType.UPLOAD);
/*      */     }
/*  711 */     else if (reviewItem.getRepositoryName().startsWith(RepositoryType.PATCH.name())) {
/*  712 */       reviewItem.setRepositoryType(RepositoryType.PATCH);
/*      */     } else {
/*  714 */       reviewItem.setRepositoryType(RepositoryType.SCM);
/*      */     } 
/*      */     
/*  717 */     reviewItem.setAuthorName(getChildText(reviewItemNode, "authorName"));
/*  718 */     reviewItem.setCommitDate(parseDateTime(getChildText(reviewItemNode, "commitDate")));
/*  719 */     String fileType = getChildText(reviewItemNode, "fileType");
/*  720 */     if (fileType != null && !"".equals(fileType)) {
/*      */       try {
/*  722 */         reviewItem.setFileType(FileType.valueOf(fileType));
/*  723 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  724 */         reviewItem.setFileType(FileType.Unknown);
/*      */       } 
/*      */     }
/*      */     
/*  728 */     reviewItem.setFilePermId(parsePermId(reviewItemNode.getChild("permId")));
/*      */     
/*  730 */     return reviewItem;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean parseGeneralComment(Review review, String myUsername, GeneralComment commentBean, Element reviewCommentNode, boolean trimWikiMarkers) {
/*  742 */     if (!parseComment(myUsername, (Comment)commentBean, reviewCommentNode, trimWikiMarkers)) {
/*  743 */       return false;
/*      */     }
/*  745 */     List<Element> replies = XmlUtil.getChildElements(reviewCommentNode, "replies");
/*  746 */     if (replies != null) {
/*  747 */       List<Comment> rep = new ArrayList<Comment>();
/*  748 */       for (Element repliesNode : replies) {
/*  749 */         List<Element> entries = XmlUtil.getChildElements(repliesNode, "generalCommentData");
/*  750 */         for (Element replyNode : entries) {
/*  751 */           GeneralComment reply = parseGeneralCommentNode(review, (Comment)commentBean, myUsername, replyNode, 
/*  752 */               trimWikiMarkers);
/*  753 */           if (reply != null) {
/*  754 */             reply.setReply(true);
/*  755 */             rep.add(reply);
/*      */           } 
/*      */         } 
/*      */       } 
/*  759 */       commentBean.setReplies(rep);
/*      */     } 
/*      */     
/*  762 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   private static VersionedComment parseVersionedComment(Review review, String myUsername, Element reviewCommentNode, boolean trimWikiMarkers, Map<PermId, CrucibleFileInfo> crucibleFileInfos) throws ParseException {
/*  774 */     VersionedComment commentBean = null;
/*  775 */     List<Element> reviewIds = XmlUtil.getChildElements(reviewCommentNode, "reviewItemId");
/*  776 */     Iterator<Element> iterator = reviewIds.iterator(); if (iterator.hasNext()) { Element reviewId = iterator.next();
/*  777 */       List<Element> ids = XmlUtil.getChildElements(reviewId, "id");
/*  778 */       Iterator<Element> iterator1 = ids.iterator(); if (iterator1.hasNext()) { Element id = iterator1.next();
/*  779 */         PermId permId = new PermId(id.getText());
/*  780 */         CrucibleFileInfo crucibleFileInfo = crucibleFileInfos.get(permId);
/*  781 */         if (crucibleFileInfo == null) {
/*  782 */           throw new ParseException("Cannot find reviewItemId [" + permId + "] in the review description " + 
/*  783 */               "while parsing comment [" + XmlUtil.toPrettyFormatedString(reviewCommentNode), 0);
/*      */         }
/*      */         
/*  786 */         commentBean = new VersionedComment(review, crucibleFileInfo);
/*  787 */         commentBean.setReviewItemId(permId); }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  793 */     if (commentBean == null) {
/*  794 */       throw new ParseException("Cannot parse comment [" + XmlUtil.toPrettyFormatedString(reviewCommentNode) + 
/*  795 */           "]: reviewItemId -> id not found", 0);
/*      */     }
/*      */ 
/*      */     
/*  799 */     if (!parseComment(myUsername, (Comment)commentBean, reviewCommentNode, trimWikiMarkers)) {
/*  800 */       return null;
/*      */     }
/*      */     
/*  803 */     List<Element> replies = XmlUtil.getChildElements(reviewCommentNode, "replies");
/*  804 */     if (replies != null) {
/*  805 */       List<Comment> rep = new ArrayList<Comment>();
/*  806 */       for (Element repliesNode : replies) {
/*  807 */         List<Element> entries = XmlUtil.getChildElements(repliesNode, "generalCommentData");
/*  808 */         for (Element replyNode : entries) {
/*  809 */           GeneralComment reply = new GeneralComment(review, (Comment)commentBean);
/*  810 */           parseGeneralComment(review, myUsername, reply, replyNode, trimWikiMarkers);
/*  811 */           if (reply != null) {
/*  812 */             reply.setReply(true);
/*  813 */             rep.add(reply);
/*      */           } 
/*      */         } 
/*      */       } 
/*  817 */       commentBean.setReplies(rep);
/*      */     } 
/*      */     
/*  820 */     return commentBean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean parseComment(String myUsername, Comment commentBean, Element reviewCommentNode, boolean trimWikiMarkers) {
/*  832 */     boolean isDraft = Boolean.parseBoolean(getChildText(reviewCommentNode, "draft"));
/*  833 */     for (Element element : XmlUtil.getChildElements(reviewCommentNode, "user")) {
/*  834 */       User commentAuthor = parseUserNode(element);
/*      */ 
/*      */       
/*  837 */       if (isDraft && !commentAuthor.getUsername().equals(myUsername)) {
/*  838 */         return false;
/*      */       }
/*  840 */       commentBean.setAuthor(commentAuthor);
/*      */     } 
/*  842 */     commentBean.setDraft(isDraft);
/*      */     
/*  844 */     String message = getChildText(reviewCommentNode, "message");
/*  845 */     if (trimWikiMarkers) {
/*  846 */       message = removeWikiMarkers(message);
/*      */     }
/*  848 */     commentBean.setMessage(message);
/*  849 */     commentBean.setDefectRaised(Boolean.parseBoolean(getChildText(reviewCommentNode, "defectRaised")));
/*  850 */     commentBean.setDefectApproved(Boolean.parseBoolean(getChildText(reviewCommentNode, "defectApproved")));
/*  851 */     commentBean.setDeleted(Boolean.parseBoolean(getChildText(reviewCommentNode, "deleted")));
/*  852 */     commentBean.setCreateDate(parseDateTime(getChildText(reviewCommentNode, "createDate")));
/*  853 */     String readStatus = getChildText(reviewCommentNode, "readStatus");
/*  854 */     commentBean.setReadState(readStatusStringToState(readStatus));
/*      */     
/*  856 */     PermId permId = null;
/*  857 */     if (reviewCommentNode.getChild("permaId") != null) {
/*  858 */       permId = new PermId(reviewCommentNode.getChild("permaId").getChild("id").getText());
/*  859 */       commentBean.setPermId(permId);
/*      */     } 
/*      */     
/*  862 */     if (commentBean.getPermId() == null) {
/*  863 */       permId = new PermId(getChildText(reviewCommentNode, "permaIdAsString"));
/*  864 */       commentBean.setPermId(permId);
/*      */     } 
/*      */     
/*  867 */     List<Element> metrics = XmlUtil.getChildElements(reviewCommentNode, "metrics");
/*  868 */     if (metrics != null) {
/*  869 */       for (Element metric : metrics) {
/*  870 */         List<Element> entries = XmlUtil.getChildElements(metric, "entry");
/*  871 */         for (Element entry : entries) {
/*  872 */           String key = getChildText(entry, "key");
/*  873 */           List<Element> values = XmlUtil.getChildElements(entry, "value");
/*  874 */           Iterator<Element> iterator = values.iterator(); if (iterator.hasNext()) { Element value = iterator.next();
/*  875 */             CustomFieldBean field = new CustomFieldBean();
/*  876 */             field.setConfigVersion(Integer.parseInt(getChildText(value, "configVersion")));
/*  877 */             field.setValue(getChildText(value, "value"));
/*  878 */             commentBean.getCustomFields().put(key, field); }
/*      */         
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*  884 */     return true;
/*      */   }
/*      */   
/*      */   private static String removeWikiMarkers(String message) {
/*  888 */     if (message.startsWith("{preserve-old}")) {
/*  889 */       message = message.substring("{preserve-old}".length());
/*      */     }
/*  891 */     if (message.endsWith("{preserve-old}")) {
/*  892 */       message = message.substring(0, message.lastIndexOf("{preserve-old}"));
/*      */     }
/*  894 */     return message;
/*      */   }
/*      */   
/*      */   private static Comment.ReadState readStatusStringToState(String readStatus) {
/*  898 */     if (readStatus == null) {
/*  899 */       return Comment.ReadState.UNKNOWN;
/*      */     }
/*  901 */     if (readStatus.equals("READ"))
/*  902 */       return Comment.ReadState.READ; 
/*  903 */     if (readStatus.equals("UNREAD"))
/*  904 */       return Comment.ReadState.UNREAD; 
/*  905 */     if (readStatus.equals("LEAVE_UNREAD")) {
/*  906 */       return Comment.ReadState.LEAVE_UNREAD;
/*      */     }
/*  908 */     return Comment.ReadState.UNKNOWN;
/*      */   }
/*      */   
/*      */   private static void prepareComment(Comment comment, Element commentNode) {
/*  912 */     String date = COMMENT_TIME_FORMAT_BASE.print(comment.getCreateDate().getTime());
/*  913 */     String strangeDate = date.substring(0, date.length() - 2);
/*  914 */     strangeDate = String.valueOf(strangeDate) + ":00";
/*  915 */     addTag(commentNode, "createDate", strangeDate);
/*  916 */     Element userElement = new Element("user");
/*  917 */     getContent(commentNode).add(userElement);
/*  918 */     addTag(userElement, "userName", comment.getAuthor().getUsername());
/*  919 */     addTag(commentNode, "defectRaised", Boolean.toString(comment.isDefectRaised()));
/*  920 */     addTag(commentNode, "defectApproved", Boolean.toString(comment.isDefectApproved()));
/*  921 */     addTag(commentNode, "deleted", Boolean.toString(comment.isDeleted()));
/*  922 */     addTag(commentNode, "draft", Boolean.toString(comment.isDraft()));
/*  923 */     addTag(commentNode, "message", comment.getMessage());
/*  924 */     Element metrics = new Element("metrics");
/*  925 */     getContent(commentNode).add(metrics);
/*      */     
/*  927 */     for (String key : comment.getCustomFields().keySet()) {
/*  928 */       Element entry = new Element("entry");
/*  929 */       getContent(metrics).add(entry);
/*  930 */       addTag(entry, "key", key);
/*  931 */       CustomField field = (CustomField)comment.getCustomFields().get(key);
/*  932 */       getContent(entry).add(prepareCustomFieldValue(field));
/*      */     } 
/*      */     
/*  935 */     Element replies = new Element("replies");
/*  936 */     getContent(commentNode).add(replies);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static GeneralComment parseGeneralCommentNode(Review review, @Nullable Comment parentComment, String myUsername, Element reviewCommentNode, boolean trimWikiMarkers) {
/*  942 */     GeneralComment reviewCommentBean = new GeneralComment(review, parentComment);
/*  943 */     if (!parseGeneralComment(review, myUsername, reviewCommentBean, reviewCommentNode, trimWikiMarkers)) {
/*  944 */       return null;
/*      */     }
/*  946 */     return reviewCommentBean;
/*      */   }
/*      */   
/*      */   public static Document prepareGeneralComment(Comment comment) {
/*  950 */     Element commentNode = new Element("generalCommentData");
/*  951 */     Document doc = new Document(commentNode);
/*  952 */     prepareComment(comment, commentNode);
/*  953 */     return doc;
/*      */   }
/*      */   
/*      */   private static List<Content> getContent(Element e) {
/*  957 */     return e.getContent();
/*      */   }
/*      */   
/*      */   public static Document prepareVersionedComment(PermId riId, VersionedComment comment) {
/*  961 */     if (comment.getToStartLine() > comment.getToEndLine()) {
/*  962 */       throw new IllegalArgumentException("Comment start cannot be after comment end!");
/*      */     }
/*  964 */     Element commentNode = new Element("versionedLineCommentData");
/*  965 */     Document doc = new Document(commentNode);
/*  966 */     prepareComment((Comment)comment, commentNode);
/*  967 */     Element reviewItemId = new Element("reviewItemId");
/*  968 */     getContent(commentNode).add(reviewItemId);
/*  969 */     addTag(reviewItemId, "id", riId.getId());
/*  970 */     if (comment.getFromStartLine() > 0 && comment.getFromEndLine() > 0) {
/*  971 */       addTag(commentNode, "fromLineRange", String.valueOf(comment.getFromStartLine()) + "-" + comment.getFromEndLine());
/*      */     }
/*  973 */     if (comment.getToStartLine() > 0 && comment.getToEndLine() > 0) {
/*  974 */       addTag(commentNode, "toLineRange", String.valueOf(comment.getToStartLine()) + "-" + comment.getToEndLine());
/*      */     }
/*  976 */     return doc;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   public static VersionedComment parseVersionedCommentNode(Review review, Map<PermId, CrucibleFileInfo> crucibleFileInfos, String myUsername, Element reviewCommentNode, boolean trimWikiMarkers) throws ParseException {
/*  985 */     VersionedComment comment = 
/*  986 */       parseVersionedComment(review, myUsername, reviewCommentNode, trimWikiMarkers, crucibleFileInfos);
/*  987 */     if (comment == null) {
/*  988 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  997 */     if (reviewCommentNode.getChild("fromLineRange") != null) {
/*  998 */       String fromLineRange = getChildText(reviewCommentNode, "fromLineRange");
/*  999 */       if (fromLineRange.trim().length() > 0) {
/*      */         try {
/* 1001 */           comment.setFromLineRanges(IntRangesParser.parse(fromLineRange));
/* 1002 */         } catch (NumberFormatException e) {
/* 1003 */           LoggerImpl.getInstance().error(e);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/* 1008 */     if (reviewCommentNode.getChild("toLineRange") != null) {
/* 1009 */       String toLineRange = getChildText(reviewCommentNode, "toLineRange");
/* 1010 */       if (toLineRange.trim().length() > 0) {
/*      */         try {
/* 1012 */           comment.setToLineRanges(IntRangesParser.parse(toLineRange));
/* 1013 */         } catch (NumberFormatException e) {
/* 1014 */           LoggerImpl.getInstance().error(e);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/* 1019 */     Element child = reviewCommentNode.getChild("lineRanges");
/* 1020 */     if (child != null) {
/* 1021 */       parseAndFillLineRanges(comment, child);
/*      */     } else {
/* 1023 */       CrucibleFileInfo fileInfo = comment.getCrucibleFileInfo();
/* 1024 */       Map<String, IntRanges> ranges = MiscUtil.buildHashMap();
/* 1025 */       if (fileInfo.getFileDescriptor() != null && comment.getToLineRanges() != null) {
/* 1026 */         ranges.put(fileInfo.getFileDescriptor().getRevision(), comment.getToLineRanges());
/*      */       }
/* 1028 */       if (fileInfo.getOldFileDescriptor() != null && comment.getFromLineRanges() != null) {
/* 1029 */         ranges.put(fileInfo.getOldFileDescriptor().getRevision(), comment.getFromLineRanges());
/*      */       }
/* 1031 */       if (ranges.size() > 0) {
/* 1032 */         comment.setLineRanges(ranges);
/*      */       }
/*      */     } 
/* 1035 */     return comment;
/*      */   }
/*      */   
/*      */   private static void parseAndFillLineRanges(VersionedComment comment, Element lineRangesNode) {
/* 1039 */     Map<String, IntRanges> rangesMap = new LinkedHashMap<String, IntRanges>();
/* 1040 */     List<Element> entries = XmlUtil.getChildElements(lineRangesNode, "lineRange");
/* 1041 */     for (Element rangeNode : entries) {
/* 1042 */       String revisionStr = rangeNode.getAttributeValue("revision");
/* 1043 */       String rangeStr = rangeNode.getAttributeValue("range");
/*      */       try {
/* 1045 */         rangesMap.put(revisionStr, IntRangesParser.parse(rangeStr));
/* 1046 */       } catch (NumberFormatException e) {
/* 1047 */         LoggerImpl.getInstance().error(e);
/*      */       } 
/*      */     } 
/* 1050 */     comment.setLineRanges(rangesMap);
/*      */   }
/*      */   
/*      */   private static Element prepareCustomFieldValue(CustomField value) {
/* 1054 */     Element entry = new Element("value");
/* 1055 */     addTag(entry, "configVersion", Integer.toString(value.getConfigVersion()));
/* 1056 */     addTag(entry, "value", value.getValue());
/* 1057 */     return entry;
/*      */   }
/*      */   
/*      */   private static CustomFieldValue getCustomFieldValue(CustomFieldValueType type, Element element) {
/* 1061 */     CustomFieldValue newValue = new CustomFieldValue();
/* 1062 */     newValue.setName(getChildText(element, "name"));
/* 1063 */     switch (type)
/*      */     { case INTEGER:
/*      */         try {
/* 1066 */           newValue.setValue(Integer.valueOf(getChildText(element, "value")));
/* 1067 */         } catch (NumberFormatException numberFormatException) {
/* 1068 */           newValue.setValue(Integer.valueOf(0));
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1082 */         return newValue;case STRING: newValue.setValue(getChildText(element, "value")); return newValue;case null: newValue.setValue(Boolean.valueOf(getChildText(element, "value"))); return newValue; }  newValue.setValue(null); return newValue;
/*      */   }
/*      */   
/*      */   public static CustomFieldDefBean parseMetricsNode(Element element) {
/* 1086 */     CustomFieldDefBean field = new CustomFieldDefBean();
/*      */     
/* 1088 */     field.setName(getChildText(element, "name"));
/* 1089 */     field.setLabel(getChildText(element, "label"));
/* 1090 */     field.setType(CustomFieldValueType.valueOf(getChildText(element, "type")));
/* 1091 */     field.setConfigVersion(Integer.parseInt(getChildText(element, "configVersion")));
/*      */     
/* 1093 */     List<Element> defaultValue = XmlUtil.getChildElements(element, "defaultValue");
/* 1094 */     for (Element value : defaultValue) {
/* 1095 */       field.setDefaultValue(getCustomFieldValue(field.getType(), value));
/*      */     }
/* 1097 */     List<Element> values = XmlUtil.getChildElements(element, "values");
/* 1098 */     for (Element value : values) {
/* 1099 */       field.getValues().add(getCustomFieldValue(field.getType(), value));
/*      */     }
/*      */     
/* 1102 */     return field;
/*      */   }
/*      */   
/*      */   public static Document prepareCustomFilter(CustomFilter filter) {
/* 1106 */     Element filterData = prepareFilterNodeElement(filter);
/* 1107 */     return new Document(filterData);
/*      */   }
/*      */   
/*      */   private static Element prepareFilterNodeElement(CustomFilter filter) {
/* 1111 */     Element filterData = new Element("customFilterData");
/*      */     
/* 1113 */     addTag(filterData, "author", (filter.getAuthor() != null) ? filter.getAuthor() : "");
/* 1114 */     addTag(filterData, "creator", (filter.getCreator() != null) ? filter.getCreator() : "");
/* 1115 */     addTag(filterData, "moderator", (filter.getModerator() != null) ? filter.getModerator() : "");
/* 1116 */     addTag(filterData, "reviewer", (filter.getReviewer() != null) ? filter.getReviewer() : "");
/* 1117 */     addTag(filterData, "project", (filter.getProjectKey() != null) ? filter.getProjectKey() : "");
/* 1118 */     String state = filter.getStates();
/*      */     
/* 1120 */     if (!StringUtils.isEmpty(state)) {
/* 1121 */       addTag(filterData, "state", state);
/*      */     }
/* 1123 */     if (filter.isComplete() != null) {
/* 1124 */       addTag(filterData, "complete", Boolean.toString(filter.isComplete().booleanValue()));
/*      */     }
/* 1126 */     addTag(filterData, "orRoles", Boolean.toString(filter.isOrRoles()));
/* 1127 */     if (filter.isAllReviewersComplete() != null) {
/* 1128 */       addTag(filterData, "allReviewersComplete", Boolean.toString(filter.isAllReviewersComplete().booleanValue()));
/*      */     }
/*      */     
/* 1131 */     return filterData;
/*      */   }
/*      */ 
/*      */   
/* 1135 */   private static final DateTimeFormatter COMMENT_TIME_FORMAT_BASE = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
/* 1136 */   private static final DateTimeFormatter[] COMMENT_TIME_FORMATS = new DateTimeFormatter[] { COMMENT_TIME_FORMAT_BASE, 
/* 1137 */       DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"), 
/* 1138 */       DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"), 
/* 1139 */       DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"), 
/* 1140 */       DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss") };
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date parseDateTime(String date) {
/* 1145 */     IllegalArgumentException ae = null;
/*      */     
/* 1147 */     if (date != null && !date.equals("")) {
/* 1148 */       byte b; int i; DateTimeFormatter[] arrayOfDateTimeFormatter; for (i = (arrayOfDateTimeFormatter = COMMENT_TIME_FORMATS).length, b = 0; b < i; ) { DateTimeFormatter f = arrayOfDateTimeFormatter[b];
/*      */         try {
/* 1150 */           Date parsedDate = f.parseDateTime(date).toDate();
/* 1151 */           return parsedDate;
/* 1152 */         } catch (IllegalArgumentException e) {
/* 1153 */           ae = e;
/*      */         } 
/*      */         b++; }
/*      */       
/* 1157 */       if (ae != null) {
/* 1158 */         throw ae;
/*      */       }
/*      */     } 
/*      */     
/* 1162 */     return null;
/*      */   }
/*      */   
/*      */   private static DateTime parseJodaDateTime(String date) throws ParseException {
/* 1166 */     ParseException pe = null;
/*      */     
/* 1168 */     if (date != null && !date.equals("")) {
/* 1169 */       byte b; int i; DateTimeFormatter[] arrayOfDateTimeFormatter; for (i = (arrayOfDateTimeFormatter = COMMENT_TIME_FORMATS).length, b = 0; b < i; ) { DateTimeFormatter f = arrayOfDateTimeFormatter[b];
/*      */         try {
/* 1171 */           return f.parseDateTime(date);
/* 1172 */         } catch (IllegalArgumentException illegalArgumentException) {
/*      */           
/* 1174 */           pe = new ParseException("Invalid date string encountered [" + date + "]", 0);
/*      */         }
/* 1176 */         catch (RuntimeException runtimeException) {
/* 1177 */           pe = new ParseException("Cannot convert string [" + date + "] to date", 0);
/*      */         } 
/*      */         b++; }
/*      */       
/* 1181 */       if (pe != null) {
/* 1182 */         throw pe;
/*      */       }
/*      */     } 
/* 1185 */     return null;
/*      */   }
/*      */   
/*      */   private static ReviewType parseReviewType(String reviewType) throws ParseException {
/* 1189 */     if (reviewType == null || "REVIEW".equals(reviewType))
/* 1190 */       return ReviewType.REVIEW; 
/* 1191 */     if ("SNIPPET".equals(reviewType)) {
/* 1192 */       return ReviewType.SNIPPET;
/*      */     }
/* 1194 */     throw new ParseException("Unknown review type [" + reviewType + "]", 0);
/*      */   }
/*      */   
/*      */   public static CrucibleVersionInfo parseVersionNode(Element element) {
/* 1198 */     return new CrucibleVersionInfo(getChildText(element, "releaseNumber"), getChildText(element, "buildDate"));
/*      */   }
/*      */   
/*      */   public static Changes parseChangesNode(Element changesNode) {
/* 1202 */     List<Change> changes = MiscUtil.buildArrayList();
/* 1203 */     for (Element changeNode : XmlUtil.getChildElements(changesNode, "change")) {
/* 1204 */       changes.add(parseChangeNode(changeNode));
/*      */     }
/* 1206 */     return new Changes(Boolean.parseBoolean(changesNode.getAttributeValue("olderChangeSetsExist")), 
/* 1207 */         Boolean.parseBoolean(changesNode.getAttributeValue("newerChangeSetsExist")), changes);
/*      */   }
/*      */   
/*      */   private static Change parseChangeNode(Element changeNode) {
/* 1211 */     String author = changeNode.getAttributeValue("author");
/* 1212 */     String csid = changeNode.getAttributeValue("csid");
/* 1213 */     Date date = parseDateTime(changeNode.getAttributeValue("date"));
/* 1214 */     Link link = parseLinkNode(changeNode.getChild("link"));
/* 1215 */     String comment = getChildText(changeNode, "comment");
/* 1216 */     List<Revision> revisions = MiscUtil.buildArrayList();
/* 1217 */     for (Element revisionNode : XmlUtil.getChildElements(changeNode, "revision")) {
/* 1218 */       revisions.add(parseRevisionNode(revisionNode));
/*      */     }
/* 1220 */     return new Change(author, date, csid, link, comment, revisions);
/*      */   }
/*      */   
/*      */   private static Revision parseRevisionNode(Element revisionNode) {
/* 1224 */     String revision = revisionNode.getAttributeValue("revision");
/* 1225 */     String path = revisionNode.getAttributeValue("path");
/* 1226 */     List<Link> links = MiscUtil.buildArrayList();
/* 1227 */     for (Element linkNode : XmlUtil.getChildElements(revisionNode, "link")) {
/* 1228 */       links.add(parseLinkNode(linkNode));
/*      */     }
/* 1230 */     return new Revision(revision, path, links);
/*      */   }
/*      */   
/*      */   private static Link parseLinkNode(Element child) {
/* 1234 */     return new Link(child.getAttributeValue("rel"), child.getAttributeValue("href"));
/*      */   }
/*      */   
/*      */   public static void parseErrorAndThrowIt(Element errorNode) throws RemoteApiException {
/* 1238 */     throw new RemoteApiException(getChildText(errorNode, "message"), getChildText(errorNode, "stacktrace"));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addAnchorData(Document request, PatchAnchorData patchAnchorData) {
/* 1243 */     if (patchAnchorData == null) {
/*      */       return;
/*      */     }
/*      */     
/* 1247 */     Element anchorData = new Element("anchor");
/* 1248 */     Element anchorRepository = new Element("anchorRepository");
/*      */ 
/*      */ 
/*      */     
/* 1252 */     anchorRepository.setText(patchAnchorData.getRepositoryName());
/*      */ 
/*      */ 
/*      */     
/* 1256 */     anchorData.addContent((Content)anchorRepository);
/*      */ 
/*      */ 
/*      */     
/* 1260 */     ((Element)request.getContent().get(0)).addContent((Content)anchorData);
/*      */   }
/*      */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\rest\CrucibleRestXmlHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */