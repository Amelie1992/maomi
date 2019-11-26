//生成按钮倒计时
var countdown = 300;
function settime(obj) {
	if (countdown == 0) {
		$(obj).attr("disabled", false);
		$(obj).css("cursor", "pointer");
		$(obj).css("background-color", "#fdcf08");
		$(obj).text("重新获取验证码");
		countdown = 300;
		return;
	} else {
		$(obj).attr("disabled", true);
		$(obj).text("重新发送(" + countdown + ")");
		$(obj).css("background-color", "#ebebeb");
		countdown--;
	}
	setTimeout(function() {
		settime(obj)
	}, 1000);
}

function getEmailVerCode(obj) {
	var codeId = "";
	var enterEmail = $("#accountEmail").val();
	if (enterEmail != null && enterEmail != "") {
		// 提交邮箱至后台
		$("#accountEmail").val(enterEmail);
		// axaj调用后台方法saveVerInfo
		$.ajax({
			async:false,
			type : "POST",
			dataType:"json",
			url : "./emailcheck/saveVerInfo",
			data : {
				email : enterEmail
			},
			success : function(data) {
				// ajax返回结果ID并赋值给codeId
				$("#codeId").val(data.codeId);
				alert("验证码发送成功,有效期为" + data.codeTime + "分钟,请尽快验证");
				settime(obj);
			}
		});
	} else {
		alert("请输入邮箱账号!");
	}
}

function checkOK() {
	var flag = "";
	var emails = $("#accountEmail").val()
	var enterCode = $("#codeMsg").val();
	var codeId = $("#codeId").val();
	if (enterCode != null && enterCode != "") {
		$.ajax({
			async:false,
			type : "POST",
			dataType:"json",
			url : "./emailcheck/judgmentCodeMsg",
			data : {
				accountEmail : emails,
				enterCode : enterCode,
				codeId : codeId,
			},
			success : function(data) {
				// ajax返回结果ID并赋值给codeId
				if(data.flag == -3){
					alert("邮箱状态异常,请确认邮箱或稍后重试!");
				}else if(data.flag == -2){
					alert("验证码超时,请重新发送!");
				}else if(data.flag == -1){
					alert("验证码有误,请确认!");
				}else if(data.flag == 0){
					alert("验证成功,奖励的10鱼干已发放至账户");
					window.location.href = "./accountinfo/personalSettings";
				}
			}
		});
	} else {
		alert("请输入接收到的验证码!");
	}
}

function backToMySetting() {
	window.location.href = "./accountinfo/personalSettings";
}

$(function() {
	$.AutoComplete("#accountEmail"); // （要补全文本框的id）
});

jQuery.AutoComplete = function(selector) {
	var elt = $(selector);
	var strHtml = '<div class="AutoComplete" id="AutoComplete">'
			+ '        <ul class="AutoComplete_ul">'
			+ '            <li hz="@163.com"></li>'
			+ '            <li hz="@126.com"></li>'
			+ '            <li hz="@139.com"></li>'
			+ '            <li hz="@189.com"></li>'
			+ '            <li hz="@qq.com"></li>'
			+ '            <li hz="@vip.sina.com"></li>'
			+ '            <li hz="@sina.cn"></li>'
			+ '            <li hz="@sina.com"></li>'
			+ '            <li hz="@sohu.com"></li>'
			+ '            <li hz="@hotmail.com"></li>'
			+ '            <li hz="@gmail.com"></li>'
			+ '            <li hz="@wo.com.cn"></li>'
			+ '            <li hz="@21cn.com"></li>'
			+ '            <li hz="@aliyun.com"></li>'
			+ '            <li hz="@yahoo.com"></li>'
			+ '            <li hz="@foxmail.com"></li>' + '        </ul>'
			+ '    </div>';
	// 将div追加到body上
	$('body').append(strHtml);
	var autoComplete, autoLi;
	autoComplete = $('#AutoComplete');
	autoComplete.data('elt', elt);
	autoLi = autoComplete.find('li');
	autoLi.mouseover(function() {
		$(this).siblings().filter('.hover').removeClass('hover');
		$(this).addClass('hover');
	}).mouseout(function() {
		$(this).removeClass('hover');
	}).mousedown(function() {
		autoComplete.data('elt').val($(this).text()).change();
		autoComplete.hide();
	});
	// 用户名补全+翻动
	elt.keyup(
			function(e) {
				if (/13|38|40|116/.test(e.keyCode) || this.value == '') {
					return false;
				}
				var username = this.value;
				var filter = /^([a-zA-Z0-9_\.\-])+$/;
				if (username.indexOf('@') == -1 && !filter.test(username)) {
					username = this.value.substring(0, this.value.length - 1);
					while (!filter.test(username)) {
						username = username.substring(0, username.length - 1);
					}
					this.value = username;
					return false;
				}
				autoLi.each(
						function() {
							this.innerHTML = username.replace(/\@+.*/, '')
									+ $(this).attr('hz');
							if (this.innerHTML.indexOf(username) >= 0) {
								$(this).show();
							} else {
								$(this).hide();
							}
						}).filter('.hover').removeClass('hover');
				autoComplete.show().css({
					left : $(this).offset().left,
					top : $(this).offset().top + $(this).outerHeight(true) - 1,
					position : 'absolute',
					zIndex : '99999'
				});
				if (autoLi.filter(':visible').length == 0) {
					autoComplete.hide();
				} else {
					autoLi.filter(':visible').eq(0).addClass('hover');
				}
			}).keydown(
			function(e) {
				if (e.keyCode == 38) { // 上
					autoLi.filter('.hover').prev().not('.AutoComplete_title')
							.addClass('hover').next().removeClass('hover');
				} else if (e.keyCode == 40) { // 下
					autoLi.filter('.hover').next().addClass('hover').prev()
							.removeClass('hover');
				} else if (e.keyCode == 13) { // 确定
					autoLi.filter('.hover').mousedown();
				}
			}).focus(function() {
		autoComplete.data('elt', $(this));
	}).blur(function() {
		autoComplete.hide();
	});
};