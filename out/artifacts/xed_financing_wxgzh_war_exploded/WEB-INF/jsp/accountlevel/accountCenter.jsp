<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" type="text/css" href="js/layui-master/dist/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
		<title>会员中心</title>
		<style type="text/css">
			.wrap {
				width: 100%;
				background-color: #161616;
			}
			
			.head {
				width: 100%;
				text-align: center;
				background-image: url(images/wx-vip-headbg.png);
				background-repeat: no-repeat;
				background-size: 100% 100%;
				background-position: center;
			}
			
			.head img:nth-child(1) {
				width: 30%;
				padding: 20px 0;
			}
			
			.head p:nth-child(2) {
				color: white;
				padding-bottom: 10px;
			}
			
			.head img:nth-child(3) {
				width: 20%;
				padding-bottom: 10px;
			}
			
			.vip-pro-bar {
				text-align: center;
				height: 30px;
				line-height: 30px;
				justify-content: center;
			}
			
			.vip-pro-bar div:nth-child(1) div {
				float: left;
				height: 30px;
			}
			
			.wrap .head .vip-pro-bar img {
				width: 60%;
			}
			
			.layui-progress-bar {
				background-color: #ad8a5c;
			}
			
			.vip-lable {
				background-image: url(images/wx-vip-lablebg.png);
				background-repeat: no-repeat;
				background-size: 100% 100%;
				background-position: center;
			}
			
			.vip-lable p {
				text-align: center;
				font-size: 12px;
				color: #332516;
				padding: 5px;
				line-height: 30px;
				height: 30px;
			}
			
			.vip-lable span {
				color: white;
			}
			
			.content {
				width: 96%;
				padding: 2%;
				background-color:#161616 ;
			}
			
			.my-pri {
				width: 100%;
			}
			
			.my-pri-title {
				line-height: 20px;
			}
			
			.my-pri-title span {
				display: inline-block;
				font-size: 14px;
				color: #AD8A5C;
			}
			
			.my-pri-title span:nth-child(1) {
				width: 4px;
				height: 20px;
				background-color: #AD8A5C;
			}
			
			.carousel {
				width: 100%;
			}
			
			.swiper-container {
				width: 100%;
				height: 100%;
				padding-bottom: 15px;
				border-bottom: 2px solid #AD8A5C;
			}
			
			.swiper-slide {
				text-align: center;
				font-size: 18px;
				/*background: #fff;*/
				/* Center slide text vertically */
				display: -webkit-box;
				display: -ms-flexbox;
				display: -webkit-flex;
				display: flex;
				-webkit-box-pack: center;
				-ms-flex-pack: center;
				-webkit-justify-content: center;
				justify-content: center;
				-webkit-box-align: center;
				-ms-flex-align: center;
				-webkit-align-items: center;
				align-items: center;
			}
			.swiper-slide img{
				width: 60%;
			}
			.swiper-slide2 {
				width:24%;
				text-align: center;
				font-size: 18px;
				/*background: #fff;*/
				/* Center slide text vertically */
				display: inline-block;
			}
			.swiper-slide2 img{
				padding-top:9px;
				width: 68%;
			}
			.other-pri {
				width: 100%;
				padding-top: 20px;
			}
			
			.other-pri-title {
				line-height: 20px;
			}
			
			.other-pri-title span {
				display: inline-block;
				font-size: 14px;
				color: #AD8A5C;
			}
			
			.other-pri-title span:nth-child(1) {
				width: 4px;
				height: 20px;
				background-color: #AD8A5C;
			}
			.other-pri-title span:nth-child(3) {
				float: right;
				color: #AD8A5C;
			}
			.other-pri-table{
				padding: 15px 0;
				width: 100%;
			}
			.other-pri-table table{
				width: 100%;
				text-align: center;
			}
			.other-pri-table table img{
				width: 67%;
			}
		</style>
	</head>

	<body>
		<div class="wrap">
			<div class="head">
				<img src="images/wx-vip-headpic-${accountLevel}.png" />
				<p>${accountName}</p>
				<img src="images/wx-vip-icon-${accountLevel}.png" />
				<div class="vip-pro-bar">
					<div style="margin: 0 auto;text-align: center;position: relative;top: -20px;height: 30px;">
						<div style="width: 10%;position: relative;left: 15px;z-index: 11;">
							<img src="images/wx-vip-icon-l-${accountLevel}.png" style="text-align: right;" />
						</div>
						<div style="width: 80%;position: relative;top: 30px;z-index: 0;">
							<div class="layui-progress" style="width: 100%;height: 3px;">
								<div class="layui-progress-bar" lay-percent="${s2}%" style="height: 3px;"></div>
							</div>

						</div>
						<div style="width: 10%;position: relative;right: 15px;z-index: 11;">
							<img src="images/wx-vip-icon-d-${accountLevel+1}.png" style="text-align: left;" />
						</div>
					</div>
				</div>
				<div class="vip-lable">
				<c:if test="${accountLevel==10}">
				</c:if>
				<c:if test="${accountLevel!=10}">
				<p>还差 <span>${investMoney2}元</span>可升级至VIP${accountLevel+1}级</p>
				</c:if>
				</div>

			</div>
			<div class="content">
				<div class="my-pri">
					<p class="my-pri-title">
						<span></span>
						<span style="position: relative;top: -4px;">我的特权</span>
						
					</p>
					<div class="carousel">
						<div class="swiper-container">
							<div class="swiper-wrapper">
							
							<c:if test="${accountLevel>=1}">
							<div class="swiper-slide"><a href="<%=basePath%>accountCenter/s/todetail?m=srhl"><img src="images/pc-vip-pri-srhl.png" /></a></div>
							<div class="swiper-slide"><a href="<%=basePath%>accountCenter/s/todetail?m=sjlb"><img src="images/pc-vip-pri-sjlb.png" /></a></div>
							</c:if>
							<c:if test="${accountLevel>=2}">
							<div class="swiper-slide"><a href="<%=basePath%>accountCenter/s/todetail?m=qdjx"><img src="images/pc-vip-pri-qdjx.png" /></a></div>
							<div class="swiper-slide"><a href="<%=basePath%>accountCenter/s/todetail?m=qdjx"><img src="images/pc-vip-pri-kqrh.png" /></a></div>
							<div class="swiper-slide"><a href="<%=basePath%>accountCenter/s/todetail?m=lxgl"><img src="images/pc-vip-pri-lxgl.png" /></a></div>
							<div class="swiper-slide"><a href="<%=basePath%>accountCenter/s/todetail?m=txsx"><img src="images/pc-vip-pri-txsx.png" /></a></div>
							</c:if>
							<c:if test="${accountLevel>=3}">
							<div class="swiper-slide"><a href="<%=basePath%>accountCenter/s/todetail?m=tzjx"><img src="images/pc-vip-pri-tzjx.png" /></a></div>
							<div class="swiper-slide"><a href="<%=basePath%>accountCenter/s/todetail?m=bqgn"><img src="images/pc-vip-pri-bqgn.png" /></a></div>
							</c:if>
							<c:if test="${accountLevel>=4}">
							<div class="swiper-slide"><a href="<%=basePath%>accountCenter/s/todetail?m=tqtx"><img src="images/pc-vip-pri-tqtx.png" /></a></div>
							</c:if>
							<%-- <c:if test="${accountLevel>=5}">
							<div class="swiper-slide"><a href="<%=basePath%>accountCenter/s/todetail?m=mmzc"><img src="images/pc-vip-pri-mmzc.png" /></a></div>
							</c:if> --%>
							</div>
						</div>
					</div>
				</div>
				<div class="other-pri">
					<p class="other-pri-title">
						<span></span>
						<span style="position: relative;top: -4px;">下级特权</span>
						<span onclick="toAccountLevel()">查看全部特权</span>
					</p>
					<div class="other-pri-table">
							<c:if test="${accountLevel>=0}">
							<div class="swiper-slide2"><a href="<%=basePath%>accountCenter/s/todetail?m=srhl"><img src="images/pc-vip-pri-srhl.png" /></a></div>
							<div class="swiper-slide2"><a href="<%=basePath%>accountCenter/s/todetail?m=sjlb"><img src="images/pc-vip-pri-sjlb.png" /></a></div>
							</c:if>
							<c:if test="${accountLevel>=1}">
							<div class="swiper-slide2"><a href="<%=basePath%>accountCenter/s/todetail?m=qdjx"><img src="images/pc-vip-pri-qdjx.png" /></a></div>
							<div class="swiper-slide2"><a href="<%=basePath%>accountCenter/s/todetail?m=kqrh"><img src="images/pc-vip-pri-kqrh.png" /></a></div>
							<div class="swiper-slide2"><a href="<%=basePath%>accountCenter/s/todetail?m=lxgl"><img src="images/pc-vip-pri-lxgl.png" /></a></div>
							<div class="swiper-slide2"><a href="<%=basePath%>accountCenter/s/todetail?m=txsx"><img src="images/pc-vip-pri-txsx.png" /></a></div>
							</c:if>
							<c:if test="${accountLevel>=2}">
							<div class="swiper-slide2"><a href="<%=basePath%>accountCenter/s/todetail?m=tzjx"><img src="images/pc-vip-pri-tzjx.png" /></a></div>
							<div class="swiper-slide2"><a href="<%=basePath%>accountCenter/s/todetail?m=bqgn"><img src="images/pc-vip-pri-bqgn.png" /></a></div>
							</c:if>
							<c:if test="${accountLevel>=3}">
							<div class="swiper-slide2"><a href="<%=basePath%>accountCenter/s/todetail?m=tqtx"><img src="images/pc-vip-pri-tqtx.png" /></a></div>
							</c:if>
							<%-- <c:if test="${accountLevel>=4}">
							<div class="swiper-slide2"><a href="<%=basePath%>accountCenter/s/todetail?m=mmzc"><img src="images/pc-vip-pri-mmzc.png" /></a></div>
							</c:if> --%>
						<!-- <table border="0" cellspacing="" cellpadding="">
							<tr>
								<th><img src="images/pc-vip-pri-sjlb.png" /></th>
								<th><img src="images/pc-vip-pri-sjlb.png" /></th>
								<th><img src="images/pc-vip-pri-sjlb.png" /></th>
								<th><img src="images/pc-vip-pri-sjlb.png" /></th>
							</tr>
							<tr>
								<td><img src="images/pc-vip-pri-sjlb.png" /></td>
								<td><img src="images/pc-vip-pri-sjlb.png" /></td>
								<td><img src="images/pc-vip-pri-sjlb.png" /></td>
								<td></td>
							</tr>
						</table> -->
					</div>
				</div>
			</div>

		</div>
	</body>
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/layui-master/dist/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		layui.use('element', function() {
			var $ = layui.jquery,
				element = layui.element;
			//Tab的切换功能，切换事件监听等，需要依赖element模块
		});
		var swiper = new Swiper('.swiper-container', {
			slidesPerView: 3,
			spaceBetween: 30,
			pagination: {
				el: '.swiper-pagination',
				clickable: true,
			},
		});
		
		function toAccountLevel(){
			window.location.href='<%=basePath%>accountCenter/s/accountLevel';
		}
		$(window).load(function(){
			$('.wrap').css('height',$(document).height());
		});
	</script>

</html>
