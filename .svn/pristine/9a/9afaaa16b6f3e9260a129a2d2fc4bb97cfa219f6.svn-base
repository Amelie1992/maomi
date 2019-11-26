<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>众筹参与</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/crowdfund/crowdfundinvest.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<script src="js/layer/layer.js"></script>
<script src="js/checkgold/checkgold.js"></script>
<script type="text/javascript" src="js/crowdfund/crowdfundinvest.js"></script>
</head>
<body>
		<div class="wrap">
			<div class="head">
				<p id="totalMoney">${cBean.eachMoney }元</p>
				<p>实际投资金额</p>
			</div>
			<div class="mid">
				<div class="mid-inner">
					<div style="width: 50%;margin: 0 auto;height: 30px;line-height: 30px;">
						<div>
							<img src="images/zctz-minus.png" onclick="minNum()"/>
						</div>
						<div id="shownum">1</div>
						<div>
							<img src="images/zctz-add.png" onclick="addNum()"/>
						</div>

					</div>

				</div>
				
				<div class="zctz-btn">
					<p>请选择投资份数</p>
					<img src="images/zctz-btn.png" onclick="investCrowdfund(${cBean.crowdId})"/>
				</div>
			</div>
			<div class="tips">
				<p>温馨提示：</p>
				<p>此众筹目标总金额为${cBean.crowdMoney }元，共计${cBean.maxEach }份，每份${cBean.eachMoney }元，剩余可投${hasEach }份,请按需投资。</p>
			</div>
		</div>
		<input type="hidden" id="maxEach" value="${cBean.maxEach }">
		<input type="hidden" id="hasEach" value="${hasEach }">
		<input type="hidden" id="eachMoney" value="${cBean.eachMoney }">
</body>
</html>