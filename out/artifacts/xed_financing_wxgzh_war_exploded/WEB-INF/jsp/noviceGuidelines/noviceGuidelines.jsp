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
	font-weight: normal;
}
</style>
</head>
<body>
	<div id="wrap">
		<p>
			<img src="<%=basePath%>images/back.png" id="back" onclick="goBack()" />新手指引
		</p>
		<ul>
			<li onclick="tenderGuide()"><img style="width: 100%"
				src="<%=basePath%>images/20170505110807.jpg" /></li>
			<li>
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th><img onclick="transferClaims()" style="width: 100%"
							src="<%=basePath%>images/20170505110750.jpg" /></th>
						<th><img onclick="pointsMall()" style="width: 100%"
							src="<%=basePath%>images/20170505162507.jpg" /></th>
					</tr>
				</table>
			</li>
			<li>
				<h3>问答</h3>
				<h5>Q：你们这个平台都是做什么的？</h5>
				<h5>A：我们这个平台是做投资理财</h5>
			</li>
			<li>
				<h5>Q：风险高么？</h5>
				<h5>A：高收益，低风险</h5>
			</li>
			<li>
				<h5>Q：具体怎么操作？</h5>
				<h5>A：点击上方的指引，根据个人情况</h5>
			</li>
		</ul>
	</div>
</body>
<script type="text/javascript">
	function goBack(){
		window.location.href='<%=basePath%>capital/querycapital';
	}
	function tenderGuide(){
		window.location.href='<%=basePath%>noviceGuidelines/s/tenderGuide';
	}
	function pointsMall(){
		window.location.href='<%=basePath%>noviceGuidelines/s/pointsMall';
	}
	function transferClaims(){
		window.location.href='<%=basePath%>noviceGuidelines/s/transferClaims';
	}
</script>
</html>