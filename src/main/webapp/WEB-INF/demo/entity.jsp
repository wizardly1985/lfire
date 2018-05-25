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
<script
	src="http://upcdn.b0.upaiyun.com/libs/jquery/jquery-2.0.2.min.js">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#query").click(function() {
			if ($("#id").val() == "") {
				alert("输入不能为空");
				return;
			}

			$.post("demo!showEntity.action", {
				eid : $("#id").val(),
			}, function(data, status) {
				var jsondatas=eval("("+data+")"); 
				$("#eid").text(jsondatas.data.id);
				$("#bl").text(jsondatas.data.bl);
				$("#b").text(jsondatas.data.b);
				$("#s").text(jsondatas.data.s);
				$("#c").text(jsondatas.data.c);
				$("#i").text(jsondatas.data.i);
				$("#f").text(jsondatas.data.f);
				$("#l").text(jsondatas.data.l);
				$("#d").text(jsondatas.data.d);
				$("#str").text(jsondatas.data.str);
				$("#date").text(jsondatas.data.date);
				$("#dept").find("option[text='"+jsondatas.data.dept+"']").attr("selected",true);
				if(jsondatas.data.sex == "W"){
					$("#w").attr("checked", true);
				}else{
					$("#m").attr("checked", true);
				}
			});
		});
		$("#del").click(function() {
			if ($("#id").val() == "") {
				alert("输入不能为空");
				return;
			}
			$.post("demo!delEntity.action", {
				eid : $("#id").val(),
			}, function(data, status) {
			});
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	id:
	<input type="text" id="id">
	<input type="button" id="query">查询
	</input>
	<input type="button" id="del">删除
	</input>
	<table border="1">
		<tr>
			<td>id</td>
			<td id = "eid">${e.id}</td>
		</tr>
		<tr>
			<td>布尔型</td>
			<td id = "bl">${e.bl}</td>
		</tr>
		<tr>
			<td>字节型</td>
			<td id = "b">${e.b}</td>
		</tr>
		<tr>
			<td>短整型</td>
			<td id = "s">${e.s}</td>
		</tr>
		<tr>
			<td>字符型</td>
			<td id = "c">${e.c}</td>
		</tr>
		<tr>
			<td>整数型</td>
			<td id = "i">${e.i}</td>
		</tr>
		<tr>
			<td>浮点型</td>
			<td id = "f">${e.f}</td>
		</tr>
		<tr>
			<td>长整型</td>
			<td id = "l">${e.l}</td>
		</tr>
		<tr>
			<td>双精度型</td>
			<td id = "d">${e.d}</td>
		</tr>
		<tr>
			<td>字符串型</td>
			<td id ="str">${e.str}</td>
		</tr>
		<tr>
			<td>日期型</td>
			<td id="date">${e.date}</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>男性： <input type="radio" checked="checked" name="Sex" id="m"
				value="male" /> 女性： <input type="radio" name="Sex" id="w" value="female" />
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
</body>
</html>