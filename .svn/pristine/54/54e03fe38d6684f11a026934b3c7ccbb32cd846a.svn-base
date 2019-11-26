/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.redpackage.RedPackageController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年12月19日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.redpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.savings.SavingsBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.awardrotate.AwardRotateService;
import com.xed.financing.wxgzh.service.message.MessageService;
import com.xed.financing.wxgzh.service.messagecode.MessageCodeService;
import com.xed.financing.wxgzh.service.savings.SavingsService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.MobileMessageSavings;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.RedPackageUtil;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * 
 * 红包控制层
 * @className:com.xed.financing.wxgzh.controller.redpackage.RedPackageController
 * @description:
 * @version:v1.0.0 
 * @date:2017年12月19日 下午3:26:52
 * @author:QT
 */
@Controller
@RequestMapping("/redpackage")
public class RedPackageController
{
	
	@Autowired
	private AwardRotateService awardRotateService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private SavingsService savingsService;
	
	@Autowired
	private AccountInfoService accountInfoService;
	
	@Autowired
	private MessageCodeService messageCodeService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(RedPackageController.class);
	
	/**
	 * 拆红包
	 * @Description:
	 * @param request
	 * @param accountInfo
	 * @param usedScore
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年12月19日 下午3:37:17
	 */
	@ResponseBody
	@RequestMapping(value="/openredpackage",method=RequestMethod.POST)
	public Map<String, Object> getItem(HttpServletRequest request, AccountInfo accountInfo, String usedScore)
	{
		String result = "FAIL";
		String score = "";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try
		{
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			//已领取红包
			MessageBean mBean=new MessageBean();
			mBean.setAccountId(accountId);
			mBean.setMsgTitle("2017跨年红包奖励");
			int countredPackage=messageService.countRecordByTitle(mBean);
			
			//共获得红包
			SubjectBean subjectBean=new SubjectBean();
			subjectBean.setAccountId(accountId);
			subjectBean.setActivityBeginTime(Constants.NEW_YEAR_BEGIN_TIME);
			subjectBean.setActivityEndTime(Constants.NEW_YEAR_END_TIME);
			int allRed=subjectService.countInvestBetweenTime(subjectBean);
			
			if(allRed-countredPackage>0)
			{
				double item = Math.floor(Math.random() * 10000);
				double prize1 = RedPackageUtil.REDPACKAGE_PRIZE.get(1) * 10000 / 100;
				double prize2 = prize1 + RedPackageUtil.REDPACKAGE_PRIZE.get(2) * 10000 / 100;
				double prize3 = prize2 + RedPackageUtil.REDPACKAGE_PRIZE.get(3) * 10000 / 100;
				double prize4 = prize3 + RedPackageUtil.REDPACKAGE_PRIZE.get(4) * 10000 / 100;
				double prize5 = prize4 + RedPackageUtil.REDPACKAGE_PRIZE.get(5) * 10000 / 100;
				
				System.out.println("奖项随机数-->" + item);
				
				// 获取当前用户
				//String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
				if (item >= 0 && item <= prize1)
				{
					//现金券
					item = 1;
				}
				else if (item >= (prize1 + 1) && item <= prize2)
				{
					//加息券
					item = 2;
				}
				else if (item >= (prize2 + 1) && item <= prize3)
				{
					//鱼干
					item = 3;
				}
				else if (item >= (prize3 + 1) && item <= prize4)
				{
					//小黄米
					item = 4;
				}
				else if (item >= (prize4 + 1) && item <= prize5)
				{
					//SK-II神仙水
					item = 5;
				}
				
				// 用户信息
				AccountInfo account = awardRotateService.getAccountScore(accountId);

				double money = 0.0;
				
				// 获得奖励鱼干
				AccountScoreBean accountScoreInfo = new AccountScoreBean();
				accountScoreInfo.setAccountId(account.getAccountId());
				accountScoreInfo.setInExpend(Constants.DEVIL_NUM_ZERO);
				accountScoreInfo.setScoreType(Constants.DEVIL_NUM_FOUR);

				// 现金券券奖品
				if (item == 1)
				{
					// 发放优惠券
					money = awardRotateService.grantRewards(2, account,Constants.RED_PACKAGE_VALUE);
				}
				//	加息券
				if (item == 2 )
				{
					// 发放优惠券
					money = awardRotateService.grantRewards(6, account,Constants.RED_PACKAGE_VALUE);
				}
				// 获奖奖品为鱼干
				else if (item == 3)
				{
					// 发放鱼干
					money = awardRotateService.updateAccountScore(5, account, accountScoreInfo,Constants.RED_PACKAGE_VALUE);
				}
				//小黄米 SK-II神仙水
				else if (item == 4 || item == 5 )
				{
					SubjectBean sBean=new SubjectBean();
					MessageBean outMessageBean = new MessageBean();
					sBean.setAccountId(accountId);
					//奖励金类型（0现金券 1加息券 2实物奖励）
					sBean.setAwardType(Constants.DEVIL_NUM_TWO);
					
					//奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标）  
					sBean.setAwardFrom(Constants.DEVIL_NUM_ZERO);
					
					//标类型（-1所有 0新手标，1精选理财 4爆款 ）   
					sBean.setSubjectType("-1");
					
					//0首次投资 1累计投资 2满足等额 3大于等额
					sBean.setInterestType("3");
					
					sBean.setMonthProfit(Constants.YUANDAN_KUANIAN_MONEY);
					
					//0未发送 1已发送
					sBean.setIsSend(Constants.DEVIL_NUM_ZERO);
					if(item == 4)
					{
						sBean.setGoodsId(Constants.XIAOHUANMI_GOODS);
						sBean.setRemark("跨年活动投资满2000得实物红包：小黄米一袋");
						outMessageBean.setMsgContent("跨年活动投资满2000得实物红包：小黄米一袋，请至<a href='javascript:void(0)' onclick='goDetails(10)'>收货地址</a>完善您的信息。");
					}
					else
					{
						sBean.setGoodsId(Constants.SHENXIANSHUI_GOODS);
						sBean.setRemark("跨年活动投资满2000得实物红包：SK-II神仙水一瓶");
						outMessageBean.setMsgContent("跨年活动投资满2000得实物红包：SK-II神仙水一瓶，请至<a href='javascript:void(0)' onclick='goDetails(10)'>收货地址</a>完善您的信息。");
					}
					subjectService.addAwardRecord(sBean);
					
					// 发送消息
					outMessageBean.setAccountId(accountId);
					outMessageBean.setMsgTitle("2017跨年红包奖励");
					
					messageService.addMessageInfo(outMessageBean);
				}
				
				
				
				
				// 扣除抽奖鱼干
				result="SUCCESS";
				System.out.println("奖项结果数-->" + item);
				resultMap.put("item", item);
				resultMap.put("money", money);
			}	
			resultMap.put("result", result);
			resultMap.put("accountScore", score);
		}
		catch (Exception e)
		{
			logger.error("鱼干查询成功", e);
		}
	
		return resultMap;
	}
	
