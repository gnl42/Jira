/*     */ package com.atlassian.theplugin.commons.util;
/*     */ 
/*     */ import java.util.AbstractMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.jetbrains.annotations.Nullable;
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
/*     */ public final class MiscUtil
/*     */ {
/*     */   public static <K, V> HashMap<K, V> buildHashMap() {
/*  37 */     return new HashMap<K, V>();
/*     */   }
/*     */   
/*     */   public static <K, V> AbstractMap<K, V> buildConcurrentHashMap(int initialCapacity) {
/*  41 */     return new ConcurrentHashMap<K, V>(initialCapacity);
/*     */   }
/*     */   
/*     */   public static <T> boolean isModified(@Nullable T a, @Nullable T b) {
/*  45 */     return (a != null) ? (!a.equals(b)) : ((b != null));
/*     */   }
/*     */   
/*     */   public static <T> boolean isEqual(@Nullable T a, @Nullable T b) {
/*  49 */     return (a != null) ? a.equals(b) : ((b == null));
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> Set<T> buildHashSet() {
/*  54 */     return new HashSet<T>();
/*     */   }
/*     */   
/*     */   public static <T> Set<T> buildHashSet(Object... elements) {
/*  58 */     return new HashSet<T>(Arrays.asList((T[])elements));
/*     */   }
/*     */   
/*     */   public static <T> Set<T> buildLinkedHashSet(Object... elements) {
/*  62 */     return new LinkedHashSet<T>(Arrays.asList((T[])elements));
/*     */   }
/*     */   
/*     */   public static <T> TreeSet<T> buildTreeSet(Object... elements) {
/*  66 */     return new TreeSet<T>(Arrays.asList((T[])elements));
/*     */   }
/*     */   
/*     */   public static <T> Set<T> buildLinkedHashSet() {
/*  70 */     return new LinkedHashSet<T>();
/*     */   }
/*     */   
/*     */   public static <T> TreeSet<T> buildTreeSet() {
/*  74 */     return new TreeSet<T>();
/*     */   }
/*     */   
/*     */   public static <T> Set<T> buildHashSet(Collection<T> elements) {
/*  78 */     return new HashSet<T>(elements);
/*     */   }
/*     */   
/*     */   public static <T> TreeSet<T> buildTreeSet(Collection<T> elements) {
/*  82 */     return new TreeSet<T>(elements);
/*     */   }
/*     */   
/*     */   public static <T> ArrayList<T> buildArrayList() {
/*  86 */     return new ArrayList<T>();
/*     */   }
/*     */   
/*     */   public static <T> ArrayList<T> buildArrayList(int initialCapacity) {
/*  90 */     return new ArrayList<T>(initialCapacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> ArrayList<T> buildArrayList(Object... elements) {
/* 100 */     ArrayList<T> tmp = new ArrayList<T>();
/* 101 */     tmp.addAll(Arrays.asList((T[])elements));
/* 102 */     return tmp;
/*     */   }
/*     */   
/*     */   public static <T> ArrayList<T> buildArrayList(Collection<T> collection) {
/* 106 */     return new ArrayList<T>(collection);
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\common\\util\MiscUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */