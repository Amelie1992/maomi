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
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/zc-rule.css" />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<title>众筹规则</title>
<link rel="stylesheet" type="text/css" href="css/commonStyle.css"/>
<style type="text/css">
	body {
				background-color: #F2F2F2;
			}
			
			.wrap {
				width: 100%;
			}
			
			.title {
				width: 100%;
				position: relative;
				text-align: center;
				font-size: 16px;
				color: #000;
				height: 40px;
				line-height: 40px;
				background-color: #F7F7F7;
			}
			
			.back {
				position: absolute;
				left: 20px;
				top: 14px;
				width: 10px;
				height: 15px;
			}
			
			.contentName {
				color: #333333;
			}
			
			.contentTips {
				float: right;
				margin-right: 20px;
				color: #Ff5420;
			}
			
			.content_inner .accordion li i {
				position: absolute;
				top: 12px;
				left: 12px;
				font-size: 18px;
				color: #888;
				-webkit-transition: all 0.4s ease;
				-o-transition: all 0.4s ease;
				transition: all 0.4s ease;
			}
			
			.submenu li {
				position: relative;
				
				line-height: 25px;
				
				border: none !important;
			}
</style>
</head>

<body>
	<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="javascript:window.history.go(-1);" />众筹规则
			</div>
			<div class="content">
				<div class="content_inner">
					<ul id="accordion2" class="accordion">
						<li>
							<div class="link">
								</i>

								<p class="contentName">猫咪众筹<i class="fa fa-chevron-down"></i>
							</div>
							<ul class="submenu">

								为增加各位尊贵会员更有趣的体验，猫咪财富新增猫咪众筹。不用花一分钱就有机会获得丰厚的大奖。

							</ul>
						</li>
						<li>
							<div class="link">
								</i>

								<p class="contentName">众筹规则<i class="fa fa-chevron-down"></i>
							</div>
							<ul class="submenu">

								<ul>
									<li>1.1000投注一次获得一个随机号，中奖号码从中随即抽取。</li>
									<li>2.募筹期到期时抽取奖品数为满足最高档位数。</li>
									<li>3.该标到期后返还所有参与者的本金与利息。</li>
									<li>4.募筹期中获得的利息都会发放到参与者的账户中。</li>
								</ul>

							</ul>
						</li>
						<li>
							<div class="link">
								</i>

								<p class="contentName">附带说明<i class="fa fa-chevron-down"></i>
							</div>
							<ul class="submenu">

								<ul>
									<li>1.随机号发放数量=该标投资次数。</li>
									<li>2.奖品数量=众筹满足的最高档位。</li>
									<li>3.奖品价格为我们提供奖品的零售价格。</li>
								</ul>

							</ul>
						</li>
						<li>
							<div class="link">
								</i>

								<p class="contentName">举例说明<i class="fa fa-chevron-down"></i>
							</div>
							<ul class="submenu">
								本期众筹物品为<font style="color:red">${cBean.goodsName}${cBean.goodsSpecs}</font>，该标投资为${cBean.crowdGrade}元一档，若投标总金额为${cBean.crowdMoney}元，众筹期结束后最多抽取${num}位获奖用户。
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/accordion.js" type="text/javascript" charset="utf-8"></script>
<script src="js/help_content_inner.js" type="text/javascript" charset="utf-8"></script>
</html>
