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
		<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
		<title>会员俱乐部</title>
		<style type="text/css">
			.wrap {
				width: 100%;
				background-color: #161616;
			}
			
			.banner {
				width: 100%;
			}
			
			.banner img {
				width: 100%;
			}
			
			.vip-label {
				width: 100%;
			}
			
			.vip-lable img {
				width: 100%;
			}
			
			.carousel {
				width: 100%;
			}
			
			.swiper-container {
				width: 100%;
				padding-top: 20px;
				padding-bottom: 20px;
			}
			
			.swiper-slide {
					background-position: center;
					background-size: cover;
					width: 80%;
					height: 139px;
			}
			
			@media only screen and (min-width: 319px) and (max-width: 321px) {
				.swiper-slide {
					background-position: center;
					background-size: cover;
					width: 80%;
					height: 123px;
				}
			}
			
			@media only screen and (min-width: 374px) and (max-width: 376px) {
				.swiper-slide {
					background-position: center;
					background-size: cover;
					width: 80%;
					height: 144px;
				}
			}
			
			@media only screen and (min-width: 413px) and (max-width: 415px) {
				.swiper-slide {
					background-position: center;
					background-size: cover;
					width: 80%;
					height: 160px;
				}
			}
		
			.swiper-slide img {
				width: 100%;
			}
			
			.tips {
				padding: 20px 0;
			}
			
			.tips p {
				font-size: 12px;
				color: #876944;
				line-height: 22px;
				padding: 0 10px;
			}
			
			.privilege {
				width: 100%;
				padding: 20px 0;
			}
			
			.privilege table {
				width: 95%;
				margin: 0 auto;
				text-align: center;
			}
			
			.privilege table th{
				padding: 10px 0;
			}
			.privilege table img {
				width: 50%;
			}
		</style>
	</head>

	<body>
		<div class="wrap">
			<div class="banner">
				<img src="images/pc-vip-banner.jpg" />
			</div>
			<div class="vip-lable">
				<img src="images/pc-vip-lable-hycz.png" />
			</div>
			<div class="carousel">
				<div class="swiper-container">
					<div class="swiper-wrapper">
						<div class="swiper-slide" style="background-image:url(images/pc-vip-1.png)"></div>
						<div class="swiper-slide" style="background-image:url(images/pc-vip-2.png)"></div>
						<div class="swiper-slide" style="background-image:url(images/pc-vip-3.png)"></div>
						<div class="swiper-slide" style="background-image:url(images/pc-vip-4.png)"></div>
						<div class="swiper-slide" style="background-image:url(images/pc-vip-5.png)"></div>
						<div class="swiper-slide" style="background-image:url(images/pc-vip-6.png)"></div>
						<div class="swiper-slide" style="background-image:url(images/pc-vip-7.png)"></div>
						<div class="swiper-slide" style="background-image:url(images/pc-vip-8.png)"></div>
						<div class="swiper-slide" style="background-image:url(images/pc-vip-9.png)"></div>
						<div class="swiper-slide" style="background-image:url(images/pc-vip-10.png)"></div>
					</div>

				</div>

			</div>
			<div class="tips">
				<p>温馨提示：用户每次投资后检查用户当前投资总额是否达到下一级标准，达到直接升级并发放相应奖励。用户升级后本月原特权与升级后特权叠加，如跳级升级，所有特权统一发放。</p>
				<p>注：每个月结束查看当前投资金额，是否符合当前等级对应的档位，如果未满对应档位的50% ，且连续两个月则降一级，直至0级为止。</p>

			</div>
			<div class="vip-lable">
				<img src="images/pc-vip-lable-hytq.png" />
			</div>
			<div class="privilege">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>
							<a href="<%=basePath%>accountCenter/s/todetail?m=sjlb">
								<img src="images/pc-vip-pri-sjlb.png" />
							</a>
						</th>
						<th>
							<a href="<%=basePath%>accountCenter/s/todetail?m=srhl">
								<img src="images/pc-vip-pri-srhl.png" />
							</a>

						</th>
						<th>
							<a href="<%=basePath%>accountCenter/s/todetail?m=qdjx">
								<img src="images/pc-vip-pri-qdjx.png" />
							</a>
						</th>
					</tr>
					<tr>
						<th>
							<a href="<%=basePath%>accountCenter/s/todetail?m=tzjx">
								<img src="images/pc-vip-pri-tzjx.png" />
							</a>

						</th>
						<th>
							<a href="<%=basePath%>accountCenter/s/todetail?m=tqtx">
								<img src="images/pc-vip-pri-tqtx.png" />
							</a>
						</th>
						<th>
							<a href="<%=basePath%>accountCenter/s/todetail?m=kqrh">
								<img src="images/pc-vip-pri-kqrh.png" />
							</a>
						</th>
					</tr>
					<tr>
						<th>
							<a href="<%=basePath%>accountCenter/s/todetail?m=bqgn">
								<img src="images/pc-vip-pri-bqgn.png" />
							</a>
						</th>
						<th>
							<a href="<%=basePath%>accountCenter/s/todetail?m=lxgl">
								<img src="images/pc-vip-pri-lxgl.png" />
							</a>
						</th>
						<th>
							<a href="<%=basePath%>accountCenter/s/todetail?m=txsx">
								<img src="images/pc-vip-pri-txsx.png" />
							</a>
						</th>
					</tr>
				</table>
			</div>
		</div>
	</body>
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		var swiper = new Swiper('.swiper-container', {
			effect: 'coverflow',
			loop: true,
			grabCursor: true,
			centeredSlides: true,
			slidesPerView: 'auto',
			coverflowEffect: {
				rotate: 50,
				stretch: 0,
				depth: 100,
				modifier: 1,
				slideShadows: true,
			},
			pagination: {
				el: '.swiper-pagination',
			},
		});
		$(window).load(function(){
			$('.wrap').css('height',$(document).height());
		});
	</script>

</html>
