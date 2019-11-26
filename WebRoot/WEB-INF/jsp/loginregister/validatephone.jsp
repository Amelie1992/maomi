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
<link rel="stylesheet" href="css/reset.css" />
<title>绑定手机</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

.logo {
	text-align: center;
	padding-top: 42px;
	padding-bottom: 30px;
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

.center li input {
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

#captcha {
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
	height: 43px;
	line-height: 43px;
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
	height: 43px;
	line-height: 43px;
	background-color: #fdcf08;
	text-align: center;
	font-size: 20px;
	color: black;
	border-radius: 2px;
}

.regp {
	padding-top: 12px;
	display: block;
	text-align: center;
}

#reg_a {
	color: #999;
	font-size: 14px;
}

input:focus {
	/*border:none;*/
	outline: none;
}

.foter {
	text-align: center;
	margin-top: 55px;
}

.img2 {
	width: 14px;
	height: 14px;
}
</style>
</head>

<body>
	<div class="logo">
		<img src="images/logo.png" style="width: 60%;" />
	</div>
	<div class="center">
		<ul>
			<li><input type="text" name="telephone" id="telephoneNumber"
				placeholder="请输入本人手机号"><img src="images/clear.png" id="tab1"></li>
			<li><input id="captcha" name="yzm" type="text"
				placeholder="请输入验证码"><span id="sentCaptcha" onclick=""
				class="yzm_span">获取验证码</span></li>
		</ul>
	</div>
	<div class="reg">
		<span class="regbutton_sub" onclick="nextCheck()">下一步</span>
	</div>

<script type="text/javascript">
//倒计时
var countdown=60;
// 清空手机号
$('#tab1').click(function(){
	$('#telephoneNumber').val('');
});

function nextCheck(){
	var telephone=$("#telephoneNumber").val();
	var yzm=$("#captcha").val();
		$.ajax({
			url:"<%=basePath%>loginregister/s/nextCheck",
			data : {
				telephone : telephone,
				yzm : yzm 
			},
			success : function(data) {
				if (data.result === 'success') {
					if(confirm('是否绑定手机号码：' + telephone + ' ？')){		
						window.location.href='<%=basePath%>capital/querycapital';
					}else{
						$("#telephoneNumber").val('');
						$("#captcha").val('');
					}		
				} else if (data.result === 'error') {
					alert('绑定失败，请重新输入');
				} else if (data.result === 'repeat') {
					alert('该手机号已注册过');
				} else if (data.result === 'new') {
					window.location.href='<%=basePath%>loginregister/s/toRegister';
				} else if (data.result === 'yzm') {
					alert('验证码错误');
				}
			}
		});
}
//发送短信
function sendMobileCode(){
	var telephone=$("#telephoneNumber").val();
	if(!verifyVal(telephone,"mobilePhone","手机号")){
		return false;
	} 
	settime();
	$.ajax({
		url:"<%=basePath%>loginregister/s/sendMobileCode",
		data : {
			telephone : telephone
		},
		success : function(data) {
			if (data.result === 'success') {
				alert('已发送短信');
			}else if (data.result === 'limit'){
				alert('短信次数已达上限');
			}
		}
	});
}
//计时
function settime() { 
	if (countdown == 0) { 
		$("#sentCaptcha").text("获取验证码");
		$('#sentCaptcha').prop('class','yzm_span_fs');
		$('#sentCaptcha').prop('onclick','');
		countdown = 60;
		return;
	} else { 
		$('#sentCaptcha').prop('class','yzm_span');
		$('#sentCaptcha').prop('onclick','sendMobileCode()');
		$("#sentCaptcha").text("重新发送(" + countdown + ")"); 
		countdown--; 
	} 
	setTimeout(function() { 
	settime();
	},1000) 
}

//注册手机号验证
$("#telephoneNumber").keyup(function(){
	var telephone=$("#telephoneNumber").val();
	if($("#telephoneNumber").val().length!=11){
		return;
	}else{
		$.ajax({
			url:"<%=basePath%>loginregister/s/checkPhone",
			data : {
				telephone:telephone
			},
			success:function(data){
				if(data.result==='error'){
					$('#sentCaptcha').attr('onclick','sendMobileCode()');
					$('#sentCaptcha').prop('class','yzm_span_fs');
				}else{
					if(confirm("您的手机号未注册，是否进行注册？")){
						window.location.href='<%=basePath%>loginregister/s/toRegister?telephone=' + telephone;
					}else{
						$("#telephoneNumber").val('');
					}
				}
			}
		});
	}
});
</script>
</body>
</html>
