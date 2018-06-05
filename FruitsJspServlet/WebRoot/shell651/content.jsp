<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8">
		<title>国贸城</title>
    <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />

  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/shell651/css/amazeui.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/shell651/css/app.css">
  
  	
 <style> .am-direction-nav{ display: none;}</style>
	</head>
	<body style=" background: #fff;">
<div class="am-slider am-slider-default" data-am-flexslider id="demo-slider-0" style="border-bottom: 1px solid #b6b6b6;">
  <ul class="am-slides">
    <li><img src="${pageContext.request.contextPath }/${f.f_pic}"/></li>
    <li><img src="${pageContext.request.contextPath }/${f.f_pic}" /></li>
    <li><img src="${pageContext.request.contextPath }/${f.f_pic}" /></li>
    <li><img src="${pageContext.request.contextPath }/${f.f_pic}" /></li>
  </ul>
  <div class="am-header-left am-header-nav return">

		<a href="javascript:history.back()" class="return-fir">
			<i class="am-icon-chevron-left"></i>
		</a>
		<a href="javascript:;" class="share"></a>
		<a href="" class="xin"></a>
  </div>
  <div class="share-con">
  	<a href="" class="friend"></a>
  	<a href="" class="zone"></a>
  	<a href="" class="weixin"></a>
  	<a href="" class="qq"></a>
  	<a href="" class="sina"></a>
  </div>
 
</div>

<div class="content">
	<div class="title">${f.f_name }</div>
	<div class="con">
	  <div class="price">￥<span>${f.f_price }</span></div>
	  <div class="p-pur">
      </div>
	</div>
</div>
<div class="con-num">
	<span class="con-num-l">规格</span>
	<span class="con-num-r">${f.f_guige}</span>
</div>
<a class="con-num" href="CommentServlet.qian.do?action=show">
	<span class="con-num-l">商品评价</span>
	<i class="am-icon-angle-right" style=" float:right; color: #b4b4b4;"></i>
	<span class="con-num-m">
		<p style="color: #b4b4b4;">97%的果友给了</p>
		<p style=" margin-top: 1px;">
			<img src="${pageContext.request.contextPath }/shell651/images/start.png"/>
			<img src="${pageContext.request.contextPath }/shell651/images/start.png"/>
			<img src="${pageContext.request.contextPath }/shell651/images/start.png"/>
			<img src="${pageContext.request.contextPath }/shell651/images/start.png"/>
			<img src="${pageContext.request.contextPath }/shell651/images/start.png"/>
		</p>
	</span>
</a>
<div class="con-relative">
	<div class="title">购买该产品的果友也买了</div>
	<ul class="am-gallery am-avg-sm-3 am-avg-md-3 am-avg-lg-3 am-gallery-default ">
		<li>
			<a href="">
				<img src="${pageContext.request.contextPath }/shell651/images/p1.jpg">
				<div class="am-gallery-desc">
                	<p class="tit">南丰贡桔<span>12个装</span></p>
                	<p class="yanse">￥<span>88</span></p>
                </div>
			</a>
		</li>
		<li>
			<a href="">
				<img src="${pageContext.request.contextPath }/shell651/images/p1.jpg">
				<div class="am-gallery-desc">
                	<p class="tit">南丰贡桔<span>12个装</span></p>
                	<p class="yanse">￥<span>88</span></p>
                </div>
			</a>
		</li>
		<li>
			<a href="">
				<img src="${pageContext.request.contextPath }/shell651/images/p1.jpg">
				<div class="am-gallery-desc">
                	<p class="tit">南丰贡桔<span>12个装</span></p>
                	<p class="yanse">￥<span>88</span></p>
                </div>
			</a>
		</li>

	</ul>
</div>

<div class="con-moretit"><img src="${pageContext.request.contextPath }/shell651/images/tit.png"></div>

<div id="tuwen">
${f.f_tuwen }
	<div class="con-pic"><img src="${pageContext.request.contextPath }/shell651/images/test.jpg"></div>
<div class="con-pic"><img src="${pageContext.request.contextPath }/shell651/images/test2.jpg"></div>
	
</div>
<div class="shop-cart">
  <span><i class="am-icon-shopping-cart am-icon-sm"></i><p class="nums"></p></span> 
 <a href="CartServlet.qian.do?action=addCart&f_id=${f.f_id}">加入购物车</a>        
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

<script src="${pageContext.request.contextPath }/shell651/js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/shell651/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/shell651/js/amazeui.min.js"></script>
		<script>
			$(function(){
        		$(".share").click(function(){
        			$(".share-con").fadeToggle()
        		})
        	})

		</script>

	</body>
</html>
