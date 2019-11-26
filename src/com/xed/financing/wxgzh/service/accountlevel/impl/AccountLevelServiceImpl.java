package com.xed.financing.wxgzh.service.accountlevel.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountlevel.AccountLevelMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.couponDetail.CouponDetail;
import com.xed.financing.wxgzh.model.couponInfo.CouponInfoBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.GetUUID;
import com.xed.financing.wxgzh.util.LevelParam;
import com.xed.financing.wxgzh.util.MoneyUtils;

@Service
public class AccountLevelServiceImpl implements AccountLevelService
{
	@Resource
	private AccountLevelMapper accountLevelMapper;
	
	@Resource
	private ParamMapper paramMapper;
	
	@Resource
	private MessageMapper messageMapper;
	
	private Logger logger=Logger.getLogger(AccountLevelServiceImpl.class);
	
	/**
	 * 查询上个月用户的签到次数,发放加息券
	 */
	@Override
	@Transactional
	public void queryAccountLastMonthSigns() throws SQLException
	{
		try
		{
			//查询上个月用户的签到次数，等级
			List<AccountInfo> accountInfos=accountLevelMapper.queryAccountLastMonthSigns();
			if(accountInfos!=null && accountInfos.size()>0){
				//循环遍历
				for (AccountInfo accountInfo : accountInfos)
				{
					//根据用户的vip等级获取相应的加息点数
					Double Interest=LevelParam.SIGN_INTEREST_RATE.get(accountInfo.getAccountLevel());
					//加息券点数=加息点数*签到次数
					String interests=MoneyUtils.formatFloatNumber(Integer.parseInt(accountInfo.getSigns())*Interest);
					
					Double Interests=Double.valueOf(interests);
					
					if(Interests<=0){
						continue;
					}
				
					
					//---------------发加息券---------------- 
					String couponId = paramMapper.getParamVal(Constants.LEVEL_POWER_SIGN_SEND_INTEREST);
					
					//新增优惠券
					CouponDetail couponDetail = new CouponDetail();
					couponDetail.setCouponId(couponId);
					couponDetail.setCouponCode(GetUUID.getUUID("LV"));
					couponDetail.setCouponMoney(String.valueOf(Interests));
					couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
					couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
					couponDetail.setValidityDays("30");
					couponDetail.setInterestDays("2");
					couponDetail.setInterestType("1");
					accountLevelMapper.addCouponDetail(couponDetail);
					
					// 修改优惠券概述的数量
					CouponInfoBean couponInfoBean = accountLevelMapper.selectCouponInfo(couponId);
					couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
					accountLevelMapper.updateCouponInfo(couponInfoBean);
					
					//发送消息
					MessageBean outMessageBean = new MessageBean();
					outMessageBean.setAccountId(accountInfo.getAccountId());
					outMessageBean.setMsgTitle("特权签到奖励");
					outMessageBean.setMsgContent("您上个月累计签到"+(accountInfo.getSigns())+"天，已发放"+ (Double.valueOf(couponDetail.getCouponMoney()))
							+"%加息券到您账户，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
					messageMapper.addMessageInfo(outMessageBean);
					
					// 绑定加息券
					CouponBean couponBean = new CouponBean();
					couponBean.setAccountId(accountInfo.getAccountId());
					couponBean.setCouDetailId(couponDetail.getCouDetailId());
					couponBean.setOutTime("30");
					accountLevelMapper.addAdditional(couponBean);
				}
			}
		}
		catch (Exception e)
		{
			logger.error("查询上个月用户的签到次数异常",e);
			throw new RuntimeException();
		}
	}
	
	/**
	 * 用户生日7天投资达到档位送现金券
	 */
	@Override
	@Transactional
	public void accountBirthdayGiveCash() throws SQLException
	{
		try
		{
			List<AccountInvest>accountInvests= accountLevelMapper.accountBirthdayGiveCash();
			if(accountInvests!=null && accountInvests.size()>0){
				for (AccountInvest accountInvest : accountInvests)
				{
					//获取用户等级
					int accountLevel=Integer.parseInt(accountInvest.getAccountLevel());
					//获取用户的投资金额(分)
					int investMoney=Integer.parseInt(accountInvest.getInvestMoney());
					//向下循环判断
					for (; accountLevel>0 ; accountLevel--)
					{
						//判断用户投资金额是否满足相应vip的起投金额
						if(investMoney>=LevelParam.BIRTHDAY_INVEST_MONEY.get(accountLevel))
						{
							break;
						}
					}
					//需要发的现金券数值 （元）
					int cashCoupon=LevelParam.BIRTHDAY_CASH_COUPON.get(accountLevel);
					
					if(cashCoupon<=0){
						continue;
					}
					
					
					//----------------发现金券--------------
					String couponId = paramMapper.getParamVal(Constants.LEVEL_POWER_BIRTHDAY_SEND_CASH);

					// 新增优惠券
					CouponDetail couponDetail = new CouponDetail();
					couponDetail.setCouponId(couponId);
					couponDetail.setCouponCode(GetUUID.getUUID("LV"));
					couponDetail.setCouponMoney(String.valueOf(cashCoupon));
					couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
					couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
					couponDetail.setValidityDays("-1");
					couponDetail.setInterestDays("-1");
					couponDetail.setInterestType("-1");
					accountLevelMapper.addCouponDetail(couponDetail);

					// 修改优惠券概述的数量
					CouponInfoBean couponInfoBean = accountLevelMapper.selectCouponInfo(couponId);
					couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
					accountLevelMapper.updateCouponInfo(couponInfoBean);

					// 发送消息
					MessageBean outMessageBean = new MessageBean();
					outMessageBean.setAccountId(accountInvest.getAccountId());
					outMessageBean.setMsgTitle("特权生日奖励");
					outMessageBean.setMsgContent("您生日后的7天内最高一笔投资是"+(investMoney/100)+"元，已发放"+(Integer.valueOf(couponDetail.getCouponMoney()) / 100.0)
							+"元现金券到您账户，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
					messageMapper.addMessageInfo(outMessageBean);

					//绑定现金券
					CouponBean couponBean = new CouponBean();
					couponBean.setAccountId(accountInvest.getAccountId());
					couponBean.setCouDetailId(couponDetail.getCouDetailId());
					couponBean.setOutTime("-1");
					accountLevelMapper.addAdditional(couponBean);
				}
			}
		}
		catch (Exception e)
		{
			logger.error("用户生日送现金券异常",e);
			throw new RuntimeException();
		}
	}

	/**
	 * 用户升级享受的特权叠加,发放大礼包
	 */
	@Override
	@Transactional
	public void upgradeprivilege(int oldVIP, int newVIP, String accountId) throws SQLException
	{
		try
		{
			if(newVIP<=oldVIP){
				return;
			}
			
			//升级获得大礼包
			AccountInfo accountInfo=new AccountInfo();
			accountInfo.setAccountId(accountId);
			//查询用户等级信息
			accountInfo=accountLevelMapper.queryAccountLevel(accountInfo);
			//查询已获得的等级礼包
			int IsRewardLevel = Integer.parseInt(accountInfo.getIsRewardLevel());
			for (int i = newVIP; i >IsRewardLevel;i --)
			{
					//升级现金券点数
					int cashCoupon=LevelParam.UPGRADE_CASH_COUPON.get(i);
					
					//----------------升级发现金券--------------
					String couponId = paramMapper.getParamVal(Constants.LEVEL_POWER_UPGRADE_SEND_CASH);

					// 新增优惠券
					CouponDetail couponDetail = new CouponDetail();
					couponDetail.setCouponId(couponId);
					couponDetail.setCouponCode(GetUUID.getUUID("LV"));
					couponDetail.setCouponMoney(String.valueOf(cashCoupon));
					couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
					couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
					couponDetail.setValidityDays("-1");
					couponDetail.setInterestDays("-1");
					couponDetail.setInterestType("-1");
					accountLevelMapper.addCouponDetail(couponDetail);

					// 修改优惠券概述的数量
					CouponInfoBean couponInfoBean = accountLevelMapper.selectCouponInfo(couponId);
					couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
					accountLevelMapper.updateCouponInfo(couponInfoBean);

					// 发送消息
					MessageBean outMessageBean = new MessageBean();
					outMessageBean.setAccountId(accountId);
					outMessageBean.setMsgTitle("特权升级奖励");
					outMessageBean.setMsgContent("您的等级已从VIP"+oldVIP+"升到VIP"+newVIP+"，已发放"+(Integer.valueOf(couponDetail.getCouponMoney()) / 100.0)
							+"元现金券到您账户，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
					messageMapper.addMessageInfo(outMessageBean);

					//绑定现金券
					CouponBean couponBean = new CouponBean();
					couponBean.setAccountId(accountId);
					couponBean.setCouDetailId(couponDetail.getCouDetailId());
					couponBean.setOutTime("-1");
					accountLevelMapper.addAdditional(couponBean);
					
					//升级加息券点数
					Double increaseInterestCoupon=LevelParam.UPGRADE_INCREASE_INTEREST_COUPON.get(i);
					//升级加息券起投金额（元）
					int investmentMoney=LevelParam.UPGRADE_INVESTMENT_MONEY.get(i);
					//升级加息券计息时间
					int interestTime=LevelParam.UPGRADE_INTEREST_TIME.get(i);
					//升级发加息券（起投金额，计息时间）
					
					//---------------发加息券---------------- 
					String couponId2 = paramMapper.getParamVal(Constants.LEVEL_POWER_UPGRADE_SEND_INTEREST);
					
					//新增优惠券
					CouponDetail couponDetail2 = new CouponDetail();
					couponDetail2.setCouponId(couponId2);
					couponDetail2.setCouponCode(GetUUID.getUUID("LV"));
					couponDetail2.setCouponMoney(String.valueOf(increaseInterestCoupon));
					couponDetail2.setIsReceive(Constants.DEVIL_NUM_ONE);
					couponDetail2.setIsShow(Constants.DEVIL_NUM_ONE);
					couponDetail2.setValidityDays("30");
					couponDetail2.setInterestDays(String.valueOf(interestTime));
					couponDetail2.setInterestType("1");
					couponDetail2.setStartMoney(String.valueOf(investmentMoney));
					accountLevelMapper.addCouponDetail(couponDetail2);
					
					// 修改优惠券概述的数量
					CouponInfoBean couponInfoBean2 = accountLevelMapper.selectCouponInfo(couponId2);
					couponInfoBean2.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean2.getCouponQuantity()) + 1));
					accountLevelMapper.updateCouponInfo(couponInfoBean2);
					
					//发送消息
					MessageBean outMessageBean2 = new MessageBean();
					outMessageBean2.setAccountId(accountId);
					outMessageBean2.setMsgTitle("特权升级奖励");
					outMessageBean2.setMsgContent("您的等级已从VIP"+oldVIP+"升到VIP"+newVIP+"，已发放"+ (Double.valueOf(couponDetail2.getCouponMoney()))
							+"%加息券到您账户，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
					messageMapper.addMessageInfo(outMessageBean2);
					
					// 绑定加息券
					CouponBean couponBean2 = new CouponBean();
					couponBean2.setAccountId(accountId);
					couponBean2.setCouDetailId(couponDetail2.getCouDetailId());
					couponBean2.setOutTime("30");
					accountLevelMapper.addAdditional(couponBean2);
					
			}
			//更新最高等级大礼包               newVIP>IsRewardLevel
			if(newVIP>IsRewardLevel)
			{
				//将已获得等级礼包更新为新的等级礼包
				accountInfo.setIsRewardLevel(String.valueOf(newVIP));
			}
			
			
			//特权提现次数
			int privilegeWithdrawals=Integer.parseInt(accountInfo.getWithdrawalsNumber());
			for (int j = newVIP; j>oldVIP;j--)
			{
				//升级后的提现次数
				privilegeWithdrawals +=LevelParam.PRIVILEGE_WITHDRAWALS.get(j);
			}
			//添加特权提现次数
			accountInfo.setWithdrawalsNumber(String.valueOf(privilegeWithdrawals));
			
			//特权补签次数
			int retroactiveNumbers=Integer.parseInt(accountInfo.getRepairSignNumber());
			for (int k = newVIP; k>oldVIP;k--)
			{
				//升级后的补签次数
				retroactiveNumbers+=LevelParam.RETROACTIVE_NUMBERS.get(k);
			}
			//添加补签次数
			accountInfo.setRepairSignNumber(String.valueOf(retroactiveNumbers));
			
			//卡券融合次数
			int fuseCoupon=Integer.parseInt(accountInfo.getFuseCouponNumber());
			for (int x = newVIP; x>oldVIP;x--)
			{
				//升级后的卡券融合次数
				fuseCoupon +=(x-1);
			}
			//添加卡券融合次数
			accountInfo.setFuseCouponNumber(String.valueOf(fuseCoupon));
			
			//免费提现次数
			int freeWithdrawals = Integer.parseInt(accountInfo.getFreeWithdrawalsNumber());
			for (int x = newVIP; x>oldVIP;x--)
			{
				//升级后的免费提现次数
				freeWithdrawals +=LevelParam.FREE_WITHDRAWALS_NUMBER.get(x);
			}
			//添加免费提现次数
			accountInfo.setFreeWithdrawalsNumber(String.valueOf(freeWithdrawals));
			
			//升级用户的VIP等级
			accountInfo.setAccountLevel(String.valueOf(newVIP));
			accountLevelMapper.updateAccountVIP(accountInfo);
			//升级后将等级状态修改为0
			accountInfo.setIsChange("0");
			//执行修改方法
			accountLevelMapper.updateAccountLevelAndIsChange(accountInfo);
			
		}
		catch (Exception e)
		{
			logger.error("用户升级享受的特权叠加异常",e);
			throw new RuntimeException();
		}
	}
	
	/**
	 * 判断用户是否可以升级VIP等级
	 */
	@Override
	@Transactional
	public void updateVIP(String accountId) throws SQLException
	{
		try
		{
			AccountCapital accountCapital=new AccountCapital();
			//将用户accountId塞入bean中
			accountCapital.setAccountId(accountId);
			//查询用户的资金明细
			accountCapital=accountLevelMapper.queryAccountCapital(accountCapital);
			//用户当前投资金额（分）
			int investmentMoney=Integer.parseInt(accountCapital.getInvestmentMoney());
			if(investmentMoney<=0){
				return;
			}
			//查询用户等级信息
			AccountInfo accountInfo=new AccountInfo(); 
			//将用户accountId塞入bean中
			accountInfo.setAccountId(accountId);
			accountInfo=accountLevelMapper.queryAccountLevel(accountInfo);
			//用户原先等级
			int oldVIP=Integer.parseInt(accountInfo.getAccountLevel());
			
			Integer newVIP = 10;
			for (int i = 0; i < 10; i++)
			{
				String gradeDivision = LevelParam.GRADE_DIVISION.get(i);
				String[] s = gradeDivision.split(",");
				if(Integer.parseInt(s[0]) < investmentMoney && investmentMoney <= Integer.parseInt(s[1])){
					newVIP = i;
					break;
				}
			}
			
			if(newVIP!=oldVIP){
				upgradeprivilege(oldVIP,newVIP,accountId);
			}
			//VIP1(5.01-10万)
			/*if(5000000<investmentMoney&&investmentMoney<=10000000)
			{
				//用户升级享受的特权叠加
				accountLevelServiceImpl.upgradeprivilege(oldVIP,1,accountId);
				
			//VIP2(10.01-30万)
			}else if(10000000<investmentMoney&&investmentMoney<=30000000)
			{
				//用户升级享受的特权叠加
				accountLevelServiceImpl.upgradeprivilege(oldVIP,2,accountId);
				
			//VIP3(30.01-50万)	
			}else if(30000000<investmentMoney&&investmentMoney<=50000000)
			{
				//用户升级享受的特权叠加
				accountLevelServiceImpl.upgradeprivilege(oldVIP,3,accountId);
				
			//VIP4(50.01-80万)	
			}else if(50000000<investmentMoney&&investmentMoney<=80000000)
			{
				//用户升级享受的特权叠加
				accountLevelServiceImpl.upgradeprivilege(oldVIP,4,accountId);
				
			//VIP5(80.01-120万)	
			}else if(80000000<investmentMoney&&investmentMoney<=120000000)
			{
				//用户升级享受的特权叠加
				accountLevelServiceImpl.upgradeprivilege(oldVIP,5,accountId);
				
			//VIP6(120.01-160万)	
			}else if(120000000<investmentMoney&&investmentMoney<=160000000)
			{
				//用户升级享受的特权叠加
				accountLevelServiceImpl.upgradeprivilege(oldVIP,6,accountId);
				
			//VIP7(160.01-200万)	
			}else if(160000000<investmentMoney&&investmentMoney<=200000000)
			{
				//用户升级享受的特权叠加
				accountLevelServiceImpl.upgradeprivilege(oldVIP,7,accountId);
				
			//VIP8(200.01-250万)	
			}else if(200000000<investmentMoney&&investmentMoney<=250000000)
			{
				//用户升级享受的特权叠加
				accountLevelServiceImpl.upgradeprivilege(oldVIP,8,accountId);
				
			//VIP9(250.01-300万)	
			}else if(250000000<investmentMoney&&investmentMoney<=300000000)
			{
				//用户升级享受的特权叠加
				accountLevelServiceImpl.upgradeprivilege(oldVIP,9,accountId);
			//VIP10(300.01以上)
			}else if(investmentMoney>300000000)
			{
				//用户升级享受的特权叠加
				accountLevelServiceImpl.upgradeprivilege(oldVIP,10,accountId);	
			}*/
		}
		catch (Exception e)
		{
			logger.error("用户升级VIP异常",e);
			throw new RuntimeException();
		}
	}

	/**
	 * 每月初判定用户是否降级
	 */
	@Override
	@Transactional
	public void accountDowngrade() throws SQLException
	{
		try
		{
			List<AccountCapital> accountCapitals=accountLevelMapper.queryAccountCapitalByLevel();
			if(accountCapitals!=null && accountCapitals.size()>0)
			{
				for (AccountCapital accountCapital : accountCapitals)
				{
					//获取用户的VIP等级
					String accountLevel=accountCapital.getAccountLevel();
					//获取用户的等级状态
					String isChange=accountCapital.getIsChange();
					//获取用户的投资金额
					int investMoney=Integer.parseInt(accountCapital.getInvestmentMoney());
					//获取用户的id
					String accountId=accountCapital.getAccountId();
					AccountInfo accountInfo=new AccountInfo();
					//将用户id塞入bean中
					accountInfo.setAccountId(accountId);
					accountInfo.setAccountLevel(accountLevel);
					//对应等级降级需要满足的金额
					int investMoneys= LevelParam.DOWN_GRADE_DIVISION.get(accountLevel);
					
					if(Constants.DEVIL_NUM_ZERO.equals(isChange) && investMoney<investMoneys)
					{
						//将等级状态设为1
						accountInfo.setIsChange(Constants.DEVIL_NUM_ONE);
						//执行修改方法
						accountLevelMapper.updateAccountLevelAndIsChange(accountInfo);
					//金额不满足条件并且等级状态为1
					}else if(Constants.DEVIL_NUM_ONE.equals(isChange) && investMoney<investMoneys)
					{
						//将等级状态设为0
						accountInfo.setIsChange(Constants.DEVIL_NUM_ZERO);
						//将等级降一级变为当前等级减1
						accountInfo.setAccountLevel(String.valueOf(Integer.parseInt(accountLevel)-1));
						//执行修改方法
						accountLevelMapper.updateAccountLevelAndIsChange(accountInfo);
					}else if(Constants.DEVIL_NUM_ONE.equals(isChange) && investMoney>=investMoneys)
					{
						//将等级状态设为0
						accountInfo.setIsChange(Constants.DEVIL_NUM_ZERO);
						//执行修改方法
						accountLevelMapper.updateAccountLevelAndIsChange(accountInfo);
					}
				}
			}
		}
		catch (Exception e)
		{
			logger.error("用户降级VIP异常",e);
			throw new RuntimeException();
		}
		
	}

	/**
	 * 根据用户等级刷新用户补签次数和特权提现次数
	 */
	@Override
	@Transactional
	public void refeshPower() throws SQLException
	{
		try
		{
			//----------------特权补签次数-------------------
			Map<Object, Object> map=new HashMap<Object,Object>();
			//VIP0,VIP1,VIP2(补签次数0)
			map.put("repairSignNumber", 0);
			map.put("checkedIds", new String[]{"0","1","2"});
			accountLevelMapper.updateRepairSignNumber(map);
			//VIP3,VIP4,VIP5(补签次数1)
			map.put("repairSignNumber", 1);
			map.put("checkedIds", new String[]{"3","4","5"});
			accountLevelMapper.updateRepairSignNumber(map);
			//VIP6,VIP7,VIP8(补签次数2)
			map.put("repairSignNumber", 2);
			map.put("checkedIds", new String[]{"6","7","8"});
			accountLevelMapper.updateRepairSignNumber(map);
			//VIP9,VIP10(补签次数3)
			map.put("repairSignNumber", 3);
			map.put("checkedIds", new String[]{"9","10"});
			accountLevelMapper.updateRepairSignNumber(map);
			
			//----------------特权提现次数-------------------
			//VIP0,VIP1,VIP2,VIP3(特权提现次数0)
			map.put("withdrawalsNumber", 0);
			map.put("checkedIds", new String[]{"0","1","2","3"});
			accountLevelMapper.updateWithdrawalsNumber(map);
			//VIP4,VIP5(特权提现次数1)
			map.put("withdrawalsNumber", 1);
			map.put("checkedIds", new String[]{"4","5"});
			accountLevelMapper.updateWithdrawalsNumber(map);
			//VIP6,VIP7(特权提现次数2)
			map.put("withdrawalsNumber", 2);
			map.put("checkedIds", new String[]{"6","7"});
			accountLevelMapper.updateWithdrawalsNumber(map);
			//VIP8,VIP9,VIP10(特权提现次数3)
			map.put("withdrawalsNumber", 3);
			map.put("checkedIds", new String[]{"8","9","10"});
			accountLevelMapper.updateWithdrawalsNumber(map);
			
			//---------------卡券融合次数-------------------
			accountLevelMapper.updateFuseCouponNumber();
			
			
			//---------------免费提现次数---------------------
			//VIP0,VIP1(免费提现次数0)
			map.put("freeWithdrawalsNumber", 0);
			map.put("checkedIds", new String[]{"0","1"});
			accountLevelMapper.updateFreeWithdrawalsNumber(map);
			//VIP2,VIP3,VIP4(免费提现次数1)
			map.put("freeWithdrawalsNumber", 1);
			map.put("checkedIds", new String[]{"2","3","4"});
			accountLevelMapper.updateFreeWithdrawalsNumber(map);
			//VIP5,VIP6,VIP7,VIP8,VIP9,VIP10(免费提现次数3)
			map.put("freeWithdrawalsNumber", 2);
			map.put("checkedIds", new String[]{"6","7","8","9","10"});
			accountLevelMapper.updateFreeWithdrawalsNumber(map);
			
		}
		catch (Exception e)
		{
			logger.error("根据用户等级刷新用户补签次数和特权提现次数异常",e);
			throw new RuntimeException();
		}
	}

	/**
	 * 根据用户的VIP等级在投标时固定加息
	 */
	@Override
	public Double LevelIncreaseInterest(String accountId) throws SQLException
	{
			AccountInfo accountInfo=new AccountInfo();
			//将用户id塞入bean中
			accountInfo.setAccountId(accountId);
			//根据用户id查询用户的VIP等级
			accountInfo=accountLevelMapper.queryAccountLevel(accountInfo);
			//根据用户VIP等级查询投资加息的点数
			Double vipRate=LevelParam.INVEST_INTEREST_RATE.get(accountInfo.getAccountLevel());
			//最终的利率=原利率+VIP固定加息点数
			return vipRate;
	}
	
	@Override
	public Double LevelInterestManagement(String accountId) throws SQLException
	{
			AccountInfo accountInfo=new AccountInfo();
			//将用户id塞入bean中
			accountInfo.setAccountId(accountId);
			//根据用户id查询用户的VIP等级
			accountInfo=accountLevelMapper.queryAccountLevel(accountInfo);
			//根据用户VIP等级查询利息管理费利率
			Double Management=LevelParam.LEVEL_MANAGEMENT_INTEREST.get(accountInfo.getAccountLevel());
			
			return Management;
	}
	
	
	
	/**
	 * 等级上线扫描一次根据用户投资金额刷新用户等级
	 */
	/*@Override
	@Transactional
	public void refeshLevelOnlyOneTime() throws SQLException
	{
		try
		{
			//查询用户的accountId
			List<AccountInfo>accountInfos=accountLevelMapper.queryAccountId();
			if(accountInfos!=null && accountInfos.size()>0)
			{
				//遍历集合
				for (AccountInfo accountInfo : accountInfos)
				{
					//获取用户Id
					String accountId=accountInfo.getAccountId();
					//调用升级等级VIP方法
					updateVIP(accountId);
				}
			}
		}
		catch (Exception e)
		{
			logger.error("根据用户投资金额刷新用户等级异常",e);
			throw new RuntimeException();
		}
		
	}*/

	public AccountInfo queryAccountLevel(AccountInfo accountInfo) throws SQLException{
		return accountLevelMapper.queryAccountLevel(accountInfo);
	}

	@Override
	public void updateAccountVIP(AccountInfo accountInfo) throws SQLException
	{
		accountLevelMapper.updateAccountVIP(accountInfo);
	}
	
	
}
