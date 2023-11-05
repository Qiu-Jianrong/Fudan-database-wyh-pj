<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入java server tag library 实现 c:if -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>货物管理界面</title>
	<style type="text/css">
		body {
		    font-family: Arial, sans-serif;
		    background-color: #f2f2f2;
		}

		.container {
		    max-width: 800px;
		    margin: auto;
		    padding: 20px;
		}


		li {
		    border: 1px solid #ccc;
		    border-radius: 5px;
		    padding: 12px;
		    margin: 10px 0;
		}
		.header-divider {
			height: 3px;
			background-color: hsl(39, 100%, 50%);
			margin-bottom: 20px;
			padding-top: 1px;
		}
		li:hover {
		    background-color: #f1f1f1;
		}
		.icon-logo {
			width: 70px;
			height: 70px;
			margin-right: 20px;
		}
	</style>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<%
    String set_price_success=(String)session.getAttribute("set_price_success");  //接收后台传来的message
    %>
    <%
    if(set_price_success != null && set_price_success.equals("T")){  //判断是否加购成功
    %>
		<script type="text/javascript">
		if ("Notification" in window) {
		    // 请求权限
		    Notification.requestPermission().then(function (permission) {
		        if (permission === "granted") {
		            // 展示通知
		            var notification = new Notification("价格修改成功！");
		        }
		    });
		}
   		</script>
<%
        session.setAttribute("set_price_success","G");  //将message值设为空，否则将一直弹出。
	}
    else if(set_price_success != null && set_price_success.equals("F")){
%>    	<script type="text/javascript">
		if ("Notification" in window) {
		    Notification.requestPermission().then(function (permission) {
		        if (permission === "granted") {
		            // 展示通知
		            var notification = new Notification("修改失败！");
		        }
			});
		}
   		</script>
<%		session.setAttribute("set_price_success","G");  //将message值设为空，否则将一直弹出。 	
    }
    
%>

<%
    String in_success=(String)session.getAttribute("in_success");  //接收后台传来的message
    %>
    <%
    if(in_success != null && in_success.equals("T")){  //判断是否加购成功
    %>
		<script type="text/javascript">
		if ("Notification" in window) {
		    // 请求权限
		    Notification.requestPermission().then(function (permission) {
		        if (permission === "granted") {
		            // 展示通知
		            var notification = new Notification("进货成功！");
		        }
		    });
		}
   		</script>
<%
        session.setAttribute("in_success","G");  //将message值设为空，否则将一直弹出。
	}
    else if(in_success != null && in_success.equals("F")){
%>    	<script type="text/javascript">
		if ("Notification" in window) {
		    Notification.requestPermission().then(function (permission) {
		        if (permission === "granted") {
		            // 展示通知
		            var notification = new Notification("进货失败！");
		        }
			});
		}
   		</script>
<%		session.setAttribute("in_success","G");  //将message值设为空，否则将一直弹出。 
    } 
%>

	<style>
		.btnmargin{
			margin-left: 10px;
		}
	</style>

    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css"/>
    <!--link rel="stylesheet" type="text/css" href="<%=basePath%>/css/header.css"/-->

    <script type="text/javascript" src="<%=basePath%>/js/jquery-3.6.4.min.js"></script>
    <!-- script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script-->
    <script type="text/javascript" src="<%=basePath%>/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<c:choose>
<c:when test="${empty role}">
<div style = "padding-top:15px; text-align:center;">
	<h1>请先登录！</h1>
</div>	
</c:when>

<c:when test="${role eq 'admin'}">  
<div style = "margin-right:10px;width: 1100px;height:110px; padding-bottom:10px;padding-top:20px;margin:auto;">
<img src="<%=basePath%>/img/icon-13.png" width = '90px' style = "float:left;" alt="网站标志" class="icon-logo">
<h1 style="padding-top:15px;">货物管理</h1>
</div>

<div class="header-divider"></div>
<form action = '<%=basePath%>/select_goods' style = "float:left;" method = 'post'>
	<button class = "btn btn-primary" type = 'submit' style = "margin-left:20px;">查看最新商品信息</button>
</form>
<form style = "margin-right : 10px" action="<%=basePath%>/Jump">
    <button class="btn btnmargin btn-outline-secondary" type="submit">返回首页</button>
    <input type = "hidden" name = "url" value = "book_show.jsp">
</form>
	<div class="container">

		<h1 style = "text-align: center; color: #333;">货物条目</h1>
		<ul style = "list-style-type: none;">
		<c:forEach items="${all_goods}" var="s" varStatus="vs">
			<li>
			&nbsp;&nbsp;&nbsp;商品ID: ${s.id}<br><br>
			&nbsp;&nbsp;&nbsp;商品新度: ${s.newness}<br><br>
			&nbsp;&nbsp;&nbsp;商品数量: ${s.number}<br><br>
			&nbsp;&nbsp;&nbsp;商品价格: ${s.price}<br><br>
			<div class = "container-fulid" style="width:1000px; margin:auto;">
			<form action="<%= basePath%>/in_good" method = "post">
			<div class="container-fluid" style = "float:left;width:200px;">
					<div style = "padding-bottom:5px">
					  <button class = "btn btn-outline-primary" title="进货" type = "submit">进货</button>
					</div>
				<input class="form-control me-2" name = "in_number" id = "in_number" type="text" placeholder="请输入进货数量">
				<input type = 'hidden' name = "id" value = "${s.id}">
				<input type = 'hidden' name = "newness" value = "${s.newness}">
			</div>
			</form>
			
			<form action="<%= basePath%>/set_price" method = "post">
			<div class="container-fluid" style = "width:200px;">
			<div style = "padding-bottom:5px">
			<button title="定价" class = "btn btn-outline-primary" type = "submit">定价</button>
			</div>
			<input class="form-control me-2" name = "new_price" id = "new_price" type="text" placeholder="请输入定价" aria-label="Search">
			<input type = 'hidden' name = "id" value = "${s.id}">
			<input type = 'hidden' name = "newness" value = "${s.newness}">
			</div>
			</form>
			</div>
			
			</li>
		</c:forEach>
		</ul>
	</div>
</c:when>
<c:otherwise>
<div style = "padding-top:15px; text-align:center;">
	<h1>对不起，您无权访问！</h1>
</div>	
</c:otherwise>
</c:choose>
</body>
</html>