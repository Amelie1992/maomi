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
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/navigation.js"></script>
<script type="text/javascript" src="js/activity/singlesday.js"></script>

<title>双十一理财节</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/nationalactivity/singlesday.css" />

</head>

<body>
	<form method="post" action="" id="form1" >
    	<input type="hidden" id="goodId"  name="goodId" value=""/>
	</form>
	<div class="wrap">
			<img src="images/wx-double11-bg.png" />
			<p class="wx-double11-jxq-title">投资满额，加息不断！</p>
			<p class="wx-double11-jxq-tips">猫咪宝投资满1万元元且投资满10天可获得一张1%加息券</p>
			<div id="countdown" style="left:10%;">
				<div id='tiles'>
					<p>
						<c:choose>
							<c:when test="${days==0}">
								<span>已满足领取条件</span>
							</c:when>
							<c:when test="${days==11}">
								<span>暂未获取资格</span>
							</c:when>
							<c:otherwise>
								<span>距离领奖还有</span>
								<span class="getPrizeTime">${days}</span>
								<span>天</span>
							</c:otherwise>
						</c:choose>
					</p>
				</div>

			</div>

			<!-- <img src="images/wx-double11-btn-before.png" class="wx-double11-jxq-btn" /> -->
			<c:choose>
				<c:when test="${days==0}">
					<c:if test="${isReceive>=1}">
							<img src="images/double11-btn-send.png" class="wx-double11-jxq-btn"/>
					</c:if>
					<c:if test="${isReceive<1}">
							<img src="images/wx-double11-btn-after.png" class="wx-double11-jxq-btn" style="top:15.2%;" onclick="receiveCoupon()"/>
					</c:if>
					
				</c:when>
				<c:otherwise>
					 	<img src="images/wx-double11-btn-before.png" class="wx-double11-jxq-btn"/>
				</c:otherwise>
			</c:choose>
			<!--满足条件后图片换成wx-double11-btn-after.png-->
			<p class="wx-double11-jxq-tips">新手标投资满100元即可获得</p>
			<p class="wx-double11-jxq-tips">爆款标首次投资满1万元元即可获得</p>
			<p class="wx-double11-jxq-tips">新手标投资满1000元即可获得.精选理财首次投资满1万元元即可获得 </p>
			<p class="wx-double11-jxq-tips">爆款标累计投资满6万元元即可获得 .精选理财累计投资满5万元元即可获得 </p>
			<p class="wx-double11-jxq-title">久久投资，赢Iphone8,IphoneX！</p>
			<a href="javascript:lookQualifications(1)" class="wx-double11-jxq-look">查看资格</a>
			<a href="javascript:lookQualifications(2)" class="wx-double11-jxq-look">查看资格</a>
			<a href="javascript:lookQualifications(3)" class="wx-double11-jxq-look">查看资格</a>
			<a href="javascript:lookQualifications(4)" class="wx-double11-jxq-look">查看资格</a>
			<a href="javascript:lookQualifications(5)" class="wx-double11-jxq-look">查看资格</a>
			<a href="javascript:lookQualifications(6)" class="wx-double11-jxq-look">查看资格</a>
			
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th>A.90000投资4个月</th>
					<th>B.60000投资6个月</th>
				</tr>
				<tr>
					<th>C.40000投资9个月</th>
					<th>D.20000投资18个月</th>
				</tr>
			</table>
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th>A.90000投资5个月</th>
					<th>B.50000投资9个月</th>
				</tr>
				<tr>
					<th>C.30000投资15个月</th>
					<th>D.20000投资22个月</th>
				</tr>
			</table>
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th>A.70000投资6个月</th>
					<th>B.50000投资8个月</th>
				</tr>
				<tr>
					<th>C.35000投资12个月</th>
					<th>D.20000投资20个月</th>
				</tr>
			</table>
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th>A.100000投资5个月</th>
					<th>B.80000投资6个月</th>
				</tr>
				<tr>
					<th>C.50000投资10个月</th>
					<th>D.20000投资24个月</th>
				</tr>
			</table>
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th>A.89000投资6个月</th>
					<th>B.67000投资8个月</th>
				</tr>
				<tr>
					<th>C.45000投资12个月</th>
					<th>D.27000投资20个月</th>
				</tr>
			</table>
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th>A.100000投资6个月</th>
					<th>B.78000投资8个月</th>
				</tr>
				<tr>
					<th>C.50000投资12个月</th>
					<th>D.31000投资20个月</th>
				</tr>
			</table>
			<div class="double11-rule" >
				<p class="double11-rule-title">理财节活动规则</p>
				<!-- <p style="font-size:1rem;text-algin:center;padding-top:10px;">活动时间</p> -->
				<p style="font-size:1rem;text-algin:center;padding-top:10px;">（2017-11-10至2017-11-18）</p>
				<ul>
					<li>1.投资送加息券活动，除猫咪宝以外，其余投资特殊渠道不参加，参加无返点。</li>
					<li>2.猫咪宝满足活动要求后，可在活动详情页领取加息券。
					</li>
					<li>3.投资送手机活动，手机作为最后收益。用户投资后，在“我的投资”页面可以查看订单详情，我们会在3个工作日内寄达，寄送后订单详情会提供快递单号。（iPhone X货源较为紧张可能会增加1-2天工作日）。
					</li>
					<li>5.本活动最终解释权归猫咪财富所有。</li>
				</ul>
			</div>
			
		</div>
		<div class="footer">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="toChange(this,1)"><img src="images/tab_home_sel.png" /></th>
						<th onclick="toChange(this,2)"><img src="images/tab_touzi_nor.png" /></th>
						<th onclick="toChange(this,3)"><img src="images/tab_mall_nor.png" /></th>
						<th onclick="toChange(this,4)"><img src="images/tab_geren_nor.png" /></th>
					</tr>
					<tr>
						<td class="currentChose">首页</td>
						<td>投资</td>
						<td>商城</td>
						<td>我</td>
					</tr>
				</table>
			</div>
</body>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script>
$(document).ready(function(){
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
				    title: '悄悄告诉你，我们要送iphoneX了!', 
				    desc: '猫咪财富双十一理财节送您加息劵、iphone8、iphone8Plus、iphoneX!', 
				    link: 'https://www.maomibank.com/xed_financing_wxgzh/singlesday/s/gosinglesday',
				    imgUrl: 'https://www.maomibank.com/xed_financing_wxgzh/images/activity/wxshare.png',
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
				    title: '悄悄告诉你，我们要送iphoneX了!', 
				    link: 'https://www.maomibank.com/xed_financing_wxgzh/singlesday/s/gosinglesday',
				    imgUrl: 'https://www.maomibank.com/xed_financing_wxgzh/images/activity/wxshare.png',
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
