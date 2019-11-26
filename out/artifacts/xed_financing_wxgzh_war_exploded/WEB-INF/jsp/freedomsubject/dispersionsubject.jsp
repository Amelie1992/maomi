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
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>

<title>分散投资详情</title>
<style type="text/css">
			.wrap {
				width: 100%;
				position: relative;
			}
			.title {
				width: 100%;
				position: relative;
				text-align: center;
				font-size: 18px;
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
			.mid-tips {
				width: 50%;
				position: absolute;
				left: 25%;
				top: 18%;
				text-align: center;
				line-height: 25px;
			}
			.mid-tips p:nth-of-type(1){
				color: #888888;
			}
			.mid-tips p:nth-of-type(2){
				color: #212121;
				font-size: 18px;
			}
			.mid-tips p:nth-of-type(3){
				color: lightskyblue;
				font-size: 12px;
			}
			
			.tipsbar{
				width: 85%;
				margin: 0 auto;
				text-align: center;
				font-size: 12px;
				line-height: 20px;
				color: #888888;
				padding-top:15px
			}
			.tipsbar table{
				width: 100%;
				text-align: left;
			}
			.tipsbar table th:nth-of-type(1){
				
				text-align:left;
			}
			.tipsbar table th:nth-of-type(2){
				
				text-align: left;
			}
			.tipsbar table th:nth-of-type(6){
				
				text-align: right;
			}
			.tipsbar table th:nth-of-type(7){
				
				text-align: right;
			}
			.tipsbar table th:nth-of-type(2) span{
				display: inline-block;
				width: 20px;
				height: 20px;
				border-radius: 10px;
				background-color: lightskyblue;
				color: white;
				text-align: center;
			}
			.tipsbar table th:nth-of-type(6) span{
				display: inline-block;
				width: 20px;
				height: 20px;
				border-radius: 10px;
				background-color: lightcoral;
				color: white;
				text-align: center;
			}
			
			.tipsbar table th:nth-of-type(3){
				width: 15%;				
				background-color: #ff8310;
			}
			.tipsbar table th:nth-of-type(4){
				width: 15%;
				background-color: #1ba8e9;
			}
			.tipsbar table th:nth-of-type(5){
				width: 15%;
				background-color: #47e8a6;
			}
			
			.tips {
				width: 85%;
				margin: 0 auto;
				line-height: 25px;
				text-align: left;
				color:#888;
				font-size:14px;
				background-color:#F7F7F7;
			}
			
			.datatips {
				width: 85%;
				margin: 0 auto;
				color: #888888;
				text-align: left;
				line-height: 24px;
				font-size: 12px;
				list-style-type:none;
				background-color:#F7F7F7;
			}
			
			.datatips b {
				display: inline-block;
				width: 30px;
				height: 12px;
				border-radius: 2px;
			}
			
			.datatips li {
				line-height: 40px;
				padding-left:10px
			}
			
			.datatips li:nth-of-type(1) b {
				background-color: #ff8310;
			}
			
			.datatips li:nth-of-type(2) b {
				background-color: #1ba8e9;
			}
			
			.datatips li:nth-of-type(3) b {
				background-color: #47e8a6;
			}
		</style>
</head>

<body>
		<form method="post" action="" id="form1" >
    	  <input type="hidden" id="freedomSubjectId" name="freedomSubjectId" value="${freedomSubjectId}">
   		</form>
		<div class="wrap">
			
			<input type="hidden" id="d0" value="${s0.typeCount }">
			<input type="hidden" id="d1" value="${s1.typeCount }">
			<input type="hidden" id="d2" value="${s2.typeCount }">
			
			<div class="title">
				<img src="images/back.png" class="back" onclick="goBack()"/>现持有团标组成
			</div>
			<div id="main" style="width: 100%;height: 300px;">

			</div>
			<div class="mid-tips">
				<p>共分散投资</p>
				<p>${count }标</p>
				<p onclick="queryDispersionSubject()">查看更多详情</p>
			</div>
			
			<div class="datatips">
				<li>
					<b></b>
					<span>I质押类标</span>

					<span>共计${s0.typeMoney }万元</span>
					<span>占比${s0.typeCountPercentage }%</span>
				</li>
				<li>
					<b></b>
					<span>II抵押类标</span>

					<span>共计${s1.typeMoney }万元</span>
					<span>占比${s1.typeCountPercentage }%</span>
				</li>
				<li>
					<b></b>
					<span>III信用贷类标</span>

					<span>共计${s2.typeMoney }万元</span>
					<span>占比${s2.typeCountPercentage }%</span>
				</li>
			</div>
			
			<div class="tipsbar">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>风险等级</th>
						<th>
							<span>低</span>
						</th>
						<th></th>
						<th></th>
						<th></th>
						<th>
							<span>高</span>
						</th>
						<th>风险等级</th>
					</tr>
					
				</table>
			</div>

			<div class="tips">
				<p>&nbsp;&nbsp;&nbsp;&nbsp;猫咪财富根据风险定价原则，将散标从高到低分为I,II,III 3个风险评级。</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;每个评级分1-9个等级,每个等级利率各不相同。</p>
			</div>

		</div>
		
		<script src="js/echarts.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		function goBack()
		{
			var form = document.forms['form1'];
			form.action = './freedomsubject/s/detailfreedomsubject';
			form.submit();
		}
		
		function queryDispersionSubject()
		{
			var form = document.forms['form1'];
			form.action = './subjectdispersed/querySubjectDispered';
			form.submit();
		}
		
		var d0=$("#d0").val();
		var d1=$("#d1").val();
		var d2=$("#d2").val();
		var myChart = echarts.init(document.getElementById('main'));
		var i = 0;
		var colors = ['#393939', '#f5b031', '#fad797', '#59ccf7', '#c3b4df'];
		option = {
			tooltip: {
				trigger: 'item',
				formatter: "{a} <br/>{b}: {c} ({d}%)"
			},

			series: [{
				name: '分散标类型',
				type: 'pie',
				radius: ['50%', '85%'],
				avoidLabelOverlap: false,
				label: {

					normal: {
						show: false,
						position: 'center'
					},
					emphasis: {
						show: false,
						textStyle: {
							fontSize: '30',
							fontWeight: 'bold'
						}
					}
				},
				labelLine: {
					normal: {
						show: false
					}
				},
				data: [{
						value: d0,
						name: 'I标(数量)',
						itemStyle: {
							normal: {
								color: '#ff8310'
							}
						}
					},
					{
						value: d1,
						name: 'II类标(数量)',
						itemStyle: {
							normal: {
								color: '#1ba8e9'
							}
						}
					},
					{
						value: d2,
						name: 'III类标(数量)',
						itemStyle: {
							normal: {
								color: '#47e8a6'
							}
						}
					}
				]
			}]
		};
		myChart.setOption(option);
		</script>
</body>
</html>
