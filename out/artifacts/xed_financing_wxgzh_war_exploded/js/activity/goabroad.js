function convert(type,aType)
{
	var msg="";
	if(aType==6)
	{
		msg="奖励一经兑换无法修改，确定兑换泰国跟团游票吗？";
	}
	else if(aType==7)
	{
		msg="奖励一经兑换无法修改，确定兑换越南跟团游票吗？";
	}
	else if(aType==8)
	{
		msg="奖励一经兑换无法修改，确定将泰国跟团游票折现吗？";
	}
	else if(aType==9)
	{
		msg="奖励一经兑换无法修改，确定将越南跟团游票折现吗？";
	}
	else if(aType==0)
	{
		msg="确定给好友返现吗？";
	}
	var noInviteFriendCount=$("#noInviteFriendCount").val();
	var noGoAbroadCount=$("#noGoAbroadCount").val();
	var flag=$("#flag").val();
	if(confirm(msg))
	{
		if(type==1)
		{
			if(noGoAbroadCount>0)
			{
				var index=layer.load();
				convertIt(type,aType);
			}
			else if(noInviteFriendCount>0 && flag=="yes")
			{
				var index=layer.load();
				convertIt(type,aType);
			}
			else
			{
				alert("暂未获得出国游兑换资格");
				
			}
		}
		else
		{
			if(noInviteFriendCount>0)
			{
				var index=layer.load();
				convertIt(type,aType)
			}
			else
			{
				alert("暂未获得好友返现兑换资格");
			}
		}
	}
	
}

function convertIt(type,aType)
{
	$.ajax({
		url:"./activity/convertabroad",
		type: "POST",
		data : {
			type:type,
			aType:aType
		},
		dataType:"json",
		success:function(data){
			layer.closeAll();
			if(data.result==='success'){
				alert("兑换成功");
			}
			else if(data.result==='nochoice'){
				alert("暂未获得兑换资格");	
			}
			else if(data.result==='limit'){
				alert("出国游兑换次数已达上限");	
			}
			else
			{
				alert("系统错误");
			}
			window.location.href='./activity/goabroad';
		}
		});
}