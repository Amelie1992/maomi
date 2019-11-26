function getBack() {
	window.location.href = $("#basePath").val() + 'scorecenter/gotoscorecenter';
}

// 计算鱼干
function countScore() {
	var money = $("#money").val();
	var score = 0;
	var filter = /^[0-9]*[1-9][0-9]*$/;
	if (!filter.test(money)) {
		money = money.substring(0, money.length - 1);
		$("#money").val(money);
		return false;
	}
	if (money.length <= 3) {
		score = parseInt(money) * 5;
	} else if (money.length == 4) {
		score = parseInt(money) * 6;
	} else if (money.length >= 5) {
		score = parseInt(money) * 8;
	}
	$("#showScore").html(score);
	$("#realMoney").val(money);
	$("#showMoney").html(money);
}

//计算鱼干
function quickCountScore(obj) {
	var score = 0;
	if(obj <= 999){
		score = parseInt(obj) * 5;
	} else if (obj > 999 && obj <= 9999) {
		score = parseInt(obj) * 6;
	} else if (obj >= 10000) {
		score = parseInt(obj) * 8;
	}
	$("#showScore").html(score);
	$("#realMoney").val(obj);
	$("#showMoney").html(obj);
	$("#money").val('');
}

//点击其他金额
function clearScore(){
	$("#showScore").html(0);
	$("#realMoney").val('');
	$("#showMoney").html(0);
	$("#money").val('');
}

function recharge() {
	var money = $("#realMoney").val();
	var score = $("#showScore").html();
	if(money == "" || money == 0){
		alert("请选择购买金额");
		return;
	}
	if(!confirm("确定花费" + money + "元购买" + score + "鱼干吗")){
		return;
	}
	layer.load();
	$.ajax({
		url : $("#basePath").val() + "integralscore/recharge",
		type: "POST",
		data : {
			money : money
		},
		success : function(data) {
			layer.closeAll();
			if (data.result == 'success') {
				alert('购买成功');
				if(typeof(data.jizi)!='undefined'){
					var zi = '';
					if(data.jizi==='1'){
						zi = '举';
					}else if(data.jizi==='2'){
						zi = '国';
					}else if(data.jizi==='3'){
						zi = '欢';
					}else if(data.jizi==='4'){
						zi = '庆';
					}
					if(confirm('意外惊喜,恭喜您在国庆集字活动中成功获得"' + zi + '"字,是否前往活动页面查看'))
					{
						window.location.href=$("#basePath").val()+'activity/s/goactivity';
					}
					else
					{
						window.location.href = $("#basePath").val()
						+ 'scorecenter/gotoscorecenter';
					}
				}else{
					window.location.href = $("#basePath").val()
					+ 'scorecenter/gotoscorecenter';
				}
				
			} else if (data.result == 'insufficient') {
				alert('余额不足');
				window.location.href = $("#basePath").val()
						+ 'recharge/rechargeInfo';
			} else if (data.result == 'miserror') {
				alert('购买金额异常');
				window.location.href = $("#basePath").val()
						+ 'recharge/rechargeInfo';
			} else if (data.result == 'error') {
				alert('付款异常');
				window.location.href = $("#basePath").val()
				+ 'scorecenter/gotoscorecenter';
			}
		}
	});
};