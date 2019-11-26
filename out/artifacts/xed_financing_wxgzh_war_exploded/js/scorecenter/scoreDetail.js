//返回
	function backScoreCenter(){
		window.location.href=$("#basePath").val() + "scorecenter/gotoscorecenter";
	}
	
	function Flag(thisth,type) {
		$('.filtrate th').each(function(index, obj){
			$(obj).removeClass('currentChose_head');
		});
		$(thisth).addClass('currentChose_head');
		$.ajax({
			url: $("#basePath").val() + "scorecenter/getTypeQurey",
			type: "POST",
			data : {
				type : type
			},
			dataType : "json",
			success : function(data) {
				var str = "";
				for(var i = 0;i < data.typeList.length;i++){
					var ss = "";
					var inExpend = "";
					if (data.typeList[i].scoreType == '0') {
						ss = "签到";
					} else if (data.typeList[i].scoreType == '1') {
						ss = "完善信息";
					} else if (data.typeList[i].scoreType == '2') {
						ss = "投标奖励";
					} else if (data.typeList[i].scoreType == '3') {
						ss = "鱼干兑换";
					} else if (data.typeList[i].scoreType == '4') {
						ss = "鱼干抽奖";
					} else if (data.typeList[i].scoreType == '5') {
						ss = "鱼干购买";
					} else if (data.typeList[i].scoreType == '6') {
						ss = "其他";
					} else if (data.typeList[i].scoreType == '7') {
						ss = "鱼干退回";
					}
					str += '<li><div class="content_detail_left';
					if (data.typeList[i].inExpend == '0') {
						str += ' income">+'+data.typeList[i].score;
					} else if (data.typeList[i].inExpend == '1') {
						str += ' outcome">-'+data.typeList[i].score;
					}
					str += '</div><div class="content_detail_right"><p class="contentName">' + ss + '</p><p class="contentTime">'+data.typeList[i].modTime+'</p>';
					str += "</div></li>";
				}
				$(".content ul").html(str);
			}
		});
	}