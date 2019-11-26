layui.use('element', function() {
	var $ = layui.jquery, element = layui.element;
});
$('.jxq').click(function() {
	
	if (!$(this).hasClass("jxq-selected")) {
		if($('.jxq-selected').size()>=10){
			alert('融合优惠券数量不能超过10张');
			return;
		}
		$(this).addClass("jxq-selected");
		$(this).children(".checkIcon").attr('src', 'images/hc-check.png');
	} else {
		$(this).removeClass("jxq-selected");
		$(this).children(".checkIcon").attr('src', 'images/hc-check-before.png');
	}
	settlement(1);
});
$('.zzq').click(function() {
	
	if (!$(this).hasClass("zzq-selected")) {
		if($('.zzq-selected').size()>=10){
			alert('融合优惠券数量不能超过10张');
			return;
		}
		$(this).addClass("zzq-selected");
		$(this).children(".checkIcon").attr('src', 'images/hc-check.png');
	} else {
		$(this).removeClass("zzq-selected");
		$(this).children(".checkIcon").attr('src', 'images/hc-check-before.png');
	}
	settlement(0);
});

//计算
function settlement(type){
	if(type==0){
		//增值券
		var couponMoney = parseInt(0);
		$('.zzq-selected').each(function(i,o){
			couponMoney += parseFloat($(o).find(".couponMoney").text());
		});
		couponMoney = parseFloat(couponMoney*0.9);
		if(couponMoney>1000){
			couponMoney = 1000;
		}
		$('#result').html(couponMoney);
	}else{
		//加息券
		var couponMoney = parseInt(0);
		$('.jxq-selected').each(function(i,o){
			couponMoney += parseInt($(o).find(".couponMoney").text()*100);
		});
		couponMoney = couponMoney*90;
		couponMoney = parseFloat(couponMoney/10000);
		if(couponMoney>2){
			couponMoney=2
		}
		$('#result').html(couponMoney);
	}
}

//切换
function choose(type){
	var str ='';
	if(type==0){
		//增值券
		$('.jxq-selected').each(function(i,o){
			$(o).removeClass("jxq-selected");
			$(o).children(".checkIcon").attr('src', 'images/hc-check.png');
		});
		str = '<th><span class="yhq-tips">¥</span><span id="result">0.0</span></th>'+
				'<th class="yhq-type">增值券</th>'+
				'<th></th>';
	}else{
		//加息券
		$('.zzq-selected').each(function(i,o){
			$(o).removeClass("zzq-selected");
			$(o).children(".checkIcon").attr('src', 'images/hc-check.png');
		});
		str = '<th><span id="result">0.0</span><span class="yhq-tips">%</span></th>'+
		'<th class="yhq-type">加息券</th>'+
		'<th></th>';
	}
	
	$('#choose').html(str);
	
}
$('.scsfzzp').find('input[name="scsfzzp"]').each(function(index,dom){
	scsfzzp.push($(dom).val());
});

function composeCoupon(){
	var couponId = new Array();
	var couponType = '';
	if($('.zzq-selected').size()>4){
		$('.zzq-selected').each(function(i,o){
			couponId.push($(o).find('input[name="additionalId"]').val());
		});
		couponType = '0';
	}else if($('.jxq-selected').size()>4){
		$('.jxq-selected').each(function(i,o){
			couponId.push($(o).find('input[name="additionalId"]').val());
		});
		couponType = '1';
	}else{
		alert('融合最少需要5张优惠券');
		return;
	}
	if(confirm('是否确认合成？')){
		$.ajax({
			type: "POST",
			url: './coupon/fuseCoupon',
			data: { 
				'couponId' : couponId,
				'couponType' : couponType
				},
			dataType:'json',
			async: false,
			error: function(request) {
				alert("系统异常");
			},
			success: function(data) {
				if(data.result=="success"){
					alert("合成成功!");
					window.location.href='./coupon/toFuseCoupon';
				}else if(data.result=="notEnoughNumber"){
					alert("可融合次数不足!");
					window.location.href='./coupon/toFuseCoupon';
				}else if(data.result=="notEnoughCount"){
					alert("优惠券个数不正确!");
					window.location.href='./coupon/toFuseCoupon';
				}else if(data.result=="notEnoughScore"){
					alert("鱼干数量不足!");
					window.location.href='./coupon/toFuseCoupon';
				}else if(data.result=="notAgree"){
					alert("有已使用或已过期的优惠券!");
					window.location.href='./coupon/toFuseCoupon';
				}
			}
		});
	}
};
	
function toCouponRule()
{
	window.location.href='./accountCenter/s/todetail?m=kqrh';
}
