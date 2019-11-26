<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<title>排行榜</title>
<style type="text/css">
		.wrap {
			width: 100%;
			color:#888;
		}
		.title {
			width: 100%;
			position: relative;
			text-align: center;
			font-size: 18px;
			color: #333333;
			/*font-weight: 600;*/
			height: 40px;
			line-height: 40px;
			background-color: #F7F7F7;
		}
		
		.back {
			position: absolute;
			left: 20px;
			top: 14px;
			width: 10px;
			height: 15px;
		}
		
		#tab {
			width: 100%;
			
			padding-top: 24px;
		}
		
		#tab .tabList {
			width: 80%;
			height: 40px;
			margin: 0 auto;
			/*overflow: hidden;*/
			border: 1px solid #FF8310;
			border-radius: 20px;
			color: #F95D18;
		}
		
		#tab .tabList li {
			width: 50%;
			height: 40px;
			float: left;
			text-align: center;
			line-height: 40px;
			font-size: 16px;
			border-radius: 19px;
		}
		
		#tab .tabList .cur {
			color: white;
			background-color: #F95D18;
		}
		
		.tabCon {
			position: relative;
		    height: 750px;
			padding: 20px;
		}
		
		.program_1_con {
			width: 100%;
			position: absolute;
			top: 0;
			left: 0;
			opacity: 1;
			z-index: 10;
			text-align: center;
		}
		
		.program_1_con p {
			font-size: 16px;
			line-height: 50px;
			color: #212121;
			padding: 10px 0;
		}
		
		.program_1_con p i {
			display: inline-block;
			width: 35px;
			font-size: 30px;
			color: #F95D18;
			font-weight: bold;
			text-align: center;
		}
		
		.program_2_con {
			width: 100%;
			/*height: 350px;*/
			position: absolute;
			top: 0;
			left: 0;
			opacity: 0;
			z-index: 1;
			text-align: center;
		}
		
		.program_common p {
			font-size: 16px;
			line-height: 50px;
			color: #888;
			padding: 10px 0;
		}
		
		.program_2_con p {
			padding: 13px 0;
			color: #888;
		}
		
		.program_1_con p i {
			display: inline-block;
			width: 35px;
			font-size: 30px;
			color: #F95D18;
			font-weight: bold;
			text-align: center;
		}
		.program_2_con p i {
			display: inline-block;
			width: 35px;
			font-size: 30px;
			color: #F95D18;
			font-weight: bold;
			text-align: center;
		}
		.program_common ul {
			width: 100%;
		}
		
		.program_common ul li {
			height: 70px;
			width: 100%;
			background-size: 100% 100%;
			background-repeat: no-repeat;
			background-position: center;
		}
		
		.program_common ul li table th:nth-of-type(1) {
			width: 25%;
		}
		
		.program_common ul li:nth-of-type(1) {
			background-image: url(images/rank1.png);
			color: white;
		}
		
		.program_common ul li:nth-of-type(2) {
			background-image: url(images/rank2.png);
			color: white;
		}
		
		.program_common ul li:nth-of-type(3) {
			background-image: url(images/rank3.png);
			color: white;
		}
		
		.program_common ul li:nth-of-type(4) {
			background-image: url(images/rank4.png);
		}
		
		.program_common ul li:nth-of-type(5) {
			background-image: url(images/rank5.png);
		}
		
		.program_common ul li:nth-of-type(6) {
			background-image: url(images/rank6.png);
		}
		
		.program_common ul li:nth-of-type(7) {
			background-image: url(images/rank7.png);
		}
		
		.program_common ul li:nth-of-type(8) {
			background-image: url(images/rank8.png);
		}
		
		.program_common ul li:nth-of-type(9) {
			background-image: url(images/rank9.png);
		}
		
		.program_common ul li:nth-of-type(10) {
			background-image: url(images/rank10.png);
		}
		
		.program_common ul li table {
			width: 100%;
			/*margin-left: 5%;*/
			text-align: center;
			line-height: 60px;
		}
		.footer {
			background-color: #fafafa;
			/*height: 80px;*/
			position: fixed;
			left: 0;
			bottom: 0;
			width: 100%;
			z-index:102;
		}
		
		.footer table {
			width: 100%;
			text-align: center;
			font-size: 14px;
		}
		
		.footer table img {
			width: 30%;
		}
	</style>
</head>

<body>
		<form action="<%=basePath%>sorting/querysorting" name="form1" method="post" id="form1">
		<input type="hidden"  id="flag" name="flag" value="${flag}"/>
		<input type="hidden"  id="flag1111" name="flag1111" value="${isExist}"/>
		</form>
		<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()"/>投资达人排行榜
			</div>
			<div id="tab">
				<div class="tabList">

					<ul>
						<li 
							<c:if test="${1==flag }">class="cur program_1"</c:if>
							<c:if test="${2==flag }">class="program_1"</c:if> 
							onclick="changeDiv(1)">月榜</li>
						<li <c:if test="${1==flag }">class="program_2"</c:if>
							<c:if test="${2==flag }">class="cur program_2"</c:if> 
							onclick="changeDiv(2)">总榜</li>
					</ul>
				</div>
				<div class="tabCon">
					<c:if test="${1==flag }">
					<div class="program_1_con program_common">
						<c:choose>
							<c:when test="${''!=isExist }">
								<p>您当前排名第 <i>${isExist}</i>&nbsp;&nbsp;位</p>
							</c:when>
							<c:otherwise>
								<p>您当前未上榜</p>
							</c:otherwise>
						</c:choose>
						
						<ul>
							<c:forEach items="${rspList}" var="sj">
							<li>
								<table border="0" cellspacing="" cellpadding="">
									<tr>
										<th></th>
										<th>${sj.telephone }</th>
										<th>${sj.investMoney }元</th>
									</tr>

								</table>
							</li>
							</c:forEach>
						</ul>
					</div>
					</c:if>
					<c:if test="${2==flag }">
					<div class="program_2_con program_common">
						<c:choose>
							<c:when test="${''!=isExist }">
								<p>您当前排名第 <i>${isExist}</i>&nbsp;&nbsp;位</p>
							</c:when>
							<c:otherwise>
								<p>您当前未上榜</p>
							</c:otherwise>
						</c:choose>
						<ul>
							<c:forEach items="${rspList}" var="sj">
							<li>
								<table border="0" cellspacing="" cellpadding="">
									<tr>
										<th></th>
										<th>${sj.telephone }</th>
										<th>${sj.investMoney }元</th>
									</tr>

								</table>
							</li>
							</c:forEach>
							<li>
								<table border="0" cellspacing="" cellpadding="">
									<tr>
										<th></th>
										<th></th>
										<th></th>
									</tr>

								</table>
							</li>
						</ul>
					</div>
					</c:if>
				</div>
			</div>
		</div>
		<jsp:include page="../navigation/emptyDiv.jsp" flush="true" />
			<div class="footer">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="toChange(this,1)"><img src="images/tab_home_sel.png" /></th>
						<th onclick="toChange(this,2)"><img src="images/tab_touzi_nor.png" /></th>
						<th onclick="toChange(this,3)"><img src="images/tab_mall_nor.png" /></th>
						<th onclick="toChange(this,4)"><img src="images/tab_geren_nor.png" /></th>
					</tr>
					<tr>
						<td class="currentChose">首页</td>
						<td>投资</td>
						<td>商城</td>
						<td>我</td>
					</tr>
				</table>
			</div>
	
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/navigation.js"></script>
	<script type="text/javascript">
		$(function(){ 
			var flag=$("#flag").val();
			if(flag==1)
			{
				$('.program_1').css('color', 'white');
				$('.program_1').css('background-color', '#F95D18');
				$('.program_2').css('color', '#F95D18');
				$('.program_2').css('background-color', 'white');
				$('.program_1_con').css('opacity', '1');
				$('.program_1_con').css('z-index', '100');
				$('.program_2_con').css('opacity', '0');
				$('.program_2_con').css('z-index', '1');
				
			}
			else if(flag==2)
			{
				$('.program_2').css('color', 'white');
				$('.program_2').css('background-color', '#F95D18');
				$('.program_1').css('color', '#F95D18');
				$('.program_1').css('background-color', 'white');
				$('.program_1_con').css('opacity', '0');
				$('.program_1_con').css('z-index', '1');
				$('.program_2_con').css('opacity', '1');
				$('.program_2_con').css('z-index', '100');
			}
		});
		function changeDiv(flag)
		{
			var form1 = document.forms['form1'];
			form1.method = "post";
			$("#flag").val(flag)
			
			form1.submit();
		}
		function goBack()
		{
			window.location.href="<%=basePath%>fontpage/s/queryFontPage";
		}
	</script>
</html>
