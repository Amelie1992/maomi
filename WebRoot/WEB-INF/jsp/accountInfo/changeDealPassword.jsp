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
<title>修改交易密码</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
}

th {
	font-weight: normal;
}

.back {
	position: absolute;
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}

#wrap p:nth-child(1) {
	font-size: 20px;
	color: #333333;
	background-color: #F7F7F7;
	text-align: center;
	padding: 10px;
}

table {
	width: 100%;
	height: 100px;
	text-align: center;
	/*border-top: 5px solid burlywood;*/
	font-size: 16px;
	color: gray;
	/*background-color: gray;*/
}

img {
	width: 100%;
	margin: 0 auto;
}

input[type="password"] {
	box-sizing: border-box;
	/*text-align: center;*/
	font-size: 14px;
	height: 2.5em;
	border-radius: 4px;
	border: 1px solid #c8cccf;
	color: #6a6f77;
	-web-kit-appearance: none;
	-moz-appearance: none;
	outline: 0;
	text-decoration: none;
}

input[type="password"]:focus {
	border: 1px solid #FEC63D;
}

.myButton {
	background-color: #FEC63D;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: 1px solid #FEC63D;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 15px;
	/*font-weight: bold;*/
	padding: 6px 24px;
	text-decoration: none;
	width: 50%;
	/*text-shadow: 0px -1px 0px #5b6178;*/
}
</style>


</head>

<body>
	<div id="wrap">
		<p>
			<a href="javascript:getBack();"><img src="images/back.png"
				class="back" /></a>修改交易密码
		</p>
		<ul>
			<li>
				<table border="0" cellspacing="10" cellpadding="">
					<tr>
						<th style="width: 50%;">输入原交易密码</th>
						<th style="width: 50%;"><input type="password"
							name="oldDealPassword" id="oldDealPassword" value="" placeholder="6-16位，包含数字和字母"/></th>
					</tr>
					<tr>
						<th style="width: 50%;">设置新交易密码</th>
						<th style="width: 50%;"><input type="password"
							name="dealPassword" id="dealPassword" value="" placeholder="6-16位，包含数字和字母"/></th>
					</tr>
					<tr>
						<th style="width: 50%;">确认新交易密码</th>
						<th style="width: 50%;"><input type="password"
							name="password2" id="password2" value="" placeholder="6-16位，包含数字和字母"/></th>
					</tr>
				</table>
			</li>
			<li style="width: 100%; text-align: center;"><input
				type="button" class="myButton" id="button" value="确认修改" /></li>
			
		</ul>
	</div>
</body>
<script type="text/javascript">
//返回上一页
function getBack(){
	window.location.href='<%=basePath%>accountinfo/pwdManager';
}

	//修改交易密码
	$("#button").click(function(){
		var oldDealPassword = $("#oldDealPassword").val();
		var dealPassword = $("#dealPassword").val();
		var password2 = $("#password2").val();
		if(!verifyVal(oldDealPassword,"password","原交易密码")){
			return;
		}else if(!verifyVal(dealPassword,"password","新交易密码")){
			return;
		}else if(!sameWith(dealPassword,password2)){
			alert("输入的两次交易密码不一致");
			return;
		}
		$.ajax({
			type: "POST",
			url: "<%=basePath%>accountinfo/changeDealPassword",
			data : {
				oldDealPassword : oldDealPassword,
				dealPassword : dealPassword
			},
			success : function(data) {
				if(data.result==='unLogin'){
					alert('尚未登录，登录过期');
					window.location.href='<%=basePath%>loginregister/s/toLogin';
				}else if(data.result==='worry'){
					alert('原密码输入错误');
				}else if(data.result==='success'){
					alert('修改成功');
					window.location.href='<%=basePath%>accountinfo/pwdManager';
				}
			}
		});
	});
</script>
</html>
