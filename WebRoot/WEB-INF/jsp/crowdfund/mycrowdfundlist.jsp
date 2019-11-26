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
<title>我的众筹列表</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="js/layui-master/dist/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/crowdfund/crowdfundlist.css"/>
</head>
<body>
	<form method="post" action="<%=basePath%>crowdfund/detailmycrowfund" id="gotodetailFrm" >
    	<input type="hidden" id="id"  name="crowdId" value=""/>
    </form>
	<div class="wrap">
		<c:if test="${empty  rspList}">
		
			<div class="no-zc-record">
				<img src="images/no_crowdlist.png"/>
				<p>
					<img src="images/want_to_invest.png" onclick="goInvest()"/>
				</p>
			</div>
			
		
		</c:if>
		<c:forEach items="${rspList}" var="sj">
			<div class="crowdfundingBox">
				<div class="crowdfunding-title">
					<span></span> 
						<c:if test="${sj.crowdStatus==0 }">未开始</c:if>
						<c:if test="${sj.crowdStatus==1 }">众筹开始</c:if>
						<c:if test="${sj.crowdStatus==2 }">已满标</c:if>
						<c:if test="${sj.crowdStatus==3 }">众筹集资结束</c:if>
						<c:if test="${sj.crowdStatus==4 }">众筹失败</c:if>
						<c:if test="${sj.crowdStatus==5 }">众筹成功</c:if>
						<c:if test="${sj.crowdStatus==6 }">众筹结束</c:if>
				</div>
				<div class="crowdfunding-content" onclick="detailMyCrowdfund(${sj.crowdId})">
					<div class="crowdfunding-content-left">
						<img src="${sj.picUrl}" />
					</div>
					<div class="crowdfunding-content-right">
						<ul>
							<li>${sj.crowdName}</li>
								<!-- <li>
									<div class="layui-progress" lay-showpercent="true">
										<div class="layui-progress-bar layui-bg-orange" lay-percent="83%"></div>
									</div>
								</li> -->
							<li>商品名称：${sj.goodsName}</li>
							<li>商品价格：${sj.saleMoney}元</li>
							<li>参与计划：${sj.crowdfundCount}笔</li>
							<li>参考年回报率：${sj.crowdRate}%</li>
							<li>投资期限：${sj.activityDay}天</li>
						</ul>
					</div>
				</div>		
			</div>
		</c:forEach>		
</div>
</body>
<script src="js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layui-master/dist/layui.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
$(".no-zc-record").css("height",$(window).height());
function detailMyCrowdfund(obj){
	$("#id").val(obj)
	$("#gotodetailFrm").submit();
}
function goInvest(){
	window.location.href="./crowdfund/s/querycrowfund";	
}
</script>
</html>