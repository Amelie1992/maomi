<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/swiper.min.js"></script>
<script type="text/javascript" src="js/isWeixin.js"></script>
<script type="text/javascript" src="js/navigation.js"></script>
<link rel="stylesheet" type="text/css" href="css/xlcd.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
<title>投资中心</title>
<style type="text/css">
th {
	font-weight: normal;
}

.wrap {
	width: 100%;
	position: relative;
}

.wrap .navigation {
	width: 100%;
	background-color: #E5E5E5;
}

.wrap .navigation table {
	line-height: 40px;
	/*font-size: 20px;*/
	padding-top: 5px;
	width: 100%;
	border-bottom: 1px solid #EEEEEE;
}

.swiper-container {
				width: 100%;
				height: 50px;
			}
			
			.swiper-slide {
				text-align: center;
				font-size: 16px;
				background: #fff;
				display: -webkit-box;
				display: -ms-flexbox;
				display: -webkit-flex;
				display: flex;
				-webkit-box-pack: center;
				-ms-flex-pack: center;
				-webkit-justify-content: center;
				justify-content: center;
				-webkit-box-align: center;
				-ms-flex-align: center;
				-webkit-align-items: center;
				align-items: center;
			}
			
			.swiper-button-next,
			.swiper-button-prev {
				position: absolute;
				top: 78%;
				width: 14px;
				height: 14px;
				z-index: 10;
				cursor: pointer;
				background-size: 100% 100%;
				background-position: center;
				background-repeat: no-repeat;
			}
			
			.swiper-button-prev,
			.swiper-container-rtl .swiper-button-next {
				background-image: url(images/backdark.png);
				left: 0px;
				right: auto
			}
			
			.swiper-button-prev.swiper-button-black,
			.swiper-container-rtl .swiper-button-next.swiper-button-black {
				background-image: url(images/backdark.png);
			}
			
			.swiper-button-prev.swiper-button-white,
			.swiper-container-rtl .swiper-button-next.swiper-button-white {
				background-image: url(images/backlight.png);
			}
			
			.swiper-button-next,
			.swiper-container-rtl .swiper-button-prev {
				background-image: url(images/nextdark.png);
				right: 0px;
				left: auto
			}
			
			.swiper-button-next.swiper-button-black,
			.swiper-container-rtl .swiper-button-prev.swiper-button-black {
				background-image: url(images/nextdark.png);
			}
			
			.swiper-button-next.swiper-button-white,
			.swiper-container-rtl .swiper-button-prev.swiper-button-white {
				background-image: url(images/nextlight.png);
			}



.wrap .filtrate {
	width: 80%;
	margin: 0 auto;
	border-bottom: 1px solid #EEEEEE;
}

.wrap .filtrate table {
	/*padding-top: 15px;*/
	width: 100%;
	line-height: 40px;
	font-size: 12px;
}

.content {
	border-bottom: 1px solid #EEEEEE;
}

.content, .content_detail {
	width: 100%;
	overflow: hidden;
	/*padding-top: 15px;*/
	padding-bottom: 15px;
	/*border-bottom: 1px solid #eee;*/
	margin-top: 15px;
	background-color: #FFFFFF;
	text-align: left;
	text-indent: 10px;
}

.content_detail_title {
	padding: 0 5px;
	font-size: 20px;
	color: #333333;
	/*text-align: center;*/
	width: 100%;
	margin: 0 auto;
	/*margin-bottom: 15px;*/
}

.content_detail_title .jiaji {
	color: #F54749;
	display: inline-block;
	padding: 0 8px;
	line-height: 20px;
	font-size: 12px;
	border: 1px solid #eee;
	border-radius: 10px;
	text-indent: 0px;
}



.content-tips {
	font-size: 12px;
	color: #C0C0C0;
}

.content_detail_box {
	padding: 0 5px;
	/*padding: 0 5%;*/
	width: 100%;
	text-align: left;
	margin: 0 auto;
}

.content_detail_box table {
	width: 100%;
}
.content_detail_box table th {
	height: 50px;
	line-height: 20px;
	text-align: left;
	text-indent: 10px;
}

.content_detail_box table th:nth-child(1) p:nth-child(1) span {
	color: #FA5D18;
}

.content_detail_box table th:nth-child(1) p:nth-child(1) span:nth-child(1) {
	font-size: 25px;
	text-indent: 0px;
}

.qiang {
	background-color: #ff9f26;
	border-radius: 42px;
	/*	border: 1px solid #e65f44;*/
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 20px;
	/*font-weight: bold;*/
	padding: 15px 15px;
	text-decoration: none;
	text-indent: 0px;
	text-align: center;
}

.qiangbuliao {
	background-color: #eee;
	border-radius: 42px;
	/*	border: 1px solid #e65f44;*/
	display: inline-block;
	cursor: pointer;
	color: #888;
	font-family: Arial;
	font-size: 20px;
	/*font-weight: bold;*/
	padding: 15px 15px;
	text-decoration: none;
	text-indent: 0px;
	text-align: center;
}

.qiang:active {
	position: relative;
	top: 1px;
}

.currentChose_head {
	color: #FC7831;
	border-bottom: 2px solid #FC7831;
}

.currentChose {
	color: #FC7831;
}

.space {
	width: 100%;
	height: 15px;
	background-color: #F7F7F7;
}

.footer {
	background-color: #fafafa;
	/*height: 80px;*/
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	border-top: 1px solid #EEEEEE;
}

.footer table {
	width: 100%;
	text-align: center;
	font-size: 14px;
}

.footer table img {
	width: 30%;
}
.ziji {
	color: #888;
	display: inline-block;
	padding: 0 8px;
	line-height: 20px;
	font-size: 12px;
	border: 1px solid #eee;
	border-radius: 10px;
	text-indent: 0px;
}

</style>
</head>
<script type="text/javascript">
	function Flag(sorting,type,obj) {
		var data2 = {};
		var accountId = $('#accountId').val();
		if(type===1){
			data2={creditRate : sorting};
			if(sorting===0){
				$("#two").attr('onclick','Flag(1,1,this)');
			}else{
				$("#two").attr('onclick','Flag(0,1,this)');
			}
		}else if(type === 2){
			data2={creditMoney : sorting};
			if(sorting===0){
				$("#three").attr('onclick','Flag(1,2,this)');
			}else{
				$("#three").attr('onclick','Flag(0,2,this)');
			}
		}else if(type === 3){
			data2={creditTime : sorting};
			if(sorting===0){
				$("#four").attr('onclick','Flag(1,3,this)');
			}else{
				$("#four").attr('onclick','Flag(0,3,this)');
			}
		}
		$("th[name='tabs']").each(function(index,dom){
			$(dom).removeClass('currentChose_head');
		});
		$(obj).addClass('currentChose_head');
		$.ajax({
			  url: "<%=basePath%>bondTransfer/getSortingList",
			  type: "POST",
				data : data2,
			  success: function(data){
					var a = eval('('+data+')');
					var str="";
		 			$(a.creditRecords).each(function(index,obj){
		 				str += "<div class='content' onclick='transfer("+obj.creditId+")'>"+
						"<div class='content_detail'>"+
							"<p class='content_detail_title'>"+ obj.subjectId ;
								if(obj.creditType!=0){
									str+="<span class='jiaji'>加急中</span>";
								}
								if(obj.outAccountId==accountId){
									str+="<span class='ziji'>我的债权</span>";
								}
								if(obj.dealType==2){
									str+="<span class='ziji'>已承接</span>";
								}
							str+="</p>"+
						"</div>"+
						"<div class='content_detail_box'>"+
							"<table border='0' cellspacing='' cellpadding=''>"+
								"<tr>"+
									"<th>"+
										"<p>"+
											"<span>"+obj.creditRate+"</span> <span>%</span>"+
										"</p>"+
										"<p>"+
											"<span class='content-tips'>参考年回报率</span>"+
										"</p>"+
									"</th>"+
									"<th>"+
										"<p>"+
											"<span class='content-tips'>结束时间:</span> <span>"+obj.creditTime+"</span>"+
										"</p>"+
										"<p>"+
											"<span class='content-tips'>转让金额:</span> <span>"+obj.creditMoney+"元</span>"+
										"</p>"+
									"</th>"+
									"<th>";
										if(obj.dealType==0){
											if(obj.outAccountId!=accountId){
												str+="<a class='qiang'>抢</a>";
											}else{
												str+="<a class='qiangbuliao'>抢</a>";
											}
										}else if(obj.dealType==2){
											str+="<a class='qiangbuliao'>完</a>";
										}
										
									str+="</th>"+
								"</tr>"+
							"</table>"+
						"</div>"+
					"</div>"+
					"<div class='space'></div>";
					
		 			});		
		 			$("#entry").html(str);
			  }
			  		
		});
		
	}
function transfer(creditId){
	window.location.href='<%=basePath%>bondTransfer/getbondtransferdetail?creditId='+creditId;
			
};
</script>
<body>
	<form method="post" action="" id="form1" >
    	<input type="hidden" id="subjectType"  name="subjectType"/>
    </form>
	<input type="hidden" name="accountId" id="accountId"
		value="${account.accountId}" />
	<input type="hidden" name="sorting" id="sorting" value="0" />
	<div class="wrap">
		<!-- <div class="navigation">
			切到哪个标 就给对应的加类名 .currentChose_head
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th onclick="querynewsubject()">新手标</th>
					<th onclick="querysubject()">精选理财</th>
					<th onclick="querynewsubject()">实物标</th>
					<th onclick="queryhighsubject()">爆款标</th>
					<th onclick="getBondTransfer()" class="currentChose_head">债权转让</th>
				</tr>
			</table>
		</div> -->
		<div class="navigation">
			<!--切到哪个标 就给对应的加类名 .currentChose_head-->
			<div class="swiper-container">
				<div class="swiper-wrapper">
					<div class="swiper-slide" onclick="changeBiao(this,0)">新手专享</div>
					<div class="swiper-slide" onclick="changeBiao(this,1)">精选理财</div>
					<div class="swiper-slide" onclick="changeBiao(this,4)">爆款推荐</div>
					<div class="swiper-slide" onclick="changeBiao(this,7)">猫咪众筹</div>
					<!-- <div class="swiper-slide" onclick="changeBiao(this,6)">猫咪宝</div> -->
					<div class="swiper-slide currentChose_head swiper-slide-active" onclick="changeBiao(this,5)">债权转让</div>
				</div>
				<!-- Add Arrows -->
				<div id="swiper_go_right" class="swiper-button-next"></div>
				<div id="swiper_go_left" class="swiper-button-prev"></div>

			</div>
		</div>
		
		<div class="filtrate">
			<!--切到哪个筛选条件 就给对应的加类名 .currentChose_head-->
			<table border="0" cellspacing="" cellpadding="">
				<tr>
					<th onclick="Flag(null,null,this)" id="one" name="tabs"
						class="currentChose_head">默认</th>
					<th onclick="Flag(0,1,this)" id="two" name="tabs">利率</th>
					<th onclick="Flag(0,2,this)" id="three" name="tabs">金额</th>
					<th onclick="Flag(0,3,this)" id="four" name="tabs">期限</th>
				</tr>

			</table>
		</div>
		<div id="entry">
		<c:if test="${!empty record.creditRecords }">
			<c:forEach items="${record.creditRecords}" var="cr">
				<div class="content" onclick="transfer(${cr.creditId})" >
					<div class="content_detail">
						<p class="content_detail_title">
							${cr.subjectId}
							<c:if test="${cr.creditType!=0}">
								<span class="jiaji">加急中</span>
							</c:if>
							<c:if test="${cr.outAccountId==account.accountId}">
								<span class="ziji">我的债权</span>
							</c:if>
							<c:if test="${cr.dealType==2}">
								<span class="ziji">已承接</span>
							</c:if>
						</p>
					</div>
					<div class="content_detail_box">
						<table border="0" cellspacing="" cellpadding="">
							<tr>
								<th>
									<p>
										<span>${cr.creditRate}</span> <span>%</span>
									</p>
									<p>
										<span class="content-tips">参考年回报率</span>
									</p>
								</th>
								<th>
									<p>
										<span class="content-tips">结束时间:</span> <span>${cr.creditTime}</span>
									</p>
									<p>
										<span class="content-tips">转让金额:</span> <span>${cr.creditMoney}元</span>
									</p>
								</th>
								<th style="text-indent: 0px;">
									<c:if test="${cr.dealType==0}">
										<c:if test="${cr.outAccountId!=account.accountId}">
											<a class="qiang">抢</a>
										</c:if>
										<c:if test="${cr.outAccountId==account.accountId}">
											<a class="qiangbuliao">抢</a>
										</c:if>
									</c:if>
									<c:if test="${cr.dealType==2}">
										<a class="qiangbuliao">完</a>
									</c:if>
								</th>
							</tr>
						</table>
					</div>
				</div>
				<div class="space"></div>
			</c:forEach>
		</c:if>
		</div>
		<!-- 空白导航  防止被底部导航栏遮住内容 -->
	<jsp:include page="../navigation/emptyDiv.jsp" flush="true" />
		<div class="footer">
				<table border="0" cellspacing="" cellpadding="">
					<tr>
						<th onclick="toChange(this,1)"><img src="images/tab_home_nor.png" /></th>
						<th onclick="toChange(this,2)"><img src="images/tab_touzi_sel.png" /></th>
						<th onclick="toChange(this,3)"><img src="images/tab_mall_nor.png" /></th>
						<th onclick="toChange(this,4)"><img src="images/tab_geren_nor.png" /></th>
					</tr>
					<tr>
						<td onclick="toChange(this,1)">首页</td>
						<td onclick="toChange(this,2)" class="currentChose">投资</td>
						<td onclick="toChange(this,3)">商城</td>
						<td onclick="toChange(this,4)">我</td>
					</tr>
				</table>
			</div>
	</div>
	
	<!-- 底部导航 -->
	<%-- <jsp:include page="../navigation/navigation.jsp" flush="true" /> --%>
