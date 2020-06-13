/*    */ package com.atlassian.theplugin.commons.bamboo;
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
/*    */ public class TestDetailsInfo
/*    */   implements TestDetails
/*    */ {
/*    */   private String testClassName;
/*    */   private String testMethodName;
/*    */   private double testDuration;
/*    */   private TestResult testResult;
/*    */   private String testErrors;
/*    */   
/*    */   public String getTestClassName() {
/* 28 */     return this.testClassName;
/*    */   }
/*    */   
/*    */   public String getTestMethodName() {
/* 32 */     return this.testMethodName;
/*    */   }
/*    */   
/*    */   public double getTestDuration() {
/* 36 */     return this.testDuration;
/*    */   }
/*    */   
/*    */   public TestResult getTestResult() {
/* 40 */     return this.testResult;
/*    */   }
/*    */   
/*    */   public String getErrors() {
/* 44 */     return this.testErrors;
/*    */   }
/*    */   
/*    */   public void setTestClassName(String testClassName) {
/* 48 */     this.testClassName = testClassName;
/*    */   }
/*    */   
/*    */   public void setTestDuration(double testDuration) {
/* 52 */     this.testDuration = testDuration;
/*    */   }
/*    */   
/*    */   public void setTestErrors(String testErrors) {
/* 56 */     this.testErrors = testErrors;
/*    */   }
/*    */   
/*    */   public void setTestMethodName(String testMethodName) {
/* 60 */     this.testMethodName = testMethodName;
/*    */   }
/*    */   
/*    */   public void setTestResult(TestResult testResult) {
/* 64 */     this.testResult = testResult;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\TestDetailsInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */