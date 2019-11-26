<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>我的投资</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css"
	href="css/investrecord/investrecord.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script src="js/jquery-1.10.2.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" src="js/investrecord/investrecord.js"></script>
<script type="text/javascript" src="js/navigation.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
</head>

<body>
	<input type="hidden" id="basePath" value="<%=basePath%>" />
	<form action="<%=basePath%>investrecord/toContract" method="post" id="contractForm">
		<input type="hidden" value="" id="iid" name="investId" />
		<input type="hidden" value="" id="sid" name="subjectId" />
		<input type="hidden" value="" id="type" name="type" />
	</form>
	<form method="post" action="<%=basePath%>investrecord/tomyinvest" id="gotodetailFrm" >
    	<input type="hidden" id="id"  name="investId" value=""/>
    	<input type="hidden" id="sid"  name="subjecId" value=""/>
    	<input type="hidden" id="isHome"  name="isHome" value=""/>
    </form>
	<form action="<%=basePath%>investrecord/toTransfer" name="form1"
		method="post" id="form1">
		<input type="hidden" value="" id="investId" name="investId" /> <input
			type="hidden" value="" id="investMoney" name="investMoney" /> <input
			type="hidden" value="" id="totalCreditMoney" name="totalCreditMoney" /><input
			type="hidden" value="" id="subjectRate" name="subjectRate" /><input type="hidden" id="investStatus" name="investStatus" value="">

		<div class="wrap">
			<%-- <div class="navigation">
				<!--切到哪个标 就给对应的加类名 .currentChose_head-->
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th <c:if test="${1==flag }">class="currentChose_head tz"</c:if>
							<c:if test="${2==flag }">class="tz"</c:if> onclick="changeDiv(1)">我的投资</th>
						<th <c:if test="${2==flag }">class="currentChose_head zr"</c:if>
							<c:if test="${1==flag }">class="zr"</c:if> onclick="changeDiv(2)">我的转让</th>
					</tr>
				</table>
			</div> --%>
				<div class="contentContainer">
				<c:if test="${1==flag }">
				<div class="filtrate">
					<!--切到哪个筛选条件 就给对应的加类名 .currentChose_head-->
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th onclick="queryAll(9)" <c:if test="${'9'==investStatus}">class="currentChose_head"</c:if>>全部</th>
							<th onclick="queryAll(0)"  <c:if test="${'0'==investStatus}">class="currentChose_head"</c:if>>投资中</th>
							<th onclick="queryAll(3)"  <c:if test="${'3'==investStatus}">class="currentChose_head"</c:if>>承接债权</th>
							<th onclick="queryAll(1)"  <c:if test="${'1'==investStatus}">class="currentChose_head"</c:if>>已到期</th>
						</tr>
	
					</table>
				</div>
				<div class="space">
						
				</div>
				
				<div class="content">
				    <table border="0" cellspacing="" cellpadding="" class="bid-tips">
						<tr>
							<th>待收本金：</th>
							<th>${countSumInvestSubject}元</th>
						</tr>
					</table>
					
					<div class="space">
						
					</div>
					
					
					<c:if test="${!empty rspList }">
					<c:forEach items="${rspList}" var="cd">
					<div class="content_detail">
						<p class="content_detail_title" onclick="gotodetail(${cd.investStatus},${cd.subjectId},${cd.investId},event)">
							${cd.subjectName}
							<span>
								<c:choose>
									<c:when test="${''!=cd.investMoney && '1'==cd.subjectStatus && ('1'==cd.subjectType || '4'==cd.subjectType) && '0'==cd.isCredit && '0'==cd.investStatus && cd.repeatType!='2'}">
										回款中
									</c:when>
									<c:when test="${'0'==cd.subjectStatus}">
										筹款中
									</c:when>
									<c:when test="${'3'==cd.investStatus}">
										已承接债权
									</c:when>
									<c:when test="${'1'==cd.investStatus || '4'==cd.investStatus}">
										已到期
									</c:when>
									<c:when test="${'4'==cd.investStatus}">
										流标
									</c:when>
									<c:when test="${'1'==cd.isCredit}">
										转让中
									</c:when>
									<c:otherwise>
										回款中
									</c:otherwise>
								</c:choose>
							</span>
							<c:if test="${'2'==cd.isEarly}">
								<span style="color:red">提前还款</span>
							</c:if>
							<c:if test="${'4'==cd.investStatus}">
								<span style="color:red">流标</span>
							</c:if>
							<b>${cd.investTime}</b>

						</p>
						<div class="content_detail_left" onclick="gotodetail(${cd.investStatus},${cd.subjectId},${cd.investId},event)">
							<p>
								<span class="contentRate contentRate_1">${cd.sRate}</span> <span
									class="contentRate">%<c:if test="${cd.subjectRates!='0.00'}">&nbsp;+&nbsp;${cd.subjectRates}%</c:if></span>
							</p>
							<p>
								<span class="contentTips">参考年回报率</span>
							</p>
							<p class="content_detail_box">
								<a href="javascript:void(0);" onclick="detaiContract(${cd.investId},${cd.subjectId})">点击查看协议</a>
							</p>
						</div>
						<div class="content_detail_right" onclick="gotodetail(${cd.investStatus},${cd.subjectId},${cd.investId},event)">
							<p style="height:20px;">
								<span class="contentTips" style="color:#FC7831;">${cd.investMoney}(元)</span>
								<span class="redPacket">
									<c:if test="${'3'!=cd.investStatus && '-1'!=cd.subjectId}">
										<c:choose>
											<c:when test="${'0'!=cd.couponMoney}">
												(+${cd.couponMoney}元)
											</c:when>
											<c:when test="${'0.00'!=cd.subjectRates}">
												(+<fmt:formatNumber type="number" value="${cd.subjectRates-cd.vipRate}" maxFractionDigits="2"></fmt:formatNumber>%)
												
											</c:when>
											<c:otherwise>
												
											</c:otherwise>
										</c:choose>
									</c:if>
								
								
								</span>
							</p>
							<p>
								<c:if test="${'0'==cd.repeatType}">等额本息</c:if>
								<c:if test="${'1'==cd.repeatType}">先息后本</c:if>
								<c:if test="${'2'==cd.repeatType}">到期还本付息</c:if>
							</p>
							<p><span style="font-size:12px;padding-right:5px;">到期时间:</span>${cd.endTime}</p>
						</div>
						<!-- <p style="line-height: 30px;padding:0 10px;color: #888888;">查看合同详情
							<span style="float: right;">到期时间：2017-10-09</span>
						</p> -->
						<%-- <div class="content_detail_box">
							<a href="javascript:void(0);" onclick="detaiContract(${cd.investId},${cd.subjectId})">点击查看协议</a>
						</div> --%>
					</div>
					
					<div class="space"></div>
					</c:forEach>
					</c:if>
				</div>
				</c:if>
				<c:if test="${2==flag }">
				<div class="content">
					<c:if test="${!empty rspList }">
					<c:forEach items="${rspList}" var="cd">
					<div class="content_detail">
						<p class="content_detail_title">
							${cd.subjectName} 
							<span>
								<c:if test="${'' != cd.dealTime && null != cd.dealTime}">
									转让成功
								</c:if>
								<c:if test="${'' == cd.dealTime || null == cd.dealTime}">
									<c:if test="${cd.creditType == 0}">
										普通转让
									</c:if>
									<c:if test="${cd.creditType == 1}">
										加急转让
									</c:if>
									<c:if test="${cd.creditType == 2}">
										平台接盘
									</c:if>
								</c:if>
							</span> 
							<b>${cd.creditTime}</b>

						</p>
						<div class="content_detail_left">
							<p>
								<span class="contentRate contentRate_1">${cd.creditRate}</span> <span
									class="contentRate">%</span>
							</p>
							<p>
								<span class="contentTips">转让利率</span>
							</p>
							<p>
								<span class="contentTips" onclick="toTransferConstact(${cd.investId},1);" style="color:#FFC040;">点击查看协议</span>
							</p>
						</div>
						<div class="content_detail_right" style="text-align:center;">
							<p>
								<c:if test="${cd.creditType ==0 && (''==cd.dealTime ||null==cd.dealTime)}">
									<input type="button" class="chengjieBtn" id="${cd.creditId }" value="加急转让" onclick="fastTransfer(${cd.investId},${cd.creditId },${fastscore})"/>
								</c:if>
								<c:if test="${cd.creditType ==1}">
									<input type="button" class="chengjieBtn2" id="${cd.creditId }" value="已加急" disabled="disabled"/>
								</c:if>
								<%-- <c:if test="${''==cd.dealTime || null==cd.dealTime}">
									<input type="button" class="chengjieBtn" id="${cd.creditId }a" value="平台承接" onclick="sysTransfer(${cd.investId},${cd.creditId })"/>
								</c:if>
								 --%>
								<c:if test="${''!=cd.dealTime && null!=cd.dealTime}">
									<input type="button" class="chengjieBtn2"  value="已转出" disabled="disabled"/>
								</c:if>
							</p>
							<p>
								<c:if test="${'2'!=cd.creditType && (''==cd.dealTime ||null==cd.dealTime)}">
									<input type="button" class="chengjieBtn"  value="取消转让" onclick="cancelTransfer(${cd.investId},${cd.creditId })"/>
								</c:if>
							</p>
							<p>
								<span class="contentTips">转让成功${cd.creditMoney}元</span>
							</p>
						</div>
					</div>
					<div class="space"></div>
					</c:forEach>
					</c:if>
				</div>
				</c:if>
			</div>
		</div>
	</form>
	<!-- 空白导航  防止被底部导航栏遮住内容 -->
	<jsp:include page="../navigation/emptyDiv.jsp" flush="true" />
	<!-- 底部导航 -->
	<jsp:include page="../navigation/navigation.jsp" flush="true" />
</body>

</html>
