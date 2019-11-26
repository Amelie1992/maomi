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
<title>反馈说明</title>

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
.showInfo{
	width: 80%;
	margin: 0 auto;
	line-height: 22px;
}
</style>
</head>

<body>
<input type="hidden" id="basePath" value="<%=basePath%>" />
	<div class="wrap">
		<div class="xmxq_head">
			<div class="title">
				<img src="images/back.png" class="back" onclick="backtocenter()"/>反馈说明
			</div>
		</div>
		<div class="demo" style="padding: 1em 0;">
			<div class="">
				<div class="showInfo">
					猫咪财富切实从投资者角度着想,努力将平台发展成一个可以更好的为用户提供便捷,诚信,稳定收益的大型投资理财平台.故此猫咪财富开设意见反馈功能,希望广纳投资人的意见,将平台做的更加完美.
				</div>
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
												<span>如何反馈</span> <img
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
												<li>用户进入意见反馈菜单,点击立即反馈,填写想对猫咪财富提出的意见并留下您的手机号码,猫咪财富会记录您留下的相关意见.</li>
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
												<span>平台采纳</span> <img
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
												<li>猫咪财富将有用户体验部会对您的意见进行备案,并定期组织产品经理对所有留下的意见进行筛选探讨.若您的意见符合猫咪财富的发展或对猫咪财富有较大的意义,猫咪财富将采纳该意见并对提出人给予丰富的奖励,以激励其他投资人对平台提出更加完美的意见.</li>
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
											<div class="accordion-title" id="select_3">
												<span>奖励说明</span> <img
													src="images/down01.png" class="down finda" id="down_3"
													onclick="tab('down_3')" />
											</div>
										</a>
									</h4>
								</div>
								<div id="collapseThree" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="headingThree">
									<div class="panel-body">
										<div class="accordion-content">
											<ul>
												<li>猫咪财富将根据用户提出的意见的作用给予相应的奖励,奖励包括但不限于以下内容:</li>
												<li>1.虚拟奖励,包括但不限于猫咪财富内部的鱼干,现金券,加息券;</li>
												<li>2.体育公益奖励,包括但不限于双色球,大乐透彩票;</li>
												<li>3.实物奖励,包括但不限于近期市面比较热销的电子产品,化妆品.</li>
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
												<span>采纳说明</span> <img
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
												<li>猫咪财富将定期公示采纳用户的部分信息及奖励,以体现猫咪财富是本着公平公正的原则,为更好的发展所采纳的意见.若多人提出了相同的意见后,猫咪财富将根据提出意见的先后顺序分别给予相应的奖励.</li>
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
												<span>其他说明</span> <img
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
												<li>为了更好的筛选采纳意见,猫咪财富希望用户在提出意见时,本着实事求是的原则,避免使用过激,不文明的语言.</li>
												<li>慎重提示:您所提出的意见在猫咪财富采纳之前若对猫咪财富产生不良影响,或您刻意抹黑,污蔑猫咪财富,猫咪财富将根据实际情况,依法追求其法律责任.</li>
												<li>意见反馈的最终解释权归猫咪财富所有.</li>
											</ul>
											<a href="javascript:gotorecord();"><span>点此处立即给猫咪财富提出您宝贵的意见.</span></a>
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
			window.location.href = '<%=basePath%>proposalrecord/s/goproposalcenter';
		}
		
		function gotorecord(){
			window.location.href = '<%=basePath%>proposalrecord/s/goproposalrecord';
		}
	</script>

</body>