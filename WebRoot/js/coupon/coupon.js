	//查询框
	function change(id) 
	{
		$("#couponType").val(id);
		var form2 = document.forms['form1'];
		form2.action = './coupon/querycoupon';
		form2.method = "post";
		form2.submit();
	}

	function orderBy(flag)
	{
		var form2 = document.forms['form1'];
		if(flag=="0")
		{
			$("#isUsed").val("0");
			$("#isBad").val("0");
			
		}
		else if(flag=="1")
		{
			$("#isUsed").val("1");
		}
		else if(flag=="2")
		{
			$("#isUsed").val("0");
			$("#isBad").val("1");
		}
		else if(flag=="")
		{
			$("#isUsed").val("");
		}
		form2.action = './coupon/querycoupon';
		form2.submit();
	}
	
	//立即使用
	function useNow(couponType,additionalId)
	{
		if("2"==couponType)
		{
			window.location.href='./subject/s/querynewsubject';
		}
		//现金券
		else if("3"==couponType)
		{
			if (confirm("你确认立即使用现金券吗？")) 
			{
				$.ajax({
					url:"./coupon/useCashCoupons",
					type: "POST",
					data : {
						additionalId:additionalId
					},
					success:function(data){
						if(data.result==='success'){
							alert('使用成功');
							window.location.href='./coupon/querycoupon';
						}else if(data.result==='error'){
							alert("发生错误");
						}else if(data.result==='noinvest'){
							if(confirm("请使用本金投资后使用，赶紧去投资吧！")){
								window.location.href='./subject/s/querynewsubject';
							}else{
								window.location.href='./coupon/querycoupon';
							}
						}else if(data.result==='noTime'){
							alert("双十二现金券请于2019年01月01号以后使用");
						}
					}
				});
			}
			
		}
		else if("4"==couponType)
		{
			//提现
			window.location.href='./withdraw/rechargeInfo';
		}else{
			window.location.href='./subject/s/querysubject';
		}
	}
	
	//返回
	function toBack(event)
	{
		window.location.href='./capital/querycapital';
		event.stopPropagation();
	}
	//Regional开始
	$(document).ready(function() {
		$(".Regional").click(function(event) {
			if($('.grade-eject').hasClass('grade-w-roll')) {
				$('.grade-eject').removeClass('grade-w-roll');
				$(this).removeClass('current');
				$('.screening').attr('style', ' ');
				event.stopPropagation();
				
			} else {
				$('.grade-eject').addClass('grade-w-roll');
				$(this).addClass('current');
				$(".meishi").removeClass('current');
				$(".Brand").removeClass('current');
				$(".Sort").removeClass('current');
				$('.screening').attr('style', 'position: fixed;top:0;');
				event.stopPropagation();
				
			}
		});
	});

	$('.grade-w li:nth-child(1)').click(function() {
		$('.title').text($(this).text());
		$('.grade-w li:nth-child(1) .selectBox').css('display','block');
		$('.grade-w li:nth-child(2) .selectBox').css('display','none');
		$('.grade-w li:nth-child(3) .selectBox').css('display','none');
		$('.grade-w li:nth-child(4) .selectBox').css('display','none');
		$("#myCoupon").text("我的优惠券");
	});

	$('.grade-w li:nth-child(2)').click(function() {
		$('.title').text($(this).text());
		$('.grade-w li:nth-child(1) .selectBox').css('display','none');
		$('.grade-w li:nth-child(2) .selectBox').css('display','block');
		$('.grade-w li:nth-child(3) .selectBox').css('display','none');
		$('.grade-w li:nth-child(4) .selectBox').css('display','none');
	});
	$('.grade-w li:nth-child(3)').click(function() {
		$('.title').text($(this).text());
		$('.grade-w li:nth-child(1) .selectBox').css('display','none');
		$('.grade-w li:nth-child(2) .selectBox').css('display','none');
		$('.grade-w li:nth-child(3) .selectBox').css('display','block');
		$('.grade-w li:nth-child(4) .selectBox').css('display','none');
	});

	$('.grade-w li:nth-child(4)').click(function() {
		$('.title').text($(this).text());
		$('.grade-w li:nth-child(1) .selectBox').css('display','none');
		$('.grade-w li:nth-child(2) .selectBox').css('display','none');
		$('.grade-w li:nth-child(3) .selectBox').css('display','none');
		$('.grade-w li:nth-child(4) .selectBox').css('display','block');
		
	});
	


	function grade1(wbj,couponType) {
		var arr = document.getElementById("gradew").getElementsByTagName("li");
		for(var i = 0; i < arr.length; i++) {
			var a = arr[i];
			a.style.background = "";
			a.style.color = '';
		};
		wbj.style.background = "#eee"
		wbj.style.color = "#333"
		$("#couponType").val(couponType);
		var form2 = document.forms['form1'];
		form2.action = './coupon/querycoupon';
		form2.submit();
	}

	function gradet(tbj) {
		var arr = document.getElementById("gradet").getElementsByTagName("li");
		for(var i = 0; i < arr.length; i++) {
			var a = arr[i];
			a.style.background = "";
		};
	}

	function grades(sbj) {
		var arr = document.getElementById("grades").getElementsByTagName("li");
		for(var i = 0; i < arr.length; i++) {
			var a = arr[i];
			a.style.borderBottom = "";
		};
		sbj.style.borderBottom = "solid 1px #ff7c08";
	}
	
	
	function tofuseCoupon(){
		window.location.href='./coupon/toFuseCoupon';
	}