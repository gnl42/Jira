/*    */ package com.atlassian.theplugin.commons.bamboo;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BambooJobImpl
/*    */   implements BambooJob
/*    */ {
/*    */   private final String key;
/*    */   private final String shortKey;
/*    */   private final String name;
/*    */   private final String shortName;
/*    */   private boolean enabled;
/*    */   private final List<TestDetails> successfulTests;
/*    */   private final List<TestDetails> failedTests;
/*    */   
/*    */   public BambooJobImpl(String key, String shortKey, String name, String shortName) {
/* 35 */     this.key = key;
/* 36 */     this.shortKey = shortKey;
/* 37 */     this.name = name;
/* 38 */     this.shortName = shortName;
/*    */     
/* 40 */     this.successfulTests = new ArrayList<TestDetails>();
/* 41 */     this.failedTests = new ArrayList<TestDetails>();
/*    */   }
/*    */   
/*    */   public void addFailedTest(TestDetailsInfo tInfo) {
/* 45 */     getFailedTests().add(tInfo);
/*    */   }
/*    */   
/*    */   public void addSuccessfulTest(TestDetailsInfo tInfo) {
/* 49 */     getSuccessfulTests().add(tInfo);
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 53 */     return this.key;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getShortKey() {
/* 59 */     return (this.shortKey != null && this.shortKey.length() > 0) ? this.shortKey : StringUtils.substringAfterLast(this.key, "-");
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 63 */     return this.enabled;
/*    */   }
/*    */   
/*    */   public List<TestDetails> getSuccessfulTests() {
/* 67 */     return this.successfulTests;
/*    */   }
/*    */   
/*    */   public List<TestDetails> getFailedTests() {
/* 71 */     return this.failedTests;
/*    */   }
/*    */   
/*    */   public void setEnabled(boolean enabled) {
/* 75 */     this.enabled = enabled;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 79 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getShortName() {
/* 83 */     return this.shortName;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BambooJobImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */