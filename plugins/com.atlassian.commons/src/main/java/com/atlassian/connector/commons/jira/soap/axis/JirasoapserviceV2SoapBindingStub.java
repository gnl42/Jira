/*      */ package com.atlassian.connector.commons.jira.soap.axis;
/*      */ import java.rmi.RemoteException;
/*      */ import javax.xml.namespace.QName;
/*      */ import org.apache.axis.AxisFault;
/*      */ import org.apache.axis.NoEndPointException;
/*      */ import org.apache.axis.client.Call;
/*      */ import org.apache.axis.constants.Style;
/*      */ import org.apache.axis.constants.Use;
/*      */ import org.apache.axis.description.FaultDesc;
/*      */ import org.apache.axis.description.OperationDesc;
/*      */ import org.apache.axis.description.ParameterDesc;
/*      */ import org.apache.axis.soap.SOAPConstants;
/*      */ import org.apache.axis.utils.JavaUtils;
/*      */ 
/*      */ public class JirasoapserviceV2SoapBindingStub extends Stub implements JiraSoapService {
/*   16 */   private Vector cachedSerClasses = new Vector();
/*   17 */   private Vector cachedSerQNames = new Vector();
/*   18 */   private Vector cachedSerFactories = new Vector();
/*   19 */   private Vector cachedDeserFactories = new Vector();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   24 */   static OperationDesc[] _operations = new OperationDesc[100]; static {
/*   25 */     _initOperationDesc1();
/*   26 */     _initOperationDesc2();
/*   27 */     _initOperationDesc3();
/*   28 */     _initOperationDesc4();
/*   29 */     _initOperationDesc5();
/*   30 */     _initOperationDesc6();
/*   31 */     _initOperationDesc7();
/*   32 */     _initOperationDesc8();
/*   33 */     _initOperationDesc9();
/*   34 */     _initOperationDesc10();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void _initOperationDesc1() {
/*   40 */     OperationDesc oper = new OperationDesc();
/*   41 */     oper.setName("getComment");
/*   42 */     ParameterDesc param = new ParameterDesc(new QName("", "in0"), (byte)
/*   43 */         1, 
/*   44 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*   45 */         false);
/*   46 */     oper.addParameter(param);
/*   47 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*   48 */         1, 
/*   49 */         new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
/*   50 */     oper.addParameter(param);
/*   51 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComment"));
/*   52 */     oper.setReturnClass(RemoteComment.class);
/*   53 */     oper.setReturnQName(new QName("", "getCommentReturn"));
/*   54 */     oper.setStyle(Style.RPC);
/*   55 */     oper.setUse(Use.ENCODED);
/*   56 */     oper.addFault(new FaultDesc(
/*   57 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*   58 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*   59 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*   60 */           true));
/*      */     
/*   62 */     _operations[0] = oper;
/*      */     
/*   64 */     oper = new OperationDesc();
/*   65 */     oper.setName("createGroup");
/*   66 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*   67 */         1, 
/*   68 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*   69 */         false);
/*   70 */     oper.addParameter(param);
/*   71 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*   72 */         1, 
/*   73 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*   74 */         false);
/*   75 */     oper.addParameter(param);
/*   76 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/*   77 */         1, 
/*   78 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"), 
/*   79 */         RemoteUser.class, false, false);
/*   80 */     oper.addParameter(param);
/*   81 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup"));
/*   82 */     oper.setReturnClass(RemoteGroup.class);
/*   83 */     oper.setReturnQName(new QName("", "createGroupReturn"));
/*   84 */     oper.setStyle(Style.RPC);
/*   85 */     oper.setUse(Use.ENCODED);
/*   86 */     oper.addFault(new FaultDesc(
/*   87 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*   88 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*   89 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*   90 */           true));
/*      */     
/*   92 */     oper.addFault(new FaultDesc(
/*   93 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*   94 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/*   95 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/*   96 */           true));
/*      */     
/*   98 */     oper.addFault(new FaultDesc(
/*   99 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  100 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  101 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  102 */           true));
/*      */     
/*  104 */     oper.addFault(new FaultDesc(
/*  105 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  106 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  107 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  108 */           true));
/*      */     
/*  110 */     _operations[1] = oper;
/*      */     
/*  112 */     oper = new OperationDesc();
/*  113 */     oper.setName("getSecurityLevel");
/*  114 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  115 */         1, 
/*  116 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  117 */         false);
/*  118 */     oper.addParameter(param);
/*  119 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  120 */         1, 
/*  121 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  122 */         false);
/*  123 */     oper.addParameter(param);
/*  124 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteSecurityLevel"));
/*  125 */     oper.setReturnClass(RemoteSecurityLevel.class);
/*  126 */     oper.setReturnQName(new QName("", "getSecurityLevelReturn"));
/*  127 */     oper.setStyle(Style.RPC);
/*  128 */     oper.setUse(Use.ENCODED);
/*  129 */     oper.addFault(new FaultDesc(
/*  130 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  131 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  132 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  133 */           true));
/*      */     
/*  135 */     oper.addFault(new FaultDesc(
/*  136 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  137 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  138 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  139 */           true));
/*      */     
/*  141 */     _operations[2] = oper;
/*      */     
/*  143 */     oper = new OperationDesc();
/*  144 */     oper.setName("getServerInfo");
/*  145 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  146 */         1, 
/*  147 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  148 */         false);
/*  149 */     oper.addParameter(param);
/*  150 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteServerInfo"));
/*  151 */     oper.setReturnClass(RemoteServerInfo.class);
/*  152 */     oper.setReturnQName(new QName("", "getServerInfoReturn"));
/*  153 */     oper.setStyle(Style.RPC);
/*  154 */     oper.setUse(Use.ENCODED);
/*  155 */     _operations[3] = oper;
/*      */     
/*  157 */     oper = new OperationDesc();
/*  158 */     oper.setName("getGroup");
/*  159 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  160 */         1, 
/*  161 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  162 */         false);
/*  163 */     oper.addParameter(param);
/*  164 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  165 */         1, 
/*  166 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  167 */         false);
/*  168 */     oper.addParameter(param);
/*  169 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup"));
/*  170 */     oper.setReturnClass(RemoteGroup.class);
/*  171 */     oper.setReturnQName(new QName("", "getGroupReturn"));
/*  172 */     oper.setStyle(Style.RPC);
/*  173 */     oper.setUse(Use.ENCODED);
/*  174 */     oper.addFault(new FaultDesc(
/*  175 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  176 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  177 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  178 */           true));
/*      */     
/*  180 */     oper.addFault(new FaultDesc(
/*  181 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  182 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/*  183 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/*  184 */           true));
/*      */     
/*  186 */     oper.addFault(new FaultDesc(
/*  187 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  188 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  189 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  190 */           true));
/*      */     
/*  192 */     oper.addFault(new FaultDesc(
/*  193 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  194 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  195 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  196 */           true));
/*      */     
/*  198 */     _operations[4] = oper;
/*      */     
/*  200 */     oper = new OperationDesc();
/*  201 */     oper.setName("createUser");
/*  202 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  203 */         1, 
/*  204 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  205 */         false);
/*  206 */     oper.addParameter(param);
/*  207 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  208 */         1, 
/*  209 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  210 */         false);
/*  211 */     oper.addParameter(param);
/*  212 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/*  213 */         1, 
/*  214 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  215 */         false);
/*  216 */     oper.addParameter(param);
/*  217 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/*  218 */         1, 
/*  219 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  220 */         false);
/*  221 */     oper.addParameter(param);
/*  222 */     param = new ParameterDesc(new QName("", "in4"), (byte)
/*  223 */         1, 
/*  224 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  225 */         false);
/*  226 */     oper.addParameter(param);
/*  227 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"));
/*  228 */     oper.setReturnClass(RemoteUser.class);
/*  229 */     oper.setReturnQName(new QName("", "createUserReturn"));
/*  230 */     oper.setStyle(Style.RPC);
/*  231 */     oper.setUse(Use.ENCODED);
/*  232 */     oper.addFault(new FaultDesc(
/*  233 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  234 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  235 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  236 */           true));
/*      */     
/*  238 */     oper.addFault(new FaultDesc(
/*  239 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  240 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/*  241 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/*  242 */           true));
/*      */     
/*  244 */     oper.addFault(new FaultDesc(
/*  245 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  246 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  247 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  248 */           true));
/*      */     
/*  250 */     oper.addFault(new FaultDesc(
/*  251 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  252 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  253 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  254 */           true));
/*      */     
/*  256 */     _operations[5] = oper;
/*      */     
/*  258 */     oper = new OperationDesc();
/*  259 */     oper.setName("getUser");
/*  260 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  261 */         1, 
/*  262 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  263 */         false);
/*  264 */     oper.addParameter(param);
/*  265 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  266 */         1, 
/*  267 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  268 */         false);
/*  269 */     oper.addParameter(param);
/*  270 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"));
/*  271 */     oper.setReturnClass(RemoteUser.class);
/*  272 */     oper.setReturnQName(new QName("", "getUserReturn"));
/*  273 */     oper.setStyle(Style.RPC);
/*  274 */     oper.setUse(Use.ENCODED);
/*  275 */     oper.addFault(new FaultDesc(
/*  276 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  277 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  278 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  279 */           true));
/*      */     
/*  281 */     oper.addFault(new FaultDesc(
/*  282 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  283 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  284 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  285 */           true));
/*      */     
/*  287 */     _operations[6] = oper;
/*      */     
/*  289 */     oper = new OperationDesc();
/*  290 */     oper.setName("login");
/*  291 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  292 */         1, 
/*  293 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  294 */         false);
/*  295 */     oper.addParameter(param);
/*  296 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  297 */         1, 
/*  298 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  299 */         false);
/*  300 */     oper.addParameter(param);
/*  301 */     oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/*  302 */     oper.setReturnClass(String.class);
/*  303 */     oper.setReturnQName(new QName("", "loginReturn"));
/*  304 */     oper.setStyle(Style.RPC);
/*  305 */     oper.setUse(Use.ENCODED);
/*  306 */     oper.addFault(new FaultDesc(
/*  307 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  308 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  309 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  310 */           true));
/*      */     
/*  312 */     oper.addFault(new FaultDesc(
/*  313 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  314 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  315 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  316 */           true));
/*      */     
/*  318 */     _operations[7] = oper;
/*      */     
/*  320 */     oper = new OperationDesc();
/*  321 */     oper.setName("getIssue");
/*  322 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  323 */         1, 
/*  324 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  325 */         false);
/*  326 */     oper.addParameter(param);
/*  327 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  328 */         1, 
/*  329 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  330 */         false);
/*  331 */     oper.addParameter(param);
/*  332 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"));
/*  333 */     oper.setReturnClass(RemoteIssue.class);
/*  334 */     oper.setReturnQName(new QName("", "getIssueReturn"));
/*  335 */     oper.setStyle(Style.RPC);
/*  336 */     oper.setUse(Use.ENCODED);
/*  337 */     oper.addFault(new FaultDesc(
/*  338 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  339 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  340 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  341 */           true));
/*      */     
/*  343 */     oper.addFault(new FaultDesc(
/*  344 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  345 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  346 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  347 */           true));
/*      */     
/*  349 */     oper.addFault(new FaultDesc(
/*  350 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  351 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  352 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  353 */           true));
/*      */     
/*  355 */     _operations[8] = oper;
/*      */     
/*  357 */     oper = new OperationDesc();
/*  358 */     oper.setName("createIssue");
/*  359 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  360 */         1, 
/*  361 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  362 */         false);
/*  363 */     oper.addParameter(param);
/*  364 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  365 */         1, 
/*  366 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"), 
/*  367 */         RemoteIssue.class, false, false);
/*  368 */     oper.addParameter(param);
/*  369 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"));
/*  370 */     oper.setReturnClass(RemoteIssue.class);
/*  371 */     oper.setReturnQName(new QName("", "createIssueReturn"));
/*  372 */     oper.setStyle(Style.RPC);
/*  373 */     oper.setUse(Use.ENCODED);
/*  374 */     oper.addFault(new FaultDesc(
/*  375 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  376 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  377 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  378 */           true));
/*      */     
/*  380 */     oper.addFault(new FaultDesc(
/*  381 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  382 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/*  383 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/*  384 */           true));
/*      */     
/*  386 */     oper.addFault(new FaultDesc(
/*  387 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  388 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  389 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  390 */           true));
/*      */     
/*  392 */     oper.addFault(new FaultDesc(
/*  393 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  394 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  395 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  396 */           true));
/*      */     
/*  398 */     _operations[9] = oper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void _initOperationDesc2() {
/*  405 */     OperationDesc oper = new OperationDesc();
/*  406 */     oper.setName("getAvailableActions");
/*  407 */     ParameterDesc param = new ParameterDesc(new QName("", "in0"), (byte)
/*  408 */         1, 
/*  409 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  410 */         false);
/*  411 */     oper.addParameter(param);
/*  412 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  413 */         1, 
/*  414 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  415 */         false);
/*  416 */     oper.addParameter(param);
/*  417 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/*  418 */           "ArrayOf_tns1_RemoteNamedObject"));
/*  419 */     oper.setReturnClass(RemoteNamedObject[].class);
/*  420 */     oper.setReturnQName(new QName("", "getAvailableActionsReturn"));
/*  421 */     oper.setStyle(Style.RPC);
/*  422 */     oper.setUse(Use.ENCODED);
/*  423 */     oper.addFault(new FaultDesc(
/*  424 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  425 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  426 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  427 */           true));
/*      */     
/*  429 */     _operations[10] = oper;
/*      */     
/*  431 */     oper = new OperationDesc();
/*  432 */     oper.setName("updateIssue");
/*  433 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  434 */         1, 
/*  435 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  436 */         false);
/*  437 */     oper.addParameter(param);
/*  438 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  439 */         1, 
/*  440 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  441 */         false);
/*  442 */     oper.addParameter(param);
/*  443 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/*  444 */         1, new QName(
/*  445 */           "http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteFieldValue"), 
/*  446 */         RemoteFieldValue[].class, false, false);
/*  447 */     oper.addParameter(param);
/*  448 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"));
/*  449 */     oper.setReturnClass(RemoteIssue.class);
/*  450 */     oper.setReturnQName(new QName("", "updateIssueReturn"));
/*  451 */     oper.setStyle(Style.RPC);
/*  452 */     oper.setUse(Use.ENCODED);
/*  453 */     oper.addFault(new FaultDesc(
/*  454 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  455 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  456 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  457 */           true));
/*      */     
/*  459 */     _operations[11] = oper;
/*      */     
/*  461 */     oper = new OperationDesc();
/*  462 */     oper.setName("getConfiguration");
/*  463 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  464 */         1, 
/*  465 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  466 */         false);
/*  467 */     oper.addParameter(param);
/*  468 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteConfiguration"));
/*  469 */     oper.setReturnClass(RemoteConfiguration.class);
/*  470 */     oper.setReturnQName(new QName("", "getConfigurationReturn"));
/*  471 */     oper.setStyle(Style.RPC);
/*  472 */     oper.setUse(Use.ENCODED);
/*  473 */     oper.addFault(new FaultDesc(
/*  474 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  475 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  476 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  477 */           true));
/*      */     
/*  479 */     oper.addFault(new FaultDesc(
/*  480 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  481 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  482 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  483 */           true));
/*      */     
/*  485 */     oper.addFault(new FaultDesc(
/*  486 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  487 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  488 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  489 */           true));
/*      */     
/*  491 */     _operations[12] = oper;
/*      */     
/*  493 */     oper = new OperationDesc();
/*  494 */     oper.setName("getComponents");
/*  495 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  496 */         1, 
/*  497 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  498 */         false);
/*  499 */     oper.addParameter(param);
/*  500 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  501 */         1, 
/*  502 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  503 */         false);
/*  504 */     oper.addParameter(param);
/*  505 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/*  506 */           "ArrayOf_tns1_RemoteComponent"));
/*  507 */     oper.setReturnClass(RemoteComponent[].class);
/*  508 */     oper.setReturnQName(new QName("", "getComponentsReturn"));
/*  509 */     oper.setStyle(Style.RPC);
/*  510 */     oper.setUse(Use.ENCODED);
/*  511 */     oper.addFault(new FaultDesc(
/*  512 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  513 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  514 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  515 */           true));
/*      */     
/*  517 */     oper.addFault(new FaultDesc(
/*  518 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  519 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  520 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  521 */           true));
/*      */     
/*  523 */     oper.addFault(new FaultDesc(
/*  524 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  525 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  526 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  527 */           true));
/*      */     
/*  529 */     _operations[13] = oper;
/*      */     
/*  531 */     oper = new OperationDesc();
/*  532 */     oper.setName("updateProject");
/*  533 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  534 */         1, 
/*  535 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  536 */         false);
/*  537 */     oper.addParameter(param);
/*  538 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  539 */         1, 
/*  540 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"), 
/*  541 */         RemoteProject.class, false, false);
/*  542 */     oper.addParameter(param);
/*  543 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"));
/*  544 */     oper.setReturnClass(RemoteProject.class);
/*  545 */     oper.setReturnQName(new QName("", "updateProjectReturn"));
/*  546 */     oper.setStyle(Style.RPC);
/*  547 */     oper.setUse(Use.ENCODED);
/*  548 */     oper.addFault(new FaultDesc(
/*  549 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  550 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  551 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  552 */           true));
/*      */     
/*  554 */     oper.addFault(new FaultDesc(
/*  555 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  556 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/*  557 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/*  558 */           true));
/*      */     
/*  560 */     oper.addFault(new FaultDesc(
/*  561 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  562 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  563 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  564 */           true));
/*      */     
/*  566 */     oper.addFault(new FaultDesc(
/*  567 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  568 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  569 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  570 */           true));
/*      */     
/*  572 */     _operations[14] = oper;
/*      */     
/*  574 */     oper = new OperationDesc();
/*  575 */     oper.setName("getProjectByKey");
/*  576 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  577 */         1, 
/*  578 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  579 */         false);
/*  580 */     oper.addParameter(param);
/*  581 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  582 */         1, 
/*  583 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  584 */         false);
/*  585 */     oper.addParameter(param);
/*  586 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"));
/*  587 */     oper.setReturnClass(RemoteProject.class);
/*  588 */     oper.setReturnQName(new QName("", "getProjectByKeyReturn"));
/*  589 */     oper.setStyle(Style.RPC);
/*  590 */     oper.setUse(Use.ENCODED);
/*  591 */     oper.addFault(new FaultDesc(
/*  592 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  593 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  594 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  595 */           true));
/*      */     
/*  597 */     oper.addFault(new FaultDesc(
/*  598 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  599 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  600 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  601 */           true));
/*      */     
/*  603 */     oper.addFault(new FaultDesc(
/*  604 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  605 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  606 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  607 */           true));
/*      */     
/*  609 */     _operations[15] = oper;
/*      */     
/*  611 */     oper = new OperationDesc();
/*  612 */     oper.setName("getPriorities");
/*  613 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  614 */         1, 
/*  615 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  616 */         false);
/*  617 */     oper.addParameter(param);
/*  618 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/*  619 */           "ArrayOf_tns1_RemotePriority"));
/*  620 */     oper.setReturnClass(RemotePriority[].class);
/*  621 */     oper.setReturnQName(new QName("", "getPrioritiesReturn"));
/*  622 */     oper.setStyle(Style.RPC);
/*  623 */     oper.setUse(Use.ENCODED);
/*  624 */     oper.addFault(new FaultDesc(
/*  625 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  626 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  627 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  628 */           true));
/*      */     
/*  630 */     oper.addFault(new FaultDesc(
/*  631 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  632 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  633 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  634 */           true));
/*      */     
/*  636 */     _operations[16] = oper;
/*      */     
/*  638 */     oper = new OperationDesc();
/*  639 */     oper.setName("getResolutions");
/*  640 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  641 */         1, 
/*  642 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  643 */         false);
/*  644 */     oper.addParameter(param);
/*  645 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/*  646 */           "ArrayOf_tns1_RemoteResolution"));
/*  647 */     oper.setReturnClass(RemoteResolution[].class);
/*  648 */     oper.setReturnQName(new QName("", "getResolutionsReturn"));
/*  649 */     oper.setStyle(Style.RPC);
/*  650 */     oper.setUse(Use.ENCODED);
/*  651 */     oper.addFault(new FaultDesc(
/*  652 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  653 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  654 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  655 */           true));
/*      */     
/*  657 */     oper.addFault(new FaultDesc(
/*  658 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  659 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  660 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  661 */           true));
/*      */     
/*  663 */     _operations[17] = oper;
/*      */     
/*  665 */     oper = new OperationDesc();
/*  666 */     oper.setName("getIssueTypes");
/*  667 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  668 */         1, 
/*  669 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  670 */         false);
/*  671 */     oper.addParameter(param);
/*  672 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/*  673 */           "ArrayOf_tns1_RemoteIssueType"));
/*  674 */     oper.setReturnClass(RemoteIssueType[].class);
/*  675 */     oper.setReturnQName(new QName("", "getIssueTypesReturn"));
/*  676 */     oper.setStyle(Style.RPC);
/*  677 */     oper.setUse(Use.ENCODED);
/*  678 */     oper.addFault(new FaultDesc(
/*  679 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  680 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  681 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  682 */           true));
/*      */     
/*  684 */     oper.addFault(new FaultDesc(
/*  685 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  686 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  687 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  688 */           true));
/*      */     
/*  690 */     _operations[18] = oper;
/*      */     
/*  692 */     oper = new OperationDesc();
/*  693 */     oper.setName("getStatuses");
/*  694 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  695 */         1, 
/*  696 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  697 */         false);
/*  698 */     oper.addParameter(param);
/*  699 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/*  700 */           "ArrayOf_tns1_RemoteStatus"));
/*  701 */     oper.setReturnClass(RemoteStatus[].class);
/*  702 */     oper.setReturnQName(new QName("", "getStatusesReturn"));
/*  703 */     oper.setStyle(Style.RPC);
/*  704 */     oper.setUse(Use.ENCODED);
/*  705 */     oper.addFault(new FaultDesc(
/*  706 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  707 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  708 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  709 */           true));
/*      */     
/*  711 */     oper.addFault(new FaultDesc(
/*  712 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  713 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  714 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  715 */           true));
/*      */     
/*  717 */     _operations[19] = oper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void _initOperationDesc3() {
/*  724 */     OperationDesc oper = new OperationDesc();
/*  725 */     oper.setName("getSubTaskIssueTypes");
/*  726 */     ParameterDesc param = new ParameterDesc(new QName("", "in0"), (byte)
/*  727 */         1, 
/*  728 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  729 */         false);
/*  730 */     oper.addParameter(param);
/*  731 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/*  732 */           "ArrayOf_tns1_RemoteIssueType"));
/*  733 */     oper.setReturnClass(RemoteIssueType[].class);
/*  734 */     oper.setReturnQName(new QName("", "getSubTaskIssueTypesReturn"));
/*  735 */     oper.setStyle(Style.RPC);
/*  736 */     oper.setUse(Use.ENCODED);
/*  737 */     oper.addFault(new FaultDesc(
/*  738 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  739 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/*  740 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/*  741 */           true));
/*      */     
/*  743 */     oper.addFault(new FaultDesc(
/*  744 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  745 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/*  746 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/*  747 */           true));
/*      */     
/*  749 */     _operations[20] = oper;
/*      */     
/*  751 */     oper = new OperationDesc();
/*  752 */     oper.setName("getProjectRoles");
/*  753 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  754 */         1, 
/*  755 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  756 */         false);
/*  757 */     oper.addParameter(param);
/*  758 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/*  759 */           "ArrayOf_tns1_RemoteProjectRole"));
/*  760 */     oper.setReturnClass(RemoteProjectRole[].class);
/*  761 */     oper.setReturnQName(new QName("", "getProjectRolesReturn"));
/*  762 */     oper.setStyle(Style.RPC);
/*  763 */     oper.setUse(Use.ENCODED);
/*  764 */     oper.addFault(new FaultDesc(
/*  765 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  766 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  767 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  768 */           true));
/*      */     
/*  770 */     _operations[21] = oper;
/*      */     
/*  772 */     oper = new OperationDesc();
/*  773 */     oper.setName("getProjectRole");
/*  774 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  775 */         1, 
/*  776 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  777 */         false);
/*  778 */     oper.addParameter(param);
/*  779 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  780 */         1, 
/*  781 */         new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
/*  782 */     oper.addParameter(param);
/*  783 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"));
/*  784 */     oper.setReturnClass(RemoteProjectRole.class);
/*  785 */     oper.setReturnQName(new QName("", "getProjectRoleReturn"));
/*  786 */     oper.setStyle(Style.RPC);
/*  787 */     oper.setUse(Use.ENCODED);
/*  788 */     oper.addFault(new FaultDesc(
/*  789 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  790 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  791 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  792 */           true));
/*      */     
/*  794 */     _operations[22] = oper;
/*      */     
/*  796 */     oper = new OperationDesc();
/*  797 */     oper.setName("getProjectRoleActors");
/*  798 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  799 */         1, 
/*  800 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  801 */         false);
/*  802 */     oper.addParameter(param);
/*  803 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  804 */         1, 
/*  805 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"), 
/*  806 */         RemoteProjectRole.class, false, false);
/*  807 */     oper.addParameter(param);
/*  808 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/*  809 */         1, 
/*  810 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"), 
/*  811 */         RemoteProject.class, false, false);
/*  812 */     oper.addParameter(param);
/*  813 */     oper.setReturnType(
/*  814 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRoleActors"));
/*  815 */     oper.setReturnClass(RemoteProjectRoleActors.class);
/*  816 */     oper.setReturnQName(new QName("", "getProjectRoleActorsReturn"));
/*  817 */     oper.setStyle(Style.RPC);
/*  818 */     oper.setUse(Use.ENCODED);
/*  819 */     oper.addFault(new FaultDesc(
/*  820 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  821 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  822 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  823 */           true));
/*      */     
/*  825 */     _operations[23] = oper;
/*      */     
/*  827 */     oper = new OperationDesc();
/*  828 */     oper.setName("getDefaultRoleActors");
/*  829 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  830 */         1, 
/*  831 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  832 */         false);
/*  833 */     oper.addParameter(param);
/*  834 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  835 */         1, 
/*  836 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"), 
/*  837 */         RemoteProjectRole.class, false, false);
/*  838 */     oper.addParameter(param);
/*  839 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteRoleActors"));
/*  840 */     oper.setReturnClass(RemoteRoleActors.class);
/*  841 */     oper.setReturnQName(new QName("", "getDefaultRoleActorsReturn"));
/*  842 */     oper.setStyle(Style.RPC);
/*  843 */     oper.setUse(Use.ENCODED);
/*  844 */     oper.addFault(new FaultDesc(
/*  845 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  846 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  847 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  848 */           true));
/*      */     
/*  850 */     _operations[24] = oper;
/*      */     
/*  852 */     oper = new OperationDesc();
/*  853 */     oper.setName("removeAllRoleActorsByNameAndType");
/*  854 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  855 */         1, 
/*  856 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  857 */         false);
/*  858 */     oper.addParameter(param);
/*  859 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  860 */         1, 
/*  861 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  862 */         false);
/*  863 */     oper.addParameter(param);
/*  864 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/*  865 */         1, 
/*  866 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  867 */         false);
/*  868 */     oper.addParameter(param);
/*  869 */     oper.setReturnType(XMLType.AXIS_VOID);
/*  870 */     oper.setStyle(Style.RPC);
/*  871 */     oper.setUse(Use.ENCODED);
/*  872 */     oper.addFault(new FaultDesc(
/*  873 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  874 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  875 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  876 */           true));
/*      */     
/*  878 */     _operations[25] = oper;
/*      */     
/*  880 */     oper = new OperationDesc();
/*  881 */     oper.setName("removeAllRoleActorsByProject");
/*  882 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  883 */         1, 
/*  884 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  885 */         false);
/*  886 */     oper.addParameter(param);
/*  887 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  888 */         1, 
/*  889 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"), 
/*  890 */         RemoteProject.class, false, false);
/*  891 */     oper.addParameter(param);
/*  892 */     oper.setReturnType(XMLType.AXIS_VOID);
/*  893 */     oper.setStyle(Style.RPC);
/*  894 */     oper.setUse(Use.ENCODED);
/*  895 */     oper.addFault(new FaultDesc(
/*  896 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  897 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  898 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  899 */           true));
/*      */     
/*  901 */     _operations[26] = oper;
/*      */     
/*  903 */     oper = new OperationDesc();
/*  904 */     oper.setName("deleteProjectRole");
/*  905 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  906 */         1, 
/*  907 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  908 */         false);
/*  909 */     oper.addParameter(param);
/*  910 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  911 */         1, 
/*  912 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"), 
/*  913 */         RemoteProjectRole.class, false, false);
/*  914 */     oper.addParameter(param);
/*  915 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/*  916 */         1, 
/*  917 */         new QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
/*  918 */     oper.addParameter(param);
/*  919 */     oper.setReturnType(XMLType.AXIS_VOID);
/*  920 */     oper.setStyle(Style.RPC);
/*  921 */     oper.setUse(Use.ENCODED);
/*  922 */     oper.addFault(new FaultDesc(
/*  923 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  924 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  925 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  926 */           true));
/*      */     
/*  928 */     _operations[27] = oper;
/*      */     
/*  930 */     oper = new OperationDesc();
/*  931 */     oper.setName("updateProjectRole");
/*  932 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  933 */         1, 
/*  934 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  935 */         false);
/*  936 */     oper.addParameter(param);
/*  937 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  938 */         1, 
/*  939 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"), 
/*  940 */         RemoteProjectRole.class, false, false);
/*  941 */     oper.addParameter(param);
/*  942 */     oper.setReturnType(XMLType.AXIS_VOID);
/*  943 */     oper.setStyle(Style.RPC);
/*  944 */     oper.setUse(Use.ENCODED);
/*  945 */     oper.addFault(new FaultDesc(
/*  946 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  947 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  948 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  949 */           true));
/*      */     
/*  951 */     _operations[28] = oper;
/*      */     
/*  953 */     oper = new OperationDesc();
/*  954 */     oper.setName("createProjectRole");
/*  955 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/*  956 */         1, 
/*  957 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  958 */         false);
/*  959 */     oper.addParameter(param);
/*  960 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  961 */         1, 
/*  962 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"), 
/*  963 */         RemoteProjectRole.class, false, false);
/*  964 */     oper.addParameter(param);
/*  965 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"));
/*  966 */     oper.setReturnClass(RemoteProjectRole.class);
/*  967 */     oper.setReturnQName(new QName("", "createProjectRoleReturn"));
/*  968 */     oper.setStyle(Style.RPC);
/*  969 */     oper.setUse(Use.ENCODED);
/*  970 */     oper.addFault(new FaultDesc(
/*  971 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/*  972 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/*  973 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/*  974 */           true));
/*      */     
/*  976 */     _operations[29] = oper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void _initOperationDesc4() {
/*  983 */     OperationDesc oper = new OperationDesc();
/*  984 */     oper.setName("isProjectRoleNameUnique");
/*  985 */     ParameterDesc param = new ParameterDesc(new QName("", "in0"), (byte)
/*  986 */         1, 
/*  987 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  988 */         false);
/*  989 */     oper.addParameter(param);
/*  990 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/*  991 */         1, 
/*  992 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/*  993 */         false);
/*  994 */     oper.addParameter(param);
/*  995 */     oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/*  996 */     oper.setReturnClass(boolean.class);
/*  997 */     oper.setReturnQName(new QName("", "isProjectRoleNameUniqueReturn"));
/*  998 */     oper.setStyle(Style.RPC);
/*  999 */     oper.setUse(Use.ENCODED);
/* 1000 */     oper.addFault(new FaultDesc(
/* 1001 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1002 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1003 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1004 */           true));
/*      */     
/* 1006 */     _operations[30] = oper;
/*      */     
/* 1008 */     oper = new OperationDesc();
/* 1009 */     oper.setName("addActorsToProjectRole");
/* 1010 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1011 */         1, 
/* 1012 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1013 */         false);
/* 1014 */     oper.addParameter(param);
/* 1015 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1016 */         1, 
/* 1017 */         new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_string"), 
/* 1018 */         String[].class, false, false);
/* 1019 */     oper.addParameter(param);
/* 1020 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1021 */         1, 
/* 1022 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"), 
/* 1023 */         RemoteProjectRole.class, false, false);
/* 1024 */     oper.addParameter(param);
/* 1025 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 1026 */         1, 
/* 1027 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"), 
/* 1028 */         RemoteProject.class, false, false);
/* 1029 */     oper.addParameter(param);
/* 1030 */     param = new ParameterDesc(new QName("", "in4"), (byte)
/* 1031 */         1, 
/* 1032 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1033 */         false);
/* 1034 */     oper.addParameter(param);
/* 1035 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 1036 */     oper.setStyle(Style.RPC);
/* 1037 */     oper.setUse(Use.ENCODED);
/* 1038 */     oper.addFault(new FaultDesc(
/* 1039 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1040 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1041 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1042 */           true));
/*      */     
/* 1044 */     _operations[31] = oper;
/*      */     
/* 1046 */     oper = new OperationDesc();
/* 1047 */     oper.setName("removeActorsFromProjectRole");
/* 1048 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1049 */         1, 
/* 1050 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1051 */         false);
/* 1052 */     oper.addParameter(param);
/* 1053 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1054 */         1, 
/* 1055 */         new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_string"), 
/* 1056 */         String[].class, false, false);
/* 1057 */     oper.addParameter(param);
/* 1058 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1059 */         1, 
/* 1060 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"), 
/* 1061 */         RemoteProjectRole.class, false, false);
/* 1062 */     oper.addParameter(param);
/* 1063 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 1064 */         1, 
/* 1065 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"), 
/* 1066 */         RemoteProject.class, false, false);
/* 1067 */     oper.addParameter(param);
/* 1068 */     param = new ParameterDesc(new QName("", "in4"), (byte)
/* 1069 */         1, 
/* 1070 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1071 */         false);
/* 1072 */     oper.addParameter(param);
/* 1073 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 1074 */     oper.setStyle(Style.RPC);
/* 1075 */     oper.setUse(Use.ENCODED);
/* 1076 */     oper.addFault(new FaultDesc(
/* 1077 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1078 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1079 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1080 */           true));
/*      */     
/* 1082 */     _operations[32] = oper;
/*      */     
/* 1084 */     oper = new OperationDesc();
/* 1085 */     oper.setName("addDefaultActorsToProjectRole");
/* 1086 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1087 */         1, 
/* 1088 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1089 */         false);
/* 1090 */     oper.addParameter(param);
/* 1091 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1092 */         1, 
/* 1093 */         new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_string"), 
/* 1094 */         String[].class, false, false);
/* 1095 */     oper.addParameter(param);
/* 1096 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1097 */         1, 
/* 1098 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"), 
/* 1099 */         RemoteProjectRole.class, false, false);
/* 1100 */     oper.addParameter(param);
/* 1101 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 1102 */         1, 
/* 1103 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1104 */         false);
/* 1105 */     oper.addParameter(param);
/* 1106 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 1107 */     oper.setStyle(Style.RPC);
/* 1108 */     oper.setUse(Use.ENCODED);
/* 1109 */     oper.addFault(new FaultDesc(
/* 1110 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1111 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1112 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1113 */           true));
/*      */     
/* 1115 */     _operations[33] = oper;
/*      */     
/* 1117 */     oper = new OperationDesc();
/* 1118 */     oper.setName("removeDefaultActorsFromProjectRole");
/* 1119 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1120 */         1, 
/* 1121 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1122 */         false);
/* 1123 */     oper.addParameter(param);
/* 1124 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1125 */         1, 
/* 1126 */         new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_string"), 
/* 1127 */         String[].class, false, false);
/* 1128 */     oper.addParameter(param);
/* 1129 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1130 */         1, 
/* 1131 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"), 
/* 1132 */         RemoteProjectRole.class, false, false);
/* 1133 */     oper.addParameter(param);
/* 1134 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 1135 */         1, 
/* 1136 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1137 */         false);
/* 1138 */     oper.addParameter(param);
/* 1139 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 1140 */     oper.setStyle(Style.RPC);
/* 1141 */     oper.setUse(Use.ENCODED);
/* 1142 */     oper.addFault(new FaultDesc(
/* 1143 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1144 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1145 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1146 */           true));
/*      */     
/* 1148 */     _operations[34] = oper;
/*      */     
/* 1150 */     oper = new OperationDesc();
/* 1151 */     oper.setName("getAssociatedNotificationSchemes");
/* 1152 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1153 */         1, 
/* 1154 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1155 */         false);
/* 1156 */     oper.addParameter(param);
/* 1157 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1158 */         1, 
/* 1159 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"), 
/* 1160 */         RemoteProjectRole.class, false, false);
/* 1161 */     oper.addParameter(param);
/* 1162 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 1163 */           "ArrayOf_tns1_RemoteScheme"));
/* 1164 */     oper.setReturnClass(RemoteScheme[].class);
/* 1165 */     oper.setReturnQName(new QName("", "getAssociatedNotificationSchemesReturn"));
/* 1166 */     oper.setStyle(Style.RPC);
/* 1167 */     oper.setUse(Use.ENCODED);
/* 1168 */     oper.addFault(new FaultDesc(
/* 1169 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1170 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1171 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1172 */           true));
/*      */     
/* 1174 */     _operations[35] = oper;
/*      */     
/* 1176 */     oper = new OperationDesc();
/* 1177 */     oper.setName("getAssociatedPermissionSchemes");
/* 1178 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1179 */         1, 
/* 1180 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1181 */         false);
/* 1182 */     oper.addParameter(param);
/* 1183 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1184 */         1, 
/* 1185 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole"), 
/* 1186 */         RemoteProjectRole.class, false, false);
/* 1187 */     oper.addParameter(param);
/* 1188 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 1189 */           "ArrayOf_tns1_RemoteScheme"));
/* 1190 */     oper.setReturnClass(RemoteScheme[].class);
/* 1191 */     oper.setReturnQName(new QName("", "getAssociatedPermissionSchemesReturn"));
/* 1192 */     oper.setStyle(Style.RPC);
/* 1193 */     oper.setUse(Use.ENCODED);
/* 1194 */     oper.addFault(new FaultDesc(
/* 1195 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1196 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1197 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1198 */           true));
/*      */     
/* 1200 */     _operations[36] = oper;
/*      */     
/* 1202 */     oper = new OperationDesc();
/* 1203 */     oper.setName("getCustomFields");
/* 1204 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1205 */         1, 
/* 1206 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1207 */         false);
/* 1208 */     oper.addParameter(param);
/* 1209 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 1210 */           "ArrayOf_tns1_RemoteField"));
/* 1211 */     oper.setReturnClass(RemoteField[].class);
/* 1212 */     oper.setReturnQName(new QName("", "getCustomFieldsReturn"));
/* 1213 */     oper.setStyle(Style.RPC);
/* 1214 */     oper.setUse(Use.ENCODED);
/* 1215 */     oper.addFault(new FaultDesc(
/* 1216 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1217 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1218 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1219 */           true));
/*      */     
/* 1221 */     _operations[37] = oper;
/*      */     
/* 1223 */     oper = new OperationDesc();
/* 1224 */     oper.setName("getComments");
/* 1225 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1226 */         1, 
/* 1227 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1228 */         false);
/* 1229 */     oper.addParameter(param);
/* 1230 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1231 */         1, 
/* 1232 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1233 */         false);
/* 1234 */     oper.addParameter(param);
/* 1235 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 1236 */           "ArrayOf_tns1_RemoteComment"));
/* 1237 */     oper.setReturnClass(RemoteComment[].class);
/* 1238 */     oper.setReturnQName(new QName("", "getCommentsReturn"));
/* 1239 */     oper.setStyle(Style.RPC);
/* 1240 */     oper.setUse(Use.ENCODED);
/* 1241 */     oper.addFault(new FaultDesc(
/* 1242 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1243 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1244 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1245 */           true));
/*      */     
/* 1247 */     oper.addFault(new FaultDesc(
/* 1248 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1249 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1250 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1251 */           true));
/*      */     
/* 1253 */     oper.addFault(new FaultDesc(
/* 1254 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1255 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1256 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1257 */           true));
/*      */     
/* 1259 */     _operations[38] = oper;
/*      */     
/* 1261 */     oper = new OperationDesc();
/* 1262 */     oper.setName("getFavouriteFilters");
/* 1263 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1264 */         1, 
/* 1265 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1266 */         false);
/* 1267 */     oper.addParameter(param);
/* 1268 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 1269 */           "ArrayOf_tns1_RemoteFilter"));
/* 1270 */     oper.setReturnClass(RemoteFilter[].class);
/* 1271 */     oper.setReturnQName(new QName("", "getFavouriteFiltersReturn"));
/* 1272 */     oper.setStyle(Style.RPC);
/* 1273 */     oper.setUse(Use.ENCODED);
/* 1274 */     oper.addFault(new FaultDesc(
/* 1275 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1276 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1277 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1278 */           true));
/*      */     
/* 1280 */     oper.addFault(new FaultDesc(
/* 1281 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1282 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1283 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1284 */           true));
/*      */     
/* 1286 */     oper.addFault(new FaultDesc(
/* 1287 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1288 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1289 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1290 */           true));
/*      */     
/* 1292 */     _operations[39] = oper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void _initOperationDesc5() {
/* 1299 */     OperationDesc oper = new OperationDesc();
/* 1300 */     oper.setName("archiveVersion");
/* 1301 */     ParameterDesc param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1302 */         1, 
/* 1303 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1304 */         false);
/* 1305 */     oper.addParameter(param);
/* 1306 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1307 */         1, 
/* 1308 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1309 */         false);
/* 1310 */     oper.addParameter(param);
/* 1311 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1312 */         1, 
/* 1313 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1314 */         false);
/* 1315 */     oper.addParameter(param);
/* 1316 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 1317 */         1, 
/* 1318 */         new QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
/* 1319 */     oper.addParameter(param);
/* 1320 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 1321 */     oper.setStyle(Style.RPC);
/* 1322 */     oper.setUse(Use.ENCODED);
/* 1323 */     oper.addFault(new FaultDesc(
/* 1324 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1325 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1326 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1327 */           true));
/*      */     
/* 1329 */     _operations[40] = oper;
/*      */     
/* 1331 */     oper = new OperationDesc();
/* 1332 */     oper.setName("getVersions");
/* 1333 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1334 */         1, 
/* 1335 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1336 */         false);
/* 1337 */     oper.addParameter(param);
/* 1338 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1339 */         1, 
/* 1340 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1341 */         false);
/* 1342 */     oper.addParameter(param);
/* 1343 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 1344 */           "ArrayOf_tns1_RemoteVersion"));
/* 1345 */     oper.setReturnClass(RemoteVersion[].class);
/* 1346 */     oper.setReturnQName(new QName("", "getVersionsReturn"));
/* 1347 */     oper.setStyle(Style.RPC);
/* 1348 */     oper.setUse(Use.ENCODED);
/* 1349 */     oper.addFault(new FaultDesc(
/* 1350 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1351 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1352 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1353 */           true));
/*      */     
/* 1355 */     oper.addFault(new FaultDesc(
/* 1356 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1357 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1358 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1359 */           true));
/*      */     
/* 1361 */     oper.addFault(new FaultDesc(
/* 1362 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1363 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1364 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1365 */           true));
/*      */     
/* 1367 */     _operations[41] = oper;
/*      */     
/* 1369 */     oper = new OperationDesc();
/* 1370 */     oper.setName("createProject");
/* 1371 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1372 */         1, 
/* 1373 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1374 */         false);
/* 1375 */     oper.addParameter(param);
/* 1376 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1377 */         1, 
/* 1378 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1379 */         false);
/* 1380 */     oper.addParameter(param);
/* 1381 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1382 */         1, 
/* 1383 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1384 */         false);
/* 1385 */     oper.addParameter(param);
/* 1386 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 1387 */         1, 
/* 1388 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1389 */         false);
/* 1390 */     oper.addParameter(param);
/* 1391 */     param = new ParameterDesc(new QName("", "in4"), (byte)
/* 1392 */         1, 
/* 1393 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1394 */         false);
/* 1395 */     oper.addParameter(param);
/* 1396 */     param = new ParameterDesc(new QName("", "in5"), (byte)
/* 1397 */         1, 
/* 1398 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1399 */         false);
/* 1400 */     oper.addParameter(param);
/* 1401 */     param = new ParameterDesc(new QName("", "in6"), (byte)
/* 1402 */         1, 
/* 1403 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"), 
/* 1404 */         RemotePermissionScheme.class, false, false);
/* 1405 */     oper.addParameter(param);
/* 1406 */     param = new ParameterDesc(new QName("", "in7"), (byte)
/* 1407 */         1, 
/* 1408 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteScheme"), 
/* 1409 */         RemoteScheme.class, false, false);
/* 1410 */     oper.addParameter(param);
/* 1411 */     param = new ParameterDesc(new QName("", "in8"), (byte)
/* 1412 */         1, 
/* 1413 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteScheme"), 
/* 1414 */         RemoteScheme.class, false, false);
/* 1415 */     oper.addParameter(param);
/* 1416 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"));
/* 1417 */     oper.setReturnClass(RemoteProject.class);
/* 1418 */     oper.setReturnQName(new QName("", "createProjectReturn"));
/* 1419 */     oper.setStyle(Style.RPC);
/* 1420 */     oper.setUse(Use.ENCODED);
/* 1421 */     oper.addFault(new FaultDesc(
/* 1422 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1423 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1424 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1425 */           true));
/*      */     
/* 1427 */     oper.addFault(new FaultDesc(
/* 1428 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1429 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 1430 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 1431 */           true));
/*      */     
/* 1433 */     oper.addFault(new FaultDesc(
/* 1434 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1435 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1436 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1437 */           true));
/*      */     
/* 1439 */     oper.addFault(new FaultDesc(
/* 1440 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1441 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1442 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1443 */           true));
/*      */     
/* 1445 */     _operations[42] = oper;
/*      */     
/* 1447 */     oper = new OperationDesc();
/* 1448 */     oper.setName("addComment");
/* 1449 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1450 */         1, 
/* 1451 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1452 */         false);
/* 1453 */     oper.addParameter(param);
/* 1454 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1455 */         1, 
/* 1456 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1457 */         false);
/* 1458 */     oper.addParameter(param);
/* 1459 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1460 */         1, 
/* 1461 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComment"), 
/* 1462 */         RemoteComment.class, false, false);
/* 1463 */     oper.addParameter(param);
/* 1464 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 1465 */     oper.setStyle(Style.RPC);
/* 1466 */     oper.setUse(Use.ENCODED);
/* 1467 */     oper.addFault(new FaultDesc(
/* 1468 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1469 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1470 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1471 */           true));
/*      */     
/* 1473 */     oper.addFault(new FaultDesc(
/* 1474 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1475 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1476 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1477 */           true));
/*      */     
/* 1479 */     oper.addFault(new FaultDesc(
/* 1480 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1481 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1482 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1483 */           true));
/*      */     
/* 1485 */     _operations[43] = oper;
/*      */     
/* 1487 */     oper = new OperationDesc();
/* 1488 */     oper.setName("getFieldsForEdit");
/* 1489 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1490 */         1, 
/* 1491 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1492 */         false);
/* 1493 */     oper.addParameter(param);
/* 1494 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1495 */         1, 
/* 1496 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1497 */         false);
/* 1498 */     oper.addParameter(param);
/* 1499 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 1500 */           "ArrayOf_tns1_RemoteField"));
/* 1501 */     oper.setReturnClass(RemoteField[].class);
/* 1502 */     oper.setReturnQName(new QName("", "getFieldsForEditReturn"));
/* 1503 */     oper.setStyle(Style.RPC);
/* 1504 */     oper.setUse(Use.ENCODED);
/* 1505 */     oper.addFault(new FaultDesc(
/* 1506 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1507 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1508 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1509 */           true));
/*      */     
/* 1511 */     _operations[44] = oper;
/*      */     
/* 1513 */     oper = new OperationDesc();
/* 1514 */     oper.setName("getIssueTypesForProject");
/* 1515 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1516 */         1, 
/* 1517 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1518 */         false);
/* 1519 */     oper.addParameter(param);
/* 1520 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1521 */         1, 
/* 1522 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1523 */         false);
/* 1524 */     oper.addParameter(param);
/* 1525 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 1526 */           "ArrayOf_tns1_RemoteIssueType"));
/* 1527 */     oper.setReturnClass(RemoteIssueType[].class);
/* 1528 */     oper.setReturnQName(new QName("", "getIssueTypesForProjectReturn"));
/* 1529 */     oper.setStyle(Style.RPC);
/* 1530 */     oper.setUse(Use.ENCODED);
/* 1531 */     oper.addFault(new FaultDesc(
/* 1532 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1533 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1534 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1535 */           true));
/*      */     
/* 1537 */     oper.addFault(new FaultDesc(
/* 1538 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1539 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1540 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1541 */           true));
/*      */     
/* 1543 */     _operations[45] = oper;
/*      */     
/* 1545 */     oper = new OperationDesc();
/* 1546 */     oper.setName("getSubTaskIssueTypesForProject");
/* 1547 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1548 */         1, 
/* 1549 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1550 */         false);
/* 1551 */     oper.addParameter(param);
/* 1552 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1553 */         1, 
/* 1554 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1555 */         false);
/* 1556 */     oper.addParameter(param);
/* 1557 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 1558 */           "ArrayOf_tns1_RemoteIssueType"));
/* 1559 */     oper.setReturnClass(RemoteIssueType[].class);
/* 1560 */     oper.setReturnQName(new QName("", "getSubTaskIssueTypesForProjectReturn"));
/* 1561 */     oper.setStyle(Style.RPC);
/* 1562 */     oper.setUse(Use.ENCODED);
/* 1563 */     oper.addFault(new FaultDesc(
/* 1564 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1565 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1566 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1567 */           true));
/*      */     
/* 1569 */     oper.addFault(new FaultDesc(
/* 1570 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1571 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1572 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1573 */           true));
/*      */     
/* 1575 */     _operations[46] = oper;
/*      */     
/* 1577 */     oper = new OperationDesc();
/* 1578 */     oper.setName("addUserToGroup");
/* 1579 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1580 */         1, 
/* 1581 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1582 */         false);
/* 1583 */     oper.addParameter(param);
/* 1584 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1585 */         1, 
/* 1586 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup"), 
/* 1587 */         RemoteGroup.class, false, false);
/* 1588 */     oper.addParameter(param);
/* 1589 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1590 */         1, 
/* 1591 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"), 
/* 1592 */         RemoteUser.class, false, false);
/* 1593 */     oper.addParameter(param);
/* 1594 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 1595 */     oper.setStyle(Style.RPC);
/* 1596 */     oper.setUse(Use.ENCODED);
/* 1597 */     oper.addFault(new FaultDesc(
/* 1598 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1599 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1600 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1601 */           true));
/*      */     
/* 1603 */     oper.addFault(new FaultDesc(
/* 1604 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1605 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 1606 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 1607 */           true));
/*      */     
/* 1609 */     oper.addFault(new FaultDesc(
/* 1610 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1611 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1612 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1613 */           true));
/*      */     
/* 1615 */     oper.addFault(new FaultDesc(
/* 1616 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1617 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1618 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1619 */           true));
/*      */     
/* 1621 */     _operations[47] = oper;
/*      */     
/* 1623 */     oper = new OperationDesc();
/* 1624 */     oper.setName("removeUserFromGroup");
/* 1625 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1626 */         1, 
/* 1627 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1628 */         false);
/* 1629 */     oper.addParameter(param);
/* 1630 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1631 */         1, 
/* 1632 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup"), 
/* 1633 */         RemoteGroup.class, false, false);
/* 1634 */     oper.addParameter(param);
/* 1635 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1636 */         1, 
/* 1637 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"), 
/* 1638 */         RemoteUser.class, false, false);
/* 1639 */     oper.addParameter(param);
/* 1640 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 1641 */     oper.setStyle(Style.RPC);
/* 1642 */     oper.setUse(Use.ENCODED);
/* 1643 */     oper.addFault(new FaultDesc(
/* 1644 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1645 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1646 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1647 */           true));
/*      */     
/* 1649 */     oper.addFault(new FaultDesc(
/* 1650 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1651 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 1652 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 1653 */           true));
/*      */     
/* 1655 */     oper.addFault(new FaultDesc(
/* 1656 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1657 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1658 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1659 */           true));
/*      */     
/* 1661 */     oper.addFault(new FaultDesc(
/* 1662 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1663 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1664 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1665 */           true));
/*      */     
/* 1667 */     _operations[48] = oper;
/*      */     
/* 1669 */     oper = new OperationDesc();
/* 1670 */     oper.setName("logout");
/* 1671 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1672 */         1, 
/* 1673 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1674 */         false);
/* 1675 */     oper.addParameter(param);
/* 1676 */     oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 1677 */     oper.setReturnClass(boolean.class);
/* 1678 */     oper.setReturnQName(new QName("", "logoutReturn"));
/* 1679 */     oper.setStyle(Style.RPC);
/* 1680 */     oper.setUse(Use.ENCODED);
/* 1681 */     _operations[49] = oper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void _initOperationDesc6() {
/* 1688 */     OperationDesc oper = new OperationDesc();
/* 1689 */     oper.setName("getProjectById");
/* 1690 */     ParameterDesc param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1691 */         1, 
/* 1692 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1693 */         false);
/* 1694 */     oper.addParameter(param);
/* 1695 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1696 */         1, 
/* 1697 */         new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
/* 1698 */     oper.addParameter(param);
/* 1699 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"));
/* 1700 */     oper.setReturnClass(RemoteProject.class);
/* 1701 */     oper.setReturnQName(new QName("", "getProjectByIdReturn"));
/* 1702 */     oper.setStyle(Style.RPC);
/* 1703 */     oper.setUse(Use.ENCODED);
/* 1704 */     oper.addFault(new FaultDesc(
/* 1705 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1706 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1707 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1708 */           true));
/*      */     
/* 1710 */     oper.addFault(new FaultDesc(
/* 1711 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1712 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1713 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1714 */           true));
/*      */     
/* 1716 */     oper.addFault(new FaultDesc(
/* 1717 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1718 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1719 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1720 */           true));
/*      */     
/* 1722 */     _operations[50] = oper;
/*      */     
/* 1724 */     oper = new OperationDesc();
/* 1725 */     oper.setName("getProjectWithSchemesById");
/* 1726 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1727 */         1, 
/* 1728 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1729 */         false);
/* 1730 */     oper.addParameter(param);
/* 1731 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1732 */         1, 
/* 1733 */         new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
/* 1734 */     oper.addParameter(param);
/* 1735 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"));
/* 1736 */     oper.setReturnClass(RemoteProject.class);
/* 1737 */     oper.setReturnQName(new QName("", "getProjectWithSchemesByIdReturn"));
/* 1738 */     oper.setStyle(Style.RPC);
/* 1739 */     oper.setUse(Use.ENCODED);
/* 1740 */     oper.addFault(new FaultDesc(
/* 1741 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1742 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1743 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1744 */           true));
/*      */     
/* 1746 */     _operations[51] = oper;
/*      */     
/* 1748 */     oper = new OperationDesc();
/* 1749 */     oper.setName("deleteProject");
/* 1750 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1751 */         1, 
/* 1752 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1753 */         false);
/* 1754 */     oper.addParameter(param);
/* 1755 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1756 */         1, 
/* 1757 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1758 */         false);
/* 1759 */     oper.addParameter(param);
/* 1760 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 1761 */     oper.setStyle(Style.RPC);
/* 1762 */     oper.setUse(Use.ENCODED);
/* 1763 */     oper.addFault(new FaultDesc(
/* 1764 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1765 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1766 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1767 */           true));
/*      */     
/* 1769 */     oper.addFault(new FaultDesc(
/* 1770 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1771 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1772 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1773 */           true));
/*      */     
/* 1775 */     oper.addFault(new FaultDesc(
/* 1776 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1777 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1778 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1779 */           true));
/*      */     
/* 1781 */     _operations[52] = oper;
/*      */     
/* 1783 */     oper = new OperationDesc();
/* 1784 */     oper.setName("releaseVersion");
/* 1785 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1786 */         1, 
/* 1787 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1788 */         false);
/* 1789 */     oper.addParameter(param);
/* 1790 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1791 */         1, 
/* 1792 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1793 */         false);
/* 1794 */     oper.addParameter(param);
/* 1795 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1796 */         1, 
/* 1797 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteVersion"), 
/* 1798 */         RemoteVersion.class, false, false);
/* 1799 */     oper.addParameter(param);
/* 1800 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 1801 */     oper.setStyle(Style.RPC);
/* 1802 */     oper.setUse(Use.ENCODED);
/* 1803 */     oper.addFault(new FaultDesc(
/* 1804 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1805 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1806 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1807 */           true));
/*      */     
/* 1809 */     _operations[53] = oper;
/*      */     
/* 1811 */     oper = new OperationDesc();
/* 1812 */     oper.setName("getSecurityLevels");
/* 1813 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1814 */         1, 
/* 1815 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1816 */         false);
/* 1817 */     oper.addParameter(param);
/* 1818 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1819 */         1, 
/* 1820 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1821 */         false);
/* 1822 */     oper.addParameter(param);
/* 1823 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 1824 */           "ArrayOf_tns1_RemoteSecurityLevel"));
/* 1825 */     oper.setReturnClass(RemoteSecurityLevel[].class);
/* 1826 */     oper.setReturnQName(new QName("", "getSecurityLevelsReturn"));
/* 1827 */     oper.setStyle(Style.RPC);
/* 1828 */     oper.setUse(Use.ENCODED);
/* 1829 */     oper.addFault(new FaultDesc(
/* 1830 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1831 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1832 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1833 */           true));
/*      */     
/* 1835 */     oper.addFault(new FaultDesc(
/* 1836 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1837 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1838 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1839 */           true));
/*      */     
/* 1841 */     _operations[54] = oper;
/*      */     
/* 1843 */     oper = new OperationDesc();
/* 1844 */     oper.setName("deleteIssue");
/* 1845 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1846 */         1, 
/* 1847 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1848 */         false);
/* 1849 */     oper.addParameter(param);
/* 1850 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1851 */         1, 
/* 1852 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1853 */         false);
/* 1854 */     oper.addParameter(param);
/* 1855 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 1856 */     oper.setStyle(Style.RPC);
/* 1857 */     oper.setUse(Use.ENCODED);
/* 1858 */     oper.addFault(new FaultDesc(
/* 1859 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1860 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1861 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1862 */           true));
/*      */     
/* 1864 */     oper.addFault(new FaultDesc(
/* 1865 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1866 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1867 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1868 */           true));
/*      */     
/* 1870 */     oper.addFault(new FaultDesc(
/* 1871 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1872 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1873 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1874 */           true));
/*      */     
/* 1876 */     _operations[55] = oper;
/*      */     
/* 1878 */     oper = new OperationDesc();
/* 1879 */     oper.setName("createIssueWithSecurityLevel");
/* 1880 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1881 */         1, 
/* 1882 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1883 */         false);
/* 1884 */     oper.addParameter(param);
/* 1885 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1886 */         1, 
/* 1887 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"), 
/* 1888 */         RemoteIssue.class, false, false);
/* 1889 */     oper.addParameter(param);
/* 1890 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1891 */         1, 
/* 1892 */         new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
/* 1893 */     oper.addParameter(param);
/* 1894 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"));
/* 1895 */     oper.setReturnClass(RemoteIssue.class);
/* 1896 */     oper.setReturnQName(new QName("", "createIssueWithSecurityLevelReturn"));
/* 1897 */     oper.setStyle(Style.RPC);
/* 1898 */     oper.setUse(Use.ENCODED);
/* 1899 */     oper.addFault(new FaultDesc(
/* 1900 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1901 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1902 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1903 */           true));
/*      */     
/* 1905 */     oper.addFault(new FaultDesc(
/* 1906 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1907 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 1908 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 1909 */           true));
/*      */     
/* 1911 */     oper.addFault(new FaultDesc(
/* 1912 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1913 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1914 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1915 */           true));
/*      */     
/* 1917 */     oper.addFault(new FaultDesc(
/* 1918 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1919 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1920 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1921 */           true));
/*      */     
/* 1923 */     _operations[56] = oper;
/*      */     
/* 1925 */     oper = new OperationDesc();
/* 1926 */     oper.setName("addAttachmentsToIssue");
/* 1927 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1928 */         1, 
/* 1929 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1930 */         false);
/* 1931 */     oper.addParameter(param);
/* 1932 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1933 */         1, 
/* 1934 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1935 */         false);
/* 1936 */     oper.addParameter(param);
/* 1937 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 1938 */         1, 
/* 1939 */         new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_string"), 
/* 1940 */         String[].class, false, false);
/* 1941 */     oper.addParameter(param);
/* 1942 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 1943 */         1, new QName(
/* 1944 */           "http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_base64Binary"), byte[][].class, false, 
/* 1945 */         false);
/* 1946 */     oper.addParameter(param);
/* 1947 */     oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 1948 */     oper.setReturnClass(boolean.class);
/* 1949 */     oper.setReturnQName(new QName("", "addAttachmentsToIssueReturn"));
/* 1950 */     oper.setStyle(Style.RPC);
/* 1951 */     oper.setUse(Use.ENCODED);
/* 1952 */     oper.addFault(new FaultDesc(
/* 1953 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1954 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1955 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 1956 */           true));
/*      */     
/* 1958 */     oper.addFault(new FaultDesc(
/* 1959 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1960 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 1961 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 1962 */           true));
/*      */     
/* 1964 */     oper.addFault(new FaultDesc(
/* 1965 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1966 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 1967 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 1968 */           true));
/*      */     
/* 1970 */     oper.addFault(new FaultDesc(
/* 1971 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1972 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 1973 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 1974 */           true));
/*      */     
/* 1976 */     _operations[57] = oper;
/*      */     
/* 1978 */     oper = new OperationDesc();
/* 1979 */     oper.setName("getAttachmentsFromIssue");
/* 1980 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 1981 */         1, 
/* 1982 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1983 */         false);
/* 1984 */     oper.addParameter(param);
/* 1985 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 1986 */         1, 
/* 1987 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 1988 */         false);
/* 1989 */     oper.addParameter(param);
/* 1990 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 1991 */           "ArrayOf_tns1_RemoteAttachment"));
/* 1992 */     oper.setReturnClass(RemoteAttachment[].class);
/* 1993 */     oper.setReturnQName(new QName("", "getAttachmentsFromIssueReturn"));
/* 1994 */     oper.setStyle(Style.RPC);
/* 1995 */     oper.setUse(Use.ENCODED);
/* 1996 */     oper.addFault(new FaultDesc(
/* 1997 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 1998 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 1999 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2000 */           true));
/*      */     
/* 2002 */     oper.addFault(new FaultDesc(
/* 2003 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2004 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2005 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2006 */           true));
/*      */     
/* 2008 */     oper.addFault(new FaultDesc(
/* 2009 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2010 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 2011 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 2012 */           true));
/*      */     
/* 2014 */     oper.addFault(new FaultDesc(
/* 2015 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2016 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2017 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2018 */           true));
/*      */     
/* 2020 */     _operations[58] = oper;
/*      */     
/* 2022 */     oper = new OperationDesc();
/* 2023 */     oper.setName("hasPermissionToEditComment");
/* 2024 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2025 */         1, 
/* 2026 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2027 */         false);
/* 2028 */     oper.addParameter(param);
/* 2029 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2030 */         1, 
/* 2031 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComment"), 
/* 2032 */         RemoteComment.class, false, false);
/* 2033 */     oper.addParameter(param);
/* 2034 */     oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 2035 */     oper.setReturnClass(boolean.class);
/* 2036 */     oper.setReturnQName(new QName("", "hasPermissionToEditCommentReturn"));
/* 2037 */     oper.setStyle(Style.RPC);
/* 2038 */     oper.setUse(Use.ENCODED);
/* 2039 */     oper.addFault(new FaultDesc(
/* 2040 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2041 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2042 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2043 */           true));
/*      */     
/* 2045 */     _operations[59] = oper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void _initOperationDesc7() {
/* 2052 */     OperationDesc oper = new OperationDesc();
/* 2053 */     oper.setName("editComment");
/* 2054 */     ParameterDesc param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2055 */         1, 
/* 2056 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2057 */         false);
/* 2058 */     oper.addParameter(param);
/* 2059 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2060 */         1, 
/* 2061 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComment"), 
/* 2062 */         RemoteComment.class, false, false);
/* 2063 */     oper.addParameter(param);
/* 2064 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComment"));
/* 2065 */     oper.setReturnClass(RemoteComment.class);
/* 2066 */     oper.setReturnQName(new QName("", "editCommentReturn"));
/* 2067 */     oper.setStyle(Style.RPC);
/* 2068 */     oper.setUse(Use.ENCODED);
/* 2069 */     oper.addFault(new FaultDesc(
/* 2070 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2071 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2072 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2073 */           true));
/*      */     
/* 2075 */     _operations[60] = oper;
/*      */     
/* 2077 */     oper = new OperationDesc();
/* 2078 */     oper.setName("getFieldsForAction");
/* 2079 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2080 */         1, 
/* 2081 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2082 */         false);
/* 2083 */     oper.addParameter(param);
/* 2084 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2085 */         1, 
/* 2086 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2087 */         false);
/* 2088 */     oper.addParameter(param);
/* 2089 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 2090 */         1, 
/* 2091 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2092 */         false);
/* 2093 */     oper.addParameter(param);
/* 2094 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 2095 */           "ArrayOf_tns1_RemoteField"));
/* 2096 */     oper.setReturnClass(RemoteField[].class);
/* 2097 */     oper.setReturnQName(new QName("", "getFieldsForActionReturn"));
/* 2098 */     oper.setStyle(Style.RPC);
/* 2099 */     oper.setUse(Use.ENCODED);
/* 2100 */     oper.addFault(new FaultDesc(
/* 2101 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2102 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2103 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2104 */           true));
/*      */     
/* 2106 */     _operations[61] = oper;
/*      */     
/* 2108 */     oper = new OperationDesc();
/* 2109 */     oper.setName("progressWorkflowAction");
/* 2110 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2111 */         1, 
/* 2112 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2113 */         false);
/* 2114 */     oper.addParameter(param);
/* 2115 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2116 */         1, 
/* 2117 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2118 */         false);
/* 2119 */     oper.addParameter(param);
/* 2120 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 2121 */         1, 
/* 2122 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2123 */         false);
/* 2124 */     oper.addParameter(param);
/* 2125 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 2126 */         1, new QName(
/* 2127 */           "http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteFieldValue"), 
/* 2128 */         RemoteFieldValue[].class, false, false);
/* 2129 */     oper.addParameter(param);
/* 2130 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"));
/* 2131 */     oper.setReturnClass(RemoteIssue.class);
/* 2132 */     oper.setReturnQName(new QName("", "progressWorkflowActionReturn"));
/* 2133 */     oper.setStyle(Style.RPC);
/* 2134 */     oper.setUse(Use.ENCODED);
/* 2135 */     oper.addFault(new FaultDesc(
/* 2136 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2137 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2138 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2139 */           true));
/*      */     
/* 2141 */     _operations[62] = oper;
/*      */     
/* 2143 */     oper = new OperationDesc();
/* 2144 */     oper.setName("getIssueById");
/* 2145 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2146 */         1, 
/* 2147 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2148 */         false);
/* 2149 */     oper.addParameter(param);
/* 2150 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2151 */         1, 
/* 2152 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2153 */         false);
/* 2154 */     oper.addParameter(param);
/* 2155 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"));
/* 2156 */     oper.setReturnClass(RemoteIssue.class);
/* 2157 */     oper.setReturnQName(new QName("", "getIssueByIdReturn"));
/* 2158 */     oper.setStyle(Style.RPC);
/* 2159 */     oper.setUse(Use.ENCODED);
/* 2160 */     oper.addFault(new FaultDesc(
/* 2161 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2162 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2163 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2164 */           true));
/*      */     
/* 2166 */     oper.addFault(new FaultDesc(
/* 2167 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2168 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 2169 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 2170 */           true));
/*      */     
/* 2172 */     oper.addFault(new FaultDesc(
/* 2173 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2174 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2175 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2176 */           true));
/*      */     
/* 2178 */     _operations[63] = oper;
/*      */     
/* 2180 */     oper = new OperationDesc();
/* 2181 */     oper.setName("addWorklogWithNewRemainingEstimate");
/* 2182 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2183 */         1, 
/* 2184 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2185 */         false);
/* 2186 */     oper.addParameter(param);
/* 2187 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2188 */         1, 
/* 2189 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2190 */         false);
/* 2191 */     oper.addParameter(param);
/* 2192 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 2193 */         1, 
/* 2194 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog"), 
/* 2195 */         RemoteWorklog.class, false, false);
/* 2196 */     oper.addParameter(param);
/* 2197 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 2198 */         1, 
/* 2199 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2200 */         false);
/* 2201 */     oper.addParameter(param);
/* 2202 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog"));
/* 2203 */     oper.setReturnClass(RemoteWorklog.class);
/* 2204 */     oper.setReturnQName(new QName("", "addWorklogWithNewRemainingEstimateReturn"));
/* 2205 */     oper.setStyle(Style.RPC);
/* 2206 */     oper.setUse(Use.ENCODED);
/* 2207 */     oper.addFault(new FaultDesc(
/* 2208 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2209 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2210 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2211 */           true));
/*      */     
/* 2213 */     oper.addFault(new FaultDesc(
/* 2214 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2215 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2216 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2217 */           true));
/*      */     
/* 2219 */     oper.addFault(new FaultDesc(
/* 2220 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2221 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2222 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2223 */           true));
/*      */     
/* 2225 */     _operations[64] = oper;
/*      */     
/* 2227 */     oper = new OperationDesc();
/* 2228 */     oper.setName("addWorklogAndAutoAdjustRemainingEstimate");
/* 2229 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2230 */         1, 
/* 2231 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2232 */         false);
/* 2233 */     oper.addParameter(param);
/* 2234 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2235 */         1, 
/* 2236 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2237 */         false);
/* 2238 */     oper.addParameter(param);
/* 2239 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 2240 */         1, 
/* 2241 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog"), 
/* 2242 */         RemoteWorklog.class, false, false);
/* 2243 */     oper.addParameter(param);
/* 2244 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog"));
/* 2245 */     oper.setReturnClass(RemoteWorklog.class);
/* 2246 */     oper.setReturnQName(new QName("", "addWorklogAndAutoAdjustRemainingEstimateReturn"));
/* 2247 */     oper.setStyle(Style.RPC);
/* 2248 */     oper.setUse(Use.ENCODED);
/* 2249 */     oper.addFault(new FaultDesc(
/* 2250 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2251 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2252 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2253 */           true));
/*      */     
/* 2255 */     oper.addFault(new FaultDesc(
/* 2256 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2257 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2258 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2259 */           true));
/*      */     
/* 2261 */     oper.addFault(new FaultDesc(
/* 2262 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2263 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2264 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2265 */           true));
/*      */     
/* 2267 */     _operations[65] = oper;
/*      */     
/* 2269 */     oper = new OperationDesc();
/* 2270 */     oper.setName("addWorklogAndRetainRemainingEstimate");
/* 2271 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2272 */         1, 
/* 2273 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2274 */         false);
/* 2275 */     oper.addParameter(param);
/* 2276 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2277 */         1, 
/* 2278 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2279 */         false);
/* 2280 */     oper.addParameter(param);
/* 2281 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 2282 */         1, 
/* 2283 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog"), 
/* 2284 */         RemoteWorklog.class, false, false);
/* 2285 */     oper.addParameter(param);
/* 2286 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog"));
/* 2287 */     oper.setReturnClass(RemoteWorklog.class);
/* 2288 */     oper.setReturnQName(new QName("", "addWorklogAndRetainRemainingEstimateReturn"));
/* 2289 */     oper.setStyle(Style.RPC);
/* 2290 */     oper.setUse(Use.ENCODED);
/* 2291 */     oper.addFault(new FaultDesc(
/* 2292 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2293 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2294 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2295 */           true));
/*      */     
/* 2297 */     oper.addFault(new FaultDesc(
/* 2298 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2299 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2300 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2301 */           true));
/*      */     
/* 2303 */     oper.addFault(new FaultDesc(
/* 2304 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2305 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2306 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2307 */           true));
/*      */     
/* 2309 */     _operations[66] = oper;
/*      */     
/* 2311 */     oper = new OperationDesc();
/* 2312 */     oper.setName("deleteWorklogWithNewRemainingEstimate");
/* 2313 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2314 */         1, 
/* 2315 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2316 */         false);
/* 2317 */     oper.addParameter(param);
/* 2318 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2319 */         1, 
/* 2320 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2321 */         false);
/* 2322 */     oper.addParameter(param);
/* 2323 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 2324 */         1, 
/* 2325 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2326 */         false);
/* 2327 */     oper.addParameter(param);
/* 2328 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 2329 */     oper.setStyle(Style.RPC);
/* 2330 */     oper.setUse(Use.ENCODED);
/* 2331 */     oper.addFault(new FaultDesc(
/* 2332 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2333 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2334 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2335 */           true));
/*      */     
/* 2337 */     oper.addFault(new FaultDesc(
/* 2338 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2339 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2340 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2341 */           true));
/*      */     
/* 2343 */     oper.addFault(new FaultDesc(
/* 2344 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2345 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2346 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2347 */           true));
/*      */     
/* 2349 */     _operations[67] = oper;
/*      */     
/* 2351 */     oper = new OperationDesc();
/* 2352 */     oper.setName("deleteWorklogAndAutoAdjustRemainingEstimate");
/* 2353 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2354 */         1, 
/* 2355 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2356 */         false);
/* 2357 */     oper.addParameter(param);
/* 2358 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2359 */         1, 
/* 2360 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2361 */         false);
/* 2362 */     oper.addParameter(param);
/* 2363 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 2364 */     oper.setStyle(Style.RPC);
/* 2365 */     oper.setUse(Use.ENCODED);
/* 2366 */     oper.addFault(new FaultDesc(
/* 2367 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2368 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2369 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2370 */           true));
/*      */     
/* 2372 */     oper.addFault(new FaultDesc(
/* 2373 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2374 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2375 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2376 */           true));
/*      */     
/* 2378 */     oper.addFault(new FaultDesc(
/* 2379 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2380 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2381 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2382 */           true));
/*      */     
/* 2384 */     _operations[68] = oper;
/*      */     
/* 2386 */     oper = new OperationDesc();
/* 2387 */     oper.setName("deleteWorklogAndRetainRemainingEstimate");
/* 2388 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2389 */         1, 
/* 2390 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2391 */         false);
/* 2392 */     oper.addParameter(param);
/* 2393 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2394 */         1, 
/* 2395 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2396 */         false);
/* 2397 */     oper.addParameter(param);
/* 2398 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 2399 */     oper.setStyle(Style.RPC);
/* 2400 */     oper.setUse(Use.ENCODED);
/* 2401 */     oper.addFault(new FaultDesc(
/* 2402 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2403 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2404 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2405 */           true));
/*      */     
/* 2407 */     oper.addFault(new FaultDesc(
/* 2408 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2409 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2410 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2411 */           true));
/*      */     
/* 2413 */     oper.addFault(new FaultDesc(
/* 2414 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2415 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2416 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2417 */           true));
/*      */     
/* 2419 */     _operations[69] = oper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void _initOperationDesc8() {
/* 2426 */     OperationDesc oper = new OperationDesc();
/* 2427 */     oper.setName("updateWorklogWithNewRemainingEstimate");
/* 2428 */     ParameterDesc param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2429 */         1, 
/* 2430 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2431 */         false);
/* 2432 */     oper.addParameter(param);
/* 2433 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2434 */         1, 
/* 2435 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog"), 
/* 2436 */         RemoteWorklog.class, false, false);
/* 2437 */     oper.addParameter(param);
/* 2438 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 2439 */         1, 
/* 2440 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2441 */         false);
/* 2442 */     oper.addParameter(param);
/* 2443 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 2444 */     oper.setStyle(Style.RPC);
/* 2445 */     oper.setUse(Use.ENCODED);
/* 2446 */     oper.addFault(new FaultDesc(
/* 2447 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2448 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2449 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2450 */           true));
/*      */     
/* 2452 */     oper.addFault(new FaultDesc(
/* 2453 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2454 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2455 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2456 */           true));
/*      */     
/* 2458 */     oper.addFault(new FaultDesc(
/* 2459 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2460 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2461 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2462 */           true));
/*      */     
/* 2464 */     _operations[70] = oper;
/*      */     
/* 2466 */     oper = new OperationDesc();
/* 2467 */     oper.setName("updateWorklogAndAutoAdjustRemainingEstimate");
/* 2468 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2469 */         1, 
/* 2470 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2471 */         false);
/* 2472 */     oper.addParameter(param);
/* 2473 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2474 */         1, 
/* 2475 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog"), 
/* 2476 */         RemoteWorklog.class, false, false);
/* 2477 */     oper.addParameter(param);
/* 2478 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 2479 */     oper.setStyle(Style.RPC);
/* 2480 */     oper.setUse(Use.ENCODED);
/* 2481 */     oper.addFault(new FaultDesc(
/* 2482 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2483 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2484 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2485 */           true));
/*      */     
/* 2487 */     oper.addFault(new FaultDesc(
/* 2488 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2489 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2490 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2491 */           true));
/*      */     
/* 2493 */     oper.addFault(new FaultDesc(
/* 2494 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2495 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2496 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2497 */           true));
/*      */     
/* 2499 */     _operations[71] = oper;
/*      */     
/* 2501 */     oper = new OperationDesc();
/* 2502 */     oper.setName("updateWorklogAndRetainRemainingEstimate");
/* 2503 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2504 */         1, 
/* 2505 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2506 */         false);
/* 2507 */     oper.addParameter(param);
/* 2508 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2509 */         1, 
/* 2510 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog"), 
/* 2511 */         RemoteWorklog.class, false, false);
/* 2512 */     oper.addParameter(param);
/* 2513 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 2514 */     oper.setStyle(Style.RPC);
/* 2515 */     oper.setUse(Use.ENCODED);
/* 2516 */     oper.addFault(new FaultDesc(
/* 2517 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2518 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2519 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2520 */           true));
/*      */     
/* 2522 */     oper.addFault(new FaultDesc(
/* 2523 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2524 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2525 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2526 */           true));
/*      */     
/* 2528 */     oper.addFault(new FaultDesc(
/* 2529 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2530 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2531 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2532 */           true));
/*      */     
/* 2534 */     _operations[72] = oper;
/*      */     
/* 2536 */     oper = new OperationDesc();
/* 2537 */     oper.setName("getWorklogs");
/* 2538 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2539 */         1, 
/* 2540 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2541 */         false);
/* 2542 */     oper.addParameter(param);
/* 2543 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2544 */         1, 
/* 2545 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2546 */         false);
/* 2547 */     oper.addParameter(param);
/* 2548 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 2549 */           "ArrayOf_tns1_RemoteWorklog"));
/* 2550 */     oper.setReturnClass(RemoteWorklog[].class);
/* 2551 */     oper.setReturnQName(new QName("", "getWorklogsReturn"));
/* 2552 */     oper.setStyle(Style.RPC);
/* 2553 */     oper.setUse(Use.ENCODED);
/* 2554 */     oper.addFault(new FaultDesc(
/* 2555 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2556 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2557 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2558 */           true));
/*      */     
/* 2560 */     oper.addFault(new FaultDesc(
/* 2561 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2562 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2563 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2564 */           true));
/*      */     
/* 2566 */     oper.addFault(new FaultDesc(
/* 2567 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2568 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2569 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2570 */           true));
/*      */     
/* 2572 */     _operations[73] = oper;
/*      */     
/* 2574 */     oper = new OperationDesc();
/* 2575 */     oper.setName("hasPermissionToCreateWorklog");
/* 2576 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2577 */         1, 
/* 2578 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2579 */         false);
/* 2580 */     oper.addParameter(param);
/* 2581 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2582 */         1, 
/* 2583 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2584 */         false);
/* 2585 */     oper.addParameter(param);
/* 2586 */     oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 2587 */     oper.setReturnClass(boolean.class);
/* 2588 */     oper.setReturnQName(new QName("", "hasPermissionToCreateWorklogReturn"));
/* 2589 */     oper.setStyle(Style.RPC);
/* 2590 */     oper.setUse(Use.ENCODED);
/* 2591 */     oper.addFault(new FaultDesc(
/* 2592 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2593 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2594 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2595 */           true));
/*      */     
/* 2597 */     oper.addFault(new FaultDesc(
/* 2598 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2599 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2600 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2601 */           true));
/*      */     
/* 2603 */     _operations[74] = oper;
/*      */     
/* 2605 */     oper = new OperationDesc();
/* 2606 */     oper.setName("hasPermissionToDeleteWorklog");
/* 2607 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2608 */         1, 
/* 2609 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2610 */         false);
/* 2611 */     oper.addParameter(param);
/* 2612 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2613 */         1, 
/* 2614 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2615 */         false);
/* 2616 */     oper.addParameter(param);
/* 2617 */     oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 2618 */     oper.setReturnClass(boolean.class);
/* 2619 */     oper.setReturnQName(new QName("", "hasPermissionToDeleteWorklogReturn"));
/* 2620 */     oper.setStyle(Style.RPC);
/* 2621 */     oper.setUse(Use.ENCODED);
/* 2622 */     oper.addFault(new FaultDesc(
/* 2623 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2624 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2625 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2626 */           true));
/*      */     
/* 2628 */     oper.addFault(new FaultDesc(
/* 2629 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2630 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2631 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2632 */           true));
/*      */     
/* 2634 */     _operations[75] = oper;
/*      */     
/* 2636 */     oper = new OperationDesc();
/* 2637 */     oper.setName("hasPermissionToUpdateWorklog");
/* 2638 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2639 */         1, 
/* 2640 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2641 */         false);
/* 2642 */     oper.addParameter(param);
/* 2643 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2644 */         1, 
/* 2645 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2646 */         false);
/* 2647 */     oper.addParameter(param);
/* 2648 */     oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 2649 */     oper.setReturnClass(boolean.class);
/* 2650 */     oper.setReturnQName(new QName("", "hasPermissionToUpdateWorklogReturn"));
/* 2651 */     oper.setStyle(Style.RPC);
/* 2652 */     oper.setUse(Use.ENCODED);
/* 2653 */     oper.addFault(new FaultDesc(
/* 2654 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2655 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2656 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2657 */           true));
/*      */     
/* 2659 */     oper.addFault(new FaultDesc(
/* 2660 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2661 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2662 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2663 */           true));
/*      */     
/* 2665 */     _operations[76] = oper;
/*      */     
/* 2667 */     oper = new OperationDesc();
/* 2668 */     oper.setName("getNotificationSchemes");
/* 2669 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2670 */         1, 
/* 2671 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2672 */         false);
/* 2673 */     oper.addParameter(param);
/* 2674 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 2675 */           "ArrayOf_tns1_RemoteScheme"));
/* 2676 */     oper.setReturnClass(RemoteScheme[].class);
/* 2677 */     oper.setReturnQName(new QName("", "getNotificationSchemesReturn"));
/* 2678 */     oper.setStyle(Style.RPC);
/* 2679 */     oper.setUse(Use.ENCODED);
/* 2680 */     oper.addFault(new FaultDesc(
/* 2681 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2682 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2683 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2684 */           true));
/*      */     
/* 2686 */     oper.addFault(new FaultDesc(
/* 2687 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2688 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 2689 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 2690 */           true));
/*      */     
/* 2692 */     oper.addFault(new FaultDesc(
/* 2693 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2694 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2695 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2696 */           true));
/*      */     
/* 2698 */     _operations[77] = oper;
/*      */     
/* 2700 */     oper = new OperationDesc();
/* 2701 */     oper.setName("getPermissionSchemes");
/* 2702 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2703 */         1, 
/* 2704 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2705 */         false);
/* 2706 */     oper.addParameter(param);
/* 2707 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 2708 */           "ArrayOf_tns1_RemotePermissionScheme"));
/* 2709 */     oper.setReturnClass(RemotePermissionScheme[].class);
/* 2710 */     oper.setReturnQName(new QName("", "getPermissionSchemesReturn"));
/* 2711 */     oper.setStyle(Style.RPC);
/* 2712 */     oper.setUse(Use.ENCODED);
/* 2713 */     oper.addFault(new FaultDesc(
/* 2714 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2715 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2716 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2717 */           true));
/*      */     
/* 2719 */     oper.addFault(new FaultDesc(
/* 2720 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2721 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 2722 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 2723 */           true));
/*      */     
/* 2725 */     oper.addFault(new FaultDesc(
/* 2726 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2727 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2728 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2729 */           true));
/*      */     
/* 2731 */     _operations[78] = oper;
/*      */     
/* 2733 */     oper = new OperationDesc();
/* 2734 */     oper.setName("createPermissionScheme");
/* 2735 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2736 */         1, 
/* 2737 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2738 */         false);
/* 2739 */     oper.addParameter(param);
/* 2740 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2741 */         1, 
/* 2742 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2743 */         false);
/* 2744 */     oper.addParameter(param);
/* 2745 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 2746 */         1, 
/* 2747 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2748 */         false);
/* 2749 */     oper.addParameter(param);
/* 2750 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"));
/* 2751 */     oper.setReturnClass(RemotePermissionScheme.class);
/* 2752 */     oper.setReturnQName(new QName("", "createPermissionSchemeReturn"));
/* 2753 */     oper.setStyle(Style.RPC);
/* 2754 */     oper.setUse(Use.ENCODED);
/* 2755 */     oper.addFault(new FaultDesc(
/* 2756 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2757 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2758 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2759 */           true));
/*      */     
/* 2761 */     oper.addFault(new FaultDesc(
/* 2762 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2763 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2764 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2765 */           true));
/*      */     
/* 2767 */     oper.addFault(new FaultDesc(
/* 2768 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2769 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 2770 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 2771 */           true));
/*      */     
/* 2773 */     oper.addFault(new FaultDesc(
/* 2774 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2775 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2776 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2777 */           true));
/*      */     
/* 2779 */     _operations[79] = oper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void _initOperationDesc9() {
/* 2786 */     OperationDesc oper = new OperationDesc();
/* 2787 */     oper.setName("deletePermissionScheme");
/* 2788 */     ParameterDesc param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2789 */         1, 
/* 2790 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2791 */         false);
/* 2792 */     oper.addParameter(param);
/* 2793 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2794 */         1, 
/* 2795 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2796 */         false);
/* 2797 */     oper.addParameter(param);
/* 2798 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 2799 */     oper.setStyle(Style.RPC);
/* 2800 */     oper.setUse(Use.ENCODED);
/* 2801 */     oper.addFault(new FaultDesc(
/* 2802 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2803 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2804 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2805 */           true));
/*      */     
/* 2807 */     oper.addFault(new FaultDesc(
/* 2808 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2809 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2810 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2811 */           true));
/*      */     
/* 2813 */     oper.addFault(new FaultDesc(
/* 2814 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2815 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 2816 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 2817 */           true));
/*      */     
/* 2819 */     oper.addFault(new FaultDesc(
/* 2820 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2821 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2822 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2823 */           true));
/*      */     
/* 2825 */     _operations[80] = oper;
/*      */     
/* 2827 */     oper = new OperationDesc();
/* 2828 */     oper.setName("addPermissionTo");
/* 2829 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2830 */         1, 
/* 2831 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2832 */         false);
/* 2833 */     oper.addParameter(param);
/* 2834 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2835 */         1, 
/* 2836 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"), 
/* 2837 */         RemotePermissionScheme.class, false, false);
/* 2838 */     oper.addParameter(param);
/* 2839 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 2840 */         1, 
/* 2841 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermission"), 
/* 2842 */         RemotePermission.class, false, false);
/* 2843 */     oper.addParameter(param);
/* 2844 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 2845 */         1, 
/* 2846 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteEntity"), 
/* 2847 */         RemoteEntity.class, false, false);
/* 2848 */     oper.addParameter(param);
/* 2849 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"));
/* 2850 */     oper.setReturnClass(RemotePermissionScheme.class);
/* 2851 */     oper.setReturnQName(new QName("", "addPermissionToReturn"));
/* 2852 */     oper.setStyle(Style.RPC);
/* 2853 */     oper.setUse(Use.ENCODED);
/* 2854 */     oper.addFault(new FaultDesc(
/* 2855 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2856 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2857 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2858 */           true));
/*      */     
/* 2860 */     oper.addFault(new FaultDesc(
/* 2861 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2862 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2863 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2864 */           true));
/*      */     
/* 2866 */     oper.addFault(new FaultDesc(
/* 2867 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2868 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 2869 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 2870 */           true));
/*      */     
/* 2872 */     oper.addFault(new FaultDesc(
/* 2873 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2874 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2875 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2876 */           true));
/*      */     
/* 2878 */     _operations[81] = oper;
/*      */     
/* 2880 */     oper = new OperationDesc();
/* 2881 */     oper.setName("deletePermissionFrom");
/* 2882 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2883 */         1, 
/* 2884 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2885 */         false);
/* 2886 */     oper.addParameter(param);
/* 2887 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2888 */         1, 
/* 2889 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"), 
/* 2890 */         RemotePermissionScheme.class, false, false);
/* 2891 */     oper.addParameter(param);
/* 2892 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 2893 */         1, 
/* 2894 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermission"), 
/* 2895 */         RemotePermission.class, false, false);
/* 2896 */     oper.addParameter(param);
/* 2897 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 2898 */         1, 
/* 2899 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteEntity"), 
/* 2900 */         RemoteEntity.class, false, false);
/* 2901 */     oper.addParameter(param);
/* 2902 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"));
/* 2903 */     oper.setReturnClass(RemotePermissionScheme.class);
/* 2904 */     oper.setReturnQName(new QName("", "deletePermissionFromReturn"));
/* 2905 */     oper.setStyle(Style.RPC);
/* 2906 */     oper.setUse(Use.ENCODED);
/* 2907 */     oper.addFault(new FaultDesc(
/* 2908 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2909 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2910 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2911 */           true));
/*      */     
/* 2913 */     oper.addFault(new FaultDesc(
/* 2914 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2915 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 2916 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 2917 */           true));
/*      */     
/* 2919 */     oper.addFault(new FaultDesc(
/* 2920 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2921 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 2922 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 2923 */           true));
/*      */     
/* 2925 */     oper.addFault(new FaultDesc(
/* 2926 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2927 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2928 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2929 */           true));
/*      */     
/* 2931 */     _operations[82] = oper;
/*      */     
/* 2933 */     oper = new OperationDesc();
/* 2934 */     oper.setName("getAllPermissions");
/* 2935 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2936 */         1, 
/* 2937 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2938 */         false);
/* 2939 */     oper.addParameter(param);
/* 2940 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 2941 */           "ArrayOf_tns1_RemotePermission"));
/* 2942 */     oper.setReturnClass(RemotePermission[].class);
/* 2943 */     oper.setReturnQName(new QName("", "getAllPermissionsReturn"));
/* 2944 */     oper.setStyle(Style.RPC);
/* 2945 */     oper.setUse(Use.ENCODED);
/* 2946 */     oper.addFault(new FaultDesc(
/* 2947 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2948 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 2949 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 2950 */           true));
/*      */     
/* 2952 */     oper.addFault(new FaultDesc(
/* 2953 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2954 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 2955 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 2956 */           true));
/*      */     
/* 2958 */     oper.addFault(new FaultDesc(
/* 2959 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2960 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2961 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2962 */           true));
/*      */     
/* 2964 */     _operations[83] = oper;
/*      */     
/* 2966 */     oper = new OperationDesc();
/* 2967 */     oper.setName("getIssueCountForFilter");
/* 2968 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2969 */         1, 
/* 2970 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2971 */         false);
/* 2972 */     oper.addParameter(param);
/* 2973 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2974 */         1, 
/* 2975 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2976 */         false);
/* 2977 */     oper.addParameter(param);
/* 2978 */     oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
/* 2979 */     oper.setReturnClass(long.class);
/* 2980 */     oper.setReturnQName(new QName("", "getIssueCountForFilterReturn"));
/* 2981 */     oper.setStyle(Style.RPC);
/* 2982 */     oper.setUse(Use.ENCODED);
/* 2983 */     oper.addFault(new FaultDesc(
/* 2984 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 2985 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 2986 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 2987 */           true));
/*      */     
/* 2989 */     _operations[84] = oper;
/*      */     
/* 2991 */     oper = new OperationDesc();
/* 2992 */     oper.setName("getIssuesFromTextSearch");
/* 2993 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 2994 */         1, 
/* 2995 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 2996 */         false);
/* 2997 */     oper.addParameter(param);
/* 2998 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 2999 */         1, 
/* 3000 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3001 */         false);
/* 3002 */     oper.addParameter(param);
/* 3003 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3004 */           "ArrayOf_tns1_RemoteIssue"));
/* 3005 */     oper.setReturnClass(RemoteIssue[].class);
/* 3006 */     oper.setReturnQName(new QName("", "getIssuesFromTextSearchReturn"));
/* 3007 */     oper.setStyle(Style.RPC);
/* 3008 */     oper.setUse(Use.ENCODED);
/* 3009 */     oper.addFault(new FaultDesc(
/* 3010 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3011 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3012 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3013 */           true));
/*      */     
/* 3015 */     _operations[85] = oper;
/*      */     
/* 3017 */     oper = new OperationDesc();
/* 3018 */     oper.setName("getIssuesFromTextSearchWithProject");
/* 3019 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3020 */         1, 
/* 3021 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3022 */         false);
/* 3023 */     oper.addParameter(param);
/* 3024 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 3025 */         1, 
/* 3026 */         new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_string"), 
/* 3027 */         String[].class, false, false);
/* 3028 */     oper.addParameter(param);
/* 3029 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 3030 */         1, 
/* 3031 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3032 */         false);
/* 3033 */     oper.addParameter(param);
/* 3034 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 3035 */         1, 
/* 3036 */         new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
/* 3037 */     oper.addParameter(param);
/* 3038 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3039 */           "ArrayOf_tns1_RemoteIssue"));
/* 3040 */     oper.setReturnClass(RemoteIssue[].class);
/* 3041 */     oper.setReturnQName(new QName("", "getIssuesFromTextSearchWithProjectReturn"));
/* 3042 */     oper.setStyle(Style.RPC);
/* 3043 */     oper.setUse(Use.ENCODED);
/* 3044 */     oper.addFault(new FaultDesc(
/* 3045 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3046 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3047 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3048 */           true));
/*      */     
/* 3050 */     _operations[86] = oper;
/*      */     
/* 3052 */     oper = new OperationDesc();
/* 3053 */     oper.setName("deleteUser");
/* 3054 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3055 */         1, 
/* 3056 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3057 */         false);
/* 3058 */     oper.addParameter(param);
/* 3059 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 3060 */         1, 
/* 3061 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3062 */         false);
/* 3063 */     oper.addParameter(param);
/* 3064 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 3065 */     oper.setStyle(Style.RPC);
/* 3066 */     oper.setUse(Use.ENCODED);
/* 3067 */     oper.addFault(new FaultDesc(
/* 3068 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3069 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 3070 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 3071 */           true));
/*      */     
/* 3073 */     oper.addFault(new FaultDesc(
/* 3074 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3075 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 3076 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 3077 */           true));
/*      */     
/* 3079 */     oper.addFault(new FaultDesc(
/* 3080 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3081 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 3082 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 3083 */           true));
/*      */     
/* 3085 */     oper.addFault(new FaultDesc(
/* 3086 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3087 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3088 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3089 */           true));
/*      */     
/* 3091 */     _operations[87] = oper;
/*      */     
/* 3093 */     oper = new OperationDesc();
/* 3094 */     oper.setName("updateGroup");
/* 3095 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3096 */         1, 
/* 3097 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3098 */         false);
/* 3099 */     oper.addParameter(param);
/* 3100 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 3101 */         1, 
/* 3102 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup"), 
/* 3103 */         RemoteGroup.class, false, false);
/* 3104 */     oper.addParameter(param);
/* 3105 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup"));
/* 3106 */     oper.setReturnClass(RemoteGroup.class);
/* 3107 */     oper.setReturnQName(new QName("", "updateGroupReturn"));
/* 3108 */     oper.setStyle(Style.RPC);
/* 3109 */     oper.setUse(Use.ENCODED);
/* 3110 */     oper.addFault(new FaultDesc(
/* 3111 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3112 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 3113 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 3114 */           true));
/*      */     
/* 3116 */     oper.addFault(new FaultDesc(
/* 3117 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3118 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 3119 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 3120 */           true));
/*      */     
/* 3122 */     oper.addFault(new FaultDesc(
/* 3123 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3124 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 3125 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 3126 */           true));
/*      */     
/* 3128 */     oper.addFault(new FaultDesc(
/* 3129 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3130 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3131 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3132 */           true));
/*      */     
/* 3134 */     _operations[88] = oper;
/*      */     
/* 3136 */     oper = new OperationDesc();
/* 3137 */     oper.setName("deleteGroup");
/* 3138 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3139 */         1, 
/* 3140 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3141 */         false);
/* 3142 */     oper.addParameter(param);
/* 3143 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 3144 */         1, 
/* 3145 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3146 */         false);
/* 3147 */     oper.addParameter(param);
/* 3148 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 3149 */         1, 
/* 3150 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3151 */         false);
/* 3152 */     oper.addParameter(param);
/* 3153 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 3154 */     oper.setStyle(Style.RPC);
/* 3155 */     oper.setUse(Use.ENCODED);
/* 3156 */     oper.addFault(new FaultDesc(
/* 3157 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3158 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 3159 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 3160 */           true));
/*      */     
/* 3162 */     oper.addFault(new FaultDesc(
/* 3163 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3164 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 3165 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 3166 */           true));
/*      */     
/* 3168 */     oper.addFault(new FaultDesc(
/* 3169 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3170 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 3171 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 3172 */           true));
/*      */     
/* 3174 */     oper.addFault(new FaultDesc(
/* 3175 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3176 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3177 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3178 */           true));
/*      */     
/* 3180 */     _operations[89] = oper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void _initOperationDesc10() {
/* 3187 */     OperationDesc oper = new OperationDesc();
/* 3188 */     oper.setName("refreshCustomFields");
/* 3189 */     ParameterDesc param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3190 */         1, 
/* 3191 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3192 */         false);
/* 3193 */     oper.addParameter(param);
/* 3194 */     oper.setReturnType(XMLType.AXIS_VOID);
/* 3195 */     oper.setStyle(Style.RPC);
/* 3196 */     oper.setUse(Use.ENCODED);
/* 3197 */     oper.addFault(new FaultDesc(
/* 3198 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3199 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3200 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3201 */           true));
/*      */     
/* 3203 */     _operations[90] = oper;
/*      */     
/* 3205 */     oper = new OperationDesc();
/* 3206 */     oper.setName("getProjectsNoSchemes");
/* 3207 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3208 */         1, 
/* 3209 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3210 */         false);
/* 3211 */     oper.addParameter(param);
/* 3212 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3213 */           "ArrayOf_tns1_RemoteProject"));
/* 3214 */     oper.setReturnClass(RemoteProject[].class);
/* 3215 */     oper.setReturnQName(new QName("", "getProjectsNoSchemesReturn"));
/* 3216 */     oper.setStyle(Style.RPC);
/* 3217 */     oper.setUse(Use.ENCODED);
/* 3218 */     oper.addFault(new FaultDesc(
/* 3219 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3220 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 3221 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 3222 */           true));
/*      */     
/* 3224 */     oper.addFault(new FaultDesc(
/* 3225 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3226 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 3227 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 3228 */           true));
/*      */     
/* 3230 */     oper.addFault(new FaultDesc(
/* 3231 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3232 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3233 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3234 */           true));
/*      */     
/* 3236 */     _operations[91] = oper;
/*      */     
/* 3238 */     oper = new OperationDesc();
/* 3239 */     oper.setName("addVersion");
/* 3240 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3241 */         1, 
/* 3242 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3243 */         false);
/* 3244 */     oper.addParameter(param);
/* 3245 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 3246 */         1, 
/* 3247 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3248 */         false);
/* 3249 */     oper.addParameter(param);
/* 3250 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 3251 */         1, 
/* 3252 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteVersion"), 
/* 3253 */         RemoteVersion.class, false, false);
/* 3254 */     oper.addParameter(param);
/* 3255 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteVersion"));
/* 3256 */     oper.setReturnClass(RemoteVersion.class);
/* 3257 */     oper.setReturnQName(new QName("", "addVersionReturn"));
/* 3258 */     oper.setStyle(Style.RPC);
/* 3259 */     oper.setUse(Use.ENCODED);
/* 3260 */     oper.addFault(new FaultDesc(
/* 3261 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3262 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3263 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3264 */           true));
/*      */     
/* 3266 */     _operations[92] = oper;
/*      */     
/* 3268 */     oper = new OperationDesc();
/* 3269 */     oper.setName("getSavedFilters");
/* 3270 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3271 */         1, 
/* 3272 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3273 */         false);
/* 3274 */     oper.addParameter(param);
/* 3275 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3276 */           "ArrayOf_tns1_RemoteFilter"));
/* 3277 */     oper.setReturnClass(RemoteFilter[].class);
/* 3278 */     oper.setReturnQName(new QName("", "getSavedFiltersReturn"));
/* 3279 */     oper.setStyle(Style.RPC);
/* 3280 */     oper.setUse(Use.ENCODED);
/* 3281 */     oper.addFault(new FaultDesc(
/* 3282 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3283 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 3284 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 3285 */           true));
/*      */     
/* 3287 */     oper.addFault(new FaultDesc(
/* 3288 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3289 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 3290 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 3291 */           true));
/*      */     
/* 3293 */     oper.addFault(new FaultDesc(
/* 3294 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3295 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3296 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3297 */           true));
/*      */     
/* 3299 */     _operations[93] = oper;
/*      */     
/* 3301 */     oper = new OperationDesc();
/* 3302 */     oper.setName("addBase64EncodedAttachmentsToIssue");
/* 3303 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3304 */         1, 
/* 3305 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3306 */         false);
/* 3307 */     oper.addParameter(param);
/* 3308 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 3309 */         1, 
/* 3310 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3311 */         false);
/* 3312 */     oper.addParameter(param);
/* 3313 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 3314 */         1, 
/* 3315 */         new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_string"), 
/* 3316 */         String[].class, false, false);
/* 3317 */     oper.addParameter(param);
/* 3318 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 3319 */         1, 
/* 3320 */         new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_string"), 
/* 3321 */         String[].class, false, false);
/* 3322 */     oper.addParameter(param);
/* 3323 */     oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
/* 3324 */     oper.setReturnClass(boolean.class);
/* 3325 */     oper.setReturnQName(new QName("", "addBase64EncodedAttachmentsToIssueReturn"));
/* 3326 */     oper.setStyle(Style.RPC);
/* 3327 */     oper.setUse(Use.ENCODED);
/* 3328 */     oper.addFault(new FaultDesc(
/* 3329 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3330 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 3331 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 3332 */           true));
/*      */     
/* 3334 */     oper.addFault(new FaultDesc(
/* 3335 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3336 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 3337 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 3338 */           true));
/*      */     
/* 3340 */     oper.addFault(new FaultDesc(
/* 3341 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3342 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 3343 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 3344 */           true));
/*      */     
/* 3346 */     oper.addFault(new FaultDesc(
/* 3347 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3348 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3349 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3350 */           true));
/*      */     
/* 3352 */     _operations[94] = oper;
/*      */     
/* 3354 */     oper = new OperationDesc();
/* 3355 */     oper.setName("createProjectFromObject");
/* 3356 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3357 */         1, 
/* 3358 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3359 */         false);
/* 3360 */     oper.addParameter(param);
/* 3361 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 3362 */         1, 
/* 3363 */         new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"), 
/* 3364 */         RemoteProject.class, false, false);
/* 3365 */     oper.addParameter(param);
/* 3366 */     oper.setReturnType(new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"));
/* 3367 */     oper.setReturnClass(RemoteProject.class);
/* 3368 */     oper.setReturnQName(new QName("", "createProjectFromObjectReturn"));
/* 3369 */     oper.setStyle(Style.RPC);
/* 3370 */     oper.setUse(Use.ENCODED);
/* 3371 */     oper.addFault(new FaultDesc(
/* 3372 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3373 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 3374 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 3375 */           true));
/*      */     
/* 3377 */     oper.addFault(new FaultDesc(
/* 3378 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3379 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteValidationException", 
/* 3380 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
/* 3381 */           true));
/*      */     
/* 3383 */     oper.addFault(new FaultDesc(
/* 3384 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3385 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 3386 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 3387 */           true));
/*      */     
/* 3389 */     oper.addFault(new FaultDesc(
/* 3390 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3391 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3392 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3393 */           true));
/*      */     
/* 3395 */     _operations[95] = oper;
/*      */     
/* 3397 */     oper = new OperationDesc();
/* 3398 */     oper.setName("getSecuritySchemes");
/* 3399 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3400 */         1, 
/* 3401 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3402 */         false);
/* 3403 */     oper.addParameter(param);
/* 3404 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3405 */           "ArrayOf_tns1_RemoteScheme"));
/* 3406 */     oper.setReturnClass(RemoteScheme[].class);
/* 3407 */     oper.setReturnQName(new QName("", "getSecuritySchemesReturn"));
/* 3408 */     oper.setStyle(Style.RPC);
/* 3409 */     oper.setUse(Use.ENCODED);
/* 3410 */     oper.addFault(new FaultDesc(
/* 3411 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3412 */           "com.atlassian.connector.commons.jira.soap.axis.RemotePermissionException", 
/* 3413 */           new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
/* 3414 */           true));
/*      */     
/* 3416 */     oper.addFault(new FaultDesc(
/* 3417 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3418 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteAuthenticationException", 
/* 3419 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
/* 3420 */           true));
/*      */     
/* 3422 */     oper.addFault(new FaultDesc(
/* 3423 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3424 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3425 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3426 */           true));
/*      */     
/* 3428 */     _operations[96] = oper;
/*      */     
/* 3430 */     oper = new OperationDesc();
/* 3431 */     oper.setName("getIssuesFromFilter");
/* 3432 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3433 */         1, 
/* 3434 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3435 */         false);
/* 3436 */     oper.addParameter(param);
/* 3437 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 3438 */         1, 
/* 3439 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3440 */         false);
/* 3441 */     oper.addParameter(param);
/* 3442 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3443 */           "ArrayOf_tns1_RemoteIssue"));
/* 3444 */     oper.setReturnClass(RemoteIssue[].class);
/* 3445 */     oper.setReturnQName(new QName("", "getIssuesFromFilterReturn"));
/* 3446 */     oper.setStyle(Style.RPC);
/* 3447 */     oper.setUse(Use.ENCODED);
/* 3448 */     oper.addFault(new FaultDesc(
/* 3449 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3450 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3451 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3452 */           true));
/*      */     
/* 3454 */     _operations[97] = oper;
/*      */     
/* 3456 */     oper = new OperationDesc();
/* 3457 */     oper.setName("getIssuesFromFilterWithLimit");
/* 3458 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3459 */         1, 
/* 3460 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3461 */         false);
/* 3462 */     oper.addParameter(param);
/* 3463 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 3464 */         1, 
/* 3465 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3466 */         false);
/* 3467 */     oper.addParameter(param);
/* 3468 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 3469 */         1, 
/* 3470 */         new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
/* 3471 */     oper.addParameter(param);
/* 3472 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 3473 */         1, 
/* 3474 */         new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
/* 3475 */     oper.addParameter(param);
/* 3476 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3477 */           "ArrayOf_tns1_RemoteIssue"));
/* 3478 */     oper.setReturnClass(RemoteIssue[].class);
/* 3479 */     oper.setReturnQName(new QName("", "getIssuesFromFilterWithLimitReturn"));
/* 3480 */     oper.setStyle(Style.RPC);
/* 3481 */     oper.setUse(Use.ENCODED);
/* 3482 */     oper.addFault(new FaultDesc(
/* 3483 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3484 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3485 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3486 */           true));
/*      */     
/* 3488 */     _operations[98] = oper;
/*      */     
/* 3490 */     oper = new OperationDesc();
/* 3491 */     oper.setName("getIssuesFromTextSearchWithLimit");
/* 3492 */     param = new ParameterDesc(new QName("", "in0"), (byte)
/* 3493 */         1, 
/* 3494 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3495 */         false);
/* 3496 */     oper.addParameter(param);
/* 3497 */     param = new ParameterDesc(new QName("", "in1"), (byte)
/* 3498 */         1, 
/* 3499 */         new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, 
/* 3500 */         false);
/* 3501 */     oper.addParameter(param);
/* 3502 */     param = new ParameterDesc(new QName("", "in2"), (byte)
/* 3503 */         1, 
/* 3504 */         new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
/* 3505 */     oper.addParameter(param);
/* 3506 */     param = new ParameterDesc(new QName("", "in3"), (byte)
/* 3507 */         1, 
/* 3508 */         new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
/* 3509 */     oper.addParameter(param);
/* 3510 */     oper.setReturnType(new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3511 */           "ArrayOf_tns1_RemoteIssue"));
/* 3512 */     oper.setReturnClass(RemoteIssue[].class);
/* 3513 */     oper.setReturnQName(new QName("", "getIssuesFromTextSearchWithLimitReturn"));
/* 3514 */     oper.setStyle(Style.RPC);
/* 3515 */     oper.setUse(Use.ENCODED);
/* 3516 */     oper.addFault(new FaultDesc(
/* 3517 */           new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "fault"), 
/* 3518 */           "com.atlassian.connector.commons.jira.soap.axis.RemoteException", 
/* 3519 */           new QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
/* 3520 */           true));
/*      */     
/* 3522 */     _operations[99] = oper;
/*      */   }
/*      */ 
/*      */   
/*      */   public JirasoapserviceV2SoapBindingStub() throws AxisFault {
/* 3527 */     this((Service)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public JirasoapserviceV2SoapBindingStub(URL endpointURL, Service service) throws AxisFault {
/* 3532 */     this(service);
/* 3533 */     this.cachedEndpoint = endpointURL;
/*      */   }
/*      */   
/*      */   public JirasoapserviceV2SoapBindingStub(Service service) throws AxisFault {
/* 3537 */     if (service == null) {
/* 3538 */       this.service = (Service)new Service();
/*      */     } else {
/* 3540 */       this.service = service;
/*      */     } 
/* 3542 */     ((Service)this.service).setTypeMappingVersion("1.1");
/*      */ 
/*      */ 
/*      */     
/* 3546 */     Class<BeanSerializerFactory> beansf = BeanSerializerFactory.class;
/* 3547 */     Class<BeanDeserializerFactory> beandf = BeanDeserializerFactory.class;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3556 */     QName qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "AbstractNamedRemoteEntity");
/* 3557 */     this.cachedSerQNames.add(qName);
/* 3558 */     Class<AbstractNamedRemoteEntity> cls = AbstractNamedRemoteEntity.class;
/* 3559 */     this.cachedSerClasses.add(cls);
/* 3560 */     this.cachedSerFactories.add(beansf);
/* 3561 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3563 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "AbstractRemoteConstant");
/* 3564 */     this.cachedSerQNames.add(qName);
/* 3565 */     Class<AbstractRemoteConstant> clazz64 = AbstractRemoteConstant.class;
/* 3566 */     this.cachedSerClasses.add(clazz64);
/* 3567 */     this.cachedSerFactories.add(beansf);
/* 3568 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3570 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "AbstractRemoteEntity");
/* 3571 */     this.cachedSerQNames.add(qName);
/* 3572 */     Class<AbstractRemoteEntity> clazz63 = AbstractRemoteEntity.class;
/* 3573 */     this.cachedSerClasses.add(clazz63);
/* 3574 */     this.cachedSerFactories.add(beansf);
/* 3575 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3577 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteAttachment");
/* 3578 */     this.cachedSerQNames.add(qName);
/* 3579 */     Class<RemoteAttachment> clazz62 = RemoteAttachment.class;
/* 3580 */     this.cachedSerClasses.add(clazz62);
/* 3581 */     this.cachedSerFactories.add(beansf);
/* 3582 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3584 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComment");
/* 3585 */     this.cachedSerQNames.add(qName);
/* 3586 */     Class<RemoteComment> clazz61 = RemoteComment.class;
/* 3587 */     this.cachedSerClasses.add(clazz61);
/* 3588 */     this.cachedSerFactories.add(beansf);
/* 3589 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3591 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComponent");
/* 3592 */     this.cachedSerQNames.add(qName);
/* 3593 */     Class<RemoteComponent> clazz60 = RemoteComponent.class;
/* 3594 */     this.cachedSerClasses.add(clazz60);
/* 3595 */     this.cachedSerFactories.add(beansf);
/* 3596 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3598 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteConfiguration");
/* 3599 */     this.cachedSerQNames.add(qName);
/* 3600 */     Class<RemoteConfiguration> clazz59 = RemoteConfiguration.class;
/* 3601 */     this.cachedSerClasses.add(clazz59);
/* 3602 */     this.cachedSerFactories.add(beansf);
/* 3603 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3605 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteCustomFieldValue");
/* 3606 */     this.cachedSerQNames.add(qName);
/* 3607 */     Class<RemoteCustomFieldValue> clazz58 = RemoteCustomFieldValue.class;
/* 3608 */     this.cachedSerClasses.add(clazz58);
/* 3609 */     this.cachedSerFactories.add(beansf);
/* 3610 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3612 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteEntity");
/* 3613 */     this.cachedSerQNames.add(qName);
/* 3614 */     Class<RemoteEntity> clazz57 = RemoteEntity.class;
/* 3615 */     this.cachedSerClasses.add(clazz57);
/* 3616 */     this.cachedSerFactories.add(beansf);
/* 3617 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3619 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteField");
/* 3620 */     this.cachedSerQNames.add(qName);
/* 3621 */     Class<RemoteField> clazz56 = RemoteField.class;
/* 3622 */     this.cachedSerClasses.add(clazz56);
/* 3623 */     this.cachedSerFactories.add(beansf);
/* 3624 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3626 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteFieldValue");
/* 3627 */     this.cachedSerQNames.add(qName);
/* 3628 */     Class<RemoteFieldValue> clazz55 = RemoteFieldValue.class;
/* 3629 */     this.cachedSerClasses.add(clazz55);
/* 3630 */     this.cachedSerFactories.add(beansf);
/* 3631 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3633 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteFilter");
/* 3634 */     this.cachedSerQNames.add(qName);
/* 3635 */     Class<RemoteFilter> clazz54 = RemoteFilter.class;
/* 3636 */     this.cachedSerClasses.add(clazz54);
/* 3637 */     this.cachedSerFactories.add(beansf);
/* 3638 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3640 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup");
/* 3641 */     this.cachedSerQNames.add(qName);
/* 3642 */     Class<RemoteGroup> clazz53 = RemoteGroup.class;
/* 3643 */     this.cachedSerClasses.add(clazz53);
/* 3644 */     this.cachedSerFactories.add(beansf);
/* 3645 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3647 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue");
/* 3648 */     this.cachedSerQNames.add(qName);
/* 3649 */     Class<RemoteIssue> clazz52 = RemoteIssue.class;
/* 3650 */     this.cachedSerClasses.add(clazz52);
/* 3651 */     this.cachedSerFactories.add(beansf);
/* 3652 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3654 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssueType");
/* 3655 */     this.cachedSerQNames.add(qName);
/* 3656 */     Class<RemoteIssueType> clazz51 = RemoteIssueType.class;
/* 3657 */     this.cachedSerClasses.add(clazz51);
/* 3658 */     this.cachedSerFactories.add(beansf);
/* 3659 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3661 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteNamedObject");
/* 3662 */     this.cachedSerQNames.add(qName);
/* 3663 */     Class<RemoteNamedObject> clazz50 = RemoteNamedObject.class;
/* 3664 */     this.cachedSerClasses.add(clazz50);
/* 3665 */     this.cachedSerFactories.add(beansf);
/* 3666 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3668 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermission");
/* 3669 */     this.cachedSerQNames.add(qName);
/* 3670 */     Class<RemotePermission> clazz49 = RemotePermission.class;
/* 3671 */     this.cachedSerClasses.add(clazz49);
/* 3672 */     this.cachedSerFactories.add(beansf);
/* 3673 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3675 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionMapping");
/* 3676 */     this.cachedSerQNames.add(qName);
/* 3677 */     Class<RemotePermissionMapping> clazz48 = RemotePermissionMapping.class;
/* 3678 */     this.cachedSerClasses.add(clazz48);
/* 3679 */     this.cachedSerFactories.add(beansf);
/* 3680 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3682 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme");
/* 3683 */     this.cachedSerQNames.add(qName);
/* 3684 */     Class<RemotePermissionScheme> clazz47 = RemotePermissionScheme.class;
/* 3685 */     this.cachedSerClasses.add(clazz47);
/* 3686 */     this.cachedSerFactories.add(beansf);
/* 3687 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3689 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePriority");
/* 3690 */     this.cachedSerQNames.add(qName);
/* 3691 */     Class<RemotePriority> clazz46 = RemotePriority.class;
/* 3692 */     this.cachedSerClasses.add(clazz46);
/* 3693 */     this.cachedSerFactories.add(beansf);
/* 3694 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3696 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject");
/* 3697 */     this.cachedSerQNames.add(qName);
/* 3698 */     Class<RemoteProject> clazz45 = RemoteProject.class;
/* 3699 */     this.cachedSerClasses.add(clazz45);
/* 3700 */     this.cachedSerFactories.add(beansf);
/* 3701 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3703 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole");
/* 3704 */     this.cachedSerQNames.add(qName);
/* 3705 */     Class<RemoteProjectRole> clazz44 = RemoteProjectRole.class;
/* 3706 */     this.cachedSerClasses.add(clazz44);
/* 3707 */     this.cachedSerFactories.add(beansf);
/* 3708 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3710 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRoleActors");
/* 3711 */     this.cachedSerQNames.add(qName);
/* 3712 */     Class<RemoteProjectRoleActors> clazz43 = RemoteProjectRoleActors.class;
/* 3713 */     this.cachedSerClasses.add(clazz43);
/* 3714 */     this.cachedSerFactories.add(beansf);
/* 3715 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3717 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteResolution");
/* 3718 */     this.cachedSerQNames.add(qName);
/* 3719 */     Class<RemoteResolution> clazz42 = RemoteResolution.class;
/* 3720 */     this.cachedSerClasses.add(clazz42);
/* 3721 */     this.cachedSerFactories.add(beansf);
/* 3722 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3724 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteRoleActor");
/* 3725 */     this.cachedSerQNames.add(qName);
/* 3726 */     Class<RemoteRoleActor> clazz41 = RemoteRoleActor.class;
/* 3727 */     this.cachedSerClasses.add(clazz41);
/* 3728 */     this.cachedSerFactories.add(beansf);
/* 3729 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3731 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteRoleActors");
/* 3732 */     this.cachedSerQNames.add(qName);
/* 3733 */     Class<RemoteRoleActors> clazz40 = RemoteRoleActors.class;
/* 3734 */     this.cachedSerClasses.add(clazz40);
/* 3735 */     this.cachedSerFactories.add(beansf);
/* 3736 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3738 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteScheme");
/* 3739 */     this.cachedSerQNames.add(qName);
/* 3740 */     Class<RemoteScheme> clazz39 = RemoteScheme.class;
/* 3741 */     this.cachedSerClasses.add(clazz39);
/* 3742 */     this.cachedSerFactories.add(beansf);
/* 3743 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3745 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteSecurityLevel");
/* 3746 */     this.cachedSerQNames.add(qName);
/* 3747 */     Class<RemoteSecurityLevel> clazz38 = RemoteSecurityLevel.class;
/* 3748 */     this.cachedSerClasses.add(clazz38);
/* 3749 */     this.cachedSerFactories.add(beansf);
/* 3750 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3752 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteServerInfo");
/* 3753 */     this.cachedSerQNames.add(qName);
/* 3754 */     Class<RemoteServerInfo> clazz37 = RemoteServerInfo.class;
/* 3755 */     this.cachedSerClasses.add(clazz37);
/* 3756 */     this.cachedSerFactories.add(beansf);
/* 3757 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3759 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteStatus");
/* 3760 */     this.cachedSerQNames.add(qName);
/* 3761 */     Class<RemoteStatus> clazz36 = RemoteStatus.class;
/* 3762 */     this.cachedSerClasses.add(clazz36);
/* 3763 */     this.cachedSerFactories.add(beansf);
/* 3764 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3766 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteTimeInfo");
/* 3767 */     this.cachedSerQNames.add(qName);
/* 3768 */     Class<RemoteTimeInfo> clazz35 = RemoteTimeInfo.class;
/* 3769 */     this.cachedSerClasses.add(clazz35);
/* 3770 */     this.cachedSerFactories.add(beansf);
/* 3771 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3773 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser");
/* 3774 */     this.cachedSerQNames.add(qName);
/* 3775 */     Class<RemoteUser> clazz34 = RemoteUser.class;
/* 3776 */     this.cachedSerClasses.add(clazz34);
/* 3777 */     this.cachedSerFactories.add(beansf);
/* 3778 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3780 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteVersion");
/* 3781 */     this.cachedSerQNames.add(qName);
/* 3782 */     Class<RemoteVersion> clazz33 = RemoteVersion.class;
/* 3783 */     this.cachedSerClasses.add(clazz33);
/* 3784 */     this.cachedSerFactories.add(beansf);
/* 3785 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3787 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog");
/* 3788 */     this.cachedSerQNames.add(qName);
/* 3789 */     Class<RemoteWorklog> clazz32 = RemoteWorklog.class;
/* 3790 */     this.cachedSerClasses.add(clazz32);
/* 3791 */     this.cachedSerFactories.add(beansf);
/* 3792 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3794 */     qName = new QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException");
/* 3795 */     this.cachedSerQNames.add(qName);
/* 3796 */     Class<RemoteAuthenticationException> clazz31 = RemoteAuthenticationException.class;
/* 3797 */     this.cachedSerClasses.add(clazz31);
/* 3798 */     this.cachedSerFactories.add(beansf);
/* 3799 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3801 */     qName = new QName("http://exception.rpc.jira.atlassian.com", "RemoteException");
/* 3802 */     this.cachedSerQNames.add(qName);
/* 3803 */     Class<RemoteException> clazz30 = RemoteException.class;
/* 3804 */     this.cachedSerClasses.add(clazz30);
/* 3805 */     this.cachedSerFactories.add(beansf);
/* 3806 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3808 */     qName = new QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException");
/* 3809 */     this.cachedSerQNames.add(qName);
/* 3810 */     Class<RemotePermissionException> clazz29 = RemotePermissionException.class;
/* 3811 */     this.cachedSerClasses.add(clazz29);
/* 3812 */     this.cachedSerFactories.add(beansf);
/* 3813 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3815 */     qName = new QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException");
/* 3816 */     this.cachedSerQNames.add(qName);
/* 3817 */     Class<RemoteValidationException> clazz28 = RemoteValidationException.class;
/* 3818 */     this.cachedSerClasses.add(clazz28);
/* 3819 */     this.cachedSerFactories.add(beansf);
/* 3820 */     this.cachedDeserFactories.add(beandf);
/*      */     
/* 3822 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3823 */         "ArrayOf_tns1_RemoteAttachment");
/* 3824 */     this.cachedSerQNames.add(qName);
/* 3825 */     Class<RemoteAttachment[]> clazz27 = RemoteAttachment[].class;
/* 3826 */     this.cachedSerClasses.add(clazz27);
/* 3827 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteAttachment");
/* 3828 */     QName qName2 = null;
/* 3829 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3830 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3832 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3833 */         "ArrayOf_tns1_RemoteComment");
/* 3834 */     this.cachedSerQNames.add(qName);
/* 3835 */     Class<RemoteComment[]> clazz26 = RemoteComment[].class;
/* 3836 */     this.cachedSerClasses.add(clazz26);
/* 3837 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComment");
/* 3838 */     qName2 = null;
/* 3839 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3840 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3842 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3843 */         "ArrayOf_tns1_RemoteComponent");
/* 3844 */     this.cachedSerQNames.add(qName);
/* 3845 */     Class<RemoteComponent[]> clazz25 = RemoteComponent[].class;
/* 3846 */     this.cachedSerClasses.add(clazz25);
/* 3847 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComponent");
/* 3848 */     qName2 = null;
/* 3849 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3850 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3852 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3853 */         "ArrayOf_tns1_RemoteCustomFieldValue");
/* 3854 */     this.cachedSerQNames.add(qName);
/* 3855 */     Class<RemoteCustomFieldValue[]> clazz24 = RemoteCustomFieldValue[].class;
/* 3856 */     this.cachedSerClasses.add(clazz24);
/* 3857 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteCustomFieldValue");
/* 3858 */     qName2 = null;
/* 3859 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3860 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3862 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3863 */         "ArrayOf_tns1_RemoteEntity");
/* 3864 */     this.cachedSerQNames.add(qName);
/* 3865 */     Class<RemoteEntity[]> clazz23 = RemoteEntity[].class;
/* 3866 */     this.cachedSerClasses.add(clazz23);
/* 3867 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteEntity");
/* 3868 */     qName2 = null;
/* 3869 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3870 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3872 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3873 */         "ArrayOf_tns1_RemoteField");
/* 3874 */     this.cachedSerQNames.add(qName);
/* 3875 */     Class<RemoteField[]> clazz22 = RemoteField[].class;
/* 3876 */     this.cachedSerClasses.add(clazz22);
/* 3877 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteField");
/* 3878 */     qName2 = null;
/* 3879 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3880 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3882 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3883 */         "ArrayOf_tns1_RemoteFieldValue");
/* 3884 */     this.cachedSerQNames.add(qName);
/* 3885 */     Class<RemoteFieldValue[]> clazz21 = RemoteFieldValue[].class;
/* 3886 */     this.cachedSerClasses.add(clazz21);
/* 3887 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteFieldValue");
/* 3888 */     qName2 = null;
/* 3889 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3890 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3892 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3893 */         "ArrayOf_tns1_RemoteFilter");
/* 3894 */     this.cachedSerQNames.add(qName);
/* 3895 */     Class<RemoteFilter[]> clazz20 = RemoteFilter[].class;
/* 3896 */     this.cachedSerClasses.add(clazz20);
/* 3897 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteFilter");
/* 3898 */     qName2 = null;
/* 3899 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3900 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3902 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3903 */         "ArrayOf_tns1_RemoteIssue");
/* 3904 */     this.cachedSerQNames.add(qName);
/* 3905 */     Class<RemoteIssue[]> clazz19 = RemoteIssue[].class;
/* 3906 */     this.cachedSerClasses.add(clazz19);
/* 3907 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue");
/* 3908 */     qName2 = null;
/* 3909 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3910 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3912 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3913 */         "ArrayOf_tns1_RemoteIssueType");
/* 3914 */     this.cachedSerQNames.add(qName);
/* 3915 */     Class<RemoteIssueType[]> clazz18 = RemoteIssueType[].class;
/* 3916 */     this.cachedSerClasses.add(clazz18);
/* 3917 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssueType");
/* 3918 */     qName2 = null;
/* 3919 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3920 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3922 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3923 */         "ArrayOf_tns1_RemoteNamedObject");
/* 3924 */     this.cachedSerQNames.add(qName);
/* 3925 */     Class<RemoteNamedObject[]> clazz17 = RemoteNamedObject[].class;
/* 3926 */     this.cachedSerClasses.add(clazz17);
/* 3927 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteNamedObject");
/* 3928 */     qName2 = null;
/* 3929 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3930 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3932 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3933 */         "ArrayOf_tns1_RemotePermission");
/* 3934 */     this.cachedSerQNames.add(qName);
/* 3935 */     Class<RemotePermission[]> clazz16 = RemotePermission[].class;
/* 3936 */     this.cachedSerClasses.add(clazz16);
/* 3937 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermission");
/* 3938 */     qName2 = null;
/* 3939 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3940 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3942 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3943 */         "ArrayOf_tns1_RemotePermissionMapping");
/* 3944 */     this.cachedSerQNames.add(qName);
/* 3945 */     Class<RemotePermissionMapping[]> clazz15 = RemotePermissionMapping[].class;
/* 3946 */     this.cachedSerClasses.add(clazz15);
/* 3947 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionMapping");
/* 3948 */     qName2 = null;
/* 3949 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3950 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3952 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3953 */         "ArrayOf_tns1_RemotePermissionScheme");
/* 3954 */     this.cachedSerQNames.add(qName);
/* 3955 */     Class<RemotePermissionScheme[]> clazz14 = RemotePermissionScheme[].class;
/* 3956 */     this.cachedSerClasses.add(clazz14);
/* 3957 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme");
/* 3958 */     qName2 = null;
/* 3959 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3960 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3962 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3963 */         "ArrayOf_tns1_RemotePriority");
/* 3964 */     this.cachedSerQNames.add(qName);
/* 3965 */     Class<RemotePriority[]> clazz13 = RemotePriority[].class;
/* 3966 */     this.cachedSerClasses.add(clazz13);
/* 3967 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePriority");
/* 3968 */     qName2 = null;
/* 3969 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3970 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3972 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3973 */         "ArrayOf_tns1_RemoteProject");
/* 3974 */     this.cachedSerQNames.add(qName);
/* 3975 */     Class<RemoteProject[]> clazz12 = RemoteProject[].class;
/* 3976 */     this.cachedSerClasses.add(clazz12);
/* 3977 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject");
/* 3978 */     qName2 = null;
/* 3979 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3980 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3982 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3983 */         "ArrayOf_tns1_RemoteProjectRole");
/* 3984 */     this.cachedSerQNames.add(qName);
/* 3985 */     Class<RemoteProjectRole[]> clazz11 = RemoteProjectRole[].class;
/* 3986 */     this.cachedSerClasses.add(clazz11);
/* 3987 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProjectRole");
/* 3988 */     qName2 = null;
/* 3989 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 3990 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 3992 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 3993 */         "ArrayOf_tns1_RemoteResolution");
/* 3994 */     this.cachedSerQNames.add(qName);
/* 3995 */     Class<RemoteResolution[]> clazz10 = RemoteResolution[].class;
/* 3996 */     this.cachedSerClasses.add(clazz10);
/* 3997 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteResolution");
/* 3998 */     qName2 = null;
/* 3999 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 4000 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 4002 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 4003 */         "ArrayOf_tns1_RemoteRoleActor");
/* 4004 */     this.cachedSerQNames.add(qName);
/* 4005 */     Class<RemoteRoleActor[]> clazz9 = RemoteRoleActor[].class;
/* 4006 */     this.cachedSerClasses.add(clazz9);
/* 4007 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteRoleActor");
/* 4008 */     qName2 = null;
/* 4009 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 4010 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 4012 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 4013 */         "ArrayOf_tns1_RemoteScheme");
/* 4014 */     this.cachedSerQNames.add(qName);
/* 4015 */     Class<RemoteScheme[]> clazz8 = RemoteScheme[].class;
/* 4016 */     this.cachedSerClasses.add(clazz8);
/* 4017 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteScheme");
/* 4018 */     qName2 = null;
/* 4019 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 4020 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 4022 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 4023 */         "ArrayOf_tns1_RemoteSecurityLevel");
/* 4024 */     this.cachedSerQNames.add(qName);
/* 4025 */     Class<RemoteSecurityLevel[]> clazz7 = RemoteSecurityLevel[].class;
/* 4026 */     this.cachedSerClasses.add(clazz7);
/* 4027 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteSecurityLevel");
/* 4028 */     qName2 = null;
/* 4029 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 4030 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 4032 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 4033 */         "ArrayOf_tns1_RemoteStatus");
/* 4034 */     this.cachedSerQNames.add(qName);
/* 4035 */     Class<RemoteStatus[]> clazz6 = RemoteStatus[].class;
/* 4036 */     this.cachedSerClasses.add(clazz6);
/* 4037 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteStatus");
/* 4038 */     qName2 = null;
/* 4039 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 4040 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 4042 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 4043 */         "ArrayOf_tns1_RemoteUser");
/* 4044 */     this.cachedSerQNames.add(qName);
/* 4045 */     Class<RemoteUser[]> clazz5 = RemoteUser[].class;
/* 4046 */     this.cachedSerClasses.add(clazz5);
/* 4047 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser");
/* 4048 */     qName2 = null;
/* 4049 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 4050 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 4052 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 4053 */         "ArrayOf_tns1_RemoteVersion");
/* 4054 */     this.cachedSerQNames.add(qName);
/* 4055 */     Class<RemoteVersion[]> clazz4 = RemoteVersion[].class;
/* 4056 */     this.cachedSerClasses.add(clazz4);
/* 4057 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteVersion");
/* 4058 */     qName2 = null;
/* 4059 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 4060 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 4062 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 4063 */         "ArrayOf_tns1_RemoteWorklog");
/* 4064 */     this.cachedSerQNames.add(qName);
/* 4065 */     Class<RemoteWorklog[]> clazz3 = RemoteWorklog[].class;
/* 4066 */     this.cachedSerClasses.add(clazz3);
/* 4067 */     qName = new QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteWorklog");
/* 4068 */     qName2 = null;
/* 4069 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 4070 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 4072 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", 
/* 4073 */         "ArrayOf_xsd_base64Binary");
/* 4074 */     this.cachedSerQNames.add(qName);
/* 4075 */     Class<byte[][]> clazz2 = byte[][].class;
/* 4076 */     this.cachedSerClasses.add(clazz2);
/* 4077 */     qName = new QName("http://www.w3.org/2001/XMLSchema", "byte");
/* 4078 */     qName2 = null;
/* 4079 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 4080 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 4082 */     qName = new QName("http://jira.atlassian.com/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_string");
/* 4083 */     this.cachedSerQNames.add(qName);
/* 4084 */     Class<String[]> clazz1 = String[].class;
/* 4085 */     this.cachedSerClasses.add(clazz1);
/* 4086 */     qName = new QName("http://www.w3.org/2001/XMLSchema", "string");
/* 4087 */     qName2 = null;
/* 4088 */     this.cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
/* 4089 */     this.cachedDeserFactories.add(new ArrayDeserializerFactory());
/*      */     
/* 4091 */     qName = new QName("http://service.soap.rpc.jira.atlassian.com", 
/* 4092 */         "IssueServiceImpl$RemoteWorklogImpl");
/* 4093 */     this.cachedSerQNames.add(qName);
/* 4094 */     Class<IssueServiceImpl$RemoteWorklogImpl> clazz = IssueServiceImpl$RemoteWorklogImpl.class;
/* 4095 */     this.cachedSerClasses.add(clazz);
/* 4096 */     this.cachedSerFactories.add(beansf);
/* 4097 */     this.cachedDeserFactories.add(beandf);
/*      */   }
/*      */ 
/*      */   
/*      */   protected Call createCall() throws RemoteException {
/*      */     try {
/* 4103 */       Call _call = _createCall();
/* 4104 */       if (this.maintainSessionSet) {
/* 4105 */         _call.setMaintainSession(this.maintainSession);
/*      */       }
/* 4107 */       if (this.cachedUsername != null) {
/* 4108 */         _call.setUsername(this.cachedUsername);
/*      */       }
/* 4110 */       if (this.cachedPassword != null) {
/* 4111 */         _call.setPassword(this.cachedPassword);
/*      */       }
/* 4113 */       if (this.cachedEndpoint != null) {
/* 4114 */         _call.setTargetEndpointAddress(this.cachedEndpoint);
/*      */       }
/* 4116 */       if (this.cachedTimeout != null) {
/* 4117 */         _call.setTimeout(this.cachedTimeout);
/*      */       }
/* 4119 */       if (this.cachedPortName != null) {
/* 4120 */         _call.setPortName(this.cachedPortName);
/*      */       }
/* 4122 */       Enumeration<Object> keys = this.cachedProperties.keys();
/* 4123 */       while (keys.hasMoreElements()) {
/* 4124 */         String key = (String)keys.nextElement();
/* 4125 */         _call.setProperty(key, this.cachedProperties.get(key));
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4132 */       synchronized (this) {
/* 4133 */         if (firstCall()) {
/*      */           
/* 4135 */           _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4136 */           _call.setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");
/* 4137 */           for (int i = 0; i < this.cachedSerFactories.size(); i++) {
/* 4138 */             Class cls = this.cachedSerClasses.get(i);
/* 4139 */             QName qName = 
/* 4140 */               this.cachedSerQNames.get(i);
/* 4141 */             Object x = this.cachedSerFactories.get(i);
/* 4142 */             if (x instanceof Class) {
/* 4143 */               Class sf = 
/* 4144 */                 this.cachedSerFactories.get(i);
/* 4145 */               Class df = 
/* 4146 */                 this.cachedDeserFactories.get(i);
/* 4147 */               _call.registerTypeMapping(cls, qName, sf, df, false);
/* 4148 */             } else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
/* 4149 */               SerializerFactory sf = 
/* 4150 */                 this.cachedSerFactories.get(i);
/* 4151 */               DeserializerFactory df = 
/* 4152 */                 this.cachedDeserFactories.get(i);
/* 4153 */               _call.registerTypeMapping(cls, qName, sf, df, false);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/* 4158 */       return _call;
/*      */     }
/* 4160 */     catch (Throwable _t) {
/* 4161 */       throw new AxisFault("Failure trying to get the Call object", _t);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public RemoteComment getComment(String in0, long in1) throws RemoteException, RemoteException {
/* 4167 */     if (this.cachedEndpoint == null) {
/* 4168 */       throw new NoEndPointException();
/*      */     }
/* 4170 */     Call _call = createCall();
/* 4171 */     _call.setOperation(_operations[0]);
/* 4172 */     _call.setUseSOAPAction(true);
/* 4173 */     _call.setSOAPActionURI("");
/* 4174 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4175 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getComment"));
/*      */     
/* 4177 */     setRequestHeaders(_call);
/* 4178 */     setAttachments(_call);
/*      */     try {
/* 4180 */       Object _resp = _call.invoke(new Object[] { in0, new Long(in1) });
/*      */       
/* 4182 */       if (_resp instanceof RemoteException) {
/* 4183 */         throw (RemoteException)_resp;
/*      */       }
/* 4185 */       extractAttachments(_call);
/*      */       try {
/* 4187 */         return (RemoteComment)_resp;
/* 4188 */       } catch (Exception exception) {
/* 4189 */         return 
/* 4190 */           (RemoteComment)JavaUtils.convert(_resp, RemoteComment.class);
/*      */       }
/*      */     
/* 4193 */     } catch (AxisFault axisFaultException) {
/* 4194 */       if (axisFaultException.detail != null) {
/* 4195 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4196 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4198 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4199 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4202 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteGroup createGroup(String in0, String in1, RemoteUser in2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 4212 */     if (this.cachedEndpoint == null) {
/* 4213 */       throw new NoEndPointException();
/*      */     }
/* 4215 */     Call _call = createCall();
/* 4216 */     _call.setOperation(_operations[1]);
/* 4217 */     _call.setUseSOAPAction(true);
/* 4218 */     _call.setSOAPActionURI("");
/* 4219 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4220 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "createGroup"));
/*      */     
/* 4222 */     setRequestHeaders(_call);
/* 4223 */     setAttachments(_call);
/*      */     try {
/* 4225 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 4227 */       if (_resp instanceof RemoteException) {
/* 4228 */         throw (RemoteException)_resp;
/*      */       }
/* 4230 */       extractAttachments(_call);
/*      */       try {
/* 4232 */         return (RemoteGroup)_resp;
/* 4233 */       } catch (Exception exception) {
/* 4234 */         return 
/* 4235 */           (RemoteGroup)JavaUtils.convert(_resp, RemoteGroup.class);
/*      */       }
/*      */     
/* 4238 */     } catch (AxisFault axisFaultException) {
/* 4239 */       if (axisFaultException.detail != null) {
/* 4240 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4241 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4243 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4244 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4246 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 4247 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 4249 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4250 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 4252 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4253 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4256 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteSecurityLevel getSecurityLevel(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteException {
/* 4264 */     if (this.cachedEndpoint == null) {
/* 4265 */       throw new NoEndPointException();
/*      */     }
/* 4267 */     Call _call = createCall();
/* 4268 */     _call.setOperation(_operations[2]);
/* 4269 */     _call.setUseSOAPAction(true);
/* 4270 */     _call.setSOAPActionURI("");
/* 4271 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4272 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getSecurityLevel"));
/*      */     
/* 4274 */     setRequestHeaders(_call);
/* 4275 */     setAttachments(_call);
/*      */     try {
/* 4277 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 4279 */       if (_resp instanceof RemoteException) {
/* 4280 */         throw (RemoteException)_resp;
/*      */       }
/* 4282 */       extractAttachments(_call);
/*      */       try {
/* 4284 */         return (RemoteSecurityLevel)_resp;
/* 4285 */       } catch (Exception exception) {
/* 4286 */         return 
/* 4287 */           (RemoteSecurityLevel)JavaUtils.convert(_resp, RemoteSecurityLevel.class);
/*      */       }
/*      */     
/* 4290 */     } catch (AxisFault axisFaultException) {
/* 4291 */       if (axisFaultException.detail != null) {
/* 4292 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4293 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4295 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4296 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4298 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4299 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4302 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public RemoteServerInfo getServerInfo(String in0) throws RemoteException {
/* 4308 */     if (this.cachedEndpoint == null) {
/* 4309 */       throw new NoEndPointException();
/*      */     }
/* 4311 */     Call _call = createCall();
/* 4312 */     _call.setOperation(_operations[3]);
/* 4313 */     _call.setUseSOAPAction(true);
/* 4314 */     _call.setSOAPActionURI("");
/* 4315 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4316 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getServerInfo"));
/*      */     
/* 4318 */     setRequestHeaders(_call);
/* 4319 */     setAttachments(_call);
/*      */     try {
/* 4321 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 4323 */       if (_resp instanceof RemoteException) {
/* 4324 */         throw (RemoteException)_resp;
/*      */       }
/* 4326 */       extractAttachments(_call);
/*      */       try {
/* 4328 */         return (RemoteServerInfo)_resp;
/* 4329 */       } catch (Exception exception) {
/* 4330 */         return 
/* 4331 */           (RemoteServerInfo)JavaUtils.convert(_resp, RemoteServerInfo.class);
/*      */       }
/*      */     
/* 4334 */     } catch (AxisFault axisFaultException) {
/* 4335 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteGroup getGroup(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 4344 */     if (this.cachedEndpoint == null) {
/* 4345 */       throw new NoEndPointException();
/*      */     }
/* 4347 */     Call _call = createCall();
/* 4348 */     _call.setOperation(_operations[4]);
/* 4349 */     _call.setUseSOAPAction(true);
/* 4350 */     _call.setSOAPActionURI("");
/* 4351 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4352 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getGroup"));
/*      */     
/* 4354 */     setRequestHeaders(_call);
/* 4355 */     setAttachments(_call);
/*      */     try {
/* 4357 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 4359 */       if (_resp instanceof RemoteException) {
/* 4360 */         throw (RemoteException)_resp;
/*      */       }
/* 4362 */       extractAttachments(_call);
/*      */       try {
/* 4364 */         return (RemoteGroup)_resp;
/* 4365 */       } catch (Exception exception) {
/* 4366 */         return 
/* 4367 */           (RemoteGroup)JavaUtils.convert(_resp, RemoteGroup.class);
/*      */       }
/*      */     
/* 4370 */     } catch (AxisFault axisFaultException) {
/* 4371 */       if (axisFaultException.detail != null) {
/* 4372 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4373 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4375 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4376 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4378 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 4379 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 4381 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4382 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 4384 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4385 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4388 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteUser createUser(String in0, String in1, String in2, String in3, String in4) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 4398 */     if (this.cachedEndpoint == null) {
/* 4399 */       throw new NoEndPointException();
/*      */     }
/* 4401 */     Call _call = createCall();
/* 4402 */     _call.setOperation(_operations[5]);
/* 4403 */     _call.setUseSOAPAction(true);
/* 4404 */     _call.setSOAPActionURI("");
/* 4405 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4406 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "createUser"));
/*      */     
/* 4408 */     setRequestHeaders(_call);
/* 4409 */     setAttachments(_call);
/*      */     try {
/* 4411 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3, in4 });
/*      */       
/* 4413 */       if (_resp instanceof RemoteException) {
/* 4414 */         throw (RemoteException)_resp;
/*      */       }
/* 4416 */       extractAttachments(_call);
/*      */       try {
/* 4418 */         return (RemoteUser)_resp;
/* 4419 */       } catch (Exception exception) {
/* 4420 */         return 
/* 4421 */           (RemoteUser)JavaUtils.convert(_resp, RemoteUser.class);
/*      */       }
/*      */     
/* 4424 */     } catch (AxisFault axisFaultException) {
/* 4425 */       if (axisFaultException.detail != null) {
/* 4426 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4427 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4429 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4430 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4432 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 4433 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 4435 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4436 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 4438 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4439 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4442 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteUser getUser(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException {
/* 4449 */     if (this.cachedEndpoint == null) {
/* 4450 */       throw new NoEndPointException();
/*      */     }
/* 4452 */     Call _call = createCall();
/* 4453 */     _call.setOperation(_operations[6]);
/* 4454 */     _call.setUseSOAPAction(true);
/* 4455 */     _call.setSOAPActionURI("");
/* 4456 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4457 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getUser"));
/*      */     
/* 4459 */     setRequestHeaders(_call);
/* 4460 */     setAttachments(_call);
/*      */     try {
/* 4462 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 4464 */       if (_resp instanceof RemoteException) {
/* 4465 */         throw (RemoteException)_resp;
/*      */       }
/* 4467 */       extractAttachments(_call);
/*      */       try {
/* 4469 */         return (RemoteUser)_resp;
/* 4470 */       } catch (Exception exception) {
/* 4471 */         return 
/* 4472 */           (RemoteUser)JavaUtils.convert(_resp, RemoteUser.class);
/*      */       }
/*      */     
/* 4475 */     } catch (AxisFault axisFaultException) {
/* 4476 */       if (axisFaultException.detail != null) {
/* 4477 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4478 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4480 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4481 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4483 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4484 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4487 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String login(String in0, String in1) throws RemoteException, RemoteAuthenticationException, RemoteException {
/* 4494 */     if (this.cachedEndpoint == null) {
/* 4495 */       throw new NoEndPointException();
/*      */     }
/* 4497 */     Call _call = createCall();
/* 4498 */     _call.setOperation(_operations[7]);
/* 4499 */     _call.setUseSOAPAction(true);
/* 4500 */     _call.setSOAPActionURI("");
/* 4501 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4502 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "login"));
/*      */     
/* 4504 */     setRequestHeaders(_call);
/* 4505 */     setAttachments(_call);
/*      */     try {
/* 4507 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 4509 */       if (_resp instanceof RemoteException) {
/* 4510 */         throw (RemoteException)_resp;
/*      */       }
/* 4512 */       extractAttachments(_call);
/*      */       try {
/* 4514 */         return (String)_resp;
/* 4515 */       } catch (Exception exception) {
/* 4516 */         return (String)JavaUtils.convert(_resp, String.class);
/*      */       }
/*      */     
/* 4519 */     } catch (AxisFault axisFaultException) {
/* 4520 */       if (axisFaultException.detail != null) {
/* 4521 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4522 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4524 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4525 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 4527 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4528 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4531 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssue getIssue(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 4539 */     if (this.cachedEndpoint == null) {
/* 4540 */       throw new NoEndPointException();
/*      */     }
/* 4542 */     Call _call = createCall();
/* 4543 */     _call.setOperation(_operations[8]);
/* 4544 */     _call.setUseSOAPAction(true);
/* 4545 */     _call.setSOAPActionURI("");
/* 4546 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4547 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getIssue"));
/*      */     
/* 4549 */     setRequestHeaders(_call);
/* 4550 */     setAttachments(_call);
/*      */     try {
/* 4552 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 4554 */       if (_resp instanceof RemoteException) {
/* 4555 */         throw (RemoteException)_resp;
/*      */       }
/* 4557 */       extractAttachments(_call);
/*      */       try {
/* 4559 */         return (RemoteIssue)_resp;
/* 4560 */       } catch (Exception exception) {
/* 4561 */         return 
/* 4562 */           (RemoteIssue)JavaUtils.convert(_resp, RemoteIssue.class);
/*      */       }
/*      */     
/* 4565 */     } catch (AxisFault axisFaultException) {
/* 4566 */       if (axisFaultException.detail != null) {
/* 4567 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4568 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4570 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4571 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4573 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4574 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 4576 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4577 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4580 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssue createIssue(String in0, RemoteIssue in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 4590 */     if (this.cachedEndpoint == null) {
/* 4591 */       throw new NoEndPointException();
/*      */     }
/* 4593 */     Call _call = createCall();
/* 4594 */     _call.setOperation(_operations[9]);
/* 4595 */     _call.setUseSOAPAction(true);
/* 4596 */     _call.setSOAPActionURI("");
/* 4597 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4598 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "createIssue"));
/*      */     
/* 4600 */     setRequestHeaders(_call);
/* 4601 */     setAttachments(_call);
/*      */     try {
/* 4603 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 4605 */       if (_resp instanceof RemoteException) {
/* 4606 */         throw (RemoteException)_resp;
/*      */       }
/* 4608 */       extractAttachments(_call);
/*      */       try {
/* 4610 */         return (RemoteIssue)_resp;
/* 4611 */       } catch (Exception exception) {
/* 4612 */         return 
/* 4613 */           (RemoteIssue)JavaUtils.convert(_resp, RemoteIssue.class);
/*      */       }
/*      */     
/* 4616 */     } catch (AxisFault axisFaultException) {
/* 4617 */       if (axisFaultException.detail != null) {
/* 4618 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4619 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4621 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4622 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4624 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 4625 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 4627 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4628 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 4630 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4631 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4634 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public RemoteNamedObject[] getAvailableActions(String in0, String in1) throws RemoteException, RemoteException {
/* 4640 */     if (this.cachedEndpoint == null) {
/* 4641 */       throw new NoEndPointException();
/*      */     }
/* 4643 */     Call _call = createCall();
/* 4644 */     _call.setOperation(_operations[10]);
/* 4645 */     _call.setUseSOAPAction(true);
/* 4646 */     _call.setSOAPActionURI("");
/* 4647 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4648 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getAvailableActions"));
/*      */     
/* 4650 */     setRequestHeaders(_call);
/* 4651 */     setAttachments(_call);
/*      */     try {
/* 4653 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 4655 */       if (_resp instanceof RemoteException) {
/* 4656 */         throw (RemoteException)_resp;
/*      */       }
/* 4658 */       extractAttachments(_call);
/*      */       try {
/* 4660 */         return (RemoteNamedObject[])_resp;
/* 4661 */       } catch (Exception exception) {
/* 4662 */         return 
/* 4663 */           (RemoteNamedObject[])JavaUtils.convert(_resp, RemoteNamedObject[].class);
/*      */       }
/*      */     
/* 4666 */     } catch (AxisFault axisFaultException) {
/* 4667 */       if (axisFaultException.detail != null) {
/* 4668 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4669 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4671 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4672 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4675 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssue updateIssue(String in0, String in1, RemoteFieldValue[] in2) throws RemoteException, RemoteException {
/* 4682 */     if (this.cachedEndpoint == null) {
/* 4683 */       throw new NoEndPointException();
/*      */     }
/* 4685 */     Call _call = createCall();
/* 4686 */     _call.setOperation(_operations[11]);
/* 4687 */     _call.setUseSOAPAction(true);
/* 4688 */     _call.setSOAPActionURI("");
/* 4689 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4690 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "updateIssue"));
/*      */     
/* 4692 */     setRequestHeaders(_call);
/* 4693 */     setAttachments(_call);
/*      */     try {
/* 4695 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 4697 */       if (_resp instanceof RemoteException) {
/* 4698 */         throw (RemoteException)_resp;
/*      */       }
/* 4700 */       extractAttachments(_call);
/*      */       try {
/* 4702 */         return (RemoteIssue)_resp;
/* 4703 */       } catch (Exception exception) {
/* 4704 */         return 
/* 4705 */           (RemoteIssue)JavaUtils.convert(_resp, RemoteIssue.class);
/*      */       }
/*      */     
/* 4708 */     } catch (AxisFault axisFaultException) {
/* 4709 */       if (axisFaultException.detail != null) {
/* 4710 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4711 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4713 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4714 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4717 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteConfiguration getConfiguration(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 4725 */     if (this.cachedEndpoint == null) {
/* 4726 */       throw new NoEndPointException();
/*      */     }
/* 4728 */     Call _call = createCall();
/* 4729 */     _call.setOperation(_operations[12]);
/* 4730 */     _call.setUseSOAPAction(true);
/* 4731 */     _call.setSOAPActionURI("");
/* 4732 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4733 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getConfiguration"));
/*      */     
/* 4735 */     setRequestHeaders(_call);
/* 4736 */     setAttachments(_call);
/*      */     try {
/* 4738 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 4740 */       if (_resp instanceof RemoteException) {
/* 4741 */         throw (RemoteException)_resp;
/*      */       }
/* 4743 */       extractAttachments(_call);
/*      */       try {
/* 4745 */         return (RemoteConfiguration)_resp;
/* 4746 */       } catch (Exception exception) {
/* 4747 */         return 
/* 4748 */           (RemoteConfiguration)JavaUtils.convert(_resp, RemoteConfiguration.class);
/*      */       }
/*      */     
/* 4751 */     } catch (AxisFault axisFaultException) {
/* 4752 */       if (axisFaultException.detail != null) {
/* 4753 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4754 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4756 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4757 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4759 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4760 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 4762 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4763 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4766 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteComponent[] getComponents(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 4775 */     if (this.cachedEndpoint == null) {
/* 4776 */       throw new NoEndPointException();
/*      */     }
/* 4778 */     Call _call = createCall();
/* 4779 */     _call.setOperation(_operations[13]);
/* 4780 */     _call.setUseSOAPAction(true);
/* 4781 */     _call.setSOAPActionURI("");
/* 4782 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4783 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getComponents"));
/*      */     
/* 4785 */     setRequestHeaders(_call);
/* 4786 */     setAttachments(_call);
/*      */     try {
/* 4788 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 4790 */       if (_resp instanceof RemoteException) {
/* 4791 */         throw (RemoteException)_resp;
/*      */       }
/* 4793 */       extractAttachments(_call);
/*      */       try {
/* 4795 */         return (RemoteComponent[])_resp;
/* 4796 */       } catch (Exception exception) {
/* 4797 */         return 
/* 4798 */           (RemoteComponent[])JavaUtils.convert(_resp, RemoteComponent[].class);
/*      */       }
/*      */     
/* 4801 */     } catch (AxisFault axisFaultException) {
/* 4802 */       if (axisFaultException.detail != null) {
/* 4803 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4804 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4806 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4807 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4809 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4810 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 4812 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4813 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4816 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteProject updateProject(String in0, RemoteProject in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 4826 */     if (this.cachedEndpoint == null) {
/* 4827 */       throw new NoEndPointException();
/*      */     }
/* 4829 */     Call _call = createCall();
/* 4830 */     _call.setOperation(_operations[14]);
/* 4831 */     _call.setUseSOAPAction(true);
/* 4832 */     _call.setSOAPActionURI("");
/* 4833 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4834 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "updateProject"));
/*      */     
/* 4836 */     setRequestHeaders(_call);
/* 4837 */     setAttachments(_call);
/*      */     try {
/* 4839 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 4841 */       if (_resp instanceof RemoteException) {
/* 4842 */         throw (RemoteException)_resp;
/*      */       }
/* 4844 */       extractAttachments(_call);
/*      */       try {
/* 4846 */         return (RemoteProject)_resp;
/* 4847 */       } catch (Exception exception) {
/* 4848 */         return 
/* 4849 */           (RemoteProject)JavaUtils.convert(_resp, RemoteProject.class);
/*      */       }
/*      */     
/* 4852 */     } catch (AxisFault axisFaultException) {
/* 4853 */       if (axisFaultException.detail != null) {
/* 4854 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4855 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4857 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4858 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4860 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 4861 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 4863 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4864 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 4866 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4867 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4870 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteProject getProjectByKey(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 4878 */     if (this.cachedEndpoint == null) {
/* 4879 */       throw new NoEndPointException();
/*      */     }
/* 4881 */     Call _call = createCall();
/* 4882 */     _call.setOperation(_operations[15]);
/* 4883 */     _call.setUseSOAPAction(true);
/* 4884 */     _call.setSOAPActionURI("");
/* 4885 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4886 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getProjectByKey"));
/*      */     
/* 4888 */     setRequestHeaders(_call);
/* 4889 */     setAttachments(_call);
/*      */     try {
/* 4891 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 4893 */       if (_resp instanceof RemoteException) {
/* 4894 */         throw (RemoteException)_resp;
/*      */       }
/* 4896 */       extractAttachments(_call);
/*      */       try {
/* 4898 */         return (RemoteProject)_resp;
/* 4899 */       } catch (Exception exception) {
/* 4900 */         return 
/* 4901 */           (RemoteProject)JavaUtils.convert(_resp, RemoteProject.class);
/*      */       }
/*      */     
/* 4904 */     } catch (AxisFault axisFaultException) {
/* 4905 */       if (axisFaultException.detail != null) {
/* 4906 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4907 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4909 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4910 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4912 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4913 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 4915 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4916 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4919 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemotePriority[] getPriorities(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException {
/* 4926 */     if (this.cachedEndpoint == null) {
/* 4927 */       throw new NoEndPointException();
/*      */     }
/* 4929 */     Call _call = createCall();
/* 4930 */     _call.setOperation(_operations[16]);
/* 4931 */     _call.setUseSOAPAction(true);
/* 4932 */     _call.setSOAPActionURI("");
/* 4933 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4934 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getPriorities"));
/*      */     
/* 4936 */     setRequestHeaders(_call);
/* 4937 */     setAttachments(_call);
/*      */     try {
/* 4939 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 4941 */       if (_resp instanceof RemoteException) {
/* 4942 */         throw (RemoteException)_resp;
/*      */       }
/* 4944 */       extractAttachments(_call);
/*      */       try {
/* 4946 */         return (RemotePriority[])_resp;
/* 4947 */       } catch (Exception exception) {
/* 4948 */         return 
/* 4949 */           (RemotePriority[])JavaUtils.convert(_resp, RemotePriority[].class);
/*      */       }
/*      */     
/* 4952 */     } catch (AxisFault axisFaultException) {
/* 4953 */       if (axisFaultException.detail != null) {
/* 4954 */         if (axisFaultException.detail instanceof RemoteException) {
/* 4955 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 4957 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 4958 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 4960 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 4961 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 4964 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteResolution[] getResolutions(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException {
/* 4971 */     if (this.cachedEndpoint == null) {
/* 4972 */       throw new NoEndPointException();
/*      */     }
/* 4974 */     Call _call = createCall();
/* 4975 */     _call.setOperation(_operations[17]);
/* 4976 */     _call.setUseSOAPAction(true);
/* 4977 */     _call.setSOAPActionURI("");
/* 4978 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 4979 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getResolutions"));
/*      */     
/* 4981 */     setRequestHeaders(_call);
/* 4982 */     setAttachments(_call);
/*      */     try {
/* 4984 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 4986 */       if (_resp instanceof RemoteException) {
/* 4987 */         throw (RemoteException)_resp;
/*      */       }
/* 4989 */       extractAttachments(_call);
/*      */       try {
/* 4991 */         return (RemoteResolution[])_resp;
/* 4992 */       } catch (Exception exception) {
/* 4993 */         return 
/* 4994 */           (RemoteResolution[])JavaUtils.convert(_resp, RemoteResolution[].class);
/*      */       }
/*      */     
/* 4997 */     } catch (AxisFault axisFaultException) {
/* 4998 */       if (axisFaultException.detail != null) {
/* 4999 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5000 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5002 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 5003 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 5005 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 5006 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5009 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssueType[] getIssueTypes(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException {
/* 5016 */     if (this.cachedEndpoint == null) {
/* 5017 */       throw new NoEndPointException();
/*      */     }
/* 5019 */     Call _call = createCall();
/* 5020 */     _call.setOperation(_operations[18]);
/* 5021 */     _call.setUseSOAPAction(true);
/* 5022 */     _call.setSOAPActionURI("");
/* 5023 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5024 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getIssueTypes"));
/*      */     
/* 5026 */     setRequestHeaders(_call);
/* 5027 */     setAttachments(_call);
/*      */     try {
/* 5029 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 5031 */       if (_resp instanceof RemoteException) {
/* 5032 */         throw (RemoteException)_resp;
/*      */       }
/* 5034 */       extractAttachments(_call);
/*      */       try {
/* 5036 */         return (RemoteIssueType[])_resp;
/* 5037 */       } catch (Exception exception) {
/* 5038 */         return 
/* 5039 */           (RemoteIssueType[])JavaUtils.convert(_resp, RemoteIssueType[].class);
/*      */       }
/*      */     
/* 5042 */     } catch (AxisFault axisFaultException) {
/* 5043 */       if (axisFaultException.detail != null) {
/* 5044 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5045 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5047 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 5048 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 5050 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 5051 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5054 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteStatus[] getStatuses(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException {
/* 5061 */     if (this.cachedEndpoint == null) {
/* 5062 */       throw new NoEndPointException();
/*      */     }
/* 5064 */     Call _call = createCall();
/* 5065 */     _call.setOperation(_operations[19]);
/* 5066 */     _call.setUseSOAPAction(true);
/* 5067 */     _call.setSOAPActionURI("");
/* 5068 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5069 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getStatuses"));
/*      */     
/* 5071 */     setRequestHeaders(_call);
/* 5072 */     setAttachments(_call);
/*      */     try {
/* 5074 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 5076 */       if (_resp instanceof RemoteException) {
/* 5077 */         throw (RemoteException)_resp;
/*      */       }
/* 5079 */       extractAttachments(_call);
/*      */       try {
/* 5081 */         return (RemoteStatus[])_resp;
/* 5082 */       } catch (Exception exception) {
/* 5083 */         return 
/* 5084 */           (RemoteStatus[])JavaUtils.convert(_resp, RemoteStatus[].class);
/*      */       }
/*      */     
/* 5087 */     } catch (AxisFault axisFaultException) {
/* 5088 */       if (axisFaultException.detail != null) {
/* 5089 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5090 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5092 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 5093 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 5095 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 5096 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5099 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssueType[] getSubTaskIssueTypes(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException {
/* 5106 */     if (this.cachedEndpoint == null) {
/* 5107 */       throw new NoEndPointException();
/*      */     }
/* 5109 */     Call _call = createCall();
/* 5110 */     _call.setOperation(_operations[20]);
/* 5111 */     _call.setUseSOAPAction(true);
/* 5112 */     _call.setSOAPActionURI("");
/* 5113 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5114 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getSubTaskIssueTypes"));
/*      */     
/* 5116 */     setRequestHeaders(_call);
/* 5117 */     setAttachments(_call);
/*      */     try {
/* 5119 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 5121 */       if (_resp instanceof RemoteException) {
/* 5122 */         throw (RemoteException)_resp;
/*      */       }
/* 5124 */       extractAttachments(_call);
/*      */       try {
/* 5126 */         return (RemoteIssueType[])_resp;
/* 5127 */       } catch (Exception exception) {
/* 5128 */         return 
/* 5129 */           (RemoteIssueType[])JavaUtils.convert(_resp, RemoteIssueType[].class);
/*      */       }
/*      */     
/* 5132 */     } catch (AxisFault axisFaultException) {
/* 5133 */       if (axisFaultException.detail != null) {
/* 5134 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5135 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5137 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 5138 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 5140 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 5141 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5144 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public RemoteProjectRole[] getProjectRoles(String in0) throws RemoteException, RemoteException {
/* 5150 */     if (this.cachedEndpoint == null) {
/* 5151 */       throw new NoEndPointException();
/*      */     }
/* 5153 */     Call _call = createCall();
/* 5154 */     _call.setOperation(_operations[21]);
/* 5155 */     _call.setUseSOAPAction(true);
/* 5156 */     _call.setSOAPActionURI("");
/* 5157 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5158 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getProjectRoles"));
/*      */     
/* 5160 */     setRequestHeaders(_call);
/* 5161 */     setAttachments(_call);
/*      */     try {
/* 5163 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 5165 */       if (_resp instanceof RemoteException) {
/* 5166 */         throw (RemoteException)_resp;
/*      */       }
/* 5168 */       extractAttachments(_call);
/*      */       try {
/* 5170 */         return (RemoteProjectRole[])_resp;
/* 5171 */       } catch (Exception exception) {
/* 5172 */         return 
/* 5173 */           (RemoteProjectRole[])JavaUtils.convert(_resp, RemoteProjectRole[].class);
/*      */       }
/*      */     
/* 5176 */     } catch (AxisFault axisFaultException) {
/* 5177 */       if (axisFaultException.detail != null) {
/* 5178 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5179 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5181 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5182 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5185 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public RemoteProjectRole getProjectRole(String in0, long in1) throws RemoteException, RemoteException {
/* 5191 */     if (this.cachedEndpoint == null) {
/* 5192 */       throw new NoEndPointException();
/*      */     }
/* 5194 */     Call _call = createCall();
/* 5195 */     _call.setOperation(_operations[22]);
/* 5196 */     _call.setUseSOAPAction(true);
/* 5197 */     _call.setSOAPActionURI("");
/* 5198 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5199 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getProjectRole"));
/*      */     
/* 5201 */     setRequestHeaders(_call);
/* 5202 */     setAttachments(_call);
/*      */     try {
/* 5204 */       Object _resp = _call.invoke(new Object[] { in0, new Long(in1) });
/*      */       
/* 5206 */       if (_resp instanceof RemoteException) {
/* 5207 */         throw (RemoteException)_resp;
/*      */       }
/* 5209 */       extractAttachments(_call);
/*      */       try {
/* 5211 */         return (RemoteProjectRole)_resp;
/* 5212 */       } catch (Exception exception) {
/* 5213 */         return 
/* 5214 */           (RemoteProjectRole)JavaUtils.convert(_resp, RemoteProjectRole.class);
/*      */       }
/*      */     
/* 5217 */     } catch (AxisFault axisFaultException) {
/* 5218 */       if (axisFaultException.detail != null) {
/* 5219 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5220 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5222 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5223 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5226 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteProjectRoleActors getProjectRoleActors(String in0, RemoteProjectRole in1, RemoteProject in2) throws RemoteException, RemoteException {
/* 5234 */     if (this.cachedEndpoint == null) {
/* 5235 */       throw new NoEndPointException();
/*      */     }
/* 5237 */     Call _call = createCall();
/* 5238 */     _call.setOperation(_operations[23]);
/* 5239 */     _call.setUseSOAPAction(true);
/* 5240 */     _call.setSOAPActionURI("");
/* 5241 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5242 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getProjectRoleActors"));
/*      */     
/* 5244 */     setRequestHeaders(_call);
/* 5245 */     setAttachments(_call);
/*      */     try {
/* 5247 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 5249 */       if (_resp instanceof RemoteException) {
/* 5250 */         throw (RemoteException)_resp;
/*      */       }
/* 5252 */       extractAttachments(_call);
/*      */       try {
/* 5254 */         return (RemoteProjectRoleActors)_resp;
/* 5255 */       } catch (Exception exception) {
/* 5256 */         return 
/* 5257 */           (RemoteProjectRoleActors)JavaUtils.convert(_resp, RemoteProjectRoleActors.class);
/*      */       }
/*      */     
/* 5260 */     } catch (AxisFault axisFaultException) {
/* 5261 */       if (axisFaultException.detail != null) {
/* 5262 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5263 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5265 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5266 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5269 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteRoleActors getDefaultRoleActors(String in0, RemoteProjectRole in1) throws RemoteException, RemoteException {
/* 5276 */     if (this.cachedEndpoint == null) {
/* 5277 */       throw new NoEndPointException();
/*      */     }
/* 5279 */     Call _call = createCall();
/* 5280 */     _call.setOperation(_operations[24]);
/* 5281 */     _call.setUseSOAPAction(true);
/* 5282 */     _call.setSOAPActionURI("");
/* 5283 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5284 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getDefaultRoleActors"));
/*      */     
/* 5286 */     setRequestHeaders(_call);
/* 5287 */     setAttachments(_call);
/*      */     try {
/* 5289 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 5291 */       if (_resp instanceof RemoteException) {
/* 5292 */         throw (RemoteException)_resp;
/*      */       }
/* 5294 */       extractAttachments(_call);
/*      */       try {
/* 5296 */         return (RemoteRoleActors)_resp;
/* 5297 */       } catch (Exception exception) {
/* 5298 */         return 
/* 5299 */           (RemoteRoleActors)JavaUtils.convert(_resp, RemoteRoleActors.class);
/*      */       }
/*      */     
/* 5302 */     } catch (AxisFault axisFaultException) {
/* 5303 */       if (axisFaultException.detail != null) {
/* 5304 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5305 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5307 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5308 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5311 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeAllRoleActorsByNameAndType(String in0, String in1, String in2) throws RemoteException, RemoteException {
/* 5317 */     if (this.cachedEndpoint == null) {
/* 5318 */       throw new NoEndPointException();
/*      */     }
/* 5320 */     Call _call = createCall();
/* 5321 */     _call.setOperation(_operations[25]);
/* 5322 */     _call.setUseSOAPAction(true);
/* 5323 */     _call.setSOAPActionURI("");
/* 5324 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5325 */     _call.setOperationName(
/* 5326 */         new QName("http://soap.rpc.jira.atlassian.com", "removeAllRoleActorsByNameAndType"));
/*      */     
/* 5328 */     setRequestHeaders(_call);
/* 5329 */     setAttachments(_call);
/*      */     try {
/* 5331 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 5333 */       if (_resp instanceof RemoteException) {
/* 5334 */         throw (RemoteException)_resp;
/*      */       }
/* 5336 */       extractAttachments(_call);
/* 5337 */     } catch (AxisFault axisFaultException) {
/* 5338 */       if (axisFaultException.detail != null) {
/* 5339 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5340 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5342 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5343 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5346 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeAllRoleActorsByProject(String in0, RemoteProject in1) throws RemoteException, RemoteException {
/* 5352 */     if (this.cachedEndpoint == null) {
/* 5353 */       throw new NoEndPointException();
/*      */     }
/* 5355 */     Call _call = createCall();
/* 5356 */     _call.setOperation(_operations[26]);
/* 5357 */     _call.setUseSOAPAction(true);
/* 5358 */     _call.setSOAPActionURI("");
/* 5359 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5360 */     _call.setOperationName(
/* 5361 */         new QName("http://soap.rpc.jira.atlassian.com", "removeAllRoleActorsByProject"));
/*      */     
/* 5363 */     setRequestHeaders(_call);
/* 5364 */     setAttachments(_call);
/*      */     try {
/* 5366 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 5368 */       if (_resp instanceof RemoteException) {
/* 5369 */         throw (RemoteException)_resp;
/*      */       }
/* 5371 */       extractAttachments(_call);
/* 5372 */     } catch (AxisFault axisFaultException) {
/* 5373 */       if (axisFaultException.detail != null) {
/* 5374 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5375 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5377 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5378 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5381 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void deleteProjectRole(String in0, RemoteProjectRole in1, boolean in2) throws RemoteException, RemoteException {
/* 5387 */     if (this.cachedEndpoint == null) {
/* 5388 */       throw new NoEndPointException();
/*      */     }
/* 5390 */     Call _call = createCall();
/* 5391 */     _call.setOperation(_operations[27]);
/* 5392 */     _call.setUseSOAPAction(true);
/* 5393 */     _call.setSOAPActionURI("");
/* 5394 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5395 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "deleteProjectRole"));
/*      */     
/* 5397 */     setRequestHeaders(_call);
/* 5398 */     setAttachments(_call);
/*      */     try {
/* 5400 */       Object _resp = _call.invoke(new Object[] { in0, in1, new Boolean(in2) });
/*      */       
/* 5402 */       if (_resp instanceof RemoteException) {
/* 5403 */         throw (RemoteException)_resp;
/*      */       }
/* 5405 */       extractAttachments(_call);
/* 5406 */     } catch (AxisFault axisFaultException) {
/* 5407 */       if (axisFaultException.detail != null) {
/* 5408 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5409 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5411 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5412 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5415 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateProjectRole(String in0, RemoteProjectRole in1) throws RemoteException, RemoteException {
/* 5421 */     if (this.cachedEndpoint == null) {
/* 5422 */       throw new NoEndPointException();
/*      */     }
/* 5424 */     Call _call = createCall();
/* 5425 */     _call.setOperation(_operations[28]);
/* 5426 */     _call.setUseSOAPAction(true);
/* 5427 */     _call.setSOAPActionURI("");
/* 5428 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5429 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "updateProjectRole"));
/*      */     
/* 5431 */     setRequestHeaders(_call);
/* 5432 */     setAttachments(_call);
/*      */     try {
/* 5434 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 5436 */       if (_resp instanceof RemoteException) {
/* 5437 */         throw (RemoteException)_resp;
/*      */       }
/* 5439 */       extractAttachments(_call);
/* 5440 */     } catch (AxisFault axisFaultException) {
/* 5441 */       if (axisFaultException.detail != null) {
/* 5442 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5443 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5445 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5446 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5449 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteProjectRole createProjectRole(String in0, RemoteProjectRole in1) throws RemoteException, RemoteException {
/* 5456 */     if (this.cachedEndpoint == null) {
/* 5457 */       throw new NoEndPointException();
/*      */     }
/* 5459 */     Call _call = createCall();
/* 5460 */     _call.setOperation(_operations[29]);
/* 5461 */     _call.setUseSOAPAction(true);
/* 5462 */     _call.setSOAPActionURI("");
/* 5463 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5464 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "createProjectRole"));
/*      */     
/* 5466 */     setRequestHeaders(_call);
/* 5467 */     setAttachments(_call);
/*      */     try {
/* 5469 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 5471 */       if (_resp instanceof RemoteException) {
/* 5472 */         throw (RemoteException)_resp;
/*      */       }
/* 5474 */       extractAttachments(_call);
/*      */       try {
/* 5476 */         return (RemoteProjectRole)_resp;
/* 5477 */       } catch (Exception exception) {
/* 5478 */         return 
/* 5479 */           (RemoteProjectRole)JavaUtils.convert(_resp, RemoteProjectRole.class);
/*      */       }
/*      */     
/* 5482 */     } catch (AxisFault axisFaultException) {
/* 5483 */       if (axisFaultException.detail != null) {
/* 5484 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5485 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5487 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5488 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5491 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isProjectRoleNameUnique(String in0, String in1) throws RemoteException, RemoteException {
/* 5497 */     if (this.cachedEndpoint == null) {
/* 5498 */       throw new NoEndPointException();
/*      */     }
/* 5500 */     Call _call = createCall();
/* 5501 */     _call.setOperation(_operations[30]);
/* 5502 */     _call.setUseSOAPAction(true);
/* 5503 */     _call.setSOAPActionURI("");
/* 5504 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5505 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "isProjectRoleNameUnique"));
/*      */     
/* 5507 */     setRequestHeaders(_call);
/* 5508 */     setAttachments(_call);
/*      */     try {
/* 5510 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 5512 */       if (_resp instanceof RemoteException) {
/* 5513 */         throw (RemoteException)_resp;
/*      */       }
/* 5515 */       extractAttachments(_call);
/*      */       try {
/* 5517 */         return ((Boolean)_resp).booleanValue();
/* 5518 */       } catch (Exception exception) {
/* 5519 */         return ((Boolean)JavaUtils.convert(_resp, boolean.class)).booleanValue();
/*      */       }
/*      */     
/* 5522 */     } catch (AxisFault axisFaultException) {
/* 5523 */       if (axisFaultException.detail != null) {
/* 5524 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5525 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5527 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5528 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5531 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addActorsToProjectRole(String in0, String[] in1, RemoteProjectRole in2, RemoteProject in3, String in4) throws RemoteException, RemoteException {
/* 5539 */     if (this.cachedEndpoint == null) {
/* 5540 */       throw new NoEndPointException();
/*      */     }
/* 5542 */     Call _call = createCall();
/* 5543 */     _call.setOperation(_operations[31]);
/* 5544 */     _call.setUseSOAPAction(true);
/* 5545 */     _call.setSOAPActionURI("");
/* 5546 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5547 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "addActorsToProjectRole"));
/*      */     
/* 5549 */     setRequestHeaders(_call);
/* 5550 */     setAttachments(_call);
/*      */     try {
/* 5552 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3, in4 });
/*      */       
/* 5554 */       if (_resp instanceof RemoteException) {
/* 5555 */         throw (RemoteException)_resp;
/*      */       }
/* 5557 */       extractAttachments(_call);
/* 5558 */     } catch (AxisFault axisFaultException) {
/* 5559 */       if (axisFaultException.detail != null) {
/* 5560 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5561 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5563 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5564 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5567 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeActorsFromProjectRole(String in0, String[] in1, RemoteProjectRole in2, RemoteProject in3, String in4) throws RemoteException, RemoteException {
/* 5575 */     if (this.cachedEndpoint == null) {
/* 5576 */       throw new NoEndPointException();
/*      */     }
/* 5578 */     Call _call = createCall();
/* 5579 */     _call.setOperation(_operations[32]);
/* 5580 */     _call.setUseSOAPAction(true);
/* 5581 */     _call.setSOAPActionURI("");
/* 5582 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5583 */     _call.setOperationName(
/* 5584 */         new QName("http://soap.rpc.jira.atlassian.com", "removeActorsFromProjectRole"));
/*      */     
/* 5586 */     setRequestHeaders(_call);
/* 5587 */     setAttachments(_call);
/*      */     try {
/* 5589 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3, in4 });
/*      */       
/* 5591 */       if (_resp instanceof RemoteException) {
/* 5592 */         throw (RemoteException)_resp;
/*      */       }
/* 5594 */       extractAttachments(_call);
/* 5595 */     } catch (AxisFault axisFaultException) {
/* 5596 */       if (axisFaultException.detail != null) {
/* 5597 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5598 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5600 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5601 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5604 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addDefaultActorsToProjectRole(String in0, String[] in1, RemoteProjectRole in2, String in3) throws RemoteException, RemoteException {
/* 5611 */     if (this.cachedEndpoint == null) {
/* 5612 */       throw new NoEndPointException();
/*      */     }
/* 5614 */     Call _call = createCall();
/* 5615 */     _call.setOperation(_operations[33]);
/* 5616 */     _call.setUseSOAPAction(true);
/* 5617 */     _call.setSOAPActionURI("");
/* 5618 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5619 */     _call.setOperationName(
/* 5620 */         new QName("http://soap.rpc.jira.atlassian.com", "addDefaultActorsToProjectRole"));
/*      */     
/* 5622 */     setRequestHeaders(_call);
/* 5623 */     setAttachments(_call);
/*      */     try {
/* 5625 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3 });
/*      */       
/* 5627 */       if (_resp instanceof RemoteException) {
/* 5628 */         throw (RemoteException)_resp;
/*      */       }
/* 5630 */       extractAttachments(_call);
/* 5631 */     } catch (AxisFault axisFaultException) {
/* 5632 */       if (axisFaultException.detail != null) {
/* 5633 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5634 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5636 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5637 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5640 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeDefaultActorsFromProjectRole(String in0, String[] in1, RemoteProjectRole in2, String in3) throws RemoteException, RemoteException {
/* 5647 */     if (this.cachedEndpoint == null) {
/* 5648 */       throw new NoEndPointException();
/*      */     }
/* 5650 */     Call _call = createCall();
/* 5651 */     _call.setOperation(_operations[34]);
/* 5652 */     _call.setUseSOAPAction(true);
/* 5653 */     _call.setSOAPActionURI("");
/* 5654 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5655 */     _call.setOperationName(
/* 5656 */         new QName("http://soap.rpc.jira.atlassian.com", "removeDefaultActorsFromProjectRole"));
/*      */     
/* 5658 */     setRequestHeaders(_call);
/* 5659 */     setAttachments(_call);
/*      */     try {
/* 5661 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3 });
/*      */       
/* 5663 */       if (_resp instanceof RemoteException) {
/* 5664 */         throw (RemoteException)_resp;
/*      */       }
/* 5666 */       extractAttachments(_call);
/* 5667 */     } catch (AxisFault axisFaultException) {
/* 5668 */       if (axisFaultException.detail != null) {
/* 5669 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5670 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5672 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5673 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5676 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteScheme[] getAssociatedNotificationSchemes(String in0, RemoteProjectRole in1) throws RemoteException, RemoteException {
/* 5683 */     if (this.cachedEndpoint == null) {
/* 5684 */       throw new NoEndPointException();
/*      */     }
/* 5686 */     Call _call = createCall();
/* 5687 */     _call.setOperation(_operations[35]);
/* 5688 */     _call.setUseSOAPAction(true);
/* 5689 */     _call.setSOAPActionURI("");
/* 5690 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5691 */     _call.setOperationName(
/* 5692 */         new QName("http://soap.rpc.jira.atlassian.com", "getAssociatedNotificationSchemes"));
/*      */     
/* 5694 */     setRequestHeaders(_call);
/* 5695 */     setAttachments(_call);
/*      */     try {
/* 5697 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 5699 */       if (_resp instanceof RemoteException) {
/* 5700 */         throw (RemoteException)_resp;
/*      */       }
/* 5702 */       extractAttachments(_call);
/*      */       try {
/* 5704 */         return (RemoteScheme[])_resp;
/* 5705 */       } catch (Exception exception) {
/* 5706 */         return 
/* 5707 */           (RemoteScheme[])JavaUtils.convert(_resp, RemoteScheme[].class);
/*      */       }
/*      */     
/* 5710 */     } catch (AxisFault axisFaultException) {
/* 5711 */       if (axisFaultException.detail != null) {
/* 5712 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5713 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5715 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5716 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5719 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteScheme[] getAssociatedPermissionSchemes(String in0, RemoteProjectRole in1) throws RemoteException, RemoteException {
/* 5726 */     if (this.cachedEndpoint == null) {
/* 5727 */       throw new NoEndPointException();
/*      */     }
/* 5729 */     Call _call = createCall();
/* 5730 */     _call.setOperation(_operations[36]);
/* 5731 */     _call.setUseSOAPAction(true);
/* 5732 */     _call.setSOAPActionURI("");
/* 5733 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5734 */     _call.setOperationName(
/* 5735 */         new QName("http://soap.rpc.jira.atlassian.com", "getAssociatedPermissionSchemes"));
/*      */     
/* 5737 */     setRequestHeaders(_call);
/* 5738 */     setAttachments(_call);
/*      */     try {
/* 5740 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 5742 */       if (_resp instanceof RemoteException) {
/* 5743 */         throw (RemoteException)_resp;
/*      */       }
/* 5745 */       extractAttachments(_call);
/*      */       try {
/* 5747 */         return (RemoteScheme[])_resp;
/* 5748 */       } catch (Exception exception) {
/* 5749 */         return 
/* 5750 */           (RemoteScheme[])JavaUtils.convert(_resp, RemoteScheme[].class);
/*      */       }
/*      */     
/* 5753 */     } catch (AxisFault axisFaultException) {
/* 5754 */       if (axisFaultException.detail != null) {
/* 5755 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5756 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5758 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5759 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5762 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public RemoteField[] getCustomFields(String in0) throws RemoteException, RemoteException {
/* 5768 */     if (this.cachedEndpoint == null) {
/* 5769 */       throw new NoEndPointException();
/*      */     }
/* 5771 */     Call _call = createCall();
/* 5772 */     _call.setOperation(_operations[37]);
/* 5773 */     _call.setUseSOAPAction(true);
/* 5774 */     _call.setSOAPActionURI("");
/* 5775 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5776 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getCustomFields"));
/*      */     
/* 5778 */     setRequestHeaders(_call);
/* 5779 */     setAttachments(_call);
/*      */     try {
/* 5781 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 5783 */       if (_resp instanceof RemoteException) {
/* 5784 */         throw (RemoteException)_resp;
/*      */       }
/* 5786 */       extractAttachments(_call);
/*      */       try {
/* 5788 */         return (RemoteField[])_resp;
/* 5789 */       } catch (Exception exception) {
/* 5790 */         return 
/* 5791 */           (RemoteField[])JavaUtils.convert(_resp, RemoteField[].class);
/*      */       }
/*      */     
/* 5794 */     } catch (AxisFault axisFaultException) {
/* 5795 */       if (axisFaultException.detail != null) {
/* 5796 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5797 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5799 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5800 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5803 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteComment[] getComments(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 5811 */     if (this.cachedEndpoint == null) {
/* 5812 */       throw new NoEndPointException();
/*      */     }
/* 5814 */     Call _call = createCall();
/* 5815 */     _call.setOperation(_operations[38]);
/* 5816 */     _call.setUseSOAPAction(true);
/* 5817 */     _call.setSOAPActionURI("");
/* 5818 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5819 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getComments"));
/*      */     
/* 5821 */     setRequestHeaders(_call);
/* 5822 */     setAttachments(_call);
/*      */     try {
/* 5824 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 5826 */       if (_resp instanceof RemoteException) {
/* 5827 */         throw (RemoteException)_resp;
/*      */       }
/* 5829 */       extractAttachments(_call);
/*      */       try {
/* 5831 */         return (RemoteComment[])_resp;
/* 5832 */       } catch (Exception exception) {
/* 5833 */         return 
/* 5834 */           (RemoteComment[])JavaUtils.convert(_resp, RemoteComment[].class);
/*      */       }
/*      */     
/* 5837 */     } catch (AxisFault axisFaultException) {
/* 5838 */       if (axisFaultException.detail != null) {
/* 5839 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5840 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5842 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 5843 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 5845 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 5846 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 5848 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5849 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5852 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteFilter[] getFavouriteFilters(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 5860 */     if (this.cachedEndpoint == null) {
/* 5861 */       throw new NoEndPointException();
/*      */     }
/* 5863 */     Call _call = createCall();
/* 5864 */     _call.setOperation(_operations[39]);
/* 5865 */     _call.setUseSOAPAction(true);
/* 5866 */     _call.setSOAPActionURI("");
/* 5867 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5868 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getFavouriteFilters"));
/*      */     
/* 5870 */     setRequestHeaders(_call);
/* 5871 */     setAttachments(_call);
/*      */     try {
/* 5873 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 5875 */       if (_resp instanceof RemoteException) {
/* 5876 */         throw (RemoteException)_resp;
/*      */       }
/* 5878 */       extractAttachments(_call);
/*      */       try {
/* 5880 */         return (RemoteFilter[])_resp;
/* 5881 */       } catch (Exception exception) {
/* 5882 */         return 
/* 5883 */           (RemoteFilter[])JavaUtils.convert(_resp, RemoteFilter[].class);
/*      */       }
/*      */     
/* 5886 */     } catch (AxisFault axisFaultException) {
/* 5887 */       if (axisFaultException.detail != null) {
/* 5888 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5889 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5891 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 5892 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 5894 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 5895 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 5897 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5898 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5901 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void archiveVersion(String in0, String in1, String in2, boolean in3) throws RemoteException, RemoteException {
/* 5907 */     if (this.cachedEndpoint == null) {
/* 5908 */       throw new NoEndPointException();
/*      */     }
/* 5910 */     Call _call = createCall();
/* 5911 */     _call.setOperation(_operations[40]);
/* 5912 */     _call.setUseSOAPAction(true);
/* 5913 */     _call.setSOAPActionURI("");
/* 5914 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5915 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "archiveVersion"));
/*      */     
/* 5917 */     setRequestHeaders(_call);
/* 5918 */     setAttachments(_call);
/*      */     try {
/* 5920 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, new Boolean(in3) });
/*      */       
/* 5922 */       if (_resp instanceof RemoteException) {
/* 5923 */         throw (RemoteException)_resp;
/*      */       }
/* 5925 */       extractAttachments(_call);
/* 5926 */     } catch (AxisFault axisFaultException) {
/* 5927 */       if (axisFaultException.detail != null) {
/* 5928 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5929 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5931 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5932 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5935 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteVersion[] getVersions(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 5943 */     if (this.cachedEndpoint == null) {
/* 5944 */       throw new NoEndPointException();
/*      */     }
/* 5946 */     Call _call = createCall();
/* 5947 */     _call.setOperation(_operations[41]);
/* 5948 */     _call.setUseSOAPAction(true);
/* 5949 */     _call.setSOAPActionURI("");
/* 5950 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 5951 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getVersions"));
/*      */     
/* 5953 */     setRequestHeaders(_call);
/* 5954 */     setAttachments(_call);
/*      */     try {
/* 5956 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 5958 */       if (_resp instanceof RemoteException) {
/* 5959 */         throw (RemoteException)_resp;
/*      */       }
/* 5961 */       extractAttachments(_call);
/*      */       try {
/* 5963 */         return (RemoteVersion[])_resp;
/* 5964 */       } catch (Exception exception) {
/* 5965 */         return 
/* 5966 */           (RemoteVersion[])JavaUtils.convert(_resp, RemoteVersion[].class);
/*      */       }
/*      */     
/* 5969 */     } catch (AxisFault axisFaultException) {
/* 5970 */       if (axisFaultException.detail != null) {
/* 5971 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5972 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 5974 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 5975 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 5977 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 5978 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 5980 */         if (axisFaultException.detail instanceof RemoteException) {
/* 5981 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 5984 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteProject createProject(String in0, String in1, String in2, String in3, String in4, String in5, RemotePermissionScheme in6, RemoteScheme in7, RemoteScheme in8) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 5997 */     if (this.cachedEndpoint == null) {
/* 5998 */       throw new NoEndPointException();
/*      */     }
/* 6000 */     Call _call = createCall();
/* 6001 */     _call.setOperation(_operations[42]);
/* 6002 */     _call.setUseSOAPAction(true);
/* 6003 */     _call.setSOAPActionURI("");
/* 6004 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6005 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "createProject"));
/*      */     
/* 6007 */     setRequestHeaders(_call);
/* 6008 */     setAttachments(_call);
/*      */     try {
/* 6010 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3, in4, in5, in6, in7, in8 });
/*      */       
/* 6012 */       if (_resp instanceof RemoteException) {
/* 6013 */         throw (RemoteException)_resp;
/*      */       }
/* 6015 */       extractAttachments(_call);
/*      */       try {
/* 6017 */         return (RemoteProject)_resp;
/* 6018 */       } catch (Exception exception) {
/* 6019 */         return 
/* 6020 */           (RemoteProject)JavaUtils.convert(_resp, RemoteProject.class);
/*      */       }
/*      */     
/* 6023 */     } catch (AxisFault axisFaultException) {
/* 6024 */       if (axisFaultException.detail != null) {
/* 6025 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6026 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6028 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6029 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6031 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 6032 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 6034 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6035 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 6037 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6038 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6041 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addComment(String in0, String in1, RemoteComment in2) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 6050 */     if (this.cachedEndpoint == null) {
/* 6051 */       throw new NoEndPointException();
/*      */     }
/* 6053 */     Call _call = createCall();
/* 6054 */     _call.setOperation(_operations[43]);
/* 6055 */     _call.setUseSOAPAction(true);
/* 6056 */     _call.setSOAPActionURI("");
/* 6057 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6058 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "addComment"));
/*      */     
/* 6060 */     setRequestHeaders(_call);
/* 6061 */     setAttachments(_call);
/*      */     try {
/* 6063 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 6065 */       if (_resp instanceof RemoteException) {
/* 6066 */         throw (RemoteException)_resp;
/*      */       }
/* 6068 */       extractAttachments(_call);
/* 6069 */     } catch (AxisFault axisFaultException) {
/* 6070 */       if (axisFaultException.detail != null) {
/* 6071 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6072 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6074 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6075 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6077 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6078 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 6080 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6081 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6084 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public RemoteField[] getFieldsForEdit(String in0, String in1) throws RemoteException, RemoteException {
/* 6090 */     if (this.cachedEndpoint == null) {
/* 6091 */       throw new NoEndPointException();
/*      */     }
/* 6093 */     Call _call = createCall();
/* 6094 */     _call.setOperation(_operations[44]);
/* 6095 */     _call.setUseSOAPAction(true);
/* 6096 */     _call.setSOAPActionURI("");
/* 6097 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6098 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getFieldsForEdit"));
/*      */     
/* 6100 */     setRequestHeaders(_call);
/* 6101 */     setAttachments(_call);
/*      */     try {
/* 6103 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 6105 */       if (_resp instanceof RemoteException) {
/* 6106 */         throw (RemoteException)_resp;
/*      */       }
/* 6108 */       extractAttachments(_call);
/*      */       try {
/* 6110 */         return (RemoteField[])_resp;
/* 6111 */       } catch (Exception exception) {
/* 6112 */         return 
/* 6113 */           (RemoteField[])JavaUtils.convert(_resp, RemoteField[].class);
/*      */       }
/*      */     
/* 6116 */     } catch (AxisFault axisFaultException) {
/* 6117 */       if (axisFaultException.detail != null) {
/* 6118 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6119 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6121 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6122 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6125 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssueType[] getIssueTypesForProject(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException {
/* 6133 */     if (this.cachedEndpoint == null) {
/* 6134 */       throw new NoEndPointException();
/*      */     }
/* 6136 */     Call _call = createCall();
/* 6137 */     _call.setOperation(_operations[45]);
/* 6138 */     _call.setUseSOAPAction(true);
/* 6139 */     _call.setSOAPActionURI("");
/* 6140 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6141 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getIssueTypesForProject"));
/*      */     
/* 6143 */     setRequestHeaders(_call);
/* 6144 */     setAttachments(_call);
/*      */     try {
/* 6146 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 6148 */       if (_resp instanceof RemoteException) {
/* 6149 */         throw (RemoteException)_resp;
/*      */       }
/* 6151 */       extractAttachments(_call);
/*      */       try {
/* 6153 */         return (RemoteIssueType[])_resp;
/* 6154 */       } catch (Exception exception) {
/* 6155 */         return 
/* 6156 */           (RemoteIssueType[])JavaUtils.convert(_resp, RemoteIssueType[].class);
/*      */       }
/*      */     
/* 6159 */     } catch (AxisFault axisFaultException) {
/* 6160 */       if (axisFaultException.detail != null) {
/* 6161 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6162 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6164 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6165 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6167 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6168 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6171 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssueType[] getSubTaskIssueTypesForProject(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException {
/* 6179 */     if (this.cachedEndpoint == null) {
/* 6180 */       throw new NoEndPointException();
/*      */     }
/* 6182 */     Call _call = createCall();
/* 6183 */     _call.setOperation(_operations[46]);
/* 6184 */     _call.setUseSOAPAction(true);
/* 6185 */     _call.setSOAPActionURI("");
/* 6186 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6187 */     _call.setOperationName(
/* 6188 */         new QName("http://soap.rpc.jira.atlassian.com", "getSubTaskIssueTypesForProject"));
/*      */     
/* 6190 */     setRequestHeaders(_call);
/* 6191 */     setAttachments(_call);
/*      */     try {
/* 6193 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 6195 */       if (_resp instanceof RemoteException) {
/* 6196 */         throw (RemoteException)_resp;
/*      */       }
/* 6198 */       extractAttachments(_call);
/*      */       try {
/* 6200 */         return (RemoteIssueType[])_resp;
/* 6201 */       } catch (Exception exception) {
/* 6202 */         return 
/* 6203 */           (RemoteIssueType[])JavaUtils.convert(_resp, RemoteIssueType[].class);
/*      */       }
/*      */     
/* 6206 */     } catch (AxisFault axisFaultException) {
/* 6207 */       if (axisFaultException.detail != null) {
/* 6208 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6209 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6211 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6212 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6214 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6215 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6218 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addUserToGroup(String in0, RemoteGroup in1, RemoteUser in2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 6228 */     if (this.cachedEndpoint == null) {
/* 6229 */       throw new NoEndPointException();
/*      */     }
/* 6231 */     Call _call = createCall();
/* 6232 */     _call.setOperation(_operations[47]);
/* 6233 */     _call.setUseSOAPAction(true);
/* 6234 */     _call.setSOAPActionURI("");
/* 6235 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6236 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "addUserToGroup"));
/*      */     
/* 6238 */     setRequestHeaders(_call);
/* 6239 */     setAttachments(_call);
/*      */     try {
/* 6241 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 6243 */       if (_resp instanceof RemoteException) {
/* 6244 */         throw (RemoteException)_resp;
/*      */       }
/* 6246 */       extractAttachments(_call);
/* 6247 */     } catch (AxisFault axisFaultException) {
/* 6248 */       if (axisFaultException.detail != null) {
/* 6249 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6250 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6252 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6253 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6255 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 6256 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 6258 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6259 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 6261 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6262 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6265 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeUserFromGroup(String in0, RemoteGroup in1, RemoteUser in2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 6275 */     if (this.cachedEndpoint == null) {
/* 6276 */       throw new NoEndPointException();
/*      */     }
/* 6278 */     Call _call = createCall();
/* 6279 */     _call.setOperation(_operations[48]);
/* 6280 */     _call.setUseSOAPAction(true);
/* 6281 */     _call.setSOAPActionURI("");
/* 6282 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6283 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "removeUserFromGroup"));
/*      */     
/* 6285 */     setRequestHeaders(_call);
/* 6286 */     setAttachments(_call);
/*      */     try {
/* 6288 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 6290 */       if (_resp instanceof RemoteException) {
/* 6291 */         throw (RemoteException)_resp;
/*      */       }
/* 6293 */       extractAttachments(_call);
/* 6294 */     } catch (AxisFault axisFaultException) {
/* 6295 */       if (axisFaultException.detail != null) {
/* 6296 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6297 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6299 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6300 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6302 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 6303 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 6305 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6306 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 6308 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6309 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6312 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean logout(String in0) throws RemoteException {
/* 6317 */     if (this.cachedEndpoint == null) {
/* 6318 */       throw new NoEndPointException();
/*      */     }
/* 6320 */     Call _call = createCall();
/* 6321 */     _call.setOperation(_operations[49]);
/* 6322 */     _call.setUseSOAPAction(true);
/* 6323 */     _call.setSOAPActionURI("");
/* 6324 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6325 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "logout"));
/*      */     
/* 6327 */     setRequestHeaders(_call);
/* 6328 */     setAttachments(_call);
/*      */     try {
/* 6330 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 6332 */       if (_resp instanceof RemoteException) {
/* 6333 */         throw (RemoteException)_resp;
/*      */       }
/* 6335 */       extractAttachments(_call);
/*      */       try {
/* 6337 */         return ((Boolean)_resp).booleanValue();
/* 6338 */       } catch (Exception exception) {
/* 6339 */         return ((Boolean)JavaUtils.convert(_resp, boolean.class)).booleanValue();
/*      */       }
/*      */     
/* 6342 */     } catch (AxisFault axisFaultException) {
/* 6343 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteProject getProjectById(String in0, long in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 6351 */     if (this.cachedEndpoint == null) {
/* 6352 */       throw new NoEndPointException();
/*      */     }
/* 6354 */     Call _call = createCall();
/* 6355 */     _call.setOperation(_operations[50]);
/* 6356 */     _call.setUseSOAPAction(true);
/* 6357 */     _call.setSOAPActionURI("");
/* 6358 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6359 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getProjectById"));
/*      */     
/* 6361 */     setRequestHeaders(_call);
/* 6362 */     setAttachments(_call);
/*      */     try {
/* 6364 */       Object _resp = _call.invoke(new Object[] { in0, new Long(in1) });
/*      */       
/* 6366 */       if (_resp instanceof RemoteException) {
/* 6367 */         throw (RemoteException)_resp;
/*      */       }
/* 6369 */       extractAttachments(_call);
/*      */       try {
/* 6371 */         return (RemoteProject)_resp;
/* 6372 */       } catch (Exception exception) {
/* 6373 */         return 
/* 6374 */           (RemoteProject)JavaUtils.convert(_resp, RemoteProject.class);
/*      */       }
/*      */     
/* 6377 */     } catch (AxisFault axisFaultException) {
/* 6378 */       if (axisFaultException.detail != null) {
/* 6379 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6380 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6382 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6383 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6385 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6386 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 6388 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6389 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6392 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public RemoteProject getProjectWithSchemesById(String in0, long in1) throws RemoteException, RemoteException {
/* 6398 */     if (this.cachedEndpoint == null) {
/* 6399 */       throw new NoEndPointException();
/*      */     }
/* 6401 */     Call _call = createCall();
/* 6402 */     _call.setOperation(_operations[51]);
/* 6403 */     _call.setUseSOAPAction(true);
/* 6404 */     _call.setSOAPActionURI("");
/* 6405 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6406 */     _call.setOperationName(
/* 6407 */         new QName("http://soap.rpc.jira.atlassian.com", "getProjectWithSchemesById"));
/*      */     
/* 6409 */     setRequestHeaders(_call);
/* 6410 */     setAttachments(_call);
/*      */     try {
/* 6412 */       Object _resp = _call.invoke(new Object[] { in0, new Long(in1) });
/*      */       
/* 6414 */       if (_resp instanceof RemoteException) {
/* 6415 */         throw (RemoteException)_resp;
/*      */       }
/* 6417 */       extractAttachments(_call);
/*      */       try {
/* 6419 */         return (RemoteProject)_resp;
/* 6420 */       } catch (Exception exception) {
/* 6421 */         return 
/* 6422 */           (RemoteProject)JavaUtils.convert(_resp, RemoteProject.class);
/*      */       }
/*      */     
/* 6425 */     } catch (AxisFault axisFaultException) {
/* 6426 */       if (axisFaultException.detail != null) {
/* 6427 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6428 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6430 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6431 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6434 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deleteProject(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 6442 */     if (this.cachedEndpoint == null) {
/* 6443 */       throw new NoEndPointException();
/*      */     }
/* 6445 */     Call _call = createCall();
/* 6446 */     _call.setOperation(_operations[52]);
/* 6447 */     _call.setUseSOAPAction(true);
/* 6448 */     _call.setSOAPActionURI("");
/* 6449 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6450 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "deleteProject"));
/*      */     
/* 6452 */     setRequestHeaders(_call);
/* 6453 */     setAttachments(_call);
/*      */     try {
/* 6455 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 6457 */       if (_resp instanceof RemoteException) {
/* 6458 */         throw (RemoteException)_resp;
/*      */       }
/* 6460 */       extractAttachments(_call);
/* 6461 */     } catch (AxisFault axisFaultException) {
/* 6462 */       if (axisFaultException.detail != null) {
/* 6463 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6464 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6466 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6467 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6469 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6470 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 6472 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6473 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6476 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void releaseVersion(String in0, String in1, RemoteVersion in2) throws RemoteException, RemoteException {
/* 6483 */     if (this.cachedEndpoint == null) {
/* 6484 */       throw new NoEndPointException();
/*      */     }
/* 6486 */     Call _call = createCall();
/* 6487 */     _call.setOperation(_operations[53]);
/* 6488 */     _call.setUseSOAPAction(true);
/* 6489 */     _call.setSOAPActionURI("");
/* 6490 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6491 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "releaseVersion"));
/*      */     
/* 6493 */     setRequestHeaders(_call);
/* 6494 */     setAttachments(_call);
/*      */     try {
/* 6496 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 6498 */       if (_resp instanceof RemoteException) {
/* 6499 */         throw (RemoteException)_resp;
/*      */       }
/* 6501 */       extractAttachments(_call);
/* 6502 */     } catch (AxisFault axisFaultException) {
/* 6503 */       if (axisFaultException.detail != null) {
/* 6504 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6505 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6507 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6508 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6511 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteSecurityLevel[] getSecurityLevels(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteException {
/* 6519 */     if (this.cachedEndpoint == null) {
/* 6520 */       throw new NoEndPointException();
/*      */     }
/* 6522 */     Call _call = createCall();
/* 6523 */     _call.setOperation(_operations[54]);
/* 6524 */     _call.setUseSOAPAction(true);
/* 6525 */     _call.setSOAPActionURI("");
/* 6526 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6527 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getSecurityLevels"));
/*      */     
/* 6529 */     setRequestHeaders(_call);
/* 6530 */     setAttachments(_call);
/*      */     try {
/* 6532 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 6534 */       if (_resp instanceof RemoteException) {
/* 6535 */         throw (RemoteException)_resp;
/*      */       }
/* 6537 */       extractAttachments(_call);
/*      */       try {
/* 6539 */         return (RemoteSecurityLevel[])_resp;
/* 6540 */       } catch (Exception exception) {
/* 6541 */         return 
/* 6542 */           (RemoteSecurityLevel[])JavaUtils.convert(_resp, RemoteSecurityLevel[].class);
/*      */       }
/*      */     
/* 6545 */     } catch (AxisFault axisFaultException) {
/* 6546 */       if (axisFaultException.detail != null) {
/* 6547 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6548 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6550 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6551 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6553 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6554 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6557 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deleteIssue(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 6565 */     if (this.cachedEndpoint == null) {
/* 6566 */       throw new NoEndPointException();
/*      */     }
/* 6568 */     Call _call = createCall();
/* 6569 */     _call.setOperation(_operations[55]);
/* 6570 */     _call.setUseSOAPAction(true);
/* 6571 */     _call.setSOAPActionURI("");
/* 6572 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6573 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "deleteIssue"));
/*      */     
/* 6575 */     setRequestHeaders(_call);
/* 6576 */     setAttachments(_call);
/*      */     try {
/* 6578 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 6580 */       if (_resp instanceof RemoteException) {
/* 6581 */         throw (RemoteException)_resp;
/*      */       }
/* 6583 */       extractAttachments(_call);
/* 6584 */     } catch (AxisFault axisFaultException) {
/* 6585 */       if (axisFaultException.detail != null) {
/* 6586 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6587 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6589 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6590 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6592 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6593 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 6595 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6596 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6599 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssue createIssueWithSecurityLevel(String in0, RemoteIssue in1, long in2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 6609 */     if (this.cachedEndpoint == null) {
/* 6610 */       throw new NoEndPointException();
/*      */     }
/* 6612 */     Call _call = createCall();
/* 6613 */     _call.setOperation(_operations[56]);
/* 6614 */     _call.setUseSOAPAction(true);
/* 6615 */     _call.setSOAPActionURI("");
/* 6616 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6617 */     _call.setOperationName(
/* 6618 */         new QName("http://soap.rpc.jira.atlassian.com", "createIssueWithSecurityLevel"));
/*      */     
/* 6620 */     setRequestHeaders(_call);
/* 6621 */     setAttachments(_call);
/*      */     try {
/* 6623 */       Object _resp = _call.invoke(new Object[] { in0, in1, new Long(in2) });
/*      */       
/* 6625 */       if (_resp instanceof RemoteException) {
/* 6626 */         throw (RemoteException)_resp;
/*      */       }
/* 6628 */       extractAttachments(_call);
/*      */       try {
/* 6630 */         return (RemoteIssue)_resp;
/* 6631 */       } catch (Exception exception) {
/* 6632 */         return 
/* 6633 */           (RemoteIssue)JavaUtils.convert(_resp, RemoteIssue.class);
/*      */       }
/*      */     
/* 6636 */     } catch (AxisFault axisFaultException) {
/* 6637 */       if (axisFaultException.detail != null) {
/* 6638 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6639 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6641 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6642 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6644 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 6645 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 6647 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6648 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 6650 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6651 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6654 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addAttachmentsToIssue(String in0, String in1, String[] in2, byte[][] in3) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 6663 */     if (this.cachedEndpoint == null) {
/* 6664 */       throw new NoEndPointException();
/*      */     }
/* 6666 */     Call _call = createCall();
/* 6667 */     _call.setOperation(_operations[57]);
/* 6668 */     _call.setUseSOAPAction(true);
/* 6669 */     _call.setSOAPActionURI("");
/* 6670 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6671 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "addAttachmentsToIssue"));
/*      */     
/* 6673 */     setRequestHeaders(_call);
/* 6674 */     setAttachments(_call);
/*      */     try {
/* 6676 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3 });
/*      */       
/* 6678 */       if (_resp instanceof RemoteException) {
/* 6679 */         throw (RemoteException)_resp;
/*      */       }
/* 6681 */       extractAttachments(_call);
/*      */       try {
/* 6683 */         return ((Boolean)_resp).booleanValue();
/* 6684 */       } catch (Exception exception) {
/* 6685 */         return ((Boolean)JavaUtils.convert(_resp, boolean.class)).booleanValue();
/*      */       }
/*      */     
/* 6688 */     } catch (AxisFault axisFaultException) {
/* 6689 */       if (axisFaultException.detail != null) {
/* 6690 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6691 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6693 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6694 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6696 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 6697 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 6699 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6700 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 6702 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6703 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6706 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteAttachment[] getAttachmentsFromIssue(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 6716 */     if (this.cachedEndpoint == null) {
/* 6717 */       throw new NoEndPointException();
/*      */     }
/* 6719 */     Call _call = createCall();
/* 6720 */     _call.setOperation(_operations[58]);
/* 6721 */     _call.setUseSOAPAction(true);
/* 6722 */     _call.setSOAPActionURI("");
/* 6723 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6724 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getAttachmentsFromIssue"));
/*      */     
/* 6726 */     setRequestHeaders(_call);
/* 6727 */     setAttachments(_call);
/*      */     try {
/* 6729 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 6731 */       if (_resp instanceof RemoteException) {
/* 6732 */         throw (RemoteException)_resp;
/*      */       }
/* 6734 */       extractAttachments(_call);
/*      */       try {
/* 6736 */         return (RemoteAttachment[])_resp;
/* 6737 */       } catch (ClassCastException e) {
/* 6738 */         throw e;
/* 6739 */       } catch (Exception exception) {
/* 6740 */         return 
/* 6741 */           (RemoteAttachment[])JavaUtils.convert(_resp, RemoteAttachment[].class);
/*      */       }
/*      */     
/* 6744 */     } catch (AxisFault axisFaultException) {
/* 6745 */       if (axisFaultException.detail != null) {
/* 6746 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6747 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6749 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6750 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6752 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 6753 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 6755 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6756 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 6758 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6759 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6762 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPermissionToEditComment(String in0, RemoteComment in1) throws RemoteException, RemoteException {
/* 6769 */     if (this.cachedEndpoint == null) {
/* 6770 */       throw new NoEndPointException();
/*      */     }
/* 6772 */     Call _call = createCall();
/* 6773 */     _call.setOperation(_operations[59]);
/* 6774 */     _call.setUseSOAPAction(true);
/* 6775 */     _call.setSOAPActionURI("");
/* 6776 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6777 */     _call.setOperationName(
/* 6778 */         new QName("http://soap.rpc.jira.atlassian.com", "hasPermissionToEditComment"));
/*      */     
/* 6780 */     setRequestHeaders(_call);
/* 6781 */     setAttachments(_call);
/*      */     try {
/* 6783 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 6785 */       if (_resp instanceof RemoteException) {
/* 6786 */         throw (RemoteException)_resp;
/*      */       }
/* 6788 */       extractAttachments(_call);
/*      */       try {
/* 6790 */         return ((Boolean)_resp).booleanValue();
/* 6791 */       } catch (Exception exception) {
/* 6792 */         return ((Boolean)JavaUtils.convert(_resp, boolean.class)).booleanValue();
/*      */       }
/*      */     
/* 6795 */     } catch (AxisFault axisFaultException) {
/* 6796 */       if (axisFaultException.detail != null) {
/* 6797 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6798 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6800 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6801 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6804 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteComment editComment(String in0, RemoteComment in1) throws RemoteException, RemoteException {
/* 6811 */     if (this.cachedEndpoint == null) {
/* 6812 */       throw new NoEndPointException();
/*      */     }
/* 6814 */     Call _call = createCall();
/* 6815 */     _call.setOperation(_operations[60]);
/* 6816 */     _call.setUseSOAPAction(true);
/* 6817 */     _call.setSOAPActionURI("");
/* 6818 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6819 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "editComment"));
/*      */     
/* 6821 */     setRequestHeaders(_call);
/* 6822 */     setAttachments(_call);
/*      */     try {
/* 6824 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 6826 */       if (_resp instanceof RemoteException) {
/* 6827 */         throw (RemoteException)_resp;
/*      */       }
/* 6829 */       extractAttachments(_call);
/*      */       try {
/* 6831 */         return (RemoteComment)_resp;
/* 6832 */       } catch (Exception exception) {
/* 6833 */         return 
/* 6834 */           (RemoteComment)JavaUtils.convert(_resp, RemoteComment.class);
/*      */       }
/*      */     
/* 6837 */     } catch (AxisFault axisFaultException) {
/* 6838 */       if (axisFaultException.detail != null) {
/* 6839 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6840 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6842 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6843 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6846 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteField[] getFieldsForAction(String in0, String in1, String in2) throws RemoteException, RemoteException {
/* 6853 */     if (this.cachedEndpoint == null) {
/* 6854 */       throw new NoEndPointException();
/*      */     }
/* 6856 */     Call _call = createCall();
/* 6857 */     _call.setOperation(_operations[61]);
/* 6858 */     _call.setUseSOAPAction(true);
/* 6859 */     _call.setSOAPActionURI("");
/* 6860 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6861 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getFieldsForAction"));
/*      */     
/* 6863 */     setRequestHeaders(_call);
/* 6864 */     setAttachments(_call);
/*      */     try {
/* 6866 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 6868 */       if (_resp instanceof RemoteException) {
/* 6869 */         throw (RemoteException)_resp;
/*      */       }
/* 6871 */       extractAttachments(_call);
/*      */       try {
/* 6873 */         return (RemoteField[])_resp;
/* 6874 */       } catch (Exception exception) {
/* 6875 */         return 
/* 6876 */           (RemoteField[])JavaUtils.convert(_resp, RemoteField[].class);
/*      */       }
/*      */     
/* 6879 */     } catch (AxisFault axisFaultException) {
/* 6880 */       if (axisFaultException.detail != null) {
/* 6881 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6882 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6884 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6885 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6888 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssue progressWorkflowAction(String in0, String in1, String in2, RemoteFieldValue[] in3) throws RemoteException, RemoteException {
/* 6895 */     if (this.cachedEndpoint == null) {
/* 6896 */       throw new NoEndPointException();
/*      */     }
/* 6898 */     Call _call = createCall();
/* 6899 */     _call.setOperation(_operations[62]);
/* 6900 */     _call.setUseSOAPAction(true);
/* 6901 */     _call.setSOAPActionURI("");
/* 6902 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6903 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "progressWorkflowAction"));
/*      */     
/* 6905 */     setRequestHeaders(_call);
/* 6906 */     setAttachments(_call);
/*      */     try {
/* 6908 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3 });
/*      */       
/* 6910 */       if (_resp instanceof RemoteException) {
/* 6911 */         throw (RemoteException)_resp;
/*      */       }
/* 6913 */       extractAttachments(_call);
/*      */       try {
/* 6915 */         return (RemoteIssue)_resp;
/* 6916 */       } catch (Exception exception) {
/* 6917 */         return 
/* 6918 */           (RemoteIssue)JavaUtils.convert(_resp, RemoteIssue.class);
/*      */       }
/*      */     
/* 6921 */     } catch (AxisFault axisFaultException) {
/* 6922 */       if (axisFaultException.detail != null) {
/* 6923 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6924 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6926 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6927 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6930 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssue getIssueById(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 6938 */     if (this.cachedEndpoint == null) {
/* 6939 */       throw new NoEndPointException();
/*      */     }
/* 6941 */     Call _call = createCall();
/* 6942 */     _call.setOperation(_operations[63]);
/* 6943 */     _call.setUseSOAPAction(true);
/* 6944 */     _call.setSOAPActionURI("");
/* 6945 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6946 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getIssueById"));
/*      */     
/* 6948 */     setRequestHeaders(_call);
/* 6949 */     setAttachments(_call);
/*      */     try {
/* 6951 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 6953 */       if (_resp instanceof RemoteException) {
/* 6954 */         throw (RemoteException)_resp;
/*      */       }
/* 6956 */       extractAttachments(_call);
/*      */       try {
/* 6958 */         return (RemoteIssue)_resp;
/* 6959 */       } catch (Exception exception) {
/* 6960 */         return 
/* 6961 */           (RemoteIssue)JavaUtils.convert(_resp, RemoteIssue.class);
/*      */       }
/*      */     
/* 6964 */     } catch (AxisFault axisFaultException) {
/* 6965 */       if (axisFaultException.detail != null) {
/* 6966 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6967 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 6969 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 6970 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 6972 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 6973 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 6975 */         if (axisFaultException.detail instanceof RemoteException) {
/* 6976 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 6979 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteWorklog addWorklogWithNewRemainingEstimate(String in0, String in1, RemoteWorklog in2, String in3) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException {
/* 6988 */     if (this.cachedEndpoint == null) {
/* 6989 */       throw new NoEndPointException();
/*      */     }
/* 6991 */     Call _call = createCall();
/* 6992 */     _call.setOperation(_operations[64]);
/* 6993 */     _call.setUseSOAPAction(true);
/* 6994 */     _call.setSOAPActionURI("");
/* 6995 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 6996 */     _call.setOperationName(
/* 6997 */         new QName("http://soap.rpc.jira.atlassian.com", "addWorklogWithNewRemainingEstimate"));
/*      */     
/* 6999 */     setRequestHeaders(_call);
/* 7000 */     setAttachments(_call);
/*      */     try {
/* 7002 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3 });
/*      */       
/* 7004 */       if (_resp instanceof RemoteException) {
/* 7005 */         throw (RemoteException)_resp;
/*      */       }
/* 7007 */       extractAttachments(_call);
/*      */       try {
/* 7009 */         return (RemoteWorklog)_resp;
/* 7010 */       } catch (Exception exception) {
/* 7011 */         return 
/* 7012 */           (RemoteWorklog)JavaUtils.convert(_resp, RemoteWorklog.class);
/*      */       }
/*      */     
/* 7015 */     } catch (AxisFault axisFaultException) {
/* 7016 */       if (axisFaultException.detail != null) {
/* 7017 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7018 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7020 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7021 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7023 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7024 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7026 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7027 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7030 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteWorklog addWorklogAndAutoAdjustRemainingEstimate(String in0, String in1, RemoteWorklog in2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException {
/* 7039 */     if (this.cachedEndpoint == null) {
/* 7040 */       throw new NoEndPointException();
/*      */     }
/* 7042 */     Call _call = createCall();
/* 7043 */     _call.setOperation(_operations[65]);
/* 7044 */     _call.setUseSOAPAction(true);
/* 7045 */     _call.setSOAPActionURI("");
/* 7046 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7047 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", 
/* 7048 */           "addWorklogAndAutoAdjustRemainingEstimate"));
/*      */     
/* 7050 */     setRequestHeaders(_call);
/* 7051 */     setAttachments(_call);
/*      */     try {
/* 7053 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 7055 */       if (_resp instanceof RemoteException) {
/* 7056 */         throw (RemoteException)_resp;
/*      */       }
/* 7058 */       extractAttachments(_call);
/*      */       try {
/* 7060 */         return (RemoteWorklog)_resp;
/* 7061 */       } catch (Exception exception) {
/* 7062 */         return 
/* 7063 */           (RemoteWorklog)JavaUtils.convert(_resp, RemoteWorklog.class);
/*      */       }
/*      */     
/* 7066 */     } catch (AxisFault axisFaultException) {
/* 7067 */       if (axisFaultException.detail != null) {
/* 7068 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7069 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7071 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7072 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7074 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7075 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7077 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7078 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7081 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteWorklog addWorklogAndRetainRemainingEstimate(String in0, String in1, RemoteWorklog in2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException {
/* 7090 */     if (this.cachedEndpoint == null) {
/* 7091 */       throw new NoEndPointException();
/*      */     }
/* 7093 */     Call _call = createCall();
/* 7094 */     _call.setOperation(_operations[66]);
/* 7095 */     _call.setUseSOAPAction(true);
/* 7096 */     _call.setSOAPActionURI("");
/* 7097 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7098 */     _call.setOperationName(
/* 7099 */         new QName("http://soap.rpc.jira.atlassian.com", "addWorklogAndRetainRemainingEstimate"));
/*      */     
/* 7101 */     setRequestHeaders(_call);
/* 7102 */     setAttachments(_call);
/*      */     try {
/* 7104 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 7106 */       if (_resp instanceof RemoteException) {
/* 7107 */         throw (RemoteException)_resp;
/*      */       }
/* 7109 */       extractAttachments(_call);
/*      */       try {
/* 7111 */         return (RemoteWorklog)_resp;
/* 7112 */       } catch (Exception exception) {
/* 7113 */         return 
/* 7114 */           (RemoteWorklog)JavaUtils.convert(_resp, RemoteWorklog.class);
/*      */       }
/*      */     
/* 7117 */     } catch (AxisFault axisFaultException) {
/* 7118 */       if (axisFaultException.detail != null) {
/* 7119 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7120 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7122 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7123 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7125 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7126 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7128 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7129 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7132 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deleteWorklogWithNewRemainingEstimate(String in0, String in1, String in2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException {
/* 7140 */     if (this.cachedEndpoint == null) {
/* 7141 */       throw new NoEndPointException();
/*      */     }
/* 7143 */     Call _call = createCall();
/* 7144 */     _call.setOperation(_operations[67]);
/* 7145 */     _call.setUseSOAPAction(true);
/* 7146 */     _call.setSOAPActionURI("");
/* 7147 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7148 */     _call.setOperationName(
/* 7149 */         new QName("http://soap.rpc.jira.atlassian.com", "deleteWorklogWithNewRemainingEstimate"));
/*      */     
/* 7151 */     setRequestHeaders(_call);
/* 7152 */     setAttachments(_call);
/*      */     try {
/* 7154 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 7156 */       if (_resp instanceof RemoteException) {
/* 7157 */         throw (RemoteException)_resp;
/*      */       }
/* 7159 */       extractAttachments(_call);
/* 7160 */     } catch (AxisFault axisFaultException) {
/* 7161 */       if (axisFaultException.detail != null) {
/* 7162 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7163 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7165 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7166 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7168 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7169 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7171 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7172 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7175 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deleteWorklogAndAutoAdjustRemainingEstimate(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException {
/* 7183 */     if (this.cachedEndpoint == null) {
/* 7184 */       throw new NoEndPointException();
/*      */     }
/* 7186 */     Call _call = createCall();
/* 7187 */     _call.setOperation(_operations[68]);
/* 7188 */     _call.setUseSOAPAction(true);
/* 7189 */     _call.setSOAPActionURI("");
/* 7190 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7191 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", 
/* 7192 */           "deleteWorklogAndAutoAdjustRemainingEstimate"));
/*      */     
/* 7194 */     setRequestHeaders(_call);
/* 7195 */     setAttachments(_call);
/*      */     try {
/* 7197 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 7199 */       if (_resp instanceof RemoteException) {
/* 7200 */         throw (RemoteException)_resp;
/*      */       }
/* 7202 */       extractAttachments(_call);
/* 7203 */     } catch (AxisFault axisFaultException) {
/* 7204 */       if (axisFaultException.detail != null) {
/* 7205 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7206 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7208 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7209 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7211 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7212 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7214 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7215 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7218 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deleteWorklogAndRetainRemainingEstimate(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException {
/* 7226 */     if (this.cachedEndpoint == null) {
/* 7227 */       throw new NoEndPointException();
/*      */     }
/* 7229 */     Call _call = createCall();
/* 7230 */     _call.setOperation(_operations[69]);
/* 7231 */     _call.setUseSOAPAction(true);
/* 7232 */     _call.setSOAPActionURI("");
/* 7233 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7234 */     _call.setOperationName(
/* 7235 */         new QName("http://soap.rpc.jira.atlassian.com", "deleteWorklogAndRetainRemainingEstimate"));
/*      */     
/* 7237 */     setRequestHeaders(_call);
/* 7238 */     setAttachments(_call);
/*      */     try {
/* 7240 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 7242 */       if (_resp instanceof RemoteException) {
/* 7243 */         throw (RemoteException)_resp;
/*      */       }
/* 7245 */       extractAttachments(_call);
/* 7246 */     } catch (AxisFault axisFaultException) {
/* 7247 */       if (axisFaultException.detail != null) {
/* 7248 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7249 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7251 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7252 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7254 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7255 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7257 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7258 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7261 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateWorklogWithNewRemainingEstimate(String in0, RemoteWorklog in1, String in2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException {
/* 7270 */     if (this.cachedEndpoint == null) {
/* 7271 */       throw new NoEndPointException();
/*      */     }
/* 7273 */     Call _call = createCall();
/* 7274 */     _call.setOperation(_operations[70]);
/* 7275 */     _call.setUseSOAPAction(true);
/* 7276 */     _call.setSOAPActionURI("");
/* 7277 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7278 */     _call.setOperationName(
/* 7279 */         new QName("http://soap.rpc.jira.atlassian.com", "updateWorklogWithNewRemainingEstimate"));
/*      */     
/* 7281 */     setRequestHeaders(_call);
/* 7282 */     setAttachments(_call);
/*      */     try {
/* 7284 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 7286 */       if (_resp instanceof RemoteException) {
/* 7287 */         throw (RemoteException)_resp;
/*      */       }
/* 7289 */       extractAttachments(_call);
/* 7290 */     } catch (AxisFault axisFaultException) {
/* 7291 */       if (axisFaultException.detail != null) {
/* 7292 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7293 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7295 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7296 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7298 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7299 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7301 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7302 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7305 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateWorklogAndAutoAdjustRemainingEstimate(String in0, RemoteWorklog in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException {
/* 7314 */     if (this.cachedEndpoint == null) {
/* 7315 */       throw new NoEndPointException();
/*      */     }
/* 7317 */     Call _call = createCall();
/* 7318 */     _call.setOperation(_operations[71]);
/* 7319 */     _call.setUseSOAPAction(true);
/* 7320 */     _call.setSOAPActionURI("");
/* 7321 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7322 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", 
/* 7323 */           "updateWorklogAndAutoAdjustRemainingEstimate"));
/*      */     
/* 7325 */     setRequestHeaders(_call);
/* 7326 */     setAttachments(_call);
/*      */     try {
/* 7328 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 7330 */       if (_resp instanceof RemoteException) {
/* 7331 */         throw (RemoteException)_resp;
/*      */       }
/* 7333 */       extractAttachments(_call);
/* 7334 */     } catch (AxisFault axisFaultException) {
/* 7335 */       if (axisFaultException.detail != null) {
/* 7336 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7337 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7339 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7340 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7342 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7343 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7345 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7346 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7349 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateWorklogAndRetainRemainingEstimate(String in0, RemoteWorklog in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException {
/* 7358 */     if (this.cachedEndpoint == null) {
/* 7359 */       throw new NoEndPointException();
/*      */     }
/* 7361 */     Call _call = createCall();
/* 7362 */     _call.setOperation(_operations[72]);
/* 7363 */     _call.setUseSOAPAction(true);
/* 7364 */     _call.setSOAPActionURI("");
/* 7365 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7366 */     _call.setOperationName(
/* 7367 */         new QName("http://soap.rpc.jira.atlassian.com", "updateWorklogAndRetainRemainingEstimate"));
/*      */     
/* 7369 */     setRequestHeaders(_call);
/* 7370 */     setAttachments(_call);
/*      */     try {
/* 7372 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 7374 */       if (_resp instanceof RemoteException) {
/* 7375 */         throw (RemoteException)_resp;
/*      */       }
/* 7377 */       extractAttachments(_call);
/* 7378 */     } catch (AxisFault axisFaultException) {
/* 7379 */       if (axisFaultException.detail != null) {
/* 7380 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7381 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7383 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7384 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7386 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7387 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7389 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7390 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7393 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteWorklog[] getWorklogs(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteException {
/* 7401 */     if (this.cachedEndpoint == null) {
/* 7402 */       throw new NoEndPointException();
/*      */     }
/* 7404 */     Call _call = createCall();
/* 7405 */     _call.setOperation(_operations[73]);
/* 7406 */     _call.setUseSOAPAction(true);
/* 7407 */     _call.setSOAPActionURI("");
/* 7408 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7409 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getWorklogs"));
/*      */     
/* 7411 */     setRequestHeaders(_call);
/* 7412 */     setAttachments(_call);
/*      */     try {
/* 7414 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 7416 */       if (_resp instanceof RemoteException) {
/* 7417 */         throw (RemoteException)_resp;
/*      */       }
/* 7419 */       extractAttachments(_call);
/*      */       try {
/* 7421 */         return (RemoteWorklog[])_resp;
/* 7422 */       } catch (Exception exception) {
/* 7423 */         return 
/* 7424 */           (RemoteWorklog[])JavaUtils.convert(_resp, RemoteWorklog[].class);
/*      */       }
/*      */     
/* 7427 */     } catch (AxisFault axisFaultException) {
/* 7428 */       if (axisFaultException.detail != null) {
/* 7429 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7430 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7432 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7433 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7435 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7436 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7438 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7439 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7442 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPermissionToCreateWorklog(String in0, String in1) throws RemoteException, RemoteValidationException, RemoteException {
/* 7449 */     if (this.cachedEndpoint == null) {
/* 7450 */       throw new NoEndPointException();
/*      */     }
/* 7452 */     Call _call = createCall();
/* 7453 */     _call.setOperation(_operations[74]);
/* 7454 */     _call.setUseSOAPAction(true);
/* 7455 */     _call.setSOAPActionURI("");
/* 7456 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7457 */     _call.setOperationName(
/* 7458 */         new QName("http://soap.rpc.jira.atlassian.com", "hasPermissionToCreateWorklog"));
/*      */     
/* 7460 */     setRequestHeaders(_call);
/* 7461 */     setAttachments(_call);
/*      */     try {
/* 7463 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 7465 */       if (_resp instanceof RemoteException) {
/* 7466 */         throw (RemoteException)_resp;
/*      */       }
/* 7468 */       extractAttachments(_call);
/*      */       try {
/* 7470 */         return ((Boolean)_resp).booleanValue();
/* 7471 */       } catch (Exception exception) {
/* 7472 */         return ((Boolean)JavaUtils.convert(_resp, boolean.class)).booleanValue();
/*      */       }
/*      */     
/* 7475 */     } catch (AxisFault axisFaultException) {
/* 7476 */       if (axisFaultException.detail != null) {
/* 7477 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7478 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7480 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7481 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7483 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7484 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7487 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPermissionToDeleteWorklog(String in0, String in1) throws RemoteException, RemoteValidationException, RemoteException {
/* 7494 */     if (this.cachedEndpoint == null) {
/* 7495 */       throw new NoEndPointException();
/*      */     }
/* 7497 */     Call _call = createCall();
/* 7498 */     _call.setOperation(_operations[75]);
/* 7499 */     _call.setUseSOAPAction(true);
/* 7500 */     _call.setSOAPActionURI("");
/* 7501 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7502 */     _call.setOperationName(
/* 7503 */         new QName("http://soap.rpc.jira.atlassian.com", "hasPermissionToDeleteWorklog"));
/*      */     
/* 7505 */     setRequestHeaders(_call);
/* 7506 */     setAttachments(_call);
/*      */     try {
/* 7508 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 7510 */       if (_resp instanceof RemoteException) {
/* 7511 */         throw (RemoteException)_resp;
/*      */       }
/* 7513 */       extractAttachments(_call);
/*      */       try {
/* 7515 */         return ((Boolean)_resp).booleanValue();
/* 7516 */       } catch (Exception exception) {
/* 7517 */         return ((Boolean)JavaUtils.convert(_resp, boolean.class)).booleanValue();
/*      */       }
/*      */     
/* 7520 */     } catch (AxisFault axisFaultException) {
/* 7521 */       if (axisFaultException.detail != null) {
/* 7522 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7523 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7525 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7526 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7528 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7529 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7532 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPermissionToUpdateWorklog(String in0, String in1) throws RemoteException, RemoteValidationException, RemoteException {
/* 7539 */     if (this.cachedEndpoint == null) {
/* 7540 */       throw new NoEndPointException();
/*      */     }
/* 7542 */     Call _call = createCall();
/* 7543 */     _call.setOperation(_operations[76]);
/* 7544 */     _call.setUseSOAPAction(true);
/* 7545 */     _call.setSOAPActionURI("");
/* 7546 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7547 */     _call.setOperationName(
/* 7548 */         new QName("http://soap.rpc.jira.atlassian.com", "hasPermissionToUpdateWorklog"));
/*      */     
/* 7550 */     setRequestHeaders(_call);
/* 7551 */     setAttachments(_call);
/*      */     try {
/* 7553 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 7555 */       if (_resp instanceof RemoteException) {
/* 7556 */         throw (RemoteException)_resp;
/*      */       }
/* 7558 */       extractAttachments(_call);
/*      */       try {
/* 7560 */         return ((Boolean)_resp).booleanValue();
/* 7561 */       } catch (Exception exception) {
/* 7562 */         return ((Boolean)JavaUtils.convert(_resp, boolean.class)).booleanValue();
/*      */       }
/*      */     
/* 7565 */     } catch (AxisFault axisFaultException) {
/* 7566 */       if (axisFaultException.detail != null) {
/* 7567 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7568 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7570 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7571 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7573 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7574 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7577 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteScheme[] getNotificationSchemes(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 7585 */     if (this.cachedEndpoint == null) {
/* 7586 */       throw new NoEndPointException();
/*      */     }
/* 7588 */     Call _call = createCall();
/* 7589 */     _call.setOperation(_operations[77]);
/* 7590 */     _call.setUseSOAPAction(true);
/* 7591 */     _call.setSOAPActionURI("");
/* 7592 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7593 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getNotificationSchemes"));
/*      */     
/* 7595 */     setRequestHeaders(_call);
/* 7596 */     setAttachments(_call);
/*      */     try {
/* 7598 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 7600 */       if (_resp instanceof RemoteException) {
/* 7601 */         throw (RemoteException)_resp;
/*      */       }
/* 7603 */       extractAttachments(_call);
/*      */       try {
/* 7605 */         return (RemoteScheme[])_resp;
/* 7606 */       } catch (Exception exception) {
/* 7607 */         return 
/* 7608 */           (RemoteScheme[])JavaUtils.convert(_resp, RemoteScheme[].class);
/*      */       }
/*      */     
/* 7611 */     } catch (AxisFault axisFaultException) {
/* 7612 */       if (axisFaultException.detail != null) {
/* 7613 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7614 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7616 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7617 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7619 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 7620 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 7622 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7623 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7626 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemotePermissionScheme[] getPermissionSchemes(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 7634 */     if (this.cachedEndpoint == null) {
/* 7635 */       throw new NoEndPointException();
/*      */     }
/* 7637 */     Call _call = createCall();
/* 7638 */     _call.setOperation(_operations[78]);
/* 7639 */     _call.setUseSOAPAction(true);
/* 7640 */     _call.setSOAPActionURI("");
/* 7641 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7642 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getPermissionSchemes"));
/*      */     
/* 7644 */     setRequestHeaders(_call);
/* 7645 */     setAttachments(_call);
/*      */     try {
/* 7647 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 7649 */       if (_resp instanceof RemoteException) {
/* 7650 */         throw (RemoteException)_resp;
/*      */       }
/* 7652 */       extractAttachments(_call);
/*      */       try {
/* 7654 */         return (RemotePermissionScheme[])_resp;
/* 7655 */       } catch (Exception exception) {
/* 7656 */         return 
/* 7657 */           (RemotePermissionScheme[])JavaUtils.convert(_resp, RemotePermissionScheme[].class);
/*      */       }
/*      */     
/* 7660 */     } catch (AxisFault axisFaultException) {
/* 7661 */       if (axisFaultException.detail != null) {
/* 7662 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7663 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7665 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7666 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7668 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 7669 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 7671 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7672 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7675 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemotePermissionScheme createPermissionScheme(String in0, String in1, String in2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 7685 */     if (this.cachedEndpoint == null) {
/* 7686 */       throw new NoEndPointException();
/*      */     }
/* 7688 */     Call _call = createCall();
/* 7689 */     _call.setOperation(_operations[79]);
/* 7690 */     _call.setUseSOAPAction(true);
/* 7691 */     _call.setSOAPActionURI("");
/* 7692 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7693 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "createPermissionScheme"));
/*      */     
/* 7695 */     setRequestHeaders(_call);
/* 7696 */     setAttachments(_call);
/*      */     try {
/* 7698 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 7700 */       if (_resp instanceof RemoteException) {
/* 7701 */         throw (RemoteException)_resp;
/*      */       }
/* 7703 */       extractAttachments(_call);
/*      */       try {
/* 7705 */         return (RemotePermissionScheme)_resp;
/* 7706 */       } catch (Exception exception) {
/* 7707 */         return 
/* 7708 */           (RemotePermissionScheme)JavaUtils.convert(_resp, RemotePermissionScheme.class);
/*      */       }
/*      */     
/* 7711 */     } catch (AxisFault axisFaultException) {
/* 7712 */       if (axisFaultException.detail != null) {
/* 7713 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7714 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7716 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7717 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7719 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7720 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7722 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 7723 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 7725 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7726 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7729 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deletePermissionScheme(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 7738 */     if (this.cachedEndpoint == null) {
/* 7739 */       throw new NoEndPointException();
/*      */     }
/* 7741 */     Call _call = createCall();
/* 7742 */     _call.setOperation(_operations[80]);
/* 7743 */     _call.setUseSOAPAction(true);
/* 7744 */     _call.setSOAPActionURI("");
/* 7745 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7746 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "deletePermissionScheme"));
/*      */     
/* 7748 */     setRequestHeaders(_call);
/* 7749 */     setAttachments(_call);
/*      */     try {
/* 7751 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 7753 */       if (_resp instanceof RemoteException) {
/* 7754 */         throw (RemoteException)_resp;
/*      */       }
/* 7756 */       extractAttachments(_call);
/* 7757 */     } catch (AxisFault axisFaultException) {
/* 7758 */       if (axisFaultException.detail != null) {
/* 7759 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7760 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7762 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7763 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7765 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7766 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7768 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 7769 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 7771 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7772 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7775 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemotePermissionScheme addPermissionTo(String in0, RemotePermissionScheme in1, RemotePermission in2, RemoteEntity in3) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 7787 */     if (this.cachedEndpoint == null) {
/* 7788 */       throw new NoEndPointException();
/*      */     }
/* 7790 */     Call _call = createCall();
/* 7791 */     _call.setOperation(_operations[81]);
/* 7792 */     _call.setUseSOAPAction(true);
/* 7793 */     _call.setSOAPActionURI("");
/* 7794 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7795 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "addPermissionTo"));
/*      */     
/* 7797 */     setRequestHeaders(_call);
/* 7798 */     setAttachments(_call);
/*      */     try {
/* 7800 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3 });
/*      */       
/* 7802 */       if (_resp instanceof RemoteException) {
/* 7803 */         throw (RemoteException)_resp;
/*      */       }
/* 7805 */       extractAttachments(_call);
/*      */       try {
/* 7807 */         return (RemotePermissionScheme)_resp;
/* 7808 */       } catch (Exception exception) {
/* 7809 */         return 
/* 7810 */           (RemotePermissionScheme)JavaUtils.convert(_resp, RemotePermissionScheme.class);
/*      */       }
/*      */     
/* 7813 */     } catch (AxisFault axisFaultException) {
/* 7814 */       if (axisFaultException.detail != null) {
/* 7815 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7816 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7818 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7819 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7821 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7822 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7824 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 7825 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 7827 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7828 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7831 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemotePermissionScheme deletePermissionFrom(String in0, RemotePermissionScheme in1, RemotePermission in2, RemoteEntity in3) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 7843 */     if (this.cachedEndpoint == null) {
/* 7844 */       throw new NoEndPointException();
/*      */     }
/* 7846 */     Call _call = createCall();
/* 7847 */     _call.setOperation(_operations[82]);
/* 7848 */     _call.setUseSOAPAction(true);
/* 7849 */     _call.setSOAPActionURI("");
/* 7850 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7851 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "deletePermissionFrom"));
/*      */     
/* 7853 */     setRequestHeaders(_call);
/* 7854 */     setAttachments(_call);
/*      */     try {
/* 7856 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3 });
/*      */       
/* 7858 */       if (_resp instanceof RemoteException) {
/* 7859 */         throw (RemoteException)_resp;
/*      */       }
/* 7861 */       extractAttachments(_call);
/*      */       try {
/* 7863 */         return (RemotePermissionScheme)_resp;
/* 7864 */       } catch (Exception exception) {
/* 7865 */         return 
/* 7866 */           (RemotePermissionScheme)JavaUtils.convert(_resp, RemotePermissionScheme.class);
/*      */       }
/*      */     
/* 7869 */     } catch (AxisFault axisFaultException) {
/* 7870 */       if (axisFaultException.detail != null) {
/* 7871 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7872 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7874 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7875 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7877 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 7878 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 7880 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 7881 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 7883 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7884 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7887 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemotePermission[] getAllPermissions(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 7895 */     if (this.cachedEndpoint == null) {
/* 7896 */       throw new NoEndPointException();
/*      */     }
/* 7898 */     Call _call = createCall();
/* 7899 */     _call.setOperation(_operations[83]);
/* 7900 */     _call.setUseSOAPAction(true);
/* 7901 */     _call.setSOAPActionURI("");
/* 7902 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7903 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getAllPermissions"));
/*      */     
/* 7905 */     setRequestHeaders(_call);
/* 7906 */     setAttachments(_call);
/*      */     try {
/* 7908 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 7910 */       if (_resp instanceof RemoteException) {
/* 7911 */         throw (RemoteException)_resp;
/*      */       }
/* 7913 */       extractAttachments(_call);
/*      */       try {
/* 7915 */         return (RemotePermission[])_resp;
/* 7916 */       } catch (Exception exception) {
/* 7917 */         return 
/* 7918 */           (RemotePermission[])JavaUtils.convert(_resp, RemotePermission[].class);
/*      */       }
/*      */     
/* 7921 */     } catch (AxisFault axisFaultException) {
/* 7922 */       if (axisFaultException.detail != null) {
/* 7923 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7924 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7926 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 7927 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 7929 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 7930 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 7932 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7933 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7936 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public long getIssueCountForFilter(String in0, String in1) throws RemoteException, RemoteException {
/* 7942 */     if (this.cachedEndpoint == null) {
/* 7943 */       throw new NoEndPointException();
/*      */     }
/* 7945 */     Call _call = createCall();
/* 7946 */     _call.setOperation(_operations[84]);
/* 7947 */     _call.setUseSOAPAction(true);
/* 7948 */     _call.setSOAPActionURI("");
/* 7949 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7950 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getIssueCountForFilter"));
/*      */     
/* 7952 */     setRequestHeaders(_call);
/* 7953 */     setAttachments(_call);
/*      */     try {
/* 7955 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 7957 */       if (_resp instanceof RemoteException) {
/* 7958 */         throw (RemoteException)_resp;
/*      */       }
/* 7960 */       extractAttachments(_call);
/*      */       try {
/* 7962 */         return ((Long)_resp).longValue();
/* 7963 */       } catch (Exception exception) {
/* 7964 */         return ((Long)JavaUtils.convert(_resp, long.class)).longValue();
/*      */       }
/*      */     
/* 7967 */     } catch (AxisFault axisFaultException) {
/* 7968 */       if (axisFaultException.detail != null) {
/* 7969 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7970 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 7972 */         if (axisFaultException.detail instanceof RemoteException) {
/* 7973 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 7976 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public RemoteIssue[] getIssuesFromTextSearch(String in0, String in1) throws RemoteException, RemoteException {
/* 7982 */     if (this.cachedEndpoint == null) {
/* 7983 */       throw new NoEndPointException();
/*      */     }
/* 7985 */     Call _call = createCall();
/* 7986 */     _call.setOperation(_operations[85]);
/* 7987 */     _call.setUseSOAPAction(true);
/* 7988 */     _call.setSOAPActionURI("");
/* 7989 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 7990 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getIssuesFromTextSearch"));
/*      */     
/* 7992 */     setRequestHeaders(_call);
/* 7993 */     setAttachments(_call);
/*      */     try {
/* 7995 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 7997 */       if (_resp instanceof RemoteException) {
/* 7998 */         throw (RemoteException)_resp;
/*      */       }
/* 8000 */       extractAttachments(_call);
/*      */       try {
/* 8002 */         return (RemoteIssue[])_resp;
/* 8003 */       } catch (Exception exception) {
/* 8004 */         return 
/* 8005 */           (RemoteIssue[])JavaUtils.convert(_resp, RemoteIssue[].class);
/*      */       }
/*      */     
/* 8008 */     } catch (AxisFault axisFaultException) {
/* 8009 */       if (axisFaultException.detail != null) {
/* 8010 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8011 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8013 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8014 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8017 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssue[] getIssuesFromTextSearchWithProject(String in0, String[] in1, String in2, int in3) throws RemoteException, RemoteException {
/* 8024 */     if (this.cachedEndpoint == null) {
/* 8025 */       throw new NoEndPointException();
/*      */     }
/* 8027 */     Call _call = createCall();
/* 8028 */     _call.setOperation(_operations[86]);
/* 8029 */     _call.setUseSOAPAction(true);
/* 8030 */     _call.setSOAPActionURI("");
/* 8031 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8032 */     _call.setOperationName(
/* 8033 */         new QName("http://soap.rpc.jira.atlassian.com", "getIssuesFromTextSearchWithProject"));
/*      */     
/* 8035 */     setRequestHeaders(_call);
/* 8036 */     setAttachments(_call);
/*      */     try {
/* 8038 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, new Integer(in3) });
/*      */       
/* 8040 */       if (_resp instanceof RemoteException) {
/* 8041 */         throw (RemoteException)_resp;
/*      */       }
/* 8043 */       extractAttachments(_call);
/*      */       try {
/* 8045 */         return (RemoteIssue[])_resp;
/* 8046 */       } catch (Exception exception) {
/* 8047 */         return 
/* 8048 */           (RemoteIssue[])JavaUtils.convert(_resp, RemoteIssue[].class);
/*      */       }
/*      */     
/* 8051 */     } catch (AxisFault axisFaultException) {
/* 8052 */       if (axisFaultException.detail != null) {
/* 8053 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8054 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8056 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8057 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8060 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deleteUser(String in0, String in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 8069 */     if (this.cachedEndpoint == null) {
/* 8070 */       throw new NoEndPointException();
/*      */     }
/* 8072 */     Call _call = createCall();
/* 8073 */     _call.setOperation(_operations[87]);
/* 8074 */     _call.setUseSOAPAction(true);
/* 8075 */     _call.setSOAPActionURI("");
/* 8076 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8077 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "deleteUser"));
/*      */     
/* 8079 */     setRequestHeaders(_call);
/* 8080 */     setAttachments(_call);
/*      */     try {
/* 8082 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 8084 */       if (_resp instanceof RemoteException) {
/* 8085 */         throw (RemoteException)_resp;
/*      */       }
/* 8087 */       extractAttachments(_call);
/* 8088 */     } catch (AxisFault axisFaultException) {
/* 8089 */       if (axisFaultException.detail != null) {
/* 8090 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8091 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8093 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 8094 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 8096 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 8097 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 8099 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 8100 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 8102 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8103 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8106 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteGroup updateGroup(String in0, RemoteGroup in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 8116 */     if (this.cachedEndpoint == null) {
/* 8117 */       throw new NoEndPointException();
/*      */     }
/* 8119 */     Call _call = createCall();
/* 8120 */     _call.setOperation(_operations[88]);
/* 8121 */     _call.setUseSOAPAction(true);
/* 8122 */     _call.setSOAPActionURI("");
/* 8123 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8124 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "updateGroup"));
/*      */     
/* 8126 */     setRequestHeaders(_call);
/* 8127 */     setAttachments(_call);
/*      */     try {
/* 8129 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 8131 */       if (_resp instanceof RemoteException) {
/* 8132 */         throw (RemoteException)_resp;
/*      */       }
/* 8134 */       extractAttachments(_call);
/*      */       try {
/* 8136 */         return (RemoteGroup)_resp;
/* 8137 */       } catch (Exception exception) {
/* 8138 */         return 
/* 8139 */           (RemoteGroup)JavaUtils.convert(_resp, RemoteGroup.class);
/*      */       }
/*      */     
/* 8142 */     } catch (AxisFault axisFaultException) {
/* 8143 */       if (axisFaultException.detail != null) {
/* 8144 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8145 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8147 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 8148 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 8150 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 8151 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 8153 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 8154 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 8156 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8157 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8160 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deleteGroup(String in0, String in1, String in2) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 8169 */     if (this.cachedEndpoint == null) {
/* 8170 */       throw new NoEndPointException();
/*      */     }
/* 8172 */     Call _call = createCall();
/* 8173 */     _call.setOperation(_operations[89]);
/* 8174 */     _call.setUseSOAPAction(true);
/* 8175 */     _call.setSOAPActionURI("");
/* 8176 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8177 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "deleteGroup"));
/*      */     
/* 8179 */     setRequestHeaders(_call);
/* 8180 */     setAttachments(_call);
/*      */     try {
/* 8182 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 8184 */       if (_resp instanceof RemoteException) {
/* 8185 */         throw (RemoteException)_resp;
/*      */       }
/* 8187 */       extractAttachments(_call);
/* 8188 */     } catch (AxisFault axisFaultException) {
/* 8189 */       if (axisFaultException.detail != null) {
/* 8190 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8191 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8193 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 8194 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 8196 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 8197 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 8199 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 8200 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 8202 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8203 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8206 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void refreshCustomFields(String in0) throws RemoteException, RemoteException {
/* 8212 */     if (this.cachedEndpoint == null) {
/* 8213 */       throw new NoEndPointException();
/*      */     }
/* 8215 */     Call _call = createCall();
/* 8216 */     _call.setOperation(_operations[90]);
/* 8217 */     _call.setUseSOAPAction(true);
/* 8218 */     _call.setSOAPActionURI("");
/* 8219 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8220 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "refreshCustomFields"));
/*      */     
/* 8222 */     setRequestHeaders(_call);
/* 8223 */     setAttachments(_call);
/*      */     try {
/* 8225 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 8227 */       if (_resp instanceof RemoteException) {
/* 8228 */         throw (RemoteException)_resp;
/*      */       }
/* 8230 */       extractAttachments(_call);
/* 8231 */     } catch (AxisFault axisFaultException) {
/* 8232 */       if (axisFaultException.detail != null) {
/* 8233 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8234 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8236 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8237 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8240 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteProject[] getProjectsNoSchemes(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 8248 */     if (this.cachedEndpoint == null) {
/* 8249 */       throw new NoEndPointException();
/*      */     }
/* 8251 */     Call _call = createCall();
/* 8252 */     _call.setOperation(_operations[91]);
/* 8253 */     _call.setUseSOAPAction(true);
/* 8254 */     _call.setSOAPActionURI("");
/* 8255 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8256 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getProjectsNoSchemes"));
/*      */     
/* 8258 */     setRequestHeaders(_call);
/* 8259 */     setAttachments(_call);
/*      */     try {
/* 8261 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 8263 */       if (_resp instanceof RemoteException) {
/* 8264 */         throw (RemoteException)_resp;
/*      */       }
/* 8266 */       extractAttachments(_call);
/*      */       try {
/* 8268 */         return (RemoteProject[])_resp;
/* 8269 */       } catch (Exception exception) {
/* 8270 */         return 
/* 8271 */           (RemoteProject[])JavaUtils.convert(_resp, RemoteProject[].class);
/*      */       }
/*      */     
/* 8274 */     } catch (AxisFault axisFaultException) {
/* 8275 */       if (axisFaultException.detail != null) {
/* 8276 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8277 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8279 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 8280 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 8282 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 8283 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 8285 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8286 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8289 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteVersion addVersion(String in0, String in1, RemoteVersion in2) throws RemoteException, RemoteException {
/* 8296 */     if (this.cachedEndpoint == null) {
/* 8297 */       throw new NoEndPointException();
/*      */     }
/* 8299 */     Call _call = createCall();
/* 8300 */     _call.setOperation(_operations[92]);
/* 8301 */     _call.setUseSOAPAction(true);
/* 8302 */     _call.setSOAPActionURI("");
/* 8303 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8304 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "addVersion"));
/*      */     
/* 8306 */     setRequestHeaders(_call);
/* 8307 */     setAttachments(_call);
/*      */     try {
/* 8309 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2 });
/*      */       
/* 8311 */       if (_resp instanceof RemoteException) {
/* 8312 */         throw (RemoteException)_resp;
/*      */       }
/* 8314 */       extractAttachments(_call);
/*      */       try {
/* 8316 */         return (RemoteVersion)_resp;
/* 8317 */       } catch (Exception exception) {
/* 8318 */         return 
/* 8319 */           (RemoteVersion)JavaUtils.convert(_resp, RemoteVersion.class);
/*      */       }
/*      */     
/* 8322 */     } catch (AxisFault axisFaultException) {
/* 8323 */       if (axisFaultException.detail != null) {
/* 8324 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8325 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8327 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8328 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8331 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteFilter[] getSavedFilters(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 8339 */     if (this.cachedEndpoint == null) {
/* 8340 */       throw new NoEndPointException();
/*      */     }
/* 8342 */     Call _call = createCall();
/* 8343 */     _call.setOperation(_operations[93]);
/* 8344 */     _call.setUseSOAPAction(true);
/* 8345 */     _call.setSOAPActionURI("");
/* 8346 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8347 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getSavedFilters"));
/*      */     
/* 8349 */     setRequestHeaders(_call);
/* 8350 */     setAttachments(_call);
/*      */     try {
/* 8352 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 8354 */       if (_resp instanceof RemoteException) {
/* 8355 */         throw (RemoteException)_resp;
/*      */       }
/* 8357 */       extractAttachments(_call);
/*      */       try {
/* 8359 */         return (RemoteFilter[])_resp;
/* 8360 */       } catch (Exception exception) {
/* 8361 */         return 
/* 8362 */           (RemoteFilter[])JavaUtils.convert(_resp, RemoteFilter[].class);
/*      */       }
/*      */     
/* 8365 */     } catch (AxisFault axisFaultException) {
/* 8366 */       if (axisFaultException.detail != null) {
/* 8367 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8368 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8370 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 8371 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 8373 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 8374 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 8376 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8377 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8380 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addBase64EncodedAttachmentsToIssue(String in0, String in1, String[] in2, String[] in3) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 8390 */     if (this.cachedEndpoint == null) {
/* 8391 */       throw new NoEndPointException();
/*      */     }
/* 8393 */     Call _call = createCall();
/* 8394 */     _call.setOperation(_operations[94]);
/* 8395 */     _call.setUseSOAPAction(true);
/* 8396 */     _call.setSOAPActionURI("");
/* 8397 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8398 */     _call.setOperationName(
/* 8399 */         new QName("http://soap.rpc.jira.atlassian.com", "addBase64EncodedAttachmentsToIssue"));
/*      */     
/* 8401 */     setRequestHeaders(_call);
/* 8402 */     setAttachments(_call);
/*      */     try {
/* 8404 */       Object _resp = _call.invoke(new Object[] { in0, in1, in2, in3 });
/*      */       
/* 8406 */       if (_resp instanceof RemoteException) {
/* 8407 */         throw (RemoteException)_resp;
/*      */       }
/* 8409 */       extractAttachments(_call);
/*      */       try {
/* 8411 */         return ((Boolean)_resp).booleanValue();
/* 8412 */       } catch (Exception exception) {
/* 8413 */         return ((Boolean)JavaUtils.convert(_resp, boolean.class)).booleanValue();
/*      */       }
/*      */     
/* 8416 */     } catch (AxisFault axisFaultException) {
/* 8417 */       if (axisFaultException.detail != null) {
/* 8418 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8419 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8421 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 8422 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 8424 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 8425 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 8427 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 8428 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 8430 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8431 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8434 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteProject createProjectFromObject(String in0, RemoteProject in1) throws RemoteException, RemotePermissionException, RemoteValidationException, RemoteAuthenticationException, RemoteException {
/* 8444 */     if (this.cachedEndpoint == null) {
/* 8445 */       throw new NoEndPointException();
/*      */     }
/* 8447 */     Call _call = createCall();
/* 8448 */     _call.setOperation(_operations[95]);
/* 8449 */     _call.setUseSOAPAction(true);
/* 8450 */     _call.setSOAPActionURI("");
/* 8451 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8452 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "createProjectFromObject"));
/*      */     
/* 8454 */     setRequestHeaders(_call);
/* 8455 */     setAttachments(_call);
/*      */     try {
/* 8457 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 8459 */       if (_resp instanceof RemoteException) {
/* 8460 */         throw (RemoteException)_resp;
/*      */       }
/* 8462 */       extractAttachments(_call);
/*      */       try {
/* 8464 */         return (RemoteProject)_resp;
/* 8465 */       } catch (Exception exception) {
/* 8466 */         return 
/* 8467 */           (RemoteProject)JavaUtils.convert(_resp, RemoteProject.class);
/*      */       }
/*      */     
/* 8470 */     } catch (AxisFault axisFaultException) {
/* 8471 */       if (axisFaultException.detail != null) {
/* 8472 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8473 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8475 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 8476 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 8478 */         if (axisFaultException.detail instanceof RemoteValidationException) {
/* 8479 */           throw (RemoteValidationException)axisFaultException.detail;
/*      */         }
/* 8481 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 8482 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 8484 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8485 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8488 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteScheme[] getSecuritySchemes(String in0) throws RemoteException, RemotePermissionException, RemoteAuthenticationException, RemoteException {
/* 8496 */     if (this.cachedEndpoint == null) {
/* 8497 */       throw new NoEndPointException();
/*      */     }
/* 8499 */     Call _call = createCall();
/* 8500 */     _call.setOperation(_operations[96]);
/* 8501 */     _call.setUseSOAPAction(true);
/* 8502 */     _call.setSOAPActionURI("");
/* 8503 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8504 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getSecuritySchemes"));
/*      */     
/* 8506 */     setRequestHeaders(_call);
/* 8507 */     setAttachments(_call);
/*      */     try {
/* 8509 */       Object _resp = _call.invoke(new Object[] { in0 });
/*      */       
/* 8511 */       if (_resp instanceof RemoteException) {
/* 8512 */         throw (RemoteException)_resp;
/*      */       }
/* 8514 */       extractAttachments(_call);
/*      */       try {
/* 8516 */         return (RemoteScheme[])_resp;
/* 8517 */       } catch (Exception exception) {
/* 8518 */         return 
/* 8519 */           (RemoteScheme[])JavaUtils.convert(_resp, RemoteScheme[].class);
/*      */       }
/*      */     
/* 8522 */     } catch (AxisFault axisFaultException) {
/* 8523 */       if (axisFaultException.detail != null) {
/* 8524 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8525 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8527 */         if (axisFaultException.detail instanceof RemotePermissionException) {
/* 8528 */           throw (RemotePermissionException)axisFaultException.detail;
/*      */         }
/* 8530 */         if (axisFaultException.detail instanceof RemoteAuthenticationException) {
/* 8531 */           throw (RemoteAuthenticationException)axisFaultException.detail;
/*      */         }
/* 8533 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8534 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8537 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public RemoteIssue[] getIssuesFromFilter(String in0, String in1) throws RemoteException, RemoteException {
/* 8543 */     if (this.cachedEndpoint == null) {
/* 8544 */       throw new NoEndPointException();
/*      */     }
/* 8546 */     Call _call = createCall();
/* 8547 */     _call.setOperation(_operations[97]);
/* 8548 */     _call.setUseSOAPAction(true);
/* 8549 */     _call.setSOAPActionURI("");
/* 8550 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8551 */     _call.setOperationName(new QName("http://soap.rpc.jira.atlassian.com", "getIssuesFromFilter"));
/*      */     
/* 8553 */     setRequestHeaders(_call);
/* 8554 */     setAttachments(_call);
/*      */     try {
/* 8556 */       Object _resp = _call.invoke(new Object[] { in0, in1 });
/*      */       
/* 8558 */       if (_resp instanceof RemoteException) {
/* 8559 */         throw (RemoteException)_resp;
/*      */       }
/* 8561 */       extractAttachments(_call);
/*      */       try {
/* 8563 */         return (RemoteIssue[])_resp;
/* 8564 */       } catch (Exception exception) {
/* 8565 */         return 
/* 8566 */           (RemoteIssue[])JavaUtils.convert(_resp, RemoteIssue[].class);
/*      */       }
/*      */     
/* 8569 */     } catch (AxisFault axisFaultException) {
/* 8570 */       if (axisFaultException.detail != null) {
/* 8571 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8572 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8574 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8575 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8578 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssue[] getIssuesFromFilterWithLimit(String in0, String in1, int in2, int in3) throws RemoteException, RemoteException {
/* 8585 */     if (this.cachedEndpoint == null) {
/* 8586 */       throw new NoEndPointException();
/*      */     }
/* 8588 */     Call _call = createCall();
/* 8589 */     _call.setOperation(_operations[98]);
/* 8590 */     _call.setUseSOAPAction(true);
/* 8591 */     _call.setSOAPActionURI("");
/* 8592 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8593 */     _call.setOperationName(
/* 8594 */         new QName("http://soap.rpc.jira.atlassian.com", "getIssuesFromFilterWithLimit"));
/*      */     
/* 8596 */     setRequestHeaders(_call);
/* 8597 */     setAttachments(_call);
/*      */     try {
/* 8599 */       Object _resp = _call
/* 8600 */         .invoke(new Object[] { in0, in1, new Integer(in2), new Integer(in3) });
/*      */       
/* 8602 */       if (_resp instanceof RemoteException) {
/* 8603 */         throw (RemoteException)_resp;
/*      */       }
/* 8605 */       extractAttachments(_call);
/*      */       try {
/* 8607 */         return (RemoteIssue[])_resp;
/* 8608 */       } catch (Exception exception) {
/* 8609 */         return 
/* 8610 */           (RemoteIssue[])JavaUtils.convert(_resp, RemoteIssue[].class);
/*      */       }
/*      */     
/* 8613 */     } catch (AxisFault axisFaultException) {
/* 8614 */       if (axisFaultException.detail != null) {
/* 8615 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8616 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8618 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8619 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8622 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public RemoteIssue[] getIssuesFromTextSearchWithLimit(String in0, String in1, int in2, int in3) throws RemoteException, RemoteException {
/* 8629 */     if (this.cachedEndpoint == null) {
/* 8630 */       throw new NoEndPointException();
/*      */     }
/* 8632 */     Call _call = createCall();
/* 8633 */     _call.setOperation(_operations[99]);
/* 8634 */     _call.setUseSOAPAction(true);
/* 8635 */     _call.setSOAPActionURI("");
/* 8636 */     _call.setSOAPVersion((SOAPConstants)SOAPConstants.SOAP11_CONSTANTS);
/* 8637 */     _call.setOperationName(
/* 8638 */         new QName("http://soap.rpc.jira.atlassian.com", "getIssuesFromTextSearchWithLimit"));
/*      */     
/* 8640 */     setRequestHeaders(_call);
/* 8641 */     setAttachments(_call);
/*      */     try {
/* 8643 */       Object _resp = _call
/* 8644 */         .invoke(new Object[] { in0, in1, new Integer(in2), new Integer(in3) });
/*      */       
/* 8646 */       if (_resp instanceof RemoteException) {
/* 8647 */         throw (RemoteException)_resp;
/*      */       }
/* 8649 */       extractAttachments(_call);
/*      */       try {
/* 8651 */         return (RemoteIssue[])_resp;
/* 8652 */       } catch (Exception exception) {
/* 8653 */         return 
/* 8654 */           (RemoteIssue[])JavaUtils.convert(_resp, RemoteIssue[].class);
/*      */       }
/*      */     
/* 8657 */     } catch (AxisFault axisFaultException) {
/* 8658 */       if (axisFaultException.detail != null) {
/* 8659 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8660 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/* 8662 */         if (axisFaultException.detail instanceof RemoteException) {
/* 8663 */           throw (RemoteException)axisFaultException.detail;
/*      */         }
/*      */       } 
/* 8666 */       throw axisFaultException;
/*      */     } 
/*      */   }
/*      */ }


/* Location:              E:\cygwin64\tmp\com.atlassian.connector.commons_4.0.0.v20150427.jar!\com\atlassian\connector\commons\jira\soap\axis\JirasoapserviceV2SoapBindingStub.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */