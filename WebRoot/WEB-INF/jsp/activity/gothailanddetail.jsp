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
<link rel="stylesheet" type="text/css" href="css/activity/gothailanddetail.css"/>

<title>泰国游详情</title>


</head>

<body>
<input type="hidden" id="noInviteFriendCount" value="${noInviteFriendCount }">
<input type="hidden" id="noGoAbroadCount" value="${noGoAbroadCount }">
<input type="hidden" id="flag" value="${flag }">
<div class="wrap">
	<div class="banner">
		<img src="images/activity/goabroad/wx-ac-cgy-tgy-1.png" />
	</div>
	<ul class="layui-timeline">
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 1</h3>
				<h3 class="layui-timeline-title">南京直飞曼谷</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-tgy-2.png" />
				</div>
				<p>参考航班：XW887 2000-2240（以实际开出机票为准）。</p>
				<p>温馨提示：此为经济航空，不提供免费餐食，建议上飞机前食用适量餐饮。另飞机上冷气较足，建议自带厚外套一件。 （廉价航空，飞机上不含免费餐饮）手提7kg，托运20kg。</p>
				<p>前往酒店: 曼谷中庭安凡尼酒店或其他同类酒店。</p>
			</div>
		</li>
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 2</h3>
				<h3 class="layui-timeline-title">曼谷爱侣湾四面佛+丹嫩沙多水上市场+游船-大皇宫+玉佛寺</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-tgy-3.png" />
				</div>
				<p>早餐: 酒店内。</p>
				<p>午餐: 自理 丹嫩沙多水上市场自理。</p>
				<p>晚餐: 沙維餐厅泰式风味餐。</p>
				<p>前往酒店: 曼谷中庭安凡尼酒店或其他同类酒店。</p>
			</div>
		</li>
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 3</h3>
				<h3 class="layui-timeline-title">曼谷BUS芭提雅  龙虎园-泰国风情园-Tiffany蒂芬妮国际人妖秀</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-tgy-4.png" />
				</div>
				<p>早餐: 酒店内。</p>
				<p>午餐: 龙虎园餐厅。</p>
				<p>晚餐: 永珍泰式风味料理+学泰餐。</p>
				<p>前往酒店: 沙妮酒店或其他同类酒店。</p>
			</div>
		</li>
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 4</h3>
				<h3 class="layui-timeline-title">VIP豪华风帆游艇出海-泰式古法按摩-赠送夜间表演秀。</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-tgy-5.png" />
				</div>
				<p>早餐: 酒店内。</p>
				<p>午餐: 食为天泰式餐厅。</p>
				<p>晚餐: 泰拳楼或者GARDEN CLIFF自助餐。</p>
				<p>前往酒店: 沙妮酒店或其他同类酒店。</p>
			</div>
		</li>
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 5</h3>
				<h3 class="layui-timeline-title">芭提雅BUS曼谷  珠宝博物馆-KINGPOWER免税城-曼谷国际品牌五星级酒店自由活动半天-Asia-que河畔亚洲夜市</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-tgy-6.png" />
				</div>
				<p>早餐: 酒店内。</p>
				<p>午餐: 拉玛雅娜国际自助餐。</p>
				<p>晚餐: 自理 亚洲夜市自理。</p>
				<p>前往酒店: 曼谷香格里拉酒店或其他同类酒店。</p>
			</div>
		</li>
		<li class="layui-timeline-item">
			<i class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h3 class="layui-timeline-title">DAY 6</h3>
				<h3 class="layui-timeline-title">曼谷直飞南京</h3>
				<div class="layui-timeline-item-img">
					<img src="images/activity/goabroad/wx-ac-cgy-tgy-7.png" />
				</div>
				<p>早餐: 酒店内。</p>
				<p>参考航班：XW888 1340-1850（以实际开出机票为准）。</p>
			</div>
		</li>
	</ul>
	<div class="space">

	</div>
	<div class="tips">
		<span class="tips-title">费用包含</span>
		<ul>
			<li>1.往返经济舱机票燃油附加费（以实际收费标准为准）机场建设费。</li>
			<li>2.行程所列酒店住宿费用。</li>
			<li>3.酒店标准2人间。</li>
			<li>4.行程内所列餐食，具体情况请见行程推荐/安排、飞机餐是否收费请参照航空公司规定。</li>
			<li>5.领队和当地中文导游服务。</li>
			<li>6.安排当地专属用车(除部分特殊路段因当地规定及安全考量，则依规定派遣小型车)。</li>
			<li>7.行程中所列景点首道大门票大皇宫等。</li>
			<li>8.年龄2-18周岁（不含）,不占床。</li>
		</ul>
	</div>
	<div class="tips">
		<span class="tips-title">自理费用</span>
		<ul>
			<li>1. 您所支付的费用中不包含2200泰株/人的签证价格。请在出 入境时自备有效签证，如需代办，请在预订时选择相应附加 费用选项。
			</li>
			<li>2. 单房差。
			</li>
			<li>3. 你的行程中不包含司导和领队小费，根据当地的风俗习惯和 更好的激励随团人员的服务，建议您可在行程中支付小费（ 自愿），支付给相关人员，共计金额，货币/人。
			</li>
			<li>4. 出入境个人物品海关征税；超重行李的托运费、保管费; 因 交通延阻、罢工、天气、机器故障等不可抗力原因所导致 的额外费用: 酒店内洗衣、理发、电话、传真、收费电视、 饮品、烟酒等个人消费; 自由活动期间的用车服务; 提供导 游服务的产品在自由活动期间无陪同服务; 当地参加的自费 以及“费用包含”中不包含的其它项目。
			</li>					
		</ul>
	</div>
	<a onclick="convert(1,6)" class="tz-btn">立即兑换</a>
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
