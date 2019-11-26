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
	<title>投标指南</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/commonStyle.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<style type="text/css">
img {
	width: 100%;
}

li {
	padding: 10px 30px 10px;
	border-top: 1px solid dodgerblue;
	position: relative;
}

h4 {
	text-align: left;
	padding-left: 20px;
	border-left: 2px dodgerblue solid;
	color: dodgerblue;
	padding-bottom: 5px;
}

h6 {
	text-align: left;
	padding-left: 20px;
	border-left: 2px dodgerblue solid;
	color: grey;
	font-weight: normal;
}

.more {
	position: absolute;
	top: 40%;
	right: 5%;
	width: 24px;
	margin-left: 98%;
}
</style>
</head>
<body>
	<div id="wrap">
		<p>
			<img src="<%=basePath%>images/back.png" id="back" onclick="goBack()" />投标指引
		</p>
		<ul>
			<li><img src="<%=basePath%>images/cnm.jpg" /></li>
			<li onclick="noviceMark()">
				<h4>新手标</h4>
				<h6>
					新手专享标，低门槛，简单操作<img src="<%=basePath%>images/more.png"  class="more"/>
				</h6>
				<h6>每人只限投两次</h6>

			</li>
			<li onclick="commonStandard()">
				<h4>精选理财</h4>
				<h6>
					定期理财，选择多，收益稳定<img src="<%=basePath%>images/more.png" class="more"/>
				</h6>
				<h6>可操作</h6>

			</li>
			<li onclick="explosionStandard()">
				<h4>爆款标</h4>
				<h6>
					0元购商品，各种精美商品等你来拿<img src="<%=basePath%>images/more.png"  class="more"/>
				</h6>
				<h6>即投即得</h6>

			</li>
			<li onclick="automaticBidding()">
				<h4>自动投标</h4>
				<h6>
					把你的要求告诉我们，我们帮你选<img src="<%=basePath%>images/more.png"  class="more"/>
				</h6>
				<h6>释放双手，释放大脑，远离茫茫标海</h6>

			</li>

			<img src="<%=basePath%>images/ditu.jpg" />

		</ul>
	</div>
</body>
<script type="text/javascript">
	function noviceMark(){
		window.location.href='<%=basePath%>noviceGuidelines/s/noviceMark';
	}
	function commonStandard(){
		window.location.href='<%=basePath%>noviceGuidelines/s/commonStandard';
	}
	function explosionStandard(){
		window.location.href='<%=basePath%>noviceGuidelines/s/explosionStandard';
	}
	function automaticBidding(){
		window.location.href='<%=basePath%>noviceGuidelines/s/automaticBidding';
	}
	function goBack(){
		window.location.href='<%=basePath%>noviceGuidelines/s/noviceGuidelines';
	}
</script>
</html>