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
<title>帮助中心-我要理财</title>
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
	<!-- -----------------------------------------我要理财----------------------------------------- -->
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">新手专享标是什么 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				新手专享标是猫咪财富为新注册用户提供的起点低，收益高，周期短的一种专属标。新注册用户可以通过新手专享标，迅速体验由猫咪财富带来的理财乐趣。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">新手专享标投标有什么注意事项 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				新手专享标是为新注册用户所提供的，默认限投次数1次。可以通过鱼干抽奖获取额外次数。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">精选理财标是什么 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				精选理财标是属于期限灵活，流动性高的定期理财产品。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">爆款标是什么 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				爆款标是属于猫咪财富收益高，不限投标次数的明星标。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">预发布标是什么 </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				预发布标是在猫咪财富发标之前提前展示的标，让用户提前获悉，避免出现其余用户投满而投不到的情况。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">预发布标什么时间发布？ </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				当天12：00预告当天17：00的预发布标，当天18：00预告次日9：00的预发布标。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">如何进行投标</span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				用户根据实际情况选择适合您的产品：新手专享标，精选理财标，爆款推荐标。选择后点击“立即投资”进入标详情页面，根据相关提示输入金额，完成投标。
			</ul>
		</li>
	</ul>
	
	<ul class="accordion">
		<li>
			<div class="link">
				<span class="contentName">投资成功后，什么时候开始计息？ </span><i class="fa fa-chevron-down"></i>
			</div>
			<ul class="submenu">
				投资成功的项目，在该项目满标并审核后开始计息。
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
