<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/xlcd.css" />
<link rel="stylesheet" type="text/css" href="css/commonStyle.css"/>
<link rel="stylesheet" href="css/awardRotate.css" type="text/css" />
<link rel="stylesheet" href="css/awardRotate/awardRotate.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/awardRotate.js"></script>
<script type="text/javascript" src="js/awardRotate/awardRotate.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>鱼干抽奖</title>
</head>
<body>
<input type="hidden" id="basePath" value="<%=basePath%>" />

	<div class="wrap">
			<p class="backbox">
				<img src="images/back.png" class="getBack" onclick="getBack()" />鱼干抽奖
			</p>
			<div class="content">
				<img src="images/cj-bg.png" class="cj-bg" />
				<img src="images/cj-title.png" class="cj-title" />
				<img src="images/cj-plant.png" class="cj-table" />
				<img src="images/turntable.png" class="cj-plant" />
				<img src="images/cj-pointer.png" class="cj-pointer" />
				<img src="images/cj-dizuo.png" class="cj-base" />
				<img src="images/cj-snow.png" class="cj-snow" />

				<div class="tips">
					<p>
						<span>您当前鱼干:</span>
						<span style="font-weight: bolder;" id="accountScore">${accountScore}</span>
						<span>本次抽奖消耗:</span>
						<span style="font-weight: bolder;"><span id="usedScore">${score}</span>鱼干</span>
					</p>
				</div>
			</div>
			<!-- <div class="top">
				<div class="rotate" id="rotate">
				
				</div>
				<div class="pointer">
					<img src="images/pointer.png" />
				</div>
			</div> -->
			
			<div class="bottom">
				<div class="howToGet">
					<a href="javascript:toBuyScore();">如何获取鱼干?</a>
				</div>
				<div class="blackBar">

				</div>
				<div class="prizeList">

					<div class="prizeBox">
						<div class="prizeBox-title">

						</div>
						<div class="prizeBox-lable">
							中奖名单
						</div>
						<div class="prizeBox-nameList">
							<div id="scrollMessage">
								<ul id="message_1">
									<c:forEach items="${drawList}" var="dl">
	    								<li>${fn:substring(dl.telephone, 0, 3)}****${fn:substring(dl.telephone, 7, 11)}&nbsp;&nbsp;抽中&nbsp;${dl.drawContent}</li>
	       	 						</c:forEach>
								</ul>
								<div id="message_2"></div>
							</div>
						</div>
					</div>      
				</div>
				
				<div style="width:100%;text-align:center;margin-top:10px;">
					<span style="font-weight:bold;color:red;">抽奖概率公示:</span>
							<table style="width:100%;text-align:center;line-height:25px;">
								<tr>
									<td style="width:50%;text-align:left;padding-left:30px;">奖项</td>
									<td style="width:30%;text-align:center;">概率</td>
								</tr>
								<tr>
									<td style="width:50%;text-align:left;padding-left:30px;">加息券</td>
									<td style="width:30%;text-align:center;">24%</td>
								</tr>
								<tr>
									<td style="width:50%;text-align:left;padding-left:30px;">现金券</td>
									<td style="width:30%;text-align:center;">8%</td>
								</tr>
								<tr>
									<td style="width:50%;text-align:left;padding-left:30px;">增值券</td>
									<td style="width:30%;text-align:center;">8%</td>
								</tr>
								<tr>
									<td style="width:50%;text-align:left;padding-left:30px;">鱼干</td>
									<td style="width:30%;text-align:center;">34%</td>
								</tr>
								<tr>
									<td style="width:50%;text-align:left;padding-left:30px;">新手专享标再投机会</td>
									<td style="width:30%;text-align:center;">4%</td>
								</tr>
								<tr>
									<td style="width:50%;text-align:left;padding-left:30px;">免费提现券</td>
									<td style="width:30%;text-align:center;">4%</td>
								</tr>
								<tr>
									<td style="width:50%;text-align:left;padding-left:30px;">未中奖</td>
									<td style="width:30%;text-align:center;">18%</td>
								</tr>
							</table>
				</div>
				<div class="information">
					<p>活动规则:</p>
					<ul>
						<li>1.用户凭鱼干进行抽奖,每次抽奖消耗${score}鱼干。</li>
						<li>2.获奖后奖品直接发放至抽奖帐户。</li>
						<li>3.本平台保证抽奖奖项与轮盘信息相符,且抽奖过程真实有效。</li>
						<li>4.加息券投资精选理财时可使用,可增加投标年化利率;增值券投资精选理财时使用,可额外增加增值券金额本金收益;现金券使用后可立即获得现金券金额的可提现金额;免费提现券可用于本平台后期免费提现;新手标再投机会给予用户额外投资一次新手专享标的机会.</li>
						<li>5.各优惠券奖品有效期为自中奖日起180天,请注意使用避免过期。</li>
						<li>6.由于平台提现暂时免费,免费提现券奖项奖品暂无使用期限。</li>
						<li>7.使用不正当方式参与抽奖或违规进行抽奖会依法追究其法律责任。</li>
						<li>8.该抽奖活动最终解释权归猫咪财富平台所有。</li>
						<li><a href="javascript:goMyAward();" style="color: white;">点击查看我的奖品</a></li>
					</ul>

				</div>

			</div>
		</div>
	</body>
</html>
