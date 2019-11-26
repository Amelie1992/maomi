/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.signin.impl.SignInServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月13日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.signin.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper;
import com.xed.financing.wxgzh.mapper.accountlevel.AccountLevelMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.mapper.signin.SignInMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.signin.SignInBean;
import com.xed.financing.wxgzh.service.signin.SignInService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.LevelParam;

/**
 * @className:com.xed.financing.wxgzh.service.signin.impl.SignInServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年4月13日 下午4:17:00
 * @author:ZhangJun
 */
@Service
public class SignInServiceImpl implements SignInService
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(SignInServiceImpl.class);

	@Resource
	private SignInMapper signInMapper;

	@Resource
	private AccountScoreMapper accountScoreMapper;

	@Resource
	private ParamMapper paramMapper;

	@Resource
	private MessageMapper messageMapper;
	
	@Resource
	private AccountLevelMapper accountLevelMapper;

	@Override
	public Integer queryCurrentMonthSignInDayCount(String accountId) throws SQLException
	{
		return signInMapper.queryCurrentMonthSignInDayCount(accountId);
	}
	

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.signin.SignInService#queryCurrentMonthSignInScoreCount(java.lang.String)
	 */
	@Override
	public Integer queryCurrentMonthSignInScoreCount(String accountId) throws SQLException
	{
		return signInMapper.queryCurrentMonthSignInScoreCount(accountId);
	}

	@Override
	public List<SignInBean> queryCurrentMonthSignInList(String accountId) throws SQLException
	{
		List<SignInBean> signInBean = signInMapper.queryCurrentMonthSignInList(accountId);
		for (SignInBean bean : signInBean)
		{
			bean.setSigninDate(bean.getSigninDate().replaceAll("-", ""));
		}
		return signInBean;
	}

	@Override
	@Transactional
	public Integer addSignIn(SignInBean signInBean)
	{
		try
		{
			return signInMapper.addSignIn(signInBean);
		}
		catch (Exception e)
		{
			logger.error("添加签到信息异常");
			throw new RuntimeException();
		}

	}

	@Override
	public Integer checkSignIn(String accountId) throws SQLException
	{
		return signInMapper.checkSignIn(accountId);
	}
	
	/** 
     * 获取当月的 天数 
     * */  
    public static int getCurrentMonthDay() {  
          
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }  

	@Override
	@Transactional
	public String addBonusPoints(HttpServletRequest request, String accountId,Map<String, Object> map)
	{
		// 返回的结果
		String result = "";
		try
		{
			// 获得当前用户的鱼干和经验,等级
			AccountInfo accountInfo = accountScoreMapper.findScoreAndExp(accountId);
			map.put("accountInfo", accountInfo);
			// 获得当前月累计签到天数
			Integer count = signInMapper.queryCurrentMonthSignInDayCount(accountId);
			map.put("count", count);
			// 用户VIP等级
			String level = accountInfo.getAccountLevel();
			// 累计加息点
			Double rate = LevelParam.SIGN_INTEREST_RATE.get(level);
			// 累计加息
			Double rateAll = rate*count;
			map.put("rate",rate);
			map.put("rateAll",rateAll);
			
			
			// 增加的鱼干，和累计签到奖励鱼干
			Integer scores = 0;
			// 创建鱼干明细
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(accountId);
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ZERO);
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_ZERO);
			accountScoreBean.setModReason("签到鱼干");

			// 每日签到奖励鱼干增加
			scores += Integer.parseInt(paramMapper.getParamVal(Constants.DAILY_POINTS));
			String message = "签到成功，奖励" + scores + "鱼干";

			// 判断累计签到奖励鱼干增加
			if (Constants.DEVIL_NUM_SEVEN.equals(String.valueOf(count)))
			{
				scores += Integer.parseInt(paramMapper.getParamVal(Constants.EXTRA_POINTS_SEVENS));
				message = "签到成功，已累计签到" + Constants.DEVIL_NUM_SEVEN + "天,奖励" + scores + "鱼干";
			}
			else if (Constants.DEVIL_NUM_TWENTY.equals(String.valueOf(count)))
			{
				scores += Integer.parseInt(paramMapper.getParamVal(Constants.EXTRA_POINTS_TWENTY));
				message = "签到成功，已累计签到" + Constants.DEVIL_NUM_TWENTY + "天,奖励" + scores + "鱼干";
			}
			else if (String.valueOf(getCurrentMonthDay()).equals(String.valueOf(count)))
			{
				scores += Integer.parseInt(paramMapper.getParamVal(Constants.EXTRA_POINTS_ALLDAY));
				message = "签到成功，您当月已经满签,奖励" + scores + "鱼干";
			}

			// 鱼干明细输入奖励鱼干数量
			accountScoreBean.setScore(String.valueOf(scores));
			// 账户添加鱼干，经验
			accountInfo.setAccountExp(String.valueOf(Integer.valueOf(accountInfo.getAccountExp()) + scores));
			accountInfo.setAccountScore(String.valueOf(Integer.valueOf(accountInfo.getAccountScore()) + scores));
			accountScoreMapper.changeScoreAndExp(accountInfo);
			// 添加用户鱼干明细
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);

			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(accountId);
			outMessageBean.setMsgTitle("签到成功");
			outMessageBean.setMsgContent(message);
			messageMapper.addMessageInfo(outMessageBean);
		}
		catch (Exception e)
		{
			logger.error("签到奖励鱼干，发送消息异常");
			throw new RuntimeException();
		}
		return result;
	}


	@Override
	public Integer countSignOn(SignInBean signInBean) throws SQLException
	{
		return signInMapper.countSignOn(signInBean);
	}


	@Override
	public String signingYesterday(AccountInfo accountInfo) throws SQLException
	{
		String result = "notEnough";
		//获取用户等级和可补签次数
		AccountInfo info = accountLevelMapper.queryAccountLevel(accountInfo);
		//判断是否还有次数
		if(Integer.parseInt(info.getRepairSignNumber())>0){
			
			//判断昨日是否签过
			if(signInMapper.changeYesterdaySign(accountInfo)==0){
				
				//获取补签消耗的鱼干数量
				Integer consumeScore = LevelParam.RETROACTIVE_DRIED_FISH.get(info.getAccountLevel());
				if(consumeScore>Integer.parseInt(info.getAccountScore())){
					result = "notScore";
				}else{
					result = "success";
				}
			}else{
				result = "isSign";
			}
		}
		return result;
	}


	@Override
	@Transactional
	public String addBonusPointsYesterDay(AccountInfo accountInfo) throws SQLException
	{
		String result = "error";
		try
		{
			AccountInfo info = accountLevelMapper.queryAccountLevel(accountInfo);
			
			//添加签到记录
			signInMapper.signYesterday(accountInfo);
			info.setRepairSignNumber(String.valueOf(Integer.parseInt(info.getRepairSignNumber())-1));
			accountLevelMapper.updateAccountVIP(info);
			
			
			// 获得当前月累计签到天数
			Integer count = signInMapper.queryCurrentMonthSignInDayCount(accountInfo.getAccountId());
			// 增加的鱼干，和累计签到奖励鱼干
			Integer scores = 0;
			// 创建鱼干明细
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(accountInfo.getAccountId());
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ZERO);
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_ZERO);
			accountScoreBean.setModReason("签到鱼干");

			// 每日签到奖励鱼干增加
			scores += Integer.parseInt(paramMapper.getParamVal(Constants.DAILY_POINTS));
			String message = "补签昨日成功，奖励" + scores + "鱼干";

			// 判断累计签到奖励鱼干增加
			if (Constants.DEVIL_NUM_SEVEN.equals(String.valueOf(count)))
			{
				scores += Integer.parseInt(paramMapper.getParamVal(Constants.EXTRA_POINTS_SEVENS));
				message = "补签昨日成功，已累计签到" + Constants.DEVIL_NUM_SEVEN + "天,奖励" + scores + "鱼干";
			}
			else if (Constants.DEVIL_NUM_TWENTY.equals(String.valueOf(count)))
			{
				scores += Integer.parseInt(paramMapper.getParamVal(Constants.EXTRA_POINTS_TWENTY));
				message = "补签昨日成功，已累计签到" + Constants.DEVIL_NUM_TWENTY + "天,奖励" + scores + "鱼干";
			}
			else if (String.valueOf(getCurrentMonthDay()).equals(String.valueOf(count)))
			{
				scores += Integer.parseInt(paramMapper.getParamVal(Constants.EXTRA_POINTS_ALLDAY));
				message = "补签昨日成功，您当月已经满签,奖励" + scores + "鱼干";
			}

			// 鱼干明细输入奖励鱼干数量
			accountScoreBean.setScore(String.valueOf(scores));
			// 添加用户鱼干明细
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);
			
			
			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(accountInfo.getAccountId());
			outMessageBean.setMsgTitle("补签成功");
			outMessageBean.setMsgContent(message);
			messageMapper.addMessageInfo(outMessageBean);
			
			//获取补签消耗的鱼干数量
			Integer consumeScore = LevelParam.RETROACTIVE_DRIED_FISH.get(info.getAccountLevel());
			
			//补签消耗鱼干
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ONE);
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_TEN);
			accountScoreBean.setModReason("特权补签");
			accountScoreBean.setScore(String.valueOf(consumeScore));
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);
			
			
			// 账户添加鱼干，经验
			info.setAccountExp(String.valueOf(Integer.valueOf(info.getAccountExp()) + scores));
			info.setAccountScore(String.valueOf(Integer.valueOf(info.getAccountScore()) + scores - consumeScore));
			accountScoreMapper.changeScoreAndExp(info);
			
			result = "success";
		}
		catch (Exception e)
		{
			logger.error("补签奖励鱼干，发送消息异常");
			throw new RuntimeException();
		}
		
		return result;
	}


	@Override
	public Integer changeYesterdaySign(AccountInfo accountInfo) throws SQLException
	{
		return signInMapper.changeYesterdaySign(accountInfo);
	}

	
}
