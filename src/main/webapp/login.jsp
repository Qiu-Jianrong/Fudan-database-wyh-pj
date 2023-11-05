<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%
    String mess=(String)session.getAttribute("message");  //接收后台传来的message
    %>
    <%
    if(mess != null && mess.equals("F")){  //判断message
    %>
		<script type="text/javascript">
     		alert("用户名或密码错误，请重新输入！");  //弹出警示框
   		</script>
<%
        session.setAttribute("message","");  //将message值设为空，否则将一直弹出。
	}
%>
    
	<style>
		.pedding_top{
			padding-top: 20px;
		}
		.login_form{
			width: 50%;
			position : absolute;
			left: 25%;
			top: 7%;
		}
		.sele{
			width: 300px;
		}
	</style>
<meta charset="UTF-8">
<title>login</title>
	<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
	<script src="<%=basePath%>/js/jquery-3.6.4.min.js"></script>
	<script src="<%=basePath%>/js/bootstrap.min.js"></script>
</head>
<body>

<div class="login_form">
	<form action='<%=basePath%>/login' method="post">
		<div class="modal-body">
 			<div class="fillin">
			<label for="username">用户名： </label> 
			<input type="text" name="username" class="form-control" id="username" placeholder="username"><!-- placehoder显示框内起始值 -->
			</div><br>
			<div class="fillin">
			<label for="password">密码：</label> 
			<input type="password" name="password" class="form-control" id="password" placeholder="password">
        	</div><br>
		</div>
		<div>
		<select class = "sele" size = "1" name = "role" id = "role" style = "font-size: 17px;">
			<option selected value = "user"> 用户 </option>
			<option selected value = "admin"> 管理员 </option>
			<option selected value = "super_admin"> 超级管理员 </option>
		</select>
		</div>
		<div class = "pedding_top" align = "center">
			<button type="submit" class="btn btn-primary">登录</button>
		</div>
	</form>
</div>


<!-- form表单提供的是虚拟路径，不是文件路径 -->
<!--form action = '<%=basePath%>/login' method = 'POST'>
	username:<input type = 'text' name = 'username'><br>
	password:<input type = 'password' name = 'password'><br>
	<select size = "1" name = "role">
		<option selected value = "user"> 用户 </option>
		<option selected value = "admin"> 管理员 </option>
	</select>
	<div class = "padding-top"><input type = 'submit' name = 'login' value = "登录"></div>
</form-->
</body>
</html>