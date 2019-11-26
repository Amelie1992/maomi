<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/isWeixin.js"></script>
				
		<title>投团记录</title>
		<style type="text/css">
			.wrap {
				width: 100%;
				background-color: #F2F2F2;
			}
			
			.title {
				width: 100%;
				position: relative;
				text-align: center;
				font-size: 16px;
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
			
			.wrap table{
				width: 100%;
				background-color: white;
				text-align: center;
				font-size: 12px;
				color: #666666;
			}
			.wrap table tr:nth-child(1){
				color: #141414;
			}
			.wrap table tr{
				border-bottom: 1px solid #E0E0E0;
				line-height: 40px;
			}
		</style>
	</head>

	<body>
		<input type="hidden" id="basePath" value="<%=basePath%>" />
		<form method="post" action="" id="form1" >
   	  		<input type="hidden" id="freedomSubjectId" name="freedomSubjectId" value="${freedomSubjectId }">
  		</form>
		<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()"/>猫咪宝加入记录
			</div>
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th>投资人</th>
					<th>投入金额(元)</th>
					<th>投入时间</th>
				</tr>
				<c:forEach items="${rspList}" var="sj">
				<tr>
					<td>${fn:substring(sj.accountName, 0, 1)}**</td>
					<td>${sj.money }</td>
					<td>${sj.dealTime }</td>					
				</tr>
				</c:forEach>
			</table>
		</div>
	
	</body>
	
	<script type="text/javascript">
		function goBack()
		{
			var path= $("#basePath").val();
			var form = document.forms['form1'];
			form.action = path+'freedomsubject/s/detailfreedomsubject';
			form.submit();
		}
		
	</script>


</html>