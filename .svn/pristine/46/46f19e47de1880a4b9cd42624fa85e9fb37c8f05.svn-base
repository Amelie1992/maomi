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
<title>众筹记录</title>
<link rel="stylesheet" type="text/css" href="css/commonStyle.css"/>
<style type="text/css">
.wrap {
				width: 100%;
			}
			
			.wrap table {
				width: 100%;
				margin: 0 auto;
				text-align: center;
				font-size: 12px;
			}
			
			.wrap table tr:nth-child(1) {
				line-height: 40px;
				border-bottom: 1px solid #E0E0E0;
				background-color: #e0e0e0 !important;
				font-size: 14px;
			}
			.wrap table tr:nth-child(2n+1)
			{
				background-color: #F7F7F7;
			}
			.wrap table td {
				height: 40px;
				line-height: 40px;
				color: #888888;
				border-bottom:1px solid #e0e0e0;
			}
			
</style>
</head>

<body>
	<div class="wrap">
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th>投资人</th>
					<th>众筹金额</th>
					<th>众筹时间</th>
					<th>是否中奖</th>
				</tr>
				<c:forEach items="${rspList}" var="sj">
				<tr>
					<td>${sj.telephone }</td>
					<td>${cBean.eachMoney }元</td>
					<td>${sj.crowdDate }</td>
					<td <c:if test="${sj.isWinning==1 }">style="color:red;"</c:if>>
						<c:choose>
							<c:when test="${sj.isWinning==0 }">
								未中奖
							</c:when>
							<c:when test="${sj.isWinning==1 }">
								已中奖
							</c:when>
							<c:when test="${sj.isWinning==2 }">
								众筹失败
							</c:when>
							<c:otherwise>
								暂未开奖
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				</c:forEach>
				
			</table>
		</div>
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/accordion.js" type="text/javascript" charset="utf-8"></script>
<script src="js/help_content_inner.js" type="text/javascript" charset="utf-8"></script>
</html>
