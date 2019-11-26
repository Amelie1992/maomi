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
<script type="text/javascript" src="js/isWeixin.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<title>设置交易密码</title>
<style type="text/css">
			* {
	margin: 0;
	padding: 0;
}

html, body {
	text-align: center;
	height: 100%;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
	width: 100%;
}

.back {
	position: absolute;
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}

#wrap p:nth-child(1) {
	font-size: 20px;
	color: #333333;
	background-color: #F7F7F7;
	text-align: center;
	padding: 10px;
}

#wrap ul {
	width: 100%;
	margin-top: 20px;
}

table {
	width: 100%;
}

:-moz-placeholder {
	/* Mozilla Firefox 4 to 18 */
	color: #B5B5B5;
}

::-moz-placeholder {
	/* Mozilla Firefox 19+ */
	color: #B5B5B5;
}

input:-ms-input-placeholder, textarea:-ms-input-placeholder {
	color: #B5B5B5;
}

input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {
	color: #B5B5B5;
}

#logoImg {
	width: 100%;
}

#telephoneNumber {
	text-indent: 40px;
	width: 90%;
	font-size: 16px;
	font-family: "微软雅黑";
	margin-left: 5px;
	padding: 5px;
	color: #6a6f77;
	background-image: url(images/profile.png);
	background-repeat: no-repeat;
	background-position-x: 5px;
	background-position-y: center;
}

#captcha {
	overflow: hidden;
	text-indent: 40px;
	width: 86%;
	font-size: 16px;
	font-family: "微软雅黑";
	margin-left: 5px;
	margin-bottom: 10px;
	margin-top: 10px;
	padding: 5px;
	color: #6a6f77;
	background-image: url(images/check.png);
	background-repeat: no-repeat;
	background-position-x: 5px;
	background-position-y: center;
}

#sentCaptcha {
	height: 38px;
}

.myButton {
	background-color: #FEC63D;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	border: 1px solid #FEC63D;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 15px;
	/*padding: 9px 23px;*/
	text-decoration: none;
}

.myButton:active {
	position: relative;
	top: 1px;
}

#passWord_1, #passWord_2 {
	box-sizing: border-box;
	/*text-align: center;*/
	text-indent: 40px;
	font-size: 14px;
	height: 2.5em;
	border-radius: 4px;
	border: 1px solid #c8cccf;
	color: #EEEEEE;
	-web-kit-appearance: none;
	-moz-appearance: none;
	outline: 0;
	padding: 0 1em;
	text-decoration: none;
	width: 90%;
	font-size: 16px;
	font-family: "微软雅黑";
	/*margin-top: 8px;*/
	margin-left: 5px;
	margin-bottom: 8px;
	padding: 5px;
	color: #6a6f77;
	background-image: url(images/key.png);
	background-repeat: no-repeat;
	background-position-x: 5px;
	background-position-y: center;
}

#passWord_3, #passWord_4 {
	box-sizing: border-box;
	/*text-align: center;*/
	text-indent: 40px;
	font-size: 14px;
	height: 2.5em;
	border-radius: 4px;
	border: 1px solid #c8cccf;
	color: #6a6f77;
	-web-kit-appearance: none;
	-moz-appearance: none;
	outline: 0;
	padding: 0 1em;
	text-decoration: none;
	width: 90%;
	font-size: 16px;
	font-family: "微软雅黑";
	/*margin-top: 8px;*/
	margin-left: 5px;
	/*margin-bottom: 8px;*/
	padding: 5px;
	color: #6a6f77;
	background-image: url(images/mima.png);
	background-repeat: no-repeat;
	background-position-x: 5px;
	background-position-y: center;
}

#phone {
	overflow: hidden;
	text-indent: 40px;
	width: 90%;
	font-size: 16px;
	font-family: "微软雅黑";
	margin-left: 5px;
	/*margin-bottom: 10px;
				margin-top: 10px;*/
	padding: 5px;
	color: #6a6f77;
	background-image: url(images/phone_32.png);
	background-repeat: no-repeat;
	background-position-x: 5px;
	background-position-y: center;
}

input[type="password"]:focus {
	border: 1px solid dodgerblue;
}

input[type="password"] {
	box-sizing: border-box;
	/*text-align: center;*/
	font-size: 14px;
	height: 2em;
	border-radius: 4px;
	border: 1px solid #c8cccf;
	color: red;
	-web-kit-appearance: none;
	-moz-appearance: none;
	outline: 0;
	padding: 0 1em;
	text-decoration: none;
}

input[type="password"]:focus {
	border: 1px solid #FEC63D;
	/*color: royalblue;*/
}

.myButton_1 {
	background-color: #FEC63D;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: 1px solid #FEC63D;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 15px;
	font-weight: bold;
	padding: 6px 24px;
	text-decoration: none;
	width: 50%;
}

.myButton_1:active {
	position: relative;
	top: 1px;
}

#wrap>ul>li:nth-child(7) {
	margin: 10px 0;
}

#wrap>ul>li:nth-child(8) {
	margin: 20px 0;
}

#wrap>ul>li:nth-child(9) {
	font-size: 14px;
	font-weight: 550;
	font-family: arial;
}

#wrap>ul>li>a {
	color: red;
}
</style>


</head>

<body>
<div id="wrap">
	<p>
			<img src="images/back.png" onclick="getBack()" class="back" />设置交易密码
		</p>
	<ul>
		<li>
			<table border="0" cellspacing="10" cellpadding="">
				<tr>
					<th style="width: 50%;font-size: 14px;">设置交易密码</th>
					<th style="width: 50%;"><input type="password" name="dealPassword" id="dealPassword" value="" /></th>
				</tr>
				<tr>
					<th style="width: 50%;font-size: 14px;">确认交易密码</th>
					<th style="width: 50%;"><input type="password" name="password2" id="password2" value="" /></th>
				</tr>
			</table>
		</li>
		<li style="width: 100%; text-align: center;">
			<input type="button" class="myButton_1" id="button" value="确认设置" />
		</li>
		<li>
			<img style="width:100%;" src="<%=basePath%>images/logo.png" />
		</li>
	</ul>
</div>


	<%-- <form id="account" action="" method="post">
		原交易密码：<input type="password" name="oldDealPassword" id="oldDealPassword" /><br>
		新交易密码：<input type="password" name="dealPassword" id="dealPassword" /><br>
		确认密码：<input type="password" name="password2" id="password2" /><br>
		<input type="button" id="button" value="确认" />
	</form>
	<a href="<%=basePath%>accountinfo/getBackDealPassword"></a> --%>
</body>
<script type="text/javascript">
//返回上一页
function getBack(){
	window.location.href='<%=basePath%>accountinfo/pwdManager';
}
	//修改密码
	$("#button").click(function(){
		var dealPassword = $("#dealPassword").val();
		var password2 = $("#password2").val();
		if(!verifyVal(dealPassword,"password","交易密码")){
			return;
		}else if(!sameWith(dealPassword,password2)){
			alert("输入的两次交易密码不一致");
			return;
		}
		$.ajax({
			type: "POST",
			url: "<%=basePath%>accountinfo/setDealPassword",
			data : {
				dealPassword : dealPassword
			},
			success : function(data) {
				if(data.result==='unLogin'){
					alert('尚未登录，登录过期');
					window.location.href='<%=basePath%>loginregister/s/toLogin';
				}else if(data.result==='error'){
					alert('系统错误');
				}else if(data.result==='success'){
					alert('修改成功');
					window.location.href='<%=basePath%>accountinfo/pwdManager';
				}
			}
		});
	});
</script>
</html>
