//滚动中奖信息
	var speed = 50
	window.onload = function() {
		var scrollMessage = document.getElementById("scrollMessage");
		var message_2 = document.getElementById("message_2");
		var message_1 = document.getElementById("message_1");
		message_2.innerHTML = message_1.innerHTML

		function Marquee() {
			if(scrollMessage.scrollTop >= message_1.offsetHeight) {
				scrollMessage.scrollTop = 0;
			} else {
				scrollMessage.scrollTop = scrollMessage.scrollTop + 1;
			}
		}
		var MyMar = setInterval(Marquee, speed);

	}

//中奖名单
var t = 0;
var timer1 = setInterval(function() {
	var html = $(".winners_name table tbody").html()
		$(".winners_name table tbody").html(html);
	t+=-27;
	$(".winners_name table").animate({ 'top':t + 'px' });
	
}, 1000);


$(".prize_header img").click(function(){
	return false;
})




var t = 0;
var timer1 = setInterval(function() {
	var html = $(".winner_name table tbody").html()
		$(".winner_name table tbody").html(html+'<tr><td><div class="circle"></div></td><td>151****7773</td><td>拼接</td><td>加息券：0.5%</td></tr>')
	$(".winner_name table").animate({ 'top':t + 'px' });
	t+=-33.5;
}, 1000);


function shadehide() {
	$(".prize_header img").attr(
			"src", "images/awardrotate/bg1.png"
		);
		$(".shade").hide();
		$("#img1").empty()
	
}