<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/subject/subjectdetail.css" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="js/isWeixin.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/showPic.css" />
<link rel="stylesheet" href="css/photoswipe.css">
<link rel="stylesheet" href="css/default-skin/default-skin.css">
<title>标详情</title>
		<script type="text/javascript">
		
		$(document).ready(function() {
			var newbieDetailTitle = $("#perSubject").val();
			$("#progressBarY").width(newbieDetailTitle+"%");
		});
		
			//安全保障
			function safePromote()
			{
				window.location.href='<%=basePath%>safetySecurity.jsp';	
			}
			
			//底部按钮
			$(window).scroll(function() {
				if($(document).scrollTop() + $(window).height() >= $(document).height()) {
					$('#operation').show(1000);
				}
				//			else{
				//				$('#operation').hide();
				//			}
			});
		
			//投标
			function investNow(id,subjectStatus,subjectStartingMoney)
			{
				//新手专享标投标次数
				var counts = $("#count").val();
				if('over'==counts)
				{
					if(confirm("新手专享投标次数已用完！抽奖有机会增加次数，是否去抽奖？")) 
					{
						window.location.href='<%=basePath%>awardrotate/gotoawardrotate';	
					}
					
				}
				else if(subjectStatus>=1)
				{
					alert("已投满！");
				}
				else
				{
					var form = document.forms['form1'];
					form.action = '<%=basePath%>subject/investnow?id='+id;
					form.method="post";
					form.submit();
				}
			}	
			//返回
			function toBack()
			{
				var sType = $("#subjectType").val()
				var form = document.forms['form1'];
				if($("#isHome").val() == 1){
					form.action = '<%=basePath%>/fontpage/s/queryFontPage';
				}
				else if($("#isHome").val() == 2){
					form.action = '<%=basePath%>/investrecord/queryinvest';
				}else{
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
				}
				form.submit();
			}
			
			//下拉框
			function tab(tabId){
				//$("#"+tabId).addClass("up");
				//$("#"+tabId).removeClass("down");
				var finda = $("#"+tabId).parent('div').parent('a').attr("aria-expanded");
				$(".finda").each(function(index, dom){
					$(dom).removeClass("up");
					$(dom).addClass("down");
				});
				if(finda=='false'){
					$("#"+tabId).addClass("up");
					$("#"+tabId).removeClass("down");
				}else{
					$("#"+tabId).removeClass("up");
					$("#"+tabId).addClass("down");
				}
			}
			
			//查询供应链金融合同
			function querySupplyChainFinanceContract(subjectId)
			{
				$("#subjectId").val(subjectId);
				$("#financeContractForm").submit();
			}
			//《网络借贷风险及禁止性行为提示书》</a>和<a>《资金来源合法承诺书》
			function goPromptBooks(){
				window.location.href='<%=basePath%>subject/goPromptBooks';
			}
			function goLegitimate(){
				window.location.href='<%=basePath%>subject/goLegitimate';
			}
		</script>
