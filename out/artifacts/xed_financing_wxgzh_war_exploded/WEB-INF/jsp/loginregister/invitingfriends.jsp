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
<title>邀请好友</title>
<style type="text/css">
.wrap {
	width: 100%;
	height: 100%;
}

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

.inner {
	width: 100%;
	background-color: #F0AD4E;
	padding-bottom: 20px;
	text-align: center;
}

.inner_head {
	background-image: url(images/yaoqinghaoyou_bg.png);
	background-size: 100% 100%;
	width: 100%;
	height: 300px;
}

.inner_text {
	width: 90%;
	margin: 0 auto;
	border-radius: 5px;
	background-color: white;
}

.inner_text table {
	width: 100%;
	text-align: left;
	line-height: 30px;
	color: #888888;
	letter-spacing: 2px;
}

.inner_text table span {
	font-size: 14px;
	color: #F2BB00;
}

.inner_text img {
	vertical-align: middle;
	margin-left: 10px;
	margin-right: 5px;
}

.inner p {
	width: 90%;
	margin: 0 auto;
	line-height: 20px;
	padding-top: 20px;
	color: white;
	text-align: left;
	letter-spacing: 1px;
}

.inner b {
	color: #F54749;
}

.inner .code {
	width: 200px;
	margin: 0 auto;
	padding-top: 20px;
}

.inner_text table tr th:nth-of-type(2) {
	text-align: right;
}

.inner_op {
	font-size: 15px;
	color: white;
	background-image: url(images/yqhy-op-bg.png);
	background-size: 100% 100%;
	width: 150px;
	height: 43px;
	line-height: 43px;
	margin: 20px auto;
}
</style>
</head>

<body>
	<input type="hidden" id="basePath" value="<%=basePath%>" />
	<div class="wrap">
		<div class="title">
			<img src="images/back.png" class="back" onclick="getBack()" />邀请好友
		</div>
		<div class="inner">
			<div class="inner_head"></div>
			<div class="inner_op" onclick="goChack()">
					我的邀请(${friendsCount}人)
			</div>
			<div class="inner_text">
				<table border="0" cellspacing="" cellpadding="">
					<%-- <tr>
						<th><span><img src="images/yaoqinghaoyou.png"
								width="24" height="24" /></span>已邀请好友</th>
						<th><span>${friendsCount}</span>人</th>
					</tr> --%>
					<tr>
						<th><span><img src="images/hyxjjl.png" width="24"
								height="24" /></span>已获得现金奖励</th>
						<th><span>${friendsMoney}</span>元</th>
					</tr>
					<tr>
						<th><span><img src="images/hyjxq.png" width="24"
								height="24" /></span>已获得加息券</th>
						<th><span><c:if test="${!empty friendsPercent}">${friendsPercent}</c:if>
								<c:if test="${empty friendsPercent}">0.0</c:if></span>%</th>
					</tr>
					<tr>
						<th><span><img src="images/haoyoutouzi.png" width="24"
								height="24" /></span>好友累计投资</th>
						<th><span>${friendsInvest}</span>元</th>
					</tr>
				</table>
			</div>

			<p>
				1.该受邀好友首次投资,邀请人可获得受邀人<b>所投本金的1%</b>将作为现金奖励,并额外获得<b>2%加息券</b>奖励.现金奖励自动发放至邀请人可用余额,加息券以优惠券形式自动发放至邀请人。
			</p>
			<p>
				2.该受邀好友第二次投资,邀请人可获得受邀人<b>所投本金的0.5%</b>将作为现金奖励,并额外获得<b>1%加息券</b>奖励.现金奖励自动发放至邀请人可用余额,加息券以优惠券形式自动发放至邀请人。
			</p>
			<p>平台新用户是指实名认证时所使用的身份证与在本平台第一次使用注册一致的用户.</p>
			<p>
				<b>长按下方二维码分享给好友。</b>
			</p>
			<img src="images/erweima.jpg" class="code" />

		</div>

	</div>
</body>
<script type="text/javascript">
	//返回
	function getBack() {
		window.location.href = $("#basePath").val() + 'capital/querycapital';
	}
	
	function goChack(){
		window.location.href = '<%=basePath%>loginregister/checkFriends';
	}
</script>

</html>