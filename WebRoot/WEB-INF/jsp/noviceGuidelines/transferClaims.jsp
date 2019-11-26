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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/commonStyle.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<style type="text/css">
li {
	list-style: none;
	width: 100%;
	margin-top: 10px;
	color: gray;
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
			<img src="<%=basePath%>images/back.png" id="back" onclick="goBack()" />债权转让指引
		</p>
		<ul>
			<li><img src="<%=basePath%>images/AYEFEW1GS2BO1851BCGGYTI8.png" />
				<h5>Tips：如果您临时需要动用资金，可以去我的投资转让债权</h5></li>
			<li><img src="<%=basePath%>images/GNXVFE161XFESY11D2M5J28.png" />
				<h5>Tips：转让成功后可在我的债权转让中查看，如急于用钱，可选择加急，或平台转让</h5></li>
			<li><img src="<%=basePath%>images/YDQJPOYM8LWDXQWVL6K6H2N.png" />
				<h5>Tips：您也可以在债权转让中查看，或承接别人的债权</h5></li>
			<li></li>
			<li>
				<h3>问答</h3>
				<h5>Q：加急和平台有什么要求么？</h5>
				<h5>A：加急就是您的转让信息置顶，让别人能第一时间看到你的债权。平台接盘就是直接由平台接收，平台会扣去一些利率</h5>
			</li>
			<li>
				<h5>Q：债权接收也会有鱼干奖励么？</h5>
				<h5>A：是的，债权接收也视为投资投标</h5>
			</li>

			<li>
				<h5>Q：债权转让可以转让部分么？</h5>
				<h5>A：是可以的，可以转让部分，也可以转让全部</h5>
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