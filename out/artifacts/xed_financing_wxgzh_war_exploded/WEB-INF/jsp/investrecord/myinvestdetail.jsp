<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html >
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/investrecord/myinvestdetail.css" />
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/investrecord/investrecord.js"></script>
<script src="js/accordion.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>js/validate.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>投资详情</title>

</head>
<body>

	<form action="<%=basePath%>investrecord/toTransfer" name="form1"
		method="post" id="form1">
		<input type="hidden" value="" id="investId" name="investId" /> <input
			type="hidden" value="" id="investMoney" name="investMoney" /> <input
			type="hidden" value="" id="totalCreditMoney" name="totalCreditMoney" /><input
			type="hidden" value="" id="subjectRate" name="subjectRate" />
			
	<div class="wrap">
			<div class="head">

				<h4>
					<img src="images/backW.png" class="back" onclick="goBack()"/>
				${iBean.subjectName}
				</h4>

				<p>${iBean.subjectRates}%<span class="wx-tz-tips">+<fmt:formatNumber type="number" value="${iBean.subjectRate-iBean.subjectRates}" maxFractionDigits="2"></fmt:formatNumber>% <img src="images/wx-tz-q.png"/></span></p>
				<div class="chat-box">
					
					<c:if test="${(iBean.subjectRate-iBean.subjectRates-iBean.vipRate)>0}">
						<c:if test="${'-1'==iBean.couponDetail.interestDays}">
							无计息期限
						</c:if>
						<c:if test="${'-1'!=iBean.couponDetail.interestDays}">
							
							计息${iBean.couponDetail.interestDays}<c:if test="${'0'==iBean.couponDetail.interestType}">
								天
							</c:if>
							<c:if test="${'1'==iBean.couponDetail.interestType}">
								月
							</c:if>
							<c:if test="${'2'==iBean.couponDetail.interestType}">
								年
							</c:if>
						</c:if><fmt:formatNumber type="number" value="${iBean.subjectRate-iBean.subjectRates-iBean.vipRate}" maxFractionDigits="2"></fmt:formatNumber>%加息券
						
							(+${iBean.vipRate}%等级加成)
					</c:if>
					<c:if test="${(iBean.subjectRate-iBean.subjectRates-iBean.vipRate)<=0}">
						
						<c:if test="${(iBean.subjectRate-iBean.subjectRates)>0}">
							+${iBean.vipRate}等级加成
						</c:if>
						<c:if test="${(iBean.subjectRate-iBean.subjectRates)<=0}">
							暂无加息加成
						</c:if>
						
					</c:if>
				</div>

				
				<p style="padding-bottom: 15px; border-bottom: 1px solid #F0AD4E;">
					参考年回报率
				</p>

				<div class="table-box">
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th style="border-right: 1px solid #FEB73B;">${iBean.couponMoney }(元)</th>
							<th style="border-right: 1px solid #FEB73B;">${iBean.investMoney }(元)</th>
							<th>
								${subjectBeans.subjectPeriods }
												<c:if test="${'0'==subjectBeans.subjectTerm }">天</c:if>
												<c:if test="${'1'==subjectBeans.subjectTerm }">月</c:if>
												<c:if test="${'2'==subjectBeans.subjectTerm }">年</c:if>
							</th>
						</tr>
						<tr>
							<td style="border-right: 1px solid #FEB73B;">优惠金
								<c:if test="${not empty iBean.couponDetail.couponMoney}">
									<c:if test="${'-1'!=iBean.couponDetail.interestDays }">(计息${iBean.couponDetail.interestDays }
										<c:if test="${'0'==iBean.couponDetail.interestType}">天</c:if>
										<c:if test="${'1'==iBean.couponDetail.interestType}">月</c:if>
										<c:if test="${'2'==iBean.couponDetail.interestType}">年</c:if>)
									</c:if>
									<%-- <c:if test="${'-1'==iBean.couponDetail.interestDays }">(无计息期限)</c:if> --%>
								</c:if>
							</td>
							<td style="border-right: 1px solid #FEB73B;">投资本金</td>
							<td>投资期限</td>
						</tr>
					</table>
				</div>

			</div>
			<div class="progress-bar-box">
				<div class="progress-bar">
					<span class="progress-bar-tips">
							(${day}/${days})
					</span>
					<p class="progress-bar-g"></p>
					<p class="progress-bar-y" style="width:${100*day/days}%;"></p>
				</div>
			</div>

			<p class="last-time">
				<span>计息方式:
					<c:if test="${'0'==iBean.repeatType}">等额本息</c:if>
					<c:if test="${'1'==iBean.repeatType}">先息后本</c:if>
					<c:if test="${'2'==iBean.repeatType}">到期还本付息</c:if>
				</span>
				<c:if test="${'1'==iBean.isEarly }">
					<span>
						<c:if test="${'0'==subjectBeans.subjectTerm }">已投天数:<b>${day}天</b></c:if>
						<c:if test="${'0'!=subjectBeans.subjectTerm }">已结算期数:<b>${day}期</b></c:if>
					</span>
				</c:if>
				<c:if test="${'2'==iBean.isEarly }">
					<span>
						提前还款:<b>${iBean.earlyTime }</b>
					</span>
				</c:if>
			</p>
			<p class="last-time">
				<span>
					利息管理费:${manageSum}元
				</span>
				<span>
					预计总收益:${profitSum}元
				</span>
			</p>
			<c:if test="${'2'==iBean.isEarly && makeup!='0.00'}">
				<p class="last-time" style="text-align:center;color:red;">借款用户提前还款，您将获得${makeup }元现金补偿</p>
			</c:if>
			<div id="tab">
				<div class="tabList">

					<ul>
						<li class="cur program_1">项目详情</li>
						<li class="program_2">收益结算</li>
					</ul>
				</div>
				<div class="tabCon">
					<div class="program_1_con">
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
										<span class="accordion-content-tips-left">投资期限:</span>
										<span class="accordion-content-tips-right">
											${subjectBeans.subjectPeriods }
												<c:if test="${'0'==subjectBeans.subjectTerm }">天</c:if>
												<c:if test="${'1'==subjectBeans.subjectTerm }">月</c:if>
												<c:if test="${'2'==subjectBeans.subjectTerm }">年</c:if>
										</span>
									</p>
									<p>
										<span class="accordion-content-tips-left">还款方式:</span>
										<span class="accordion-content-tips-right">
											<c:if test="${'0'==subjectBeans.repeatType }">等额本息</c:if>
											<c:if test="${'1'==subjectBeans.repeatType }">先息后本</c:if>
											<c:if test="${'2'==subjectBeans.repeatType }">到期还本付息</c:if>
										</span>
									</p>
									<c:if test="${'-2'!=subjectBeans.subjectId}">
									<p>
										<span class="accordion-content-tips-left">标总金额:</span>
										<span class="accordion-content-tips-right">${subjectBeans.subjectMoney}(元)</span>
									</p>
									<p>
										<span class="accordion-content-tips-left">起投金额:</span>
										<span class="accordion-content-tips-right">${subjectBeans.subjectStartingMoney}(元)</span>
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
									</c:if>
								</ul>
							</li>
							<c:if test="${'-2'!=subjectBeans.subjectId}">
							<c:choose>
								<c:when test="${'10'!=subjectBeans.usedPurpose}">
									<li>
										<div class="link">
											</i>
											<div class="contentPic">
												<img src="images/yqhy.png" />
											</div>
											<span class="contentName">
												贷款人基本资料
											</span><i class="fa fa-chevron-down"></i>
										</div>
										
										<ul class="submenu">
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
		
										</ul>
									</li>
		
									<li>
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
												<span class="accordion-content-tips-right">${subjectBeans.carMoney}(元)</span>
											</p>
											<p>
												<span class="accordion-content-tips-left">抵押价格:</span>
												<span class="accordion-content-tips-right">${subjectBeans.carExpectMoney}(元)</span>
											</p>
											<p>
												<span class="accordion-content-tips-left">车牌年限:</span>
												<span class="accordion-content-tips-right">${subjectBeans.carLimit}年</span>
											</p>
		
										</ul>
									</li>
		
									<li>
										<div class="link">
											</i>
											<div class="contentPic">
												<img src="images/yqhy.png" />
											</div>
											<span class="contentName">资质审核</span><i class="fa fa-chevron-down"></i>
										</div>
										<ul class="submenu">
											<p>
												<span class="accordion-content-tips-left" style="color: #888888;">审核资料</span>
												<span class="accordion-content-tips-right">审核结果</span>
											</p>
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
												<span class="accordion-content-tips-left">抵押声明:</span>
												<span class="accordion-content-tips-right">通过</span>
											</p>
											<p>
												<span class="accordion-content-tips-left">违章信息登记:</span>
												<span class="accordion-content-tips-right">通过</span>
											</p>
											<p>
												<span class="accordion-content-tips-left">铭牌照片:</span>
												<span class="accordion-content-tips-right">通过</span>
											</p>
		
										</ul>
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<div class="link">
											</i>
											<div class="contentPic">
												<img src="images/yqhy.png" />
											</div>
											<span class="contentName">
												供应链金融
											</span><i class="fa fa-chevron-down"></i>
										</div>
										
										<ul class="submenu">
											<p>
												<span class="accordion-content-tips-left">公司名称:</span>
												<span class="accordion-content-tips-right">${subjectBeans.userName}</span>
											</p>
											<p>
												<span class="accordion-content-tips-left">供应链金融:</span>
												<span class="accordion-content-tips-right"><a onclick="querySupplyChainFinanceContract(${subjectBeans.subjectId})">点击查看合同</a></span>
											</p>
										</ul>
									</li>
								</c:otherwise>
							</c:choose>
							</c:if>

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
											<th>投资人</th>
											<th>投资时间</th>
											<th>投资金额</th>
										</tr>
										<c:if test="${!empty listSubjectAccount }">
										<c:forEach items="${listSubjectAccount}" var="subjectBean">
										<tr>
											<td>${subjectBean.telephone}</td>
											<td>${subjectBean.investTime }</td>
											<td>${subjectBean.investMoney }(元)</td>
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
									<a href="<%=basePath%>safetySecurity.jsp">查看安全保障详情</a>

								</ul>
							</li>
						</ul>

					</div>

					<div class="program_2_con">

						<table border="0" cellspacing="" cellpadding="" style="margin-bottom: 40px;">
							<tr>
								<th>期数</th>
								<th>结算时间</th>
								<th>预计收益</th>
								<th>返还本金</th>
							</tr>
							<c:if test="${!empty  rspList}">
							<c:forEach items="${rspList}" var="rs">
							<tr>
								<td>第${rs.rn }期</td>
								<td>${rs.endTime }</td>
								<td>${rs.showProfit }(元)</td>
								<td>${rs.surplusMoney}(元)</td>
							</tr>
							</c:forEach>
							</c:if>
							<c:if test="${empty  rspList}">
							<tr>
								<td colspan="4">暂未满标</td>
							</tr>
							</c:if>
						</table>

					</div>
				</div>
			</div>

			<%-- <a href="javascript:transferNow(${iBean.investId},${iBean.subjectType},${iBean.investStatus},${iBean.repeatType},${iBean.subjectTerm},${iBean.investMoney},${iBean.subjectRate},${userScore},${transferScore})" class="touziBtn">
				立即转让
			</a> --%>
		</div>
		</form>
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

$('.wx-tz-tips').click(function (event) {
	$('.chat-box').show();
	event.stopPropagation();
});
$('.chat-box').click(function (event) {
	$('.chat-box').hide();
	event.stopPropagation();
})
$('.head').click(function (event) {
	$('.chat-box').hide();
	event.stopPropagation();
});

function goBack()
{
	window.location.href="./investrecord/queryinvest";	
}
</script>
</html>