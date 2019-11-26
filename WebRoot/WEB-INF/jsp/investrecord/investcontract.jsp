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
<title>猫咪财富借款协议书</title>
<style type="text/css">
	body{
		font-size: 10.0pt;
	}
	.back {
	left: 20px;
	top: 18px;
	width: 10px;
	height: 15px;
}
.jiafang,
			.yifang {
				width: 100%;
				height: 50px;
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
function goBack(){
	window.location.href='<%=basePath%>investrecord/queryinvest';
}
</script>
</head>

<body lang=ZH-CN style='tab-interval:21.0pt;text-justify-trim:punctuation'>
<p>
	<img src="<%=basePath%>images/back.png" class="back" onclick="goBack()" />
</p>
<div class=WordSection1 style='layout-grid:15.6pt'>

			<p class=MsoNormal align=center style='text-align:center'><b style='mso-bidi-font-weight:
normal'><span style='font-size:14.0pt'>猫咪财富借款协议书<span lang=EN-US><o:p></o:p></span></span></b></p>

			<p class=MsoNormal align=left style='text-align:left'><span style='font-size:
7.5pt'>借款协议号：</span><span lang=EN-US style='font-size:7.5pt;mso-ascii-font-family:
等线;mso-ascii-theme-font:minor-fareast;mso-hansi-font-family:等线;mso-hansi-theme-font:
minor-fareast'>${sBean.subjectCode}</span><span lang=EN-US style='font-size:7.5pt'> <span
style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span style='mso-spacerun:yes'>&nbsp;</span><span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>
				<o:p></o:p>
				</span>
			</p>

			<%-- <p class=MsoNormal align=left style='text-align:left'><span style='font-size:
7.5pt'>借款人：</span><span lang=EN-US style='font-size:7.5pt;mso-ascii-font-family:
等线;mso-ascii-theme-font:minor-fareast;mso-hansi-font-family:等线;mso-hansi-theme-font:
minor-fareast'>${sBean.userName}<o:p></o:p></span></p>

			<p class=MsoNormal align=left style='text-align:left'><span style='font-size:
7.5pt;mso-ascii-font-family:等线;mso-ascii-theme-font:minor-fareast;mso-hansi-font-family:
等线;mso-hansi-theme-font:minor-fareast'>身份证号码：<span lang=EN-US>${sBean.idCard}<span
style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp; </span>
				<o:p></o:p>
				</span>
				</span>
			</p>
 --%>
 			<div class="jiafang">
			<p><img src="images/JKR01.jpg" /></p>
			</div>
			<p class=MsoNormal align=left style='text-align:left'><span style='font-size:
7.5pt;mso-ascii-font-family:等线;mso-ascii-theme-font:minor-fareast;mso-hansi-font-family:
等线;mso-hansi-theme-font:minor-fareast'>签订日期：<span lang=EN-US>${iBean.investTime} <span
style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span style='mso-spacerun:yes'>&nbsp;</span>
				<o:p></o:p>
				</span>
				</span>
			</p>

			<p class=MsoNormal align=left style='text-align:left'><span style='font-size:
7.5pt;mso-ascii-font-family:等线;mso-ascii-theme-font:minor-fareast;mso-hansi-font-family:
等线;mso-hansi-theme-font:minor-fareast'>出借人：<u>详见本协议第一条</u> <span lang=EN-US><span
style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<o:p></o:p>
				</span>
				</span>
			</p>

			<p class=MsoNormal>签订地点：南京市鼓楼区 <span style='mso-spacerun:yes'>&nbsp;</span>居间服务人：江苏猫儿信息科技股份有限公司
			</p>

			<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

			<p class=MsoNormal>
				
				<p>
				鉴于：
				</p>
				<span lang=EN-US> 1</span>.居间服务人是一家在中国南京市合法成立并有效存续的有限公司，拥有并运营
				<a name="_Hlk485110068">猫咪财富</a> （网址：<span lang=EN-US>maomibank.com ,</span>以下凡提及该网站者，均指居间服务人），向网站注册用户提供咨询.信息提供及各种委托服务等居间服务。</p>

			<p class=MsoNormal><span lang=EN-US><span
style='mso-spacerun:yes'>&nbsp;</span>2</span>.出借人和借款人均已阅读并同意遵守猫咪财富的《注册协议》，注册成为猫咪财富的用户，并认可猫咪财富通过网站公开发布关于注册用户的各种规则。
			</p>

			<p class=MsoNormal><span lang=EN-US>3</span>.出借人和借款人同意通过居间服务人的服务.以电子合同的形式达成本借款协议，本借款协议的内容经双方充分阅读且知晓每一条款的含义，是双方真实意思表示。
			</p>

			<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

			<p class=MsoNormal>借款人与各出借人，通过猫咪财富的居间服务，就有关借款事项达成如下协议： </p>

			<p class=MsoNormal>第一条.出借人详情如下表所示<span lang=EN-US>: </span></p>

			<p class=MsoNormal>出借人：<span lang=EN-US>${aBean.realName}</span></p>

			<p class=MsoNormal>出借人身份证号码：<span lang=EN-US>${aBean.idCard}</span></p>

			<p class=MsoNormal>出借金额：<span lang=EN-US>${iBean.investMoney}</span></p>

			<p class=MsoNormal>出借期限：<span lang=EN-US>${iBean.endTime}</span></p>

			<p class=MsoNormal>第二条.还款 </p>

			<p class=MsoNormal><span lang=EN-US>1</span>.借款人承诺按照本协议第一条约定的时间和金额按期足额向出借人还款。 </p>

			<p class=MsoNormal><span lang=EN-US>2</span>.借款人的每一期还款的还款金额计算公式为：每月须还款总金额<span lang=EN-US>=</span>每月须还利息<span lang=EN-US>+</span>每月须还本金。</p>

			<p class=MsoNormal><span lang=EN-US><span
style='mso-spacerun:yes'>&nbsp;</span>3</span>.借款人的最后一期还款必须包含全部剩余本金.利息及其他根据本协议产生的全部费用。  </p>

			<p class=MsoNormal>第三条.借款.还款的支付方式 </p>

			<p class=MsoNormal><span lang=EN-US>1</span>.出借人在同意向借款人出借相应款项时<span lang=EN-US>,</span>已委托猫咪财富在本借款协议生效后将该笔借款直接划付至借款人帐户。借款人已委托猫咪财富将还款直接划付至出借人帐户。出借人及借款人均授权猫咪财富委托银行从出借人或借款人账户中划付应支付或应偿还的借款本息及其他应付费用。
			</p>

			<p class=MsoNormal><span lang=EN-US>2</span>.猫咪财富网站通过公告或其他各种方式明示出借人应享有的各种收益（包括但不限于利息.奖励等），均已包含在本协议的借款利息中。
			</p>

			<p class=MsoNormal><span lang=EN-US>3</span>.借款人和出借人均同意，猫咪财富接受借款人或出借人委托所采取的划付款项行为，所产生的法律后果均由相应委托方借款人或出借人自行承担。</p>

			<p class=MsoNormal><span lang=EN-US><span
style='mso-spacerun:yes'>&nbsp;</span>4</span>.本协议中借款和还款的履行地均为猫咪财富的公司注册地：江苏省南京市鼓楼区。
			</p>

			<p class=MsoNormal>第四条.逾期还款 </p>

			<p class=MsoNormal><span lang=EN-US>1</span>.若借款人逾期仍未还款<span lang=EN-US>,</span>借款人除向出借人支付正常利息以外<span lang=EN-US>,</span>还应每天承担逾期罚息<span lang=EN-US>(</span>金额为未偿还本息的千分之八<span lang=EN-US>)</span>，且出借人有权提前终止合同，要求借款人偿还全部借款本息。出借人和借款人均同意并认可，猫咪财富可通过短信.电话.上门催收或委托第三方等方式对借款人逾期未偿还的本息进行催收<span lang=EN-US>,</span>且上述逾期罚息，借款人和出借人均同意作为催收服务费用由借款人直接向猫咪财富或债权受让方（如有）支付。 </p>

			<p class=MsoNormal><span lang=EN-US>2</span>.借款人同意，其逾期还款造成出借人因此支付的费用<span lang=EN-US>(</span>包括但不限于律师费.诉讼费.保全费.公告费<span lang=EN-US>)</span>由借款人承担；</p>

			<p class=MsoNormal><span lang=EN-US><span
style='mso-spacerun:yes'>&nbsp;</span>3</span>.借款人同意，如借款人逾期未偿还任何一期还款，出借人及借款人同意并支持猫咪财富采取以下措施之一项或几项：
			</p>

			<p class=MsoNormal>（<span lang=EN-US>1</span>）将借款人的有关身份资料及其他个人信息通过猫咪财富<span lang=EN-US>“</span>逾期黑名单<span lang=EN-US>”</span>等栏目对外公开； （<span lang=EN-US>2</span>）将借款人的有关身份资料及其他个人信息正式备案在<span lang=EN-US>“</span>不良信用记录<span lang=EN-US>”,</span>列入全国个人信用评级体系的黑名单<span lang=EN-US>(“</span>不良信用记录<span lang=EN-US>”</span>数据将为银行.电信.担保公司.人才中心等有关机构提供 个人不良信用信息<span lang=EN-US>)</span>； </p>

			<p class=MsoNormal>（<span lang=EN-US>3</span>）对借款人采取法律措施<span lang=EN-US>,</span>由此所产生的所有法律后果将由借款人来承担；
			</p>

			<p class=MsoNormal>（<span lang=EN-US>4</span>）无需催告即可要求借款人偿还全部借款本息，并提前解除借款合同。 </p>

			<p class=MsoNormal>第五条：借款债权的转让 </p>

			<p class=MsoNormal><span lang=EN-US>1</span>.借款人知晓并同意出借人于本协议履行过程中可能将其因本借款协议而享有的债权的全部或部分转让给不特定的第三人，且转让次数无限定。
			</p>

			<p class=MsoNormal><span lang=EN-US>2</span>.出借人将其债权全部或部分转让给第三人的，应当通知借款人，可以以信件.电子邮件.短信.电话或当面送达等合法形式。该债权转让自出借人或其委托人之通知送达之日起对借款人发生效力。
			</p>

			<p class=MsoNormal>
				
				<p>
					<span lang=EN-US>3</span>.就债权转让事宜，出借人在此无条件且不可撤销的授予猫咪财富如下委托事项及权限： 
				</p>
				
				
				
				
				（
				<span lang=EN-US>1</span>）在符合本协议<span lang=EN-US>5.7</span>条或本协议其他条款约定或猫咪财富公告的债权转让的情形发生时，由猫咪财富代表全体出借人与债权受让人（或与债权受让人.借款人一并）签订《债权转让协议》和<span lang=EN-US>/</span>或《债权转让确认书》及其他债权转让有关的合同.文件； </p>

			<p class=MsoNormal>（<span lang=EN-US>2</span>）将债权转让事宜（包括债权受让人等）通知借款人；<span style='font-size:14.0pt'> <span lang=EN-US><o:p></o:p></span></span>
			</p>

			<p class=MsoNormal>（<span lang=EN-US>3</span>）代收债权转让对价款项； </p>

			<p class=MsoNormal>上述委托的有效期自本协议生效之日起直至本协议项下全部借款本息及清偿费用全部清偿完毕之日止。 </p>

			<p class=MsoNormal><span lang=EN-US>4</span>.借款人在此已明确知晓猫咪财富的受托权限，承诺在接到猫咪财富的债权转让通知时即对债权受让人负有对应债权的清偿义务，而无需猫咪财富再行出具出借人的书面委托。</p>

			<p class=MsoNormal><span lang=EN-US>5</span>.出借人将其债权全部或部分转让给第三人的，本借款协议中对应权利及义务一并转让给债权受让人，包括但不限于主张罚息.利息.单方提前解除合同等权利及支付中介服务费用的义务。</p>

			<p class=MsoNormal><span lang=EN-US><span
style='mso-spacerun:yes'>&nbsp;</span>6</span>.在借款人正常还款的情形下，出借人可按照猫咪财富公布的债权转让规则将债权转让给第三人。</p>

			<p class=MsoNormal><span lang=EN-US><span
style='mso-spacerun:yes'>&nbsp;</span>7</span>.出借人和借款人均同意，为集中维护各出借人权利，如出现猫咪财富认为有需要的（包括但不限于借款人未能按期如数清偿任意一期借款本息或猫咪财富认为借款人有逾期风险等）情形下，全体出借人一致同意将本协议项下债权转让给猫咪财富或猫咪财富居间介绍的其他愿意受让该项债权的第三人。出借人在此授权猫咪财富：上述情形发生之后，由猫咪财富作为全体出借人的代理人，代为选择债权受让人；代为与债权受让人签订债权转让涉及的所有合同.文件；代为向借款人发送债权转让通知；代为决定或进行其他与债权转让有关的事项，包括但不限于视实际情况独立决定债权转让的价格.支付债权转让对价的时间和方式等。自债权转让通知送达至借款人时，债权受让人取代出借人成为本借款协议新的债权人，取得与债权有关的所有权利。猫咪财富可以依据风险准备金保障计划，为债权受让人垫付债权转让对价。
			</p>

			<p class=MsoNormal>第六条：猫咪财富的居间服务费等收费</p>

			<p class=MsoNormal><span lang=EN-US>1</span>.居间服务费是指因居间服务人（猫咪财富）为借款人与出借人提供交易信息.信用咨询.信用评估、还款提醒、账户管理、还款特殊情况沟通、债权转让各项委托等系列相关服务而由借款人与出借人分别支付给猫咪财富的报酬。
			</p>

			<p class=MsoNormal><span lang=EN-US>2</span>.借款人同意在借款成功时根据借款类型的不同向猫咪财富支付居间服务费、履约保证金等费用，此笔费用借款人委托猫咪财富在借款成功时从借款本金中直接扣除。</p>

			<p class=MsoNormal><span lang=EN-US><span
style='mso-spacerun:yes'>&nbsp;</span>3</span>、借款人同意在借款成功后按月向猫咪财富支付账户管理费用，此笔费用借款人应当按月主动向猫咪财富指定账户支付，同时借款人同意由猫咪财富在借款到账时直接扣除。
			</p>

			<p class=MsoNormal><span lang=EN-US>4</span>.出借人同意在借款成功后按月向猫咪财富支付本次借款所得利息的一定比例作为居间服务费，此笔费用出借人与借款人一致同意猫咪财富在借款人支付借款本息时直接扣除。</p>

			<p class=MsoNormal><span lang=EN-US>5</span>.如借款人通过其他第三方提供的中介服务而签订本借款协议的，或借款人与第三方签订了与本借款协议有关的猫咪财富认可的其他协议的，借款人委托猫咪财富在借款成功时从借款本金中直接扣除借款人应支付给第三方的相关费用，由猫咪财富代为扣除并直接和第三方结算。
			</p>

			<p class=MsoNormal><span lang=EN-US>6</span>.包括上述费用在内的各种收费及标准，猫咪财富可事先在官方网站公告，出借人和借款人在签订本协议前均对此完全知悉并同意以猫咪财富公告或本人签字认可为准。
			</p>

			<p class=MsoNormal>第七条：违约责任</p>

			<p class=MsoNormal><span lang=EN-US>1</span>.本协议各方均应严格履行协议义务，任何一方违约，违约方应承担因违约使其他各方产生的费用和损失，包括但不限于调查费、诉讼费、律师费等。
			</p>

			<p class=MsoNormal><span lang=EN-US>2</span>.出借人和借款人双方同意<span lang=EN-US>,</span>若借款人出现如下任何一种情况<span lang=EN-US>,</span>则本协议项下的全部借款自动提前到期<span lang=EN-US>,</span>借款人在收到猫咪财富发出的借款提前到期或解除合同等通知后，应立即清偿全部本金、利息、逾期利息及根据本协议产生的其他全部费用：
			</p>

			<p class=MsoNormal>（<span lang=EN-US>1</span>）借款人因任何原因逾期支付任何一期还款超过<span lang=EN-US>1</span>天的； </p>

			<p class=MsoNormal>（<span lang=EN-US>2</span>）借款人的工作单位、职务或住所变更后，未在<span lang=EN-US>7</span>天内通知猫咪财富的； </p>

			<p class=MsoNormal>（<span lang=EN-US>3</span>）借款人发生影响其清偿本协议项下借款的其他不利变化，未在<span lang=EN-US>3</span>天内通知猫咪财富的。
			<p class=MsoNormal><span lang=EN-US>3</span>.若借款人逾期<span lang=EN-US>90</span>天支付任何一期还款的，借款人应当按照借款本金的<span lang=EN-US>20%</span>支付违约金。
			<p class=MsoNormal><span lang=EN-US>4</span>.借款人的每期还款均应按照如下顺序清偿： </p>

			<p class=MsoNormal>（<span lang=EN-US>1</span>）根据本协议产生的除本款<span lang=EN-US>7.4.2--7.4.6</span>项之外的其他全部费用；
			</p>

			<p class=MsoNormal>（<span lang=EN-US>2</span>）罚息； </p>

			<p class=MsoNormal>（<span lang=EN-US>3</span>）拖欠的利息； </p>

			<p class=MsoNormal>（<span lang=EN-US>4</span>）拖欠的本金； </p>

			<p class=MsoNormal>（<span lang=EN-US>5</span>）正常的利息； </p>

			<p class=MsoNormal>（<span lang=EN-US>6</span>）正常的本金。</p>

			<p class=MsoNormal><span lang=EN-US>3</span>.双方同意<span lang=EN-US>,</span>借款人有权提前清偿全部或部分借款而不承担任何的违约责任<span lang=EN-US>(</span>借款超过<span lang=EN-US>1</span>日不足<span lang=EN-US>1</span>个月，利息按足月计算<span lang=EN-US>)</span>。</p>

			<p class=MsoNormal>第八条:法律适用和管辖 </p>

			<p class=MsoNormal>本协议的签订、履行、终止、解释均适用中华人民共和国法律<span lang=EN-US>,</span>并由猫咪财富注册地即南京市鼓楼区人民法院管辖。</p>

			<p class=MsoNormal>第九条:特别条款 </p>

			<p class=MsoNormal><span lang=EN-US>1</span>.出借人保证，用于出借的资金是合法取得的资金。同时借款人保证，借款人将借款用于合法用途，不将所借款项用于任何违法活动<span lang=EN-US>(</span>包括但不限于赌博、吸毒、贩毒、卖淫嫖娼等<span lang=EN-US>)</span>及一切高风险投资<span lang=EN-US>(</span>如证券期货、彩票等<span lang=EN-US>)</span>。如借款人违反前述保证或有违反前述保证的嫌疑，则出借人有权采取下列措施：
			</p>

			<p class=MsoNormal>（<span lang=EN-US>1</span>）宣布提前收回全部借款； </p>

			<p class=MsoNormal>（<span lang=EN-US>2</span>）出借人向公安等有关行政机关举报<span lang=EN-US>,</span>追回此款并追究借款人的刑事责任，出借人和借款人均同意并授权猫咪财富采取前述措施。
			</p>

			<p class=MsoNormal><span lang=EN-US>2</span>.借款人和出借人均不得利用猫咪财富进行信用卡套现和其他洗钱等不正当交易行为<span lang=EN-US>,</span>若有发现，猫咪财富有权向公安等有关行政机关举报<span lang=EN-US>,</span>追究其相关法律责任。 </p>

			<p class=MsoNormal><span lang=EN-US>3</span>.借款人以各种方式提供的如下联络通讯方式以供接收与本协议有关的各项通知（包括但不限于还款通知、债权转让通知等）：
			</p>

			<p class=MsoNormal>（<span lang=EN-US>1</span>）移动电话（如有），其中短信方式发送的短信成功发出即为有效送达； </p>

			<p class=MsoNormal>（<span lang=EN-US>2</span>）<span lang=EN-US> QQ</span>（如有），<span lang=EN-US>QQ</span>消息发送成功时即为有效送达； </p>

			<p class=MsoNormal>（<span lang=EN-US>3</span>）电子邮箱（如有），邮件发送成功时即为有效送达； </p>

			<p class=MsoNormal>（<span lang=EN-US>4</span>）猫咪财富提供的借款人站内短信，站内短信发送成功时即为有效送达； </p>

			<p class=MsoNormal>（<span lang=EN-US>5</span>）邮件快递：以借款人身份证（或营业执照）地址为准，收寄后三个工作日或邮件签收两者之间先到者即为有效送达；
			</p>

			<p class=MsoNormal>（<span lang=EN-US>6</span>）当面送达的，以借款人签收的书面文件中落款标明的日期为有效送达日期。</p>

			<p class=MsoNormal>借款人认可上述联络方式中任意一种接收到通知即对借款人产生法律效力。</p>

			<p class=MsoNormal>第十条:其他 </p>

			<p class=MsoNormal><span lang=EN-US>1</span>.本协议采用电子文本形式制成<span lang=EN-US>,</span>以网络点击的方式在猫咪财富签订，出借人.借款人均委托猫咪财富保管本协议。
			</p>

			<p class=MsoNormal><span lang=EN-US>2</span>.本协议自借款人在猫咪财富发布的借款标的审核成功之日即本协议题头标明的签订日起生效。
			</p>

			<p class=MsoNormal><span lang=EN-US>3</span>.借款人、出借人在履行本协议过程中，应遵守猫咪财富在网站上公开发布的在法律允许范围内的各项规则规定。</p>

			<p class=MsoNormal><span lang=EN-US>4</span>.出借人、借款人一致同意，授权或认可猫咪财富作为网络借款的中间平台，根据本协议的规定，委托
				<a name="_GoBack"></a>猫咪财富行使各项权利、发出各项通知或采取各项措施，一切法律后果和风险均由借款人或出借人承担。</p>

		</div>

</body>

</html>
