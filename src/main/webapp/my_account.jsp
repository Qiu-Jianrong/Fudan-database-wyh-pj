<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入java server tag library 实现 c:if -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
	<link href= "<%=basePath%>/css/academyLabHeader.css" rel=stylesheet>
    <link href= "<%=basePath%>/css/labs.css" rel=stylesheet>
	<script src="<%=basePath%>/js/labHeader.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css"/>
    <script type="text/javascript" src="<%=basePath%>/js/jquery-3.6.4.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%String role = (String)session.getAttribute("role");%>
<%String username = (String)session.getAttribute("username");%>
<%String a = (String)session.getAttribute("address");%>
<%String s = (String)session.getAttribute("sex");%>
<%String e = (String)session.getAttribute("email");%>
<%String t = (String)session.getAttribute("tel");%>
<div id="academyLabHeader">
    <section class='academyLabBanner'>
        <div class=container>
            <div class=logo>
            	<img alt="user management" src="<%=basePath%>/img/icon-11.png" height = '90px' width = '90px'>
            </div>
                <div class="title-container">
                    <h1>账户信息</h1>
                </div>
                <c:if test="${!empty user}">
                <div class='widgetcontainer-lab-status is-notsolved'>
                    <span><%=role %></span>
                    <p align = 'center'><%=username %></p>
                </div>
                </c:if>
            </div>
    </section>
</div>
		<div>
            <section class="maincontainer">
                <header class="container-fluid">
                      <nav class="navbar navbar-expand-lg bg-body-tertiary">
                        <div class="container-fluid justify-content-end">
    	
    					<form action="<%=basePath%>/logout">
    						<button class="btn btn-sm btnmargin btn-outline-success" type="submit">退出登录</button>
    	 				</form>
    					</div>
    				  </nav>
                </header>
                <div class="container is-page">
                    <header class="notification-header">
                    </header>
                    <h1>修改账户</h1>
                    <div id=account-content>
                    	<c:if test="${!empty user}">
                   	 		<p>Your role is: <%=role%></p>
                        	<p>Your username is: <%=username%></p>
                        </c:if>
                        <form class="login-form" name="change-form" action="<%=basePath%>/my-account/change-profile?username=<%=username %>" method="POST">
                            <label>邮箱：</label>
                            <input required type="text" name="email" value="<%=e %>">
                            
                            <label>收货地址：</label>
                            <input required type="text" name="address" value="<%=a %>">
                            
                            <label>电话号码：</label>
                            <input required type="text" name="tel" value="<%=t %>">
                            
                          
							<label for="sex">性别：</label>
							<input required type="text" name="sex" value= "<%=s %>" placeholder="male / female">
                            
                            <button class='button' type='submit'> 提交修改 </button>
                        </form>
                    </div>
                </div>
            </section>
        </div>
</body>
</html>