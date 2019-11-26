


var d1 = new Date();  // 获取当前系统时间 我现在的时间是 2017年4月13日 星期一
d1.getFullYear();    // 获取年信息， 2017
d1.getMonth();      // 获取月信息（从0开始 范围：0-11） 4
d1.getDate();      // 获取天信息 此处结果：13
d1.getDay();      // 获取星期信息 （0-6） 此处结果： 4 

// 设置 2017年4月13日
var d2 = new Date(2017, 4, 13);    // 月是从0开始计数， 需要减一
d2.getFullYear();          // 2017
d2.getMonth();            // 4
d2.getDate();            // 13
d2.toLocaleDateString();      // "2017/4/13" 证明设置正确 




var d3 = new Date(2016, 3, 30);
d3.toLocaleDateString();      // "2016/4/30"
var d4 = new Date(2016, 3, 31);
d4.toLocaleDateString();      // "2016/5/1"
var d5 = new Date(2016, 3, 33);
d5.toLocaleDateString();      // "2016/5/3"
var d6 = new Date(2016, 4, 1);
d6.toLocaleDateString();      // "2016/5/1"
var d7 = new Date(2016, 4, 0);
d7.toLocaleDateString();      // "2016/4/30"
var d8 = new Date(2016, 4, -3);
d8.toLocaleDateString();      // "2016/4/27"


