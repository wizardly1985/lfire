<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>demo</title>
</head>
<body>
<table border="2" >
 <tr>
        <td>编号</td>
        <td>项目</td>
        <td>jsp</td>
        <td>备注</td>
        <td>完成情况</td>
    </tr>
    <tr>
        <td>00，00，00，01</td>
        <td>实体类</td>
        <td><a href = "demo!gotoEntity.action">entity.jsp</a></td>
        <td>实体类各类型的变量的定义，显示,查询，删除</td>
        <td>删除正常的，需要加异常的处理。查询能查到</td>
    </tr>
    <tr>
        <td>00，00，00，02</td>
        <td>实体类</td>
        <td><a href = "demo!gotoAdd.action">addentity.jsp</a></td>
        <td>实体类添加</td>
        <td></td>
    </tr>
    <tr>
        <td>00，00，00，02</td>
        <td>实体类</td>
        <td><a href = "demo!uploadEntity.action">uploadentity.jsp</a></td>
        <td>实体类gengai</td>
        <td></td>
    </tr>
    <tr>
        <td>00，00，00，03</td>
        <td>实体类</td>
        <td><a href = "demo!gotoListEntity.action">listentity.jsp</a></td>
        <td>实体类列表</td>
        <td></td>
    </tr>
    <tr>
        <td>00，00，00，04</td>
        <td>实体类</td>
        <td><a href = "demo!gotoEntity.action">entity.jsp</a></td>
        <td>添加常用的控件</td>
        <td></td>
    </tr>
    <tr>
        <td>00，00，00，04</td>
        <td>文件上传</td>
        <td><a href = "demo!gotoUpload.action">upload.jsp</a></td>
        <td>能完成上传</td>
        <td></td>
    </tr>
    <tr>
        <td>00，00，00，05</td>
        <td>树</td>
        <td><a href = "demo!gotoTree.action">tree.jsp</a></td>
        <td>添加常用的控件</td>
        <td>未完成</td>
    </tr>
    <tr>
        <td>00，00，00，06</td>
        <td>消息推送</td>
        <td><a href = "demo!gotoWebSocket.action">websocket.jsp</a></td>
        <td>websocket实现</td>
        <td>能推送消息，要加入身份</td>
    </tr>
    <tr>
        <td>00，00，00，07</td>
        <td>权限管理</td>
        <td><a href = "demo!gotoShrio.action">shrio.jsp</a></td>
        <td>Shrio实现</td>
        <td></td>
    </tr>
    <tr>
        <td>00，00，00，08</td>
        <td>工作流</td>
        <td><a href = "demo!gotoActiviti.action">Activiti.jsp</a></td>
        <td>activiti5实现</td>
        <td></td>
    </tr>
    <tr>
        <td>00，00，00，08</td>
        <td>验证码</td>
        <td><a href = "demo!gotoCode.action">code.jsp</a></td>
        <td>实现验证码Kaptcha</td>
        <td></td>
    </tr>
</table>
</body>
</html>