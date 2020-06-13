/*    */ package com.atlassian.theplugin.commons.fisheye.api.model;
/*    */ 
/*    */ import org.jdom.Element;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FisheyePathHistoryItem
/*    */ {
/*    */   private String path;
/*    */   private String rev;
/*    */   private String ancestor;
/*    */   private String author;
/*    */   
/*    */   public FisheyePathHistoryItem(Element element) {
/* 20 */     this.rev = element.getAttributeValue("rev");
/* 21 */     this.ancestor = element.getAttributeValue("ancestor");
/* 22 */     this.path = element.getAttributeValue("path");
/* 23 */     this.author = element.getAttributeValue("author");
/*    */   }
/*    */   
/*    */   public String getPath() {
/* 27 */     return this.path;
/*    */   }
/*    */   
/*    */   public String getRev() {
/* 31 */     return this.rev;
/*    */   }
/*    */   
/*    */   public String getAncestor() {
/* 35 */     return this.ancestor;
/*    */   }
/*    */   
/*    */   public String getAuthor() {
/* 39 */     return this.author;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\fisheye\api\model\FisheyePathHistoryItem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */