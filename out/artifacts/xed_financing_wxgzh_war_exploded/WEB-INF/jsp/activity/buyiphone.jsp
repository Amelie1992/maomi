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

<title>兑换iphone</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/activity/buyiphone.css" />
<link rel="stylesheet" type="text/css" href="css/activity/selectaddress.min.css" />

</head>

<body>
	<div class="wrap">
		<div class="content-head">
			<div class="content-head-top">
				<c:if test="${goodId==1 || goodId==2}"><img src="images/activity/wx-grey8.png" /></c:if>
				<c:if test="${goodId==3 || goodId==4}"><img src="images/activity/wx-grey8p.png" /></c:if>
				<c:if test="${goodId==6 || goodId==5}"><img src="images/activity/wx-greyIphonex.png" /></c:if>
			</div>
			<div class="content-head-phone-tips-red">
				<c:if test="${switchs=='on'}">
					<c:if test="${empty sessionScope.account}">
						<a href="./loginregister/s/toLogin" >立即登录把iphone带回去</a>
					</c:if>
					<c:if test="${!empty sessionScope.account}">
						活动已开启(剩余库存：${num})
					</c:if>
				</c:if>
				<c:if test="${switchs=='off'}">
						11月10号00:00点开启活动。敬请期待...
				</c:if>
				<c:if test="${switchs=='over'}">
						iphone已售罄
				</c:if>
				<c:if test="${switchs=='out'}">
						活动已结束
				</c:if>
				</div>
			<div class="content-head-phone-tips">
					<c:if test="${goodId==1 }">Apple/苹果 Iphone8 64G 手机全网通</c:if>
					<c:if test="${goodId==2 }">Apple/苹果 Iphone8 256G 手机全网通</c:if>
					<c:if test="${goodId==3 }">Apple/苹果 Iphone8plus 64G 手机全网通</c:if>
					<c:if test="${goodId==4 }">Apple/苹果 Iphone8plus 256G 手机全网通</c:if>
					<c:if test="${goodId==5 }">Apple/苹果 IphoneX 64G 手机全网通</c:if>
					<c:if test="${goodId==6 }">Apple/苹果 IphoneX 256G 手机全网通</c:if>
			</div>
			<div class="content-head-bottom">
				<p>手机颜色</p>
				<div>
					<span class="phoneColor colorType-grey">深空灰色</span>
					<span class="phoneColor colorType-white">银色</span>
					<c:if test="${goodId!=5 &&goodId!=6}">
					<span class="phoneColor colorType-gold">金色</span>
					</c:if>
				</div>
			</div>
			<div class="content-head-bottom content-head-bottom-2">
				<p>投资类型</p>
				<c:if test="${goodId==1 }">
					<div>
						<span class="phoneColor bidType-1">90000投资4个月</span>
						<span class="phoneColor bidType-2">60000投资6个月</span>
					</div>
					<div>
						<span class="phoneColor bidType-3">40000投资9个月</span>
						<span class="phoneColor bidType-4">20000投资18个月</span>
					</div>
				</c:if>
				
				<c:if test="${goodId==2 }">
					<div>
						<span class="phoneColor bidType-1">90000投资5个月</span>
						<span class="phoneColor bidType-2">50000投资9个月</span>
					</div>
					<div>
						<span class="phoneColor bidType-3">30000投资15个月</span>
						<span class="phoneColor bidType-4">20000投资22个月</span>
					</div>
				</c:if>
				
				<c:if test="${goodId==3 }">
					<div>
						<span class="phoneColor bidType-1">70000投资6个月</span>
						<span class="phoneColor bidType-2">50000投资8个月</span>
					</div>
					<div>
						<span class="phoneColor bidType-3">35000投资12个月</span>
						<span class="phoneColor bidType-4">20000投资20个月</span>
					</div>
				</c:if>
				
				<c:if test="${goodId==4 }">
					<div>
						<span class="phoneColor bidType-1">100000投资5个月</span>
						<span class="phoneColor bidType-2">80000投资6个月</span>
					</div>
					<div>
						<span class="phoneColor bidType-3">50000投资10个月</span>
						<span class="phoneColor bidType-4">20000投资24个月</span>
					</div>
				</c:if>
				
				<c:if test="${goodId==5 }">
					<div>
						<span class="phoneColor bidType-1">89000投资6个月</span>
						<span class="phoneColor bidType-2">67000投资8个月</span>
					</div>
					<div>
						<span class="phoneColor bidType-3">45000投资12个月</span>
						<span class="phoneColor bidType-4">27000投资20个月</span>
					</div>
				</c:if>
				
				<c:if test="${goodId==6 }">
					<div>
						<span class="phoneColor bidType-1">100000投资6个月</span>
						<span class="phoneColor bidType-2">78000投资8个月</span>
					</div>
					<div>
						<span class="phoneColor bidType-3">50000投资12个月</span>
						<span class="phoneColor bidType-4">31000投资20个月</span>
					</div>
				</c:if>
			</div>
			<div class="content-head-bottom-3">
				<ul>
					<li>
						<span class="content-head-bottom-left-tips"> 收件人 </span> 
						<span class="content-head-bottom-right-tips"> 
							<input type="text" name="userName" id="userName" value="" placeholder="请填写收件人姓名" />
						</span>
					</li>
					<li>
						<span class="content-head-bottom-left-tips"> 手机号码 </span>
						<span class="content-head-bottom-right-tips"> 
							<input type="text" name="userTelephone" id="userTelephone" value="" placeholder="请填写手机号码" />
						</span>
					</li>
					<li>
						<span class="content-head-bottom-left-tips"> 省</span>
						<span class="content-head-bottom-right-tips">
							<select id="province" name="province">
								<option value="">请选择</option>
								<c:forEach items="${provinceList}" var="p">
									<option value="${p.cityCode}">${p.cityName}</option>
								</c:forEach>
							</select>
						</span>
					</li>
					<li>
						<span class="content-head-bottom-left-tips"> 市</span>
						<span class="content-head-bottom-right-tips">
							<select id="bankCity" name="city">
								<option value="">请选择</option>
							</select>
						</span>
					</li>
					<li>
						<span class="content-head-bottom-left-tips"> 区</span>
						<span class="content-head-bottom-right-tips">
							<select id="area" name="classify">
								<option value="">请选择</option>
							</select>
						</span>
					</li>
					<li>
						<span class="content-head-bottom-left-tips"> 邮政编码 </span>
						<span class="content-head-bottom-right-tips"> 
							<input type="text" name="" id="" value="" placeholder="请填写邮政编码" />
						</span>
					</li>
					<div style="height: 80px;">
						<div class="content-head-bottom-left-tips"
							style="height: 70px; float: left; padding-top: 10px;">详细地址
						</div>
						<textarea id="userAddress" name="userAddress" rows="" cols="" placeholder="请填写详细地址"
							style="height: 70px; resize: none; float: left; padding-top: 10px; text-indent: 3px;"></textarea>
					</div>
				</ul>
			</div>
		</div>
		<div class="getPhone">
			<!--活动开启换图 wx-getphone-after.png-->
			<c:if test="${switchs=='on'}">
				<c:if test="${empty sessionScope.account}">
					<img src="images/activity/wx-getphone-login.png" onclick="goLogin()"/>
				</c:if>
				<c:if test="${!empty sessionScope.account}">
					<img src="images/activity/wx-getphone-after.png" onclick="getIt()"/>
				</c:if>
			</c:if>
			<c:if test="${switchs=='off'}">
				<img src="images/activity/wx-getphone-before.png" />
			</c:if>
			<c:if test="${switchs=='over'}">
				<img src="images/activity/wx-getphone-over.png" />
			</c:if>
			<c:if test="${switchs=='out'}">
				<img src="images/activity/wx-getphone-out.png" />
			</c:if>
		</div>
				<input type="hidden" name="color"  id="color" value="">
				<input type="hidden" name="package" id="investType" value="">
				<input type="hidden" name="goodId" id="goodId" value="${goodId}">
	</div>
