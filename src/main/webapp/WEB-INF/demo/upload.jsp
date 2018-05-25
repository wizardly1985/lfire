<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="http://upcdn.b0.upaiyun.com/libs/jquery/jquery-2.0.2.min.js">
	
</script>
<script type="text/javascript">
	$(document).ready(
			function() {

				$("#file_upload").change(
						function() {
							alert("文件上传");
							var files = $("#file_upload").prop("files");
							var d = new FormData();
							d.append("file", files[0]);
							
							$.ajax({
								url : "demo!upload.action",
								type : "POST",
								cache : false,
								data : d,
								processData : false,
								contentType : false,
								success : function(data) {
									alert("文件上传回调");
								}
							});
						});

			});
</script>
</head>
<body>
	<form id="uploadForm" enctype="multipart/form-data">
		<!-- 声明文件上传 -->
		<input id="file_upload" type="file" name="pic" />
		<!-- 定义change事件,选择文件后触发 -->
		<input type="hidden" name="modelName" value="famoxuke" />
		<!-- 项目需求字段,非必须 -->
		<br /> <span style="color: red" id="fileTypeError"></span>
		<!-- 文件类型错误回显,此处通过前后端两次验证文件类型 -->
	</form>
</body>
</html>