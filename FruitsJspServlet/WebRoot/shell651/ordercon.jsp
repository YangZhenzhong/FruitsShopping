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
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/shell651/css/check.css" />
	</head>
	<body>
		<header data-am-widget="header" class="am-header am-header-default joan-head2 ">
	<div class="am-header-left am-header-nav">
		<a href="javascript:history.back()" class="">
			<i class="am-icon-chevron-left"></i>
		</a>
	</div>
	<h1 class="am-header-title">
  	<a href="" class="">订单详情</a>
  </h1>
</header>
   <div class="order-num">
   	<span class="order-num-l">订单编号：${order.o_id }</span>
   	<span class="order-num-r">${order.state.name }</span>
   </div>
    <div class="order-pay">
    	<li>
    		<span class="pay-sty">订单总额</span>
    		<span class="weixinpay" style="color: #ff992e;">${order.total } </span>
    	</li>
    	<li>
    		<span class="pay-sty">支付方式</span>
    		<span class="weixinpay">${order.o_zhifufangshi }</span>
    	</li>
    	<li>
    		<span class="pay-sty">支付状态</span>
    		<span class="weixinpay">${order.state.name } </span>
    	</li>
    	<li style="border: 0;">
    		<span class="pay-sty">下单时间</span>
    		<span class="weixinpay">${order.o_date }</span>
    	</li>
    </div>
    <div class="order-text">配送信息</div>
    <div class="order-pay-infor">
    	<p>收货地址</p>
    	<p class="order-pay-add">${order.loc.local } </p>
    	<p class="order-pay-name">${order.loc.loc_name }，${order.loc.phone}</p>
    </div>
    <div class="order-pay-no">
    	<span class="pay-sty">物流查询</span>
        <i class="am-icon-angle-right" style=" float:right; color: #333; "></i>
        <span class="weixinpay">暂无物流信息</span>
    </div>

    <div class="order-text">商品清单</div>
    <c:forEach items="${order.detailL}" var="qd">
    <div class="c-comment-list" style=" border-top: 1px solid #ddd;">
			<a class="o-con" href="">
            	<div class="o-con-img"><img src="${pageContext.request.contextPath }/${qd.fruit.f_pic}"/></div>
                <div class="o-con-txt" style="padding-top: 0;"><p>${qd.fruit.f_name}</p><p style="color: #afafaf;">${qd.fruit.f_guige }</p></div>
            	<div class="o-con-much"> <h4>x${qd.qd_num }</h4></div>
            	<div class="agoprice" style="margin-left: 2%;">￥<span>${qd.qd_price}</span></div>
            </a>
	</div>
	</c:forEach>
     <div class="order-text">发票信息</div>
     <div class="order-pay-no" style="border-top: 1px solid #ddd;">
    	<span class="pay-sty">发票抬头</span>
    </div>
    <div class="order-text">价格清单</div>
     <div class="order-pay" style="margin-top: 0;">
    	<li>
    		<span class="pay-sty" >商品总价</span>
    		<span class="weixinpay" style="color: #ff992e;">￥${order.total }</span>
    	</li>
    	<li>
    		<span class="pay-sty">运费</span>
    		<span class="weixinpay"  style="color: #ff992e;">￥0.00 </span>
    	</li>
    	<li>
    		<span class="pay-sty">积分抵扣</span>
    		<span class="weixinpay">-￥0.00</span>
    	</li>
    	<li style="border: 0;">
    		<span class="pay-sty">优惠劵抵扣</span>
    		<span class="weixinpay">-￥0.00</span>
    	</li>
    </div>
    
  
    <div class="order-message">订单留言</div>
   <div class="orderprice">
	  <a href="QueRenXiaDan.qian.do?action=quxiao&o_id=${order.o_id}" class="order-pay-1">取消订单</a>
	  <a href="FruitPayServlet.qian.do?action=yibao&o_id=${order.o_id}" class="order-pay-2">立即支付</a>
   </div>
	</body>
</html>
