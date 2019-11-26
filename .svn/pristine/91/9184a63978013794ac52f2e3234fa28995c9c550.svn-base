

var rotateFn = function (awards,txt){
		
	var result;
	var money;
	$.ajax({
		async:false,
		type: "POST",
		data:{awards:awards},
		dataType:"json",
		url: $("#basePath").val() + "redpackage/grantredpackage",
		success : function(data) {
			money = data.money;
			if(data.result == "SUCCESS"){
				
				if(awards == 1){
					alert("恭喜您获得" + money+"元" + txt + "奖励。");
				}else if(awards == 2){
					alert("恭喜您获得" + money+"%" + txt + "奖励。");
				}else if(awards == 3){
					alert("恭喜您获得" + money+"个" + txt + "奖励。");
				}else if(awards == 4){
					alert("抽中实物大奖啦！恭喜您获得一袋" + txt + "奖励。");
				}else if(awards == 5){
					alert("抽中实物大奖啦！恭喜您获得一瓶" + txt + "奖励。");
				}
				window.location.href="./capital/querycapital";
			}
			else
			{
				alert("红包异常");
			}
		}		
	});
				
}


function openredpackage()
{
	$.ajax({
		async:false,
		type: "POST",
		dataType:"json",
		url: $("#basePath").val() +"redpackage/openredpackage",
		success : function(data) {
			item = data.item;
			switch (item) 
			{
				case 1:
					rotateFn(1,'现金券');
					break;
				case 2:
					rotateFn(2,'加息券');
					break;
				case 3:
					rotateFn(3,'鱼干');
					break;
				case 4:
					rotateFn(4,'小黄米');
					break;
				case 5:
					rotateFn(5,'SK-II神仙水');
					break;
			
			}
		}			
	});
}