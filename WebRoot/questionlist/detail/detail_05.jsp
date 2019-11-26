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
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<title>增值服务-邀请好友</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<style type="text/css">
.wrap {
	padding: 15px;
}
.wrap p{
	padding-bottom:15px ;
	font-size: 18px;
	color: #212121;
}
.wrap .database-text{
	color: #757575;
	font-size: 14px;
	line-height: 20px;
}
</style>

</head>

<body>
<div class="wrap">
	<p>如何才算邀请好友成功</p>
	<div class="database-text">
		在注册用户页面，用户必须正确填写邀请人的手机号码。
	</div>
</div>
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>

</html>
