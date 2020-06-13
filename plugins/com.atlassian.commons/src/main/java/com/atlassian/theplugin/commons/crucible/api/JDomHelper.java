/*    */ package com.atlassian.theplugin.commons.crucible.api;
/*    */ 
/*    */ import com.google.common.base.Function;
/*    */ import com.google.common.collect.Iterables;
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.List;
/*    */ import org.jdom.Content;
/*    */ import org.jdom.Element;
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
/*    */ public final class JDomHelper
/*    */ {
/*    */   public static List<Element> getContent(Element e) {
/* 30 */     return Lists.newArrayList(Iterables.transform(e.getContent(), new Function<Content, Element>() {
/*    */             public Element apply(Content content) {
/* 32 */               return (Element)content;
/*    */             }
/*    */           }));
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\crucible\api\JDomHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */