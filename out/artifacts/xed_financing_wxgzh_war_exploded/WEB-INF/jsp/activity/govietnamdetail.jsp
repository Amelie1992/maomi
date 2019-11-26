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
<link rel="stylesheet" type="text/css" href="js/layui-master/src/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/activity/govietnamdetail.css"/>

<title>越南游详情</title>


</head>

<body>
<input type="hidden" id="noInviteFriendCount" value="${noInviteFriendCount }">
<input type="hidden" id="noGoAbroadCount" value="${noGoAbroadCount }">
<input type="hidden" id="flag" value="${flag }">
<div class="wrap">
	<div class="banner">
		<img src="images/activity/goabroad/wx-ac-cgy-yny-1.png" />
	</div>
	<ul class="layui-timeline">
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 1</h3>
				<h3 class="layui-timeline-title">南京直飞芽庄</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-yny-2.png" />
				</div>
				<p>参考航班：VJ5417 20:15-22:45（以实际开出机票为准）。</p>
				<p>温馨提示：此为经济航空，不提供免费餐食，建议上飞机前食用适量餐饮。另飞机上冷气较足，建议自带厚外套一件。 （廉价航空，飞机上不含免费餐饮）手提7kg，托运20kg。</p>
				<p>前往酒店: 勒尼德芽庄酒店或芽庄加里奥特酒店。</p>
			</div>
		</li>
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 2</h3>
				<h3 class="layui-timeline-title">芽庄烟海湾-芽庄大教堂</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-yny-3.png" />
				</div>
				<p>早餐: 酒店自助。</p>
				<p>午餐: 当地合菜。</p>
				<p>晚餐: 自理。</p>
				<p>前往酒店: 勒尼德芽庄酒店或芽庄加里奥特酒店。</p>
			</div>
		</li>
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 3</h3>
				<h3 class="layui-timeline-title">芽庄珠宝店-婆那加占婆塔-泥浆浴</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-yny-4.png" />
				</div>
				<p>早餐: 酒店自助。</p>
				<p>午餐: 当地合菜。</p>
				<p>晚餐: 自理。</p>
				<p>前往酒店: 勒尼德芽庄酒店或芽庄加里奥特酒店。</p>
			</div>
		</li>
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 4</h3>
				<h3 class="layui-timeline-title">全天自由活动</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-yny-5.png" />
				</div>
				<p>早餐: 酒店自助。</p>
				<p>午餐: 自理。</p>
				<p>晚餐: 自理。</p>
				<p>前往酒店: 勒尼德芽庄酒店或芽庄加里奥特酒店。</p>
			</div>
		</li>
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 5</h3>
				<h3 class="layui-timeline-title">芽庄乳胶店-木岛-竹岛-汉潭岛-海燕岛</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-yny-6.png" />
				</div>
				<p>早餐: 酒店自助。</p>
				<p>午餐: 团餐。</p>
				<p>晚餐: 自理。</p>
				<p>前往酒店: 勒尼德芽庄酒店或芽庄加里奥特酒店。</p>
			</div>
		</li>
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 6</h3>
				<h3 class="layui-timeline-title">芽庄沉香店或珠宝店-芽庄直飞南京</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-yny-7.png" />
				</div>
				<p>早餐: 酒店自助。</p>
				<p>参考航班：VJ5416 14:50-19:15（以实际开出机票为准）。</p>
			</div>
		</li>
	</ul>
	<div class="space">

	</div>
	<div class="tips">
		<span class="tips-title">费用包含</span>
		<ul>
			<li>1. 往返经济舱机票燃油附加费（以实际收费标准为准）机票税。
			</li>
			<li>2. 行程所列酒店住宿费用。</li>
			<li>3. 行程内所列餐食，具体情况请见行程推荐/安排。
			</li>
			<li>4. 领队和当地中文导游服务。
			</li>
			<li>5. 行程中所列景点首道大门票天依女神庙、钟屿石岬角。
			</li>
			<li>6. 越南落地签旅游签证费用。
			</li>
			<li>7. 年龄2-11周岁（不含）,不占床,服务标准同成人。
			</li>

		</ul>
	</div>
	<div class="tips">
		<span class="tips-title">自理费用</span>
		<ul>
			<li>1. 海外游客、港澳台游客需要支付1500的差价，请在后续附加产品页面中选择附加费选项。

			</li>
			<li>2. 本产品不包含旅游意外险，建议您自行购买旅游意外保险。

			</li>
			<li>3. 全程只含5早餐3正餐，其余餐食敬请自理。

			</li>
			<li>4. 单房差。
			</li>
			<li>
				5. 你的行程中不包含司导和领队小费，根据当地的风俗习惯和更好的激励随团人员的服务，建议您可在行程中支付小费（ 自愿），支付给相关人员，共计金额，货币/人。
			</li>
			<li>
				6. 出入境个人物品海关征税；超重行李的托运费、保管费; 因交通延阻、罢工、天气、机器故障等不可抗力原因所导致的额外费用: 酒店内洗衣、理发、电话、传真、收费电视、饮品、烟酒等个人消费; 自由活动期间的用车服务; 提供导游服务的产品在自由活动期间无陪同服务; 当地参加的自费以及“费用包含”中不包含的其它项目。
			</li>
		</ul>
	</div>
	<a onclick="convert(1,7)" class="tz-btn">立即兑换</a>
</div>
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/validate.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layui-master/dist/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="js/activity/goabroad.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layer/layer.js"></script>
<script type="text/javascript">
	function toubiao() {
		window.location.href='<%=basePath%>subject/s/querysubject';
	}
</script>
</html>
