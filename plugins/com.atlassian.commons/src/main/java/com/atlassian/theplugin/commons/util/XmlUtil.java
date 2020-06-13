/*    */ package com.atlassian.theplugin.commons.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.StringWriter;
/*    */ import java.util.List;
/*    */ import org.jdom.Document;
/*    */ import org.jdom.Element;
/*    */ import org.jdom.output.Format;
/*    */ import org.jdom.output.XMLOutputter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class XmlUtil
/*    */ {
/*    */   public static void printXml(Document request) {
/* 34 */     XMLOutputter o = new XMLOutputter(Format.getPrettyFormat());
/*    */     try {
/* 36 */       o.output(request, System.out);
/* 37 */     } catch (IOException e) {
/* 38 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String toPrettyFormatedString(Element element) {
/* 43 */     XMLOutputter o = new XMLOutputter(Format.getPrettyFormat());
/* 44 */     StringWriter writer = new StringWriter();
/*    */     try {
/* 46 */       o.output(element, writer);
/* 47 */     } catch (IOException e) {
/* 48 */       return "[" + element.getName() + "] - string representation failed: " + e.getMessage();
/*    */     } 
/* 50 */     return writer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public static List<Element> getChildElements(Element node, String childName) {
/* 55 */     return node.getChildren(childName);
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\common\\util\XmlUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */