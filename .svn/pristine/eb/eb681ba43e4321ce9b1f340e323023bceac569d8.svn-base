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
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<base href="<%=basePath%>">
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/isWeixin.js"></script>
		<link rel="stylesheet" type="text/css" href="css/commonStyle.css" />
		<title>用户鱼干兑换记录</title>
		<style type="text/css">
			table {
				width: 100%;
				height: 40px;
				font-size: 14px;
				color: gray;
				border-bottom: 2px solid dodgerblue;
				margin-bottom: 10px;
			}
			
			img{
				width: 100%;
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
				background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #33bdef), color-stop(1, #019ad2));
				background: -moz-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -webkit-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -o-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -ms-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: linear-gradient(to bottom, #33bdef 5%, #019ad2 100%);
				filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bdef', endColorstr='#019ad2', GradientType=0);
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
			#back {
				position: absolute;
				left: 20px;
				top: 18px;
				width: 10px;
				height: 15px;
			}
		</style>
		<script type="text/javascript">
			function backToGoodsList(){
				window.location.href="<%=basePath%>scorecenter/gotoscorecenter";
			}
		</script>
	</head>

	<body>
		<div id="wrap">
			<ul>
				<p><img src="images/back.png" id="back" onclick="backToGoodsList()"/>鱼干兑换记录</p>
				<li>
					<img src="images/logo.png" />
				</li>
				<li>
					<h4>兑换记录</h4>
				</li>
				<li>
					<table border="0" cellspacing="10" cellpadding="">
					
					<c:if test="${!empty goodsOrderList }">
					<c:forEach items="${goodsOrderList}" var="go">
						<tr>
							<th>${go.goodsName }</th>
							<th>数量:x${go.goodsNum }</th>
							<th colspan="2">
								<c:if test="${'0'==go.orderStatus }">交易关闭</c:if>
								<c:if test="${'1'==go.orderStatus }">已支付</c:if>
								<c:if test="${'2'==go.orderStatus }">已发货</c:if>
								<c:if test="${'3'==go.orderStatus }">已收货</c:if>
								<c:if test="${'4'==go.orderStatus }">已退款</c:if>
								<c:if test="${'5'==go.orderStatus }">退货</c:if> 
							</th>
						</tr>
						<tr>
							<th>${go.orderTime }</th>
							<th>${go.goodsMoney }鱼干</th>
						</tr>
					</c:forEach>
					</c:if>
						
					</table>
				</li>

			</ul>

		</div>
	</body>

</html>