</body>
<script src="js/activity/CNAddrArr.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/activity/selectAddress.js" type="text/javascript" charset="utf-8"></script>

	<script type="text/javascript">
		
		//11.11号0.00分执行下面的代码
		//$('.content-head-phone-tips-red').css('display','none');
		var goodId=$("#goodId").val();
		//手机类型
		//深空灰
		$('.colorType-grey').click(function() {
			if(goodId==1 || goodId==2)
			{
				$('.content-head-top img').attr('src','images/activity/wx-grey8.png');
			}
			else if(goodId==3 || goodId==4)
			{
				$('.content-head-top img').attr('src','images/activity/wx-grey8p.png');
			}
			else if(goodId==5 || goodId==6)
			{
				$('.content-head-top img').attr('src','images/activity/wx-greyIphonex.png');
			}
			$('.colorType-grey').css('border-color', '#F95D18');
			$('.colorType-grey').css('color', '#F95D18');
			$('.colorType-white').css('border-color', '');
			$('.colorType-white').css('color', '');
			$('.colorType-gold').css('border-color', '');
			$('.colorType-gold').css('color', '');
			$("#color").val(1);
		});
		//银色
		$('.colorType-white').click(function() {
			if(goodId==1 || goodId==2)
			{
				$('.content-head-top img').attr('src','images/activity/wx-white8.png');
			}
			else if(goodId==3 || goodId==4)
			{
				$('.content-head-top img').attr('src','images/activity/wx-white8p.png');
			}
			else if(goodId==5 || goodId==6)
			{
				$('.content-head-top img').attr('src','images/activity/wx-whiteIphonex.png');
			}
			$('.colorType-white').css('border-color', '#F95D18');
			$('.colorType-white').css('color', '#F95D18');
			$('.colorType-grey').css('border-color', '');
			$('.colorType-grey').css('color', '');
			$('.colorType-gold').css('border-color', '');
			$('.colorType-gold').css('color', '');
			$("#color").val(2);
		});
		$('.colorType-gold').click(function() {
			if(goodId==1 || goodId==2)
			{
				$('.content-head-top img').attr('src','images/activity/wx-gold8.png');
			}
			else if(goodId==3 || goodId==4)
			{
				$('.content-head-top img').attr('src','images/activity/wx-gold8p.png');
			}
			$('.colorType-gold').css('border-color', '#F95D18');
			$('.colorType-gold').css('color', '#F95D18');
			$('.colorType-white').css('border-color', '');
			$('.colorType-white').css('color', '');
			$('.colorType-grey').css('border-color', '');
			$('.colorType-grey').css('color', '');
			$("#color").val(3);
		});
		//投资类型
		$('.bidType-1').click(function() {
			$('.bidType-1').css('border-color', '#F95D18');
			$('.bidType-1').css('color', '#F95D18');
			$('.bidType-2').css('border-color', '');
			$('.bidType-2').css('color', '');
			$('.bidType-3').css('border-color', '');
			$('.bidType-3').css('color', '');
			$('.bidType-4').css('border-color', '');
			$('.bidType-4').css('color', '');
			$("#investType").val(1);
		});
		$('.bidType-2').click(function() {
			$('.bidType-1').css('border-color', '');
			$('.bidType-1').css('color', '');
			$('.bidType-2').css('border-color', '#F95D18');
			$('.bidType-2').css('color', '#F95D18');
			$('.bidType-3').css('border-color', '');
			$('.bidType-3').css('color', '');
			$('.bidType-4').css('border-color', '');
			$('.bidType-4').css('color', '');
			$("#investType").val(2);

		});
		$('.bidType-3').click(function() {
			$('.bidType-1').css('border-color', '');
			$('.bidType-1').css('color', '');
			$('.bidType-2').css('border-color', '');
			$('.bidType-2').css('color', '');
			$('.bidType-3').css('border-color', '#F95D18');
			$('.bidType-3').css('color', '#F95D18');
			$('.bidType-4').css('border-color', '');
			$('.bidType-4').css('color', '');
			$("#investType").val(3);
		});
		$('.bidType-4').click(function() {
			$('.bidType-1').css('border-color', '');
			$('.bidType-1').css('color', '');
			$('.bidType-2').css('border-color', '');
			$('.bidType-2').css('color', '');
			$('.bidType-3').css('border-color', '');
			$('.bidType-3').css('color', '');
			$('.bidType-4').css('border-color', '#F95D18');
			$('.bidType-4').css('color', '#F95D18');
			$("#investType").val(4);
		});

		
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
		
		//退出登录
		function goLogin()
		{
			if(confirm("确定登录吗？"))
			{
				window.location.href='<%=basePath%>loginregister/s/toLogin';
			}
		}
		
		//兑换
		function getIt()
		{
			var goodId=$("#goodId").val();
			var color=$("#color").val();
			var packages=$("#investType").val();
			var userName=$("#userName").val();
			var userPhone=$("#userTelephone").val();
			var province=$("#province").val();
			var city=$("#bankCity").val();
			var classify=$("#area").val();
			var userAddress=$("#userAddress").val();
			if (color == null || color == "") {
				alert("请选择手机颜色");
				return;
			}
			else if (packages == null || packages == "") {
				alert("请选择投标类型");
				return;
			}
			else if (userName == null || userName == "") {
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
			else
			{
				if(confirm("是否立即兑换"))
				{
					$.ajax({
						type:"POST",
						url:"./singlesday/getiphone",
						data:{
							goodId:goodId,
							color:color,
							packages:packages,
							userName:userName,
							userTelephone:userPhone,
							province:province,
							city:city,
							classify:classify,
							userAddress:userAddress
						},
						success:function(data){
							if(data.result==='success'){
								alert('领取成功');
								window.location.href='./singlesday/s/gosinglesday';
							}
							else if(data.result==='errornum'){
								alert('库存不足');
								window.location.href='./singlesday/s/gosinglesday';
							}
							else if(data.result==='errorMoney'){
								if(confirm("余额不足，是否现在充值"))
								{
									window.location.href='./recharge/rechargeInfo';
								}
								else
								{
									window.location.href='./singlesday/s/gosinglesday';
								}
							}
							else if(data.result==='errorsys'){
								alert('违规操作');
								window.location.href='./singlesday/s/gosinglesday';
							}
						}
					});
				}
			}
		}
	</script>
</html>
