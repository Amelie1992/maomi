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

<title>涨薪宝</title>
<link rel="stylesheet" type="text/css" href="css/commonStyle.css"/>
<style type="text/css">
			.wrap {
				width: 100%;
				position: relative;
			}
			
			.wrap img {
				width: 100%;
			}
			
			.wrap a {
				-moz-box-shadow: inset 0px 1px 0px 0px #fff6af;
				-webkit-box-shadow: inset 0px 1px 0px 0px #fff6af;
				box-shadow: inset 0px 1px 0px 0px #fff6af;
				
				background-color: #ffbc13;
				-moz-border-radius: 6px;
				-webkit-border-radius: 6px;
				border-radius: 20px;
				/*border: 1px solid #ffaa22;*/
				display: inline-block;
				cursor: pointer;
				color: white;
				font-family: Arial;
				font-size: 16px;
				/*font-weight: bold;*/
				width: 50%;
				height: 40px;
				line-height: 40px;
				text-align: center;
				text-decoration: none;
				text-shadow: 0px 1px 0px #ffee66;
			}
			
			.wrap a:active {
				position: relative;
				top: 1px;
			}
			.wrap a:nth-of-type(1){
				position: absolute;
				top: 38%;
				left: 25%;
			}
			.wrap a:nth-of-type(2){
				position: absolute;
				top: 68%;
				left: 25%;
			}
			.wrap a:nth-of-type(3){
				position: absolute;
				top: 95%;
				left: 25%;
			}
			
	</style>
</head>

<body>
		<div class="wrap">
			<img src="images/gzlc.png" />
			<a href="<%=basePath%>loginregister/s/toLogin" class="login">登陆体验</a>
			<a href="<%=basePath%>subject/s/querysubject" class="ty">立即投资</a>
			<a href="<%=basePath%>withdraw/rechargeInfo" class="tx">去提现</a>
		</div>
</body>
<script type="text/javascript">
	function goBack(){
		window.location.href='<%=basePath%>capital/querycapital';
	}
</script>
</html>
