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
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>账号设置</title>
<style type="text/css">
.wrap {
				width: 100%;
			}
			
			.title {
				width: 100%;
				position: relative;
				text-align: center;
				font-size: 20px;
				color: #333333;
				font-weight: 600;
				height: 50px;
				line-height: 50px;
				background-color: #F7F7F7;
			}
			
			.back {
				position: absolute;
				left: 20px;
				top: 10px;
			}
			.wrap ul li{
				height: 50px;
				position: relative;
				margin-top: 10px;
				
			}
			.bankPic{
				position: absolute;
				top: 5px;
				left: 10px;
			}
			.wrap .bankPic img{
				width: 40px;
				height: 40px;
			}
			.bankName{
				font-size: 18px;
				color: #333333;
				padding: 5px 0;
				font-weight: bold;
				margin-left: 60px;
			}
			.bankTips{
				color: #C3C3C3;
				padding: 5px 0;
				margin-left: 60px;
				border-bottom: 1px solid #EEEEEE;
			}	
</style>


</head>

<body>
	<div class="wrap">
	<div class="title">
			<img src="images/back.png" class="back" onclick="getBack()" />选择银行
		</div>
	<ul>
		<c:forEach items="${bankCardList}" var="p">
		<li onclick="chooseBank('${p.bankCode}','${p.bankPic}','${p.bankName}')">
			<div class="bankPic">
				<img src="images/${p.bankPic}"/>
			</div>
			<p class="bankName">${p.bankName}</p>
			<p class="bankTips">单笔5万，单日50万</p>
		</li>
		</c:forEach>
	</ul>
	<form action="<%=basePath%>accountinfo/toBindBankCard" method="post">
		<input type="hidden" id="bankCode" name="bankCode"/>
		<input type="hidden" id="bankPic" name="bankPic"/>
		<input type="hidden" id="bankName" name="bankName"/>
	</form>
</div>	
</body>
<script type="text/javascript">
	//返回上一页
	function getBack(){
		window.history.go(-1);
	}
	//选择银行
	function chooseBank(code,pic,name){
		$("#bankCode").val(code);
		$("#bankPic").val(pic);
		$("#bankName").val(name);
		$("form").submit();
	}
	
	
</script>
</html>
