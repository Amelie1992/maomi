<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>我的邀请</title>
<style type="text/css">
.title {
	width: 100%;
	position: relative;
	text-align: center;
	font-size: 20px;
	color: #333333;
	font-weight: 600;
	height: 50px;
	line-height: 50px;
	background-color: #F7F7F7;
}

.back {
	position: absolute;
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}
.wdyq-box {
	padding: 10px 0;
	border-bottom: 1px solid #E0E0E0;
}

.byqr-name {
	padding: 13px 0 30px 15px;
	font-size: 16px;
	color: #212121;
}

#progressBar {
	width: 100%;
	position: relative;
	margin: 0 auto;
}

#progressBar div {
	width: 70%;
	height: 1px;
	position: absolute;
	top: 4%;
	left: 15%;
	margin: 0 auto;
	background: #ccc;
}

#progressBar div span {
	position: absolute;
	display: inline-block;
	height: 1px;
	width: 25%;
}

#progressBar>span {
	position: absolute;
	top: 0;
	margin-top: -10px;
	margin-left: -20px;
	color: #fff;
}

#progressBar>span img {
	width: 23px;
	height: 23px;
}

#progressBar>span:nth-child(2) {
	left: 20%;
}

#progressBar>span:nth-child(3) {
	left: 52%;
}

#progressBar>span:nth-child(4) {
	left: 85%;
}

#progressBar table {
	width: 95%;
	text-align: center;
	margin: 0 auto;
}

#progressBar table th {
	padding-top: 25px;
}

.wdyq-su {
	display: inline-block;
	width: 24px;
	height: 24px;
	background-image: url(images/wdyq-su.png);
	background-size: 100% 100%;
	background-position: center;
	background-repeat: no-repeat;
}

.wdyq-fa {
	display: inline-block;
	width: 24px;
	height: 24px;
	background-image: url(images/wdyq-fa.png);
	background-size: 100% 100%;
	background-position: center;
	background-repeat: no-repeat;
}
</style>
</head>

<body>
	<div class="wrap">
		<div class="title">
			<img src="images/back.png" class="back" onclick="getBack()" />我的邀请
		</div>
		<c:forEach items="${friends}" var="f">
			<div class="wdyq-box">
				<p class="byqr-name">
					<c:choose>
						<c:when test="${f.realName==null || f.realName ==''}">${f.telephone}</c:when>
						<c:otherwise>${f.realName}</c:otherwise>
					</c:choose>
				</p>
				<div id="progressBar">
					<!-- 进度条 -->
					<div class="wdyq-line"></div>
					<!-- 五个圆 -->
					<span class="wdyq-su"></span>
					<c:choose>
						<c:when test="${f.realName!=null && f.realName !=''}"><span class="wdyq-su"></span></c:when>
						<c:otherwise><span class="wdyq-fa"></span></c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${f.accountWX!=null && f.accountWX !=''}"><span class="wdyq-su"></span></c:when>
						<c:otherwise><span class="wdyq-fa"></span></c:otherwise>
					</c:choose>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>好友注册</th>
							<th></th>
							<th>实名认证</th>
							<th></th>
							<th>完成出借</th>
						</tr>
					</table>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
<script type="text/javascript">
	//返回
	function getBack() {
		window.location.href = '<%=basePath%>loginregister/invitingfriends';
	}
	
	function goChack(){
		window.location.href = '<%=basePath%>loginregister/checkFriends';
	}
</script>

</html>