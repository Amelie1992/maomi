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
	<link rel="stylesheet" type="text/css" href="css/subject/subjectnextlist.css" />
    <title>次日发布标</title>

	<script type="text/javascript">
	function toBack()
	{
		window.location.href='<%=basePath%>fontpage/s/queryFontPage';	
	}
	function orderBY(obj,flag)
	{
		var form2 = document.forms['form1'];
		form2.action = '<%=basePath%>subject/s/querynextsubject?flag='+flag;
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
	<form method="post" action="<%=basePath%>subject/detailsubject" id="gotodetailFrm" >
    	<input type="hidden" id="id"  name="id" value=""/>
    </form>
    <input type="hidden" id="types" value="${types}">
    
    
    
    <div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="toBack()"/>次日发布
			</div>
			<div class="content">
				<!--次日发布-->
				<table border="0" cellspacing="" cellpadding="" class="bid-tips">
					<tr>
						<th>次日发布标总个数：</th>
						<th>${countNextSubject}个</th>
					</tr>
					<tr>
						<td>次日发布标总金额：</td>
						<td>${sumMoney}(元)</td>
					</tr>
				</table>
				
				<div class="space">
					
				</div>
				
				<c:if test="${empty subjectList}">
					<div class="isNone"><img src="images/yushoubiao_kong.png" /></div>
				</c:if>
				
				<c:forEach items="${subjectList}" var="sj">
					<div class="content_detail">
						<p class="content_detail_title">
							<img src="images/bid-morrow.png" />
							<b>${sj.subjectName }</b>
							<b>期限：<span>${sj.subjectPeriods}<c:if test="${'0'==sj.subjectTerm }">天</c:if><c:if test="${'1'==sj.subjectTerm }">月</c:if><c:if test="${'2'==sj.subjectTerm }">年</c:if></span></b>
						</p>
						<p class="content_detail_title-icon">
							<span class="limit-1"><fmt:formatNumber type="number" value="${sj.subjectStartingMoney}" maxFractionDigits="0"></fmt:formatNumber>起投</span>
							<span class="limit-1">准时开抢</span>
							<span class="limit-1">
								<c:if test="${'0'==sj.isLimit }">无限制</c:if>
								<c:if test="${'1'==sj.isLimit }">限制所有</c:if>
								<c:if test="${'2'==sj.isLimit }">部分限制</c:if>
							</span>
							<span class="limit-2">
								<c:if test="${'0'==sj.nextType }">新手专享标</c:if>
								<c:if test="${'1'==sj.nextType }">精选理财</c:if>
								<c:if test="${'4'==sj.nextType }">爆款标</c:if>
							</span>
						</p>
						<div class="content_detail_box">
							<div class="content_detail_left">
								<table border="0" cellspacing="" cellpadding="">
									<tr>
										<th>年化收益率： <span>${sj.subjectRate }</span>% </th>

									</tr>
									<tr>
										<th>金额： <span>${sj.subjectMoney}</span> 元</th>
									</tr>
								</table>
							</div>
							<div class="content_detail_right">
								<a>当天19:00发布</a>
								<br/>
								<a>次日9:00开抢</a>
							</div>
						</div>
						<p class="bidNum">标编号：${sj.subjectCode}</p>
					</div>
					
					<div class="space"></div>
				
				</c:forEach>
		</div>
		<!-- 空白导航  防止被底部导航栏遮住内容 -->
		<jsp:include page="../navigation/emptyDiv.jsp" flush="true"/>	
		<!-- 底部导航 -->
		<jsp:include page="../navigation/navigation.jsp" flush="true" />
	</div>
  </body>
</html>
