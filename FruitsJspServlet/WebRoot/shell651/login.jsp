<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

   <header data-am-widget="header" class="am-header am-header-default joan-head2 ">
       <div class="am-header-left am-header-nav">
        <a href="javascript:history.back()" class="">
            <i class="am-icon-chevron-left"></i>
        </a>
        </div>
    
        <h1 class="am-header-title">
            <a href="#title-link" class="">登录</a>
        </h1>
    
        <div class="am-header-right am-header-nav">
            
           <a href="index.jsp" class="">
                <i class="am-header-icon am-icon-home"></i>
            </a>
        </div>
  </header>

 


 
 
<div class="login">
        <form method="post" action="" name="form">
            <ul class="login-ul">
                <li class="login-li">
                 
                    <input name="u_phone" placeholder="手机" class="login-input-phone" type="tel">
                    <i class="am-icon-user"></i>
                 
                </li>
                <li class="login-li">
                 
                    <input name="u_pwd" placeholder="密码" class="login-input-password" type="password">
                 	<i class="am-icon-unlock-alt"></i>
                </li>
            </ul>
            <div class="login-btn">
        	<a  class="am-btn am-btn-warning am-round mb20" onclick="form.action='UserLoginServlet.qian.do?action=phoneLogin';form.submit()">登陆</a>
        	<a href="${pageContext.request.contextPath }/shell651/reg.jsp" class="am-btn am-btn-default am-round login-other-btn">注册</a>
       		 </div>
        </form>
        
        
        
         


 </div>
   
  
  
   

 
  
   	
     


<script src="${pageContext.request.contextPath }/shell651/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/shell651/js/amazeui.min.js"></script>

</body>
</html>
