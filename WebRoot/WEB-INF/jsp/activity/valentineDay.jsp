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
<title>七夕活动</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<style type="text/css">
.wrap {
	width: 100%;
	background-image: url(images/qx-bg.png);
	background-size: 100% 100%;
	min-height: 1000px;
	background-position-y: -40px;
}

.title {
	width: 100%;
	position: relative;
	text-align: center;
	font-size: 20px;
	color: #333333;
	font-weight: 600;
	height: 40px;
	line-height: 40px;
	background-color: #F7F7F7;
}

.back {
	position: absolute;
	left: 20px;
	top: 14px;
	width: 10px;
	height: 15px;
}

.qx_bg {
	width: 100%;
}

.textBox {
	width: 100%;
	padding-top: 90%;
}

.textBox table {
	width: 100%;
}

.textBox table th {
	position: relative;
}

.textBox span {
	display: inline-block;
	display: none;
	width: 25px;
	height: 25px;
	line-height: 25px;
	background-image: url(images/qx-countnumber.png);
	background-size: 100% 100%;
	background-repeat: no-repeat;
	background-position: center;
	text-align: center;
	font-weight: bold;
	position: absolute;
	right: 0px;
	top: 0px;
}

.textBox .hasText {
	display: block;
}

.textBox img {
	width: 100%;
}
/*按钮可以合成*/
.hecheng_s {
	display: inline-block;
	width: 40%;
	height: 40px;
	line-height: 40px;
	font-size: 18px;
	color: white;
	border-radius: 20px;
	background-color: #ff4398;
	margin-left: 30%;
	margin-top: 15%;
	text-align: center;
}

.hecheng_s:active {
	position: relative;
	top: 1px;
}
/*按钮不能合成*/
.hecheng_f {
	display: inline-block;
	width: 40%;
	height: 40px;
	line-height: 40px;
	font-size: 18px;
	color: white;
	border-radius: 20px;
	background-color: #757575;
	margin-left: 30%;
	margin-top: 15%;
	text-align: center;
}

.qx-title {
	width: 80%;
	margin: 0 auto;
	margin-top: 10%;
	color: white;
	font-weight: bold;
	font-size: 16px;
	text-align: center;
	padding: 15px 0;
	background-image: url(images/qx-titlebox-1.png);
	background-size: 100% 100%;
	background-repeat: no-repeat;
	background-position: center;
}

.qx-textbox {
	background-image: url(images/qx-textbox.png);
	background-size: 100% 100%;
	background-repeat: no-repeat;
	background-position: center;
	width: 80%;
	margin: 0 auto;
	margin-top: 10%;
	padding: 5% 5%;
	color: white;
	font-size: 16px;
	font-weight: bold;
	line-height: 25px;
}

.qx-textbox p {
	text-indent: 25px;
	/*margin-bottom: 5%;*/
}

.copyright, .service {
	font-size: 12px;
	color: white;
	text-align: center;
	line-height: 20px;
	padding: 10px;
}
</style>
<script type="text/javascript">
function grantrewards(){
	$.ajax({
		url:"<%=basePath%>activity/grantrewards",
		type: "POST",
		success:function(data){
			var a =  eval('('+data+')');
			if(a.result==='error'){
				alert('系统异常');
			}else if(a.result==='success'){
				alert('兑换成功,28元现金券已发送至您的账户,请在我的优惠券中查看');
				window.location.href='<%=basePath%>activity/s/goactivity';
			}else if(a.result==='lack'){
				alert('未集齐,请继续努力');
			}
		}
	});
}

function goback(){
	window.location.href='<%=basePath%>capital/querycapital';
}
</script>

</head>

<body>
	<div class="wrap">
		<div class="title">
			<img src="images/back.png" onclick="goback()" class="back" />情定七夕
		</div>
		<div class="textBox">
			<!--右上角数字，只有在字是红色时候才显示  对应class名 hasText-->
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th>
						<c:if test="${counts.niu>0}"><img src="images/qx-niur.png" /> <span class="count hasText">${counts.niu}</span></c:if>
						<c:if test="${counts.niu==0}"><img src="images/qx-niug.png" /> <span class="count">${counts.niu}</span></c:if>
					</th>
					<th>
						<c:if test="${counts.lang>0}"><img src="images/qx-langr.png" /> <span class="count hasText">${counts.lang}</span></c:if>
						<c:if test="${counts.lang==0}"><img src="images/qx-langg.png" /> <span class="count">${counts.lang}</span></c:if>
					</th>
					<th>
						<c:if test="${counts.zhi>0}"><img src="images/qx-zhir.png" /><span class="count hasText">${counts.zhi}</span></c:if>
						<c:if test="${counts.zhi==0}"><img src="images/qx-zhig.png" /><span class="count">${counts.zhi}</span></c:if>
					</th>
					<th>
						<c:if test="${counts.nv>0}"><img src="images/qx-nvr.png" /><span class="count hasText">${counts.nv}</span></c:if>
						<c:if test="${counts.nv==0}"><img src="images/qx-nvg.png" /><span class="count">${counts.nv}</span></c:if>
					</th>
				</tr>

			</table>
			<!--四个字每个至少有一个的时候 可以合成hecheng_s   否则不能合成hecheng_f-->
			<c:if test="${counts.niu>0&&counts.lang>0&&counts.zhi>0&&counts.nv>0}">
				<a href="javascript:grantrewards()" class="hecheng_s">合成</a>
			</c:if>
			<c:if test="${counts.niu==0||counts.lang==0||counts.zhi==0||counts.nv==0}">
				<a href="javascript:void(0)" class="hecheng_f">合成</a>
			</c:if>

			<p class="qx-title">七夕夜深人静时，牛郎织女夜相会</p>
			<div class="qx-textbox">
				<p>一年一度的七夕情人节就要来临了，在这个甜蜜的日子里，猫咪财富又要放大招啦！</p>
				<p>1.自8月25日至8月31日期间，小伙伴们只要通过投资爆款标、签到、债权承接、充值鱼干包括转盘抽到未中奖就有可能收集到“牛、郎、织、女”里的一个字，凡是集满“牛郎织女”四个字的小伙伴，可在下面点击合成按钮，即可领取28元现金券奖励。此活动可重复合成领取现金券奖励！
				</p>
				<p>
					2.在七夕节当天，猫咪财富会上一款带有“情定七夕”样式的活动标凡是小伙伴通过此活动标投资满1000元，即可获得38元现金券。</p>
				<p></p>
			</div>
			<p class="qx-title">活动规则</p>

			<div class="qx-textbox">
				<p>1.活动时间8.25~8.31,9.1 00:00:00以后不再以任何方式获得活动文字,所收集的文字会在活动结束后第二天统一清除。希望集满的小伙伴不要忘记使用！
				</p>

				<p>2.小伙伴在七夕当天的活动标投满1000元后，可联系猫咪财富客服领取现金券奖励。</p>
			</div>

			<p class="copyright">本活动最终解释权归猫咪财富所有</p>
			<p class="service">
				有任何问题请致电：400-000-3060 <br/>或 客服微信号 18105181539
			</p>
		</div>
	</div>
</body>
</html>
