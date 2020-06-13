/*    */ package com.atlassian.theplugin.commons.fisheye.api.model.changeset;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.util.MiscUtil;
/*    */ import java.util.List;
/*    */ import org.jetbrains.annotations.NotNull;
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
/*    */ public final class ChangesetIdList
/*    */ {
/*    */   private final List<String> csids;
/*    */   
/*    */   public ChangesetIdList(@NotNull List<String> csids) {
/* 23 */     this.csids = MiscUtil.buildArrayList(csids);
/*    */   }
/*    */   
/*    */   public List<String> getCsids() {
/* 27 */     return this.csids;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\fisheye\api\model\changeset\ChangesetIdList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */