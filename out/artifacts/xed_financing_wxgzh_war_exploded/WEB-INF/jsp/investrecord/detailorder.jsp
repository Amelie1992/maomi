<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/investrecord/detailorder.css" />
<title>我的投资订单</title>
</head>
<body>
	<div class="wrap">
			<div class="content-head">
				<div class="content-head-left">
					
					<c:if test="${iBean.goodId==1 ||iBean.goodId==2}">
							<c:if test="${iBean.color==1}">
								<img src="images/activity/wx-double11-details-grey8.png" />
							</c:if>
							<c:if test="${iBean.color==2}">
								<img src="images/activity/wx-double11-details-white8.png" />
							</c:if>
							<c:if test="${iBean.color==3}">
								<img src="images/activity/wx-double11-details-gold8.png" />
							</c:if>
						</c:if>
						<c:if test="${iBean.goodId==3 ||iBean.goodId==4}">
							<c:if test="${iBean.color==1}">
								<img src="images/activity/wx-double11-details-grey8p.png" />
							</c:if>
							<c:if test="${iBean.color==2}">
								<img src="images/activity/wx-double11-details-white8p.png" />
							</c:if>
							<c:if test="${iBean.color==3}">
								<img src="images/activity/wx-double11-details-gold8p.png" />
							</c:if>
						</c:if>
						<c:if test="${iBean.goodId==6 ||iBean.goodId==5}">
							<c:if test="${iBean.color==1}">
								<img src="images/activity/wx-double11-details-greyiphonex.png" />
							</c:if>
							<c:if test="${iBean.color==2}">
								<img src="images/activity/wx-double11-details-whiteiphonex.png" />
							</c:if>
						</c:if>
				</div>
				<div class="content-head-right">
					<c:if test="${iBean.goodId==1 }"><p class="content-head-right-title">Apple/苹果 Iphone8 64G 手机全网通</p></c:if>
					<c:if test="${iBean.goodId==2 }"><p class="content-head-right-title">Apple/苹果 Iphone8 256G 手机全网通</p></c:if>
					<c:if test="${iBean.goodId==3 }"><p class="content-head-right-title">Apple/苹果 Iphone8plus 64G 手机全网通</p></c:if>
					<c:if test="${iBean.goodId==4 }"><p class="content-head-right-title">Apple/苹果 Iphone8plus 256G 手机全网通</p></c:if>
					<c:if test="${iBean.goodId==5 }"><p class="content-head-right-title">Apple/苹果 IphoneX 64G 手机全网通</p></c:if>
					<c:if test="${iBean.goodId==6 }"><p class="content-head-right-title">Apple/苹果 IphoneX 256G 手机全网通</p></c:if>
					<p class="content-head-right-box">
						<span>
							<c:if test="${iBean.color==1}">
								深灰色
							</c:if>
							<c:if test="${iBean.color==2}">
								银色
							</c:if>
							<c:if test="${iBean.color==3}">
								金色
							</c:if>
						</span>
						<span>
							${iBean.investMoney }投资${iBean.months}个月
						</span>
					</p>
				</div>
			</div>
			<div class="content-inner">
				<ul>
					<li>
						<span class="content-inner-left-tips">投入本金</span>
						<span class="content-inner-right-tips">${iBean.investMoney }元</span>
					</li>
					<li>
						<span class="content-inner-left-tips">投资期限</span>
						<span class="content-inner-right-tips">${iBean.months}个月</span>
					</li>
					<li>
						<span class="content-inner-left-tips">到期时间</span>
						<span class="content-inner-right-tips">${iBean.endTime}</span>
					</li>
				</ul>
			</div>
			<div class="content-bot">
				<ul>
					<li>
						<span><img src="images/receiverName.png"/>收货人：${iBean.userName }</span>
						<span><img src="images/receiverPhone.png" style="margin-left: 10px;"/>${iBean.userTelephone }</span>
					</li>
					<li>
						<img src="images/addressIcon.png"/>收货地址：${iBean.province}${iBean.city}${iBean.classify}${iBean.userAddress}
					</li>
					<li>
						<img src="images/receiverCar.png"/>物流状态：
						<c:if test="${'0'==iBean.isSend }">
							暂未发货
						</c:if>
						<c:if test="${'1'==iBean.isSend }">
							已发货
						</c:if>
					</li>
					<c:if test="${'1'==iBean.isSend }">
					<li>
						<img src="images/expressCompany.png"/>快递公司：${iBean.expressCompany }
						<img src="images/expressCode.png"/>物流单号：${iBean.expressCode }
					</li>
					</c:if>
				</ul>
			</div>
		</div>
</body>

</html>