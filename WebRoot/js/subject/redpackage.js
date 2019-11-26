/*$(function() {
			$('.redP-mask').css('height',$(window).height());
			$('.ljtz').click(function() {
				$('.redP-mask').show();
				$('.redP-content').slideDown();
			});
			$('.close-redp').click(function() {
				$('.redP-mask').slideUp();
				$('.redP-content').slideUp();
			});
		});*/

//投资页  弹储蓄红包
function redpackage() {
	getredpackage();
	
	//显示背景
	$('.redP-mask').css('height',$(window).height());
	$('.redP-mask').show();
	$('.redP-content').slideDown();
}
//获取当前红包
function getredpackage()
{
$.ajax({
	async:false,
	type: "POST",
	dataType:"json",
	url: $("#basePath").val() +"redpackage/getRedPackage",
	success : function(data) {
		var money = data.money;
		var savingsId = data.savingsId;
		
		$('#redp').val(money);
		$('#savings').val(savingsId);
		
		/*$('#redpmm').before(money);*/
		$('#redpmm').html(money);
	}			
});
}
//使用红包
function redpackageopen(savingsId){
	if(savingsId == 0){
		savingsId = $('#savings').val();
	}
	if(confirm("是否使用红包?")){
		
	}else{
		return;
	}
	
	
$.ajax({
	async:false,
	type: "POST",
	dataType:"json",
	url: $("#basePath").val() +"redpackage/redpackageopen",
	data:{
		savingsId : savingsId
	},
	success : function(data) {
		var result = data.result;
		window.location.href="./redpackage/toSavings";
	}			
});
}

//储蓄页弹红包
function outredpackage(savingsId){
	$('#savings').val(savingsId);
	//显示背景
	$('.redP-mask').css('height',$(window).height());
	$('.redP-mask').show();
	$('.redP-content').slideDown();
}

//赠送
function givefriend(savingsId){
	var friendtelephone = $("#friendtelephone").val();
	if(savingsId == 0){
		savingsId = $("#savings").val();
	}
	
	if(!objIsNullOrEmptyNoMsg(friendtelephone)){
		alert('请输入好友手机号');
		$("#friendtelephone").val("");
		return;
	}
	
	if($("#friendtelephone").val().length!=11){
		alert('请输入正确的手机号！');
		$("#friendtelephone").val("");
		return;
	}
	
	var mobilePhone = /^1[0-9]{10}$/; 
	if(!mobilePhone.test(friendtelephone)) 
	{ 
	    alert('请输入有效的手机号码！'); 
	    $("#friendtelephone").val("");
	    return ; 
	} 
	
	if(confirm("是否赠送红包?")){
		
	}else{
		return;
	}
	
	$.ajax({
		async:false,
		type: "POST",
		dataType:"json",
		url: $("#basePath").val() +"redpackage/givingRedPackage",
		data : {
			telephone : friendtelephone,
			savingsId : savingsId
		},
		success : function(data) {
			
			if(data.result === 'errorPhone'){
				alert('手机输入错误！');
			}else if(data.result === 'addsuccess'){
				alert('赠送成功！');
				$('.redP-mask').slideUp();
				$('.redP-content').slideUp();
				
				window.location.href="./redpackage/toSavings";
			}else if(data.result === 'addfail'){
				alert('您的操作有误，请重新操作！');
				$("#friendtelephone").val("");
			}else if(data.result === 'yourself'){
				alert('赠送失败,不能给赠送自己！');
				$("#friendtelephone").val("");
			}
		}			
	});
	
}

//提取
function extractredpackage(){
var money = $("#savingsmm").val();

if(money <= 0){
	alert('您的猫咪储蓄还没有哦, 赶快去投资吧！');
	return;
}else if(money < 100){
	if(confirm("您的猫咪储蓄不足100元，强行提取会减半发放，是否进行提取？")){
		
	}else{
		return;
	}
}else if(money >= 100){
	if(confirm("您的猫咪储蓄已满，赶快领取吧！")){
		
	}else{
		return;
	}
}

$.ajax({
	async:false,
	type: "POST",
	dataType:"json",
	url: $("#basePath").val() +"redpackage/extractSavings",
	success : function(data) {
		var result = data.result;
		
		if(result === 'success'){
			alert('提取成功！');
			window.location.href="./redpackage/toSavings";
		}else if(result === 'error'){
			alert('提取失败！');
			window.location.href="./redpackage/toSavings";
		}else if(result === 'abnormal'){
			alert('提取失败，请重新操作！');
			window.location.href="./redpackage/toSavings";
		}
	}			
});
}

//关闭
function gosubject(){
	$('.redP-mask').slideUp();
	$('.redP-content').slideUp();
	window.location.href="./redpackage/toSavings";
}

//去规则
function gorule(){
	window.location.href="./redpackage/gorule";
}

