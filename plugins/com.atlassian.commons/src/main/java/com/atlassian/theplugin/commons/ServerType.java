/*    */ package com.atlassian.theplugin.commons;
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
/*    */ 
/*    */ 
/*    */ public enum ServerType
/*    */ {
/* 23 */   BAMBOO_SERVER("Bamboo Servers", "Bamboo", "http://www.atlassian.com/software/bamboo/"),
/* 24 */   CRUCIBLE_SERVER("Crucible/FishEye Servers", "Crucible/FishEye", "http://www.atlassian.com/software/crucible/"),
/* 25 */   JIRA_SERVER("JIRA Servers", "JIRA", "http://www.atlassian.com/software/jira/"),
/* 26 */   FISHEYE_SERVER("FishEye Servers", "FishEye", "http://www.atlassian.com/software/fisheye/"),
/* 27 */   JIRA_STUDIO_SERVER("JIRA Studio Servers", "JIRA Studio", "http://www.atlassian.com/studio/", true);
/*    */ 
/*    */   
/*    */   private final String name;
/*    */   
/*    */   private String shortName;
/*    */   
/*    */   private final String infoUrl;
/*    */   
/*    */   private boolean pseudoServer;
/*    */ 
/*    */   
/*    */   ServerType(String name, String shortName, String infoUrl, boolean pseudoServer) {
/* 40 */     this.name = name;
/* 41 */     this.shortName = shortName;
/* 42 */     this.infoUrl = infoUrl;
/* 43 */     this.pseudoServer = pseudoServer;
/*    */   }
/*    */   
/*    */   public String getShortName() {
/* 47 */     return this.shortName;
/*    */   }
/*    */   
/*    */   public String getInfoUrl() {
/* 51 */     return this.infoUrl;
/*    */   }
/*    */   
/*    */   public boolean isPseudoServer() {
/* 55 */     return this.pseudoServer;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 60 */     return this.name;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\ServerType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */