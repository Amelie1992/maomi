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
<meta charset="UTF-8">
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />

<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<script type="text/javascript" src="js/emailcheck/emailcheck.js"></script>
<title>邮箱认证</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}
.back {
	position: absolute;
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}
.center p {
	font-size: 20px;
	color: #333333;
	background-color: #F7F7F7;
	text-align: center;
	padding: 10px;
}
.center {
	width: 100%;
}

.center ul {
	position: relative;
}

.center li {
	margin: 5px 10px;
	height: 50px;
	line-height: 50px;
}

input {
	width: 100%;
	font-size: 14px;
	height: 33px;
	border: 0px;
	border-bottom: 1px solid #E5E5E5;
}

input::-webkit-input-placeholder {
	color: #999;
}

input:-moz-placeholder {
	color: #999;
}

#tab1 {
	position: absolute;
	top: 19px;
	left: 88%;
	width: 16px;
	height: 16px;
}

#accountEmail {
	width: 60%;
}

.yzm_span {
	font-size: 15px;
	float: right;
	color: #b3b3b3;
	width: 120px;
	height: 42px;
	line-height: 42px;
	background-color: #ebebeb;
	text-align: center;
	border-radius: 2px;
}

.yzm_span_fs {
	font-size: 15px;
	float: right;
	color: black;
	width: 120px;
	height: 42px;
	line-height: 42px;
	background-color: #fdcf08;
	text-align: center;
	border-radius: 2px;
}

#tab2 {
	position: absolute;
	top: 130px;
	left: 88%;
	width: 18px;
	height: 18px;
}

.reg {
	padding-top: 20px;
	width: 100%;
}

.regbutton {
	margin: auto;
	display: block;
	width: 88%;
	height: 35px;
	line-height: 35px;
	background-color: #ebebeb;
	text-align: center;
	font-size: 20px;
	color: #B3B3B3;
	border-radius: 2px;
}

.regbutton_sub {
	margin: auto;
	display: block;
	width: 88%;
	height: 42px;
	line-height: 42px;
	background-color: #fdcf08;
	text-align: center;
	font-size: 18px;
	color: black;
	border-radius: 2px;
}



input:focus {
	/*border:none;*/
	outline: none;
}
#AutoComplete{
	background-color: white;
}


</style>
</head>

<body>
	<%-- <input id="basePath" type="hidden" value="<%=basePath%>"/> --%>
		<div class="center">
					<input type="hidden" id="flag" value="${emailStatus}"> 
					<input type="hidden" id="codeId" value="${codeId}"/> 
					<p><img src="images/back.png" class="back" onclick="backToMySetting()" />认证邮箱</p>
			<ul>
				<li><input type="text" name="accountEmail" id="accountEmail" value="${accountEmail}" placeholder="请输入邮箱帐号" />
				<%-- <c:if test="${emailStatus == 1 }">${accountEmail}</c:if> --%>
				<span class="yzm_span_fs" id=""  onclick="getEmailVerCode(this)" >获取验证码</span>
				</li>
				<li>	
				<%-- <c:if test="${emailStatus == 0 }"> --%>
					<input type="text" name="codeMsg" id="codeMsg" value="" placeholder="请输入邮箱验证码" />
					
				<%-- </c:if> --%>
				</li>
				<li><span class="regbutton_sub"  onclick="checkOK()">确认</span></li>
			</ul>
		</div>
	</body>
</html>
