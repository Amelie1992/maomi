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
<title>双十二活动详情</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/activity/twelveActivityDetail.css" />
</head>

<body>
	<div class="wrap">
			<div class="content-head">
				<div class="content-head-top">
					<img src="images/wx-12-ipx-grey.png" />
				</div>

				<div class="content-head-phone-tips">
					Apple/苹果 iPhoneX 64G 手机全网通
				</div>
				<div class="content-head-bottom">
					<p>请选择颜色</p>
					<div>
						<span class="phoneColor colorType-grey">深空灰色</span>
						<span class="phoneColor colorType-white">银色</span>

					</div>

				</div>

			</div>
			<ul>
				<li>
					投资金额 <span>
								<c:if test="${'-1'==type}">20000.00元</c:if>
								<c:if test="${'-2'==type}">30000.00元</c:if>
							</span>
				</li>
				<li>
					投资期限 <span>${sBean.subjectPeriods }
									<c:if test="${'0'==sBean.subjectTerm }">天</c:if>
									<c:if test="${'1'==sBean.subjectTerm }">月</c:if>
									<c:if test="${'2'==sBean.subjectTerm }">年</c:if></span>
				</li>
				<li>
					年化利率 <span>${sBean.subjectRate }%</span>
				</li>
				<li>
					预期收益 <span>
							<c:if test="${'-1'==type}">800.00元</c:if>
							<c:if test="${'-2'==type}">1200.00元</c:if>
							</span>
				</li>
				<li>
					购机价格 <span>
							<c:if test="${'-1'==type}">7788.00元</c:if>
							<c:if test="${'-2'==type}">7588.00元</c:if>
							</span>
				</li>
				<li>
					还款方式 <span>
							<c:if test="${'0'==sBean.repeatType }">等额本息</c:if>
							<c:if test="${'1'==sBean.repeatType }">先息后本</c:if>
							<c:if test="${'2'==sBean.repeatType }">到期还本付息</c:if>
							</span>
				</li>
			</ul>
            <div class="tz-btn">
            	<c:if test="${empty sessionScope.account}">
					<img src="images/wx-12-btn.png" onclick="investNow(0)"/> 
				</c:if>
				<c:if test="${!empty sessionScope.account}">
					<img src="images/wx-12-btn.png" onclick="investNow(${type})"/> 
				</c:if>
            	
            </div>
		</div>
		<input type="hidden" id="type">
		<input type="hidden" id="color" name="color" value="">
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/activity/twelveActivity.js"></script>
<script type="text/javascript">
$('.content-head-top img').attr('src', 'images/wx-12-ipx-grey.png');
$('.colorType-grey').css('border-color', '#F95D18');
$('.colorType-grey').css('color', '#F95D18');
$('.colorType-white').css('border-color', '');
$('.colorType-white').css('color', '');
$("#color").val("1");
//手机类型
$('.colorType-grey').click(function() {
	$('.content-head-top img').attr('src', 'images/wx-12-ipx-grey.png');
	$('.colorType-grey').css('border-color', '#F95D18');
	$('.colorType-grey').css('color', '#F95D18');
	$('.colorType-white').css('border-color', '');
	$('.colorType-white').css('color', '');
	$("#color").val("1");

});
$('.colorType-white').click(function() {
	$('.content-head-top img').attr('src', 'images/wx-12-ipx-white.png');
	$('.colorType-white').css('border-color', '#F95D18');
	$('.colorType-white').css('color', '#F95D18');
	$('.colorType-grey').css('border-color', '');
	$('.colorType-grey').css('color', '');
	$("#color").val("2");

});
	</script>
</html>
