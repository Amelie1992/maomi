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
<title>我的客服</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<style type="text/css">
.head {
	width: 100%;
	height: 160px;
	background-image: url(images/wx-kf-headbg.png);
	background-size: 100% 100%;
}

.head div {
	display: inline-block;
	float: left;
}

.head-pic img {
	width: 50px;
	height: 50px;
	padding: 40px 7px 70px 30px;
}

.head-cheat {
	width: 258px;
	height: 48px;
	background-image: url(images/wx-kf-cheatbox.png);
	background-size: 100% 100%;
	margin: 40px 0px 70px 0px;
}

@media only screen and (min-width: 319px) and (max-width: 321px) {
	.head-cheat {
		width: 210px;
		height: 48px;
		background-image: url(images/wx-kf-cheatbox.png);
		background-size: 100% 100%;
		margin: 40px 0px 70px 0px;
	}
}

.head-cheat p {
	padding: 6px 15px 6px 24px;
	color: #F5F5F5;
	font-size: 14px;
	line-height: 20px;
}

.head-box {
	width: 94%;
	height: 60px;
	background-color: white;
	position: absolute;
	top: 120px;
	margin: 0 3%;
	text-align: center;
	padding-top: 20px;
}

.head-box table {
	width: 100%;
	line-height: 40px;
}

.head-box table img {
	width: 24px;
	height: 24px;
	position: relative;
	top: 6px;
	margin-right: 10px;
}

.content {
	background-color: #efefef;
	padding: 10px 3%;
	padding-top: 50px;
	margin-bottom: 65px;
}

.database li {
	padding: 0 14px;
	border-bottom: 1px solid #E0E0E0;
	height: 40px;
	line-height: 40px;
	background-color: white;
	color: #212121;
}

.database ul .database-title {
	font-size: 14px;
	color: #757575;
	line-height: 50px;
	height: 50px;
}

.database li img {
	width: 7px;
	height: 13px;
	float: right;
	margin-top: 13px;
}

.database li .database-icon {
	width: 24px;
	height: 24px;
	float: left;
	margin-top: 8px;
	margin-right: 10px;
}

@media only screen and (min-height: 811px) and (max-height: 813px) {
	.footer {
		width: 100%;
		height: 45px;
		padding: 10px 0;
		position: relative;
		bottom: 0;
		left: 0;
		background-color: white;
		border-top: 1px solid #E0E0E0;
	}
	.content {
		height: 600px;
		margin-bottom: 0;
	}
}

.footer {
	width: 100%;
	height: 45px;
	padding: 10px 0;
	position: fixed;
	bottom: 0;
	left: 0;
	background-color: white;
	border-top: 1px solid #E0E0E0;
}

.footer table {
	width: 100%;
	text-align: center;
}

.footer table img {
	width: 24px;
	height: 24px;
}

.footer table td {
	padding-top: 6px;
}
/*二维码*/

.qrcode {
	position: fixed;
	left: 3%;
	bottom: 70px;
	display: none;
}

.qrcode img {
	width: 168px;
	height: 200px;
}

</style>
<script type="text/javascript">
	function kefucode() {
		$('.qrcode').toggle()
	}
</script>
</head>

<body>
<div class="wrap">
			<div class="head">
				<div class="head-pic">
					<img src="images/wx-kf-kfpic.png" />
				</div>
				<div class="head-cheat">
					<p>尊敬的投资用户，您好！客服蓝猫很高兴为您服务！</p>

				</div>
			</div>
			<div class="head-box">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th style="border-right: 1px solid #E0E0E0;">
							<a href="<%=basePath%>proposalrecord/s/goproposalcenter"><img src="images/wx-kf-yjfk.png" />意见反馈</a>
						</th>
						<th>
							<a href="<%=basePath%>proposalrecord/s/goproposalreward"><img src="images/wx-kf-jlgs.png" />奖励公示</a>
						</th>
					</tr>
				</table>
			</div>
			<div class="content">
				<div class="database">
					<ul>
						<li class="database-title">常见问题</li>
						<li>
							<a href="<%=basePath%>/questionlist/detail/detail_01.jsp">咪财富支持哪些银行？ <img src="images/wx-kf-go.png" /></a>
						</li>
						<li>
							<a href="<%=basePath%>/questionlist/detail/detail_02.jsp">猫咪财富充值是否限额？<img src="images/wx-kf-go.png" /></a>
						</li>
						<li>
							<a href="<%=basePath%>/questionlist/detail/detail_03.jsp">猫咪财富充值失败的原因有哪些？<img src="images/wx-kf-go.png" /></a>
						</li>
						<li>
							<a href="<%=basePath%>/questionlist/detail/detail_04.jsp">投资成功后，什么时候开始计息？<img src="images/wx-kf-go.png" /></a>
						</li>
						<li>
							<a href="<%=basePath%>/questionlist/detail/detail_05.jsp">如何才算邀请好友成功？<img src="images/wx-kf-go.png" /></a>
						</li>
					</ul>
				</div>
				<div class="database" style="margin-top: 10px;">
					<ul>
						<li class="database-title">问题分类</li>
						<li>
							<a href="<%=basePath%>/questionlist/question_01.jsp"><img src="images/wx-kf-xsrm.png" class="database-icon" /> 新手入门（注册/充值/提现等） <img src="images/wx-kf-go.png" /></a>
						</li>
						<li>
							<a href="<%=basePath%>/questionlist/question_02.jsp"><img src="images/wx-kf-tzlc.png" class="database-icon" />投资理财（精选/爆款/计息等）<img src="images/wx-kf-go.png" /></a>
						</li>
						<li>
							<a href="<%=basePath%>/questionlist/question_03.jsp"><img src="images/wx-kf-zzfw.png" class="database-icon" />增值服务（邀请好友/鱼干等）<img src="images/wx-kf-go.png" /></a>
						</li>
						<li>
							<a href="<%=basePath%>/questionlist/question_04.jsp"><img src="images/wx-kf-zhgl.png" class="database-icon" />账户管理（安全设置/银行等）<img src="images/wx-kf-go.png" /></a>
						</li>
					</ul>
				</div>
			</div>

			<div class="footer">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<!-- <th style="border-right: 1px solid #E0E0E0;"><img src="images/wx-kf-kfcode.png"  class="code-btn"/></th> -->
						<th>
							<a href="tel:4000003060"><img src="images/wx-kf-kftel.png" /></a>
						</th>
					</tr>
					<tr>
						<!-- <td style="border-right: 1px solid #E0E0E0;" onclick="kefucode()">客服二维码</td> -->
						<td>
							<a href="tel:4000003060">客服电话</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="qrcode">
			<img src="images/wx-kf-qrcode.jpg" />
		</div>

</body>
</html>
