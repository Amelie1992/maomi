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
		<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/freedomsubject/freedomsubject.css"/>
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/navigation.js"></script>
		<script type="text/javascript" src="js/isWeixin.js"></script>
		<script type="text/javascript" src="js/freedomsubject/freedomsubject.js"></script>
		<title>猫咪宝列表</title>
	</head>

	<body>
		<input type="hidden" id="basePath" value="<%=basePath%>" />
		<input type="hidden" id="types" value="${types}">
    	<input type="hidden" id="flag" value="${flag}">
    	<form method="post" action="" id="form1" >
    	  <input type="hidden" id="freedomSubjectId" name="freedomSubjectId" value="">
   		</form>
		<div class="wrap">
			<div class="navigation">
				<!--切到哪个标 就给对应的加类名 .currentChose_head-->
				<div class="swiper-container">
					<div class="swiper-wrapper">
						<div class="swiper-slide" onclick="changeBiao(this,0)">新手专享</div>
						<div class="swiper-slide" onclick="changeBiao(this,1)">精选理财</div>
						<div class="swiper-slide" onclick="changeBiao(this,4)">爆款推荐</div>
						<div class="swiper-slide" onclick="changeBiao(this,7)">猫咪众筹</div>
						<div class="swiper-slide currentChose_head" onclick="changeBiao(this,6)">猫咪宝</div>
						<div class="swiper-slide" onclick="changeBiao(this,5)">债权转让</div>
					</div>
					<!-- Add Arrows -->
					<div id="swiper_go_right" class="swiper-button-next"></div>
					<div id="swiper_go_left" class="swiper-button-prev"></div>

				</div>
			</div>
			<div class="content-title">
				<img src="images/mmb-list-bg.png"/>
			</div>
			
			<c:forEach items="${rspList}" var="sj">
			<div class="content">				
				<div class="content-box">
					<p class="content-box-title">${sj.freedomSubjectName }<span class="content-box-icon">随存随取</span></p>					
					<p class="interest">${sj.freedomRate}<span>%</span></p>
					<p class="interest-tips">近七日年化收益率</p>
					<div class="content-box-left">
						<p>${sj.freedomSurplusMoney}元</p>
						<p class="interest-tips">剩余额度</p>
					</div>
					<div class="content-box-right">
						<p>${sj.freedomOriginMoney}元</p>
						<p class="interest-tips">起投金额</p>
					</div>
					<a href="javascript:investNow(${sj.freedomSubjectId})">立即投资</a>
					<p class="tips">T为买入日期，T+1为次日计息</p>
					<p class="tips">投资金额随存随取</p>
				</div>				
			</div>
			</c:forEach>
	
			
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
						<td>首页</td>
						<td class="currentChose">投资</td>
						<td>商城</td>
						<td>我</td>
					</tr>
				</table>
			</div>
		</div>
	
	</body>
	
	
	<script src="js/swiper.min.js"></script>

	<script type="text/javascript">
			var swiper = new Swiper('.swiper-container', {
			nextButton: '.swiper-button-next',
			prevButton: '.swiper-button-prev',
			slidesPerView: 3,
			initialSlide :2,
			resistanceRatio: 0,
			paginationClickable: true,
			freeMode: true
		});

	</script>

</html>