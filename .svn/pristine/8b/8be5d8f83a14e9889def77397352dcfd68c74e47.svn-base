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
<title>账号设置</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html, body {
	/*background-color: whitesmoke;*/
	width: 100%;
	text-align: center;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
}

.back {
	position: absolute;
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}

#wrap p:nth-child(1) {
	font-size: 18px;
	color: #333;
	background-color: #f7f7f7;
	text-align: center;
	padding: 10px;
	border-bottom: 1px solid #EEEEEE;
}

table {
	width: 100%;
	height: 100px;
	text-align: center;
	/*border-top: 5px solid burlywood;*/
	font-size: 14px;
	/*background-color: gray;*/
}

img {
	width: 100%;
}

input[type="text"] {
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
	padding: 0 1em;
	text-decoration: none;
	width: 90%;
}

input[type="text"]:focus {
	border: 1px solid #FFC040;
}

.myButton {
	color: #555;
	height: 40px;
	width: 75%;
	border-radius: 4px;
	border: 1px solid #FFC040;
	background-color:#FFC040;
	margin-top: 20px;
}
.myButton_no{
	
	color: #555;
	height: 40px;
	width: 75%;
	border-radius: 4px;
	border: 1px solid #f7f7f7;
	background-color: #f7f7f7;
	margin-top: 20px;
}
.myButton:active {
	position: relative;
	top: 1px;
}
</style>


</head>

<body>
	<div id="wrap">
		<p>
			<a href="javascript:getBack();"><img src="images/back.png"
				class="back" /></a>修改用户名
		</p>
		<ul>
			<li>
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th style="width: 26%; font-size: 16px; color: #555;">新用户名</th>
						<th style="width: 74%;"><input type="text" name="accountName"
							id="accountName" value="" placeholder="用户名只能修改一次" /></th>
					</tr>

				</table>
			</li>
			<li style="width: 100%; text-align: center;"><input
				type="button" class="myButton" id="button" onclick="change()" value="确认修改" /></li>
			
		</ul>
	</div>



	<!-- <form id="account" action="" method="post">
		<input type="text" name="accountName" id="accountName" />
		<input type="button" id="button" value="确认" />
	</form>  -->
</body>
<script type="text/javascript">
//返回上一页
function getBack(){
	window.location.href='<%=basePath%>accountinfo/personalSettings';
}
	//检查用户名是否存在
	function check(){
		var accountName=$("#accountName").val();
		$.ajax({
			url:"<%=basePath%>accountinfo/checkName",
			type : 'POST',
			data : {
				accountName:encodeURI(accountName)
			},
			success:function(data){
				if(data.result==='error'){
					alert('该用户名已被占用,请更换');
					$("#accountName").val('');
					return false;
				}else{
					if(confirm("用户名只能修改一次，是否确认修改")){
						$.ajax({
							url:"<%=basePath%>accountinfo/changeName",
							type: "POST",
							data : {
								accountName : encodeURI(accountName)
							},
							success:function(data){
								if(data.result==='noLogin'){
									alert('登录超时');
									window.location.href='<%=basePath%>loginregister/s/toLogin';
								}else if(data.result==='success'){
									alert('修改成功，奖励的10鱼干已发放至账户');
									window.location.href='<%=basePath%>accountinfo/personalSettings';
								} else if(data.result==='error'){
									alert('系统错误');
									window.location.href='<%=basePath%>accountinfo/personalSettings';
								}
							}
						});
					}
				}
			}
		});
	}
	//修改用户名
	function change(){
		var accountName=$("#accountName").val();
		if(!verifyVal(accountName,"accountName","用户名")){
			return;
		}
		check();
	}
</script>
</html>
