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
<title>双十二活动</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/activity/twelveActivity.css" />

</head>

<body>
	<form method="post" action="" id="form1" >
    	<input type="hidden" id="type"  name="type" value=""/>
	</form>
		<div class="wrap">
			<img src="images/wx-12-bg.png" />
			<div class="content-lable">
				<p>还剩${limitcount}台</p>
			</div>
			<div class="content">
				<div class="content-inner">

					<img src="images/wx-12-textbg.png" />
					<div>
						<p class="content-inner-title">
							<span></span> iPhoneX 64G
							<span></span>
						</p>
						<p class="phone-price-num">7788.00 <span>元</span></p>
						<p class="phone-price">购机价格</p>
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th>${sBean.subjectRate }%</th>
								<th>20000.00元</th>
								<th>${sBean.subjectPeriods }
									<c:if test="${'0'==sBean.subjectTerm }">天</c:if>
									<c:if test="${'1'==sBean.subjectTerm }">月</c:if>
									<c:if test="${'2'==sBean.subjectTerm }">年</c:if>
								</th>
							</tr>
							<tr>
								<td>年化利率</td>
								<td>投资金额</td>
								<td>投资期限</td>
							</tr>
						</table>
						<c:if test="${empty sessionScope.account}">
							<img src="images/wx-12-btn.png" class="tz-btn" onclick="investX(0)"/>
						</c:if>
						<c:if test="${!empty sessionScope.account}">
							<img src="images/wx-12-btn.png" class="tz-btn" onclick="investX(-1)"/>
						</c:if>
					</div>

				</div>
				<div class="content-inner content-inner-2">
					<img src="images/wx-12-textbg.png" />
					<div>
						<p class="content-inner-title">
							<span></span> iPhoneX 64G
							<span></span>
						</p>
						<p class="phone-price-num">7588.00 <span>元</span></p>
						<p class="phone-price">购机价格</p>
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th>${sBean.subjectRate }%</th>
								<th>30000.00元</th>
								<th>${sBean.subjectPeriods }
									<c:if test="${'0'==sBean.subjectTerm }">天</c:if>
									<c:if test="${'1'==sBean.subjectTerm }">月</c:if>
									<c:if test="${'2'==sBean.subjectTerm }">年</c:if>
								</th>
							</tr>
							<tr>
								<td>年化利率</td>
								<td>投资金额</td>
								<td>投资期限</td>
							</tr>
						</table>
						<c:if test="${empty sessionScope.account}">
							<img src="images/wx-12-btn.png" class="tz-btn" onclick="investX(0)"/>
						</c:if>
						<c:if test="${!empty sessionScope.account}">
						<img src="images/wx-12-btn.png" class="tz-btn" onclick="investX(-2)"/>
						</c:if>
					</div>
				</div>
			</div>
			<input type="hidden" id="limitcount"  value="${limitcount}"/>
			<p class="double12-rule-title">
				<span></span>
				<img src="images/wx-12-rule.png" />
				<span></span>
			</p>
			<ul class="double12-rule">
				<li>1.本次活动时间为2017年12月12日至2017年12月14日。</li>
				<li>2.双12活动标为约定年化率12%固定投资的4个月标先息后本。只要投注该标视为购机成功，到期后从本金扣除购机费用。
				</li>
				<li>3.该活动手机为iPhoneX 64G 颜色自选（仅限10台），购机成功后会在1-3个工作日内发货。
				</li>
				<li>4.本活动最终解释权归猫咪财富所有。</li>
			</ul>
		</div>
		<div class="footer">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="toChange(this,1)"><img src="images/tab_home_nor.png" /></th>
						<th onclick="toChange(this,2)"><img src="images/tab_touzi_sel.png" /></th>
						<th onclick="toChange(this,3)"><img src="images/tab_mall_nor.png" /></th>
						<th onclick="toChange(this,4)"><img src="images/tab_geren_nor.png" /></th>
					</tr>
					<tr>
						<td onclick="toChange(this,1)">首页</td>
						<td onclick="toChange(this,2)" class="currentChose">投资</td>
						<td onclick="toChange(this,3)">商城</td>
						<td onclick="toChange(this,4)">我</td>
					</tr>
				</table>
			</div>
</body>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/navigation.js"></script>
<script type="text/javascript" src="js/activity/twelveActivity.js"></script>
<script type="text/javascript">
$(window).load(function() {
	var divH = $('.content-inner img:nth-child(1)').height();
	$('.content-inner div').css('height', divH);
});
</script>
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
	   success : function(data){
		   var a = eval('('+data+')');
	    	appId = a.appId;
	   		timestamp = a.timestamp; 
	    	nonceStr = a.nonceStr; 
	    	signature = a.signature;
	    	
	    	wxconfig();
	   },
	   error: function(){  
		   
		   } 
	   });
	  /* alert(signature); */
	  function wxconfig(){
		  wx.config({
			    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
			    appId: appId,
			    timestamp: timestamp, // 必填，生成签名的时间戳
			    nonceStr: nonceStr,
			    signature: signature, // 必填，签名，见附录1
			    jsApiList: [
			                'onMenuShareTimeline', 
			                'onMenuShareAppMessage'
			                ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
			});
		  wx.ready(function(){
				
			    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
				wx.onMenuShareAppMessage({
				    title: '猫咪财富', // 分享标题
				    desc: '快来看，更多金币等你来拿', // 分享描述
				    link: 'https://www.maomibank.com/xed_financing_wxgzh/activity/s/twelveactivity',
				    imgUrl: 'https://www.maomibank.com/xed_financing_wxgzh/images/defaultHeadPic.png',
				    type: 'link', // 分享类型,music、video或link，不填默认为link
				    dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
				    success: function () { 
				        alert('分享成功！');
				    },
				    cancel: function () { 
				        // 用户取消分享后执行的回调函数
				    	alert('取消分享！');
				    }
				});
			    
				wx.onMenuShareTimeline({
				    title: '猫咪财富', // 分享标题
				    link: 'https://www.maomibank.com/xed_financing_wxgzh/activity/s/twelveactivity',
				    imgUrl: 'https://www.maomibank.com/xed_financing_wxgzh/images/defaultHeadPic.png',
				    success: function () { 
				        alert('分享成功！');
				    },
				    cancel: function () { 
				        // 用户取消分享后执行的回调函数
				    	 alert('取消分享！');
				    }
				});
			});
			wx.error(function(res){
			    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
				
				
			});
	  }
});
</script>
</html>
