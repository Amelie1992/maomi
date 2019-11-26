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
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/navigation.js"></script>
<title>新手四重福利</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/fontpage/newuserpage.css"/>
</head>

<body>
<div class="wrap">
			<div class="headbox">
				<img src="images/xsfl-head-bg.png" />
			</div>
			<div class="content">
				<div class="tyj">
					<div class="content-left">
						<img src="images/xsfl-tyj.png" />
					</div>
					<div class="content-right">
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th class="light-bar"><img src="images/xsfl-light-left.png" /></th>
								<th>注册送888元体验金</th>
								<th class="light-bar"><img src="images/xsfl-light-right.png" /></th>

							</tr>

						</table>
						<p>
							<c:if test="${empty sessionScope.account}">
								<span class="touse" onclick="useNows(0)">立即使用</span>
							</c:if>
							<c:if test="${!empty sessionScope.account}">
								<span class="touse" onclick="useNows(1)">立即使用</span>
							</c:if>
						</p>
					</div>
				</div>
				<div class="mmhb">
					<div class="content-left">
						<img src="images/xsfl-mmhb.png" />
					</div>
					<div class="content-right">
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th class="light-bar"><img src="images/xsfl-light-left.png" /></th>
								<th>注册送0.5元猫咪红包</th>
								<th class="light-bar"><img src="images/xsfl-light-right.png" /></th>

							</tr>

						</table>
						<p>
							<c:if test="${empty sessionScope.account}">
								<span class="touse" onclick="useNows(0)">立即使用</span>
							</c:if>
							<c:if test="${!empty sessionScope.account}">
								<span class="touse" onclick="useNows(2)">立即使用</span>
							</c:if>
						</p>
					</div>
				</div>
				<div class="yqm">
					<div class="content-left">
						<img src="images/xsfl-yqmhb.png" />
					</div>
					<div class="content-right">
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th class="light-bar"><img src="images/xsfl-light-left.png" /></th>
								<th>邀请好友首次投资奖励</th>
								<th class="light-bar"><img src="images/xsfl-light-right.png" /></th>

							</tr>

						</table>
						<p>
							<c:if test="${empty sessionScope.account}">
								<span class="touse" onclick="useNows(0)">立即使用</span>
							</c:if>
							<c:if test="${!empty sessionScope.account}">
								<span class="touse" onclick="useNows(4)">立即使用</span>
							</c:if>
						</p>
					</div>
				</div>
				<input type="hidden" id="rst" value="${rst }" />
				<div class="zc">
					<div class="content-left">
						<img src="images/xsfl-zchb.png" />
					</div>
					<div class="content-right">
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th class="light-bar"><img src="images/xsfl-light-left.png" /></th>
								<th>邀请好友二次投资奖励</th>
								<th class="light-bar"><img src="images/xsfl-light-right.png" /></th>

							</tr>

						</table>
						<p>
							<c:if test="${empty sessionScope.account}">
								<span class="touse" onclick="useNows(0)">立即使用</span>
							</c:if>
							<c:if test="${!empty sessionScope.account}">
								<span class="touse" onclick="useNows(4)">立即使用</span>
							</c:if>
						</p>
					</div>
				</div>
			</div>
		</div>
</body>
<script type="text/javascript">
if(screen.height == 812 && screen.width == 375)
{
	$(".content").css("height","590px");	
}
</script>
</html>
