<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>个人中心</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/help_content_inner.css" />
		<link rel="stylesheet" type="text/css" href="css/loginregister/myCenter.css"/>
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/navigation.css"/>
		<link rel="stylesheet" href="css/zoomify.min.css">
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/navigation.js"></script>
		<script type="text/javascript" src="js/isWeixin.js"></script>
		
		<style type="text/css">
			.imgborder{
				border-radius:50%;
			}
			
		</style>
	</head>
	
	<body>
	<input type="hidden" id="basePath" value="<%=basePath%>" />
	
	<div class="wrap">
	
			<div class="head">			
				<div >
					
					<c:if test="${accountBean.accountIcon == null || accountBean.accountIcon == '' }">					
						<img src="" id="WXicon" onclick="toSetting()" style="width:90px;height:90px; border-radius:50%;"/>
					</c:if>
					<c:if test="${accountBean.accountIcon != null && accountBean.accountIcon != '' }">
						<img src="${accountBean.accountIcon }" onclick="toSetting()" style="width:90px;height:90px;border-radius:50%;"/>
					</c:if>
					
					<%-- <input type="file" id="WXImg" name="csvfile" style="display: none;" onchange="changeImg(this,'WXImg','<%=basePath%>')" multiple="multiple"/> --%>
					<p onclick="toSetting()">${accountName}
						<span><c:if test="${accountBean.isCompany=='1'}"><img src="images/wx-qiye-icon.png" style="vertical-align:middle;width:20px;height:20px;"/></c:if></span>
					</p>
					<p onclick="toAccountCenter()">
						<img src="images/wx-vip-icon-${accountLevel}.png" />
					</p>
				</div>
				<span onclick="querymessage()"><c:choose>
							<c:when test="${noReadMessage==0}">
								<img src="images/wx-grzx-message-no.png" class="toMessage"/>
							</c:when>
							<c:otherwise>
								<img src="images/wx-grzx-message.png" class="toMessage"/>
							</c:otherwise>
						</c:choose></span>
                 <div class="userOperation">
                 	<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>${totalAsset}</th>
							<th>${availableBalance}</th>
							<th>${investmentMoney}</th>
						</tr>
						<tr>
							<td>总资产(元)</td>
							<td>可用余额(元)</td>
							<td>投资金额(元)</td>
						</tr>
					</table>
                 	
                 </div>
				
			<%-- 	<div onclick="signin()" class="sign" style="">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签到
				</div>
				<p onclick="toSetting()" class="userName">${accountName} <span class="vipLv"><i>v${accountLevel}&nbsp;</i></span></p>
				
				<p onclick="toSetting()" class="userAccount"><span>账户号：</span><span>${telePhone}</span></p>
			
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th class="tx" onclick="toWithdraw()"><span>提现</span></th>
					<th class="cz" onclick="toRecharge()"><span>充值</span></th>
				</tr>
				
			</table> --%>
			</div>
			<div style="padding-top: 10px;background-color: #F7F7F7;">
					<table border="0" cellspacing="" cellpadding="" style="text-align: center;width: 100%;">
                 		<tr>
                 			<th style="width: 33%;"><img src="images/chongzhi.png" onclick="toWithdraw()"/></th>
                 			<th style="width: 33%;"><img src="images/tixian.png" onclick="toRecharge()"/></th>
                 			<th style="width: 33%;">
                 			<c:if test="${isSign==0}">
                 				<img src="images/weiqiandao.png" onclick="signin()"/>
                 			</c:if>
                 			<c:if test="${isSign>0}">
                 				<img src="images/yiqiandao.png" onclick="signin()"/>
                 			</c:if>
                 			</th>
                 		</tr>
                 		<tr style="line-height: 30px;">
                 			<td onclick="toWithdraw()">提现</td>
                 			<td onclick="toRecharge()">充值</td>
                 			<td onclick="signin()">
                 				<c:if test="${isSign==0}">签到</c:if>
                 				<c:if test="${isSign>0}">今日已签</c:if>
                 			</td>
                 		</tr>
                 	</table>
			</div>
			<div class="content">
				<ul>
					<li>
						<div class="content_inner">
							<ul id="accordion2" class="accordion">
								<li>
									<div class="link">
										<i class="fa fa-chevron-down"></i>
										<div class="contentPic">
											<img src="images/zcze.png" />
										</div>
										<p class="contentName">资产列表（元）</p><i class="fa fa-chevron-down"></i>
									</div>
									<ul class="submenu">
										<li>
											<div class="contentPic">
												<img src="images/savings/cxg.png" />
											</div>
											<p class="contentName">猫咪储蓄提取总额<span class="contentTips">${stotalMoney}</span></p>
										</li>
										<li>
											<div class="contentPic">
												<img src="images/dysy.png" />
											</div>
											<p class="contentName">当月收益<span class="contentTips">${monthProfit}</span></p>
										</li>
										<li>
											<div class="contentPic">
												<img src="images/ljtz.png" />
											</div>
											<p class="contentName">累计投标收益<span class="contentTips">${totalInvestProfit}</span></p>
										</li>
										<li>
											<div class="contentPic">
												<img src="images/ljmmb.png" />
											</div>
											<p class="contentName">累计猫咪宝收益<span class="contentTips">${totalFreedomProfit}</span></p>
										</li>
										<li>
											<div class="contentPic">
												<img src="images/ljcz.png" />
											</div>
											<p class="contentName">累计充值金额<span class="contentTips">${totalRecharge}</span></p>
										</li>
										<li>
											<div class="contentPic">
												<img src="images/ljtx.png" />
											</div>
											<p class="contentName">累计提现金额<span class="contentTips">${totalCashWithdrawal}</span></p>
										</li>
										<%-- <li>
											<div class="contentPic">
												<img src="images/crfb.png" />
											</div>
											<p class="contentName">猫咪宝转余额金额（元）<span class="contentTips">${nowWithdrawMoney}元</span></p>
										</li>--%>
									</ul>
								</li>
							</ul>
						</div>
					</li>
					<%-- <li>
						<div class="contentPic">
							<img src="images/zcze.png" />
						</div>
						<p class="contentName">资产总额（元）<span class="contentTips">${totalAsset}元</span></p>
					</li>
					<li>
						<div class="contentPic">
							<img src="images/kyye.png" />
						</div>
						<p class="contentName">可用余额（元）<span class="contentTips">${availableBalance}元</span></p>
					</li>
					<li>
						<div class="contentPic">
							<img src="images/tzje.png" />
						</div>
						<p class="contentName">投资金额（元）<span class="contentTips">${investmentMoney}元</span></p>
					</li>
					<li>
						<div class="contentPic">
							<img src="images/tzje.png" />
						</div>
						<p class="contentName">猫咪宝金额（元）<span class="contentTips">${freedomMoney}元</span></p>
					</li> --%>
					<li><a href="<%=basePath%>autobid/toautobid">
						<div class="contentPic">
							<img src="images/zdtb.png" />
						</div>
						<p class="contentName">自动投标<span class="contentTips"><c:choose><c:when test="${autobidInfo==null || autobidInfo.status!=1}">去设置</c:when><c:otherwise>${autobidInfo.money}元</c:otherwise></c:choose><img src="images/go.png" class="go"/></span></p></a>
					</li>
					<%-- <li><a href="<%=basePath%>freedomsubject/toMyFreedom">
						<div class="contentPic">
							<img src="images/wdtz.png" />
						</div>
						<p class="contentName">我的猫咪宝<span class="contentTips">${freedomMoney}元<img src="images/go.png" class="go"/></span></p></a>
					</li> --%>
					
					<li><a href="<%=basePath%>redpackage/toSavings">
						<div class="contentPic">
							<img src="images/savings/cxg.png" />
						</div>
						<p class="contentName">猫咪储蓄<span class="contentTips">${sMoney }元<img src="images/go.png" class="go"/></span></p></a>
					</li>
					
					<li><a href="<%=basePath%>loginregister/invitingfriends">
						<div class="contentPic">
							<img src="images/yqhy.png" />
						</div>
						<p class="contentName">邀请好友<span class="contentTips"><img src="images/go.png" class="go"/></span></p></a>
					</li>
					<li><a href="<%=basePath%>scorecenter/gotoscorecenter">
						<div class="contentPic">
							<img src="images/yhk.png" />
						</div>
						<p class="contentName">我的鱼干<span class="contentTips">${accountScore}<img src="images/go.png" class="go"/></span></p></a>
					</li>
					<li><a href="<%=basePath%>investrecord/queryinvest">
						<div class="contentPic">
							<img src="images/wdtz.png" />
						</div>
						<p class="contentName">我的投资<span class="contentTips"><img src="images/go.png" class="go"/></span></p></a>
					</li>
					<li><a href="<%=basePath%>crowdfund/querymycrowfund">
						<div class="contentPic">
							<img src="images/wdtz.png" />
						</div>
						<p class="contentName">我的众筹<span class="contentTips"><img src="images/go.png" class="go"/></span></p></a>
					</li>

					<li><a href="<%=basePath%>capitaldetail/getAllCapitaldetail">
						<div class="contentPic">
							<img src="images/zjmx.png" />
						</div>
						<p class="contentName">资金明细<span class="contentTips"><img src="images/go.png" class="go"/></span></p></a>
					</li>
					<!-- <li><a href="<%=basePath%>bondTransfer/getBondTransfer">
						<div class="contentPic">
							<img src="images/zqrz.png" />
						</div>
						<p class="contentName">债权转让<span class="contentTips"><img src="images/go.png" class="go"/></span></p></a>
					</li> -->
					<%-- <li><a href="<%=basePath%>subject/s/querynextsubject">
						<div class="contentPic">
							<img src="images/crfb.png" />
						</div>
						<p class="contentName">次日发布标<span class="contentTips"><img src="images/go.png" class="go"/></span></p></a>
					</li> --%>
					<li><a href="<%=basePath%>safetySecurity.jsp">
						<div class="contentPic">
							<img src="images/aqbz.png" />
						</div>
						<p class="contentName">安全保障<span class="contentTips"><img src="images/go.png" class="go"/></span></p></a>
					</li>
					<li><a href="<%=basePath%>accountaddress/toaccountaddress">
						<div class="contentPic">
							<img src="images/shdz.png" />
						</div>
						<p class="contentName">收货地址<span class="contentTips"><img src="images/go.png" class="go"/></span></p>
					</li>
					<!-- <li><a href="<%=basePath%>autobid/queryautobid">
						<div class="contentPic">
							<img src="images/yhk.png" />
						</div>
						<p class="contentName">自动投标<span class="contentTips"><img src="images/go.png" class="go"/></span></p></a>
					</li> -->
					<li><a href="<%=basePath%>coupon/querycoupon">
						<div class="contentPic">
							<img src="images/yhq.png" />
						</div>
						<p class="contentName">优惠券<span class="contentTips">${myCoupon}<span style="color:#888;font-size:12px;">张可用</span><img src="images/go.png" class="go"/></span></p></a>
					</li>
					
					
					<!-- <li>
						<div class="contentPic">
							<img src="images/yhk.png" />
						</div>
						<p class="contentName">我的银行卡<span class="contentTips"><img src="images/go.png" class="go"/></span></p>
					</li> -->
					<div class="space">

					</div>
					<%-- <li><a href="javascript:querymessage()">
						<div class="contentPic">
							<img src="images/xx.png" />
						</div>
						<p class="contentName">消息列表<span class="contentTips">${noReadMessage}<span style="color:#888;font-size:12px;">条未读</span><img src="images/go.png" class="go"/></span></p></a>
					</li> --%>
					<li><a href="<%=basePath%>loginregister/s/goCustomer">
						<div class="contentPic">
							<img src="images/mmkf.png" />
						</div>
						<p class="contentName">我的客服<span class="contentTips"><img src="images/go.png" class="go"/></span></p></a>
					</li>
					<!-- <li>
						<div class="contentPic">
							<img src="images/gyjk.png" />
						</div>
						<p class="contentName">公益捐款<span class="contentTips"><img src="images/go.png" class="go"/></span></p>
					</li> -->
					
					<li onclick="outLogin()">
						<div class="contentPic">
							<img src="images/tcdl.png" />
						</div>
						<p class="contentName">退出登录<span class="contentTips"><img src="images/go.png" class="go"/></span></p>
					</li>
				</ul>
			</div>
			<input type="hidden" id="status" value="${autobidInfo.status }">
			
			<div class="xgn-mask" id="xgn-mask" style="display:none;position: fixed;top: 0;left: 0;bottom: 0;right: 0;">

			</div>
			<div class="xgn-con" id="xgn-con" style="display:none;position: fixed;">
				<p>温馨提示</p>
				<div>新功能<b>自动投标</b>已上线！请您设置相应的自动投标信息，以方便您进行更为方便快捷的投资！</div>
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th><a id="btn-iknow">我知道了</a></th>
						<th><a id="btn-gotoset">去设置</a></th>
					</tr>
					
				</table>
			</div>
	</div>
			
		<!-- 空白导航  防止被底部导航栏遮住内容 -->
		<jsp:include page="../navigation/emptyDiv.jsp" flush="true"/>
		<!-- 底部导航 -->
		
			<div class="footer">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="toChange(this,1)"><img src="images/tab_home_nor.png" /></th>
						<th onclick="toChange(this,2)"><img src="images/tab_touzi_nor.png" /></th>
						<th onclick="toChange(this,3)"><img src="images/tab_mall_nor.png" /></th>
						<th onclick="toChange(this,4)"><img src="images/tab_geren_sel.png" /></th>
					</tr>
					<tr>
						<td onclick="toChange(this,1)">首页</td>
						<td onclick="toChange(this,2)">投资</td>
						<td onclick="toChange(this,3)">商城</td>
						<td onclick="toChange(this,4)" class="currentChose">我</td>
					</tr>
				</table>
			</div>
			
	</body>
		<script src="js/accordion.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/help_content_inner.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/zoomify.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/capital/capital.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	if($.trim("${sessionScope.headimgurl}") != "")
    {
         $("#WXicon").attr("src","${headimgurl}");
    }else{
    	 $("#WXicon").attr("src","images/wx-vip-headpic-${accountLevel}.png");
    }
	
	function toSetting(){
		window.location.href='<%=basePath%>accountinfo/personalSettings';
	}
	
	function toSignin(){
		window.location.href='<%=basePath%>signin/toSignIn';
	}
	function toWithdraw(){
		window.location.href='<%=basePath%>withdraw/rechargeInfo';
	}
	function toRecharge(){
		window.location.href='<%=basePath%>recharge/rechargeInfo';
	}
	function toMessage(){
		window.location.href='<%=basePath%>message/querymessage';
	}
	function signin(){
		window.location.href='<%=basePath%>signin/toSignIn';
	}
	function querymessage(){
		window.location.href='<%=basePath%>message/querymessage';
	}
	function toAccountCenter(){
		window.location.href='<%=basePath%>accountCenter/queryAccountLevel';
	}
	
	//退出登录
	function outLogin()
	{
		if(confirm("确定退出登录吗？"))
		{
			window.location.href='<%=basePath%>loginregister/outLogin';
		}
	}
	//-------------------
	
	$(document).ready(function()
		{
		var status=$("#status").val();
		var res=document.cookie.indexOf("autobid=");
		if(res==-1)
		{
			if(status==""||status!=1)
			{
				$('.xgn-mask').css('height', $('.wrap').height());
				$('.xgn-mask').css("display","block");
				$('.xgn-con').css("display","block");
			}
		}

	});
		$('#btn-iknow').click(function () {
			$('.xgn-mask').hide();
			$('.xgn-con').hide();
			var oDate=new Date();
			oDate.setDate(oDate.getDate()+3);
			document.cookie="autobid=maomibank_auto_bid;expires="+oDate;
		});
		
		$('#btn-gotoset').click(function () {
			var oDate=new Date();
			oDate.setDate(oDate.getDate()+3);
			document.cookie="autobid=maomibank_auto_bid;expires="+oDate;
			window.location.href='<%=basePath%>autobid/toautobid';
		});
	</script>

</html>