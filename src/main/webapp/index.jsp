<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<link rel="stylesheet" href="zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">

<script type="text/javascript" src="zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="zTree/js/jquery.ztree.core.js"></script>
<SCRIPT LANGUAGE="JavaScript">
	var zTreeObj;
	// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
	var setting = {};
	// zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
	var zNodes = [ {
		name : "test1",
		open : true,
		children : [ {
			name : "test1_1"
		}, {
			name : "test1_2"
		} ]
	}, {
		name : "test2",
		open : true,
		children : [ {
			name : "test2_1"
		}, {
			name : "test2_2"
		} ]
	} ];
	$(document).ready(function() {
		zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
</SCRIPT>
</head>
<body>
	<h1>
		<a href="demo!demoAll.action">跳转到demo</a>
	</h1>
	<h3>技术方案</h3>
	<p>
	<h4>后台技术:</h4>
	</br> 工作流引擎：Activiti 5.21.0
	</br> ORM框架：Hibernate 4.1.3.Final
	</br> Web框架：Struts 2.3.16.3
	</br> 核心框架：Spring 3.1.2.RELEASE
	</br> 任务调度：Spring Task
	</br> 权限安全：Apache Shiro
	</br> 全文搜索引擎：---------
	</br> 页面静态化处理：--------
	</br> 服务器页面包含技术：-----
	</br> 网页即时通讯：websocket
	</br> 连接池：-------------
	</br> 日志处理：------------
	</br> 缓存处理：------------
	</br> Excel表处理：---------
	</br>
	</p>
	<p>
	<h4>前端技术:</h4>
	</br> 文件上传：JQuery
	</br> 树形结构：zTree
	</br> 日期插件：-------
	</br> 弹窗框架：-------
	</br> Cookie保存：-----
	</br> 富文本编辑器：------
	</br> 前端框架：---------
	</br>
	</p>
	<p>
	<h4>服务器:</h4>
	</br> 负载均衡：Nginx
	</br> 分布式：alibaba Dubbo
	</br> 中间件：RocketMQ
	</br>
	</p>
	<p>
	<h4>项目测试:</h4>
	</br> DeBug：Junit、FindBugs、EclEmma
	</br> 程序质量：Jdepend4eclipse
	</br> 压力测试：JMeter
	</br>
	</p>
	<p>
	<h4>工具软件:</h4>
	</br> 服务器：SecureCRT
	</br> Java：IntelliJ IDEA/Eclipse
	</br> 远程控制：TeamViewer
	</br> 版本控制：Git
	</br> Jar管理：Maven
	</br> UML建模：ArgoUML
	</br> Eclipse测试插件：EclEmma
	</br> 程序质量检查插件：Jdepend4eclipse(Eclipse平台)
	</br>
	</p>
	
</body>
</html>