<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<base href="<%=basePath%>">
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/validate.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/animate.css"/>
<link rel="stylesheet" href="css/activity/rank.css" />

<title>518猫咪财富全民理财节排行榜</title>


</head>

<body>
<div id="rank">
			<div class="rankbox">
				<div class="rank_kind">
					<span onclick="rich()" class="rich">富豪榜</span>
					<span onclick="connection()" class="connection">人脉榜</span>
				</div>
				<div class="rank_list">
					<div class="rank_box">
						<div class="rank_rich animated">
							<div class="top_three">
								<c:if test="${two==null }">
									<div class="silver">
										<div class="rank_photo rank_photo_2">
											<c:if test="${two.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${two.accountIcon!=null }">
												<img src="${two.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${two.telephone }</p>
											<p class="money">${two.awardMoney }暂未上榜</p> 
										</div>
									</div>
								</c:if>
								<c:if test="${two!=null }">
									<div class="silver">
										<div class="rank_photo rank_photo_2">
											<c:if test="${two.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${two.accountIcon!=null }">
												<img src="${two.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${two.telephone }</p>
											<p class="money">${two.awardMoney }元</p> 
										</div>
									</div>
								</c:if>
								<c:if test="${one==null }">
									<div class="gold"> 
										<div class="rank_photo rank_photo_1">
											<c:if test="${one.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${one.accountIcon!=null }">
												<img src="${one.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${one.telephone }</p>
											<p class="money">${one.awardMoney }暂未上榜</p>
										</div>
									</div>
								</c:if>
								<c:if test="${one!=null }">
									<div class="gold"> 
										<div class="rank_photo rank_photo_1">
											<c:if test="${one.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${one.accountIcon!=null }">
												<img src="${one.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${one.telephone }</p>
											<p class="money">${one.awardMoney }元</p>
										</div>
									</div>
								</c:if>
								<c:if test="${three==null }">
									<div class="copper">
										<div class="rank_photo rank_photo_3">
											<c:if test="${three.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${three.accountIcon!=null }">
												<img src="${three.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${three.telephone }</p>
											<p class="money">${three.awardMoney }暂未上榜</p>
										</div>
									</div>
								</c:if>
								<c:if test="${three!=null }">
									<div class="copper">
										<div class="rank_photo rank_photo_3">
											<c:if test="${three.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${three.accountIcon!=null }">
												<img src="${three.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${three.telephone }</p>
											<p class="money">${three.awardMoney }元</p>
										</div>
									</div>
								</c:if>
							</div>
							<div class="top_others">
								<div class="top_box">
								<!-- 4-7排行榜 -->
									<c:forEach items="${sub}" var="sub" varStatus="i">
										<div class="rank_person">
											<div class="rank_num">
												<img src="./images/activity/fiveoneight/risk/lcj-rank-${4+i.index}.png" alt="" />
											</div>
										<div class="headshot">
											<c:if test="${sub.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png" />
											</c:if>
											<c:if test="${sub.accountIcon!=null }">
												<img src="${sub.accountIcon }" />
											</c:if>
										</div>
											<div class="rank_name">
												${sub.telephone }
											</div>
											<div class="rank_money">
												${sub.awardMoney }元
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="rank_connection animated slideInRight">
							<div class="top_three">
								<c:if test="${TWO==null }">
									<div class="silver">
										<div class="rank_photo rank_photo_2">
											<c:if test="${TWO.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${TWO.accountIcon!=null }">
												<img src="${TWO.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${TWO.telephone }</p>
											<p class="money">${TWO.inviterNum }暂未上榜</p>
										</div>
									</div>
								</c:if>
								<c:if test="${TWO!=null }">
									<div class="silver">
										<div class="rank_photo rank_photo_2">
											<c:if test="${TWO.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${TWO.accountIcon!=null }">
												<img src="${TWO.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${TWO.telephone }</p>
											<p class="money">${TWO.inviterNum }人</p>
										</div>
									</div>
								</c:if>
								<c:if test="${ONE==null }">
									<div class="gold">
										<div class="rank_photo rank_photo_1">
											<c:if test="${ONE.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${ONE.accountIcon!=null }">
												<img src="${ONE.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${ONE.telephone }</p>
											<p class="money">${ONE.inviterNum }暂未上榜</p>
										</div>
									</div>
								</c:if>
								<c:if test="${ONE!=null }">
									<div class="gold">
										<div class="rank_photo rank_photo_1">
											<c:if test="${ONE.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${ONE.accountIcon!=null }">
												<img src="${ONE.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${ONE.telephone }</p>
											<p class="money">${ONE.inviterNum }人</p>
										</div>
									</div>
								</c:if>
								<c:if test="${THREE==null }">
									<div class="copper">
										<div class="rank_photo rank_photo_3">
											<c:if test="${THREE.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${THREE.accountIcon!=null }">
												<img src="${THREE.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${THREE.telephone }</p>
											<p class="money">${THREE.inviterNum }暂未上榜</p>
										</div>
									</div>
								</c:if>
								<c:if test="${THREE!=null }">
									<div class="copper">
										<div class="rank_photo rank_photo_3">
											<c:if test="${THREE.accountIcon==null }">
												<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png"/>
											</c:if>
											<c:if test="${THREE.accountIcon!=null }">
												<img src="${THREE.accountIcon }"/>
											</c:if>
										</div>
										<div class="rank_mes">
											<p class="rank_name">${THREE.telephone }</p>
											<p class="money">${THREE.inviterNum }人</p>
										</div>
									</div>
								</c:if>
							</div>
							<div class="top_others">
								<div class="top_box">
									<c:forEach  items="${subj}" var="subj" varStatus="i">
										<div class="rank_person">
											<div class="rank_num">
												<img src="./images/activity/fiveoneight/risk/lcj-rank-${4+i.index}.png" alt="" />
											</div>
											<div class="headshot">
												<c:if test="${subj.accountIcon==null }">
													<img src="./images/activity/fiveoneight/risk/wx-vip-headpic-0.png" />
												</c:if>
												<c:if test="${subj.accountIcon!=null }">
													<img src="${subj.accountIcon }" />
												</c:if>
											</div>
											<div class="rank_name">
												${subj.telephone }
											</div>
											<div class="rank_money">
												${subj.inviterNum }人
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
	function rich(){
		$(".rank_rich").addClass("slideInLeft")
		$(".rank_rich").show();
		$(".rank_connection").hide();
		$(".rich").css({'background':'white','color':'#29a1ff'});
		$(".connection").css({'background':'#29a1ff','color':'white'});
	}
	function connection(){
		$(".rank_connection").show();
		$(".rank_rich").hide();
		$(".connection").css({'background':'white','color':'#29a1ff'});
		$(".rich").css({'background':'#29a1ff','color':'white'});
	}
</script>
</body>
</html>
