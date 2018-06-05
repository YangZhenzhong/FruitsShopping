<%@ page language="java" import="java.util.*,top.yangzhenzhong.bean.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
	<base href="<%=basePath%>">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>国贸城</title>
		<meta name="description" content="">
		<meta name="keywords" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="icon" type="image/png" href="assets/i/favicon.png">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/shell651/css/amazeui.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/shell651/css/app.css">
	</head>
	<body>
		<header data-am-widget="header" class="am-header am-header-default joan-head2 ">
			<div class="am-header-left am-header-nav">
				<a href="javascript:history.back()" class="">
					<i class="am-icon-chevron-left"></i>
				</a>
			</div>
			<h1 class="am-header-title">
  	            <a href="" class="">我的定单</a>
            </h1>
		</header>
		<div class="order">
		<ul class="order">
			<li><a  class="current" id="btnNo">未完成</a></li>
			<li><a  id="btnS">已完成</a></li>
			<li><a  style="border: 0;" id="btnQ">已取消</a></li>
		</ul>
		</div>
		<div id="weiwancheng" >
			<c:forEach var="order" items="${orderLNo}">
			<div class="or">
				<div class="c-comment">
					<span class="c-comment-num">订单编号：${order.o_id}</span>
					<span class="c-comment-suc">待付款</span>
				</div>
				<div class="c-comment-list" style="border: 0;">
					<a class="o-con" href="QueRenXiaDan.qian.do?action=detail&o_id=${order.o_id }">
            		<div class="o-con-img"><img src="${pageContext.request.contextPath }/${order.detailL[0].fruit.f_pic}"/></div>
                	<div class="o-con-txt"><p></p><p style="color: #afafaf;"></p></div>
            			<div class="o-con-much"> <h4>x2</h4></div>
           			 </a>
           			 <div class="c-com-money">实付金额：<span>${order.total}</span></div>
				</div>
				<div class="c-com-btn">
				<a href="${pageContext.request.contextPath }/FruitPayServlet.qian.do?action=nopay&o_id=${order.o_id}">立即支付</a>
				</div>
			</div>
			</c:forEach>
		</div>
		<div id="yiwancheng" style="display:none;">
			<c:forEach var="order" items="${orderLS}">
			<div class="or">
				<div class="c-comment">
					<span class="c-comment-num">订单编号：${order.o_id}</span>
					<span class="c-comment-suc">已付款</span>
				</div>
				<div class="c-comment-list" style="border: 0;">
					<a class="o-con" href="QueRenXiaDan.qian.do?action=detail&o_id=${order.o_id }">
            		<div class="o-con-img"><img src="${pageContext.request.contextPath }/${order.detailL[0].fruit.f_pic}"/></div>
                	<div class="o-con-txt"><p></p><p style="color: #afafaf;"></p></div>
            			<div class="o-con-much"> <h4>x2</h4></div>
           			 </a>
           			 <div class="c-com-money">实付金额：<span>${order.total}</span></div>
				</div>
			</div>
			</c:forEach>
		</div>
		<div id="yiquxiao" style="display:none;">
			<c:forEach var="order" items="${orderLQ}">
			<div class="or">
				<div class="c-comment">
					<span class="c-comment-num">订单编号：${order.o_id}</span>
					<span class="c-comment-suc">已取消</span>
				</div>
				<div class="c-comment-list" style="border: 0;">
					<a class="o-con" href="QueRenXiaDan.qian.do?action=detail&o_id=${order.o_id }">
            		<div class="o-con-img"><img src="${pageContext.request.contextPath }/${order.detailL[0].fruit.f_pic}"/></div>
                	<div class="o-con-txt"><p></p><p style="color: #afafaf;"></p></div>
            			<div class="o-con-much"> <h4>x2</h4></div>
           			 </a>
           			 <div class="c-com-money">实付金额：<span>${order.total}</span></div>
				</div>
			</div>
			</c:forEach>
		</div>
	  <div data-am-widget="navbar" class="am-navbar  am-navbar-default gm-foot"   id="">
      <ul class="am-navbar-nav am-cf am-avg-sm-4">
          <li >
            <a href="${pageContext.request.contextPath }/shell651/index.jsp" class="curr">
                <span class="am-icon-home"></span>
                <span class="am-navbar-label">首页</span>
            </a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/ShowFruitServlet.qian.do?action=show" class="">
                <span class="am-icon-th-large"></span>
                <span class="am-navbar-label">商品</span>
            </a>
          </li>
          <li >
            <a href="${pageContext.request.contextPath }/shell651/member.jsp" class="">
                <span class="am-icon-user"></span>
                <span class="am-navbar-label">个人中心</span>
            </a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/CartServlet.qian.do?action=show" class="">
                <span class="am-icon-shopping-cart"></span>
                <span class="am-navbar-label">购物车</span>
            </a>
          </li>
          <li >
            <a href="${pageContext.request.contextPath }/shell651/talk.html" class="">
                <span class="am-icon-file-text-o"></span>
                <span class="am-navbar-label">果友说</span>
            </a>
          </li>
      </ul>
  </div>

<script src="${pageContext.request.contextPath }/shell651/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/shell651/js/amazeui.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btnNo").click(function(){
			$("#btnNo").removeClass("current");
			$("#btnS").removeClass("current");
			$("#btnQ").removeClass("current");
			$("#btnNo").addClass("current");
			$("#yiwancheng").css('display','none');
			$("#weiwancheng").css('display','block');
			$("#yiquxiao").css('display','none')
		
		});
		$("#btnS").click(function(){
			$("#btnNo").removeClass("current");
			$("#btnS").removeClass("current");
			$("#btnQ").removeClass("current");
			$("#btnS").addClass("current");
			$("#yiwancheng").css('display','block');
			$("#weiwancheng").css('display','none');
			$("#yiquxiao").css('display','none')
		
		});
		$("#btnQ").click(function(){
			$("#btnNo").removeClass("current");
			$("#btnS").removeClass("current");
			$("#btnQ").removeClass("current");
			$("#btnQ").addClass("current");
			$("#yiwancheng").css('display','none');
			$("#weiwancheng").css('display','none');
			$("#yiquxiao").css('display','block')
		
		});
	
	});
</script>
	</body>

</html>