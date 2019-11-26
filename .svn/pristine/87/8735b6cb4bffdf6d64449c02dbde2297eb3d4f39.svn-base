//明细
function queryCapitalDetail()
{
	var path= $("#basePath").val();
	var form = document.forms['form1'];
	form.action = path+'freedomsubject/tocapitaldetail';
	form.submit();
}
//转入
function turninMoney(id,type)
{
	var path= $("#basePath").val();
	var form = document.forms['form1'];
	$("#freedomSubjectId").val(id);
	$("#type").val(type);
	form.action = path+'freedomsubject/turnin';
	form.submit();
}
function turnoutMoney(id)
{
	var path= $("#basePath").val();
	var form = document.forms['form1'];
	$("#freedomSubjectId").val(id);
	form.action = path+'freedomsubject/turnout';
	form.submit();
}

//返回
function goBack()
{
	var path= $("#basePath").val();
	window.location.href=path+"capital/querycapital";
}

//window.onload = function() {
//	
//		var rates=$("#rates").val();
//		var dates=$("#dates").val();
//		var ratesArray=new Array();
//		  $(rates.split(',')).each(function(index,dom){
//			  ratesArray[index]=dom;
//		  });
//		var datesArray=new Array();
//		  $(dates.split(',')).each(function(index,dom){
//			  datesArray[index]=dom;
//		  });
//	  
//		var myChart = echarts.init(document.getElementById('main'));
//
//		option = {
//			title: {
//				text: '近一周年化收益率',
//				subtext: '数据来源于本平台'
//			},
//			tooltip: {
//				trigger: 'axis'
//			},
//			legend: {
//				data: ['近一周年化收益率']
//			},
//			calculable: true,
//			xAxis: [{
//				type: 'category',
//				boundaryGap: false,
//				data: datesArray
//			}],
//			yAxis: [{
//				type: 'value',
//				axisLabel: {
//					formatter: '{value} %'
//				}
//			}],
//			series: [{
//					name: '年化收益',
//					type: 'line',
//					data: ratesArray,
//					
//				}
//
//			]
//		};
//		myChart.setOption(option);
//}
