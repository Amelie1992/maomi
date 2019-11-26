<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<base href="<%=basePath%>">
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/validate.js"></script>
		<script type="text/javascript" src="js/isWeixin.js"></script>
		<link rel="stylesheet" type="text/css" href="css/commonStyle.css" />
		<title>抗风险能力测试</title>
		<style type="text/css">
			ul {
				/*color: grey;*/
				margin-bottom: 10px;
				letter-spacing: 3px;
				line-height: 28px;
			}
			
			b {
				color: chocolate;
			}
			
			#tips {
				font-size: 14px;
				color: gray;
				padding: 10px;
			}
			
			#question {
				text-align: left;
				padding: 10px;
			}
			
			.result {
				color: gray;
				font-size: 14px;
				position: absolute;
				opacity: 0;
			}
			
			.myButton {
				-moz-box-shadow: 0px 1px 0px 0px #f0f7fa;
				-webkit-box-shadow: 0px 1px 0px 0px #f0f7fa;
				box-shadow: 0px 1px 0px 0px #f0f7fa;
				background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #33bdef), color-stop(1, #019ad2));
				background: -moz-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -webkit-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -o-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -ms-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: linear-gradient(to bottom, #33bdef 5%, #019ad2 100%);
				filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bdef', endColorstr='#019ad2', GradientType=0);
				background-color: #33bdef;
				-moz-border-radius: 6px;
				-webkit-border-radius: 6px;
				border-radius: 6px;
				border: 1px solid #057fd0;
				display: inline-block;
				cursor: pointer;
				color: #ffffff;
				font-family: Arial;
				font-size: 16px;
				font-weight: bold;
				padding: 6px 24px;
				text-decoration: none;
				width: 45%;
				text-shadow: 0px -1px 0px #5b6178;
			}
			
			.myButton:hover {
				background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #019ad2), color-stop(1, #33bdef));
				background: -moz-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: -webkit-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: -o-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: -ms-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: linear-gradient(to bottom, #019ad2 5%, #33bdef 100%);
				filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#019ad2', endColorstr='#33bdef', GradientType=0);
				background-color: #019ad2;
			}
			
			.myButton:active {
				position: relative;
				top: 1px;
			}
			.resetButton {
				-moz-box-shadow: 0px 1px 0px 0px #f0f7fa;
				-webkit-box-shadow: 0px 1px 0px 0px #f0f7fa;
				box-shadow: 0px 1px 0px 0px #f0f7fa;
				background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #33bdef), color-stop(1, #019ad2));
				background: -moz-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -webkit-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -o-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -ms-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: linear-gradient(to bottom, #33bdef 5%, #019ad2 100%);
				filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bdef', endColorstr='#019ad2', GradientType=0);
				background-color: #33bdef;
				-moz-border-radius: 6px;
				-webkit-border-radius: 6px;
				border-radius: 6px;
				border: 1px solid #057fd0;
				display: inline-block;
				cursor: pointer;
				color: #ffffff;
				font-family: Arial;
				font-size: 16px;
				font-weight: bold;
				padding: 6px 24px;
				text-decoration: none;
				width: 90%;
				text-shadow: 0px -1px 0px #5b6178;
			}
			
			.resetButton:hover {
				background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #019ad2), color-stop(1, #33bdef));
				background: -moz-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: -webkit-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: -o-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: -ms-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: linear-gradient(to bottom, #019ad2 5%, #33bdef 100%);
				filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#019ad2', endColorstr='#33bdef', GradientType=0);
				background-color: #019ad2;
			}
			
			.resetButton:active {
				position: relative;
				top: 1px;
			}
			.backButton {
				-moz-box-shadow: 0px 1px 0px 0px #f0f7fa;
				-webkit-box-shadow: 0px 1px 0px 0px #f0f7fa;
				box-shadow: 0px 1px 0px 0px #f0f7fa;
				background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #33bdef), color-stop(1, #019ad2));
				background: -moz-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -webkit-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -o-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: -ms-linear-gradient(top, #33bdef 5%, #019ad2 100%);
				background: linear-gradient(to bottom, #33bdef 5%, #019ad2 100%);
				filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bdef', endColorstr='#019ad2', GradientType=0);
				background-color: #33bdef;
				-moz-border-radius: 6px;
				-webkit-border-radius: 6px;
				border-radius: 6px;
				border: 1px solid #057fd0;
				display: inline-block;
				cursor: pointer;
				color: #ffffff;
				font-family: Arial;
				font-size: 16px;
				font-weight: bold;
				padding: 6px 24px;
				text-decoration: none;
				width: 45%;
				text-shadow: 0px -1px 0px #5b6178;
			}
			
			.backButton:hover {
				background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #019ad2), color-stop(1, #33bdef));
				background: -moz-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: -webkit-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: -o-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: -ms-linear-gradient(top, #019ad2 5%, #33bdef 100%);
				background: linear-gradient(to bottom, #019ad2 5%, #33bdef 100%);
				filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#019ad2', endColorstr='#33bdef', GradientType=0);
				background-color: #019ad2;
			}
			
			.backButton:active {
				position: relative;
				top: 1px;
			}
			h3, h4, h5 {
				font-weight: normal;
			}
			h5 {
				margin-left: 5px;
				margin-right: 5px;
			}
			input {
				margin-left: 5px;
				margin-right: 5px;
			}
			
			/* 弹出层css */
			.fx-cns {
				background-color: white;
				width: 90%;
				margin: 0 auto;
				position: absolute;
				left: 5%;
				top: 10%;
				display: none;
			}
			
			.cns-content {
				width: 80%;
				height: 350px;
				overflow: scroll;
				margin: 20px auto;
				padding: 10px;
				background-color: white;
			}
			
			.cns-content div {
				font-size: 12px;
				text-indent: 30px;
				margin: 10px 0;
				line-height: 25px;
				text-align: left !important;
			}
			
			.cns-content li {
				list-style-type: decimal;
				text-indent: 0;
			}
			
			.cns-title {
				font-size: 16px !important;
				color: #212121;
				font-weight: bold;
				text-align: center;
				padding: 10px 0;
				background-color: #f2f2f2 !important;
			}
			
			.cns-content p {
				font-weight: bold;
				font-size: 14px !important;
				text-align: left !important;
				width: 100% !important;
			}
			
			.cns-btn {
				text-align: center;
				padding: 10px;
				background-color: #F2F2F2;
				color: #2F4056;
			}
			
			.cns-mask {
				width: 100%;
				height: 120%;
				position: absolute;
				top: 0;
				left: 0;
				background-color: #BDbdbd;
				opacity: 0.8;
				display: none;
			}
			
		</style>
	</head>

	<body>
		<div id="wrap">
			<p><img src="images/back.png" id="back" class="back" onclick="goBack();"/>风险能力测试</p>
			
			<div id="question">
			<c:if test="${accountInfo.isRisk == 0}">
				<ul id="ques1">
					<li>
						<h4>1. 您的年龄是：</h4></li>
					<li>
						<h5> <input type="radio" name="test_1" class="answerA" value="10" onclick="goNext();"/>A:30 岁以下</h5></li>
					<li>
						<h5> <input type="radio" name="test_1" class="answerB" value="8" onclick="goNext();"/>B:30 岁（含）至40 岁</h5></li>
					<li>
						<h5> <input type="radio" name="test_1" class="answerC" value="5" onclick="goNext();"/>C:40 岁（含）至50 岁</h5></li>
					<li>
						<h5> <input type="radio" name="test_1" class="answerD" value="3" onclick="goNext();"/>D:50 岁（含）至60 岁</h5></li>
					<li>
						<h5> <input type="radio" name="test_1" class="answerE" value="0" onclick="goNext();"/>E:60 岁（含）以上</h5></li>
				</ul>

				<ul id="ques2">
					<li>
						<h4>2. 您的职业稳定性如何：</h4></li>
					<li>
						<h5> <input type="radio" name="test_2" class="answerA" value="10" onclick="goNext();"/>A:很稳定</h5></li>
					<li>
						<h5> <input type="radio" name="test_2" class="" value="8" onclick="goNext();"/>B:较稳定</h5></li>
					<li>
						<h5> <input type="radio" name="test_2" class="" value="5" onclick="goNext();"/>C:不稳定</h5></li>
					<li>
						<h5> <input type="radio" name="test_2" class="" value="3" onclick="goNext();"/>D:较不稳定</h5></li>
					<li>
						<h5> <input type="radio" name="test_2" class="" value="0" onclick="goNext();"/>E:目前待业</h5></li>
				</ul>

				<ul id="ques3">
					<li>
						<h4>3. 您所供养的人数：</h4></li>
					<li>
						<h5> <input type="radio" name="test_3" class="answerA" value="10" onclick="goNext();"/>A:未婚</h5></li>
					<li>
						<h5> <input type="radio" name="test_3" class="" value="8" onclick="goNext();"/>B:双薪无子女</h5></li>
					<li>
						<h5> <input type="radio" name="test_3" class="" value="5" onclick="goNext();"/>C:1-2人</h5></li>
					<li>
						<h5> <input type="radio" name="test_3" class="" value="3" onclick="goNext();"/>D:3-4人</h5></li>
					<li>
						<h5> <input type="radio" name="test_3" class="" value="0" onclick="goNext();"/>E:4人以上</h5></li>
				</ul>

				<ul id="ques4">
					<li>
						<h4>4. 您目前的置产状况如何：</h4></li>
					<li>
						<h5> <input type="radio" name="test_4" class="answerA" value="10" onclick="goNext();"/>A:投资不动产</h5></li>
					<li>
						<h5> <input type="radio" name="test_4" class="" value="8" onclick="goNext();"/>B:自住不动产，无房贷</h5></li>
					<li>
						<h5> <input type="radio" name="test_4" class="" value="5" onclick="goNext();"/>C:自住不动产，有房贷</h5></li>
					<li>
						<h5> <input type="radio" name="test_4" class="" value="3" onclick="goNext();"/>D:收入稳定，无不动产</h5></li>
					<li>
						<h5> <input type="radio" name="test_4" class="" value="0" onclick="goNext();"/>E:收入不稳定</h5></li>
				</ul>

				<ul id="ques5">
					<li>
						<h4>5. 您投资于有风险的投资品的经验如何：</h4></li>
					<li>
						<h5> <input type="radio" name="test_5" class="answerA" value="10" onclick="goNext();"/>A:8年以上</h5></li>
					<li>
						<h5> <input type="radio" name="test_5" class="" value="8" onclick="goNext();"/>B:4-8年</h5></li>
					<li>
						<h5> <input type="radio" name="test_5" class="" value="5" onclick="goNext();"/>C:1-4年</h5></li>
					<li>
						<h5> <input type="radio" name="test_5" class="" value="3" onclick="goNext();"/>D:1年以内</h5></li>
					<li>
						<h5> <input type="radio" name="test_5" class="" value="0" onclick="goNext();"/>E:无</h5></li>
				</ul>

				<ul id="ques6">
					<li>
						<h4>6. 您对投资所能容忍的亏损范围：</h4></li>
					<li>
						<h5> <input type="radio" name="test_6" class="answerA" value="10" onclick="goNext();"/>A:25%（含）以上</h5></li>
					<li>
						<h5> <input type="radio" name="test_6" class="" value="8" onclick="goNext();"/>B:15%（含）-25%</h5></li>
					<li>
						<h5> <input type="radio" name="test_6" class="" value="5" onclick="goNext();"/>C:10%（含）-15%</h5></li>
					<li>
						<h5> <input type="radio" name="test_6" class="" value="3" onclick="goNext();"/>D:0-10%</h5></li>
					<li>
						<h5> <input type="radio" name="test_6" class="" value="0" onclick="goNext();"/>E:不能容忍任何亏损</h5></li>
				</ul>

				<ul id="ques7">
					<li>
						<h4>7. 您的投资目标是什么：</h4></li>
					<li>
						<h5> <input type="radio" name="test_7" class="answerA" value="10" onclick="goNext();"/>A:长期投资</h5></li>
					<li>
						<h5> <input type="radio" name="test_7" class="" value="8" onclick="goNext();"/>B:短期投资</h5></li>
					<li>
						<h5> <input type="radio" name="test_7" class="" value="5" onclick="goNext();"/>C:保证每年有一定的现金收益</h5></li>
					<li>
						<h5> <input type="radio" name="test_7" class="" value="3" onclick="goNext();"/>D:投资利益率只要能抵御通货膨胀就行</h5></li>
					<li>
						<h5> <input type="radio" name="test_7" class="" value="0" onclick="goNext();"/>E:只要投资能够保本保息，即使低于通胀率也行</h5></li>
				</ul>

				<ul id="ques8">
					<li>
						<h4>8. 假设您的某项投资突然亏损15%以上，你将：</h4></li>
					<li>
						<h5> <input type="radio" name="test_8" class="answerA" value="10" onclick="goNext();"/>A:加码摊平</h5></li>
					<li>
						<h5> <input type="radio" name="test_8" class="" value="8" onclick="goNext();"/>B:等待反弹</h5></li>
					<li>
						<h5> <input type="radio" name="test_8" class="" value="5" onclick="goNext();"/>C:卖掉一半</h5></li>
					<li>
						<h5> <input type="radio" name="test_8" class="" value="3" onclick="goNext();"/>D:卖掉止损</h5></li>
					<li>
						<h5> <input type="radio" name="test_8" class="" value="0" onclick="goNext();"/>E:预设停损点</h5></li>
				</ul>

				<ul id="ques9">
					<li>
						<h4>9. 假设您的某项投资突然亏损15%以上，对您的心理可能产生：</h4></li>
					<li>
						<h5> <input type="radio" name="test_9" class="answerA" value="10" onclick="goNext();"/>A:没有影响</h5></li>
					<li>
						<h5> <input type="radio" name="test_9" class="" value="8" onclick="goNext();"/>B:基本无影响</h5></li>
					<li>
						<h5> <input type="radio" name="test_9" class="" value="5" onclick="goNext();"/>C:影响情绪小</h5></li>
					<li>
						<h5> <input type="radio" name="test_9" class="" value="3" onclick="goNext();"/>D:影响情绪大</h5></li>
					<li>
						<h5> <input type="radio" name="test_9" class="" value="0" onclick="goNext();"/>E:影响正常生活</h5></li>
				</ul>

				<ul id="ques10">
					<li>
						<h4>10.对于投资资产价值的波动，您认为：</h4></li>
					<li>
						<h5> <input type="radio" name="test_10" class="answerA" value="10" onclick="goNext();"/>A:再大波动都能接受</h5></li>
					<li>
						<h5> <input type="radio" name="test_10" class="" value="8" onclick="goNext();"/>B:担心但还能接受亏损</h5></li>
					<li>
						<h5> <input type="radio" name="test_10" class="" value="5" onclick="goNext();"/>C:能接受轻微波动</h5></li>
					<li>
						<h5> <input type="radio" name="test_10" class="" value="3" onclick="goNext();"/>D:关心资产保值多过增值</h5></li>
					<li>
						<h5> <input type="radio" name="test_10" class="" value="0" onclick="goNext();"/>E:不能接受任何价格方面波动</h5></li>
				</ul>

				<input type="button" class="myButton" id="myButton" value="提交" onclick="submitButton()"/>
				<input type="button" class="backButton" id="" onclick="goBack()" value="返回"/>
				</c:if>
				<c:if test="${accountInfo.riskResult > 0 && accountInfo.riskResult <=20 }">
				<div class="result result_1" style="opacity:1;">
					<!-- <h3>您的测试分数为：<b class="score">0-20</b></h3> -->
					<h3>您的类型为：<b class="leixing">保守型投资人</b></h3>
					<h3>我们的建议是：<b class="advice">低风险级别产品为主</b></h3>
					<h3>说明：</h3>
					<b class="information" style="color: gray;">
						您的风险承担能力水平比较低，您关注资产的安全性远超于资产的收益性。低风险的投资品种比较适合您作为主要投资产品。 比如：储蓄、短期国债、债权类等。这类投资的收益相对偏低，所以您应该将资产的绝大部分投资于此类低风险产品，另有小部分投资于证券、贵金属现货、证券投资类基金等； 参考投资分配比例：低风险类资产：中等风险类资产 = 8:2
					</b>
					<input type="button" class="resetButton" id="" value="重新测试" onclick="resetButton()"/>
				</div>
				</c:if>
				<c:if test="${accountInfo.riskResult > 20 && accountInfo.riskResult <=40 }">
				<div class="result result_2"  style="opacity:1;">
					<!-- <h3>您的测试分数为：<b class="score">20-40</b></h3> -->
					<h3>您的类型为：<b class="leixing">稳健偏保守型投资人</b></h3>
					<h3>我们的建议是：<b class="advice">中低风险级别产品为主</b></h3>
					<h3>说明：</h3>
					<b class="information" style="color: gray;">
						您的风险承受能力偏低，对投资收益比较敏感，期望通过长期且持续的投资获得高于平均水平的回报。中低等级风险收益的投资品种比较适合您作为主要投资产品。
比如：证券投资类基金、长期债权等。为了提高整个资产组合的平均收益率，还可以将小部分资金投资于贵金属现货、贵金属期货等此类资产；
参考投资分配比例：低风险类投资：中等风险类投资 = 7:3
					</b>
					<input type="button" class="resetButton" id="" value="重新测试" onclick="resetButton()"/>
				</div>
				</c:if>
				<c:if test="${accountInfo.riskResult > 40 && accountInfo.riskResult <=60 }">
				<div class="result result_3"  style="opacity:1;">
					<!-- <h3>您的测试分数为：<b class="score">40-60</b></h3> -->
					<h3>您的类型为：<b class="leixing">稳健型投资人</b></h3>
					<h3>我们的建议是：<b class="advice">中等风险级别产品为主</b></h3>
					<h3>说明：</h3>
					<b class="information" style="color: gray;">
						您有一定的风险承受能力，对投资收益比较敏感，期望通过长期且持续的投资获得高于平均水平的回报，通常更注重十年甚至更长期限内的平均收益。所以中等风险收益的投资品种比较适合您作为主要投资产品，回避风险的同时有一定的收益保证；
参考投资分配比例：低风险类投资：中等风险类投资 = 6:4
					</b>
					<input type="button" class="resetButton" id="" value="重新测试" onclick="resetButton()"/>
				</div>
				</c:if>
				<c:if test="${accountInfo.riskResult > 60 && accountInfo.riskResult <=80 }">
				<div class="result result_4"  style="opacity:1;">
					<!-- <h3>您的测试分数为：<b class="score">60-80</b></h3> -->
					<h3>您的类型为：<b class="leixing">稳健偏积极型投资人</b></h3>
					<h3>我们的建议是：<b class="advice">中高风险级别产品为主</b></h3>
					<h3>说明：</h3>
					<b class="information" style="color: gray;">您有中高的风险承受能力，愿意承担可预见的投资风险去获取更多的收益，一般倾向于进行中短期投资。所以中高等级的风险收益投资品种比较适合您作为主要投资产品，以一定的可预见风险换取超额收益；
参考投资分配比例：低风险类投资：中等风险类投资：高等风险类投资 = 5:4:1
					</b>
					<input type="button" class="resetButton" id="" value="重新测试" onclick="resetButton()"/>
				</div>
				</c:if>
				<c:if test="${accountInfo.riskResult > 80 && accountInfo.riskResult <=100 }">
				<div class="result result_5"  style="opacity:1;">
					<!-- <h3>您的测试分数为：<b class="score">80-100</b></h3> -->
					<h3>您的类型为：<b class="leixing">积极型投资人</b></h3>
					<h3>我们的建议是：<b class="advice">高风险级别产品为主</b></h3>
					<h3>说明：</h3>
					<b class="information" style="color: gray;">
						您有较高的风险承受能力，是富有冒险精神的积极型选手。在投资收益波动的情况下，仍然保持积极进取的投资理念。短期内投资收益的下跌被您视为加注投资的利好机会。您适合事灵活、风险与报酬都比较高的投资，不过要注意不要因一时的高报酬获利而将全部资金投入高风险操作，务必做好风险管理与资金调配工作；
参考投资分配比例：低风险类投资：中等风险类投资：高风险类投资 = 3: 4：3
					</b>
					<input type="button" class="resetButton" id="" value="重新测试" onclick="resetButton()"/>
				</div>
				</c:if>
			</div>
			<c:if test="${accountInfo.isRisk == 0}">
			<div id="tips">
				<b>温馨提示：</b>在众多可供投资的金融产品中，选择适合自己的理财产品是一门学问。在投资组合中，如何找到适合自己风险承受能力的产品，从而配置各项投资品种的理财份额，以保持总体投资风险适合投资者自身情况，在投资中尤为重要。 在投资前，投资者应对自身投资风险承受能力和风险偏好充分认识，以更好运用投资产品或投资组合。以上10道测试，能够帮助您初步了解自己的风险偏好和风险承受能力，从而根据资金及风险承受能力进行综合的投资选择。 （请您根据实际情况填写，选出最符合自己现状的选项，对自己的风险承受能力做出评估。）<br/>
				<b>注：</b>以上测试，仅供参考。投资有风险，入市需谨慎，请自行根据资金及投资策略选择投资品种，本测试旨在帮助您了解风险，不代表本平台任何观点.
			</div>
			</c:if>
		</div>
		<div class="cns-mask">

			</div>
			<div class="fx-cns">
				<p class="cns-title">网络借贷风险提示及禁止性行为说明书</p>
				<div class="cns-content">
					<p>尊敬的猫咪财富用户，您好！</p>
					<div>
						恭喜您成为猫咪财富平台的注册用户。猫咪财富是由江苏猫儿信息科技股份有限公司运营的网络借贷中介服务平台，您可根据您的资金出借需求，自愿选择通过猫咪财富平台进行资金出借，以期获得相应预期收益。
					</div>
					<div>
						当您点击“立即投资”、“确认”、“同意”、“购买”或其他类似含义的选项时，即视为您已经充分理解并确认《网络借贷风险和禁止性行为提示书》和《资金来源合法承诺书》的相关内容，对您出借资金来源的合法性作出保证性承诺，并自愿承担网络借贷所产生的相应风险。</div>
					<div>
						<p>
							一、网络借贷风险提示：在您通过猫咪财富平台进行资金出借的过程中，也许会面临以下可能导致您出借资金及收益受损的各种风险。请您在进行资金出借前仔细阅读以下内容，了解融资项目信贷风险，确保自身具备相应的投资风险意识、风险认知能力、风险识别能力和风险承受能力，拥有非保本类金融产品投资的经历并熟悉互联网，并请您根据自身的风险承受能力选择是否出借资金及出借资金的数额。
						</p>
					</div>
					<div>
						<ul>
							<li>法律及监管风险：因许多法律和法规相对较新且可能发生变化，相关官方解释和执行可能存在较大不确定性等因素引起的风险。有些新制定的法律、法规或修正案的生效可能被延迟；有些新颁布或生效的法律法规可能具有追溯力从而对您的投资利益造成不利影响。</li>
							<li>政策风险：因国家宏观政策、财政政策、货币政策、监管导向、行业政策、地区发展政策等因素引起的风险。</li>
							<li>市场风险：因市场资金面紧张或利率波动、行业不景气、企业效益下滑等因素引起的风险。</li>
							<li>借款人信用风险：针对平台上的债权，猫咪财富仅在债权形成前对借款人的借款需求及相关信息进行必要审核，但是猫咪财富不对借款人的还款能力做出任何明示或默示的担保或保证，并且如果发生债权转让，猫咪财富不会在债权转让时再次对借款人进行信用审核，您受让的债权可能在其受让前已经存在逾期情况。当借款人因收入情况、财产状况发生变化、人身出现意外、发生疾病、死亡等情况，短期或者长期丧失还款能力，或者借款人的还款意愿发生变化时，您的出借资金可能无法按时回收甚至无法回收，您的预期收益可能无法实现。猫咪财富没有义务对逾期的本息以及费用进行垫付或未经委托对借款人进行追索。</li>
							<li>资金流动性风险：针对您的出借本金或者回款再出借资金，猫咪财富会根据网络借贷相关协议约定积极协助您寻找、推荐借款人，以完成资金出借、获取收益之目的，但猫咪财富寻找、推荐借款人的时间存在一定不确定性。同时，猫咪财富将根据网络借贷相关协议约定在您提出需要时，努力帮助您寻找、向您推荐愿意受让债权的第三方，以完成您的债权转让，但猫咪财富不对债权转让的实现以及实现时间做出任何承诺和保证。</li>
							<li>技术风险：由于无法控制和不可预测的系统故障、设备故障、通讯故障、电力故障、网络故障、黑客或计算机病毒攻击、以及其它因素，可能导致平台出现非正常运行或者瘫痪，由此导致您无法及时进行查询、充值、出借、提现等操作。</li>
							<li>不可抗力风险：由于战争、动乱、自然灾害等不可抗力因素的出现而可能导致您出借资金损失的风险。</li>
						</ul>
					</div>
					<div>
						<p>
							二、网络借贷禁止性行为提示：猫咪财富平台作为网络借贷信息中介平台，将严格依据《网络借贷信息中介机构业务活动管理暂行办法》的规定，不予从事或者接受委托从事下列活动，请您知悉并共同进行监督：
						</p>

					</div>
					<div>
						<ul>
							<li>为自身或变相为自身融资；</li>
							<li>直接或间接接受、归集出借人的资金；</li>
							<li>直接或变相向出借人提供担保或者承诺保本保息；</li>
							<li>自行或委托、授权第三方在互联网、固定电话、移动电话等电子渠道以外的物理场所进行宣传或推介融资项目；</li>
							<li>发放贷款，但法律法规另有规定的除外；</li>
							<li>将融资项目的期限进行拆分；</li>
							<li>自行发售理财等金融产品募集资金，代销银行理财、券商资管、基金、保险或信托产品等金融产品；</li>
							<li>开展类资产证券化业务或实现以打包资产、证券化资产、信托资产、基金份额等形式的债权转让行为；</li>
							<li>除法律法规和网络借贷有关监管规定允许外，与其他机构投资、代理销售、经纪等业务进行任何形式的混合、捆绑、代理；</li>
							<li>虚构、夸大融资项目的真实性、收益前景，隐瞒融资项目的瑕疵及风险，以歧义性语言或其他欺骗性手段等进行虚假片面宣传或促销等，捏造、散布虚假信息或不完整信息损害他人商业信誉，误导出借人或借款人；</li>
							<li>向借款用途为投资股票、场外配资、期货合约、结构化产品及其他衍生品等高风险的融资提供信息中介服务；</li>
							<li>从事股权众筹等业务。</li>
							<li>洗钱、信用卡套现、虚假交易等行为。</li>
						</ul>
					</div>
					<div>
						<h4 style="text-align: right;">风险提示方：江苏猫儿信息科技股份有限公司 </br><b>【猫咪财富】</b></h4>
					</div>
				</div>

				<div class="cns-btn">
					我已确认
				</div>
			</div>
		
	</body>
	<script type="text/javascript">
		//点击选项跳转下一个未选项
		function goNext(){
			var flag = -1;
			for(var i = 1;i <=10; i++){
				if(typeof($('input[name="test_' + i + '"]:checked').val()) == "undefined"){
					flag = i;
					break;
				}
			}
			if(flag != -1){
				window.location.hash = "#ques" + flag;
			}else{
				window.location.hash = "#myButton";
			}
		}
	
		//计算分数
		function submitButton(){
			for(var i = 1;i <=10; i++){
				if(typeof($('input[name="test_' + i + '"]:checked').val()) == "undefined"){
					alert('第' + i + '题尚未填写,请将问卷调查填写完整');
					break;
				}
			}
			$("#tips").css("margin-top","250px");
			var num1 = $('input[name="test_1"]:checked').val();
			var num2 = $('input[name="test_2"]:checked').val();
			var num3 = $('input[name="test_3"]:checked').val();
			var num4 = $('input[name="test_4"]:checked').val();
			var num5 = $('input[name="test_5"]:checked').val();
			var num6 = $('input[name="test_6"]:checked').val();
			var num7 = $('input[name="test_7"]:checked').val();
			var num8 = $('input[name="test_8"]:checked').val();
			var num9 = $('input[name="test_9"]:checked').val();
			var num10 = $('input[name="test_10"]:checked').val();
			
			var sum = parseInt(num1) + parseInt(num2) + parseInt(num3) + parseInt(num4) + parseInt(num5) + parseInt(num6) + parseInt(num7) + parseInt(num8) + parseInt(num9) + parseInt(num10);
			
			var backurl = '<%=request.getAttribute("backurl")%>';
			
			$.ajax({
				url:"<%=basePath%>accountinfo/risktestover",
				type : "POST",
				data : {
					riskResult : sum
				},
				dataType: 'json',
				success:function(data){
					if(data.result==='noLogin'){
						alert('登录超时');
						window.location.href='<%=basePath%>loginregister/s/toLogin';
					}else if(data.result==='success'){
						alert('测试成功');
						if(backurl != 'null'){
							window.location.href='' + backurl;
						}else{
							window.location.href='<%=basePath%>accountinfo/torisktest';
						}
						
					} else if(data.result==='successOne'){
						alert('测试成功,奖励的10鱼干已发放至账户');
						if(backurl != 'null'){
							window.location.href='' + backurl;
						}else{
							window.location.href='<%=basePath%>accountinfo/torisktest';
						}
					} else if(data.result==='error'){
						alert('系统错误');
						window.location.href='<%=basePath%>accountinfo/torisktestreset';
					}
				}
			});
		};
		
		//重新测试
		function resetButton(){
			window.location.href = "<%=basePath%>accountinfo/torisktestreset";
		};
		
		//返回上一页
		function goBack() {
			window.location.href = "<%=basePath%>accountinfo/personalSettings";
		}
		
		$(function() {
			var isRisk = ${isRisk};
			if(isRisk == 0){
				$('.cns-mask').css('height', $(document).height());
				
				$('.cns-mask').show();
				$('.fx-cns').slideDown();
				setTimeout("$('.cns-btn').attr('style','background-color: #ff5500;color:white;')",5000);
				setTimeout("$('.cns-btn').attr('onclick','closeIfream();')",5000);
			}

		});
		function closeIfream(){
			$('.cns-mask').slideUp();
			$('.fx-cns').slideUp();
		}
		
	</script>

</html>