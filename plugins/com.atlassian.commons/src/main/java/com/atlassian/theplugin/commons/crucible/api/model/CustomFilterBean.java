/*     */ package com.atlassian.theplugin.commons.crucible.api.model;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.cfg.ServerIdImpl;
/*     */ import org.apache.commons.lang.StringUtils;
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
/*     */ public class CustomFilterBean
/*     */   implements CustomFilter
/*     */ {
/*     */   private ServerIdImpl serverId;
/*  25 */   private String title = "";
/*  26 */   private State[] state = new State[0];
/*  27 */   private String author = "";
/*  28 */   private String moderator = "";
/*  29 */   private String creator = "";
/*  30 */   private String reviewer = "";
/*     */   private boolean orRoles;
/*     */   private Boolean complete;
/*     */   private Boolean allReviewersComplete;
/*  34 */   private String projectKey = "";
/*     */   private boolean enabled;
/*     */   private static final double ID_DISCRIMINATOR = 1002.0D;
/*     */   private static final int HASHCODE_CONSTANT = 31;
/*     */   private static final int SHIFT_32 = 32;
/*     */   public static final String FILTER_ID = "MANUAL_FILTER_ID";
/*  40 */   private final String filterName = "Custom";
/*     */   
/*     */   private boolean empty = false;
/*     */   
/*     */   public boolean equals(Object o) {
/*  45 */     if (this == o) {
/*  46 */       return true;
/*     */     }
/*  48 */     if (o == null || getClass() != o.getClass()) {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     CustomFilterBean that = (CustomFilterBean)o;
/*     */     
/*  54 */     if (this.uid != that.uid) {
/*  55 */       return false;
/*     */     }
/*  57 */     that.getClass(); if (!"Custom".equals("Custom")) {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  67 */     int result = ("Custom" != null) ? "Custom".hashCode() : 0;
/*  68 */     result = 31 * result + (int)(this.uid ^ this.uid >>> 32L);
/*  69 */     return result;
/*     */   }
/*     */   
/*  72 */   private transient long uid = System.currentTimeMillis() + (long)(Math.random() * 1002.0D);
/*     */   
/*     */   public ServerIdImpl getServerId() {
/*  75 */     return this.serverId;
/*     */   }
/*     */   
/*     */   public void setServerId(ServerIdImpl serverId) {
/*  79 */     this.serverId = serverId;
/*     */   }
/*     */   
/*     */   public CustomFilterBean copy(CustomFilterBean bean) {
/*  83 */     this.serverId = bean.serverId;
/*  84 */     this.title = bean.title;
/*  85 */     this.state = bean.state;
/*  86 */     this.author = bean.author;
/*  87 */     this.moderator = bean.moderator;
/*  88 */     this.creator = bean.creator;
/*  89 */     this.reviewer = bean.reviewer;
/*  90 */     this.orRoles = bean.orRoles;
/*  91 */     this.complete = bean.complete;
/*  92 */     this.allReviewersComplete = bean.allReviewersComplete;
/*  93 */     this.projectKey = bean.projectKey;
/*  94 */     this.enabled = bean.enabled;
/*  95 */     this.empty = bean.empty;
/*  96 */     return this;
/*     */   }
/*     */   public CustomFilterBean(CustomFilterBean bean) {
/*  99 */     copy(bean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CustomFilterBean() {}
/*     */ 
/*     */   
/*     */   public String getTitle() {
/* 108 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/* 112 */     this.title = title;
/*     */   }
/*     */   
/*     */   public State[] getState() {
/* 116 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setState(State[] state) {
/* 121 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getAuthor() {
/* 125 */     return this.author;
/*     */   }
/*     */   
/*     */   public void setAuthor(String author) {
/* 129 */     this.author = author;
/*     */   }
/*     */   
/*     */   public String getModerator() {
/* 133 */     return this.moderator;
/*     */   }
/*     */   
/*     */   public void setModerator(String moderator) {
/* 137 */     this.moderator = moderator;
/*     */   }
/*     */   
/*     */   public String getCreator() {
/* 141 */     return this.creator;
/*     */   }
/*     */   
/*     */   public void setCreator(String creator) {
/* 145 */     this.creator = creator;
/*     */   }
/*     */   
/*     */   public String getReviewer() {
/* 149 */     return this.reviewer;
/*     */   }
/*     */   
/*     */   public void setReviewer(String reviewer) {
/* 153 */     this.reviewer = reviewer;
/*     */   }
/*     */   
/*     */   public Boolean isComplete() {
/* 157 */     return this.complete;
/*     */   }
/*     */   
/*     */   public void setComplete(Boolean complete) {
/* 161 */     this.complete = complete;
/*     */   }
/*     */   
/*     */   public Boolean isAllReviewersComplete() {
/* 165 */     return this.allReviewersComplete;
/*     */   }
/*     */   
/*     */   public void setAllReviewersComplete(Boolean allReviewersComplete) {
/* 169 */     this.allReviewersComplete = allReviewersComplete;
/*     */   }
/*     */   
/*     */   public String getProjectKey() {
/* 173 */     return this.projectKey;
/*     */   }
/*     */   
/*     */   public void setProjectKey(String projectKey) {
/* 177 */     this.projectKey = projectKey;
/*     */   }
/*     */   
/*     */   public boolean isOrRoles() {
/* 181 */     return this.orRoles;
/*     */   }
/*     */   
/*     */   public void setOrRoles(boolean orRoles) {
/* 185 */     this.orRoles = orRoles;
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/* 189 */     return this.enabled;
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 193 */     this.enabled = enabled;
/*     */   }
/*     */   
/*     */   public String getId() {
/* 197 */     return "MANUAL_FILTER_ID";
/*     */   }
/*     */   
/*     */   public String getFilterName() {
/* 201 */     return "Custom";
/*     */   }
/*     */   
/*     */   public String getFilterUrl() {
/* 205 */     return prepareCustomFilterUrl();
/*     */   }
/*     */   
/*     */   private String prepareCustomFilterUrl() {
/* 209 */     StringBuilder url = new StringBuilder();
/*     */     
/* 211 */     addQueryParam("author", getAuthor(), url);
/* 212 */     addQueryParam("creator", getCreator(), url);
/* 213 */     addQueryParam("moderator", getModerator(), url);
/* 214 */     addQueryParam("reviewer", getReviewer(), url);
/* 215 */     addQueryParam("project", getProjectKey(), url);
/* 216 */     String stateParam = getStates();
/* 217 */     addQueryParam("states", stateParam, url);
/*     */     
/* 219 */     if (isComplete() != null) {
/* 220 */       addQueryParam("complete", Boolean.toString(isComplete().booleanValue()), url);
/*     */     }
/* 222 */     addQueryParam("orRoles", Boolean.toString(isOrRoles()), url);
/* 223 */     if (isAllReviewersComplete() != null) {
/* 224 */       addQueryParam("allReviewersComplete", Boolean.toString(isAllReviewersComplete().booleanValue()), url);
/*     */     }
/*     */     
/* 227 */     String urlString = url.toString();
/* 228 */     return urlString.equals("?") ? "" : urlString;
/*     */   }
/*     */   
/*     */   private void addQueryParam(String name, String value, StringBuilder builder) {
/* 232 */     if (!StringUtils.isEmpty(value)) {
/* 233 */       if (builder.length() > 0) {
/* 234 */         builder.append("&");
/*     */       }
/* 236 */       builder.append(name).append("=").append(value);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getStates() {
/* 241 */     String stateParam = "";
/* 242 */     if (getState() != null) {
/* 243 */       byte b; int i; State[] arrayOfState; for (i = (arrayOfState = getState()).length, b = 0; b < i; ) { State s = arrayOfState[b];
/* 244 */         if (stateParam.length() > 0) {
/* 245 */           stateParam = String.valueOf(stateParam) + ",";
/*     */         }
/* 247 */         stateParam = String.valueOf(stateParam) + s.value(); b++; }
/*     */     
/*     */     } 
/* 250 */     return stateParam;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 254 */     return this.empty;
/*     */   }
/*     */   
/*     */   public void setEmpty(boolean empty) {
/* 258 */     this.empty = empty;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\CustomFilterBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */