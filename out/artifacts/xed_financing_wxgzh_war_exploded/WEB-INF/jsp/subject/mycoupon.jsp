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
<link rel="stylesheet" type="text/css" href="css/coupon/coupon.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/coupon/coupon.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>选择优惠券</title>
</head>

<script type="text/javascript">
	function chooseIt(additionalId,couponType,interestDays,interestType)
	{
		$("#additionalId").val(additionalId);
		$("#couponType").val(couponType);
		$("#interestDays").val(interestDays);
		$("#interestType").val(interestType);
		$("#form1").submit();
	}
</script>

<body>
	<input type="hidden" name="sorting" id="sorting" value="0">
	<form action="<%=basePath%>subject/investnow?id=${id}" id="form1" method="post">
		<input type="hidden" name="isUsed" id="isUsed" value="${couponBean.isUsed}"/>
		<input type="hidden" name="isBad"  id="isBad"   value="${couponBean.isBad}"/>
		<input type="hidden" name="couponType"  id="couponType" value="${couponBean.couponType}"/>
		<input type="hidden" name="additionalId"  id="additionalId" value="${couponBean.additionalId}"/>
		<input type="hidden" name="iMoney"  id="iMoney" value="${inputMoney}"/>
		<input type="hidden" name="interestDays"  id="interestDays" />
		<input type="hidden" name="interestType"  id="interestType" />
	</form>
		<div id="wrap">
			<!--内容开始-->
			<div class="content">
				<c:if test="${!empty listCouponBean }">
				<c:forEach items="${listCouponBean}" var="cd">
				<div id="${cd.additionalId}"  onclick="chooseIt(${cd.additionalId},${cd.couponType},${cd.interestDays},${cd.interestType })"
					<c:choose>
						<c:when test="${'1'==cd.isUsed}">
							class="content-detail  gq"
						</c:when>
						<c:when test="${'0'==cd.isUsed && '1'==cd.isBad}">
							 class="content-detail  gq"
						</c:when>
						<c:otherwise>   
							<c:if test="${'0'==cd.couponType}">class="content-detail zzq"</c:if>
							<c:if test="${'1'==cd.couponType}">class="content-detail jxq" </c:if>
							<c:if test="${'2'==cd.couponType}">class="content-detail tyj" </c:if>
							<c:if test="${'3'==cd.couponType}">class="content-detail xjq"</c:if>		
							<c:if test="${'4'==cd.couponType}">class="content-detail txq" </c:if>
							<c:if test="${'5'==cd.couponType}">class="content-detail hdq" </c:if>
						</c:otherwise> 
					</c:choose>>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>
								<c:if test="${'0'==cd.couponType || '2'==cd.couponType}">
									<span class="yhq-tips">¥</span><fmt:formatNumber type="number" value="${cd.couponMoney}" maxFractionDigits="0"></fmt:formatNumber>
								</c:if>
								<c:if test="${'1'==cd.couponType}">
									<fmt:formatNumber type="number" value="${cd.couponMoney}" maxFractionDigits="2"></fmt:formatNumber><span class="yhq-tips">%</span>
								</c:if>
								
								<c:if test="${'3' ==cd.couponType || '5' ==cd.couponType}">
									<fmt:formatNumber type="number" value="${cd.couponMoney}" maxFractionDigits="2"></fmt:formatNumber><span class="yhq-tips">元</span>
								</c:if>
							</th>
							<th class="yhq-type">
								<c:if test="${'0'==cd.couponType }">增值券</c:if>
								<c:if test="${'1'==cd.couponType }">加息券</c:if> 
								<c:if test="${'2'==cd.couponType }">体验金</c:if>
								<c:if test="${'3'==cd.couponType }">现金券</c:if>
								<c:if test="${'4'==cd.couponType }">提现券</c:if>
								<c:if test="${'5'==cd.couponType }">活动券</c:if>
							</th>
							<th></th>
						</tr>
					</table>
					<ul>
						<li>
							<c:choose>
								<c:when test="${'0'==cd.couponType}"><img src="images/wx-yhq-yxq-zzq.png" /></c:when>
								<c:when test="${'1'==cd.couponType}"><img src="images/wx-yhq-yxq-jxq.png" /></c:when>
								<c:when test="${'2'==cd.couponType}"><img src="images/wx-yhq-yxq-tyj.png" /></c:when>
								<c:when test="${'3'==cd.couponType}"><img src="images/wx-yhq-yxq-xjq.png" /></c:when>		
								<c:when test="${'4'==cd.couponType}"><img src="images/wx-yhq-yxq-txq.png" /></c:when>
								<c:when test="${'5'==cd.couponType}"><img src="images/wx-yhq-yxq-hdq.png" /></c:when>
								<c:otherwise><img src="images/wx-yhq-gq-yxq.png" /></c:otherwise>
							</c:choose>
							<span>到期时间</span>：
							<c:if test="${'-1'==cd.validityDays }">永久有效</c:if> 
							<c:if test="${'-1'!=cd.validityDays }">${cd.outTime }号后失效</c:if>
						</li>
						<li>
							<img src="images/wx-yhq-sysm.png" /><span>使用说明</span>：
							<c:if test="${cd.startMoney=='0'}">起投无限制</c:if>
							<c:if test="${cd.startMoney!='0'}">投资${cd.startMoney}元可用</c:if>
							<span style="padding-left:3px;color:red;">
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
							</span>
						</li>
						<li>
							<c:if test="${ '0'==cd.couponType || '1'==cd.couponType || '2'==cd.couponType}">
								<img src="images/wx-yhq-jxqx.png" /><span>计息期限</span>：
								<c:if test="${'-1'==cd.interestDays }">无期限</c:if> 
									<c:if test="${'-1'!=cd.interestDays }">${cd.interestDays}
									<c:if test="${'0'==cd.interestType }">天</c:if>
									<c:if test="${'1'==cd.interestType }">月</c:if>
									<c:if test="${'2'==cd.interestType }">年</c:if>
								</c:if>
							</c:if>
						</li>
					</ul>
				</div>
			</c:forEach>
			</c:if>
			</div>
		</div>
		<div class="span"></div>
	<jsp:include page="../navigation/emptyDiv.jsp" flush="true"/>	
	<!-- 底部导航 -->
	<jsp:include page="../navigation/navigation.jsp" flush="true"/>
</body>
</html>
