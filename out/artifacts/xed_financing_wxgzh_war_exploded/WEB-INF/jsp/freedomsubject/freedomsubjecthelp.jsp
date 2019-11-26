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
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" type="text/css" href="css/help.css" />
		<link rel="stylesheet" type="text/css" href="css/help_content_inner.css" />
		<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
		<title>猫咪宝常见问题</title>
		<style type="text/css">
			body {
				background-color: #F2F2F2;
			}
			
			.wrap {
				width: 100%;
			}
			
			.title {
				width: 100%;
				position: relative;
				text-align: center;
				font-size: 16px;
				color: #333333;
				/*font-weight: 600;*/
				height: 40px;
				line-height: 40px;
				background-color: #F7F7F7;
			}
			
			.back {
				position: absolute;
				left: 20px;
				top: 14px;
				width: 10px;
				height: 15px;
			}
		</style>
	</head>

	<body>
		<input type="hidden" id="basePath" value="<%=basePath%>" />
		<form method="post" action="" id="form1" >
			<input type="hidden" id="freedomSubjectId" name="freedomSubjectId" value="${fBean.freedomSubjectId}">
   		</form>
		<div class="wrap">
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()"/>猫咪宝常见问题
			</div>
			<div class="content">
				<div class="content_inner">
					<ul id="accordion2" class="accordion">
						<li>
							<div class="link">
								</i>· 什么是猫咪宝？<i class="fa fa-chevron-down"></i>
							</div>
							<ul class="submenu">
								<li>
									<a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;猫咪宝享受多重保障，投资资金能够实现高度分散，有效降低风险。猫咪财富坚持向投资者披露每一笔资金的去向，和每一笔借款的还款情况。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;猫咪宝支持1元起投、随存随取，能让零钱生息，确保投资者在猫咪财富的资金无缝生息，真正做到“让时间为您赚钱”。猫咪宝投资和转出都非常灵活方便，每天收益会计入可用余额。投资者随时可以将猫咪宝余额转至可用余额，或者提现至银行卡，无任何手续费。</a>
								</li>
							</ul>
						</li>
						<li>
							<div class="link">
								</i>· 七日年化收益率和万份收益是什么？<i class="fa fa-chevron-down"></i>
							</div>
							<ul class="submenu">
								<li>
									<a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;七日年化收益率是猫咪财富最近七日年化收益率的平均值；万份收益是为了便于投资人计算每日收益，将当日年化收益率折算成万元投资的参考值。</a>
								</li>
							</ul>
						</li>
						<li>
							<div class="link">
								</i>· 如何投资猫咪宝？<i class="fa fa-chevron-down"></i>
							</div>
							<ul class="submenu">
								<li>
									<a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在底部“投资”选择“猫咪宝”,点击“转入”按钮，输入转入金额，1元起投。转入金额由猫咪财富可用余额扣除，当出现资金不足的情况，用户可在猫咪宝投资页面点击“我要充值”增加可用余额。</a>
								</li>
							</ul>
						</li>
						<li>
							<div class="link">
								</i>· 猫咪宝是如何计息的？<i class="fa fa-chevron-down"></i>
							</div>
							<ul class="submenu">
								<li>
									<a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;投资成功后第二天起计算收益，第三天起发放收益（例如投资者12月1号当日投资成功，则于12月2号起计算收益，12月3号收到首次收益）。</a>
								</li>
							</ul>
						</li>
						<li>
							<div class="link">
								</i>· 为什么我在猫咪宝投了多笔只能看到一条合并在一起的记录？<i class="fa fa-chevron-down"></i>
							</div>
							<ul class="submenu">
								<li>
									<a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;猫咪财富为满足用户小额零钱投资管理需求，对用户投资的“猫咪宝”交易进行合并处理。用户可以清晰地了解在“猫咪宝”的总投资情况，既可一次性转出全部金额，又能使每笔小额交易都能获取收益。转出遵循“先进先出”的原则（投资者12月1号先投了一笔100元，后投了一笔200元，发起转出150元申请，遵循“先进先出”原则，猫咪财富会优先扣除第一笔100元的全部转入金额，然后从200元的转入金额中扣除剩余转出的50元，用户转出150元后剩余150元）。</a>
								</li>
							</ul>
						</li>
						<li>
							<div class="link">
								</i>· 转出有哪些方式？<i class="fa fa-chevron-down"></i>
							</div>
							<ul class="submenu">
								<li>
									<a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;转出分为“转出至可用余额”和“转出至银行卡”：<br/>&nbsp;&nbsp;&nbsp;&nbsp;“转出至可用余额”为满足投资者紧急的资金需求，60分钟内返至您猫咪财富的可用余额。<br/>&nbsp;&nbsp;&nbsp;&nbsp;“转出至银行卡”遵循猫咪财富提现规则。14:00之前不允许转出到银行卡；14:00~15:00转出，若当天是工作日则当日到账；若当天是周末或法定节假日，则延迟至工作日到账；15:00后转出，下一个工作日到账(法定节假日顺延)。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;例如投资者2017年10月3号申请"转至银行卡"，由于10月1号~8号为法定节假日，投资者资金9号到账。</a>
								</li>
							</ul>
						</li>
						
					</ul>

				</div>
			</div>
		</div>
	</body>
	
	<script type="text/javascript">
			//返回
			function goBack()
			{
				var path= $("#basePath").val();
				var form = document.forms['form1'];
				form.action = './freedomsubject/s/detailfreedomsubject';
				form.submit();
			}
		</script>
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/accordion.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/help_content_inner.js" type="text/javascript" charset="utf-8"></script>


</html>