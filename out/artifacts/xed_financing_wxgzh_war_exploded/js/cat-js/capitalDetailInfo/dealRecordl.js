//返回
	function backMyCenter(){
		window.location.href="./capital/querycapital";
	}
	
	function Flag(thisth,type) {
		$('.filtrate th').each(function(index, obj){
			$(obj).removeClass('currentChose_head');
		});
		$(thisth).addClass('currentChose_head');
		$.ajax({
			url: "./capitaldetail/getTypeQurey",
			type: "POST",
			data : {
				type : type
			},
			success : function(data) {
				var a = eval(data);
				var str = "";
				$(a).each(function(index, obj) {
					var ss = "";
					var inExpend = "";
					if (obj.type == '0') {
						ss = "储蓄卡充值";
					} else if (obj.type == '1') {
						ss = "微信充值";
					} else if (obj.type == '2') {
						ss = "信用卡充值";
					} else if (obj.type == '3') {
						ss = "投资投标";
					} else if (obj.type == '4') {
						ss = "投资收益";
					} else if (obj.type == '5') {
						ss = "提现";
					} else if (obj.type == '6') {
						ss = "债权转出";
					} else if (obj.type == '7') {
						ss = "债权接收";
					} else if (obj.type == '8') {
						ss = "爆款退款";
					} else if (obj.type == '9') {
						ss = "投资结算";
					} else if (obj.type == '10'){
						ss = "活动获取";
					} else if (obj.type == '11'){
						ss = "购买鱼干";
					} else if (obj.type == '12'){
						ss = "猫咪宝转入";
					} else if (obj.type == '13'){
						ss = "猫咪宝转出";
					} else if (obj.type == '14'){
						ss = "猫咪宝收益";
					} else if (obj.type == '15'){
						ss = "猫咪宝提现";
					}  else if(obj.type == '16'){
						ss = "工资发放";
					}  else if(obj.type == '17'){
						ss = "邀请好友奖励";
					}  else if(obj.type == '18'){
						ss = "投资众筹";
					}  else if(obj.type == '19'){
						ss = "猫咪储蓄提取";
					}  else if(obj.type == '20'){
						ss = "利息管理费";
					}  else if(obj.type == '21'){
						ss = "提现手续费";
					}
					if (obj.inExpend == '0') {
						str += "<li><div class='content_detail_left income'>+"+obj.money+"</div>";
					} else if (obj.inExpend == '1') {
						str += "<li><div class='content_detail_left expend'>-"+obj.money+"</div>";
					}
					str += "<div class='content_detail_right'><p class='contentName'>"
						+ ss
						+ "</p><p class='contentTime'>"+obj.dealTime+"</p></div></li>";
				});
				str += "";
				$(".content ul").html(str);
			}
		});
	}