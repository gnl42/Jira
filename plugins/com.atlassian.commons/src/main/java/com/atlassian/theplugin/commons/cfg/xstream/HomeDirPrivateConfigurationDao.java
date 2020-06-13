/*     */ package com.atlassian.theplugin.commons.cfg.xstream;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.cfg.PrivateConfigurationDao;
/*     */ import com.atlassian.theplugin.commons.cfg.PrivateServerCfgInfo;
/*     */ import com.atlassian.theplugin.commons.cfg.ServerCfg;
/*     */ import com.atlassian.theplugin.commons.cfg.ServerCfgFactoryException;
/*     */ import com.atlassian.theplugin.commons.cfg.ServerId;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.JDOMException;
/*     */ import org.jdom.input.SAXBuilder;
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
/*     */ public class HomeDirPrivateConfigurationDao
/*     */   extends BasePrivateConfigurationDao<PrivateServerCfgInfo>
/*     */   implements PrivateConfigurationDao
/*     */ {
/*     */   private static final String ROOT_ELEMENT_NAME = "single-server-private-cfg";
/*     */   
/*     */   public PrivateServerCfgInfo load(ServerId id) throws ServerCfgFactoryException {
/*  42 */     File atlassianDir = getPrivateCfgDirectorySavePath();
/*     */     
/*  44 */     if (isDirReady()) {
/*  45 */       File serverCfgFile = new File(atlassianDir.getAbsolutePath(), id.toString());
/*  46 */       if (serverCfgFile.isFile() && serverCfgFile.canRead()) {
/*     */         Document doc;
/*     */         
/*  49 */         SAXBuilder builder = new SAXBuilder(false);
/*     */         
/*     */         try {
/*  52 */           doc = builder.build(serverCfgFile.toURI().toString());
/*  53 */         } catch (JDOMException e) {
/*  54 */           throw new ServerCfgFactoryException("Cannot parse server cfg file " + e.getMessage());
/*  55 */         } catch (IOException e) {
/*  56 */           throw new ServerCfgFactoryException("Cannot read sever cfg file " + e.getMessage());
/*     */         } 
/*     */         
/*  59 */         PrivateServerCfgInfo privateServerCfgInfo = null;
/*  60 */         if (doc != null) {
/*  61 */           privateServerCfgInfo = load(doc);
/*     */         }
/*  63 */         return privateServerCfgInfo;
/*     */       } 
/*  65 */       return null;
/*     */     } 
/*     */ 
/*     */     
/*  69 */     throw new ServerCfgFactoryException("Cannot read private configuration stored in directory [" + 
/*  70 */         atlassianDir.getAbsolutePath() + "]. Directory does not exist or is not accessible");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static PrivateServerCfgInfo load(Document doc) throws ServerCfgFactoryException {
/*  76 */     return (PrivateServerCfgInfo)loadJDom(doc.getRootElement(), PrivateServerCfgInfo.class, Boolean.valueOf(false));
/*     */   }
/*     */   
/*     */   public void save(@NotNull PrivateServerCfgInfo info) throws ServerCfgFactoryException {
/*  80 */     Document document = createJDom(info);
/*     */     
/*     */     try {
/*  83 */       writeXmlFile(document.getRootElement(), new File(getPrivateCfgDirectorySavePath(), 
/*  84 */             info.getServerId().toString()));
/*  85 */     } catch (IOException e) {
/*  86 */       ServerCfgFactoryException ex = new ServerCfgFactoryException(e.getMessage());
/*  87 */       ex.initCause(e);
/*  88 */       throw ex;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getRootElementName() {
/*  98 */     return "single-server-private-cfg";
/*     */   }
/*     */ 
/*     */   
/*     */   public void deleteFile(ServerCfg server) {
/* 103 */     File toDelete = new File(getPrivateCfgDirectoryPath(), server.getServerId().toString());
/* 104 */     if (toDelete.exists() && toDelete.canWrite())
/* 105 */       toDelete.delete(); 
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\xstream\HomeDirPrivateConfigurationDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */