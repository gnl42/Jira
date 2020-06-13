/*     */ package com.atlassian.theplugin.commons.cfg.xstream;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.cfg.ServerCfg;
/*     */ import com.atlassian.theplugin.commons.cfg.ServerCfgFactoryException;
/*     */ import com.atlassian.theplugin.commons.cfg.SharedServerList;
/*     */ import com.atlassian.theplugin.commons.util.LoggerImpl;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.JDOMException;
/*     */ import org.jdom.input.SAXBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HomeDirSharedConfigurationImpl
/*     */   extends BasePrivateConfigurationDao<SharedServerList>
/*     */   implements UserSharedConfigurationDao
/*     */ {
/*     */   private static final String GLOBAL_SERVERS_FILE_NAME = "shared-servers";
/*     */   
/*     */   public synchronized void save(SharedServerList serversInfo, Collection<ServerCfg> allServers) throws ServerCfgFactoryException {
/*  46 */     File outputFile = null;
/*     */     
/*     */     try {
/*  49 */       outputFile = new File(getPrivateCfgDirectorySavePath(), "shared-servers");
/*  50 */       if (!outputFile.exists()) {
/*  51 */         outputFile.createNewFile();
/*     */       }
/*  53 */       SharedServerList storedList = load();
/*  54 */       if (outputFile.exists() && outputFile.canWrite()) {
/*  55 */         Document document; if (storedList != null) {
/*     */           
/*  57 */           document = createJDom(SharedServerList.merge(serversInfo, storedList, allServers));
/*     */         } else {
/*     */           
/*  60 */           document = createJDom(serversInfo);
/*     */         } 
/*     */         
/*  63 */         writeXmlFile(document.getRootElement(), outputFile);
/*     */       } else {
/*  65 */         LoggerImpl.getInstance().error("Shared configuration hasn't been saved - cannot write file " + outputFile.getAbsolutePath());
/*  66 */         throw new ServerCfgFactoryException("Shared configuration hasn't been saved");
/*     */       }
/*     */     
/*  69 */     } catch (Exception e) {
/*  70 */       LoggerImpl.getInstance().error("Shared configuration hasn't been saved", e);
/*  71 */       ServerCfgFactoryException ex = new ServerCfgFactoryException(e.getMessage());
/*  72 */       ex.initCause(e);
/*  73 */       throw ex;
/*     */     } 
/*     */   }
/*     */   
/*     */   public SharedServerList load() throws ServerCfgFactoryException {
/*  78 */     File atlassianDir = getPrivateCfgDirectorySavePath();
/*     */     
/*  80 */     if (isDirReady()) {
/*  81 */       File sharedConfigFile = new File(atlassianDir.getAbsolutePath(), "shared-servers");
/*  82 */       if (sharedConfigFile.isFile() && sharedConfigFile.canRead() && sharedConfigFile.length() > 0L) {
/*     */         Document doc;
/*     */         
/*  85 */         SAXBuilder builder = new SAXBuilder(false);
/*     */         try {
/*  87 */           doc = builder.build(sharedConfigFile.toURI().toString());
/*  88 */         } catch (JDOMException e) {
/*  89 */           throw new ServerCfgFactoryException("Cannot parse shared cfg file " + e.getMessage());
/*  90 */         } catch (IOException e) {
/*  91 */           throw new ServerCfgFactoryException("Cannot read shared cfg file " + sharedConfigFile.getAbsolutePath() + " : " + e.getMessage());
/*     */         } 
/*     */         
/*  94 */         SharedServerList globalServerInfos = null;
/*  95 */         if (doc != null) {
/*  96 */           globalServerInfos = (SharedServerList)loadJDom(doc.getRootElement(), SharedServerList.class, Boolean.valueOf(true));
/*     */         }
/*  98 */         return globalServerInfos;
/*     */       } 
/* 100 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 104 */     throw new ServerCfgFactoryException("Cannot read shared configuration stored in directory [" + 
/* 105 */         atlassianDir.getAbsolutePath() + "]. Directory does not exist or is not accessible");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getRootElementName() {
/* 112 */     return "shared-servers";
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\xstream\HomeDirSharedConfigurationImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */