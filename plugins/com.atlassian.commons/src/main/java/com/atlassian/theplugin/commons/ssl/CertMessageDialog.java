package com.atlassian.theplugin.commons.ssl;

import java.security.cert.X509Certificate;

public interface CertMessageDialog {
  void show(String paramString1, String paramString2, X509Certificate[] paramArrayOfX509Certificate);
  
  boolean isOK();
  
  boolean isTemporarily();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\ssl\CertMessageDialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */