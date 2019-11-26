<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<link rel="stylesheet" href="css/awardRotate/reset.css" />
	<link rel="stylesheet" href="css/awardRotate/prize.css" />
	<link rel="stylesheet" href="css/awardRotate/animate.css" />
<script src="js/awardRotate/jquery-1.9.0.min.js"></script>
<script src="js/awardRotate/prize.js"></script>
<script type="text/javascript" src="js/awardRotate.js"></script>
<script type="text/javascript" src="js/awardRotate/awardRotate.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<script src="js/layer/layer.js"></script>
<title>鱼干抽奖</title>
</head>
	
<body>
<input type="hidden" class="accountId" value="${accountInfo.accountId }"/>
<div onclick="shadehide()" class="shade">
			<div class="gain_bg" id="award">
			</div>
			<div class="shade_on">点击屏幕继续</div>
		</div>
		<div id="prize">
			<div class="prize_header">
				<img src="images/awardrotate/bg1.png" alt="" />
			</div>
			<div class="prize_mes">
				<div class="fish_num"><span>当前共有<i id="score">${accountScore}</i>鱼干!</span></div>
				<div class="award_num">
					<span onclick="iosShadeshow('1')" class="award1">抽奖一次</span>
					<span onclick="iosShadeshow('5')" class="award5">抽奖五次</span>
				</div>
				<div class="probability">
					<p class="probability_tit">抽奖概率公示</p>
					<div class="img_box">
						<div>
							<img src="images/awardrotate/p1.png" alt="" />
							<p>24%</p>
						</div>
						<div>
							<img src="images/awardrotate/p2.png" alt="" />
							<p>8%</p>
						</div>
						<div>
							<img src="images/awardrotate/p3.png" alt="" />
							<p>8%</p>
						</div>
						<div>
							<img src="images/awardrotate/P4.png" alt="" />
							<p>4%</p>
						</div>
						<div>
							<img src="images/awardrotate/p5.png" alt="" />
							<p>34%</p>
						</div>
						<div>
							<img src="images/awardrotate/P6.png" alt="" />
							<p>4%</p>
						</div>
						<div>
							<img src="images/awardrotate/p7.png" alt="" />
							<p>18%</p>
						</div>
					</div>
				</div>
				<div class="winners">
					<div class="winners_tit">
						<h>中奖名单</h>
					</div>
					<div class="prizeBox-nameList">
						<div id="scrollMessage">
							<ul id="message_1">
								<c:forEach items="${drawList}" var="dl">
								<li><span>${fn:substring(dl.telephone, 0, 3)}****${fn:substring(dl.telephone, 7, 11)}</span>
									<span>抽中</span>
									<span>${dl.drawContent}</span>
								</li>
								</c:forEach>
							</ul>
							<div id="message_2"></div>
						</div>
					</div>
				</div>
		
				<div class="rules">
					<div class="rules_tit">
						<img src="images/awardrotate/line.png" alt="" />
						<h2>活动规则</h2>
						<img src="images/awardrotate/line.png" alt="" />
					</div>
					<div class="rules_con">
						<ul>
							<li>用户凭鱼干进行抽奖，每次抽奖消耗15鱼干。</li>
							<li>获奖后奖品直接发放至抽奖账户。</li>
							<li>使用加息券投资可增加投标年化利率;使用增值券投资可额外增加增值券金额本金收益;现金券使用后可立即获得现金券金额的可提现金额;免费提现券可用于本平台后期免费提现;新手标再投机会给予用户额外投资一次新手专享标的机会.</li>
							<li>各优惠券奖品有效期为自中奖日起180天，请注意使用，避免过期。</li>
							<li>使用不正当方式参与抽奖或违规进行抽奖会依法追究其法律责任。</li>
							<li>该抽奖活动最终解释权归猫咪财富平台所有。</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>

