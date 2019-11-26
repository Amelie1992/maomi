<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="css/commonStyle.css"/>
<title>邮箱认证</title>
<script type="text/javascript">
function backToEmail(){
	window.location.href="<%=basePath%>emailcheck/judgeEmailIsVerification";
}
</script>
</head>

<body>
		<div id="wrap">
			<ul>
				<li style="text-align: left;background-color: dodgerblue;color: white;">[提示]</li>
				<li style="width: 100%;">
					<table border="0" cellspacing="" cellpadding="" style="width: 100%;margin-top: 20px;">
						<tr style="text-align: center;">
							<th style="width: 50%;text-align: right;">
								<img src="img/warning.png"/>
							</th>
							<th  style="width: 50%;text-align: left;font-size: 14px;">
								验证码有误
							</th>
						</tr>
					</table>
				</li>
				<li style="width: 100%;text-align: center; margin-top: 20px;">
					<input type="button" onclick="backToEmail()" class="myButton" id="" value="点击返回" style="width: 50%;padding: 4px 6px; border: 1px solid dodgerblue;background-color: dodgerblue;border-radius: 2px;color: white;" />
				</li>
			</ul>
		</div>
	</body>
</html>
