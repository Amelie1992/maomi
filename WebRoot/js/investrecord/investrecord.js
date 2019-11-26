// 根据标识判断显示投标页面还是债权转让页面
function changeDiv(flag) {
	var form1 = document.forms['form1'];
	form1.action = $("#basePath").val() + 'investrecord/queryinvest?flag=' + flag;
	form1.method = "post";
	form1.submit();
}


//筛选
function queryAll(flag) {
	var form1 = document.forms['form1'];
	$("#investStatus").val(flag);
	form1.action = $("#basePath").val() + 'investrecord/queryinvest';
	form1.method = "post";
	form1.submit();
}

//查看合同
function detaiContract(investId,subjectId)
{
	window.event? window.event.cancelBubble = true : e.stopPropagation();
	$("#iid").val(investId);
	$("#sid").val(subjectId);
	$("#contractForm").submit();
}

//债权转让协议
function toTransferConstact(investId,type)
{
	$("#iid").val(investId);
	$("#type").val(type);
	$("#contractForm").attr("action","./investrecord/transfercontract").submit();
}
// 跳转转让页面
function transferNow(investId,subjectType,investStatus,repeatType,subjectTerm, investMoney,subjectRate,userScore,transferScore) {
	//window.event? window.event.cancelBubble = true : e.stopPropagation();
	
	if(subjectType=='0')
	{
		alert("新手标不可转让!");
	}
	else if(repeatType=='2')
	{
		alert("到期还本付息不可转让!");
	}
	else if(subjectTerm=='0')
	{
		alert("天标不可转让!");
	}
	else if(investStatus=='1')
	{
		alert("标已经结束!");
	}
	else if(investStatus=='3')
	{
		alert("承接债权不可转让!");
	}
	else
	{
		if(confirm("转让需要扣除"+transferScore+"鱼干,确认转让吗"))
		{
			if(userScore>=transferScore)
			{
				$("#investId").val(investId);
				$("#investMoney").val(investMoney);
				$("#totalCreditMoney").val(totalCreditMoney);
				$("#subjectRate").val(subjectRate);
				$("#form1").submit();
			}
			else
			{
				if(confirm("您的鱼干不足"+transferScore+",是否确认充值"))
				{
					window.location.href = $("#basePath").val()
					+ 'integralscore/toIntegral';
				}
			}
		}
	}
	
}

//加急
function fastTransfer(investId, creditId,fastscore) {
	if(confirm("加急转让需扣除"+fastscore+"鱼干作为手续费,确定加急吗？"))
	{
		var btns_1 = $("#" + creditId);
		var btns_2 = $("#" + creditId + "a");
		$.ajax({
			type : "POST",
			url : $("#basePath").val() + "investrecord/fastTransfer",
			data : {
				creditId : creditId,
				investId : investId
			},
			success : function(data) {
				if (data.result === 'success') {
					btns_1.addClass("myButton_2");
					btns_1.value = '已加急';
					btns_1.attr("disabled", true);
					btns_2.css("backgroundColor", "");
					alert("加急成功！");
					// 刷新页面
					window.location.href = $("#basePath").val()
							+ 'investrecord/queryinvest?flag=2';
				}
				else if (data.result === 'error') {
					alert("加急失败");
				}
				else if (data.result === 'errorscore') {
					if(confirm("您的鱼干不足"+fastscore+",是否现在充值"))
					{
						window.location.href = $("#basePath").val()
						+ 'integralscore/toIntegral';
					}
				}
				
			}
		});
	}
}

//取消转让
function cancelTransfer(investId, creditId) {
	if(confirm("确定取消转让吗？"))
	{
		$.ajax({
			type : "POST",
			url : $("#basePath").val() + "investrecord/canceltransfer",
			data : {
				creditId : creditId,
				investId : investId
			},
			success : function(data) {
				if (data.result === 'success') {
				
					alert("取消成功！");
					// 刷新页面
					window.location.href = $("#basePath").val()
							+ 'investrecord/queryinvest';
				}
				else if (data.result === 'error') {
					alert("取消转让失败");
				}
			}
		});
	}
}

//平台接盘
function sysTransfer(investId, creditId) {
	if(confirm("确定平台接盘吗？"))
	{
		$.ajax({
			url : basePath + "investrecord/sysTransfer",
			type: "POST",
			data : {
				creditId : creditId,
				investId : investId
			},
			success : function(data) {
				if (data.result === 'success') {
					alert("平台接盘成功");
					window.location.href = $("#basePath").val()
							+ 'investrecord/queryinvest?flag=2';
				} else if (data.result === 'error') {
					alert("加急失败");
				}
			}
		});
	}
}

function toBack() {
	window.location.href = $("#basePath").val() + 'capital/querycapital';
}

function gotodetail(investStatus,sid,id,e){
	e=e||event;
	window.event? window.event.cancelBubble = true : e.stopPropagation();
	$("#id").val(id);
	$("#sid").val(sid);
	$("#isHome").val(2);
	var url="./investrecord/tomyinvest";
	if(investStatus==4)
	{
		alert("改标已流标，详情请查看资金明细");
	}
	else
	{
		if(sid==-1)
		{
			url="./investrecord/detailorder";
		}
		$("#gotodetailFrm").attr("action", url).submit();
	}
	
}
