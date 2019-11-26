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
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<title>绑定微信</title>
<style type="text/css">
.wrap {
	width: 100%;
}

.title {
	width: 100%;
	position: relative;
	text-align: center;
	font-size: 17px;
	color: #333333;
	font-weight: 600;
	height: 50px;
	line-height: 50px;
	background-color: #F7F7F7;
}

.back {
	position: absolute;
	left: 20px;
	top: 15px;
	width: 11px;
	height: 16px;
}

.content {
	width: 100%;
	/*padding-left: 10px;*/
	text-indent: 20px;
}

.content li {
	width: 100%;
	height: 50px;
	line-height: 50px;
	border-bottom: 1px solid #EEEEEE;
	font-size: 15px;
}

.contentLeft {
	float: left;
	font-size: 14px;
	width: 28%;
}

.contentLeftImg {
	float: left;
	font-size: 14px;
	width: 14%;
}

.contentLeft_2 {
	float: left;
	font-size: 14px;
	width: 70%;
	padding: 0px;
	margin: 0px;
}

.imgLeft {
	float: left;
	font-size: 14px;
	margin-top: 12px;
	margin-left: 25px;
}

.contentRight {
	float: right;
	margin-right: 30px;
	position: relative;
	color: #C3C3C3;
}

.go {
	line-height: 50px;
	width: 10px;
	height: 14px;
}

.content li span img:nth-child(2) {
	
}

::-webkit-input-placeholder {
	color: #C3C3C3;
	padding-left: 5px;
	font-size: 16px;
}
/* 使用webkit内核的浏览器 */
:-moz-placeholder {
	color: #C3C3C3;
	text-align: center;
	font-size: 16px;
}
/* Firefox版本4-18 */
::-moz-placeholder {
	color: #C3C3C3;
	text-align: center;
	font-size: 16px;
}
/* Firefox版本19+ */
:-ms-input-placeholder {
	color: #C3C3C3;
	text-align: center;
	font-size: 16px;
}
/* IE浏览器 */
input[type="text"] {
	height: 40px;
	width: 90%;
	/*width: 180px;*/
	border: 0;
	/*color: blue;*/
	color: #C3C3C3;
}

input[type="text"]:focus {
	height: 40px;
	border: 0;
	outline: none;
}

select {
	font-size: 16px;
	border: 0px;
	height: 40px;
	width: 90%;
	/*width: 180px;*/
	/*color: blue;*/
	color: #C3C3C3;
}

select:focus {
	border: 0;
}

.tips {
	height: 50px;
	line-height: 50px;
	font-size: 12px;
	color: #C3C3C3;
	text-indent: 20px;
	margin-bottom: 15px;
}
/*资料不完整*/
.tijiao_f {
	width: 80%;
	height: 37px;
	line-height: 37px;
	background-color: #dddddd;
	color: white;
	font-size: 18px;
	margin: 0 auto;
	text-align: center;
	border-radius: 3px;
}
/*资料完整*/
.tijiao_s {
	width: 80%;
	height: 37px;
	line-height: 37px;
	background-color: #ffbf41;
	color: white;
	font-size: 18px;
	margin: 0 auto;
	text-align: center;
	border-radius: 3px;
}
</style>
</head>

<body>
	<div id="wrap">
		<div class="title">
			<img src="images/back.png" class="back" onclick="goBack()" />绑定微信
		</div>
		<ul class="content">
			<li>
				<span class="contentLeft">微信号</span>
				<span class="contentLeft_2">
					<input type="text" name="accountWX" id="accountWX" value="${accountInfo.accountWX }" placeholder="输入微信号" />
				</span>
			</li>
			<!-- <li>
				<span class="contentLeft">身份证号</span>
				<span class="contentLeft_2">
					<input type="text" name="idCard" id="idCard" value="" placeholder="" />
				</span>
			</li>
			<li>
				<span class="contentLeft">所在城市</span>
				<span class="contentLeft_2">
					<select id="accountSex" name="accountSex">
						<option value="0" selected="selected">男</option>
						<option value="1">女</option>
					</select>
				</span>
			</li> -->
		</ul>
		<p class="tips">第一次绑定成功赠送鱼干</p>
		<div id="bind" onclick="bindWX()" class="tijiao_s">确定</div>
	</div>

	<script type="text/javascript">
		//返回上一页
		function goBack(){
			window.location.href='<%=basePath%>accountinfo/moreInfo';
		}
		
		//绑定微信
		function bindWX(){
			var accountWX = $("#accountWX").val();
			if(!objIsNullOrEmpty(accountWX)){
				alert('请填微信号');
				return;
			}
			$.ajax({
				url:"<%=basePath%>accountinfo/bindWX",
				type : "POST",
				data : {
					accountWX : accountWX
				},
				success:function(data){
					if(data.result==='noLogin'){
						alert('登录超时');
						window.location.href='<%=basePath%>loginregister/s/toLogin';
					}else if(data.result==='success'){
						alert('修改成功');
						window.location.href='<%=basePath%>accountinfo/moreInfo';
					} else if(data.result==='error'){
						alert('系统错误');
						window.location.href='<%=basePath%>accountinfo/moreInfo';
					} else if(data.result==='score'){
						alert('绑定成功,奖励的10鱼干已发放至账户');
						window.location.href='<%=basePath%>accountinfo/moreInfo';
					}
				}
			});
		}
	</script>
</body>
</html>
