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
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>充值</title>
<style type="text/css">
			* {
				margin: 0;
				padding: 0;
			}
			
			html,
			body {
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
			
			#wrap ul{
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
			
			input:-ms-input-placeholder,
			textarea:-ms-input-placeholder {
				color: grey;
			}
			
			input::-webkit-input-placeholder,
			textarea::-webkit-input-placeholder {
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
				/*border: 1px solid #FEC63D;*/
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
			.yhkh{
				border: none;
				background-image: url(images/yhkh.png);
				background-repeat: no-repeat;
				background-position-x: 2%;
				background-position-y: center;
				
			}
			
			.czTips{
				color: #555;
				text-align: left;
				padding-left: 10px;
			}
			#wrap>ul>li {
				padding-top:10px ;
				padding-bottom: 15px;
				font-size: 14px;
			}
			
			#wrap>ul>li:nth-child(4) {
				font-size: 14px;
				text-align: left;
			}
			
			li{
				position: relative;
			}
			.bankPic{
				position: absolute;
				top: 0px;
				width: 40px;
				height: 40px;
			}
			.bankPic img{
				width: 100%;
			}
			.backName, .bankNum{
				line-height: 25px;
				margin-left: 40%;
			}
			.backName{
				font-size: 18px;
				font-weight: bold;
			}
			.bankNum{
				font-size: 14px;
				color: #808080;
			}
			.go{
				position: absolute;
				top: 10px;
				right: 0;
				width: 20px;
				height: 20px;
			}
			.myButton {
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
			
			.myButton:active {
				position: relative;
				top: 1px;
			}
		</style>
</head>

<body>
	<div id="wrap">
			<p style="background-color: #F7F7F7;color: #333333;height: 30px; text-align: center;padding: 10px;"><img src="images/back.png" class="back" onclick="toBack()"/>充值</p>
			<ul>				
                <li id="hidImg" style="display: none;">
                	<img src="" id="bankPic" class="bankPic">
                	<p class="backName" id="banksnames"></p>                	
                </li>
                <li>
                	<input type="text" id="bankCard" name="bankCard" value="" placeholder="请输入银行卡号" onblur="queryBank()" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" 
			 onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" class="yhkh"/>
                </li>
                <li>
                	<input type="text" id="name" name="name" value="" placeholder="请输入开户银行预留姓名" class="xm"/>
                </li>
                <li>
                	<input type="text" id="idNo" name="idNo" value="" placeholder="请输入银行预留身份证号" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" 
			 onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" class="sfz"/>
                </li>
				<li style="line-height: 25px;">
					<input type="text" name="amt" id="amt" value="" class="cz" placeholder="请输入要充值的金额" 
			 onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" 
			 onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/>
					<p class="czTips">充值限额:单笔5万，单月30万</p>
				</li>
				
				<li>
					<input type="button" name="" id="" onclick="next()" value="确定" class="myButton" />
					
				</li>
			</ul>
		</div>
		<input type="hidden" id="cardNum" name="cardNum" value="" /> 
	<form action="" id="form1" method="post">
		<input type="hidden" id="ENCTP" name="ENCTP" value="0" /> 
		<input type="hidden" id="VERSION" name="VERSION" value="2.0" /> 
		<input type="hidden" id="MCHNTCD" name="MCHNTCD" value="" />
		<input type="hidden" id="FM" name="FM" value="" /> 
	</form>
</body>
<script type="text/javascript">
	function next(){
		var bankCard = $('#bankCard').val();
		var name = $('#name').val();
		var idNo = $('#idNo').val();
		var amt = $('#amt').val();
		var cardNum = $("#cardNum").val();
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
				  idNo : idNo
			  },
			  success: function(data){
					$("#MCHNTCD").val(data.mchntCd);
					$("#FM").val(data.fm);
					form1.action=data.payUrl;
					form1.submit();
			  }
			  		
		});
	}
	
	function queryBank(){
		var bankCard = $('#bankCard').val();
		 $("#hidImg").css("display","none");
		if(bankCard == ""){
			return;
		}
		$.ajax({
			  url: "<%=basePath%>payEntry/cardQuery",
			  type: "POST",
			  dataType:'json',
			  data : {
				  bankCard : bankCard
			  },
			  success: function(data){
				  $("#cardNum").val(data.rcd);
				 
				if(data.rcd == "0000"){
					$("#hidImg").css("display","block");
					$("#banksnames").text(data.cnm);
					$("#bankPic").attr("src",data.img);
				}
				
			  }
			  		
		});
	}
	function toBack()
	{
		window.location.href='<%=basePath%>capital/querycapital';
	}
</script>
</html>

