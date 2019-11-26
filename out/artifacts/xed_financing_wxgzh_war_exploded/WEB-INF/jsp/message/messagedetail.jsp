<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/commonStyle.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/message/messagedetail.css" />

<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>消息详情</title>
<script type="text/javascript">
function goDetails(flag)
{
	//资金明细
	if(flag==1)
	{
		window.location.href='<%=basePath%>capitaldetail/getAllCapitaldetail';
	}
	//优惠券
	else if(flag==2)
	{
		window.location.href='<%=basePath%>coupon/querycoupon';
	}
	//我的投资
	else if(flag==3)
	{
		window.location.href='<%=basePath%>investrecord/queryinvest';
	}
	//中奖纪录
	else if(flag==4)
	{
		window.location.href='<%=basePath%>awardrotate/gotomyaward';
	}
	//鱼干明细 
	else if(flag==5)
	{
		window.location.href='<%=basePath%>scorecenter/queryscoredetail';
	}
	//我的转让
	else if(flag==6)
	{
		window.location.href='<%=basePath%>investrecord/queryinvest?flag=2';
	}
	//债权转让
	else if(flag==7)
	{
		window.location.href='<%=basePath%>bondTransfer/getBondTransfer';
	}
	//我的猫咪宝
	else if(flag==8)
	{
		window.location.href='<%=basePath%>freedomsubject/toMyFreedom';
	}
	//联系客服
	else if(flag==9)
	{
		window.location.href='<%=basePath%>loginregister/s/goCustomer';
	}
	//收货地址
	else if(flag==10)
	{
		window.location.href='<%=basePath%>accountaddress/toaccountaddress';
	}
	

}
</script>
</head>
<body>
	<div id="wrap">
			<p><img src="images/back.png" class="back"  onclick="toBack()"/>消息详情</p>
			<ul>
				<li>
				<b>
					${msgBean.msgTitle}
				</b>	
				<p>
					${msgBean.msgContent}
				</p>
				<p>
					${msgBean.addTime}
				</p>
				</li>
			</ul>
		
		</div>
</body>
	<script type="text/javascript">
			function toBack()
			{
				window.location.href='<%=basePath%>message/querymessage';
			}
			
		</script>
</html>