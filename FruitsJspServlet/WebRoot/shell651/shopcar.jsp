<%@ page language="java" import="java.util.*,top.yangzhenzhong.bean.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<body style="background: #fff;">
<header data-am-widget="header" class="am-header am-header-default joan-head2 ">
			<div class="am-header-left am-header-nav">
				<a href="javascript:history.back()" class="">
					<i class="am-icon-chevron-left"></i>
				</a>
			</div>
			<h1 class="am-header-title">
  	            <a href="" class="">购物车</a>
            </h1>
            <div class="am-header-right am-header-nav">
       <a href="javascript:deleteAjax()" onclick="return confirm('确认清空吗？')" class="">
            <i class="am-header-icon am-icon-del"></i>
        </a>
    </div>
</header>

<div class="shopcartit">购物车商品</div>
<div class="c-comment-list" style="border: 0;" id="cartBox">
			<c:choose>
			<c:when test="${not empty cList}">
			<c:forEach var="cart" items="${cList}">
			<div class="o-con2" >
            	<div class="o-con-img"><img src="${pageContext.request.contextPath }/${cart.fruit.f_pic}"/></div>
                <div class="o-con-txt2">
                	<p>${cart.fruit.f_name }</p>
                	<p style="color: #afafaf;">${cart.fruit.f_name}</p>
                	 <div class="con">
	                    <div class="price">￥<span>${cart.fruit.f_price}</span></div>
	                    <div class="p-pur">
                           <a class="decrease" href="javascript:ajaxNum('reduce',${cart.c_id})">-</a>
                           <em class="sy_num">${cart.c_num }</em>
                           <a class="increase" href="javascript:ajaxNum('plus',${cart.c_id})">+</a>   
                        </div>
	                 </div>
                </div>
            </div>
          </c:forEach>
          </c:when>
          <c:otherwise>
          	<center><h1>购物车空空如也，快去添加购物车吧！</h1></center>
          </c:otherwise>
          </c:choose>
            
</div>
<div class="shaopprice">
	<em>￥ <span id="total">${total }</span></em>
	<a href="QueRenXiaDan.qian.do?action=show" id="liji">立即结算</a>
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
	function deleteAjax(){
		$.ajax({
				type:"GET",
				url:"CartServlet.qian.do",
				data:"action=deleteAll",
				async: false,
				dataType:"JSON",
				success:function(rs){
					$("#cartBox").html("<center><h1>购物车空空如也，快去添加购物车吧！</h1></center>");
					$("#total").html(0);
				}
			});
	}
	function ajaxNum(action,c_id){
		$.ajax({
				type:"GET",
				url:"CartServlet.qian.do",
				data:"action="+action+"&c_id="+c_id,
				async: false,
				dataType:"JSON",
				success:function(rs){
					var s="<center><h1>购物车空空如也，快去添加购物车吧！</h1></center>";
					var reduce ="'reduce'";
					var plus = "'plus'";
					cList = rs[0];
					for(var i=0;i<cList.length;i++){
							if(i==0){
								s="";
							}
							var cart = cList[i];
							s=s
								+'<div class="o-con2" >'
            					+'<div class="o-con-img"><img src="${pageContext.request.contextPath }/'+cart.fruit.f_pic+'"/></div>'
               					 +'<div class="o-con-txt2">'
                					+'<p>'+cart.fruit.f_name +'</p>'
                					+'<p style="color: #afafaf;">'+cart.fruit.f_name+'</p>'
                					+'<div class="con">'
	                    			+'<div class="price">￥<span>'+cart.fruit.f_price+'</span></div>'
	                    			+'<div class="p-pur">'
                           			+'<a class="decrease" href="javascript:ajaxNum('+reduce+','+cart.c_id+')">-</a>'
                           			+'<em class="sy_num">'+cart.c_num+'</em>'
                           			+'<a class="increase" href="javascript:ajaxNum('+plus+','+cart.c_id+')">+</a>'   
                       				 +'</div>'
	                 			+'</div>'
                				+'</div>'
           					 +'</div>';
           					
						
					}
					$("#cartBox").html(s);
					$("#total").html(rs[1]);
				}
			
			});
	}
</script>
	</body>
</html>
