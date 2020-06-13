/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.cfg.ServerId;
/*    */ import com.atlassian.theplugin.commons.cfg.ServerIdImpl;
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
/*    */ public class ReviewRecentlyOpenBean
/*    */ {
/*    */   private ServerIdImpl serverId;
/*    */   private String reviewId;
/*    */   
/*    */   public ReviewRecentlyOpenBean() {}
/*    */   
/*    */   public ReviewRecentlyOpenBean(ServerId serverId, String reviewId) {
/* 32 */     if (serverId instanceof ServerIdImpl) {
/* 33 */       this.serverId = (ServerIdImpl)serverId;
/*    */     }
/* 35 */     this.reviewId = reviewId;
/*    */   }
/*    */   
/*    */   public ServerIdImpl getServerId() {
/* 39 */     return this.serverId;
/*    */   }
/*    */   
/*    */   public void setServerId(ServerIdImpl serverId) {
/* 43 */     this.serverId = serverId;
/*    */   }
/*    */   
/*    */   public String getReviewId() {
/* 47 */     return this.reviewId;
/*    */   }
/*    */   
/*    */   public void setReviewId(String reviewId) {
/* 51 */     this.reviewId = reviewId;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o) {
/* 55 */     if (this == o) {
/* 56 */       return true;
/*    */     }
/* 58 */     if (o == null || getClass() != o.getClass()) {
/* 59 */       return false;
/*    */     }
/*    */     
/* 62 */     ReviewRecentlyOpenBean that = (ReviewRecentlyOpenBean)o;
/*    */     
/* 64 */     if ((this.reviewId != null) ? !this.reviewId.equals(that.reviewId) : (that.reviewId != null)) {
/* 65 */       return false;
/*    */     }
/* 67 */     if ((this.serverId != null) ? !this.serverId.equals((ServerId)that.serverId) : (that.serverId != null)) {
/* 68 */       return false;
/*    */     }
/*    */     
/* 71 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 76 */     int result = (this.serverId != null) ? this.serverId.hashCode() : 0;
/* 77 */     result = 31 * result + ((this.reviewId != null) ? this.reviewId.hashCode() : 0);
/* 78 */     return result;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\ReviewRecentlyOpenBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */