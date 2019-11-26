//全部投资
function investAll()
{
	var availableBalance=$("#availableBalance").val();
	if(parseFloat(availableBalance)>=5000)
	{
		availableBalance=5000;
	}
	$("#imoney").val(availableBalance);
}
function toRecharge(){
	window.location.href='./recharge/rechargeInfo';
}
//返回
function goBack(type)
{
	if(type==1)
	{
		var form = document.forms['form1'];
		form.action = './freedomsubject/s/detailfreedomsubject';
		form.submit();
	}
	else if(type ==2)
	{
		window.location.href="./freedomsubject/toMyFreedom";
	}
	
}

//确认转入
function turnInMoney(id)
{
	var path= $("#basePath").val();
	var imoney = $("#imoney").val();
	//限投
	var limitMoney = parseFloat($("#limitMoney").val());
	//起投
	var freedomOriginMoney = parseFloat($("#freedomOriginMoney").val());
	//剩余
	var freedomSurplusMoney = parseFloat($("#freedomSurplusMoney").val());
	var todayLimitMoney=parseFloat($("#todayLimitMoney").val());
	var todayAllMoney=parseFloat($("#todayAllMoney").val());
	var imoneys=parseFloat($("#imoney").val());
	if(null ==imoney || ''==imoney)
	{
		if(imoney=="" || imoney==null)
		{
			alert("请输入转入金额");	
			return;
		}
	}
	else 
	{
		if(!verifyVals(imoney,"rateValue","转入金额")){
			return;
		}
	}
	
	if(imoneys<freedomOriginMoney)
	{
		alert("转入金额至少为"+freedomOriginMoney+"元");
		return;
	}
	else if(imoneys>limitMoney)
	{
		alert("单笔限投"+limitMoney+"元");
		return;
	}
	else if((todayAllMoney+imoneys)>todayLimitMoney)
	{
		alert("当日限投"+todayLimitMoney+"元");
	}
	else if((freedomSurplusMoney-imoneys)<0)
	{
		alert("猫咪宝剩余额度不足");
		return;
	}
	else
	{
		if(confirm("您确认立即转入猫咪宝吗？")) 
		{
			$.ajax({
				url:path+"freedomsubject/checkMoney",
				type: "POST",
				data : {
					freedomSubjectId:id,
					money:imoney
				},
				success:function(data){
					if(data.result==='success'){
						alert("猫咪宝转入成功！");
						window.location.href=path+'freedomsubject/s/queryfreedomsubject';
					}
					
					else if(data.result==='errornull')
					{
						alert("转入金额不能为空！");
					}
					else if(data.result==='errormoney')
					{
						if(confirm("余额不足，是否充值"))
						{
							window.location.href=path+'recharge/rechargeInfo';
						}	
					}
					else if(data.result==='errorsurplus')
					{
						alert("猫咪宝剩余额度不足！");
					}
					else if(data.result==='errorstart')
					{
						alert("转入金额不能低于起投金额！");
					}
					else if(data.result==='errorend')
					{
						alert("单笔限投"+limitMoney+"元！");
					}
					else if(data.result==='errorlimittoday')
					{
						alert("当日限投"+todayLimitMoney+"元");
					}
				}
			});
		}
	}
	
}