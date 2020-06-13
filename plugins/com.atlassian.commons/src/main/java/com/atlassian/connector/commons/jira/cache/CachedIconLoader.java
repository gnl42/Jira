/*    */ package com.atlassian.connector.commons.jira.cache;
/*    */ 
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.swing.GrayFilter;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.ImageIcon;
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
/*    */ public final class CachedIconLoader
/*    */ {
/* 26 */   private static Map<String, Icon> icons = new HashMap<String, Icon>();
/* 27 */   private static Map<String, Icon> disabledIcons = new HashMap<String, Icon>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Icon getDisabledIcon(String urlString) {
/* 33 */     return disabledIcons.get(urlString);
/*    */   }
/*    */   
/*    */   private static void addDisabledIcon(String urlString, Icon icon) {
/* 37 */     disabledIcons.put(urlString, icon);
/*    */   }
/*    */   
/*    */   private static Icon generateDisabledIcon(Icon icon) {
/* 41 */     return new ImageIcon(GrayFilter.createDisabledImage(((ImageIcon)icon).getImage()));
/*    */   }
/*    */   
/*    */   private static void maybeGenerateDisabledIcon(String urlString, Icon icon) {
/* 45 */     if (disabledIcons.containsKey(urlString) || icon == null) {
/*    */       return;
/*    */     }
/* 48 */     addDisabledIcon(urlString, generateDisabledIcon(icon));
/*    */   }
/*    */   
/*    */   public static Icon getIcon(URL url) {
/* 52 */     if (url != null) {
/* 53 */       String key = url.toString();
/* 54 */       if (!icons.containsKey(key)) {
/* 55 */         Icon i = new ImageIcon(url);
/* 56 */         icons.put(key, i);
/* 57 */         maybeGenerateDisabledIcon(key, i);
/*    */       } 
/* 59 */       return icons.get(key);
/*    */     } 
/* 61 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public static Icon getIcon(String urlString) {
/* 66 */     if (urlString != null) {
/* 67 */       if (!icons.containsKey(urlString)) {
/* 68 */         loadIcon(urlString);
/*    */       }
/* 70 */       return icons.get(urlString);
/*    */     } 
/* 72 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void loadIcon(String urlString) {
/* 77 */     if (urlString != null && !icons.containsKey(urlString))
/*    */       
/*    */       try {
/* 80 */         URL url = new URL(urlString);
/* 81 */         Icon i = new ImageIcon(url);
/* 82 */         icons.put(urlString, i);
/* 83 */         maybeGenerateDisabledIcon(urlString, i);
/* 84 */       } catch (MalformedURLException malformedURLException) {} 
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\cache\CachedIconLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */