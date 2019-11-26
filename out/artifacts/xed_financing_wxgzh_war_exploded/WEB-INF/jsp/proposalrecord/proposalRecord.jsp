<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>立即反馈</title>
<style type="text/css">
.smart-green {
	margin-left: auto;
	margin-right: auto;
	max-width: 500px;
	/*background: #F8F8F8;*/
	padding: 30px 30px 20px 30px;
	font: 12px Arial, Helvetica, sans-serif;
	color: #666;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
}

.smart-green h1 {
	font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
	padding: 20px 0px 20px 40px;
	display: block;
	margin: -30px -30px 10px -30px;
	color: #FFF;
	background: #FEC63D;
	text-shadow: 1px 1px 1px #949494;
	border-radius: 5px 5px 0px 0px;
	-webkit-border-radius: 5px 5px 0px 0px;
	-moz-border-radius: 5px 5px 0px 0px;
	border-bottom: 1px solid #FEC63D;
}

.smart-green h1>span {
	display: block;
	font-size: 11px;
	color: #FFF;
}

.smart-green label {
	display: block;
	margin: 0px 0px 5px;
}

.smart-green label>span {
	float: left;
	margin-top: 10px;
	color: #5E5E5E;
}

.smart-green input[type="text"], .smart-green input[type="email"],
	.smart-green textarea, .smart-green select {
	color: #555;
	height: 30px;
	line-height: 15px;
	width: 100%;
	padding: 0px 0px 0px 10px;
	margin-top: 2px;
	border: none;
	outline: none;
	border-bottom: 1px solid #E5E5E5;
	/*background: #FBFBFB;*/
	outline: 0;
	-webkit-box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
	box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
	font: normal 14px/14px Arial, Helvetica, sans-serif;
}

.smart-green textarea {
	height: 100px;
	padding-top: 10px;
}

.smart-green select {
	background: url('down-arrow.png') no-repeat right,
		-moz-linear-gradient(top, #FBFBFB 0%, #E9E9E9 100%);
	background: url('down-arrow.png') no-repeat right,
		-webkit-gradient(linear, left top, left bottom, color-stop(0%, #FBFBFB),
		color-stop(100%, #E9E9E9));
	appearance: none;
	-webkit-appearance: none;
	-moz-appearance: none;
	text-indent: 0.01px;
	text-overflow: '';
	width: 100%;
	height: 30px;
}

.smart-green .button {
	background-color: #FEC63D;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-border-radius: 5px;
	border: none;
	padding: 10px 25px 10px 25px;
	color: #FFF;
	text-shadow: 1px 1px 1px #949494;
	width: 100%;
}

.smart-green .button:active {
	position: relative;
	top: 1px;
}

.title {
	width: 100%;
	position: relative;
	text-align: center;
	font-size: 18px;
	color: #333333;
	height: 50px;
	line-height: 50px;
	background-color: #F7F7F7;
}

.back {
	position: absolute;
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}
</style>
<script type="text/javascript">
	//返回上一页
	function getBack(){
		window.location.href='<%=basePath%>proposalrecord/s/goproposalcenter';
	}
	
	//返回上一页
	function doProposal(){
		if($("#name").val() == ''){
			alert("请填写您的姓名");
			return false;
		}
		if($("#telephone").val() == ''){
			alert("请填写您的联系方式");
			return false;
		}
		if($("#proposalContent").val() == ''){
			alert("请提出您的意见");
			return false;
		}
		alert("反馈成功,谢谢您对猫咪平台的支持");
		$("#proposalFrm").submit();
	}
</script>
</head>

<body>
	<div class="title">
		<a href="javascript:getBack();"><img src="images/back.png" class="back" /></a>立即反馈
	</div>
	<form action="<%=basePath%>proposalrecord/s/recordproposal" method="post" class="smart-green" id="proposalFrm">
		<input type="hidden" name="accountId" id="accountId" value="${accountInfo.accountId}"/>
		<h1>
			意见反馈 <span>请提交您对本平台的意见</span>
		</h1>
		<label>
			<span>姓名:</span>
			<input id="name" type="text" name="name" placeholder="请输入您的姓名" value="${accountInfo.accountName}"/>
		</label>
		<label>
			<span>联系方式:</span>
			<input id="telephone" type="text" name="telephone" placeholder="请输入您电话"  value="${accountInfo.telephone}"/>
		</label>
		<label>
			<span>您的意见:</span>
			<textarea id="proposalContent" name="proposalContent" placeholder="请为本平台提供您宝贵的意见"></textarea>
		</label>
		<label>
		<span>&nbsp;</span>
			<input type="button" class="button" value="提交" onclick="doProposal()" />
		</label>
	</form>
</body>
</html>