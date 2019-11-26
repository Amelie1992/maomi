function minNum()
{
	var num = parseInt($("#shownum").text());
	var eachMoney=parseInt($("#eachMoney").val());
	
	if(num == 1)
	{
		$("#shownum").html(1);
	}
	else
	{
		$("#shownum").html(num - 1);
		$("#totalMoney").html(eachMoney * (num - 1));
	}
}

function addNum()
{
	var num = parseInt($("#shownum").text());
	var eachMoney=parseInt($("#eachMoney").val());
	var maxEach=parseInt($("#maxEach").val());
	if(num>=maxEach)
	{
		$("#shownum").html(num);
	}
	else
	{
		$("#shownum").html(num + 1);
		$("#totalMoney").html(eachMoney * (num + 1));
	}
}

function investCrowdfund(crowdId)
{
	var num = parseInt($("#shownum").text());
	if(confirm("确定立即参与众筹吗？"))
	{
		var index=layer.load();
		$.ajax({
			url:"./crowdfund/buycrowfund",
			type: "POST",
			data : {
				nums:num,
				crowdId:crowdId
			},
			success:function(data){
				layer.closeAll();
				if(data.result==='success')
				{
					alert("成功参与众筹");
					window.location.href='./capital/querycapital'
				}
				else if(data.result==='overactivity')
				{
					alert("众筹已结束");
				}
				else if(data.result==='nostarted')
				{
					alert("众筹还未结束");
				}
				else if(data.result==='overlimit')
				{
					alert("已达到购买上限");
				}
				else if(data.result==='overmoney')
				{
					alert("余额不足");
				}
				else{
					alert("系统错误");
				}
				
			}
			});
	}
}