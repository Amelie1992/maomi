<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html xmlns:v="urn:schemas-microsoft-com:vml"
xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns:m="http://schemas.microsoft.com/office/2004/12/omml"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
<base href="<%=basePath%>">
<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<title>债权转让及受让协议</title>
<style type="text/css">
	.back {
		left: 20px;
		top: 18px;
		width: 10px;
		height: 15px;
	}
	.WordSection1{
		position: relative;
	}
	.yingzhang img{
		width: 170px;
		height: 170px;
	}
	.yingzhang{
		position: absolute;
		right: 5px;
		bottom: -15px;
	}
	.mask{
		position: relative;
	}
	.name{
		position: absolute;
		z-index: 80;
		top:-3px;
		opacity: 0.6;
		left: 0px;
		width: 55px;
		height: 21px;
	}
	.fname{
		top:-3px;
		position: absolute;
		z-index: 70;
		opacity: 1;
		left: 0px;
		width: 55px;
		height: 21px;
	}
	.idcode{
		width: 180px;
		height: 21px;
		vertical-align:middle;
	}
</style>
<script type="text/javascript">
function goBack(){
	window.history.go(-1);
}
</script>
</head>

<body lang=ZH-CN style='tab-interval:21.0pt;text-justify-trim:punctuation'>
<p>
	<img src="<%=basePath%>images/back.png" class="back" onclick="goBack()" />
</p>
<div class='WordSection1' style='layout-grid:15.6pt'>

<p class=MsoNormal align=center style='text-align:center;line-height:39.0pt;
mso-pagination:widow-orphan;background:#F6F6F6'><span style='font-size:10.0pt;
font-family:宋体;mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;
mso-bidi-font-family:Arial;color:#212121;mso-font-kerning:0pt'>债权转让及受让协议</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>甲方（债权受让人）：<span class="mask"><img src="images/mask_name.png" class="name"><img src="images/mask_fname.png" class="fname" ></span></span><span lang=EN-US
style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>身份证号码：<img src="images/mask_idcard.png" class="idcode"></span><span lang=EN-US
style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>乙方（债务人）：<span class="mask"><img src="images/mask_name.png" class="name"><img src="images/mask_fname.png" class="fname" ></span></span><span lang=EN-US
style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>身份证号码：<img src="images/mask_idcard.png" class="idcode"></span><span lang=EN-US
style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>居间服务人：江苏猫儿信息科技股份有限公司</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>江苏猫儿信息科技股份有限公司（以下简称</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'>“</span><span style='font-size:10.0pt;
font-family:宋体;mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;
mso-bidi-font-family:Arial;color:#212121;mso-font-kerning:0pt'>猫咪财富</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'>”</span><span style='font-size:10.0pt;
font-family:宋体;mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;
mso-bidi-font-family:Arial;color:#212121;mso-font-kerning:0pt'>）</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span lang=EN-US style='font-size:10.0pt;
font-family:"Arial","sans-serif";mso-fareast-font-family:宋体;color:#212121;
mso-font-kerning:0pt'>1</span><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>、乙方于</span><span lang=EN-US
style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt;text-decoration:underline;'><c:if test="${type==0 }">_____________</c:if><c:if test="${type==1 }">${iBean.investTime}</c:if></span><span
style='font-size:10.0pt;font-family:宋体;mso-ascii-font-family:Arial;mso-hansi-font-family:
Arial;mso-bidi-font-family:Arial;color:#212121;mso-font-kerning:0pt'>通过猫咪财富的居间服务与借款人签订《借款协议书》并以电子数据形式存证于猫咪财富平台。乙方确认该《借款协议书》是乙方真实意思表示并有效签订的合同，且借款人已经收到乙方通过猫咪财富支付的全部出借款项，该借款协议项下的债权真实、合法、有效。</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span lang=EN-US style='font-size:10.0pt;
font-family:"Arial","sans-serif";mso-fareast-font-family:宋体;color:#212121;
mso-font-kerning:0pt'>2</span><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>、按照上述编号</span><span lang=EN-US
style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt;text-decoration:underline;'><c:if test="${type==0 }">_____________</c:if><c:if test="${type==1 }">${iBean.subjectCode}</c:if></span><span
style='font-size:10.0pt;font-family:宋体;mso-ascii-font-family:Arial;mso-hansi-font-family:
Arial;mso-bidi-font-family:Arial;color:#212121;mso-font-kerning:0pt'>《借款协议书》的约定，乙方通过猫咪财富居间服务将上述债权转让给甲方，猫咪财富根据《借款协议书》的约定完成债权转让通知及相关事宜。甲、乙双方均明确知晓并认可猫咪财富的受托权限。</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span lang=EN-US style='font-size:10.0pt;
font-family:"Arial","sans-serif";mso-fareast-font-family:宋体;color:#212121;
mso-font-kerning:0pt'>3</span><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>、甲、乙双方需按照猫咪财富平台的收费标准向其支付居间服务费、账户管理费等，甲、乙并不可撤销地确认授权猫咪财富代扣相关费用。</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span lang=EN-US style='font-size:10.0pt;
font-family:"Arial","sans-serif";mso-fareast-font-family:宋体;color:#212121;
mso-font-kerning:0pt'>4</span><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>、自甲、乙双方签署本协议及债权转让通知送达借款人后，借款人即按原《借款协议书》的约定向甲方按期还本付息。根据《借款协议书》及借款人的还款情况，转让债权的具体情况如下：</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'> &nbsp; &nbsp; <o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>借款人：</span><span lang=EN-US
style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt;text-decoration:underline;'><c:if test="${type==0 }">_____________</c:if><c:if test="${type==1 }">${sBean.userName}</c:if></span><span
style='font-size:10.0pt;font-family:宋体;mso-ascii-font-family:Arial;mso-hansi-font-family:
Arial;mso-bidi-font-family:Arial;color:#212121;mso-font-kerning:0pt'>；</span><span
style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'> </span><span style='font-size:10.0pt;
font-family:宋体;mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;
mso-bidi-font-family:Arial;color:#212121;mso-font-kerning:0pt'>债权转让本金：</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt;text-decoration:underline'><c:if test="${type==0 }">_____________</c:if><c:if test="${type==1 }">${iBean.creditMoney}</c:if></span><span style='font-size:10.0pt;font-family:宋体;mso-ascii-font-family:
Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:Arial;color:#212121;
mso-font-kerning:0pt'>元（人民币）；<br/>利率：</span><span lang=EN-US style='font-size:10.0pt;
font-family:"Arial","sans-serif";mso-fareast-font-family:宋体;color:#212121;
mso-font-kerning:0pt;text-decoration:underline;'><c:if test="${type==0 }">_____________</c:if><c:if test="${type==1 }">${iBean.creditRate}%</c:if></span><span
style='font-size:10.0pt;font-family:宋体;mso-ascii-font-family:Arial;mso-hansi-font-family:
Arial;mso-bidi-font-family:Arial;color:#212121;mso-font-kerning:0pt'>（年）；到期时间：</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt;text-decoration:underline;'><c:if test="${type==0 }">_____________</c:if><c:if test="${type==1 }">${iBean.endTime}</c:if></span></span><span
style='font-size:10.0pt;font-family:宋体;mso-ascii-font-family:Arial;mso-hansi-font-family:
Arial;mso-bidi-font-family:Arial;color:#212121;mso-font-kerning:0pt'>；</span><span
style='font-size:10.0pt;font-family:宋体;mso-ascii-font-family:Arial;mso-hansi-font-family:
Arial;mso-bidi-font-family:Arial;color:#212121;mso-font-kerning:0pt'></span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span lang=EN-US style='font-size:10.0pt;
font-family:"Arial","sans-serif";mso-fareast-font-family:宋体;color:#212121;
mso-font-kerning:0pt'>5</span><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>、借款人未按约定还款的，借款人应承担甲方或其他债权受让方为实现债权而发生的一切费用（包括但不限于诉讼费、财产保全费、律师费、差旅费、执行费、评估鉴定费、拍卖费等）。</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span lang=EN-US style='font-size:10.0pt;
font-family:"Arial","sans-serif";mso-fareast-font-family:宋体;color:#212121;
mso-font-kerning:0pt'>6</span><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>、本协议未约定内容，以猫咪财富注册协议及《借款协议书》约定为准。</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span lang=EN-US style='font-size:10.0pt;
font-family:"Arial","sans-serif";mso-fareast-font-family:宋体;color:#212121;
mso-font-kerning:0pt'>7</span><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>、凡因本协议导致诉讼的，由江苏省南京市鼓楼区人民法院管辖。</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=left style='text-align:left;line-height:21.0pt;
mso-pagination:widow-orphan'><span lang=EN-US style='font-size:10.0pt;
font-family:"Arial","sans-serif";mso-fareast-font-family:宋体;color:#212121;
mso-font-kerning:0pt'>8</span><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>、本协议由甲方、乙方在猫咪财富平台点击确认后生效。</span><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

<p class=MsoNormal align=right style='text-align:right;mso-pagination:widow-orphan'><span
lang=EN-US style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p>&nbsp;</o:p></span></p>

<div class="yifang">

<p class=MsoNormal align=right style='text-align:right;mso-pagination:widow-orphan'><a
name="_GoBack"></a><span style='font-size:10.0pt;font-family:宋体;mso-ascii-font-family:
Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:Arial;color:#212121;
mso-font-kerning:0pt'>居间服务人：江苏猫儿信息科技股份有限公司</span><span lang=EN-US
style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt'><o:p></o:p></span></p>

</div>

<p class=MsoNormal align=right style='text-align:right;line-height:21.0pt;
mso-pagination:widow-orphan'><span style='font-size:10.0pt;font-family:宋体;
mso-ascii-font-family:Arial;mso-hansi-font-family:Arial;mso-bidi-font-family:
Arial;color:#212121;mso-font-kerning:0pt'>签订时间：</span><span lang=EN-US
style='font-size:10.0pt;font-family:"Arial","sans-serif";mso-fareast-font-family:
宋体;color:#212121;mso-font-kerning:0pt;text-decoration:underline;'><c:if test="${type==0 }">_____________</c:if><c:choose><c:when test="${type==1 && iBean.dealTime!=null && iBean.dealTime!=''}">${iBean.dealTime}</c:when><c:otherwise>_____________</c:otherwise></c:choose><o:p></o:p></span></p>
<div class="yingzhang"><img src="images/gsgz.png" /></div>
</div>


</body>

</html>
