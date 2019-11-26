function play68_init() {
	updateShare(0);
}

function goHome() {
	window.location.href = HOME_PATH;
}

function play68_submitScore(score) {
	updateShareScore(score);			
}

function updateShare(bestScore) {
	imgUrl = 'title-bg.png';
	lineLink = './';
	//网站
	descContent = "反向跑酷没玩过吧？快来一起跑！";
	updateShareScore(bestScore);
	appid = '';	
}

function updateShareScore(bestScore) {
	if(bestScore > 0) {
		shareTitle = "我在《猫咪财富3D熊出没》被追了" + bestScore + "你，你能跑过我不？！";
		if(send){
			send = false;
			footPlay.pause();
			bgmPlay.pause();
			var telephone = $('#telephone').val();
			var name = $('#name').val();
			$.ajax({
				url:"./playRecord/s/subResults",
				type : 'POST',
				data : {
					bestScore : bestScore,
					telephone : telephone,
					name : name
				},
				success : function(data) {
					
				}
			});
			//window.location.href='http://192.168.0.127:8080/xed_financing_wxgzh/loginregister/s/toLogin';
			//http://m.maomibank.com/xed_financing_wxgzh/
		}
	}
	else{
		shareTitle = "超华丽跑酷《猫咪财富3D熊出没》，你能跑多远？";
	}
}