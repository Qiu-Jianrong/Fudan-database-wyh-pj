<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入java server tag library 实现 c:if -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		    padding: 10px;
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
		.btnmargin{
			margin-left: 10px;
		}
	</style>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css"/>
    <script type="text/javascript" src="<%=basePath%>/js/jquery-3.6.4.min.js"></script>
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
<h1 style="padding-top:15px;">订单管理</h1>
</div>

<div class="header-divider"></div>
<form action = '<%=basePath%>/select_orders' style = "float:left;" method = 'post'>
	<button class = "btn btn-primary" type = 'submit' style = "margin-left:20px;">查看最新订单情况</button>
</form>

<form style = "margin-right : 10px" action="<%=basePath%>/Jump">
    <button class="btn btnmargin btn-outline-secondary" type="submit">返回首页</button>
    <input type = "hidden" name = "url" value = "book_show.jsp">
</form>

	<div class="container">
		<h1 style = "text-align: center; color: #333;">订单条目</h1>
		<ul style = "list-style-type: none;">
		<c:forEach items="${orders}" var="s" varStatus="vs">
			<li>
			<p>用户ID: ${s.u_ID}</p>
			<p>商品ID: ${s.i_ID}</p>
			<p>商品新度: ${s.newness}</p>
			<p>订单数量: ${s.num}</p>
			<p>发货状态: ${s.state}</p>
			<c:if test="${s.state eq '未发货'}">
			<form action="<%=basePath%>/order_management?op=send" method = "post">
			<button class = "btn btn-outline-success" type = "submit">发货</button>
			<input type = "hidden" name = "u_id" value = "${s.u_ID}">
			<input type = "hidden" name = "i_id" value = "${s.i_ID}">
			<input type = "hidden" name = "newness" value = "${s.newness}">
			</form>
			</c:if>
			<form action="<%=basePath%>/order_management?op=delete" method = "post" style = "padding-top:10px;">
			<button class = "btn btn-outline-secondary" type = "submit">删除订单</button>
			<input type = "hidden" name = "u_id" value = "${s.u_ID}">
			<input type = "hidden" name = "i_id" value = "${s.i_ID}">
			<input type = "hidden" name = "newness" value = "${s.newness}">
			</form>
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