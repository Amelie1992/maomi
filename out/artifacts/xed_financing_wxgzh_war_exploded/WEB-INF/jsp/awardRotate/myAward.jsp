<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>中奖记录</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html, body {
	width: 100%;
	background-color: #E5E5E5;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
	list-style-type: none;
}

.back {
	position: absolute;
	left: 20px;
	top: 15px;
	width: 10px;
	height: 15px;
}

#wrap p:nth-child(1) {
	background-color: #F7F7F7;
	text-align: center;
	padding: 10px;
}

#wrap ul {
	margin-top: 15px;
	background-color: white;
}

#wrap ul li {
	width: 100%;
	position: relative;
	overflow: hidden;
	height: 40px;
	line-height: 20px;
	font-size: 14px;
	color: #555555;
	/*border-bottom: 1px solid #EEEEEE;*/
	padding: 5px 0;
}

#wrap ul li p {
	font-size: 14px;
	color: #888;
}

h6 {
	text-align: center;
	padding: 15px 0;
	font-weight: normal;
}
</style>
<script type="text/javascript">	
function goBack(){
	window.location.href = '<%=basePath%>awardrotate/gotoawardrotate';
}
</script>
</head>

<body>
	<div id="wrap">
		<p>
			<img src="images/back.png" class="back" onclick="goBack()"/>中奖记录
		</p>
		<c:if test="${!empty drawLst}">
		<ul>
			<c:forEach items="${drawLst}" var="dl">
			<li>
				<p>
					<span style="float:left;width:46%;text-align:left;">${dl.drawTime}</span>
					<span style="text-align:center;margin:0 2px;">抽中</span>
					<span style="float:right;width:42%;text-align:left;
							<c:if test="${fn:contains(dl.drawRank, '加息')}">color:#79c6e5;</c:if>
							<c:if test="${fn:contains(dl.drawRank, '现金')}">color:#f9d484;</c:if>
							<c:if test="${fn:contains(dl.drawRank, '增值')}">color:#e99deb;</c:if>
							<c:if test="${fn:contains(dl.drawRank, '提现')}">color:#98e165;</c:if>
							<c:if test="${fn:contains(dl.drawRank, '新手')}">color:#fcb875;</c:if>">${dl.drawContent}</span>
				</p>
			</li>
			</c:forEach>
		</ul>
		</c:if>
		<h6>没有更多了</h6>
	</div>
</body>
</html>