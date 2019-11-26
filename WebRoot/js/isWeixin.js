/*$(document).ready(function (){
	if(screen.height == 812 && screen.width == 375) {
		$('.cj-base').css('top', '75%');
		$('.cj-plant').css('top', '41.5%');
		$('.cj-snow').css('top', '80%');
		$('.tips').css('top', '90%');
	}
});*/

/*
//判断手机PC
function isMobile(){
	var system = {
		win: false,
		mac: false,
		xll: false
	};
	var p = navigator.platform;
	system.win = p.indexOf("Win") == 0;
	system.mac = p.indexOf("Mac") == 0;
	system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
	if(system.win || system.mac || system.xll) {
		window.location.href="./warningError.jsp";
	} else {
		window.onload = function() {
			if(!isWeiXin()) {
				window.location.href ="./warningError.jsp";
			} 
		}
	}
}
$(function(){
	isMobile();
});
//判断微信
function isWeiXin() {
	var ua = window.navigator.userAgent.toLowerCase();
	var u = navigator.userAgent;
	var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1; //android终端
	var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
	if(ua.match(/MicroMessenger/i) == 'micromessenger'||isAndroid||isiOS) {
		return true;
	} else {
		return false;
	}
}

*/