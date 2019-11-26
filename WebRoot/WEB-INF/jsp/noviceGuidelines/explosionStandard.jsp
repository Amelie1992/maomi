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

img {
	width: 100%;
}

h5 {
	text-align: left;
	padding-left: 10px;
	font-weight: normal;
}
</style>
</head>
<body>
	<div id="wrap">
		<p>
			<img src="<%=basePath%>images/back.png" id="back" onclick="goBack()" />爆款标指引
		</p>
		<ul>
			<li><img src="<%=basePath%>images/3FESWFEZB82BADC]FDBRUAT.png" />
				<h5>Tips：爆款标时没有利率的，他的收益是实物</h5></li>
			<li><img src="<%=basePath%>images/EF8S6E8SJPFVC2216MUM3BU.png" />
				<h5>Tips：在这里选择你要兑换的数量，并填写好你的收获地址</h5></li>
			<li></li>
			<li>
				<h3>问答</h3>
				<h5>Q：请问这个实物是什么时候发过来？</h5>
				<h5>A：当您投标成功时，我们就有客服联系您，确认收获地址</h5>
			</li>
			<li>
				<h5>Q：支持包邮么？</h5>
				<h5>A：包邮的亲</h5>
			</li>
			<li>
				<h5>Q：如果商品质量不好怎么办，能退么？</h5>
				<h5>A：您可以与客服联系</h5>
			</li>
		</ul>
	</div>
</body>
<script type="text/javascript">
function goBack(){
	window.location.href='<%=basePath%>noviceGuidelines/s/tenderGuide';
}
</script>
</html>