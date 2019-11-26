<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<link rel="stylesheet" type="text/css" href="css/commonStyle.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script src="js/layer/layer.js"></script>
<script src="js/checkgold/checkgold.js"></script>
<title>自动投标</title>
<style type="text/css">
.wrap {
	width: 100%;
	background-color: white;
}

.wrap .head {
	position: relative;
}

.wrap .head img {
	width: 100%;
	margin-bottom: 20px;
}

.wrap .head p {
	width: 100%;
	text-align: center;
	position: absolute;
	color: white;
	z-index: 11;
}

.wrap .head p:nth-child(2) {
	top: 25%;
}

.wrap .head p:nth-child(2) span {
	font-size: 24px;
}

.wrap .head p:nth-child(3) {
	top: 40%;
	font-size: 12px;
}

.toRule {
	display: inline-block;
	padding: 10px;
	position: absolute;
	right: 0;
	top: 0;
	color: white;
}

.space {
	width: 100%;
	height: 10px;
	background-color: #F6F4F4;
}

.filtrate table {
	width: 100%;
	background-color: white;
	text-align: center;
}

.filtrate table th {
	width: 50%;
	padding: 15px 0;
	color: #333333;
}

.filtrate table th select {
	background-color: white;
	border: none;
	outline: none;
	-webkit-appearance: none;
	color: #fb751e;
	;
}

.auto-bid-tips {
	padding: 10px 20px;
	line-height: 25px;
	background-color: #f6f4f4;
	color: #BDBDBD;
}

.my-yue {
	overflow: hidden;
	padding: 5px 15px;
	color: #fb761e;
	font-size: 14px;
	line-height: 40px;
	height: 40px;
	position: relative;
}

.my-yue span {
	display: inline-block;
}

.my-yue span:nth-child(2) {
	width: 45px;
	height: 24px;
	position: absolute;
	right: 20px;
	top: 12px;
	border: 1px solid #FB751E;
	border-radius: 8px;
	text-align: center;
	line-height: 24px;
}

.auto-bid-input {
	padding: 5px 15px;
	height: 45px;
	padding-top: 15px;
}

.auto-bid-input input {
	width: 100%;
	border: none;
	outline: none;
	border: 1px solid #E0E0E0;
	height: 43px;
	border-radius: 20px;
	text-indent: 15px;
}

.auto-bid-range {
	padding: 5px 15px;
	padding-top: 20px;
}

.auto-bid-range span {
	color: #FB751E;
	font-size: 12px;
}

.auto-bid-range span:nth-child(2) {
	float: right;
}

.srs {
	display: block;
	width: 100%;
	margin: 20px auto;
	padding: 20px;
	font-size: 16px
}

.srs-slider {
	position: relative;
	margin: 25px auto;
	display: block;
	width: 100%;
	height: 50px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none
}

.srs-slider::before, .srs-slider::after {
	content: '';
	display: table
}

.srs-slider::after {
	clear: both
}

.srs-track {
	position: absolute;
	left: 40px;
	right: 40px;
	top: 25px;
	height: 2px;
	background: #e9e9e9
}

.srs-thumb {
	position: absolute;
	top: -25px;
	left: -25px;
	width: 0px;
	height: 0px;
	color: #fff;
	font-size: 18px;
	background: #fff !important;
	text-align: center;
	border-radius: 50%;
	cursor: ew-resize;
	/*z-index: -1;*/
	/*opacity: 0;*/
}

.srs-thumb span {
	position: absolute;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
	opacity: 1;
}

.srs-bubble {
	position: absolute;
	/*top: -30px;*/
	left: 0px;
	opacity: 1;
}

.srs-bubble span {
	width: 45px;
	height: 18px;
	line-height: 18px;
	display: inline-block;
	text-align: center;
	font-size: 12px;
	color: #fff;
	background: #FB751E;
	border-radius: 5px
}

.srs-bubble:before {
	content: '';
	background: #FB751E;
	position: absolute;
	left: 50%;
	bottom: -25px;
	margin-left: -5px;
	width: 10px;
	height: 10px;
	-webkit-transform: rotate(45deg);
	transform: rotate(45deg)
}

.srs-minus {
	position: relative;
	float: left
}

.srs-plus {
	position: relative;
	float: right
}

.srs-minus, .srs-plus {
	top: 10px;
	width: 25px;
	height: 25px;
	/*color: #333;*/
	/*font-size: 18px;*/
	/*border: 2px solid #e9e9e9;*/
	border-radius: 50%;
	cursor: pointer
}

.srs-minus span, .srs-plus span {
	display: none;
}

.srs-minus {
	background-image: url(images/wx-autobid-minus.png);
	background-size: 100% 100%;
}

.srs-plus {
	background-image: url(images/wx-autobid-add.png);
	background-size: 100% 100%;
}

.edit-box {
	width: 55%;
	margin: 0 auto;
	height: 40px;
	line-height: 40px;
	text-align: center;
	margin-top:30px;
	color: white;
	/*position: fixed;*/
	/*bottom: 0%;*/
	/*left: 22.5%;*/
	background-image: url(images/zdtb-btn.png);
	background-size: 100% 100%;
	font-size: 16px;
	margin-bottom: 20px;
}

.edit-box-after {
	width: 55%;
	margin: 0 auto;
	height: 40px;
	line-height: 40px;
	text-align: center;
	color: white;
	position: fixed;
	bottom: 10%;
	left: 22.5%;
	background-image: url(images/zdtb-btn.png);
	background-size: 100% 100%;
}
.auto-bid-show{
				text-align: center;
				font-size: 18px;
				color: #FB751E;
				padding: 10px 0;
				border-bottom: 1px solid #E0e0e0;
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="head">
			<img src="images/wx-autobid-head-bg.png" />
			<p>
				最高 <span>16.00%</span>
			</p>
			<p>参考年回报率</p>
			<span class="toRule" onclick="goRule()">查看规则</span>
		</div>
		<div class="space"></div>
		<div class="filtrate">
			<c:choose>
				<c:when test="${autobid==null || autobid.status!=1}">
					<table border="0" cellspacing="" cellpadding="">
						<tr style="border-bottom: 1px solid #E0e0e0;">
							<th>投标期限</th>
							<th><select id="lowerLimit" style="margin-right: 20px;color: #fb751e;">
									<option value="-1">不限</option>
									<c:forEach var="i" begin="1" end="36">
										<option value="${i}">${i}月</option>
									</c:forEach>
							</select> <select id="upperLimit">
									<option value="99">不限</option>
									<c:forEach var="i" begin="1" end="36">
										<option value="${i}">${i}月</option>
									</c:forEach>
							</select></th>
						</tr>
						<%-- <tr>
							<th>投标金额</th>
							<th><select id="money">
									<c:forEach var="i" begin="0" end="${accountLevel}">
										<option value="${1000+i*5000}">${1000+i*5000}元</option>
									</c:forEach>
							</select></th>
						</tr> --%>
					</table>
				</c:when>
				<c:otherwise>
					<table border="0" cellspacing="" cellpadding="">
						<tr style="border-bottom: 1px solid #E0e0e0;">
							<th>投标期限</th>
							<th><select disabled="disabled" style="margin-right: 20px;color: #fb751e;">
									<c:choose>
										<c:when test="${autobid.lowerLimit==-1}">
											<option>不限</option>
										</c:when>
										<c:otherwise>
											<option>${autobid.lowerLimit}月</option>
										</c:otherwise>
									</c:choose>
							</select> <select disabled="disabled">
									<c:choose>
										<c:when test="${autobid.upperLimit==99}">
											<option>不限</option>
										</c:when>
										<c:otherwise>
											<option>${autobid.upperLimit}月</option>
										</c:otherwise>
									</c:choose>
							</select></th>
						</tr>
						<%-- <tr>
							<th>投标金额</th>
							<th><select disabled="disabled">
									<option>${autobid.money}元</option>
							</select></th>
						</tr> --%>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="auto-bid-tips">
				投标期限设置为：不限-不限，则视为1-36个月；VIP0级用户 1000元档，每一级多5000元档，取消后重新排队。
		</div>
		<div class="my-yue">
			<span>我的余额：¥${cap}</span>
		</div>
		
		<c:choose>
			<c:when test="${autobid==null || autobid.status!=1}">
				<div class="auto-bid-show">
					<!-- <input type="number" name="" id="money" value="" placeholder="请输入您预期出借金额" /> -->
					预约金额：1000元
				</div>
				<div class="auto-bid-range">
					<span class="auto-bid-range-floor">1000</span>
					<span class="auto-bid-range-ceiling">${1000+accountLevel*5000}</span>
					<div class="auto-bid-range-inner">
						<input id="example-3" name="example-3" type="number" min="1000" max="${1000+accountLevel*5000}" step="5000" value="1000" data-color="#12C7AC" class="srs">
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="auto-bid-show">
					预约金额：${autobid.money}元
					<%-- <input type="number" name="" id="money" value="${autobid.money}" placeholder="请输入您预期出借金额" /> --%>
				</div>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${autobid==null || autobid.status!=1}">
				<div class="edit-box" onclick="bid()">保存设置</div>
			</c:when>
			<c:otherwise>
				<div class="edit-box" onclick="cancel()">取消预约</div>
			</c:otherwise>
		</c:choose>
		<%-- <div class="space"></div>
		<div class="auto-bid-tips">投标期限设置为：不限-不限
			则视为1月-36个月；VIP0级用户1000元档，每一级多5000元档，取消后重新排队。</div>

		<c:choose>
			<c:when test="${autobid==null || autobid.status!=1}">
				<div class="edit-box" onclick="bid()">保存设置</div>
			</c:when>
			<c:otherwise>
				<div class="edit-box" onclick="cancel()">取消预约</div>
			</c:otherwise>
		</c:choose> --%>
	</div>
	<input type="hidden" id="money" value="1000">
</body>
<script src="js/rangeSlide.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function bid(){
		var lowerLimit = $('#lowerLimit').val();
		var upperLimit = $('#upperLimit').val();
		var money = $('#money').val();
		if(parseInt(lowerLimit)>parseInt(upperLimit)){
			alert('投标期限上限不能小于下限!');
			return;
		}
		$.ajax({
	    	type: "POST",
	    	url: "<%=basePath%>autobid/addAutobid",
			data : {
				money:money,
				lowerLimit:lowerLimit,
				upperLimit:upperLimit
			},
			success : function(data) {
				var a = eval('(' + data + ')');
				if (a.result == 'success') {
					alert("预约成功");
					 window.location.href='<%=basePath%>capital/querycapital'; 
				} else if (a.result == 'notEnough') {
					alert("账户金额不足");
					window.location.href='<%=basePath%>capital/querycapital'; 
				}else if(a.result == 'haveBid'){
					alert("已有未取消预约");
					window.location.href='<%=basePath%>capital/querycapital'; 
				}else{
					alert("预约失败,请联系客服人员");
					window.location.href='<%=basePath%>capital/querycapital'; 
				}
			}
		});
	}
	
	function cancel(){
		if(confirm("确认取消吗？重新设置将会重新排队!")){
			$.ajax({
		    	type: "POST",
		    	url: "<%=basePath%>autobid/cancelAutobid",
				success : function(data) {
					var a = eval('(' + data + ')');
					if (a.result == 'success') {
						alert("取消成功");
						window.location.href='<%=basePath%>capital/querycapital'; 
					}else if(a.result == 'isCancel'){
						alert("请勿重复取消");
						window.location.href='<%=basePath%>capital/querycapital'; 
					} else {
						alert("数据异常，请联系客服人员");
						window.location.href='<%=basePath%>capital/querycapital'; 
					}
				}
			});
		}
	}
	
	function goRule(){
		window.location.href='<%=basePath%>autobid/goRule';
	}
</script>

</html>
