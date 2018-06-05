<%@ page language="java" import="java.util.*,top.yangzhenzhong.bean.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
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
	<body style="background: #fff;">
		<header data-am-widget="header" class="am-header am-header-default joan-head2 ">
			<div class="am-header-left am-header-nav">
				<a href="javascript:history.back()" class="">
					<i class="am-icon-chevron-left"></i>
				</a>
			</div>
			<h1 class="am-header-title">
  	            <a href="" class="">确认订单</a>
            </h1>
		</header>
   		<div id="box">
   			<!-- 确认订单 -->
		<div id="pay_text">
			<center><span style="font-family: 黑体;font-size: 16;">温馨提示：请在1小时内完成支付，否则订单将被关闭哦</span></center>
		</div>
		<hr id="hr">
	</div>
	<br>
	<form id="addNewLoc">
	<center><a id="addLoc">添加新收货地址</a></center>
		<center>
		<div id="newAddressDiv" style="display:none;">
			<input name="action" type="hidden" value="addLoc">
			<table>
				<tr>
				
					<td>收货人姓名：</td>
					<td><input name="loc_name" ></td>
				</tr>
				<tr>
					<td>收货人手机号：</td>
					<td><input name="loc_phone" ></td>
				</tr>
				<tr>
					<td>收货人地址：</td>
					<td>
						<textarea rows="3" cols="25" name="local"></textarea>
					</td>
				</tr>
				<tr>
					<td><input type="reset" value="重置"></td>
					<td><input type="button" value="添加" onclick="ajaxAddLoc()"></td>
				</tr>
			</table>
		</div>
		</center>
	</form>
	<form action="QueRenXiaDan.qian.do?action=queRen" method="post" id="addNewLoc">
	<!-- 收货地址 -->
	<div id="address">
	<br>
	
	<center>		<span style="font-family: 黑体;font-size: 30;">&nbsp;选择收货地址</span></center>
		<hr>
		<div id="oldAddressDiv">
			<table border="0px" width="100%" style="text-align: center;">
			<tr>
			<td>地址</td>
			<td>收货人</td>
			<td>电话</td>
			</tr>
			<c:forEach var="add" items="${locList}" varStatus="s">
					<tr>
						<td width="33%" height="50px;" style="text-align: left;">&nbsp;<input type="radio"
							name="loc_id" value="${add.loc_id}" 
							<c:if test="${s.first}">checked="checked"</c:if>
							
							/>
							<span style="font-size: 22;">${add.local }</span></td>
						<td width="33%"><input type="hidden" name="rdocnee" value="${add.loc_name}">${add.loc_name }</td>
						<td width="33%;"><input type="hidden" name="rdophone" value="${add.phone }">${add.phone }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<br>
	</div>
	<br>
	<!-- 购物车 -->
	<div id="carshop">
			<c:forEach var="cart" items="${cList}" varStatus="i">
			<div class="o-con2" >
				<div>
					<input type="checkbox" name="c_id" value="${cart.c_id}" checked="checked"
								onclick="jisuanTotal()" />
				</div>
            	<div class="o-con-img"><img src="${pageContext.request.contextPath }/${cart.fruit.f_pic}"/></div>
                <div class="o-con-txt2">
                	<p>${cart.fruit.f_name }</p>
                	<p style="color: #afafaf;">${cart.fruit.f_name}</p>
                	 <div class="con">
	                    <div class="price">￥<span>${cart.fruit.f_price}</span></div>
	                    <div class="p-pur">
                           <em class="sy_num">${cart.c_num }</em>
                           <input type="text" readonly="readonly" size="2" id="c_total_${cart.c_id }" name="c_total_${cart.c_id }" value="${cart.fruit.f_price*cart.c_num}">   
                        </div>
	                 </div>
                </div>
            </div>
           
          </c:forEach>
	</div>
		
		<!-- 支付栏 -->
	<center>
	<div id="pay">
			<div >
				<span id="total_span">合计：
				<input type="text"  name="total" readonly="readonly" size="2" value="${total}"></span>
				<span>
				<input type="submit" value="确认订单" id="paybtn" onmouseover="this.style.color='white';"
						onmouseout="this.style.color='black';"></span>
			</div>
	</div>
	</center>
		<br>
	</form>
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
<script type="text/javascript">
	$(function(){
		$('#addLoc').click(function(){
				var show = $('#newAddressDiv').css('display');
				$('#newAddressDiv').css('display',show =='block'?'none':'block');
		});
	
	});
	function ajaxAddLoc(){
		 var formParam = $('#addNewLoc').serialize();
		$.ajax({
				type:"post",
				url:"QueRenXiaDan.qian.do",
				data:formParam,
				dataType:"JSON",
				success:function(locList){
					var s;
					s='<table border="0px" width="100%" style="text-align: center;">'
						+'<tr>'
							+'<td>地址</td>'
							+'<td>收货人</td>'
							+'<td>电话</td>'
						+'</tr>';
					for(var i=0;i<locList.length;i++){
						
						var add = locList[i];
						if(i==0){
							s=s+'<tr>'
								+'<td width="33%" height="50px;" style="text-align: left;">&nbsp;<input type="radio"'
									+'name="loc_id" value="'+add.loc_id+'" checked="checked" />'
										+'<span style="font-size: 22;">'+add.local+'</span></td>'
								+'<td width="33%"><input type="hidden" name="rdocnee" value="'+add.loc_name+'">'+add.loc_name+'</td>'
								+'<td width="33%;"><input type="hidden" name="rdophone" value="'+add.phone +'">'+add.phone+'</td>'
							+'</tr>';
						}else{
						s=s
							+'<tr>'
								+'<td width="33%" height="50px;" style="text-align: left;">&nbsp;<input type="radio"'
									+'name="loc_id" value="'+add.loc_id+'" />'
										+'<span style="font-size: 22;">'+add.local+'</span></td>'
								+'<td width="33%"><input type="hidden" name="rdocnee" value="'+add.loc_name+'">'+add.loc_name+'</td>'
								+'<td width="33%;"><input type="hidden" name="rdophone" value="'+add.phone +'">'+add.phone+'</td>'
							+'</tr>';
						}
					}
					s=s+'</table>';
					$('#oldAddressDiv').html(s);
				}
		
			});
	}
	
	function jisuanTotal() {
		//获取所有的复选按钮
		var chks = document.getElementsByName("c_id");
		var total = 0;
		for (var i = 0; i < chks.length; i++) {
			//判断复选按钮是否被选中
			if (chks[i].checked == true) {
				var c_id = chks[i].value;
				${cart.c_id }
				var xiaoji = document.getElementById("c_total_" + c_id).value;
				total += parseInt(xiaoji);
			}
		}
		//为合计赋值
		document.getElementsByName("total")[0].value = total;
		//${total } = total;
	}
</script>
  </body>
</html>
