/*     */ package com.atlassian.connector.commons.jira.soap.axis;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import javax.xml.namespace.QName;
/*     */ import org.apache.axis.description.ElementDesc;
/*     */ import org.apache.axis.description.FieldDesc;
/*     */ import org.apache.axis.description.TypeDesc;
/*     */ import org.apache.axis.encoding.Deserializer;
/*     */ import org.apache.axis.encoding.Serializer;
/*     */ import org.apache.axis.encoding.ser.BeanDeserializer;
/*     */ import org.apache.axis.encoding.ser.BeanSerializer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RemoteIssue
/*     */   extends AbstractRemoteEntity
/*     */   implements Serializable
/*     */ {
/*     */   private RemoteVersion[] affectsVersions;
/*     */   private String assignee;
/*     */   private String[] attachmentNames;
/*     */   private RemoteComponent[] components;
/*     */   private Calendar created;
/*     */   private RemoteCustomFieldValue[] customFieldValues;
/*     */   private String description;
/*     */   private Calendar duedate;
/*     */   private String environment;
/*     */   private RemoteVersion[] fixVersions;
/*     */   private String key;
/*     */   private String priority;
/*     */   private String project;
/*     */   private String reporter;
/*     */   private String resolution;
/*     */   private String status;
/*     */   private String summary;
/*     */   private String type;
/*     */   private Calendar updated;
/*     */   private Long votes;
/*     */   
/*     */   public RemoteIssue(String id, RemoteVersion[] affectsVersions, String assignee, String[] attachmentNames, RemoteComponent[] components, Calendar created, RemoteCustomFieldValue[] customFieldValues, String description, Calendar duedate, String environment, RemoteVersion[] fixVersions, String key, String priority, String project, String reporter, String resolution, String status, String summary, String type, Calendar updated, Long votes) {
/*  78 */     super(id);
/*  79 */     this.affectsVersions = affectsVersions;
/*  80 */     this.assignee = assignee;
/*  81 */     this.attachmentNames = attachmentNames;
/*  82 */     this.components = components;
/*  83 */     this.created = created;
/*  84 */     this.customFieldValues = customFieldValues;
/*  85 */     this.description = description;
/*  86 */     this.duedate = duedate;
/*  87 */     this.environment = environment;
/*  88 */     this.fixVersions = fixVersions;
/*  89 */     this.key = key;
/*  90 */     this.priority = priority;
/*  91 */     this.project = project;
/*  92 */     this.reporter = reporter;
/*  93 */     this.resolution = resolution;
/*  94 */     this.status = status;
/*  95 */     this.summary = summary;
/*  96 */     this.type = type;
/*  97 */     this.updated = updated;
/*  98 */     this.votes = votes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteVersion[] getAffectsVersions() {
/* 108 */     return this.affectsVersions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAffectsVersions(RemoteVersion[] affectsVersions) {
/* 118 */     this.affectsVersions = affectsVersions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAssignee() {
/* 128 */     return this.assignee;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAssignee(String assignee) {
/* 138 */     this.assignee = assignee;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getAttachmentNames() {
/* 148 */     return this.attachmentNames;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttachmentNames(String[] attachmentNames) {
/* 158 */     this.attachmentNames = attachmentNames;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteComponent[] getComponents() {
/* 168 */     return this.components;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComponents(RemoteComponent[] components) {
/* 178 */     this.components = components;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getCreated() {
/* 188 */     return this.created;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreated(Calendar created) {
/* 198 */     this.created = created;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteCustomFieldValue[] getCustomFieldValues() {
/* 208 */     return this.customFieldValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomFieldValues(RemoteCustomFieldValue[] customFieldValues) {
/* 218 */     this.customFieldValues = customFieldValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 228 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String description) {
/* 238 */     this.description = description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getDuedate() {
/* 248 */     return this.duedate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDuedate(Calendar duedate) {
/* 258 */     this.duedate = duedate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEnvironment() {
/* 268 */     return this.environment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnvironment(String environment) {
/* 278 */     this.environment = environment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RemoteVersion[] getFixVersions() {
/* 288 */     return this.fixVersions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFixVersions(RemoteVersion[] fixVersions) {
/* 298 */     this.fixVersions = fixVersions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKey() {
/* 308 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(String key) {
/* 318 */     this.key = key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPriority() {
/* 328 */     return this.priority;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPriority(String priority) {
/* 338 */     this.priority = priority;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getProject() {
/* 348 */     return this.project;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProject(String project) {
/* 358 */     this.project = project;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReporter() {
/* 368 */     return this.reporter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReporter(String reporter) {
/* 378 */     this.reporter = reporter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getResolution() {
/* 388 */     return this.resolution;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResolution(String resolution) {
/* 398 */     this.resolution = resolution;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStatus() {
/* 408 */     return this.status;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatus(String status) {
/* 418 */     this.status = status;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSummary() {
/* 428 */     return this.summary;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSummary(String summary) {
/* 438 */     this.summary = summary;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 448 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String type) {
/* 458 */     this.type = type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getUpdated() {
/* 468 */     return this.updated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdated(Calendar updated) {
/* 478 */     this.updated = updated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getVotes() {
/* 488 */     return this.votes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVotes(Long votes) {
/* 498 */     this.votes = votes;
/*     */   }
/*     */   
/* 501 */   private Object __equalsCalc = null;
/*     */   
/*     */   public synchronized boolean equals(Object obj) {
/* 504 */     if (!(obj instanceof RemoteIssue)) {
/* 505 */       return false;
/*     */     }
/* 507 */     RemoteIssue other = (RemoteIssue)obj;
/* 508 */     if (obj == null) {
/* 509 */       return false;
/*     */     }
/* 511 */     if (this == obj) {
/* 512 */       return true;
/*     */     }
/* 514 */     if (this.__equalsCalc != null) {
/* 515 */       return (this.__equalsCalc == obj);
/*     */     }
/* 517 */     this.__equalsCalc = obj;
/*     */     
/* 519 */     boolean _equals = (super.equals(obj) && ((
/* 520 */       this.affectsVersions == null && other.getAffectsVersions() == null) || (
/* 521 */       this.affectsVersions != null && 
/* 522 */       Arrays.equals((Object[])this.affectsVersions, (Object[])other.getAffectsVersions()))) && ((
/* 523 */       this.assignee == null && other.getAssignee() == null) || (
/* 524 */       this.assignee != null && 
/* 525 */       this.assignee.equals(other.getAssignee()))) && ((
/* 526 */       this.attachmentNames == null && other.getAttachmentNames() == null) || (
/* 527 */       this.attachmentNames != null && 
/* 528 */       Arrays.equals((Object[])this.attachmentNames, (Object[])other.getAttachmentNames()))) && ((
/* 529 */       this.components == null && other.getComponents() == null) || (
/* 530 */       this.components != null && 
/* 531 */       Arrays.equals((Object[])this.components, (Object[])other.getComponents()))) && ((
/* 532 */       this.created == null && other.getCreated() == null) || (
/* 533 */       this.created != null && 
/* 534 */       this.created.equals(other.getCreated()))) && ((
/* 535 */       this.customFieldValues == null && other.getCustomFieldValues() == null) || (
/* 536 */       this.customFieldValues != null && 
/* 537 */       Arrays.equals((Object[])this.customFieldValues, (Object[])other.getCustomFieldValues()))) && ((
/* 538 */       this.description == null && other.getDescription() == null) || (
/* 539 */       this.description != null && 
/* 540 */       this.description.equals(other.getDescription()))) && ((
/* 541 */       this.duedate == null && other.getDuedate() == null) || (
/* 542 */       this.duedate != null && 
/* 543 */       this.duedate.equals(other.getDuedate()))) && ((
/* 544 */       this.environment == null && other.getEnvironment() == null) || (
/* 545 */       this.environment != null && 
/* 546 */       this.environment.equals(other.getEnvironment()))) && ((
/* 547 */       this.fixVersions == null && other.getFixVersions() == null) || (
/* 548 */       this.fixVersions != null && 
/* 549 */       Arrays.equals((Object[])this.fixVersions, (Object[])other.getFixVersions()))) && ((
/* 550 */       this.key == null && other.getKey() == null) || (
/* 551 */       this.key != null && 
/* 552 */       this.key.equals(other.getKey()))) && ((
/* 553 */       this.priority == null && other.getPriority() == null) || (
/* 554 */       this.priority != null && 
/* 555 */       this.priority.equals(other.getPriority()))) && ((
/* 556 */       this.project == null && other.getProject() == null) || (
/* 557 */       this.project != null && 
/* 558 */       this.project.equals(other.getProject()))) && ((
/* 559 */       this.reporter == null && other.getReporter() == null) || (
/* 560 */       this.reporter != null && 
/* 561 */       this.reporter.equals(other.getReporter()))) && ((
/* 562 */       this.resolution == null && other.getResolution() == null) || (
/* 563 */       this.resolution != null && 
/* 564 */       this.resolution.equals(other.getResolution()))) && ((
/* 565 */       this.status == null && other.getStatus() == null) || (
/* 566 */       this.status != null && 
/* 567 */       this.status.equals(other.getStatus()))) && ((
/* 568 */       this.summary == null && other.getSummary() == null) || (
/* 569 */       this.summary != null && 
/* 570 */       this.summary.equals(other.getSummary()))) && ((
/* 571 */       this.type == null && other.getType() == null) || (
/* 572 */       this.type != null && 
/* 573 */       this.type.equals(other.getType()))) && ((
/* 574 */       this.updated == null && other.getUpdated() == null) || (
/* 575 */       this.updated != null && 
/* 576 */       this.updated.equals(other.getUpdated()))) && ((
/* 577 */       this.votes == null && other.getVotes() == null) || (
/* 578 */       this.votes != null && 
/* 579 */       this.votes.equals(other.getVotes()))));
/* 580 */     this.__equalsCalc = null;
/* 581 */     return _equals;
/*     */   }
/*     */   
/*     */   private boolean __hashCodeCalc = false;
/*     */   
/*     */   public synchronized int hashCode() {
/* 587 */     if (this.__hashCodeCalc) {
/* 588 */       return 0;
/*     */     }
/* 590 */     this.__hashCodeCalc = true;
/* 591 */     int _hashCode = super.hashCode();
/* 592 */     if (getAffectsVersions() != null) {
/* 593 */       int i = 0;
/* 594 */       for (; i < Array.getLength(getAffectsVersions()); 
/* 595 */         i++) {
/* 596 */         Object obj = Array.get(getAffectsVersions(), i);
/* 597 */         if (obj != null && 
/* 598 */           !obj.getClass().isArray()) {
/* 599 */           _hashCode += obj.hashCode();
/*     */         }
/*     */       } 
/*     */     } 
/* 603 */     if (getAssignee() != null) {
/* 604 */       _hashCode += getAssignee().hashCode();
/*     */     }
/* 606 */     if (getAttachmentNames() != null) {
/* 607 */       int i = 0;
/* 608 */       for (; i < Array.getLength(getAttachmentNames()); 
/* 609 */         i++) {
/* 610 */         Object obj = Array.get(getAttachmentNames(), i);
/* 611 */         if (obj != null && 
/* 612 */           !obj.getClass().isArray()) {
/* 613 */           _hashCode += obj.hashCode();
/*     */         }
/*     */       } 
/*     */     } 
/* 617 */     if (getComponents() != null) {
/* 618 */       int i = 0;
/* 619 */       for (; i < Array.getLength(getComponents()); 
/* 620 */         i++) {
/* 621 */         Object obj = Array.get(getComponents(), i);
/* 622 */         if (obj != null && 
/* 623 */           !obj.getClass().isArray()) {
/* 624 */           _hashCode += obj.hashCode();
/*     */         }
/*     */       } 
/*     */     } 
/* 628 */     if (getCreated() != null) {
/* 629 */       _hashCode += getCreated().hashCode();
/*     */     }
/* 631 */     if (getCustomFieldValues() != null) {
/* 632 */       int i = 0;
/* 633 */       for (; i < Array.getLength(getCustomFieldValues()); 
/* 634 */         i++) {
/* 635 */         Object obj = Array.get(getCustomFieldValues(), i);
/* 636 */         if (obj != null && 
/* 637 */           !obj.getClass().isArray()) {
/* 638 */           _hashCode += obj.hashCode();
/*     */         }
/*     */       } 
/*     */     } 
/* 642 */     if (getDescription() != null) {
/* 643 */       _hashCode += getDescription().hashCode();
/*     */     }
/* 645 */     if (getDuedate() != null) {
/* 646 */       _hashCode += getDuedate().hashCode();
/*     */     }
/* 648 */     if (getEnvironment() != null) {
/* 649 */       _hashCode += getEnvironment().hashCode();
/*     */     }
/* 651 */     if (getFixVersions() != null) {
/* 652 */       int i = 0;
/* 653 */       for (; i < Array.getLength(getFixVersions()); 
/* 654 */         i++) {
/* 655 */         Object obj = Array.get(getFixVersions(), i);
/* 656 */         if (obj != null && 
/* 657 */           !obj.getClass().isArray()) {
/* 658 */           _hashCode += obj.hashCode();
/*     */         }
/*     */       } 
/*     */     } 
/* 662 */     if (getKey() != null) {
/* 663 */       _hashCode += getKey().hashCode();
/*     */     }
/* 665 */     if (getPriority() != null) {
/* 666 */       _hashCode += getPriority().hashCode();
/*     */     }
/* 668 */     if (getProject() != null) {
/* 669 */       _hashCode += getProject().hashCode();
/*     */     }
/* 671 */     if (getReporter() != null) {
/* 672 */       _hashCode += getReporter().hashCode();
/*     */     }
/* 674 */     if (getResolution() != null) {
/* 675 */       _hashCode += getResolution().hashCode();
/*     */     }
/* 677 */     if (getStatus() != null) {
/* 678 */       _hashCode += getStatus().hashCode();
/*     */     }
/* 680 */     if (getSummary() != null) {
/* 681 */       _hashCode += getSummary().hashCode();
/*     */     }
/* 683 */     if (getType() != null) {
/* 684 */       _hashCode += getType().hashCode();
/*     */     }
/* 686 */     if (getUpdated() != null) {
/* 687 */       _hashCode += getUpdated().hashCode();
/*     */     }
/* 689 */     if (getVotes() != null) {
/* 690 */       _hashCode += getVotes().hashCode();
/*     */     }
/* 692 */     this.__hashCodeCalc = false;
/* 693 */     return _hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 698 */   private static TypeDesc typeDesc = new TypeDesc(RemoteIssue.class, true);
/*     */   
/*     */   static {
/* 701 */     typeDesc.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"));
/* 702 */     ElementDesc elemField = new ElementDesc();
/* 703 */     elemField.setFieldName("affectsVersions");
/* 704 */     elemField.setXmlName(new QName("", "affectsVersions"));
/* 705 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteVersion"));
/* 706 */     elemField.setNillable(true);
/* 707 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 708 */     elemField = new ElementDesc();
/* 709 */     elemField.setFieldName("assignee");
/* 710 */     elemField.setXmlName(new QName("", "assignee"));
/* 711 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 712 */     elemField.setNillable(true);
/* 713 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 714 */     elemField = new ElementDesc();
/* 715 */     elemField.setFieldName("attachmentNames");
/* 716 */     elemField.setXmlName(new QName("", "attachmentNames"));
/* 717 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 718 */     elemField.setNillable(true);
/* 719 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 720 */     elemField = new ElementDesc();
/* 721 */     elemField.setFieldName("components");
/* 722 */     elemField.setXmlName(new QName("", "components"));
/* 723 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComponent"));
/* 724 */     elemField.setNillable(true);
/* 725 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 726 */     elemField = new ElementDesc();
/* 727 */     elemField.setFieldName("created");
/* 728 */     elemField.setXmlName(new QName("", "created"));
/* 729 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
/* 730 */     elemField.setNillable(true);
/* 731 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 732 */     elemField = new ElementDesc();
/* 733 */     elemField.setFieldName("customFieldValues");
/* 734 */     elemField.setXmlName(new QName("", "customFieldValues"));
/* 735 */     elemField.setXmlType(
/* 736 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteCustomFieldValue"));
/* 737 */     elemField.setNillable(true);
/* 738 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 739 */     elemField = new ElementDesc();
/* 740 */     elemField.setFieldName("description");
/* 741 */     elemField.setXmlName(new QName("", "description"));
/* 742 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 743 */     elemField.setNillable(true);
/* 744 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 745 */     elemField = new ElementDesc();
/* 746 */     elemField.setFieldName("duedate");
/* 747 */     elemField.setXmlName(new QName("", "duedate"));
/* 748 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
/* 749 */     elemField.setNillable(true);
/* 750 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 751 */     elemField = new ElementDesc();
/* 752 */     elemField.setFieldName("environment");
/* 753 */     elemField.setXmlName(new QName("", "environment"));
/* 754 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 755 */     elemField.setNillable(true);
/* 756 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 757 */     elemField = new ElementDesc();
/* 758 */     elemField.setFieldName("fixVersions");
/* 759 */     elemField.setXmlName(new QName("", "fixVersions"));
/* 760 */     elemField.setXmlType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteVersion"));
/* 761 */     elemField.setNillable(true);
/* 762 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 763 */     elemField = new ElementDesc();
/* 764 */     elemField.setFieldName("key");
/* 765 */     elemField.setXmlName(new QName("", "key"));
/* 766 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 767 */     elemField.setNillable(true);
/* 768 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 769 */     elemField = new ElementDesc();
/* 770 */     elemField.setFieldName("priority");
/* 771 */     elemField.setXmlName(new QName("", "priority"));
/* 772 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 773 */     elemField.setNillable(true);
/* 774 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 775 */     elemField = new ElementDesc();
/* 776 */     elemField.setFieldName("project");
/* 777 */     elemField.setXmlName(new QName("", "project"));
/* 778 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 779 */     elemField.setNillable(true);
/* 780 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 781 */     elemField = new ElementDesc();
/* 782 */     elemField.setFieldName("reporter");
/* 783 */     elemField.setXmlName(new QName("", "reporter"));
/* 784 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 785 */     elemField.setNillable(true);
/* 786 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 787 */     elemField = new ElementDesc();
/* 788 */     elemField.setFieldName("resolution");
/* 789 */     elemField.setXmlName(new QName("", "resolution"));
/* 790 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 791 */     elemField.setNillable(true);
/* 792 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 793 */     elemField = new ElementDesc();
/* 794 */     elemField.setFieldName("status");
/* 795 */     elemField.setXmlName(new QName("", "status"));
/* 796 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 797 */     elemField.setNillable(true);
/* 798 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 799 */     elemField = new ElementDesc();
/* 800 */     elemField.setFieldName("summary");
/* 801 */     elemField.setXmlName(new QName("", "summary"));
/* 802 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 803 */     elemField.setNillable(true);
/* 804 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 805 */     elemField = new ElementDesc();
/* 806 */     elemField.setFieldName("type");
/* 807 */     elemField.setXmlName(new QName("", "type"));
/* 808 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 809 */     elemField.setNillable(true);
/* 810 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 811 */     elemField = new ElementDesc();
/* 812 */     elemField.setFieldName("updated");
/* 813 */     elemField.setXmlName(new QName("", "updated"));
/* 814 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
/* 815 */     elemField.setNillable(true);
/* 816 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/* 817 */     elemField = new ElementDesc();
/* 818 */     elemField.setFieldName("votes");
/* 819 */     elemField.setXmlName(new QName("", "votes"));
/* 820 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 821 */     elemField.setNillable(true);
/* 822 */     typeDesc.addFieldDesc((FieldDesc)elemField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeDesc getTypeDesc() {
/* 829 */     return typeDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType) {
/* 839 */     return 
/* 840 */       (Serializer)new BeanSerializer(
/* 841 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType) {
/* 851 */     return 
/* 852 */       (Deserializer)new BeanDeserializer(
/* 853 */         _javaType, _xmlType, typeDesc);
/*     */   }
/*     */   
/*     */   public RemoteIssue() {}
/*     */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\RemoteIssue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */