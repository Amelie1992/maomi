

//详情
function investX(type)
{
	if(type==0)
	{
		if(confirm("用户未登录，是否现在登录？")) 
		{
			window.location.href="./loginregister/s/toLogin";
		}
	}
	else
	{
		$("#type").val(type);	
		var form = document.forms['form1'];
		form.action = './activity/s/detailtwelveactivity';
		form.submit();
	}
}

//立即投标 ajax提交
function investNow(type)
{
	var color=$("#color").val();
	if(type==0)
	{
		if(confirm("用户未登录，是否现在登录？")) 
		{
			window.location.href="./loginregister/s/toLogin"
		}
	}
	else
	{
		if(confirm("您确认立即投资吗？")) 
		{
			var msg=",您是企业用户首次投标，将获得28元奖励金到您银行卡，1~3个工作日到账";
			var amsg="";
			$.ajax({
				url:"./activity/paytwelve",
				type: "POST",
				data : {
					type:type,
					color:color
				},
				success:function(data){
					if(data.result==='twelveActivity')
					{
						if(data.flag==='isflag')
						{
							alert("投资成功"+msg);
						}
						else if(data.flag==='errorflag')
						{
							alert("投资成功");
						}
						window.location.href='./activity/s/twelveactivity';
					}
					else if(data.result==='errorcount')
					{
						alert("iphoneX不足");
						window.location.href='./activity/s/twelveactivity';
					}
					else if(data.result==='errorLow')
					{
						alert("余额不足，是否充值");
						window.location.href='./recharge/rechargeInfo';
					}
					else if(data.result==='errorsys')
					{
						alert("违规操作");
						window.location.href='./activity/s/twelveactivity';
					}else if(data.result==='notbegin'){
						alert("活动未开始");	
						window.location.href='./activity/s/twelveactivity';
					}else if(data.result==='isend'){
						alert("活动结束");	
						window.location.href='./activity/s/twelveactivity';
					}
				}
				});
		}
	}
}