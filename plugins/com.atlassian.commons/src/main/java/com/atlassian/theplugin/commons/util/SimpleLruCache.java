/*     */ package com.atlassian.theplugin.commons.util;
/*     */ 
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleLruCache<K, V>
/*     */ {
/*     */   private static final float LOAD_FACTOR = 0.75F;
/*     */   private final int cacheSize;
/*     */   protected final LinkedHashMap<K, V> map;
/*     */   
/*     */   public SimpleLruCache(int cacheSize) {
/*  49 */     this.cacheSize = cacheSize;
/*  50 */     int capacity = (int)Math.ceil((cacheSize / 0.75F)) + 1;
/*  51 */     this.map = new LinkedHashMap<K, V>(capacity, 0.75F, true)
/*     */       {
/*     */         protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
/*  54 */           return (size() > SimpleLruCache.this.cacheSize);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized V get(K key) {
/*  67 */     return this.map.get(key);
/*     */   }
/*     */   
/*     */   public synchronized int size() {
/*  71 */     return this.map.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized V put(K key, V value) {
/*  84 */     return this.map.put(key, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int getUsedEntriesCount() {
/*  93 */     return this.map.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LinkedHashMap<K, V> getMap() {
/* 105 */     return this.map;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\common\\util\SimpleLruCache.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */