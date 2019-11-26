<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML >
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<script type="text/javascript" src="js/subject/invest.js"></script>
<script type="text/javascript" src="js/subject/redpackage.js"></script>
<script src="js/layer/layer.js"></script>
<script src="js/checkgold/checkgold.js"></script>
<link rel="stylesheet" type="text/css" href="css/commonStyle.css" />
<title>立即投资</title>
	<style type="text/css">
			body {
				background-color: #F7F7F7;
			}
			
			#wrap {
				width: 100%;
			}
			
			#wrap p:nth-child(1) {
				font-size: 20px;
				color: #333333;
				background-color: white;
				text-align: center;
				line-height: 40px;
				width: 100%;
				padding: 0;
			}
			
			#wrap .tz-content {
				width: 100%;
				
			}
			
			#wrap .tz-content li {
				width:100%;
				height: 40px;
				background-color: white;
				/*padding-left: 10px*/
				text-indent: 10px;
				display: block;
			}
			
			#wrap .tz-content li:nth-child(1){
				height: 20px;
			}
			#wrap .tz-content li:nth-child(2){
				height: 30px;
			}
			#wrap .tz-content li:nth-child(3){
				height: 70px;
				font-size: 20px;
			}
			#wrap .tz-content li:nth-child(4){
				height: 70px;
				font-size: 20px;
			}
			#wrap .tz-content li:nth-child(5){
				height: 50px;
				font-size: 14px;
			}
			
			#wrap .tz-content li input {
				/*width: 90%;*/
				height: 30px;
				border: none;
			}
			input[type="text"]:focus {
				/*border:none;*/
				outline: none;
			}
			.yhqPic {
				width: 20px;
				height: 20px;
				position: absolute;
				top: 20px;
			}
			
			.yhq {
				margin-left: 30px;
			}
			
			.go {
				width: 20px;
				height: 30px;
				position: absolute;
				top: 15px;
				right:0px;
			}
			
			#wrap p:last-child {
				width: 100%;
			}
			
			.ljtz {
				width: 70%;
				margin-left: 15%;
				background-color: #FEC63D;
				height: 40px;
				border-radius: 5px;
				display: inline-block;
				line-height: 40px;
				text-align: center;
				color: white;
				margin-top: 25px;
			}
			
			.ljtz:active {
				position: relative;
				top: 1px;
			}
			
			.selectBox {
				margin-top: 15px;
				height: 60px;
				line-height: 50px;
				position: relative;
				border-bottom: 1px solid #EEEEEE;
			}
			
			.selectBox img {
				position: absolute;
				width: 30px;
				height: 30px;
				top: 8px;
			}
			
			.selectBox span:nth-child(2) {
				margin-left: 50px;
			}
			
			.selectBox span:nth-child(3) {
				color: #FF5500;
				float: right;
				margin-right: 40px;
			}
			
			.shouyiTips {
				font-size: 12px;
				color: #888;
				text-align: center;
			}
			.tips {
				padding: 12px;
				background-color: #f7ecd1;
			}
			
			#wrap .tips p:nth-of-type(1) {
				background-color: #f7ecd1;
				font-size: 14px;
				color: #616161;
				text-align: left;
				font-weight: 700;
				line-height:20px;
			}
			
			#wrap  .tips .tips-inner {
				font-size: 12px;
				color: #616161;
				background-color: #f7ecd1;
				line-height: 20px;				
			}
		
			/*红包*/
			
			.redP-mask {
				width: 100%;
				height: 100%;
				position: absolute;
				top: 0;
				left: 0;
				background-color: #BDbdbd;
				opacity: 0.8;
				display: none;
			}
			
			.redP-content {
				width: 80%;
				margin: 0 auto;
				height: 285px;
				text-align: center;
				background-image: url(images/savings/tz-redp-bg.png);
				background-position: center;
				background-size: 100% 100%;
				background-repeat: no-repeat;
				padding-top: 125px;
				position: absolute;
				left: 10%;
				top: 20%;
				display: none;
			}
			
			#wrap .redP-content li {
				height: 45px;
				line-height: 42px;
				margin: 20px 0;
			}
			
			#wrap .redP-content li:nth-child(1) {
				font-size: 16px;
				color: #fae468;
			}
			
			#wrap .redP-content li:nth-child(1) span {
				font-size: 18px;
				color: #fae468;
			}
			
			#wrap .redP-content li:nth-child(3) p {
				color: #ee423f;
				background-color: #ffe448;
				font-size: 16px;
			}
			
			#wrap .redP-content li:nth-child(4) p {
				color: #fff;
				background-color: #fe945d;
				font-size: 16px;
			}
			
			#wrap .redP-content p {
				width: 90%;
				margin: 0 auto;
				border-radius: 10px;
			}
			
			#wrap .redP-content li input {
				width: 90%;
				margin: 0 auto;
				height: 40px;
				background-color: white;
				border-radius: 10px;
				font-size: 12px;
				text-indent: 20px;
				border : none;
				outline : none;
				
			}
			#wrap .redP-content #redpmm{
				font-size : 30px;
			}
			
			
			.close-redp {
				width: 40px;
				height: 40px;
				margin-top: 20px;
			}
		</style>
		
		
		<script type="text/javascript">
			$(function(){
				showPromte();
				$('.redEnve-mask').css('height', $(window).height());
			});
			

			var vipRate=new Array(0.0,0.0,0.0,0.001,0.003,0.004,0.005,0.006,0.007,0.008,0.01);

			var memberRate = new Array(0.95,0.95,0.97,0.97,0.97,1,1,1,1,1,1);
			
			//展示收益
			function showPromte()
			{
				//用户等级
				var accountLevel = $('#accountLevel').val();
				//标的期限
				var subjectPeriods =$("#subjectPeriods").val();
				//期限类型(0:天 1:月 2:年)
				var subjectTerm = $("#subjectTerm").val();
				//还款方式(0:等额本息 1:先息后本 2:一次性还本付息)
				var repeatType = $("#repeatType").val();
				//利率
				var subjectRate = parseFloat($("#subjectRate").val())/100;
				//投标金额
				var inputMoney=parseFloat($("#iMoney").val());
				//优惠
				var cMoney;
				//优惠类型
				var cType = $("#couponType").val();
				//优惠券期限
				var interestDays = $('#interestDays').val();
				
				var interestType = $('#interestType').val();
				
				subjectRate = subjectRate+vipRate[accountLevel];
				
				
				if(''===$("#iMoney").val())
				{
					promote=0.0;
					inputMoney = 0.0;
				}
				
				var aId=$("#aId").val();
				if(''!=aId && null!==aId)
				{
					if('1'==cType)
					{
						//加息券
						cMoney=parseFloat($("#cMoney").val())/100;
						subjectRate=subjectRate+cMoney;
						
					}
					else if('5'!=cType)
					{
						//增值券
						cMoney=parseFloat($("#cMoney").val())/100;
						inputMoney=inputMoney+cMoney;
					}
				}
				
				
				var promote = 0;
				//判断还款方式
				if(repeatType==1){
					//先息后本
					
					//判断期限类型
					if(subjectTerm==1){
						//月标
						promote=subjectRate*inputMoney/12*subjectPeriods;
						if(interestDays!=null&&interestDays!=''&&parseInt(interestDays)!=-1&&parseInt(interestDays)<parseInt(subjectPeriods)){
							//优惠券为有期限并且不满期限
							
							//判断优惠券类型
							if('1'==cType)
							{
								//加息券
								
								//收益 = 利率 * 本金 /12 * 优惠券期限
								promote = subjectRate*inputMoney/12*interestDays;
								//去除优惠券
								subjectRate=subjectRate-cMoney;
								//收益 = 收益 +利率*本金/12*(标期限-优惠券期限)
								promote = promote+subjectRate*inputMoney/12*(subjectPeriods-interestDays);
							}
							else if('5'!=cType)
							{
								//增值券
								//收益 = 利率 * 本金 /12 * 优惠券期限
								promote = subjectRate*inputMoney/12*interestDays;
								
								//去除优惠券
								inputMoney=inputMoney-cMoney;
								//收益 = 收益 +利率*本金/12*(标期限-优惠券期限)
								promote = promote+subjectRate*inputMoney/12*(subjectPeriods-interestDays);
								
							}
						}
						
					}else{
						//天标
						promote=subjectRate*inputMoney/12/30*subjectPeriods;
						
						if(interestDays!=null&&interestDays!=''&&parseInt(interestDays)!=-1&&parseInt(interestDays)<parseInt(subjectPeriods)){
							//优惠券为有期限并且不满期限
							
							//判断优惠券类型
							if('1'==cType)
							{
								//加息券
								
								//收益 = 利率 * 本金 /12/30* 优惠券期限
								promote = subjectRate*inputMoney/12/30*interestDays;
								//去除优惠券
								subjectRate=subjectRate-cMoney;
								//收益 = 收益 +利率*本金/12/30*(标期限-优惠券期限)
								promote = promote+subjectRate*inputMoney/12/30*(subjectPeriods-interestDays);
							}
							else if('5'!=cType)
							{
								//增值券
								//收益 = 利率 * 本金 /12/30 * 优惠券期限
								promote = subjectRate*inputMoney/12/30*interestDays;
								//去除优惠券
								inputMoney=inputMoney-cMoney;
								//收益 = 收益 +利率*本金/12/30*(标期限-优惠券期限)
								promote = promote+subjectRate*inputMoney/12/30*(subjectPeriods-interestDays);
							}
						}
						
						
					}
					
				}else if(repeatType==0){
					//等额本息
					
					
					if(interestDays!=null&&interestDays!=''&&parseInt(interestDays)!=-1&&parseInt(interestDays)<parseInt(subjectPeriods)){
						//优惠券为有期限并且不满期限
						
						//判断优惠券类型
						if('1'==cType)
						{
							//加息券
							
							var returnPrincipal = inputMoney / subjectPeriods;
							//returnPrincipal = returnPrincipal.substring(0, returnPrincipal.indexOf("."));
							//promote=subjectRate*inputMoney/12*subjectPeriods;
							for(var i = 0 ;i<subjectPeriods;i++){
								//计算的收益本金
								var money = inputMoney - returnPrincipal * i;
								if(parseInt(interestDays)==i){
									subjectRate=subjectRate-cMoney;
								}
								promote = promote + money * subjectRate / 12;
							} 
						}
						else if('5'!=cType)
						{
							//增值券
							
							inputMoney=inputMoney-cMoney;
							
							var returnPrincipal = inputMoney / subjectPeriods;
							var returninputMoney = cMoney/interestDays;
							
							
							for(var i = 0 ;i<subjectPeriods;i++){
								//计算的收益本金
								if(parseInt(interestDays)==i){
									returninputMoney = 0;
									cMoney = 0;
								}
								
								var money = inputMoney+cMoney - (returnPrincipal+returninputMoney) * i;
								
								promote = promote + money * subjectRate / 12;
							}
							
							
						}
					}else{
						var returnPrincipal = inputMoney / subjectPeriods;
						//returnPrincipal = returnPrincipal.substring(0, returnPrincipal.indexOf("."));
						//promote=subjectRate*inputMoney/12*subjectPeriods;
						for(var i = 0 ;i<subjectPeriods;i++){
							//计算的收益本金
							var money = inputMoney - returnPrincipal * i;
							
							promote = promote + money * subjectRate / 12;
						}
					}
					
					
					
				}else if(repeatType==2){
					//到期还本付息
					
					//判断期限类型
					if(subjectTerm==1){
						//月标
						promote=subjectRate*inputMoney/12*subjectPeriods;
						
						if(interestDays!=null&&interestDays!=''&&parseInt(interestDays)!=-1&&parseInt(interestDays)<parseInt(subjectPeriods)){
							//优惠券为有期限并且不满期限
							
							//判断优惠券类型
							if('1'==cType)
							{
								//加息券
								
								//收益 = 利率 * 本金 /12 * 优惠券期限
								promote = subjectRate*inputMoney/12*interestDays;
								//去除优惠券
								subjectRate=subjectRate-cMoney;
								//收益 = 收益 +利率*本金/12*(标期限-优惠券期限)
								promote = promote+subjectRate*inputMoney/12*(subjectPeriods-interestDays);
							}
							else if('5'!=cType)
							{
								//增值券
								//收益 = 利率 * 本金 /12 * 优惠券期限
								promote = subjectRate*inputMoney/12*interestDays;
								//去除优惠券
								inputMoney=inputMoney-cMoney;
								//收益 = 收益 +利率*本金/12*(标期限-优惠券期限)
								promote = promote+subjectRate*inputMoney/12*(subjectPeriods-interestDays);
							}
						}
						
					}else{
						promote=subjectRate*inputMoney/365*subjectPeriods;
						if(interestDays!=null&&interestDays!=''&&parseInt(interestDays)!=-1&&parseInt(interestDays)<parseInt(subjectPeriods)){
							//优惠券为有期限并且不满期限
							
							//判断优惠券类型
							if('1'==cType)
							{
								//加息券
								
								//收益 = 利率 * 本金 /12 * 优惠券期限
								promote = subjectRate*inputMoney/365*interestDays;
								//去除优惠券
								subjectRate=subjectRate-cMoney;
								//收益 = 收益 +利率*本金/12*(标期限-优惠券期限)
								promote = promote+subjectRate*inputMoney/365*(subjectPeriods-interestDays);
							}
							else if('5'!=cType)
							{
								//增值券
								//收益 = 利率 * 本金 /12 * 优惠券期限
								promote = subjectRate*inputMoney/365*interestDays;
								//去除优惠券
								inputMoney=inputMoney-cMoney;
								//收益 = 收益 +利率*本金/12*(标期限-优惠券期限)
								promote = promote+subjectRate*inputMoney/365*(subjectPeriods-interestDays);
							}
						}
						
					}
				}
				
				//判断活动
				/* if(''!=aId && null!==aId)
				{
					if('5'==cType)
					{
						cMoney=parseFloat($("#cMoney").val())/100;
						//活动券
						promote = promote+(subjectRate*cMoney/12/31*7);
					}
				} */
				promote = promote*memberRate[accountLevel];
				
				promote=Math.floor(promote * 100) / 100; 
				
				
				
				
				$("#promotes").text(promote+"元");
			}
			
			//投标
			function doSubject()
			{
				var isRest = "<%=request.getAttribute("isRisk")%>"; 
				
				//检查用户有没有进行风险测试
				if(isRest == 0){
					if(confirm("请先去填写风险测试！")) 
					{
						//获取当前url,将url存入session
						var url = window.location.href;
						
						window.location.href='<%=basePath%>accountinfo/torisktest?url=' + url;
					}else{
						return;
					}
				}
				
				//获取页面投标金额
				var smoney=$("#iMoney").val();
				var money;
				if(smoney==""||smoney==null)
				{
					money=0;
				}
				else
				{
					money=parseInt($("#iMoney").val());
				}
				
				//标余额
				var subjectOverplusMoney=parseFloat($("#subjectOverplusMoney").val());
				//用户余额
				var balance=parseFloat($("#balance").val());
				//类型
				var couponType = $("#couponType").val();
				//起投金额
				var subjectStartingMoney = parseInt($("#subjectStartingMoney").val());
				var sId=$("#sId").val();
				var aId=$("#aId").val();
				if(null ==smoney || ''==smoney)
				{
					if(couponType=="" || couponType==null || "2"!=couponType)
					{
						alert("请输入金额");	
						return;
					}
				}
				else 
				{
					if(!verifyVals(smoney,"integerValue","金额")){
						return;
					}
				}
				//如果使用优惠券  先做一步提示语
				if(''!=aId && aId !=null)
				{
					if(confirm("您确认立即使用优惠券投标吗？")) 
					{
						//form.submit();
						var index=layer.load();
						investSubject();
					}
				}
				//如果没有使用优惠券   直接提交
				else
				{
					if(confirm("您确认立即投标吗？")) 
					{
						//form.submit();
						var index=layer.load();
						investSubject();
					}
				}
			}
		
		//立即投标 ajax提交
		function investSubject()
		{
			var smoney=$("#iMoney").val();
			var sId=$("#sId").val();
			var aId=$("#aId").val();
			var msg=",您是企业用户首次投标，将获得28元奖励金到您银行卡，1~3个工作日到账";
			var amsg="";
			$.ajax({
				url:"<%=basePath%>subject/checkMoney",
				type: "POST",
				data : {
					additionalId:aId,
					subjectId:sId,
					money:smoney
				},
				dataType:"json",
				success:function(data){
					
					layer.closeAll();
					if(data.result==='querynewsubject'){
						if(data.flag==='isflag')
						{
							alert("新手专享投标成功"+msg);
							if(data.resultC === "addsuccess"){
								redpackage();
							}
							else
							{
								window.location.href='<%=basePath%>subject/s/querynewsubject';
							}
							
						}
						else
						{
							
							alert("新手专享投标成功");
							if(data.resultC === "addsuccess"){
								redpackage();
							}
							else
							{
								window.location.href='<%=basePath%>subject/s/querynewsubject';
							}
							
						}								
					}
					else if(data.result==='querysubject'){
						if(data.flag==='isflag')
						{
							
							alert("精选理财投标成功"+msg);
							if(data.resultC === "addsuccess"){
								redpackage();
							}
							else
							{
								window.location.href='<%=basePath%>subject/s/querysubject';
							}
							
						}
						else
						{
							
							alert("精选理财投标成功");
							if(data.resultC === "addsuccess"){
								redpackage();
							}
							else
							{
								window.location.href='<%=basePath%>subject/s/querysubject';
							}
							
						}
						
					}
					else if(data.result==='queryhighsubject'){
						if(data.flag==='isflag')
						{
							alert("爆款投标成功"+msg);
							if(data.resultC === "addsuccess"){
								redpackage();
							}
							else
							{
								window.location.href='<%=basePath%>subject/s/queryhighsubject';
							}
							
						}
						else
						{
							alert("爆款投标成功");
							if(data.resultC === "addsuccess"){
								redpackage();
							}
							else
							{
								window.location.href='<%=basePath%>subject/s/queryhighsubject';
							}
							
						}
					}
					else if(data.result=="errorLowMoney")
					{
						alert("余额不足");
					}
					else if(data.result==='errorSubject')
					{
						alert("标余额不足！");
					}
					else if(data.result==='errorLow')
					{
						if(confirm("余额不足，是否充值"))
						{
							window.location.href='<%=basePath%>recharge/rechargeInfo';
						}							
					}
					else if(data.result==='errorLowStart')
					{
						alert("投标金额不能低于起投金额");
					}
					else if(data.result==='errorStartFull')
					{
						alert("投标金额必须是起投金额整数倍");
					}
					else if(data.result==='errorNewSubjectLimit')
					{
						alert("新手标限投一万元");
					}
					else if(data.result==='errorCoupon')
					{
						alert("优惠券已被使用");
					}
					else if(data.result==='errorLimitMoney')
					{
						alert("投资1000元以上可以使用高温补贴金！");
					}
					else if(data.result==='errorFirstCompany')
					{
						alert("企业用户第一次限投${countCompanyMoney}元");
					}
					else if(data.result==='errorLimitTodayMoney')
					{
						alert("当日限投${subjectLimitTodayMoney}元");
					}
					else if(data.result==='errorStartMoney')
					{
						alert("投资金额少于优惠券起投金额");
					}
					else if(data.result==='errorCouponType')
					{
						alert("优惠券不适用于该标");
					}
					else if(data.result==='sendgift'){
						
					}
				}
				});
	
		}
		
		function toBack()
		{
			var form = document.forms['form1'];
			form.action = '<%=basePath%>subject/detailsubject';
			form.submit();
		}
	
		//选择优惠券
		function toChooseIt(counts)
		{
			var isLimit=$("#isLimit").val();
			if(isLimit=='1')
			{
				alert("本标不支持使用优惠券");
			}
			else if(counts==0)
			{
				if(confirm("暂无优惠券可用！是否获取优惠券？"))
				{
					window.location.href='<%=basePath%>awardrotate/gotoawardrotate';
				}
			}
			else
			{
				var iMoney = $("#iMoney").val();
				$("#inputMoney").val(iMoney);
				$("#chooseItForm").submit();	
			}
		}
		
		//获得当前月天数
		function mGetDate(){
		     var date = new Date();
		     var year = date.getFullYear();
		     var month = date.getMonth()+1;
		     var d = new Date(year, month, 0);
		     return d.getDate();
		}
		
		
</script>
</head>

<body>
	<form action="<%=basePath%>subject/querymycoupon" method="post" id="chooseItForm">
		<input type="hidden" id="inputMoney" name="inputMoney" value="" />
		<input type="hidden" id="subjectId" name="subjectId" value="${subjectBean.subjectId}" />
	</form>
	<form action="" id="form1">
		<input type="hidden" id="sId" name="subjectId" value="${subjectBean.subjectId}" />
		<input type="hidden" id="subjectOverplusMoney" value="${subjectBean.subjectOverplusMoney}" />
		<input type="hidden" id="subjectTerm" value="${subjectBean.subjectTerm}" />
		<input type="hidden" id="isLimit" value="${subjectBean.isLimit}" />
		<input type="hidden" id="subjectPeriods" value="${subjectBean.subjectPeriods}" />
		<input type="hidden" id="repeatType" value="${subjectBean.repeatType}" />
		<input type="hidden" id="balance" value="${balance}" />
		<input type="hidden" id="aId" value="${couponBeans.additionalId}" />
		<input type="hidden" id="cMoney" value="${couponBeans.couponMoney}" />
		<input type="hidden" id="couponType" value="${couponBeans.couponType}" />
		<input type="hidden" id="interestDays" value="${couponBeans.interestDays}" />
		<input type="hidden" id="interestType" value="${couponBeans.interestType}" />
		
		<input type="hidden" id="subjectStartingMoney" value="${subjectBean.subjectStartingMoney}" />
		<input type="hidden" id="subjectRate" value="${subjectBean.subjectRate}" />
		<input type="hidden" id="redp" value="${money }" />
		<input type="hidden" id="savings" value="" />
		<input id="basePath" type="hidden" value="<%=basePath%>"/>
		<c:if test="${!empty sessionScope.account}">
			<input type="hidden" id="accountLevel" value="${sessionScope.account.accountLevel}">
		</c:if>
		<c:if test="${empty sessionScope.account}">
			<input type="hidden" id="accountLevel" value="0">
		</c:if>
		<div id="wrap">
			<p><img src="<%=basePath%>images/back.png" class="back" onclick="toBack()"/>投资操作</p>
			<ul class="tz-content">
				<li style="text-align: center;font-size: 12px;color: #808080;padding-top: 15px;background-color: #F7F7F7;">实际投资收益</li>
				<li style="text-align: center;font-size: 22px;color: #333;padding-top: 10px;padding-bottom:10px;background-color: #F7F7F7;" id="promotes">0.0</li>
				<li style="border-bottom: 1px solid #E5E5E5;font-size: 50px;">
					<span style="font-size: 30px;line-height: 70px;">¥<input style="padding-left:10px;font-size:20px;" type="text" name="" id="iMoney" value="${iMoney }" placeholder='请输入<fmt:formatNumber type="number" value="${subjectBean.subjectStartingMoney}" maxFractionDigits="0"></fmt:formatNumber>整数倍' onkeyup="value=value.replace(/[^\d]/g,''),showPromte()"onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/></span>
				</li>
				<li style="text-align: left;font-size: 15px;color: #333;">
					<span style="line-height: 70px;">账户余额:${balance}元</span>
				</li>

				<c:if test="${subjectBean.isLimit!=1}">
				<li class="selectBox" onclick="toChooseIt(${countCoupon})">
					<img src="images/xzyhq.png" />
					
						
					<c:choose>
						<c:when test="${empty couponBeans.couponName}">
						<span>
							暂未选择优惠券
							</span>
								<span>${countCoupon}张可用</span>
						</c:when>
						<c:otherwise>
							<span>
							${couponBeans.couponName}
							</span>
						</c:otherwise>
					</c:choose>
					
					<img src="images/go.png" class="go" />
				</li>
				</c:if>
			</ul>
			<div class="tips">
				<p>温馨提示： </p>
				<c:choose>
					<c:when test="${subjectBean.isLimit==0}">
						<p class="tips-inner">此标优惠券（体验金，增值券，加息券，以下优惠券皆指这三种）使用权限属于"无限制"，使用优惠券只需满足如下条件之一： </p>
						<p class="tips-inner">1.无计息期限的优惠券。 </p>
						<p class="tips-inner">2.计息期限为<c:if test="${subjectBean.subjectTerm==0}">天</c:if><c:if test="${subjectBean.subjectTerm==1}">月</c:if><c:if test="${subjectBean.subjectTerm==2}">年</c:if>的优惠券。 </p>
					</c:when>
					
					<c:when test="${subjectBean.isLimit==1}">
						<p class="tips-inner">此标优惠券使用权限属于"限制所有"，故不可以使用优惠券 。</p>
					</c:when>
					
					<c:when test="${subjectBean.isLimit==2}">
						<p class="tips-inner">此标优惠券使用权限属于"部分限制"，使用优惠券只需满足如下条件之一： </p>
						<p class="tips-inner">1.无计息期限的优惠券 。</p>
						<p class="tips-inner">2.有计息期限，但优惠券计息期限必须是${str}之一。 </p>
					</c:when>
				</c:choose>
				
				
				
			</div>
			<p>
				<a href="javascript:doSubject();" class="ljtz" >立即投资</a>
				
			</p>
			<div class="redP-mask">

			</div>
			<div class="redP-content">
				<ul>
					<li>
					
					<!-- <input type="text" id="redPackNum" value="" readonly="readonly"/> -->
					<span></span><span id="redpmm"></span>
					<span>元</span></li>
					
					<li><input type="text" name="friendtelephone" id="friendtelephone" value="" placeholder="请输入好友手机号" /></li>
					<li onclick="givefriend(0)">
						<p class="sendToFriend">立即赠送</p>
					</li>
					<li onclick="redpackageopen(0)">
						<p>存入钱罐</p>
					</li>
				</ul>
				<img src="images/savings/tz-redp-close.png" class="close-redp" onclick="gosubject()"/>
			</div>
		</div>
		<!-- <div class="redEnve-mask">

			</div>
			<div class="redEnve">
				<img src="images/redE-before.png" id="rotare1" />
				<p id="redEnve-tips"></p>
			</div> -->
		
	</form>
</body>
<script type="text/javascript">
	
	function chooseIt(id,couponType){
		var a1 = $("#"+id);
		var cou =$("#cou"+id);
		var cType=$("#couponType").val();
		var aId=$("#aId").val();
		if(""==aId || null==aId || aId!=id)
		{
			$(".youhuiquan").each(function(){
				$(this).css("border-color","");
			});
			$(".youhuiquan").find("th").each(function(i){
				if(i%4==3){
					$(this).css('opacity','0');
				}
				
			});
			cou.css('opacity','1');
			a1.css('border-color','red');
			$("#aId").val(id);
			$("#couponType").val(couponType)
		}
		else
		{
			$(".youhuiquan").each(function(){
				$(this).css("border-color","");
			});
			$(".youhuiquan").find("th").each(function(i){
				if(i%4==3){
					$(this).css('opacity','0');
				}
				
			});
			$("#aId").val("");
			$("#couponType").val("");
		}
	}
	/* 
	function redEnvelope() {
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
		$("#rotare1").click(function() {
			if(offOn) {
				rotating1();
				offOn = false;
				setTimeout(function() {
					window.location.href="./activity/s/yuandanActivity";
				}, 6000)
				
			}

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
	} */
</script>
</html>
