<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="js/isWeixin.js"></script>
<title>委托发标协议</title>
<style type="text/css">
	.back {
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}
	.wrap {
				width: 100%;
			}
			* {
				font-size: 12px;
			}
			
			table {
				width: 100%;
				text-align: center;
				border: 1px solid #212121;
			}
			
			.title {
				text-align: center;
				font-size: 14px;
			}
			.jiafang,
			.yifang {
				width: 100%;
				height: 120px;
				margin-top: 20px;
				position: relative;
			}
			
			.yifang img {
				position: absolute;
				/*width: 200px;*/
				height: 150px;
				left: 20px; 
				top: -20px;
			}


</style>
<script type="text/javascript">

//返回
function goBack(){
	var id=$("#sid").val();
	window.location.href='<%=basePath%>subject/detailsubject?id='+id;
}
</script>
</head>

<body>
	<input type="hidden" id="sid" value="${sBean.subjectId }"/>
	<p>
	<img src="<%=basePath%>images/back.png" class="back" onclick="goBack()" />
	</p>
	<div class="wrap">
		<h4 class="title">
			委托发标协议
		</h4>
		<p>
			本协议由以下双方当事人于${sBean.effectTime}签订:
		</p>
		<div class="jiafang">
			<p><img src="images/gsyz1.jpg" /></p>
		</div>
		<p>乙方（中介方）：江苏猫儿信息科技股份有限公司</p>
		<p>地址：南京市鼓楼区山西路68号11层D座</p>
		<setion>
			依据 《中华人民共和国合同法》 及相关法律、法规之规定，甲、乙双方在平等 、自愿和协商一致的基础上，就甲方委托乙方代理发布借款项目等事宜达成一致意 见，订立协议如下：
			<h4>
	第一条 委托内容
</h4>
			<p>1.1 甲方有借款之意向，委托乙方为其提供订立借款合同的机会。</p>
			<p>1.2 甲方委托乙方代其在猫咪财富平台上发布借款项目进行融资，因该项目签署的 平台电子借款协议对甲方具有法律约束力。甲方理解并同意，在签署本协议之前其 已经仔细阅读平台电子借款协议（详见本协议附件 “猫咪财富”借款协议》）。
			</p>
			<p>1.3 甲方委托乙方在借款项目募集完成以后代为将募集款项支付到甲方的银行账户 作为质押借款。
			</p>
			<h4>
	第二条:借款项目信息
</h4>
			<p>借款金额：【${sBean.subjectMoney}】元</p>
			<p>年化利率：【${sBean.subjectRate}】%</p>
			<p>借款期限：【${sBean.subjectPeriods}】
			 	 <c:if test="${'0'==sBean.subjectTerm}">天</c:if>
				 <c:if test="${'1'==sBean.subjectTerm}">月</c:if>
				 <c:if test="${'2'==sBean.subjectTerm}">年</c:if>
			</p>
			<p>还款方式：【<c:if test="${'0'==sBean.repeatType}">等额本息</c:if>
						<c:if test="${'1'==sBean.repeatType}">先息后本</c:if>
						<c:if test="${'2'==sBean.repeatType}">一次性还本付息</c:if>
				】</p>
			<p>
				质押物:
				<table border="1" cellspacing="0" cellpadding="5">
					<tr>
						<th>序号</th>
						<th>品牌</th>
						<th>货物名称(中文)</th>
						<th>规格,型号</th>
						<th>数量</th>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				
					<tr>
						<td colspan='4' style="text-align: left;">合计</td>

						<td></td>
					</tr>
				</table>
			</p>

			<h4>
	第三条:服务费用支付
</h4>
			<p>
				3.1 就乙方提供的服务，甲方应支付服务费。本次服务费为借款本金金额的【${trueRate}】%年化利率即【${trueMoney}】元。
			</p>

			<p>
				3.2 在借款项目募集完成后，乙方可在甲方每次还款金额中直接扣收服务费。
			</p>
			<p>
				3.3 提前还款，乙方不退还任何服务费。
			</p>
			<h4>
	第四条:保密条款
</h4>
			<p>4.1 甲、乙双方之任何一方对于因签署或履行本协议而获悉的对方尚未公开的信息承担 保密义务，未经其他方事先书面同意，不得将该信息以及本协议之内容披露予本协议双 方之外的任何人，但履行本协议需要（如推荐借款需求给出借款人、尽职调查等）以及 法律、法规要求披露的情况除外。
			</p>
			<p>4.2 本条规定在本协议终止后仍然有效。</p>
			<p>4.3 如甲方违反 《借款协议》 或本协议之约定，乙方有权向公众披露甲方的违约信息。</p>

			<h4>
			第五条 :服务费用支付
		</h4>
			<p>
				甲、乙双方应依照本协议之条款适当履行合同义务，如有违反，须向守约方承担违 约责任，并赔偿对方因此遭受的损失（包括但不限于诉讼费、律师费及其用它实现 债权的费用）。

			</p>
			<h4>
		第六条 :其它事项	
		</h4>
			<p>6.1 本协议有效期内，如甲、乙双方之任何一方变更银行账户、通讯地址等信息， 须以书面形式通知相关方，否则视为尚未变更，由此造成的损失由该方自行承担。
			</p>
			<p>6.2 履行本协议过程中若产生争议，应通过友好协商的方式加以解决。协商不成 的，甲、乙双方之任何一方均可向乙方所在地南京市鼓楼区人民法院提起诉讼。
			</p>
			<p>6.3 本协议自双方签章后生效。 </p>
			<p>6.4 本协议一式二份，甲、乙双方各执一份。</p>
			<p>6.5 本协议未尽事宜，双方应另行协商确定。</p>

			<div class="jiafang">
				
				<p><img src="images/gsyz1.jpg" /></p>
			</div>
			<div class="yifang">
				<p>乙方：江苏猫儿信息科技股份有限公司</p>
				<p>日期：</p>
				<p><img src="images/gsgz.png" /></p>
			</div>

		</setion>
	</div>

</body>

</html>
