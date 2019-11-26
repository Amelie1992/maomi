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
<title>欢庆元旦</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/subject/invest.js"></script>
<style type="text/css">
.wrap {
	width: 100%;
	background-image: url(images/activity/yuandan/yd-bg.png);
	background-size: 100% 100%;
	background-position: center;
	background-repeat: no-repeat;
}

.wrap img {
	width: 100%;
}

.title {
	padding: 0 30px;
}

.content {
	padding: 0 3%;
	position: relative;
}

.wrap .yd-btn {
	position: absolute;
	width: 30%;
	right: 13%;
	bottom: 2%;
}

.wrap .rule {
	padding: 8% 3%;
}
/*红包*/
						
.redEnve-mask {
	width: 100%;
	height: 400px;
	position: absolute;
	top: 0;
	left: 0;
	background-color: black;
	opacity: 0.5;
	display: none;
}

.redEnve {
	position: absolute;
	top: 50%;
	padding: 5%;
	text-align: center;
	display: none;
}

.redEnve img {
	width: 50%;
}

#redEnve-tips {
	width: 90%;
	text-align: center;
	color: #fff;
	font-size: 18px;
	position: absolute;
	top: 21%;
	display: none;
}
.redEnve-pack{
	position: absolute;
	width: 30%;
	left: 30px;
	bottom: 20px;
}
.redEnve-pack img{
	width: 80%;
}
.redEnve-pack-tips{
	position: absolute;
	/*width: 70%;*/
	right: 45px;
	font-size: 12px;
	top: 75%;
	line-height: 25px;
}
@media only screen and (min-width: 0px) and (max-width: 320px) {
				.redEnve-pack-tips {
					position: absolute;
					/*width: 70%;*/
					right: 20px;
					font-size: 12px;
					top: 72%;
					line-height: 25px;
				}
			}
.redEnve-pack-tips img{
	width: 20px;
}
.redEnve-pack-tips p:nth-child(1){
	color: #212121;
}
.redEnve-pack-tips p:nth-child(1) b{
	color: #FF0000;
}
.redEnve-pack-tips p:nth-child(2){
	color: #757575;
}
.redEnve-pack-tips p:nth-child(3){
	color: #f13d3d;
	font-size: 14px;
}
</style>
</head>

