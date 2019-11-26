<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" type="text/css" href="css/freedomsubject/turnin.css" />
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/validate.js"></script>
		<script type="text/javascript" src="js/isWeixin.js"></script>
		<script type="text/javascript" src="js/freedomsubject/turnin.js"></script>
		
		<title>猫咪宝转入</title>
		
	</head>

	<body>
		<input type="hidden" id="basePath" value="<%=basePath%>" />
		<input type="hidden" id="availableBalance" value="${capitalBean.availableBalance }" />
		<input type="hidden" id="limitMoney" value="${fBean.freedomRestrictMoney}" />
		<input type="hidden" id="freedomOriginMoney" value="${fBean.freedomOriginMoney}" />
		<input type="hidden" id="freedomSurplusMoney" value="${fBean.freedomSurplusMoney}" />
		<input type="hidden" id="todayLimitMoney" value="${todayLimitMoney}" />
		<input type="hidden" id="todayAllMoney" value="${todayAllMoney}" />
		<input type="hidden" id="type" value="${type }" />
		<form method="post" action="" id="form1" >
			<input type="hidden" name="inputMoney" id="inputMoney">
			<input type="hidden" id="freedomSubjectId" name="freedomSubjectId" value="${fBean.freedomSubjectId}">
   		</form>
		<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack(${type })"/>${fBean.freedomSubjectName }
			</div>
			<div class="content">
				<p>转入金额 <input type="text" name="" id="imoney" value="" placeholder="请输入转入金额，最低1元" /></p>
				<p>支付方式 <input type="radio" name="way" id="" value="" checked/> <span>账户余额</span></p>
			</div>
			<p class="ktxje">
				<span style="color: #333333;">可用余额(元)：${capitalBean.availableBalance }</span>
				<span onclick="toRecharge()"style="float:right;">我要充值</span>
				<span onclick="investAll()" style="float:right;">全部投资</span>
			</p>
			

			<a href="javascript:turnInMoney(${fBean.freedomSubjectId })">确认转入</a>
			<div class="today-turnin">今日已转入(元)：<span>${todayAllMoney}</span></div>
			<div class="textbox">
				<p>温馨提示</p>

				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;猫咪宝1元起投，单笔最高5000元，当日最高50000元，投资成功次日计息，第三天发放收益。</p>

				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;猫咪宝支持可用余额支付，若可用余额不足可选择"我要充值"先充值可用余额。</p>
			</div>
		</div>
	
	</body>
	
	


</html>