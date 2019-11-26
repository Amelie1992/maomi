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

<title>猫咪财富-感恩回馈月</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
.wrap{
	position: relative;
}
.wrap img{
	width: 100%;
	display: block;
}
.wrap .btn{
	position: absolute;
	width: 100%;
	bottom: 3%;				
}
.wrap .btn img{
	width: 160px;
	height: 50px;
	margin: 0 auto;
}
</style>
</head>

<body>
<div class="wrap">
	<img src="images/mmcf-12-wx-bgg.png" >
	<p class="btn" onclick="querySubject()"><img src="images/mmcf-12-wx-btnn.png" ></p>
</div>
</body>
<script type="text/javascript">
function querySubject() {
	window.location.href='./subject/s/querysubject';
}
</script>
</html>
