<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="js/layui-master/dist/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/coupon/fuseCoupon.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>我的优惠券</title>
<style type="text/css">
</style>
</head>
<body>
	<div class="wrap">
		<div class="layui-tab layui-tab-brief">
			<div class="hc-head">
				<div class="content-detail hc-jg">
					<table border="0" cellspacing="" cellpadding="">
						<tr id="choose">
							<th><span id="result">0.0</span><span class="yhq-tips">%</span></th>
							<th class="yhq-type">加息券</th>
							<th onclick="toCouponRule()">规则说明</th>
						</tr>
					</table>
					<ul>
						<li><img src="images/hc-jg-yxq.png" /><span>有效期</span>：1月</li>
						<li><img src="images/wx-yhq-sysm.png" /><span>使用说明</span>：起投无限制</li>
						<li><img src="images/wx-yhq-jxqx.png" /><span>计息期限</span>：1月</li>
					</ul>
				</div>
				<ul class="layui-tab-title">
					<li class="layui-this" style="float: left;margin-left: 5%;" onclick="choose(1)">加息券</li>
					<div class="hc-btn">
						<img src="images/hc-btn.png" onclick="composeCoupon()" />
					</div>
					<li style="float: right;margin-right: 5%;" onclick="choose(0)">增值券</li>
				</ul>
			</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<c:forEach items="${jxList}" var="cd">
						<div class="jxq-box">
							<div class="content-detail jxq">
								<table border="0" cellspacing="" cellpadding="">
									<tr>
										<th>
											<span class="couponMoney"><fmt:formatNumber type="number" value="${cd.couponMoney}" maxFractionDigits="2"></fmt:formatNumber></span><span class="yhq-tips">%</span>
										</th>
										<th class="yhq-type">加息券</th>
										<th></th>
									</tr>
								</table>
								<input type="hidden" value="${cd.additionalId}" name="additionalId">
								<ul>
									<li>
										<img src="images/wx-yhq-yxq-jxq.png" />
										<span>到期时间</span>：<c:if test="${'-1'==cd.validityDays }">永久有效</c:if><c:if test="${'-1'!=cd.validityDays }">${cd.outTime }号后失效</c:if>
									</li>
									<li><img src="images/wx-yhq-sysm.png" /><span>使用说明</span>：
										<c:if test="${cd.startMoney=='0'}">起投无限制</c:if>
										<c:if test="${cd.startMoney!='0'}">${cd.startMoney}元起投</c:if>
										<c:choose>
											<c:when test="${cd.subjectType=='-2'}">
												全部不适用
											</c:when>
											<c:when test="${cd.subjectType=='0'}">
												仅限新手标
											</c:when>
											<c:when test="${cd.subjectType=='1'}">
												仅限精选理财
											</c:when>
											<c:when test="${cd.subjectType=='2'}">
												仅限爆款标
											</c:when>
											<c:when test="${cd.subjectType=='3'}">
												适用新手标、精选理财
											</c:when>
											<c:when test="${cd.subjectType=='4'}">
												适用新手标、爆款标
											</c:when>
											<c:when test="${cd.subjectType=='5'}">
												适用精选理财、爆款标
											</c:when>
										</c:choose>
									</li>
									<li><img src="images/wx-yhq-jxqx.png" /><span>计息期限</span>：<c:if test="${'-1'==cd.interestDays }">无期限</c:if> 
									<c:if test="${'-1'!=cd.interestDays }">${cd.interestDays}
										<c:if test="${'0'==cd.interestType }">天</c:if>
										<c:if test="${'1'==cd.interestType }">月</c:if>
										<c:if test="${'2'==cd.interestType }">年</c:if>
									</c:if></li>
								</ul>
								<img src="images/hc-check-before.png" class="checkIcon" />
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="layui-tab-item">
					<c:forEach items="${zzList}" var="zz">
						<div class="zzq-box">
							<div class="content-detail zzq">
								<table border="0" cellspacing="" cellpadding="">
									<tr>
										<th>
											<span class="yhq-tips">¥</span><span class="couponMoney"><%-- <fmt:formatNumber type="number" value="" maxFractionDigits="0"></fmt:formatNumber> --%>${zz.couponMoney}</span>
										</th>
										<th class="yhq-type">增值券</th>
										<th></th>
									</tr>
								</table>
								<input type="hidden" value="${zz.additionalId}" name="additionalId">
								<ul>
									<li>
										<img src="images/wx-yhq-yxq-zzq.png" />
										<span>到期时间</span>：<c:if test="${'-1'==zz.validityDays }">永久有效</c:if><c:if test="${'-1'!=zz.validityDays }">${zz.outTime }号后失效</c:if>
									</li>
									<li><img src="images/wx-yhq-sysm.png" /><span>使用说明</span>：
										<c:if test="${zz.startMoney=='0'}">起投无限制</c:if>
										<c:if test="${zz.startMoney!='0'}">${zz.startMoney}元起投</c:if>
										<c:choose>
											<c:when test="${zz.subjectType=='-2'}">
												全部不适用
											</c:when>
											<c:when test="${zz.subjectType=='0'}">
												仅限新手标
											</c:when>
											<c:when test="${zz.subjectType=='1'}">
												仅限精选理财
											</c:when>
											<c:when test="${zz.subjectType=='2'}">
												仅限爆款标
											</c:when>
											<c:when test="${zz.subjectType=='3'}">
												适用新手标、精选理财
											</c:when>
											<c:when test="${zz.subjectType=='4'}">
												适用新手标、爆款标
											</c:when>
											<c:when test="${zz.subjectType=='5'}">
												适用精选理财、爆款标
											</c:when>
										</c:choose>
									</li>
									<li><img src="images/wx-yhq-jxqx.png" /><span>计息期限</span>：<c:if test="${'-1'==zz.interestDays }">无期限</c:if> 
									<c:if test="${'-1'!=zz.interestDays }">${zz.interestDays}
										<c:if test="${'0'==zz.interestType }">天</c:if>
										<c:if test="${'1'==zz.interestType }">月</c:if>
										<c:if test="${'2'==zz.interestType }">年</c:if>
									</c:if></li>
								</ul>
								<img src="images/hc-check.png" class="checkIcon" />
								<img src="images/hc-check-before.png" class="checkIcon" />
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<!-- 空白导航  防止被底部导航栏遮住内容 -->
	<jsp:include page="../navigation/emptyDiv.jsp" flush="true"/>
	<!-- 底部导航 -->
	<jsp:include page="../navigation/navigation.jsp" flush="true"/>
	<script src="js/layui-master/dist/layui.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="js/coupon/fuseCoupon.js"></script>
</body>
</html>
