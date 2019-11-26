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
<script type="text/javascript" src="js/tool.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<title>服务协议</title>
<style type="text/css">
*{
	margin: 0px;
	padding: 0px;
}
.wrap {
	width: 100%;
	font-size: 14px;
}

.title {
	width: 100%;
	position: relative;
	text-align: center;
	font-size: 17px;
	color: #333333;
	font-weight: 600;
	height: 50px;
	line-height: 50px;
	background-color: #F7F7F7;
	
}

.back {
	position: absolute;
	left: 20px;
	top: 15px;
	width: 11px;
	height: 16px;
}
.d_p{
padding: 8px;
}
table{
	width: 100%;
	padding: 0px;
	padding: 8px;
}
table th{
width:100%;
font-size: 16px;
}
.sj{
	text-indent: 2em;
}
.sj1{
	text-indent: 1em;
}
.ts{
	width: 15%;
	vertical-align:top;
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="title">
			<img src="images/back.png" class="back" onclick="goBack()" />服务协议
		</div>
		<div class="d_p"><p class="sj">欢迎阅读《猫咪财富服务条款协议》(下称"本协议")。本协议双方为猫咪财富(以下简称"本平台")与猫咪财富会员(包括个人和企业客户，简称"会员"或"您")，本服务协议具有合同效力。</p></div>
		<table>
			<tr>
				<th colspan="2">第一章 接受条款</th>
			</tr>
			<tr>
				<td></td>
				<td class="sj">本协议内容包括协议正文及所有已经发布的或将来可能发布的各类规则。所有规则为协议不可分割的一部分，与协议正文具有同等法律效力。</td>
			</tr>
			<tr>
				<td></td>
				<td class="sj">在您注册成为本平台会员前请务必仔细阅读以下条款。若您一旦注册，则视为您接受本平台的服务且必须受以下条款的约束。若您不接受以下条款，请立即离开本平台。</td>
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="2">第二章 会员身份限制</th>
			</tr>
			<tr>
				<td class="ts">第一条</td>
				<td class="sj">作为本平台会员，您必须是中华人民共和国公民，年龄在18周岁及以上，且具有完全的民事权利能力及民事行为能力。如不具备上述资格，您只能在父母或其他监护人的监护参与下才能使用本平台。否则，您应立即停止在网站的注册程序、停止使用本平台服务，本平台有权随时终止您的注册进程及本平台服务，您应对您的注册给本平台带来的全部损失承担赔偿责任，且您的监护人应承担连带责任。</td>
			</tr>
			<tr>
				<td class="ts">第二条</td>
				<td class="sj">个人会员必须依本平台要求提供个人会员真实、最新、有效、完整的信息以及融资信息。</td>
			</tr>
			<tr>
				<td class="ts">第三条</td>
				<td class="sj">个人会员有义务维持并更新个人会员的资料，确保其为真实、最新、有效及完整。若个人会员提供任何错误、虚假、过时或不完整的资料，或者本平台依其独立判断怀疑资料为错误、虚假、过时或不完整，本平台有权暂停或终止个人会员的会员账户，并拒绝个人会员使用本平台服务的部分或全部功能。在此情况下，本平台不承担任何责任，并且个人会员同意负担因此所产生的直接或间接的任何支出或损失。</td>
			</tr>
			<tr>
				<td class="ts">第四条</td>
				<td class="sj">如因个人会员未及时更新基本资料，导致本平台服务无法提供服务或提供服务时发生任何错误，个人会员不得将此作为取消交易或拒绝付款的理由，本平台亦不承担任何责任，所有后果应由个人会员承担。</td>
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="2">第三章 您的权利和义务</th>
			</tr>
			<tr>
				<td class="ts">第一条</td>
				<td class="sj">您有权利拥有在本平台注册的会员名及登录密码，并有权利使用自己的会员名及密码随时登陆本平台。您不得以任何形式擅自转让或授权他人使用自己的本平台会员名及密码；</td>
			</tr>
			<tr>
				<td class="ts">第二条</td>
				<td class="sj">您有权根据本协议的规定以及本平台上发布的相关规则，利用本平台信息发布平台查询服务信息、提交融资信息、参与本平台的有关活动以及有权享受本平台提供的其它的有关服务；</td>
			</tr>
			<tr>
				<td class="ts">第三条</td>
				<td class="sj">您在本平台进行交易的过程中，如与其他融资机构因交易产生纠纷，可以请求本平台予以协调。您如发现其他机构有违法或违反本协议的行为，可以向本平台进行反馈和要求处理。如您因网上交易与其他会员发生诉讼的，您有权通过司法部门要求本平台提供相关资料；</td>
			</tr>
			<tr>
				<td class="ts">第四条</td>
				<td class="sj">您同意遵守本平台的交易规则，接收来自本平台或本平台合作伙伴发出的邮件或信息。</td>
			</tr>
			<tr>
				<td class="ts">第五条</td>
				<td class="sj">您应当保证在使用本平台进行信息发布过程中遵守诚实信用的原则，不得在发布的信息中包含有反动、暴力、淫秽、毒品、赌博、教唆及有损社会公共道德的内容；不得发布各类违法或违规信息；</td>
			</tr>
			<tr>
				<td class="ts">第六条</td>
				<td class="sj">您不应在本平台上恶意评价其他会员，或采取不正当手段提高自身的信用度或降低其他会员的信用度；</td>
			</tr>
			<tr>
				<td class="ts">第七条</td>
				<td class="sj">您在本平台上不得发布包含有国家禁止或限制发布包含有侵犯他人知识产权或其它合法权益的机密类信息，也不得发布违背社会公共利益或公共道德的、或是本平台认为不适合在本平台上发布的信息。</td>
			</tr>
			<tr>
				<td class="ts">第八条</td>
				<td class="sj">您承诺在使用本平台时实施的所有行为均遵守国家法律、法规和本平台的相关规定以及各种社会公共利益或公共道德。如有违反上述承诺导致任何法律后果的发生，您应独立承担所有相应的法律责任；</td>
			</tr>
			<tr>
				<td class="ts">第九条</td>
				<td class="sj">您同意，不对本平台上任何数据作商业性利用，包括但不限于在未经本平台事先书面批准的情况下，以复制、传播等方式使用在本平台网站上展示的任何资料。</td>
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="2">第四章 本平台对您的资料的披露</th>
			</tr>
			<tr>
				<td class="ts">第一条</td>
				<td class="sj">本平台将采用行业标准惯例以保护您的个人资料，但鉴于技术限制，本平台不能确保您的全部私人通讯及其他个人资料不会通过本隐私规则中未列明的途径泄露出去。</td>
			</tr>
			<tr>
				<td class="ts">第二条</td>
				<td class="sj">本平台有义务根据有关法律要求向司法机关和政府部门提供您的个人资料。在您未能按照与本平台签订的服务协议、居间协议或者与本平台其他会员签订的借款协议的约定履行自己应尽的义务时，本平台有权根据自己的判断或者与该笔交易有关的其他会员的请求披露您的个人资料，并作出评论。</td>
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="2">第五章 您对其他会员的资料的使用</th>
			</tr>
			<tr>
				<td></td>
				<td class="sj">在本平台提供的交易活动中，您无权要求本平台提供其他会员的个人资料，除非符合以下条件：</td>
			</tr>
			<tr>
				<td></td>
				<td class="sj1">(a)您已向法院起诉其他会员在本平台活动中的违约行为；</td>
			</tr>
			<tr>
				<td></td>
				<td class="sj1">(b)与您有关的其他会员(包括交易关系、本平台登记的朋友关系)逾期未归还借款本息；</td>
			</tr>
			<tr>
				<td></td>
				<td class="sj1">(c)本平台被吊销营业执照、解散、清算、宣告破产或者其他有碍于您收回借款本息的情形。</td>
			</tr>
			<tr>
				<td></td>
				<td class="sj">如您在与本平台的其他会员的交易中逾期未归还借款本息，本平台的其他会员可以采取发布您个人信息的方式向您追索债权，但本平台对该等会员的行为免责。</td>
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="2">第六章 密码的安全性</th>
			</tr>
			<tr>
				<td></td>
				<td class="sj">您须对使用您的会员名和密码所采取的一切行为负责。因此，本平台建议您不要向任何第三方披露您在本平台的会员名和密码。</td>
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="2">第七章 免责声明</th>
			</tr>
			<tr>
				<td></td>
				<td class="sj">个人会员同意，基于互联网的特殊性，本平台不担保服务不会中断，也不担保服务的及时性和安全性。 系统因相关状况无法正常运作，使个人会员无法使用任何本平台服务或使用任何本平台服务时受到任何影响时，本平台对个人会员或第三方不负任何责任，前述状况包括但不限于：</td>
			</tr>
			<tr>
				<td></td>
				<td class="sj1">1、本平台系统停机维护期间。</td>
			</tr>
			<tr>
				<td></td>
				<td class="sj1">2、电信设备出现故障不能进行数据传输的。</td>
			</tr>
			<tr>
				<td></td>
				<td class="sj1">3、由于黑客攻击、网络供应商技术调整或故障、网站升级、银行方面的问题等原因而造成的本平台服务中断或延迟。</td>
			</tr>
			<tr>
				<td></td>
				<td class="sj1">4、因台风、地震、海啸、洪水、停电、战争、恐怖袭击等不可抗力之因素，造成本平台系统障碍不能执行业务的。</td>
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="2">第八章 规则修改</th>
			</tr>
			<tr>
				<td></td>
				<td class="sj">本平台可能不时按照您的意见和本平台的需要修改本隐私规则，以准确地反映本平台的资料收集及披露惯例。本规则的所有修改，在本平台于拟定生效日期前至少三十(30)日在网站公布有关修改通知。</td>
			</tr>
			<tr>
				<td></td>
				<td class="sj">除此之外，其他向您个人发布的具有专属性的通知将由本平台向您的注册时或者注册后变更会员信息时本平台提供的电子邮箱，或您在注册时绑定的手机发送，已经发送即视为已发送。请您密切关注您的电子邮箱、"个人收件箱"中的邮件个信息及手机中的短信信息。</td>
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="2">第九章 终止</th>
			</tr>
			<tr>
				<td></td>
				<td class="sj">除非本平台终止本协议或者您申请终止本协议及注销相应会员账户且经本平台同意，否则本协议始终有效。</td>
			</tr>
			<tr>
				<td></td>
				<td class="sj">在您违反了本协议、相关规则，或在相关法律法规、政府部门的要求下，本平台有权通过电子邮件告知方式终止本协议、关闭您的账户或者限制您使用本平台</td>
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="2">第十章 违约责任</th>
			</tr>
			<tr>
				<td></td>
				<td class="sj">如果您违反了您在协议中所作的陈述、保证、承诺或任何其他义务，致使本平台或本平台的股东、实质控制人、员工承受任何损失，您应向受损失的一方做出全额赔偿</td>
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="2">第十一章 其他</th>
			</tr>
			<tr>
				<td></td>
				<td class="sj">若本协议适用中华人民共和国法律，同时约定本网站所在地法院为争议管辖法院，与本协议的解释和履行有关的争议应提交本平台管辖法院处理。</td>
			</tr>
		</table>
	</div>
</body>
<script type="text/javascript">
function goBack(){
	window.history.go(-1);
	
}
</script>
</html>
