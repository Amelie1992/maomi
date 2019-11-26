<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML >
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<link rel="stylesheet" href="css/reset.css" />
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>收货地址</title>
<style type="text/css">
	.wrap {
				width: 100%;
			}
			
			.wrap ul {
				padding: 12px;
			}
			
			.wrap ul li {
				height: 40px;
				line-height: 40px;
				border-bottom: 1px solid #E0E0E0;
			}
			
			.wrap ul li span {
				display: inline-block;
			}
			
			.wrap div textarea {
				width: 62%;
				min-width: 185px;
				border: none;
				outline: none;
			}
			
			.content-head-bottom-left-tips {
				padding-left: 10px;
				display: inline-block;
				width: 100px;
				text-align: left;
				font-size: 16px;
				color: #212121;
			}
			
			.content-head-bottom-right-tips input {
				border: none;
				height: 30px;
				outline: none;
				width: 100%;
				min-width: 180px;
			}
			.content-head-bottom-right-tips select {
				width: 180px;
			}
			
			.address-save-btn {
				display: inline-block;
				width: 50%;
				text-align: center;
				height: 40px;
				line-height: 40px;
				margin: 0 auto;
				margin-left: 25%;
				color: white;
				background-color: #F2BB00;
			}
</style>


</head>

<body>
	<div class="wrap">
		<input type="hidden" id="flag" value="${flag }">
			<ul>
				<li>
					<span class="content-head-bottom-left-tips">
								收件人
							</span>
					<span class="content-head-bottom-right-tips">
								<input type="text" name="userName" id="userName" value="${aBean.userName}"  placeholder="请填写收件人姓名"/>
							</span>
				</li>
				<li>
					<span class="content-head-bottom-left-tips">
								手机号码
							</span>
					<span class="content-head-bottom-right-tips">
								<input type="text" name="userTelephone" id="userTelephone" value="${aBean.userTelephone}"  placeholder="请填写手机号码"/>
							</span>
				</li>
				<li>
					<span class="content-head-bottom-left-tips">
								省
					</span>
					<span class="content-head-bottom-right-tips">
						<select id="province" name="province">
						
							<option value="">请选择</option>
							<c:forEach items="${provinceList}" var="p">
								<option value="${p.cityCode}" <c:if test="${p.cityCode==aBean.province }">selected="selected"</c:if>>${p.cityName}</option>
							</c:forEach>
						</select>
					</span>
				</li>
				<li>
					<span class="content-head-bottom-left-tips">
								市
					</span>
					<span class="content-head-bottom-right-tips">
						<select id="bankCity" name="city">
							<option value="">请选择</option>
							<c:forEach items="${cityList}" var="p">
								<option value="${p.cityCode}" <c:if test="${p.cityCode==aBean.city }">selected="selected"</c:if>>${p.cityName}</option>
							</c:forEach>
						</select>
					</span>
				</li>
				<li>
					<span class="content-head-bottom-left-tips">
								区
					</span>
					<span class="content-head-bottom-right-tips">
						<select id="area" name="classify">
							<option value="">请选择</option>
							<c:forEach items="${quList}" var="p">
								<option value="${p.cityCode}" <c:if test="${p.cityCode==aBean.classify }">selected="selected"</c:if>>${p.cityName}</option>
							</c:forEach>
						</select>
					</span>
				</li>
				<div style="height: 85px;border-bottom: 1px solid #E0E0E0;">
					<div class="content-head-bottom-left-tips" style="height: 70px;float: left;padding-top: 10px;">
						详细地址
					</div>
					<textarea name="userAddress" id="userAddress" rows="" cols="" placeholder="请填写详细地址" style="height: 70px;resize:none;float: left;padding-top: 10px;">${aBean.userAddress}</textarea>
				</div>
				
				<div style="height: 85px;border-bottom: 1px solid #E0E0E0;">
					<div class="content-head-bottom-left-tips" style="height: 70px;float: left;padding-top: 10px;">
						备注
					</div>
					<textarea name="remark" id="remark" rows="" cols="" placeholder="请填写备注（非必填）" style="height: 70px;resize:none;float: left;padding-top: 10px;">${aBean.remark}</textarea>
				</div>

			</ul>
			<div style="width: 100%;">
				<a href="javascript:getIt();" class="address-save-btn">
				
				<c:if test="${flag=='edit'}">
					立即修改
				</c:if>
				<c:if test="${flag=='save'}">
					立即保存
				</c:if>
				</a>
			</div>
		</div>
</body>

<script>
//修改省份，变更市
$("#province").change(function(){
	var str="<option value>请选择</option>";
	$("#bankCity").html(str);
	$("#area").html(str);
	var province = $('#province').val();
	$.ajax({
		url:"<%=basePath%>accountinfo/s/getCity",
		type: "POST",
		data : {
			province : province
		},
		success:function(data){
			var a = eval(data);
	 		$(a).each(function(i,o){
	 			str+="<option value='"+o.cityCode+"'>"+o.cityName+"</option>";
	 		});		
	 		$("#bankCity").html(str);
		}
	});
});
//修改市，变更区
$("#bankCity").change(function(){
	var str="<option value>请选择</option>";
	$("#area").html(str);
	var bankCity = $('#bankCity').val();
	$.ajax({
		url:"<%=basePath%>accountinfo/s/getCity",
		type: "POST",
		data : {
			province : bankCity
		},
		success:function(data){
			var a = eval(data);
	 		
	 		$(a).each(function(i,o){
	 			str+="<option value='"+o.cityCode+"'>"+o.cityName+"</option>";
	 		});		
	 		$("#area").html(str);
		}
	});
});



	function getIt(){
		var userName=$("#userName").val();
		var userPhone=$("#userTelephone").val();
		var province=$("#province").val();
		var city=$("#bankCity").val();
		var classify=$("#area").val();
		var userAddress=$("#userAddress").val();
		var remark=$("#remark").val();
		var flag=$("#flag").val();
		var msg="";
		if(flag=="edit")
		{
			msg="是否立即修改收货地址";
		}
		else
		{
			msg="是否立即保存收货地址";
		}
		if (userName == null || userName == "") {
			alert("请填写收件人姓名");
			return;
		}
		else if (userPhone == null || userPhone == "") {
			alert("请填写收件人手机号码");
			return;
		}
		else if(!verifyVal(userPhone,"mobilePhone","手机号码")){
			return;
		}
		else if (province == null || province == "" || city == null || city == "" || classify == null || classify == "") {
			alert("请填写省市区");
			return;
		}
		else if (userAddress == null || userAddress == "") {
			alert("请填写详细地址");
			return;
		}
		else{
			if(confirm(msg))
			{
				$.ajax({
					type:"POST",
					url:"./accountaddress/saveAddress",
					data:{
						userName:userName,
						userTelephone:userPhone,
						province:province,
						city:city,
						classify:classify,
						userAddress:userAddress,
						remark:remark
					},
					success:function(data){
						if(data.result==='successsave'){
							alert("保存成功");
							window.location.href='./capital/querycapital';
						}
						else if(data.result==='successedit'){
							alert("修改成功");
							window.location.href='./capital/querycapital';
						}
						else {
							alert('操作失败');
							window.location.href='./accountaddress/toaccountaddress';
						}
						
					}
				});
			}
		}
}
</script>
</html>
