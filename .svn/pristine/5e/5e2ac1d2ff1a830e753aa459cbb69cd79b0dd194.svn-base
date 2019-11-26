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
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" type="text/css" href="css/freedomsubject/moreprofit.css" />
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/validate.js"></script>
		<script type="text/javascript" src="js/isWeixin.js"></script>
		<script type="text/javascript" src="js/freedomsubject/turnin.js"></script>
		
		<title>万份收益</title>
		<script type="text/javascript">
			function goBack()
			{
				var form = document.forms['form1'];
				form.action = './freedomsubject/s/detailfreedomsubject';
				form.submit();
			}
		</script>
	</head>

	<body>
		<input type="hidden" id="basePath" value="<%=basePath%>" />
		<form method="post" action="" id="form1" >
			<input type="hidden" id="freedomSubjectId" name="freedomSubjectId" value="${fBean.freedomSubjectId}">
   		</form>
		<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()"/>万份收益
			</div>
			<div class="headInfor">
				<p>昨日万份收益</p>
				<p>${fBean.dayReturns }元</p>
			</div>
			<div class="content">
				<p>近30天万份收益</p>
				<!--循环30个数据 不翻页-->
				<ul>
					<c:forEach items="${rspList}" var="sj">
					<li>
						<span class="content-time">${sj.freedomDate}</span>
						<span class="content-count">${sj.dayReturns}（元）</span>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	
	</body>
	
	


</html>