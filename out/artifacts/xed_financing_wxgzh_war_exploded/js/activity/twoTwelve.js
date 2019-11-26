$(function(){
		var cout=$("#cout").val();
		if(cout>0)
		{
			$("#item"+cout).addClass("item-su");
			$("#item"+cout).text("已满足");
			$("#item"+cout).attr("onclick","convert();")
			
		}
	});
	function convert() {
		layer.msg("已满足领取条件,奖励将于活动结束后三天内统一发放完毕");
	}
	function querySubject() {
		window.location.href='./subject/s/querysubject';
	}