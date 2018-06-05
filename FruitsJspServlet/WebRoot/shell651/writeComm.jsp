<%@ page language="java" import="java.util.*,top.yangzhenzhong.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html><head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>评价</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/shell651//评价_files/new_file.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/shell651//评价_files/jquery-1.8.2.min.js.下载"></script>
	</head>
	
	<body>
		<form action="" name="form">
		<input type="hidden" name="action" value="writeComm">
		<input type="hidden" name="comm_id" id="comm_id" value="<%=request.getParameter("comm_id")%>">
		<input type="hidden" name="comm_flag" id="comm_flag" value="4">
		<!--头部  star-->
		<header>
			<a href="javascript:history.go(-1);">
				<div class="_left"><img src="${pageContext.request.contextPath }/shell651//评价_files/left.png"></div>
				   评价
			</a>
		</header>
		<!--头部 end-->
        <!--内容 star-->
		<div class="contaniner fixed-cont">
			<!--1-->
			<section class="assess">
				<p>
					<textarea rows="7" placeholder="请写下对水果的感受吧，对他人帮助很大哦～～" name="comm_comment"></textarea>
				</p>
				<ul>
					<li>评价</li>
					<li class="assess-right">
						<div><img src="${pageContext.request.contextPath }/shell651/评价_files/hua.png"></div>
					</li>
				</ul>
			</section>
			<!--2-->
			<section class="main">
			<div class="main-wrap">
				<span class="revtit">综合评分:</span>
				<div id="mydiv1"  class="mydiv">
	    			<ul class="star_ul">
				        <li num="1"><img src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png" id="img_1" class="xing_hui" onclick="start1()"></li>
				        <li num="2"><img src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png" id="img_2"  class="xing_hui" onclick="start2()"></li>
				        <li num="3"><img src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png" id="img_3"  class="xing_hui" onclick="start3()"></li>
				        <li num="4"><img src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png" id="img_4"  class="xing_hui" onclick="start4()"></li>
				        <li num="5"><img src="${pageContext.request.contextPath }/shell651/评价_files/star_empty.png" id="img_5"  class="xing_hui" onclick="start5()"></li>
			   		</ul>
				</div>
			</div>
		</section>
		</div>
		<!--内容 end-->
        
        <!--底部 star-->
		<footer class="assess-footer fixed-footer ">
			<ul>
				<input type="button"  onclick="form.action='CommentServlet.qian.do';form.submit()" value="发表评论">
			</ul>
		</footer>
	</form>
     
	<script type="text/javascript">
		function emptyStar(){
			document.getElementById("img_1").src="${pageContext.request.contextPath }/shell651/评价_files/star_empty.png";
			document.getElementById("img_2").src="${pageContext.request.contextPath }/shell651/评价_files/star_empty.png";
			document.getElementById("img_3").src="${pageContext.request.contextPath }/shell651/评价_files/star_empty.png";
			document.getElementById("img_4").src="${pageContext.request.contextPath }/shell651/评价_files/star_empty.png";
			document.getElementById("img_5").src="${pageContext.request.contextPath }/shell651/评价_files/star_empty.png";
		}
		function start1(){
			emptyStar();
			document.getElementById("img_1").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			$("#comm_flag").attr("value",1);
		}
		function start2(){
			emptyStar();
			document.getElementById("img_1").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			document.getElementById("img_2").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			$("#comm_flag").attr("value",2);
		}
		function start3(){
			emptyStar();
			document.getElementById("img_1").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			document.getElementById("img_2").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			document.getElementById("img_3").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			$("#comm_flag").attr("value",3);
		}
		function start4(){
			emptyStar();
			document.getElementById("img_1").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			document.getElementById("img_2").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			document.getElementById("img_3").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			document.getElementById("img_4").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			$("#comm_flag").attr("value",4);
		}
		function start5(){
			emptyStar();
			document.getElementById("img_1").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			document.getElementById("img_2").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			document.getElementById("img_3").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			document.getElementById("img_4").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			document.getElementById("img_5").src="${pageContext.request.contextPath }/shell651/评价_files/star_full.png";
			$("#comm_flag").attr("value",5);
		}
	</script>
       
	

</body></html>