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
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<title>限额说明</title>
<style type="text/css">
.wrap {
				width: 100%;
			}
			
			.title {
				width: 100%;
				position: relative;
				text-align: center;
				font-size: 20px;
				color: #333333;
				font-weight: 600;
				height: 50px;
				line-height: 50px;
				background-color: #F7F7F7;
			}
			
			.back {
				position: absolute;
				left: 20px;
				top: 10px;
			}
			.wrap ul li{
				height: 50px;
				position: relative;
				margin-top: 10px;
				
			}
			.bankPic{
				position: absolute;
				top: 5px;
				left: 10px;
			}
			.wrap .bankPic img{
				width: 40px;
				height: 40px;
			}
			.bankName{
				font-size: 18px;
				color: #333333;
				padding: 5px 0;
				font-weight: bold;
				margin-left: 60px;
			}
			.bankTips{
				color: #C3C3C3;
				padding: 5px 0;
				margin-left: 60px;
				font-size:8px;
				border-bottom: 1px solid #EEEEEE;
			}	
</style>


</head>

<body>
	<div class="wrap">
	<div class="title">
			<img src="images/back.png" class="back" onclick="getBack()" />限额说明
		</div>
	<ul>
		<li>
			<div class="bankPic">
				<img src="images/zhongguo.png"/>
			</div>
			<p class="bankName">中国银行</p>
			<p class="bankTips">单笔限额5万,单日限额20万,单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/gongshang.png"/>
			</div>
			<p class="bankName">工商银行</p>
			<p class="bankTips">单笔限额5万,单日限额5万,单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/nongye.png"/>
			</div>
			<p class="bankName">农业银行</p>
			<p class="bankTips">单笔限额5万,单日限额20万(单日仅限6笔成功交易),单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/jianshe.png"/>
			</div>
			<p class="bankName">建设银行</p>
			<p class="bankTips">单笔限额5万,单日限额10万,单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/jiaotong.png"/>
			</div>
			<p class="bankName">交通银行</p>
			<p class="bankTips">单笔限额5万,单日限额5万,单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/zhaoshang.png"/>
			</div>
			<p class="bankName">招商银行</p>
			<p class="bankTips">单笔限额5万,单日限额20万,单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/youzheng.png"/>
			</div>
			<p class="bankName">邮政储蓄银行</p>
			<p class="bankTips">单笔限额10万,单日限额20万,单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/pufa.png"/>
			</div>
			<p class="bankName">浦发银行</p>
			<p class="bankTips">单笔限额10万,单日限额20万,单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/guangfa.png"/>
			</div>
			<p class="bankName">广发银行</p>
			<p class="bankTips">单笔限额10万,单日限额20万,单月限额100万</p>
		</li>
		
		<li>
			<div class="bankPic">
				<img src="images/zhongxin.png"/>
			</div>
			<p class="bankName">中信银行</p>
			<p class="bankTips">单笔限额1万,单日限额1万,单月限额2万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/xingye.png"/>
			</div>
			<p class="bankName">兴业银行</p>
			<p class="bankTips">单笔限额5万,单日限额5万,单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/minsheng.png"/>
			</div>
			<p class="bankName">民生银行</p>
			<p class="bankTips">单笔限额10万,单日限额20万,单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/huaxia.png"/>
			</div>
			<p class="bankName">华夏银行</p>
			<p class="bankTips">单笔限额10万,单日限额20万,单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/pingan.png"/>
			</div>
			<p class="bankName">平安银行</p>
			<p class="bankTips">单笔限额10万,单日限额20万,单月限额100万</p>
		</li>
		<li>
			<div class="bankPic">
				<img src="images/guangda.png"/>
			</div>
			<p class="bankName">光大银行</p>
			<p class="bankTips">单笔限额10万,单日限额20万,单月限额100万</p>
		</li>
	</ul>
	<form action="<%=basePath%>accountinfo/toBindBankCard" method="post">
		<input type="hidden" id="bankCode" name="bankCode"/>
		<input type="hidden" id="bankPic" name="bankPic"/>
		<input type="hidden" id="bankName" name="bankName"/>
	</form>
</div>	
</body>
<script type="text/javascript">
	//返回上一页
	function getBack(){
		window.history.go(-1);
	}
</script>
</html>
