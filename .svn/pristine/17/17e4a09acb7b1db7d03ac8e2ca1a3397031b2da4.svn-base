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
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/activity/lcj-wx.css"/>

<title>518猫咪财富全民理财节</title>


</head>

<body>
<div class="wrap">
			<div class="head">
				<img src="images/activity/fiveoneight/lcj-head-bg.png" />
			</div>
			<div class="content">
				<div class="lcj-tz">
					<div class="lcj-tz-title">
						<img src="images/activity/fiveoneight/lcj-qmtz.png" />
					</div>
					<p class="activity-rule">活动期间单笔投资满<b>6800元</b>，送价值<b>100元京东E卡</b>及额外赠送<b>50鱼干</b>。（可获次数上限为10次）</p>
					<div class="activity-box activity-box-1">
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th><img src="images/activity/fiveoneight/lcj-jd100.png" /></th>
								<th><img src="images/activity/fiveoneight/lcj-plus1.png" /></th>
								<th><img src="images/activity/fiveoneight/lcjj-fish.png" /></th>
								<th>
									<img src="images/activity/fiveoneight/lcj-tz-btn.png" onclick="toubiao()" /></a>
								</th>
							</tr>
							<tr>
								<td>100元</td>
								<td> </td>
								<td>50</td>
							</tr>
						</table>
					</div>
					<p class="activity-rule">活动期间单笔投资满<b>10800元</b>，送价值<b>200元京东E卡</b>及额外赠送<b>100鱼干</b>。（可获次数上限为10次）</p>
					<div class="activity-box activity-box-2">
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th><img src="images/activity/fiveoneight/lcj-jd200.png" /></th>
								<th><img src="images/activity/fiveoneight/lcj-plus2.png" /></th>
								<th><img src="images/activity/fiveoneight/lcjj-fish.png" /></th>
								<th>
									<img src="images/activity/fiveoneight/lcj-tz-btn.png" onclick="toubiao()" /></a>
								</th>
							</tr>
							<tr>
								<td>200元</td>
								<td> </td>
								<td>100</td>

							</tr>
						</table>
					</div>
				</div>
				<div class="yqhy">
					<div class="lcj-tz-title">
						<img src="images/activity/fiveoneight/lcj-yqhy.png" />
					</div>
					<p class="activity-rule">活动期间成功邀请好友注册猫咪财富，且好友成功投资后即可获得好友首次投资金额的<b>18%</b>作为奖励。 （活动期间，好友邀请人数无上限，单笔最高奖励为10000元）</p>
					<div class="activity-box-example">
						<p>举个例子</p>
						<p>好友首投1000*18%=180元，即在原有的奖励上额外赠送180元现金奖励。
						</p>
					</div>
					<a href="./loginregister/invitingfriends" class="gotorank">
					<img src="images/activity/fiveoneight/lcj-yq-btn.png" class="lcj-yqhy-btn" /></a>
					
					<p class="activity-rule"><b>富豪榜：</b>活动期间所邀请好友投资总额越高，与富豪榜的距离越近。根据您在活动期间参加返利并审核通过的投资金额由高到低的顺序排列。排名前10的用户可获赠猫咪财富提供的奖励。</p>
					<p class="activity-rule"><b>人脉榜：</b>活动期间所邀请好友人数越多，与人脉榜的距离越近。根据您在活动期间邀请好友的数量由高到低的顺序排列（好友必须在活动期间注册且完成一笔投资），排名前10的用户可获得猫咪财富提供的奖励。</p>
					<div class="activity-box-1 activity-tel">
						<div class="activity-box-rank">第1名 </div>
						<div class="activity-box-tel"><img src="images/activity/fiveoneight/lcj-iPhoneX.png" /></div>
						<div class="activity-box-rank-prizebox">
							<div>
								<p>iPhone X 256G </p>
								<p>颜色可选</p>
							</div>

						</div>
					</div>
					<div class="activity-box-2 activity-tel">
						<div class="activity-box-rank">第2-3名</div>
						<div class="activity-box-tel"><img src="images/activity/fiveoneight/lcj-iPhone8plus.png" /></div>
						<div class="activity-box-rank-prizebox">
							<div>
								<p>iPhone8 Plus 256G </p>
								<p>颜色可选</p>
							</div>

						</div>
					</div>
					<div class="activity-box-3 activity-tel">
						<div class="activity-box-rank">第4-5名</div>
						<div class="activity-box-tel"><img src="images/activity/fiveoneight/lcj-iPhone8.png" /></div>
						<div class="activity-box-rank-prizebox">
							<div>
								<p>iPhone8 64G </p>
								<p>颜色可选</p>
							</div>

						</div>
					</div>

					<div class="activity-box-4">
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th>
									<div>
										<p>第6-7名</p>
									</div>
									<img src="images/activity/fiveoneight/lcj-box-1888.png" />
								</th>
								<th>
									<div>
										<p>第8-10名</p>
									</div>
									<img src="images/activity/fiveoneight/lcj-box-888.png" /></th>
							</tr>

						</table>
					</div>
					<a href="./activity/s/fiveoneeightrsking" class="gotorank"><img src="images/activity/fiveoneight/lcj-gotorank.png" /></a>

				</div>
			</div>

			<div class="lcj-rule">
				<p>活动规则</p>
				<ul>
					<li>1. 活动时间：2018年5月18日—2018年5月31日。</li>
					<li>2. 此次活动只限月标，<b style="color:red;">天标和自动投标不参加</b>。</li>
					<li>3. 此次活动赠送的现金奖励、实物奖励、鱼干奖励在活动结束核实无误后统一发放，现金奖励由猫咪财富现金券代替与鱼干奖励在活动结束后的3-7个工作日内到账。实物奖励会在活动结束后的3-10个工作日内寄送至用户个人中心填写的<a style="color: #2096fe;"href="./accountaddress/toaccountaddress">收货地址</a>。</li>
					<li>4. 此次活动最终解释权归猫咪财富所有，如有疑问请联系<a style="color: #2096fe;"href="tel:4000003060">猫咪财富客服400-000-3060</a>。</li>
				</ul>
			</div>
		</div>
</body>
<script type="text/javascript">
	function toubiao() {
		window.location.href='<%=basePath%>subject/s/querysubject';
	}
</script>
</html>
