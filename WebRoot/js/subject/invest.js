function openredpackage()
{
	$.ajax({
		async:false,
		type: "POST",
		dataType:"json",
		url: $("#basePath").val() +"redpackage/openredpackage",
		success : function(data) {
			item = data.item;
			var money = data.money;
			switch (item) 
			{
				case 1:
					rotateFn(1,'现金券',money);
					break;
				case 2:
					rotateFn(2,'加息券',money);
					break;
				case 3:
					rotateFn(3,'鱼干',money);
					break;
				case 4:
					rotateFn(4,'小黄米',money);
					break;
				case 5:
					rotateFn(5,'SK-II神仙水',money);
					break;
			
			}
		}			
	});
}

var rotateFn = function (awards,txt,money){
	

				if(awards == 1){
					$('#rotare1').attr('src', 'images/redE-xjq.png');
					$('#redEnve-tips').text("现金券："+money+"元").fadeIn();
				}else if(awards == 2){
					$('#rotare1').attr('src', 'images/redE-jxq.png');
					$('#redEnve-tips').text("加息券："+money+"%").fadeIn();
				}else if(awards == 3){
					$('#rotare1').attr('src', 'images/redE-yg.png');
					$('#redEnve-tips').text("鱼干："+money+"个").fadeIn();
				}else if(awards == 4){
					$('#rotare1').attr('src', 'images/redE-xhm.png');
				}else if(awards == 5){
					$('#rotare1').attr('src', 'images/redE-SK.png');
				}
			
		}		
	
				
