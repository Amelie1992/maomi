<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/navigation.css"/>
		<link rel="stylesheet" type="text/css" href="css/fontpage/fontpage.css"/>
		<script type="text/javascript" src="js/navigation.js"></script>
		<script type="text/javascript" src="js/isWeixin.js"></script>
		<script type="text/javascript" src="js/fontpage/fontpage.js"></script>
		<title>首页</title>
	</head>

	<body>
	<input type="hidden" id="basePath" value="<%=basePath%>" />
	
	<form action="" id="form1" method="post">
    	<input type="hidden" id="subjectId"  name="subjectId" value=""/>
    </form>
	
	<form method="post" action="<%=basePath%>subject/s/detailsubject" id="gotodetailFrm" >
    	<input type="hidden" id="id"  name="id" value=""/>
    	<input type="hidden" id="crowdId"  name="crowdId" value=""/>
    </form>
	
		<div class="wrap"> 
		<!-- <div class="banner">
			<div class="swiper-container">
				<div class="swiper-wrapper">
					<div class="swiper-slide" onclick="toHref(33)"><img src="images/banner/new_inves_banner_wx.jpg" /></div>
					<div class="swiper-slide" onclick="toHref(32)"><img src="images/banner/two_twelve_banner_wx.jpg" /></div>
					<div class="swiper-slide" onclick="toHref(27)"><img src="images/banner/banner-wx-threePaul.jpg" /></div>
					<div class="swiper-slide" onclick="toHref(25)"><img src="images/savings/banner-redp.jpg" /></div>
					<div class="swiper-slide" onclick="toHref(20)"><img src="images/banner-wechat.jpg" /></div>
					<div class="swiper-slide" onclick="toHref(12)"><img src="images/banner2.png" /></div>
				</div>
				Add Pagination
				<div class="swiper-pagination"></div>
			</div>
		</div> -->
		<div class="banner">
			<div class="swiper-container">
				<div class="swiper-wrapper">
					<c:forEach items="${bannerList}" var="cd">
						<div class="swiper-slide"><a href="${cd.picLink }"><img src="${cd.picUrl }" /></a></div>
					</c:forEach>
				</div>
				<!-- Add Pagination -->
				<div class="swiper-pagination"></div>
			</div>
		</div>
		
		<div class="yqhy">
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th onclick="toHref(1)">
						<img src="images/yaoqinghaoyouicon.png" style="width: 60px;height: 60px;"/>
					</th>
					<th onclick="toHref(2)">
						<img src="images/choujiangicon.png" style="width: 60px;height: 60px;"/>
					</th>
					<th onclick="toHref(6)">
						<img src="images/savings/savings.png" style="width: 60px;height: 60px;"/>
					</th>
					<th onclick="toHref(28)">
						<img src="images/savings/wx-lxjsq.png" style="width: 60px;height: 60px;"/>
					</th>
				</tr>
				<tr>
					<td onclick="toHref(1)">
						新手福利
					</td>
					<td onclick="toHref(2)">
						鱼干抽奖
					</td>
					<td onclick="toHref(6)">
						猫咪储蓄
					</td>
					<td onclick="toHref(28)">
						利息计算
					</td>
				</tr>
				
			</table>
		</div>
		
		<div class="guide">
			<!-- <img src="images/guide.png" onclick="gotorecharge()"/> -->
			<img src="images/mm-wx-fp-lcqb.png" onclick="gotorecharge()"/>
		</div>
		<div class="att">
			<img src="images/att.png" />&nbsp;&nbsp;投资有风险，入市需谨慎！
		</div>
		<!-- 新手标 -->
		<div class="space"></div>
		<div class="content">
			<div class="content-box">
				<p> <span class="content-title xszx-title">新手专享</span> <span class="content-title-tips xszx-tips">新手专享送888体验金</span></p>
				<c:forEach items="${newSubject}" var="cd">
					<p class="content-detail-title">${cd.subjectName}
						<span><fmt:formatNumber type="number" value="${cd.subjectStartingMoney}" maxFractionDigits="0"></fmt:formatNumber>起投</span>
						<span>限投${newCount}次</span>
					</p>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th><span class="content-rate">${cd.subjectRate}</span>%</th>
							<th>剩余期限：<span>${cd.subjectPeriods }
								<c:if test="${'0'==cd.subjectTerm }">天</c:if>
								<c:if test="${'1'==cd.subjectTerm }">月</c:if>
								<c:if test="${'2'==cd.subjectTerm }">年</c:if></span></th>
							<th rowspan="2" style="text-align: center;">
								<c:choose>
									<c:when test="${cd.subjectOverplusMoney=='0.00'}">
										<img src="images/mm-wx-fp-tzym.png" />
									</c:when>
									<c:otherwise>
										<img src="images/fp-tz-btn.png" onclick="investNow(${cd.subjectId})"/>
									</c:otherwise>
								</c:choose>
							</th>
						</tr>
						<tr>
							<td>参考年回报率</td>
							<td>剩余金额：<span>${cd.subjectOverplusMoney}元</span></td>
						</tr>
					</table>
				</c:forEach>
				<p class="lookmore" onclick="queryMore(0)">查看更多</p>
			</div>
			<div class="space">

			</div>
			<div class="content-box zc-box">
				<c:forEach items="${crowdfund}" var="sj">
				<p> <span class="content-title tszc-title">
						<c:if test="${sj.crowdStatus==0 }">未开始</c:if>
						<c:if test="${sj.crowdStatus==1 }">众筹开始</c:if>
						<c:if test="${sj.crowdStatus==2 }">已满标</c:if>
						<c:if test="${sj.crowdStatus==3 }">众筹集资结束</c:if>
						<c:if test="${sj.crowdStatus==4 }">众筹失败</c:if>
						<c:if test="${sj.crowdStatus==5 }">众筹成功</c:if>
						<c:if test="${sj.crowdStatus==6 }">众筹结束</c:if>
					</span> <span class="content-title-tips tszc-tips">特色玩法 丰厚奖励</span></p>
				
					<table border="0" cellspacing="" cellpadding="" onclick="detailCrowdfund(${sj.crowdId})">
						<tr>
							<th>
								<img src="${sj.picUrl}" />
							</th>
							<th>
								<div class="content-detail-title">${sj.crowdName}</div>
								<p>上限金额：<span>${sj.crowdMoney}元</span></p>
								<p>单笔金额：<span>${sj.eachMoney}元</span></p>
								<p>参考年回报率：<span>${sj.crowdRate}%</span></p>
								<p>投资期限：<span>${sj.activityDay}天</span></p>
							</th>
						</tr>
					</table>
			</c:forEach>
				<p class="lookmore" onclick="queryMore(5)">查看更多</p>
			</div>
			<div class="space">

			</div>
			<div class="content-box">
				<p> <span class="content-title rmtj-title">热门推荐</span> <span class="content-title-tips rmtj-tips">稳健理财 放心资产</span></p>
				<c:forEach items="${highSubjcet}" var="cd">
					<p class="content-detail-title">${cd.subjectName}
						<span><fmt:formatNumber type="number" value="${cd.subjectStartingMoney}" maxFractionDigits="0"></fmt:formatNumber>起投</span>
					</p>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th><span class="content-rate">${cd.subjectRate}</span>%</th>
							<th>剩余期限：<span>${cd.subjectPeriods }
											<c:if test="${'0'==cd.subjectTerm }">天</c:if>
											<c:if test="${'1'==cd.subjectTerm }">月</c:if>
											<c:if test="${'2'==cd.subjectTerm }">年</c:if>
										</span></th>
							<th rowspan="2" style="text-align: center;">
								<c:choose>
									<c:when test="${cd.subjectOverplusMoney=='0.00'}">
										<img src="images/mm-wx-fp-tzym.png" />
									</c:when>
									<c:otherwise>
										<img src="images/fp-tz-btn.png" onclick="investNow(${cd.subjectId})"/>
									</c:otherwise>
								</c:choose>
							</th>
						</tr>
						<tr>
							<td>参考年回报率</td>
							<td>剩余金额：<span>${cd.subjectOverplusMoney}元</span></td>
						</tr>
					</table>
				</c:forEach>
				<p class="lookmore" onclick="queryMore(4)">查看更多</p>
			</div>
			<div class="space">

			</div>
			<div class="content-box">
					<p> <span class="content-title jxlc-title">精选理财</span> <span class="content-title-tips jxlc-tips">稳健理财 多重选择</span></p>
					<c:forEach items="${commonSubjcet}" var="cd">
						<p class="content-detail-title">${cd.subjectName}
							<span><fmt:formatNumber type="number" value="${cd.subjectStartingMoney}" maxFractionDigits="0"></fmt:formatNumber>起投</span>
						</p>
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th><span class="content-rate">${cd.subjectRate}</span>%</th>
								<th>剩余期限：<span>${cd.subjectPeriods }
												<c:if test="${'0'==cd.subjectTerm }">天</c:if>
												<c:if test="${'1'==cd.subjectTerm }">月</c:if>
												<c:if test="${'2'==cd.subjectTerm }">年</c:if>
											</span></th>
								<th rowspan="2" style="text-align: center;">
									<c:choose>
										<c:when test="${cd.subjectOverplusMoney=='0.00'}">
											<img src="images/mm-wx-fp-tzym.png" />
										</c:when>
										<c:otherwise>
											<img src="images/fp-tz-btn.png" onclick="investNow(${cd.subjectId})"/>
										</c:otherwise>
									</c:choose>
								</th>
							</tr>
							<tr>
								<td>参考年回报率</td>
								<td>剩余金额：<span>${cd.subjectOverplusMoney}元</span></td>
							</tr>
						</table>
					</c:forEach>
					<p class="lookmore" onclick="queryMore(1)">查看更多</p>
				</div>
				<div class="space">
	
				</div>
			 <div class="content-box">
				<p> <span class="content-title cryg-title">预发布标</span> <span class="content-title-tips cryg-tips">优选理财 抢先通知</span></p>
				<c:forEach items="${tomorrowSubjcet}" var="cd">
					<p class="content-detail-title">${cd.subjectName}
						<span><fmt:formatNumber type="number" value="${cd.subjectStartingMoney}" maxFractionDigits="0"></fmt:formatNumber>起投</span>
						<span>
								<c:if test="${'0'==cd.nextType }">新手专享标</c:if>
								<c:if test="${'1'==cd.nextType }">精选理财</c:if>
								<c:if test="${'4'==cd.nextType }">爆款标</c:if>
						</span>
					</p>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th><span class="content-rate">${cd.subjectRate}</span>%</th>
							<th>标的期限：<span>${cd.subjectPeriods }
											<c:if test="${'0'==cd.subjectTerm }">天</c:if>
											<c:if test="${'1'==cd.subjectTerm }">月</c:if>
											<c:if test="${'2'==cd.subjectTerm }">年</c:if>
										</span></th>
							<th rowspan="2" style="text-align: center;" onclick="investTomorrow(${cd.chooseFlag},'${cd.flag }')">
								<span class="yfb-time">
								<c:choose>
									<c:when test="${0==cd.chooseFlag }">
										今日
									</c:when>
									<c:otherwise>
										明日
									</c:otherwise>
								</c:choose>
								${cd.flag }
								</span>
							</th>
						</tr>
						<tr>
							<td>参考年回报率</td>
							<td>标的金额：<span>${cd.subjectMoney}元</span></td>
						</tr>
					</table>
				</c:forEach>
				<c:if test="${empty tomorrowSubjcet}">
					<p class="lookmore">主人，一大波优质标正马不停蹄向您赶来</p>
				</c:if>
				<%-- <c:if test="${!empty tomorrowSubjcet}">
					<p class="lookmore" onclick="queryMore(3)">查看更多</p>
				</c:if> --%>
			</div>
			<div class="space">

			</div>
		</div>
		
		<div class="about">
        	<table border="0" cellspacing="" cellpadding="">
        		<tr>
        			<th onclick="toHref(3)"><img src="images/about.png"/></th>
        			<th onclick="toHref(4)"><img src="images/safe.png"/></th>
        			<th onclick="toHref(5)"><img src="images/gaoguan.png"/></th>
        		</tr>
        		<tr>
        			<td onclick="toHref(3)">关于我们</td>
        			<td onclick="toHref(4)">安全保障</td>
        			<td onclick="toHref(5)">联系客服</td>
        		</tr>
        	</table>
        </div>
        
	
			<!-- 空白导航  防止被底部导航栏遮住内容 -->
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
						<td onclick="toChange(this,1)" class="currentChose">首页</td>
						<td onclick="toChange(this,2)">投资</td>
						<td onclick="toChange(this,3)">商城</td>
						<td onclick="toChange(this,4)">我</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
	<script src="js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript">
		var swiper = new Swiper('.swiper-container', {
			pagination: '.swiper-pagination',
			paginationClickable: true,
			autoplay: 2000,
			loop: true,
		});
		
 	</script>

</html>