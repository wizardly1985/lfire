<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- shiro头引入 -->
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shrio</title>
<script
	src="http://upcdn.b0.upaiyun.com/libs/jquery/jquery-2.0.2.min.js">
</script>
<script type="text/javascript">
$(document).ready(function() {

	$("#submit").click(function() {
		
		alert("提交");
		$.post("demo!shrio.action", {
			username:$("#username").val(),
			pwd:$("#pwd").val(),
		}, function(data, status) {
			
		});
	});
	
});
</script>
</head>
<body>
	<!-- 有curd权限才显示修改链接，没有该 权限不显示，相当 于if(hasPermission(curd)) -->
	<shiro:hasPermission name="curd">
		<BR />  
                    I have super right!!
                </shiro:hasPermission>
     <from id = "login">
     <table>
     <tr>
     	<td>
     	用户名：
     	</td>
     	<td>
     	<input type="text" id = "username"></input>
     	</td>
     </tr>
     <tr>
     	<td>
     	密码：
     	</td>
     	<td>
     	<input type="text" id = "pwd"></input>
     	</td>
     </tr>
     <tr>
     	<td>
     	
     	</td>
     	<td>
     	<input type="submit" id ="submit" value = "登陆"></input>
     	</td>
     </tr>
     </table>
     </from>
     <shiro:principal />
     <shiro:hasRole name="role">
     		当前的角色是role
     </shiro:hasRole>
     <shiro:hasPermission name="permission">
     		当前的权限是role
     </shiro:hasPermission>
</body>
</html>