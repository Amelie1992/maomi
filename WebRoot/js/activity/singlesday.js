function receiveCoupon()
{
	$.ajax({
		type:"POST",
		url:"./singlesday/sendcoupon",
		success:function(data){
			if(data.result==='success'){
				alert("领取成功！");
				window.location.href='./singlesday/s/gosinglesday';
			}
			else if(data.result==='noreward'){
				alert("未获得领取资格！");
				window.location.href='./singlesday/s/gosinglesday';
			}
			else if(data.result==='isHave'){
				alert("已领取过奖励！");
				window.location.href='./singlesday/s/gosinglesday';
			}
		}
	});
}

function lookQualifications(flag)
{
	var form = document.forms['form1'];
	$("#goodId").val(flag)
	form.action = './singlesday/s/buyiphone';
	form.submit();
}