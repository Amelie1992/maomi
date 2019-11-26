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

<title>营业执照</title>
<link rel="stylesheet" type="text/css" href="css/commonStyle.css"/>
<style type="text/css">
	.wrap {
				width: 100%;
			}
	.title {
				background-color: #6DA6EF;
				width: 100%;
				position: relative;
				text-align: center;
				font-size: 20px;
				color: white;
				font-weight: 600;
				height: 50px;
				line-height: 50px;
			}
			.back {
				position: absolute;
				left: 20px;
				top: 20px;
				width: 10px;
				height: 15px;
			}
			.promote{
				width: 100%;
			}
</style>
</head>

<body>
		<div id="wrap">
			<div>
				<img src="images/yingyezhizhao.jpg" class="promote"/>
			</div>
		</div>
</body>
<script type="text/javascript">
	function goBack(){
		window.location.href='<%=basePath%>capital/querycapital';
	}
</script>
</html>
