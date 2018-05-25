<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zTree</title>
<link rel="stylesheet" href="zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">

<script type="text/javascript" src="zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="zTree/js/jquery.ztree.core.js"></script>
<SCRIPT LANGUAGE="JavaScript">
	var zTreeObj;
	var zTreeDateObj;
	// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
	var setting = {};
	// zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
	var zNodes = [ {
		name : "test1",
		open : true,
		children : [ {
			name : "test1_1",
			open : true,
			children : [ {
				name : "test1_1_1"
			} ]
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
	var zDateNodes = "";
	jQuery.fn.getTreeDate = function() {
		$.post("demo!listType.action", {

		}, function(data, status) {
			alert(data);
			var jsondatas = eval("(" + data + ")");
			
		});
	};
	$(document).ready(function() {
		zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
		$().getTreeDate();
		zTreeDateObj = $.fn.zTree.init($("#treeDate"), setting, zDateNodes);
	});
</SCRIPT>
</head>
<body>
	-------
	<div>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	---treedate----
	<div>
		<ul id="treeDate" class="ztree"></ul>
	</div>
</body>
</html>