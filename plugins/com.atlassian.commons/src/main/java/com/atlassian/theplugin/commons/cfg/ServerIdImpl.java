/*    */ package com.atlassian.theplugin.commons.cfg;
/*    */ 
/*    */ import java.util.UUID;
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
/*    */ public class ServerIdImpl
/*    */   implements ServerId
/*    */ {
/* 21 */   private UUID uuid = UUID.randomUUID();
/*    */   
/*    */   public ServerIdImpl() {
/* 24 */     this.uuid = UUID.randomUUID();
/* 25 */     assert this.uuid != null;
/*    */   }
/*    */   
/*    */   public ServerIdImpl(String uuid) {
/* 29 */     this.uuid = UUID.fromString(uuid);
/* 30 */     assert uuid != null;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 34 */     return this.uuid.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setId(String aUuid) {
/* 44 */     this.uuid = UUID.fromString(aUuid);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 49 */     return this.uuid.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 54 */     if (this == o) {
/* 55 */       return true;
/*    */     }
/* 57 */     if (o == null || getClass() != o.getClass()) {
/* 58 */       return false;
/*    */     }
/*    */     
/* 61 */     ServerIdImpl serverId = (ServerIdImpl)o;
/*    */     
/* 63 */     if (!this.uuid.equals(serverId.uuid)) {
/* 64 */       return false;
/*    */     }
/*    */     
/* 67 */     return true;
/*    */   }
/*    */   
/*    */   public boolean equals(ServerId o) {
/* 71 */     return equals(o);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 76 */     return this.uuid.hashCode();
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\ServerIdImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */