/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.integralscore.impl.IntegralScoreServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月14日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.integralscore.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.goldDetails.GoldDetailsMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.golddetails.GoldDetailsBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.fuiou.FuiouService;
import com.xed.financing.wxgzh.service.integralscore.IntegralScoreService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.InterfaceUtil;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.MoneyUtils;

import net.sf.json.JSONObject;

/**
 * @className:com.xed.financing.wxgzh.service.integralscore.impl.IntegralScoreServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年4月14日 下午5:49:03
 * @author:ZhangJun
 */
@Service
public class IntegralScoreServiceImpl implements IntegralScoreService
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(IntegralScoreServiceImpl.class);
	
	@Resource
	private AccountInfoMapper accountInfoMapper;

	@Resource
	private ParamMapper paramMapper;

	@Resource
	private BondTransferMapper bondTransferMapper;

	@Resource
	private AccountScoreMapper accountScoreMapper;
	
	@Resource
	private MessageMapper messageMapper;
	
	@Resource
	private GoldDetailsMapper goldDetailsMapper;
	
	@Autowired
	private FuiouService fuiouService;

	@Override
	@Transactional
	public void sendMessage(HttpServletRequest request)
	{
		try
		{
			// 获得登录用户的ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			// 获得登录用户信息
			AccountInfo accountInfo = accountInfoMapper.getLoginAccountInfo(accountId);
			// 根据登录用户的等级查出用户下一级需要多少经验
			Integer score = 0;
			if (Constants.DEVIL_NUM_ZERO.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_ZEOR));
			}
			else if (Constants.DEVIL_NUM_ONE.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_ONE));
			}
			else if (Constants.DEVIL_NUM_TWO.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_TWO));
			}
			else if (Constants.DEVIL_NUM_THREE.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_THREE));
			}
			else if (Constants.DEVIL_NUM_FOUR.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_FOUR));
			}
			else if (Constants.DEVIL_NUM_FIVE.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_FIVES));
			}
			else if (Constants.DEVIL_NUM_SIX.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_SIX));
			}
			else if (Constants.DEVIL_NUM_SEVEN.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_SEVEN));
			}
			else if (Constants.DEVIL_NUM_EIGHT.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_EIGHT));
			}
			else if (Constants.DEVIL_NUM_NINE.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_NINE));
			}
			else if (Constants.DEVIL_NUM_TEN.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_TEN));
			}
			// 还需要的升级经验
			score = score - Integer.parseInt(accountInfo.getAccountExp());
			// 查询用户金额
			AccountCapital capital = bondTransferMapper.getBalances(accountId);
			Integer balances = Integer.parseInt(capital.getWithdrawMoney())
					+ Integer.parseInt(capital.getNoWithdrawMoney());
			String balance = MoneyUtils.changeFToY(String.valueOf(balances));
			// 查询积分充值比率
			Integer ratio = Integer.parseInt(paramMapper.getParamVal(Constants.SCORE_RATIO));
			// --------------------------------------------------------------------------------------------------
			request.setAttribute("ratio", ratio);
			request.setAttribute("balance", balance);
			request.setAttribute("score", score);
			request.setAttribute("accountInfo", accountInfo);
		}
		catch (Exception e)
		{
			logger.error("积分充值");
			throw new RuntimeException();
		}

	}
	
	@Override
	@Transactional
	public void iosSendMessage(String accountId,JSONObject obj)
	{
		try
		{
			// 获得登录用户信息
			AccountInfo accountInfo = accountInfoMapper.getLoginAccountInfo(accountId);
			// 根据登录用户的等级查出用户下一级需要多少经验
			Integer score = 0;
			if (Constants.DEVIL_NUM_ZERO.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_ZEOR));
			}
			else if (Constants.DEVIL_NUM_ONE.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_ONE));
			}
			else if (Constants.DEVIL_NUM_TWO.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_TWO));
			}
			else if (Constants.DEVIL_NUM_THREE.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_THREE));
			}
			else if (Constants.DEVIL_NUM_FOUR.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_FOUR));
			}
			else if (Constants.DEVIL_NUM_FIVE.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_FIVES));
			}
			else if (Constants.DEVIL_NUM_SIX.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_SIX));
			}
			else if (Constants.DEVIL_NUM_SEVEN.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_SEVEN));
			}
			else if (Constants.DEVIL_NUM_EIGHT.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_EIGHT));
			}
			else if (Constants.DEVIL_NUM_NINE.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_NINE));
			}
			else if (Constants.DEVIL_NUM_TEN.equals(accountInfo.getAccountLevel()))
			{
				score = Integer.parseInt(paramMapper.getParamVal(Constants.USERLEVEL_TEN));
			}
			// 还需要的升级经验
			score = score - Integer.parseInt(accountInfo.getAccountExp());
			// 查询用户金额
			AccountCapital capital = bondTransferMapper.getBalances(accountId);
			Integer balances = Integer.parseInt(capital.getWithdrawMoney())
					+ Integer.parseInt(capital.getNoWithdrawMoney());
			String balance = MoneyUtils.changeFToY(String.valueOf(balances));
			// 查询积分充值比率
			Integer ratio = Integer.parseInt(paramMapper.getParamVal(Constants.SCORE_RATIO));
			// --------------------------------------------------------------------------------------------------
			JSONObject objs = new JSONObject();
			objs.put("ratio", ratio);
			objs.put("balance", balance);
			objs.put("score", score);
			objs.put("accountInfo",JsonUtil.beanToJson(accountInfo));
			obj.put("data",objs);
		}
		catch (Exception e)
		{
			logger.error("积分充值");
			throw new RuntimeException();
		}

	}

	/*
	@Override
	@Transactional
	public String recharge(String money, HttpServletRequest request)
	{
		try
		{
			// 获得登录用户的ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			// 查询当前登录用户的积分和经验
			AccountInfo accountInfo = accountScoreMapper.findScoreAndExp(accountId);
			// 查询账户金额
			AccountCapital capital = bondTransferMapper.getBalances(accountId);
			Integer sum = Integer.parseInt(money) * 100;
			if(sum <= Integer.parseInt(Constants.DEVIL_NUM_ZERO)){
				return "miserror";
			}
			// 判断账户金额是否充足
			if (sum > Integer.parseInt(capital.getNoWithdrawMoney()) + Integer.parseInt(capital.getWithdrawMoney()))
			{
				return "insufficient";
			}
			// 判断不可提现金额是否大于充值金额
			if (sum < Integer.parseInt(capital.getNoWithdrawMoney()))
			{
				// 只更改不可提现金额
				capital.setNoWithdrawMoney(String.valueOf(Integer.parseInt(capital.getNoWithdrawMoney()) - sum));
			}
			else
			{
				// 不可提现金额归0，再减少可提现金额
				capital.setNoWithdrawMoney("0");
				capital.setWithdrawMoney(String.valueOf(Integer.parseInt(capital.getWithdrawMoney())
						+ Integer.parseInt(capital.getNoWithdrawMoney()) - sum));
			}
			// 变更账户金额
			bondTransferMapper.changeFunds(capital);
			CapitalDetail inCapitalDetail = new CapitalDetail();
			inCapitalDetail.setAccountId(accountId);
			inCapitalDetail.setMoney(String.valueOf(sum));
			inCapitalDetail.setType(Constants.DEVIL_NUM_ELEVEN);
			inCapitalDetail.setInExpend(Constants.DEVIL_NUM_ONE);
			inCapitalDetail.setRemark("花费" + money + "购买鱼干");
			// 添加账户资金明细
			bondTransferMapper.addCapital(inCapitalDetail);
			Integer ratio = 1;
			//计算比例
			if(money.length() <= 3){
				ratio = 5;
			}else if(money.length() == 4){
				ratio = 6;
			}else if(money.length() >= 5){
				ratio = 8;
			}
			
			accountInfo.setAccountExp(String.valueOf(Integer.parseInt(accountInfo.getAccountExp())
					+ (Integer.parseInt(money) / 100)));
			accountInfo.setAccountScore(String.valueOf(Integer.parseInt(accountInfo.getAccountScore())
					+ (Integer.parseInt(money) * ratio)));
			accountScoreMapper.changeScoreAndExp(accountInfo);
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(accountId);
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ZERO);
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_FIVE);
			accountScoreBean.setModReason("鱼干充值");
			accountScoreBean.setScore(String.valueOf(Integer.parseInt(money) * ratio));
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);
			return "success";
		}
		catch (Exception e)
		{
			logger.error("鱼干充值异常");
			throw new RuntimeException();
		}
	}
	*/
	
	@Override
	public Map<String, Object> getBalance(HttpSession session) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		//用户ID
		String accountId = ((AccountInfo)session.getAttribute("account")).getAccountId();
		//用户信息
		AccountInfo accountInfo = accountInfoMapper.getAccountInfo(accountId);
		//用户账户
		String custNo  = accountInfo.getTelephone();
		AccountCapital capital = bondTransferMapper.getBalances(accountId);
		//金账户余额
		Integer jinBanlance =Integer.valueOf(capital.getNoWithdrawMoney());
		//平台账户余额
		Integer mmBalance = Integer.valueOf(capital.getWithdrawMoney());
		//总余额
		String balance = String.valueOf(Double.valueOf(jinBanlance + mmBalance)/100);
		map.put("balance", balance);
		map.put("accountInfo", accountInfo);
		return map;
	}
	
	@Override
	@Transactional
	public String recharge(String money, HttpServletRequest request)
	{
		//执行状态码
		String result = "error";
		try
		{
			AccountInfo accountBean = (AccountInfo) request.getSession().getAttribute("account");
			//获得登录用户的ID
			String accountId = accountBean.getAccountId();
			//商户账号
			String mmCustNo = paramMapper.getParamVal("JZH_SHOP");
			//用户账号
			String accountCustNo = accountBean.getTelephone();
			//查询当前登录用户的积分和经验
			AccountInfo accountInfo = accountScoreMapper.findScoreAndExp(accountId);
			//查询账户金额
			AccountCapital capital = bondTransferMapper.getBalances(accountId);
			//平台账户余额
			Integer mmBalance = Integer.valueOf(capital.getWithdrawMoney());
			//查询金账户余额(判断用户是否存在金账户)
			Integer jinBalance = Integer.valueOf(capital.getNoWithdrawMoney());
			//用户总余额
			Integer sumBalance = jinBalance + mmBalance; 
			//支付金额
			Integer sum = Integer.parseInt(money) * 100;
			if(sum <= Integer.parseInt(Constants.DEVIL_NUM_ZERO)){
				result = "miserror";
				return result;
			}
			// 判断账户金额是否充足
			if (sum.intValue() > sumBalance.intValue())
			{
				result = "insufficient";
				return result;
			}
			if(mmBalance.intValue() >= sum.intValue()) {
				// 变更账户金额
				capital.setWithdrawMoney(String.valueOf(mmBalance-sum));
				bondTransferMapper.changeFunds(capital);
			} else {
				//差额(需要扣除金账户金额)
				Integer differenceInt = sum - mmBalance;
				String difference = String.valueOf(differenceInt);
				//修改金账户余额
				Map<String, String> map = InterfaceUtil.shopToCust(accountCustNo,mmCustNo,difference);
				fuiouService.addGoldTransfer(map, accountCustNo, mmCustNo);
				String respCode = map.get("resp_code");
				System.out.println("购买鱼干修改金账户余额状态码："+respCode);
				if ("0000".equals(respCode)) {
					//添加金账户资金明细
					GoldDetailsBean goldDetailsBean = new GoldDetailsBean();
					goldDetailsBean.setInCustNo(mmCustNo);
					goldDetailsBean.setOutCustNo(accountCustNo);
					goldDetailsBean.setMoney(difference);
					goldDetailsBean.setTransferType(Constants.DEVIL_NUM_ONE);
					goldDetailsBean.setPurpose(Constants.DEVIL_NUM_THREE);
					goldDetailsBean.setRemark("花费" + Double.valueOf(difference)/100 + "元购买鱼干");
					goldDetailsMapper.addGoldDetail(goldDetailsBean);
					// 平台账户金额归0
					capital.setWithdrawMoney("0");
					capital.setNoWithdrawMoney(String.valueOf(Integer.valueOf(capital.getNoWithdrawMoney())-differenceInt));
					bondTransferMapper.changeFunds(capital);
				} else {
					return result;
				}
			}
			CapitalDetail inCapitalDetail = new CapitalDetail();
			inCapitalDetail.setAccountId(accountId);
			inCapitalDetail.setMoney(String.valueOf(sum));
			inCapitalDetail.setType(Constants.DEVIL_NUM_ELEVEN);
			inCapitalDetail.setInExpend(Constants.DEVIL_NUM_ONE);
			inCapitalDetail.setRemark("花费" + money + "元购买鱼干");
			// 添加账户资金明细
			bondTransferMapper.addCapital(inCapitalDetail);
			
			Integer ratio = 1;
			//计算比例
			if(money.length() <= 3){
				ratio = 5;
			}else if(money.length() == 4){
				ratio = 6;
			}else if(money.length() >= 5){
				ratio = 8;
			}
			accountInfo.setAccountExp(String.valueOf(Integer.parseInt(accountInfo.getAccountExp())
					+ (Integer.parseInt(money) / 100)));
			accountInfo.setAccountScore(String.valueOf(Integer.parseInt(accountInfo.getAccountScore())
					+ (Integer.parseInt(money) * ratio)));
			accountScoreMapper.changeScoreAndExp(accountInfo);
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(accountId);
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ZERO);
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_FIVE);
			accountScoreBean.setModReason("鱼干充值");
			accountScoreBean.setScore(String.valueOf(Integer.parseInt(money) * ratio));
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);
			result = "success";
		}
		catch (Exception e)
		{
			logger.error("鱼干充值异常");
			throw new RuntimeException();
		} 
		return result;

	}
	
	@Override
	@Transactional
	public String iosRecharge(String money, String accountId)
	{
		//执行状态码
		String result = "error";
		try
		{
			AccountInfo accountBean = accountInfoMapper.getLoginAccountInfo(accountId);
			//商户账号
			String mmCustNo = paramMapper.getParamVal("JZH_SHOP");
			//用户账号
			String accountCustNo = accountBean.getTelephone();
			// 查询当前登录用户的积分和经验
			AccountInfo accountInfo = accountScoreMapper.findScoreAndExp(accountId);
			// 查询账户金额
			AccountCapital capital = bondTransferMapper.getBalances(accountId);
			//平台账户余额
			Integer mmBalance = Integer.valueOf(capital.getWithdrawMoney());
			//查询金账户余额(判断用户是否存在金账户)
			Integer jinBalance = Integer.valueOf(capital.getNoWithdrawMoney());
			//用户总余额
			Integer sumBalance = jinBalance + mmBalance; 
			//支付金额
			Integer sum = Integer.parseInt(money) * 100;
			if(sum <= Integer.parseInt(Constants.DEVIL_NUM_ZERO)){
				result = "miserror";
				return result;
			}
			// 判断账户金额是否充足
			if (sum.intValue() > sumBalance.intValue())
			{
				result = "insufficient";
				return result;
			}
			if(mmBalance.intValue() >= sum.intValue()) {
				// 变更账户金额
				capital.setWithdrawMoney(String.valueOf(mmBalance-sum));
				bondTransferMapper.changeFunds(capital);
			} else {
				//差额(需要扣除金账户金额)
				Integer differenceInt = sum - mmBalance;
				String difference = String.valueOf(differenceInt);
				//修改金账户余额
				Map<String, String> map = InterfaceUtil.shopToCust(accountCustNo,mmCustNo,difference);
				fuiouService.addGoldTransfer(map, accountCustNo, mmCustNo);
				String respCode = map.get("resp_code");
				System.out.println("购买鱼干修改金账户余额状态码："+respCode);
				if ("0000".equals(respCode)) {
					//添加金账户资金明细
					GoldDetailsBean goldDetailsBean = new GoldDetailsBean();
					goldDetailsBean.setInCustNo(mmCustNo);
					goldDetailsBean.setOutCustNo(accountCustNo);
					goldDetailsBean.setMoney(difference);
					goldDetailsBean.setTransferType(Constants.DEVIL_NUM_ONE);
					goldDetailsBean.setPurpose(Constants.DEVIL_NUM_THREE);
					goldDetailsBean.setRemark("花费" + Double.valueOf(difference)/100 + "元购买鱼干");
					goldDetailsMapper.addGoldDetail(goldDetailsBean);
					// 平台账户金额归0
					capital.setWithdrawMoney("0");
					capital.setNoWithdrawMoney(String.valueOf(Integer.valueOf(capital.getNoWithdrawMoney())-differenceInt));
					bondTransferMapper.changeFunds(capital);
				} else {
					return result;
				}
			}
			CapitalDetail inCapitalDetail = new CapitalDetail();
			inCapitalDetail.setAccountId(accountId);
			inCapitalDetail.setMoney(String.valueOf(sum));
			inCapitalDetail.setType(Constants.DEVIL_NUM_ELEVEN);
			inCapitalDetail.setInExpend(Constants.DEVIL_NUM_ONE);
			inCapitalDetail.setRemark("花费" + money + "元购买鱼干");
			// 添加账户资金明细
			bondTransferMapper.addCapital(inCapitalDetail);
			Integer ratio = 1;
			//计算比例
			if(money.length() <= 3){
				ratio = 5;
			}else if(money.length() == 4){
				ratio = 6;
			}else if(money.length() >= 5){
				ratio = 8;
			}
			
			accountInfo.setAccountExp(String.valueOf(Integer.parseInt(accountInfo.getAccountExp())
					+ (Integer.parseInt(money) / 100)));
			accountInfo.setAccountScore(String.valueOf(Integer.parseInt(accountInfo.getAccountScore())
					+ (Integer.parseInt(money) * ratio)));
			accountScoreMapper.changeScoreAndExp(accountInfo);
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(accountId);
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ZERO);
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_FIVE);
			accountScoreBean.setModReason("鱼干充值");
			accountScoreBean.setScore(String.valueOf(Integer.parseInt(money) * ratio));
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);
			result = "success";
		}
		catch (Exception e)
		{
			logger.error("鱼干充值异常");
			throw new RuntimeException();
		}
		return result;
	}

	@Override
	public Integer perfectInformationIntegralReward(HttpServletRequest request) throws Exception
	{
		try
		{
			AccountInfo accountInfo = (AccountInfo)request.getSession().getAttribute("account");
			//查询当前登录用户的积分 传参：登录用户ID
			AccountInfo account = accountScoreMapper.findScoreAndExp(accountInfo.getAccountId());
			String point = paramMapper.getParamVal(Constants.PERFECT_INFO_GIFT_POINTS);
			//account.setAccountExp(String.valueOf(Integer.parseInt(account.getAccountExp())+Integer.parseInt(point)));
			account.setAccountScore(String.valueOf(Integer.parseInt(account.getAccountScore())+Integer.parseInt(point)));
			//修改用户积分和经验 传参：用户信息Bean
			accountScoreMapper.changeScoreAndExp(account);

			//添加积分明细 传参：积分明细Bean
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(accountInfo.getAccountId());
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ZERO);
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_ONE);
			accountScoreBean.setModReason("信息完善成功，奖励鱼干"+point);
			accountScoreBean.setScore(String.valueOf(point));
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);
			
			String projectUrl=paramMapper.getParamVal("MAKE_PROJECT_URL");
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(accountInfo.getAccountId());
			messageBean.setMsgTitle("完善信息成功");
			messageBean.setMsgContent("信息完善成功，奖励"+point+"鱼干。详情可至<a href='javascript:void(0)' onclick='goDetails(5)'>鱼干明细</a>查看");
			messageMapper.addMessageInfo(messageBean);
		}
		catch (Exception e)
		{
			logger.error("完善信息赠送积分异常");
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public Integer iosPerfectInformationIntegralReward(String accountId) throws Exception
	{
		try
		{
			//查询当前登录用户的积分 传参：登录用户ID
			AccountInfo account = accountScoreMapper.findScoreAndExp(accountId);
			String point = paramMapper.getParamVal(Constants.PERFECT_INFO_GIFT_POINTS);
			account.setAccountScore(String.valueOf(Integer.parseInt(account.getAccountScore())+Integer.parseInt(point)));
			//修改用户积分和经验 传参：用户信息Bean
			accountScoreMapper.changeScoreAndExp(account);

			//添加积分明细 传参：积分明细Bean
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(accountId);
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ZERO);
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_ONE);
			accountScoreBean.setModReason("信息完善成功，奖励鱼干"+point);
			accountScoreBean.setScore(String.valueOf(point));
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);
			
			String projectUrl=paramMapper.getParamVal("MAKE_PROJECT_URL");
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(accountId);
			messageBean.setMsgTitle("完善信息成功");
			messageBean.setMsgContent("信息完善成功，奖励"+point+"鱼干。详情可至<a href='javascript:void(0)' onclick='goDetails(5)'>鱼干明细</a>查看");
			messageMapper.addMessageInfo(messageBean);
		}
		catch (Exception e)
		{
			logger.error("完善信息赠送积分异常");
			throw new RuntimeException();
		}
		return null;
	}

}
