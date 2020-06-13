/*     */ package com.atlassian.theplugin.commons.ssl;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.configuration.GeneralConfigurationBean;
/*     */ import com.atlassian.theplugin.commons.remoteapi.rest.AbstractHttpSession;
/*     */ import java.awt.EventQueue;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.security.KeyStore;
/*     */ import java.security.KeyStoreException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.CertificateExpiredException;
/*     */ import java.security.cert.CertificateNotYetValidException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
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
/*     */ public class ConnectorTrustManager
/*     */   implements X509TrustManager
/*     */ {
/*  39 */   private static final Collection<String> ALREADY_REJECTED_CERTS = new HashSet<String>();
/*     */   
/*  41 */   private static Collection<String> temporarilyAcceptedCerts = Collections.synchronizedCollection(new HashSet<String>());
/*     */   
/*     */   private final GeneralConfigurationBean configuration;
/*     */   
/*     */   private CertMessageDialog certMessageDialog;
/*     */   private X509TrustManager standardTrustManager;
/*  47 */   private static ThreadLocal<String> url = new ThreadLocal<String>();
/*     */ 
/*     */   
/*     */   public static String getUrl() {
/*  51 */     return url.get();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ConnectorTrustManager(GeneralConfigurationBean configuration, CertMessageDialog certMessageDialog, KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
/*  57 */     this.configuration = configuration;
/*  58 */     this.certMessageDialog = certMessageDialog;
/*     */     
/*  60 */     TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
/*  61 */     factory.init(keyStore);
/*  62 */     TrustManager[] trustmanagers = factory.getTrustManagers(); byte b;
/*     */     int i;
/*     */     TrustManager[] arrayOfTrustManager1;
/*  65 */     for (i = (arrayOfTrustManager1 = trustmanagers).length, b = 0; b < i; ) { TrustManager trustmanager = arrayOfTrustManager1[b];
/*  66 */       if (trustmanager instanceof X509TrustManager) {
/*  67 */         this.standardTrustManager = (X509TrustManager)trustmanager;
/*     */         return;
/*     */       } 
/*     */       b++; }
/*     */     
/*  72 */     if (this.standardTrustManager == null) {
/*  73 */       throw new NoSuchAlgorithmException("cannot retrieve default trust manager found");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
/*  81 */     this.standardTrustManager.checkClientTrusted(chain, authType);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isSelfSigned(X509Certificate certificate) {
/*  86 */     return certificate.getSubjectDN().equals(certificate.getIssuerDN());
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkServerTrusted(final X509Certificate[] chain, String authType) throws CertificateException {
/*     */     try {
/*  92 */       this.standardTrustManager.checkServerTrusted(chain, authType);
/*     */     }
/*  94 */     catch (CertificateException e) {
/*  95 */       synchronized (ConnectorTrustManager.class) {
/*  96 */         String strCert = chain[0].toString();
/*  97 */         if (ALREADY_REJECTED_CERTS.contains(strCert)) {
/*  98 */           throw e;
/*     */         }
/*     */         
/* 101 */         if (!checkChain(chain, this.configuration.getCerts())) {
/*     */           
/* 103 */           if (checkChain(chain, temporarilyAcceptedCerts)) {
/*     */             return;
/*     */           }
/*     */           
/* 107 */           String message = e.getMessage();
/* 108 */           message = message.substring(message.lastIndexOf(":") + 1);
/* 109 */           if (isSelfSigned(chain[0])) {
/* 110 */             message = "Self-signed certificate";
/*     */           }
/*     */           try {
/* 113 */             chain[0].checkValidity();
/* 114 */           } catch (CertificateExpiredException certificateExpiredException) {
/* 115 */             message = "Certificate expired";
/* 116 */           } catch (CertificateNotYetValidException certificateNotYetValidException) {
/* 117 */             message = "Certificate not yet valid";
/*     */           } 
/* 119 */           final String server = AbstractHttpSession.getUrl().getHost();
/*     */ 
/*     */           
/* 122 */           final int[] accepted = new int[1];
/*     */           
/*     */           try {
/* 125 */             final String message1 = message;
/* 126 */             EventQueue.invokeAndWait(new Runnable() {
/*     */                   public void run() {
/* 128 */                     if (ConnectorTrustManager.this.certMessageDialog != null) {
/* 129 */                       ConnectorTrustManager.this.certMessageDialog.show(server, message1, chain);
/* 130 */                       if (ConnectorTrustManager.this.certMessageDialog.isOK()) {
/* 131 */                         if (ConnectorTrustManager.this.certMessageDialog.isTemporarily()) {
/* 132 */                           accepted[0] = 1;
/*     */                           return;
/*     */                         } 
/* 135 */                         accepted[0] = 2;
/*     */                       } 
/*     */                     } 
/*     */                   }
/*     */                 });
/* 140 */           } catch (InterruptedException interruptedException) {
/*     */           
/* 142 */           } catch (InvocationTargetException invocationTargetException) {}
/*     */ 
/*     */ 
/*     */           
/* 146 */           switch (accepted[0]) {
/*     */             case 1:
/* 148 */               temporarilyAcceptedCerts.add(strCert);
/*     */               break;
/*     */             case 2:
/* 151 */               synchronized (this.configuration) {
/*     */                 
/* 153 */                 this.configuration.addCert(strCert);
/*     */               } 
/*     */               break;
/*     */             default:
/* 157 */               synchronized (ALREADY_REJECTED_CERTS) {
/* 158 */                 ALREADY_REJECTED_CERTS.add(strCert);
/*     */               } 
/* 160 */               throw e;
/*     */           } 
/*     */           return;
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     }  } private boolean checkChain(X509Certificate[] chain, Collection<String> certs) {
/*     */     byte b;
/*     */     int i;
/*     */     X509Certificate[] arrayOfX509Certificate;
/* 170 */     for (i = (arrayOfX509Certificate = chain).length, b = 0; b < i; ) { X509Certificate cert = arrayOfX509Certificate[b];
/* 171 */       if (certs.contains(cert.toString()))
/* 172 */         return true; 
/*     */       b++; }
/*     */     
/* 175 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public X509Certificate[] getAcceptedIssuers() {
/* 180 */     return this.standardTrustManager.getAcceptedIssuers();
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\ssl\ConnectorTrustManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */