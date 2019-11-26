<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<script type="text/javascript" src="js/navigation.js"></script>
<title>鱼干商城</title>
<link rel="stylesheet" type="text/css" href="css/commonStyle.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/navigation.css"/>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html, body {
	background-color: whitesmoke;
	width: 100%;
	text-align: center;
}

img {
	width: 100%;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
}

#back {
	width: 30px;
	height: 30px;
	border: none;
	float: left;
}

#wrap>ul>li:nth-child(1) {
	background-color: dodgerblue;
}

.table_left {
	text-align: left;
}

.table_right {
	float: right;
}

.myButton {
	-moz-box-shadow: 0px 1px 0px 0px #f0f7fa;
	-webkit-box-shadow: 0px 1px 0px 0px #f0f7fa;
	box-shadow: 0px 1px 0px 0px #f0f7fa;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #33bdef
		), color-stop(1, #019ad2));
	background: -moz-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background: -webkit-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background: -o-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background: -ms-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background: linear-gradient(to bottom, #33bdef 5%, #019ad2 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bdef',
		endColorstr='#019ad2', GradientType=0);
	background-color: #33bdef;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: 1px solid #057fd0;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 14px;
	font-weight: bold;
	padding: 6px 24px;
	text-decoration: none;
	text-shadow: 0px -1px 0px #5b6178;
}

.myButton:active {
	position: relative;
	top: 1px;
}
</style>
<script type="text/javascript">
			function backMyCenter(){
				window.location.href="<%=basePath%>capital/querycapital";
			}
			function gotoconvert(obj){
				$("#goodsId").val(obj);
				$("#gotoconvertFrm").submit();
			}
		</script>
</head>

<body>
<input type="hidden" id="basePath" value="<%=basePath%>" />

	<form method="post" action="<%=basePath%>scoremarket/gotoconvert"
		id="gotoconvertFrm">
		<input type="hidden" name="goodsId" id="goodsId" value="">
	</form>
	<!-- <div id="wrap">
		<ul>
			<p>
				<img src="images/back.png" id="back" onclick="backMyCenter()" />鱼干商城
			</p>
			<li><img src="images/logo.png" /></li>
			<li>
				<table border="0" cellspacing="10" cellpadding="">
					<tr>
						<th class="table_left">我的鱼干：<b>${accountScore}</b></th>
						<th class="table_right"><a
							href="<%=basePath%>scoremarket/queryscoreconvertrecord">查看鱼干兑换记录</a>
						</th>
					</tr>
				</table>
			</li>

			<c:if test="${!empty goodsInfoList }">
				<c:forEach items="${goodsInfoList}" var="gi">
					<li onclick="gotoconvert(${gi.goodsId})">
						<table border="0" cellspacing="10" cellpadding="">
							<tr>
								<th style="width: 50%;"><img src="images/logo.png" /></th>
								<th style="width: 50%; text-align: right; padding: 20px;">
									<b>${gi.goodsName }</b>
									<p>${gi.goodsSpecs }</p>
									<p>
										&nbsp;&nbsp;&nbsp;剩余：<b style="color: black;">${gi.realStock }</b>
									</p>
									<p>
										所需鱼干：<b>${gi.saleMoney }</b>
									</p>
								</th>
							</tr>
						</table>
					</li>
				</c:forEach>
			</c:if>
		</ul>
	</div>-->
	<div id="wrap">
		<img src="images/comingsoon.png" />
	</div>
	<!-- 空白导航  防止被底部导航栏遮住内容 -->
	<!--<jsp:include page="../navigation/emptyDiv.jsp" flush="true" />-->
	<!-- 底部导航 -->
	<div class="footer">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="toChange(this,1)"><img src="images/tab_home_nor.png" /></th>
						<th onclick="toChange(this,2)"><img src="images/tab_touzi_nor.png" /></th>
						<th onclick="toChange(this,3)"><img src="images/tab_mall_sel.png" /></th>
						<th onclick="toChange(this,4)"><img src="images/tab_geren_nor.png" /></th>
					</tr>
					<tr>
						<td onclick="toChange(this,1)">首页</td>
						<td onclick="toChange(this,2)">投资</td>
						<td onclick="toChange(this,3)" class="currentChose" >商城</td>
						<td onclick="toChange(this,4)">我</td>
					</tr>
				</table>
			</div>

</body>

</html>