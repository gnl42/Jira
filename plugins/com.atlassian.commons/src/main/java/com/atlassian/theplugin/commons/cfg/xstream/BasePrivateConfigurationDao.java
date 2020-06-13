/*     */ package com.atlassian.theplugin.commons.cfg.xstream;
/*     */ import com.atlassian.theplugin.commons.cfg.ServerCfgFactoryException;
/*     */ import com.thoughtworks.xstream.XStream;
/*     */ import com.thoughtworks.xstream.io.HierarchicalStreamReader;
/*     */ import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
/*     */ import com.thoughtworks.xstream.io.xml.JDomReader;
/*     */ import com.thoughtworks.xstream.io.xml.JDomWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.nio.charset.Charset;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.output.Format;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public abstract class BasePrivateConfigurationDao<T> {
/*     */   private static final String ATLASSIAN_DIR_NAME = ".atlassian";
/*     */   
/*     */   void writeXmlFile(Element element, @NotNull File outputFile) throws IOException {
/*  24 */     StringWriter sw = new StringWriter();
/*  25 */     (new XMLOutputter(Format.getPrettyFormat())).output(element, sw);
/*  26 */     sw.flush();
/*  27 */     sw.close();
/*  28 */     String str = sw.toString();
/*     */ 
/*     */     
/*  31 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(outputFile), 
/*  32 */         Charset.forName("UTF-8").newEncoder());
/*  33 */     PrintWriter out = new PrintWriter(new BufferedWriter(outputStreamWriter));
/*  34 */     out.write(str);
/*  35 */     out.flush();
/*  36 */     out.close();
/*     */   }
/*     */   private static final String ATLASSIAN_IDE_CONNECTOR_DIR_NAME = "ide-connector";
/*     */   static void saveJDom(Object object, Element rootElement) {
/*  40 */     if (object == null) {
/*  41 */       throw new NullPointerException("Serialized object cannot be null");
/*     */     }
/*  43 */     JDomWriter writer = new JDomWriter(rootElement);
/*  44 */     XStream xStream = JDomXStreamUtil.getProjectJDomXStream(true);
/*  45 */     xStream.marshal(object, (HierarchicalStreamWriter)writer);
/*     */   }
/*     */   
/*     */   public static String getPrivateCfgDirectoryPath() {
/*  49 */     return String.valueOf(System.getProperty("user.home")) + File.separator + ".atlassian" + 
/*  50 */       File.separator + "ide-connector";
/*     */   }
/*     */   
/*     */   abstract String getRootElementName();
/*     */   
/*     */   public Document createJDom(T t) {
/*  56 */     Document document = new Document(new Element(getRootElementName()));
/*  57 */     saveJDom(t, document.getRootElement());
/*  58 */     return document;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static File getPrivateCfgDirectorySavePath() throws ServerCfgFactoryException {
/*  63 */     File ideConnectorHomeDir = new File(getPrivateCfgDirectoryPath());
/*  64 */     if (!ideConnectorHomeDir.exists() && 
/*  65 */       !ideConnectorHomeDir.mkdirs()) {
/*  66 */       throw new ServerCfgFactoryException("Cannot create directory [" + ideConnectorHomeDir.getAbsolutePath() + "]");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  71 */     if (ideConnectorHomeDir.isDirectory() && ideConnectorHomeDir.canWrite()) {
/*  72 */       return ideConnectorHomeDir;
/*     */     }
/*  74 */     throw new ServerCfgFactoryException("[" + ideConnectorHomeDir.getAbsolutePath() + "] is not writable" + 
/*  75 */         " or is not a directory");
/*     */   }
/*     */ 
/*     */   
/*     */   protected static <T1> T1 loadJDom(Element rootElement, Class<T1> clazz, Boolean saveAll) throws ServerCfgFactoryException {
/*  80 */     int childCount = rootElement.getChildren().size();
/*  81 */     if (childCount != 1) {
/*  82 */       throw new ServerCfgFactoryException("Cannot travers JDom tree. Exactly one child node expected, but found [" + 
/*  83 */           childCount + "]");
/*     */     }
/*  85 */     JDomReader reader = new JDomReader(rootElement.getChildren().get(0));
/*  86 */     XStream xStream = JDomXStreamUtil.getProjectJDomXStream(saveAll.booleanValue());
/*     */     try {
/*  88 */       return clazz.cast(xStream.unmarshal((HierarchicalStreamReader)reader));
/*  89 */     } catch (ClassCastException e) {
/*  90 */       throw new ServerCfgFactoryException("Cannot load " + clazz.getSimpleName() + " due to ClassCastException: " + 
/*  91 */           e.getMessage(), e);
/*  92 */     } catch (Exception e) {
/*  93 */       throw new ServerCfgFactoryException("Cannot load " + clazz.getSimpleName() + ": " + 
/*  94 */           e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isDirReady() throws ServerCfgFactoryException {
/*  99 */     File atlassianDir = getPrivateCfgDirectorySavePath();
/*     */     
/* 101 */     return (atlassianDir.isDirectory() && atlassianDir.canRead());
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\xstream\BasePrivateConfigurationDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */