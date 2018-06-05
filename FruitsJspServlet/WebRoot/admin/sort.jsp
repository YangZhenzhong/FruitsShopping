<%@ page language="java" import="java.util.*,top.yangzhenzhong.bean.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<body onload="check()">
<%
	if(request.getParameter("message")!=null){
 %>
	<script type="text/javascript">
			alert(${message});
	</script>
<%}else{ }%>
<c:remove var="message"/>
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
        <a href="${pageContext.request.contextPath }/SortServlet.do?action=show" class="list-group-item active">类别管理</a>
        <a href="${pageContext.request.contextPath }/admin/sort_post.jsp" class="list-group-item">添加类别</a>
    </div>
</div>
<div class="col-md-10">
<div class="page-header">
    <h1>类别管理</h1>
</div>
<ul class="nav nav-tabs">
    <li class="active">
        <a href="${pageContext.request.contextPath }/SortServlet.do?action=show">类别管理</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath }/admin/sort_post.jsp">添加类别</a>
    </li>
</ul>
<table class="table">
    <thead>
    <tr>
        <th>类别名</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sList}" var="sort">
    <tr>
        <th scope="row">${sort.s_name}</th>
        <td>
            <div role="presentation" class="dropdown">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    操作<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath }/admin/sort_update.jsp?s_id=${sort.s_id}&s_name=${sort.s_name}">编辑</a></li>
                    <li><a href="${pageContext.request.contextPath }/SortServlet.do?action=delete&s_id=${sort.s_id }" onclick="return confirm('确认删除吗？')">删除</a></li>
                </ul>
            </div>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<nav class="pull-right">
    <ul class="pagination">
        <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
        <li class="active"><a href="#">1</a></li>
        <li><a href="#">2 </a></li>
        <li><a href="#">3 </a></li>
        <li><a href="#">4 </a></li>
        <li><a href="#">5 </a></li>
        <li><a href="#">6 </a></li>
        <li><a href="#"><span aria-hidden="true">&raquo;</span></a></li>
    </ul>
</nav>
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