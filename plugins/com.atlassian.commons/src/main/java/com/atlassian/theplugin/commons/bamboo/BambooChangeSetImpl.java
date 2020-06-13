/*    */ package com.atlassian.theplugin.commons.bamboo;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.BambooFileInfo;
/*    */ import com.atlassian.theplugin.commons.VirtualFileSystem;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
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
/*    */ public class BambooChangeSetImpl
/*    */   implements BambooChangeSet
/*    */ {
/*    */   private String author;
/*    */   private Date commitDate;
/*    */   private String comment;
/* 34 */   private List<BambooFileInfo> files = new ArrayList<BambooFileInfo>();
/*    */   private VirtualFileSystem virtualFileSystem;
/*    */   
/*    */   public String getAuthor() {
/* 38 */     return this.author;
/*    */   }
/*    */   
/*    */   public void setAuthor(String author) {
/* 42 */     this.author = author;
/*    */   }
/*    */   
/*    */   public String getComment() {
/* 46 */     return this.comment;
/*    */   }
/*    */   
/*    */   public void setComment(String comment) {
/* 50 */     this.comment = comment;
/*    */   }
/*    */   
/*    */   public Date getCommitDate() {
/* 54 */     return new Date(this.commitDate.getTime());
/*    */   }
/*    */   
/*    */   public void setCommitDate(Date commitDate) {
/* 58 */     this.commitDate = new Date(commitDate.getTime());
/*    */   }
/*    */   
/*    */   public List<BambooFileInfo> getFiles() {
/* 62 */     return this.files;
/*    */   }
/*    */   
/*    */   public void addCommitFile(BambooFileInfo file) {
/* 66 */     this.files.add(file);
/*    */   }
/*    */   
/*    */   public VirtualFileSystem getVirtualFileSystem() {
/* 70 */     if (this.virtualFileSystem == null) {
/* 71 */       this.virtualFileSystem = new VirtualFileSystem();
/*    */     }
/* 73 */     return this.virtualFileSystem;
/*    */   }
/*    */   
/*    */   public void setVirtualFileSystem(VirtualFileSystem virtualFileSystem) {
/* 77 */     this.virtualFileSystem = virtualFileSystem;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BambooChangeSetImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */