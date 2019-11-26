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
<title>喜迎圣诞</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css"
	href="css/activity/christmasActivity.css" />

</head>

<body>
	<div class="wrap">
		<div class="head">
			<img src="images/activity/sdj-head.png" />
		</div>
		<div class="content">
			<img src="images/activity/sdj-textbox.png" class="textbox" />
			<img src="images/activity/sdj-btn.png" class="sdj-btn" onclick="gotoActivity()"/>
		</div>

		<div class="tips">
			<p class="tips-title">
				<span class="bar"></span> <span>活动规则</span> <span class="bar"></span>
			</p>
			<ul>
				<li>1.活动时间为2017年12月25日当天。</li>
				<li>2.此奖励每档仅限领取一次。</li>
				<li>3.满足获奖条件后，前往个人中心收货地址详情页内填写相应信息 我们会在1-3个工作日内寄出。</li>
				<li>此次投标活动可正常获取收益，但无法使用优惠券进行加息、增值等。</li>
			</ul>
			<h4>活动最终解释权归猫咪财富所有，如有任何疑问请联系客服！</h4>
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
													link : 'https://www.maomibank.com/xed_financing_wxgzh/activity/s/christmasActivity',
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
													link : 'https://www.maomibank.com/xed_financing_wxgzh/activity/s/christmasActivity',
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
</script>
</html>
