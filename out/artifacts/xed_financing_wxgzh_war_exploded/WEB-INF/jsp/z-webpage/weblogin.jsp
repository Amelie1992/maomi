<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML >
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/z-webpage/login.css">

<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/tool.js"></script>
<script type="text/javascript" src="js/validate.js"></script>

<title>猫咪财富</title>
</head>

<body>
	<div class="wrap">
		<img src="images/z-webpage/wap-bg.png" />
		<ul>
			<li>
				<div class="wap-reg-img-title"></div> <input type="text"
				name="telephone" id="telephoneNumber" value=""
				placeholder="请输入注册手机号" />
			</li>
			<li>
				<div class="wap-reg-img-title"></div> <input type="text" name="yzm"
				id="captcha" value="" placeholder="请输入验证码" /> <span class="capchat"
				id="sentCaptcha" onclick="">获取验证码</span>
			</li>
			<li>
				<div class="wap-reg-img-title"></div> <input type="password"
				name="password" id="passWord_1" value="" placeholder="请输入登录密码" />
			</li>
			<li>
				<div class="wap-reg-img-title"></div> <input type="text"
				name="recommendTelephone" id="phone" value=""
				placeholder="填写邀请人手机号（非必填）" />
			</li>
			<li><a href="javascript:register()" class="reg-btn">注册领888注册红包</a></li>
			<li>
				<p class="agreement">注册即代表您同意《猫咪财富服务协议》</p>
				<p class="goto-log">
					已有账号？<b onclick="toLogin()">立即登录</b>
				</p>
			</li>
			<li style="text-align: center;"><img src="images/z-webpage/wap-code.jpg"
				id="wap-code" /></li>
			<li style="text-align: center; font-size: 12px; color: #757575;">
				扫一扫即可关注猫咪财富获取更多信息！</li>
		</ul>
		<p class="friend">邀请好友</p>
	</div>
</body>
<script type="text/javascript">
//去登录
function toLogin(){
	window.location.href='<%=basePath%>loginregister/s/toLogin';
}

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
			url:"<%=basePath%>weblogin/s/checkPhone",
			data : {
				telephone:telephone
			},
			success:function(data){
				if(data.result==='error'){
					alert('该手机号已注册过，请确认手机号');
					$("#telephoneNumber").val('');
					
					$('#sentCaptcha').prop('onclick','');
				}else{
					$('#sentCaptcha').attr('onclick','sendMobileCode()');
					
				}
			}
		});
	}
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
	
//验证邀请人
$("#phone").keyup(function(){
	var telephone=$("#phone").val();
	if($("#phone").val().length!=11){
		return;
	}else{
		$.ajax({
			url:"<%=basePath%>weblogin/s/checkPhone",
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
	if(!verifyVal(telephone,"mobilePhone","手机号")){
		return false;
	}
	settime();
	$.ajax({
		url:"<%=basePath%>weblogin/s/sendMobileCode",
		data : {
			telephone : telephone
		},
		success : function(data) {
			if (data.result === 'success') {
				alert('已发送短信');
			} else if(data.result === 'limit'){
				alert('已超出短信发送条数限制');
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
	
	if(!verifyVal(telephone,"mobilePhone","手机号")){
		return ;
	}else if(!verifyVal(password,"password","登录密码")){
		return ;
	}else if(!objIsNullOrEmptyNoMsg(yzm)){
		alert('请输入验证码');
		return;
	}else if(!verifyValNoMsg(phone,"mobilePhone")){
		if(objIsNullOrEmptyNoMsg(phone)){
			alert('邀请人手机号格式不正确');
			return;
		}
	}	
	
	$.ajax({
		url:"<%=basePath%>weblogin/s/register",
		data : {
			telephone : telephone,
			yzm : yzm,
			recommendTelephone : phone,
			password : password	
		},
		success : function(data) {
			if (data.result === 'success') {
				alert('注册成功');
				window.location.href='<%=basePath%>capital/querycapital';
				} else if (data.result === 'yzm') {
					alert('验证码错误');
				} else if (data.result === 'error') {
					alert('注册失败');
				} else if (data.result === 'repeat') {
					alert('该手机号已注册过');
				}
			}
		});

	}
</script>

</html>
