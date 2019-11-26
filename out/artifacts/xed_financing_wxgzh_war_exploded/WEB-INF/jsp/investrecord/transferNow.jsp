<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/commonStyle.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/investrecord/transferNow.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="<%=basePath%>js/validate.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>债权转让</title>

</head>
<body>
	<form action="" name="form1">
		<div id="wrap">
			<p>
				<img src="<%=basePath%>images/back.png" class="back" onclick="goBack()" />债权转让操作
			</p>
			
			<ul>
				
				<li style="border-bottom: 1px solid #E5E5E5;font-size: 50px;">
					<span><input type="text" name="creditRate"id="creditRate" value="" placeholder="请输入转让利率(%)" style="font-size: 16px;text-align: center;"/></span>
				</li>
				
			</ul>
			
			<div class="tips">
				<!--默认选中给下面的class变成 xz  未选择class 是wsz-->
				<span id="xz" class="wxz" onclick="changeStatus()"></span>
				<span>我已阅读并同意 <a href="javascript:toTransferContract(0);"> 《债权转让协议》 </a></span>
			</div>
			
			<p>
				<a  id="cjBtn" class="ljtz" onclick="transferBond(${investId},${investMoney })">立即转让</a>
			</p>
		
		</div>
	</form>
</body>
<script type="text/javascript">
//默认未选择  按钮置灰
$(document).ready(function() {
	$("#cjBtn").attr("onclick", ""); 
	$("#cjBtn").css("background-color", "#ebebeb"); 
	$("#cjBtn").css("color", "#b3b3b3");
});

//更改选择状态
function changeStatus()
{
	var xzclass=$("#xz").attr('class');
	if(xzclass=="wxz")
	{
		$("#xz").removeClass("wxz");
		$("#xz").addClass("xz");
		$("#cjBtn").attr("onclick", "transferBond(${investId},${investMoney })");
		$("#cjBtn").css("background-color", "#FEC63D"); 
	}
	else
	{
		$("#xz").removeClass("xz");
		$("#xz").addClass("wxz");
		$("#cjBtn").attr("onclick", ""); 
		$("#cjBtn").css("background-color", "#ebebeb"); 
		$("#cjBtn").css("color", "#b3b3b3");
	}
}

//债权转让
function transferBond(id,investMoney)
{
	//输入金额
	var creditRate =$("#creditRate").val();
	if(!verifyVal(creditRate,"rateValue","转让利率")){
		return;
	}
	if(creditRate>36)
	{
		alert("转让利率不得大于36%,请重新输入");
		return;
	}
	else
	{
		$.ajax({
			url:"<%=basePath%>investrecord/transferBond",
			type: "POST",		
			data:{
				investId:id,
				creditRate:creditRate
			},
			success:function(data){
				if(data.result=='success')
				{
					alert("转让成功");
					window.location.href='<%=basePath%>investrecord/queryinvest';
				}
				else 
				{
					alert("转让失败");
				}
			}
		});
	}
}

function goBack(){
	window.location.href='<%=basePath%>investrecord/queryinvest';
}

function toTransferContract(type)
{
	window.location.href='<%=basePath%>investrecord/transfercontract?type='+type;
}
</script>
</html>