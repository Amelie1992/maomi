<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/activity/twoTwelve.css" />

<title>猫咪财富-双12回馈新老用户活动</title>

</head>
<div class="wrap">
			<div class="wrap-head">
				<img src="images/activity/twoTwelve/mmcf-12-wx-headbg.png">
			</div>
			<p style="text-align: center;font-size: 14px;color: #487dc0;padding: 15px 0;">您当前累计投资金额：<span style="color: #E3330B;">${iMoneySum}元</span></p>
			<input type="hidden" id="cout" value="${cout }">
			<div class="wrap-con">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>
							<div class="item">
								<span class="code-num">1</span>
								<p class="rate">2%</p>
								<p class="rate-tips">加息券</p>
								<span id="item1" class="item-btn">5000元档</span>
							</div>
						</th>
						<th>
							<div class="item">
								<span class="code-num">2</span>
								<p class="rate">5%</p>
								<p class="rate-tips">加息券</p>
								<span id="item2" class="item-btn">10000元档</span>
							</div>
						</th>
					</tr>
					<tr>
						<th>
							<div class="item">
								<span class="code-num">3</span>
								<p class="rate">500</p>
								<p class="rate-tips">现金券</p>
								<span id="item3" class="item-btn">20000元档</span>
							</div>
						</th>
						<th>
							<div class="item">
								<span class="code-num">4</span>
								<p class="rate">1500</p>
								<p class="rate-tips">现金券</p>
								<span id="item4" class="item-btn">40000元档</span>
							</div>
						</th>
					</tr>
					<tr>
						<th>
							<div class="item">
								<span class="code-num">5</span>
								<p class="rate">3500</p>
								<p class="rate-tips">现金券</p>
								<span id="item5" class="item-btn">60000元档</span>
							</div>
						</th>
						<th>
							<div class="item">
								<span class="code-num">6</span>
								<p class="rate">6000</p>
								<p class="rate-tips">现金券</p>
								<span id="item6" class="item-btn">80000元档</span>
							</div>
						</th>
					</tr>
					<tr>
						<th>
							<div class="item">
								<span class="code-num">7</span>
								<p class="rate">8000</p>
								<p class="rate-tips">现金券</p>
								<span id="item7" class="item-btn">100000元档</span>
							</div>
						</th>
						<th>
						</th>
					</tr>

				</table>
			</div>

			<p style="text-align: center;" onclick="querySubject()">
				<img src="images/activity/twoTwelve/mmcf-12-wx-btn.png" style="width: 165px;height: 45px;margin: 20px auto;">
			</p>
			<div class="rule">
				<ul>
					<li class="rule-title">
						<span></span><b>活动规则</b><span></span>
					</li>
					<li>1.现金券只能用于2019年1月提现。</li>
					<li>2.三个月以内的标不参加活动。</li>
					<li>3.现金券和加息券会在活动结束后3个工作日内发放。</li>
					<li>4.本活动最终解释权归猫咪财富所有。</li>
				</ul>
			</div>


		</div>
<body>
	
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/validate.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layer/layer.js"></script>
<script src="js/activity/twoTwelve.js" type="text/javascript" charset="utf-8"></script>
</html>
