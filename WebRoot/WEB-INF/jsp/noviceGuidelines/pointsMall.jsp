<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>鱼干商城指南</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/commonStyle.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>

<style type ="text/css" >
li {
	list-style: none;
	width: 100%;
	margin-top: 10px;
	color: gray;
}

img {
	width: 100%;
}

h5 {
	text-align: left;
	padding-left: 10px;
}
</style>
</head>
<body>
	<div id="wrap">
		<p>
			<img src="<%=basePath%>images/back.png" id="back" onclick="goBack()" />鱼干商城指引
		</p>
		<ul>
			<li><img src="<%=basePath%>images/UOU9BKMNE9E8F7XQOP90WR.png" />
				<h5>Tips：消耗鱼干换取实物商品</h5></li>
			<li><img src="<%=basePath%>images/6X2KTCK1RO8B2Y8EDUWXU32.png" />
				<h5>Tips：选择您要换取的数量，填写好您的收货地址并确认</h5></li>
			<li></li>
			<li>
				<h3>问答</h3>
				<h5>Q：鱼干兑换的商品需要邮费么？</h5>
				<h5>A：是不需要邮费的</h5>
			</li>
			<li>
				<h5>Q：如果收货地址填写错误怎么办？</h5>
				<h5>A：打电话联系客服，更改收货地址</h5>
			</li>
			<li>
				<h5>Q：怎么获取鱼干？</h5>
				<h5>A：每日签到，投标和债权承接</h5>
			</li>

		</ul>
	</div>
</body>
<script type="text/javascript">
function goBack(){
	window.location.href='<%=basePath%>noviceGuidelines/s/noviceGuidelines';
}
</script>
</html>