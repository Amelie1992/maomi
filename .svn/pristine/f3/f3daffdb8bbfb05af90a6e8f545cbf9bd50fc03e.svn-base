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
<title>用户注册</title>
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
	top: /* 130px */180px;
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
	margin-top: 20px;
}

.img2,.img1 {
	width: 14px;
	height: 14px;
}
#codeImg{
	position: absolute;
	right: 10px;
	top:50px;
}

</style>
</head>

<body>
	<div class="logo">
		<img src="images/logo.png" style="width: 60%;" /><input type="hidden"
			id="result" value="${result}">
	</div>
	<div class="center">
		<ul>
			<li><input type="text" name="telephone" id="telephoneNumber" value="${telephone }"
				placeholder="请输入注册手机号 " ><img src="images/clear.png" id="tab1"></li>
			<li>
				<input type="text" placeholder="请输入图片验证码" id="check"> <img id="codeImg" alt="" src="<%=basePath%>/imgVerificationCode" onclick="reflashImgCode()" class="yzm">
			</li>
			<li><input id="captcha" name="yzm" type="text"
				placeholder="请输入验证码"><span id="sentCaptcha" onclick=""
				class="yzm_span">获取验证码</span></li>
			<li><input type="password" name="password" id="passWord_1"
				placeholder="设置登录密码"><img src="images/eyesclose.png"
				id="tab2"></li>
			<li><input type="text" name="recommendTelephone" id="phone"
				value="${recommendTelephone}" placeholder="推荐人手机号（非必填）"></li>
			<%-- <li><input type="text" name="recommendCode" id="recommendCode"
				value="${recommendCode}" placeholder="推荐码（非必填，填写正确，立即领取8.8元现金红包！）"></li> --%>
			<!-- <li>是否绑定微信 ： <input type="checkbox" name="accountWX" id="accountWX" 
				value="true" checked="checked" onclick="wxcheckbox()"/></li> -->
		</ul>
	</div>
	<div class="reg">
		<span class="regbutton_sub" onclick="register()">立即注册</span>
		<p class="regp">
			<a id="reg_a" href="javascript:toLogin()">已有账号去登录 ></a>
		</p>
	</div>
	<!-- <div class="foter">
		<img src="images/yuanjiao4.png" class="img1" onclick="changeImg1()" />
		&nbsp; <a id="reg_a" href="#">绑定微信</a>
	</div> -->
	<div class="foter">
		<img src="images/yuanjiao2.png" class="img2" onclick="changeImg2()" />
		&nbsp; <a id="reg_a" href="<%=basePath%>registrationProtocol.jsp">注册即代表同意 《猫咪财富服务协议》</a>
	</div>

<script type="text/javascript">

function reflashImgCode() {
	$("#codeImg").attr("src",
			$("#codeImg").attr("src") + "?random=" + Math.random);
}

//切换密码可见
var isClick = true;
$('#tab2').click(function () {
	if (isClick) {
		$('#passWord_1').prop('type','text');
		$('#tab2').attr('src','images/eyesopen.png');
	} else{
		$('#passWord_1').prop('type','password');	
		$('#tab2').attr('src','images/eyesclose.png');
	}	
	isClick =!isClick;
});
// 清空手机号
$('#tab1').click(function(){
	$('#telephoneNumber').val('');
});
	
//倒计时
var countdown=60;

//注册手机号验证
$("#telephoneNumber").keyup(function(){
	telephonekeUp();
});
$(function (){
	telephonekeUp();
});
function telephonekeUp(){
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
					alert('该手机号已注册过，请确认手机号');
					$("#telephoneNumber").val('');
					$('#sentCaptcha').prop('class','yzm_span');
					$('#sentCaptcha').prop('onclick','');
				}else{
					$('#sentCaptcha').attr('onclick','sendMobileCode()');
					$('#sentCaptcha').prop('class','yzm_span_fs');
				}
			}
		});
	}
}
//计时
function settime() { 
	if (countdown == 0) { 
		$("#sentCaptcha").text("获取验证码");
		$('#sentCaptcha').attr('onclick','sendMobileCode()');
		$('#sentCaptcha').attr('class','yzm_span_fs');
		countdown = 60;
		return;
	} else { 
		$('#sentCaptcha').removeAttr('onclick');
		$('#sentCaptcha').attr('class','yzm_span');
		$("#sentCaptcha").text("重新发送(" + countdown + ")"); 
		countdown--; 
	} 
	setTimeout(function() { 
	settime();
	},1000) 
}
	
