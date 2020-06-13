/*     */ package com.atlassian.theplugin.commons.configuration;
/*     */ 
/*     */ import com.atlassian.theplugin.commons.util.HttpConfigurableAdapter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PluginConfigurationBean
/*     */   implements PluginConfiguration
/*     */ {
/*  11 */   private BambooConfigurationBean bambooConfiguration = new BambooConfigurationBean();
/*     */   
/*  13 */   private CrucibleConfigurationBean crucibleConfiguration = new CrucibleConfigurationBean();
/*  14 */   private JiraConfigurationBean jiraConfiguration = new JiraConfigurationBean();
/*  15 */   private GeneralConfigurationBean generalConfigurationBean = new GeneralConfigurationBean();
/*     */ 
/*     */ 
/*     */   
/*     */   private HttpConfigurableAdapter httpConfigurableAdapter;
/*     */ 
/*     */   
/*     */   private static final int ONE_EFF = 31;
/*     */ 
/*     */ 
/*     */   
/*     */   public PluginConfigurationBean() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public PluginConfigurationBean(PluginConfiguration cfg) {
/*  31 */     setConfiguration(cfg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfiguration(PluginConfiguration cfg) {
/*  41 */     setGeneralConfigurationData(new GeneralConfigurationBean(cfg.getGeneralConfigurationData()));
/*  42 */     setBambooConfigurationData(new BambooConfigurationBean(cfg.getBambooConfigurationData()));
/*  43 */     setCrucibleConfigurationData(new CrucibleConfigurationBean(cfg.getCrucibleConfigurationData()));
/*  44 */     setJIRAConfigurationData(new JiraConfigurationBean(cfg.getJIRAConfigurationData()));
/*  45 */     transientSetHttpConfigurable(cfg.transientGetHttpConfigurable());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BambooConfigurationBean getBambooConfigurationData() {
/*  54 */     return this.bambooConfiguration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBambooConfigurationData(BambooConfigurationBean newConfiguration) {
/*  63 */     this.bambooConfiguration = newConfiguration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CrucibleConfigurationBean getCrucibleConfigurationData() {
/*  72 */     return this.crucibleConfiguration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCrucibleConfigurationData(CrucibleConfigurationBean newConfiguration) {
/*  81 */     this.crucibleConfiguration = newConfiguration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JiraConfigurationBean getJIRAConfigurationData() {
/*  90 */     return this.jiraConfiguration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJIRAConfigurationData(JiraConfigurationBean newConfiguration) {
/*  99 */     this.jiraConfiguration = newConfiguration;
/*     */   }
/*     */   
/*     */   public GeneralConfigurationBean getGeneralConfigurationData() {
/* 103 */     return this.generalConfigurationBean;
/*     */   }
/*     */   
/*     */   public void setGeneralConfigurationData(GeneralConfigurationBean aGeneralConfigurationBean) {
/* 107 */     this.generalConfigurationBean = aGeneralConfigurationBean;
/*     */   }
/*     */   
/*     */   public void transientSetHttpConfigurable(HttpConfigurableAdapter aHttpConfigurableAdapter) {
/* 111 */     this.httpConfigurableAdapter = aHttpConfigurableAdapter;
/*     */   }
/*     */   
/*     */   public HttpConfigurableAdapter transientGetHttpConfigurable() {
/* 115 */     return this.httpConfigurableAdapter;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o) {
/* 119 */     if (this == o) {
/* 120 */       return true;
/*     */     }
/* 122 */     if (o == null || getClass() != o.getClass()) {
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     PluginConfigurationBean that = (PluginConfigurationBean)o;
/*     */ 
/*     */     
/* 129 */     if (!this.bambooConfiguration.equals(that.bambooConfiguration)) {
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     if (!this.crucibleConfiguration.equals(that.crucibleConfiguration)) {
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     if (!this.generalConfigurationBean.equals(that.generalConfigurationBean)) {
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     return this.jiraConfiguration.equals(that.jiraConfiguration);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 147 */     int result = 0;
/* 148 */     result = 31 * result + ((this.bambooConfiguration != null) ? this.bambooConfiguration.hashCode() : 0);
/* 149 */     result = 31 * result + ((this.crucibleConfiguration != null) ? this.crucibleConfiguration.hashCode() : 0);
/* 150 */     result = 31 * result + ((this.jiraConfiguration != null) ? this.jiraConfiguration.hashCode() : 0);
/* 151 */     result = 31 * result + ((this.generalConfigurationBean != null) ? this.generalConfigurationBean.hashCode() : 0);
/*     */     
/* 153 */     return result;
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\configuration\PluginConfigurationBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */