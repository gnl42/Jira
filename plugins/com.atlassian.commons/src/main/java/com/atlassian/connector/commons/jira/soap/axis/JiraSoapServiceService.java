package com.atlassian.connector.commons.jira.soap.axis;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface JiraSoapServiceService extends Service {
  String getJirasoapserviceV2Address();
  
  JiraSoapService getJirasoapserviceV2() throws ServiceException;
  
  JiraSoapService getJirasoapserviceV2(URL paramURL) throws ServiceException;
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\JiraSoapServiceService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */