<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>众筹详情</title>
<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="js/layui-master/dist/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/crowdfund/crowdfunddetail.css"/>
</head>
<body>
	<form method="post" action="<%=basePath%>crowdfund/investcrowfund" id="gotodetailFrm" >
    	<input type="hidden" id="id"  name="crowdId" value="${cBean.crowdId}"/>
    </form>
    <input type="hidden" name="goodName" value="${cBean.goodsName}" id="goodName"/>
	<div class="wrap">
		<div class="banner">
				<div class="swiper-container">
					<div class="swiper-wrapper">
						<c:forEach items="${gList}" var="sj">
						<div class="swiper-slide"><img src="${sj.picUrl }" /></div>
						</c:forEach>
					</div>
					<!-- Add Pagination -->
					<div class="swiper-pagination"></div>
				</div>
			</div>
			<div class="head">
				<div class="zc-state">
					<div class="zc-state-left">
						<c:if test="${cBean.crowdStatus==0 }"><img src="images/zc-icon-wks.png" /></c:if>
						<c:if test="${cBean.crowdStatus==1 }"><img src="images/zc-icon-zcz.png" /></c:if>
						<c:if test="${cBean.crowdStatus==2 }"><img src="images/zc-icon-ymb.png" /></c:if>
						<c:if test="${cBean.crowdStatus==3 }"><img src="images/zc-icon-zcz.png" /></c:if>
						<c:if test="${cBean.crowdStatus==4 }"><img src="images/zc-icon-zcsb.png" /></c:if>
						<c:if test="${cBean.crowdStatus==5 }"><img src="images/zc-icon-zccg.png" /></c:if>
						<c:if test="${cBean.crowdStatus==6 }"><img src="images/zc-icon-zcjs.png" /></c:if>
					</div>
					<div class="zc-state-right">
						<c:if test="${cBean.crowdStatus==0 }">敬请期待</c:if>
						<c:if test="${cBean.crowdStatus==1 }">离开奖还剩：${cBean.overDay }天</c:if>
						<c:if test="${cBean.crowdStatus==2 }">不可投</c:if>
						<c:if test="${cBean.crowdStatus==3 }">等待开奖</c:if>
						<c:if test="${cBean.crowdStatus==4 }">到期返还本金和收益</c:if>
						<c:if test="${cBean.crowdStatus==5 }">${cwinng }件奖品</c:if>
						<c:if test="${cBean.crowdStatus==6 }">返还本金和收益</c:if>
					</div>

				</div>
				<p class="zc-name">${cBean.crowdName }</p>
				<p class="zc-love">爱心公益目前累计
					<c:choose>
						<c:when test="">
								<fmt:formatNumber type="number" value="${welfareMoney }" maxFractionDigits="2"></fmt:formatNumber>元
						</c:when>
						<c:otherwise>
								0.00元						
						</c:otherwise>
					</c:choose>
				&nbsp;&nbsp;<img  title="爱心公益" src="images/crowd_love.png"></p>
			</div>
			<div class="content">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>已筹资金：${aMoney}元</th>
						<th>进度：${per}%</th>
					</tr>
					<tr>
						<td colspan="2">
							<div class="layui-progress" >
								<div class="layui-progress-bar layui-bg-orange" lay-percent="${per}%"></div>
							</div>
						</td>
					</tr>
					<tr>
						<td>商品名称：${cBean.goodsName}</td>
						<td>商品价格：${cBean.saleMoney}元</td>
					</tr>
					
					<tr>
						<td>参考年回报率：${cBean.crowdRate}%</td>
						<td>投资周期：${cBean.activityDay}天</td>
					</tr>
					<tr>
						<td>上限金额：${cBean.crowdMoney}元</td>
						<td>起投金额：${cBean.eachMoney}元</td>
					</tr>
					<tr>
						<td>最少比数：${cBean.minEach}</td>
						<td>加入笔数：${counts }</td>
					</tr>
					<tr>
						<td>开始时间：${cBean.beginDate}</td>
						<td>结束时间：${cBean.groupDate}</td>
					</tr>
					<tr>
						<td>结算时间：${cBean.endDate}</td>
						<td></td>
					</tr>
				</table>
			</div>
			<ul class="zc-tips">
				<li onclick="goRule()">活动规则 <img src="images/go.png"/></li>
				<li onclick="goRecord(${cBean.crowdId})">加入记录<img src="images/go.png"/></li>
			</ul>
			<div class="zc-btn">
				<c:choose>
					<c:when test="${cBean.crowdStatus==1 }">
						<img src="images/zc-btn-after.png"  onclick="investNow(${cBean.crowdId})"/>
					</c:when>
					<c:otherwise>
						<img src="images/zc-btn-before.png"/>
					</c:otherwise>
				</c:choose>
				
			</div>
		</div>
	
</body>
<script src="js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layui-master/dist/layui.js" type="text/javascript" charset="utf-8"></script>

	<script type="text/javascript">
	layui.use('element', function() {
		var $ = layui.jquery,
			element = layui.element;
		//Tab的切换功能，切换事件监听等，需要依赖element模块
	});
	
	var swiper = new Swiper('.swiper-container', {
		pagination: '.swiper-pagination',
		paginationClickable: true,
		autoplay: 2000, 
		loop: true,
	});
	
		
		
		
		function investNow(crowdId)
		{
			$("#id").val(crowdId);
			$("#gotodetailFrm").submit();
		}
		
		function goRule()
		{
			var id = $("#id").val();
			window.location.href="<%=basePath%>crowdfund/crowdrule?crowdId= " + id;
		}
		function goRecord(crowdId)
		{
			$("#id").val(crowdId);
			$("#gotodetailFrm").attr("action","./crowdfund/crowdrecord").submit();
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
			  var crowfundId = $("#id").val();
				wx.onMenuShareAppMessage({
				    title: '好吃健康，免费抽送', 
				    desc: '特级初榨橄榄油饮食的健康伴侣!', 
				    link: 'https://www.maomibank.com/xed_financing_wxgzh/crowdfund/s/detailcrowfund?crowdId=' + crowfundId,
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
				    link: 'https://www.maomibank.com/xed_financing_wxgzh/crowdfund/s/detailcrowfund?crowdId=' + crowfundId,
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