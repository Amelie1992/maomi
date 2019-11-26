/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.activity.ActivityController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月23日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.activity;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.activityrecord.ActivityRecordBean;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;
import com.xed.financing.wxgzh.model.message.CompanyMessageBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.signin.SignInBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.service.activityrecord.ActivityRecordService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.investrecord.InvestRecordService;
import com.xed.financing.wxgzh.service.message.MessageService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.sendcash.SendCashCouponService;
import com.xed.financing.wxgzh.service.signin.SignInService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.service.userlevel.UserLevelService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.controller.activity.ActivityController
 * @description:
 * @version:v1.0.0
 * @date:2017年3月23日 下午2:14:50
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/activity")
public class ActivityController
{
	
	@Autowired
	private ActivityRecordService activityRecordService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ParamService paramService;
	
	@Autowired
	private SignInService service;
	
	@Autowired
	private UserLevelService userLevelService;
	
	@Autowired
	private AccountInfoService accountInfoService;
	
	@Autowired
	private InvestRecordService investRecordService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private SendCashCouponService sendCashCouponService;
	
	@Autowired
	private AccountLevelService accountLevelService;
	
	@Autowired
	private CapitalService capitalService;

	@Resource
	private ParamMapper paramMapper;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(ActivityController.class);

	
	@RequestMapping("/s/goactivity")
	public String goactivity(HttpServletRequest request)
	{
		// 获取当前用户
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
		try
		{
			Map<String, Integer> countCalligraphy = new HashMap<String, Integer>();
			if(accountInfo!=null){
				String accountId = accountInfo.getAccountId();
				ActivityRecordBean activityRecordBean = new ActivityRecordBean();
				activityRecordBean.setAccountId(accountId);
				activityRecordBean.setGainCode("1");
				countCalligraphy.put("niu", activityRecordService.countNotConvertible(activityRecordBean));
				activityRecordBean.setGainCode("2");
				countCalligraphy.put("lang", activityRecordService.countNotConvertible(activityRecordBean));
				activityRecordBean.setGainCode("3");
				countCalligraphy.put("zhi", activityRecordService.countNotConvertible(activityRecordBean));
				activityRecordBean.setGainCode("4");
				countCalligraphy.put("nv", activityRecordService.countNotConvertible(activityRecordBean));
				
			}else{
				countCalligraphy.put("niu", 0);
				countCalligraphy.put("lang", 0);
				countCalligraphy.put("zhi", 0);
				countCalligraphy.put("nv", 0);
			}
			request.setAttribute("counts", countCalligraphy);
			
			//没有登录
			if(StringTools.isNullOrEmpty(request.getSession().getAttribute("account")))
			{
				request.setAttribute("nationalCounts","0");
				//是否满签
				request.setAttribute("fullSignCounts","8");
				request.setAttribute("inviteFriendCounts","0");
			}
			else
			{
				SubjectBean subjectBean=new SubjectBean();
				subjectBean.setAccountId(accountInfo.getAccountId());
				//---------------------------国庆标是否获得现金券--------------------------------
				//奖励金类型（0现金券 1加息券）
				subjectBean.setAwardType(Constants.DEVIL_NUM_ZERO);
				//奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标）  
				subjectBean.setAwardFrom(Constants.DEVIL_NUM_ZERO);
				
				//是否获奖
				request.setAttribute("nationalCounts",subjectService.countIsGetAward(subjectBean));
				if(!StringTools.isNullOrEmpty(subjectService.queryAwardById(subjectBean)))
				{
					//查询是否发送 大于0则发送了
					subjectBean.setIsSend("1");
					request.setAttribute("nationalFlag",subjectService.countIsGetAward(subjectBean));
					//获奖金额
					request.setAttribute("nationalMoney",subjectService.queryAwardById(subjectBean).getAwardMoney());
				}
				//---------------------------------------------------------------------------
				
				
				//---------------------------国庆8天满签是否获得现金券--------------------------------
				//奖励金类型（0现金券 1加息券）
				subjectBean.setAwardType(Constants.DEVIL_NUM_ZERO);
				//奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标）  
				subjectBean.setAwardFrom(Constants.DEVIL_NUM_ONE);
				
				SignInBean signInBean = new SignInBean();
				signInBean.setAccountId(accountInfo.getAccountId());
				String beginDate=paramService.getParamVal("SIGN_BEGIN_DATE");
				String endDate=paramService.getParamVal("SIGN_END_DATE");
				signInBean.setBeginDate(beginDate);
				signInBean.setEndDate(endDate);
				//是否满签
				request.setAttribute("fullSignCounts",8-service.countSignOn(signInBean));
				if(!StringTools.isNullOrEmpty(subjectService.queryAwardById(subjectBean)))
				{
					//查询是否发送 大于0则发送了
					subjectBean.setIsSend("1");
					request.setAttribute("fullSignFlag",subjectService.countIsGetAward(subjectBean));
					//获奖金额
					request.setAttribute("fullSignMoney",subjectService.queryAwardById(subjectBean).getAwardMoney());
				}
				
				//---------------------------------------------------------------------------
				
				//---------------------------邀请好友是否获得现金券--------------------------------
				//奖励金类型（0现金券 1加息券）
				subjectBean.setAwardType(Constants.DEVIL_NUM_ZERO);
				//奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标）  
				subjectBean.setAwardFrom(Constants.DEVIL_NUM_THREE);
				//是否获奖
				subjectBean.setIsSend("");
				request.setAttribute("inviteFriendCounts",subjectService.countIsGetAward(subjectBean));
				//查询是否发送 大于0则发送了
				subjectBean.setIsSend("1");
				request.setAttribute("inviteFriendFlag",subjectService.countIsGetAward(subjectBean));
				//---------------------------------------------------------------------------
				
			}
			
			
		}
		catch (Exception e)
		{
			logger.error("去活动页面异常", e);
		}

		return "activity/nationalactivity";
	}
	
	
	/**
	 * 跳转中秋活动页面
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年9月26日 下午6:29:25
	 */
	@RequestMapping("/s/gomidactivity")
	public String goMidActivity(HttpServletRequest request)
	{
		
		try
		{
			//---------------------------中秋标是否获得加息券--------------------------------
			// 获取当前用户
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			//没有登录
			if(StringTools.isNullOrEmpty(request.getSession().getAttribute("account")))
			{
				request.setAttribute("midAutunmCounts","0");
			}
			else
			{
				SubjectBean subjectBean=new SubjectBean();
				subjectBean.setAccountId(accountInfo.getAccountId());
				//奖励金类型（0现金券 1加息券）
				subjectBean.setAwardType(Constants.DEVIL_NUM_ONE);
				//奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标）  
				subjectBean.setAwardFrom(Constants.DEVIL_NUM_ZERO);
				//是否获奖
				request.setAttribute("midAutunmCounts",subjectService.countIsGetAward(subjectBean));
				//查询是否发送 大于0则发送了
				subjectBean.setIsSend("1");
				request.setAttribute("midAutunmFlag",subjectService.countIsGetAward(subjectBean));
				//获奖金额
				request.setAttribute("midAutunmMoney",subjectService.queryAwardById(subjectBean));
			}
			
			//---------------------------------------------------------------------------
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "activity/midautumnactivity";
	}
	/**
	 * 兑换集字活动
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月22日 下午5:49:58
	 */
	/*@RequestMapping("/grantrewards")*/
	@ResponseBody
	@RequestMapping(value="/grantrewards",method=RequestMethod.POST)
	public Map<String, Object> grantRewards(HttpServletRequest request)
	{

		Map<String, Object> resultMap = new HashMap<String, Object>();

		try
		{
			String result = activityRecordService.exchangeCalligraphy(request);
			
			
			
			resultMap.put("result", result);
		}
		catch (Exception e)
		{
			logger.error("兑换集字活动异常", e);
		}
		return resultMap;
	}
	
	/**
	 * 双十二活动
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年12月6日 上午10:12:37
	 */
	@RequestMapping("/s/twelveactivity")
	public String queryTweleveActivity(HttpServletRequest request)
	{
		SubjectBean sBean=new SubjectBean();
		sBean.setSubjectId(Constants.TWELVE_ACTIVITY_IPHONEX);
		try
		{
			sBean=subjectService.querySubjectById(sBean);
			request.setAttribute("limitcount", Constants.TWELVE_ACTIVITY_IPHONEX_COUNT-subjectService.countTwelveActivity(sBean)-Integer.parseInt(paramService.getParamVal("TWELEVE_LIMIT_COUNT")));
		}
		catch (SQLException e)
		{
			logger.error("查询双十二iphoneX异常！", e);
		}
		request.setAttribute("sBean", sBean);
		return "activity/twelveActivity";
	}
	
	/**
	 * 
	 * 双十二活动详情
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年12月7日 上午10:29:11
	 */
	@RequestMapping("/s/detailtwelveactivity")
	public String detailTweleveActivity(HttpServletRequest request,String type)
	{
		SubjectBean sBean=new SubjectBean();
		sBean.setSubjectId(Constants.TWELVE_ACTIVITY_IPHONEX);
		try
		{
			//如果拼路径进详情 默认进30000档
			if(StringTools.isNullOrEmpty(type))
			{
				type="-2";
			}
			sBean=subjectService.querySubjectById(sBean);
			request.setAttribute("limitcount", Constants.TWELVE_ACTIVITY_IPHONEX_COUNT-subjectService.countTwelveActivity(sBean)-Integer.parseInt(paramService.getParamVal("TWELEVE_LIMIT_COUNT")));
			request.setAttribute("type", type);
		}
		catch (SQLException e)
		{
			logger.error("查询双十二iphoneX异常！", e);
		}
		request.setAttribute("sBean", sBean);
		return "activity/twelveActivityDetail";
	}
	
	/**
	 * 双十二活动
	 * @Description:
	 * @param type
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年12月6日 下午5:15:31
	 */
	@ResponseBody
	@RequestMapping("/paytwelve")
	public void checkMoney(String type,String color,HttpServletRequest request,HttpServletResponse response)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		response.setContentType("application/json");
		// 检查账户余额是否足
		try
		{
			double investMoney =0;
			String money="";
			String flag = "errorflag";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String nowDate = sdf.format(date);
			if((!Constants.DEVIL_NUM_ONE.equals(color)) && (!Constants.DEVIL_NUM_TWO.equals(color)))
			{
				result = "{\"result\":\"errorsys\"}";
			}
			else if(!DateUtils.compareDateLong(nowDate, paramMapper.getParamVal("TWELVE_BEGIN_TIME"))){
				result = "{\"result\":\"notbegin\"}";
			}
			else if(DateUtils.compareDateLong(nowDate, paramMapper.getParamVal("TWELVE_END_TIME"))){
				result = "{\"result\":\"isend\"}";
			}
			else
			{
				if("-1".equals(type) || "-2".equals(type))
				{
					if("-1".equals(type))
					{
						money=Constants.TWELVE_ACTIVITY_INVEST_TWO;
						
					}
					else if("-2".equals(type))
					{
						money=Constants.TWELVE_ACTIVITY_INVEST_THREE;
					}
					investMoney=Integer.parseInt(money);
					SubjectBean subjectBean = new SubjectBean();
					// 获取页面Id
					subjectBean.setSubjectId(Constants.TWELVE_ACTIVITY_IPHONEX);
					
					// 从session中查询出账户ID
					String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
					
					subjectBean.setAccountId(accountId);
					
					subjectBean = subjectService.querySubjectById(subjectBean);
					
					//金额bean
					CapitalBean capitalBean = new CapitalBean();
					capitalBean.setAccountId(accountId);
					capitalBean = capitalService.queryCapitalById(capitalBean);
					
					//用户余额
					double balance = capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney();
					
					int limitcount=10-subjectService.countTwelveActivity(subjectBean)-Integer.parseInt(paramService.getParamVal("TWELEVE_LIMIT_COUNT"));
					if(limitcount>0)
					{
						//用户余额大于投标金额
						if(balance>=investMoney)
						{
							//---------------------------------------投资操作↓---------------------------------------------------------
						
							//个人/公司用户(0:个人 1:公司)
							String isCompany=accountInfoService.getAccountInfo(accountId).getIsCompany();
								
							subjectService.findSubject( money, Constants.TWELVE_ACTIVITY_IPHONEX,"",color,accountId);
							
							//投入了本金  后台已增加完积分  判断积分是否足够升级
							if(Integer.parseInt(money)>0)
							{
								AccountInfo accountInfoBean = new AccountInfo();
								accountInfoBean=accountInfoService.getLoginAccountInfo(request);
								
								//如果是企业用户
								if(isCompany.equals(Constants.DEVIL_NUM_ONE) )
								{
									SubjectBean sBean =new SubjectBean();
									sBean.setAccountId(accountId);
									//企业用户投标次数
									int companySubject = subjectService.countCompanySubject(sBean);
									//投标记录在721行已经插入 所以判断是否第一次投标必须用1判断
									if(companySubject==1)
									{
										flag = "isflag";
										
										//公司首次投标奖励金额
										String firstreward=paramService.getParamVal("COMPANY_FIRST_REWARD");
										String contents="企业用户首次投标，将获得"+firstreward+"元奖励金，自动转入到您绑定的银行卡，将在1~3个工作日到账";
										CompanyMessageBean companyMessageBean = new CompanyMessageBean();
										companyMessageBean.setAccountId(accountId);
										companyMessageBean.setMsgContent(contents);
										//通知类型（0首次充值奖励，1首次投标奖励）
										companyMessageBean.setMsgType(Constants.DEVIL_NUM_ONE);
										//是否发送（0未发送，1已发送）
										companyMessageBean.setIsSend(Constants.DEVIL_NUM_ZERO);
											
										//添加企业用户消息通知
										messageService.addCompanyMessage(companyMessageBean);
										
										MessageBean messageBean =new MessageBean();
										messageBean.setAccountId(accountId);
										messageBean.setMsgTitle("企业用户首次投标奖励");
										messageBean.setMsgContent(contents);
										
										//添加系统消息
										messageService.addMessageInfo(messageBean);
									}
								}
								
								//判断是否有邀请人
								if(!StringTools.isNullOrEmpty(accountInfoBean.getRecommendTelephone()))
								{
									//邀请人信息
									AccountInfo account = accountInfoService.getAccountInfoByPhone(accountInfoBean.getRecommendTelephone());
									
									//判断是否第一次投标
									InvestRecordBean investRecordBean = new InvestRecordBean();
									investRecordBean.setAccountId(accountId);
									if(investRecordService.countFirstSubject(investRecordBean)==1)
									{
										if(accountInfoService.checkIdCard(account) == 1)
										{
											//判断是否新用户
											//给邀请人发送首次投资奖励
											accountInfoService.sendRecommendReward(account, 1, money);
										}
										
									
									}else if(investRecordService.countFirstSubject(investRecordBean)==2){
										if(accountInfoService.checkIdCard(account) == 1){	
											//判断是否新用户
											//给邀请人发送第二次投资奖励
											accountInfoService.sendRecommendReward(account, 2, money);
										}
									}
								}
								//改变等级
								accountLevelService.updateVIP(accountId);
							}
								result = "{\"result\":\"twelveActivity\",\"flag\":\""+flag+"\"}";
							//---------------------------------------投资操作↑---------------------------------------------------------
						}
						else
						{
							//余额不足
							result = "{\"result\":\"errorLow\"}";
						}
					}
					else
					{
						//库存不足
						result = "{\"result\":\"errorcount\"}";
					}
				}
				else
				{
					//系统异常
					result = "{\"result\":\"errorsys\"}";
				}
			}
			
		
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (SQLException e)
		{
			logger.error("sql异常", e);
		}
		catch (Exception e) {
			logger.error("异常", e);
		}
	}
	
	/**
	 * 去圣诞活动页面
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月19日 上午9:58:48
	 */
	@RequestMapping(value="/s/christmasActivity")
	public String christmasActivity(){
		return "activity/christmasActivity";
	}
	
	/**
	 * 去元旦活动页面
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月19日 上午9:58:48
	 */
	@RequestMapping(value="/s/yuandanActivity")
	public String yuandanActivity(HttpServletRequest request){
		int countredPackage=0;
		int allRed=0;
		try
		{
			if(!StringTools.isNullOrEmpty((AccountInfo) request.getSession().getAttribute("account")))
			{
				String accountId=((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
				//已领取红包
				MessageBean mBean=new MessageBean();
				mBean.setAccountId(accountId);
				mBean.setMsgTitle("2017跨年红包奖励");
				
				countredPackage=messageService.countRecordByTitle(mBean);
				
				
				
				//共获得红包
				SubjectBean subjectBean=new SubjectBean();
				subjectBean.setAccountId(accountId);
				subjectBean.setActivityBeginTime(Constants.NEW_YEAR_BEGIN_TIME);
				subjectBean.setActivityEndTime(Constants.NEW_YEAR_END_TIME);
				allRed=subjectService.countInvestBetweenTime(subjectBean);
				
				if(allRed>=5)
				{
					allRed=5;
				}
			}
		}
		catch (SQLException e)
		{
			logger.error("跳转双旦活动异常", e);
		}
		
		request.setAttribute("countredPackage",countredPackage);
		request.setAttribute("noGetRed", allRed-countredPackage);
		request.setAttribute("allRed", allRed);
		return "activity/yuandanActivity";
	}
	
	/**
	 * 春节活动
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月5日 下午2:07:01
	 */
	@RequestMapping(value="/s/springFestival")
	public String toSpringFestival(HttpServletRequest request){
		try{
			// 从session中查询出账户ID
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			
			if(StringTools.isNullOrEmpty(accountInfo)){
				request.setAttribute("count1", 3);
				request.setAttribute("count2", 3);
				request.setAttribute("count3", 3);
				request.setAttribute("count4", 3);
				return "activity/springFestival";
			}
			String accountId = accountInfo.getAccountId();
			
			//设置查询条件
			SubjectBean subjectBean = setSelectCondition(accountId, "5", "1", "-1", "2", "50000", "1", Constants.SPRING_FESTIVAL_BEGIN_TIME, Constants.SPRING_FESTIVAL_END_TIME);
			int ac1 = subjectService.countIsGetAward(subjectBean);
			
			//设置查询条件
			subjectBean = setSelectCondition(accountId, "5", "5", "-1", "2", "300000", "1", Constants.SPRING_FESTIVAL_BEGIN_TIME, Constants.SPRING_FESTIVAL_END_TIME);
			int ac2 = subjectService.countIsGetAward(subjectBean);
			
			//设置查询条件
			subjectBean = setSelectCondition(accountId, "5", "4", "-1", "2", "500000", "1", Constants.SPRING_FESTIVAL_BEGIN_TIME, Constants.SPRING_FESTIVAL_END_TIME);
			int ac3 = subjectService.countIsGetAward(subjectBean);
			
			//设置查询条件
			subjectBean = setSelectCondition(accountId, "5", "4", "-1", "2", "1000000", "1", Constants.SPRING_FESTIVAL_BEGIN_TIME, Constants.SPRING_FESTIVAL_END_TIME);
			int ac4 = subjectService.countIsGetAward(subjectBean);
			
			request.setAttribute("count1", ac1);
			request.setAttribute("count2", ac2);
			request.setAttribute("count3", ac3);
			request.setAttribute("count4", ac4);
			
			
		}catch (SQLException e)
		{
			logger.error("跳转春节活动异常", e);
		}
		
		
		
		return "activity/springFestival";
	}
	/**
	 * 设置春节活动查询条件
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月2日 下午2:23:05
	 */
	public SubjectBean setSelectCondition(String accountId, String awardFrom, String awardtype, String subjectType, 
			String investType, String conditionMoney, String chooseFlag, String beginTime, String endTime){
		SubjectBean subjectBean = new SubjectBean();
		subjectBean.setAccountId(accountId);
		
		//奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标 4参与活动 5春节活动）
		subjectBean.setAwardFrom(awardFrom);
		//奖励金类型  0现金券 1加息券 2红包实物奖励 3实物奖励 4鱼干 5新手再投次数
		subjectBean.setAwardType(awardtype);
		//设置标类型（-1所有 0新手标，1精选理财 4爆款 ）
		subjectBean.setSubjectType(subjectType);
		//投资方式（0首次投资 1累计投资 2满足等额 3大于等额）
		subjectBean.setInvestType(investType);
		//设置条件金额
		subjectBean.setSetMoney(conditionMoney);
		//设置选择模式 加入时间选择
		subjectBean.setChooseFlag(chooseFlag);
		//设置活动开始时间
		subjectBean.setActivityBeginTime(beginTime);
		//设置活动结束时间
		subjectBean.setActivityEndTime(endTime);
		return subjectBean;
	}
	
	/**
	 * 跳转518理财节
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年5月10日 下午5:21:52
	 */
	@RequestMapping("/s/fiveoneeight")
	public String toFiveOneEightActivity()
	{
		return "activity/fiveoneeight";
	}
	
	/**
	 * 跳转排行榜
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年5月10日 下午5:41:43
	 */
	@RequestMapping("/s/fiveoneeightrsking")
	public String toFiveOneEightRisking(HttpServletRequest request,SubjectBean subjectBean)
	{
		try
		{
			//---------------------------------------富豪榜-----------------------------------------------
			//投资金额前10名
			List<SubjectBean> sub = subjectService.rich(subjectBean);
			for (SubjectBean sub2 : sub)
			{
				//-------------处理手机号--------------
				String phone = sub2.getTelephone();
				String phoneNumber = phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
				sub2.setTelephone(phoneNumber);
			}
			
			if(sub.size()>3)
			{
				//除去前三的list
				List<SubjectBean> subLst = sub.subList(3, sub.size());
				request.setAttribute("sub", subLst);//list
			}
			//前3
			else if(sub.size()==1)
			{
				request.setAttribute("one", sub.get(0));//one
			}
			else if(sub.size()==2)
			{
				request.setAttribute("one", sub.get(0));//one
				request.setAttribute("two", sub.get(1));//two
			}
			else if(sub.size()==3)
			{
				request.setAttribute("one", sub.get(0));//one
				request.setAttribute("two", sub.get(1));//two
				request.setAttribute("three", sub.get(2));//three
			}
			
			
			//---------------------------------------人脉榜-----------------------------------------------
			//邀请好友前7名
			List<SubjectBean> subj = subjectService.connection(subjectBean);
			for (SubjectBean sub2 : subj)
			{
				//-------------处理手机号--------------
				String phone = sub2.getTelephone();
				String phoneNumber = phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
				sub2.setTelephone(phoneNumber);
			}
			if(subj.size()>3)
			{
				//除去前三的list
				List<SubjectBean> subjLst = subj.subList(3, subj.size());
				request.setAttribute("subj", subjLst);//list
			}
			//前3名
			else if(subj.size()==1)
			{
				request.setAttribute("ONE", subj.get(0));//one
			}
			else if(subj.size()==2)
			{
				request.setAttribute("ONE", subj.get(0));//one
				request.setAttribute("TWO", subj.get(1));//two
			}
			else if(subj.size()==3)
			{
				request.setAttribute("ONE", subj.get(0));//one
				request.setAttribute("TWO", subj.get(1));//two
				request.setAttribute("THREE", subj.get(2));//three
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "activity/inviterisking";
	}
	
	/**
	 * 跳转2018暑期出国游活动页面
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年7月4日 上午11:32:28
	 */
	@RequestMapping("/goabroad")
	public String toGoAbroad(HttpServletRequest request)
	{
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		SubjectBean sBean=new SubjectBean();
		sBean.setAwardFrom("7");
		sBean.setAccountId(accountId);
		//查询未兑换出国游机会
		int noGoAbroadCount=0;
		//查询未好友返现机会
		int noInviteFriendCount=0;
		
		//查询已兑换出国游机会
		int yesGoAbroadCount=0;
		//查询已好友返现机会
		int yesInviteFriendCount=0;
		String flag="no";
		try
		{
			//判断用户是否有两个都满足的记录
			sBean.setAwardType("-1");
			noInviteFriendCount=subjectService.countIsGetAward(sBean);
			//没有满足两个的
			if(noInviteFriendCount==0)
			{
				//查询邀请好友未兑换次数
				sBean.setAwardType("-3");
				noInviteFriendCount=subjectService.countIsGetAward(sBean);
			}
			else
			{
				flag="yes";
			}
				
			//查询出国游未兑换次数
			sBean.setAwardType("-2");
			noGoAbroadCount=subjectService.countIsGetAward(sBean);
			
			
			//查询已兑换邀请好友
			sBean.setAwardType("0");
			yesInviteFriendCount=subjectService.countIsGetAward(sBean);
			//查询出国游已兑换次数
			sBean.setAwardType("4");
			yesGoAbroadCount=subjectService.countIsGetAward(sBean);
			
			request.setAttribute("noInviteFriendCount",noInviteFriendCount );
			request.setAttribute("noGoAbroadCount",noGoAbroadCount );
			request.setAttribute("yesInviteFriendCount",yesInviteFriendCount );
			request.setAttribute("yesGoAbroadCount", yesGoAbroadCount);
			request.setAttribute("flag", flag);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "activity/goabroad";
	}
	
	/**
	 * 出国详情
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年7月4日 下午4:31:20
	 */
	@RequestMapping("/goabroaddetail")
	public String toGoAbroadDetail(HttpServletRequest request,String type)
	{
		String s="activity/gothailanddetail";
		if("2".equals(type))
		{
			s="activity/govietnamdetail";
		}
		
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		SubjectBean sBean=new SubjectBean();
		sBean.setAwardFrom("7");
		sBean.setAccountId(accountId);
		//查询未兑换出国游机会
		int noGoAbroadCount=0;
		//查询未好友返现机会
		int noInviteFriendCount=0;
		
		//查询已兑换出国游机会
		int yesGoAbroadCount=0;
		//查询已好友返现机会
		int yesInviteFriendCount=0;
		String flag="no";
		try
		{
			//判断用户是否有两个都满足的记录
			sBean.setAwardType("-1");
			noInviteFriendCount=subjectService.countIsGetAward(sBean);
			//没有满足两个的
			if(noInviteFriendCount==0)
			{
				//查询邀请好友未兑换次数
				sBean.setAwardType("-3");
				noInviteFriendCount=subjectService.countIsGetAward(sBean);
			}
			else
			{
				flag="yes";
			}
				
			//查询出国游未兑换次数
			sBean.setAwardType("-2");
			noGoAbroadCount=subjectService.countIsGetAward(sBean);
			
			
			//查询已兑换邀请好友
			sBean.setAwardType("0");
			yesInviteFriendCount=subjectService.countIsGetAward(sBean);
			//查询出国游已兑换次数
			sBean.setAwardType("4");
			yesGoAbroadCount=subjectService.countIsGetAward(sBean);
			
			request.setAttribute("noInviteFriendCount",noInviteFriendCount );
			request.setAttribute("noGoAbroadCount",noGoAbroadCount );
			request.setAttribute("yesInviteFriendCount",yesInviteFriendCount );
			request.setAttribute("yesGoAbroadCount", yesGoAbroadCount);
			request.setAttribute("flag", flag);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * 兑换出国游奖励
	 * @Description:
	 * @param request
	 * @param type
	 * @param aType
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年7月5日 上午9:20:50
	 */
	@ResponseBody
	@RequestMapping("/convertabroad")
	public Map<String,String> exchange(HttpServletRequest request,String type,String aType)
	{
		Map<String,String> map=new HashMap<String, String>();
		String result="error";
		String accountId=((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		SubjectBean subjectBean=new SubjectBean();
		subjectBean.setAccountId(accountId);
		//奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标 4参与活动 5春节活动 6理财节）
		subjectBean.setAwardFrom("7");
		//查询未兑换出国游机会
		int noGoAbroadCount=0;
		//查询未好友返现机会
		int noInviteFriendCount=0;
		List<SubjectBean> awardList=null;
		try
		{
			//兑换出国游
			if("1".equals(type))
			{
				subjectBean.setAwardType("2");
				noGoAbroadCount=subjectService.countIsGetAward(subjectBean);
				if(noGoAbroadCount<=0)
				{
					result="nochoice";
				}
				else if(noGoAbroadCount==1)
				{
					//判断用户兑换了几张  如果已经兑换了两张则不能兑换
					subjectBean.setAwardType("4");
					if(subjectService.countIsGetAward(subjectBean)<2)
					{
						subjectBean.setAwardType("2");
						subjectBean=subjectService.queryAwardById(subjectBean);
						subjectBean.setAwardType(aType);
						subjectService.updateAward(subjectBean);
						if("6".equals(aType))
						{
							addMessage(accountId, "暑期送清凉-猫咪带你出国游", "您成功兑换泰国游。");
						}else if("7".equals(aType))
						{
							addMessage(accountId, "暑期送清凉-猫咪带你出国游", "您成功兑换越南游。");
						}else if("8".equals(aType))
						{
							addMessage(accountId, "暑期送清凉-猫咪带你出国游", "您成功兑换泰国游折现。");
						}else if("9".equals(aType))
						{
							addMessage(accountId, "暑期送清凉-猫咪带你出国游", "您成功兑换越南游折现。");
						}
						result="success";
					}
					else
					{
						result="limit";
					}
				}
				else
				{
					awardList=subjectService.queryAwardList(subjectBean);
					int opp=0;
					for (SubjectBean sBean : awardList)
					{
						while(opp<1)
						{
							if("-2".equals(sBean.getAwardType()))
							{
								//判断用户兑换了几张  如果已经兑换了两张则不能兑换
								subjectBean.setAwardType("4");
								if(subjectService.countIsGetAward(subjectBean)<2)
								{
									subjectBean.setAwardType(aType);
									subjectBean.setAwardId(sBean.getAwardId());
									subjectService.updateAward(subjectBean);
									if("6".equals(aType))
									{
										addMessage(accountId, "暑期送清凉-猫咪带你出国游", "您成功兑换泰国游。");
									}else if("7".equals(aType))
									{
										addMessage(accountId, "暑期送清凉-猫咪带你出国游", "您成功兑换越南游。");
									}else if("8".equals(aType))
									{
										addMessage(accountId, "暑期送清凉-猫咪带你出国游", "您成功兑换泰国游折现。");
									}else if("9".equals(aType))
									{
										addMessage(accountId, "暑期送清凉-猫咪带你出国游", "您成功兑换越南游折现。");
									}
									opp++;
									result="success";
								}
								else
								{
									opp++;
									result="limit";
								}
								
							}
							else
							{
								break;
							}
							
						}
					}
				}
				
			}
			//兑换好友返现
			else if("2".equals(type))
			{
				subjectBean.setAwardType("1");
				noInviteFriendCount=subjectService.countIsGetAward(subjectBean);
				if(noInviteFriendCount<=0)
				{
					result="nochoice";
				}
				else
				{
					subjectBean=subjectService.queryAwardById(subjectBean);
					subjectBean.setAwardType("0");
					subjectService.updateAward(subjectBean);
					addMessage(accountId, "暑期送清凉-好友超级返", "您成功给推荐好友返现");
					result="success";
				}
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("result", result);
		return map;
	}
	
	private void addMessage(String accountId,String msgTitle,String msgContent)
	{
		MessageBean messageBean =new MessageBean();
		messageBean.setAccountId(accountId);
		messageBean.setMsgTitle(msgTitle);
		messageBean.setMsgContent(msgContent);
		try
		{
			messageService.addMessageInfo(messageBean);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 2018国庆活动
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月27日 上午10:15:30
	 */
	@RequestMapping("/s/tenone")
	public String toTenOne(HttpServletRequest request)
	{
		int cout=0;
		String iMoneySum="0";
		//从session中查询出账户ID
		AccountInfo accountInfo = (AccountInfo)request.getSession().getAttribute("account");
		//登录状态
		if(!StringTools.isNullOrEmpty(accountInfo))
		{
			String accountId=accountInfo.getAccountId();
			SubjectBean sBean=new SubjectBean();
			sBean.setAccountId(accountId);
			sBean.setActivityBeginTime(Constants.FIVE_ZERO_EIGHT_ACTIVITY_BEGIN_TIME_HOUR);
			sBean.setActivityEndTime(Constants.FIVE_ZERO_EIGHT_ACTIVITY_END_TIME_HOUR);
			try
			{
				iMoneySum=subjectService.querySumElevenMoney(sBean).getInvestMoney();
				double i=Double.parseDouble(iMoneySum);
				if(i>=30000&&i<50000)
				{
					cout=1;
				}
				else if(i>=50000&&i<80000)
				{
					cout=2;
				}
				else if(i>=80000&&i<100000)
				{
					cout=3;
				}
				else if(i>=100000)
				{
					cout=4;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				logger.error("2018跳转国庆页面异常", e);
			}
		}
		request.setAttribute("cout", cout);
		request.setAttribute("iMoneySum", iMoneySum);
		return "activity/tenone";
	}
	
	/**
	 * 2018双十二活动
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年12月4日 下午3:55:59
	 */
	@RequestMapping("/s/twoTwelve")
	public String toTwelveAndTwelve(HttpServletRequest request)
	{
		int cout=0;
		String iMoneySum="0";
		//从session中查询出账户ID
		AccountInfo accountInfo = (AccountInfo)request.getSession().getAttribute("account");
		//登录状态
		if(!StringTools.isNullOrEmpty(accountInfo))
		{
			String accountId=accountInfo.getAccountId();
			SubjectBean sBean=new SubjectBean();
			sBean.setAccountId(accountId);
			sBean.setActivityBeginTime(Constants.TWELVE_AND_TWELVE_ACTIVITY_BEGIN_TIME_HOUR);
			sBean.setActivityEndTime(Constants.TWELVE_AND_TWELVE_ACTIVITY_END_TIME_HOUR);
			try
			{
				iMoneySum=subjectService.querySumElevenMoney(sBean).getInvestMoney();
				double i=Double.parseDouble(iMoneySum);
				if(i>=5000&&i<10000)
				{
					cout=1;
				}
				else if(i>=10000&&i<20000)
				{
					cout=2;
				}
				else if(i>=20000&&i<40000)
				{
					cout=3;
				}
				else if(i>=40000&&i<60000)
				{
					cout=4;
				}
				else if(i>=60000&&i<80000)
				{
					cout=5;
				}
				else if(i>=80000&&i<100000)
				{
					cout=6;
				}
				else if(i>=100000)
				{
					cout=7;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				logger.error("2018跳转双十二活动页面异常", e);
			}
		}
		request.setAttribute("cout", cout);
		request.setAttribute("iMoneySum", iMoneySum);
		return "activity/twoTwelve";
	}
}

