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
/*    */ public class CustomFieldBean
/*    */   implements CustomField
/*    */ {
/*    */   private int configVersion;
/*    */   private String value;
/*    */   private static final int HASHCODE_MAGIC = 31;
/*    */   
/*    */   public CustomFieldBean() {}
/*    */   
/*    */   public CustomFieldBean(CustomField field) {
/* 28 */     this.configVersion = field.getConfigVersion();
/* 29 */     this.value = field.getValue();
/*    */   }
/*    */   
/*    */   public int getConfigVersion() {
/* 33 */     return this.configVersion;
/*    */   }
/*    */   
/*    */   public void setConfigVersion(int configVersion) {
/* 37 */     this.configVersion = configVersion;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 41 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(String value) {
/* 45 */     this.value = value;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 50 */     if (this == o) {
/* 51 */       return true;
/*    */     }
/* 53 */     if (o == null || getClass() != o.getClass()) {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     CustomFieldBean that = (CustomFieldBean)o;
/*    */     
/* 59 */     if (this.configVersion != that.configVersion) {
/* 60 */       return false;
/*    */     }
/* 62 */     if ((this.value != null) ? !this.value.equals(that.value) : (that.value != null)) {
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 71 */     int result = this.configVersion;
/* 72 */     result = 31 * result + ((this.value != null) ? this.value.hashCode() : 0);
/* 73 */     return result;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\model\CustomFieldBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */