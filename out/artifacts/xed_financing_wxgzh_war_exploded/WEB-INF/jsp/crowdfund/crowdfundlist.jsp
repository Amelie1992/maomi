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
 <script type="text/javascript" src="js/navigation.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>众筹列表</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="js/layui-master/dist/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
<link rel="stylesheet" type="text/css" href="css/crowdfund/crowdfundlist.css"/>
</head>
<body>
	<form method="post" action="<%=basePath%>crowdfund/s/detailcrowfund" id="gotodetailFrm" >
    	<input type="hidden" id="id"  name="crowdId" value=""/>
    </form>
	<div class="wrap">
		<div class="navigation">
				<!--切到哪个标 就给对应的加类名 .currentChose_head-->
				<div class="swiper-container">
					<div class="swiper-wrapper">
						<div class="swiper-slide <c:if test="${'0'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,0)">新手专享</div>
						<div class="swiper-slide <c:if test="${'1'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,1)">精选理财</div>
						<div class="swiper-slide <c:if test="${'4'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,4)">爆款推荐</div>
						<div class="swiper-slide currentChose_head swiper-slide-active" onclick="changeBiao(this,7)">猫咪众筹</div>
						<%-- <div class="swiper-slide <c:if test="${'6'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,6)">猫咪宝</div> --%>
						<%-- <div class="swiper-slide <c:if test="${'5'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,5)">债权转让</div> --%>
					</div>
					<!-- Add Arrows -->
					<div id="swiper_go_right" class="swiper-button-next"></div>
					<div id="swiper_go_left" class="swiper-button-prev"></div>

				</div>
			</div>
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
				<div class="crowdfunding-content" onclick="detailCrowdfund(${sj.crowdId})">
					<div class="crowdfunding-content-left">
						<img src="${sj.picUrl}" />
					</div>
					<div class="crowdfunding-content-right">
						<ul>
							<li>${sj.crowdName}</li>
							<li>上限金额：${sj.crowdMoney}元</li>
							<li>商品名称：${sj.goodsName}</li>
							<li>参考年回报率：${sj.crowdRate}%</li>
							<li>投资期限：${sj.activityDay}天</li>
							<li style="margin-bottom:10px;">
								<div class="layui-progress" lay-showpercent="true">
									<div class="layui-progress-bar layui-bg-orange" lay-percent="${sj.per}%"></div>
								</div>
							</li>
						</ul>
					</div>
				</div>		
			</div>
		</c:forEach>	
		</div>	
		
		<!-- 空白导航  防止被底部导航栏遮住内容 -->
			<jsp:include page="../navigation/emptyDiv.jsp" flush="true"/>	
			
			<div class="footer">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="toChange(this,1)"><img src="images/tab_home_nor.png" /></th>
						<th onclick="toChange(this,2)"><img src="images/tab_touzi_sel.png" /></th>
						<th onclick="toChange(this,3)"><img src="images/tab_mall_nor.png" /></th>
						<th onclick="toChange(this,4)"><img src="images/tab_geren_nor.png" /></th>
					</tr>
					<tr>
						<td onclick="toChange(this,1)">首页</td>
						<td onclick="toChange(this,2)" class="currentChose">投资</td>
						<td onclick="toChange(this,3)">商城</td>
						<td onclick="toChange(this,4)">我</td>
					</tr>
				</table>
			</div>
</body>
<script src="js/layui-master/dist/layui.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/swiper.min.js"></script>
<script type="text/javascript">

var init = 0;
var inii = $('#types').val();
if(inii==4){
	init = 1;
}
var swiper = new Swiper('.swiper-container', {
	nextButton: '.swiper-button-next',
	prevButton: '.swiper-button-prev',
	slidesPerView: 3,
	resistanceRatio: 0,
	initialSlide :2,
	paginationClickable: true,
	freeMode: true
});

</script>
<script type="text/javascript">
layui.use('element', function() {
	var $ = layui.jquery,
		element = layui.element;
	//Tab的切换功能，切换事件监听等，需要依赖element模块
});

function detailCrowdfund(obj){
	$("#id").val(obj)
	$("#gotodetailFrm").submit();
}

function changeBiao(obj,sType)
{
	
	var form = document.forms['gotodetailFrm'];
	if('2'==sType)
	{
		form.action = '<%=basePath%>hotsubject/s/queryhotsubject';
	}
	else if('1'==sType)
	{
		form.action = '<%=basePath%>subject/s/querysubject';
	}
	else if('0'==sType)
	{
		form.action = '<%=basePath%>subject/s/querynewsubject';
	}
	else if('4'==sType)
	{
		form.action = '<%=basePath%>subject/s/queryhighsubject';
	}
	else if("5"==sType)
	{
		form.action = '<%=basePath%>bondTransfer/getBondTransfer';
	}
	else if("6"==sType)
	{
		form.action = '<%=basePath%>freedomsubject/s/queryfreedomsubject';
	}
	else if("7"==sType)
	{
		form.action = '<%=basePath%>crowdfund/s/querycrowfund';
	}
	form.submit();
}
</script>
</html>