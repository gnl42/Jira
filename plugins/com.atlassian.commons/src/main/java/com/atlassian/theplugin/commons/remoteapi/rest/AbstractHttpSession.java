/*     */ package com.atlassian.theplugin.commons.remoteapi.rest;
/*     */ 
/*     */ import com.atlassian.connector.commons.api.ConnectionCfg;
/*     */ import com.atlassian.theplugin.commons.exception.HttpProxySettingsException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiMalformedUrlException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.RemoteApiSessionExpiredException;
/*     */ import com.atlassian.theplugin.commons.remoteapi.ServiceUnavailableException;
/*     */ import com.atlassian.theplugin.commons.util.LoggerImpl;
/*     */ import com.atlassian.theplugin.commons.util.UrlUtil;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import org.apache.commons.httpclient.Header;
/*     */ import org.apache.commons.httpclient.HttpClient;
/*     */ import org.apache.commons.httpclient.HttpMethod;
/*     */ import org.apache.commons.httpclient.HttpStatus;
/*     */ import org.apache.commons.httpclient.auth.AuthenticationException;
/*     */ import org.apache.commons.httpclient.methods.DeleteMethod;
/*     */ import org.apache.commons.httpclient.methods.GetMethod;
/*     */ import org.apache.commons.httpclient.methods.PostMethod;
/*     */ import org.apache.commons.httpclient.methods.RequestEntity;
/*     */ import org.apache.commons.httpclient.methods.StringRequestEntity;
/*     */ import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
/*     */ import org.apache.commons.httpclient.methods.multipart.Part;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.JDOMException;
/*     */ import org.jdom.input.SAXBuilder;
/*     */ import org.jdom.output.Format;
/*     */ import org.jdom.output.XMLOutputter;
/*     */ import org.jdom.xpath.XPath;
/*     */ import org.jetbrains.annotations.NotNull;
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
/*     */ public abstract class AbstractHttpSession
/*     */ {
/*     */   @NotNull
/*     */   protected final HttpSessionCallback callback;
/*     */   @NotNull
/*     */   private final ConnectionCfg server;
/*     */   private static final int MAX_REDIRECTS = 3;
/*     */   private String responseCharSet;
/*     */   
/*     */   @NotNull
/*     */   protected ConnectionCfg getServer() {
/*  78 */     return this.server;
/*     */   }
/*     */   
/*     */   protected String getUsername() {
/*  82 */     return this.server.getUsername();
/*     */   }
/*     */   
/*     */   protected String getPassword() {
/*  86 */     return this.server.getPassword();
/*     */   }
/*     */   
/*  89 */   private final Object clientLock = new Object();
/*     */   
/*  91 */   private static ThreadLocal<URL> url = new ThreadLocal<URL>();
/*     */ 
/*     */   
/*  94 */   private final Map<String, CacheRecord> cache = new WeakHashMap<String, CacheRecord>();
/*     */ 
/*     */   
/*     */   private final class CacheRecord
/*     */   {
/*     */     private final byte[] document;
/*     */     
/*     */     private final String lastModified;
/*     */     
/*     */     private final String etag;
/*     */ 
/*     */     
/*     */     private CacheRecord(byte[] document, String lastModified, String etag) {
/* 107 */       if (document == null || lastModified == null || etag == null) {
/* 108 */         throw new IllegalArgumentException("null");
/*     */       }
/* 110 */       this.document = document;
/* 111 */       this.lastModified = lastModified;
/* 112 */       this.etag = etag;
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] getDocument() {
/* 117 */       return this.document;
/*     */     }
/*     */     
/*     */     public String getLastModified() {
/* 121 */       return this.lastModified;
/*     */     }
/*     */     
/*     */     public String getEtag() {
/* 125 */       return this.etag;
/*     */     }
/*     */   }
/*     */   
/*     */   public static URL getUrl() {
/* 130 */     return url.get();
/*     */   }
/*     */   
/*     */   public static void setUrl(URL urlString) {
/* 134 */     url.set(urlString);
/*     */   }
/*     */   
/*     */   public static void setUrl(String urlString) throws MalformedURLException {
/* 138 */     setUrl(new URL(urlString));
/*     */   }
/*     */   
/*     */   protected String getBaseUrl() {
/* 142 */     return UrlUtil.removeUrlTrailingSlashes(this.server.getUrl());
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
/*     */   public AbstractHttpSession(@NotNull ConnectionCfg server, @NotNull HttpSessionCallback callback) throws RemoteApiMalformedUrlException {
/* 155 */     this.server = server;
/* 156 */     this.callback = callback;
/* 157 */     String myurl = server.getUrl();
/*     */     try {
/* 159 */       UrlUtil.validateUrl(myurl);
/* 160 */     } catch (MalformedURLException e) {
/* 161 */       throw new RemoteApiMalformedUrlException("Malformed server URL: " + myurl, e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Document retrieveGetResponse(String urlString) throws IOException, JDOMException, RemoteApiSessionExpiredException {
/* 168 */     SAXBuilder builder = new SAXBuilder();
/*     */     
/* 170 */     ByteArrayInputStream in = new ByteArrayInputStream(doConditionalGet(urlString));
/* 171 */     InputStreamReader reader = new InputStreamReader(in);
/* 172 */     BufferedReader br = new BufferedReader(reader);
/* 173 */     StringBuilder allInput = new StringBuilder();
/*     */     String line;
/* 175 */     while ((line = br.readLine()) != null) {
/* 176 */       allInput.append(line);
/*     */     }
/* 178 */     in.close();
/* 179 */     br.close();
/* 180 */     reader.close();
/*     */     
/*     */     try {
/* 183 */       ByteArrayInputStream bis = new ByteArrayInputStream(allInput.toString().getBytes());
/* 184 */       Document doc = builder.build(bis);
/* 185 */       preprocessResult(doc);
/* 186 */       return doc;
/* 187 */     } catch (JDOMException e) {
/* 188 */       throw new JDOMException(String.valueOf(e.getMessage()) + "\n\n" + allInput.toString() + "\n");
/*     */     } 
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
/*     */   protected String doUnconditionalGetForTextNonXmlResource(String urlString) throws IOException {
/* 203 */     UrlUtil.validateUrl(urlString);
/* 204 */     setUrl(urlString);
/* 205 */     synchronized (this.clientLock) {
/*     */       HttpClient client; GetMethod method;
/*     */       try {
/* 208 */         client = this.callback.getHttpClient(this.server);
/* 209 */       } catch (HttpProxySettingsException e) {
/* 210 */         throw createIOException("Connection error. Please set up HTTP Proxy settings", e);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 216 */         method = new GetMethod(urlString);
/* 217 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 218 */         throw new IOException("Invalid url " + urlString);
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 223 */         method.getParams().setCookiePolicy("compatibility");
/* 224 */         method.getParams().setSoTimeout(client.getParams().getSoTimeout());
/* 225 */         this.callback.configureHttpMethod(this, (HttpMethod)method);
/* 226 */         client.executeMethod((HttpMethod)method);
/*     */         
/* 228 */         if (method.getStatusCode() != 200) {
/* 229 */           throw new IOException("HTTP " + method.getStatusCode() + " (" + 
/* 230 */               HttpStatus.getStatusText(method.getStatusCode()) + ")\n" + method.getStatusText());
/*     */         }
/* 232 */         return method.getResponseBodyAsString();
/*     */       }
/* 234 */       catch (NullPointerException e) {
/* 235 */         throw createIOException("Connection error", e);
/*     */       } finally {
/* 237 */         method.releaseConnection();
/*     */       } 
/*     */     } 
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
/*     */   protected byte[] doConditionalGet(String urlString) throws IOException {
/* 253 */     UrlUtil.validateUrl(urlString);
/* 254 */     setUrl(urlString);
/* 255 */     synchronized (this.clientLock) {
/*     */       HttpClient client; GetMethod method;
/*     */       try {
/* 258 */         client = this.callback.getHttpClient(this.server);
/* 259 */       } catch (HttpProxySettingsException e) {
/* 260 */         throw createIOException("Connection error. Please set up HTTP Proxy settings", e);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 266 */         method = new GetMethod(urlString);
/* 267 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 268 */         throw new IOException("Invalid url " + urlString);
/*     */       } 
/*     */       
/* 271 */       CacheRecord cacheRecord = this.cache.get(urlString);
/* 272 */       this.callback.configureHttpMethod(this, (HttpMethod)method);
/*     */       
/* 274 */       if (cacheRecord != null) {
/*     */ 
/*     */         
/* 277 */         method.addRequestHeader("If-Modified-Since", cacheRecord.getLastModified());
/* 278 */         method.addRequestHeader("If-None-Match", cacheRecord.getEtag());
/*     */       } 
/*     */       
/* 281 */       method.addRequestHeader("Accept", "application/xml;q=0.9,*/*");
/*     */ 
/*     */       
/*     */       try {
/* 285 */         method.getParams().setCookiePolicy("compatibility");
/* 286 */         method.getParams().setSoTimeout(client.getParams().getSoTimeout());
/*     */         
/* 288 */         client.executeMethod((HttpMethod)method);
/*     */         
/* 290 */         if (method.getStatusCode() == 304 && cacheRecord != null)
/*     */         {
/* 292 */           return cacheRecord.getDocument(); } 
/* 293 */         if (method.getStatusCode() != 200) {
/* 294 */           String errorDescription = "HTTP " + method.getStatusCode() + " (" + 
/* 295 */             HttpStatus.getStatusText(method.getStatusCode()) + ")";
/* 296 */           LoggerImpl.getInstance().info(String.valueOf(errorDescription) + "\n" + method.getStatusText());
/*     */           
/* 298 */           throw createIOException(errorDescription, new Exception(method.getResponseBodyAsString()));
/*     */         } 
/* 300 */         byte[] result = method.getResponseBody();
/* 301 */         String lastModified = (method.getResponseHeader("Last-Modified") == null) ? null : 
/* 302 */           method.getResponseHeader("Last-Modified").getValue();
/* 303 */         String eTag = (method.getResponseHeader("Etag") == null) ? null : method.getResponseHeader(
/* 304 */             "Etag").getValue();
/*     */         
/* 306 */         if (lastModified != null && eTag != null) {
/* 307 */           cacheRecord = new CacheRecord(result, lastModified, eTag, null);
/* 308 */           this.cache.put(urlString, cacheRecord);
/*     */         } 
/* 310 */         return result;
/*     */       }
/* 312 */       catch (NullPointerException e) {
/* 313 */         throw createIOException("Connection error", e);
/* 314 */       } catch (AuthenticationException e) {
/*     */         
/* 316 */         throw createIOException("Connection error", e);
/*     */       } finally {
/* 318 */         method.releaseConnection();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getResponseCharSet() {
/* 324 */     return this.responseCharSet;
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
/*     */   private IOException createIOException(String message, Throwable cause) {
/* 351 */     IOException ioException = new IOException(message);
/* 352 */     ioException.initCause(cause);
/* 353 */     return ioException;
/*     */   }
/*     */   
/*     */   protected Document retrievePostResponse(String urlString, Document request) throws IOException, JDOMException, RemoteApiException {
/* 357 */     return retrievePostResponse(urlString, request, (StringBuilder)null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Document retrievePostResponse(String urlString, Document request, StringBuilder txtHolder) throws IOException, JDOMException, RemoteApiException {
/* 362 */     return retrievePostResponse(urlString, request, true, txtHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Document retrievePostResponse(String urlString, Document request, boolean expectResponse) throws JDOMException, RemoteApiException {
/* 367 */     return retrievePostResponse(urlString, request, expectResponse, (StringBuilder)null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Document retrievePostResponse(String urlString, Document request, boolean expectResponse, StringBuilder txtHolder) throws JDOMException, RemoteApiException {
/* 372 */     XMLOutputter serializer = new XMLOutputter(Format.getPrettyFormat());
/* 373 */     String requestString = serializer.outputString(request);
/* 374 */     return retrievePostResponse(urlString, requestString, expectResponse, txtHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Document retrievePostResponse(String urlString, String request, boolean expectResponse) throws JDOMException, RemoteApiException {
/* 379 */     return retrievePostResponse(urlString, request, expectResponse, (StringBuilder)null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Document retrievePostResponse(String urlString, String request, boolean expectResponse, StringBuilder txtHolder) throws JDOMException, RemoteApiException {
/* 384 */     return retrievePostResponseInternal(urlString, request, expectResponse, 0, txtHolder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Document retrievePostResponseInternal(String urlString, final String request, boolean expectResponse, int redirectCounter, StringBuilder txtHolder) throws JDOMException, RemoteApiException {
/* 393 */     return retrievePostResponseInternalImpl(urlString, new PostMethodPreparer()
/*     */         {
/*     */           public void prepare(PostMethod postMethod) throws UnsupportedEncodingException {
/* 396 */             if (request != null && !"".equals(request)) {
/* 397 */               postMethod.setRequestEntity((RequestEntity)new StringRequestEntity(request, "application/xml", "UTF-8"));
/*     */             }
/*     */           }
/* 400 */         }expectResponse, redirectCounter, txtHolder);
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
/*     */   protected Document retrievePostResponseInternalImpl(String urlString, PostMethodPreparer postMethodPreparer, boolean expectResponse, int redirectCounter, StringBuilder txtHolder) throws JDOMException, RemoteApiException {
/*     */     // Byte code:
/*     */     //   0: aconst_null
/*     */     //   1: astore #6
/*     */     //   3: aload_1
/*     */     //   4: astore #7
/*     */     //   6: iconst_0
/*     */     //   7: istore #8
/*     */     //   9: goto -> 920
/*     */     //   12: aload #7
/*     */     //   14: invokestatic validateUrl : (Ljava/lang/String;)V
/*     */     //   17: aload #7
/*     */     //   19: invokestatic setUrl : (Ljava/lang/String;)V
/*     */     //   22: goto -> 42
/*     */     //   25: astore #9
/*     */     //   27: new com/atlassian/theplugin/commons/remoteapi/RemoteApiException
/*     */     //   30: dup
/*     */     //   31: aload #9
/*     */     //   33: invokevirtual getMessage : ()Ljava/lang/String;
/*     */     //   36: aload #9
/*     */     //   38: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   41: athrow
/*     */     //   42: aload_0
/*     */     //   43: getfield clientLock : Ljava/lang/Object;
/*     */     //   46: dup
/*     */     //   47: astore #9
/*     */     //   49: monitorenter
/*     */     //   50: aload_0
/*     */     //   51: getfield callback : Lcom/atlassian/theplugin/commons/remoteapi/rest/HttpSessionCallback;
/*     */     //   54: aload_0
/*     */     //   55: getfield server : Lcom/atlassian/connector/commons/api/ConnectionCfg;
/*     */     //   58: invokeinterface getHttpClient : (Lcom/atlassian/connector/commons/api/ConnectionCfg;)Lorg/apache/commons/httpclient/HttpClient;
/*     */     //   63: astore #10
/*     */     //   65: goto -> 82
/*     */     //   68: astore #11
/*     */     //   70: new com/atlassian/theplugin/commons/remoteapi/RemoteApiException
/*     */     //   73: dup
/*     */     //   74: ldc 'Connection error. Please set up HTTP Proxy settings'
/*     */     //   76: aload #11
/*     */     //   78: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   81: athrow
/*     */     //   82: new org/apache/commons/httpclient/methods/PostMethod
/*     */     //   85: dup
/*     */     //   86: aload #7
/*     */     //   88: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   91: astore #11
/*     */     //   93: aload #11
/*     */     //   95: invokevirtual getParams : ()Lorg/apache/commons/httpclient/params/HttpMethodParams;
/*     */     //   98: ldc 'compatibility'
/*     */     //   100: invokevirtual setCookiePolicy : (Ljava/lang/String;)V
/*     */     //   103: aload #11
/*     */     //   105: invokevirtual getParams : ()Lorg/apache/commons/httpclient/params/HttpMethodParams;
/*     */     //   108: aload #10
/*     */     //   110: invokevirtual getParams : ()Lorg/apache/commons/httpclient/params/HttpClientParams;
/*     */     //   113: invokevirtual getSoTimeout : ()I
/*     */     //   116: invokevirtual setSoTimeout : (I)V
/*     */     //   119: aload #11
/*     */     //   121: ldc_w 'Accept'
/*     */     //   124: ldc_w 'application/xml'
/*     */     //   127: invokevirtual addRequestHeader : (Ljava/lang/String;Ljava/lang/String;)V
/*     */     //   130: aload_0
/*     */     //   131: getfield callback : Lcom/atlassian/theplugin/commons/remoteapi/rest/HttpSessionCallback;
/*     */     //   134: aload_0
/*     */     //   135: aload #11
/*     */     //   137: invokeinterface configureHttpMethod : (Lcom/atlassian/theplugin/commons/remoteapi/rest/AbstractHttpSession;Lorg/apache/commons/httpclient/HttpMethod;)V
/*     */     //   142: aload_2
/*     */     //   143: aload #11
/*     */     //   145: invokeinterface prepare : (Lorg/apache/commons/httpclient/methods/PostMethod;)V
/*     */     //   150: aload #10
/*     */     //   152: aload #11
/*     */     //   154: invokevirtual executeMethod : (Lorg/apache/commons/httpclient/HttpMethod;)I
/*     */     //   157: pop
/*     */     //   158: aload #11
/*     */     //   160: invokevirtual getStatusCode : ()I
/*     */     //   163: istore #12
/*     */     //   165: iload #12
/*     */     //   167: sipush #204
/*     */     //   170: if_icmpne -> 194
/*     */     //   173: aload #6
/*     */     //   175: astore #18
/*     */     //   177: aload_0
/*     */     //   178: aload #11
/*     */     //   180: invokevirtual preprocessMethodResult : (Lorg/apache/commons/httpclient/HttpMethod;)V
/*     */     //   183: aload #11
/*     */     //   185: invokevirtual releaseConnection : ()V
/*     */     //   188: aload #9
/*     */     //   190: monitorexit
/*     */     //   191: aload #18
/*     */     //   193: areturn
/*     */     //   194: iload #12
/*     */     //   196: sipush #301
/*     */     //   199: if_icmpeq -> 210
/*     */     //   202: iload #12
/*     */     //   204: sipush #302
/*     */     //   207: if_icmpne -> 353
/*     */     //   210: aload #11
/*     */     //   212: ldc_w 'Location'
/*     */     //   215: invokevirtual getResponseHeader : (Ljava/lang/String;)Lorg/apache/commons/httpclient/Header;
/*     */     //   218: astore #13
/*     */     //   220: aload #13
/*     */     //   222: ifnonnull -> 236
/*     */     //   225: new com/atlassian/theplugin/commons/remoteapi/RemoteApiException
/*     */     //   228: dup
/*     */     //   229: ldc_w 'Connection error. Received redirection without new target address'
/*     */     //   232: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   235: athrow
/*     */     //   236: aload #13
/*     */     //   238: invokevirtual getValue : ()Ljava/lang/String;
/*     */     //   241: astore #14
/*     */     //   243: aload #14
/*     */     //   245: ldc_w '/success'
/*     */     //   248: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   251: ifeq -> 320
/*     */     //   254: aload #14
/*     */     //   256: iconst_0
/*     */     //   257: aload #14
/*     */     //   259: ldc_w '/success'
/*     */     //   262: invokevirtual lastIndexOf : (Ljava/lang/String;)I
/*     */     //   265: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   268: astore #15
/*     */     //   270: aload #7
/*     */     //   272: aload #15
/*     */     //   274: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   277: ifne -> 787
/*     */     //   280: new java/lang/StringBuilder
/*     */     //   283: dup
/*     */     //   284: aload #15
/*     */     //   286: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   289: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   292: ldc_w '/'
/*     */     //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   298: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   301: astore #7
/*     */     //   303: aload_0
/*     */     //   304: aload #11
/*     */     //   306: invokevirtual preprocessMethodResult : (Lorg/apache/commons/httpclient/HttpMethod;)V
/*     */     //   309: aload #11
/*     */     //   311: invokevirtual releaseConnection : ()V
/*     */     //   314: aload #9
/*     */     //   316: monitorexit
/*     */     //   317: goto -> 917
/*     */     //   320: aload #14
/*     */     //   322: ldc_w '/JiraLockedError'
/*     */     //   325: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   328: ifeq -> 342
/*     */     //   331: new com/atlassian/theplugin/commons/remoteapi/RemoteApiException
/*     */     //   334: dup
/*     */     //   335: ldc_w 'JIRA is locked. Please contact your JIRA administrator.'
/*     */     //   338: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   341: athrow
/*     */     //   342: new com/atlassian/theplugin/commons/remoteapi/RemoteApiException
/*     */     //   345: dup
/*     */     //   346: ldc_w 'Connection error. Received too many redirects (more than 3)'
/*     */     //   349: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   352: athrow
/*     */     //   353: iload #12
/*     */     //   355: sipush #403
/*     */     //   358: if_icmpne -> 449
/*     */     //   361: new java/lang/StringBuilder
/*     */     //   364: dup
/*     */     //   365: ldc_w 'HTTP 403 ('
/*     */     //   368: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   371: sipush #403
/*     */     //   374: invokestatic getStatusText : (I)Ljava/lang/String;
/*     */     //   377: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   380: ldc_w ')'
/*     */     //   383: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   386: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   389: astore #13
/*     */     //   391: invokestatic getInstance : ()Lcom/atlassian/theplugin/commons/util/Logger;
/*     */     //   394: new java/lang/StringBuilder
/*     */     //   397: dup
/*     */     //   398: aload #13
/*     */     //   400: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   403: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   406: ldc '\\n'
/*     */     //   408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   411: aload #11
/*     */     //   413: invokevirtual getStatusText : ()Ljava/lang/String;
/*     */     //   416: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   419: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   422: invokeinterface info : (Ljava/lang/String;)V
/*     */     //   427: new com/atlassian/theplugin/commons/remoteapi/RemoteApiException
/*     */     //   430: dup
/*     */     //   431: aload #13
/*     */     //   433: new java/lang/Exception
/*     */     //   436: dup
/*     */     //   437: aload #11
/*     */     //   439: invokevirtual getResponseBodyAsString : ()Ljava/lang/String;
/*     */     //   442: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   445: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   448: athrow
/*     */     //   449: iload #12
/*     */     //   451: sipush #200
/*     */     //   454: if_icmpeq -> 561
/*     */     //   457: iload #12
/*     */     //   459: sipush #201
/*     */     //   462: if_icmpeq -> 561
/*     */     //   465: aload #11
/*     */     //   467: invokevirtual getResponseBodyAsString : ()Ljava/lang/String;
/*     */     //   470: ldc_w '<html>'
/*     */     //   473: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   476: ifne -> 561
/*     */     //   479: new org/jdom/input/SAXBuilder
/*     */     //   482: dup
/*     */     //   483: invokespecial <init> : ()V
/*     */     //   486: astore #14
/*     */     //   488: new java/io/StringWriter
/*     */     //   491: dup
/*     */     //   492: invokespecial <init> : ()V
/*     */     //   495: astore #15
/*     */     //   497: aload #11
/*     */     //   499: invokevirtual getResponseBodyAsStream : ()Ljava/io/InputStream;
/*     */     //   502: aload #15
/*     */     //   504: ldc_w 'UTF-8'
/*     */     //   507: invokestatic copy : (Ljava/io/InputStream;Ljava/io/Writer;Ljava/lang/String;)V
/*     */     //   510: aload #15
/*     */     //   512: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   515: astore #16
/*     */     //   517: aload #5
/*     */     //   519: ifnull -> 530
/*     */     //   522: aload #5
/*     */     //   524: aload #16
/*     */     //   526: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   529: pop
/*     */     //   530: aload #14
/*     */     //   532: new java/io/ByteArrayInputStream
/*     */     //   535: dup
/*     */     //   536: aload #16
/*     */     //   538: invokevirtual getBytes : ()[B
/*     */     //   541: invokespecial <init> : ([B)V
/*     */     //   544: invokevirtual build : (Ljava/io/InputStream;)Lorg/jdom/Document;
/*     */     //   547: astore #13
/*     */     //   549: aload_0
/*     */     //   550: aload #11
/*     */     //   552: invokevirtual getStatusCode : ()I
/*     */     //   555: aload #13
/*     */     //   557: invokespecial buildExceptionText : (ILorg/jdom/Document;)Lcom/atlassian/theplugin/commons/remoteapi/RemoteApiException;
/*     */     //   560: athrow
/*     */     //   561: iload #12
/*     */     //   563: sipush #406
/*     */     //   566: if_icmpne -> 673
/*     */     //   569: new java/lang/StringBuilder
/*     */     //   572: dup
/*     */     //   573: ldc_w 'HTTP '
/*     */     //   576: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   579: iload #12
/*     */     //   581: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   584: ldc_w ' ('
/*     */     //   587: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   590: ldc_w 'Authentication failed (probably invalid username or password).'
/*     */     //   593: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   596: iload #12
/*     */     //   598: invokestatic getStatusText : (I)Ljava/lang/String;
/*     */     //   601: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   604: ldc_w ')'
/*     */     //   607: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   610: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   613: astore #13
/*     */     //   615: invokestatic getInstance : ()Lcom/atlassian/theplugin/commons/util/Logger;
/*     */     //   618: new java/lang/StringBuilder
/*     */     //   621: dup
/*     */     //   622: aload #13
/*     */     //   624: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   627: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   630: ldc '\\n'
/*     */     //   632: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   635: aload #11
/*     */     //   637: invokevirtual getStatusText : ()Ljava/lang/String;
/*     */     //   640: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   643: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   646: invokeinterface info : (Ljava/lang/String;)V
/*     */     //   651: new com/atlassian/theplugin/commons/remoteapi/RemoteApiException
/*     */     //   654: dup
/*     */     //   655: aload #13
/*     */     //   657: new java/lang/Exception
/*     */     //   660: dup
/*     */     //   661: aload #11
/*     */     //   663: invokevirtual getResponseBodyAsString : ()Ljava/lang/String;
/*     */     //   666: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   669: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   672: athrow
/*     */     //   673: iload #12
/*     */     //   675: sipush #200
/*     */     //   678: if_icmpeq -> 787
/*     */     //   681: iload #12
/*     */     //   683: sipush #201
/*     */     //   686: if_icmpeq -> 787
/*     */     //   689: new java/lang/StringBuilder
/*     */     //   692: dup
/*     */     //   693: ldc_w 'HTTP '
/*     */     //   696: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   699: iload #12
/*     */     //   701: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   704: ldc_w ' ('
/*     */     //   707: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   710: iload #12
/*     */     //   712: invokestatic getStatusText : (I)Ljava/lang/String;
/*     */     //   715: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   718: ldc_w ')'
/*     */     //   721: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   724: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   727: astore #13
/*     */     //   729: invokestatic getInstance : ()Lcom/atlassian/theplugin/commons/util/Logger;
/*     */     //   732: new java/lang/StringBuilder
/*     */     //   735: dup
/*     */     //   736: aload #13
/*     */     //   738: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   741: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   744: ldc '\\n'
/*     */     //   746: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   749: aload #11
/*     */     //   751: invokevirtual getStatusText : ()Ljava/lang/String;
/*     */     //   754: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   757: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   760: invokeinterface info : (Ljava/lang/String;)V
/*     */     //   765: new com/atlassian/theplugin/commons/remoteapi/RemoteApiException
/*     */     //   768: dup
/*     */     //   769: aload #13
/*     */     //   771: new java/lang/Exception
/*     */     //   774: dup
/*     */     //   775: aload #11
/*     */     //   777: invokevirtual getResponseBodyAsString : ()Ljava/lang/String;
/*     */     //   780: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   783: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   786: athrow
/*     */     //   787: aload_0
/*     */     //   788: aload #11
/*     */     //   790: invokevirtual getResponseCharSet : ()Ljava/lang/String;
/*     */     //   793: putfield responseCharSet : Ljava/lang/String;
/*     */     //   796: iload_3
/*     */     //   797: ifeq -> 827
/*     */     //   800: new org/jdom/input/SAXBuilder
/*     */     //   803: dup
/*     */     //   804: invokespecial <init> : ()V
/*     */     //   807: astore #13
/*     */     //   809: aload #13
/*     */     //   811: aload #11
/*     */     //   813: invokevirtual getResponseBodyAsStream : ()Ljava/io/InputStream;
/*     */     //   816: invokevirtual build : (Ljava/io/InputStream;)Lorg/jdom/Document;
/*     */     //   819: astore #6
/*     */     //   821: aload_0
/*     */     //   822: aload #6
/*     */     //   824: invokevirtual preprocessResult : (Lorg/jdom/Document;)V
/*     */     //   827: aload_0
/*     */     //   828: aload #11
/*     */     //   830: invokevirtual preprocessMethodResult : (Lorg/apache/commons/httpclient/HttpMethod;)V
/*     */     //   833: aload #11
/*     */     //   835: invokevirtual releaseConnection : ()V
/*     */     //   838: aload #9
/*     */     //   840: monitorexit
/*     */     //   841: goto -> 926
/*     */     //   844: astore #12
/*     */     //   846: new com/atlassian/theplugin/commons/remoteapi/RemoteApiException
/*     */     //   849: dup
/*     */     //   850: new java/lang/StringBuilder
/*     */     //   853: dup
/*     */     //   854: ldc_w 'Connection error to ['
/*     */     //   857: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   860: aload #7
/*     */     //   862: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   865: ldc_w ']'
/*     */     //   868: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   871: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   874: aload #12
/*     */     //   876: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   879: athrow
/*     */     //   880: astore #12
/*     */     //   882: new com/atlassian/theplugin/commons/remoteapi/RemoteApiException
/*     */     //   885: dup
/*     */     //   886: aload #12
/*     */     //   888: invokevirtual getMessage : ()Ljava/lang/String;
/*     */     //   891: aload #12
/*     */     //   893: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   896: athrow
/*     */     //   897: astore #17
/*     */     //   899: aload_0
/*     */     //   900: aload #11
/*     */     //   902: invokevirtual preprocessMethodResult : (Lorg/apache/commons/httpclient/HttpMethod;)V
/*     */     //   905: aload #11
/*     */     //   907: invokevirtual releaseConnection : ()V
/*     */     //   910: aload #17
/*     */     //   912: athrow
/*     */     //   913: aload #9
/*     */     //   915: monitorexit
/*     */     //   916: athrow
/*     */     //   917: iinc #8, 1
/*     */     //   920: iload #8
/*     */     //   922: iconst_3
/*     */     //   923: if_icmple -> 12
/*     */     //   926: aload #6
/*     */     //   928: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #406	-> 0
/*     */     //   #407	-> 3
/*     */     //   #409	-> 6
/*     */     //   #411	-> 12
/*     */     //   #412	-> 17
/*     */     //   #413	-> 25
/*     */     //   #414	-> 27
/*     */     //   #417	-> 42
/*     */     //   #420	-> 50
/*     */     //   #421	-> 68
/*     */     //   #422	-> 70
/*     */     //   #425	-> 82
/*     */     //   #429	-> 93
/*     */     //   #430	-> 103
/*     */     //   #431	-> 119
/*     */     //   #433	-> 130
/*     */     //   #434	-> 142
/*     */     //   #436	-> 150
/*     */     //   #438	-> 158
/*     */     //   #439	-> 165
/*     */     //   #440	-> 173
/*     */     //   #517	-> 177
/*     */     //   #518	-> 183
/*     */     //   #440	-> 188
/*     */     //   #441	-> 194
/*     */     //   #442	-> 202
/*     */     //   #444	-> 210
/*     */     //   #445	-> 220
/*     */     //   #446	-> 225
/*     */     //   #447	-> 229
/*     */     //   #446	-> 232
/*     */     //   #449	-> 236
/*     */     //   #450	-> 243
/*     */     //   #451	-> 254
/*     */     //   #452	-> 270
/*     */     //   #454	-> 280
/*     */     //   #517	-> 303
/*     */     //   #518	-> 309
/*     */     //   #455	-> 314
/*     */     //   #457	-> 320
/*     */     //   #458	-> 331
/*     */     //   #461	-> 342
/*     */     //   #462	-> 346
/*     */     //   #461	-> 349
/*     */     //   #465	-> 353
/*     */     //   #466	-> 361
/*     */     //   #467	-> 371
/*     */     //   #466	-> 386
/*     */     //   #468	-> 391
/*     */     //   #470	-> 427
/*     */     //   #471	-> 449
/*     */     //   #472	-> 457
/*     */     //   #473	-> 465
/*     */     //   #476	-> 479
/*     */     //   #477	-> 488
/*     */     //   #478	-> 497
/*     */     //   #479	-> 510
/*     */     //   #480	-> 517
/*     */     //   #481	-> 522
/*     */     //   #483	-> 530
/*     */     //   #484	-> 549
/*     */     //   #486	-> 561
/*     */     //   #487	-> 569
/*     */     //   #488	-> 590
/*     */     //   #489	-> 596
/*     */     //   #487	-> 610
/*     */     //   #490	-> 615
/*     */     //   #491	-> 651
/*     */     //   #494	-> 673
/*     */     //   #495	-> 689
/*     */     //   #496	-> 710
/*     */     //   #495	-> 724
/*     */     //   #497	-> 729
/*     */     //   #498	-> 765
/*     */     //   #501	-> 787
/*     */     //   #502	-> 796
/*     */     //   #503	-> 800
/*     */     //   #504	-> 809
/*     */     //   #505	-> 821
/*     */     //   #517	-> 827
/*     */     //   #518	-> 833
/*     */     //   #507	-> 838
/*     */     //   #509	-> 844
/*     */     //   #510	-> 846
/*     */     //   #511	-> 880
/*     */     //   #512	-> 882
/*     */     //   #516	-> 897
/*     */     //   #517	-> 899
/*     */     //   #518	-> 905
/*     */     //   #519	-> 910
/*     */     //   #417	-> 913
/*     */     //   #409	-> 917
/*     */     //   #522	-> 926
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	929	0	this	Lcom/atlassian/theplugin/commons/remoteapi/rest/AbstractHttpSession;
/*     */     //   0	929	1	urlString	Ljava/lang/String;
/*     */     //   0	929	2	postMethodPreparer	Lcom/atlassian/theplugin/commons/remoteapi/rest/AbstractHttpSession$PostMethodPreparer;
/*     */     //   0	929	3	expectResponse	Z
/*     */     //   0	929	4	redirectCounter	I
/*     */     //   0	929	5	txtHolder	Ljava/lang/StringBuilder;
/*     */     //   3	926	6	doc	Lorg/jdom/Document;
/*     */     //   6	923	7	baseUrl	Ljava/lang/String;
/*     */     //   9	917	8	i	I
/*     */     //   27	15	9	e	Ljava/net/MalformedURLException;
/*     */     //   65	3	10	client	Lorg/apache/commons/httpclient/HttpClient;
/*     */     //   82	831	10	client	Lorg/apache/commons/httpclient/HttpClient;
/*     */     //   70	12	11	e	Lcom/atlassian/theplugin/commons/exception/HttpProxySettingsException;
/*     */     //   93	820	11	method	Lorg/apache/commons/httpclient/methods/PostMethod;
/*     */     //   165	679	12	httpStatus	I
/*     */     //   220	133	13	newLocation	Lorg/apache/commons/httpclient/Header;
/*     */     //   243	110	14	lUrl	Ljava/lang/String;
/*     */     //   270	50	15	newBaseUrl	Ljava/lang/String;
/*     */     //   391	58	13	errorDescription	Ljava/lang/String;
/*     */     //   549	12	13	document	Lorg/jdom/Document;
/*     */     //   488	73	14	builder	Lorg/jdom/input/SAXBuilder;
/*     */     //   497	64	15	writer	Ljava/io/StringWriter;
/*     */     //   517	44	16	response	Ljava/lang/String;
/*     */     //   615	58	13	errorDescription	Ljava/lang/String;
/*     */     //   729	58	13	errorDescription	Ljava/lang/String;
/*     */     //   809	18	13	builder	Lorg/jdom/input/SAXBuilder;
/*     */     //   846	34	12	e	Ljava/lang/NullPointerException;
/*     */     //   882	15	12	e	Ljava/io/IOException;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   12	22	25	java/net/MalformedURLException
/*     */     //   50	65	68	com/atlassian/theplugin/commons/exception/HttpProxySettingsException
/*     */     //   50	191	913	finally
/*     */     //   93	177	844	java/lang/NullPointerException
/*     */     //   93	177	880	java/io/IOException
/*     */     //   93	177	897	finally
/*     */     //   194	303	844	java/lang/NullPointerException
/*     */     //   194	303	880	java/io/IOException
/*     */     //   194	303	897	finally
/*     */     //   194	317	913	finally
/*     */     //   320	827	844	java/lang/NullPointerException
/*     */     //   320	827	880	java/io/IOException
/*     */     //   320	827	897	finally
/*     */     //   320	841	913	finally
/*     */     //   844	897	897	finally
/*     */     //   844	916	913	finally
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
/*     */   protected Document retrievePostResponseWithForm(String urlString, final Map<String, String> form, boolean expectResponse) throws JDOMException, RemoteApiException {
/* 527 */     return retrievePostResponseInternalImpl(urlString, new PostMethodPreparer()
/*     */         {
/*     */           public void prepare(PostMethod postMethod) throws UnsupportedEncodingException {
/* 530 */             if (form != null) {
/* 531 */               for (Map.Entry<String, String> formEntry : (Iterable<Map.Entry<String, String>>)form.entrySet()) {
/* 532 */                 postMethod.addParameter(formEntry.getKey(), formEntry.getValue());
/*     */               }
/*     */             }
/*     */           }
/* 536 */         }expectResponse, 0, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Document retrievePostResponse(String urlString, Part[] parts, boolean expectResponse) throws JDOMException, RemoteApiException {
/* 545 */     return retrievePostResponseInternal(urlString, parts, expectResponse, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Document retrievePostResponseInternal(String urlString, Part[] parts, boolean expectResponse, int redirectCounter) throws JDOMException, RemoteApiException {
/* 552 */     Document doc = null;
/*     */     
/* 554 */     synchronized (this.clientLock) {
/*     */       HttpClient client;
/*     */       try {
/* 557 */         client = this.callback.getHttpClient(this.server);
/* 558 */       } catch (HttpProxySettingsException e) {
/* 559 */         throw new RemoteApiException("Connection error to [" + urlString + 
/* 560 */             "]. Please set up HTTP Proxy settings", e);
/*     */       } 
/*     */       
/* 563 */       PostMethod method = new PostMethod(urlString);
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 568 */         method.getParams().setBooleanParameter("http.protocol.expect-continue", true);
/* 569 */         method.getParams().setCookiePolicy("compatibility");
/*     */ 
/*     */         
/* 572 */         method.setRequestEntity((RequestEntity)new MultipartRequestEntity(parts, method.getParams()));
/* 573 */         this.callback.configureHttpMethod(this, (HttpMethod)method);
/*     */         
/* 575 */         client.executeMethod((HttpMethod)method);
/* 576 */         int httpStatus = method.getStatusCode();
/* 577 */         if (httpStatus == 204)
/* 578 */           return doc; 
/* 579 */         if (httpStatus == 301 || 
/* 580 */           httpStatus == 302) {
/* 581 */           if (redirectCounter < 3) {
/* 582 */             Header newLocation = method.getResponseHeader("Location");
/* 583 */             if (newLocation == null) {
/* 584 */               throw new RemoteApiException(
/* 585 */                   "Connection error. Received redirection without new target address");
/*     */             }
/* 587 */             return retrievePostResponseInternal(
/* 588 */                 newLocation.getValue(), parts, expectResponse, redirectCounter + 1);
/*     */           } 
/* 590 */           throw new RemoteApiException(
/* 591 */               "Connection error. Received too many redirects (more than 3)");
/*     */         } 
/* 593 */         if (httpStatus != 200 && httpStatus != 201) {
/*     */ 
/*     */           
/* 596 */           SAXBuilder builder = new SAXBuilder();
/* 597 */           Document document = builder.build(method.getResponseBodyAsStream());
/* 598 */           throw buildExceptionText(method.getStatusCode(), document);
/*     */         } 
/*     */         
/* 601 */         if (expectResponse) {
/* 602 */           SAXBuilder builder = new SAXBuilder();
/* 603 */           doc = builder.build(method.getResponseBodyAsStream());
/* 604 */           preprocessResult(doc);
/*     */         } 
/* 606 */       } catch (NullPointerException e) {
/* 607 */         throw new RemoteApiException("Connection error to [" + urlString + "]", e);
/* 608 */       } catch (IOException e) {
/* 609 */         throw new RemoteApiException(String.valueOf(IOException.class.getSimpleName()) + " encountered while posting data to [" + 
/* 610 */             urlString + "]: " + e.getMessage(), e);
/*     */       } finally {
/* 612 */         preprocessMethodResult((HttpMethod)method);
/* 613 */         method.releaseConnection();
/*     */       } 
/*     */     } 
/* 616 */     return doc;
/*     */   }
/*     */   
/*     */   private RemoteApiException buildExceptionText(int statusCode, Document document) throws JDOMException {
/* 620 */     StringBuilder textBuilder = (new StringBuilder()).append("Server returned HTTP ")
/* 621 */       .append(statusCode)
/* 622 */       .append(" (")
/* 623 */       .append(HttpStatus.getStatusText(statusCode))
/* 624 */       .append(")\n")
/* 625 */       .append("Reason: ");
/*     */ 
/*     */     
/* 628 */     XPath xpath = XPath.newInstance("error/code");
/*     */     
/* 630 */     List<Element> nodes = xpath.selectNodes(document);
/* 631 */     if (nodes != null && !nodes.isEmpty()) {
/* 632 */       textBuilder.append(((Element)nodes.get(0)).getValue()).append(" ");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 637 */     xpath = XPath.newInstance("error/message");
/*     */     
/* 639 */     List<Element> messages = xpath.selectNodes(document);
/* 640 */     if (messages != null && !messages.isEmpty()) {
/* 641 */       textBuilder.append("\nMessage: ").append(((Element)messages.get(0)).getValue());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 646 */     xpath = XPath.newInstance("status/message");
/*     */     
/* 648 */     messages = xpath.selectNodes(document);
/* 649 */     if (messages != null && !messages.isEmpty()) {
/* 650 */       textBuilder.append("\nMessage: ").append(((Element)messages.get(0)).getValue());
/*     */     }
/*     */ 
/*     */     
/* 654 */     String serverStackTrace = null;
/*     */     
/* 656 */     XPath xPath1 = XPath.newInstance("error/stacktrace");
/*     */     
/* 658 */     List<Element> list1 = xPath1.selectNodes(document);
/* 659 */     if (list1 != null && !list1.isEmpty()) {
/* 660 */       serverStackTrace = "\nStacktrace from the server:\n";
/* 661 */       serverStackTrace = String.valueOf(serverStackTrace) + ((Element)list1.get(0)).getValue();
/*     */     } 
/*     */ 
/*     */     
/* 665 */     return new RemoteApiException(textBuilder.toString(), serverStackTrace);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Document retrieveDeleteResponse(String urlString, boolean expectResponse) throws IOException, JDOMException, RemoteApiSessionExpiredException {
/* 670 */     return retrieveDeleteResponseInternal(urlString, expectResponse, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Document retrieveDeleteResponseInternal(String urlString, boolean expectResponse, int redirectCounter) throws IOException, JDOMException, RemoteApiSessionExpiredException {
/* 675 */     UrlUtil.validateUrl(urlString);
/*     */     
/* 677 */     Document doc = null;
/* 678 */     synchronized (this.clientLock) {
/*     */       HttpClient client;
/*     */       try {
/* 681 */         client = this.callback.getHttpClient(this.server);
/* 682 */       } catch (HttpProxySettingsException e) {
/* 683 */         throw createIOException("Connection error. Please set up HTTP Proxy settings", e);
/*     */       } 
/*     */       
/* 686 */       DeleteMethod method = new DeleteMethod(urlString);
/*     */ 
/*     */       
/*     */       try {
/* 690 */         method.getParams().setCookiePolicy("compatibility");
/* 691 */         method.getParams().setSoTimeout(client.getParams().getSoTimeout());
/* 692 */         this.callback.configureHttpMethod(this, (HttpMethod)method);
/*     */         
/* 694 */         client.executeMethod((HttpMethod)method);
/*     */         
/* 696 */         int statusCode = method.getStatusCode();
/* 697 */         if (statusCode == 204) {
/* 698 */           return null;
/*     */         }
/* 700 */         if (statusCode == 301 || 
/* 701 */           statusCode == 302) {
/* 702 */           if (redirectCounter < 3) {
/* 703 */             Header newLocation = method.getResponseHeader("Location");
/* 704 */             if (newLocation == null) {
/* 705 */               throw new IOException(
/* 706 */                   "Connection error. Received redirection without new target address");
/*     */             }
/* 708 */             return retrieveDeleteResponseInternal(
/* 709 */                 newLocation.getValue(), expectResponse, redirectCounter + 1);
/*     */           } 
/* 711 */           throw new IOException(
/* 712 */               "Connection error. Received too many redirects (more than 3)");
/*     */         } 
/*     */         
/* 715 */         if (method.getStatusCode() != 200) {
/* 716 */           throw new IOException("HTTP status code " + method.getStatusCode() + ": " + method.getStatusText());
/*     */         }
/*     */         
/* 719 */         if (expectResponse) {
/* 720 */           SAXBuilder builder = new SAXBuilder();
/* 721 */           doc = builder.build(method.getResponseBodyAsStream());
/* 722 */           preprocessResult(doc);
/*     */         } 
/* 724 */       } catch (NullPointerException e) {
/* 725 */         throw createIOException("Connection error", e);
/*     */       } finally {
/* 727 */         method.releaseConnection();
/*     */       } 
/*     */     } 
/* 730 */     return doc;
/*     */   }
/*     */   
/*     */   protected abstract void adjustHttpHeader(HttpMethod paramHttpMethod);
/*     */   
/*     */   protected abstract void preprocessResult(Document paramDocument) throws JDOMException, RemoteApiSessionExpiredException;
/*     */   
/*     */   protected abstract void preprocessMethodResult(HttpMethod paramHttpMethod) throws RemoteApiException, ServiceUnavailableException;
/*     */   
/*     */   public static String getServerNameFromUrl(String urlString) {
/* 740 */     int pos = urlString.indexOf("://");
/* 741 */     if (pos != -1) {
/* 742 */       urlString = urlString.substring(pos + 1 + 2);
/*     */     }
/* 744 */     pos = urlString.indexOf("/");
/* 745 */     if (pos != -1) {
/* 746 */       urlString = urlString.substring(0, pos);
/*     */     }
/* 748 */     return urlString;
/*     */   }
/*     */   
/*     */   protected static interface PostMethodPreparer {
/*     */     void prepare(PostMethod param1PostMethod) throws UnsupportedEncodingException;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\remoteapi\rest\AbstractHttpSession.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */