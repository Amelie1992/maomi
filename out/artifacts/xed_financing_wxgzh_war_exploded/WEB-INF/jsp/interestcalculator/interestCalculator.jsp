<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML >
<html>
<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/validate.js" type="text/javascript" charset="utf-8"></script>
		<title>利息计算器</title>
		<style type="text/css">
			body {
				background-color: #F2F2F2;
			}
			
			.wrap {
				padding: 10px;
			}
			
			.head-box {
				position: fixed;
				top: 0;
				left: 0;
				width: 100%;
				text-align: center;
				background-color: white;
				margin-bottom: 20px;
				border-bottom: 1px solid #E0E0E0;
			}
			
			.head-box-tips-2 {
				color: #F95D18;
			}
			
			.head-box-tips-1 {
				color: #212121;
				font-size: 14px;
			}
			
			.head-box p:nth-of-type(1) {
				padding: 30px 0 12px 0;
			}
			
			.head-box p:nth-of-type(2) {
				font-size: 24px;
				font-weight: bold;
			}
			
			.head-box table {
				width: 100%;
				text-align: center;
			}
			
			.head-box table th {
				line-height: 30px;
				padding-top: 20px;
				padding-bottom: 10px;
			}
			
			.head-box table td {
				color: #F95D18;
				padding-bottom: 20px;
			}
			
			.bid-type {
				width: 100%;
				background-color: white;
				margin-top: 180px;
				margin-bottom: 20px;
			}
			
			.bid-type p {
				padding: 12px 0 15px 12px;
				font-size: 14px;
				color: #212121;
			}
			
			.bid-type table {
				width: 100%;
			}
			
			.bid-type table th {
				height: 40px;
				width: 33.3%;
				padding: 10px 0;
			}
			
			.bid-type table th span {
				display: inline-block;
				width: 90%;
				text-align: center;
				padding: 10px 0;
				border: 1px solid #E0E0E0;
			}
			.bid-type table th span select{
				width: auto;
				padding: 0 1%;
				border: none;
				outline: none;
				text-align: center;
				line-height: 15px;
				background-color: white;
				border: none;
            	appearance:none;
            	-moz-appearance:none;
            	-webkit-appearance:none;
			}
            .currentSelect{
            	border: 1px solid #F95D18 !important;
            	color: #F95D18;
            }
            .pay-type{
            	width: 100%;
				background-color: white;
				margin-bottom: 20px;
            }
             .pay-type p {
				padding: 12px 0 15px 12px;
				font-size: 14px;
				color: #212121;
			}
			
			 .pay-type table {
				width: 100%;
			}
			
			 .pay-type table th {
				height: 40px;
				width: 33.3%;
				padding: 10px 0;
			}
			
			 .pay-type table th span {
				display: inline-block;
				width: 90%;
				text-align: center;
				padding: 10px 0;
				border: 1px solid #E0E0E0;
			}
			.vip{
				width: 100%;
				background-color: white;
			}
			.vip p:nth-child(1){
				color: #F95D18;
				font-size: 14px;
				padding: 12px 0 15px 12px;
				/*line-height: 50px;*/
			}
			.vip p:nth-child(1) span{
				float: right;
				margin-right: 12px;
			}
			.vip li{
				width: 100%;
				height: 50px;
				border-bottom: 1px solid #E0E0E0;
				position: relative;
			}
			.vip li input{
				width: 100%;
				height: 100%;
				border: none;
				outline:none;
				text-indent: 20px;
			}
			.vip li span{
				position: absolute;
				top: 20px;
				right: 12px;
			}
			.vip a{
				display: inline-block;
				width: 100%;
				text-align: center;
				margin: 0 auto;
				padding: 20px 0;
				color: #F95D18;
				
			}
			.btns{
				width: 100%;
				overflow: hidden;
			}
			.btns div{
				width: 45%;
				text-align: center;
				padding: 12px 0;
			}
			.btns-count{
				float: left;
				margin-left: 12px;
				color: white;
				background-color: #F95D18;
			}
			.btns-reset{
				float: right;
				margin-right: 12px;
				color: white;
				background-color: #BDBDBD;
			}
			.bid-type-nouse{
				background-color: #757575;
				color: white;
			}
		</style>
	</head>

<body>
			<div class="wrap">
			<div class="head-box">
				<p class="head-box-tips-1">实际收益(元)</p>
				<p class="head-box-tips-2" id="cc">0元</p>
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>利息收入(元)</th>
						<th>VIP奖励(元)</th>
						<th>利息管理费(元)</th>
					</tr>
					<tr>
						<td id="bb">0元</td>
						<td id="aa">0元</td>
						<td id="dd">0元</td>
					</tr>
				</table>
			</div>
			<form action="<%=basePath%>interestCalculator/s/toRepaymentPlan" id="repaymentPlan" method="post"> 
			<input type="hidden" id="investMoneys" name="investMoney" value=""  />
			<input type="hidden" id="subjectRates" name="subjectRate" value=""  />
			<input type="hidden" id="subjectTerms" name="subjectTerm" value=""  />
			<input type="hidden" id="subjectPeriodss" name="subjectPeriods" value=""  />
			<input type="hidden" id="vipRates" name="vipRate" value=""  />
			<input type="hidden" id="repeatTypes" name="repeatType" value=""  />
			<input type="hidden" id="accountLevels" name="accountLevel" value=""  />
			</form>
			<form action=""  id="content">
			<div class="bid-type">
				<p>请选择标类型和VIP等级</p>
				<table border="0" cellspacing="" cellpadding="" id="monthchoose">
					<tr>
						<th>
							<span class="currentSelect" onclick="month(this)">月标</span>
						</th>
						<th>
							<span onclick="day(this)">天标</span>
						</th>
						<th>
							<span>
								<select name="accountLevel" id="accountLevel" onchange="vip(this)">
								<option value="0">VIP0</option>
								<option value="0">VIP1</option>
								<option value="0">VIP2</option>
								<option value="0.1">VIP3</option>
								<option value="0.3">VIP4</option>
								<option value="0.4">VIP5</option>
								<option value="0.5">VIP6</option>
								<option value="0.6">VIP7</option>
								<option value="0.7">VIP8</option>
								<option value="0.8">VIP9</option>
								<option value="1">VIP10</option>
							</select>
							</span>

						</th>
					</tr>

				</table>
			</div>
			<div class="pay-type">
				<p>请选择还款方式</p>
				<table border="0" cellspacing="" cellpadding="" id="currentTable">
					<tr>
						<th>
							<span onclick="current(this)" class="currentSelect">等额本息</span>
						</th>
						<th>
							 <span onclick="current(this)">先息后本</span>
						</th>
						<th>
							<span onclick="current(this)">到期还本付息</span>
						</th>
					</tr>

				</table>
			</div>
			<div class="vip">
				<p>VIP奖励 <span>%</span><span id="vipRate">0</span></p>
				<ul>
					<li>
						<input type="text" name="investMoney" id="investMoney" value="" placeholder="请输入投资金额"/>
						<span>元</span>
					</li>
					<li>
						<input type="text" name="subjectRate" id="subjectRate" value="" placeholder="请输入年化利率"/>
						<span>%</span>
					</li>
					<li>
						<input type="text" name="subjectPeriods" id="subjectPeriods" value="" placeholder="请输入投资期限"/>
						<span id="time">月</span>
					</li>
				</ul>

				<a href="javaScript:void(0);" onclick="repaymentplan()"><u>点击查看还款计划</u> </a>
				<div class="btns">
					<div class="btns-count" onclick="jisuan()">计算</div>
					<div class="btns-reset" onclick="reset()">重置</div>
				</div>
			</div>
			</form>
		</div>
	</body>
	<script type="text/javascript">
		
		function vip(sel){
			/* document.getElementById('vipRate').value=sel.options[sel.selectedIndex].value; */
			$("#vipRate").text(sel.options[sel.selectedIndex].value);
		}
		
		function current(obj){
			$('#currentTable span').removeClass('currentSelect');
			$(obj).addClass('currentSelect');
		};
		
		function day(obj){
			$("#time").text("天");
			$("#currentTable span").removeClass('currentSelect');
			$("#currentTable span:eq(2)").addClass('currentSelect');
			$("#currentTable span[class!='currentSelect']").addClass('bid-type-nouse').removeAttr('onclick');
			$("#monthchoose span").removeClass('currentSelect');
			$(obj).addClass('currentSelect');
		}
		
		function month(obj){
			$("#time").text("月");
			$("#currentTable span").removeClass('bid-type-nouse').attr('onclick','current(this)').removeClass('currentSelect');
			$("#currentTable span:eq(0)").addClass('currentSelect');
			$("#monthchoose span").removeClass('currentSelect');
			$(obj).addClass('currentSelect');
		}
		
		function reset(){
			$("#content")[0].reset();
			month();
			$("#monthchoose span:eq(0)").addClass('currentSelect');
		}
		
		//投资金额
		var investMoney;
		//年化利率
		var subjectRate;
		//借款类型
		var subjectTerm;
		//借款时长
		var subjectPeriods;
		//vip奖励
		var vipRate;
		//还款方式
		var repeatType;
		//用户等级
		var accountLevel
		function jisuan(){
			//投资金额
			investMoney=$("#investMoney").val();
			//年化利率
			subjectRate=$("#subjectRate").val();
			//借款类型
			if($("#monthchoose span:eq(0)").hasClass('currentSelect')){
				subjectTerm=1;
			}else{
				subjectTerm=0;
			}
			//借款时长
			subjectPeriods=$("#subjectPeriods").val();
			//vip奖励
			vipRate=$("#vipRate").text();
			//还款方式
			if($("#currentTable span:eq(0)").hasClass('currentSelect')){
				repeatType=0;
			}else if($("#currentTable span:eq(1)").hasClass('currentSelect')){
				repeatType=1;
			}else{
				repeatType=2;
			}
			accountLevel=$("#accountLevel").find("option:selected").text();
			if(investMoney==""){
				alert('请输入投资金额');
				return;
			}
			if(subjectRate==""){
				alert('请输入年化利率');
				return;
			}
			if(subjectPeriods==""){
				alert('请输入投资时长');
				return;
			}
			if(!verifyValNoMsg(investMoney,'integerValue') || investMoney%100!=0){
				alert('投资金额请输入100的倍数');
				return;
			}
			if(!verifyValNoMsg(subjectRate,'rateValue') || subjectRate<1 || subjectRate>36){
				alert('年化利率请输入1~36之间的数值');
				return;
			}
			if(subjectTerm==1){
				if(!verifyValNoMsg(subjectPeriods,'integerValue') || subjectPeriods>36){
					alert('月标投资时长请输入1~36之间的正整数');
					return;
				}
			}else{
				if(!verifyValNoMsg(subjectPeriods,'integerValue') || subjectPeriods>90){
					alert('天标投资时长请输入1~90之间的正整数');
					return;
				}
			}
			$.ajax({
				url:"<%=basePath%>interestCalculator/s/jisuan",
				type : "POST",
				data : {
					investMoney: investMoney,
					subjectRate:subjectRate,
					subjectTerm:subjectTerm,
					subjectPeriods:subjectPeriods,
					vipRate:vipRate,
					repeatType:repeatType,
					accountLevel:accountLevel
				},
				success:function(data){
					var a = eval('('+data+')');
					$("#aa").text(a.vipMoney+'元');
					$("#bb").text(a.sumlixi+'元');
					$("#cc").text(a.realIncome+'元');
					$("#dd").text(a.interestManagementFee+'元');
				}
			});
	  }
		
		function repaymentplan(){
			//投资金额
			investMoney=$("#investMoney").val();
			//年化利率
			subjectRate=$("#subjectRate").val();
			//借款类型
			if($("#monthchoose span:eq(0)").hasClass('currentSelect')){
				subjectTerm=1;
			}else{
				subjectTerm=0;
			}
			//借款时长
			subjectPeriods=$("#subjectPeriods").val();
			//vip奖励
			vipRate=$("#vipRate").text();
			//还款方式
			if($("#currentTable span:eq(0)").hasClass('currentSelect')){
				repeatType=0;
			}else if($("#currentTable span:eq(1)").hasClass('currentSelect')){
				repeatType=1;
			}else{
				repeatType=2;
			}
			accountLevel=$("#accountLevel").find("option:selected").text();
			if(investMoney==""){
				alert('请输入投资金额');
				return;
			}
			if(subjectRate==""){
				alert('请输入年化利率');
				return;
			}
			if(subjectPeriods==""){
				alert('请输入投资时长');
				return;
			}
			if(!verifyValNoMsg(investMoney,'integerValue') || investMoney%100!=0){
				alert('投资金额请输入100的倍数');
				return;
			}
			if(!verifyValNoMsg(subjectRate,'rateValue') || subjectRate<1 || subjectRate>36){
				alert('年化利率请输入1~36之间的数值');
				return;
			}
			if(subjectTerm==1){
				if(!verifyValNoMsg(subjectPeriods,'integerValue') || subjectPeriods>36){
					alert('月标投资时长请输入1~36之间的正整数');
					return;
				}
			}else{
				if(!verifyValNoMsg(subjectPeriods,'integerValue') || subjectPeriods>90){
					alert('天标投资时长请输入1~90之间的正整数');
					return;
				}
			}
			$("#investMoneys").val(investMoney);
			$("#subjectRates").val(subjectRate);
			$("#subjectTerms").val(subjectTerm);
			$("#subjectPeriodss").val(subjectPeriods);
			$("#vipRates").val(vipRate);
			$("#repeatTypes").val(repeatType);
			$("#accountLevels").val(accountLevel);
			//提交form表单
			$("#repaymentPlan").submit();
		}	
	</script>
</html>
