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
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/accountInfo/bankCard.css"/>
<title>我的银行卡</title>
</head>

<body>
	<div class="wrap">
		<p class="title">
			<img src="images/back.png" onclick="goBack()" class="back" />我的银行卡
		</p>
		<div class="content">
			<p class="bankName">
				<img src="images/${accountBankcardBean.bankPic}" /> <span>${accountBankcardBean.bankName}</span>
			</p>
			<p>${accountBankcardBean.bankCard}</p>
			<p>持卡人：${accountInfo.realName}</p>
		</div>
		<div>
			<p class="hkxz">换卡须知：</p>
			<table class="hkxz_tk">
				<tr>
					<td class="bh">1.</td>
					<td>联系客服,电话<a href="tel:400-000-3060">客服电话:400-000-3060</a></td>
				</tr>
				<tr>
					<td class="bh">2.</td>
					<td>提供身份证正反面、新银行卡照片</td>
				</tr>
				<tr>
					<td class="bh">3.</td>
					<td>提供本人与身份证、新银行卡的合照</td>
				</tr>
				<tr>
					<td class="bh">4.</td>
					<td>若是因原银行卡丢失换卡，需提供原银行卡的挂失证明或原银行卡的交易流水</td>
				</tr>
				<tr>
					<td class="bh">5.</td>
					<td>若是因不支持银行卡快捷支付或其他情况换卡，需提供原银行卡照片或原银行卡的交易流水</td>
				</tr>
			</table>
			<!-- <ul >
				<li>1.联系客服,电话<a href="tel:400-000-3060">客服电话:400-000-3060</a></li>
				<li>2.提供身份证正反面、新银行卡照片</li>
				<li>3.提供本人与身份证、新银行卡的合照</li>
				<li>4.若是因原银行卡丢失换卡，需提供原银行卡的挂失证明或原银行卡的交易流水</li>
				<li>5.若是因不支持银行卡快捷支付或其他情况换卡，需提供原银行卡照片或原银行卡的交易流水</li>
			</ul> -->
		</div>
		
		<!-- <div id="backBtn" class="changeBankCard">更换银行卡</div> -->
	</div>

</body>
<script type="text/javascript">
	//去绑定银行卡页面
	<%-- $("#backBtn").click(function(){
		window.location.href='<%=basePath%>accountinfo/toBindBankCard';
	}); --%>
	
	//返回上一页
	function goBack(){
		window.location.href='<%=basePath%>accountinfo/personalSettings';
	}
</script>
</html>