	/**
	 * 获取当前 猫咪储蓄红包
	 * @Description:
	 * @param request
	 * @param accountInfo
	 * @param usedScore
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 下午3:07:01
	 */
	@ResponseBody
	@RequestMapping(value="/getRedPackage",method=RequestMethod.POST)
	public Map<String, Object> getRedPackage(HttpServletRequest request, AccountInfo accountInfo, String usedScore)
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try
		{
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			
			//查询出用户未使用的猫咪储蓄(最近一次)
			SavingsBean savingsBean = new SavingsBean();
			savingsBean.setAccountId(accountId);
			SavingsBean sBean = savingsService.findSavingsNearest(savingsBean);

			resultMap.put("money", sBean.getSavingsMoney());
			resultMap.put("savingsId", sBean.getSavingsId());
		}
		catch (Exception e)
		{
			logger.error("获取当前红包失败", e);
		}
	
		return resultMap;
	}

	/**
	 * 拆 猫咪储蓄红包
	 * @Description:
	 * @param request
	 * @param accountInfo
	 * @param usedScore
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 下午3:07:01
	 */
	@ResponseBody
	@RequestMapping(value="/redpackageopen",method=RequestMethod.POST)
	public Map<String, Object> redPackageOpen(HttpServletRequest request, String savingsId)
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try
		{
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			
			//
			SavingsBean savingsBean = new SavingsBean();
			savingsBean.setAccountId(accountId);
			savingsBean.setSavingsId(savingsId);
			
			//使用该猫咪储蓄
			savingsService.updateUseType(savingsBean);
			
			//根据savingsId查询信息
			savingsBean = savingsService.findSavingsInfo(savingsBean);
			
			//添加消息
			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(accountId);
			outMessageBean.setMsgTitle("猫咪储蓄");
			outMessageBean.setMsgContent("您使用猫咪储蓄红包，获得" + savingsBean.getSavingsMoney() + "元猫咪储蓄金额。");
			messageService.addMessageInfo(outMessageBean);
			
			resultMap.put("result","success");
			
		}
		catch (Exception e)
		{
			resultMap.put("result","fail");
			logger.error("鱼干查询成功", e);
		}
	
		return resultMap;
	}
	
	/**
	 * 猫咪储蓄提取
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 下午5:48:05
	 */
	@ResponseBody
	@RequestMapping(value = "/extractSavings")
	public void extractSavings(HttpServletRequest request, HttpServletResponse response){
		//ModelAndView mv = new ModelAndView();
		// 设置标识
		String result = "{\"result\":\"error\"}";
		//查出当前用户的猫咪储蓄
		AccountInfo account = (AccountInfo) request.getSession().getAttribute("account");
		
		//获取用户猫咪储蓄金额
		SavingsBean sBean = findAllMoney(request, account);	
		
		String savingsMoney = sBean.getSavingsMoney();
		int sMoney = Integer.parseInt(savingsMoney);	
			try
			{
				if(sMoney >= 10000){
					accountInfoService.sendRecommendReward(account, 3, "10000");
				}else if(sMoney < 10000 && sMoney > 0){
					
					accountInfoService.sendRecommendReward(account, 3, "" + (sMoney/2));
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//将该用户的猫咪储蓄清 “0”
		try
		{
			int count = savingsService.updateWithdrawalsType(sBean);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = "{\"result\":\"success\"}";
		
		//用户通过非常规操作
		if(sMoney == 0){
			result = "{\"result\":\"abnormal\"}";
		}
		
		response.setContentType("application/json");
		try
		{
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (IOException e)
		{
			logger.error("IO异常", e);
		}
	}
	
	/**
	 * 进入猫咪储蓄罐
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月9日 下午5:16:53
	 */
	@RequestMapping("/toSavings")
	public String toSavings(HttpServletRequest request){
		//查出当前用户的猫咪储蓄
		AccountInfo account = (AccountInfo) request.getSession().getAttribute("account");
		
		//获取用户猫咪储蓄金额
		SavingsBean sBean = findAllMoney(request, account);	
		//String allmoney = "" + (Double.parseDouble(MoneyUtils.changeFToY(sBean.getSavingsMoney())) > 100 ? 100 : MoneyUtils.changeFToY(sBean.getSavingsMoney()));
		//是否满100   0：不满  1：满
		String fmoney = "";
		double savingMoney = Double.parseDouble(MoneyUtils.changeFToY(sBean.getSavingsMoney()));
		String allmoney = "";
		//+ (savingMoney > 100 ? 100 : MoneyUtils.changeFToY(sBean.getSavingsMoney()));
				
		if(savingMoney >= 100){
			allmoney = "100";
			fmoney = "1";
		}else{
			allmoney = "" + savingMoney;
			fmoney = "0";
		}
		
		
		//用户未使用的猫咪储蓄
		List<SavingsBean> listNoUsed = null;
		try
		{
			listNoUsed = savingsService.findNotUsed(sBean);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//其他猫咪储蓄
		List<SavingsBean> listSavingsOther = null;
		try
		{
			listSavingsOther = savingsService.findSavingsOther(sBean);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("listSavingsOther", listSavingsOther);
		request.setAttribute("listNoUsed", listNoUsed);
		request.setAttribute("allmoney", allmoney);
		request.setAttribute("fmoney", fmoney);
		return "savings/savings";
	}
	
	/**
	 * 查询用户猫咪出息总额
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月9日 下午5:47:44
	 */
	public SavingsBean findAllMoney(HttpServletRequest request, AccountInfo account){
		
		//获取用户猫咪储蓄金额
		SavingsBean savingsBean = new SavingsBean();
		savingsBean.setAccountId(account.getAccountId());
		try
		{
			savingsBean = savingsService.findAllMonetById(savingsBean);
			savingsBean.setAccountId(account.getAccountId());
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return savingsBean;
	}
	
	/**
	 * 赠送
	 * @Description:
	 * @param request
	 * @param telephone
	 * @param savingsId
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月11日 上午11:39:19
	 */
	@ResponseBody
	@RequestMapping(value = "/givingRedPackage", method = RequestMethod.POST)
	public Map<String, Object> givingRedPackage(HttpServletRequest request, String telephone, String savingsId){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try
		{
			if(!StringTools.isMobileNO(telephone)){
				map.put("result", "errorPhone");
			}
			
			if(!StringTools.isNullOrEmpty(telephone)){
				//检查用户是否注册 
				if(accountInfoService.checkTelephone(telephone)){
					//已经注册
					
					AccountInfo account = (AccountInfo) request.getSession().getAttribute("account");
					SavingsBean savingsBean = new SavingsBean();
					savingsBean.setAccountId(account.getAccountId());
					savingsBean.setSavingsId(savingsId);
					savingsBean.setGiveAccountId(telephone);
					
					//被赠送人添加记录
					String giveAccountId = accountInfoService.getAccountInfoByPhone(telephone).getAccountId();
					String giveMoney = savingsService.findSavingsInfo(savingsBean).getSavingsMoney().replace(",", "");
					
					//红包的用户id
					String sId = savingsService.findSavingsInfo(savingsBean).getAccountId();
					if(!sId.equals(account.getAccountId())){
						map.put("result", "adderror");
					}else if(!giveAccountId.equals(account.getAccountId())){
						//返回值："addsuccess" : "addfail"
						String result = savingsService.addSavingsRecord(giveAccountId, "" + MoneyUtils.changeYToF(giveMoney), "2", 1);
						
						
						//更改赠送人的记录信息
						savingsService.updateGiveAccountId(savingsBean);
						
						//发送短信信息
						String message = MobileMessageSavings.sendMsg(telephone, account.getTelephone(), MoneyUtils.changeYToF(giveMoney));
						messageCodeService.addMessage(telephone, "5");
						
						if(!message.equals("success")){
							logger.debug("短信发送异常" + message);
						}
							
						map.put("result", result);
						
					}else{
						map.put("result", "yourself");
					}
				}else{
					//未注册
					
					AccountInfo account = (AccountInfo) request.getSession().getAttribute("account");
					SavingsBean savingsBean = new SavingsBean();
					savingsBean.setAccountId(account.getAccountId());
					savingsBean.setSavingsId(savingsId);
					savingsBean.setGiveAccountId(telephone);
					
					//被赠送人添加记录
					//String giveAccountId = accountInfoService.getAccountInfoByPhone(telephone).getAccountId();
					String giveMoney = savingsService.findSavingsInfo(savingsBean).getSavingsMoney().replace(",", "");
					
					//红包的用户id
					String sId = savingsService.findSavingsInfo(savingsBean).getAccountId();
					
					if(!sId.equals(account.getAccountId())){
						map.put("result", "adderror");
					}else{
						//返回值："addsuccess" : "addfail"
						//更改赠送人的记录信息
						savingsService.updateGiveAccountIdno(savingsBean);
						map.put("result", "addsuccess");
						
						String message = MobileMessageSavings.sendMsg(telephone, account.getTelephone(), MoneyUtils.changeYToF(giveMoney));
						messageCodeService.addMessage(telephone, "5");
						if(!message.equals("success")){
							logger.debug("短信发送异常" + message);
						}
					}
				}
				
				
			}else{
				map.put("result", "addfail");
			}
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
	
	/**
	 * 去规则
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月15日 上午9:25:33
	 */
	@RequestMapping("/gorule")
	public String toRule(){
		return "savings/savingsrule";
	}
}