</head>
<body>
<input type="hidden" value="${isHome}" id="isHome"/>
	<form action="<%=basePath%>subject/supplychainfinancecontract" id="financeContractForm" method="post">
		<input type="hidden" name="subjectId" id="subjectId" >
	</form>
	<form action="" id="form1" method="post">
		<input type="hidden" id="count" value="${count }">
		<input type="hidden" id="perSubject" value="${subjectBeans.perSubject}">
		<input type="hidden" id="subjectType" value="${subjectBeans.subjectType}">
	</form>
	<div class="wrap">
			<div class="xmxq_head">
				<div class="title">
					<img src="images/backW.png" class="back" onclick="toBack()"/>${subjectBeans.subjectName}
				</div>
				<div>
					<p>参考年回报率（%）</p>
				</div>
				<div>
					<p>${subjectBeans.subjectRate}</p>
				</div>
				<div class="progressBar">
					<p class="progressBarW"></p>
					<p class="progressBarY" id="progressBarY"></p>
				</div>
				<div class="tips" id="newbieDetailTitle">
					进度${subjectBeans.perSubject}%,剩余可投金额${subjectBeans.subjectOverplusMoney}元
				</div>
			</div>
			<div class="space">

			</div>
			<ul id="accordion2" class="accordion">
							<li>
								<div class="link">
									</i>
									<div class="contentPic">
										<img src="images/xmxqy.png" style="width: 18px;" />
									</div>
									<span class="contentName">项目详情</span><i class="fa fa-chevron-down"></i>
								</div>
								<ul class="submenu">
									<p>
										<span class="accordion-content-tips-left">项目名称:</span>
										<span class="accordion-content-tips-right">${subjectBeans.subjectName}</span>
									</p>
									<p>
										<span class="accordion-content-tips-left">参考年回报率:</span>
										<span class="accordion-content-tips-right">${subjectBeans.subjectRate}%</span>
									</p>
									<p>
										<span class="accordion-content-tips-left">标总金额:</span>
										<span class="accordion-content-tips-right">${subjectBeans.subjectMoney}元</span>
									</p>
									<p>
										<span class="accordion-content-tips-left">投资期限:</span>
										<span class="accordion-content-tips-right">
											${subjectBeans.subjectPeriods }
											<c:if test="${'0'==subjectBeans.subjectTerm }">天</c:if>
											<c:if test="${'1'==subjectBeans.subjectTerm }">月</c:if>
											<c:if test="${'2'==subjectBeans.subjectTerm }">年</c:if>
										</span>
									</p>
									<p>
										<span class="accordion-content-tips-left">起投金额:</span>
										<span class="accordion-content-tips-right">${subjectBeans.subjectStartingMoney}元</span>
									</p>
									<p>
										<span class="accordion-content-tips-left">还款方式:</span>
										<span class="accordion-content-tips-right">
											<c:if test="${'0'==subjectBeans.repeatType }">等额本息</c:if>
											<c:if test="${'1'==subjectBeans.repeatType }">先息后本</c:if>
											<c:if test="${'2'==subjectBeans.repeatType }">到期还本付息</c:if>
										</span>
									</p>
									<p>
										<span class="accordion-content-tips-left">优惠券权限:</span>
										<span class="accordion-content-tips-right">
											<c:if test="${'0'==subjectBeans.isLimit }">无限制</c:if>
											<c:if test="${'1'==subjectBeans.isLimit }">限制所有</c:if>
											<c:if test="${'2'==subjectBeans.isLimit }">无计息期限或为${str }</c:if>
										</span>
									</p>
									<p>
										描述:
										<c:choose>
											<c:when test="${''==subjectBeans.usedRemark || null==subjectBeans.usedRemark}">
												暂无
											</c:when>
											<c:otherwise>
												${subjectBeans.usedRemark}
											</c:otherwise>
										</c:choose>
									</p>
								</ul>
							</li>
							
							<li>
								<div class="link">
									</i>
									<div class="contentPic">
										<img src="images/yqhy.png" />
									</div>
									<span class="contentName">
										<c:if test="${empty userCompanyBean}">
											贷款人基本资料
										</c:if>
										<c:if test="${!empty userCompanyBean}">
											法人基本资料
										</c:if>
									</span>
									<i class="fa fa-chevron-down"></i>
								</div>
								<ul class="submenu">
									<c:if test="${empty userCompanyBean}">
										<p>
											<span class="accordion-content-tips-left">姓名:</span>
											<span class="accordion-content-tips-right">${fn:substring(subjectBeans.userName, 0, 1)}**</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">性别:</span>
											<span class="accordion-content-tips-right">
												<c:if test="${'0'==subjectBeans.userSex }">男</c:if>
												<c:if test="${'1'==subjectBeans.userSex }">女</c:if>
											</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">年龄:</span>
											<span class="accordion-content-tips-right">${subjectBeans.userAge}</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">居住地:</span>
											<span class="accordion-content-tips-right">${subjectBeans.province} ${subjectBeans.city} ${subjectBeans.classify}</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">风险评级:</span>
											<span class="accordion-content-tips-right">
												<span class="star-lv">
												<c:forEach var="x" begin="1" end="${subjectBeans.securityRating }" step="1"> 
													<span class="star-select"></span>
												</c:forEach>
												<c:forEach var="x" begin="1" end="${6-subjectBeans.securityRating }" step="1"> 
													<span></span>
												</c:forEach>	
												</span>
											</span>
										</p>
										<p style="font-size:12px;">
											 风险评级等级越高,风险等级越低。	
										</p>
									<%-- <p>
											<span class="accordion-content-tips-left">婚姻状况:</span>
											<span class="accordion-content-tips-right">
										        <c:if test="${'0'==subjectBean.marriageType }">未婚</c:if>
												<c:if test="${'1'==subjectBean.marriageType }">已婚</c:if>
											</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">是否有房贷:</span>
											<span class="accordion-content-tips-right">
												<c:if test="${'0'==subjectBeans.houseType }">有房有贷款</c:if>
												<c:if test="${'1'==subjectBeans.houseType }">有房无贷款</c:if>
												<c:if test="${'2'==subjectBeans.houseType }">非所属市住房</c:if>
											</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">是否有车贷:</span>
											<span class="accordion-content-tips-right">
												<c:if test="${'0'==subjectBeans.carType }">无车贷</c:if>
												<c:if test="${'1'==subjectBeans.carType }">有车贷</c:if>
											</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">是否有其他贷款:</span>
											<span class="accordion-content-tips-right">
												<c:if test="${'0'==subjectBeans.isLoan }">无</c:if>
												<c:if test="${'1'==subjectBeans.isLoan }">有</c:if>
											</span>
										</p> --%>
									</c:if>
									
									<c:if test="${!empty userCompanyBean}">
										<p>
											<span class="accordion-content-tips-left">姓名:</span>
											<span class="accordion-content-tips-right">${fn:substring(subjectBeans.userName, 0, 1)}**</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">性别:</span>
											<span class="accordion-content-tips-right">
												<c:if test="${'0'==subjectBeans.userSex }">男</c:if>
												<c:if test="${'1'==subjectBeans.userSex }">女</c:if>
											</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">年龄:</span>
											<span class="accordion-content-tips-right">${subjectBeans.userAge}</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">户籍:</span>
											<span class="accordion-content-tips-right">${subjectBeans.province} ${subjectBeans.city} ${subjectBeans.classify}</span>
										</p>
									</c:if>
								</ul>
							</li>
							
							<li>
								<c:if test="${empty userHouseBean && empty userCompanyBean}">
									<div class="link">
										</i>
										<div class="contentPic">
											<img src="images/car-icon.png" />
										</div>
										<span class="contentName">车辆基本资料</span><i class="fa fa-chevron-down"></i>
									</div>
									<ul class="submenu">
										<p>
											<span class="accordion-content-tips-left">车辆型号:</span>
											<span class="accordion-content-tips-right">${subjectBeans.carBrand}</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">车辆颜色:</span>
											<span class="accordion-content-tips-right">${subjectBeans.carColor}</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">车牌号:</span>
											<span class="accordion-content-tips-right">${fn:substring(subjectBeans.carTag, 0, 1)}****${fn:substring(subjectBeans.carTag, 5, 7)}</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">购买价格:</span>
											<span class="accordion-content-tips-right">${subjectBeans.carMoney}</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">抵押价格:</span>
											<span class="accordion-content-tips-right">${subjectBeans.carExpectMoney}</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">车辆年限:</span>
											<span class="accordion-content-tips-right">${subjectBeans.carLimit}年</span>
										</p>
									</ul>
								</c:if>
								
								<c:if test="${!empty userHouseBean}">
									<div class="link">
										</i>
										<div class="contentPic">
											<img src="images/house-info.png" />
										</div>
										<span class="contentName">房屋资料</span><i class="fa fa-chevron-down"></i>
									</div>
									<ul class="submenu">
										<p>
											<span class="accordion-content-tips-left">房屋类型:</span>
											<span class="accordion-content-tips-right">
												<c:if test="${userHouseBean.typeHouse == 1}">普通住宅</c:if>
												<c:if test="${userHouseBean.typeHouse == 2}">商铺</c:if>
												<c:if test="${userHouseBean.typeHouse == 3}">别墅</c:if>
											</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">建筑面积:</span>
											<span class="accordion-content-tips-right">${userHouseBean.buildArea}平方米</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">房龄:</span>
											<span class="accordion-content-tips-right">${userHouseBean.houseAge}年</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">房产地址:</span>
											<span class="accordion-content-tips-right">${userHouseBean.province}${userHouseBean.city}${userHouseBean.classify}*********</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">房产评估价格:</span>
											<span class="accordion-content-tips-right">${userHouseBean.houseExceptMoney}元</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">房产抵押价格:</span>
											<span class="accordion-content-tips-right">${userHouseBean.housePledgeMoney}元</span>
										</p>
									</ul>
								</c:if>
								
								<c:if test="${!empty userCompanyBean}">
									<div class="link">
										</i>
										<div class="contentPic">
											<img src="images/company-info.png" />
										</div>
										<span class="contentName">公司资料</span><i class="fa fa-chevron-down"></i>
									</div>
									<ul class="submenu">
										<p>
											<span class="accordion-content-tips-left">企业名称:</span>
											<span class="accordion-content-tips-right">${userCompanyBean.userCompanyName}</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">企业所在城市:</span>
											<span class="accordion-content-tips-right">${userCompanyBean.userCompaneyCity}</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">营业执照号:</span>
											<span class="accordion-content-tips-right">${userCompanyBean.userBusinessLicence}</span>
										</p>
									</ul>
								</c:if>
							</li>
							
							<li>
								<div class="link">
									</i>
									<div class="contentPic">
										<img src="images/zzshy.png" />
									</div>
									<span class="contentName">资质审核</span><i class="fa fa-chevron-down"></i>
								</div>
								<ul class="submenu">
									<p>
										<span class="accordion-content-tips-left" style="color:#888;">审核资料</span>
										<span class="accordion-content-tips-right" style="color:#888;">审核结果</span>													
									</p>
									<c:if test="${empty userHouseBean && empty userCompanyBean}">
										<p>
											<span class="accordion-content-tips-left">合同资料:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">登记证书:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">行驶证:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">人车合影:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">借款承诺书:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">二代身份证:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">身份证验证图:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">抵押情况声明:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">违章信息:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">铭牌照片:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
									</c:if>
									
									<c:if test="${!empty userHouseBean}">
										<p>
											<span class="accordion-content-tips-left">房产证:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">现场照片:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">借款承诺书:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">借款申请书:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">他项凭证:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">二代身份证:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
									</c:if>
									
									<c:if test="${!empty userCompanyBean}">
										<p>
											<span class="accordion-content-tips-left">营业执照:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">开户许可证:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">组织机构代码证:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">二代身份证:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">手机认证:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">收入证明:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
										<p>
											<span class="accordion-content-tips-left">工作证明:</span>
											<span class="accordion-content-tips-right">通过</span>
										</p>
									</c:if>
								</ul>
							</li>
							<li>
								<div class="link">
									</i>
									<div class="contentPic">
										<img src="images/tzjly.png" />
									</div>
									<span class="contentName">投资记录</span><i class="fa fa-chevron-down"></i>
								</div>
								<ul class="submenu">

									<table border="0" cellspacing="" cellpadding="" class="invisteRer">
										<tr>
											<th>投资人/投资时间</th>
											<th>投资金额(元)</th>
										</tr>
										<c:if test="${!empty listSubjectAccount }">
										<c:forEach items="${listSubjectAccount}" var="subjectBean">
											<tr style="border-bottom: 1px solid #EEEEEE;">
												<th>
													<p>${subjectBean.telephone}</p>
													<p class="tz-time">${subjectBean.investTime }</p>
												</th>
												<th>${subjectBean.investMoney }</th>
											</tr>
										</c:forEach>
										</c:if>
									</table>
								</ul>
							</li>
							<li>
								<div class="link">
									</i>
									<div class="contentPic">
										<img src="images/aqbzy.png" />
									</div>
									<span class="contentName">安全保障</span><i class="fa fa-chevron-down"></i>
								</div>
								<ul class="submenu">
									<img src="images/aqbzBG.png" class="aqbzBG" />
								</ul>
							</li>
							<li>
								<div class="link">
									</i>
									<div class="contentPic">
										<img src="images/risk-agreement.png" />
									</div>
									<span class="contentName">风险提示</span><i class="fa fa-chevron-down"></i>
								</div>
								<ul class="submenu" style="text-align: left; font-size: 14px; color: #141414;">
									市场有风险，出借需谨慎。请您在出借前，仔细阅读
									<span onclick="goPromptBooks()"><font color="blue">《网络借贷风险及禁止性行为提示书》</font></span>和
									<span onclick="goLegitimate()"><font color="blue">《资金来源合法承诺书》</font></span>。
								</ul> 
							</li>
							<c:if test="${!empty spLst}">
							<li>
								<div class="link">
									</i>
									<div class="contentPic">
										<img src="images/wx-bxq-zztp.png" />
									</div>
									<span class="contentName">资质材料</span><i class="fa fa-chevron-down"></i>
								</div>
								<ul class="submenu" style="margin-bottom: 40px;">
									<div class="container">
										<div class="my-gallery">
											<c:forEach items="${spLst}" var="subjectPicBean">
											<figure>
												<a href="${subjectPicBean.picUrl}" data-size="800x1142">
													<img src="${subjectPicBean.picUrl}" style="height:100px;"/>
												</a>
											</figure>
											</c:forEach>	
										</div>
									</div>
									<div class="pswp" tabindex="-1" role="dialog" aria-hidden="true">
										<div class="pswp__bg"></div>
										<div class="pswp__scroll-wrap">
											<div class="pswp__container">
												<div class="pswp__item"></div>
												<div class="pswp__item"></div>
												<div class="pswp__item"></div>
											</div>
											<div class="pswp__ui pswp__ui--hidden">
												<div class="pswp__top-bar">
													<div class="pswp__counter"></div>
													<button class="pswp__button pswp__button--close" title="Close (Esc)"></button>
													<div class="pswp__preloader">
														<div class="pswp__preloader__icn">
															<div class="pswp__preloader__cut">
																<div class="pswp__preloader__donut"></div>
															</div>
														</div>
													</div>
												</div>
												<div class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
													<div class="pswp__share-tooltip"></div>
												</div>
												<button class="pswp__button pswp__button--arrow--left" title="Previous (arrow left)"></button>
												<button class="pswp__button pswp__button--arrow--right" title="Next (arrow right)"></button>
												<div class="pswp__caption">
													<div class="pswp__caption__center"></div>
												</div>
											</div>
										</div>
									</div>
								</ul>
							</li>
							</c:if>
							<li>
									<p style="font-size:12px;text-align:center;padding-top:22px;">温馨提示：理财有风险，投资需谨慎!</p>
							</li>
						</ul>
						
				<a href="javascript:void(0);" class="touziBtn" onclick="investNow(${subjectBeans.subjectId},${subjectBeans.subjectStatus},${subjectBeans.subjectStartingMoney})">
					立即投资
				</a>
