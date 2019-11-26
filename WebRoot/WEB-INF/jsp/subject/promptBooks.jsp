<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="css/reset.css"/>
<title>猫咪财富--网络借贷风险及禁止性行为提示书</title>
		<style type="text/css">
			.wrap{
				padding: 10px;
			}
			.wrap h1{
				font-size: 16px;
				font-weight: bold;
				text-align: center;
				padding: 10px 0;
			}
			.wrap div{
				margin: 10px auto;
				text-indent: 25px;
			}
			.wrap div ul li{
				line-height: 22px;
				font-size: 12px;
				
			}
			.title {
				width: 100%;
				position: relative;
				text-align: center;
				font-size: 20px;
				color: red;
				font-weight: 600;
				height: 50px;
				line-height: 50px;
			}
			
			.back {
				position: absolute;
				left: 20px;
				top: 20px;
				width: 10px;
				height: 15px;
			}
		</style>

</head>
<body>
<div class="wrap">
			<div class="title">
					<img src="images/back.png" class="back" onclick="toBack()"/>说明书
			</div>
			<h1>
				尊敬的猫咪财富用户，您好！
			</h1>
			<div>
				<ul>
					<li>恭喜您成为猫咪财富平台的注册用户。猫咪财富是由江苏猫儿信息科技股份有限公司运营的网络借贷中介服务平台，您可根据您的资金出借需求，自愿选择通过猫咪财富平台进行资金出借，以期获得相应预期收益。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>当您点击“立即投资”、“确认”、“同意”、“购买”或其他类似含义的选项时，即视为您已经充分理解并确认《网络借贷风险和禁止性行为提示书》和《资金来源合法承诺书》的相关内容，对您出借资金来源的合法性作出保证性承诺，并自愿承担网络借贷所产生的相应风险。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>一、网络借贷风险提示：在您通过猫咪财富平台进行资金出借的过程中，也许会面临以下可能导致您出借资金及收益受损的各种风险。请您在进行资金出借前仔细阅读以下内容，了解融资项目信贷风险，确保自身具备相应的投资风险意识、风险认知能力、风险识别能力和风险承受能力，拥有非保本类金融产品投资的经历并熟悉互联网，并请您根据自身的风险承受能力选择是否出借资金及出借资金的数额。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	1. 法律及监管风险：因许多法律和法规相对较新且可能发生变化，相关官方解释和执行可能存在较大不确定性等因素引起的风险。有些新制定的法律、法规或修正案的生效可能被延迟；有些新颁布或生效的法律法规可能具有追溯力从而对您的投资利益造成不利影响。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	2. 政策风险：因国家宏观政策、财政政策、货币政策、监管导向、行业政策、地区发展政策等因素引起的风险。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	3. 市场风险：因市场资金面紧张或利率波动、行业不景气、企业效益下滑等因素引起的风险。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	4. 借款人信用风险：针对平台上的债权，猫咪财富仅在债权形成前对借款人的借款需求及相关信息进行必要审核，但是猫咪财富不对借款人的还款能力做出任何明示或默示的担保或保证，并且如果发生债权转让，猫咪财富不会在债权转让时再次对借款人进行信用审核，您受让的债权可能在其受让前已经存在逾期情况。当借款人因收入情况、财产状况发生变化、人身出现意外、发生疾病、死亡等情况，短期或者长期丧失还款能力，或者借款人的还款意愿发生变化时，您的出借资金可能无法按时回收甚至无法回收，您的预期收益可能无法实现。猫咪财富没有义务对逾期的本息以及费用进行垫付或未经委托对借款人进行追索。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	5. 资金流动性风险：针对您的出借本金或者回款再出借资金，猫咪财富会根据网络借贷相关协议约定积极协助您寻找、推荐借款人，以完成资金出借、获取收益之目的，但猫咪财富寻找、推荐借款人的时间存在一定不确定性。同时，猫咪财富将根据网络借贷相关协议约定在您提出需要时，努力帮助您寻找、向您推荐愿意受让债权的第三方，以完成您的债权转让，但猫咪财富不对债权转让的实现以及实现时间做出任何承诺和保证。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	6. 技术风险：由于无法控制和不可预测的系统故障、设备故障、通讯故障、电力故障、网络故障、黑客或计算机病毒攻击、以及其它因素，可能导致平台出现非正常运行或者瘫痪，由此导致您无法及时进行查询、充值、出借、提现等操作。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	7. 不可抗力风险：由于战争、动乱、自然灾害等不可抗力因素的出现而可能导致您出借资金损失的风险。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>二、网络借贷禁止性行为提示：猫咪财富平台作为网络借贷信息中介平台，将严格依据《网络借贷信息中介机构业务活动管理暂行办法》的规定，不予从事或者接受委托从事下列活动，请您知悉并共同进行监督：</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	1. 为自身或变相为自身融资；</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	2. 直接或间接接受、归集出借人的资金；</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	3. 直接或变相向出借人提供担保或者承诺保本保息；</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	4. 自行或委托、授权第三方在互联网、固定电话、移动电话等电子渠道以外的物理场所进行宣传或推介融资项目；</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	5. 发放贷款，但法律法规另有规定的除外；</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	6. 将融资项目的期限进行拆分；</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	7. 自行发售理财等金融产品募集资金，代销银行理财、券商资管、基金、保险或信托产品等金融产品；</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	8. 开展类资产证券化业务或实现以打包资产、证券化资产、信托资产、基金份额等形式的债权转让行为；</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	9. 除法律法规和网络借贷有关监管规定允许外，与其他机构投资、代理销售、经纪等业务进行任何形式的混合、捆绑、代理；</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	10. 虚构、夸大融资项目的真实性、收益前景，隐瞒融资项目的瑕疵及风险，以歧义性语言或其他欺骗性手段等进行虚假片面宣传或促销等，捏造、散布虚假信息或不完整信息损害他人商业信誉，误导出借人或借款人；</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	11. 向借款用途为投资股票、场外配资、期货合约、结构化产品及其他衍生品等高风险的融资提供信息中介服务；</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	12. 从事股权众筹等业务。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>•	13. 洗钱、信用卡套现、虚假交易等行为。</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>“本人已经阅读《网络借贷风险和禁止性行为提示书》的所有内容，充分了解并清楚知晓相应的权利义务，并愿意承担相关风险及法律后果。”</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>风险提示方：江苏猫儿信息科技股份有限公司【猫咪财富】</li>
				</ul>
			</div>
		</div>
</body>
<script type="text/javascript">
function toBack()
{
	window.history.back(-1); 
}
</script>
</html>