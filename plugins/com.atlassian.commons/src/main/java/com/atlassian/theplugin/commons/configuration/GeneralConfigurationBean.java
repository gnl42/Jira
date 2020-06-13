/*     */ package com.atlassian.theplugin.commons.configuration;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.util.Version;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GeneralConfigurationBean
/*     */ {
/*     */   private boolean autoUpdateEnabled = true;
/*  36 */   private Version rejectedUpgrade = Version.NULL_VERSION;
/*     */   private boolean checkUnstableVersionsEnabled;
/*     */   private Boolean anonymousEnhancedFeedbackEnabled;
/*     */   private boolean useIdeaProxySettings = true;
/*     */   private boolean httpServerEnabled = true;
/*  41 */   private Collection<String> certs = new HashSet<String>();
/*  42 */   private Map<String, Integer> statsCountersMap = Collections.synchronizedMap(new HashMap<String, Integer>());
/*     */   
/*  44 */   private long uid = 0L;
/*     */   private static final double ID_DISCRIMINATOR = 1000.0D;
/*  46 */   private CheckNowButtonOption checkNowButtonOption = CheckNowButtonOption.ONLY_STABLE;
/*     */   
/*     */   public static final int HTTP_SERVER_PORT = 51235;
/*  49 */   private int httpServerPort = 51235;
/*     */   
/*     */   private boolean askedAboutDefaultServers = false;
/*     */   private boolean informedAboutIdea9TaskExperimentalSupport = false;
/*     */   private static final int THIRTY_ONE = 31;
/*     */   private static final int THIRTY_TWO = 32;
/*     */   
/*     */   public GeneralConfigurationBean() {}
/*     */   
/*     */   public GeneralConfigurationBean(GeneralConfigurationBean generalConfigurationData) {
/*  59 */     this.anonymousEnhancedFeedbackEnabled = generalConfigurationData.getAnonymousEnhancedFeedbackEnabled();
/*  60 */     this.rejectedUpgrade = generalConfigurationData.getRejectedUpgrade();
/*  61 */     this.checkUnstableVersionsEnabled = generalConfigurationData.isCheckUnstableVersionsEnabled();
/*  62 */     this.autoUpdateEnabled = generalConfigurationData.isAutoUpdateEnabled();
/*  63 */     this.httpServerEnabled = generalConfigurationData.isHttpServerEnabled();
/*  64 */     this.httpServerPort = generalConfigurationData.getHttpServerPort();
/*  65 */     this.uid = generalConfigurationData.getUid();
/*  66 */     this.useIdeaProxySettings = generalConfigurationData.getUseIdeaProxySettings();
/*  67 */     this.certs = generalConfigurationData.getCerts();
/*  68 */     this.statsCountersMap = Collections.synchronizedMap(generalConfigurationData.getStatsCountersMap());
/*  69 */     this.checkNowButtonOption = generalConfigurationData.getCheckNowButtonOption();
/*  70 */     this.askedAboutDefaultServers = generalConfigurationData.isAskedAboutDefaultServers();
/*  71 */     this.informedAboutIdea9TaskExperimentalSupport = 
/*  72 */       generalConfigurationData.isInformedAboutIdea9TaskExperimentalSupport();
/*     */   }
/*     */   
/*     */   public long getUid() {
/*  76 */     if (this.uid == 0L)
/*     */     {
/*  78 */       this.uid = System.currentTimeMillis() + (long)(Math.random() * 1000.0D);
/*     */     }
/*  80 */     return this.uid;
/*     */   }
/*     */   
/*     */   public void setUid(long uid) {
/*  84 */     this.uid = uid;
/*     */   }
/*     */   
/*     */   public boolean isAutoUpdateEnabled() {
/*  88 */     return this.autoUpdateEnabled;
/*     */   }
/*     */   
/*     */   public void setAutoUpdateEnabled(boolean autoUpdateEnabled) {
/*  92 */     this.autoUpdateEnabled = autoUpdateEnabled;
/*     */   }
/*     */   
/*     */   public boolean isHttpServerEnabled() {
/*  96 */     return this.httpServerEnabled;
/*     */   }
/*     */   
/*     */   public void setHttpServerEnabled(boolean httpServerEnabled) {
/* 100 */     this.httpServerEnabled = httpServerEnabled;
/*     */   }
/*     */   
/*     */   public int getHttpServerPort() {
/* 104 */     return this.httpServerPort;
/*     */   }
/*     */   
/*     */   public void setHttpServerPort(int port) {
/* 108 */     this.httpServerPort = port;
/*     */   }
/*     */   
/*     */   public Version getRejectedUpgrade() {
/* 112 */     return this.rejectedUpgrade;
/*     */   }
/*     */   
/*     */   public void setRejectedUpgrade(Version rejectedUpgrade) {
/* 116 */     this.rejectedUpgrade = rejectedUpgrade;
/*     */   }
/*     */   
/*     */   public void setCheckUnstableVersionsEnabled(boolean checkUnstableVersionsEnabled) {
/* 120 */     this.checkUnstableVersionsEnabled = checkUnstableVersionsEnabled;
/*     */   }
/*     */   
/*     */   public boolean isCheckUnstableVersionsEnabled() {
/* 124 */     return this.checkUnstableVersionsEnabled;
/*     */   }
/*     */   
/*     */   public Boolean getAnonymousEnhancedFeedbackEnabled() {
/* 128 */     return this.anonymousEnhancedFeedbackEnabled;
/*     */   }
/*     */   
/*     */   public void setAnonymousEnhancedFeedbackEnabled(Boolean isAnonymousEnhancedFeedbackEnabled) {
/* 132 */     this.anonymousEnhancedFeedbackEnabled = isAnonymousEnhancedFeedbackEnabled;
/*     */   }
/*     */   
/*     */   public boolean getUseIdeaProxySettings() {
/* 136 */     return this.useIdeaProxySettings;
/*     */   }
/*     */   
/*     */   public synchronized Collection<String> getCerts() {
/* 140 */     return this.certs;
/*     */   }
/*     */   
/*     */   public synchronized void setCerts(Collection<String> certs) {
/* 144 */     this.certs = certs;
/*     */   }
/*     */   
/*     */   public void setUseIdeaProxySettings(boolean use) {
/* 148 */     this.useIdeaProxySettings = use;
/*     */   }
/*     */   
/*     */   public CheckNowButtonOption getCheckNowButtonOption() {
/* 152 */     return this.checkNowButtonOption;
/*     */   }
/*     */   
/*     */   public void setCheckNowButtonOption(CheckNowButtonOption checkNowButtonOption) {
/* 156 */     this.checkNowButtonOption = checkNowButtonOption;
/*     */   }
/*     */   
/*     */   public Map<String, Integer> getStatsCountersMap() {
/* 160 */     return this.statsCountersMap;
/*     */   }
/*     */   
/*     */   public synchronized void addCounterIfNotPresent(String counterName) {
/* 164 */     if (!getStatsCountersMap().containsKey(counterName)) {
/* 165 */       getStatsCountersMap().put(counterName, Integer.valueOf(0));
/*     */     }
/*     */   }
/*     */   
/*     */   public void bumpCounter(String counterName) {
/* 170 */     Boolean enabled = getAnonymousEnhancedFeedbackEnabled();
/* 171 */     if (enabled == null || !enabled.booleanValue()) {
/*     */       return;
/*     */     }
/*     */     
/* 175 */     synchronized (getStatsCountersMap()) {
/* 176 */       if (getStatsCountersMap().containsKey(counterName)) {
/* 177 */         getStatsCountersMap().put(counterName, Integer.valueOf(((Integer)getStatsCountersMap().get(counterName)).intValue() + 1));
/*     */       } else {
/* 179 */         getStatsCountersMap().put(counterName, Integer.valueOf(1));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isAskedAboutDefaultServers() {
/* 185 */     return this.askedAboutDefaultServers;
/*     */   }
/*     */   
/*     */   public boolean isInformedAboutIdea9TaskExperimentalSupport() {
/* 189 */     return this.informedAboutIdea9TaskExperimentalSupport;
/*     */   }
/*     */   
/*     */   public void setInformedAboutIdea9TaskExperimentalSupport(boolean informedAboutIdea9TaskExperimentalSupport) {
/* 193 */     this.informedAboutIdea9TaskExperimentalSupport = informedAboutIdea9TaskExperimentalSupport;
/*     */   }
/*     */   
/*     */   public void setAskedAboutDefaultServers(boolean askedAboutDefaultServers) {
/* 197 */     this.askedAboutDefaultServers = askedAboutDefaultServers;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetCounter(String counterName) {
/* 202 */     getStatsCountersMap().put(counterName, Integer.valueOf(0));
/*     */   }
/*     */   
/*     */   public void setStatsCountersMap(Map<String, Integer> statsCountersMap) {
/* 206 */     this.statsCountersMap = Collections.synchronizedMap(statsCountersMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 211 */     if (this == o) {
/* 212 */       return true;
/*     */     }
/* 214 */     if (o == null || getClass() != o.getClass()) {
/* 215 */       return false;
/*     */     }
/*     */     
/* 218 */     GeneralConfigurationBean that = (GeneralConfigurationBean)o;
/*     */     
/* 220 */     if (this.autoUpdateEnabled != that.autoUpdateEnabled) {
/* 221 */       return false;
/*     */     }
/* 223 */     if (this.httpServerEnabled != that.httpServerEnabled) {
/* 224 */       return false;
/*     */     }
/*     */     
/* 227 */     if (this.askedAboutDefaultServers != that.askedAboutDefaultServers) {
/* 228 */       return false;
/*     */     }
/*     */     
/* 231 */     if (this.httpServerPort != that.httpServerPort) {
/* 232 */       return false;
/*     */     }
/* 234 */     if (this.checkUnstableVersionsEnabled != that.checkUnstableVersionsEnabled) {
/* 235 */       return false;
/*     */     }
/* 237 */     if (this.uid != that.uid) {
/* 238 */       return false;
/*     */     }
/* 240 */     if (this.useIdeaProxySettings != that.useIdeaProxySettings) {
/* 241 */       return false;
/*     */     }
/* 243 */     if ((this.anonymousEnhancedFeedbackEnabled != null) ? 
/* 244 */       !this.anonymousEnhancedFeedbackEnabled.equals(that.anonymousEnhancedFeedbackEnabled) : (
/* 245 */       that.anonymousEnhancedFeedbackEnabled != null)) {
/* 246 */       return false;
/*     */     }
/* 248 */     if ((this.checkNowButtonOption != null) ? 
/* 249 */       !this.checkNowButtonOption.equals(that.checkNowButtonOption) : (
/* 250 */       that.checkNowButtonOption != null)) {
/* 251 */       return false;
/*     */     }
/* 253 */     if ((this.rejectedUpgrade != null) ? !this.rejectedUpgrade.equals(that.rejectedUpgrade) : (that.rejectedUpgrade != null)) {
/* 254 */       return false;
/*     */     }
/* 256 */     if (this.certs != null && !this.certs.equals(that.certs)) {
/* 257 */       return false;
/*     */     }
/* 259 */     if (!this.statsCountersMap.equals(that.statsCountersMap)) {
/* 260 */       return false;
/*     */     }
/* 262 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 272 */     int result = this.autoUpdateEnabled ? 1 : 0;
/* 273 */     result = 31 * result + (this.informedAboutIdea9TaskExperimentalSupport ? 1 : 0);
/* 274 */     result = 31 * result + (this.askedAboutDefaultServers ? 1 : 0);
/* 275 */     result = 31 * result + (this.httpServerEnabled ? 1 : 0);
/* 276 */     result = 31 * result + this.httpServerPort;
/* 277 */     result = 31 * result + ((this.rejectedUpgrade != null) ? this.rejectedUpgrade.hashCode() : 0);
/* 278 */     result = 31 * result + (this.checkUnstableVersionsEnabled ? 1 : 0);
/* 279 */     result = 31 * result + (this.useIdeaProxySettings ? 1 : 0);
/* 280 */     result = 31 * result + (
/* 281 */       (this.anonymousEnhancedFeedbackEnabled != null) ? this.anonymousEnhancedFeedbackEnabled.hashCode() : 0);
/* 282 */     result = 31 * result + ((this.checkNowButtonOption != null) ? this.checkNowButtonOption.hashCode() : 0);
/* 283 */     result = 31 * result + (int)(this.uid ^ this.uid >>> 32L);
/* 284 */     result = 31 * result + this.certs.hashCode();
/* 285 */     result = 31 * result + this.statsCountersMap.hashCode();
/* 286 */     return result;
/*     */   }
/*     */   
/*     */   public synchronized void addCert(String strCert) {
/* 290 */     this.certs.add(strCert);
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\configuration\GeneralConfigurationBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */