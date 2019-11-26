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
<link rel="stylesheet" type="text/css" href="css/freedomsubject/dispersionsubjectdetail.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/showPic.css" />
<link rel="stylesheet" href="css/photoswipe.css">
<link rel="stylesheet" href="css/default-skin/default-skin.css">
<title>标详情</title>

		<script type="text/javascript">
		
		
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
			
			function goBack()
			{
				var form = document.forms['form1'];
				form.action = '<%=basePath%>subjectdispersed/querySubjectDispered';
				form.submit();
			}
		</script>
</head>
<body>
	<form action="<%=basePath%>subject/supplychainfinancecontract" id="financeContractForm" method="post">
		<input type="hidden" name="subjectId" id="subjectId" >
	</form>
	<form action="" id="form1" method="post">
		<input type="hidden" id="count" value="${count }">
		<input type="hidden" id="subjectType" value="${subjectBeans.subjectType}">
		<input type="hidden" id="freedomSubjectId" name="freedomSubjectId" value="${freedomSubjectId}">
	</form>
	<div class="wrap">
			
			<div class="head">
				<div class="title">
				<img src="images/backW.png" class="back" onclick="goBack()"/>分散投标详情
			</div>
				<p>
					<c:choose>
						<c:when test="${subjectBeans.usedPurpose=='5'}">
							资金周转
						</c:when>
						<c:when test="${subjectBeans.usedPurpose=='10'}">
							供应链金融
						</c:when>
						<c:otherwise>
							个人贷款
						</c:otherwise>
					</c:choose>
				</p>
				<p>${subjectBeans.subjectRate}%</p>
				<p>借款人约定借款利率</p>
			</div>
			<div class="content">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>还款进度：${subjectBeans.mCount }/${subjectBeans.subjectPeriods }期</th>
						<th>贷款总额：${subjectBeans.subjectMoney }元</th>
					</tr>
					<tr>
						<td>还款状态：正常还款</td>
						<td>投资团金额：${aMoney }元</td>
					</tr>
				</table>
			</div>
			<div class="space">

			</div>
			<div id="tab">
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
										<span class="accordion-content-tips-left">标总金额:</span>
										<span class="accordion-content-tips-right">${subjectBeans.subjectMoney}(元)</span>
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
										<span class="accordion-content-tips-right">${subjectBeans.subjectStartingMoney}(元)</span>
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
											<td>${fn:substring(subjectBean.accountName, 0, 1)}**</td>
											<td>${subjectBean.inTime }</td>
											<td>${subjectBean.money }(元)</td>
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
				</div>
			</div>	
	</div>
</body>
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">


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