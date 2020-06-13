/*     */ package com.atlassian.connector.commons.jira.beans;
/*     */ 
/*     */ import java.util.HashMap;
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
/*     */ 
/*     */ public class JIRAProjectBean
/*     */   implements JIRAProject
/*     */ {
/*     */   private String name;
/*     */   private String key;
/*     */   private String url;
/*     */   private long id;
/*     */   private String description;
/*     */   private String lead;
/*     */   
/*     */   public JIRAProjectBean() {}
/*     */   
/*     */   public JIRAProjectBean(Map projMap) {
/*  34 */     this.name = (String)projMap.get("name");
/*  35 */     this.key = (String)projMap.get("key");
/*  36 */     this.description = (String)projMap.get("description");
/*  37 */     this.url = (String)projMap.get("url");
/*  38 */     this.lead = (String)projMap.get("lead");
/*  39 */     this.id = Long.valueOf((String)projMap.get("id")).longValue();
/*     */   }
/*     */   
/*     */   public JIRAProjectBean(long id, String name) {
/*  43 */     this.id = id;
/*  44 */     this.name = name;
/*     */   }
/*     */   public JIRAProjectBean(long id, String key, String name) {
/*  47 */     this.id = id;
/*  48 */     this.key = key;
/*  49 */     this.name = name;
/*     */   }
/*     */   
/*     */   public JIRAProjectBean(JIRAProjectBean other) {
/*  53 */     this(other.getMap());
/*     */   }
/*     */   
/*     */   public String getName() {
/*  57 */     return this.name;
/*     */   }
/*     */   
/*     */   public HashMap<String, String> getMap() {
/*  61 */     HashMap<String, String> map = new HashMap<String, String>();
/*  62 */     map.put("name", getName());
/*  63 */     map.put("id", Long.toString(this.id));
/*  64 */     map.put("key", getKey());
/*  65 */     map.put("description", getDescription());
/*  66 */     map.put("url", getUrl());
/*  67 */     map.put("lead", getLead());
/*  68 */     map.put("filterTypeClass", getClass().getName());
/*  69 */     return map;
/*     */   }
/*     */   
/*     */   public JIRAProjectBean getClone() {
/*  73 */     return new JIRAProjectBean(this);
/*     */   }
/*     */   
/*     */   public String getKey() {
/*  77 */     return this.key;
/*     */   }
/*     */   
/*     */   public String getUrl() {
/*  81 */     return this.url;
/*     */   }
/*     */   
/*     */   public long getId() {
/*  85 */     return this.id;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  89 */     return this.description;
/*     */   }
/*     */   
/*     */   public String getLead() {
/*  93 */     return this.lead;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getQueryStringFragment() {
/*  98 */     return "pid=" + this.id;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 102 */     this.name = name;
/*     */   }
/*     */   
/*     */   public void setKey(String key) {
/* 106 */     this.key = key;
/*     */   }
/*     */   
/*     */   public void setUrl(String url) {
/* 110 */     this.url = url;
/*     */   }
/*     */   
/*     */   public void setId(long id) {
/* 114 */     this.id = id;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 118 */     this.description = description;
/*     */   }
/*     */   
/*     */   public void setLead(String lead) {
/* 122 */     this.lead = lead;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\JIRAProjectBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */