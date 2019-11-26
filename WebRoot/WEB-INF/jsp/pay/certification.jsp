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
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>

<style type="text/css">
body {
	/*background-color: #EFEFEF;*/
	
}

* {
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
	color: green;
}

img {
	width: 100%;
}

#wrap {
	width: 100%;
}

.back {
	position: absolute;
	left: 20px;
	top: 15px;
	width: 10px;
	height: 15px;
}

#wrap p:nth-child(1) {
	width: 100%;
	line-height: 40px;
	font-size: 20px;
	color: #333333;
	background-color: #F7F7F7;
	text-align: center;
	/*padding: 10px;*/
}

:-moz-placeholder {
	/* Mozilla Firefox 4 to 18 */
	color: #E5E5E5;
	text-align: center;
}

::-moz-placeholder {
	/* Mozilla Firefox 19+ */
	color: #E5E5E5;
	text-align: center;
}

input:-ms-input-placeholder, textarea:-ms-input-placeholder {
	color: #E5E5E5;
	text-align: center;
}

input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {
	color: #E5E5E5;
	text-align: center;
}

#wrap ul li span {
	display: inline-block;
}

input[type="text"] {
	box-sizing: border-box;
	/*text-align: center;*/
	font-size: 14px;
	width: 70%;
	height: 40px;
	border-radius: 4px;
	border: 1px solid #c8cccf;
	color: #6a6f77;
	-web-kit-appearance: none;
	-moz-appearance: none;
	outline: none;
	border: none;
	padding: 0 1em;
	text-decoration: none;
	/*border-bottom: 1px solid #E5E5E5;*/
}

input[type="text"]:focus {
	outline: none;
	border: none;
	/*border-bottom: 1px solid #E5E5E5;*/
}
select{
	box-sizing: border-box;
	/*text-align: center;*/
	font-size: 14px;
	width: 70%;
	height: 40px;
	border-radius: 4px;
	border: 1px solid #c8cccf;
	color: #6a6f77;
	-web-kit-appearance: none;
	-moz-appearance: none;
	outline: none;
	border: none;
	padding: 0 1em;
	text-decoration: none;
	/*border-bottom: 1px solid #E5E5E5;*/
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
.li_span{
	margin-left: 10px;
	background-color: white;
	border-bottom: 1px solid #EEEEEE;
}

.myButton {
	display: inline-block;
	width: 60%;
	margin-left: 20%;
	margin-top: 40px;
	line-height: 40px;
	font-size: 18px;
	text-align: center;
	color: white;
	background-color: #DCDCDC;
	border: 1px solid #DCDCDC;
	border-radius: 5px;
}

.myButton_s {
	display: inline-block;
	width: 60%;
	margin-left: 20%;
	margin-top: 40px;
	line-height: 40px;
	font-size: 18px;
	text-align: center;
	color: white;
	background-color: #FEC63D;
	border: 1px solid #FEC63D;
	border-radius: 5px;
}

.step_1{
	width: 100%;
}
.step_1 img{
	width: 86%;
	padding: 25px 7%;
}
</style>
<title>实名认证</title>
</head>

<body>
	<div id="wrap">
		<p>
			<img src="images/back.png" class="back" onclick="goBack()" />实名认证
		</p>
		<ul>
			<li>
				<!-- <div class="step">
					<span> <span class="stepNum currentStep">1</span>
					</span> <span><b>-------------</b></span> <span> <span
						class="stepNum">2</span>
					</span> <span><b>-------------</b></span> <span> <span
						class="stepNum">3</span>
					</span>
				</div>

				<div class="stepTips">
					<span class="currentTips"> 实名认证 </span> <span> 银行卡 </span> <span>
						充值 </span>
				</div> -->
				<div class="step_1"><img src="images/step1.png"/></div>
			</li>

			<li class="li_span" style="margin-top: 20px;">
				<span>姓&nbsp;&nbsp;&nbsp;&nbsp;名</span> <input onchange="check()" type="text" name="realName"
				id="realName" value="" placeholder="请输入您的姓名" />
			</li>
			<li class="li_span">
				<span>身份证</span> <input onchange="check()" type="text" name="idCard" id="idCard" value=""
				placeholder="请输入您的身份证" />
			</li>
			<li class="li_span">
				<span>性&nbsp;&nbsp;&nbsp;&nbsp;别</span>
				<select onchange="check()" id="accountSex" name="accountSex">
					<option value="0">男</option>
					<option value="1">女</option>
				</select>
			</li>
			<li><div  id="next" class="myButton" onclick='' >下一步</div></li>
			<li style="text-align: center; font-size: 10px;">本平台承诺不泄露您的个人信息
			</li>
		</ul>
	</div>

</body>
<script type="text/javascript">
	function goBack(){
		window.location.href='<%=basePath%>capital/querycapital';
	}
	function certification(){

		var realName = $("#realName").val();
		var idCard = $("#idCard").val();
		var accountSex = $("#accountSex").val();
		if(confirm("实名认证只能一次，是否确认")){
			$.ajax({
				url:"<%=basePath%>accountinfo/certification",
				type : "POST",
				data : {
					realName : realName,
					idCard : idCard,
					accountSex : accountSex
				},
				success:function(data){
					if(data.result==='success'){
						alert('认证成功,奖励的10鱼干已发放至账户,如需更改请联系客服');
						window.location.href='<%=basePath%>recharge/rechargeInfo';
					} else if(data.result==='error'){
						alert('系统错误');
						window.location.href='<%=basePath%>recharge/rechargeInfo';
					}
				}
			});
		}
	
	}
	function check(){
		var realName = $("#realName").val();
		var idCard = $("#idCard").val();
		var accountSex = $("#accountSex").val();
		if(!verifyValNoMsg(realName,"chineseVerification")){
			$('#next').prop('class','myButton');
			$('#next').attr('onclick','');
			return;
		}
		if(!verifyValNoMsg(idCard,"idCard")){
			$('#next').prop('class','myButton');
			$('#next').attr('onclick','');
			return;
		}
		if(!objIsNullOrEmptyNoMsg(accountSex)){
			$('#next').prop('class','myButton');
			$('#next').attr('onclick','');
			return;
		}
		$('#next').prop('class','myButton_s');
		$('#next').attr('onclick','certification()');
	}
</script>
</html>
