<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="js/navigation.js"></script>
    <script type="text/javascript" src="js/isWeixin.js"></script>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
	<link rel="stylesheet" type="text/css" href="css/freedomsubject/dispersionsubjectlist.css" />
    <title>投资中心</title>

	<script type="text/javascript">
	

	function changeBiao(obj,sType)
	{
		
		$("#subjectType").val(sType)
		var form = document.forms['form1'];
		form.action = '<%=basePath%>subjectdispersed/querySubjectDispered';
		form.submit();
	}
	
	function goBack()
	{
		var form = document.forms['form1'];
		form.action = '<%=basePath%>subjectdispersed/querySubjectDispersedHomepage';
		form.submit();
	}
	
	function detailDispersion(subjectId){
		$("#subjectId").val(subjectId);
		var form = document.forms['form1'];
		form.action = '<%=basePath%>subjectdispersed/detailSubjectDispered';
		form.submit();
	}
	</script>
  </head>
  
  <body>
  <input type="hidden" id="basePath" value="<%=basePath%>" />
  
 	<form method="post" action="" id="form1" >
    	<input type="hidden" id="subjectType"  name="subjectType"/>
    	<input type="hidden" id="freedomSubjectId"  name="freedomSubjectId" value="${freedomSubjectId}">
    	<input type="hidden" id="subjectId"  name="subjectId"/>
    </form>
    <input type="hidden" id="types" value="${types}">
    <input type="hidden" id="flag" value="${flag}">
    
	<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()"/>分散投标列表
			</div>
			<div class="navigation">
				<!--切到哪个标 就给对应的加类名 .currentChose_head-->
				<div class="swiper-container">
					<div class="swiper-wrapper">
						<div class="swiper-slide <c:if test="${'0'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,0)">I质押类标</div>
						<div class="swiper-slide <c:if test="${'1'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,1)">II抵押类标</div>
						<div class="swiper-slide <c:if test="${'2'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,2)">III信用贷类标</div>
					</div>
				</div>
			</div>
			
			<div class="content">
				<c:forEach items="${subjectList}" var="sj">
				<!--新手-->
				<div class="content_detail" onclick="detailDispersion(${sj.subjectId})">
					<p class="content_detail_title">
						<span>
							<b <c:choose><c:when test="${types=='0'}">class="content_detail_title_b0"</c:when><c:when test="${types=='1'}">class="content_detail_title_b1"</c:when><c:when test="${types=='2'}">class="content_detail_title_b2"</c:when></c:choose>>
							<c:choose><c:when test="${types=='0'}">I</c:when><c:when test="${types=='1'}">II</c:when><c:when test="${types=='2'}">III</c:when></c:choose><c:choose><c:when test="${sj.usedPurpose=='5'}">1</c:when><c:when test="${sj.usedPurpose=='10'}">2</c:when><c:otherwise>3</c:otherwise></c:choose></b>
						</span>
						<span>编号：${sj.subjectId}</span>
						<span>
							<c:choose>
								<c:when test="${sj.usedPurpose=='5'}">
									资金周转
								</c:when>
								<c:when test="${sj.usedPurpose=='10'}">
									供应链金融
								</c:when>
								<c:otherwise>
									个人贷款
								</c:otherwise>
							</c:choose>
						</span>
					</p>

					<div class="content_detail_box">
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th>${sj.money }元</th>
								<th>${sj.subjectRate}%</th>
								<th>
								<c:if test="${sj.subjectStatus==0}">
									正常还款
								</c:if>
								<c:if test="${sj.subjectStatus==1}">
									已还款
								</c:if>
								</th>
							</tr>
							<tr>
								<td>投资金额</td>
								<td>预计利率</td>
								<td>还款中${sj.mCount }/${sj.subjectPeriods }</td>

							</tr>
						</table>

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
						<td>首页</td>
						<td class="currentChose">投资</td>
						<td>商城</td>
						<td>我</td>
					</tr>
				</table>
			</div>
		</div>
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
			initialSlide :init,
			paginationClickable: true,
			freeMode: true
		});
		$(window).scroll(function() {
			var scrollTop = $(this).scrollTop();
			var scrollHeight = $(document).height();
			var windowHeight = $(this).height();
			if(scrollHeight - scrollTop - windowHeight <= 100) {
				scrollTop = 0;
				$('.footer').css('position', 'relative');
			} else {
				$('.footer').css('position', 'fixed');
			}
		});




		$(function() {
			$('.circle').each(function(index, el) {
				var num = $(this).find('span').text() * 3.6;
				if(num <= 180) {
					$(this).find('.right').css('transform', "rotate(" + num + "deg)");
				} else {
					$(this).find('.right').css('transform', "rotate(180deg)");
					$(this).find('.left').css('transform', "rotate(" + (num - 180) + "deg)");
				};
			});
		});
		
		</script>
		
  </body>
</html>
