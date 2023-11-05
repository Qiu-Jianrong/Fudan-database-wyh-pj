<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
	<script src="<%=basePath%>/js/jquery-3.6.4.min.js"></script>
	<script src="<%=basePath%>/js/bootstrap.min.js"></script>
	
	
	<style>
		.pedding_top{
			padding-top: 20px;
		}
		.signup_form{
			width: 50%;
			position : absolute;
			left: 25%;
			top: 7%;
		}
		.sele{
			width: 300px;
		}
	</style>
</head>
<body>


<div class="signup_form">
	<form action='<%=basePath%>/signup' method="post">
		<div class="modal-body">
 			<div>
			<label for="username">用户名： </label> 
			<input type="text" name="username" class="form-control" id="username" placeholder="username"><!-- placehoder显示框内起始值 -->
			</div><br>
			
			<div>
			<label for="password">密码：</label> 
			<input type="password" name="password" class="form-control" id="password" placeholder="password">
        	</div><br>
        	
        	<div>
			<label for="sex">性别：</label>
			 
			<input type="radio" name="sex" value="female">女
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="sex" value="male">男 <br>
        	</div><br>
        	
        	<div>
			<label for="tel">电话号码：</label> 
			<input type="text" name="tel" class="form-control" id="tel" placeholder="xxx-xxxx-xxxx">
        	</div><br>
        	
        	<div>
			<label for="address">收货地址：</label> 
			<input type="text" name="address" class="form-control" id="address" placeholder="复旦大学南区学生生活园区">
        	</div><br>
        	
        	<div>
			<label for="email">邮箱：</label> 
			<input type="text" name="email" class="form-control" id="email" placeholder="xxxxxxx@xxx">
        	</div><br>
		</div>
		<div class = "pedding_top" align = "center">
			<button type="submit" class="btn btn-primary">注册</button>
		</div>
		</form>
</div>
</body>
</html>