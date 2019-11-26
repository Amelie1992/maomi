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
<script type="text/javascript" src="js/isWeixin.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<title>账号设置</title>
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
	<form id="form" action="<%=basePath%>accountinfo/chooseBank"
		method="post">
		<div class="wrap">
			<input id="bankId" name="bankId" type="hidden"
				value="${bankcard.bankCode}" />
			<div class="title">
				<img src="images/back.png" class="back" onclick="getBack()" />绑定银行卡
			</div>
			<ul class="content">
				<li onclick="chooseBank()"><span class="contentLeft">选择银行</span>
					<c:if test="${bankcardBean.bankName!=null}">
						<span class="contentLeftImg"><img class="imgLeft"
							src="images/${bankcardBean.bankPic}"
							style="width: 25px; height: 25px;" /></span>
					</c:if> <span class="contentRight"><c:if
							test="${bankcard.bankName!=null}">${bankcard.bankName}</c:if>&nbsp;&nbsp;&nbsp;&nbsp;<img
						src="images/go.png" class="go" /></span></li>
				<li><span class="contentLeft">银行卡号</span> <span
					class="contentLeft_2"><input onchange="check()" type="text" name="bankCard"
						id="bankCard" value="${bankcard.bankCard}" placeholder="请输入银行卡号" /></span></li>
				<li><span class="contentLeft">所在省份</span> <span
					class="contentLeft_2"> <select id="province" name="province">
							<option value="">请选择</option>
							<c:forEach items="${provinceList}" var="p">
								<option
									<c:if test="${p.cityCode==bankcard.province}"> selected="selected" </c:if>
									value="${p.cityCode}">${p.cityName}</option>
							</c:forEach>
					</select>
				</span></li>
				<li><span class="contentLeft">所在城市</span> <span
					class="contentLeft_2"> <select id="bankCity" name="bankCity">
							<option value="">请选择</option>
							<c:forEach items="${cityList}" var="c">
								<option
									<c:if test="${c.cityCode==bankcard.bankCity}"> selected="selected" </c:if>
									value="${c.cityCode}">${c.cityName}</option>
							</c:forEach>
					</select>
				</span></li>
				<li><span class="contentLeft">开户行</span> <span
					class="contentLeft_2"><input onchange="check()" type="text" name="bankOpening"
						id="bankOpening" value="${bankcard.bankOpening}"
						placeholder="请输入开户行" /> </span></li>

			</ul>
			<p class="tips">该卡为提现卡，请确认信息填写，否则影响资金到账</p>
			<div id="bind" class="tijiao_f">绑定</div>
		</div>
	</form>
</body>
<script type="text/javascript">
//返回上一页
function getBack(){
	window.location.href='<%=basePath%>accountinfo/personalSettings';
}
	
//修改省份，变更市区
$("#province").change(function(){
	var province = $('#province').val();
	$.ajax({
		url:"<%=basePath%>accountinfo/getCity",
		type: "POST",
		data : {
			province : province
		},
		success:function(data){
			var a = eval(data);
	 		var str="<option value>请选择</option>";
	 		$(a).each(function(i,o){
	 			str+="<option value='"+o.cityCode+"'>"+o.cityName+"</option>";
	 		});		
	 		$("#bankCity").html(str);
		}
	});
});

//选择银行
function chooseBank(){
	$("#form").submit();
}

//文档加载完毕检查信息是否填写完成
$(function(){
	check();
});

//检查信息是否填写完成，控制按钮开关
function check(){
	var bankId=$("#bankId").val();
	var bankCity=$("#bankCity").val();
	var bankOpening=$("#bankOpening").val();
	var bankCard=$("#bankCard").val();
	if(!objIsNullOrEmptyNoMsg(bankId)){
		$("#bind").prop("class","tijiao_f");
		$("#bind").attr("onclick","");
		return;
	}
	if(!objIsNullOrEmptyNoMsg(bankCity)){
		$("#bind").prop("class","tijiao_f");
		$("#bind").attr("onclick","");
		return;
	}
	if(!objIsNullOrEmptyNoMsg(bankOpening)){
		$("#bind").prop("class","tijiao_f");
		$("#bind").attr("onclick","");
		return;
	}
	if(!objIsNullOrEmptyNoMsg(bankCard)){
		$("#bind").prop("class","tijiao_f");
		$("#bind").attr("onclick","");
		return;
	}
	$("#bind").prop("class","tijiao_s");
	$("#bind").attr("onclick","bindBank()");
	
}
//绑定银行
function bindBank(){
	var bankId=$("#bankId").val();
	var bankCity=$("#bankCity").val();
	var bankOpening=$("#bankOpening").val();
	var bankCard=$("#bankCard").val();
	
	$.ajax({
		url:"<%=basePath%>accountinfo/bindBankCard",
		type : "POST",
		data : {
			bankId : bankId,
			bankCity : bankCity,
			bankOpening : bankOpening,
			bankCard : bankCard
		},
		success:function(data){
			var a = eval(data);
			if(a.result==='error'){
				alert('系统异常');
				window.location.href='<%=basePath%>accountinfo/personalSettings';
			}else if(a.result==='success'){
				alert('修改成功');
				window.location.href='<%=basePath%>accountinfo/personalSettings';
			}else if(a.result==='score'){
				alert('绑定成功,奖励的10鱼干已发放至账户');
				window.location.href='<%=basePath%>accountinfo/personalSettings';
			}
		}
	});
}
</script>
</html>
