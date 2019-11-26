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
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<script src="js/layer/layer.js"></script>
<script src="js/checkgold/checkgold.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html, body {
	width: 100%;
	position: relative;
}

img {
	width: 100%;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
	width: 100%;
}

input[type="button"], input[type="submit"], input[type="reset"] {
	-webkit-appearance: none;
}

textarea {
	-webkit-appearance: none;
}

input[type="button"] {
	border-radius: 0;
}

#wrap ul {
	width: 95%;
	margin: 0 auto;
	margin-top: 15px;
}

:-moz-placeholder {
	/* Mozilla Firefox 4 to 18 */
	color: grey;
}

::-moz-placeholder {
	/* Mozilla Firefox 19+ */
	color: grey;
}

input:-ms-input-placeholder, textarea:-ms-input-placeholder {
	color: grey;
}

input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {
	color: grey;
}

input[type="text"] {
	box-sizing: border-box;
	width: 100%;
	margin: 0 auto;
	/*text-align: center;*/
	font-size: 16px;
	height: 30px;
	border-radius: 4px;
	border: 1px solid #c8cccf;
	color: #6a6f77;
	-web-kit-appearance: none;
	-moz-appearance: none;
	/*outline: 0;*/
	padding: 0 1em;
	/*width: 100%;*/
	height: 40px;
	text-decoration: none;
	text-align: center;
	outline: none;
	border: none;
	border-bottom: 1px solid #EEEEEE;
}

input[type="text"]:focus {
	border: none;
	outline: none;
	border-bottom: 1px solid #EEEEEE;
}

.back {
	position: absolute;
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}

#wrap p:nth-child(1) {
	padding: 0 10%;
	font-size: 16px;
	color: #333333;
}

.check_right {
	float: right;
}

.cz {
	border: none;
	background-image: url(images/bank.png);
	background-repeat: no-repeat;
	background-position-x: 2%;
	background-position-y: center;
}

.sfz {
	border: none;
	background-image: url(images/shenfenzheng.png);
	background-repeat: no-repeat;
	background-position-x: 2%;
	background-position-y: center;
}

.xm {
	border: none;
	background-image: url(images/xingming.png);
	background-repeat: no-repeat;
	background-position-x: 2%;
	background-position-y: center;
}

.yhkh {
	border: none;
	background-image: url(images/yhkh.png);
	background-repeat: no-repeat;
	background-position-x: 2%;
	background-position-y: center;
}

.czTips {
	width: 60%;
	color: #555;
	text-align: left;
	/*padding-left: 10px;*/
	font-size: 10px;
	margin: 0 auto;
}

#wrap>ul>li {
	padding-top: 10px;
	padding-bottom: 15px;
	font-size: 14px;
}

#wrap>ul>li:nth-child(4) {
	font-size: 14px;
	text-align: left;
}

li {
	position: relative;
	margin-top: 20px;
	/*background-color: #F7F7F7;*/
}

.bankPic {
	position: absolute;
	top: 10px;
	width: 40px;
	height: 40px;
}

.bankPic img {
	width: 100%;
}

.backName, .bankNum {
	width:;
	line-height: 25px;
	margin-left: 20%;
}

.backName {
	font-size: 14px;
	font-weight: bold;
}

.go {
	position: absolute;
	top: 20px;
	right: 0;
	width: 20px;
	height: 20px;
}

.clear {
	position: absolute;
	width: 15px;
	height: 15px;
	top: 20px;
	right: 10px;
}

.step {
	width: 100%;
	text-align: center;
	padding-top: 20px;
}

.step span {
	margin: 0 auto;
	display: inline-block;
	/*width: 15%;*/
	font-size: 12px;
}

.stepNum {
	padding: 5px 10px;
	border-radius: 50%;
	color: white;
	background-color: #EDEDED;
	border: 1px solid #E5E5E5;
}

.stepTips {
	width: 100%;
	text-align: center;
}

.stepTips span {
	display: inline-block;
	width: 100px;
	text-align: center;
	font-size: 12px;
}

#wrap .currentStep {
	background-color: #FEC63D;
	color: white;
}

#wrap .currentTips {
	color: #FEC63D;
}

.myButton {
	background-color: #DCDCDC;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: 1px solid #DCDCDC;
	display: inline-block;
	cursor: pointer;
	color: white;
	font-family: Arial;
	font-size: 15px;
	font-weight: bold;
	padding: 6px 24px;
	text-decoration: none;
	width: 60%;
	margin-left: 20%;
	height: 40px;
}

.myButton_s {
	background-color: #FEC63D;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: 1px solid #FEC63D;
	display: inline-block;
	cursor: pointer;
	color: white;
	font-family: Arial;
	font-size: 15px;
	font-weight: bold;
	padding: 6px 24px;
	text-decoration: none;
	width: 60%;
	margin-left: 20%;
	height: 40px;
}

.myButton_s:active {
	position: relative;
	top: 1px;
}
.more{
				position: absolute;
				right: 20px;
				top:18px ;
				width:20px;
				height: 20px;
			}
.step_2{
	width: 100%;
}
.step_2 img{
	width: 86%;
	padding: 25px 7%;
}
	.select-way{
				width: 90%;
				margin: 0 auto;
				min-height: 30px; 
			}
			.select-way table th{
				min-width: 100px;
				padding: 5px 0;
			}
			.select-way table th input{
				width: 16px;
				height: 16px;
				position: relative;
				margin-right: 5px;
			}
				.select-way table{
				text-align: center;
				margin: 0 auto;
			}
</style>
<title>充值</title>
</head>

<body>
	<div id="wrap">

			<p style="background-color: #F7F7F7;color: #333333;height: 30px; text-align: center;padding: 10px;"><img src="images/back.png" onclick="goBack()" class="back" />充值</p>
			<img src="images/more.png" onclick="edsm()" class="more">

			<!-- <div class="step">
				<span>
							<span class="stepNum currentStep">1</span>
				</span>
				<span><b class="currentTips">-------------</b></span>
				<span>
							<span class="stepNum currentStep">2</span>
				</span>
				<span><b>-------------</b></span>
				<span>
							<span class="stepNum">3</span>
				</span>
			</div>

			<div class="stepTips">
				<span class="currentTips">实名认证</span>
				<span class="currentTips">银行卡</span>
				<span>充值</span>
			</div> -->
			<div class="step_2"><img src="images/step2.png"/></div>
			<ul>
				<li style="border-bottom: 1px solid #EEEEEE;">
					<img src="images/${bankcardBean.bankPic}"  class="bankPic" />
					<p class="backName">${bankcardBean.bankName}(尾号${bankcardBean.cardId}银行卡)</p>
					<p class="czTips">单笔限额5万元,单日限额10万元</p>
					<!-- <img src="images/go.png" class="go" /> -->
				</li>
				
				<li style="position: relative;">
					<input type="text" id="amt" onchange="check()" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" 
					 onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" value="" placeholder="请输入充值金额(元)" />
					<img src="images/clear.png" class="clear" id="tab1" />
				</li>
				<div class="select-way">
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th><input type="radio" name="select-way" checked="checked" id="" value="0" />快捷支付</th>
							<th><input type="radio" name="select-way" id="" value="1" />网银支付</th>
						</tr>
					</table>										
				</div>
				<li style="background-color: white;">
					<!--资料填写完成 myButton变成myButton_s-->
					<input type="button" name="" id="next" value="确认充值" onclick="" class="myButton" />

				</li>
			</ul>
		</div>
		<input type="hidden" id="cardNum" name="cardNum" value="${resutMap.rcd}" /> 
		<input type="hidden" id="bankCard" name="bankCard" value="${bankcardBean.bankCard}" /> 
		<input type="hidden" id="name" name="name" value="${sessionScope.account.realName}" /> 
		<input type="hidden" id="idNo" name="idNo" value="${sessionScope.account.idCard}" /> 
	<form action="" id="form1" method="post">
		<input type="hidden" id="mchnt_cd" name="mchnt_cd" />
		<input type="hidden" id="mchnt_txn_ssn" name="mchnt_txn_ssn"/>
		<input type="hidden" id="login_id" name="login_id"/>
		<input type="hidden" id="reg_amt" name="amt"/>
		<input type="hidden" id="order_pay_type" name="order_pay_type" />
		<input type="hidden" id="iss_ins_cd" name="iss_ins_cd"/>
		<input type="hidden" id="page_notify_url" name="page_notify_url"/>
		<input type="hidden" id="back_notify_url" name="back_notify_url"/>
		<input type="hidden" id="signature" name="signature" />
	
		<!-- <input type="hidden" id="ENCTP" name="ENCTP" value="0" /> 
		<input type="hidden" id="VERSION" name="VERSION" value="2.0" /> 
		<input type="hidden" id="MCHNTCD" name="MCHNTCD" value="" />
		<input type="hidden" id="FM" name="FM" value="" />  -->
	</form>
	
</body>
<script type="text/javascript">

function goBack(){
	window.location.href='<%=basePath%>capital/querycapital';
}
function edsm(){
	window.location.href='<%=basePath%>limitDescription.jsp';
}
function next(){
	var bankCard = $('#bankCard').val();
	var name = $('#name').val();
	var idNo = $('#idNo').val();
	var amt = $('#amt').val();
	var cardNum = $("#cardNum").val();
	var rdv = $("input[name='select-way']:checked").val();
	if(bankCard == ""){
		alert("请输入银行卡号！");
		return;
	}
	if(name == ""){
		alert("请输入您的姓名！");
		return;
	}
	if(idNo == ""){
		alert("请输入身份证号！");
		return;
	}
	if(amt == ""){
		alert("请输入您要充值的金额！");
		return;
	}
	if(amt < 100){
		alert("充值金额最低100元起！");
		return;
	}
	if(cardNum != "0000"){
	 if(cardNum == "5505"){
		alert("不支持的银行卡！");
		return;
	}
	else if(cardNum == "100001"){
		alert("不支持的卡类型！");
		return;
	}else {
		alert("无效卡号！");
		return;
	}
	}
	$.ajax({
		  url: "<%=basePath%>payEntry/rechargeInfo",
		  type: "POST",
		  dataType:'json',
		  data : {
			  amt : amt,
			  name : name,
			  bankCard : bankCard,
			  idNo : idNo,
			  rdv : rdv
		  },
		  success: function(data){
			  	$("#mchnt_cd").val(data.mchnt_cd);
				$("#mchnt_txn_ssn").val(data.mchnt_txn_ssn);
				$("#login_id").val(data.login_id);
				$("#reg_amt").val(data.amt);
				$("#order_pay_type").val(data.order_pay_type);
				$("#iss_ins_cd").val(data.iss_ins_cd);
				$("#page_notify_url").val(data.page_notify_url);
				$("#back_notify_url").val(data.back_notify_url);
				$("#signature").val(data.signature);
				form1.action=data.payUrl;
				form1.submit();
		  }
	});
}
function check(){
	var bankCard = $('#bankCard').val();
	var name = $('#name').val();
	var idNo = $('#idNo').val();
	var amt = $('#amt').val();
	var cardNum = $("#cardNum").val();
	if(bankCard == ""){
		alert("请输入银行卡号！");
		$("#next").prop("class","myButton");
		$("#next").attr("onclick","");
		return;
	}
	if(name == ""){
		alert("请输入您的姓名！");
		$("#next").prop("class","myButton");
		$("#next").attr("onclick","");
		return;
	}
	if(idNo == ""){
		alert("请输入身份证号！");
		$("#next").prop("class","myButton");
		$("#next").attr("onclick","");
		return;
	}
	if(amt == ""){
		alert("请输入您要充值的金额！");
		$("#next").prop("class","myButton");
		$("#next").attr("onclick","");
		return;
	}
	if(cardNum != "0000"){
	 if(cardNum == "5505"){
		alert("不支持的银行卡！");
		$("#next").prop("class","myButton");
		$("#next").attr("onclick","");
		return;
	}
	else if(cardNum == "100001"){
		alert("不支持的卡类型！");
		$("#next").prop("class","myButton");
		$("#next").attr("onclick","");
		return;
	}else {
		alert("无效卡号！");
		$("#next").prop("class","myButton");
		$("#next").attr("onclick","");
		return;
	}
	}
	
	$("#next").prop("class","myButton_s");
	$("#next").attr("onclick","next()");
}
$('#tab1').click(function(){
	$('#amt').attr('value','');
});
</script>
</html>
