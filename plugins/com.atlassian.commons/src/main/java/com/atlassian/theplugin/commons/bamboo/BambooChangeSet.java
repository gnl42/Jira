package com.atlassian.theplugin.commons.bamboo;

import com.atlassian.theplugin.commons.BambooFileInfo;
import com.atlassian.theplugin.commons.VirtualFileSystem;
import java.util.Date;
import java.util.List;

public interface BambooChangeSet {
  String getAuthor();
  
  String getComment();
  
  Date getCommitDate();
  
  List<BambooFileInfo> getFiles();
  
  VirtualFileSystem getVirtualFileSystem();
}


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\bamboo\BambooChangeSet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */