<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<meta name="x5-fullscreen" content="true">
<meta name="full-screen" content="yes">
<title>鱼干说明</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="js/isWeixin.js"></script>

<style type="text/css">
div {
	overflow-x: hidden;
	overflow-y: auto;
	-webkit-overflow-scrolling: touch
}

.wrap {
	width: 100%;
}

.xmxq_head {
	width: 100%;
	/*height: 300px;*/
	/*background-color: #FEC63D;*/
	padding-bottom: 25px;
}

.title {
	width: 100%;
	position: relative;
	text-align: center;
	font-size: 16px;
	color: #333333;
	font-weight: 600;
	height: 50px;
	line-height: 50px;
	background-color: #f7f7f7;
}

.back {
	position: absolute;
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}

a:hover, a:focus {
	text-decoration: none;
	outline: none;
}

.accordion-title img {
	position: absolute;
	top: 13px;
	/*left: 10px;*/
	width: 20px;
	height: 20px;
}

#accordion {
	padding-right: 24px;
	padding-left: 24px;
	z-index: 1;
}

#accordion .panel {
	border: none;
	box-shadow: none;
}

#accordion .panel-heading {
	padding: 0;
	border-radius: 0;
	border: none;
}

#accordion .panel-title {
	padding: 0;
	position: relative;
	border-bottom: 1px solid #EEEEEE;
}

#accordion .panel-title a {
	display: block;
	font-size: 16px;
	/*font-weight: bold;*/
	/*background: #e16b47;*/
	/*color: #f7c59f;*/
	padding: 15px 25px;
	position: relative;
	/*margin-left: -24px;*/
	transition: all 0.3s ease 0s;
}

#accordion .panel-title a.collapsed {
	/*background: #f7c59f;*/
	/*color: #e16b47;*/
	margin-left: 0;
	transition: all 0.3s ease 0s;
}

#accordion .panel-title a:before {
	/*content: "";*/
	/*border-left: 24px solid #e16b47;*/
	border-top: 24px solid transparent;
	border-bottom: 24px solid transparent;
	position: absolute;
	top: 0;
	right: -24px;
	transition: all 0.3s ease 0s;
}

#accordion .panel-title a.collapsed:before {
	/*border-left-color: #f7c59f;*/
	
}

#accordion .panel-title a:after {
	content: "";
	/*font-family: 'FontAwesome';*/
	position: absolute;
	top: 30%;
	right: 15px;
	font-size: 18px;
	width: 20px;
	text-align: center;
	/*color: #f7c59f;*/
}

#accordion .panel-title a.collapsed:after {
	content: "";
	/*color: #e16b47;*/
}

#accordion .panel-collapse {
	position: relative;
}

#accordion .panel-collapse.in:before {
	/*content: "";*/
	border-right: 24px solid #f7c59f;
	border-bottom: 18px solid transparent;
	position: absolute;
	top: 0;
	left: -24px;
}

#accordion .panel-body {
	font-size: 14px;
	color: #333;
	/*background: #e4e4e4;*/
	border-top: none;
	z-index: 1;
}

.accordion-content table {
	width: 100%;
	text-align: center;
}

.accordion-content table th {
	font-weight: normal;
}

.tz-time {
	color: #C3C3C3;
	font-size: 12px;
}

.aqbzBG {
	width: 100%;
}

#down_1, #down_2, #down_3, #down_4, #down_5 {
	position: absolute !important;
	width: 20px !important;
	height: 20px !important;
	left: 75% !important;
}

.up {
	position: absolute !important;
	width: 20px !important;
	height: 20px !important;
	left: 75% !important;
	transform: rotate(180deg);
	-ms-transform: rotate(180deg);
	/* IE 9 */
	-moz-transform: rotate(180deg);
	/* Firefox */
	-webkit-transform: rotate(180deg);
	/* Safari 和 Chrome */
	-o-transform: rotate(180deg);
	/* Opera */
}

.accordion-content li {
	overflow: hidden;
	text-indent: 30px;
	margin: 0 5px 0 -25px;
	line-height: 30px;
}

.accordion-content span {
	font-size: 18px;
	color: #F54749;
}

.content-left {
	float: left;
	font-size: 12px;
	color: #E3E3E3;
}

.content-right {
	float: right;
}
</style>
</head>

