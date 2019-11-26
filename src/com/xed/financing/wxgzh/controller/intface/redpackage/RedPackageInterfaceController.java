/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.redpackage.RedPackageInterfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:penggang
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月17日    penggang  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.redpackage;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.controller.redpackage.RedPackageController;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.savings.SavingsBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.awardrotate.AwardRotateService;
import com.xed.financing.wxgzh.service.message.MessageService;
import com.xed.financing.wxgzh.service.messagecode.MessageCodeService;
import com.xed.financing.wxgzh.service.savings.SavingsService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.MobileMessageSavings;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * 猫咪储蓄
 * @className:com.xed.financing.wxgzh.controller.intface.redpackage.RedPackageInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月17日 上午11:35:48
 * @author:penggang
 */
@Controller
@RequestMapping("/ios/redpackage")
public class RedPackageInterfaceController
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
	 * 进入猫咪储蓄罐
	 * @Description:/s/iostosavings/tosavings
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月9日 下午5:16:53
	 */
	@ResponseBody
	@RequestMapping("/tosavings")
	public JSONObject toSavings(String accountId){
		
		JSONObject obj = new JSONObject();
		
		//获取用户猫咪储蓄金额
		SavingsBean sBean = findAllMoney(accountId);	
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
		obj.put("msg", "");
		obj.put("code", 200);
		JSONObject objs = new JSONObject();
		objs.put("listSavingsOther", JsonUtil.listToJson(listSavingsOther));
		objs.put("listNoUsed", JsonUtil.listToJson(listNoUsed));
		//猫咪储蓄总额
		objs.put("allmoney", allmoney);
		//是否满100   0：不满  1：满
		objs.put("fmoney", fmoney);
		obj.put("data", objs);
		return obj;
	}
	
	/**
	 * 拆 猫咪储蓄红包
	 * @Description:/s/iostosavings/redpackageopens
	 * @param request
	 * @param accountInfo
	 * @param usedScore
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 下午3:07:01
	 */
	@ResponseBody
	@RequestMapping("/redpackageopens")
	public JSONObject redPackageOpen(String accountId, String savingsId)
	{
		JSONObject obj = new JSONObject();
		try
		{
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
			
			obj.put("msg", "");
			obj.put("code", 200);
			
			
		}
		catch (Exception e)
		{
			obj.put("msg", "存入失败");
			obj.put("code", 300);
			logger.error("拆猫咪储蓄红包异常！", e);
		}
	
		return obj;
	}
	
	/**
	 * 猫咪储蓄提取
	 * @Description:/s/iostosavings/extractSavings
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 下午5:48:05
	 */
	@ResponseBody
	@RequestMapping("/extractSavings")
	public JSONObject extractSavings(String accountId){
		JSONObject obj = new JSONObject();
		//获取用户猫咪储蓄金额
		SavingsBean sBean = findAllMoney(accountId);	
		AccountInfo account=new AccountInfo();
		account.setAccountId(accountId);
		String savingsMoney = sBean.getSavingsMoney();
		int sMoney = Integer.parseInt(savingsMoney);	
		try
		{
			if(sMoney >= 10000){
				accountInfoService.sendRecommendReward(account, 3, "10000");
			}else if(sMoney < 10000 && sMoney > 0){
				accountInfoService.sendRecommendReward(account, 3, "" + (sMoney/2));
			}
			//将该用户的猫咪储蓄清 “0”
			int count = savingsService.updateWithdrawalsType(sBean);
			obj.put("msg", "");
			obj.put("code", 200);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
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
	public SavingsBean findAllMoney(String accountId){
		
		//获取用户猫咪储蓄金额
		SavingsBean savingsBean = new SavingsBean();
		savingsBean.setAccountId(accountId);
		try
		{
			savingsBean = savingsService.findAllMonetById(savingsBean);
			savingsBean.setAccountId(accountId);
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
	 * @Description:/s/iostosavings/givingRedPackages
	 * @param request
	 * @param telephone
	 * @param savingsId
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月11日 上午11:39:19
	 */
	@ResponseBody
	@RequestMapping("/givingRedPackages")
	public JSONObject givingRedPackage(String accountId, String telephone, String savingsId){
		JSONObject obj = new JSONObject();
		try
		{
			AccountInfo account=accountInfoService.getAccountInfo(accountId);
			//后台校验赠送人手机号码
			if(!StringTools.isMobileNO(telephone)){
				obj.put("msg", "手机号码异常");
				obj.put("code", 300);
			}
			else
			{
				//检查赠送人是否注册 
				if(accountInfoService.checkTelephone(telephone))
				{
					//已经注册
					SavingsBean savingsBean = new SavingsBean();
					savingsBean.setAccountId(accountId);
					savingsBean.setSavingsId(savingsId);
					savingsBean.setGiveAccountId(telephone);
					
					//被赠送人添加记录
					String giveAccountId = accountInfoService.getAccountInfoByPhone(telephone).getAccountId();
					String giveMoney = savingsService.findSavingsInfo(savingsBean).getSavingsMoney().replace(",", "");
					
					//红包的用户id
					String sId = savingsService.findSavingsInfo(savingsBean).getAccountId();
					if(!giveAccountId.equals(accountId))
					{
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
						if("addsuccess".equals(result))
						{
							obj.put("msg", "赠送成功");
							obj.put("code", 200);
						}
						else
						{
							obj.put("msg", "赠送失败");
							obj.put("code", 302);
						}
					}
					else
					{
						obj.put("msg", "不能赠送给自己");
						obj.put("code", 301);
					}
				}
				else
				{
					//未注册
					SavingsBean savingsBean = new SavingsBean();
					savingsBean.setAccountId(accountId);
					savingsBean.setSavingsId(savingsId);
					savingsBean.setGiveAccountId(telephone);
					
					//被赠送人添加记录
					//String giveAccountId = accountInfoService.getAccountInfoByPhone(telephone).getAccountId();
					String giveMoney = savingsService.findSavingsInfo(savingsBean).getSavingsMoney().replace(",", "");
					
					
					//返回值："addsuccess" : "addfail"
					//更改赠送人的记录信息
					savingsService.updateGiveAccountIdno(savingsBean);
					obj.put("msg", "赠送成功");
					obj.put("code", 200);
					
					String message = MobileMessageSavings.sendMsg(telephone, account.getTelephone(), MoneyUtils.changeYToF(giveMoney));
					messageCodeService.addMessage(telephone, "5");
					if(!message.equals("success")){
						logger.debug("短信发送异常" + message);
					}
				}
				
				
			}
			
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
}
