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
<script type="text/javascript" src="js/cat-js/capitalDetailInfo/dealRecordl.js"></script>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>交易记录</title>
<link rel="stylesheet" type="text/css" href="css/capitalDetailInfo/dealRecordl.css"/>
</head>
<script type="text/javascript">
	
</script>
<body>

	<!-- *********************************************** -->
	<div class="wrap">
		<!-- 顶部导航 -->
		<div class="screening">
			<ul>
				<li><img src="images/back.png" class="back"
					onclick="backMyCenter()" /><span>资金明细</span></li>
			</ul>
		</div>
		<!-- End 顶部导航 -->

		<!--优惠券列表
			<div class="grade-eject">
				<ul class="grade-w" id="gradew">
					<li onclick="grade1(this)">全部 <span class="selectBox"><img src="images/select.png" class="select"/></span></li>
					<li onclick="grade1(this)">投资</li>
					<li onclick="grade1(this)">回款 </li>
					<li onclick="grade1(this)">充值 </li>
					<li onclick="grade1(this)">提现</li>
				</ul>
			</div>-->

		<div class="filtrate">
			<!--切到哪个筛选条件 就给对应的加类名 .currentChose_head-->
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th class="currentChose_head" onclick="Flag(this)">全部</th>
					<th onclick="Flag(this,3)">投资</th>
					<th onclick="Flag(this,0)">充值</th>
					<th onclick="Flag(this,5)">提现</th>
				</tr>

			</table>
		</div>

		<!--内容开始-->
		<div class="content">
			<c:if test="${!empty capitalDetailList }">
				<ul>
					<c:forEach items="${capitalDetailList}" var="cd">
						<li><c:if test="${'0'==cd.inExpend}">
								<div class="content_detail_left income">+${cd.money}</div>
							</c:if> <c:if test="${'1'==cd.inExpend}">
								<div class="content_detail_left expend">-${cd.money}</div>
							</c:if>
							<div class="content_detail_right">
								<p class="contentName">
									<c:if test="${'0'==cd.type }">
											储蓄卡充值
								</c:if>
									<c:if test="${'1'==cd.type }">
											微信充值
								</c:if>
									<c:if test="${'2'==cd.type }">
											信用卡充值
								</c:if>
									<c:if test="${'3'==cd.type }">
											投资投标
									</c:if>
									<c:if test="${'4'==cd.type }">
											投资收益
										</c:if>
									<c:if test="${'5'==cd.type }">
											提现
										</c:if>
									<c:if test="${'6'==cd.type }">
											债权转出
										</c:if>
									<c:if test="${'7'==cd.type }">
											债权接收
										</c:if>
									<c:if test="${'8'==cd.type }">
											爆款退款
										</c:if>
									<c:if test="${'9'==cd.type }">
											投资结算
										</c:if>
									<c:if test="${'10'==cd.type }">
											活动获取
									</c:if>
									<c:if test="${'11'==cd.type }">
											购买鱼干
									</c:if>
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
									<c:if test="${'16'==cd.type }">
											工资发放
									</c:if>
									<c:if test="${'17'==cd.type }">
											邀请好友奖励
									</c:if>
									<c:if test="${'18'==cd.type }">
											投资众筹
									</c:if>
									<c:if test="${'19'==cd.type }">
											猫咪储蓄提取
									</c:if>
									<c:if test="${'20'==cd.type }">
											利息管理费
									</c:if>
									<c:if test="${'21'==cd.type }">
											提现手续费
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