/*     */ package com.atlassian.connector.commons.jira.beans;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public final class JiraQueryUrl
/*     */ {
/*     */   private static final int NOT_INITIALIZED = -10;
/*     */   private static final String ISSUE_NAVIGATOR = "/secure/IssueNavigator.jspa?refreshFilter=false&reset=update&show=View+%3E%3E";
/*     */   private static final String ISSUE_RSS = "/sr/jira.issueviews:searchrequest-xml/temp/SearchRequest.xml?";
/*     */   private static final String ISSUES_SAVED_FILTER = "/sr/jira.issueviews:searchrequest-xml/";
/*  34 */   private String serverUrl = null;
/*  35 */   private List<JIRAQueryFragment> queryFragments = null;
/*  36 */   private String sortBy = null;
/*  37 */   private String sortOrder = null;
/*  38 */   private int start = -10;
/*  39 */   private int max = -10;
/*  40 */   private String userName = null;
/*     */   private String password;
/*     */   
/*     */   public static class Builder {
/*  44 */     private List<JIRAQueryFragment> queryFragments = null;
/*  45 */     private String sortBy = null;
/*  46 */     private String sortOrder = null;
/*  47 */     private int start = -1;
/*  48 */     private int max = -1;
/*  49 */     private String userName = null;
/*     */     
/*     */     private String serverUrl;
/*     */     private String password;
/*     */     
/*     */     public Builder serverUrl(String server) {
/*  55 */       this.serverUrl = server;
/*  56 */       return this;
/*     */     }
/*     */     
/*     */     public Builder queryFragments(List<JIRAQueryFragment> fragmentList) {
/*  60 */       this.queryFragments = fragmentList;
/*  61 */       return this;
/*     */     }
/*     */     
/*     */     public Builder sortBy(String sort) {
/*  65 */       this.sortBy = sort;
/*  66 */       return this;
/*     */     }
/*     */     
/*     */     public Builder sortOrder(String sortOdr) {
/*  70 */       this.sortOrder = sortOdr;
/*  71 */       return this;
/*     */     }
/*     */     
/*     */     public Builder start(int strt) {
/*  75 */       this.start = strt;
/*  76 */       return this;
/*     */     }
/*     */     
/*     */     public Builder max(int mx) {
/*  80 */       this.max = mx;
/*  81 */       return this;
/*     */     }
/*     */     
/*     */     public Builder userName(String username) {
/*  85 */       this.userName = username;
/*  86 */       return this;
/*     */     }
/*     */     
/*     */     public Builder password(String passw) {
/*  90 */       this.password = passw;
/*  91 */       return this;
/*     */     }
/*     */     
/*     */     public JiraQueryUrl build() {
/*  95 */       return new JiraQueryUrl(this, null);
/*     */     }
/*     */     
/*     */     public Builder queryFragment(JIRAQueryFragment fragment) {
/*  99 */       if (this.queryFragments == null) {
/* 100 */         this.queryFragments = new ArrayList<JIRAQueryFragment>();
/*     */       }
/* 102 */       this.queryFragments.add(fragment);
/* 103 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public String buildRssSearchUrl() {
/* 108 */     StringBuffer sb = new StringBuffer();
/* 109 */     sb.append(buildQueryFragment());
/* 110 */     sb.append("&").append(buildOptions());
/*     */     
/* 112 */     if (this.serverUrl != null) {
/* 113 */       sb.insert(0, "/sr/jira.issueviews:searchrequest-xml/temp/SearchRequest.xml?");
/* 114 */       sb.insert(0, this.serverUrl);
/*     */     } 
/*     */     
/* 117 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String buildIssueNavigatorUrl() {
/* 121 */     StringBuffer sb = new StringBuffer();
/* 122 */     sb.append(buildQueryFragment());
/* 123 */     sb.append("&").append(buildOptions());
/*     */     
/* 125 */     if (this.serverUrl != null) {
/* 126 */       sb.insert(0, "/secure/IssueNavigator.jspa?refreshFilter=false&reset=update&show=View+%3E%3E");
/* 127 */       sb.insert(0, this.serverUrl);
/*     */     } 
/*     */     
/* 130 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String buildSavedFilterUrl() {
/* 135 */     JIRAQueryFragment query = (this.queryFragments != null && this.queryFragments.size() > 0) ? this.queryFragments.get(0) : null;
/*     */     
/* 137 */     StringBuffer sb = new StringBuffer();
/* 138 */     if (this.serverUrl != null) {
/* 139 */       sb.append(this.serverUrl);
/* 140 */       sb.append("/sr/jira.issueviews:searchrequest-xml/");
/*     */     } 
/*     */     
/* 143 */     if (query != null) {
/* 144 */       sb.append(query.getQueryStringFragment())
/* 145 */         .append("/SearchRequest-")
/* 146 */         .append(query.getQueryStringFragment())
/* 147 */         .append(".xml");
/*     */     }
/* 149 */     sb.append("?");
/* 150 */     sb.append(buildOptions());
/*     */     
/* 152 */     return sb.toString();
/*     */   }
/*     */   private String buildQueryFragment() {
/* 155 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 157 */     List<JIRAQueryFragment> fragmentsWithoutAnys = new ArrayList<JIRAQueryFragment>();
/* 158 */     for (JIRAQueryFragment jiraQueryFragment : this.queryFragments) {
/* 159 */       if (jiraQueryFragment.getId() != -1000L) {
/* 160 */         fragmentsWithoutAnys.add(jiraQueryFragment);
/*     */       }
/*     */     } 
/*     */     
/* 164 */     for (JIRAQueryFragment fragment : fragmentsWithoutAnys) {
/* 165 */       if (fragment.getQueryStringFragment() != null) {
/* 166 */         sb.append("&");
/* 167 */         sb.append(fragment.getQueryStringFragment());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 172 */     return sb.toString();
/*     */   }
/*     */   
/*     */   private String buildOptions() {
/* 176 */     StringBuffer sb = new StringBuffer();
/*     */     
/* 178 */     if (this.sortBy != null) {
/* 179 */       sb.append("&sorter/field=").append(this.sortBy);
/*     */     }
/* 181 */     if (this.sortOrder != null) {
/* 182 */       sb.append("&sorter/order=").append(this.sortOrder);
/*     */     }
/* 184 */     if (this.start != -10) {
/* 185 */       sb.append("&pager/start=").append(this.start);
/*     */     }
/*     */     
/* 188 */     if (this.max != -10) {
/* 189 */       sb.append("&tempMax=").append(this.max);
/*     */     }
/*     */     
/* 192 */     if (this.userName != null) {
/* 193 */       sb.append(appendAuthentication(false, this.userName, this.password));
/*     */     }
/*     */     
/* 196 */     if (sb.length() > 0) {
/* 197 */       sb.deleteCharAt(0);
/*     */     }
/* 199 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String appendAuthentication(boolean firstItem, String userName, String password) {
/* 207 */     return "";
/*     */   }
/*     */   
/*     */   private JiraQueryUrl(Builder builder) {
/* 211 */     this.queryFragments = builder.queryFragments;
/* 212 */     this.sortBy = builder.sortBy;
/* 213 */     this.sortOrder = builder.sortOrder;
/* 214 */     this.start = builder.start;
/* 215 */     this.max = builder.max;
/* 216 */     this.userName = builder.userName;
/* 217 */     this.serverUrl = builder.serverUrl;
/* 218 */     this.password = builder.password;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JiraQueryUrl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */