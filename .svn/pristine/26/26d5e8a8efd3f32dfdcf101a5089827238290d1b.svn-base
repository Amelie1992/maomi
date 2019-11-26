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
<script type="text/javascript" src="js/navigation.js"></script>

<link rel="stylesheet" type="text/css" href="css/upload.css" />

<title>账号设置</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

html, body {
	width: 100%;
	text-align: center;
	position: relative;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
	height: 40px;
	line-height: 40px;
}

th {
	font-weight: normal;
}

.back {
	position: absolute;
	left: 20px;
	top: 15px;
	width: 11px;
	height: 16px;
}

.go {
	width: 20px;
	height: 24px;
	border: none;
	padding-top: 9px;
}

img {
	
}

.title_li {
	border-bottom: 1px solid #EEEEEE;
	font-size: 20px;
	color: #333333;
	background-color: #F6F6F6;
}

.body_li {
	border-bottom: 1px solid #EEEEEE;
}

.d_left {
	padding-left: 8px;
	float: left;
	width: 32%;
	color: #555555;
	font-size: 14px;
	text-align: left;
	height: 40px;
}

.d_text2 {
	float: left;
	width: 55%;
	text-align: right;
	font-size: 12px;
	color: #808080;
	height: 40px;
	line-height: 20px;
}

.d_text {
	float: left;
	width: 55%;
	text-align: right;
	font-size: 12px;
	color: #808080;
	height: 40px;
}

.d_img {
	width: 8%;
	float: right;
	height: 40px;
}

.prompt{
	height: 30px;
	line-height: 30px;
	font-size: 12px;
	padding-left: 5px;
	float: left;
	color: #808080;
}
.iconImg{
	width: 30px;
	padding-top: 2%;
}
.outlogin{
	position:fixed;
	bottom:0;
	width:100%;
	background-color:#FC7831;
	color:white;
	height:35px;
	font-size:18px;
	line-height: 35px;
}
</style>
<script type="text/javascript">

	//退出登录
	function outLogin()
	{
		if(confirm("确定退出登录吗？"))
		{
			window.location.href='<%=basePath%>loginregister/outLogin';
		}
	}
	//返回上一页
	function getBack(){
		window.location.href='<%=basePath%>capital/querycapital';
	}
	
	//去密码管理页面
	function pwdManager(){
		window.location.href='<%=basePath%>accountinfo/pwdManager';
	}
	
	//去跟多信息页面
	function moreInfo(){
		window.location.href='<%=basePath%>accountinfo/moreInfo';
	}
	
	//去风险能力测试页面
	function riskTest(){
		window.location.href='<%=basePath%>accountinfo/torisktest';
	}
</script>

</head>

<body>
		<div id="wrap">
		<input style="display: none;" type="file" onchange="changeImg(this,'idCardImages')" id="uploadimg" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg">
		<input type="hidden" id="idCardImages" name="idCardImages" value=""/>
			<ul>
				<li class="title_li"><a href="javascript:getBack();"><img src="images/back.png" class="back" /></a>个人设置</li>
				<li class="body_li">
					<c:if test="${accountInfo.isChangeName==0}">
					<a href="<%=basePath%>accountinfo/toChangeName">
					</c:if>
					<div class="d_left">
						用户名
					</div>
					<div class="d_text">
						${accountInfo.accountName}
					</div>
					<c:if test="${accountInfo.isChangeName==0}">
					<div class="d_img">
						<img src="images/go.png" class="go"/>
					</div>
					</a>
					</c:if>
				</li>
				<li class="body_li">
					<c:if test="${accountInfo.realName==null||accountInfo.realName==''}">
						<a href="<%=basePath%>accountinfo/toCertification">
					</c:if>
					<div class="d_left">
						个人信息
					</div>
					<c:if test="${accountInfo.realName!=null&&accountInfo.realName!=''}">
						<div class="d_text2">
							${accountInfo.realName}<br/>${accountInfo.idCard}
						</div>
					</c:if>
					<c:if test="${accountInfo.realName==null||accountInfo.realName==''}">
						<div class="d_text">
							未认证
						</div>
						<div class="d_img">
							<img src="images/go.png" / class="go">
						</div> 
					</c:if>
					<c:if test="${accountInfo.realName==null||accountInfo.realName==''}">
						</a>
					</c:if>
				</li>
				
				<li class="body_li">
					<a href="javascript:loadPic()">
						<div class="d_left">
							上传头像
						</div>
						<div class="d_text">
							&nbsp;
						</div>
						<div class="d_img">
							<img src="images/go.png" class="go"/>
						</div> 
					</a>
					<%-- <c:if test="${accountInfo.accountIcon==null||accountInfo.accountIcon==''}">
						<a href="javascript:loadPic()">
					</c:if>
					<c:if test="${accountInfo.accountIcon==null||accountInfo.accountIcon==''}">
						<div class="d_left">
							上传头像
						</div>
						<div class="d_text">
							&nbsp;
						</div>
						<div class="d_img">
							<img src="images/go.png" / class="go">
						</div> 
					</c:if>
					<c:if test="${accountInfo.accountIcon!=null && accountInfo.accountIcon!=''}">
						<div class="d_left">
							已上传头像
						</div>
					</c:if>
					
					<c:if test="${accountInfo.accountIcon==null||accountInfo.accountIcon==''}">
						</a>
					</c:if> --%>
				</li>
				
				<li class="body_li">
					<div class="d_left">
						账户类型
					</div>
					<div class="d_text">
						<c:if test="${accountInfo.isCompany==0}">
							个人
						</c:if>
						<c:if test="${accountInfo.isCompany==1}">
							企业
						</c:if>
					</div>
				</li>
				
				<li class="body_li">
					<div class="d_left">
						手机
					</div>
					<div class="d_text">
						${accountInfo.telephone}
					</div>
				</li>
				<li class="body_li">
					<a href="<%=basePath%>accountinfo/bankCard">
					<div class="d_left">
						银行卡
					</div>
					<div class="d_text">
						<c:if test="${bankCount==0}">
							添加
						</c:if> <c:if test="${bankCount!=0}">
							${bankCount}张
						</c:if>
					</div>
					<div class="d_img">
						<img src="images/go.png" / class="go">
					</div>
					</a>
				</li>
				
				<li onclick="pwdManager();" class="body_li">
					<div class="d_left">
						密码管理
					</div>
					<div class="d_text">
						&nbsp;
					</div>
					<div class="d_img">
						<img src="images/go.png"  class="go">
					</div>
				</li>
				<li onclick="riskTest();" class="body_li">
					<div class="d_left">
						抗风险能力测试
					</div>
					<div class="d_text">
						<c:if test="${accountInfo.isRisk == 0}">
						马上测试
						</c:if>
						<c:if test="${accountInfo.isRisk == 1}">
							<c:if test="${accountInfo.riskResult > 0 && accountInfo.riskResult <=20 }">
							保守型
							</c:if>
							<c:if test="${accountInfo.riskResult > 20 && accountInfo.riskResult <=40 }">
							稳健偏保守型
							</c:if>
							<c:if test="${accountInfo.riskResult > 40 && accountInfo.riskResult <=60 }">
							稳健型
							</c:if>
							<c:if test="${accountInfo.riskResult > 60 && accountInfo.riskResult <=80 }">
							稳健偏积极型
							</c:if>
							<c:if test="${accountInfo.riskResult > 80 && accountInfo.riskResult <=100 }">
							积极型
							</c:if>
						</c:if>
					</div>
					<div class="d_img">
						<img src="images/go.png"  class="go">
					</div>
				</li>
				<li onclick="moreInfo();" class="body_li">
					<div class="d_left">
						更多信息
					</div>
					<div class="d_text">
						&nbsp;
					</div>
					<div class="d_img">
						<img src="images/go.png" class="go">
					</div>
				</li>
				<%-- <li class="body_li">
					<a href="<%=basePath%>accountinfo/toChangeLoginPassword">
					<div class="d_left">
						修改登录密码
					</div>
					<div class="d_text">
						&nbsp;
					</div>
					<div class="d_img">
						<img src="images/go.png" / class="go">
					</div>
					</a>
				</li>
				<li class="body_li">
					<c:if test="${accountInfo.dealPassword!=null&&accountInfo.dealPassword!=''}">
					<a href="<%=basePath%>accountinfo/toChangeDealPassword">
					<div class="d_left">
						修改交易密码
					</div>
					<div class="d_text">
						&nbsp;
					</div>
					<div class="d_img">
						<img src="images/go.png" / class="go">
					</div>
					</a>
					</c:if>
					<c:if test="${accountInfo.dealPassword==null||accountInfo.dealPassword==''}">
					<a href="<%=basePath%>accountinfo/toSetDealPassword">
						<div class="d_left">
						设置交易密码
						</div>
						<div class="d_text">
							&nbsp;
						</div>
						<div class="d_img">
							<img src="images/go.png" / class="go">
						</div>
					</a>
					</c:if>
					
				</li>
				<li class="body_li">
					<a href="<%=basePath%>accountinfo/toGetBackDealPassword">
					<div class="d_left">
						找回交易密码
					</div>
					<div class="d_text">
						&nbsp;
					</div>
					<div class="d_img">
						<img src="images/go.png" / class="go">
					</div>
					</a>
				</li> --%>
			</ul>
			<span class="prompt" >每完善一条信息，送鱼干</span>
			<div class="outlogin" onclick="outLogin()">退出登录</div>
		</div>
		
		<div class="loader" style="display: none;"></div>
		<div class="loading-3" style="display: none;">
			<i></i>
			<i></i>
			<i></i>
			<i></i>
			<i></i>
			<i></i>
			<i></i>
			<i></i>
		</div>
		
</body>
<script type="text/javascript">
function loadPic(){
	$("input[id='uploadimg']").click();
}

function changeImg(obj,className){
	
	if($(obj)[0].files.length!=1){
		alert("请选择一张图片");
	}
	
	var data = new FormData();
	$.each($(obj)[0].files, function(i, file) {
		data.append('csvFile', file);
		//$("input[id='uploadimg']").attr("src", window.URL.createObjectURL(file));
	});
	
	 if(confirm("是否上传？")){
		 
		 openLoad();
		 
		//上传
			$.ajax({
				type: "POST",
				url: '<%=basePath%>wxshareController/upload',
				data: data,
				dataType:'json',
				cache: false,
				contentType: false,    //不可缺
				processData: false,    //不可缺
				success: function(data) {
					/* $('input[id="'+className+'"]').val(data.uploadFile);
					$('img[id="'+className+'"]').attr("src",data.uploadFile);
					$('img[id="'+className+'"]').removeAttr("onclick"); */
					if (data.result === "success") {
						closeLoad();
						alert("上传成功!");
						window.location.href='<%=basePath%>accountinfo/personalSettings';
					}else {
						alert("上传失败,请重新拍照!");
					}
				}
			});
     }else{
    	 alert("已取消上传");
     }	
}
function openLoad(){
	$('.shade').css('display','none');
    $('.deal').css('display','none');
	$('.fad').css('display','none');

	$('.loading-3').css('display','');
	$('.loader').css('display','');
}

function closeLoad(){

	$('.loading-3').css('display','none');
	$('.loader').css('display','none');
}

$(function(){
	$('.shade').height($(window).height());
	$('.loader').height($(window).height());

});


</script>




<%-- <script src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script>
$(document).ready(function(){
	//debugger;
	 var url = window.location.href;
	 var timestamp;
	 var nonceStr;
	 var signature;
	 var appId;	 	
	  //获取签名
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
	   },
	   error: function(){  
		   alert('error');  
		   } 
	   });
	  function wxconfig(){
		  wx.config({
			    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
			    appId: appId,
			    timestamp: timestamp, // 必填，生成签名的时间戳
			    nonceStr: nonceStr,
			    signature: signature, // 必填，签名，见附录1
			    jsApiList: ['onMenuShareTimeline', 
			                'onMenuShareAppMessage',
			                'chooseImage',
			                'previewImage',
			                'uploadImage',
			                'downloadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
			});
	  }
});

var images = { 
		  localId: [], 
		  serverId: [] 
		 };
function loadPic(){
     //拍照或从手机相册中选图接口
     wx.chooseImage({
         count:1,//设置一次能选择的图片的数量 
         sizeType:['original','compressed'],//指定是原图还是压缩,默认二者都有
         sourceType:['camera','album'],//可以指定来源是相册还是相机,默认二者都有
         success:function(res){   //微信返回了一个资源对象 
      	     //res.localIds 是一个数组　保存了用户一次性选择的所有图片的信息　  　　　　　　　
             images.localId=res.localIds;//把图片的路径保存在images[localId]中--图片本地的id信息，用于上传图片到微信浏览器时使用 
             if(confirm("是否上传？")){
                 ulLoadToWechat();
             }else{
            	 alert("已取消上传");
             }
             
          }
     });
};


//上传图片到微信
function ulLoadToWechat(){
	
	//length = images.localId.length; //本次要上传所有图片的数量
	wx.uploadImage({
	      localId: images.localId[0], //图片在本地的id
	      isShowProgressTips: 1, // 默认为1，显示进度提示
	      success: function (res) {//上传图片到微信成功的回调函数   会返回一个媒体对象  存储了图片在微信的id
	      	images.serverId[0] = res.serverId;         
	        wxImgDown(images.serverId);
	      },
	  }); 
		
};

//下载上传到微信上的图片
function wxImgDown(serverIds){  
	
  $.ajax({   //后台下载\
  	 type: "POST",
     url:"<%=basePath%>wxshareController/wxdownpic",
      data:{
      	mediaIds : serverIds,
      },
      traditional: true,
      success:function(data){		
			if (data.message == "保存成功") {
				alert("上传成功!");
				window.location.href='<%=basePath%>accountinfo/personalSettings';
			}else {
				alert("上传失败,请重新拍照!");
			}		
      },
  })
}
</script> --%>
</html>
