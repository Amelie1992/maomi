
//查看更多
function queryMore(types)
{
	if("0"==types)
	{
		window.location.href="./subject/s/querynewsubject";
	}
	else if("1"==types)
	{
		window.location.href="./subject/s/querysubject";
	}
	else if("2"==types)
	{
		window.location.href="./hotsubject/s/queryhotsubject";
	}
	else if("3"==types)
	{
		window.location.href="./subject/s/querynextsubject";
	}
	else if("4"==types)
	{
		window.location.href="./subject/s/queryhighsubject";
	}
	else if("5"==types)
	{
		window.location.href="./crowdfund/s/querycrowfund";
	}
}

//跳转充值页面
function gotorecharge(){
	window.location.href = $("#basePath").val() + 'recharge/rechargeInfo';
}

//首页立即投标
function investNow(subjectId)
{
	var form1 = document.forms['gotodetailFrm'];
	$("#id").val(subjectId)
	form1.action = './subject/detailsubject?isHome=1';
	$("#gotodetailFrm").submit();
}

//首页跳转众筹详情
function detailCrowdfund(crowdfundId)
{
	var form1 = document.forms['gotodetailFrm'];
	$("#crowdId").val(crowdfundId)
	form1.action = './crowdfund/s/detailcrowfund';
	$("#gotodetailFrm").submit();
}


//跳转页面
function toHref(rn)
{
	//邀请好友
	if(rn==-1)
	{
		window.location.href = $("#basePath").val() + 'activity.jsp';
	}
	//邀请好友
	else if(rn==1)
	{
		window.location.href = $("#basePath").val() + 'fontpage/s/queryNewUserPage';
	}
	//鱼干抽奖
	else if(rn==2)
	{
		window.location.href = $("#basePath").val() + 'awardrotate/gotoawardrotate';
	}
	//关于我们
	else if(rn==3)
	{
		window.location.href = $("#basePath").val() + 'aboutUs.jsp';
	}
	//安全保障
	else if(rn==4)
	{
		window.location.href = $("#basePath").val() + 'safetySecurity.jsp';
	}
	//高管团队
	else if(rn==5)
	{
		//window.location.href = $("#basePath").val() + 'seniorexecutivelist.jsp';
		window.location.href = $("#basePath").val() + 'loginregister/s/goCustomer';
	}
	//猫咪储蓄官
	else if(rn==6)
	{
		window.location.href = $("#basePath").val() + 'redpackage/toSavings';
	}
	//第一张轮播图
	else if(rn==11)
	{
		window.location.href = $("#basePath").val() + 'subject/s/querysubject';
	}
	//第二张轮播图
	else if(rn==12)
	{
		window.location.href = $("#basePath").val() + 'subject/s/querynewsubject';
	}
	//第三张轮播图
	else if(rn==13)
	{
		window.location.href = $("#basePath").val() + 'awardrotate/gotoawardrotate';
	}
	//第四张轮播图
	else if(rn==14)
	{
		window.location.href = $("#basePath").val() + 'freedomsubject/s/queryfreedomsubject';
	}
	//国庆活动banner
	else if(rn==15)
	{
		window.location.href = $("#basePath").val() + 'activity/s/goactivity';
	}
	//中秋活动banner
	else if(rn==16)
	{
		window.location.href = $("#basePath").val() + 'activity/s/gomidactivity';
	}
	//国庆放假通知banner
	else if(rn==17)
	{
		window.location.href = $("#basePath").val() + 'holidayinfo.jsp';
	}
	//双十一活动页面
	else if(rn==18)
	{
		window.location.href = $("#basePath").val() + 'singlesday/s/gosinglesday';
	}
	else if(rn==19)
	{
		alert("iphone手机已抢光，敬请期待下一期福利活动");
	}
	//众筹
	else if(rn==21)
	{
		window.location.href = $("#basePath").val() + 'crowdfund/s/querycrowfund';
	}
	else if(rn==20){
		window.location.href='./accountCenter/s/accountLevel';
	}
	else if(rn==22){
		window.location.href='./activity/s/twelveactivity';
	}
	//圣诞活动
	else if(rn==23){
		window.location.href='./activity/s/christmasActivity';
	}
	//元旦活动
	else if(rn==24){
		window.location.href='./activity/s/yuandanActivity';
	}
	//猫咪储蓄
	else if(rn==25){
		window.location.href='./redpackage/toSavings';
	}
	//春节活动活动
	else if(rn==26){
		window.location.href='./activity/s/springFestival';
	}
	else if(rn==27){
		window.location.href='./fontpage/s/toThreePaul';
	}
	else if(rn==28){
		window.location.href='./interestCalculator/s/toInterestCalculator';
	}
	else if(rn==29){
		window.location.href='./activity/goabroad';
	}
	else if(rn==30){
		window.location.href='./material/s/tomaterial';
	}
	else if(rn==31){
		window.location.href='./activity/s/tenone';
	}
	else if(rn==32){
		window.location.href='./activity/s/twoTwelve';
	}
	else if(rn==33){
		window.location.href=$("#basePath").val()+'new_invest_activity.jsp';
	}
}
function queryGoods(subjectId)
{
	$("#subjectId").val(subjectId);
	var form = document.forms['form1'];
	form.action = './hotsubject/detailhotdetail';
	form.submit();
}

//次日标
function investTomorrow(chooseFlag,flag)
{
	var cf="";
	if(chooseFlag==0)
	{
		cf="今日";
	}
	else
	{
		cf="明日";
	}
	alert(cf+flag+"发布");
}