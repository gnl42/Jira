/*     */ package com.atlassian.theplugin.commons.thirdparty.apache;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.security.KeyStore;
/*     */ import java.security.KeyStoreException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.SecureRandom;
/*     */ import java.security.UnrecoverableKeyException;
/*     */ import java.security.cert.CertificateException;
/*     */ import javax.net.SocketFactory;
/*     */ import javax.net.ssl.KeyManagerFactory;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.TrustManager;
/*     */ import javax.net.ssl.TrustManagerFactory;
/*     */ import javax.net.ssl.X509TrustManager;
/*     */ import org.apache.commons.httpclient.ConnectTimeoutException;
/*     */ import org.apache.commons.httpclient.HttpClientError;
/*     */ import org.apache.commons.httpclient.params.HttpConnectionParams;
/*     */ import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;
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
/*     */ public class EasySSLProtocolSocketFactory
/*     */   implements SecureProtocolSocketFactory
/*     */ {
/*     */   public static final int SSL_PORT = 443;
/* 109 */   private SSLContext sslcontext = null;
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
/*     */   private SSLContext createEasySSLContext() {
/* 122 */     KeyManagerFactory kmf = null;
/*     */ 
/*     */     
/* 125 */     try { KeyStore keyStore = getKeyStore();
/* 126 */       String p = System.getProperty("javax.net.ssl.keyStorePassword");
/* 127 */       if (keyStore != null && p != null) {
/* 128 */         kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
/* 129 */         kmf.init(keyStore, p.toCharArray());
/* 130 */         TrustManagerFactory tmf = 
/* 131 */           TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
/* 132 */         tmf.init(keyStore);
/*     */       }
/*     */        }
/* 135 */     catch (KeyStoreException keyStoreException) {  }
/* 136 */     catch (NoSuchAlgorithmException noSuchAlgorithmException) {  }
/* 137 */     catch (UnrecoverableKeyException unrecoverableKeyException) {}
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 142 */       SSLContext context = SSLContext.getInstance("SSL");
/*     */       
/* 144 */       context.init(
/* 145 */           (kmf != null) ? kmf.getKeyManagers() : null, 
/* 146 */           new TrustManager[] { getTrustManager()
/* 147 */           }, (kmf != null) ? new SecureRandom() : null);
/* 148 */       return context;
/* 149 */     } catch (Exception e) {
/*     */       
/* 151 */       throw new HttpClientError(e.toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   public static KeyStore getKeyStore() {
/* 156 */     KeyStore keyJKSStore = getKeyJKSStore(System.getProperty("javax.net.ssl.keyStore"), System.getProperty("javax.net.ssl.keyStorePassword"));
/* 157 */     KeyStore trust = getKeyJKSStore(System.getProperty("javax.net.ssl.trustStore"), System.getProperty("javax.net.ssl.trustStorePassword"));
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
/*     */     try {
/* 169 */       if (trust != null && keyJKSStore != null && trust.size() > 0 && keyJKSStore.size() > 0) {
/*     */         try {
/* 171 */           while (trust.aliases().hasMoreElements()) {
/* 172 */             String alias = trust.aliases().nextElement();
/* 173 */             keyJKSStore.setCertificateEntry(alias, trust.getCertificate(alias));
/* 174 */             trust.deleteEntry(alias);
/*     */           } 
/* 176 */         } catch (KeyStoreException keyStoreException) {}
/*     */       
/*     */       }
/*     */     }
/* 180 */     catch (KeyStoreException e) {
/* 181 */       e.printStackTrace();
/*     */     } 
/* 183 */     return keyJKSStore;
/*     */   }
/*     */ 
/*     */   
/*     */   private static KeyStore getKeyJKSStore(String keyStoreFileName, String keyStorePassword) {
/* 188 */     KeyStore jKeyStore = null;
/*     */ 
/*     */ 
/*     */     
/* 192 */     try { if (keyStorePassword != null && keyStorePassword.length() > 0 && 
/* 193 */         keyStoreFileName != null && keyStoreFileName.length() > 0) {
/* 194 */         jKeyStore = KeyStore.getInstance("JKS");
/* 195 */         File file = new File(keyStoreFileName);
/* 196 */         FileInputStream inStream = new FileInputStream(file);
/* 197 */         jKeyStore.load(inStream, keyStorePassword.toCharArray());
/*     */       }
/*     */        }
/* 200 */     catch (KeyStoreException keyStoreException) {  }
/* 201 */     catch (FileNotFoundException fileNotFoundException) {  }
/* 202 */     catch (CertificateException certificateException) {  }
/* 203 */     catch (NoSuchAlgorithmException noSuchAlgorithmException) {  }
/* 204 */     catch (IOException iOException) {}
/*     */ 
/*     */     
/* 207 */     return jKeyStore;
/*     */   }
/*     */   
/*     */   protected X509TrustManager getTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
/* 211 */     return new EasyX509TrustManager(getKeyStore());
/*     */   }
/*     */   
/*     */   private SSLContext getSSLContext() {
/* 215 */     if (this.sslcontext == null) {
/* 216 */       this.sslcontext = createEasySSLContext();
/*     */     }
/* 218 */     return this.sslcontext;
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
/*     */   public Socket createSocket(String host, int port, InetAddress clientHost, int clientPort) throws IOException, UnknownHostException {
/* 231 */     return getSSLContext().getSocketFactory().createSocket(
/* 232 */         host, 
/* 233 */         port, 
/* 234 */         clientHost, 
/* 235 */         clientPort);
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
/*     */   public Socket createSocket(String host, int port, InetAddress localAddress, int localPort, HttpConnectionParams params) throws IOException, UnknownHostException, ConnectTimeoutException {
/* 263 */     if (params == null) {
/* 264 */       throw new IllegalArgumentException("Parameters may not be null");
/*     */     }
/* 266 */     int timeout = params.getConnectionTimeout();
/* 267 */     SocketFactory socketfactory = getSSLContext().getSocketFactory();
/* 268 */     if (timeout == 0) {
/* 269 */       return socketfactory.createSocket(host, port, localAddress, localPort);
/*     */     }
/*     */     
/* 272 */     Socket socket = socketfactory.createSocket();
/* 273 */     SocketAddress localaddr = new InetSocketAddress(localAddress, localPort);
/* 274 */     SocketAddress remoteaddr = new InetSocketAddress(host, port);
/* 275 */     socket.bind(localaddr);
/* 276 */     socket.connect(remoteaddr, timeout);
/* 277 */     return socket;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
/* 286 */     return getSSLContext().getSocketFactory().createSocket(
/* 287 */         host, 
/* 288 */         port);
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
/*     */   public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException {
/* 301 */     return getSSLContext().getSocketFactory().createSocket(
/* 302 */         socket, 
/* 303 */         host, 
/* 304 */         port, 
/* 305 */         autoClose);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 310 */     return (obj != null && obj.getClass().equals(EasySSLProtocolSocketFactory.class));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 314 */     return EasySSLProtocolSocketFactory.class.hashCode();
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\thirdparty\apache\EasySSLProtocolSocketFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */