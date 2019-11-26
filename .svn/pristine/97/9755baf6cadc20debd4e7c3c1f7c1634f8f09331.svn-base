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
		<link rel="stylesheet" type="text/css" href="css/freedomsubject/turnout.css" />
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/validate.js"></script>
		<script type="text/javascript" src="js/isWeixin.js"></script>
		<script type="text/javascript" src="js/freedomsubject/turnout.js"></script>
		
		<title>猫咪宝转出</title>
		
	</head>

	<body>
		<input type="hidden" id="basePath" value="<%=basePath%>" />
		<input type="hidden" id="allMoney" value="${capitalBean.freedomMoney}" />
		<input type="hidden" id="limitMoney" value="${fBean.freedomRestrictMoney}" />
		<input type="hidden" id="freedomOriginMoney" value="${fBean.freedomOriginMoney}" />
		<input type="hidden" id="freedomSurplusMoney" value="${fBean.freedomSurplusMoney}" />
		<form method="post" action="" id="form1" >
			<input type="hidden" name="inputMoney" id="inputMoney">
			<input type="hidden" id="freedomSubjectId" name="freedomSubjectId" value="${fBean.freedomSubjectId}">
   		</form>
		<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()"/>${fBean.freedomSubjectName }
			</div>
			<div class="content">
				<p>转出金额 <input type="text" name="" id="transferMoney" value="" placeholder="请输入转出金额，最低1元" /></p>
				<p>转出方式 <input type="radio" name="way" id="" value="1" /> <span>转出至可用余额</span><input type="radio" name="way" id="" value="2" /> <span>转出至银行卡</span></p>
			</div>
			<p class="ktxje">
				猫咪宝余额(元)：${capitalBean.freedomMoney}
				
				<span onclick="transferAll()">全部转出</span>
				
			</p>

			<a href="javascript:turnout()">确认转出</a>
			<div class="textbox">
				<p>温馨提示</p>

				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;转出到可用余额：不限额度，不限次数，方便快捷，60分钟内返回您的钱包账户“可用余额”; 转出到银行卡：14:00~15:00提现当日到账，15:00后提现，次日到账。</p>

				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;使用猫咪宝支付时，赎回猫咪宝将遵循先进先出的原则，优先赎回最早投资的猫咪宝份额。</p>
			</div>
		</div>
	</body>
	
	


</html>