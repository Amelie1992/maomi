/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.accountInfo.impl.AccountInfoServiceImpl
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
package com.xed.financing.wxgzh.service.accountInfo.impl;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.capitaldetail.CapitaldetailMapper;
import com.xed.financing.wxgzh.mapper.coupon.CouponMapper;
import com.xed.financing.wxgzh.mapper.loginregister.LoginRegisterMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.revenueSettlement.RevenueSettlementMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.couponDetail.CouponDetail;
import com.xed.financing.wxgzh.model.couponInfo.CouponInfoBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.signin.impl.SignInServiceImpl;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.GetUUID;
import com.xed.financing.wxgzh.util.MD5Util;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.service.accountInfo.impl.AccountInfoServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年3月23日 上午11:35:35
 * @author:ZhangJun
 */
@Service
public class AccountInfoServiceImpl implements AccountInfoService
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(SignInServiceImpl.class);

	@Resource
	public AccountInfoMapper mapper;

	@Resource
	private LoginRegisterMapper loginMapper;

	@Resource
	private CapitalMapper capitalMapper;

	@Resource
	private CapitaldetailMapper capitaldetailMapper;

	@Resource
	private MessageMapper messageMapper;

	@Resource
	private CouponMapper couponMapper;
	
	@Resource
	private RevenueSettlementMapper revenueSettlementMapper;

	@Override
	public AccountInfo getLoginAccountInfo(HttpServletRequest request) throws SQLException
	{
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
		if (accountInfo == null)
		{
			return null;
		}
		accountInfo = mapper.getLoginAccountInfo(accountInfo.getAccountId());
		// 隐藏身份证号
		String idCard = accountInfo.getIdCard();
		if (!"".equals(idCard) && idCard != null)
		{
			idCard = idCard.replace(idCard.substring(4, idCard.length() - 4),
					"**********************".substring(0, idCard.length() - 8));
			accountInfo.setIdCard(idCard);
		}
		// 隐藏真实姓名
		String realName = accountInfo.getRealName();
		if (!"".equals(realName) && realName != null)
		{
			realName = realName.substring(0, 1);
			if ("0".equals(accountInfo.getAccountSex()))
			{
				realName += "先生";
			}
			else
			{
				realName += "女士";
			}
			accountInfo.setRealName(realName);
		}
		return accountInfo;
	}
	
	@Override
	public AccountInfo getLoginAccountInfo(HttpServletRequest request, String accountId) throws SQLException
	{
		if (StringTools.isNullOrEmpty(accountId))
		{
			return null;
		}
		AccountInfo accountInfo = mapper.getLoginAccountInfo(accountId);
		// 隐藏身份证号
		String idCard = accountInfo.getIdCard();
		if (!"".equals(idCard) && idCard != null)
		{
			idCard = idCard.replace(idCard.substring(4, idCard.length() - 4),
					"**********************".substring(0, idCard.length() - 8));
			accountInfo.setIdCard(idCard);
		}
		// 隐藏真实姓名
		String realName = accountInfo.getRealName();
		if (!"".equals(realName) && realName != null)
		{
			realName = realName.substring(0, 1);
			if ("0".equals(accountInfo.getAccountSex()))
			{
				realName += "先生";
			}
			else
			{
				realName += "女士";
			}
			accountInfo.setRealName(realName);
		}
		return accountInfo;
	}
	
	@Override
	public AccountInfo iosGetLoginAccountInfo(String accountId) throws SQLException
	{
		AccountInfo accountInfo = mapper.getLoginAccountInfo(accountId);
		// 隐藏身份证号
		String idCard = accountInfo.getIdCard();
		if (!"".equals(idCard) && idCard != null)
		{
			idCard = idCard.replace(idCard.substring(4, idCard.length() - 4),
					"**********************".substring(0, idCard.length() - 8));
			accountInfo.setIdCard(idCard);
		}
		// 隐藏真实姓名
		String realName = accountInfo.getRealName();
		if (!"".equals(realName) && realName != null)
		{
			realName = realName.substring(0, 1);
			if ("0".equals(accountInfo.getAccountSex()))
			{
				realName += "先生";
			}
			else
			{
				realName += "女士";
			}
			accountInfo.setRealName(realName);
		}
		return accountInfo;
	}

	@Override
	public int updAutoBid(AccountInfo accountInfo) throws SQLException
	{
		// TODO Auto-generated method stub
		return mapper.updAutoBid(accountInfo);
	}

	@Override
	public Integer checkAccountName(String accountName) throws SQLException
	{
		return mapper.checkAccountName(accountName);
	}

	@Override
	@Transactional
	public Integer changeAccountName(HttpServletRequest request, String accountName) throws SQLException
	{

		try
		{
			AccountInfo info = (AccountInfo) request.getSession().getAttribute("account");
			if (info == null)
			{
				return null;
			}
			info.setAccountId(info.getAccountId());
			info.setAccountName(accountName);
			return mapper.changeAccountName(info);
		}
		catch (Exception e)
		{
			logger.error("更改用户名异常");
			throw new RuntimeException();
		}

	}
	
	@Override
	@Transactional
	public Integer iosChangeAccountName(String accountName,String accountId) throws SQLException
	{
		try
		{
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setAccountId(accountId);
			accountInfo.setAccountName(accountName);
			return mapper.changeAccountName(accountInfo);
		}
		catch (Exception e)
		{
			logger.error("更改用户名异常");
			throw new RuntimeException();
		}
	}

	@Override
	public Integer checkLoginPassword(HttpServletRequest request, AccountInfo accountInfo) throws SQLException
	{
		AccountInfo info = (AccountInfo) request.getSession().getAttribute("account");
		if (info == null)
		{
			return null;
		}
		// 将密码MD5加密
		accountInfo.setPassword(MD5Util.getMD5String(accountInfo.getPassword()));
		accountInfo.setAccountId(info.getAccountId());
		return mapper.checkLoginPassword(accountInfo);
	}
	
	@Override
	public Integer iosCheckLoginPassword(String accountId, String oldPassword) throws SQLException
	{
		AccountInfo accountInfo = new AccountInfo();
		// 将密码MD5加密
		accountInfo.setPassword(MD5Util.getMD5String(oldPassword));
		accountInfo.setAccountId(accountId);
		return mapper.checkLoginPassword(accountInfo);
	}

	@Override
	@Transactional
	public Integer changeLoginPassword(HttpServletRequest request, AccountInfo accountInfo)
	{
		try
		{
			AccountInfo info = (AccountInfo) request.getSession().getAttribute("account");
			if (info == null)
			{
				return null;
			}
			// 将密码MD5加密
			accountInfo.setPassword(MD5Util.getMD5String(accountInfo.getPassword()));
			accountInfo.setAccountId(info.getAccountId());
			return mapper.changeLoginPassword(accountInfo);
		}
		catch (Exception e)
		{
			logger.error("修改登录密码异常");
			throw new RuntimeException();
		}

	}
	
	@Override
	@Transactional
	public Integer iosChangeLoginPassword(String accountId, String newPassword) throws SQLException
	{
		try
		{
			AccountInfo accountInfo = new AccountInfo();
			// 将密码MD5加密
			accountInfo.setPassword(MD5Util.getMD5String(newPassword));
			accountInfo.setAccountId(accountId);
			return mapper.changeLoginPassword(accountInfo);
		}
		catch (Exception e)
		{
			logger.error("修改登录密码异常");
			throw new RuntimeException();
		}
	}

	@Override
	public Integer checkDealPassword(HttpServletRequest request, AccountInfo accountInfo) throws SQLException
	{
		AccountInfo info = (AccountInfo) request.getSession().getAttribute("account");
		if (info == null)
		{
			return null;
		}
		// 将密码MD5加密
		accountInfo.setDealPassword(MD5Util.getMD5String(accountInfo.getDealPassword()));
		accountInfo.setAccountId(info.getAccountId());
		return mapper.checkDealPassword(accountInfo);
	}
	
	@Override
	public Integer iosCheckDealPassword(String accountId, String oldDealPassword) throws SQLException
	{
		AccountInfo accountInfo = new AccountInfo();
		// 将密码MD5加密
		accountInfo.setDealPassword(MD5Util.getMD5String(oldDealPassword));
		accountInfo.setAccountId(accountId);
		return mapper.checkDealPassword(accountInfo);
	}

	@Override
	@Transactional
	public Integer changeDealPassword(HttpServletRequest request, AccountInfo accountInfo) throws SQLException
	{
		try
		{
			AccountInfo info = (AccountInfo) request.getSession().getAttribute("account");
			if (info == null)
			{
				return null;
			}
			// 将密码MD5加密
			accountInfo.setDealPassword(MD5Util.getMD5String(accountInfo.getDealPassword()));
			accountInfo.setAccountId(info.getAccountId());
			return mapper.changeDealPassword(accountInfo);
		}
		catch (Exception e)
		{
			logger.error("修改交易密码异常");
			throw new RuntimeException();
		}

	}
	
	@Override
	@Transactional
	public Integer iosChangeDealPassword(String accountId, String newDealPassword) throws SQLException
	{
		try
		{
			AccountInfo accountInfo = new AccountInfo();
			// 将密码MD5加密
			accountInfo.setDealPassword(MD5Util.getMD5String(newDealPassword));
			accountInfo.setAccountId(accountId);
			return mapper.changeDealPassword(accountInfo);
		}
		catch (Exception e)
		{
			logger.error("修改交易密码异常");
			throw new RuntimeException();
		}
	}

	@Override
	public Boolean checkAccountTelephone(HttpServletRequest request, String telephone) throws SQLException
	{
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
		String accountTelephone = mapper.getLoginAccountInfo(accountInfo.getAccountId()).getTelephone();
		return telephone.equals(accountTelephone);
	}
	
	@Override
	public Boolean iosCheckAccountTelephone(String accountId, String telephone) throws SQLException
	{
		String accountTelephone = mapper.getLoginAccountInfo(accountId).getTelephone();
		return telephone.equals(accountTelephone);
	}

	@Override
	public Boolean certification(AccountInfo accountInfo) throws SQLException
	{

		return mapper.certification(accountInfo) > 0;
	}

	@Override
	public Boolean checkTelephone(String telephone) throws SQLException
	{
		return mapper.checkTelephone(telephone) > 0;
	}

	@Override
	public AccountInfo getAccountInfoByPhone(String telephone) throws SQLException
	{
		return mapper.getAccountInfoByPhone(telephone);
	}

	@Override
	public Boolean getBackLoginPassword(AccountInfo accountInfo) throws SQLException
	{
		accountInfo.setPassword(MD5Util.getMD5String(accountInfo.getPassword()));

		return mapper.changeLoginPassword(accountInfo) > 0;
	}

	@Override
	public Boolean setDealPassword(AccountInfo accountInfo) throws SQLException
	{
		accountInfo.setDealPassword(MD5Util.getMD5String(accountInfo.getDealPassword()));
		return mapper.changeDealPassword(accountInfo) > 0;
	}

	@Override
	public Boolean bindInfo(AccountInfo accountInfo) throws SQLException
	{

		return mapper.bindInfo(accountInfo) > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xed.financing.wxgzh.service.accountInfo.AccountInfoService#getAccountInfo
	 * (java.lang.String)
	 */
	@Override
	public AccountInfo getAccountInfo(String accountId) throws SQLException
	{
		// TODO Auto-generated method stub
		return mapper.getAccountInfo(accountId);
	}

	@Override
	public AccountInfo getAccountInfoByAccountWX(String accountWX) throws SQLException
	{
		// TODO Auto-generated method stub
		AccountInfo accountInfo = mapper.getAccountInfoByAccountWX(accountWX);
		// 点击微信图标登录成功时，更新登录时间
		if (accountInfo != null)
		{
			loginMapper.updateLoginTime(accountInfo);
		}
		return accountInfo;
	}
	
	@Override
	public AccountInfo getAccountInfoByUnionid(String unionid) throws SQLException
	{
		AccountInfo accountInfo = mapper.getAccountInfoByUnionid(unionid);
		if (accountInfo != null)
		{
			loginMapper.updateLoginTime(accountInfo);
		}
		return accountInfo;
	}

	@Override
	public Integer updateAccountInfoAccountWXByPhone(String telephone, AccountInfo accountInfo) throws SQLException
	{
		if (!StringTools.isNullOrEmpty(telephone))
		{
			accountInfo.setTelephone(telephone);
			int count = mapper.updateAccountInfoAccountWXByTelephone(accountInfo);
			// 在用户绑定微信时，更新登录时间
			if (count != 0)
			{
				loginMapper.updateLoginTime(accountInfo);
			}
			return count;
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xed.financing.wxgzh.service.accountInfo.AccountInfoService#checkIdCard
	 * (com.xed.financing.wxgzh.model.accountinfo.AccountInfo)
	 */
	@Override
	public Integer checkIdCard(AccountInfo accountInfo) throws SQLException
	{
		// TODO Auto-generated method stub
		return mapper.checkIdCard(accountInfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xed.financing.wxgzh.service.accountInfo.AccountInfoService#
	 * sendRecommendReward
	 * (com.xed.financing.wxgzh.model.accountinfo.AccountInfo, int)
	 */
	@Override
	public void sendRecommendReward(AccountInfo accountInfo, int flag, String money) throws SQLException
	{
		// TODO Auto-generated method stub
		if (flag == 0)
		{ // 10元现金奖励
			// 添加用户明细表
			CapitalDetail capitalDetail = new CapitalDetail();
			capitalDetail.setAccountId(accountInfo.getAccountId());
			capitalDetail.setMoney(money);
			capitalDetail.setType("17");
			capitalDetail.setInExpend(Constants.DEVIL_NUM_ZERO);
			capitalDetail.setRemark("受邀用户绑定银行卡奖励");
			capitaldetailMapper.addCapital(capitalDetail);

			// 修改用户金额表
			AccountCapital accountCapital = revenueSettlementMapper.getBalances(accountInfo.getAccountId());
			String withdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(accountCapital.getWithdrawMoney()) + Double.parseDouble(money));
			withdrawMoney = withdrawMoney.substring(0, withdrawMoney.indexOf("."));
			accountCapital.setWithdrawMoney(withdrawMoney);
			revenueSettlementMapper.changeFunds(accountCapital);

			// 发送消息
			MessageBean messageBean = new MessageBean();
			messageBean.setAccountId(accountInfo.getAccountId());
			messageBean.setMsgTitle("受邀好友绑定银行卡奖励");
			messageBean.setMsgContent("您邀请的好友于本平台首次注册并绑定银行卡," + Integer.parseInt(money) / 100 + "元现金奖励已发放至您的可用余额,请注意查看");
			messageMapper.addMessageInfo(messageBean);

		}
		else if (flag == 1)
		{ // 首次投资奖励
			// 添加用户明细表
			CapitalDetail capitalDetail = new CapitalDetail();
			capitalDetail.setAccountId(accountInfo.getAccountId());
			capitalDetail.setMoney(MoneyUtils.changeYToF(String.valueOf(Double.parseDouble(money) / 100)));
			capitalDetail.setType("17");
			capitalDetail.setInExpend(Constants.DEVIL_NUM_ZERO);
			capitalDetail.setRemark("受邀好友首次投资奖励");
			capitaldetailMapper.addCapital(capitalDetail);

			// 修改用户金额表
			AccountCapital accountCapital = revenueSettlementMapper.getBalances(accountInfo.getAccountId());
			String withdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(accountCapital.getWithdrawMoney()) + Double.parseDouble(money));
			withdrawMoney = withdrawMoney.substring(0, withdrawMoney.indexOf("."));
			accountCapital.setWithdrawMoney(withdrawMoney);
			revenueSettlementMapper.changeFunds(accountCapital);

			//修改加息券数量
			CouponInfoBean couponInfoBean = couponMapper.selectCouponInfo("CIInvitingFriends_");
			couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
			couponMapper.updateCouponInfo(couponInfoBean);
			
			// 添加加息券详情
			CouponDetail couponDetail = new CouponDetail();
			couponDetail.setCouponId(couponInfoBean.getCouponId());
			couponDetail.setCouponCode(GetUUID.getUUID("IF"));
			couponDetail.setCouponMoney("2.0");
			couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
			couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
			couponDetail.setValidityDays("180");
			couponDetail.setInterestDays(Constants.DEVIL_NUM_ZONE);
			couponDetail.setInterestType(Constants.DEVIL_NUM_ZONE);
			couponDetail.setStartMoney(Constants.DEVIL_NUM_ZERO);
			couponDetail.setSubjectType(Constants.DEVIL_NUM_ZONE);
			couponMapper.addCouponDetail(couponDetail);
			
			// 绑定加息券
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountInfo.getAccountId());
			couponBean.setCouDetailId(couponDetail.getCouDetailId());
			couponBean.setOutTime("180");
			couponMapper.addAdditional(couponBean);
			
			// 发送消息
			MessageBean messageBean = new MessageBean();
			messageBean.setAccountId(accountInfo.getAccountId());
			messageBean.setMsgTitle("受邀好友首次投资奖励");
			messageBean.setMsgContent("您邀请的好友于本平台首次投资,所投本金的1%现金奖励和2%加息券已发放至您的帐户,请注意查看");
			messageMapper.addMessageInfo(messageBean);

		}
		else if (flag == 2)
		{ // 二次投资奖励
			// 添加用户明细表
			CapitalDetail capitalDetail = new CapitalDetail();
			capitalDetail.setAccountId(accountInfo.getAccountId());
			capitalDetail.setMoney(MoneyUtils.changeYToF(String.valueOf(Double.parseDouble(money) / 200)));
			capitalDetail.setType("17");
			capitalDetail.setInExpend(Constants.DEVIL_NUM_ZERO);
			capitalDetail.setRemark("受邀好友第二次投资奖励");
			capitaldetailMapper.addCapital(capitalDetail);

			// 修改用户金额表
			AccountCapital accountCapital = revenueSettlementMapper.getBalances(accountInfo.getAccountId());
			String withdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(accountCapital.getWithdrawMoney()) + Double.parseDouble(money) / 2);
			withdrawMoney = withdrawMoney.substring(0, withdrawMoney.indexOf("."));
			accountCapital.setWithdrawMoney(withdrawMoney);
			revenueSettlementMapper.changeFunds(accountCapital);

			//修改加息券数量
			CouponInfoBean couponInfoBean = couponMapper.selectCouponInfo("CIInvitingFriends_");
			couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
			couponMapper.updateCouponInfo(couponInfoBean);
			
			// 添加加息券详情
			CouponDetail couponDetail = new CouponDetail();
			couponDetail.setCouponId(couponInfoBean.getCouponId());
			couponDetail.setCouponCode(GetUUID.getUUID("IF"));
			couponDetail.setCouponMoney("1.0");
			couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
			couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
			couponDetail.setValidityDays("180");
			couponDetail.setInterestDays(Constants.DEVIL_NUM_ZONE);
			couponDetail.setInterestType(Constants.DEVIL_NUM_ZONE);
			couponDetail.setStartMoney(Constants.DEVIL_NUM_ZERO);
			couponDetail.setSubjectType(Constants.DEVIL_NUM_ZONE);
			couponMapper.addCouponDetail(couponDetail);
			
			// 绑定加息券
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountInfo.getAccountId());
			couponBean.setCouDetailId(couponDetail.getCouDetailId());
			couponBean.setOutTime("180");
			couponMapper.addAdditional(couponBean);

			// 发送消息
			MessageBean messageBean = new MessageBean();
			messageBean.setAccountId(accountInfo.getAccountId());
			messageBean.setMsgTitle("受邀好友第二次投资奖励");
			messageBean.setMsgContent("您邀请的好友于本平台第二次投资,所投本金的0.5%现金奖励和1%加息券已发放至您的帐户,请注意查看");
			messageMapper.addMessageInfo(messageBean);
		}
		else if(flag == 3){
			// 添加用户明细表 猫咪储蓄提取专用
			CapitalDetail capitalDetail = new CapitalDetail();
			capitalDetail.setAccountId(accountInfo.getAccountId());
			capitalDetail.setMoney("" + (Double.parseDouble(money)));
			capitalDetail.setType("19");
			capitalDetail.setInExpend(Constants.DEVIL_NUM_ZERO);
			capitalDetail.setRemark("猫咪储蓄金额提取");
			capitaldetailMapper.addCapital(capitalDetail);

			// 修改用户金额表
			AccountCapital accountCapital = revenueSettlementMapper.getBalances(accountInfo.getAccountId());
			String withdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(accountCapital.getWithdrawMoney()) + Double.parseDouble(money));
			withdrawMoney = withdrawMoney.substring(0, withdrawMoney.indexOf("."));
			accountCapital.setWithdrawMoney(withdrawMoney);
			revenueSettlementMapper.changeFunds(accountCapital);

			// 发送消息
			MessageBean messageBean = new MessageBean();
			messageBean.setAccountId(accountInfo.getAccountId());
			messageBean.setMsgTitle("猫咪储蓄金额提取");
			messageBean.setMsgContent("您的猫咪储蓄金额已经提取,金额已发放至您的可用余额,请注意查看");
			messageMapper.addMessageInfo(messageBean);
		}
	}

	@Override
	public Integer countInvestSubject(AccountInfo accountInfo) throws SQLException
	{
		return mapper.countInvestSubject(accountInfo);
	}

	@Override
	public boolean checkIcon(AccountInfo accountInfo) throws SQLException
	{
		if(StringTools.isNullOrEmpty(mapper.checkIcon(accountInfo)))
			return true;
		else
			return false;
	}

	@Override
	public Integer updateAccountIcon(AccountInfo accountInfo) throws SQLException
	{
		return mapper.updateAccountIcon(accountInfo);
	}

	@Override
	public Integer countAccountInfoByIdCard(String idCard) throws SQLException 
	{
		return mapper.countAccountInfoByIdCard(idCard);
	}

}
