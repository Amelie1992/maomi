<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<title>猫咪储蓄罐规则</title>
<style type="text/css">
.wrap {
	padding: 10px;
	background-color: #F6F0E4;
}

.wrap p {
	padding: 20px 0 15px 12px;
	font-size: 18px;
	color: #FE5655;
}

.wrap li {
	font-size: 14px;
	color: #757575;
	padding: 10px 0;
	line-height: 20px;
}
.back {
	position: absolute;
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}
</style>
</head>

<body>
	<div class="wrap">
		<p><img src="<%=basePath%>images/back.png" class="back" onclick="goBack()"/></p>
		<p>猫咪储蓄罐玩法</p>
		<ul>
			<li>1.凡在本平台投资一次即获猫咪红包一个(天标、债权转让和众筹除外)，投资金额越大获得猫咪红包越大。</li>
			<li>2.获得的猫咪红包可以转送一次给他人(已注册手机号)或者自己使用。</li>
			<li>3.猫咪红包最终放入猫咪储蓄罐里。当储蓄金额达到100元后可提现100元至可用余额，若不足100元提现，则提现价值减半。</li>
			<li>4.猫咪储蓄罐超过100元按100元计算。</li>
			<li>5.最终解释权归猫咪财富所有。</li>
		</ul>
	</div>
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$('.wrap').css('height', $(window).height())
</script>
<script type="text/javascript">
	function goBack(){
		window.location.href='<%=basePath%>redpackage/toSavings';
	}
</script>
</html>