<body>
	<input id="basePath" type="hidden" value="<%=basePath%>"/>
	<div class="wrap">
			<div class="head">
				<img src="images/yd-head.png" />
			</div>
			<div class="kny">
				<div class="kny-title title">
					<img src="images/yd-title-1.png" />
				</div>
				<div class="kny-content content">
					<img src="images/yd-text.png" />
					<img src="images/wx-kny-redE-box.png" style="position: relative;top: -2px;" />
					<div class="redEnve-pack">
						<c:if test="${empty sessionScope.account}">
						<img src="images/wx-kny-redE.png" class="redE" onclick="gologin()"/>
						</c:if>
						<c:if test="${!empty sessionScope.account}">
						<img src="images/wx-kny-redE.png" class="redE" onclick="redEnvelope()"/>
						</c:if>
					</div>
					<div class="redEnve-pack-tips">
						<p>跨年活动红包已领(<b>${countredPackage }</b>/5) &nbsp;&nbsp;&nbsp;&nbsp;待领(<b>${noGetRed }</b>)</p>
						<%-- <p>跨年活动红包待领(<b>${noGetRed }</b></p> --%>
						<p>有效期：2018-01-01至2018-01-03</p>
						<c:if test="${empty sessionScope.account}">
							<p>
								<span onclick="gologin()">
									<img src="images/wx-kny-redE-pointer.png" style="position: relative;top: 4px;margin-right: 10px;"/>
										登录领取
								</span>
							</p>
						</c:if>
						<c:if test="${!empty sessionScope.account}">
							<p>
								<span onclick="redEnvelope()">
									<img src="images/wx-kny-redE-pointer.png" style="position: relative;top: 4px;margin-right: 10px;"/>
										点击领取
								</span>
							</p>
						</c:if>
					</div>

				</div>
				<div class="yd">
					<div class="yd-title title">
						<img src="images/yd-title-2.png" />
					</div>
					<div class="yd-content content">
						<img src="images/yd-content.png" />

						<img src="images/yd-btn.png" class="yd-btn" onclick="gotoActivity()"/>
					</div>
				</div>
				<input type="hidden" id="countredPackage" value="${countredPackage }">
				<input type="hidden" id="noGetRed" value="${noGetRed }">
				<div class="rule">
					<img src="images/yd-rule.png" />
				</div>
				<div class="redEnve-mask">

					</div>
					<div class="redEnve">
						<img src="images/redE-before.png" id="rotare1" />
						<p id="redEnve-tips"></p>
					</div>
			</div>
			</div>
</body>

<script type="text/javascript">
	function gotoActivity(){
		window.location.href='./subject/s/querysubject';
	}
</script>
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script>
$(function() {

	var maskH = $('.wrap').height();
	$('.redEnve-mask').css('height', maskH);


});
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
									success : function(data) {
										var a = eval('(' + data + ')');
										appId = a.appId;
										timestamp = a.timestamp;
										nonceStr = a.nonceStr;
										signature = a.signature;

										wxconfig();
									},
									error : function() {

									}
								});
						/* alert(signature); */
						function wxconfig() {
							wx.config({
								debug : false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
								appId : appId,
								timestamp : timestamp, // 必填，生成签名的时间戳
								nonceStr : nonceStr,
								signature : signature, // 必填，签名，见附录1
								jsApiList : [ 'onMenuShareTimeline',
										'onMenuShareAppMessage' ]
							// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
							});
							wx.ready(function() {

										// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
										wx.onMenuShareAppMessage({
													title : '猫咪财富', // 分享标题
													desc : '快来看，更多金币等你来拿', // 分享描述
													link : 'https://www.maomibank.com/xed_financing_wxgzh/activity/s/yuandanActivity',
													imgUrl : 'https://www.maomibank.com/xed_financing_wxgzh/images/defaultHeadPic.png',
													type : 'link', // 分享类型,music、video或link，不填默认为link
													dataUrl : '', // 如果type是music或video，则要提供数据链接，默认为空
													success : function() {
														alert('分享成功！');
													},
													cancel : function() {
														// 用户取消分享后执行的回调函数
														alert('取消分享！');
													}
												});

										wx.onMenuShareTimeline({
													title : '猫咪财富', // 分享标题
													link : 'https://www.maomibank.com/xed_financing_wxgzh/activity/s/yuandanActivity',
													imgUrl : 'https://www.maomibank.com/xed_financing_wxgzh/images/defaultHeadPic.png',
													success : function() {
														alert('分享成功！');
													},
													cancel : function() {
														// 用户取消分享后执行的回调函数
														alert('取消分享！');
													}
												});
									});
							wx.error(function(res) {
								// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。

							});
						}
					});
					
					
function redEnvelope() {
	var noGetRed=$("#noGetRed").val();
	if(noGetRed>0)
	{
		//显示背景
		$('.redEnve-mask').fadeIn();
		$('.redEnve').fadeIn();
		//旋转
		//获取图片
		var oPointer1 = $("#rotare1");
		var oTurntable1 = $("#rotare1");
		//保证不重复点击
		var offOn = true;
		//记录旋转过的角度
	/* 	oPointer1.click(function() {
			if(offOn) {
				rotating1();
				offOn = !offOn;
			} else {
				$('#redEnve-tips').fadeOut();					
				$('.redEnve').fadeOut();
				$('.redEnve-mask').fadeOut();
				window.location.href="./activity/s/yuandanActivity";
			}
		}); */
		
		$("#rotare1").click(function() {
			if(offOn) {
				rotating1();
				offOn = false;
				setTimeout(function() {
					window.location.href="./activity/s/yuandanActivity";
				}, 6000)
				
			}
			/* setTimeout(function() {
				offOn = true;
			}, 3000) */
			//点击后相隔多长时间可执行
		});


		function rotating1() {
			oTurntable1.css({
				transition: "all 2s",
				transform: "rotateY(" + 1800 + "deg)"
			});
			//得出奖项,延时出结果
			setTimeout(function() {
				openredpackage();
			}, 2000);

		}
	}
	else
	{
		alert("暂无可领取红包");
	}
	
}


	function gologin()
	{
		if(confirm("当前未登录，是否立即登录"))
		{
			window.location.href="./loginregister/s/toLogin";
		}		
	}
</script>
</html>
