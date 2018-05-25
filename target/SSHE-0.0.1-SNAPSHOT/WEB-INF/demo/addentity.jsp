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
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script>
	var sex = "";
	jQuery.fn.initWeb = function(){
		$().initDept();
    };
    jQuery.fn.initDept = function(){
		$.post("demo!listDept.action", {
			
		}, function(data, status) {
			var jsondatas = eval("(" + data + ")");
			$.each(jsondatas.data, function(idx, obj) {
				var s = "";
				s = "<option value='"+obj.name+"'>"+obj.name+"</option>";
				$("#dept").append(s);
			});
		});
    };
	
	$(document).ready(function() {
		$().initWeb();
		$("#date").datepicker();
		$("#date").datepicker("option", "dateFormat", "yy-mm-dd");
		$("#w").click(function() {
			sex = "W";
		});
		$("#m").click(function() {
			sex = "M";
		});
		$("#query").click(function() {
			if ($("#id").val() == "") {
				alert("输入不能为空");
				return;
			}
			$.post("demo!showEntity.action", {
				id : $("#id").val(),
			}, function(data, status) {
			});
		});
		$("#del").click(function() {
			if ($("#id").val() == "") {
				alert("输入不能为空");
				return;
			}
			$.post("demo!delEntity.action", {
				id : $("#id").val(),
			}, function(data, status) {
			});
		});
		$("#submit").click(function() {
			alert("tinajia");
			$.post("demo!addEntity.action", {
				id : $("#id").val(),
				bl : $("#bl").val(),
				b : $("#b").val(),
				s : $("#s").val(),
				c : $("#c").val(),
				i : $("#i").val(),
				f : $("#f").val(),
				l : $("#l").val(),
				d : $("#d").val(),
				str : $("#str").val(),
				sex : sex,
				date : $("#data").val(),
				name : $("#dept").val(),
			}, function(data, status) {
				alert("tinajia");
			});
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 
<form name="input" action="demo!showEntity.action" method="get">
id: <input type="text" name="id" id="id">
<input type="submit" value="查询" id="query">
<input type="submit" value="删除" id="del">
</form>
 -->
	<form name="input">
		id: <input type="text" name="id" id="id"> <input type="submit"
			value="查询" id="query">
	</form>
	<from name="upload">

	<table border="1">
		<tr>
			<td>id</td>
			<td><input type="text" id="id"></td>
		</tr>
		<tr>
			<td>布尔型</td>
			<td><input type="text" id="bl" value="${e.bl}"></input></td>
		</tr>
		<tr>
			<td>字节型</td>
			<td><input type="text" id="b" value="${e.b}"></input></td>
		</tr>
		<tr>
			<td>短整型</td>
			<td><input type="text" id="s" value="${e.s}"></input></td>
		</tr>
		<tr>
			<td>字符型</td>
			<td><input type="text" id="c" value="${e.c}"></input></td>
		</tr>
		<tr>
			<td>整数型</td>
			<td><input type="text" id="i" name="i" value="${e.i}"></input></td>
		</tr>
		<tr>
			<td>浮点型</td>
			<td><input type="text" id="f" value="${e.f}"></input></td>
		</tr>
		<tr>
			<td>长整型</td>
			<td><input type="text" id="l" value="${e.l}"></input></td>
		</tr>
		<tr>
			<td>双精度型</td>
			<td><input type="text" id="d" value="${e.d}"></input></td>
		</tr>
		<tr>
			<td>字符串型</td>
			<td><input type="text" id="str" value="${e.str}"></input></td>
		</tr>
		<tr>
			<td>日期型</td>
			<td><input type="text" id="date" value="${e.date}"></input></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="button" value="提交" id="submit"></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>男性： <input type="radio" checked="checked" name="Sex" id="m"
				value="male" /> 女性： <input type="radio" name="Sex" id="w"
				value="female" />
			</td>
		</tr>
		<tr>
			<td>爱好：</td>
			<td>旅游： <input type="checkbox" name="Bike"> 健身： <input
				type="checkbox" name="Car"></td>
		</tr>
		<tr>
			<td>部门：</td>
			<td><select id="dept">
					<option value="volvo">Volvo</option>
					<option value="saab">Saab</option>
					<option value="fiat">Fiat</option>
					<option value="audi">Audi</option>
			</select></td>
		</tr>
	</table>

	</from>

</body>
</html>