//验证邀请人
$("#phone").keyup(function(){
	var telephone=$("#phone").val();
	if($("#phone").val().length!=11){
		return;
	}else{
		$.ajax({
			url:"<%=basePath%>loginregister/s/checkPhone",
			data : {
				telephone:telephone
			},
			success:function(data){
				if(data.result==='success'){
					alert('未有该手机号用户，请确认');
					$("#phone").val('');
				}
			}
		});
	}
	
});
//发送短信
function sendMobileCode(){
	var telephone=$("#telephoneNumber").val();
	var code=$("#check").val();
	if(!verifyVal(telephone,"mobilePhone","手机号")){
		return false;
	}
	if(!objIsNullOrEmptyNoMsg(code)){
		alert('请输入图片验证码');
		return;
	}
	settime();
	$.ajax({
		url:"<%=basePath%>loginregister/s/sendMobileCode",
		data : {
			telephone : telephone,
			code:code
		},
		success : function(data) {
			if (data.result === 'success') {
				alert('已发送短信');
			}else if (data.result === 'limit'){
				alert('短信次数已达上限');
			}else if(data.result==='code'){
				alert('图片验证码错误');
				reflashImgCode();
			}
		}
	});
}
//注册
function register() {
	var telephone=$("#telephoneNumber").val();
	var yzm = $("#captcha").val();
	var password = $("#passWord_1").val();
	var phone = $("#phone").val();
	var recommendCode =  $("#recommendCode").val();
	var code=$("#check").val();
	if(!verifyVal(telephone,"mobilePhone","手机号")){
		return ;
	}else if(!verifyVal(password,"password","登录密码")){
		return ;
	}else if(!objIsNullOrEmptyNoMsg(code)){
		alert('请输入图片验证码');
		return;
	}else if(!objIsNullOrEmptyNoMsg(yzm)){
		alert('请输入验证码');
		return;
	}else if($(".img2").attr("src")=="images/yuanjiao2.png"){
		alert('请阅读并同意猫咪财富协议');
		return;
	}else if(!verifyValNoMsg(phone,"mobilePhone")){
		if(objIsNullOrEmptyNoMsg(phone)){
			alert('邀请人手机号格式不正确');
			return;
		}
	}
	/*var accountWX = null;
	
	 if($(".img1").attr("src")=="images/yuanjiao4.png"){
		accountWX = true;
	} */	
	
	$.ajax({
		url:"<%=basePath%>loginregister/s/register",
		data : {
			telephone : telephone,
			yzm : yzm,
			recommendTelephone : phone,
			password : password,
			/* accountWX : accountWX, */
			recommendCode : recommendCode,
			code:code
		},
		success : function(data) {
			if (data.result === 'success') {
				alert('注册成功');
				window.location.href='<%=basePath%>fontpage/s/queryNewUserPage';
			} else if (data.result === 'yzm') {
				alert('验证码错误');
				reflashImgCode();
			} else if(data.result === 'error') {
				alert('注册失败');
				reflashImgCode();
			} else if(data.result === 'repeat'){
				alert('该手机号已注册过');
				reflashImgCode();
			} else if(data.result === 'errorCode'){
				alert('推荐码填写错误');
				$("#recommendCode").val('');
				reflashImgCode();
			}else if(data.result==='code'){
				alert('图片验证码错误');
				reflashImgCode();
			}
		}
	});
			
}
//去登录
function toLogin(){
	window.location.href='<%=basePath%>loginregister/s/toLogin';
}
//同意协议
function changeImg2() {
	if ($(".img2").attr("src") == "images/yuanjiao2.png") {
		$(".img2").attr("src", "images/yuanjiao4.png");
	} else {
		$(".img2").attr("src", "images/yuanjiao2.png");
	}
}
function changeImg1() {
	if ($(".img1").attr("src") == "images/yuanjiao2.png") {
		$(".img1").attr("src", "images/yuanjiao4.png");
	} else {
		$(".img1").attr("src", "images/yuanjiao2.png");
	}
}
//wx快捷登录授权选择
/* function wxcheckbox() { 
	var wx = $("#accountWX").prop("checked");
	if(wx){
		$("#accountWX").val("true");
	}else{
		$("#accountWX").val("false");
	}
} */
	
	</script>
</body>
</html>
