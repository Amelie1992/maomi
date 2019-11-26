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
<meta charset="UTF-8">

<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>猫咪财富-选择银行</title>
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

.wrap ul li {
	height: 50px;
	position: relative;
	margin-top: 10px;
}

.wrap ul li:hover {
	background-color: #fdffdf;
}

.bankPic {
	position: absolute;
	top: 5px;
	left: 10px;
}

.wrap .bankPic img {
	width: 40px;
	height: 40px;
}

.bankName {
	font-size: 18px;
	color: #333333;
	padding: 5px 0;
	font-weight: bold;
	margin-left: 60px;
}

.bankTips {
	color: #C3C3C3;
	padding: 5px 0;
	margin-left: 60px;
	border-bottom: 1px solid #EEEEEE;
}
</style>
<script type="text/javascript">
		function toBack()
			{
				window.location.href='<%=basePath%>capital/querycapital';
		}
</script>
</head>
<body>
	<div class="wrap">
		<div class="title">
			<img src="images/back.png" class="back" onclick="toBack()" />选择银行
		</div>
		<ul id="sf">
			<c:forEach items="${bankList }" var="i">
				<li>
					<div class="bankPic">
						<img src="images/${i.bankPic }" />
					</div>
					<p class="bankName">${i.bankName }</p> <input id="code"
					value="${i.bankCode }" type="hidden" /> <input id="img"
					value="${i.bankPic }" type="hidden" /> <input id="bankName"
					value="${i.bankName }" type="hidden" />
					<p class="bankTips">单笔5万，单日50万</p>
				</li>
			</c:forEach>
		</ul>
	</div>
	<form action="" id="form1" method="post">
		<input id="codes" value="" type="hidden" name="codes"/> <input id="imgs" value=""
			type="hidden" name="imgs"/> <input id="bankNames" name="bankNames" value="" type="hidden" />
	</form>
</body>
<script type="text/javascript">
	window.onload = function() {
		var obj_lis = document.getElementById("sf").getElementsByTagName("li")
		for (i = 0; i < obj_lis.length; i++) {
			obj_lis[i].onclick = function() {
				
				$("#imgs").val(this.childNodes[7].value);
				$("#bankNames").val(this.childNodes[9].value);
				form1.action = '<%=basePath%>withdraw/rechargeInfo';
				form1.submit();
			}
		}
	}
</script>
</html>

