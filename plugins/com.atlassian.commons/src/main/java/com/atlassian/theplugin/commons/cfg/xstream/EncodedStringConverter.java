/*    */ package com.atlassian.theplugin.commons.cfg.xstream;
/*    */ 
/*    */ import com.atlassian.theplugin.commons.util.StringUtil;
/*    */ import com.thoughtworks.xstream.converters.Converter;
/*    */ import com.thoughtworks.xstream.converters.MarshallingContext;
/*    */ import com.thoughtworks.xstream.converters.UnmarshallingContext;
/*    */ import com.thoughtworks.xstream.io.HierarchicalStreamReader;
/*    */ import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
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
/*    */ public class EncodedStringConverter
/*    */   implements Converter
/*    */ {
/*    */   public boolean canConvert(Class clazz) {
/* 29 */     return clazz.equals(String.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
/* 34 */     String string = (String)value;
/* 35 */     writer.setValue(StringUtil.encode(string));
/*    */   }
/*    */ 
/*    */   
/*    */   public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
/* 40 */     return StringUtil.decode(reader.getValue());
/*    */   }
/*    */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\theplugin\commons\cfg\xstream\EncodedStringConverter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */