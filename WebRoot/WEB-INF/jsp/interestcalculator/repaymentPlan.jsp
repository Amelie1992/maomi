<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML >
<html>
<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<title>还款计划</title>
		<style type="text/css">
			.wrap{
				width: 100%;
				background-color: white;
			}
			.qs p{
				background-color: #E0E0E0;
				line-height: 50px;
				color: #757575;
				font-size: 14px;
				text-align: center;
			}
			.qs table{
				width: 100%;
				text-align: center;
			}
			.qs table th{
				padding: 18px 0 10px 0;
				color: #212121;
				width: 25%;
			}
			.qs table td{
				padding-bottom: 20px;
				color: #F95D18;
				font-size: 12px;
			}
		</style>
	</head>

<body>
		<div class="wrap">
		<c:forEach items="${resultMap.subjectBeans}" var="ss" varStatus="a">
			<div class="qs">
				<p>第${a.count}期</p>
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>还款时间</th>
						<th>还款总额</th>
						<th>本金</th>
						<th>利息</th>
					</tr>
					<tr>
						<td>${ss.repaymentTime}</td>
						<td>${ss.totalRepayment}元</td>
						<td>${ss.principal}元</td>
						<td>${ss.interest}元</td>
					</tr>
				</table>
			</div>
			</c:forEach>
		</div>
	</body>
</html>
