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
<title>我要理财-起息时间</title>
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
	<p>投资成功后，什么时候开始计息？</p>
	<div class="database-text">
		投资成功的项目，在该项目满标并审核后开始计息。
	</div>
</div>
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>

</html>
