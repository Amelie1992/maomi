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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/commonStyle.css" />
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
			<img src="<%=basePath%>images/back.png" id="back" onclick="goBack()" />普通投标指引
		</p>
		<ul>
			<li><img src="<%=basePath%>images/8FEZ0PAWGD93843VWTSMV1P.png" />
				<h5>Tips：根据自己的需求找到感兴趣的标，点击查看具体信息</h5></li>
			<li><img src="<%=basePath%>images/KWSXDQI0F8K85F8IWTOA7QD.png" />
				<h5>Tips：在这里可以看到标的具体信息</h5></li>
			<li><img src="<%=basePath%>images/NMEFZF6D15EQ0253OIJ10FH.png" />
				<h5>Tips：这是贷款人的信息</h5></li>
			<li><img src="<%=basePath%>images/XOGFNIEFSIVNCIXOAEFNIFI.png" />
				<h5>Tips：在这里可以自己输入投资金额</h5></li>
			<li></li>
			<li>
				<h3>问答</h3>
				<h5>Q：请问收益是怎么算的？</h5>
				<h5>A：当您投资的标满标时，开始获得收益，在标周期结束时，收益和本金会自动结算</h5>
			</li>
			<li>
				<h5>Q：请问投资有限制么？</h5>
				<h5>A：您可以投资同一个表任意次数，每次1元起投</h5>
			</li>

			<li>
				<h5>Q：请问我的标没有到期，临时缺钱怎么办？</h5>
				<h5>A：您可以返回查看债权转让指南</h5>
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