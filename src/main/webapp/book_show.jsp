<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入java server tag library 实现 c:if -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%
    String add_cart_success=(String)session.getAttribute("add_cart_success");  //接收后台传来的message
    %>
    <%
    if(add_cart_success != null && add_cart_success.equals("T")){  //判断是否加购成功
    %>
		<script type="text/javascript">
		if ("Notification" in window) {
		    // 请求权限
		    Notification.requestPermission().then(function (permission) {
		        if (permission === "granted") {
		            // 展示通知
		            var notification = new Notification("加购成功！");
		        }
		    });
		}
   		</script>
<%
        session.setAttribute("add_cart_success","");  //将message值设为空，否则将一直弹出。
	}
    else if(add_cart_success != null && add_cart_success.equals("F")){
%>    	<script type="text/javascript">
		if ("Notification" in window) {
		    Notification.requestPermission().then(function (permission) {
		        if (permission === "granted") {
		            // 展示通知
		            var notification = new Notification("加购失败！商品已无余量！请等待补货！");
		        }
			});
		}
   		</script>
<%		session.setAttribute("add_cart_success","G");  //将message值设为空，否则将一直弹出。 
    }
    else if(add_cart_success != null && add_cart_success.equals("N")){
%>    	<script type="text/javascript">
		if ("Notification" in window) {
		    Notification.requestPermission().then(function (permission) {
		        if (permission === "granted") {
		            // 展示通知
		            var notification = new Notification("加购失败！请先登录！");
		        }
			});
		}
   		</script>   
<%		session.setAttribute("add_cart_success","G");  //将message值设为空，否则将一直弹出。 	
    }
    
%>

<%
    String buy_now_success=(String)session.getAttribute("buy_now_success");  //接收后台传来的message
    %>
    <%
    if(buy_now_success != null && buy_now_success.equals("T")){  //判断是否加购成功
    %>
		<script type="text/javascript">
		if ("Notification" in window) {
		    // 请求权限
		    Notification.requestPermission().then(function (permission) {
		        if (permission === "granted") {
		            // 展示通知
		            var notification = new Notification("购买成功！");
		        }
		    });
		}
   		</script>
<%
        session.setAttribute("buy_now_success","");  //将message值设为空，否则将一直弹出。
	}
    else if(buy_now_success != null && buy_now_success.equals("F")){
%>    	<script type="text/javascript">
		if ("Notification" in window) {
		    Notification.requestPermission().then(function (permission) {
		        if (permission === "granted") {
		            // 展示通知
		            var notification = new Notification("购买失败！商品已无余量！请等待补货！");
		        }
			});
		}
   		</script>
<%		session.setAttribute("buy_now_success","G");  //将message值设为空，否则将一直弹出。 
    }
    else if(buy_now_success != null && buy_now_success.equals("N")){
%>    	<script type="text/javascript">
		if ("Notification" in window) {
		    Notification.requestPermission().then(function (permission) {
		        if (permission === "granted") {
		            // 展示通知
		            var notification = new Notification("购买失败！请先登录！");
		        }
			});
		}
   		</script>   
<%		session.setAttribute("buy_now_success","G");  //将message值设为空，否则将一直弹出。 	
    }
    
%>


	<title>Welcome to Qiu Jianrong's online bookstore!</title>
	<style>
		.sized_card{
			padding-top: 10px;
			margin: 20px;
			float: left;
			width: 14rem;
			height: 300px;
		}
		.btnmargin{
			margin-left: 10px;
		}
		.box_margin{
			margin-left: 100px;	
		}
	</style>
	
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css"/>
    <!--link rel="stylesheet" type="text/css" href="<%=basePath%>/css/header.css"/-->

    <script type="text/javascript" src="<%=basePath%>/js/jquery-3.6.4.min.js"></script>
    <!-- script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script-->
    <script type="text/javascript" src="<%=basePath%>/js/bootstrap.bundle.min.js"></script>
	<script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>
  <script>
    L2Dwidget.init({ "model": { jsonPath:
          "https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json",
        "scale": 1 }, "display": { "position": "right", "width": 99, "height": 135,
        "hOffset": 65, "vOffset": 40 }, "mobile": { "show": true, "scale": 0.5 },
        "react": { "opacityDefault": 0.8, "opacityOnHover": 0.1 } });
  </script>
</head>
<body>




<header class="container-fluid">
  <div class="row" style="heigth:200px;">
	<img src = "<%=basePath%>/img/logo2.png" height=210px;>
  </div>

<!--导航条，使用bookstrap模板-->  
  <nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: rgb(241, 182, 224);">
    <div class="container-fluid" style = "width:800px;">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="#">文史哲</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">社科</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">生医</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href = "#">艺术</a>
          </li>
		  <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			  教科及参考书
			</a>
			<ul class="dropdown-menu">
			<%String dayi= "@@cs1";String daer= "@@cs2";String dasan= "@@cs3";String dasi= "@@cs4"; %>
			  <li><a class="dropdown-item" href="<%=basePath %>/search?key=<%=dayi %>">大一</a></li>
			  <li><a class="dropdown-item" href="<%=basePath %>/search?key=<%=daer %>">大二</a></li>
			  <li><a class="dropdown-item" href="<%=basePath %>/search?key=<%=dasan %>">大三</a></li>
			  <li><a class="dropdown-item" href="<%=basePath %>/search?key=<%=dasi %>">大四</a></li>
			</ul>
		  </li>
        </ul>
      </div>
    </div>
	
