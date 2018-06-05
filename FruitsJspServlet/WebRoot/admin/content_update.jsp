<%@ page language="java" import="java.util.*,top.yangzhenzhong.bean.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
    <title>bootstrap项目实战</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/bootstrap-maizi.css"/>
    <script src="${pageContext.request.contextPath }/admin/js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript">
		$(function(){
			$("#tupian").change(function(){
				var objUrl = getObjectURL(this.files[0]) ;
				if (objUrl) {  
    				$("#showImage").attr("src", objUrl) ;  
 				}  
			});
		});
		function getObjectURL(file) {  
  var url = null ;   
  // 下面函数执行的效果是一样的，只是需要针对不同的浏览器执行不同的 js 函数而已  
  if (window.createObjectURL!=undefined) { // basic  
    url = window.createObjectURL(file) ;  
  } else if (window.URL!=undefined) { // mozilla(firefox)  
    url = window.URL.createObjectURL(file) ;  
  } else if (window.webkitURL!=undefined) { // webkit or chrome  
    url = window.webkitURL.createObjectURL(file) ;  
  }  
  return url ;  
}  
	</script>
</head>
<body>
<!--导航-->
<nav class="navbar navbar-default">
    <div class="container">
        <!--小屏幕导航按钮和logo-->
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="index.jsp" class="navbar-brand">Maizi Admin</a>
        </div>
        <!--小屏幕导航按钮和logo-->
        <!--导航-->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath }/admin/index.jsp"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;后台首页</a></li>
                <li><a href="${pageContext.request.contextPath }/UserServlet.admin.do?action=show"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;用户管理</a></li>
                <li><a href="${pageContext.request.contextPath }/FruitServlet.admin.do?action=show"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;内容管理</a></li>
              	<li><a href="${pageContext.request.contextPath }/OrderServlet.admin.do?action=show"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;订单管理</a></li>
              	<li><a href="${pageContext.request.contextPath }/CommentServlet.admin.do?action=show"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;评论管理</a></li>
              	<li><a href="${pageContext.request.contextPath }/SortServlet.do?action=show"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;类别管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        admin
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li><a href="${pageContext.request.contextPath }/admin/index.jsp"><span class="glyphicon glyphicon-screenshot"></span>&nbsp;&nbsp;前台首页</a></li>
                        <li><a href="${pageContext.request.contextPath }/admin/index.jsp"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;个人主页</a></li>
                        <li><a href="${pageContext.request.contextPath }/admin/index.jsp"><span class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;个人设置</a></li>
                        <li><a href="${pageContext.request.contextPath }/admin/index.jsp"><span class="glyphicon glyphicon-credit-card"></span>&nbsp;&nbsp;账户中心</a></li>
                        <li><a href="${pageContext.request.contextPath }/admin/index.jsp"><span class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;我的收藏</a></li>
                    </ul>
                </li>
                <li><a href="#bbs"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
            </ul>
        </div>
        <!--导航-->

    </div>
</nav>
<!--导航-->

<div class="container">
    <div class="row">
        <div class="col-md-2">
            <div class="list-group">
                <a href="${pageContext.request.contextPath }/FruitServlet.admin.do?action=show" class="list-group-item">类别管理</a>
                <a href="${pageContext.request.contextPath }/admin/content_post.jsp" class="list-group-item active">添加类别</a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>内容管理</h1>
            </div>
            <ul class="nav nav-tabs">
                <li class="active">
        <a href="${pageContext.request.contextPath }/FruitServlet.admin.do?action=show">商品管理</a>
    </li>
    <li>
        <a href="content_post.jsp">添加商品</a>
    </li>
            </ul>
           	<form action="${pageContext.request.contextPath }/FruitServlet.admin.do?action=update" method="post" enctype="multipart/form-data">
  			<input type="hidden" name="f_id" value="${f.f_id}">
  			<table>
  			<tr>
  				<td>商品名</td>
  				<td><input type="text" name="f_name" value="${f.f_name }"></td>
  			</tr>
  			<tr>
  				<td>图片</td>
  				<td>
  					<div>
  						<input type="hidden" value="${f.f_pic}" name="f.f_picName">
  						<img src="${pageContext.request.contextPath }/${f.f_pic}" width="100px" height="100px" border="1px" alt="上传图片" id="showImage"><br>
  						<input type="file" name="f_pic" id="tupian" >
  					</div>
  				</td>
  			</tr>
  			<tr>
  				<td>商品类型</td>
  				<td>
  					<select name="s_id">
  						<c:forEach items="${sList }" var="s">
  							<option 
  							 value="${s.s_id}"
  							  <c:if test="${f.s.s_id==s.s_id}">
  								selected="selected"
  								</c:if>
  							>${s.s_name }</option>
  						</c:forEach>
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td>商品数量</td>
  				<td><input type="text" name="f_kucun" value="${f.f_kucun}"></td>
  			</tr>
  			<tr>
  				<td>商品规格</td>
  				<td><input type="text" name="f_guige" value="${f.f_guige}"></td>
  			</tr>
  			<tr>
  				<td>商品价格</td>
  				<td><input type="text" name="f_price" value="${f.f_price}" ></td>
  			</tr>
  			<tr>
  				<td>商品原价</td>
  				<td><input type="text" name="f_yuanjia" value="${f.f_yuanjia}" ></td>
  			</tr>
  			<tr>
  				<td>商品描述</td>
  				<td><textarea rows="10" cols="10" name="f_tuwen" >${f.f_tuwen}</textarea></td>
  			</tr>
  		</table>
  		<input type="submit" value="更新">
  	</form>

        </div>
    </div>
</div>

<!--footer-->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p>
                    Copyright&nbsp;©&nbsp;2012-2015&nbsp;&nbsp;www.maiziedu.com&nbsp;&nbsp;蜀ICP备13014270号-4
                </p>
            </div>
        </div>
    </div>
</footer>
<!--footer-->


<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/admin/js/bootstrap.min.js"></script>
</body>
</html>