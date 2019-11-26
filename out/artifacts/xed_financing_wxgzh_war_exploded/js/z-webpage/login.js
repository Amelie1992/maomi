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
	alert(telephone);
	if($("#telephoneNumber").val().length!=11){
		return;
	}else{
		$.ajax({
			url:"./loginregister/s/checkPhone",
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
	if(!verifyVal(telephone,"mobilePhone","手机号")){
		return false;
	}
	settime();
	$.ajax({
		url:"./loginregister/s/sendMobileCode",
		data : {
			telephone : telephone
		},
		success : function(data) {
			if (data.result === 'success') {
				alert('已发送短信');
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
	
	if(!verifyVal(telephone,"mobilePhone","手机号")){
		return ;
	}else if(!verifyVal(password,"password","登录密码")){
		return ;
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
			recommendCode : recommendCode		
		},
		success : function(data) {
			if (data.result === 'success') {
				alert('注册成功');
				window.location.href='<%=basePath%>capital/querycapital';
			} else if (data.result === 'yzm') {
				alert('验证码错误');
			} else if(data.result === 'error') {
				alert('注册失败');
			} else if(data.result === 'repeat'){
				alert('该手机号已注册过');
			} else if(data.result === 'errorCode'){
				alert('推荐码填写错误');
				$("#recommendCode").val('');
			}
		}
	});
			
}