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
	<link rel="stylesheet" type="text/css" href="css/subject/subjectlist.css" />
    <title>投资中心</title>

	<script type="text/javascript">
	

	function changeBiao(obj,sType)
	{
		
		$("#subjectType").val(sType)
		var form = document.forms['form1'];
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
	
	function toBack()
	{
		window.location.href='<%=basePath%>capital/querycapital';	
	}
	function orderBY(obj,flag)
	{
		var form2 = document.forms['form1'];
		var types=$("#types").val();
		if("0"==types)
		{
			form2.action = '<%=basePath%>subject/s/querynewsubject?flag='+flag;
		}
		else if("1"==types)
		{
			form2.action = '<%=basePath%>subject/s/querysubject?flag='+flag;
		}
		else if("4"==types)
		{
			form2.action = '<%=basePath%>subject/s/queryhighsubject?flag='+flag;
		}
		form2.submit();
	}
	/* function displaySubMenu(li) {
		var subMenu = li.getElementsByTagName("ul")[0];
		subMenu.style.display = "block";
	}

	function hideSubMenu(li) {
		var subMenu = li.getElementsByTagName("ul")[0];
		subMenu.style.display = "none";
	} */
	function gotodetail(obj){
		$("#id").val(obj)
		$("#gotodetailFrm").submit();
	}
	</script>
  </head>
  
  <body>
  <input type="hidden" id="basePath" value="<%=basePath%>" />
  
 	<form method="post" action="" id="form1" >
    	<input type="hidden" id="subjectType"  name="subjectType"/>
    </form>
	<form method="post" action="<%=basePath%>subject/detailsubject?type=${types}" id="gotodetailFrm" >
    	<input type="hidden" id="id"  name="id" value=""/>
    </form>
    <input type="hidden" id="types" value="${types}">
    <input type="hidden" id="flag" value="${flag}">
	<div class="wrap">
			<%-- <div class="navigation">
				<!--切到哪个标 就给对应的加类名 .currentChose_head-->
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="changeBiao(this,0)" <c:if test="${'0'==types}">class="currentChose_head"</c:if>>新手标</th>
						<th onclick="changeBiao(this,1)" <c:if test="${'1'==types}">class="currentChose_head"</c:if>>精选理财</th>
						<!-- <th onclick="changeBiao(this,2)" <c:if test="${'2'==types}">class="currentChose_head"</c:if>>实物标</th> -->
						<th onclick="changeBiao(this,4)" <c:if test="${'4'==types}">class="currentChose_head"</c:if>>爆款标</th>
						<th onclick="changeBiao(this,5)" <c:if test="${'5'==types}">class="currentChose_head"</c:if>>债权转让</th>
					</tr>
				</table>
			</div> --%>
			<div class="navigation">
				<!--切到哪个标 就给对应的加类名 .currentChose_head-->
				<div class="swiper-container">
					<div class="swiper-wrapper">
						<div class="swiper-slide <c:if test="${'0'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,0)">新手专享</div>
						<div class="swiper-slide <c:if test="${'1'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,1)">精选理财</div>
						<div class="swiper-slide <c:if test="${'4'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,4)">爆款推荐</div>
						<div class="swiper-slide" onclick="changeBiao(this,7)">猫咪众筹</div>
						<%-- <div class="swiper-slide <c:if test="${'6'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,6)">猫咪宝</div> --%>
						<%-- <div class="swiper-slide <c:if test="${'5'==types}"> currentChose_head</c:if>" onclick="changeBiao(this,5)">债权转让</div> --%>
					</div>
					<!-- Add Arrows -->
					<div id="swiper_go_right" class="swiper-button-next"></div>
					<div id="swiper_go_left" class="swiper-button-prev"></div>

				</div>
			</div>
			<div class="filtrate">
				<!--切到哪个筛选条件 就给对应的加类名 .currentChose_head-->
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="orderBY(this,'')" <c:if test="${''==flag}">class="currentChose_head"</c:if>>默认</th>
						<th onclick="orderBY(this,1)"  <c:if test="${'1'==flag}">class="currentChose_head"</c:if>>利率</th>
						<th onclick="orderBY(this,2)"  <c:if test="${'2'==flag}">class="currentChose_head"</c:if>>金额</th>
						<th onclick="orderBY(this,3)"  <c:if test="${'3'==flag}">class="currentChose_head"</c:if>>期限</th>
					</tr>

				</table>
			</div>
			
			<div class="content">
			<c:if test="${!empty subjectList }">
			<c:forEach items="${subjectList}" var="sj">
				<div class="content_detail" onclick="gotodetail(${sj.subjectId})">
					<p class="content_detail_title">
						<c:choose>
							<c:when test="${types=='0'}">
								<img src="images/bid-new.png" />
							</c:when>
							<c:when test="${types=='1'}">
								<img src="images/bid-regular.png" />
							</c:when>
							<c:when test="${types=='4'}">
								<c:choose>
									<c:when test="${sj.subjectId==guoQingId }">
										<img src="images/national_iocn.png">
									</c:when>
									<c:when test="${sj.subjectId==zhongQiuId }">
										<img src="images/mid_icon_subject.png">
									</c:when>
									<c:otherwise>
										<img src="images/bid-hot.png" />
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>
						
						
						<b>${sj.subjectName }
								<c:if test="${'0'==sj.subjectTerm }"><img style="width:15px;" src="images/icon/subject/day_subject_iocn.png"></c:if>
								<c:if test="${'1'==sj.subjectTerm }"><img style="width:15px;" src="images/icon/subject/month_subject_iocn.png"></c:if>
								<c:if test="${'2'==sj.subjectTerm }"><img style="width:15px;" src="images/icon/subject/year_subject_iocn.png"></c:if>
						</b>
						<b>期限：
							<span>${sj.subjectPeriods }
								<c:if test="${'0'==sj.subjectTerm }">天</c:if>
								<c:if test="${'1'==sj.subjectTerm }">月</c:if>
								<c:if test="${'2'==sj.subjectTerm }">年</c:if>
							</span>
						</b>
					</p>
					<p class="content_detail_title-icon">
					<c:if test="${types=='0'}">
						<span class="limit-1">限投${newCount}次</span>
					</c:if>
						<span class="limit-1"><fmt:formatNumber type="number" value="${sj.subjectStartingMoney}" maxFractionDigits="0"></fmt:formatNumber>起投</span>
						<span class="limit-1">
							<c:if test="${'0'==sj.isLimit }">无限制</c:if>
							<c:if test="${'1'==sj.isLimit }">限制所有</c:if>
							<c:if test="${'2'==sj.isLimit }">部分限制</c:if>
						</span>
						<span class="limit-2">
							<c:if test="${'-1'==sj.subjectStatus }">暂未发标</c:if>
							<c:if test="${'0'==sj.subjectStatus }">筹标中</c:if>
							<c:if test="${'1'==sj.subjectStatus }">已满标</c:if>
							<c:if test="${'2'==sj.subjectStatus }">满标复审</c:if>
							<c:if test="${'3'==sj.subjectStatus }">还款中</c:if>
							<c:if test="${'4'==sj.subjectStatus }">流标</c:if>
							<c:if test="${'5'==sj.subjectStatus }">已结束</c:if>
						</span>
						
					</p>
					<div class="content_detail_box">
						<div class="content_detail_left">
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th>${sj.subjectRate } <span>%</span> </th>
								<th>剩： <span>${sj.subjectOverplusMoney}</span> 元</th>								
							</tr>							
						</table>
					</div>
			
					<div class="circle">
						<div class="pie_left">
							<div class="left"></div>
						</div>
						<div class="pie_right">
							<div class="right"></div>
						</div>
						<div class="mask"><span>${sj.perSubject}</span>%</div>
					</div>	
					</div>
					
					<p class="bidNum">标编号：${sj.subjectCode}</p>
				</div>
			</c:forEach>
			</c:if>
		
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
