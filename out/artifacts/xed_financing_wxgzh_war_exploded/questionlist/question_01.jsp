<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
<title>帮助中心-新手入门</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<style type="text/css">
.wrap {
				padding: 15px;
			}
			
			.accordion {
				width: 100%;
				background: #FFF;
			}
			
			.contentName {
				color: #212121;
			}
			
			.accordion .link {
				cursor: pointer;
				display: block;
				color: #888;
				font-size: 14px;
				position: relative;
				-webkit-transition: all 0.1s ease;
				-o-transition: all 0.1s ease;
				transition: all 0.1s ease;
				background-color: white;
				font-weight: normal;
				margin-top: 0;
				height: 40px;
				line-height: 40px;
				border-bottom: 1px solid #E0E0E0;
			}
			
			.accordion li i {
				position: absolute;
				top: 14px;
				left: 12px;
				font-size: 18px;
				color: #888;
				-webkit-transition: all 0.1s ease;
				-o-transition: all 0.1s ease;
				transition: all 0.1s ease;
			}
			
			.accordion li i.fa-chevron-down {
				right: 12px;
				left: auto;
				font-size: 12px;
				font-weight: normal;
			}
			
			.accordion li.open i.fa-chevron-down {
				-webkit-transform: rotate(180deg);
				-ms-transform: rotate(180deg);
				-o-transform: rotate(180deg);
				transform: rotate(180deg);
			}
			
			.submenu {
				display: none;
				font-size: 14px;
				padding: 12px 0;
				border-bottom: 1px dashed #E0E0E0;
				line-height: 20px;
				color: #757575;
			}
</style>

</head>

<body>
<div class="wrap">
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">如何注册成为猫咪财富用户</span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				访问猫咪财富官方首页（https://www.maomibank.com），点击上方导航栏的“注册”按钮，填写手机号、验证码、密码、推荐人（非必填），点击“确认提交”按钮即可注册。
			</ul>
		</li>
	</ul>
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">海外，港澳台用户注册有什么要求吗</span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				海外，港澳台用户注册时需要使用中国大陆手机号码，确保该手机能正常接收短信和接听电话。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">如何通过猫咪财富官网充值</span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				用户登录猫咪财富官网后，进入“个人中心”页面点击“充值”按钮，进入充值页面后，填写充值金额，根据提示填写相关信息并确认后，充值成功。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">猫咪财富充值支持哪些银行</span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				目前支持中国工商银行、中国农业银行、中国建设银行、中国民生银行、中国邮政，华夏银行、招商银行、中国银行、交通银行、浦发银行、兴业银行、中信银行、中国光大银行、广发银行、平安银行，总计15家银行。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">充值是否限额</span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				猫咪财富用户每笔充值金额需>=100元。 充值受限的情况为：银行对网银充值设定限额、第三方支付平台对银行卡支付设置限额、用户在开设银行卡时设置的支付限额，充值限额取三者最小值。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">充值是否收取手续费 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				通过第三方支付平台充值所产生的费用由猫咪财富承担，无需用户额外支付。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">充值失败的原因有哪些 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				1.用户银行卡账户信息填写错误。  <br /> 2.用户银行卡余额不足。   <br />3.用户的银行卡或已过期、作废、挂失 。 <br />4.超过充值限额额度。 <br />5.用户使用信用卡充值。<br />  注：如果充值后银行已扣款，用户账户可用余额未增加，请及时联系客服（400-000-3060）进行解决。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">如何通过猫咪财富官网提现 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				用户登录猫咪财富微信端后，进入“个人中心”页面点击“提现”按钮，进入提现页面后，填写提现金额，根据提示填写相关信息并确认后，申请提现成功。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">提现到账时间 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				14:00之前不支持申请提现；14:00-15:00申请提现，当天到账；15:00-23:59申请，次日到账 。<br/> 注：所有法定节假日（含周末）的提现申请将于节假日结束后的第一个工作日进行处理。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">提现相关要求 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				1.用户需绑定银行卡后才可以申请提现。 <br /> 2.不支持信用卡提现。  <br />3.14:00之前不支持提现。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">提现是否收取手续费 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				单笔收取2元提现手续费，vip2~vip4每月享有1次免费提现，vip5以上包括vip5每月享有3次免费提现。
			</ul>
		</li>
	</ul>
</div>
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {

		var Accordion = function(el, multiple) {
			this.el = el || {};
			this.multiple = multiple || false;

			var links = this.el.find('.link');

			links.on('click', {
				el: this.el,
				multiple: this.multiple
			}, this.dropdown);
		}

		Accordion.prototype.dropdown = function(e) {
			var $el = e.data.el;
			$this = $(this),
				$next = $this.next();
			$next.slideToggle();
			$this.parent().toggleClass('open');
			2

			if(!e.data.multiple) {
				$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
			};
		}
		var accordion = new Accordion($('.accordion'), false);

	});
</script>
</html>
