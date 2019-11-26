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
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/scorecenter/scoreCenter.css" />
<script type="text/javascript" src="js/scorecenter/scoreCenter.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>鱼干中心</title>
</head>

<body>
<input type="hidden" id="basePath" value="<%=basePath%>" />

	<div class="wrap">
			<div class="title">
				<a href="javascript:getBack();"><img src="images/back.png" class="back" /></a>我的鱼干
			</div>
			<div class="head">
				<p>${accountInfo.accountScore}</p>
				<img src="images/yg.png" />
				<p>
					<a href="javascript:toScoreDetail();">查看鱼干明细 >></a>
				</p>
			</div>
			<div class="operation">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="toScoreRecord()"><img src="images/dhjl.png" /></th>
						<th onclick="toScoreDraw()"><img src="images/ygcj.png" /></th>
						<th onclick="toScoreExplain()"><img src="images/ygsm.png" /></th>
					</tr>
					<tr>
						<td onclick="toScoreRecord()">中奖记录</td>
						<td onclick="toScoreDraw()">鱼干抽奖</td>
						<td onclick="toScoreExplain()">鱼干说明</td>
					</tr>
				</table>
			</div>
			<div class="buyfish">
				<p>
					<a href="javascript:toBuyScore();" class="buyfishBtn">
						<span><img src="images/fish.png"/></span>购买鱼干
					</a>
				</p>
			</div>
		</div>
</body>
</html>
