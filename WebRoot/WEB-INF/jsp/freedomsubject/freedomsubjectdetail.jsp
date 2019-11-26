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
		<link rel="stylesheet" type="text/css" href="css/freedomsubject/freedomsubjectdetail.css" />
		<script src="js/echarts.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<!-- <script type="text/javascript" src="js/isWeixin.js"></script> -->
		<script type="text/javascript" src="js/freedomsubject/freedomsubjectdetail.js"></script>
		<title>猫咪宝详情</title>
		
	</head>

	<body>
	<input type="hidden" id="basePath" value="<%=basePath%>" />
	<input type="hidden" id="rates" value="${rates}">
	<input type="hidden" id="dates" value="${dates}">
	<form method="post" action="" id="form1" >
   	  <input type="hidden" id="freedomSubjectId" name="freedomSubjectId" value="${fBean.freedomSubjectId }">
   	  <input type="hidden" id="type" name="type" value="">
  	</form>
		<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()"/>${fBean.freedomSubjectName }
			</div>
			<div class="headInfor">
				<p>昨日七日年化收益率（%）</p>
				<p>${fBean.freedomRate }</p>
				<div class="headInforbox">
					<div class="headInforbox-left">
						<p>起投金额（元）</p>
						<p>${fBean.freedomOriginMoney }</p>
					</div>
					<div class="headInforbox-right">
						<p>开放额度（元）</p>
						<p>${fBean.freedomSurplusMoney }</p>
					</div>
				</div>

			</div>
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th><img src="images/mmb-icon1.png" /></th>
					<th><img src="images/mmb-icon2.png" /></th>
					<th><img src="images/mmb-icon3.png" /></th>
				</tr>
				<tr>
					<td>随存随取</td>
					<td>无手续费</td>
					<td>收益稳健</td>
				</tr>
			</table>

			<div class="income">
				<div id="tab">
					<div class="tabList">

						<ul>
							<li class="cur program_1" onclick="flag(1)" id="sevenRates">近七日年化收益率</li>
							<li class="program_2" onclick="flag(2)" id="sevenProfit">万份收益</li>
						</ul>
					</div>
					<div class="tabCon">
						<div class="program_1_con" id="main" style="width: 100%;height: 300px;">

						</div>

						<div class="program_2_con">
							<ul>
								<c:forEach items="${rspList}" var="sj">
								<li>
									<span class="time">${sj.freedomDate} </span>
									<span class="count">${sj.dayReturns}（元）</span>
								</li>
								</c:forEach>
								
								<li class="lookmore" style="border-bottom: none;" onclick="queryMore(${fBean.freedomSubjectId})">
									查看更多 >
								</li>
							</ul>
						</div>
					</div>
				</div>

			</div>
			<div class="introduce">
				<p class="title-tips">产品介绍</p>
				<div class="text-tips">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;猫咪宝是猫咪财富一款1元起投、随存随取，能让零钱生息的特色产品。猫咪宝投资和转出都非常灵活方便，每天收益会计入可用余额。投资者随时可以将猫咪宝余额转至可用余额，或者提现至银行卡，无任何手续费。
				</div>
			</div>
			<div class="rule">
				<p class="title-tips">收益与交易规则</p>
				<img src="images/mmb-step.png" />
				<div class="income-in">
					<div>转入</div>
					<div>现在买入，次日计算收益，第三天发放收益。</div>
				</div>
				<div class="income-out">
					<div>转出</div>
					<div>转出到可用余额：不限额度，不限次数，方便快捷，60分钟内返回您的钱包账户“可用余额”; 转出到银行卡：14:00~15:00提现当日到账，15:00后提现，次日到账。</div>
				</div>
			</div>

			<div class="teamdata" onclick="queryFreedomRecord(${fBean.freedomSubjectId })">
				<p>投团记录</p>
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>累计入团</th>
						<th>累计投资</th>

					</tr>
					<tr>
						<td>${fightGroup }人</td>
						<td><fmt:formatNumber type="number" value="${fBean.freedomSubjectMoney-fBean.freedomSurplusMoney }" maxFractionDigits="2"></fmt:formatNumber>元</td>
					</tr>
				</table>
			</div>
			
			<div class="jiedai" onclick="goDispersionSubject(${fBean.freedomSubjectId })">
				<p>借贷项目</p>
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th><img src="images/mmb-circle1.png"/></th>
						<th>
							<h4>共计投资分散标</h4>
							<h4>${count }标</h4>
						</th>
						<th><img src="images/mmb-Untitled.gif" height="100px"/></th>

					</tr>
					
				</table>
			</div>

			<div class="help">
				<p onclick="goHelp(${fBean.freedomSubjectId})">常见问题 <span> <img src="images/go.png"/></span></p>
			</div>
			<a href="javascript:turnIn(${fBean.freedomSubjectId },1,${fBean.freedomSubjectStatus})">转入</a>
		</div>
	</body>

</html>