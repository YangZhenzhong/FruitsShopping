<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style type="text/css">
			*{margin: 0px; padding: 0px;font-family: arial;}
			body{
				width: 100%;
				height: 768px;
				margin: auto;
				background-size: 100% 768px;
				background-image: url(img/用户登录.jpg);
				background-repeat: no-repeat;
				position: absolute;
			}
			.login_reg{
				position: relative;
				width: 370px;
				height: 460px;
				padding: 40px 30px;
				margin: 5% 0 0 15%;
				border-radius: 30px;
				background-color: rgba(255,255,255,0.55);
				box-shadow: 2px 2px 4px dimgray,1px 1px 4px white inset;
			}
			.login_reg .title{
				color: #0033CC;
				font-size: 28px;
				text-align: center;
				margin-bottom: 20px ;
			}
			.login_reg .border-btm{
				border-bottom: 1px solid lightgray;
				box-shadow: 1px 1px 2px #0D0D0D;
			}
			.login_reg .tr{
				/*border: 1px solid red;*/
				display: block;	
				margin-top: 30px ;
			}
			.login_reg td input{
				width: 310px;
				height: 44px;
				margin-left:20px ;
				border: none;
				border-radius: 10px;
				box-shadow: 1px 1px 2px gray inset;
			}
			.login_reg .d_btn{
				/*border: 1px solid red;*/
				margin-top: 20px;
				text-align: center;
			}
			.login_reg .btn{
				border: 0px;
				border-radius: 5px;
				width: 140px;
				height: 40px;
				background-color: #FD643E;
				font-size: 20px;
				font-weight: bolder;
				color: white;
				margin-top:30px;
				box-shadow: 1px 1px 2px gray;
			}
			.login_reg .text{
				/*border: 1px solid black;*/
				text-align: center;
				margin-top: 40px;
			}
			.login_reg .text a{
				margin: 30px;
				font-weight: bolder;
				text-decoration: none;
			}
		</style>
</head>
<body>
<div class="login_reg">
	<h1 class="title">登录与注册</h1>
	<div class="border-btm"></div>
	<!-- session.getServletContext().getRealPath("/") -->
	<form action="" method="post" name="form">
		<table>
			<tr class="tr">
				<td><img src="img/登录.png" style="width: 30px; height: 44px;"/></td>
				<td><input type="text" name="username" value="" placeholder="  账号："/></td>
			</tr>
			<tr class="tr">
				<td><img src="img/密码.png" style="width: 30px; height: 44px;"/></td>
				<td><input type="password" name="pwd" placeholder="  密码："/></td>
			</tr>
		</table>
		<div class="d_btn">
			<input class="btn" id="login" type="submit" value="登录" onclick="form.action='LoginServlet'" /><br />
			<a href="regist.jsp"><input class="btn" id="reg" type="button" value="注册" /></a>
		</div>
		<div class="text">
			<a style="font-size: 16px;color: #FD643E;" onclick="form.action='UserServlet?action=visitorLogin';form.submit()">游客进入</a>
			<a href="forgetPwd.jsp" style="font-size: 13px;color: #169BD5;">忘记密码?</a>
		</div>
		</form>
</div>
</body>
</html>