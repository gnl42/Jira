/*    */ package com.atlassian.connector.commons.jira.beans;
/*    */ 
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public abstract class AbstractJIRAConstantBean
/*    */   implements JIRAConstant
/*    */ {
/*    */   protected String name;
/*    */   protected long id;
/* 27 */   protected URL iconUrl = null;
/*    */ 
/*    */   
/*    */   public AbstractJIRAConstantBean() {}
/*    */   
/*    */   protected AbstractJIRAConstantBean(long id, String name, URL iconUrl) {
/* 33 */     this.id = id;
/* 34 */     this.name = name;
/* 35 */     this.iconUrl = iconUrl;
/*    */   }
/*    */   
/*    */   public AbstractJIRAConstantBean(Map<String, String> map) {
/* 39 */     this.name = map.get("name");
/* 40 */     this.id = Long.valueOf(map.get("id")).longValue();
/*    */     
/* 42 */     if (map.containsKey("icon")) {
/*    */       try {
/* 44 */         this.iconUrl = new URL(map.get("icon"));
/* 45 */       } catch (MalformedURLException e) {
/* 46 */         e.printStackTrace();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   public HashMap<String, String> getMap() {
/* 52 */     HashMap<String, String> map = new HashMap<String, String>();
/* 53 */     map.put("name", getName());
/* 54 */     map.put("id", Long.toString(this.id));
/* 55 */     if (this.iconUrl != null) {
/* 56 */       map.put("icon", this.iconUrl.toString());
/*    */     }
/* 58 */     map.put("filterTypeClass", getClass().getName());
/* 59 */     return map;
/*    */   }
/*    */   
/*    */   public long getId() {
/* 63 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 67 */     return this.name;
/*    */   }
/*    */   
/*    */   public URL getIconUrl() {
/* 71 */     return this.iconUrl;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o) {
/* 75 */     if (this == o) {
/* 76 */       return true;
/*    */     }
/* 78 */     if (o == null || !(o instanceof AbstractJIRAConstantBean)) {
/* 79 */       return false;
/*    */     }
/*    */     
/* 82 */     AbstractJIRAConstantBean that = (AbstractJIRAConstantBean)o;
/*    */     
/* 84 */     if (this.id != that.id) {
/* 85 */       return false;
/*    */     }
/* 87 */     if ((this.name != null) ? !this.name.equals(that.name) : (that.name != null)) {
/* 88 */       return false;
/*    */     }
/*    */     
/* 91 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 96 */     int result = (this.name != null) ? this.name.hashCode() : 0;
/* 97 */     result = 31 * result + (int)(this.id ^ this.id >>> 32L);
/* 98 */     return result;
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\beans\AbstractJIRAConstantBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */