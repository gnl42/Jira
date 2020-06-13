/*     */ package com.atlassian.theplugin.commons.thirdparty.apache;
/*     */ 
/*     */ import java.security.KeyStore;
/*     */ import java.security.KeyStoreException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.CertificateExpiredException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import javax.net.ssl.TrustManager;
/*     */ import javax.net.ssl.TrustManagerFactory;
/*     */ import javax.net.ssl.X509TrustManager;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EasyX509TrustManager
/*     */   implements X509TrustManager
/*     */ {
/*  58 */   private X509TrustManager standardTrustManager = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EasyX509TrustManager(KeyStore keystore) throws NoSuchAlgorithmException, KeyStoreException {
/*  68 */     TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
/*  69 */     factory.init(keystore);
/*  70 */     TrustManager[] trustmanagers = factory.getTrustManagers();
/*  71 */     if (trustmanagers.length == 0) {
/*  72 */       throw new NoSuchAlgorithmException("no trust manager found");
/*     */     }
/*  74 */     this.standardTrustManager = (X509TrustManager)trustmanagers[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkClientTrusted(X509Certificate[] certificates, String authType) throws CertificateException {
/*  81 */     this.standardTrustManager.checkClientTrusted(certificates, authType);
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
/*     */   public void checkServerTrusted(X509Certificate[] certificates, String authType) throws CertificateException {
/*     */     try {
/*  95 */       if (certificates != null && certificates.length == 1) {
/*  96 */         certificates[0].checkValidity();
/*     */       } else {
/*  98 */         this.standardTrustManager.checkServerTrusted(certificates, authType);
/*     */       } 
/* 100 */     } catch (CertificateExpiredException e) {
/* 101 */       e.printStackTrace();
/* 102 */       throw e;
/* 103 */     } catch (CertificateException e) {
/* 104 */       e.printStackTrace();
/* 105 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public X509Certificate[] getAcceptedIssuers() {
/* 113 */     return this.standardTrustManager.getAcceptedIssuers();
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\thirdparty\apache\EasyX509TrustManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */