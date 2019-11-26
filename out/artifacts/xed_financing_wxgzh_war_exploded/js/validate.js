//验证非空(传值)
function objIsNullOrEmpty(obj){
	if (obj == null || obj == "") {
		alert("请填写相关内容");
		return false;
	}else{
		return true;
	}
}

//验证函数(传值,验证字符)
function verifyVal(obj, pat) {
	var str = obj.trim();
	if (str == null || str == "") {
		alert("请填写相关内容");
		return false;
	}
	var thePat;
	thePat = patterms[pat];
	if (thePat.test(str)) {
		return true;
	} else {
		alert("您输入的格式有误");
		return false;
	}
}

//不加非空校验  验证函数(传值,验证字符)
function verifyVals(obj, pat) {
	var str = obj.trim();
	var thePat;
	thePat = patterms[pat];
	if (thePat.test(str)) {
		return true;
	} else {
		alert("您输入的格式有误");
		return false;
	}
}

//验证函数(传值,验证字符,不通过消息提示)
function verifyVal(obj, pat, msg) {
	var str = obj.trim();
	if (str == null || str == "") {
		alert("请填写"+msg+"相关内容");
		return false;
	}
	var thePat;
	thePat = patterms[pat];
	if (thePat.test(str)) {
		return true;
	} else {
		alert("您输入的"+msg+"格式有误");
		return false;
	}
}

//验证函数(传对象,验证字符)
function verify(obj, pat) {
	var str = $(obj).val().trim();
	if (str == null || str == "") {
		$(obj).attr("placeholder", "请填写相关内容");
		return false;
	}
	var thePat;
	thePat = patterms[pat];
	if (thePat.test(str)) {
		return true;
	} else {
		$(obj).val('');
		$(obj).attr("placeholder", "您输入的格式有误");
		return false;
	}
}
//比较两个字符串是否一致(传值,传值)
function sameWith(obj1,obj2){
	var str = obj1.trim();
	var str2 = obj2.trim();
	if(str==str2){
		return true;
	}else{
		return false;
	}
}

//验证函数(传值,验证字符)    没有提示
function verifyValNoMsg(obj, pat) {
	var str = obj.trim();
	if (str == null || str == "") {
		return false;
	}
	var thePat;
	thePat = patterms[pat];
	if (thePat.test(str)) {
		return true;
	} else {
		return false;
	}
}

//验证非空(传值)     没有提示
function objIsNullOrEmptyNoMsg(obj){
	if (obj == null || obj == "") {
		return false;
	}else{
		return true;
	}
}


var patterms = new Object();

// 验证IP
patterms.ip = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])(\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])){3}$/;

// 验证EMAIL
patterms.email = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;

// 验证日期格式
patterms.date = /^\d{4}-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/;

// 验证时间格式
patterms.time = /^([0-1]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$/;

// 验证数字
patterms.num = /^[-+]?\d*$/;

// 验证字母
patterms.letter = /^[a-zA-Z]+$/;

// 验证字母+数字
patterms.alphanum = /^[a-zA-Z0-9]*$/

// 验证输入类型是否常用
patterms.chara = /^[a-zA-Z0-9_]+$/;

// 验证手机号码
patterms.mobilePhone = /^[0-9]{11}$/;

// 验证电话号码
patterms.phone = /^((([0-9]{4}|[0-9]{3})-)|(([0-9]{4}|[0-9]{3})))*([0-9]{7}|[0-9]{8})$|^[0-9]{11}$/;

// 验证身份证
patterms.idCard = /^[0-9]{17}[0-9xX]{1}$|^[0-9]{14}[0-9xX]{1}$/;

// 验证正整数
patterms.positive = /^([0-1]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$/;

patterms.nums = /^(([1-9])|(1\d)|(2[0-4]))$/;

patterms.numss = /^([1-9]|[1-2]\d|3[0-1])$/;

//密码 大小写字母数字 6~16位
patterms.password = /^[a-zA-Z0-9]{6,16}$/;

//用户名 字母开头位数6~13位
patterms.accountName = 	/^[a-zA-Z0-9\u4e00-\u9fa5._~*]{2,16}$/;

//验证正整数
patterms.integerValue=/^[1-9]\d*$/;
		
//正浮点数 保留小数点两位
patterms.rateValue=/^(?!0+(?:\.0+)?$)(?:[1-9]\d*|0)(?:\.\d{1,2})?$/;

//2~5位中文
patterms.chineseVerification=/^[\u4e00-\u9fa5]{2,5}$/;