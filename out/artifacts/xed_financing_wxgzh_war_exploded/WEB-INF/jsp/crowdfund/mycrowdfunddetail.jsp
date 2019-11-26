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
<title>我的众筹详情</title>
<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/crowdfund/mycrowdfunddetail.css"/>
</head>
<body>
	<div class="wrap">
			<div class="head">
				<div class="swiper-container">
					<div class="swiper-wrapper">
						<c:forEach items="${gList}" var="sj">
							<div class="swiper-slide"><img src="${sj.picUrl }" /></div>
						</c:forEach>
					</div>
					<!-- Add Pagination -->
					<div class="swiper-pagination"></div>
				</div>
				<!--众筹中 未开奖-->
				<c:if test="${cBean.crowdStatus==1 }">
				<div class="zc-state zc-i-wkj">
					<div class="zc-state-left">
						<img src="images/zc-icon-i.png" />
					</div>
					<div class="zc-state-right">
						距离开奖还有：${cBean.overDay }天
					</div>
				</div>
				<p class="zc-name zc-i-wkj">当前未开奖</p>
				</c:if>
				
				<!--众筹成功 未中奖-->
				<c:if test="${cBean.crowdStatus==5 }">
				<c:if test="${empty rspList2}">
				<div class="zc-state zc-t-wzj">
					<div class="zc-state-left">
						开奖号码：
						<c:forEach items="${numList}" var="cd">
							<span>${cd}</span>
						</c:forEach>
					</div>
				</div>
				<p class="zc-name zc-t-wzj">很遗憾，您当前未中奖</p>
				</c:if>
				</c:if>
				
				
				<!--众筹成功 中奖-->
				<c:if test="${cBean.crowdStatus==5 }">
				<c:if test="${!empty rspList2}">
				<div class="zc-state zc-t-zj">
					<div class="zc-state-left">
						开奖号码：
						<c:forEach items="${numList}" var="cd">
							<span>${cd }</span>
						</c:forEach>
						
					</div>
				</div>
				</c:if>
				</c:if>
				<div class="zc-name zc-t-zj">
					<p style="padding: 10px 0;">
						<c:forEach items="${rspList2}" var="cd">
							<span>${cd }</span>
						</c:forEach>
					</p>
					<p style="background-color: #F4F4F4;">您的中奖号码</p>
				</div>
				
				<c:if test="${cBean.crowdStatus==4 }">
				<!--众筹失败-->
				<div class="zc-state zc-f-wkj">
					<div class="zc-state-left">
						<img src="images/zc-icon-f.png" />
					</div>

				</div>
				<p class="zc-name zc-f-wkj">很遗憾，众筹失败</p>
				</c:if>
				
				<div class="zc-record">
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>投资金额</th>
							<th>投资时间</th>
							<th>抽奖券号</th>
							<th>是否中奖</th>
						</tr>
						<c:forEach items="${rspList}" var="cd">
						<tr>
							
							<td>${cd.eachMoney }元</td>
							<td>${cd.crowdDate }</td>
							<td>${cd.crowdNum }</td>
							<td>
								<c:if test="${cd.isWinning==0}">
									未中奖
								</c:if>
								<c:if test="${cd.isWinning==1}">
									已中奖
								</c:if>
								<c:if test="${cd.isWinning==2}">
									众筹失败
								</c:if>
								<c:if test="${cd.isWinning==3}">
									暂未开奖
								</c:if>
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
				
				<div class="zc-btn">
					<c:if test="${empty rspList2}">
					<img src="images/zc-address-before.png"/>
					</c:if>
					<c:if test="${!empty rspList2}">
					<img src="images/zc-address-after.png" onclick="goAddress()"/>
					</c:if>
				</div>
			</div>
		</div>
</body>
<script src="js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var swiper = new Swiper('.swiper-container', {
	pagination: '.swiper-pagination',
	paginationClickable: true,
	autoplay: 2000,
	loop: true,
});

function goAddress(){
	window.location.href='<%=basePath%>accountaddress/toaccountaddress';
}
</script>
</html>