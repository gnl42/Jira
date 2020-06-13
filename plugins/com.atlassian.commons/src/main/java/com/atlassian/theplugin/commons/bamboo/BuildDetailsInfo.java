/*     */ package com.atlassian.theplugin.commons.bamboo;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.util.MiscUtil;
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
/*     */ public class BuildDetailsInfo
/*     */   implements BuildDetails
/*     */ {
/*  31 */   private List<TestDetails> successfulTests = new ArrayList<TestDetails>();
/*  32 */   private List<TestDetails> failedTests = new ArrayList<TestDetails>();
/*  33 */   private final List<BambooJob> jobs = new ArrayList<BambooJob>();
/*  34 */   private List<BambooChangeSet> commitInfo = new ArrayList<BambooChangeSet>();
/*     */   private String vcsRevisionKey;
/*     */   
/*     */   public String getVcsRevisionKey() {
/*  38 */     return this.vcsRevisionKey;
/*     */   }
/*     */   
/*     */   public void setVcsRevisionKey(String vcsRevisionKey) {
/*  42 */     this.vcsRevisionKey = vcsRevisionKey;
/*     */   }
/*     */   
/*     */   public List<TestDetails> getSuccessfulTestDetails() {
/*  46 */     return this.successfulTests;
/*     */   }
/*     */   
/*     */   public void setSuccessfulTests(List<TestDetails> successfulTests) {
/*  50 */     this.successfulTests = successfulTests;
/*     */   }
/*     */   
/*     */   public void addSuccessfulTest(TestDetails test) {
/*  54 */     this.successfulTests.add(test);
/*     */   }
/*     */   
/*     */   public List<TestDetails> getFailedTestDetails() {
/*  58 */     return this.failedTests;
/*     */   }
/*     */   
/*     */   public void setFailedTests(List<TestDetails> failedTests) {
/*  62 */     this.failedTests = failedTests;
/*     */   }
/*     */   
/*     */   public void addFailedTest(TestDetails test) {
/*  66 */     this.failedTests.add(test);
/*     */   }
/*     */   
/*     */   public List<BambooChangeSet> getCommitInfo() {
/*  70 */     return this.commitInfo;
/*     */   }
/*     */   
/*     */   public void setCommitInfo(List<BambooChangeSet> commitInfo) {
/*  74 */     this.commitInfo = commitInfo;
/*     */   }
/*     */   
/*     */   public void addCommitInfo(BambooChangeSetImpl commit) {
/*  78 */     this.commitInfo.add(commit);
/*     */   }
/*     */   
/*     */   public void addJob(BambooJob job) {
/*  82 */     this.jobs.add(job);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BambooJob> getJobs() {
/*  89 */     return this.jobs;
/*     */   }
/*     */   
/*     */   public List<BambooJob> getEnabledJobs() {
/*  93 */     List<BambooJob> enabledJobs = MiscUtil.buildArrayList();
/*     */     
/*  95 */     for (BambooJob job : this.jobs) {
/*  96 */       if (job.isEnabled()) {
/*  97 */         enabledJobs.add(job);
/*     */       }
/*     */     } 
/*     */     
/* 101 */     return enabledJobs;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BuildDetailsInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */