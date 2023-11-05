<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入java server tag library 实现 c:if -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator Panel</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
	<link href= "<%=basePath%>/css/academyLabHeader.css" rel=stylesheet>
    <link href= "<%=basePath%>/css/labs.css" rel=stylesheet>
    
	<style type="text/css">
	.logo {
		float: left;
		height: 115px;
		width: 1536px;
	}
		
	</style>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/header.css"/>

    <script type="text/javascript" src="<%=basePath%>/js/jquery-3.6.4.min.js"></script>
    <!-- script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script-->
    <script type="text/javascript" src="<%=basePath%>/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<!-- script src="<%=basePath%>/js/labHeader.js"></script-->
    <%String role = (String)session.getAttribute("role");%>
    <%String username = (String)session.getAttribute("username");%>
<c:choose>    
<c:when test="${empty role}">
<div style = "padding-top:15px; text-align:center;">
	<h1>请先登录！</h1>
</div>	
</c:when>

<c:when test="${role eq 'super_admin'}">    
<div id="academyLabHeader">
    <section class='academyLabBanner'>
        <div class=container>
            <div class=logo>
            	<img alt="user management" height = '70px' width = '70px' src="<%=basePath%>/img/icon-6.png">
            </div>
                <div class=title-container>
                    <h1 style = "color: #333332;">用户管理</h1>
                </div>
                <div class='widgetcontainer-lab-status is-notsolved'>
                    <span><%=role %></span>
                    <p><%=username %></p>
                </div>
            </div>
    </section>
</div>
		<div>
            <section class="maincontainer">
                <div class="container is-page">
                    <header class="navigation-header">
                        <section class="top-links">
        					<form action = '<%=basePath%>/select_users' style = "float:left;" method = 'post'>
								<button class = "btn btn-primary" type = 'submit' style = "margin-left:20px;">查看所有用户</button>
							</form>                
							<form style = "margin-left : 10px" action="<%=basePath%>/Jump">
    							<button class="btn btnmargin btn-outline-secondary" type="submit">返回首页</button>
    							<input type = "hidden" name = "url" value = "book_show.jsp">
							</form>
                        </section>
                    </header>
                    <header class="notification-header">
                    </header>
                    <section>
                        <h1>Users</h1>
                        <c:forEach items="${users}" var="s" varStatus="vs">
                        <div>
                            <form style = "float:left; margin-right:10px;" action='<%=basePath%>/admin?op=delete' method="post">
                            	${s.username} - <button type="submit" class="btn btn-sm btn-outline-secondary">Delete</button>
                            	<input type="hidden" value="${s.username}" name="username">
                            </form>
                            <form style = "float:left;margin-right:10px;" action='<%=basePath%>/admin?op=upgrade' method="post">
                            	<button type="submit" class="btn btn-sm btnmargin btn-outline-success">Upgrade</button>
                            	<input type="hidden" value="${s.username}" name="username">
                            </form>
                            <form action='<%=basePath%>/admin?op=downgrade' method="post">
                            	<button type="submit" class="btn btn-sm btnmargin btn-outline-success">Downgrade</button>
                            	<input type="hidden" value="${s.username}" name="username">
                            </form>
                        </div>
                      </c:forEach>
                    </section>
                    <br>
                    <hr>
                </div>
            </section>
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