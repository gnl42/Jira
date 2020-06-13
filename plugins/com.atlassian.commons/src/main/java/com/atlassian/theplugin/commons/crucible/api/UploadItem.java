/*    */ package com.atlassian.theplugin.commons.crucible.api;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UploadItem
/*    */ {
/*    */   public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
/*    */   public static final String DEFAULT_CHARSET = "ISO-8859-1";
/*    */   private final String fileName;
/*    */   private final byte[] oldContent;
/*    */   private final byte[] newContent;
/*    */   private final String oldType;
/*    */   private final String newType;
/*    */   private final String oldCharset;
/*    */   private final String newCharset;
/*    */   
/*    */   public UploadItem(String fileName, byte[] oldContent, byte[] newContent) {
/* 20 */     this(fileName, "application/octet-stream", "ISO-8859-1", oldContent, "application/octet-stream", "ISO-8859-1", newContent);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public UploadItem(String fileName, String oldType, String oldCharset, byte[] oldContent, String newType, String newCharset, byte[] newContent) {
/* 32 */     this.fileName = fileName;
/* 33 */     this.oldType = oldType;
/* 34 */     this.oldContent = oldContent;
/* 35 */     this.oldCharset = oldCharset;
/* 36 */     this.newType = newType;
/* 37 */     this.newContent = newContent;
/* 38 */     this.newCharset = newCharset;
/*    */   }
/*    */   
/*    */   public String getFileName() {
/* 42 */     return this.fileName;
/*    */   }
/*    */   
/*    */   public byte[] getOldContent() {
/* 46 */     return this.oldContent;
/*    */   }
/*    */   
/*    */   public byte[] getNewContent() {
/* 50 */     return this.newContent;
/*    */   }
/*    */   
/*    */   public String getOldContentType() {
/* 54 */     return this.oldType;
/*    */   }
/*    */   
/*    */   public String getNewContentType() {
/* 58 */     return this.newType;
/*    */   }
/*    */   
/*    */   public String getOldCharset() {
/* 62 */     return this.oldCharset;
/*    */   }
/*    */   
/*    */   public String getNewCharset() {
/* 66 */     return this.newCharset;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\UploadItem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */