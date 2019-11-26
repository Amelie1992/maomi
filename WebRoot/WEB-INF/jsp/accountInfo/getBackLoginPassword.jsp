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
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<title>找回登录密码</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html, body {
	text-align: center;
	background-color: whitesmoke;
	height: 100%;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
	width: 100%;
}

table {
	width: 100%;
}
#wrap ul {
	/* width: 100%; */
	margin-top: 20px;
	margin-left: 15px;
	margin-right: 15px;
}
.logo {
	text-align: center;
	padding-top: 42px;
	padding-bottom: 30px;
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
	width: 100%;
	font-size: 16px;
	font-family: "微软雅黑";
	/* margin-left: 5px; */
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
	/* float:left; */
	width: 100%;
	/* min-width:208px; */
	font-size: 16px;
	font-family: "微软雅黑";
	/* margin-left: 5px; */
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
	float: right;
	width: 90px;
	/* margin-top: 11px; */
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
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
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
	color: #6a6f77;
	-web-kit-appearance: none;
	-moz-appearance: none;
	outline: 0;
	padding: 0 1em;
	text-decoration: none;
	width: 100%;
	font-size: 16px;
	font-family: "微软雅黑";
	/*margin-top: 8px;*/
	/* margin-left: 5px; */
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
	width: 100%;
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
	width: 100%;
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

input[type="text"] {
	box-sizing: border-box;
	/*text-align: center;*/
	font-size: 14px;
	height: 2.5em;
	border-radius: 4px;
	border: 1px solid #c8cccf;
	color: red;
	-web-kit-appearance: none;
	-moz-appearance: none;
	outline: 0;
	padding: 0 1em;
	text-decoration: none;
}

input[type="text"]:focus {
	border: 1px solid dodgerblue;
	/*color: royalblue;*/
}
.myButton_1 {
	background-color: #FEC63D;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: 1px solid #FEC63D;
	display: inline-block;
	height:25px;
	line-height:25px;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 15px;
	font-weight: bold;
	padding: 6px 24px;
	text-decoration: none;
	width: 70%;
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
	font-size: 16px;
	font-weight: 550;
	font-family: arial;
}

#wrap>ul>li>a {
	color: red;
}

.myButton_2 {
	background-color: #c7c3c7;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	border: 1px solid #dcdcdc;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 15px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	/*padding: 9px 23px;*/
	text-decoration: none;
}
</style>
</head>

<body>
	<div id="wrap">
		<div class="logo">
			<img src="images/logo.png" style="width: 60%;" />
		</div>
		<ul>
			<li><input type="text" name="telephone" id="telephoneNumber"
				value="" placeholder="请输入手机号" /></li>
			<li style="width: 68%;float: left;">
				<input type="text" name="yzm" id="captcha" value="" placeholder="请输入短信验证码" />
			</li>
			<li style="width: 32%;float: right;min-width: 77px;margin-top: 11px;">	
				<input type="button" name="" id="sentCaptcha" class="myButton" value="获取验证码" onclick="sendMobileCode()" />
			</li>
			<li><input type="password" name="password" id="passWord_1"
				value="" placeholder="设置新登录密码" /></li>
			<li><input type="password" name="" id="passWord_2" value=""
				placeholder="确认新登录密码" /></li>
			<li><div class="myButton_1" id=""
				onclick="getBack()"  >确认修改</div></li>
		</ul>
	</div>


	<!-- <form action="" method="post" id="">
		手机号：<input type="text" name="telephone" id="telephone"> <input
			type="button" value="发送短信验证码" onclick="sendMobileCode()"><br>
		密码：<input type="password" name="password" id="password"><br>
		再次输入密码：<input type="password" name="password2" id="password2"><br>
		验证码：<input type="text" name="yzm" id="yzm" /><br> <input 
			type="button" value="注册" onclick="getBack()">

	</form> -->
	<script type="text/javascript">
		var countdown=60; 
		
		//发送验证码
		function sendMobileCode(){
			var telephone=$("#telephoneNumber").val();
			if(!verifyVal(telephone,"phone","手机号")){
				return;
			}
			var telephone=$("#telephoneNumber").val();
			if(!objIsNullOrEmptyNoMsg(telephone)){
				return false;
			}
			settime();
			$.ajax({
				url:"<%=basePath%>loginregister/s/checkPhone",
				type: "POST",
				data : {
					telephone : telephone
				},
				success:function(data){
					if(data.result==='success'){
						alert('未有该手机号用户，请确认');
						$("#telephoneNumber").val('');
						countdown=0;
						return;
					}else{
						$.ajax({
							url:"<%=basePath%>accountinfo/s/sendMobileCodeCheck",
							type: "POST",
							data : {
								telephone:telephone
							},
							success:function(data){
								if(data.result==='success'){
									alert('已发送短信');
								}else if(data.result==='error'){
									alert('系统异常');
								} else if(data.result==='none'){
									alert('没有该手机号，请确认');
									$("#telephoneNumber").val("");
								} else if(data.result==='limit'){
									alert('短信发送次数超额');
								}
							}
						});
					}
				}
			});
			
		}
		
		//验证码计时
		function settime() { 
			if (countdown == 0) { 
				$("#sentCaptcha").removeAttr("disabled");
				$("#sentCaptcha").val("获取验证码");
				$("#sentCaptcha").attr("class","myButton");
				$("#sentCaptcha").attr("onclick","sendMobileCode()");
				countdown = 60;
				return;
			} else { 
				$("#sentCaptcha").attr({"disabled":"disabled"});
				$("#sentCaptcha").attr("class","myButton_2");
				$("#sentCaptcha").val("重新发送(" + countdown + ")");
				$("#sentCaptcha").attr("onclick","");
				countdown--; 
			} 
			setTimeout(function() { 
			settime() 
			},1000) 
		}
		
		
		
		//找回密码
		function getBack(){
			var password=$("#passWord_1").val();
			var yzm=$("#captcha").val();
			var passWord_2 = $("#passWord_2").val();
			var telephone=$("#telephoneNumber").val();
			if(!verifyVal(telephone,"phone","手机号")){
				return;
			}else if(!verifyVal(password,"password","登录密码")){
				return;
			}else if(!objIsNullOrEmpty(yzm)){
				return;
			}else if(!sameWith(password,passWord_2)){
				alert("输入的两次登录密码不一致");
				return;
			}
			$.ajax({
				url:"<%=basePath%>accountinfo/s/reappearSetLoginPassword",
				type: "POST",
				data : {
					password : password,
					yzm : yzm,
					telephone : telephone
				},
				success : function(data) {
					if (data.result === 'success') {
						alert('修改成功');
						window.location.href='<%=basePath%>loginregister/s/toLogin';
							} else if (data.result === 'error') {
								alert('系统异常');
							} else if (data.result === 'different') {
								alert('验证码错误');
							}
						}
					});
		}
		
		function changePhone(){
			
		};
		
	</script>
</body>
</html>
