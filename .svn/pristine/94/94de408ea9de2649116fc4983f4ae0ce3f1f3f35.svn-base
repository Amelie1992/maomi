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
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script type="text/javascript" src="js/isWeixin.js"></script>
<link rel="stylesheet" type="text/css" href="css/integralscore/integralscore.css" />
<script type="text/javascript" src="js/integralscore/integralscore.js"></script>
<script src="js/layer/layer.js"></script>
<script src="js/checkgold/checkgold.js"></script>
<title>购买鱼干</title>
</head>

<body>
<input type="hidden" id="basePath" value="<%=basePath%>" />
<input type="hidden" id="realMoney" value="" />
<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="getBack()" />购买鱼干
			</div>
			<div class="currentAccount">
				当前账户:<span>${accountInfo.accountName}</span>
			</div>
			
			<div class="getYugan">
				<span>可获得鱼干</span>
				<span><span id="showScore">0</span>鱼干</span>
			</div>
			<div class="currentYugan">
				现有鱼干: <span>${accountInfo.accountScore}鱼干</span>
			</div>
			<div class="chongzhi">
				<div onclick="quickCountScore(100)">100元</div>
				<div onclick="quickCountScore(500)">500元</div>
				<div onclick="quickCountScore(1000)">1000元</div>
				<div onclick="quickCountScore(2000)">2000元</div>
			</div>
			<div class="chongzhi1">
				<div><input type="text" name="money" id="money" value="" maxlength="20" placeholder="其他整数金额"  onkeyup="countScore()" onfocus="clearScore()"/></div>
			</div>
			<div class="zhifu">
				余额支付:<span><span id="showMoney">0</span>元</span>
				<span>余额:${balance}元</span>
			</div>
			<div class="ljgm">
				<a href="javascript:recharge();" class="goumaiBtn">立即购买</a>
			</div>
		</div>
</body>
</html>
