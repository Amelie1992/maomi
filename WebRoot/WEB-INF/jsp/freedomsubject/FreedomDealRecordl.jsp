<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>猫咪宝明细</title>
<link rel="stylesheet" type="text/css" href="css/capitalDetailInfo/dealRecordl.css"/>
</head>
<script type="text/javascript">
function backMyCenter(){
	window.location.href="<%=basePath%>freedomsubject/toMyFreedom";
}
function Flag(type){
	window.location.href="<%=basePath%>freedomsubject/tocapitaldetail?type="+type;
}
</script>
<body>

	<!-- *********************************************** -->
	<div class="wrap">
		<!-- 顶部导航 -->
		<div class="screening">
			<ul>
				<li><img src="images/back.png" class="back"
					onclick="backMyCenter()" /><span>猫咪宝明细</span></li>
			</ul>
		</div>
		<div class="filtrate">
			<!--切到哪个筛选条件 就给对应的加类名 .currentChose_head-->
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th <c:if test="${type==0}"> class="currentChose_head" </c:if> onclick="Flag(0)">全部</th>
					<th <c:if test="${type==12}"> class="currentChose_head" </c:if> onclick="Flag(12)">转入</th>
					<th <c:if test="${type=='13'}"> class="currentChose_head" </c:if> onclick="Flag('13')">转出</th>
					<th <c:if test="${type==14}"> class="currentChose_head" </c:if> onclick="Flag(14)">收益</th>
				</tr>

			</table>
		</div>

		<!--内容开始-->
		<div class="content">
			<c:if test="${!empty cList }">
				<ul>
					<c:forEach items="${cList}" var="cd">
						<li><c:if test="${'0'==cd.inExpend}">
								<div class="content_detail_left income">+${cd.money}</div>
							</c:if> <c:if test="${'1'==cd.inExpend}">
								<div class="content_detail_left expend">-${cd.money}</div>
							</c:if>
							<div class="content_detail_right">
								<p class="contentName">
									<c:if test="${'12'==cd.type }">
											猫咪宝转入
									</c:if>
									<c:if test="${'13'==cd.type }">
											猫咪宝转出
									</c:if>
									<c:if test="${'14'==cd.type }">
											猫咪宝收益
									</c:if>
									<c:if test="${'15'==cd.type }">
											猫咪宝提现
									</c:if>
								</p>
								<p class="contentTime">${cd.dealTime}</p>
							</div></li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
		<!-- 空白导航  防止被底部导航栏遮住内容 -->
	<jsp:include page="../navigation/emptyDiv.jsp" flush="true" />
	<!-- 底部导航 -->
	<jsp:include page="../navigation/navigation.jsp" flush="true" />
	</div>
</body>
</html>