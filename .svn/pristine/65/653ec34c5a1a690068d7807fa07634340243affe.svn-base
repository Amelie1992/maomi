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
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/validate.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layer/layer.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/activity/midMoon.css" />

<title>中秋月饼大作战</title>


</head>

<body>
<div class="wrap">
			<!--<img src="images/wx-zqj-bg.png"/>-->
			<div class="title">
				<img src="images/activity/midmoon/wx-zqj-title.png" />
			</div>
			<div class="count-tips">
				您已有月饼：<span>${mcount }</span>个
			</div>
			<div class="getYb">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th>
							<a href="<%=basePath%>subject/s/querysubject"><img src="images/activity/midmoon/wx-zqj-tzbtn.png" /></a>
						</th>
						<th><img src="images/activity/midmoon/wx-zqj-ckdhjl.png" class="checkrecord" onclick="toDetailMoon()"/></th>
					</tr>
				</table>
			</div>
			<div class="items">
				<div class="item">
					<img src="images/activity/midmoon/wx-zqj-10xjq.png" class="item-p"/>
					<p>10元现金券</p>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>中秋价：</th>
							<th class="item-tips">1个月饼</th>
							<th>
								<a onclick="convertMoon(5)"><img src="images/activity/midmoon/wx-zqj-dhbtn.png" /></a>
							</th>
						</tr>
					</table>
				</div>
				<div class="item">
					<img src="images/activity/midmoon/wx-zqj-100xjq.png" class="item-p"/>
					<p>100元现金券</p>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>中秋价：</th>
							<th class="item-tips">3个月饼</th>
							<th>
								<a onclick="convertMoon(6)"><img src="images/activity/midmoon/wx-zqj-dhbtn.png" /></a>
							</th>
						</tr>
					</table>
				</div>
				<div class="item">
					<img src="images/activity/midmoon/wx-zqj-yb.png" style="width: 86px;height: 78px;" class="item-p"/>
					<p>价值300元的月饼</p>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>中秋价：</th>
							<th class="item-tips">5个月饼</th>
							<th>
								<a onclick="convertMoon(7)"><img src="images/activity/midmoon/wx-zqj-dhbtn.png" /></a>
							</th>
						</tr>
					</table>
				</div>
				<div class="item">
					<img src="images/activity/midmoon/wx-zqj-jhq.png" style="width: 38px;margin-top: 7.5px;" class="item-p" id="item1"/>
					<p>价值900元的小米空气净化器</p>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>中秋价：</th>
							<th class="item-tips">10个月饼</th>
							<th>
								<a onclick="convertMoon(8)"><img src="images/activity/midmoon/wx-zqj-dhbtn.png" /></a>
							</th>
						</tr>
					</table>
				</div>
				<div class="item">
					<img src="images/activity/midmoon/wx-zqj-xm8.png" style="width: 79px;margin-top: 7.5px;" class="item-p" id="item2"/>
					<p>小米8 64G 2599</p>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>中秋价：</th>
							<th class="item-tips">20个月饼</th>
							<th>
								<a onclick="convertMoon(9)"><img src="images/activity/midmoon/wx-zqj-dhbtn.png" /></a>
							</th>
						</tr>
					</table>
				</div>
				<div class="item">
					<img src="images/activity/midmoon/wx-zqj-xm8.png" style="width: 79px;margin-top: 7.5px;" class="item-p" id="item3"/>
					<p>iphone8 64G 4488元</p>
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>中秋价：</th>
							<th class="item-tips">30个月饼</th>
							<th>
								<a onclick="convertMoon(10)"><img src="images/activity/midmoon/wx-zqj-dhbtn.png" /></a>
							</th>
						</tr>
					</table>
				</div>
				<div class="item-l">
					<table border="0" cellspacing="" cellpadding="">
						<tr>
							<th>
								<img src="images/activity/midmoon/wx-zqj-ipx.png" style="width: 66px;height: 133px;margin-top: 17px;" />
							</th>
							<th>
								<p>iphoneX 256G </p>
								<p style="color: #fef100;font-size: 16px;padding: 10px 0;">月饼大作战 好礼兑不停</p>
								<p style="color: #FFFFFF;font-size: 12px;text-align: right;margin-top: 15px;">日常价：￥8188</p>
								<p style="text-align: right;"><img src="images/activity/midmoon/wx-zqj-line.png" style="width: 66px;margin-right: 20px;" /></p>
								<p>中秋价：<span style="color: #FEF100;">45个月饼</span><span><a onclick="convertMoon(5)"><img src="images/activity/midmoon/wx-zqj-dhbtn.png" style="width: 46px;position: relative;top: 5px;margin-left: 10px;"/></a></span></p>
							</th>
						</tr>
					</table>
				</div>
			</div>
			<div class="tips-title">
				<img src="images/activity/midmoon/wx-zqj-label.png" />
				<div class="rule-tips">
					<dl>
						<dt>一、月饼获得条件</dt>
						<dd>1.活动期间单次投资满5000元，且投标期限满3个月，即可获得月饼1个</dd>
						<dd>2.活动期间单次投资满20000元，且投标期限满3个月，即可获得月饼5个</dd>
						<dd>3.活动期间满足全部签到即可获得月饼一个
							<a href="<%=basePath%>signin/toSignIn">点击签到</a>
						</dd>
						<dd>4.活动期间鱼干抽奖新增月饼奖项，中奖概率为4%
							<a href="<%=basePath%>awardrotate/gotoawardrotate">点击抽奖</a>
						</dd>
						<dd>5.活动期间邀请新用户注册、实名、绑卡并有效投资，双方均可获得所投金额对应月饼奖励。(有效投资为：被邀请人首次投资，且所投标的满3个月，金额满5000元或20000元，每个被邀请人仅限首投)
							<a href="<%=basePath%>loginregister/invitingfriends">邀请好友</a>
						</dd>
						<dt>二、活动规则</dt>
						<dd>1.此次活动时间为2018年9月21日至2018年9月28日截止。</dd>
						<dd>2.此次活动获得的月饼均不可赠送，在活动后3天内未兑换奖励的月饼将会清零。</dd>
						<dd>3.此次活动兑换的实物奖励均在活动结束后的3-10个工作日内寄出。</dd>
						<dd>4.此次活动兑换的实物奖励可根据实物总价值的7折，折现成现金券，该现金券在活动结束后的1-3个工作日内发放至用户个人中心优惠券内。</dd>
						<dd>5.此次签到活动只有满签才能获得奖励，VIP特权用户可补签。</dd>
						<dd>6.此次活动投资如满足5000元条件，即可获得1个月饼奖励。如满足20000元条件，即可获得5个月饼奖励。按所获奖励条件最大值奖励月饼。</dd>
						<dd>7.自动投标投资的标的不参加本次活动。</dd>
						<dd>8.本次活动最终解释权归猫咪财富所有，如有疑问请联系猫咪财富客服。</dd>
					</dl>
				</div>
			</div>			
		</div>
</body>
<script type="text/javascript">
	function toubiao() {
		window.location.href='<%=basePath%>subject/s/querysubject';
	}
	function toDetailMoon()
	{
		window.location.href='<%=basePath%>material/tomaterialdetail';
	}
	function convertMoon(type)
	{
			layer.confirm("确定立即兑换吗？",function(){
			var index=layer.load();
			$.ajax({
				type : "POST",
				url:"<%=basePath%>material/convertmoon",
				data : {
					type:type
				},
				dataType:"json",
				error:function(request)
				{
					layer.closeAll();
					layer.alert("月饼不足！");
				},
				success:function(data){
					layer.closeAll();
					if(data.result==='success'){
						layer.alert("兑换成功",{icon:6},function(index){
							layer.close(index);	
							window.location.href='./material/s/tomaterial';
						});
					}
					else if(data.result==='lowmoon')
					{
						layer.alert("月饼不足",{icon:5},function(index){
							layer.close(index);	
							window.location.href='./material/s/tomaterial';
						});
					}
					else
					{
						layer.alert("系统错误",{icon:5},function(index){
							layer.close(index);	
							window.location.href='./material/s/tomaterial';
						});
					}
				}
			});
		});
	}
</script>
</html>
