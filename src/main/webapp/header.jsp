<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<style>
	.pedding_top{
		padding-top: 10px;
	}
	.margin{
		margin-left: 10px;
	}

</style>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Welcome to Qiu Jianrong's online bookstore!</title>
	<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
	<script src="<%=basePath%>/js/jquery-3.6.4.min.js"></script>
	<script src="<%=basePath%>/js/bootstrap.min.js"></script>
</head>
<body>
<!--导航条-->  
<nav class="navbar bg-body-tertiary">
  <form class="container-fluid justify-content-end">
    <button class="btn btn-sm btn-outline-success" type="button" onclick = "document.location = '<%=basePath%>/login.jsp';">登录</button>
    <button class="btn btn-sm btn-outline-secondary margin" type="button" onclick = "document.location = '<%=basePath%>/sign_up.jsp';">用户注册</button>
  </form>
</nav>
    
<!--轮播图-->
<div class = "container-fluid pedding_top">
<img id = 'slide' src = '<%=basePath%>/img/slide_1.png' width = '80%' height="600px">
<script>
    var num = 1;
    function slide(){
        num = num % 2 + 1;
        var img = document.getElementById('slide');
        img.src = '<%=basePath%>/img/slide_' + num + '.png';
    }
    setInterval(slide, 2000);
</script>
</div>

</body>
</html>