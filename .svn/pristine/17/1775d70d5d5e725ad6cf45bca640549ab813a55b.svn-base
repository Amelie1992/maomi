<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" type="text/css" href="css/freedomsubject/myfreeedomsubject.css" />
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/validate.js"></script>
		<script type="text/javascript" src="js/isWeixin.js"></script>
		<script type="text/javascript" src="js/freedomsubject/myfreeedomsubject.js"></script>
		
		<title>我的猫咪宝</title>
		
	</head>

	<body>
		<input type="hidden" id="basePath" value="<%=basePath%>" />
		<input type="hidden" id="availableBalance" value="${capitalBean.availableBalance }" />
		<input type="hidden" id="limitMoney" value="${fBean.freedomRestrictMoney}" />
		<input type="hidden" id="rates" value="${rates}">
		<input type="hidden" id="dates" value="${dates}">
		<form method="post" action="" id="form1" >
			<input type="hidden" name="inputMoney" id="inputMoney">
			<input type="hidden" id="freedomSubjectId" name="freedomSubjectId" value="${fBean.freedomSubjectId}">
   			<input type="hidden" id="type" name="type" value="">
   		</form>
		<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()"/>我的猫咪宝
			</div>
			<div class="headInforBox">
				<p>总资产(元)</p>
				<p>${capitalBean.freedomMoney }</p>
                <p class="more" onclick="queryCapitalDetail()">明细</p>
				<div>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>昨日收益(元)</th>
							<th>累计收益(元)</th>
						</tr>
						<tr>
							<td>${yesertdayPromitMoney }</td>
							<td>${sumPromitMoney }</td>
						</tr>
					</table>
				</div>
			</div>
			
			<!-- 不为空 -->
			<%-- <c:if test="${!empty subjectList }"> --%>
			<c:forEach items="${rspList}" var="sj">
			<div class="content">
				<div class="content-box">
					<div class="content-title-left">

						<img src="images/mmb-icon.png" /> ${sj.freedomSubjectName }

					</div>

					<div class="content-title-right">

						<span>
							持有(元)：
						</span> ${sj.haveSumMoney }

					</div>
				</div>
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>昨日收益(元)</th>
						<th>累计收益(元)</th>
					</tr>
					<tr>
						<td>${sj.yesterdayPorfit }</td>
						<td>${sj.sumProfit }</td>
					</tr>
				</table>
				<div class="content-box-2">
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th onclick="turnoutMoney(${sj.freedomSubjectId })">
								<img src="images/mmb-in.png" /> 转出
							</th>
							<th onclick="turninMoney(${sj.freedomSubjectId },2)">
								<img src="images/mmb-out.png" /> 转入
							</th>
						</tr>

					</table>
				</div>
			</div>
			</c:forEach>
			<%-- </c:if> --%>
	
		</div>
	</body>
	
	


</html>