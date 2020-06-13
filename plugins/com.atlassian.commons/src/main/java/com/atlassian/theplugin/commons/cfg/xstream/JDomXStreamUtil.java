/*     */ package com.atlassian.theplugin.commons.cfg.xstream;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.cfg.BambooServerCfg;
/*     */ import com.atlassian.theplugin.commons.cfg.CrucibleServerCfg;
/*     */ import com.atlassian.theplugin.commons.cfg.FishEyeServerCfg;
/*     */ import com.atlassian.theplugin.commons.cfg.JiraServerCfg;
/*     */ import com.atlassian.theplugin.commons.cfg.PrivateBambooServerCfgInfo;
/*     */ import com.atlassian.theplugin.commons.cfg.PrivateProjectConfiguration;
/*     */ import com.atlassian.theplugin.commons.cfg.PrivateServerCfgInfo;
/*     */ import com.atlassian.theplugin.commons.cfg.ProjectConfiguration;
/*     */ import com.atlassian.theplugin.commons.cfg.ServerCfg;
/*     */ import com.atlassian.theplugin.commons.cfg.ServerIdImpl;
/*     */ import com.atlassian.theplugin.commons.cfg.SharedServerList;
/*     */ import com.atlassian.theplugin.commons.cfg.SubscribedPlan;
/*     */ import com.thoughtworks.xstream.XStream;
/*     */ import com.thoughtworks.xstream.converters.Converter;
/*     */ import com.thoughtworks.xstream.converters.MarshallingContext;
/*     */ import com.thoughtworks.xstream.converters.UnmarshallingContext;
/*     */ import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
/*     */ import com.thoughtworks.xstream.converters.reflection.Sun14ReflectionProvider;
/*     */ import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
/*     */ import com.thoughtworks.xstream.io.HierarchicalStreamReader;
/*     */ import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
/*     */ import com.thoughtworks.xstream.io.xml.JDomDriver;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JDomXStreamUtil
/*     */ {
/*     */   private static final String PLAN = "plan";
/*     */   private static final String PLAN_KEY = "key";
/*     */   private static final String GROUPED_KEY = "grouped";
/*     */   
/*     */   public static XStream getProjectJDomXStream() {
/*  51 */     return getProjectJDomXStream(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XStream getProjectJDomXStream(boolean saveAll) {
/*  57 */     XStream xStream = new XStream((ReflectionProvider)new Sun14ReflectionProvider(), (HierarchicalStreamDriver)new JDomDriver());
/*  58 */     xStream.setMode(1002);
/*  59 */     xStream.alias("bamboo", BambooServerCfg.class);
/*  60 */     xStream.alias("crucible", CrucibleServerCfg.class);
/*  61 */     xStream.alias("jira", JiraServerCfg.class);
/*  62 */     xStream.alias("fisheye", FishEyeServerCfg.class);
/*     */     
/*  64 */     xStream.alias("plan", SubscribedPlan.class);
/*     */     
/*  66 */     xStream.omitField(ServerCfg.class, "deleted");
/*     */     
/*  68 */     if (!saveAll) {
/*  69 */       xStream.omitField(ServerCfg.class, "username");
/*  70 */       xStream.omitField(ServerCfg.class, "password");
/*  71 */       xStream.omitField(ServerCfg.class, "isPasswordStored");
/*  72 */       xStream.omitField(ServerCfg.class, "useDefaultCredentials");
/*     */       
/*  74 */       xStream.omitField(JiraServerCfg.class, "dontUseBasicAuth");
/*  75 */       xStream.omitField(JiraServerCfg.class, "basicHttpUser");
/*     */       
/*  77 */       xStream.omitField(BambooServerCfg.class, "timezoneOffset");
/*  78 */       xStream.omitField(CrucibleServerCfg.class, "fishEyeView");
/*     */     } 
/*     */     
/*  81 */     xStream.aliasField("server-id", ServerCfg.class, "serverId");
/*     */     
/*  83 */     if (!saveAll) {
/*  84 */       xStream.omitField(ServerCfg.class, "isEnabled");
/*     */     }
/*  86 */     xStream.aliasField("use-favourites", ServerCfg.class, "isUseFavourites");
/*  87 */     xStream.aliasField("bamboo2", ServerCfg.class, "isBamboo2");
/*  88 */     xStream.aliasField("show-branches", ServerCfg.class, "showBranches");
/*  89 */     xStream.aliasField("my-branches-only", ServerCfg.class, "myBranchesOnly");
/*     */     
/*  91 */     xStream.alias("project-configuration", ProjectConfiguration.class);
/*  92 */     xStream.aliasField("default-crucible-server", ProjectConfiguration.class, "defaultCrucibleServerId");
/*  93 */     xStream.aliasField("default-crucible-project", ProjectConfiguration.class, "defaultCrucibleProject");
/*  94 */     xStream.aliasField("default-crucible-repo", ProjectConfiguration.class, "defaultCrucibleRepo");
/*  95 */     xStream.aliasField("default-fisheye-server", ProjectConfiguration.class, "defaultFishEyeServerId");
/*  96 */     xStream.aliasField("default-fisheye-repo", ProjectConfiguration.class, "defaultFishEyeRepo");
/*  97 */     xStream.aliasField("fisheye-project-path", ProjectConfiguration.class, "fishEyeProjectPath");
/*  98 */     xStream.aliasField("default-jira-server", ProjectConfiguration.class, "defaultJiraServerId");
/*     */     
/* 100 */     xStream.alias("private-server-cfg", PrivateServerCfgInfo.class);
/* 101 */     xStream.alias("private-bamboo-server-cfg", PrivateBambooServerCfgInfo.class);
/* 102 */     xStream.aliasField("server-id", PrivateServerCfgInfo.class, "serverId");
/* 103 */     xStream.aliasField("enabled", PrivateServerCfgInfo.class, "isEnabled");
/* 104 */     xStream.aliasField("timezone-offset", PrivateBambooServerCfgInfo.class, "timezoneOffset");
/* 105 */     xStream.aliasField("used-default-credentials", PrivateServerCfgInfo.class, "useDefaultCredentials");
/* 106 */     xStream.aliasField("basic-password", PrivateServerCfgInfo.class, "basicPassword");
/* 107 */     xStream.aliasField("basic-username", PrivateServerCfgInfo.class, "basicUsername");
/* 108 */     xStream.aliasField("use-http-basic", PrivateServerCfgInfo.class, "useHttpBasic");
/*     */     
/* 110 */     xStream.registerLocalConverter(PrivateServerCfgInfo.class, "password", new EncodedStringConverter());
/* 111 */     xStream.registerLocalConverter(PrivateServerCfgInfo.class, "basicPassword", new EncodedStringConverter());
/*     */ 
/*     */     
/* 114 */     xStream.alias("private-project-cfg", PrivateProjectConfiguration.class);
/* 115 */     xStream.aliasField("private-server-cfgs", PrivateProjectConfiguration.class, "privateServerCfgInfos");
/* 116 */     xStream.aliasField("plans", PrivateProjectConfiguration.class, "plans");
/* 117 */     xStream.aliasField("useFavourites", PrivateProjectConfiguration.class, "use-favourites");
/* 118 */     xStream.aliasField("showBranches", PrivateProjectConfiguration.class, "show-branches");
/* 119 */     xStream.aliasField("myBranchesOnly", PrivateProjectConfiguration.class, "my-branches-only");
/*     */ 
/*     */     
/* 122 */     xStream.aliasField("plans", BambooServerCfg.class, "plans");
/* 123 */     xStream.registerLocalConverter(ServerCfg.class, "password", new EncodedStringConverter());
/*     */ 
/*     */     
/* 126 */     xStream.alias("shared-server-list", SharedServerList.class);
/*     */     
/* 128 */     xStream.addDefaultImplementation(ArrayList.class, Collection.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     xStream.registerConverter(new Converter()
/*     */         {
/*     */           public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
/* 163 */             SubscribedPlan value = (SubscribedPlan)source;
/* 164 */             writer.addAttribute("key", value.getKey());
/* 165 */             writer.addAttribute("grouped", value.isGrouped() ? "1" : "0");
/*     */           }
/*     */ 
/*     */           
/*     */           public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
/* 170 */             return new SubscribedPlan(reader.getAttribute("key"), 
/* 171 */                 "1".equals(reader.getAttribute("grouped")));
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean canConvert(Class<?> aClass) {
/* 176 */             return SubscribedPlan.class.isAssignableFrom(aClass);
/*     */           }
/*     */         });
/* 179 */     xStream.registerConverter(new Converter()
/*     */         {
/*     */           public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
/* 182 */             ServerIdImpl value = (ServerIdImpl)source;
/* 183 */             writer.setValue(value.getId());
/*     */           }
/*     */           
/*     */           public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
/* 187 */             return new ServerIdImpl(reader.getValue());
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean canConvert(Class type) {
/* 192 */             return type.equals(ServerIdImpl.class);
/*     */           }
/*     */         });
/* 195 */     return xStream;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\xstream\JDomXStreamUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */