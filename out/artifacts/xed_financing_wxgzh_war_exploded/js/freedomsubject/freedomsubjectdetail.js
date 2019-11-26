//跳转投团记录
function queryFreedomRecord(id)
{
	var path= $("#basePath").val();
	var form = document.forms['form1'];
	$("#freedomSubjectId").val(id);
	form.action = path+'freedomsubject/toDetailFreedomRecord';
	form.submit();
}

//转入
function turnIn(id,type,freedomSubjectStatus)
{
	if(freedomSubjectStatus==2)
	{
		alert("猫咪宝已满额")
	}else
	{
		var path= $("#basePath").val();
		var form = document.forms['form1'];
		$("#freedomSubjectId").val(id);
		$("#type").val(type);
		form.action = path+'freedomsubject/turnin';
		form.submit();
	}
}

//返回
function goBack()
{
	var path= $("#basePath").val();
	window.location.href=path+'freedomsubject/s/queryfreedomsubject';
}

//查看更多
function queryMore(id)
{
	var path= $("#basePath").val();
	var form = document.forms['form1'];
	$("#freedomSubjectId").val(id);
	form.action = path+'freedomsubject/s/moreprofit';
	form.submit();
}

//跳转借贷项目
function goDispersionSubject(id)
{
	var path= $("#basePath").val();
	var form = document.forms['form1'];
	form.action = path+'subjectdispersed/querySubjectDispersedHomepage';
	$("#freedomSubjectId").val(id);
	form.submit();
}

//跳转常见问题页面
function goHelp(id)
{
	var path= $("#basePath").val();
	$("#freedomSubjectId").val(id);
	var form = document.forms['form1'];
	form.action = './freedomsubject/tohelp';
	form.submit();
}

function flag(type)
{
	if(type==1)
	{
		$('.program_1').css('color', '#F95D18');
		$('.program_2').css('color', '#141414');
		$('.program_1_con').css('opacity', '1');
		$('.program_1_con').css('z-index', '100');
		$('.program_2_con').css('opacity', '0');
		$('.program_2_con').css('z-index', '1');
	}
	else if(type==2)
	{
		$('.program_2').css('color', '#F95D18');
		$('.program_1').css('color', '#141414');
		$('.program_1_con').css('opacity', '0');
		$('.program_1_con').css('z-index', '1');
		$('.program_2_con').css('opacity', '1');
		$('.program_2_con').css('z-index', '100');
	}
}

		window.onload = function() {
			
			var rates=$("#rates").val();
			var dates=$("#dates").val();
			var ratesArray=new Array();
	    	  $(rates.split(',')).each(function(index,dom){
	    		  ratesArray[index]=dom;
	    	  });
	    	var datesArray=new Array();
	    	  $(dates.split(',')).each(function(index,dom){
	    		  datesArray[index]=dom;
	    	  });
			
			var myChart = echarts.init(document.getElementById('main'));

			option = {
				title: {
					
					subtext: '数据来源于本平台'
				},
				tooltip: {
					trigger: 'axis'
				},
				legend: {
					data: ['一周年化收益率']

				},
				calculable: true,
				xAxis: [{
					type: 'category',
					boundaryGap: true,
					data: datesArray
				}],
				yAxis: [{
					type: 'value',
					min:4,
					max:6,
					axisLabel: {
						formatter: '{value} %'
					}
				}],
				series: [{
					label: {
						normal: {

							show: true

						}
					},

						name: '年化收益',
						type: 'line',
						data: ratesArray,
				}

			]
		};
		myChart.setOption(option);
	}
		