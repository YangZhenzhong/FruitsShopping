<%@ page language="java" import="java.util.*,top.yangzhenzhong.bean.*" pageEncoding="UTF-8"%>
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

</head>
<body >

   <header data-am-widget="header" class="am-header am-header-default joan-head">
      <div class="gm-head-left">
          <a href="#left-link" class=""><i class="am-icon-map-marker"></i>南昌</a>
      </div>
      <div class="gm-head-search">
         <a href="search.html" ><input type="text" placeholder="寻找你喜欢的商品"><i class="am-icon-search"></i></a>
      </div>
      <div class="gm-head-right">
      	<%	
      		User user =(User) request.getSession().getAttribute("user");
      		if(user!=null){
      	%>
      		<a href="${pageContext.request.contextPath }/shell651/personal.jsp" >${user.u_name }</a>  /<a href="${pageContext.request.contextPath }/shell651/login.jsp" >注销</a>
      	<%}else{ %>
      	 <a href="${pageContext.request.contextPath }/shell651/login.jsp" >登陆</a>  /<a href="${pageContext.request.contextPath }/shell651/reg.jsp" >注册</a>
     	<%} %>
      </div>
  </header>
 
  
  

 

<div data-am-widget="slider" class="am-slider am-slider-b2" data-am-slider='{"controlNav":false}'>
  <ul class="am-slides">
    <li>
      <img src="${pageContext.request.contextPath }/shell651/images/ban1.png">
    </li>
    <li>
      <img src="${pageContext.request.contextPath }/shell651/images/ban2.jpg">
    </li>
     
    
  </ul>
</div>

 
<div class="case-nav">
<ul>
  <li>
    <div class="am-gallery-item">
      <a href="${pageContext.request.contextPath }/shell651/shop.html" class="case-nav-p">
        <img src="${pageContext.request.contextPath }/shell651/images/icon1.png">
        <p>全部商品</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="${pageContext.request.contextPath }/shell651/shop.html" class="case-nav-p">
        <img src="${pageContext.request.contextPath }/shell651/images/icon2.png">
        <p>鲜果区</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="${pageContext.request.contextPath }/shell651/gift.html" class="case-nav-p">
        <img src="${pageContext.request.contextPath }/shell651/images/icon3.png">
        <p>礼品区</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="#" class="case-nav-p">
        <img src="${pageContext.request.contextPath }/shell651/images/icon4.png">
        <p>品牌故事</p>
      </a>
    </div>
  </li>
     <li>
    <div class="am-gallery-item">
      <a href="${pageContext.request.contextPath }/shell651/brand.html" class="case-nav-p">
        <img src="${pageContext.request.contextPath }/shell651/images/icon1.png">
        <p>品质溯源</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="${pageContext.request.contextPath }/shell651/project.html" class="case-nav-p">
        <img src="${pageContext.request.contextPath }/shell651/images/icon2.png">
        <p>企业采购</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="#" class="case-nav-p">
        <img src="${pageContext.request.contextPath }/shell651/images/icon3.png">
        <p>物流售后</p>
      </a>
    </div>
  </li>
  <li>
    <div class="am-gallery-item">
      <a href="#" class="case-nav-p">
        <img src="${pageContext.request.contextPath }/shell651/images/icon4.png">
        <p>免费试吃</p>
      </a>
    </div>
  </li>
   
</ul>
</div>



<div class="active-main">
	<ul>
    	<li><a href="#"><img src="${pageContext.request.contextPath }/shell651/images/act1.jpg"></a></li>
    	<li><a href="#"><img src="${pageContext.request.contextPath }/shell651/images/act2.jpg"></a></li>
    	<li><a href="#"><img src="${pageContext.request.contextPath }/shell651/images/act3.jpg"></a></li>
    </ul>

</div>


<div class="product">
  <ul class="am-gallery am-avg-sm-2 am-avg-md-2 am-avg-lg-4 am-gallery-default" >
  	<h2><span></span>鲜果专区</h2>
  
      <li>
        <div class="am-gallery-item">
            <a href="ShowFruitServlet.qian.do?action=detail&f_id=1" class="">
              <img src="${pageContext.request.contextPath }/shell651/images/p1.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a href= "ShowFruitServlet.qian.do?action=detail&f_id=1" class="">
              <img src="${pageContext.request.contextPath }/shell651/images/p2.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a href="ShowFruitServlet.qian.do?action=detail&f_id=1" class="">
              <img src="${pageContext.request.contextPath }/shell651/images/p1.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a href= "ShowFruitServlet.qian.do?action=detail&f_id=1" class="">
              <img src="${pageContext.request.contextPath }/shell651/images/p2.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
  </ul>

  <ul class="am-gallery am-avg-sm-2 am-avg-md-2 am-avg-lg-4 am-gallery-default" >
  	<h2><span></span>礼盒专区</h2>
  
      <li>
        <div class="am-gallery-item">
            <a href="ShowFruitServlet.qian.do?action=detail&f_id=1" class="">
              <img src="${pageContext.request.contextPath }/shell651/images/g1.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a href= "ShowFruitServlet.qian.do?action=detail&f_id=1" class="">
              <img src="${pageContext.request.contextPath }/shell651/images/g1.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a href="ShowFruitServlet.qian.do?action=detail&f_id=1" class="">
              <img src="${pageContext.request.contextPath }/shell651/images/g1.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a href= "ShowFruitServlet.qian.do?action=detail&f_id=1" class="">
              <img src="${pageContext.request.contextPath }/shell651/images/g1.jpg" /> 
                <div class="am-gallery-desc">
                	<div class="pro-tit">
                    	<h3>南丰蜜桔 南丰贡桔</h3>
                        <p>12个装</p>
                    </div>
                    
                    <div class="pro-price">
                    	￥88<del>￥108</del>
                    </div>
                
                </div>
            </a>
        </div>
      </li>
  </ul>
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

</body>
</html>
