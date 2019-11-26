<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
<script src="js/validate.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layer/layer.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css" />

<title>兑奖记录</title>
<style type="text/css">
	.wrap {
		width: 100%;
	}
	.wrap ul li{
		padding: 0 15px;
		height: 70px;
		line-height: 35px;
		border-bottom: 1px solid #E0E0E0;
	}
	.wrap ul li table{
		width: 100%;
		
	}
	.wrap ul li table td{
		font-size: 12px;
		color: #999;
		
	}
	
	.zxbtn{
		color: #0ace3c;				
	}
	.no-zxbtn{
		color: #999999;
	}
	.no_record{
		text-align: center;
	    padding-top: 10%;
	    color: #999999;
	    font-size: 16px;
	}
</style>

</head>

<body>
<div class="wrap">
	<ul>
		<c:if test="${!empty rspList}">
		<c:forEach items="${rspList }" var="rs">
		<li>
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th style="width:70%">
						
						<c:if test="${rs.materialType=='5' }">
							已兑换10现金券
						</c:if>
						<c:if test="${rs.materialType=='6' }">
							已兑换100现金券
						</c:if>
						<c:if test="${rs.materialType=='7' }">
							已兑换300月饼
						</c:if>
						<c:if test="${rs.materialType=='8' }">
							已兑换小米空气净化器
						</c:if>
						<c:if test="${rs.materialType=='9' }">
							已兑换小米8 64G
						</c:if>
						<c:if test="${rs.materialType=='10' }">
							已兑换iphone8 64G
						</c:if>
						<c:if test="${rs.materialType=='11' }">
							已兑换iphoneX 256G
						</c:if>
					</th>
					<th rowspan="2" style="width:30%">
					<c:if test="${rs.materialType=='5' || rs.materialType=='6'}">
						<span class="zxbtn no-zxbtn">已发放</span>
					</c:if>
					<c:if test="${rs.isDiscount=='0' && rs.materialType!='5' && rs.materialType!='6'}">
						<span class="zxbtn" onclick="discountNow('${rs.materialDetailId}')">折现</span>
					</c:if>
					<c:if test="${rs.isDiscount=='1'}">
						<span class="zxbtn no-zxbtn">已折现</span>
					</c:if>
					</th>
				</tr>
				<tr>
					<td>${rs.addTime }</td>
				</tr>
			</table>
		</li>
		</c:forEach>
		</c:if>
		<c:if test="${empty rspList}">
			<div class="no_record">暂无兑换记录</div>
		</c:if>
	</ul>
</div>

</body>
<script type="text/javascript">
	function discountNow(materialDetailId)
	{
			layer.confirm("确定立即折现吗？",function(){
			var index=layer.load();
			$.ajax({
				type : "POST",
				url:"<%=basePath%>material/discountmoon",
				data : {
					materialDetailId:materialDetailId
				},
				dataType:"json",
				error:function(request)
				{
					layer.closeAll();
					layer.alert("系统错误！");
				},
				success:function(data){
					layer.closeAll();
					if(data.result==='success'){
						layer.alert("折现成功，奖励将于活动结束后1-3个工作日发放",{icon:6},function(index){
							layer.close(index);	
							window.location.href='./material/tomaterialdetail';
						});
					}
					else
					{
						layer.alert("系统错误", {icon:5},function(index){
							layer.close(index);	
							window.location.href='./material/tomaterialdetail';
						});
					}
				}
			});
		});
	}
</script>
</html>