<body>
<input type="hidden" id="basePath" value="<%=basePath%>" />
	<div class="wrap">
		<div class="xmxq_head">
			<div class="title">
				<img src="images/back.png" class="back" onclick="backtocenter()"/>鱼干说明
			</div>
		</div>
		<div class="demo" style="padding: 1em 0;">
			<div class="">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="panel-group" id="accordion" role="tablist"
							aria-multiselectable="true">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingOne">
									<h4 class="panel-title">
										<a role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapseOne"
											aria-expanded="true" aria-controls="collapseOne">
											<div class="accordion-title" onclick="tab('down_1')"
												id="select_1">
												<span>什么是鱼干</span> <img
													src="images/down01.png" class="up finda" id="down_1" />
											</div>
										</a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse in"
									role="tabpanel" aria-labelledby="headingOne">
									<div class="panel-body">
										<div class="accordion-content">
											<ul>
												<li>鱼干是猫咪财富平台积分体系的专有称谓,在猫咪财富平台中占有特殊的地位.</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingTwo">
									<h4 class="panel-title">
										<a class="collapsed" role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapseTwo"
											aria-expanded="false" aria-controls="collapseTwo">
											<div class="accordion-title" id="select_2"
												onclick="tab('down_2')">
												<span>鱼干的作用</span> <img
													src="images/down01.png" class="down finda" id="down_2" />

											</div>
										</a>
									</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="headingTwo">
									<div class="panel-body">
										<div class="accordion-content">
											<ul>
												<li>鱼干在猫咪财富平台中作用较为广泛,可用于鱼干抽奖,鱼干商城,支付债权转让相关费以及后期开放其他功能.</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingThree">
									<h4 class="panel-title">
										<a class="collapsed" role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapseThree"
											aria-expanded="false" aria-controls="collapseThree">
											<div class="accordion-title" id="select_3" onclick="tab('down_3')">
												<span>如何获得鱼干</span> <img
													src="images/down01.png" class="down finda" id="down_3"
													 />
											</div>
										</a>
									</h4>
								</div>
								<div id="collapseThree" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="headingThree">
									<div class="panel-body">
										<div class="accordion-content">
											<ul>
												<li>每日签到可获得1鱼干,累计签到7天,20天和当月满签可分别获得5,10,20额外的鱼干.</li>
												<li>注册后第一次修改用户名,完善个人信息,绑定银行卡,进行风险投资测试,完善邮箱/QQ/微信/微博/其他联系方式可分别获得10鱼干.</li>
												<li>投资标的时每投资100元可获得1鱼干,多投多送.</li>
												<li>可在鱼干购买页面花费帐户余额以最低1:5,最高1:8的比率购买的鱼干.</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingFour">
									<h4 class="panel-title">
										<a class="collapsed" role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapseFour"
											aria-expanded="false" aria-controls="collapseThree">
											<div class="accordion-title" onclick="tab('down_4')"
												id="select_4">
												<span>鱼干的使用</span> <img
													src="images/down01.png" class="down finda" id="down_4" />
											</div>
										</a>
									</h4>
								</div>
								<div id="collapseFour" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="headingFour">
									<div class="panel-body">
										<div class="accordion-content">
											<ul>
												<li>在鱼干抽奖页面,用户可消耗15鱼干进行一次抽奖,用户只要拥有足够的鱼干,就可抽奖,抽奖次数无限制.</li>
												<li>在鱼干商城页面,用户可消耗对应的鱼干兑换想要的商品,兑换后商品可与3-5日内寄至用户填写的地址.</li>
												<li>在用户发布债权转让时,需收取20鱼干抵扣手续费;发布后修改转让利率需收取5鱼干的利率修改费用;发布债权后选择加急转让需额外收取10鱼干费用.</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingFive">
									<h4 class="panel-title">
										<a class="collapsed" role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapseFive"
											aria-expanded="false" aria-controls="collapseThree">
											<div class="accordion-title" id="select_5"
												onclick="tab('down_5')">
												<span>注意事项</span> <img
													src="images/down01.png" class="down finda" id="down_5" />
											</div>
										</a>
									</h4>
								</div>
								<div id="collapseFive" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="headingFive">
									<div class="panel-body">
										<div class="accordion-content">
											<ul>
												<li>鱼干的最终解释权归猫咪财富平台所有.</li>
												<li>鱼干只能用于猫咪财富平台内部消耗,曲解鱼干含义/私下交易/恶意赚取鱼干等操作,猫咪平台可追究违规者相关法律责任.</li>
											</ul>
											<span>后续还有其他鱼干的相关功能会开放,尽请期待.</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		//下拉框
		function tab(tabId) {
			//$("#"+tabId).addClass("up");
			//$("#"+tabId).removeClass("down");
			var finda = $("#" + tabId).parent('div').parent('a').attr(
					"aria-expanded");
			$(".finda").each(function(index, dom) {
				$(dom).removeClass("up");
				$(dom).addClass("down");
			});
			if (finda == 'false') {
				$("#" + tabId).addClass("up");
				$("#" + tabId).removeClass("down");
			} else {
				$("#" + tabId).removeClass("up");
				$("#" + tabId).addClass("down");
			}
		}

		window.onload = function() {
			var u = navigator.userAgent;
			if (u.indexOf('Android') > -1 || u.indexOf('Linux') > -1) { //安卓手机
				//					alert("安卓手机");
				//					$('.back').css('display', 'none');

			} else if (u.indexOf('iPhone') > -1) { //苹果手机

				//					$('.back').css('display', 'none');
			} else if (u.indexOf('Windows Phone') > -1) { //winphone手机
				//					alert("winphone手机");

			}
		}
			
		function backtocenter(){
			window.location.href = '<%=basePath%>scorecenter/gotoscorecenter';
		}
	</script>

</body>