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
		<div class="procom">
			 <div class="am-header-left am-header-nav return">
		        <a href="javascript:history.back()" class="return-fir">
			       <i class="am-icon-chevron-left"></i>
			    </a>
            </div>
            <div class="procon">
	<div class="proleft">
		<div class="proleft-con">
			<p>80%</p>
			<div style="width:20px; height: 80px; background:#fff; margin:0 auto;"></div>
			<p>不错呦</p>
		</div>
	</div>
	<div class="proleft">
		<div class="proleft-con">
			<p>19%</p>
			<div style="width:20px; height: 40px; background:#fff; margin:0 auto;"></div>
			<p>待提高</p>
		</div>
	</div>
	<div class="proleft">
		<div class="proleft-con">
			<p>1%</p>
			<div style="width:20px; height: 30px; background:#fff; margin:0 auto;"></div>
			<p>小失落</p>
		</div>
	</div>


</div>
		</div>
		<div class="prccom-con">
			<div style="overflow: hidden;">
			<span class="pro-start" style="text-align: left;">
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
			</span>
			<span class="name">李女士</span>
			<span class="time">2015-09-25</span>
			</div>
			<p>趁 着中秋节，又习了好多，都很新鲜</p>
			<img src="${pageContext.request.contextPath }/shell651/images/p1.jpg" width="100" height="100" class="com-pic" />
		</div>
		<div class="prccom-con">
			<div style="overflow: hidden;">
			<span class="pro-start" style="text-align: left;">
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
			</span>
			<span class="name">1356****0708 </span>
			<span class="time">2015-09-25</span>
			</div>
			<p>趁着中秋节，又买了好多，都很新鲜，趁着中秋节，又买了好多，都很新鲜。</p>
			
		</div>
		<div class="prccom-con">
			<div style="overflow: hidden;">
			<span class="pro-start" style="text-align: left;">
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
				<img src="${pageContext.request.contextPath }/shell651/images/start.png" />
			</span>
			<span class="name">1356****0708 </span>
			<span class="time">2015-09-25</span>
			</div>
			<p>趁 着中秋节，又习了好多，都很新鲜</p>
		
		</div>
		
	</body>
</html>
