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

<title>提现成功</title>
<style type="text/css">
.wrap {
	width: 100%;
	height: 100%;
}

.payPic {
	width: 80%;
	margin: 0 auto;
}

.wrap img {
	width: 100%;
	margin-left: auto;
	margin-right: auto;
}

.payTips {
	width: 100%;
	text-align: center;
	margin-top: 20px;
}

.back {
	width: 100%;
	text-align: center;
}

.backBtn {
	width: 80%;
	height: 40px;
	border: 1px solid #ffc040;
	background-color: #ffc040;
	border-radius: 5px;
	font-size: 20px;
	color: white;
	margin-top: 100px;
	margin-bottom: 20px;
}
</style>
</head>

<body>
	<div class="wrap">
		<div class="payPic">
			<img src="images/zhifu1.png" />
		</div>
		<div class="payTips">提现成功</div>
		<div class="back">
			<input type="button" class="backBtn" onclick="goBack()" id="" value="返回首页" />
		</div>
	</div>
</body>
<script type="text/javascript">
	function goBack(){
		window.location.href='<%=basePath%>fontpage/s/queryFontPage';
	}
</script>
</html>
