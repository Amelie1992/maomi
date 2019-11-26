<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
<link rel="stylesheet" type="text/css" href="css/reset.css" />

<title>提现</title>
<style type="text/css">
			body{
					background-color: #F7F7F7;
			}
			.wrap {
				width: 100%;
			
				
			}
			
			.title {
				width: 100%;
				position: relative;
				text-align: center;
				font-size: 16px;
				color: #333333;				
				font-weight: 600;
				height:50px ;
				line-height: 50px;
				background-color: white;
			}
			
			.back {
				position: absolute;
				left: 20px;
				top:18px ;
				width:10px;
				height: 15px;
			}
			
			.more{
				position: absolute;
				right: 20px;
				top:18px ;
				width:20px;
				height: 20px;
			}
			
			.bank{
				background-color: white;
				position: relative;
				width: 100%;
				height: 100px;
				margin-top: 15px;
			}
			.bank img{
				position: absolute;
				width: 40px;
				height: 40px;
				top: 30px;
				left: 20px;				
			}
			.bank p{
				position: absolute;				
			}
			.bankName{
				top: 30px;
				left: 80px;
				font-size: 16px;
				font-weight: bold;
			}
			.bankNum {
				text-align: center;
				height: 40px;
				line-height: 40px;
				position: relative;
				background-color: white;
			}
			
			.bankNum input {
				position: absolute;
				width: 80%;
				left: 50px;
				top: 10px;
				height: 30px;				
				border: none;
				outline: none;
			}
			
			.bankNum img {
				position: absolute;
				width: 20px;
				height: 20px;
				top: 15px;
				left: 20px;
			}

			.tixian{
				background-color: white;
				position: relative;
				width: 100%;
				height: 100px;
				margin-top: 15px;
			}
			.tixian img{
				position: absolute;
				width: 20px;
				height: 20px;
				top: 15px;
				left: 20px;	
			}
			.tixian input{
				position: absolute;
				width: 80%;
				left: 50px;
				top: 10px;
				height: 30px;
				border: none;
			}
			input[type="text"]:focus {
				border: none;
			}
			.tixianBox{
				height: 50px;
				border-bottom: 1px solid #EEEEEE;
			}
			.tixianTips{
				overflow: hidden;
				height: 50px;
				line-height: 50px;
				text-indent: 10px;
				font-size: 12px;
			}
			.tixianTips span{
				display: inline-block;
				color: #888;
			}
			.tixianTips a{
				color: #F54749;
				float: right;
				padding-right: 20px;
			}
			.txBtn{
				display: inline-block;
				width: 80%;
				margin-top: 35px;
				margin-left:  10%;
				height: 40px;
				line-height: 40px;
				background-color: #Ffe1a3;
				color: white;
				font-size: 18px;
				text-align: center;
			}
			.txBtn_s{
				display: inline-block;
				width: 80%;
				margin-top: 35px;
				margin-left:  10%;
				height: 40px;
				line-height: 40px;
				background-color: #FF9F26;
				color: white;
				font-size: 18px;
				text-align: center;
			}
			.textbox {
				margin-top:20px;
				padding: 20px 10px;
				background-image: url(images/mmb-text-box.png);
				background-size: 95% 100%;
				background-position: center;
				background-repeat: no-repeat;
				
				background-color: #F2F2F2;
			}
			.textbox p{
				line-height: 25px;
				text-align: left;
				color: #888888;
				padding: 0 5px;
			}
			.textbox p:nth-of-type(1){
				color: #F95D18;
				font-size: 18px;
				
			}
		</style>
</head>

<body>
		<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()"/>提现
			</div>
			<div class="bank">
				<img src="images/${bankcardBean.bankPic}"/>
				<p class="bankName">${bankcardBean.bankName}</p>
			</div>
			<div class="bankNum">
				<img src="images/${bankcardBean.bankPic}" />
				<input type="text" name="" id="bankCard" value="${bankcardBean.bankCard}" disabled="disabled" />
			</div>
			<div class="tixian">
				<p class="tixianBox">
					<img src="images/bank.png"/>
					<input type="text" name="money" id="money" value="${inputMoney}"  placeholder="请输入提现金额，单笔最低50元" onkeyup="checkNext()"/>
				</p>
				<p class="tixianTips">
					<span>猫咪宝余额:</span>
					<span>${capitalBean.freedomMoney }元</span>
					<a onclick="allIn()">全部提现</a>
				</p>
			</div>
			<c:if test="${withdrawalsNumber>0}">
				<div style="text-align: center;color: #F95D18;padding: 10px 0;">
					<span><img src="images/wx-tqtx-select-before.png" id="withdrawalsNumber" style="width: 20px;position: relative;top: 5px;" onclick="checkImg(this)"/></span>
					<!--单选，换图images/wx-tqtx-select-before.png -->
					<span>使用特权提现</span>
				</div>
			</c:if>
			
			<!--数据填完之后 把txBtn 变成txBtn_s -->
			<a class="txBtn" onclick="next()" id="next">下一步</a>
			<input type="hidden" id="hidMoney" value="${capitalBean.freedomMoney }"/>
			<input type="hidden" id="accountName" value="${capitalBean.accountName }"/>
			<input type="hidden" id="bankName" value="${bankCardBean.bankName }"/>
			<input type="hidden" id="count" value="${count }"/>
			<input type="hidden" id="isComp" value="${isComp }"/>
			
			<div class="textbox">
				<p>温馨提示</p>
				
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本次提现平台暂不收取手续费。</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;根据合作银行相关规定,每日14:00之前不支持提现。</p>

				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每日14:00~15:00申请提现，若当天是工作日则当日到账；若当天是周末或法定节假日，则延迟至工作日到账；15:00后申请提现，下一个工作日到账(法定节假日顺延)。

				</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;例如投资者2017年10月3号申请"转至银行卡"，由于10月1号~8号为法定节假日，投资者资金9号到账。
				</p>
			</div>
		</div>
	</body>

<script type="text/javascript">
	$(function(){ 
		$("#next").removeClass();
		$("#next").addClass("txBtn_s");
		$("#next").attr("onclick","next()");
	});
	function checkNext()
	{
			var m = $("#money").val();
			if(''!=m)
			{
				$("#next").removeClass();
				$("#next").addClass("txBtn_s");
				$("#next").attr("onclick","next()");
			}
			else
			{
				$("#next").removeClass();
				$("#next").addClass("txBtn");
				$("#next").removeAttr("onclick");
			}
	
	}
	//获取系统当前时间
	function getNowFormatDate(date) {
  		var seperator1 = "-";
  		var seperator2 = ":";
  		var month = date.getMonth() + 1;
  		var strDate = date.getDate();
  		if (month >= 1 && month <= 9) {
  	    	month = "0" + month;
  		}
  		if (strDate >= 0 && strDate <= 9) {
  	    	strDate = "0" + strDate;
  		}
  		var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
  	    	+ " " + date.getHours() + seperator2 + date.getMinutes()
  	        + seperator2 + date.getSeconds();
  		return currentdate;
	}	

	function goBack(){
		window.location.href='<%=basePath%>freedomsubject/toMyFreedom';
	}
	
	
	function allIn(){
		$("#money").val("");
		$("#money").val($("#hidMoney").val());
	}
	
	var tq = false;
	function next(){
		var money = $("#money").val();
		var filter = /^(?!0+(?:\.0+)?$)\d+(?:\.\d{1,2})?$/;
		if (!filter.test(money)) {
			alert("提现金额格式错误");
			return ;
		}
		var hours = new Date().getHours();
		if(tq){
			if(!time_range('09:00','17:30')){
				alert("特权提现只限在9:00至17:30，并且当日到账!");
				return;
			}
		}else{
			if(hours < 14){
				alert("根据合作银行相关规定,每日14点之前不支持提现,请于14点之后进行提现操作,对您带来的不便尽请谅解!");
				return;
			}
		}
		var accountName = $('#accountName').val();
		var bankName = $('#bankName').val();
		var bankCard = $('#bankCard').val();
		var money = $('#money').val();
		var hidMoney = $('#hidMoney').val();
		var count = $('#count').val();
		var isComp = $('#isComp').val();
		if(money > parseFloat(hidMoney)){
			alert("提现金额不可大于猫咪宝余额！");
			return;
		}
		if(money < 50){
			alert("单笔提现金额最低50元！");
			return;
		}
		if(bankCard=="" || bankCard=="undefind"){
			alert("请输入银行卡号！");
			return;
		}
		if(count == 0 && isComp == 1){
			alert("您是企业用户首次提现，将获得10元奖励金到您银行卡，1~3个工作日到账");
		}
		if(confirm("您确认立即提现吗？")) 
		{
			$.ajax({
				 url: "<%=basePath%>withdraw/queryMoney",
				 type: "POST",
				  dataType:'json',
				  success: function(data){
					  if(data.freedomMoney < money){
						  alert("提现金额不可大于猫咪宝余额！");
						return;
					  }else{
						  $.ajax({
							  url: "<%=basePath%>freedomsubject/withdrawMon",
							  type: "POST",
							  dataType:'json',
							  data : {
								  accountName : accountName,
								  bankName : bankName,
								  money	: money,
								  bankCard : bankCard,
								  isComp : isComp,
								  count : count,
								  tq : tq
							  },
							  success: function(data){
								  if(data.code == 200){
									  if(tq){
										  alert("特权提现申请成功!提现金额将于当日到账,请关注到账时间!");
									  }else if(hours >= 14 && hours <= 15){
											alert("提现申请成功!每日14至15点之前申请提现,提现金额将于当日到账,请关注到账时间!");
										}else{
											alert("提现申请成功!每日15点之后申请提现,提现金额将于次日到账,请关注到账时间!");
										}
									  window.location.href='<%=basePath%>withdraw/toSucc'; 
								  }else if(data.code == 'overtop'){
									  alert("超出特权提现限额!");
								  }else if(data.code == 'notEnough'){
									  alert("特权提现次数不足!");
								  }else{
									  alert("违规操作!");
								  }
							  }
						});
					  }
				  }
			});
		}
	}
	
	function checkImg(obj){
		var src = $(obj).attr("src");
		if(src == "images/wx-tqtx-select-after.png"){
			$(obj).attr("src","images/wx-tqtx-select-before.png");
			tq = false;
		}else{
			$(obj).attr("src","images/wx-tqtx-select-after.png");
			tq = true;
		}
	}
	
	
	var time_range = function(beginTime, endTime) {
		var strb = beginTime.split(":");
		if(strb.length != 2) {
			return false;
		}

		var stre = endTime.split(":");
		if(stre.length != 2) {
			return false;
		}

		var b = new Date();
		var e = new Date();
		var n = new Date();

		b.setHours(strb[0]);
		b.setMinutes(strb[1]);
		e.setHours(stre[0]);
		e.setMinutes(stre[1]);

		if(n.getTime() - b.getTime() > 0 && n.getTime() - e.getTime() < 0) {
			return true;
		} else {
			return false;
		}
	}
	
</script>
</html>
