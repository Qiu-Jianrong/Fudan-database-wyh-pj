<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入java server tag library 实现 c:if -->
<!DOCTYPE html>
<html>
<head>
<!-- 指定全局变量path 与 basepath -->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/header.css"/>

    <script type="text/javascript" src="<%=basePath%>/js/jquery-3.6.4.min.js"></script>
    <!-- script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script-->
    <script type="text/javascript" src="<%=basePath%>/js/bootstrap.bundle.min.js"></script>
    <meta charset="utf-8">
    <title>购物车</title>
    <style type="text/css">
      /* 商品列表 */
      .cart-list {
        margin-left: 20px;
        padding: 10px;
        list-style: none;
      }
      .cart-item {
        display: flex;
        align-items: center;
        margin-bottom: 16px;
        padding-bottom: 16px;
        border-bottom: 1px solid #eee;
      }
      .cart-item-image {
        flex-shrink: 0;
        width: 80px;
        height: 80px;
        background-repeat: no-repeat;
        background-position: center center;
        background-size: contain;
      }
      .cart-item-info {
        margin-left: 16px;
      }
      .cart-item-title {
        margin: 0 0 8px;
        font-size: 18px;
        font-weight: bold;
      }
      .cart-item-price {
        margin: 0;
        font-size: 14px;
        color: #999;
      }
      .cart-item-quantity {
        margin-top: 8px;
        font-size: 14px;
      }
      .cart-item-quantity-label {
        display: inline-block;
        margin-right: 8px;
      }
      .cart-item-quantity-input {
        width: 60px;
        padding: 4px 8px;
        border: 1px solid #999;
        border-radius: 4px;
        font-size: 14px;
        text-align: center;
      }
		.header-divider {
			height: 3px;
			background-color: hsl(39, 100%, 50%);
			margin-top:10px;
			padding-top: 1px;
		}
      
      /* 总计金额 */
      .cart-total {
        margin-top: 24px;
        font-size: 18px;
        font-weight: bold;
      }
      .cart-total-label {
        display: inline-block;
        margin-right: 8px;
      }
    </style>
  </head>
  <body>
 
<div style = "width: 1200px;height:110px; padding-bottom:10px;padding-top:20px;margin:auto;">
<img src="<%=basePath%>/img/icon-3.png" width = '90px' style = "margin-right:10px;float:left;" alt="网站标志" class="icon-logo">
<h1 style="padding-top:15px;">购物车</h1>
</div>

<div class="header-divider"></div>
<header class="navigation-header" style="text-align:right;padding-top:10px;margin-right:20px;">
	<section class="top-links">               
		<form style = "margin-left : 10px" action="<%=basePath%>/Jump">
		<button class="btn btnmargin btn-outline-secondary" type="submit">返回首页</button>
		<input type = "hidden" name = "url" value = "book_show.jsp">
		</form>
	</section>
</header>
<div class="container-fluid" style="width:1300px;">
    <h1>购物车</h1>
    <ul class="cart-list">
    <c:forEach items="${cart_items}" var="s" varStatus="vs">
      <li class="cart-item">
        <div class="cart-item-image" style="background-image:url('${cart_items_img[vs.index].img}');"></div>
        <div class="cart-item-info">
          <h2 class="cart-item-title">${cart_items_name[vs.index].title}(${s.newness})</h2>
          <p class="cart-item-price">${s.price}元</p>
          <div class="cart-item-quantity">
            <span class="cart-item-quantity-label">数量:</span>
            <input class="cart-item-quantity-input" type="number" value="${s.number}" min="1">
          </div>
        </div>
      </li>
	</c:forEach>  
    </ul>
    
    <div class="cart-total">
      <span class="cart-total-label">总计金额:</span>
      ${sum }元
    </div>
</div>

  </body>
</html>