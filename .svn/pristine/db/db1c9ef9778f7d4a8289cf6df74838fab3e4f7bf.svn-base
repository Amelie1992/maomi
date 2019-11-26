<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<link rel="stylesheet" type="text/css" href="css/commonStyle.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" href="css/rule.css" />
<title>自动投标规则</title>

</head>
<body>
	
</body>
<div class="rulebox">
	<h3>一.自动投标排队规则</h3>
	<p>先筛选符合当前自动标投资条件的用户，然后在适合的用户中按照排名先后再次进行排序进行投标，以下几种情况将导致重新排队：</p>
	<div class="rule_tit"><img src="images/a@2x.png" alt="" />更改期限、金额</div>
	<div class="rule_tit"><img src="images/b@2x.png" alt="" />取消自动投标</div>
</div>
<div class="rulebox">
	<h3>二.投标期限区间设置</h3>
	<p>投资人可以按照自己的投资习惯对投资期限进行设置。<i>不限-不限 则视为1月-36个月</i>。因为自动投标只投精选理财和爆款标,并且只会自动投资月标。</p>
</div>
<div class="rulebox">
	<h3>三.部分中标情况介绍</h3>
	<p>当标的剩余可投金额小于投资人设置的投资金额，则按照标的剩余可投金额投资，将剩下的投资金额保留，排队顺序不变，留存下次，不会重新排队。如用户需要对剩余金额修改，则需要取消预约，重新设置，重新排队。</p>
</div>
<div class="rulebox">
	<h3>四.投标金额设置</h3>
	<p>根据用户VIP等级设置上限，<i>0级用户1000元档，每一级多5000元档</i>。设置后金额暂时存放在不可用金额中，如需手动投资或者转出，取消预约即可。</p>
</div>
<div class="rulebox">
	<h3>五.其他</h3>
	<p>自动投标不参加好友邀请投标奖励，猫咪储蓄，无法使用红包。鱼干奖励和VIP投资加息奖励无影响。</p>
	<p>自动投标成功后如需继续使用该功能，需要重新设置。</p>
</div>

</html>