</body>
<script type="text/javascript">
function goBack(){
	window.location.href='<%=basePath%>capital/querycapital';
}
function changeBiao(obj,sType)
{
	
	$("#subjectType").val(sType)
	var form = document.forms['form1'];
	if('2'==sType)
	{
		form.action = '<%=basePath%>hotsubject/s/queryhotsubject';
	}
	else if('1'==sType)
	{
		form.action = '<%=basePath%>subject/s/querysubject';
	}
	else if('0'==sType)
	{
		form.action = '<%=basePath%>subject/s/querynewsubject';
	}
	else if('4'==sType)
	{
		form.action = '<%=basePath%>subject/s/queryhighsubject';
	}
	else if("5"==sType)
	{
		form.action = '<%=basePath%>bondTransfer/getBondTransfer';
	}
	else if("6"==sType)
	{
		form.action = '<%=basePath%>freedomsubject/s/queryfreedomsubject';
	}
	else if("7"==sType)
	{
		form.action = '<%=basePath%>crowdfund/s/querycrowfund';
	}
	form.submit();
}

var swiper = new Swiper('.swiper-container', {
	nextButton: '.swiper-button-next',
	prevButton: '.swiper-button-prev',
	slidesPerView: 3,
	resistanceRatio: 0,
	initialSlide :3,
	paginationClickable: true,
	freeMode: true
});
$(window).scroll(function() {
	var scrollTop = $(this).scrollTop();
	var scrollHeight = $(document).height();
	var windowHeight = $(this).height();
	if(scrollHeight - scrollTop - windowHeight <= 100) {
		scrollTop = 0;
		$('.footer').css('position', 'relative');
	} else {
		$('.footer').css('position', 'fixed');
	}
});




$(function() {
	$('.circle').each(function(index, el) {
		var num = $(this).find('span').text() * 3.6;
		if(num <= 180) {
			$(this).find('.right').css('transform', "rotate(" + num + "deg)");
		} else {
			$(this).find('.right').css('transform', "rotate(180deg)");
			$(this).find('.left').css('transform', "rotate(" + (num - 180) + "deg)");
		};
	});
});

<%-- function getBondTransfer(){
	window.location.href='<%=basePath%>bondTransfer/getBondTransfer';
}

function queryhighsubject(){
	window.location.href='<%=basePath%>subject/s/queryhighsubject';
}

function querynewsubject(){
	window.location.href='<%=basePath%>subject/s/querynewsubject';
}

function querysubject(){
	window.location.href='<%=basePath%>subject/s/querysubject';
}

function queryhotsubject(){
	window.location.href='<%=basePath%>hotsubject/s/queryhotsubject';
} --%>
</script>

</html>
