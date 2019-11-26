<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>"><meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>邮箱认证</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html, body {
	/*background-color: whitesmoke;*/
	width: 100%;
	text-align: center;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
}

.back {
	position: absolute;
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}

#wrap p:nth-child(1) {
	font-size: 20px;
	color: #333333;
	background-color: #F7F7F7;
	text-align: center;
	padding: 10px;
}

#wrap {
	width: 100%;
}

#wrap img {
	width: 90%;
	margin: 0 auto;
}

#wrap li {
	padding: 10px 0;
}

.btns {
	width: 50%;
	font-size: 14px;
	line-height: 30px;
	height: 30px;
	text-align: center;
	color: white;
	background-color: #FEC63D;
	border: 1px solid #FEC63D;
	border-radius: 2px;
}

#wrap a {
	font-size: 12px;
	color: #808080;
}
</style>
</head>

<body>
<div id="wrap">
			<ul>
				<li><img src="images/yirenzheng.png" /></li>
				<li>您的认证邮箱为:</li>
				<li>${accountEmail}</li>
				<!-- <li style="text-align: right;padding-right: 10%;">
					<span>
						<a href="<%=basePath%>emailcheck/judgeEmailIsVerification">修改绑定邮箱</a>
					</span>
				</li> -->
				<li>
					<input type="button" onclick="getBack()" class="btns" id="" value="返回" />
				</li>
			</ul>
		</div>
</body>
<script type="text/javascript">
function getBack(){
	window.location.href='<%=basePath%>accountinfo/moreInfo';
}
</script>
</html>
