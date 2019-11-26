<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/savings/savings.css" />

<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<script type="text/javascript" src="js/subject/redpackage.js"></script>
<title>储蓄罐</title>
</head>

<body>
	<input type="hidden" id="basePath" value="<%=basePath%>" />
	<input type="hidden" id="savingsmm" value="${allmoney }" />
	<input type="hidden" id="savings" value="" />
	
	<div class="wrap">
	<div class="title">
		<img src="images/backW.png" class="back" onclick="toBacks()"/>
	</div>
	
	<p id="cxq" onclick="gorule()"><img src="images/savings/cxg-q.png" class="cxg-q"/> <span><u>查看规则</u></span> </p>
		<div id="main" class="head"></div>
		
		<div class="head-infor">
			<c:if test="${fmoney == '1' }">
				<div><img src="images/savings/cxg-full.png" style="top: 54px;"/></div>
			</c:if>
			<c:if test="${fmoney == '0' }">
				<div><img src="images/savings/cxg-cashBag.png" /></div>
			</c:if>
			<div onclick="extractredpackage()">
				<img src="images/savings/cxg-btn.png" />
			</div>
			<div>${allmoney }</div>
		</div>
		<div class="content">
			<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
				<ul class="layui-tab-title">
					<li class="layui-this">我的红包</li>
					<li>红包明细</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<c:if test="${!empty listNoUsed }">
						<c:forEach items="${listNoUsed}" var="ln">
						
							<div class="content-detail">
								<div class="content-detail-pic">
									<img src="images/savings/cxg-redP.png" />
								</div>
								<div class="content-detail-text">
									<p>${ln.savingsMoney}元</p>
									<p>有效期至${ln.savingsValidity}</p>
								</div>
								<div class="content-detail-btn">
									<p onclick="redpackageopen(${ln.savingsId})">存入钱罐</p>
									<p onclick="outredpackage(${ln.savingsId})">送给朋友</p>
								</div>
							</div>
						</c:forEach>
						</c:if>
						<c:if test="${empty listNoUsed }">
							<div id="norecord">
								<img src="images/savings/nopackage.png" id="noredpackage"/>
							</div>
						</c:if>
					</div>
					<div class="layui-tab-item">
						
						<c:if test="${!empty listSavingsOther }">
							<ul>
								<c:forEach items="${listSavingsOther}" var="ls">
								<li>
									<table border="0" cellspacing="" cellpadding="">
										<tr>
											<th>${ls.savingsMoney}元</th>
											
											<c:if test="${ls.savingsType == '1'}">
												<c:if test="${ls.savingsFrom == '2'}">
													<th class="redPacket-in">好友赠送</th>
												</c:if>
												<c:if test="${ls.savingsFrom != '2'}">
													<th class="redPacket-in">存入</th>
												</c:if>
											</c:if>
											<c:if test="${ls.savingsType == '2'}">
												<th class="redPacket-out">送出</th>
											</c:if>
											<c:if test="${ls.savingsType == '3'}">
												<th class="redPacket-extract">提取</th>
											</c:if>
											<c:if test="${ls.savingsType == '-1'}">
												<th class="redPacket-extract">过期</th>
											</c:if>
											
											<th>${ls.addTime}</th>
										</tr>
									</table>
								</li>
								</c:forEach>
							</ul>
						</c:if>
						
						
						<c:if test="${empty listSavingsOther }">
							<div id="norecord">
								<img src="images/savings/nopackage.png" id="noredpackage"/>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<div class="redP-mask">
		</div>
		<div class="redP-content">
			<ul>
					<li class="redli"><input type="text" name="friendtelephone" id="friendtelephone" value="" placeholder="请输入好友手机号" /></li>
					<li class="redli" onclick="givefriend(0)">
						<p class="sendToFriend">立即赠送</p>
					</li>

			</ul>
			<img src="images/savings/tz-redp-close.png" class="close-redp" onclick="gosubject()"/>
		</div>
	</div>
	<!-- 空白导航  防止被底部导航栏遮住内容 -->
		<jsp:include page="../navigation/emptyDiv.jsp" flush="true"/>	
		<!-- 底部导航 -->
		
			<div class="footer">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="toChange(this,1)"><img src="images/tab_home_nor.png" /></th>
						<th onclick="toChange(this,2)"><img src="images/tab_touzi_nor.png" /></th>
						<th onclick="toChange(this,3)"><img src="images/tab_mall_nor.png" /></th>
						<th onclick="toChange(this,4)"><img src="images/tab_geren_sel.png" /></th>
					</tr>
					<tr>
						<td onclick="toChange(this,1)">首页</td>
						<td onclick="toChange(this,2)">投资</td>
						<td onclick="toChange(this,3)">商城</td>
						<td onclick="toChange(this,4)" class="currentChose">我</td>
					</tr>
				</table>
			</div>
</body>
	
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	
	<script src="js/layui-master/src/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/echarts.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="js/navigation.js"></script>
	<script type="text/javascript" src="js/isWeixin.js"></script>
	
	<script type="text/javascript">
		var m=parseFloat($("#savingsmm").val())/100 ;
		var myChart = echarts.init(document.getElementById('main'));
		var option = {
			series: [{
				name: "储蓄罐",
				type: "gauge",
				center: ["50%", "55%"], // 默认全局居中
				radius: "94%",
				axisLine: {
					show: false,
					lineStyle: { // 属性lineStyle控制线条样式
						color: [
							[m, "#f95e17"],
							[1, "#bdbdbd"]
						],
						width: 15
					}
				},
				splitLine: {
					show: false
				},
				axisTick: {
					show: false
				},
				axisLabel: {
					show: false
				},
				pointer: {
					show: false
				},
				detail: {
					rich: {
						score: {
							color: "#ffd71a",
							fontFamily: "微软雅黑",
							fontSize: 32
						},
						name: {
							height: 25,
							color: "#526680",
							fontFamily: "微软雅黑",
							fontSize: 14
						}
					}
				},

				data: [{
					value: 0,
					label: {
						textStyle: {
							fontSize: 12
						}
					}
				}]
			}, ]
		};

		myChart.setOption(option);

		layui.use('element', function() {
			var $ = layui.jquery,
				element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

		});
		function toBacks(){
			window.location.href="./subject/s/querysubject";
		}
	</script>
</html>