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
<title>帮助中心-增值服务</title>
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
	<!-- ----------------------------------------------------------------------------------------- -->
	<!-- -----------------------------------------增值服务----------------------------------------- -->
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">鱼干是什么 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				鱼干是猫咪财富为用户提供各种丰富服务的虚拟物品。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">如何获取鱼干</span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				1.用户投标可以获取鱼干，每投资100元可获取1鱼干。<br/>2.通过“个人中心”的页面的“我的鱼干”直接购买积分。 <br/>3.完善个人信息、签到可以获取鱼干。<br/>4.“个人中心”页面的“鱼干抽奖”有几率抽到鱼干。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">鱼干有什么用</span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				1.用户转让标、加急标需扣除一定鱼干。 <br/>2.鱼干抽奖需扣除15鱼干。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">优惠券是什么 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				优惠券是猫咪财富为用户投标所提供的增值服务，可以通过使用优惠券增加收益。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">优惠券有哪些 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				目前包含体验金，增值券，加息券，免费提现券，现金券，活动券。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">体验金和增值券有什么区别 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				体验金可在用户不投本金的情况下使用投标，便于新手用户更加方便深入的了解猫咪财富，增值券必须投入本金。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">现金券如何使用 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				折扣券、加息券、体验金是用户在投标过程中有且只能选择其一使用，现金券是可以直接在“我的优惠券”中使用，优惠金额是直接存入到用户可用金额中。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">如何获取优惠券 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				1.用户注册会送888体验金。<br/>2.用户抽奖会获取各种优惠券。<br/>3.猫咪财富会不定期给所有用户发放。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">如何才算邀请好友成功 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				在注册用户页面，用户必须正确填写邀请人的手机号码。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">邀请好友有什么好处 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				根据受邀人首次投资金额给予相应比例的加息券。
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
