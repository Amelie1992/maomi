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

<title>猫咪财富-圣诞节</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
.wrap{
	position: relative;
	text-align: center;
}
.wrap img{
	display:block;
	width: 100%;
}
.wrap .btn{
	text-align: center;
	width: 100%;
	position: absolute;
	bottom: 14%;
	left: 25%;
}
.wrap .btn img{
	width: 50%;
}
.wrap .rule{
	position: absolute;
	bottom: 0%;
	padding: 5%;
}
.rule ul li{
	text-align: left;
	color: white;
	font:normal 14px/18px Tahoma, Geneva, sans-serif;
}
.rule-title{
	text-align: center;
	color: white;
	padding-bottom: 15px;
}
</style>
</head>

<body>
<div class="wrap">
			<img src="images/activity/mmcf_wx_sdj_bg.jpg" >
			<div class="btn" onclick="querySubject();">
				<img src="images/activity/mmcf_wx_sdj_btn.png" >
			</div>
			<div class="rule">
				<p class="rule-title">活动规则</p>
				<ul>
					<li>1.投资金额和上述表中投资金额相等才可以获得对应奖励。</li>
					<li>2.无限制次数的活动可重复参与，上不封顶。</li>
					<li>3.加息券的使用期限为两个月。</li>
					<li>4.现金券和加息券会在活动结束后3个工作日内发放。</li>
					<li>5.本活动最终解释权归猫咪财富所有。</li>
				</ul>
			</div>
		</div>
</body>
<script type="text/javascript">
function querySubject() {
	window.location.href='./subject/s/querysubject';
}
</script>
</html>
