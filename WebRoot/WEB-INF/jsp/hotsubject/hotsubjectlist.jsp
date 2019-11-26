<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/subject/hotsubjectlist.css" />
	<title>爆款标</title>
		<script type="text/javascript">
			//下拉框
			function changeBiao(obj,sType)
			{
				$("#subjectType").val(sType);
				var form = document.forms['form1'];
				if('2'==sType)
				{
					form.action = '<%=basePath%>hotsubject/s/queryhotsubject';
				}
				else if('1'==sType)
				{
					form.action = '<%=basePath%>subject/s/querysubject';
				}
				else if('0'==sType)
				{
					form.action = '<%=basePath%>subject/s/querynewsubject';
				}
				else if('4'==sType)
				{
					form.action = '<%=basePath%>subject/s/queryhighsubject';
				}
				else if("5"==sType)
				{
					form.action = '<%=basePath%>bondTransfer/getBondTransfer';
				}
				form.submit();
			}
			
			//返回
			function backMyCenter(){
				window.location.href="<%=basePath%>capital/querycapital";
			}
			
			function queryGoods(subjectId){
				$("#subjectId").val(subjectId);
				var form = document.forms['form1'];
				form.action = '<%=basePath%>hotsubject/detailhotdetail';
				form.submit();
			}
		</script>
</head>
<body>
	<form action="" id="form1" method="post">
    	<input type="hidden" id="subjectType"  name="subjectType"/>
    	<input type="hidden" id="subjectId"  name="subjectId" value=""/>
    </form>
	<div class="wrap">
			<div class="navigation">
				<!--切到哪个标 就给对应的加类名 .currentChose_head-->
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="changeBiao(this,0)" <c:if test="${'0'==types}">class="currentChose_head"</c:if>>新手标</th>
						<th onclick="changeBiao(this,1)" <c:if test="${'1'==types}">class="currentChose_head"</c:if>>精选理财</th>
						<th onclick="changeBiao(this,2)" <c:if test="${'2'==types}">class="currentChose_head"</c:if>>实物标</th>
						<th onclick="changeBiao(this,4)" <c:if test="${'4'==types}">class="currentChose_head"</c:if>>爆款标</th>
						<th onclick="changeBiao(this,5)" <c:if test="${'5'==types}">class="currentChose_head"</c:if>>债权转让</th>
					</tr>
				</table>
			</div>
			
			<div class="content">
			<c:if test="${!empty hotsubjectList }">
			<c:forEach items="${hotsubjectList}" var="sj">
			<div class="content_detail" onclick="queryGoods(${sj.subjectId})">
					<img src="images/goodIcon.png" class="goodIcon"/>
					<div class="goodPic">
						<img src="images/good.png"/>
					</div>
					<div class="goodTips">
						<p class="goodName">${sj.goodsName}</p>
						<p class="discount"><s>￥${sj.goodsMoney}</s></p>
						<p><input type="button" class="touziBtn" id="" value="￥${sj.pieceMoney}投资" /></p>
						<p class="leftNum">（剩余数量：${sj.realStock}个）</p>
					</div>
				</div>
				<div class="space"></div>
			</c:forEach>
			</c:if>
		</div>
		<!-- 空白导航  防止被底部导航栏遮住内容 -->
		<jsp:include page="../navigation/emptyDiv.jsp" flush="true"/>	
		<!-- 底部导航 -->
		<jsp:include page="../navigation/navigation.jsp" flush="true"/>
		</div>
</body>

</html>