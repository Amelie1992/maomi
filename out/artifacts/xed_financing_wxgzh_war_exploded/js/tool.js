var tool = {
	successAlert : function(str) {
		var shield = document.createElement("DIV");
		shield.id = "shield";
		shield.style.position = "absolute";
		shield.style.left = "0px";
		shield.style.top = "0px";
		shield.style.width = "70%";
		shield.style.height = document.body.scrollHeight + "px";
		// 弹出对话框时的背景颜色
		//shield.style.background = "red";
		shield.style.textAlign = "center";
		shield.style.zIndex = "25";
		// 背景透明 IE有效
		// shield.style.filter = "alpha(opacity=0)";
		var alertFram = document.createElement("DIV");
		alertFram.id = "alertFram";
		alertFram.style.position = "absolute";
		alertFram.style.left = "50%";
		alertFram.style.top = "50%";
		alertFram.style.marginLeft = "-150px";
		alertFram.style.marginTop = "-115px";
		alertFram.style.width = "270px";
		alertFram.style.height = "150px";
		// alertFram.style.background = "#ff0000";
		alertFram.style.textAlign = "center";
		alertFram.style.lineHeight = "150px";
		alertFram.style.zIndex = "300";
		strHtml = "<ul style=\"list-style:none;margin:0px;padding:0px;width:100%\">\n";
		strHtml += " <li style=\"background:dodgerblue;text-align:left;padding-left:20px;font-size:14px;font-weight:bold;height:25px;line-height:25px;border:1px solid #F9CADE;\">[系统提示]</li>\n";
		strHtml += " <li style=\"background:#fff;text-align:center;font-size:12px;height:120px;line-height:120px;\">"
				+ str + "</li>\n";
		strHtml += " <li style=\"background:dodgerblue;text-align:center;font-weight:bold;height:40px;line-height:40px; border:1px solid #dodgerblue;\"><input type=\"button\" value=\"确 定\" onclick=\"doOk()\" style=\"width:50%;height:100%;\" /></li>\n";
		strHtml += "</ul>\n";
		alertFram.innerHTML = strHtml;
		document.body.appendChild(alertFram);
		document.body.appendChild(shield);
		var ad = setInterval(5);
		
		alertFram.focus();
		document.body.onselectstart = function() {
			return false;
		};
	}

}

function doOk() {
	var _parentElement = alertFram.parentNode;
	_parentElement.removeChild(alertFram);
	var _parentElement2 = shield.parentNode;
	_parentElement2.removeChild(shield);
}
