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
  	            <a href="" class="">我的评论</a>
            </h1>
		</header>
		<div class="order">
		<ul class="order">
			<li><a  class="current" id="btnNo">未评论</a></li>
			<li><a  id="btnS">已评论</a></li>
		</ul>
		</div>
		<div id="weiwancheng" >
			<c:forEach var="comm" items="${noCommL}">
			<div class="or">
				<div class="c-comment">
					<span class="c-comment-num">订单时间：${comm.comm_date}</span>
					<span class="c-comment-suc">未评论</span>
				</div>
				<div class="c-comment-list" style="border: 0;">
					<a class="o-con" href="${pageContext.request.contextPath }/shell651/writeComm.jsp?comm_id=${comm.comm_id}">
            		<div class="o-con-img"><img src="${pageContext.request.contextPath }/${comm.order.detailL[0].fruit.f_pic}"/></div>
                	<div class="o-con-txt"><p></p><p style="color: #afafaf;"></p></div>
            			<div class="o-con-much"> <h4></h4></div>
           			 </a>
           			 <div class="c-com-money"><span>请评论</span></div>
				</div>
				<div class="c-com-btn">
				</div>
			</div>
			</c:forEach>
		</div>
		<div id="yiwancheng" style="display:none;">
			<c:forEach var="comm" items="${yesCommL}">
			<div class="or">
				<div class="c-comment">
					<span class="c-comment-num">评论时间：${comm.comm_date}</span>
					<span class="c-comment-suc">已评论</span>
				</div>
				<div class="c-comment-list" style="border: 0;">
					<a class="o-con" href="">
            		<div class="o-con-img"><img src="${pageContext.request.contextPath }/${comm.order.detailL[0].fruit.f_pic}"/></div>
                	<div class="o-con-txt"><p></p><p style="color: #afafaf;">${comm.comm_comment}</p></div>
            			<div class="o-con-much"> <h4></h4></div>
           			 </a>
           			 <div class="c-com-money">评分：<span>${comm.comm_flag}</span></div>
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
			$("#btnNo").addClass("current");
			$("#yiwancheng").css('display','none');
			$("#weiwancheng").css('display','block');
		
		});
		$("#btnS").click(function(){
			$("#btnNo").removeClass("current");
			$("#btnS").removeClass("current");
			$("#btnS").addClass("current");
			$("#yiwancheng").css('display','block');
			$("#weiwancheng").css('display','none');
		
		});
		$("#btnQ").click(function(){
			$("#btnNo").removeClass("current");
			$("#btnS").removeClass("current");
			$("#btnQ").addClass("current");
			$("#yiwancheng").css('display','none');
			$("#weiwancheng").css('display','none');
		
		});
	
	});
</script>
	</body>

</html>