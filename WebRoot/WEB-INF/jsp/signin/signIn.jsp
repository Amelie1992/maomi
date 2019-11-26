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
<title>每日签到</title>
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<link rel='stylesheet' href='css/signin.css' />
<style type="text/css">
/*签到弹窗*/
			.qd-mask {
				width: 100%;
				height: 100%;
				position: absolute;
				top: 0;
				left: 0;
				background-color: #BDbdbd;
				opacity: 0.8;
				background-image: url(images/qd-shadow-bg.png);
				background-size: 100% 100%;
				background-repeat: no-repeat;
				display: none;
			}
			
			.qd-content {
				width: 80%;
				height: 230px;
				background-image: url(images/alert-bg.png);
				background-position: center;
				background-size: 100% 100%;
				background-repeat: no-repeat;
				position: absolute;
				left: 10%;
				
				display: none;
			}
			
			@media only screen and (min-width: 319px) and (max-width: 321px) {
				.qd-content {
					width: 80%;
					left: 10%;
					top: 30%;
				}
			}
			
			@media only screen and (min-width: 374px) and (max-width: 376px) {
				.qd-content {
					width: 65%;
					left: 17.5%;
					top: 45%;
				}
			}
			
			@media only screen and (min-width: 413px) and (max-width: 415px) {
				.qd-content {
					width: 60%;
					left: 20%;
					top: 45%;
				}
			}
			@media only screen and (min-height: 811px) and (max-height: 813px) {
				.qd-content {
					width: 60%;
					left: 20%;
					top: 60%;
				}
			}
			#wrap .qd-content {
				text-align: center;
				font-size: 14px;
				color: #212121;
			}
			
			#wrap .qd-content p:nth-child(1) {
				width: 80%;
				margin-left: 10%;
				text-align: center;
				border-radius: 28px;
				margin-top: 85px;
				background-color: #f95d18;
				color: white;
				font-size: 16px;
				line-height: 30px;
			}
			
			#wrap .qd-content p span {
				color: #F95D18;
			}
			
			#wrap .qd-content p:nth-child(1) span {
				color: #fff000;
			}
			
			#wrap .qd-content p:nth-child(2),
			#wrap .qd-content p:nth-child(3),
			#wrap .qd-content p:nth-child(4) {
				width: 100%;
				margin-top: 10px;
			}
			
			#wrap .qd-content p:nth-child(4) {
				color: #F95D18;
			}
			
			.alert-close {
				margin-top: 30px;
			}
			
			.alert-close img {
				width: 28px;
				height: 28px;
			}

			#opration table{
				width: 90%;
				margin: 0 auto;
			}
			#opration table img{
				width: 100%;
			}
			
			.qd-mask {
				width: 100%;
				height: 100%;
				position: absolute;
				top: 0;
				left: 0;
				background-image: url(images/qd-shadow-bg.png);
				opacity: 0.8;
				display: none;
			}
			
			.qd-content {
				width: 80%;
				height: 230px;
				background-image: url(images/alert-bg.png);
				background-position: center;
				background-size: 100% 100%;
				background-repeat: no-repeat;
				position: absolute;
				left: 10%;
				top: 30%;
				display: none;
			}
			
			@media only screen and (min-width: 319px) and (max-width: 321px) {
				.qd-content {
					width: 80%;
					left: 10%;
				}
			}
			
			@media only screen and (min-width: 374px) and (max-width: 376px) {
				.qd-content {
					width: 65%;
					left: 17.5%;
				}
			}
			
			@media only screen and (min-width: 413px) and (max-width: 415px) {
				.qd-content {
					width: 60%;
					left: 20%;
				}
			}
			.qd-content{
				text-align: center;
				font-size: 14px;
				color: #212121;
			}
			.qd-content p:nth-child(1){
				width: 80%;
				margin-left: 10%;
				text-align: center;
				border-radius: 28px;
				margin-top: 85px;
				background-color: #f95d18;
				color: white;
				font-size: 18px;
				line-height: 40px;
			}
			.qd-content p span{
				color:#F95D18 ;
			}
			.qd-content p:nth-child(1) span{
				color:#fff000 ;
			}
			.qd-content p:nth-child(2),
			.qd-content p:nth-child(3),
			.qd-content p:nth-child(4){
				width: 100%;
				margin-top: 10px;
			}
			.qd-content p:nth-child(4){
				color: #F95D18;
			}
			.alert-close{
				margin-top: 35px;
			}
</style>

</head>
<body>
	<input type="hidden" id="signInDay" value="${signInDay}" />
	<input type="hidden" id="isSignIn" value="${isSignIn}" />
	
	<div class="qd-mask">
	</div>
	<div class="qd-content">
		<p>已累计签到<span id="count"></span>天</p>
		<p>本次签到获得<span>1</span>鱼干</p>
			<p id="getwin"></p>
			<p id="win"></p>
		<div>
			<img src="images/close-x.png" class="alert-close"/>
		</div>
	</div>
	
	<div class='calendar' id='calendar'>
		<p>
			<a href="javascript:getBack();"><img
				src="<%=basePath%>images/back.png" id="back" class="back" /></a>每日签到
		</p>
		<input type="hidden" id="basePath" value="<%=basePath%>">
			<div class="sign">
            <div class="signInvest">
            	<table border="0" cellspacing="" cellpadding="">
            		<tr>
            			<th style="border-right: 1px solid #D3D3D3;">当月累计签到</th>
            			<th>当月累计获得</th>
            		</tr>
            		<tr>
            			<td style="border-right: 1px solid #D3D3D3;">
            				<span>${countDay}</span>
            				天
            			</td>
            			<td>
            				<span>${countScore}</span>
            				鱼干
            			</td>
            		</tr>
            	</table>
            </div>
			</div>
		</div>
		<div id="opration">
			<%-- <input type="button" class="myButton" id="signBtn"
				onclick="signIn('<%=basePath%>')" value="签到" /> --%>
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<c:if test="${signY==1}">
						<th>
							<img onclick="signInY()" src="images/wx-grzx-bq.png" id="signBtnY" />
						</th>
					</c:if>
					<c:if test="${signY==0}">
						<th>
							<img src="images/wx-grzx-bkbq.png" id="signBtnY" />
						</th>
					</c:if>
					<th>
						<img src="images/wx-grzx-qd.png" onclick="signIn()" id="signBtn"/>
					</th>
				</tr>
			</table>
		</div>
		<!-- <input type="button" class="myButton" id="signY"
				onclick="signInY()" value="特权签到" /> -->
		<div id="signRule">
			签到规则以及奖励制度
			<ul>
				<li>1.每日签到可获得鱼干奖励</li>
				<li>2.累计签到满7天可额外获得5鱼干奖励,累计签到满20天可额外获得10鱼干奖励,当月满签可额外获得20鱼干奖励</li>
				<li>3.每月累计签到记录,月末清零</li>
				<li>4.V3及以上用户可以获得补签昨日的特权,需要消耗鱼干,只限补签昨日,不可跳签</li>
			</ul>
		</div>
		
</body>
<script type='text/javascript' src='js/signin.js'></script>
<script type="text/javascript">
function getBack(){
	window.location.href='<%=basePath%>capital/querycapital';
}


</script>
</html>
