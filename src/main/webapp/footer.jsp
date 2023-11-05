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
</head>
<body>

</body>
</html>