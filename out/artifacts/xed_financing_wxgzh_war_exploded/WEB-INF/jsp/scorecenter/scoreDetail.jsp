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
<script type="text/javascript" src="js/scorecenter/scoreDetail.js"></script>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>鱼干明细</title>
<link rel="stylesheet" type="text/css" href="css/scorecenter/scoreDetail.css"/>
</head>
<script type="text/javascript">
	
</script>
<body>
<input type="hidden" id="basePath" value="<%=basePath%>" />

	<!-- *********************************************** -->
	<div class="wrap">
		<!-- 顶部导航 -->
		<div class="screening">
			<ul>
				<li><img src="images/back.png" class="back"
					onclick="backScoreCenter()" /><span>鱼干明细</span></li>
			</ul>
		</div>
		<!-- End 顶部导航 -->

		<div class="filtrate">
			<!--切到哪个筛选条件 就给对应的加类名 .currentChose_head-->
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th class="currentChose_head" onclick="Flag(this)">全部</th>
					<th onclick="Flag(this,0)">收入</th>
					<th onclick="Flag(this,1)">支出</th>
				</tr>

			</table>
		</div>

		<!--内容开始-->
		<div class="content">
			<c:if test="${!empty accountScoreList }">
				<ul>
					<c:forEach items="${accountScoreList}" var="cd">
						<li>
						<div class="content_detail_left income">
							<c:if test="${'0'==cd.inExpend}">
									+${cd.score}
								</c:if> <c:if test="${'1'==cd.inExpend}">
									-${cd.score}
								</c:if>
							</div>
							<div class="content_detail_right">
								<p class="contentName">
								<c:if test="${'0'==cd.scoreType }">
									签到
								</c:if>
								<c:if test="${'1'==cd.scoreType }">
									完善信息
								</c:if>
								<c:if test="${'2'==cd.scoreType }">
									投标奖励
								</c:if>
								<c:if test="${'3'==cd.scoreType }">
									鱼干兑换
								</c:if>
								<c:if test="${'4'==cd.scoreType }">
									鱼干抽奖
								</c:if>
								<c:if test="${'5'==cd.scoreType }">
									鱼干购买
								</c:if>
								<c:if test="${'6'==cd.scoreType }">
									其他
								</c:if>
								<c:if test="${'7'==cd.scoreType }">
									鱼干退回
								</c:if>
								<c:if test="${'8'==cd.scoreType }">
									债权转让
								</c:if>
								<c:if test="${'9'==cd.scoreType }">
									加急转让
								</c:if>
								<c:if test="${'10'==cd.scoreType }">
									特权补签
								</c:if>
								<c:if test="${'11'==cd.scoreType }">
									优惠券融合
								</c:if>
							</p>
							<p class="contentTime">${cd.modTime}</p>
							</div>
						</li>
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