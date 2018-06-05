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
            <a href="#title-link" class="">注册</a>
        </h1>
    
        <div class="am-header-right am-header-nav">
            
           <a href="${pageContext.request.contextPath }/shell651/index.jsp" class="">
                <i class="am-header-icon am-icon-home"></i>
            </a>
        </div>
  </header>

 


 
 
<div class="login">
        <form method="post" action="RegistServlet.qian.do" name="form" onsubmit="return yanzheng()">
            <ul class="login-ul reg-ul">
                <li class="login-li">
                 	<span>手机号码</span>
                    <input name="u_phone" placeholder="手机" class=" " type="tel" id="phone">
                    <i class="am-icon-mobile" id="showPhone" style="color: red"></i>
                 
                </li>
                <li class="login-li">
                 	<span>登录密码</span>
                    <input name="u_pwd" placeholder="密码" class=" " type="password" id="pass">
                 	<i class="am-icon-unlock-alt" style="color: red" id="showPass"></i>
                </li>
                <li class="login-li">
                 	<span>再次输入密码</span>
                    <input name="u_pwdR" placeholder="密码" class=" " type="password" id="Rpass">
                 	<i class="am-icon-unlock-alt" style="color: red" id="showRPass"></i>
                </li>
                <!-- 
                <li class="login-li">
                 	<span>手机验证码</span>
                    <input name="yzm" placeholder="验证码" class="yzm-input" type="text">
                 	 <button class="am-btn am-btn-warning">获取验证码</button>
                </li>
                 -->
            </ul>
             <div class="login-btn">
        		<center><input type="submit" value="注册" ></center>
       		 </div>
        </form>
        
        
       
         


 </div>
   
  
  
   

 
  
   	
     


<script src="${pageContext.request.contextPath }/shell651/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/shell651/js/amazeui.min.js"></script>
<script type="text/javascript">
	function yanzheng(){
		
		var isMobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1})|(14[0-9]{1}))+\d{8})$/;
				var phone = $('#phone').val();
				var pass = $('#pass').val();
				var rpass = $('#Rpass').val();
				var i =0;
				if (!isMobile.exec(phone) && phone.length != 11) {  
                //错误提示信息
                	$('#showPhone').empty();
                	$('#showPhone').html('*');
                	
           		 }else{
           		 	$('#showPhone').empty();
           		 	i=i+1;
           		 }  
           		 if(pass==rpass){
           		 	$('#showPass').empty();
           		 	$('#showRPass').empty();
           		 	i=i+1;
           		 }else{
           		 	$('#showPass').html('*');
           		 	$('#showRPass').html('*');
           		 }
           		 if(i==2){
           		 	return true;
           		 }
           		 else{
           		 	return false;
           		 }
	
	}

</script>
</body>
</html>
