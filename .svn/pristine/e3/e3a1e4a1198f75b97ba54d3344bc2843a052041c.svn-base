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
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/validate.js" type="text/javascript" charset="utf-8"></script>
<script src="js/activity/goabroad.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layer/layer.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/activity/goabroad.css"/>

<title>暑期猫咪财富带你出国游</title>


</head>

<body>
<input type="hidden" id="noInviteFriendCount" value="${noInviteFriendCount }">
<input type="hidden" id="noGoAbroadCount" value="${noGoAbroadCount }">
<input type="hidden" id="flag" value="${flag }">
<div class="wrap">
	<div class="content">
		<img src="images/activity/goabroad/wx-ac-cgy-banner1.png" class="banner" />
	</div>
	<div class="space">
		<div class="title-box">
			<div class="title">
				<p>好友返现(${yesInviteFriendCount }/1)&nbsp;&nbsp;&nbsp;&nbsp;出国游(${yesGoAbroadCount }/2)</p>
			<c:choose>
				<c:when test="${flag =='yes'}">
					<c:if test="${(noGoAbroadCount+noInviteFriendCount)>=2}">
						<p>好友返现可兑换${noInviteFriendCount }次&nbsp;&nbsp;&nbsp;&nbsp;出国游可兑换${noGoAbroadCount }次</p>
					</c:if>
					<c:if test="${(noGoAbroadCount+noInviteFriendCount)<2}">
						<p>好友返现可兑换${noInviteFriendCount }次&nbsp;&nbsp;或者&nbsp;&nbsp;出国游可兑换${noGoAbroadCount+noInviteFriendCount}次</p>
					</c:if>
				</c:when>
				<c:otherwise>
					<p>好友返现可兑换${noInviteFriendCount }次&nbsp;&nbsp;&nbsp;&nbsp;出国游可兑换${noGoAbroadCount }次</p>
				</c:otherwise>
			</c:choose>
				
				
			</div>
		</div>

	</div>
	<div class="content">
		<img src="images/activity/goabroad/wx-ac-cgy-banner2.png" class="banner" />

		<div class="content-box">
			<div class="content-title">
				欢乐泰国游
			</div>
			<div class="content-detail">
				<img src="images/activity/goabroad/wx-ac-cgy-tg.png" class="content-detail-img" />
				<p class="content-detail-title">曼谷+芭提雅</p>
				<h4></h4>
				<h3></h3>
				<p class="content-detail-text">活动期间投资<span>2个月标及以上</span>并且投资金额<span>大于或等于6万</span>的用户就可获得泰国曼谷+芭堤雅6日5晚跟团游票一张，每个用户最多仅限2张。</p>
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>
							<a onclick="goabroad(1)">我想出国</a>
						</th>
						<th>
							<a onclick="convert(1,8)">我要折现</a>
						</th>
					</tr>
				</table>

			</div>
		</div>
	</div>
	<div class="content">
		<img src="images/activity/goabroad/wx-ac-cgy-banner3.png" class="banner" />
		<div class="content-box">
			<div class="content-title">
				浪漫越南游
			</div>
			<div class="content-detail">
				<img src="images/activity/goabroad/wx-ac-cgy-yn.png" class="content-detail-img" />
				<p class="content-detail-title">芽庄</p>
				<h4></h4>
				<h3></h3>
				<p class="content-detail-text">活动期间投资<span>2个月标及以上</span>并且投资金额<span>大于或等于6万</span>的用户就可获得越南芽庄6日5晚跟团游票一张，每个用户最多仅限2张。</p>
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>
							<a onclick="goabroad(2)">我想出国</a>
						</th>
						<th>
							<a onclick="convert(1,9)">我要折现</a>
						</th>
					</tr>
				</table>

			</div>
		</div>
	</div>
	<div class="content">
		<img src="images/activity/goabroad/wx-ac-cgy-banner4.png" class="banner" />
		<div class="content-box">
			<div class="content-title">
				邀请好友拿现金
			</div>
			<div class="content-detail">
				<img src="images/activity/goabroad/wx-ac-cgy-yqhy.png" class="content-detail-img" />
				<p class="content-detail-text">活动期间成功邀请好友注册猫咪财富，且好友投资<span>2个月标及以上</span>即可获得好友首次投资金额的<span>12%</span>作为奖励，奖励以现金券形式发放，现金券奖励最高上限1万，并且双方可分别额外获得<span>2%加息券</span>。
				</p>
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>
							<a onclick="convert(2,0)">返现</a>
						</th>
					</tr>
				</table>

			</div>
		</div>
	</div>
	<div class="content rule-box">
		<div class="content-box">
			<div class="content-title">
				活动规则
			</div>
			<ul class="rule">
				<li>1.活动时间：2018.07.10-2018.07.20。</li>
				<li>2.此次活动仅限2个月标及以上可参加，自动投标与未满足活动要求的不予参加。
				</li>
				<li>3.出国活动二选一，出游日期不包含法定节假日。 如需包含需根据实际情况补偿差价。
				</li>
				<li>4.不想参加出国活动的投资人，可根据标准票价的70%折现，以现金券形式提现。
				</li>
				<li>5.需要额外购票的投资人，可联系猫咪客服，由猫咪客服代办。
				</li>
				<li>6.投资人可在活动开始时至8月底选择出国时间， 如有需求可联系猫咪客服。
				</li>
				<li>7.需要办理出国签证的投资人可联系猫咪客服， 具体费用按照实际收取。
				</li>
				<li>8.带上儿童出国需要支付房差费，具体费用根据实际情况而定。
				</li>
				<li>9.活动期间获得的现金券，均在活动截止后由猫咪客服统一发放。
				</li>
				<li>10.活动期间获得的2%加息券有效期为1个月，计息期限为3个月。
				</li>
				<li>11.活动期间新用户在填写邀请人的情况下，并且投资满足6万，新用户可选是参加出国活动或是给邀请人返现。
				</li>
				<li>12. 本活动最终解释权归猫咪财富所有，如有疑问请联系猫咪客服。
				</li>
			</ul>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	function toubiao() {
		window.location.href='<%=basePath%>subject/s/querysubject';
	}
	function goabroad(type)
	{
		window.location.href='<%=basePath%>activity/goabroaddetail?type='+type;
	}
</script>
</html>
