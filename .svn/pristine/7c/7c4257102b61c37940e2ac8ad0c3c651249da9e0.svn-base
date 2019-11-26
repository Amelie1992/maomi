<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>意见反馈</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

html, body {
	width: 100%;
	text-align: center;
	position: relative;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
	height: 40px;
	line-height: 40px;
}

th {
	font-weight: normal;
}

.back {
	position: absolute;
	left: 20px;
	top: 15px;
	width: 11px;
	height: 16px;
}

.go {
	width: 20px;
	height: 24px;
	border: none;
	padding-top: 9px;
}

img {
	
}

.title_li {
	border-bottom: 1px solid #EEEEEE;
	font-size: 20px;
	color: #333333;
	background-color: #F6F6F6;
}

.body_li {
	border-bottom: 1px solid #EEEEEE;
}

.d_left {
	padding-left: 8px;
	float: left;
	width: 28%;
	color: #555555;
	font-size: 14px;
	text-align: left;
	height: 40px;
}

.d_text2 {
	float: left;
	width: 60%;
	text-align: right;
	font-size: 12px;
	color: #808080;
	height: 40px;
	line-height: 20px;
}

.d_text {
	float: left;
	width: 60%;
	text-align: right;
	font-size: 12px;
	color: #808080;
	height: 40px;
}

.d_img {
	width: 8%;
	float: right;
	height: 40px;
}

</style>
<script type="text/javascript">
	//返回上一页
	function getBack(){
		window.location.href='<%=basePath%>loginregister/s/goCustomer';
	}
	
	//奖励公示
	function goReward(){
		window.location.href='<%=basePath%>proposalrecord/s/goproposalreward';
	}
	
	//反馈说明
	function goExplan(){
		window.location.href='<%=basePath%>proposalrecord/s/goproposalexplain';
	}
	
	//立即反馈
	function goRecord(){
		window.location.href='<%=basePath%>proposalrecord/s/goproposalrecord';
	}
</script>
</head>

<body>
		<div id="wrap">
			<ul>
				<li class="title_li"><a href="javascript:getBack();"><img src="images/back.png" class="back" /></a>意见反馈</li>
				<!-- <li onclick="goReward();" class="body_li">
					<div class="d_left">
						奖励公示
					</div>
					<div class="d_text">
					</div>
					<div class="d_img">
						<img src="images/go.png" class="go"/>
					</div>
				</li> -->
				<li class="body_li" onclick="goExplan()">
					<div class="d_left">
						反馈说明
					</div>
					<div class="d_text">
					</div>
					<div class="d_img">
						<img src="images/go.png" class="go"/>
					</div>
				</li>
				<li class="body_li" onclick="goRecord()">
					<div class="d_left">
						立即反馈
					</div>
					<div class="d_text">
					</div>
					<div class="d_img">
						<img src="images/go.png" class="go"/>
					</div>
				</li>
			</ul>
	</div>
</body>
</html>
