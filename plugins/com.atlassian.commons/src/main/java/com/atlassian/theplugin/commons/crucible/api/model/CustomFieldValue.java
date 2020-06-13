/*    */ package com.atlassian.theplugin.commons.crucible.api.model;
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
/*    */ public class CustomFieldValue
/*    */ {
/*    */   private String name;
/*    */   private Object value;
/*    */   
/*    */   public CustomFieldValue() {}
/*    */   
/*    */   public CustomFieldValue(String name, Object value) {
/* 28 */     this.name = name;
/* 29 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 33 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 37 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Object getValue() {
/* 41 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(Object value) {
/* 45 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\CustomFieldValue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */