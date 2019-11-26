var speed = 50
window.onload = function() {
	var DbCh = window.screen.availHeight;
	$('.content').css('height', DbCh);

	if (screen.height == 812 && screen.width == 375) {
		$('.cj-pointer').css('top', '52%');
		$('.cj-base').css('top', '75%');
		$('.cj-plant').css('top', '41.5%');
		$('.cj-snow').css('top', '80%');
		$('.tips').css('top', '90%');
	}

	var scrollMessage = document.getElementById("scrollMessage");
	var message_2 = document.getElementById("message_2");
	var message_1 = document.getElementById("message_1");
	message_2.innerHTML = message_1.innerHTML

	function Marquee() {
		if (scrollMessage.scrollTop >= message_1.offsetHeight) {
			scrollMessage.scrollTop = 0;
		} else {
			scrollMessage.scrollTop = scrollMessage.scrollTop + 1;
		}
	}
	var MyMar = setInterval(Marquee, speed);

}

$(function() {

	var rotateTimeOut = function() {
		$('.cj-plant').rotate({
			angle : 0,
			animateTo : 2160,
			duration : 8000,
			callback : function() {
				alert('网络超时，请检查您的网络设置！');
			}
		});
	};
	var bRotate = false;

	var rotateFn = function(awards, angles, txt) {
		if (awards == 0) {
			awards = 7;
		} else if (awards == 5) {
			awards = 4;
		} else if (awards == 6) {
			awards = 5;
		} else if (awards == 7) {
			awards = 6;
		}
		var result;
		var money;
		bRotate = !bRotate;
		$('.cj-plant').stopRotate();
		$('.cj-plant')
				.rotate(
						{
							angle : 0,
							animateTo : angles + 1800,
							duration : 8000,
							callback : function() {
								bRotate = !bRotate;
								if (awards != 7) {
									$.ajax({
										async : false,
										type : "POST",
										data : {
											awards : awards
										},
										dataType : "json",
										url : $("#basePath").val()
												+ "awardrotate/grantrewards",
										success : function(data) {
											money = data.money;
											if (awards == 1) {
												money = "";
											} else if (awards == 2
													|| awards == 4) {
												money = money + "元";
											} else if (awards == 3) {
												money = "1次";
											} else if (awards == 5) {
												money = parseInt(money);
											} else if (awards == 6) {
												money = money + "%";
											}
											if (data.result == "SUCCESS") {
												alert("您的" + money + txt
														+ "奖励已发放,请注意查收.");
												if (awards == 5) {
													var score = $(
															"#accountScore")
															.html();
													score = parseInt(score)
															+ parseInt(money);
													$("#accountScore").html(
															score);
												}
											} else {
												alert("抽奖系统维护中,请稍后再试");
											}
											result = data.result;
										}
									});
								} else {
									alert("很遗憾,这次没有中奖,请再接再厉哦!");
									$
											.ajax({
												url : $("#basePath").val()
														+ "awardrotate/getActivity",
												type : "POST",
												success : function(data) {
													if (data.result == 'success') {
														if (typeof (data.jizi) != 'undefined') {
															var zi = '';
															if (data.jizi === '1') {
																zi = '举';
															} else if (data.jizi === '2') {
																zi = '国';
															} else if (data.jizi === '3') {
																zi = '欢';
															} else if (data.jizi === '4') {
																zi = '庆';
															}
															if (confirm('意外惊喜,恭喜您在国庆集字活动中成功获得"'
																	+ zi
																	+ '"字,是否前往活动页面查看')) {
																window.location.href = './activity/s/goactivity';
															}

														}
													}
												}
											});
								}
								// if(result == "SUCCESS"){
								// window.location.href=$("#basePath").val()
								// +'awardrotate/gotoawardrotate';
								// }
							}
						})
	};

	$('.cj-pointer').click(function() {
		if (bRotate)
			return;
		var score = $("#usedScore").html();
		var item;
		var enough;
		var accountScore;
		$.ajax({
			async : false,
			type : "POST",
			dataType : "json",
			data : {
				usedScore : score
			},
			url : $("#basePath").val() + "awardrotate/getitem",
			success : function(data) {
				item = data.item;
				enough = data.result;
				accountScore = data.accountScore;
			}
		});
		if (enough == "FAIL") {
			alert("您的鱼干不足,无法抽奖");
			return false;
		}
		switch (item) {
		case 0:
			// var angle = [26, 88, 137, 185, 235, 287, 337];
			rotateFn(0, 337, '未中奖');
			break;
		case 1:
			// var angle = [88, 137, 185, 235, 287];
			rotateFn(1, 26, '免费提现券');
			break;
		case 2:
			// var angle = [137, 185, 235, 287];
			rotateFn(2, 88, '现金券');
			break;
		case 3:
			// var angle = [137, 185, 235, 287];
			rotateFn(3, 137, '新手标再投机会');
			break;
		case 4:
			// var angle = [185, 235, 287];
			rotateFn(4, 185, '增值券');
			break;
		case 5:
			// var angle = [185, 235, 287];
			rotateFn(5, 185, '增值券');
			break;
		case 6:
			// var angle = [235, 287];
			rotateFn(6, 235, '鱼干');
			break;
		case 7:
			// var angle = [287];
			rotateFn(7, 287, '加息券');
			break;
		}
		$("#accountScore").html(accountScore);
	});
});

// 返回
function getBack() {
	window.location.href = $("#basePath").val() + 'scorecenter/gotoscorecenter';
}

// 购买鱼干
function toBuyScore() {
	window.location.href = $("#basePath").val() + 'integralscore/toIntegral';
}

// 我的奖品
function goMyAward() {
	window.location.href = $("#basePath").val() + 'awardrotate/gotomyaward';
}