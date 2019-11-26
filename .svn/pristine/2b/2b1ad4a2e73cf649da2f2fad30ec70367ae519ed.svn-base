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
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>

<title>国庆活动</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/nationalactivity/midautumnactivity.css" />
<script type="text/javascript" src="js/navigation.js"></script>
<script type="text/javascript">
	//跳转爆款列表
	function goInvest()
	{
		window.location.href="./subject/s/queryhighsubject"
	}
	//联系客服
	function goKefu()
	{
		window.location.href="./loginregister/s/goCustomer";
	}
	//返回首页
	function goBack()
	{
		window.location.href="./fontpage/s/queryFontPage";
	}
</script>
</head>

<body>
	<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()"/>中秋节
			</div>
			<div class="content">
				<img src="images/wx-zq-bg.png" style="min-height: 568px;width: 100%;" />
				<div class="inner">
					<img src="images/wx-zq-jxq.png" class="yhq" />
					<c:choose>
						<c:when test="${midAutunmCounts==0}">
							<p>
								很遗憾
							</p>
							<p>
								暂未获得领取资格
							</p>
							<img src="images/wx-zq-wytz.png" onclick="goInvest()"/>
						</c:when>
						<c:when test="${midAutunmCounts!=0&& midAutunmFlag!=0}">
							<p>
								奖励已发送
							</p>
							<p>
								注意查收
							</p>
							<!--投资满之后换src wx-zq-lxkf-->
							<img src="images/wx-zq-lxkf.png"  onclick="goKefu()" />
						</c:when>
						<c:otherwise>
							<p>
								恭喜您获得领取资格
							</p>
							<p>
								请联系客服领取
							</p>
							<!--投资满之后换src wx-zq-lxkf-->
							<img src="images/wx-zq-lxkf.png"  onclick="goKefu()" />
						</c:otherwise>
					</c:choose>
					
					
				</div>
			</div>
			<div class="copyRight">
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.中秋当天(10月4号)投资中秋活动标单笔满5000元可获得计息1个月的加息券，仅限一次（特殊渠道可参加，但无返点）。</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.本次活动加息券将在工作人员核实后于10月09号统一发放</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.您有任何问题请拨打咨询热线：400-000-3060或者客服微信：18105181539</p>
				<p style="text-align:center;">本活动最终解释权归猫咪财富所有</p>
			</div>
		</div>
		<jsp:include page="../navigation/emptyDiv.jsp" flush="true" />
			<div class="footer">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="toChange(this,1)"><img src="images/tab_home_sel.png" /></th>
						<th onclick="toChange(this,2)"><img src="images/tab_touzi_nor.png" /></th>
						<th onclick="toChange(this,3)"><img src="images/tab_mall_nor.png" /></th>
						<th onclick="toChange(this,4)"><img src="images/tab_geren_nor.png" /></th>
					</tr>
					<tr>
						<td class="currentChose">首页</td>
						<td>投资</td>
						<td>商城</td>
						<td>我</td>
					</tr>
				</table>
			</div>
</body>

</html>
