/*    */ package com.atlassian.theplugin.commons.cfg;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.configuration.BambooTooltipOption;
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
/*    */ public class BambooCfg
/*    */ {
/*    */   private BambooTooltipOption bambooTooltipOption;
/* 22 */   private int pollTime = 1;
/*    */   
/*    */   public BambooTooltipOption getBambooTooltipOption() {
/* 25 */     return this.bambooTooltipOption;
/*    */   }
/*    */   
/*    */   public void setBambooTooltipOption(BambooTooltipOption bambooTooltipOption) {
/* 29 */     this.bambooTooltipOption = bambooTooltipOption;
/*    */   }
/*    */   
/*    */   public int getPollTime() {
/* 33 */     return this.pollTime;
/*    */   }
/*    */   
/*    */   public void setPollTime(int pollTime) {
/* 37 */     this.pollTime = pollTime;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\BambooCfg.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */