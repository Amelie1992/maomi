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
    <script type="text/javascript" src="js/navigation.js"></script>
    <script type="text/javascript" src="js/isWeixin.js"></script>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/subject/subjectlist.css" />
    <title>新手专享标</title>

	<script type="text/javascript">
	function changeBiao(obj,sType)
	{
		
		$("#subjectType").val(sType)
		var form = document.forms['form1'];
		if('2'==sType)
		{
			form.action = '<%=basePath%>hotsubject/queryhotsubject';
		}
		else if('1'==sType)
		{
			form.action = '<%=basePath%>subject/querysubject';
		}
		else if('0'==sType)
		{
			form.action = '<%=basePath%>subject/querynewsubject';
		}
		else if('4'==sType)
		{
			form.action = '<%=basePath%>subject/queryhighsubject';
		}
		form.submit();
	}
	
	function toBack()
	{
		window.location.href='<%=basePath%>capital/querycapital';	
	}
	function orderBY(obj,flag)
	{
		var form2 = document.forms['form1'];
		var types=$("#types").val();
		if("0"==types)
		{
			form2.action = '<%=basePath%>subject/querynewsubject?flag='+flag;
		}
		else if("1"==types)
		{
			form2.action = '<%=basePath%>subject/querysubject?flag='+flag;
		}
		else if("4"==types)
		{
			form2.action = '<%=basePath%>subject/querysubject?flag='+flag;
		}
		form2.submit();
	}
	/* function displaySubMenu(li) {
		var subMenu = li.getElementsByTagName("ul")[0];
		subMenu.style.display = "block";
	}

	function hideSubMenu(li) {
		var subMenu = li.getElementsByTagName("ul")[0];
		subMenu.style.display = "none";
	} */
	function gotodetail(obj){
		$("#id").val(obj)
		$("#gotodetailFrm").submit();
	}
	</script>
  </head>
  
  <body>
  <input type="hidden" id="basePath" value="<%=basePath%>" />
  
 	<form method="post" action="" id="form1" >
    	<input type="hidden" id="subjectType"  name="subjectType"/>
    </form>
	<form method="post" action="<%=basePath%>subject/detailsubject" id="gotodetailFrm" >
    	<input type="hidden" id="id"  name="id" value=""/>
    </form>
    <input type="hidden" id="types" value="${types}">
    <input type="hidden" id="flag" value="${flag}">
	<div class="wrap">
			<div class="navigation">
				<!--切到哪个标 就给对应的加类名 .currentChose_head-->
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="changeBiao(this,0)" <c:if test="${'0'==types}">class="currentChose_head"</c:if>>新手标</th>
						<th onclick="changeBiao(this,1)" <c:if test="${'1'==types}">class="currentChose_head"</c:if>>精选理财</th>
						<th onclick="changeBiao(this,2)" <c:if test="${'2'==types}">class="currentChose_head"</c:if>>实物标</th>
						<th onclick="changeBiao(this,4)" <c:if test="${'4'==types}">class="currentChose_head"</c:if>>爆款标</th>
					</tr>
				</table>
			</div>
			<div class="filtrate">
				<!--切到哪个筛选条件 就给对应的加类名 .currentChose_head-->
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="orderBY(this,'')" <c:if test="${''==flag}">class="currentChose_head"</c:if>>默认</th>
						<th onclick="orderBY(this,1)"  <c:if test="${'1'==flag}">class="currentChose_head"</c:if>>利率</th>
						<th onclick="orderBY(this,2)"  <c:if test="${'2'==flag}">class="currentChose_head"</c:if>>金额</th>
						<th onclick="orderBY(this,3)"  <c:if test="${'3'==flag}">class="currentChose_head"</c:if>>期限</th>
					</tr>

				</table>
			</div>
			
			<div class="content">
			<c:if test="${!empty subjectList }">
			<c:forEach items="${subjectList}" var="sj">
				<div class="content_detail" onclick="gotodetail(${sj.subjectId})">
					<p class="content_detail_title">
						${sj.subjectName }
						<span>
							<c:if test="${'-1'==sj.subjectStatus }">暂未发标</c:if>
							<c:if test="${'0'==sj.subjectStatus }">筹标中</c:if>
							<c:if test="${'1'==sj.subjectStatus }">已满标</c:if>
							<c:if test="${'2'==sj.subjectStatus }">满标复审</c:if>
							<c:if test="${'3'==sj.subjectStatus }">还款中</c:if>
							<c:if test="${'4'==sj.subjectStatus }">流标</c:if>
						</span>
						<span>${sj.subjectStartingMoney}起投</span>
						
					</p>
					<div class="content_detail_left">
						<p>
							<span class="contentRate contentRate_1">${sj.subjectRate }</span>
							<span class="contentRate">%</span>
						</p>
						<p>
							<span class="contentTips">参考年回报率</span>
						</p>
					</div>
					<div class="content_detail_right">
						<p>
							期限：${sj.subjectPeriods }个月
						</p>
						<p>
							<span class="contentTips">剩余金额${sj.subjectOverplusMoney }</span>
						</p>
					</div>
				</div>
			</c:forEach>
			</c:if>
		</div>
			<!-- 空白导航  防止被底部导航栏遮住内容 -->
			<jsp:include page="../navigation/emptyDiv.jsp" flush="true"/>	
			<!-- 底部导航 -->
			<div class="space"></div>
			<div class="footer">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="toChange(this,1)"><img src="images/tab_home_nor.png" /></th>
						<th onclick="toChange(this,2)"><img src="images/tab_touzi_sel.png" /></th>
						<th onclick="toChange(this,3)"><img src="images/tab_mall_nor.png" /></th>
						<th onclick="toChange(this,4)"><img src="images/tab_geren_nor.png" /></th>
					</tr>
					<tr>
						<td>首页</td>
						<td class="currentChose">投资</td>
						<td>商城</td>
						<td>我</td>
					</tr>
				</table>
			</div>
		</div>
		
  </body>
</html>
