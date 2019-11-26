<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css"
	href="js/layui-master/dist/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
<title>春节活动</title>
<style type="text/css">
.head {
	width: 100%;
}

.head img {
	width: 100%;
}

.content {
	width: 96%;
	padding: 2%;
	background-image: url(images/activity/chunjie/cjhd-bg.png);
	background-size: 100% 100%;
	background-position: center;
	background-repeat: no-repeat;
	position: relative;
	top: -2px;
}

.content-box {
	width: 96%;
	margin: 0 auto;
	padding: 2%;
	padding-top: 30px;
	background-image: url(images/activity/chunjie/cjhd-content-bg.png);
	background-size: 100% 100%;
	background-position: center;
	background-repeat: no-repeat;
}

.activity-box {
	border: 2px solid #B52C25;
	margin-bottom: 40px;
	position: relative;
}

.activity-box table {
	width: 90%;
	margin: 0 auto;
	text-align: center;
}

.activity-box table th:nth-child(1) img {
	width: 64px;
}

.activity-box table th span {
	display: inline-block;
	width: 70%;
}

.activity-box table th:nth-child(2n+1) {
	text-align: left;
}

.activity-box table th:nth-child(2n) {
	text-align: right;
}

.content-title {
	width: 45%;
	height: 34px;
	line-height: 34px;
	text-align: center;
	font-size: 14px;
	color: #b52c25;
	background-image: url(images/activity/chunjie/cjhd-lable-box.png);
	background-size: 100% 100%;
	background-position: center;
	background-repeat: no-repeat;
	position: absolute;
	left: 27.5%;
	top: -18px;
	z-index: 100;
}

.content-box ul {
	padding: 2%;
	padding-top: 30px;
}

.content ul li {
	line-height: 22px;
	color: #B52C25;
	margin-bottom: 10px;
}

.activity-btn {
	width: 45%;
	height: 35px;
	line-height: 35px;
	text-align: center;
	margin: 20px auto;
	background-image: url(images/activity/chunjie/cjhd-btn-box.png);
	background-size: 100% 100%;
	background-position: center;
	background-repeat: no-repeat;
	color: #f8e594;
}

.activity-table {
	width: 90%;
	margin: 0 auto;
	margin-bottom: 20px;
}

.activity-table img {
	width: 100%;
}

.activity-share{
				overflow: hidden;
				text-align: center;
			}
			.activity-share .activity-btn{
				display: inline-block;
				text-align: center;
			}

.activity-rule {
	margin: 0 auto;
	padding-top: 20px;
	text-align: center;
}

.activity-rule img {
	width: 100%;
}

.content .activity-rule-text li {
	color: white;
	font-size: 12px;
}
</style>
</head>

<body>
	<div class="wrap">
		<div class="head">
			<img src="images/activity/chunjie/cjhd-head.png" />
		</div>
		<div class="content">
			<div class="content-box">
				<div class="yqhy activity-box">
					<div class="content-title">邀请好友送加息</div>
					<ul>
						<li>1、邀请好友首次投资新手标达到500元，邀请人可得一张2%加息券，被邀请人获得10元现金券。</li>
						<li>2、邀请好友首次投资新手标达到1000元，邀请人可得一张3%加息券跟新手投资一次，被邀请人获得20 元现金券。</li>
						<li>3、邀请5人以上好友且首次投资新手标，邀请人送3%加息券，5人以上多一位多送一张0.6%加息券，所有被邀请人送5元现金券。</li>
					</ul>
				</div>
				<div class="activity-box tz">
					<div class="content-title">投资达标奖励多</div>
					<ul>
						<li>1、活动期间投资爆款或精选标满500元且未满3000元， 送1%加息券。(仅限三次)</li>
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th><img src="images/activity/chunjie/cjhd-jxq.png" /></th>
								<th><span class="activity-btn" onclick="gotoActivity()">立即投资(${count1 }/3)</span></th>
							</tr>

						</table>
						<li>2、活动期间投资爆款或精选标满3000元且未满5000元， 送2次新手标再投机会。(仅限三次)</li>
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th><img src="images/activity/chunjie/cjhd-xsb.png" /></th>
								<th><span class="activity-btn" onclick="gotoActivity()">立即投资(${count2 }/3)</span></th>
							</tr>

						</table>
						<li>3、活动期间投资爆款或精选标满5000元且未满10000元， 送500鱼干。(仅限三次)</li>
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th><img src="images/activity/chunjie/cjhd-500yg.png" /></th>
								<th><span class="activity-btn" onclick="gotoActivity()">立即投资(${count3 }/3)</span></th>
							</tr>

						</table>
						<li>4、活动期间投资爆款或精选标满10000元以上， 送1200鱼干。(仅限三次)</li>
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th><img src="images/activity/chunjie/cjhd-1200yg.png" /></th>
								<th><span class="activity-btn" onclick="gotoActivity()">立即投资(${count4 }/3)</span></th>
							</tr>

						</table>
					</ul>
				</div>
				<div class="jz activity-box" style="margin-bottom: 10px;">
					<div class="content-title">分享集赞赢豪礼</div>
					<ul>
						<li>1、活动期间分享猫咪财富春节活动并附上祝福语至微信朋友圈。获得好友点赞可以获得对应的获得奖励。</li>
						<li>2、领奖条件以截图方式发给客服，客服微信号：18105181539</li>
						<li>3、集赞越多，奖励越丰厚，详情如下：</li>
					</ul>
					<div class="activity-table">
						<img src="images/activity/chunjie/cjhd-table.png" />
					</div>
					<!-- <div class="activity-share">
							<div class="activity-btn" id="onMenuShareAppMessage">
								分享给好友
							</div>
							<div class="activity-btn" id="onMenuShareTimeline">
								分享到朋友圈
							</div>
						</div> -->
				</div>
			</div>

			<div class="activity-rule">
				<img src="images/activity/chunjie/cjhd-rule.png" />
			</div>
			<ul class="activity-rule-text">
				<li>1、该活动所有获得的加息券计息一个月。</li>
				<li>2、投资奖励仅限爆款标和精选标获得。</li>
				<li>3、集赞活动的奖励在春节放假结束后的第一个工作日发放。</li>
				<li>4、该活动最终解释权归猫咪财富所有。</li>
			</ul>
		</div>
	</div>
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
function gotoActivity(){
	window.location.href='./subject/s/querysubject';
}
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
				    title: '猫咪财富丨春节送壕礼', 
				    desc: '这个活动我们已经等了1年了!', 
				    link: 'https://www.maomibank.com/xed_financing_wxgzh/activity/s/springFestival',
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
				    title: '猫咪财富丨春节送壕礼', 
				    link: 'https://www.maomibank.com/xed_financing_wxgzh/activity/s/springFestival',
				    imgUrl: 'https://www.maomibank.com/xed_financing_wxgzh/images/defaultHeadPic.png',
				    success: function () { 
				        alert('恭喜你，分享成功！');
				    },
				    cancel: function () { 
				    	alert('你已经取消了分享！');
				    }
				});
			});

	  } 
});

</script>

</html>
