<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="../js/validate.js"></script>
		<script type="text/javascript" src="../js/isWeixin.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/commonStyle.css" />
		<title>收货地址</title>
		<style type="text/css">
			img {
				width: 100%;
			}
			
			table {
				text-align: left;
				width: 100%;
				height: 40px;
				font-size: 14px;
				color: gray;
				margin-bottom: 10px;
				border-bottom: 2px solid dodgerblue;
			}
			
			input[type="text"] {
				box-sizing: border-box;
				text-align: center;
				font-size: 14px;
				height: 2.5em;
				border-radius: 4px;
				border: 1px solid #c8cccf;
				color: #6a6f77;
				-web-kit-appearance: none;
				-moz-appearance: none;
				outline: 0;
				/*padding: 0 1em;*/
				text-decoration: none;
			}
			
			input[type="text"]:focus {
				border: 1px solid dodgerblue;
			}
			
			#buy{
				display: inline-block;
			}
			#buy>div{
				float: left;
				margin: 10px;
			}
			#count {
				box-sizing: border-box;
				text-indent: 40px;
				font-size: 14px;			
				border-radius: 4px;
				border: 1px solid #c8cccf;
				color: #6a6f77;
				-web-kit-appearance: none;
				-moz-appearance: none;
				outline: 0;
				padding: 0 1em;
				text-decoration: none;
				width: 60px;
				font-size: 16px;
				font-family: "微软雅黑";
				padding: 5px;				
			}
			
			.myButton {
				-moz-box-shadow: 0px 1px 0px 0px #f0f7fa;
				-webkit-box-shadow: 0px 1px 0px 0px #f0f7fa;
				box-shadow: 0px 1px 0px 0px #f0f7fa;
				background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #33bdef), color-stop(1, #019ad2));
				background: -moz-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -webkit-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -o-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -ms-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: linear-gradient(to bottom, #33bdef 5%, #019ad2 100%);
				filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bdef', endColorstr='#019ad2', GradientType=0);
				background-color: #33bdef;
				-moz-border-radius: 6px;
				-webkit-border-radius: 6px;
				border-radius: 6px;
				border: 1px solid #057fd0;
				display: inline-block;
				cursor: pointer;
				color: #ffffff;
				font-family: Arial;
				font-size: 15px;
				font-weight: bold;
				padding: 6px 24px;
				text-decoration: none;
				text-shadow: 0px -1px 0px #5b6178;
				width: 50%;
			}
			
			.myButton_2 {
				-moz-box-shadow: inset 0px 1px 0px 0px #ffffff;
				-webkit-box-shadow: inset 0px 1px 0px 0px #ffffff;
				box-shadow: inset 0px 1px 0px 0px #ffffff;
				background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #c7c3c7), color-stop(1, #bdaabd));
				background: -moz-linear-gradient(top, #c7c3c7 5%, #bdaabd 100%);
				background: -webkit-linear-gradient(top, #c7c3c7 5%, #bdaabd 100%);
				background: -o-linear-gradient(top, #c7c3c7 5%, #bdaabd 100%);
				background: -ms-linear-gradient(top, #c7c3c7 5%, #bdaabd 100%);
				background: linear-gradient(to bottom, #c7c3c7 5%, #bdaabd 100%);
				filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#c7c3c7', endColorstr='#bdaabd', GradientType=0);
				background-color: #c7c3c7;
				-moz-border-radius: 6px;
				-webkit-border-radius: 6px;
				border-radius: 6px;
				border: 1px solid #dcdcdc;
				display: inline-block;
				cursor: pointer;
				color: #666666;
				font-family: Arial;
				font-size: 14px;
				font-weight: bold;
				padding: 6px 20px;
				width: 50%;
				margin-bottom: 10px;
				text-decoration: none;
				text-shadow: 0px 1px 0px #ffffff;
			}
			
			.myButton:active {
				position: relative;
				top: 1px;
			}
			
			#wrap>ul>li:nth-child(1) {
				background-color: dodgerblue;
				color: white;
				padding: 10px;
			}
			
			.btns {
				width: 20px;
				height: 20px;
				border: 1px solid dodgerblue;
				border-radius: 8px;
				line-height: 20px;
				text-align: center;
			}
		</style>
		<script type="text/javascript">
			function backToGoodsList(){
				window.location.href="<%=basePath%>scoremarket/queryscoremarket";
			}
			function mnum(){
				var num = parseInt($("#shownum").text());
				var score = parseInt($("#score").text());
				var payscore = parseInt($("#payscore").text());
				if(num == 1){
					$("#shownum").html(1);
				}else{
					$("#shownum").html(num - 1);
					$("#payMoney").html(payscore * (num - 1));
					$("#leMoney").html(score - payscore * (num - 1));
				}
			}
			function anum(){
				var num = parseInt($("#shownum").text());
				var score = parseInt($("#score").text());
				var payscore = parseInt($("#payscore").text());
				var goodsNum = parseInt($("#goodNum").text());
				if((score - payscore * (num + 1)) <= 0 || num == goodsNum){
					$("#shownum").html(num);
				}else{
					$("#shownum").html(num + 1);
					$("#payMoney").html(payscore * (num + 1));
					$("#leMoney").html(score - payscore * (num + 1));
				}
			}
			function convertgoods(){
				if(parseInt($("#goodNum").text())<=0)
				{
					$("#btn").attr("disabled", true);	
					$("#btn").attr("class", "myButton_2");
					alert("爆款实物已兑换完");
				}
				else if(parseInt($("#payMoney").text())>parseInt($("#score").text()))
				{
					$("#btn").attr("disabled", true);	
					$("#btn").attr("class", "myButton_2");
					alert("鱼干不足");
				}
				else
				{
					var userName = $("#userName").val();
					var userTelephone = $("#userTelephone").val();
					var userAddr = $("#userAddr").val();
					var num = parseInt($("#shownum").text());
					var goodsMoney = parseInt($("#payMoney").text());
					if(!objIsNullOrEmpty(userName)){
						return;
					}
					if(!objIsNullOrEmpty(userAddr)){
						return;
					}
					if(!verifyVal(userTelephone,"mobilePhone","收件人电话")){
						return;
					}
					$("#goodsNum").val(num);
					$("#goodsMoney").val(goodsMoney);
					$("#orderUserName").val(userName);
					$("#orderUserTelephone").val(userTelephone);
					$("#orderUserAddr").val(userAddr);
					$("#convertFrm").submit();
				}
			}
		</script>
	</head>

	<body>
		<form method="post" action="<%=basePath%>scoremarket/convertgoods" id="convertFrm">
			<input type="hidden" name="orderType" value="0">
			<input type="hidden" name="goodsId" value="${goodsInfo.goodsId }"/>
			<input type="hidden" name="goodsNum" id="goodsNum" value=""/>
			<input type="hidden" name="goodsMoney" id="goodsMoney" value=""/>
			<input type="hidden" name="orderStatus" id="orderStatus" value="1"/>
			<input type="hidden" name="orderUserName" id="orderUserName" value=""/>
			<input type="hidden" name="orderUserTelephone" id="orderUserTelephone" value=""/>
			<input type="hidden" name="orderUserAddr" id="orderUserAddr" value=""/>
		</form>
		<div id="wrap">
			<ul>
				<li>
					<img src="../images/back.png" id="back" onclick="backToGoodsList()"/>兑换商品
				</li>
				<li>
					<table border="0" cellspacing="10" cellpadding="">
						<tr>
							<th class="table_left">
								<b>当前鱼干:</b>   <b id="score">${accountScore }</b>															
								<p>${goodsInfo.goodsName }</p>
								<p>${goodsInfo.goodsSpecs }</p>
								<p>已换:<b style="color: black;">${goodsInfo.goodsStock - goodsInfo.realStock }</b> &nbsp;&nbsp;&nbsp;剩余：<b style="color: black;" id="goodNum">${goodsInfo.realStock }</b></p>
							</th>
							<th class="table_right" style="width: 50%;"><img src="../images/logo.png" /></th>
						</tr>
						<tr>
							<th class="table_left">所需鱼干：<b style="color: crimson;" id="payscore">${goodsInfo.saleMoney }</b></th>
						</tr>
					</table>
				</li>
				<li>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>兑换数量</th>
							<th>所需鱼干</th>
							<th>剩余鱼干</th>
						</tr>
						<tr>
							<th id="buy">
								<div id="minus" class="btns" onclick="mnum()">
									-
								</div>
								
								<div id="shownum">
									1
								</div>
								
								<div id="add" class="btns" onclick="anum()">
									+
								</div>
							</th>
							<th id="payMoney">${goodsInfo.saleMoney }</th>
							<th id="leMoney">
								<c:if test="${accountScore - goodsInfo.saleMoney < 0}">0</c:if>
								<c:if test="${accountScore - goodsInfo.saleMoney >= 0}">${accountScore - goodsInfo.saleMoney}</c:if>
							</th>
						</tr>
					</table>
				</li>
				<li>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th style="width: 50%;">收件人姓名 </th>
							<th style="width: 50%;"><input type="text" name="userName" id="userName" value="${accountAddress.userName }" /> </th>
						</tr>
						<tr>
							<th style="width: 50%;">收件人电话 </th>
							<th style="width: 50%;"><input type="text" name="userTelephone" id="userTelephone" value="${accountAddress.userTelephone }" /> </th>
						</tr>
						<tr>
							<th style="width: 50%;">详细地址 </th>
							<th style="width: 50%;"><textarea name="userAddr" id="userAddr" rows="5" cols="22" value="${accountAddress.userAddress }">${accountAddress.userAddress }</textarea></th>
						</tr>
					</table>
				</li>
				<li>
					<c:if test="${goodsInfo.realStock>0}">
						<input type="button" class="myButton" id="btn" value="确定" onclick="convertgoods()"/>
					</c:if>
					<c:if test="${goodsInfo.realStock<=0}">
						<input type="button" class="myButton_2" id="" value="确定" />
					</c:if>
				</li>
			</ul>

		</div>
	</body>
	<!-- <script src="jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script> -->
</html>