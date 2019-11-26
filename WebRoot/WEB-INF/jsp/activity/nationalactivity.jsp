<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
<script type="text/javascript" src="js/navigation.js"></script>
<script type="text/javascript" src="js/nationalactivity/nationalactivity.js"></script>

<title>国庆活动</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/nationalactivity/nationalactivity.css" />

</head>

<body>
	<div class="wrap">
			<div class="banner">
				<img src="images/wx-gq-banner.png" />
				<img src="images/wx-gq-cloud(2).png" />
			</div>

			<div class="gq-jizi">
				<div>
					<img src="images/wx-gq-cloud.png" style="height: 18px;float: left;padding: 50px 0 5px 0;" />
				</div>
				<div class="textbox">
					<p>国庆天天乐，集字拿现金</p>
					<p>活动时间：09月28日--10月08日
						<span style="margin-left: 20px;" onclick="scrollToEnd()"><u name="toRule">活动规则</u></span>
					</p>
					<img src="images/wx-gq-cloud.png" style="height: 18px;position: absolute;right: 0px;bottom: 0;" />
				</div>

				<div class="iconBox">
					<table border="0" cellspacing="" cellpadding="">
						<!--收集到字 换src-->
						<tr>
							<th>
								<c:if test="${counts.niu>0}">
									<img src="images/qx-niur.png" class="wx-gq-icon"/>
								</c:if>
								<c:if test="${counts.niu==0}">
									<img src="images/qx-niug.png" class="wx-gq-icon"/>
								</c:if>
								<img src="images/wx-gq-g-g.png" class="wx-gq-g" />

							</th>

							<th>
								<c:if test="${counts.lang>0}">
									<img src="images/qx-langr.png" class="wx-gq-icon"/>
								</c:if>
								<c:if test="${counts.lang==0}">
									<img src="images/qx-langg.png" class="wx-gq-icon"/>
								</c:if>
								<img src="images/wx-gq-g-g.png" class="wx-gq-g" />

							</th>

							<th>
								<c:if test="${counts.zhi>0}">
									<img src="images/qx-zhir.png" class="wx-gq-icon"/>
								</c:if>
								<c:if test="${counts.zhi==0}">
									<img src="images/qx-zhig.png" class="wx-gq-icon"/>
								</c:if>
								<img src="images/wx-gq-g-g.png" class="wx-gq-g" />

							</th>

							<th>
								<c:if test="${counts.nv>0}">
									<img src="images/qx-nvr.png" class="wx-gq-icon"/>
								</c:if>
								<c:if test="${counts.nv==0}">
									<img src="images/qx-nvg.png" class="wx-gq-icon"/>
								</c:if>
								<img src="images/wx-gq-g-g.png" class="wx-gq-g" />

							</th>
						</tr>
						
						<tr>
							<td>
								<span>${counts.niu}</span>
							</td>
							<td>
								<span>${counts.lang}</span>
							</td>
							<td>
								<span>${counts.zhi}</span>
							</td>
							<td>
								<span>${counts.nv}</span>
							</td>
						</tr>
					</table>
					<!--集满字变成btn-after-->
					<c:if test="${counts.niu>0&&counts.lang>0&&counts.zhi>0&&counts.nv>0}">
						<a href="javascript:grantrewards()" class="btn-after">立即合成</a>
					</c:if>
					<c:if test="${counts.niu==0||counts.lang==0||counts.zhi==0||counts.nv==0}">
						<a href="javascript:void(0)" class="btn-before">立即合成</a>
					</c:if>
					

				</div>
				<div class="floatcloud">
					<img src="images/wx-gq-cloud.png" style="height: 18px;position: absolute;right: 0px;bottom: 0;" />
				</div>

			</div>
			<div class="gq-touzi">
				<div class="textbox" style="padding-top: 0;">
					<p>国庆当天投满标，抽现金红包</p>
					<p>活动时间：10月1日
						<span style="margin-left: 20px;" onclick="scrollToEnd()"><u name="toRule">活动规则</u></span>
					</p>
					<img src="images/wx-gq-cloud.png" style="height: 18px;position: absolute;right: 0px;bottom: 0;" />
				</div>
				<div class="iconBox">
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th style="background-image: none;position:relative;">
								<!--有资格之后换src-->
								<!--b标签变display:block-->
								<c:if test="${nationalCounts!=0}">
									<img src="images/wx-gq-closebag.png" style="width: 70%;position: relative;left: 0;top: 0;" id="rotare1" onclick="openPocket(1)"/>
								</c:if>
								<c:if test="${nationalCounts==0}">
									<img src="images/wx-gq-closebag.png" style="width: 70%;position: relative;left: 0;top: 0;" id="rotare1" onclick="openPocket(3)"/>
								</c:if>
								<b id="bag1">￥${nationalMoney}元</b>
							</th>
							<th style="background-image: none;">
								
									<c:if test="${nationalCounts==0}">
										<p>还未获得抽奖资格！</p>
										<p>快去投资吧！</p>
										<a href="<%=basePath%>subject/s/queryhighsubject" class="btn-after">我要投资</a>
									</c:if>
									<c:if test="${nationalCounts!=0}">
										<c:if test="${nationalFlag!=0 }">
											<p>奖励已发送，注意查收</p>
											<a href="<%=basePath%>loginregister/s/goCustomer" class="btn-after">联系客服</a>
										</c:if>
									</c:if>
									<c:if test="${nationalCounts!=0}">
										<c:if test="${nationalFlag==0}">
											<!--有资格之后btn-after 字内容变成联系客服-->
											<p>已获得抽奖资格！</p>
											<p>点开红包试试手气吧！</p>
											<a href="<%=basePath%>loginregister/s/goCustomer" class="btn-after">联系客服</a>
										</c:if>
									</c:if>
								
								
							</th>
						</tr>

					</table>
					<p style="line-height: 20px;">10月1号当天投资国庆活动标满5000元可获得现金红包抽取机会，仅限一次！领取请联系客服。</p>

				</div>
			</div>

			<div class="gq-qiandao">
				<div class="textbox" style="padding-top: 0;">
					<p>国庆1-8号满签到，抽现金红包</p>
					<p>活动时间：10月01日--10月08日
						<span style="margin-left: 20px;" onclick="scrollToEnd()"><u name="toRule">活动规则</u></span>
					</p>
					<img src="images/wx-gq-cloud.png" style="height: 18px;position: absolute;right: 0px;bottom: 0;" />
				</div>
				<div class="iconBox">
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th style="background-image: none;position:relative;">
								<!--有资格之后换src-->
								<!--b标签变display:block-->
								<c:if test="${fullSignCounts==0}">
									<img src="images/wx-gq-closebag.png" style="width: 70%;position: relative;left: 0;top: 0;" id="rotare2" onclick="openPocket(2)"/>
								</c:if>
								<c:if test="${fullSignCounts!=0}">
									<img src="images/wx-gq-closebag.png" style="width: 70%;position: relative;left: 0;top: 0;" id="rotare2" onclick="openPocket(4)"/>
								</c:if>
								<b id="bag2">￥${fullSignMoney }元</b>
							</th>
							<th style="background-image: none;">
							<!--没有资格的时候下面的字是 您还没有签到满八天,快去签到吧-->
								<c:choose>
									<c:when test="${fullSignCounts!=0}">
										<p>还差${fullSignCounts}天就满签啦！</p>
										<p>别忘记签到哟！</p>
										<a href="<%=basePath%>signin/toSignIn" class="btn-after">我要签到</a>
									</c:when>
									<c:when test="${fullSignCounts==0 && fullSignFlag!=0}">
										<p>奖励已发送，注意查收</p>
										<a href="<%=basePath%>loginregister/s/goCustomer" class="btn-after">联系客服</a>
									</c:when>
									<c:otherwise>
										<!--有资格之后btn-after 字内容变成联系客服-->
										<p>已获得抽奖资格</p>
										<p>点开红包试试手气吧</p>
										<a href="<%=basePath%>loginregister/s/goCustomer" class="btn-after">联系客服</a>
									</c:otherwise>
								</c:choose>
							</th>
						</tr>

					</table>
					<p style="line-height: 20px;">国庆中秋双节期间1号到8号累计满签，可获得一次抽奖机会，领取请联系客服。</p>

				</div>
			</div>
			<div class="gq-yqhy">
				<div class="textbox" style="padding-top: 0;">
					<p>邀请好友投资，领取48元红包</p>
					<p>活动时间：10月01日--10月08日
						<span style="margin-left: 20px;" onclick="scrollToEnd()"><u name="toRule">活动规则</u></span>
					</p>
					<img src="images/wx-gq-cloud.png" style="height: 18px;position: absolute;right: 0px;bottom: 0;" />
				</div>
				<div class="iconBox">
					<img src="images/wx-gq-xjq.png" class="wx-qg-xqj" />
					<c:choose>
						<c:when test="${inviteFriendCounts==0}">
							<!--没有邀请好友-->
							<p style="line-height: 20px;font-size: 12px;color: #EE423F;">您还没有获得领取现金券的资格，去邀请好友投资吧</p>
						</c:when>
						<c:when test="${inviteFriendCounts!=0 && inviteFriendFlag!=0}">
							<p style="font-size: 14px;color: #EE423F;">
								<span>未领取${inviteFriendCounts-inviteFriendFlag }张 </span>
								<span>已发送${inviteFriendFlag }张 </span>
								<a href="<%=basePath%>loginregister/s/goCustomer" class="btn-after">联系客服</a>
							</p>
						</c:when>
						<c:otherwise>
							<p style="font-size: 14px;color: #EE423F;">
								<span>恭喜您已获得<b style="color: #212121;">${inviteFriendCounts }张</b>现金券 </span>
								<a href="<%=basePath%>loginregister/s/goCustomer" class="btn-after">联系客服</a>
							</p>
						</c:otherwise>
					</c:choose>
					<p style="line-height: 20px;">
						好友接受您的邀请并首次投资满5000元，您将获得48元现金券一张，联系客服领取
					</p>
					
					
				</div>
			</div>

			<div class="gq-hdgz">
				<div class="textbox" style="padding-top: 0;">
					<p>活动规则</p>

					<img src="images/wx-gq-cloud.png" style="height: 18px;position: absolute;right: 0px;bottom: 0;" />
				</div>
				<div class="gq-hdgz-tips">
					<ul>
						<li>1.自09月28日至10月08日期间，小伙伴们只要通过投资爆款标、签到、债权承接、充值鱼干包括转盘抽到未中奖就有可能收集到“举、国、欢、庆”里的一个字，凡是集满一组字的小伙伴，可点击页面上方“立即合成”按钮，即可兑换28元 现金券奖励。此活动可重复合成领取现金券奖励！
						</li>
						<li>

							2.10月1号当天投资活动标单笔满5000元可获得1个现金券，仅限一次（金额随机奖励 20-200元，特殊渠道可参加，但无返点）。
						</li>
						<li>

							3.国庆1-8号满签到再送一次现金券抽奖机会（金额随机奖励20-200 元）。
						</li>
						<li>
							4.自09月28日至10月08日期间，小伙伴们邀请好友注册填写邀请手机号。好友首次投资满5000元送48元现金券（特殊渠道可参加，但无返点）。 
						</li>
						<li>
							5.活动自开始至10月08日时，为不影响之后的推出活动，凡是此次活动收集的字，将在10月10号10:00统一清除。希望集满的小伙伴不要忘记领取！满足领取现金券条件的小伙伴不要忘记联系客服领取！
						</li>
						<li>
							注意：<br/>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;以上活动仅限微信端，PC端不支持，望周知。
						</li>
					</ul>

				</div>
			</div>
			<div class="copyRight">
				<p>本活动最终解释权归猫咪财富所有</p>
				<p>您有任何问题请拨打咨询热线：400-000-3060</p>
				<p>或者客服微信：18105181539</p>
				<img src="images/wx-gq-cloud(2).png" />
			</div>
		</div>
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
						<td class="currentChose">首页</td>
						<td>投资</td>
						<td>商城</td>
						<td>我</td>
					</tr>
				</table>
			</div>
</body>

</html>
