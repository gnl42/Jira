/*     */ package com.atlassian.theplugin.commons.cfg;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.ServerType;
/*     */ import com.atlassian.theplugin.commons.util.MiscUtil;
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
/*     */ 
/*     */ 
/*     */ public class ProjectConfiguration
/*     */ {
/*     */   private Collection<ServerCfg> servers;
/*     */   private ServerIdImpl defaultCrucibleServerId;
/*     */   private String defaultCrucibleProject;
/*     */   private String defaultCrucibleRepo;
/*     */   private ServerIdImpl defaultFishEyeServerId;
/*     */   private String defaultFishEyeRepo;
/*     */   private String fishEyeProjectPath;
/*     */   private ServerIdImpl defaultJiraServerId;
/*     */   private static final int HASHCODE_MAGIC = 31;
/*     */   
/*     */   public ProjectConfiguration(ProjectConfiguration other) {
/*  39 */     this.servers = cloneArrayList(other.getServers());
/*  40 */     this.defaultCrucibleServerId = other.defaultCrucibleServerId;
/*  41 */     this.defaultFishEyeServerId = other.defaultFishEyeServerId;
/*  42 */     this.defaultCrucibleProject = other.defaultCrucibleProject;
/*  43 */     this.defaultCrucibleRepo = other.defaultCrucibleRepo;
/*  44 */     this.defaultFishEyeRepo = other.defaultFishEyeRepo;
/*  45 */     this.fishEyeProjectPath = other.fishEyeProjectPath;
/*  46 */     this.defaultJiraServerId = other.defaultJiraServerId;
/*     */   }
/*     */   
/*     */   public static Collection<ServerCfg> cloneArrayList(Collection<ServerCfg> collection) {
/*  50 */     ArrayList<ServerCfg> res = new ArrayList<ServerCfg>(collection.size());
/*  51 */     for (ServerCfg serverCfg : collection) {
/*  52 */       res.add(serverCfg.getClone());
/*     */     }
/*  54 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   public ProjectConfiguration(Collection<ServerCfg> servers) {
/*  59 */     if (servers == null) {
/*  60 */       throw new NullPointerException("Servers cannot be null");
/*     */     }
/*  62 */     this.servers = servers;
/*     */   }
/*     */   
/*     */   public ProjectConfiguration() {
/*  66 */     this.servers = MiscUtil.buildArrayList();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  71 */     if (this == o) {
/*  72 */       return true;
/*     */     }
/*  74 */     if (!(o instanceof ProjectConfiguration)) {
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     ProjectConfiguration that = (ProjectConfiguration)o;
/*     */     
/*  80 */     if ((this.defaultCrucibleProject != null) ? 
/*  81 */       !this.defaultCrucibleProject.equals(that.defaultCrucibleProject) : (
/*  82 */       that.defaultCrucibleProject != null)) {
/*  83 */       return false;
/*     */     }
/*  85 */     if ((this.defaultCrucibleServerId != null) ? 
/*  86 */       !this.defaultCrucibleServerId.equals(that.defaultCrucibleServerId) : (
/*  87 */       that.defaultCrucibleServerId != null)) {
/*  88 */       return false;
/*     */     }
/*  90 */     if ((this.defaultCrucibleRepo != null) ? 
/*  91 */       !this.defaultCrucibleRepo.equals(that.defaultCrucibleRepo) : (
/*  92 */       that.defaultCrucibleRepo != null)) {
/*  93 */       return false;
/*     */     }
/*  95 */     if ((this.defaultFishEyeServerId != null) ? 
/*  96 */       !this.defaultFishEyeServerId.equals(that.defaultFishEyeServerId) : (
/*  97 */       that.defaultFishEyeServerId != null)) {
/*  98 */       return false;
/*     */     }
/* 100 */     if ((this.defaultFishEyeRepo != null) ? 
/* 101 */       !this.defaultFishEyeRepo.equals(that.defaultFishEyeRepo) : (
/* 102 */       that.defaultFishEyeRepo != null)) {
/* 103 */       return false;
/*     */     }
/* 105 */     if ((this.fishEyeProjectPath != null) ? 
/* 106 */       !this.fishEyeProjectPath.equals(that.fishEyeProjectPath) : (
/* 107 */       that.fishEyeProjectPath != null)) {
/* 108 */       return false;
/*     */     }
/* 110 */     if ((this.defaultJiraServerId != null) ? 
/* 111 */       !this.defaultJiraServerId.equals(that.defaultJiraServerId) : (
/* 112 */       that.defaultJiraServerId != null)) {
/* 113 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 117 */     if (!this.servers.equals(that.servers)) {
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 127 */     int result = this.servers.hashCode();
/* 128 */     result = 31 * result + ((this.defaultCrucibleServerId != null) ? this.defaultCrucibleServerId.hashCode() : 0);
/* 129 */     result = 31 * result + ((this.defaultFishEyeServerId != null) ? this.defaultFishEyeServerId.hashCode() : 0);
/* 130 */     result = 31 * result + ((this.defaultCrucibleProject != null) ? this.defaultCrucibleProject.hashCode() : 0);
/* 131 */     result = 31 * result + ((this.defaultCrucibleRepo != null) ? this.defaultCrucibleRepo.hashCode() : 0);
/* 132 */     result = 31 * result + ((this.fishEyeProjectPath != null) ? this.fishEyeProjectPath.hashCode() : 0);
/* 133 */     result = 31 * result + ((this.defaultJiraServerId != null) ? this.defaultJiraServerId.hashCode() : 0);
/* 134 */     return result;
/*     */   }
/*     */   
/*     */   public Collection<ServerCfg> getServers() {
/* 138 */     return this.servers;
/*     */   }
/*     */   
/*     */   public ServerCfg getServerCfg(ServerId serverId) {
/* 142 */     for (ServerCfg serverCfg : this.servers) {
/* 143 */       if (serverId.equals(serverCfg.getServerId())) {
/* 144 */         return serverCfg;
/*     */       }
/*     */     } 
/* 147 */     return null;
/*     */   }
/*     */   
/*     */   public static ProjectConfiguration emptyConfiguration() {
/* 151 */     return new ProjectConfiguration();
/*     */   }
/*     */   
/*     */   public ProjectConfiguration getClone() {
/* 155 */     return new ProjectConfiguration(this);
/*     */   }
/*     */   
/*     */   public ServerIdImpl getDefaultCrucibleServerId() {
/* 159 */     if (this.defaultCrucibleServerId == null && getAllCrucibleServers().size() == 1) {
/*     */       
/* 161 */       CrucibleServerCfg serverCfg = getAllCrucibleServers().iterator().next();
/* 162 */       if (serverCfg.isEnabled()) {
/* 163 */         this.defaultCrucibleServerId = serverCfg.getServerId();
/*     */       }
/*     */     } 
/*     */     
/* 167 */     return this.defaultCrucibleServerId;
/*     */   }
/*     */   
/*     */   public CrucibleServerCfg getDefaultCrucibleServer() {
/* 171 */     if (getDefaultCrucibleServerId() == null) {
/* 172 */       return null;
/*     */     }
/*     */     
/* 175 */     ServerCfg serverCfg = getServerCfg(getDefaultCrucibleServerId());
/*     */ 
/*     */ 
/*     */     
/* 179 */     CrucibleServerCfg crucible = (CrucibleServerCfg)serverCfg;
/* 180 */     if (crucible == null || !crucible.isEnabled()) {
/* 181 */       return null;
/*     */     }
/* 183 */     return crucible;
/*     */   }
/*     */   
/*     */   public void setDefaultCrucibleServerId(ServerIdImpl defaultCrucibleServerId) {
/* 187 */     this.defaultCrucibleServerId = defaultCrucibleServerId;
/* 188 */     if (defaultCrucibleServerId == null) {
/* 189 */       setDefaultCrucibleProject(null);
/* 190 */       setDefaultCrucibleRepo(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ServerIdImpl getDefaultFishEyeServerId() {
/* 195 */     if (this.defaultFishEyeServerId == null && getAllFisheyeServers().size() == 1) {
/* 196 */       FishEyeServerCfg cfg = getAllFisheyeServers().iterator().next();
/* 197 */       if (cfg.isEnabled()) {
/* 198 */         this.defaultFishEyeServerId = cfg.getServerId();
/*     */       }
/*     */     } 
/* 201 */     return this.defaultFishEyeServerId;
/*     */   }
/*     */   
/*     */   public FishEyeServer getDefaultFishEyeServer() {
/* 205 */     if (getDefaultFishEyeServerId() == null) {
/* 206 */       return null;
/*     */     }
/*     */     
/* 209 */     ServerCfg serverCfg = getServerCfg(getDefaultFishEyeServerId());
/*     */ 
/*     */ 
/*     */     
/* 213 */     if (serverCfg == null || !serverCfg.isEnabled()) {
/* 214 */       return null;
/*     */     }
/*     */     
/* 217 */     FishEyeServer res = serverCfg.asFishEyeServer();
/* 218 */     if (res == null || !res.isEnabled()) {
/* 219 */       return null;
/*     */     }
/* 221 */     return res;
/*     */   }
/*     */   
/*     */   public void setDefaultFishEyeServerId(ServerIdImpl defaultFishEyeServerId) {
/* 225 */     this.defaultFishEyeServerId = defaultFishEyeServerId;
/* 226 */     if (defaultFishEyeServerId == null) {
/* 227 */       this.defaultFishEyeRepo = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public ServerId getDefaultJiraServerId() {
/* 232 */     if (this.defaultJiraServerId == null && getAllJIRAServers().size() == 1) {
/* 233 */       JiraServerCfg jiraServerCfg = getAllJIRAServers().iterator().next();
/* 234 */       if (jiraServerCfg.isEnabled()) {
/* 235 */         this.defaultJiraServerId = jiraServerCfg.getServerId();
/*     */       }
/*     */     } 
/*     */     
/* 239 */     return this.defaultJiraServerId;
/*     */   }
/*     */   
/*     */   public JiraServerCfg getDefaultJiraServer() {
/* 243 */     if (getDefaultJiraServerId() == null) {
/* 244 */       return null;
/*     */     }
/*     */     
/* 247 */     ServerCfg serverCfg = getServerCfg(getDefaultJiraServerId());
/*     */ 
/*     */ 
/*     */     
/* 251 */     JiraServerCfg jiraServerCfg = (JiraServerCfg)serverCfg;
/* 252 */     if (jiraServerCfg == null || !jiraServerCfg.isEnabled()) {
/* 253 */       return null;
/*     */     }
/* 255 */     return jiraServerCfg;
/*     */   }
/*     */   
/*     */   public void setDefaultJiraServerId(ServerIdImpl defaultJiraServerId) {
/* 259 */     this.defaultJiraServerId = defaultJiraServerId;
/*     */   }
/*     */   
/*     */   public String getDefaultCrucibleProject() {
/* 263 */     return this.defaultCrucibleProject;
/*     */   }
/*     */   
/*     */   public void setDefaultCrucibleProject(String defaultCrucibleProject) {
/* 267 */     this.defaultCrucibleProject = defaultCrucibleProject;
/*     */   }
/*     */   
/*     */   public String getDefaultCrucibleRepo() {
/* 271 */     return this.defaultCrucibleRepo;
/*     */   }
/*     */   
/*     */   public void setDefaultCrucibleRepo(String defaultCrucibleRepo) {
/* 275 */     this.defaultCrucibleRepo = defaultCrucibleRepo;
/*     */   }
/*     */   
/*     */   public String getFishEyeProjectPath() {
/* 279 */     return this.fishEyeProjectPath;
/*     */   }
/*     */   
/*     */   public void setFishEyeProjectPath(String fishEyeProjectPath) {
/* 283 */     this.fishEyeProjectPath = fishEyeProjectPath;
/*     */   }
/*     */   
/*     */   public String getDefaultFishEyeRepo() {
/* 287 */     return this.defaultFishEyeRepo;
/*     */   }
/*     */   
/*     */   public void setDefaultFishEyeRepo(String defaultFishEyeRepo) {
/* 291 */     this.defaultFishEyeRepo = defaultFishEyeRepo;
/*     */   }
/*     */   
/*     */   public boolean isDefaultFishEyeServerValid() {
/* 295 */     if (getDefaultFishEyeServerId() == null) {
/* 296 */       return true;
/*     */     }
/*     */     
/* 299 */     ServerCfg serverCfg = getServerCfg(getDefaultFishEyeServerId());
/* 300 */     if (serverCfg == null) {
/* 301 */       return false;
/*     */     }
/*     */     
/* 304 */     FishEyeServer fishEye = serverCfg.asFishEyeServer();
/* 305 */     return (fishEye != null && fishEye.isEnabled());
/*     */   }
/*     */   
/*     */   public boolean isDefaultCrucibleServerValid() {
/* 309 */     if (getDefaultCrucibleServerId() == null) {
/* 310 */       return true;
/*     */     }
/*     */     
/* 313 */     ServerCfg serverCfg = getServerCfg(getDefaultCrucibleServerId());
/*     */ 
/*     */ 
/*     */     
/* 317 */     CrucibleServerCfg crucible = (CrucibleServerCfg)serverCfg;
/* 318 */     return (crucible != null && crucible.isEnabled());
/*     */   }
/*     */   
/*     */   public boolean isDefaultJiraServerValid() {
/* 322 */     if (getDefaultJiraServerId() == null) {
/* 323 */       return true;
/*     */     }
/*     */     
/* 326 */     ServerCfg serverCfg = getServerCfg(getDefaultJiraServerId());
/*     */ 
/*     */ 
/*     */     
/* 330 */     JiraServerCfg jiraServerCfg = (JiraServerCfg)serverCfg;
/* 331 */     return (jiraServerCfg != null && jiraServerCfg.isEnabled());
/*     */   }
/*     */   
/*     */   public Collection<JiraServerCfg> getAllJIRAServers() {
/* 335 */     Collection<JiraServerCfg> jiraServers = MiscUtil.buildArrayList();
/*     */     
/* 337 */     for (ServerCfg server : this.servers) {
/* 338 */       if (server.getServerType() == ServerType.JIRA_SERVER && server instanceof JiraServerCfg) {
/* 339 */         jiraServers.add((JiraServerCfg)server);
/*     */       }
/*     */     } 
/*     */     
/* 343 */     return jiraServers;
/*     */   }
/*     */   
/*     */   public Collection<BambooServerCfg> getAllBambooServers() {
/* 347 */     Collection<BambooServerCfg> bambooServers = MiscUtil.buildArrayList();
/*     */     
/* 349 */     for (ServerCfg server : this.servers) {
/* 350 */       if (server.getServerType() == ServerType.BAMBOO_SERVER && server instanceof BambooServerCfg) {
/* 351 */         bambooServers.add((BambooServerCfg)server);
/*     */       }
/*     */     } 
/*     */     
/* 355 */     return bambooServers;
/*     */   }
/*     */   
/*     */   public Collection<CrucibleServerCfg> getAllCrucibleServers() {
/* 359 */     Collection<CrucibleServerCfg> crucibleServers = MiscUtil.buildArrayList();
/*     */     
/* 361 */     for (ServerCfg server : this.servers) {
/* 362 */       if (server.getServerType() == ServerType.CRUCIBLE_SERVER && server instanceof CrucibleServerCfg) {
/* 363 */         crucibleServers.add((CrucibleServerCfg)server);
/*     */       }
/*     */     } 
/* 366 */     return crucibleServers;
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<FishEyeServerCfg> getAllFisheyeServers() {
/* 371 */     Collection<FishEyeServerCfg> fisheyeServers = MiscUtil.buildArrayList();
/*     */     
/* 373 */     for (ServerCfg server : this.servers) {
/* 374 */       if (server.getServerType() == ServerType.FISHEYE_SERVER && server instanceof FishEyeServerCfg) {
/* 375 */         fisheyeServers.add((FishEyeServerCfg)server);
/*     */       }
/*     */     } 
/*     */     
/* 379 */     return fisheyeServers;
/*     */   }
/*     */   
/*     */   public Collection<ServerCfg> getAllEnabledServersWithDefaultCredentials() {
/* 383 */     Collection<ServerCfg> defServers = MiscUtil.buildArrayList();
/* 384 */     for (ServerCfg server : this.servers) {
/* 385 */       if (server.isUseDefaultCredentials() && server.isEnabled()) {
/* 386 */         defServers.add(server);
/*     */       }
/*     */     } 
/* 389 */     return defServers;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\ProjectConfiguration.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */