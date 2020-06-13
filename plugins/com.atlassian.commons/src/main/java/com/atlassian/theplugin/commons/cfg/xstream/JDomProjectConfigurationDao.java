/*     */ package com.atlassian.theplugin.commons.cfg.xstream;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.cfg.PrivateConfigurationDao;
/*     */ import com.atlassian.theplugin.commons.cfg.PrivateProjectConfiguration;
/*     */ import com.atlassian.theplugin.commons.cfg.PrivateServerCfgInfo;
/*     */ import com.atlassian.theplugin.commons.cfg.ProjectConfiguration;
/*     */ import com.atlassian.theplugin.commons.cfg.ProjectConfigurationDao;
/*     */ import com.atlassian.theplugin.commons.cfg.ServerCfg;
/*     */ import com.atlassian.theplugin.commons.cfg.ServerCfgFactoryException;
/*     */ import com.atlassian.theplugin.commons.cfg.ServerId;
/*     */ import com.atlassian.theplugin.commons.cfg.SharedServerList;
/*     */ import com.atlassian.theplugin.commons.util.LoggerImpl;
/*     */ import com.thoughtworks.xstream.XStream;
/*     */ import com.thoughtworks.xstream.io.HierarchicalStreamReader;
/*     */ import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
/*     */ import com.thoughtworks.xstream.io.xml.JDomReader;
/*     */ import com.thoughtworks.xstream.io.xml.JDomWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import org.jdom.Element;
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
/*     */ public class JDomProjectConfigurationDao
/*     */   implements ProjectConfigurationDao
/*     */ {
/*     */   private final Element publicElement;
/*     */   private final PrivateConfigurationDao privateConfigurationDao;
/*     */   private final UserSharedConfigurationDao sharedCfg;
/*     */   
/*     */   public JDomProjectConfigurationDao(Element element, @NotNull PrivateConfigurationDao privateConfigurationDao, @NotNull UserSharedConfigurationDao userSharedCfg) {
/*  46 */     if (element == null) {
/*  47 */       throw new IllegalArgumentException(String.valueOf(Element.class.getSimpleName()) + " cannot be null");
/*     */     }
/*     */ 
/*     */     
/*  51 */     if (privateConfigurationDao == null) {
/*  52 */       throw new IllegalArgumentException(String.valueOf(PrivateConfigurationDao.class.getSimpleName()) + " cannot be null");
/*     */     }
/*  54 */     this.publicElement = element;
/*  55 */     this.privateConfigurationDao = privateConfigurationDao;
/*  56 */     this.sharedCfg = userSharedCfg;
/*     */   }
/*     */ 
/*     */   
/*     */   public ProjectConfiguration load() throws ServerCfgFactoryException {
/*  61 */     PrivateProjectConfiguration ppc = new PrivateProjectConfiguration();
/*  62 */     ProjectConfiguration res = load(this.publicElement, ProjectConfiguration.class);
/*     */ 
/*     */ 
/*     */     
/*  66 */     SharedServerList sharedServers = this.sharedCfg.load();
/*  67 */     if (sharedServers != null) {
/*  68 */       Collection<ServerCfg> serversToAdd = new ArrayList<ServerCfg>();
/*  69 */       if (res.getServers().size() > 0) {
/*  70 */         for (ServerCfg sharedServer : sharedServers) {
/*     */           
/*  72 */           if (res.getServerCfg((ServerId)sharedServer.getServerId()) == null) {
/*  73 */             serversToAdd.add(sharedServer);
/*     */           }
/*     */         } 
/*     */       } else {
/*  77 */         serversToAdd.addAll((Collection<? extends ServerCfg>)sharedServers);
/*     */       } 
/*     */       
/*  80 */       res.getServers().addAll(serversToAdd);
/*     */     } 
/*     */     
/*  83 */     for (ServerCfg serverCfg : res.getServers()) {
/*     */       try {
/*  85 */         if (!serverCfg.isShared()) {
/*     */           
/*  87 */           PrivateServerCfgInfo privateServerCfgInfo = 
/*  88 */             this.privateConfigurationDao.load((ServerId)serverCfg.getServerId());
/*  89 */           if (privateServerCfgInfo != null) {
/*  90 */             ppc.add(privateServerCfgInfo);
/*     */           }
/*     */         } 
/*  93 */       } catch (ServerCfgFactoryException serverCfgFactoryException) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  98 */     return merge(res, ppc);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PrivateProjectConfiguration loadOldPrivateConfiguration(@NotNull Element privateElement) throws ServerCfgFactoryException {
/* 104 */     return load(privateElement, PrivateProjectConfiguration.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private <T> T load(Element rootElement, Class<T> clazz) throws ServerCfgFactoryException {
/* 109 */     int childCount = rootElement.getChildren().size();
/* 110 */     if (childCount != 1) {
/* 111 */       throw new ServerCfgFactoryException("Cannot travers JDom tree. Exactly one child node expected, but found [" + 
/* 112 */           childCount + "]");
/*     */     }
/* 114 */     JDomReader reader = new JDomReader(rootElement.getChildren().get(0));
/* 115 */     XStream xStream = JDomXStreamUtil.getProjectJDomXStream(false);
/*     */     try {
/* 117 */       return clazz.cast(xStream.unmarshal((HierarchicalStreamReader)reader));
/* 118 */     } catch (ClassCastException e) {
/* 119 */       throw new ServerCfgFactoryException("Cannot load " + clazz.getSimpleName() + " due to ClassCastException: " + 
/* 120 */           e.getMessage(), e);
/* 121 */     } catch (Exception e) {
/* 122 */       throw new ServerCfgFactoryException("Cannot load " + clazz.getSimpleName() + ": " + 
/* 123 */           e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ProjectConfiguration merge(ProjectConfiguration projectConfiguration, PrivateProjectConfiguration privateProjectConfiguration) {
/* 130 */     for (ServerCfg serverCfg : projectConfiguration.getServers()) {
/* 131 */       if (!serverCfg.isShared()) {
/* 132 */         PrivateServerCfgInfo psci = privateProjectConfiguration
/* 133 */           .getPrivateServerCfgInfo((ServerId)serverCfg.getServerId());
/* 134 */         serverCfg.mergePrivateConfiguration(psci);
/*     */       } 
/*     */     } 
/* 137 */     return projectConfiguration;
/*     */   }
/*     */   
/*     */   public void save(ProjectConfiguration projectConfiguration) {
/* 141 */     Collection<ServerCfg> privateServers = new ArrayList<ServerCfg>();
/* 142 */     SharedServerList gList = new SharedServerList();
/* 143 */     for (ServerCfg server : projectConfiguration.getServers()) {
/* 144 */       if (server.isShared()) {
/* 145 */         gList.add(server);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 152 */         if (this.privateConfigurationDao instanceof HomeDirPrivateConfigurationDao) {
/* 153 */           ((HomeDirPrivateConfigurationDao)this.privateConfigurationDao).deleteFile(server);
/*     */         }
/*     */         continue;
/*     */       } 
/*     */       try {
/* 158 */         this.privateConfigurationDao.save(server.createPrivateProjectConfiguration());
/* 159 */         privateServers.add(server);
/* 160 */       } catch (ServerCfgFactoryException serverCfgFactoryException) {
/* 161 */         LoggerImpl.getInstance().error("Cannot write private cfg file for server Uuid = " + 
/* 162 */             server.getServerId().getId());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 167 */     ProjectConfiguration configurationToSave = new ProjectConfiguration(projectConfiguration);
/* 168 */     configurationToSave.getServers().clear();
/* 169 */     configurationToSave.getServers().addAll(privateServers);
/* 170 */     save(configurationToSave, this.publicElement);
/*     */     
/*     */     try {
/* 173 */       this.sharedCfg.save(gList, projectConfiguration.getServers());
/* 174 */     } catch (ServerCfgFactoryException e) {
/* 175 */       LoggerImpl.getInstance().error("Cannot write private shared config file ", (Throwable)e);
/*     */     } 
/*     */   }
/*     */   
/*     */   void save(Object object, Element rootElement) {
/* 180 */     if (object == null) {
/* 181 */       throw new NullPointerException("Serialized object cannot be null");
/*     */     }
/* 183 */     JDomWriter writer = new JDomWriter(rootElement);
/* 184 */     XStream xStream = JDomXStreamUtil.getProjectJDomXStream(false);
/* 185 */     xStream.marshal(object, (HierarchicalStreamWriter)writer);
/*     */   }
/*     */ 
/*     */   
/*     */   static PrivateServerCfgInfo createPrivateProjectConfiguration(ServerCfg serverCfg) {
/* 190 */     return serverCfg.createPrivateProjectConfiguration();
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\xstream\JDomProjectConfigurationDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */