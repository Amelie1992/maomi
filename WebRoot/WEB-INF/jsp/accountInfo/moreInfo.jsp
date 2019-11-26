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
<title>账号设置</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

html, body {
	width: 100%;
	text-align: center;
	position: relative;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
	height: 40px;
	line-height: 40px;
}

th {
	font-weight: normal;
}

.back {
	position: absolute;
	left: 20px;
	top: 15px;
	width: 11px;
	height: 16px;
}

.go {
	width: 20px;
	height: 24px;
	border: none;
	padding-top: 9px;
}

img {
	
}

.title_li {
	border-bottom: 1px solid #EEEEEE;
	font-size: 20px;
	color: #333333;
	background-color: #F6F6F6;
}

.body_li {
	border-bottom: 1px solid #EEEEEE;
}

.d_left {
	padding-left: 8px;
	float: left;
	width: 28%;
	color: #555555;
	font-size: 14px;
	text-align: left;
	height: 40px;
}

.d_text2 {
	float: left;
	width: 60%;
	text-align: right;
	font-size: 12px;
	color: #808080;
	height: 40px;
	line-height: 20px;
}

.d_text {
	float: left;
	width: 60%;
	text-align: right;
	font-size: 12px;
	color: #808080;
	height: 40px;
}

.d_img {
	width: 8%;
	float: right;
	height: 40px;
}

</style>
<script type="text/javascript">
	//返回上一页
	function getBack(){
		window.location.href='<%=basePath%>accountinfo/personalSettings';
	}
	
	//邮箱验证
	function judgeEmail(){
		window.location.href='<%=basePath%>emailcheck/judgeEmailIsVerification';
	}
	
	//去绑定QQ
	function toBindQQ(){
		window.location.href='<%=basePath%>accountinfo/toBindQQ';
	}
	
	//去绑定微博
	function toBindWB(){
		window.location.href='<%=basePath%>accountinfo/toBindWB';
	}
	
	//去绑定微信
	function toBindWX(){
		<%-- window.location.href='<%=basePath%>accountinfo/toBindWX'; --%>
		if(confirm("是否绑定手机：" + $('#telephone').val() + " ?"))
		{
			window.location.href='<%=basePath%>loginregister/s/wxLogin/band';
		}
	}
	
	//去绑定其他联系方式
	function toBindContact(){
		window.location.href='<%=basePath%>accountinfo/toBindContact';
	}
</script>

</head>

<body>
	<input type="hidden" value="${accountInfo.telephone}" id="telephone"/>
		<div id="wrap">
			<ul>
				<li class="title_li"><a href="javascript:getBack();"><img src="images/back.png" class="back" /></a>更多信息</li>
				<li onclick="judgeEmail();" class="body_li">
					<div class="d_left">
						邮箱
					</div>
					<div class="d_text">
						<c:if test="${accountInfo.isEmailValidate==0}">
							未认证
						</c:if>
						<c:if test="${accountInfo.isEmailValidate==1}">
							${accountInfo.accountEmail}
						</c:if>
					</div>
					<div class="d_img">
						<img src="images/go.png" class="go"/>
					</div>
				</li>
				<li class="body_li" onclick="toBindQQ()">
					<div class="d_left">
						QQ
					</div>
					<div class="d_text">
						<c:if test="${accountInfo.accountQQ==''||accountInfo.accountQQ==null}">
							未绑定
						</c:if>
						<c:if test="${accountInfo.accountQQ!=''&&accountInfo.accountQQ!=null}">
							${accountInfo.accountQQ}
						</c:if>
					</div>
					<div class="d_img">
						<img src="images/go.png" class="go"/>
					</div>
				</li>
				<li class="body_li">
					<div class="d_left">
						微信
					</div>
					<c:if test="${accountInfo.accountWX==''||accountInfo.accountWX==null}">
					<div class="d_text" onclick="toBindWX()">
							未绑定
					</div>
					<div class="d_img">
						<img src="images/go.png" class="go"/>
					</div>
					</c:if>
					
					<c:if test="${accountInfo.accountWX!=''&&accountInfo.accountWX!=null}">
					<div class="d_text">
							已绑定
					</div>
					</c:if>
				</li>
				<li class="body_li" onclick="toBindWB()">
					<div class="d_left">
						微博
					</div>
					<div class="d_text">
						<c:if test="${accountInfo.accountWB==''||accountInfo.accountWB==null}">
							未绑定
						</c:if>
						<c:if test="${accountInfo.accountWB!=''&&accountInfo.accountWB!=null}">
							${accountInfo.accountWB}
						</c:if>
					</div>
					<div class="d_img">
						<img src="images/go.png" class="go"/>
					</div>
				</li>
				<li class="body_li" onclick="toBindContact()">
					<div class="d_left">
						其他联系方式
					</div>
					<div class="d_text">
						<c:if test="${accountInfo.accountContactPhone==''||accountInfo.accountContactPhone==null}">
							未绑定
						</c:if>
						<c:if test="${accountInfo.accountContactPhone!=''&&accountInfo.accountContactPhone!=null}">
							已绑定
						</c:if>
					</div>
					<div class="d_img">
						<img src="images/go.png" class="go"/>
					</div>
				</li>
			</ul>
	</div>
</body>
</html>