</body>
	<script type="text/javascript">
		//进度条提示位置说明

		/*left的值取决于标的进度，也就是progress-bar-y的宽度，progress-bar-tips的left=progress-bar-y的宽度-8% 例如 62%=70%-8% 即总是差8*/
		//1.获取progress-bar-tips的内容数值
		//2.该数值-8
		//3.

		$('.progress-bar-tips').css('left', '第二部的那个数字');
		//tab切换
		$('.program_1').click(function() {
			$('.program_1').css('color', 'white');
			$('.program_1').css('background-color', '#F95D18');
			$('.program_2').css('color', '#141414');
			$('.program_2').css('background-color', 'white');
			$('.program_1_con').css('opacity', '1');
			$('.program_1_con').css('z-index', '100');
			$('.program_2_con').css('opacity', '0');
			$('.program_2_con').css('z-index', '1');
		});

		$('.program_2').click(function() {
			$('.program_2').css('color', 'white');
			$('.program_2').css('background-color', '#F95D18');
			$('.program_1').css('color', '#141414');
			$('.program_1').css('background-color', 'white');
			$('.program_1_con').css('opacity', '0');
			$('.program_1_con').css('z-index', '1');
			$('.program_2_con').css('opacity', '1');
			$('.program_2_con').css('z-index', '100');
		});

		//收缩信息
		$(function() {

			var Accordion = function(el, multiple) {
				this.el = el || {};
				this.multiple = multiple || false;

				var links = this.el.find('.link');

				links.on('click', {
					el: this.el,
					multiple: this.multiple
				}, this.dropdown);
			}

			Accordion.prototype.dropdown = function(e) {
				var $el = e.data.el;
				$this = $(this),
					$next = $this.next();
				$next.slideToggle();
				$this.parent().toggleClass('open');
				2

				if(!e.data.multiple) {
					$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
				};
			}

			var accordion = new Accordion($('#accordion2'), false);
			var accordion = new Accordion($('#accordion3'), false);
			var accordion = new Accordion($('#accordion4'), false);
			var accordion = new Accordion($('#accordion5'), false);
			var accordion = new Accordion($('#accordion6'), false);
			var accordion = new Accordion($('#accordion7'), false);
			var accordion = new Accordion($('#accordion8'), false);
			var accordion = new Accordion($('#accordion9'), false);
			var accordion = new Accordion($('#accordion10'), false);
			var accordion = new Accordion($('#accordion11'), false);
			var accordion = new Accordion($('#accordion12'), false);
			var accordion = new Accordion($('#accordion13'), false);
			var accordion = new Accordion($('#accordion14'), false);
			var accordion = new Accordion($('#accordion15'), false);
			var accordion = new Accordion($('#accordion16'), false);

		});

		$('.wx-tz-tips').click(function(event) {
			$('.chat-box').show();
			event.stopPropagation();
		});
		$('.chat-box').click(function(event) {
			$('.chat-box').hide();
			event.stopPropagation();
		})
		$('.head').click(function(event) {
			$('.chat-box').hide();
			event.stopPropagation();
		});
	</script>

	<!--图片js-->
	<script src="js/photoswipe.min.js"></script>
	<script src="js/photoswipe-ui-default.min.js"></script>
	<script type="text/javascript">
		var initPhotoSwipeFromDOM = function(gallerySelector) {

			var parseThumbnailElements = function(el) {
				var thumbElements = el.childNodes,
					numNodes = thumbElements.length,
					items = [],
					figureEl,
					linkEl,
					size,
					item;

				for(var i = 0; i < numNodes; i++) {

					figureEl = thumbElements[i];

					if(figureEl.nodeType !== 1) {
						continue;
					}

					linkEl = figureEl.children[0];

					size = linkEl.getAttribute('data-size').split('x');

					item = {
						src: linkEl.getAttribute('href'),
						w: parseInt(size[0], 10),
						h: parseInt(size[1], 10)
					};

					if(figureEl.children.length > 1) {

						item.title = figureEl.children[1].innerHTML;
					}

					if(linkEl.children.length > 0) {

						item.msrc = linkEl.children[0].getAttribute('src');
					}

					item.el = figureEl;
					items.push(item);
				}

				return items;
			};

			var closest = function closest(el, fn) {
				return el && (fn(el) ? el : closest(el.parentNode, fn));
			};

			var onThumbnailsClick = function(e) {
				e = e || window.event;
				e.preventDefault ? e.preventDefault() : e.returnValue = false;

				var eTarget = e.target || e.srcElement;

				var clickedListItem = closest(eTarget, function(el) {
					return(el.tagName && el.tagName.toUpperCase() === 'FIGURE');
				});

				if(!clickedListItem) {
					return;
				}

				var clickedGallery = clickedListItem.parentNode,
					childNodes = clickedListItem.parentNode.childNodes,
					numChildNodes = childNodes.length,
					nodeIndex = 0,
					index;

				for(var i = 0; i < numChildNodes; i++) {
					if(childNodes[i].nodeType !== 1) {
						continue;
					}

					if(childNodes[i] === clickedListItem) {
						index = nodeIndex;
						break;
					}
					nodeIndex++;
				}

				if(index >= 0) {

					openPhotoSwipe(index, clickedGallery);
				}
				return false;
			};

			var photoswipeParseHash = function() {
				var hash = window.location.hash.substring(1),
					params = {};

				if(hash.length < 5) {
					return params;
				}

				var vars = hash.split('&');
				for(var i = 0; i < vars.length; i++) {
					if(!vars[i]) {
						continue;
					}
					var pair = vars[i].split('=');
					if(pair.length < 2) {
						continue;
					}
					params[pair[0]] = pair[1];
				}

				if(params.gid) {
					params.gid = parseInt(params.gid, 10);
				}

				return params;
			};

			var openPhotoSwipe = function(index, galleryElement, disableAnimation, fromURL) {
				var pswpElement = document.querySelectorAll('.pswp')[0],
					gallery,
					options,
					items;

				items = parseThumbnailElements(galleryElement);

				options = {

					galleryUID: galleryElement.getAttribute('data-pswp-uid'),
					getThumbBoundsFn: function(index) {

						var thumbnail = items[index].el.getElementsByTagName('img')[0],
							pageYScroll = window.pageYOffset || document.documentElement.scrollTop,
							rect = thumbnail.getBoundingClientRect();

						return {
							x: rect.left,
							y: rect.top + pageYScroll,
							w: rect.width
						};
					}

				};

				if(fromURL) {
					if(options.galleryPIDs) {

						for(var j = 0; j < items.length; j++) {
							if(items[j].pid == index) {
								options.index = j;
								break;
							}
						}
					} else {

						options.index = parseInt(index, 10) - 1;
					}
				} else {
					options.index = parseInt(index, 10);
				}

				if(isNaN(options.index)) {
					return;
				}

				if(disableAnimation) {
					options.showAnimationDuration = 0;
				}

				gallery = new PhotoSwipe(pswpElement, PhotoSwipeUI_Default, items, options);
				gallery.init();
			};

			var galleryElements = document.querySelectorAll(gallerySelector);

			for(var i = 0, l = galleryElements.length; i < l; i++) {
				galleryElements[i].setAttribute('data-pswp-uid', i + 1);
				galleryElements[i].onclick = onThumbnailsClick;
			}

			var hashData = photoswipeParseHash();
			if(hashData.pid && hashData.gid) {
				openPhotoSwipe(hashData.pid, galleryElements[hashData.gid - 1], true, true);
			}
		};

		initPhotoSwipeFromDOM('.my-gallery');
	</script>
</html>