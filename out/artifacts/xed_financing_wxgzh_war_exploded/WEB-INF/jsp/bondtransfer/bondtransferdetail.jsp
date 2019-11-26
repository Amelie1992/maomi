<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/bondtransfer/bondtransferdetail.css" />
<title>债权转让详情</title>
</head>

<body>
<form action="<%=basePath%>investrecord/toContract" method="post" id="contractForm">
		<input type="hidden" value="" id="iid" name="investId" />
		<input type="hidden" value="" id="sid" name="subjectId" />
		<input type="hidden" value="" id="type" name="type" />
	</form>
	<div class="wrap">
			<div class="title">
				<input type="hidden" value="${cBena.creditId}" id="creditId">
				<img src="images/back.png" class="back" onclick="goBack()"/>${cBena.subjectName}
			</div>
			<div class="content">
				<h4>参考年回报率(%)</h4>
				<h4>${cBena.creditRate}</h4>
				<div class="contentTips">
					<div>
						<p style="font-size: 25px;">${cBena.accountInvest.endTime}</p>
						<p style="line-height: 40px;">结束时间</p>
					</div>
					<div>
						<p style="font-size: 25px; border-left: 1px solid white;">${cBena.creditMoney+cBena.dealMoney }<span>元</span></p>
						<p style="line-height: 40px;border-left: 1px solid white;">本金+垫付金额</p>
					</div>
				</div>

			</div>
			<ul>
				<li>
					<span class="content-left">原预期年化利率:</span>
					<span class="content-right">${cBena.accountInvest.subjectRate}%</span>
				</li>
				<li>
					<span class="content-left">现预期年化利率:</span>
					<span class="content-right">${cBena.creditRate}%</span>
				</li>
				<li>
					<span class="content-left">承接总额:</span>
					<span class="content-right">${cBena.creditMoney}元</span>
				</li>
				<li>
					<span class="content-left">垫付金额:</span>
					<span class="content-right">${cBena.dealMoney}元</span>
				</li>
				<li>
					<span class="content-left">结束时间:</span>
					<span class="content-right">${cBena.accountInvest.endTime}</span>
				</li>
				<li>
					<span class="content-left">还款方式:</span>
					<span class="content-right">
					<c:if test="${'0'==cBena.accountInvest.repeatType}">
					等额本息
						<c:if test="${'0'==cBena.accountInvest.isDayProfit}">(月付)</c:if>
						<c:if test="${'1'==cBena.accountInvest.isDayProfit}">(日付)</c:if>
					</c:if>
					<c:if test="${'1'==cBena.accountInvest.repeatType}">
					先息后本
						<c:if test="${'0'==cBena.accountInvest.isDayProfit}">(月付)</c:if>
						<c:if test="${'1'==cBena.accountInvest.isDayProfit}">(日付)</c:if>
					</c:if>
					<c:if test="${'2'==cBena.accountInvest.repeatType}">
					到期还本付息
						<%-- <c:if test="${'0'==cBena.accountInvest.isDayProfit}">(月付)</c:if>
						<c:if test="${'1'==cBena.accountInvest.isDayProfit}">(日付)</c:if> --%>
					</c:if>
					</span>
				</li>
			</ul>
			<c:if test="${cBena.outAccountId!=cBena.inAccountId}">
				<c:if test="${cBena.accountInvest.investStatus!=2}">
					<div class="tips">
						<!--默认选中给下面的class变成 xz  未选择class 是wxz-->
						<span id="xz" class="wxz" onclick="changeStatus()"></span>
						<span>我已阅读并同意 <a href="javascript:toTransferConstact(${cBena.investId},0);"> 《债权转让协议》 </a></span>
					</div>
					<span id="cjBtn" class="cjBtn">立即承接</span>
				</c:if>
				<c:if test="${cBena.accountInvest.investStatus==2}">
					<div class="tips"></div>
					<span id="cjBtn" class="cjBtn">已转让成功</span>
				</c:if>
			</c:if>
			<c:if test="${cBena.outAccountId==cBena.inAccountId}">
				<div class="tips"></div>
				<span id="cjBtn" class="cjBtn">我的债权</span>
			</c:if>
		</div>
		
</body>
<script type="text/javascript">
	//默认未选择  按钮置灰
	$(document).ready(function() {
		$("#cjBtn").attr("onclick", ""); 
		$("#cjBtn").css("background-color", "#888");
	});
	
	//返回
	function goBack(){
		window.location.href='<%=basePath%>bondTransfer/getBondTransfer';
	}
	
	//更改选择状态
	function changeStatus()
	{
		var xzclass=$("#xz").attr('class');
		if(xzclass=="wxz")
		{
			$("#xz").removeClass("wxz");
			$("#xz").addClass("xz");
			$("#cjBtn").attr("onclick", "transfer()");
			$("#cjBtn").css("background-color", "#Feb73b"); 
		}
		else
		{
			$("#xz").removeClass("xz");
			$("#xz").addClass("wxz");
			$("#cjBtn").attr("onclick", ""); 
			$("#cjBtn").css("background-color", "#888"); 
		}
	}
	
	//立即承接
	function transfer(){
		var creditId = $('#creditId').val();
		
			$.ajax({
				url:"<%=basePath%>bondTransfer/transferBonds",
				type: "POST",
				data : {
					creditId : creditId
				},
				success:function(data){
					var a =  eval(data);
					if(a.result==='success'){
						alert('债权承接成功');
						if(typeof(a.jizi)!='undefined'){
							var zi = '';
							if(a.jizi==='1'){
								zi = '举';
							}else if(a.jizi==='2'){
								zi = '国';
							}else if(a.jizi==='3'){
								zi = '欢';
							}else if(a.jizi==='4'){
								zi = '庆';
							}
							//alert('意外惊喜,恭喜您在七夕集字活动中成功获得"' + zi + '"字,请去活动页面查看');
							if(confirm('意外惊喜,恭喜您在国庆集字活动中成功获得"' + zi + '"字,是否前往活动页面查看'))
							{
								window.location.href='<%=basePath%>activity/s/goactivity';
							}
							else{
								window.location.href='<%=basePath%>bondTransfer/getBondTransfer';
							}
						}
						else{
							window.location.href='<%=basePath%>bondTransfer/getBondTransfer';
						}
					}else if(a.result==='error'){
						alert("系统错误");
					}else if(a.result==='insufficient'){
						alert("余额不足");
						window.location.href='<%=basePath%>recharge/rechargeInfo';
					}else if(a.result==='unable'){
						alert("您来晚了,该标已结束或被他人承接");
						window.location.href='<%=basePath%>bondTransfer/getBondTransfer';
					}
				}
			});
		};
		
		//去债权转让协议
		function toTransferConstact(investId,type)
		{
			$("#iid").val(investId);
			$("#type").val(type);
			$("#contractForm").attr("action","./investrecord/transfercontract").submit();
		}
		
</script>

</html>
