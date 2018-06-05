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
            <a href="index.jsp" class="navbar-brand">Admin</a>
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
        <a href="${pageContext.request.contextPath }/FruitServlet.admin.do?action=show" class="list-group-item active">商品管理</a>
        <a href="${pageContext.request.contextPath }/admin/content_post.jsp" class="list-group-item">添加商品</a>
    </div>
</div>
<div class="col-md-10">
<div class="page-header">
    <h1>商品管理</h1>
</div>
<ul class="nav nav-tabs">
    <li class="active">
        <a href="${pageContext.request.contextPath }/FruitServlet.admin.do?action=show">商品管理</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath }/admin/content_post.jsp">添加商品</a>
    </li>
</ul>
<table class="table table-hover table-bordered">
    <thead>
    <tr>
  		<th>商品名</th>
  		<th>类别</th>
  		<th>图片</th>
  		<th>规格</th>
  		<th>库存</th>
  		<th>价格</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="ajaxShow">
    <c:forEach items="${fList}" var="f">
    <tr style="line-height: 50px">
        <th scope="row" >${f.f_name}</th>
        <th scope="row">${f.s.s_name}</th>
        <th scope="row" ><center><img alt="${pageContext.request.contextPath }/${f.f_pic}" src="${pageContext.request.contextPath }/${f.f_pic}" style="width: 50px;height:50px;border: 1px solid;"></center></th>
        <th scope="row">${f.f_guige}</th>
        <th scope="row">${f.f_kucun}</th>
        <th scope="row">${f.f_price}</th>
        <td>
            <div role="presentation" class="dropdown">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    操作<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="FruitServlet.admin.do?action=detail&f_id=${f.f_id}">修改</a></li>
                    <li><a href="FruitServlet.admin.do?action=delete&f_id=${f.f_id}">删除</a></li>
                </ul>
            </div>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<div class="text-center pagination">
 <nav class="pull-right">
    <ul class="pagination">
         <li  class="${pL==1?'disabled':''}"><a href="<c:url value="javascript:ajaxShowPage(${pL-1>1?pL-1:1})" 

                />">&laquo;</a></li>

                <c:forEach begin="1" end="${totalP}" varStatus="loop">
                    <c:set var="active" value="${loop.index==pL?'active':''}"/>
                    <li class=""><a
                            href="<c:url value="javascript:ajaxShowPage(${loop.index})"/>">${loop.index}</a>
                    </li>
                </c:forEach>
                <li class="${page==totalP?'disabled':''}">
                    <a href="<c:url value="javascript:ajaxShowPage(${pL+1<totalP?pL+1:totalP})"/>">&raquo;</a>
                </li>
    </ul>
</nav>
</div>
</div>
</div>
</div>
<!--footer-->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p>
                ${sessionScope.pL }
                    Copyright&nbsp;©&nbsp;2012-2015&nbsp;&nbsp;www.yangzhenzhong.top&nbsp;&nbsp;蜀ICP备13014270号-4
                </p>
            </div>
        </div>
    </div>
</footer>
<!--footer-->


<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/admin/js/bootstrap.min.js"></script>
</body>
 <script>
		function ajaxShowPage(page){
			$.ajax({
				type:"post",
				url:"FruitServlet.admin.do",
				data:"action=showAjax&page="+page,
				dataType:"json",
				success:function(list){
					var s;
					for(var i=0;i<list.length;i++){
							var f = list[i];
							s=s
								+
								'<tr>'
  									+'<th scope="row">'+f.f_name+'</th>'
  									+'<th scope="row">'+f.s.s_name+'</th>'
  									+'<th scope="row"><img alt="${pageContext.request.contextPath}/'+f.f_pic+'" src="${pageContext.request.contextPath}/'+f.f_pic+'" style="width: 50px;height:50px;border: 1px solid;"></th>'
  									+'<th scope="row">'+f.f_guige+'</th>'
  									+'<th scope="row">'+f.f_kucun+'</th>'
  									+'<th scope="row">'+f.f_price+'</th>'
  									+'<td>'
  										+'<div role="presentation" class="dropdown">'
                							+'<button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">'
                  								 +'操作<span class="caret"></span>'
              					  		+'</button>'
              					 		 +'<ul class="dropdown-menu">'
                  							+'<li><a href="FruitServlet.admin.do?action=detail&f_id='+f.f_id+'">编辑</a></li>'
                  					  			+'<li><a href="FruitServlet.admin.do?action=delete&f_id='+f.f_id+'">删除</a></li>'
               					 		+'</ul>'
           							 +'</div>' 
  											
  									+'</td>'
  				 				+'</tr>'
						}
				
						$("#ajaxShow").html(s);
				}
					
				
				
				})
		}
	
	</script>
</html>