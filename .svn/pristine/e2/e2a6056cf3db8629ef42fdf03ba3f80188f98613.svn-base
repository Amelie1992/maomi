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

<title>国庆中秋放假通知</title>
<link rel="stylesheet" type="text/css" href="css/commonStyle.css"/>
<style type="text/css">
	.wrap{
				width: 100%;
			}
			.notice-pic{
				width: 100%;
			}
			.title {
				width: 100%;
				position: relative;
				text-align: center;
				font-size: 16px;
				color: #333333;
				/*font-weight: 600;*/
				height: 40px;
				line-height: 40px;
				background-color: #F7F7F7;
			}
			
			.back {
				width: 10px;
				position: absolute;
				left: 20px;
				top: 10px;
			}
</style>
</head>

<body>
		<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()" />国庆中秋放假通知
			</div>
			<img src="images/wx-gq-notice.png" class="notice-pic"/>
		</div>
</body>
<script type="text/javascript">
	function goBack(){
		window.location.href='<%=basePath%>fontpage/s/queryFontPage';
	}
</script>
</html>