<%String u_id = (String)session.getAttribute("u_id"); if(u_id == null) u_id = "";%>
	<!--搜索框-->
	<div class="container-fluid" style = "width:600px;">
		<form action = "<%=basePath %>/search" method = 'post' class="d-flex" role="search">
		  <input class="form-control me-2" name = "key" id = "key" type="search" placeholder="'@+id'进行精确搜索" aria-label="Search">
		  <button class="btn btn-outline-success" type="submit">Search</button>
		</form>
	</div>
	
	<!-- 登录注册按钮 -->
	<c:if test="${empty user}">
	<form class="container-fluid justify-content-end">
    	<button class="btn btn-sm btn-outline-success" type="button" onclick = "document.location = '<%=basePath%>/login.jsp';">登录</button>
    	<button class="btn btn-sm btnmargin btn-outline-secondary" type="button" onclick = "document.location = '<%=basePath%>/sign_up.jsp';">用户注册</button>
    </form>
    </c:if>
    
    <c:if test="${!empty user}">
    	<div class="container-fluid justify-content-end">
    	<%String role = (String)session.getAttribute("role");%>
    	<%String username = (String)session.getAttribute("username");%>
    	<%=role%> <%=username%>, 欢迎您！
    	
    	<c:if test="${role eq 'admin' }">
    	
    	<form action="<%=basePath%>/Jump">
    	<button class="btn btn-sm btn-outline-secondary" type="submit">货物管理</button>
    	<input type = "hidden" name = "url" value = "good_management.jsp">
    	</form>    
    	<form action="<%=basePath%>/Jump">
    	<button class="btn btn-sm btnmargin btn-outline-secondary" type="submit">订单管理</button>
    	<input type = "hidden" name = "url" value = "order_management.jsp">
    	</form>	
    	</c:if>
    	
    	<c:if test="${role eq 'super_admin' }">
    	<form action="<%=basePath%>/Jump">
    	<button class="btn btn-sm btn-outline-secondary" type="submit">管理员面板</button>
    	<input type = "hidden" name = "url" value = "admin_panel.jsp">
    	</form>
    	</c:if>
  
    	<form action="<%=basePath%>/my_cart?id=<%= u_id%>" method="post">
    	<button class="btn btn-sm btnmargin btn-outline-success" type="submit">购物车</button>
    	</form>
    	  	
    	<form action="<%=basePath%>/my_account">
    	<button class="btn btn-sm btnmargin btn-outline-success" type="submit">我的账户</button>
    	</form>
    	
    	<form action="<%=basePath%>/logout">
    	<button class="btn btn-sm btnmargin btn-outline-secondary" type="submit">退出登录</button>
    	 </form>
    	 
    	</div>
    </c:if>
  </nav>

</header>
<div style="padding-top: 10px;margin-left: 20px;">
<form action="<%=basePath%>/search" method="post">
<button class="btn btn-primary" type="submit">查看全部</button>
<input type="hidden" value="%" name="key">
</form>
</div>


<!--书籍展示-->
<!-- 没有搜索结果时显示 -->
<c:if test = "${no_match == 1}">
<div class = "container-fluid" style = "width:700px; padding-top: 30px;">
<div class="alert alert-info" role="alert">
  非常抱歉，没有找到相关的结果！
</div>
</div>
</c:if>

<!-- 每一次刷新页面时都提交search全部表单 -->
<!-- script type="text/javascript"> 
    setTimeout("document.form1.submit()",3000) 
</script> 
<!--% String key = (String)session.getAttribute("search_key"); if (key == null) key = "%";%-->
<!-- form name = "form1" action = "<%=basePath %>/search" method = 'post' class="d-flex" role="search">
	<input class="form-control me-2" name = "key" id = "key" type="hidden" value = <!--%=key %> placeholder="Search" aria-label="Search">
	<button class="btn btn-outline-success" type="submit">Search</button>
</form-->


<c:forEach items="${items}" var="s" varStatus="vs">
<div class = "container-fluid" style = "width:1340px">
<div class = "card sized_card text-center mb-3">
	<img src="${s.img}" height = '222px' width = '222px' class="card-img-top">
	<div class="card-body" style = "text-align:center;">
	  <p class = 'card-text'>

		<a rel="opener" class="btn btn-sm btn-outline-success" style = "margin : 2px;" href="<%=basePath %>/add_cart?id=${s.id}&u_id=<%=u_id %>&newness=${books[vs.index].newness}" role="button">
		  加入购物车
		</a>
		<a rel="opener" class="btn btn-sm btn-outline-success" href="<%=basePath %>/buy_now?id=${s.id}&u_id=<%=u_id %>&newness=${books[vs.index].newness}&number=1" role="button">
		  立即购买
		</a>
		<a class="btn btn-sm btn-outline-primary" style = "margin : 2px;" data-bs-toggle="collapse" href="#${s.id}" role="button" aria-expanded="false" aria-controls="collapseExample">
		  查看关键信息
		</a>
	  </p>
	  <div class="collapse" id="${s.id}">
		<div class="card card-body">
		  <p>库存：${books[vs.index].number}</p>
		  <p>定价：${books[vs.index].price}元</p>
		  <p>新度：${books[vs.index].newness}</p>
		</div>
	  </div>	
	</div>
</div>
</div>
</c:forEach>


</body>
</html>