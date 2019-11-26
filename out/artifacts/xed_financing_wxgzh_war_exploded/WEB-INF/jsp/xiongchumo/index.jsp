<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<base href="<%=basePath%>">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Content-Type" content="text/html;">
		<meta http-equiv="Content-Script-Type" content="text/javascript">
		<meta http-equiv="Content-Style-Type" content="text/css">
		<meta charset="utf-8">
		<meta name="viewport" id="viewport" content="width = device-width, initial-scale = 1, minimum-scale = 1, maximum-scale = 1, user-scalable=no">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta equiv="Expires" content="0">
		<link type="text/css" rel="stylesheet" href="css/xiongchumo/sidebar.css">
		<title>猫咪财富3D熊出没</title>
		<style type="text/css">
			body {
				-webkit-user-select: none;
				margin: 0 auto;
				background: #000;
				text-align: center;
			}
			.common_notice {
				display: none;
			}
			.rank {
				width: 100%;
				position: absolute;
				top: 0;
				left: 0;
				z-index: 1000;
				background-color: #140d0a;
				display: none;
			}
			
			.rank img {
				width: 100%;
			}
			
			.rank div:nth-child(2) {
				position: absolute;
				top: 55%;
				left: 0;
				width: 100%;
				height: 50px;
				background-image: url(images/gamerank-score.png);
				background-size: 100% 100%;
				background-position: center;
				background-repeat: no-repeat;
			}
			
			.rank div:nth-child(2) img {
				width: 35px;
			}
			
			.rank div:nth-child(3) {
				width: 100%;
				height: 700px;
				background-image: url(images/gamerank-ranklist.png);
				background-size: 100% 100%;
				background-position: center;
				background-repeat: no-repeat;
				position: absolute;
				top: 78%;
				margin-bottom: 120px;
			}
			
			.rank div:nth-child(3) ul {
				width: 100%;
				display: block;
				list-style-type: none;
				-webkit-margin-before: 0em;
				-webkit-margin-after: 0em;
				-webkit-margin-start: 0px;
				-webkit-margin-end: 0px;
				-webkit-padding-start: 0px;
			}
			
			.rank div:nth-child(3) ul li {
				height: 70px;
				line-height: 70px;
				color: #44260a;
				font-size: 20px;
			}
			
			.rank div:nth-child(3) ul li span:nth-child(1) {
				margin-left: 20%;
				margin-right: 20%;
			}
			
			.rank div:nth-child(4) {
				position: relative;
				height: 104px;
			}
			
			.rank div:nth-child(4) a {
				width: 20%;
				height: 80px;
				display: inline-block;
				position: absolute;
				/*background-color: white;*/
				z-index: 1500;
			}
			
			.repaly {
				bottom: 10px;
				left: 18%;
				margin-right: 10%;
			}
			
			.close {
				bottom: 10px;
				right: 40%;
				margin-left: 10%;
			}
		</style>

	</head>

	<body onorientationchange="rtalt()" style="-webkit-transform-origin: 0px 0px 0px; ">

		<div id="chf2" style="position:relative;width:320px;margin:0 auto;opacity: 1;"><canvas id="gcvs" width="320" height="416"></canvas></div>
		<audio id="footaudio" src="images/ber/foot.mp3" controls="controls" loop="loop" hidden="true"></audio>
		<audio id="bgmaudio" src="images/ber/nervas.mp3" controls="controls" loop="loop" hidden="true"></audio>
		
		<div class="moreOperation">
			<a class="checkRule">查看游戏规则</a>
			<a class="checkRank">查看排行榜</a>
			<a class="gotologin">登录拿大奖</a>
		</div>
		<div class="userInfor">
			<p><input type="text" id="telephone" value="" placeholder="请输入手机号码"/></p>
			<p><input type="text" id="name" value="" placeholder="请输入真实姓名"/></p>
			<p><a  class="trygame">游客试玩</a>
			<a  class="vipgame">登录拿大奖</a></p>	
			<img src="images/ber/userinfor-close.png" class="userInfor-close"/>
		</div>
		<div class="tips">
			<div>
				<p class="game-title">活动1：玩猫咪酷跑，获现金券大奖      <span>X</span></p>
				<p>游戏结束后完成1000米的小伙伴奖励1元现金券，2000米的2元现金券，以此类推。封顶20元现金券。 <b>此奖励仅限领一次,</b> 所以小伙伴们一定要拿出自己最满意的成绩提交给客服哦。</p>
				<p class="game-title">活动2：友情岁月，邀请好友一同来玩 </p>
				<p>把此活动分享至朋友圈，邀请好友一起来玩，24小时后可凭分享截图找猫咪客服领取5现金券奖励。<b>此奖励仅限领一次。</b></p>
				
				<li class="game-title">活动规则：
				</li>
				<li>
					1.游客试玩和不登录的用户无法参加本次活动，登录后每次成绩自动记录。
				</li>
				<li>
					2.活动时间：2017年9月7日至2017年11月7日。
				</li>
				<li>
					3.此次活动，得奖者加猫咪客服微信凭截图领取现金券奖励。奖励待客服核实后立即发放！
				</li>
				<li>
					4.如有疑问请致电：400-000-3060 或 客服微信号 18105181539
				</li>
				<li>
					5.本活动最终解释权归猫咪财富所有。
				</li>
			</div>
		</div>
		<div class="rank">
			<div><img src="images/gamerank-title.png" /></div>
			<div id="maxScore" style="font-size: 25px;font-weight: bold;color: white;line-height: 40px;">

				<!-- <img src="images/gamerank-9.png" style="margin-left: 30px;"/>
				<img src="images/gamerank-8.png"/>
				<img src="images/gamerank-7.png"/>
				<img src="images/gamerank-6.png"/>
 -->
				<img src="images/tologin.png" style="width: 100%;" class="game-tologin"/>
			</div>
			<div>
				<ul id="top_ten">
					<li><span>152****6596</span><span>99999</span></li>
					<li><span>152****6596</span><span>9999</span></li>
					<li><span>152****6596</span><span>9999</span></li>
					<li><span>152****6596</span><span>9999</span></li>
					<li><span>152****6596</span><span>9999</span></li>
					<li><span>152****6596</span><span>9999</span></li>
					<li><span>152****6596</span><span>9999</span></li>
					<li><span>152****6596</span><span>9999</span></li>
					<li><span>152****6596</span><span>9999</span></li>
					<li><span>152****6596</span><span>9999</span></li>
				</ul>
			</div>
			<div style="position: fixed;bottom: 0;width: 100%;">
				<img src="images/gamerank-bot.png" />
				<a class="close"></a>
			</div>

		</div>

	</body>
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/xiongchumo/play68.js"></script>
	<script type="text/javascript" src="js/xiongchumo/gm16.js"></script>
	<script type="text/javascript" src="js/xiongchumo/play68bar.js"></script>
	<script type="text/javascript" src="js/validate.js"></script>
	<script type="text/javascript">
		
		$('.checkRule').click(function() {
			$('.tips').css('display', 'block');
		});
		$('.gotologin').click(function() {
			$('.userInfor').css('display', 'block');
		});
		$('.tips span').click(function() {
			$('.tips').css('display', 'none');
		});
		
		$('.checkRank').click(function(){
			$('.ranking').css('display', 'block');
		});
		$('.checkRank span').click(function() {
			$('.ranking').css('display', 'none');
		});
		$('.userInfor-close').click(function() {
			$('#name').val("");
			$('#telephone').val("");
			$('.userInfor').css('display', 'none');
		});
		$('.vipgame').click(function(){
			var name = $('#name').val();
			var telephone = $('#telephone').val();
			if(!verifyValNoMsg(telephone, "mobilePhone")){
				alert('请输入正确的手机号，否则将影响您的成绩记录!');
				return ;
			}
			if(!verifyValNoMsg(name, "chineseVerification")){
				alert('请输入正确的姓名，否则将影响您的成绩记录!');
				return ;
			}
			$('.gotologin').css('display', 'none');
			$('.userInfor').css('display', 'none');
			<%-- var telephone = $('#telephone').val();
			var name = $('#name').val();
			$.ajax({
				url:"<%=basePath%>playRecord/s/submit",
				data : {
					telephone : telephone,
					name : name
				},
				success : function(data) {
					if(data.result==1){
						
					}
				}
			}); --%>
		});
		$('.trygame').click(function(){
			$('#name').val("");
			$('#telephone').val("");
			$('.userInfor').css('display', 'none');
		});
		
		$('.checkRank').click(function() {
			var name = $('#name').val();
			var telephone = $('#telephone').val();
			$.ajax({
				url:"<%=basePath%>playRecord/s/sortingScore",
				type : "POST",
				data:{name :name,telephone:telephone},
				success:function(data){
					var a = eval('('+data+')');
					var str = "";
					$(a.playRecordBeanList).each(function (index,dom){
						str += "<li><span>"+dom.telephone+"</span><span>"+dom.score+"</span></li>";
					});
					
					str +="<li><span></span><span></span></li><li><span></span><span></span></li>";
					$('#top_ten').html(str);
					$('#chf2').css('display', 'none');
					$('.rank').css('display', 'block');
					if($("#name").val()===''){
						$('.rank div:nth-child(2)').css('background-image','none'); 
						$('.rank div:nth-child(2) img').css('display','none');
						$('.game-tologin').css('display','block');
					}else{
						var score =[0,0,0,0];
						if(a.playRecordBean){
							score = a.playRecordBean.score.split('');
						}
						var ss = '<img src="images/gamerank-'+score[0]+'.png" style="margin-left: 30px;"/>'+
								'<img src="images/gamerank-'+score[1]+'.png"/>'+
								'<img src="images/gamerank-'+score[2]+'.png"/>'+
								'<img src="images/gamerank-'+score[3]+'.png"/>'+
								'<img src="images/tologin.png" style="width: 100%;" class="game-tologin"/>';
					
						/* $(a.playRecordBean).each(function (index,dom){
							ss += '<img src="images/gamerank-'+dom.score+'.png" style="margin-left: 30px;"/>'+
									'<img src="images/gamerank-'+dom.score+'.png"/>'+
									'<img src="images/gamerank-'+dom.score+'.png"/>'+
									'<img src="images/gamerank-'+dom.score+'.png"/>'+
									'<img src="images/tologin.png" style="width: 100%;" class="game-tologin"/>';
						}); */
						$('#maxScore').html(ss);
						$('.rank div:nth-child(2)').css('background-image','url(images/gamerank-score.png)');
						$('.game-tologin').css('display','none');
						$('.rank div:nth-child(2) img').css('display','inline-block');
					}
				}
			});
		});
		$(function(){
			$('.repaly').click(function() {
				
			});
		});
		
		$('.close').click(function() {
			$('#chf2').css('display', 'block');
			$('.rank').css('display', 'none');
			$('.moreOperation').css('display','block');
		});

       $('.game-tologin').click(function() {
			$('.userInfor').css('display', 'block');
			$('.rank').css('display', 'none');
			$('#chf2').css('display', 'block');
		});
		
	</script>

</html>
