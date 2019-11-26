
	function scrollToEnd() { 
		var h = $(document).height() - $(window).height();
		$(document).scrollTop(h);
	}

	function openPocket(rn)
	{
		if(rn=='1')
		{
			//旋转
			//获取图片
			var oPointer = $("#rotare1");
			var oTurntable = $("#rotare1");
			//保证不重复点击
			var offOn = true;
			//记录旋转过的角度
				if(offOn) {
					offOn = !offOn;
					oTurntable.css({
						transition: "all 2s",
						transform: "rotateY(" + 1800 + "deg)"
					});
					//得出奖项,延时出结果
					setTimeout(function() {
						$('#rotare1').attr('src', 'images/wx-gq-openbag.png');
						$('#bag1').css('display', 'block');
					}, 2000);
				}
		}
		else if(rn=='2')
		{
			var oPointer = $("#rotare2");
			var oTurntable = $("#rotare2");
			//保证不重复点击
			var offOn = true;
			//记录旋转过的角度
				if(offOn) {
					offOn = !offOn;
					oTurntable.css({
						transition: "all 2s",
						transform: "rotateY(" + 1800 + "deg)"
					});
					//得出奖项,延时出结果
					setTimeout(function() {
						$('#rotare2').attr('src', 'images/wx-gq-openbag.png');
						$('#bag2').css('display', 'block');
					}, 2000);
				}
		}
		else if(rn=='3')
		{
			if(confirm("很遗憾，您还未满足投资条件，是否现在立即投标"))
			{
				window.location.href='./subject/s/queryhighsubject';
			}
		}
		else if(rn=='4')
		{
			if(confirm("很遗憾，您还未满足满签条件，是否现在签到"))
			{
				window.location.href='./signin/toSignIn';
			}
		}
	}
		//集字兑换28元现金券
		function grantrewards(){
			var path= $("#basePath").val();
			$.ajax({
				url:"./activity/grantrewards",
				type: "POST",
				success:function(data){
					var a =  eval('('+data+')');
					if(a.result==='error'){
						alert('系统异常');
					}else if(a.result==='success'){
						if(confirm('兑换成功,28元现金券已发送至您的账户,是否点击\"我的优惠券\"查看'))
						{
							window.location.href='./coupon/querycoupon';
						}
						else
						{
							window.location.href='./activity/s/goactivity';
						}
						
					}else if(a.result==='lack'){
						alert('未集齐,请继续努力');
					}
				}
			});
		}