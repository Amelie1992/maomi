//全部转出
function transferAll()
{
	var m=$("#allMoney").val();
	$("#transferMoney").val(m);
}

//我要充值
function recharge()
{
	var path= $("#basePath").val();
	alert(path);
	var form = document.forms['form1'];
	form.action = path+'freedomsubject/recharge';
	form.submit();
}

//转出
function turnout()
{
	//单选框的值
	var flag =$('input:radio[name="way"]:checked').val();
	//转出金额
	var transferMoneys=$("#transferMoney").val();
	var transferMoney=parseFloat($("#transferMoney").val());
	//起投
	var freedomOriginMoney = parseFloat($("#freedomOriginMoney").val());
	//猫咪宝余额
	var allMoney = parseFloat($("#allMoney").val());
	var freedomSubjectId =$("#freedomSubjectId").val();
	if(transferMoneys=='' || transferMoneys==null)
	{
		alert("请输入转出金额");
		return;
	}
	else if(flag=='' || flag==null)
	{
		alert("请选择转出方式");
		return;
	}
	else 
	{
		if(!verifyVals(transferMoneys,"rateValue","转出金额")){
			return;
		}
	}
	if(flag =='1')
	{
		if(transferMoney<freedomOriginMoney)
		{
			alert("转出金额至少为"+freedomOriginMoney+"元");
			return;
		}
		else if(allMoney<transferMoney)
		{
			alert("猫咪宝余额不足");
			return;
		}
		else
		{
			//提交后台 修改可用金额 猫咪宝金额
			if(confirm("您的"+transferMoney+"元猫咪宝将直接转出到可用余额，是否确定？"))
			{
				$.ajax({
					type : "POST",
					url : $("#basePath").val() + "freedomsubject/transferfreedom",
					data : {
						money : transferMoney,
						freedomSubjectId:freedomSubjectId
					},
					success : function(data) {
						if (data.result === 'success') {
							alert("转出成功");
							// 刷新页面
							window.location.href = $("#basePath").val()+ 'freedomsubject/toMyFreedom';
						}
						else if(data.result === 'errorstart')
						{
							alert("猫咪宝至少转出1元");
						}
						else if(data.result === 'notEnough')
						{
							alert("猫咪宝余额不足");
						}
						else
						{
							alert("转出失败");
						}
					}
				});
			}
		}
	}
	else if(flag =='2')
	{
		if(transferMoney<50)
		{
			alert("转出到银行卡至少50元");
			return;
		}
		else
		{
			var form = document.forms['form1'];
			form.action = $("#basePath").val()+ 'freedomsubject/recharge';
			$("#inputMoney").val(transferMoney);
			//跳转提现页面
			form.submit();
		}
	}
}

//返回
function goBack()
{
	window.location.href= $("#basePath").val()+"freedomsubject/toMyFreedom";
}