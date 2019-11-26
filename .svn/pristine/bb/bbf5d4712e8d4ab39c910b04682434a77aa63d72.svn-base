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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/message/messagelist.css" />

<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>消息列表</title>
</head>
<body>
	<form action="" id="gotodetailFrm" method="post">
    	<input type="hidden" id="msgId"  name="msgId" value=""/>
    </form>
	<div id="wrap">
			<p style="line-height:25px;"><img src="images/back.png" class="back" onclick="toBack()"/>消息列表
				
			</p>
			<p class="set">
				<a>有<span class="noReader">${noReadMessage }</span>条未读</a>
				<a onclick="delMessage()" class="clear">清空</a>
				<a onclick="isReadMessage()" class="reader">全部已读</a>
			</p>
			<ul>
				<c:if test="${!empty rspList }">
					<c:forEach items="${rspList}" var="cd">
						<li id="msg${cd.msgId}" onclick="detailMsg(${cd.msgId})">
							<div class="messagePic">
								<c:if test="${'0'==cd.isRead}">
									<img src="images/weidu.png" />
								</c:if>
								<c:if test="${'1'==cd.isRead}">
									<img src="images/yidu.png" />
								</c:if>
							</div>
							<p>${cd.msgTitle}</p>
							<p>${cd.addTime}</p>
							<span><img src="images/go.png" class="go"/></span>
						</li>
					</c:forEach>
				</c:if>
			</ul>
			<h6>没有更多了</h6>
		</div>
</body>
	<script type="text/javascript">
			//详情
			function detailMsg(msgId)
			{
				var form1 = document.forms['gotodetailFrm'];
				$("#msgId").val(msgId);
				form1.action = '<%=basePath%>message/detailmessage';
				$("#gotodetailFrm").submit();
			}
			
			function toBack()
			{
				window.location.href='<%=basePath%>capital/querycapital';
			}
			
			//消息详情
			function flowDiv(msgId,isRead)
			{
				$("#point"+msgId).html("&nbsp;&nbsp;");
				//未读的话设置为已读
				if("0"==isRead)
				{
					$.ajax({
						type: "POST",
						url: "<%=basePath%>message/updateIsRead",
						data : {
							msgId : msgId
						},
						success : function(data) {
							window.location.href='<%=basePath%>capital/querycapital';
						}			
					});
				}
				
				$("#msgFlow"+msgId).slideToggle("slow");
			}
			
			
			//清空消息
			function delMessage()
			{
				if(confirm("确认清空所有消息？"))
				{
					$.ajax({
						type: "POST",
						url: "<%=basePath%>message/delMessage",
						success : function(data) {
							if('success'===data.result){
								alert("清空成功！");
								window.location.href='<%=basePath%>message/querymessage';
							}
							
						}			
					});
				}
			}
			
			//全部已读消息
			function isReadMessage()
			{
				if(confirm("确认将所有未读消息置为已读？"))
				{
					$.ajax({
						type: "POST",
						url: "<%=basePath%>message/updateAllIsRead",
						success : function(data) {
							if('success'===data.result){
								alert("设置成功");
								window.location.href='<%=basePath%>message/querymessage';
							}
						}			
					});
				}
			}
		</script>
</html>