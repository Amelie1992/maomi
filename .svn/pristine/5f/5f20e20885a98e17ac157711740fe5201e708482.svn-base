<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<title>特权介绍</title>
		<style type="text/css">
			.wrap{
				width: 100%;
				/* background-color: #161616; */
				background-image: url(images/vip-func-bg.png);
				background-size: 100% 100%;
				background-position: center;
				background-repeat: no-repeat;
				text-align: center;
			}
			@media only screen and (min-height: 737px) and (max-height: 812px) {
				.wrap{				
				padding-top: 44px;
			}
			}
			.wrap img{
				width: /* 100% */ 92%;
				padding-top: 25px;				
			}
		</style>
	</head>
	<body>
		<div class="wrap">
			<img src="images/vip-func-${m}.png"/>
		</div>
	</body>
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	$(window).load(function(){
		$('.wrap').css('height',$(document).height());
	});
	</script>
</html>