(function(){
  /*
   * 用于记录日期，显示的时候，根据dateObj中的日期的年月显示
   */
  var dateObj = (function(){
    var _date = new Date();    // 默认为当前系统时间
    return {
      getDate : function(){
        return _date;
      },
      setDate : function(date) {
        _date = date;
      }
    };
  })();
 
  // 设置calendar div中的html部分
  renderHtml();
  // 表格中显示日期
  showCalendarData();
  // 绑定事件
//bindEvent();
 
  /**
   * 渲染html结构
   */
  function renderHtml() {
    var calendar = document.getElementById("calendar");
    var titleBox = document.createElement("div");  // 标题盒子 设置上一月 下一月 标题
    var bodyBox = document.createElement("div");  // 表格区 显示数据
 
    // 设置标题盒子中的html
    titleBox.className = 'calendar-title-box';
    titleBox.innerHTML = 
      "<span class='calendar-title' id='calendarTitle'></span>";
    calendar.appendChild(titleBox);    // 添加到calendar div中
 
    // 设置表格区的html结构
    bodyBox.className = 'calendar-body-box';
    var _headHtml = "<tr>" + 
              "<th>日</th>" +
              "<th>一</th>" +
              "<th>二</th>" +
              "<th>三</th>" +
              "<th>四</th>" +
              "<th>五</th>" +
              "<th>六</th>" +
            "</tr>";
    var _bodyHtml = "";
 
    // 一个月最多31天，所以一个月最多占6行表格
    for(var i = 0; i < 6; i++) {  
      _bodyHtml += "<tr>" +
              "<td><div></div></td>" +
              "<td><div></div></td>" +
              "<td><div></div></td>" +
              "<td><div></div></td>" +
              "<td><div></div></td>" +
              "<td><div></div></td>" +
              "<td><div></div></td>" +
            "</tr>";
    }
    bodyBox.innerHTML = "<table id='calendarTable' class='calendar-table'>" +
              _headHtml + _bodyHtml +
              "</table>";
    // 添加到calendar div中
    calendar.appendChild(bodyBox);
    var signInDay = $('#signInDay').val();

		var signInDayArray = new Array();
		$(signInDay.split(',')).each(function(index, dom) {
			signInDayArray[index] = parseInt(dom);
		});

		window.setTimeout(function(){
			$(".currentMonth").each(function(index, domEle) {
				var s = $(domEle).attr("data");
				for (var i = 0; i < signInDayArray.length; i++) {
			        if (signInDayArray[i] == s) {
			        	$(domEle).addClass('signed');
//						$(domEle).html('');
			        }
			    }
				/*if (signInDayArray.constains(s)) {
					$(domEle).addClass('signed');
					$(domEle).html('');
				}*/
			});
			var isSignIn = $("#isSignIn").val();
			if(isSignIn==1){
				$('#signBtn').attr('src',$("#basePath").val()+'images/wx-grzx-yqd.png');
				$('.currentDay').addClass('signed');
				$('#signBtn').attr('onclick','');
			}else{
				$('#signBtn').click();
			}
			var today = new Date().getDate();
			if(today==1){
				$('#signBtnY').attr('src',$("#basePath").val()+'images/wx-grzx-bkbq.png');
				$('#signBtnY').attr('onclick','');
			}
		},10);
  }
 
  /**
   * 表格中显示数据，并设置类名
   */
  function showCalendarData() {
    var _year = dateObj.getDate().getFullYear();
    var _month = dateObj.getDate().getMonth() + 1;
    var _dateStr = getDateStr(dateObj.getDate());
 
    // 设置顶部标题栏中的 年、月信息
    var calendarTitle = document.getElementById("calendarTitle");
    var titleStr = _dateStr.substr(0, 4) + "年" + _dateStr.substr(4,2) + "月";
    calendarTitle.innerText = titleStr;
 
    // 设置表格中的日期数据
    var _table = document.getElementById("calendarTable");
    var _tds = _table.getElementsByTagName("div");
    var _firstDay = new Date(_year, _month - 1, 1);  // 当前月第一天
    for(var i = 0; i < _tds.length; i++) {
      var _thisDay = new Date(_year, _month - 1, i + 1 - _firstDay.getDay());
      var _thisDayStr = getDateStr(_thisDay);
      _tds[i].innerText = _thisDay.getDate();
      //_tds[i].data = _thisDayStr;
      _tds[i].setAttribute('data', _thisDayStr);
      if(_thisDayStr == getDateStr(new Date())) {    // 当前天
        _tds[i].className = 'currentDay';
      }else if(_thisDayStr.substr(0, 6) == getDateStr(_firstDay).substr(0, 6)) {
        _tds[i].className = 'currentMonth';  // 当前月
      }else {    // 其他月
        _tds[i].className = 'otherMonth';
      }
    }
  }
 
  /**
   * 绑定上个月下个月事件
   */
//function bindEvent() {
//  var prevMonth = document.getElementById("prevMonth");
//  var nextMonth = document.getElementById("nextMonth");
//  addEvent(prevMonth, 'click', toPrevMonth);
//  addEvent(nextMonth, 'click', toNextMonth);
//}
 
  /**
   * 绑定事件
   */
  function addEvent(dom, eType, func) {
    if(dom.addEventListener) {  // DOM 2.0
      dom.addEventListener(eType, function(e){
        func(e);
      });
    } else if(dom.attachEvent){  // IE5+
      dom.attachEvent('on' + eType, function(e){
        func(e);
      });
    } else {  // DOM 0
      dom['on' + eType] = function(e) {
        func(e);
      }
    }
  }
 
  /**
   * 点击上个月图标触发
   */
//function toPrevMonth() {
//  var date = dateObj.getDate();
//  dateObj.setDate(new Date(date.getFullYear(), date.getMonth() - 1, 1));
//  showCalendarData();
//}
 
  /**
   * 点击下个月图标触发
   */
//function toNextMonth() {
//  var date = dateObj.getDate();
//  dateObj.setDate(new Date(date.getFullYear(), date.getMonth() + 1, 1));
//  showCalendarData();
//}
 
  /**
   * 日期转化为字符串， 4位年+2位月+2位日
   */
  function getDateStr(date) {
    var _year = date.getFullYear();
    var _month = date.getMonth() + 1;    // 月从0开始计数
    var _d = date.getDate();
     
    _month = (_month > 9) ? ("" + _month) : ("0" + _month);
    _d = (_d > 9) ? ("" + _d) : ("0" + _d);
    return _year + _month + _d;
  }
})();




var table = document.getElementById("calendarTable");
var tds = table.getElementsByTagName('td');

//for(var i = 0; i < tds.length; i++) {
//addEvent(tds[i], 'click', function(e){
//  console.log(e.target.getAttribute('data'));
//});
//}

//当日签到

//$('#signBtn').click(function () {
////	$('.currentDay').css('color','gray');
////	$('.currentDay').css('color','red');
//	$('#signBtn').attr('class','myButton_1');
//	$('.currentDay').addClass('signed');
////	$('.currentMonth').addClass('signed');
////	$('.currentDay').html('');
////	$('.currentMonth').html('');
//	$('#signBtn').val('已签到');
//	$('#signBtn').attr('disabled','disabled');
//	
//});


//弹出层
function popup(a){
		//构造当前日期对象
		var date = new Date();
		//获取年份
		var year = date.getFullYear();
		//获取当前月份
		var mouth = date.getMonth() + 1;
		//定义当月的天数；
		var days ;
		//当月份为二月时，根据闰年还是非闰年判断天数
		if(mouth == 2){
		    days= year % 4 == 0 ? 29 : 28;
		}else if(mouth == 1 || mouth == 3 || mouth == 5 || mouth == 7 || mouth == 8 || mouth == 10 || mouth == 12){
		    //月份为：1,3,5,7,8,10,12 时，为大月.则天数为31；
		    days= 31;
		}else{
		    //其他月份，天数为：30.
		    days= 30;
		}
		
	//a.count获得用户累计签到天数	
	//设置id为count的P元素的内容
	$('#count').text(a.count);
	
	//设置id为getwin的P元素的内容
	if(a.count<7){
		$('#getwin').text("再累计签到"+(7-a.count)+"天可额外获得5鱼干");
	}else if(a.count>7&&a.count<20){
		$('#getwin').text("再累计签到"+(20-a.count)+"天可额外获得10鱼干");
	}else if(a.count>20&&a.count<days){
		$('#getwin').text("再累计签到"+(days-a.count)+"天可额外获得20鱼干");
	}else if(a.count==7){
		$('#getwin').text("已累计签到7天额外获得5鱼干");
	}else if(a.count==20){
		$('#getwin').text("已累计签到20天额外获得10鱼干");
	}else if(a.count==days){
		$('#getwin').text("恭喜满签额外获得20鱼干");
	}
	//获得用户VIP等级
	var level = a.accountInfo.accountLevel;
	if(level<=1){
		$('#win').text("提升vip等级可获得加息券奖励");
	}else{
		$('#win').text("已累计获得加息"+parseInt(a.rate*100)*a.count/100+"%");
	}
	
	//弹框样式
	$('.qd-mask').css('height', $('body').height());
	$('.qd-mask').show();
	$('.qd-content').slideDown();

	$('.alert-close').click(function() {
		$('.qd-mask').slideUp();
		$('.qd-content').slideUp();
		window.location.href='./signin/toSignIn';
	});
}
//当日签到
function signIn(){
	$.ajax({
		url:"./signin/signIn",
		type: "POST",
		success : function(data) {
			var a =  eval('('+data+')');
			if (a.msg == 0) {
				//调用弹出层
				popup(a);
			}else if(a.msg == 1){
				alert('已经签到过');
				$('#signBtn').attr('src',$("#basePath").val()+'images/wx-grzx-yqd.png');
				$('#signBtn').attr('onclick','');
			}else if(a.msg == 'error'){
				alert("签到失败");
			}
			
			/*if(typeof(a.jizi)!='undefined'){
				var zi = '';
				if(a.jizi==='1'){
					zi = '举';
				}else if(a.jizi==='2'){
					zi = '国';
				}else if(a.jizi==='3'){
					zi = '欢';
				}else if(a.jizi==='4'){
					zi = '庆';
				}
				if(confirm('意外惊喜,恭喜您在国庆字活动中成功获得"' + zi + '"字,是否前往活动页面查看'))
				{
					window.location.href=context+'activity/s/goactivity';
				}
				else
				{
					window.location.href=context+'signin/toSignIn';
				}
			}*/
		}
	});
}

//补签昨日
function signInY(){
	$.ajax({
		url:"./signin/signInYesterday",
		type: "POST",
		success : function(data) {
			var a =eval('('+data+')');
			if (a.result === 'success') {
				//判断是否满签
				alert('补签成功');
				$('#signBtnY').attr('src',$("#basePath").val()+'images/wx-grzx-bkbq.png');
				$('#signBtnY').attr('onclick','');
				window.location.href='./signin/toSignIn';
			}else if(a.result === 'isSign'){
				alert('不可再签');
				$('#signBtnY').attr('src',$("#basePath").val()+'images/wx-grzx-bkbq.png');
				/* $('.currentDay').addClass('signed');
				$('#signBtn').val('已签到');
				$('#signBtn').attr('disabled','disabled');*/
			}else if(a.result === 'error'){
				alert("补签失败");
			}else if(a.result === 'notEnough'){
				alert("特权次数不足");
			}else if(a.result ==='notScore'){
				alert("鱼干不足");
			}
		}
	});
}

