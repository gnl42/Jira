/*     */ package com.atlassian.connector.commons.jira.beans;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.net.URI;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class JIRASavedFilterBean
/*     */   implements JIRASavedFilter
/*     */ {
/*     */   private final String name;
/*     */   private String author;
/*     */   private String project;
/*     */   private final long id;
/*     */   private String jql;
/*     */   private URI searchUrl;
/*     */   private URI viewUrl;
/*     */   
/*     */   public JIRASavedFilterBean(Map projMap) {
/*  35 */     this.name = (String)projMap.get("name");
/*  36 */     this.author = (String)projMap.get("author");
/*  37 */     this.project = (String)projMap.get("project");
/*  38 */     this.id = Long.valueOf((String)projMap.get("id")).longValue();
/*     */   }
/*     */   
/*     */   public JIRASavedFilterBean(String n, long id) {
/*  42 */     this.name = n;
/*  43 */     this.id = id;
/*     */   }
/*     */   
/*     */   public JIRASavedFilterBean(String name, long id, String jql, URI searchUrl, URI viewUrl) {
/*  47 */     this.name = name;
/*  48 */     this.id = id;
/*  49 */     this.jql = jql;
/*  50 */     this.searchUrl = searchUrl;
/*  51 */     this.viewUrl = viewUrl;
/*     */   }
/*     */   
/*     */   public JIRASavedFilterBean(JIRASavedFilterBean other) {
/*  55 */     this.name = other.name;
/*  56 */     this.author = other.author;
/*  57 */     this.project = other.project;
/*  58 */     this.id = other.id;
/*  59 */     this.jql = other.jql;
/*  60 */     this.searchUrl = other.searchUrl;
/*  61 */     this.viewUrl = other.viewUrl;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  65 */     return this.name;
/*     */   }
/*     */   
/*     */   public HashMap<String, String> getMap() {
/*  69 */     HashMap<String, String> map = new HashMap<String, String>();
/*  70 */     map.put("name", getName());
/*  71 */     map.put("id", Long.toString(this.id));
/*  72 */     map.put("author", getAuthor());
/*  73 */     map.put("project", getProject());
/*  74 */     map.put("filterTypeClass", getClass().getName());
/*  75 */     return map;
/*     */   }
/*     */   
/*     */   public JIRASavedFilterBean getClone() {
/*  79 */     return new JIRASavedFilterBean(this);
/*     */   }
/*     */   
/*     */   public long getId() {
/*  83 */     return this.id;
/*     */   }
/*     */   
/*     */   public String getAuthor() {
/*  87 */     return this.author;
/*     */   }
/*     */   
/*     */   public String getProject() {
/*  91 */     return this.project;
/*     */   }
/*     */   
/*     */   public String getQueryStringFragment() {
/*  95 */     return Long.toString(this.id);
/*     */   }
/*     */   
/*     */   public List<JIRAQueryFragment> getQueryFragments() {
/*  99 */     return (List<JIRAQueryFragment>)ImmutableList.of(this);
/*     */   }
/*     */   
/*     */   public String getOldStyleQueryString() {
/* 103 */     return getQueryStringFragment();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getJql() {
/* 108 */     return this.jql;
/*     */   }
/*     */   
/*     */   public URI getSearchUrl() {
/* 112 */     return this.searchUrl;
/*     */   }
/*     */   
/*     */   public URI getViewUrl() {
/* 116 */     return this.viewUrl;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRASavedFilterBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */