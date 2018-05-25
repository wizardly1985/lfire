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
<script
	src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	var pageno = 0;
	var pagesize = 5;
	$(document).ready(
			function() {
				$("#next").click(
						function() {
							if ($("#id").val() == "") {
								alert("输入不能为空");
								return;
							}
							$.post("demo!listEntity.action", {
								pageNo : pageno,
								size : pagesize,
							}, function(data, status) {
								$("#tb  tr:not(:first)").empty("");
								var jsondatas = eval("(" + data + ")");
								$.each(jsondatas.data, function(idx, obj) {
									var s = "";
									s = "<tr><td>" + obj.id + "</td><td>"
											+ obj.bl + "</td><td>"
											+ obj.b + "</td><td>"
											+ obj.c + "</td><td>"
											+ obj.s + "</td><td>"
											+ obj.i + "</td><td>"
											+ obj.f + "</td><td>"
											+ obj.l + "</td><td>"
											+ obj.d + "</td><td>"
											+ obj.str + "</td><td>"
											+ obj.date + "</td><td>"
											+ obj.likes + "</td></tr>";
									$("#tb").append(s);
									$("#tb").attr("border",2)
								});
								pageno++;
							});
						});

			});
</script>
<title>Insert title here</title>
</head>
<body>
	<table border="2" id="tb">
		<tr>
			
			<td>id</td>
			<td>布尔</td>
			<td>字节</td>
			<td>短整</td>
			<td>字符</td>
			<td>整数</td>
			<td>浮点</td>
			<td>长整</td>
			<td>双精度</td>
			<td>字符串</td>
			<td>日期</td>
			<td>爱好</td>
		</tr>
		<a id="next">下一页</a>
	</table>
</body>
</html>