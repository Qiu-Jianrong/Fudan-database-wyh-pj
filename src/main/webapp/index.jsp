<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 指定全局变量path 与 basepath -->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<meta charset="UTF-8">
    <style type="text/css">
      /* 页面布局 */
      body {
        background-image: url("<%=basePath%>/img/slide_1.png");
        background-attachment: fixed;
        background-position: top;
        background-size: auto 100vh;
        background-size: 101% 101%;
        background-repeat: no-repeat;
        margin: 0;
        padding: 0;
      }
      #container {
        width: 1260px;
        margin: 0 auto;
      }
      header {
        height: 80px;
        background-color: #87CEFA;
        color: #fff;
        text-align: center;
        padding-top:10px;
        margin-top: 10px;
        line-height: 80px;
      }
      nav {
        height: 70px;
        background-color: #ccc;
        text-align: right;
        line-height: 60px;
      }
      section {
        float: left;
        width: 1260px;
        height: 500px;
        margin-right: 20px;
        background-color: #eee;
        text-align:center;
      }
      aside {
        float: left;
        width: 320px;
        height: 400px;
        background-color: #eee;
      }
      footer {
        clear: both;
        height: 80px;
        background-color: #333;
        color: #fff;
        text-align: center;
        line-height: 80px;
      }
      
    </style>
    

<title>Welcome to Qiu Jianrong's online bookstore!</title>
	<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
	<script src="<%=basePath%>/js/jquery-3.6.4.min.js"></script>
	<script src="<%=basePath%>/js/bootstrap.min.js"></script>
	<script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>
  <script>
    /*https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json*/
    L2Dwidget.init({ "model": { jsonPath:
          "https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json",
        "scale": 1 }, "display": { "position": "right", "width": 99, "height": 135,
        "hOffset": 65, "vOffset": 140 }, "mobile": { "show": true, "scale": 0.5 },
        "react": { "opacityDefault": 0.8, "opacityOnHover": 0.1 } });
  </script>
</head>
<body style="background-color: rgb(240, 243, 239);">
    <div id="container">
      <header>
        <h1>邱剑荣的书店</h1>
      </header>
	<nav>
  		<form class="container-fluid justify-content-end">
  		<button class="btn btn-outline-success" type="button" onclick = "document.location = '<%=basePath%>/book_show.jsp';">进入店铺</button>
    	<button class="btn btn-outline-success" type="button" onclick = "document.location = '<%=basePath%>/login.jsp';">登录</button>
    	<button class="btn btn-outline-secondary margin" type="button" onclick = "document.location = '<%=basePath%>/sign_up.jsp';">用户注册</button>
  		</form>
	</nav>
      <section>
        <h2 style = "padding-top:20px;">欢迎来到邱剑荣的网上书店</h2>
        <p>我们提供高品质的产品和服务，期待您的加入。</p>
        <p>请点击上方导航栏对应按钮，开启您的购书之旅~</p>
      </section>

      <footer>
        <p>@2023 网站版权所有</p>
      </footer>
    </div>
  </body>
</html>	
