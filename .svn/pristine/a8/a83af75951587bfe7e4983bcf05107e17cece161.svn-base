
//<script src="js/layer/layer.js"></script>

//检查是否金账户开户
$(function(){
	layer.load();
	$.ajax({
		url : "./accountinfo/checkGold",
		type : "POST",
		dataType : 'json',
		success : function(data) {
			layer.closeAll();
			if (data.result === 'error') {
				alert('绑定身份信息不正确，或身份信息已绑定过，请联系客服');
				window.location.href = './kefu.jsp';
			} else if (data.result === 'noRealName') {
				alert("请先实名认证");
				window.location.href = './recharge/rechargeInfo';
			} else if (data.result === 'noBankCard') {
				alert("请先绑定银行卡");
				window.location.href = './recharge/rechargeInfo';
			}
		}
	});
});

