/*     */ package com.atlassian.connector.commons.jira.soap.axis;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.rmi.Remote;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import javax.xml.namespace.QName;
/*     */ import javax.xml.rpc.ServiceException;
/*     */ import org.apache.axis.AxisFault;
/*     */ import org.apache.axis.EngineConfiguration;
/*     */ import org.apache.axis.client.Service;
/*     */ import org.apache.axis.client.Stub;
/*     */ import org.apache.axis.configuration.XMLStringProvider;
/*     */ import org.apache.axis.transport.http.HTTPSender;
/*     */ import org.apache.axis.transport.java.JavaSender;
/*     */ import org.apache.axis.transport.local.LocalSender;
/*     */ 
/*     */ public class JiraSoapServiceServiceLocator extends Service implements JiraSoapServiceService {
/*     */   public JiraSoapServiceServiceLocator(EngineConfiguration config) {
/*  20 */     super(config);
/*     */   }
/*     */   public JiraSoapServiceServiceLocator() {}
/*     */   
/*     */   public JiraSoapServiceServiceLocator(String wsdlLoc, QName sName) throws ServiceException {
/*  25 */     super(wsdlLoc, sName);
/*     */   }
/*     */ 
/*     */   
/*  29 */   private String JirasoapserviceV2_address = "http://jira.atlassian.com/rpc/soap/jirasoapservice-v2";
/*     */   
/*     */   public String getJirasoapserviceV2Address() {
/*  32 */     return this.JirasoapserviceV2_address;
/*     */   }
/*     */ 
/*     */   
/*  36 */   private String JirasoapserviceV2WSDDServiceName = "jirasoapservice-v2";
/*     */   
/*     */   public String getJirasoapserviceV2WSDDServiceName() {
/*  39 */     return this.JirasoapserviceV2WSDDServiceName;
/*     */   }
/*     */   
/*     */   public void setJirasoapserviceV2WSDDServiceName(String name) {
/*  43 */     this.JirasoapserviceV2WSDDServiceName = name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EngineConfiguration getEngineConfiguration() {
/*  51 */     StringBuffer sb = new StringBuffer();
/*     */     
/*  53 */     sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<deployment name=\"defaultClientConfig\"\n            xmlns=\"http://xml.apache.org/axis/wsdd/\"\n            xmlns:java=\"http://xml.apache.org/axis/wsdd/providers/java\">\n <globalConfiguration>\n   <parameter name=\"disablePrettyXML\" value=\"true\"/>\n   <parameter name=\"enableNamespacePrefixOptimization\" value=\"false\"/>\n </globalConfiguration>");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     sb.append("<transport name=\"http\" pivot=\"java:").append(HTTPSender.class.getName()).append("\" />\r\n");
/*  63 */     sb.append("<transport name=\"local\" pivot=\"java:").append(LocalSender.class.getName()).append("\" />\r\n");
/*  64 */     sb.append("<transport name=\"java\" pivot=\"java:").append(JavaSender.class.getName()).append("\" />\r\n");
/*  65 */     sb.append("</deployment>\r\n");
/*  66 */     XMLStringProvider config = 
/*  67 */       new XMLStringProvider(sb.toString());
/*  68 */     return (EngineConfiguration)config;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JiraSoapService getJirasoapserviceV2() throws ServiceException {
/*     */     URL endpoint;
/*     */     try {
/*  76 */       endpoint = new URL(this.JirasoapserviceV2_address);
/*  77 */     } catch (MalformedURLException e) {
/*  78 */       throw new ServiceException(e);
/*     */     } 
/*  80 */     return getJirasoapserviceV2(endpoint);
/*     */   }
/*     */ 
/*     */   
/*     */   public JiraSoapService getJirasoapserviceV2(URL portAddress) throws ServiceException {
/*     */     try {
/*  86 */       JirasoapserviceV2SoapBindingStub _stub = 
/*  87 */         new JirasoapserviceV2SoapBindingStub(portAddress, 
/*  88 */           this);
/*  89 */       _stub.setPortName(getJirasoapserviceV2WSDDServiceName());
/*  90 */       return _stub;
/*  91 */     } catch (AxisFault axisFault) {
/*  92 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setJirasoapserviceV2EndpointAddress(String address) {
/*  97 */     this.JirasoapserviceV2_address = address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Remote getPort(Class<?> serviceEndpointInterface) throws ServiceException {
/*     */     try {
/* 107 */       if (JiraSoapService.class
/* 108 */         .isAssignableFrom(serviceEndpointInterface)) {
/* 109 */         JirasoapserviceV2SoapBindingStub _stub = 
/* 110 */           new JirasoapserviceV2SoapBindingStub(
/* 111 */             new URL(this.JirasoapserviceV2_address), this);
/* 112 */         _stub.setPortName(getJirasoapserviceV2WSDDServiceName());
/* 113 */         return _stub;
/*     */       } 
/* 115 */     } catch (Throwable t) {
/* 116 */       throw new ServiceException(t);
/*     */     } 
/* 118 */     throw new ServiceException("There is no stub implementation for the interface:  " + (
/* 119 */         (serviceEndpointInterface == null) ? "null" : serviceEndpointInterface.getName()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Remote getPort(QName portName, Class serviceEndpointInterface) throws ServiceException {
/* 129 */     if (portName == null) {
/* 130 */       return getPort(serviceEndpointInterface);
/*     */     }
/* 132 */     String inputPortName = portName.getLocalPart();
/* 133 */     if ("jirasoapservice-v2".equals(inputPortName)) {
/* 134 */       return getJirasoapserviceV2();
/*     */     }
/* 136 */     Remote _stub = getPort(serviceEndpointInterface);
/* 137 */     ((Stub)_stub).setPortName(portName);
/* 138 */     return _stub;
/*     */   }
/*     */ 
/*     */   
/*     */   public QName getServiceName() {
/* 143 */     return new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 144 */         "JiraSoapServiceService");
/*     */   }
/*     */   
/* 147 */   private HashSet ports = null;
/*     */   
/*     */   public Iterator getPorts() {
/* 150 */     if (this.ports == null) {
/* 151 */       this.ports = new HashSet();
/* 152 */       this.ports.add(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 153 */             "jirasoapservice-v2"));
/*     */     } 
/* 155 */     return this.ports.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndpointAddress(String portName, String address) throws ServiceException {
/* 164 */     if ("JirasoapserviceV2".equals(portName)) {
/* 165 */       setJirasoapserviceV2EndpointAddress(address);
/*     */     } else {
/* 167 */       throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndpointAddress(QName portName, String address) throws ServiceException {
/* 176 */     setEndpointAddress(portName.getLocalPart(), address);
/*     */   }
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\JiraSoapServiceServiceLocator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */