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
/*    */ 
/*    */ public class BambooFileInfo
/*    */   implements VersionedFileInfo
/*    */ {
/*    */   private VersionedVirtualFile fileDescriptor;
/*    */   
/*    */   public BambooFileInfo(VersionedVirtualFile fileDescriptor) {
/* 28 */     this.fileDescriptor = fileDescriptor;
/*    */   }
/*    */   
/*    */   public BambooFileInfo(String file, String revision) {
/* 32 */     this(new VersionedVirtualFile(file, revision));
/*    */   }
/*    */   
/*    */   public VersionedVirtualFile getFileDescriptor() {
/* 36 */     return this.fileDescriptor;
/*    */   }
/*    */   
/*    */   public void setFileDescriptor(VersionedVirtualFile fileDescriptor) {
/* 40 */     this.fileDescriptor = fileDescriptor;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\BambooFileInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */