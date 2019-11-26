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
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/tool.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<link rel="stylesheet" href="css/reset.css" />
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>用户登录</title>
<style type="text/css">
.wrap {
	width: 100%;
}

.logo {
	text-align: center;
	padding-top: 42px;
	padding-bottom: 30px;
}

.wrap input {
	width: 100%;
	height: 50px;
	outline: none;
	border: none;
	border-bottom: 1px solid #eee;
	font-size:14px;
}

.wrap p {
	width: 90%;
	margin: 0 auto;
	overflow: hidden;
	text-align: center;
}

.logoBox {
	padding: 80px 40px;
}

.logoBox img {
	width: 100%;
}

.inputImg {
	position: absolute;
	width: 18px;
	height: 18px;
	right: 5%;
	top: 18px;
}

.LogBtn_s:active {
	position: relative;
	top: 1px;
}

.goRegist {
	float: left;
}

.goRegist a {
	color: #888;
}

.forget {
	float: right;
}

.forget a {
	color: #FDCF08;
}

.server {
	padding-top: 50px;
}

.server a {
	color: #888888;
}

.LogBtn {
	display: block;
	width: 80%;
	margin: 0 auto;
	text-align: center;
	line-height: 40px;
	font-size: 20px;
	background-color: #EBEBEB;
	color: white;
}

.LogBtn_s {
	display: block;
	width: 80%;
	margin: 0 auto;
	text-align: center;
	line-height: 40px;
	font-size: 20px;
	background-color: #Fdcf08;
	color: white;
}

.LogBtn_s:active {
	position: relative;
	top: 1px;
}
</style>


</head>

<body>
	<div class="wrap">
		<div class="logo">
			<img src="images/logo.png" style="width: 60%;" />
		</div>
		<p style="position: relative;">
			<input type="text" name="accountName" id="telephoneNumber" value=""
				placeholder="请输入您的手机号" /> <img src="images/clear.png"
				class="inputImg" id="tab1" />
		</p>
		<p style="position: relative; margin-bottom: 30px;">
			<input type="password" name="password" id="passWord" value=""
				placeholder="登录密码" /> <img src="images/eyesclose.png"
				class="inputImg" id="tab2" />
			<!--点击的时候把图片路径换成 images/eyeopen.png-->
		</p>
		<a class="LogBtn_s" onclick="login()">立即登录</a>
		<p style="margin-top: 20px;">
			<span class="goRegist"> <a href="javascript:goRegister();">立即注册</a></span>
			
			<a href="javascript:goWxLogin();">
				<img id="img1" src="">
			</a>
			
			<span class="forget"><a
				href="<%=basePath%>accountinfo/s/toGetBackLoginPassword">忘记密码？</a></span>
		</p>
		<p class="server">
			<a href="tel:400-000-3060">客服电话:400-000-3060</a>
		</p>
	</div>
</body>
<script type="text/javascript">
var isClick = true;
//密码可见
$('#tab2').click(function () {
	if (isClick) {
		$('#passWord').prop('type','text');
		$('#tab2').attr('src','images/eyesopen.png');
	} else{
		$('#passWord').prop('type','password');	
		$('#tab2').attr('src','images/eyesclose.png');
	}	
	isClick =!isClick;
});
//清空手机号
$('#tab1').click(function(){
	$('#telephoneNumber').attr('value','');
});
//登录
function login(){
	var accountName = $("#telephoneNumber").val();
	var password = $("#passWord").val();
    if(!objIsNullOrEmpty(accountName)){
    	return false;
    }else if(!verifyVal(password,"alphanum","密码")){
    	return false;
    }
    $.ajax({
    	type: "POST",
    	url: "<%=basePath%>loginregister/s/login",
		data : {
			password : password,
			accountName : accountName
		},
		success : function(data) {
			if (data.result === 'error') {
				$('#passWord').attr('value','');
				alert("手机号或密码错误");
			} else if (data.result === 'success') {
				<%--window.location.href='<%=basePath%>activity/s/twelveactivity';--%>
				 window.location.href='<%=basePath%>capital/querycapital'; 
			} else if(data.result === 'frozen'){
				$('#passWord').attr('value','');
				alert("您的账户已被冻结，详情请咨询客服");
			}
		}
	});
}

//去注册
function goRegister(){
	window.location.href='<%=basePath%>loginregister/s/toRegister';
	//window.location.href='<%=basePath%>loginregister/s/wxLogin/register';
}
//去微信登录
function goWxLogin(){
	window.location.href='<%=basePath%>loginregister/s/wxLogin/wx';
}
//判断微信客户端
$(document).ready(function () {
	var ua = window.navigator.userAgent.toLowerCase();
	if(ua.match(/MicroMessenger/i) == 'micromessenger') {	
		$('#img1').attr('src', 'images/icon16_wx_logo.png');	
	} 
});
</script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	 var url = window.location.href;
	 var timestamp;
	 var nonceStr;
	 var signature;
	 var appId;
	  //获取签名s
	 $.ajax({
	   type : "GET",
	   url : "<%=basePath%>wxshareController/s/getWxConfig",
	   data : {
		   url : url
		},
	   success : function(data){
		     var a = eval('('+data+')');
	         appId = a.appId;
	   		 timestamp = a.timestamp; 
	   		 nonceStr = a.nonceStr; 
	   		 signature = a.signature;
	   		 wxconfig();
	   	   }
	   });
	  function wxconfig(){
		  wx.config({
			    debug: false, 
			    appId: appId,
			    timestamp: timestamp, 
			    nonceStr: nonceStr,
			    signature: signature, 
			    jsApiList: ['onMenuShareTimeline', 'onMenuShareAppMessage'] 
			});
		  wx.ready(function(){
				wx.onMenuShareAppMessage({
				    title: '猫咪财富', 
				    desc: '快来看，更多金币等你来拿!', 
				    link: 'https://www.maomibank.com/xed_financing_wxgzh/',
				    imgUrl: 'https://www.maomibank.com/xed_financing_wxgzh/images/defaultHeadPic.png',
				    type: 'link', 
				    dataUrl: '', 
				    success: function () { 
				        alert('恭喜你，分享成功！');
				    },
				    cancel: function () { 
				    	alert('你已经取消了分享！');
				    }
				});
			    
				wx.onMenuShareTimeline({
				    title: '猫咪财富', 
				    link: 'https://www.maomibank.com/xed_financing_wxgzh/',
				    imgUrl: 'https://www.maomibank.com/xed_financing_wxgzh/images/defaultHeadPic.png',
				    success: function () { 
				        alert('恭喜你，分享成功！');
				    },
				    cancel: function () { 
				    	alert('你已经取消了分享！');
				    }
				});
			});
			/* wx.error(function(res){
				 alert('config信息验证失败');
			}); */
	  }
});
</script>
</html>
