<%@ page language="java" import="java.util.*,top.yangzhenzhong.bean.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html class="no-js">

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
		<style> 
		.list-curr{ background: #fff; display: block; border-right: 0;}
		.gm-head-right{ color: #2b2a2a;}
		.gm-head-right a{ color: #2b2a2a;}
		.joan-head{ background: #fff;}
		.gm-head-search input{ border: 1px solid #599a3c;}
		.gm-head-left a, .gm-head-right a{ color: #599a3c;}
		</style>

	</head>
	<body class="gudin am-with-fixed-navbar" >
		<header data-am-widget="header" class="am-header am-header-default joan-head" style="z-index:999;position: fixed; top: 0; left: 0;border: 1px solid #ddd;">
			<div class="gm-head-left"> 
				<a href="#left-link" class=""><i class="am-icon-map-marker"></i>南昌</a>
			</div>
			<div class="gm-head-search">
				
					<input type="text" placeholder="寻找你喜欢的商品" name="search" id="search"><a href="javascript:ajaxShowSearch()"><i class="am-icon-search"></i></a>
			</div>

			<div class="gm-head-right">
					<%	
      		User user =(User) request.getSession().getAttribute("user");
      		if(user!=null){
      	%>
      		<a href="${pageContext.request.contextPath }/shell651/personal.jsp" >${user.u_name }</a>  /<a href="${pageContext.request.contextPath }/shell651/login.jsp" >注销</a>
      	<%}else{ %>
      	 <a href="${pageContext.request.contextPath }/shell651/login.jsp" >登陆</a>  /<a href="${pageContext.request.contextPath }/shell651/reg.html" >注册</a>
     	<%} %>
			</div>
		</header>
		<div class="list-content">
			 <div class="list-left">
			 	 <li id="sort_id0"><a  class="list-curr" href="${pageContext.request.contextPath }/ShowFruitServlet.qian.do?action=show" >全部商品</a></li>
			 	 <c:forEach var="sort" items="${sortList}">
			 	 <li id="sort_id${sort.s_id}"><a  href="javascript:ajaxShowSortId(${sort.s_id})">${sort.s_name}</a></li>
			 	 </c:forEach>
			 </div>
			 <div class="list-right">
			 	<ul class="list-menu">
			 		<li><a href="${pageContext.request.contextPath }/ShowFruitServlet.qian.do?action=show">默认排序 </a></li>
			 		<li><a href="javascript:ajaxShowPrice()">价格</a><i class="list-menu-arrow"></i></li>
			 		<li><a href="javascript:ajaxShowKuCun()">新品</a><i class="list-menu-arrow"></i></li>
			 	</ul>
			 	<div id="showBox">
			 	<c:forEach var="f" items="${fList}" >
			 	<ul>
			 		<li class="zm">
			 			<div class="zm-l">
			 				<a href="ShowFruitServlet.qian.do?action=detail&f_id=${f.f_id}">
			 				<div class="pro-img" ><img src="${pageContext.request.contextPath}/${f.f_pic}"/></div>
			 				<div class="pro-con">
			 					<h2 class="pro-deta" data-id="{$val.id}">${f.f_name } </h2>
			 					<p class="pro-num" data-id="{$val.id}">${f.f_guige }</p>
			 					<p><span>${f.f_price}</span><del>${f.f_yuanjia }</del></p>
			 				</div>
			 				</a>
			 				<div class="zm-r">
			 					<a href="CartServlet.qian.do?action=addCart&f_id=${f.f_id}">加入购物车</a>    
			 				</div>
			 			</div>
			 		</li>
			 		<li style="height: 20px;"></li>
			 	</ul>
			 	</c:forEach>
			 	</div>
			 </div>
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
		<script src="${pageContext.request.contextPath }/shell651/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
			$(function(){		
			
				$('#search').keyup(function(){
				
				
			var key = $('#search').val();
			$.ajax({
				type:"GET",
				url:"ShowFruitServlet.qian.do",
				data:"action=ajaxShowSearch&key="+key,
				dataType:"JSON",
				success:function(flist){
					var s;
					for(var i=0;i<flist.length;i++){
							var f = flist[i];
							s=s
								+'<ul>'
			 		+'<li class="zm">'
			 			+'<div class="zm-l">'
			 				+'<a>'
			 				+'<div class="pro-img" ><img src="${pageContext.request.contextPath}/'+f.f_pic+'"/></div>'
			 				+'<div class="pro-con">'
			 					+'<h2 class="pro-deta" data-id="{$val.id}">'+f.f_name+'</h2>'
			 					+'<p class="pro-num" data-id="{$val.id}">'+f.f_guige+'</p>'
			 					+'<p><span>'+f.f_price+'</span><del>'+f.f_yuanjia+'</del></p>'
			 				+'</div>'
			 				+'</a>'
			 				+'<div class="zm-r">'
			 					+'<a href="">加入购物车</a>'    
			 				+'</div>'
			 			+'</div>'
			 		+'</li>'
			 		+'<li style="height: 20px;"></li>'
			 	+'</ul>'
								
							
					}
					$("#showBox").html(s);
				}
			
			});
			kucunR++;
			if(kucunR>1){
				kucunR=0;
			}

				
				
				
				
				
				});
			
					
					
				$('.pro-deta').click(function(){
					 var id = $(this).data('id');
					 var $modal = $('.st-pop-'+id);
					 var pop_height = $('.st-slider-box-'+id).height();
//		 			 console.log(pop_height);
					 $('.st-pop-'+id+' .am-modal-bd').html($('.slide-'+id).html());
					 $modal.modal();					 
					 $('.st-slider-'+id).flexslider();
				})
				
				$('.pro-img').click(function(){
					 var id = $(this).data('id');
					 var $modal = $('.st-pop-'+id);
					 var pop_height = $('.st-slider-box-'+id).height();
//		 			 console.log(pop_height);
					 $('.st-pop-'+id+' .am-modal-bd').html($('.slide-'+id).html());
					 $modal.modal();					 
					 $('.st-slider-'+id).flexslider();
				})
			})
</script>
<script type="text/javascript">
	var rule = ["DESC","ASC"];
	var	priceR = 0;
	var kucunR = 0;
	function ajaxShowSortId(s_id){
			$.ajax({
				type:"GET",
				url:"ShowFruitServlet.qian.do",
				data:"action=ajaxShowSortId&s_id="+s_id,
				dataType:"JSON",
				success:function(flist){
					var s;
					for(var i=0;i<flist.length;i++){
							var f = flist[i];
							s=s
								+'<ul>'
			 		+'<li class="zm">'
			 			+'<div class="zm-l">'
			 				+'<a>'
			 				+'<div class="pro-img" ><img src="${pageContext.request.contextPath}/'+f.f_pic+'"/></div>'
			 				+'<div class="pro-con">'
			 					+'<h2 class="pro-deta" data-id="{$val.id}">'+f.f_name+'</h2>'
			 					+'<p class="pro-num" data-id="{$val.id}">'+f.f_guige+'</p>'
			 					+'<p><span>'+f.f_price+'</span><del>'+f.f_yuanjia+'</del></p>'
			 				+'</div>'
			 				+'</a>'
			 				+'<div class="zm-r">'
			 					+'<a href="">加入购物车</a>'    
			 				+'</div>'
			 			+'</div>'
			 		+'</li>'
			 		+'<li style="height: 20px;"></li>'
			 	+'</ul>'
								
							
					}
					$("#showBox").html(s);
				}
			
			});
		}
		function ajaxShowPrice(){
			$.ajax({
				type:"GET",
				url:"ShowFruitServlet.qian.do",
				data:"action=ajaxShowPaixu&row=f_price&rule="+rule[priceR],
				dataType:"JSON",
				success:function(flist){
					var s;
					for(var i=0;i<flist.length;i++){
							var f = flist[i];
							s=s
								+'<ul>'
			 		+'<li class="zm">'
			 			+'<div class="zm-l">'
			 				+'<a>'
			 				+'<div class="pro-img" ><img src="${pageContext.request.contextPath}/'+f.f_pic+'"/></div>'
			 				+'<div class="pro-con">'
			 					+'<h2 class="pro-deta" data-id="{$val.id}">'+f.f_name+'</h2>'
			 					+'<p class="pro-num" data-id="{$val.id}">'+f.f_guige+'</p>'
			 					+'<p><span>'+f.f_price+'</span><del>'+f.f_yuanjia+'</del></p>'
			 				+'</div>'
			 				+'</a>'
			 				+'<div class="zm-r">'
			 					+'<a href="">加入购物车</a>'    
			 				+'</div>'
			 			+'</div>'
			 		+'</li>'
			 		+'<li style="height: 20px;"></li>'
			 	+'</ul>'
								
							
					}
					$("#showBox").html(s);
				}
			
			});
			priceR++;
			if(priceR>1){
				priceR=0;
			}

		}
		
		function ajaxShowKuCun(){
			$.ajax({
				type:"GET",
				url:"ShowFruitServlet.qian.do",
				data:"action=ajaxShowPaixu&row=f_kucun&rule="+rule[kucunR],
				dataType:"JSON",
				success:function(flist){
					var s;
					for(var i=0;i<flist.length;i++){
							var f = flist[i];
							s=s
								+'<ul>'
			 		+'<li class="zm">'
			 			+'<div class="zm-l">'
			 				+'<a>'
			 				+'<div class="pro-img" ><img src="${pageContext.request.contextPath}/'+f.f_pic+'"/></div>'
			 				+'<div class="pro-con">'
			 					+'<h2 class="pro-deta" data-id="{$val.id}">'+f.f_name+'</h2>'
			 					+'<p class="pro-num" data-id="{$val.id}">'+f.f_guige+'</p>'
			 					+'<p><span>'+f.f_price+'</span><del>'+f.f_yuanjia+'</del></p>'
			 				+'</div>'
			 				+'</a>'
			 				+'<div class="zm-r">'
			 					+'<a href="">加入购物车</a>'    
			 				+'</div>'
			 			+'</div>'
			 		+'</li>'
			 		+'<li style="height: 20px;"></li>'
			 	+'</ul>'
								
							
					}
					$("#showBox").html(s);
				}
			
			});
			kucunR++;
			if(kucunR>1){
				kucunR=0;
			}

		}
</script>
	</body>

</html>