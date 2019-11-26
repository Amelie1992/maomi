/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.revenueSettlement.impl.RevenueSettlementServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月26日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.revenueSettlement.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.accountlevel.AccountLevelMapper;
import com.xed.financing.wxgzh.mapper.goldDetails.GoldDetailsMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.mapper.profitreturn.ProfitReturnMapper;
import com.xed.financing.wxgzh.mapper.revenueSettlement.RevenueSettlementMapper;
import com.xed.financing.wxgzh.mapper.userCapital.UserCapitalMapper;
import com.xed.financing.wxgzh.mapper.userCapitalDetail.UserCapitalDetailMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.couponDetail.CouponDetail;
import com.xed.financing.wxgzh.model.creditrecord.CreditRecord;
import com.xed.financing.wxgzh.model.freedomsubject.FreedomSubjectBean;
import com.xed.financing.wxgzh.model.golddetails.GoldDetailsBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.usercapital.UserCapitalBean;
import com.xed.financing.wxgzh.model.usercapitaldetail.UserCapitalDetailBean;
import com.xed.financing.wxgzh.service.fuiou.FuiouService;
import com.xed.financing.wxgzh.service.revenueSettlement.RevenueSettlementService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.InterfaceUtil;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * 收益结算
 * 
 * @className:com.xed.financing.wxgzh.service.revenueSettlement.impl.RevenueSettlementServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年4月26日 上午9:31:26
 * @author:ZhangJun
 */
@Service
@Transactional
public class RevenueSettlementServiceImpl implements RevenueSettlementService
{

	@Resource
	private RevenueSettlementMapper revenueSettlementMapper;

	@Resource
	private MessageMapper messageMapper;
	
	@Resource
	private ParamMapper paramMapper;
	
	@Resource
	private AccountLevelMapper accountLevelMapper;
	
	@Resource
	private UserCapitalMapper userCapitalMapper;
	
	@Resource
	private AccountInfoMapper accountInfoMapper;

	@Resource
	private GoldDetailsMapper goldDetailsMapper;

	@Resource
	private UserCapitalDetailMapper userCapitalDetailMapper;
	
	@Autowired
	private FuiouService fuiouService;
	
	@Resource
	private ProfitReturnMapper profitReturnMapper;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(RevenueSettlementServiceImpl.class);

	/**
	 * 收益结算
	 */
	@Transactional
	public void revenueSettlement()
	{
		System.out.println("开始计算收益");
		try
		{
			/*String couponId = paramMapper.getParamVal(Constants.ACTIVITY_EXPERIENCE_GOLD);
			
			//查询使用当天为投标7天，并且使用3000体验金的
			List<AccountInvest> activityAccountInvests = revenueSettlementMapper.selActivitySettlementIncomeInvestInfo(couponId);
			for (AccountInvest accountInvest : activityAccountInvests)
			{
				// 收益计算本金(分)
				Integer principal = Integer.parseInt(accountInvest.getCouponMoney());
				// 利率
				Double rate = Double.parseDouble(accountInvest.getSubjectRate()) / 100;
				// 收益金额(分) = 收益计算本金 * 利率 / 12 / 当月天数 * 7
				String incomeAmount = MoneyUtils.formatFloatNumber(principal * rate / 12 / DateUtils.getDaysBydate(accountInvest.getNextProfitTime())*7);
				incomeAmount = incomeAmount.substring(0, incomeAmount.indexOf("."));
				// 收益结算
				activityIncomeSettlement(incomeAmount, accountInvest);
			}*/
			
			// 查询出今天结算收益的投资记录next_profit_time 投标状态invest_status 正常 已接收债权
			List<AccountInvest> accountInvests = revenueSettlementMapper.getSettlementIncomeInvestInfo();

			for (AccountInvest accountInvest : accountInvests)
			{
				//优惠券标记(-1:未使用优惠券  1:无限制（满期限） 2：未过期 3：刚好到期 4：已到期)
				Integer flag = -1;
				flag = couponPeriod(accountInvest);
				if ("0".equals(accountInvest.getRepeatType()))
				{
					// -------------------- 等额本息
					if ("0".equals(accountInvest.getIsDayProfit()))
					{
						// ------------------------ 按月收益
						
						// 收益计算本金(分) = 剩余金额 + 红包金额
						Integer principal = Integer.parseInt(accountInvest.getSurplusMoney())
								+ Integer.parseInt(accountInvest.getCouponMoney());
						// 利率 = 投标利率
						Double rate = Double.parseDouble(accountInvest.getSubjectRate()) / 100;
						
						if(flag==4){
							if("1".equals(accountInvest.getCouponDetail().getCouponType())){
								//加息券
								
								//利率 = 利率 - 加息券利率
								rate = rate - Double.parseDouble(accountInvest.getCouponDetail().getCouponMoney())/100;
							}else{
								//增值券、体验金
								
								//收益计算本金(分) = 收益计算本金(分) - 红包金额
								principal = principal - Integer.parseInt(accountInvest.getCouponMoney());
							}
						}
						
						// 收益金额(分) = 收益计算本金(分)*利率/12
						String incomeAmount = MoneyUtils.formatFloatNumber(principal * rate / 12);
						incomeAmount = incomeAmount.substring(0, incomeAmount.indexOf("."));
						// 每期归还的本金(分)
						String returnPrincipal = null;

						if (accountInvest.getNextProfitTime().equals(accountInvest.getEndTime()))
						{
							// 标结束了-----------------------

							// 每期归还的本金(分) = 剩余金额
							returnPrincipal = accountInvest.getSurplusMoney();
							// 剩余本金归零
							accountInvest.setSurplusMoney("0");
							// 改变状态
							accountInvest.setInvestStatus("1");
							// 修改投标记录
							revenueSettlementMapper.updateInvestInfoByMonth(accountInvest);

							// 正在转让的债权，要进行撤销----------------------------
							if ("1".equals(accountInvest.getIsCredit()))
							{
								revenueSettlementMapper.updateTransferStatus(accountInvest.getInvestId());
							}
						}
						else
						{
							// 修改下次结算时间------------------------------------------------
							// 更新下次结算日期据投标日的月份 = 本次结算日期至投标日+1 的月份
							Integer apartMonth = DateUtils.GetTwoDatesMonths(accountInvest.getNextProfitTime(),
									accountInvest.getFullTime()) + 1;
							accountInvest.setApartMonth(apartMonth);
							// 剩余 投标期数
							Integer periods = DateUtils.GetTwoDatesMonths(accountInvest.getEndTime(),
									accountInvest.getNextProfitTime());
							// 每期归还的本金(分) = 剩余金额 / 剩余期限+1 
							returnPrincipal = String
									.valueOf(Integer.parseInt(accountInvest.getSurplusMoney()) / (periods+1));

							// 剩余红包金额 = 红包金额  / (剩余期数+1)
							String reduceRedPackets = MoneyUtils.formatFloatNumber(Double.parseDouble(accountInvest.getCouponMoney())-Double.parseDouble(accountInvest.getCouponMoney()) / (periods +1));
							

							if(flag==4||flag ==3){
								//已过期和正好过期都是扣除结束
								reduceRedPackets = "0.0";
							}else if(flag ==2 && !"1".equals(accountInvest.getCouponDetail().getCouponType())){
								// 未过期  增值券  体验金
								//剩余红包金额  = 剩余红包金额 - 优惠券金额 / 优惠券期限
								reduceRedPackets = MoneyUtils.formatFloatNumber(Double.parseDouble(accountInvest.getCouponMoney())-Integer.parseInt(accountInvest.getCouponDetail().getCouponMoney())/Integer.parseInt(accountInvest.getCouponDetail().getInterestDays()));
							}
							reduceRedPackets = reduceRedPackets.substring(0, reduceRedPackets.indexOf("."));
							accountInvest.setCouponMoney(reduceRedPackets);
							// 计算剩下的本金
							accountInvest.setSurplusMoney(MoneyUtils.formatFloatNumber(Double.parseDouble(accountInvest
									.getSurplusMoney()) - Integer.parseInt(returnPrincipal)));
							revenueSettlementMapper.updateInvestInfoByMonth(accountInvest);
						}

						// 收益结算
						incomeSettlement(returnPrincipal, incomeAmount, accountInvest);

					}
					else
					{
						// ------------------------按天收益
						// 当天收益
						// 收益计算本金(分) = 剩余金额+红包金额
						Integer principal = Integer.parseInt(accountInvest.getSurplusMoney())
								+ Integer.parseInt(accountInvest.getCouponMoney());
						// 利率 = 投标利率
						Double rate = Double.parseDouble(accountInvest.getSubjectRate()) / 100;
						// 收益金额(分) = 本金 * 利率 / 12 * 投标至结束期数  / 投标至结束天数
						String incomeAmount = MoneyUtils.formatFloatNumber(principal * rate / 12 * DateUtils.GetTwoDatesMonths(accountInvest.getEndTime(),accountInvest.getFullTime())/ DateUtils.daysBetween(accountInvest.getEndTime(),accountInvest.getFullTime()));
						incomeAmount = incomeAmount.substring(0, incomeAmount.indexOf("."));
						// 归还的本金(分)
						String returnPrincipal = null;

						if (accountInvest.getNextProfitTime().equals(accountInvest.getEndTime()))
						{
							// 标结束--------
							returnPrincipal = accountInvest.getSurplusMoney();
							// 剩余本金归零
							accountInvest.setSurplusMoney("0");
							// 改变状态
							accountInvest.setInvestStatus("1");
							// 修改投标记录
							revenueSettlementMapper.updateInvestInfoByDay(accountInvest);
							if ("1".equals(accountInvest.getIsCredit()))
							{
								// 正在转让的债权，要进行撤销----------------------------
								revenueSettlementMapper.updateTransferStatus(accountInvest.getInvestId());
							}
						}
						else
						{
							// 当前期数
							Integer apartMonth = DateUtils.GetTwoDatesMonths(accountInvest.getNextProfitTime(),
									accountInvest.getFullTime());
							// 算出当前月份应当结算本金的日期
							String settlementDate = DateUtils.GetSysDate("yyyy-MM-dd HH:mm:ss",
									accountInvest.getFullTime(), 0, apartMonth, 0);

							// 判断是否今天是结算部分本金
							if (accountInvest.getNextProfitTime().equals(settlementDate))
							{
								// 今天结算本金一部分-----------------------

								apartMonth = apartMonth + 1;
								accountInvest.setApartMonth(apartMonth);
								// 剩余投标期数
								Integer periods = DateUtils.GetTwoDatesMonths(accountInvest.getEndTime(),
										accountInvest.getNextProfitTime());
								// 每期归还的本金(分) = 剩余金额 / (剩余期限+1)
								returnPrincipal = MoneyUtils.formatFloatNumber(Double.parseDouble(accountInvest.getSurplusMoney())
										/ (periods+1));
								returnPrincipal = returnPrincipal.substring(0, returnPrincipal.indexOf("."));

								// 剩余红包金额 = 红包金额  / (剩余期数+1)
								String reduceRedPackets = MoneyUtils.formatFloatNumber(Double.parseDouble(accountInvest.getCouponMoney())-Double.parseDouble(accountInvest.getCouponMoney()) / (periods +1));
								reduceRedPackets = reduceRedPackets.substring(0, reduceRedPackets.indexOf("."));
								accountInvest.setCouponMoney(reduceRedPackets);

								// 计算剩下的本金
								accountInvest.setSurplusMoney(MoneyUtils.formatFloatNumber(Double.parseDouble(accountInvest
										.getSurplusMoney()) - Integer.parseInt(returnPrincipal)));
								revenueSettlementMapper.updateInvestInfoByDay(accountInvest);
							}
							else
							{
								// 不结算本金
								revenueSettlementMapper.updateInvestInfoByDay(accountInvest);
							}
						}
						// 收益结算
						incomeSettlement(returnPrincipal, incomeAmount, accountInvest);
					}
				}
				else if ("1".equals(accountInvest.getRepeatType()))
				{
					// 先息后本
					if ("0".equals(accountInvest.getIsDayProfit()))
					{
						// ---------------------------------------按月收益
						// 收益计算本金(分)
						Integer principal = Integer.parseInt(accountInvest.getSurplusMoney())
								+ Integer.parseInt(accountInvest.getCouponMoney());
						
						// 利率
						Double rate = Double.parseDouble(accountInvest.getSubjectRate()) / 100;
						
						
						if(flag==4){
							if("1".equals(accountInvest.getCouponDetail().getCouponType())){
								//加息券
								
								//利率 = 利率 - 加息券利率
								rate = rate - Double.parseDouble(accountInvest.getCouponDetail().getCouponMoney())/100;
							}else{
								//增值券、体验金
								
								//收益计算本金(分) = 收益计算本金(分) - 红包金额
								principal = principal - Integer.parseInt(accountInvest.getCouponMoney());
							}
						}
						
						
						
						
						// 收益金额(分) = 本金 * 利率 / 12
						String incomeAmount = MoneyUtils.formatFloatNumber(principal * rate / 12);
						incomeAmount = incomeAmount.substring(0, incomeAmount.indexOf("."));
						// 归还的本金(分)
						String returnPrincipal = null;
						
						// 判断是否结束
						if (accountInvest.getNextProfitTime().equals(accountInvest.getEndTime()))
						{
							// 标结束
							returnPrincipal = accountInvest.getSurplusMoney();
							// 剩余本金归零
							accountInvest.setSurplusMoney("0");
							// 改变状态
							accountInvest.setInvestStatus("1");

							if ("1".equals(accountInvest.getIsCredit()))
							{
								// 正在转让的债权，要进行撤销----------------------------
								revenueSettlementMapper.updateTransferStatus(accountInvest.getInvestId());
							}
						}
						else
						{
							// 投标日至今的月数+1=下次投标日期至投标日的月份
							Integer apartMonth = DateUtils.GetTwoDatesMonths(accountInvest.getNextProfitTime(),
									accountInvest.getFullTime()) + 1;
							accountInvest.setApartMonth(apartMonth);
						}
						// 修改投标记录
						revenueSettlementMapper.updateInvestInfoByMonth(accountInvest);
						
						//双十二IPhone手机投标
						if(accountInvest.getNextProfitTime().equals(accountInvest.getEndTime()) && Constants.TWELVE_ACTIVITY_IPHONEX.equals(accountInvest.getSubjectId())){
							
							//双十二Iphone手机投标结算
							incomeSettlement(incomeAmount, accountInvest);
						}else{
							// 收益结算
							incomeSettlement(returnPrincipal, incomeAmount, accountInvest);
						}

					}
					else
					{
						// ---------------------------------------按天收益
						
						
						// 收益计算本金(分)
						Integer principal = Integer.parseInt(accountInvest.getSurplusMoney())
								+ Integer.parseInt(accountInvest.getCouponMoney());
						
						// 利率
						Double rate = Double.parseDouble(accountInvest.getSubjectRate()) / 100;
						
						
						if(flag==4){
							if("1".equals(accountInvest.getCouponDetail().getCouponType())){
								//加息券
								
								//利率 = 利率 - 加息券利率
								rate = rate - Double.parseDouble(accountInvest.getCouponDetail().getCouponMoney())/100;
							}else{
								//增值券、体验金
								
								//收益计算本金(分) = 收益计算本金(分) - 红包金额
								principal = principal - Integer.parseInt(accountInvest.getCouponMoney());
							}
						}
						
						
						
						
						// 收益金额(分) = 收益计算本金 * 利率 / 12 / 当月天数
						String incomeAmount = MoneyUtils.formatFloatNumber(principal * rate / 12 / DateUtils.getDaysBydate(accountInvest.getNextProfitTime()));
						incomeAmount = incomeAmount.substring(0, incomeAmount.indexOf("."));
						// 归还的本金(分)
						String returnPrincipal = null;
						// 判断是否结束
						if (accountInvest.getNextProfitTime().equals(accountInvest.getEndTime()))
						{
							// 标结束
							returnPrincipal = accountInvest.getSurplusMoney();
							// 剩余本金归零
							accountInvest.setSurplusMoney("0");
							// 改变状态
							accountInvest.setInvestStatus("1");

							if ("1".equals(accountInvest.getIsCredit()))
							{
								// 正在转让的债权，要进行撤销----------------------------
								revenueSettlementMapper.updateTransferStatus(accountInvest.getInvestId());
							}
						}
						// 修改投标记录
						revenueSettlementMapper.updateInvestInfoByDay(accountInvest);
						// 收益结算
						incomeSettlement(returnPrincipal, incomeAmount, accountInvest);
					}
				}
				else
				{
					// 到期还本付息
					// 收益计算本金(分)
					Integer principal = Integer.parseInt(accountInvest.getSurplusMoney())
							+ Integer.parseInt(accountInvest.getCouponMoney());
					// 利率（14.5% = 0.145）
					Double rate = Double.parseDouble(accountInvest.getSubjectRate()) / 100;
					
					//投资天数
					Integer termOfInvestment = DateUtils.daysBetween(accountInvest.getEndTime(), accountInvest.getFullTime());
					String incomeAmount ="";
					if(flag>1){
						//优惠券期限不足标期限
						
						//优惠券期限
						Integer couponDays = Integer.parseInt(accountInvest.getCouponDetail().getInterestDays());
						
						
						//判断天标月标
						if("0".equals(accountInvest.getSubjectTerm())){
							//天
							
							//优惠券期限收益 = 收益金额*利率/365*优惠券期限
							incomeAmount = MoneyUtils.formatFloatNumber(principal*rate/365*couponDays);
							
							//过了优惠券期限后减少优惠券金额（利率）
							if("1".equals(accountInvest.getCouponDetail().getCouponType())){
								//加息券
								//利率 = 利率 - 加息券利率
								rate = rate - Double.parseDouble(accountInvest.getCouponDetail().getCouponMoney())/100;
							}else{
								//增值券、体验金
								//收益计算本金(分) = 收益计算本金(分) - 红包金额
								principal = principal - Integer.parseInt(accountInvest.getCouponMoney());
							}
							
							// 最终收益 =  已用优惠券收益 + 本金*利率/365*(投资天数 - 优惠券期限)
							incomeAmount = MoneyUtils.formatFloatNumber(Double.parseDouble(incomeAmount) + principal * rate / 365 * (termOfInvestment-couponDays));
							
						}else if("1".equals(accountInvest.getSubjectTerm())){
							//月
							
							//投资月份
							Integer investmentMonth = DateUtils.GetTwoDatesMonths(accountInvest.getEndTime(), accountInvest.getFullTime());
							
							//优惠券期限收益 = 收益金额*利率/12*优惠券期限
							incomeAmount = MoneyUtils.formatFloatNumber(principal*rate/12*couponDays);
							
							if("1".equals(accountInvest.getCouponDetail().getCouponType())){
								//加息券
								
								//利率 = 利率 - 加息券利率
								rate = rate - Double.parseDouble(accountInvest.getCouponDetail().getCouponMoney())/100;
							}else{
								//增值券、体验金
								
								//收益计算本金(分) = 收益计算本金(分) - 红包金额
								principal = principal - Integer.parseInt(accountInvest.getCouponMoney());
							}
							
							// 最终收益 =  已用优惠券收益 + 本金*利率/12*(投资天数 - 优惠券期限)
							incomeAmount = MoneyUtils.formatFloatNumber(Double.parseDouble(incomeAmount) + principal * rate / 12 * (investmentMonth-couponDays));
							
						}
					}else{
						//未使用优惠券或优惠券是全期
						
						// 收益金额(分) = 本金*利率/365天 *（结束日至投标日天数）
						incomeAmount = MoneyUtils.formatFloatNumber(principal * rate / 365
								* termOfInvestment);
					}
					incomeAmount = incomeAmount.substring(0, incomeAmount.indexOf("."));
					// 归还的本金(分)
					String returnPrincipal = accountInvest.getSurplusMoney();
					// 剩余本金归零
					accountInvest.setSurplusMoney("0");
					// 改变状态
					accountInvest.setInvestStatus("1");
					if ("1".equals(accountInvest.getIsCredit()))
					{
						// 正在转让的债权，要进行撤销----------------------------
						revenueSettlementMapper.updateTransferStatus(accountInvest.getInvestId());
					}
					// 修改投标记录
					revenueSettlementMapper.updateInvestInfoByMonth(accountInvest);
					// 收益结算
					incomeSettlement(returnPrincipal, incomeAmount, accountInvest);
				}
			}
		}
		catch (Exception e)
		{
			logger.error("收益结算异常");
			throw new RuntimeException(e);
		}

	}

	/**
	 * 判断投标使用优惠券期限
	 * @Description:
	 * @param accountInvest
	 * @return 返回flag值 
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年9月13日 上午10:51:43
	 */
	private Integer couponPeriod(AccountInvest accountInvest)throws Exception{
		Integer flag = -1;
		// 判断是否使用优惠券，使用的优惠券期限
		CouponDetail couponDetail = accountInvest.getCouponDetail();
		if(couponDetail!=null&&couponDetail.getCouDetailId()!=null){
			//判断是否过期
			
			//优惠券期限
			String interestDays = couponDetail.getInterestDays();
			
			Integer term = Integer.parseInt(accountInvest.getSubjectPeriods());
			if("-1".equals(interestDays)){
				//无限制
				flag = 1;
			}else if(Integer.parseInt(interestDays)>=term){
				//满期限
				flag = 1;
			}else{
				//不满期限
				//投资期限判断天还是月
				Integer periodOfInvestment = 0;
				if("0".equals(accountInvest.getSubjectTerm())){
					//天
					periodOfInvestment = DateUtils.daysBetween(accountInvest.getNextProfitTime(), accountInvest.getFullTime());
				}else if("1".equals(accountInvest.getSubjectTerm())){
					//月
					periodOfInvestment = DateUtils.GetTwoDatesMonths(accountInvest.getNextProfitTime(), accountInvest.getFullTime());
				}
				
				if(Integer.parseInt(interestDays)>periodOfInvestment){
					//未过期
					flag = 2;
				}else if(Integer.parseInt(interestDays)==periodOfInvestment){
					//正好到期
					flag = 3;
				}else{
					//已过期
					flag = 4;
				}
			}
		}else{
			//未使用优惠券
			flag = -1;
		}
		return flag ;
	}
	
	
	
	
	/**
	 * 计算收益 发送信息
	 * 
	 * @Description:
	 * @param returnPrincipal
	 *            归还本金
	 * @param incomeAmount
	 *            收益
	 * @param accountInvest
	 *            投标记录
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月14日 下午4:44:55
	 */
	@Transactional
	public void incomeSettlement(String returnPrincipal, String incomeAmount, AccountInvest accountInvest)
			throws Exception
	{
		
		//-----------------------收取收益管理费用
		Double expenseRate = Double.parseDouble(accountInvest.getExpenseRate());
		String expenseMoney = "0.0";
		if(expenseRate>0){
			expenseMoney =  MoneyUtils.formatFloatNumber(expenseRate * Double.parseDouble(incomeAmount) /100);
		}
		expenseMoney = expenseMoney.substring(0, expenseMoney.indexOf("."));
		
		// --------------------------------------------------------查询出账户金额 修改金额
		// --------------------------------------------------------
		AccountCapital accountCapital = revenueSettlementMapper.getBalances(accountInvest.getAccountId());
		/*Boolean flag = true;*/
		if("1".equals(accountInvest.getIsGold())){
			
			
			if (returnPrincipal != null)
			{
				// 等额本息 归还本金、增加收益
				Integer investmentMoney = Integer.parseInt(accountCapital.getInvestmentMoney())
						- Integer.parseInt(returnPrincipal);
				accountCapital.setInvestmentMoney(String.valueOf(investmentMoney));
				Integer noWithdrawMoney = Integer.parseInt(accountCapital.getNoWithdrawMoney())
						+ Integer.parseInt(returnPrincipal) + Integer.parseInt(incomeAmount) - Integer.parseInt(expenseMoney);
				accountCapital.setNoWithdrawMoney(String.valueOf(noWithdrawMoney));
				
				//收益返还
				accountInvest.getProfitReturnBean().setProfitMoney(String.valueOf(Integer.parseInt(returnPrincipal) + Integer.parseInt(incomeAmount) - Integer.parseInt(expenseMoney)));
				
			}
			else
			{
				// 先息后本 只增加收益
				Integer noWithdrawMoney = Integer.parseInt(accountCapital.getNoWithdrawMoney())
						+ Integer.parseInt(incomeAmount) - Integer.parseInt(expenseMoney);
				accountCapital.setNoWithdrawMoney(String.valueOf(noWithdrawMoney));
				
				//收益返还
				accountInvest.getProfitReturnBean().setProfitMoney(String.valueOf(Integer.parseInt(incomeAmount) - Integer.parseInt(expenseMoney)));
			}

			accountInvest.getProfitReturnBean().setType("1");
			profitReturnMapper.addProfitReturn(accountInvest.getProfitReturnBean());
			
			
		}else{
			if (returnPrincipal != null)
			{
				// 等额本息 归还本金、增加收益
				Integer investmentMoney = Integer.parseInt(accountCapital.getInvestmentMoney())
						- Integer.parseInt(returnPrincipal);
				accountCapital.setInvestmentMoney(String.valueOf(investmentMoney));
				Integer withdrawMoney = Integer.parseInt(accountCapital.getWithdrawMoney())
						+ Integer.parseInt(returnPrincipal) + Integer.parseInt(incomeAmount) - Integer.parseInt(expenseMoney);
				accountCapital.setWithdrawMoney(String.valueOf(withdrawMoney));
			}
			else
			{
				// 先息后本 只增加收益
				Integer withdrawMoney = Integer.parseInt(accountCapital.getWithdrawMoney())
						+ Integer.parseInt(incomeAmount) - Integer.parseInt(expenseMoney);
				accountCapital.setWithdrawMoney(String.valueOf(withdrawMoney));
			}
		}
		/*if(!flag){
			//金账户异常，处理
			
			
			
			return ;
		}*/
		// 修改金额
		revenueSettlementMapper.changeFunds(accountCapital);

		// --------------------------------------------------资金明细----------------------------------------------------------------------
		if (returnPrincipal != null)
		{
			// 资金明细：投资金额-
			CapitalDetail investMent = new CapitalDetail();
			investMent.setAccountId(accountInvest.getAccountId());
			investMent.setMoney(returnPrincipal);
			investMent.setType(Constants.DEVIL_NUM_NINE);
			investMent.setInExpend(Constants.DEVIL_NUM_ONE);
			investMent.setRemark("支出投资金额：" + Double.parseDouble(returnPrincipal) / 100+"元");
			revenueSettlementMapper.addCapital(investMent);
			// 资金明细：本金+
			CapitalDetail principal = new CapitalDetail();
			principal.setAccountId(accountInvest.getAccountId());
			principal.setMoney(returnPrincipal);
			principal.setType(Constants.DEVIL_NUM_NINE);
			principal.setInExpend(Constants.DEVIL_NUM_ZERO);
			principal.setRemark("收入本金：" + Double.parseDouble(returnPrincipal) / 100+"元");
			revenueSettlementMapper.addCapital(principal);
		}
		// 资金明细：收益+
		CapitalDetail income = new CapitalDetail();
		income.setAccountId(accountInvest.getAccountId());
		income.setMoney(incomeAmount);
		income.setType(Constants.DEVIL_NUM_FOUR);
		income.setInExpend(Constants.DEVIL_NUM_ZERO);
		income.setRemark("收入收益：" + Double.parseDouble(incomeAmount) / 100+"元");
		revenueSettlementMapper.addCapital(income);

		if(expenseRate>0){
			//利息管理费
			CapitalDetail expense = new CapitalDetail();
			expense.setAccountId(accountInvest.getAccountId());
			expense.setMoney(expenseMoney);
			expense.setType("20");
			expense.setInExpend(Constants.DEVIL_NUM_ONE);
			expense.setRemark("利息管理费：" + Double.parseDouble(expenseMoney) / 100+"元");
			revenueSettlementMapper.addCapital(expense);
		}
		
		
		// 发送消息
		MessageBean outMessageBean = new MessageBean();
		outMessageBean.setAccountId(accountInvest.getAccountId());
		outMessageBean.setMsgTitle("投资到期");
		
		if(expenseRate>0){
			outMessageBean.setMsgContent("您投资的标,已产生收益" + Double.parseDouble(incomeAmount) / 100+"元！扣除利息管理费" + Double.parseDouble(expenseMoney) / 100 + "元。详情请在我的<a href='javascript:void(0)' onclick='goDetails(1)'>资金明细</a>中查看。");
		}else{
			outMessageBean.setMsgContent("您投资的标,已产生收益" + Double.parseDouble(incomeAmount) / 100+"元！详情请在我的<a href='javascript:void(0)' onclick='goDetails(1)'>资金明细</a>中查看。");
		}
		
		messageMapper.addMessageInfo(outMessageBean);
	}
	
	/**
	 * 金账户还款
	 * @Description:
	 * @param returnPrincipal 归还本金
	 * @param incomeAmount 收益
	 * @param accountInvest 投标记录
	 * @param expenseMoney 利息管理费
	 * @param accountCapital 用户资金
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月7日 下午4:20:44
	 */
	@Transactional
	public Boolean goldAccountRepayment(String returnPrincipal, String incomeAmount, AccountInvest accountInvest,String expenseMoney,AccountCapital accountCapital){
		Boolean flag = false;
		try
		{
			String userTel = userCapitalMapper.getUserTelephone(accountInvest.getUserId());
			//查看借款人金账户余额
			UserCapitalBean userCapital = userCapitalMapper.queryUserCapital(userTel);
			String userBalance = userCapital.getBalance();
			
			returnPrincipal = returnPrincipal==null ? "0" : returnPrincipal;
			
			AccountInfo account = accountInfoMapper.getLoginAccountInfo(accountInvest.getAccountId());
			// 借款人需还款
			Integer repaymentMoney = Integer.parseInt(returnPrincipal)+Integer.parseInt(incomeAmount);
			
			if(Integer.parseInt(userBalance)>=repaymentMoney){
				//借款人-->投资人[转账-还款]
				Map<String, String> repayMap = InterfaceUtil.custToCust(userTel, account.getTelephone(), String.valueOf(repaymentMoney));
				fuiouService.addGoldTransfer(repayMap, userTel, account.getTelephone());
				//userCapitalDetailMapper goldDetailsMapper
				if("0000".equals(repayMap.get("resp_code"))){
					//借款人账户-->投资人[资金明细,金账户明细]
					GoldDetailsBean goldDetailsBean = new GoldDetailsBean();
					goldDetailsBean.setInCustNo(account.getTelephone());
					goldDetailsBean.setOutCustNo(userTel);
					goldDetailsBean.setMoney(String.valueOf(repaymentMoney));
					goldDetailsBean.setTransferType("4");
					goldDetailsBean.setPurpose("2");
					goldDetailsBean.setRemark("借款人:"+userTel+",还款给投资人:"+account.getTelephone()+";"+(repaymentMoney/100.0)+"元(本金加利息)");
					goldDetailsMapper.addGoldDetail(goldDetailsBean);
					
					//修改账户信息
					userBalance = String.valueOf(Integer.parseInt(userBalance)-repaymentMoney);
					userCapital.setBalance(userBalance);
					userCapitalMapper.updateUserCapital(userCapital);
					
					//借款人资金明细
					UserCapitalDetailBean userCapitalDetailBean = new UserCapitalDetailBean();
					userCapitalDetailBean.setUserId(accountInvest.getUserId());
					userCapitalDetailBean.setMoney(String.valueOf(repaymentMoney));
					userCapitalDetailBean.setType("0");
					userCapitalDetailBean.setInExpend("1");
					userCapitalDetailBean.setRemark("还款"+repaymentMoney/100.0+"元");
					userCapitalDetailBean.setIsShow("1");
					userCapitalDetailMapper.addUserCapitalDetail(userCapitalDetailBean);
					
					String shopNo = paramMapper.getParamVal("JZH_SHOP");
					
					//投资人-->商户[转账-利息管理费]
					Map<String, String> managementMap =InterfaceUtil.shopToCust(account.getTelephone(), shopNo, expenseMoney);
					fuiouService.addGoldTransfer(managementMap, account.getTelephone(), shopNo);
					if("0000".equals(managementMap.get("resp_code"))){
						//投资人-->商户[金账户明细]
						GoldDetailsBean goldDetail = new GoldDetailsBean();
						goldDetail.setInCustNo(shopNo);
						goldDetail.setOutCustNo(userTel);
						goldDetail.setMoney(expenseMoney);
						goldDetail.setTransferType("1");
						goldDetail.setPurpose("5");
						goldDetail.setRemark("投资人:"+userTel+",支付利息管理费,"+(Integer.parseInt(expenseMoney)/100.0)+"元");
						goldDetailsMapper.addGoldDetail(goldDetail);
						
						
						
						
						//投资人资金表-----资金变动
						Integer investmentMoney = Integer.parseInt(accountCapital.getInvestmentMoney())
								- Integer.parseInt(returnPrincipal);
						accountCapital.setInvestmentMoney(String.valueOf(investmentMoney));
						Integer noWithdrawMoney = Integer.parseInt(accountCapital.getNoWithdrawMoney())
								+ Integer.parseInt(returnPrincipal) + Integer.parseInt(incomeAmount) - Integer.parseInt(expenseMoney);
						accountCapital.setNoWithdrawMoney(String.valueOf(noWithdrawMoney));
						
						
						flag = true;
						
					}
					
				}
				
			}
			
		}
		catch (Exception e)
		{
			//sss;
		}
		return flag;
	}
	
	
	
	
	/**
	 * 活动体验金计算收益 发送信息
	 * @Description:
	 * @param incomeAmount
	 * @param accountInvest
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年7月24日 下午9:51:04
	 */
	/*public void activityIncomeSettlement(String incomeAmount, AccountInvest accountInvest)
			throws Exception
	{
		// --------------------------------------------------------查询出账户金额 修改金额
		// --------------------------------------------------------
		AccountCapital accountCapital = revenueSettlementMapper.getBalances(accountInvest.getAccountId());
		
		// 活动体验金 只增加收益
		Integer withdrawMoney = Integer.parseInt(accountCapital.getWithdrawMoney())+ Integer.parseInt(incomeAmount);
		accountCapital.setWithdrawMoney(String.valueOf(withdrawMoney));
		
		// 修改金额
		revenueSettlementMapper.changeFunds(accountCapital);

		// --------------------------------------------------资金明细----------------------------------------------------------------------
		
		// 资金明细：收益+
		CapitalDetail income = new CapitalDetail();
		income.setAccountId(accountInvest.getAccountId());
		income.setMoney(incomeAmount);
		income.setType(Constants.DEVIL_NUM_FOUR);
		income.setInExpend(Constants.DEVIL_NUM_ZERO);
		income.setRemark("收入收益：" + Double.parseDouble(incomeAmount) / 100);
		revenueSettlementMapper.addCapital(income);

		// 发送消息
		MessageBean outMessageBean = new MessageBean();
		outMessageBean.setAccountId(accountInvest.getAccountId());
		outMessageBean.setMsgTitle("体验金使用结束");
		outMessageBean.setMsgContent("您使用的3000元体验金,7日计息已结束！收益已发放至您的个人账户中,详情请在我的资金明细中查看。");
		messageMapper.addMessageInfo(outMessageBean);

	}*/
	
	
	/**
	 * 修改转让记录
	 * @Description:
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月20日 下午4:26:25
	 */
	@Override
	public void updateTransferRecord() throws Exception
	{
		//获得当前未转让成功、未结束、未撤销 的转让记录
		List<CreditRecord> creditRecords = revenueSettlementMapper.getCreditRecords();
		for (CreditRecord creditRecord : creditRecords)
		{
			creditRecord = updateTransferAmount(creditRecord);
			revenueSettlementMapper.updateCreditRecord(creditRecord);
		}

	}

	/**
	 * 修改转让记录
	 * @Description:
	 * @param creditRecord
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月20日 下午4:32:54
	 */
	@Override
	public CreditRecord updateTransferAmount(CreditRecord creditRecord) throws Exception
	{
		// 转让金额
		String transferAmount = creditRecord.getAccountInvest().getSurplusMoney();
		// 垫付金额
		String advanceAmount = "0.0";
		// 利率修正金额
		String interestRateAmendment = "0.0";

		// 投标金额
		String investMoney = creditRecord.getAccountInvest().getInvestMoney();
		// 投标日期
		String investTime = creditRecord.getAccountInvest().getFullTime();
		// 结束日期
		String endTime = creditRecord.getAccountInvest().getEndTime();
		// 上次结算日期
		String lastProfitTime = creditRecord.getAccountInvest().getLastProfitTime();
		// 下次结算日期
		String nextProfitTime = creditRecord.getAccountInvest().getNextProfitTime();
		// 原利率
		Double subjectRate = Double.parseDouble(creditRecord.getAccountInvest().getSubjectRate()) / 100;
		// 转让利率
		Double creditRate = Double.parseDouble(creditRecord.getCreditRate()) / 100;
		// 利率差
		String interestRateDifference = subjectRate > creditRate ? String.valueOf(subjectRate - creditRate) : String
				.valueOf(creditRate - subjectRate);

		// 当前时间
		String nowDate = revenueSettlementMapper.getNow();
		//
		Boolean flag = DateUtils.compareDateLong(nowDate, lastProfitTime);
		if (flag)
		{
			if ("0".equals(creditRecord.getAccountInvest().getRepeatType()))
			{
				// 等额本息----------------------------------------------------------------------
				if ("0".equals(creditRecord.getAccountInvest().getIsDayProfit()))
				{
					// 月付
					// 计算利率修正金额------------------------------------------------------------------
					// 投标期限(月份) = 结束日期-投标日期
					Integer tenderPeriod = DateUtils.GetTwoDatesMonths(endTime, investTime);
					// 剩余期数(月份) = 结束日 - 下次结算日
					Integer apartMonth = DateUtils.GetTwoDatesMonths(endTime, nextProfitTime);
					// 当前期的日数(天数) = 下次结算日期 - 上次结算日期
					Integer monthDay = DateUtils.daysBetween(nextProfitTime, lastProfitTime);
					// 本期剩余天数(天数) = 下次结算日期-今天
					Integer revisedDate = DateUtils.daysBetween(nextProfitTime, nowDate);
					// 垫付日期(天数) = 今天-上次结算时间
					Integer revisedDate1 = DateUtils.daysBetween(nowDate, lastProfitTime);
					// 每期返还金额
					String returnPrincipal = MoneyUtils.formatFloatNumber(Double.parseDouble(investMoney) / tenderPeriod);
					returnPrincipal = returnPrincipal.substring(0, returnPrincipal.indexOf("."));
					for (int i = tenderPeriod - apartMonth; i < tenderPeriod; i++)
					{
						// 计算本金 = 投标金额 - 每期返回金额 * 返还次数
						int money = Integer.parseInt(transferAmount) - Integer.parseInt(returnPrincipal)
								* (i-1);
						// 计算修正金额 = 修正金额 + 本金 * 差额利率 / 12
						interestRateAmendment = MoneyUtils.formatFloatNumber(Double.parseDouble(interestRateAmendment) + money
								* Double.parseDouble(interestRateDifference) / 12);
					}

					// 修正金额 = 修正金额 + 本金 * 差额利率 / 12 / 当前期天数 * 当前期剩余天数
					if(revisedDate!=0){
						interestRateAmendment = MoneyUtils.formatFloatNumber(Double.parseDouble(interestRateAmendment)
								+ Double.parseDouble(transferAmount) * Double.parseDouble(interestRateDifference) / 12
								/ monthDay / revisedDate);
					}
					
					interestRateAmendment = interestRateAmendment.substring(0, interestRateAmendment.indexOf("."));
					creditRecord.setOutMoney(interestRateAmendment);

					// 计算垫付金额----------------------------------------------------------------------------
					if(revisedDate1!=0){
						advanceAmount = MoneyUtils.formatFloatNumber(Double.parseDouble(transferAmount)
								* creditRate / 12 / monthDay * revisedDate1);
					}
					advanceAmount = advanceAmount.substring(0, advanceAmount.indexOf("."));
					creditRecord.setDealMoney(advanceAmount);
				}
				else
				{
					// 日付
					
				}

			}
			else if ("1".equals(creditRecord.getAccountInvest().getRepeatType()))
			{
				// 先息后本
				if ("0".equals(creditRecord.getAccountInvest().getIsDayProfit()))
				{
					// 月付
					// 计算利率修正金额-------------------------
					// 剩余期数 = 结束日-下次结算之间的月份
					Integer apartMonth = DateUtils.GetTwoDatesMonths(endTime, nextProfitTime);
					// 本期天数 = 下次结算日期-上次结算日期
					Integer monthDay = DateUtils.daysBetween(nextProfitTime, lastProfitTime);
					// 本期剩余天数 = 下次结算日期-今天
					Integer revisedDate = DateUtils.daysBetween(nextProfitTime, nowDate);
					// 利率修正金额(剩余期数) = 转让金额 * 利率差 / 12 * 剩余期数
					interestRateAmendment = MoneyUtils.formatFloatNumber(Integer.parseInt(transferAmount) * Double.parseDouble(interestRateDifference) / 12 * apartMonth);
					// 利率修正金额 = 利率修正金额(剩余期数) + 转让金额 * 利率差 / 12 / 本期天数 *
					// 下次结算日期至今天的天数
					interestRateAmendment = MoneyUtils.formatFloatNumber(Double.parseDouble(interestRateAmendment)
							+ Integer.parseInt(transferAmount) * Double.parseDouble(interestRateDifference) / 12
							/ monthDay * revisedDate);
					interestRateAmendment = interestRateAmendment.substring(0, interestRateAmendment.indexOf("."));
					creditRecord.setOutMoney(interestRateAmendment);

					// 计算垫付金额--------------------------------
					// 垫付日期 = 今天-上次结算时间
					Integer revisedDate1 = DateUtils.daysBetween(nowDate, lastProfitTime);
					// 垫付金额 = 转让金额*转让利率/12/本期天数*今天至上次结算日期天数
					if(revisedDate1!=0){
						advanceAmount = MoneyUtils.formatFloatNumber(Double.parseDouble(transferAmount) * creditRate / 12 / monthDay
								* revisedDate1);
						
					}
					advanceAmount = advanceAmount.substring(0, advanceAmount.indexOf("."));
					creditRecord.setDealMoney(advanceAmount);
				}
				else
				{
					// 日付
					// 计算利率修正金额-------------------------
					// 剩余期限是几个月份
					Integer apartMonth = DateUtils.GetTwoDatesMonths(endTime, nextProfitTime);
					Integer daysBetween = DateUtils.daysBetween(endTime, nextProfitTime);
					// 判断是否同月
					if (apartMonth == 0)
					{
						// 同月
						// 利率修正金额 = 本金 * 利率差/12/下次结算日天数*下次结算日至结束日天数
						interestRateAmendment = MoneyUtils.formatFloatNumber(Integer.parseInt(transferAmount)
								* Double.parseDouble(interestRateDifference) / 12
								/ DateUtils.getDaysBydate(nextProfitTime) * daysBetween);
						interestRateAmendment = interestRateAmendment.substring(0, interestRateAmendment.indexOf("."));
						creditRecord.setOutMoney(interestRateAmendment);
					}
					else
					{
						// 不同月
						// 利率修正金额（下次结算日当月） = 本金 * 利率差/12/下次结算日天数*下次结算日至月末天数
						interestRateAmendment = String
								.valueOf(Integer.parseInt(transferAmount)
										* Double.parseDouble(interestRateDifference)
										/ 12
										/ DateUtils.getDaysBydate(nextProfitTime)
										* (DateUtils.daysBetween(DateUtils.getMaxDayByDate(nextProfitTime),
												nextProfitTime) + 1));
						// 下次结算日下月至结束日上月
						for (int i = 1; i < apartMonth; i++)
						{
							// 按整月计算
							// 利率修正金额（下次结算日下月至结束日上月） = 之前的利率修正金额 + 本金*利率差/12
							interestRateAmendment = MoneyUtils.formatFloatNumber(Double.parseDouble(interestRateAmendment)
									+ Integer.parseInt(transferAmount) * Double.parseDouble(interestRateDifference)
									/ 12);
						}
						// 利率修正金额（结束日当月）
						interestRateAmendment = MoneyUtils.formatFloatNumber(Double.parseDouble(interestRateAmendment)
								+ Integer.parseInt(transferAmount) * Double.parseDouble(interestRateDifference) / 12
								/ DateUtils.getDaysBydate(endTime)
								* (DateUtils.daysBetween(DateUtils.getMinDayByDate(endTime), endTime) + 1));
					}
					interestRateAmendment = interestRateAmendment.substring(0, interestRateAmendment.indexOf("."));
					creditRecord.setOutMoney(interestRateAmendment);

					// 计算垫付金额--------------------------------
					// 垫付金额 = 转让金额*转让利率/12/下次结算日天数*1
					advanceAmount = MoneyUtils.formatFloatNumber(Double.parseDouble(transferAmount) * creditRate / 12
							/ DateUtils.getDaysBydate(nextProfitTime) * 1);
					advanceAmount = advanceAmount.substring(0, advanceAmount.indexOf("."));
					creditRecord.setDealMoney(advanceAmount);

				}
			}
			else
			{
				// 到期还本付息（二期）
				
				
				
				
				
			}
		}

		// 转让金额为剩余金额
		creditRecord.setCreditMoney(transferAmount);
		return creditRecord;
	}
	

	
	/**
	 * 猫咪宝收益发放
	 */
	@Override
	@Transactional
	public void grantProfit() throws Exception
	{
		try
		{
			//---------------------------------------------计算收益--------------------------------------------------------
			//获取昨天之前未合并的记录 根据标ID查询前天的利率
			List<FreedomSubjectBean> noMergeFreedomSubjectBeans = revenueSettlementMapper.getBeforeLastDayNoMerge();
			
			
			for (FreedomSubjectBean freedomSubjectBean : noMergeFreedomSubjectBeans)
			{
				if(revenueSettlementMapper.checkFreedomProfit(freedomSubjectBean)==0){
					String profit = "0.0";
					//收益计算 = 本金昨天之前未合并金额 * 前天利率 / 12 /当月天数
					profit = String.valueOf(Integer.parseInt(freedomSubjectBean.getFreedomMoney())
							* Double.parseDouble(freedomSubjectBean.getFreedomRate())/100 / 12
							/ DateUtils.getCurrentMonthDay());
					profit = profit.substring(0, profit.indexOf("."));
					if(!"0".equals(profit)){
						settlementIncome(freedomSubjectBean,profit);
					}
					freedomSubjectBean.setProfitMoney(profit);
					//添加收益记录
					revenueSettlementMapper.addFreedomProfit(freedomSubjectBean);
				}
			}
		}
		catch (Exception e)
		{
			logger.error("猫咪宝收益结算异常");
			throw new RuntimeException(e);
		}
	}

	
	
	private void settlementIncome(FreedomSubjectBean bean,String profit)throws Exception{
		// --------------------------------------------------------查询出账户金额 修改金额
		// --------------------------------------------------------
		AccountCapital accountCapital = revenueSettlementMapper.getBalances(bean.getAccountId());
		Integer withdrawMoney = Integer.parseInt(accountCapital.getWithdrawMoney()) + Integer.parseInt(profit);
		accountCapital.setWithdrawMoney(String.valueOf(withdrawMoney));
				
		// 修改金额
		revenueSettlementMapper.changeFunds(accountCapital);

		// 资金明细：收益+
		CapitalDetail income = new CapitalDetail();
		income.setAccountId(bean.getAccountId());
		income.setMoney(profit);
		income.setType("14");
		income.setInExpend(Constants.DEVIL_NUM_ZERO);
		income.setRemark("猫咪宝收入收益：" + Double.parseDouble(profit) / 100);
		revenueSettlementMapper.addCapital(income);

		// 发送消息
		MessageBean outMessageBean = new MessageBean();
		outMessageBean.setAccountId(bean.getAccountId());
		outMessageBean.setMsgTitle("猫咪宝投资收益");
		outMessageBean.setMsgContent("您的猫咪宝,已产生收益" + Double.parseDouble(profit) / 100+"元！详情请在我的<a href='javascript:void(0)' onclick='goDetails(1)'>资金明细</a>中查看。");
		messageMapper.addMessageInfo(outMessageBean);
	}

	@Override
	@Transactional
	public void mergeRecord() throws Exception
	{
		try
		{
			//----------------------------------------合并-------------------------------------------------------
			//查询要结算收益的猫咪宝投资记录(前天未合并的)
			List<FreedomSubjectBean> freedomSubjectBeans = revenueSettlementMapper.getSettlementFreedom();
			
			for (FreedomSubjectBean freedomSubjectBean : freedomSubjectBeans)
			{
				
				FreedomSubjectBean freedomNoMerge = new FreedomSubjectBean();
				//猫咪宝投资明细ID
				String recordId = freedomSubjectBean.getRecordId();
				//猫咪宝投资金额
				String freedomMoney = freedomSubjectBean.getFreedomMoney();
				String[] recordIds = recordId.split(",");
				String[] freedomMoneys = freedomMoney.split(",");
				
				Integer freedomMoneySum = 0;
				//循环计算累计金额 修改合并投资记录(除了最后一条)
				for (int i = 0; i < recordIds.length-1; i++)
				{
					//金额累加
					freedomMoneySum += Integer.parseInt(freedomMoneys[i]);
					freedomNoMerge.setMergeId(recordIds[recordIds.length-1]);
					freedomNoMerge.setRecordId(recordIds[i]);
					revenueSettlementMapper.updateMergeFreedom(freedomNoMerge);
				}
				
				//获得前天之前未合并的猫咪宝投资记录
				freedomNoMerge = revenueSettlementMapper.getNoMerge(freedomSubjectBean);
				
				//合并前天之前合并的投资记录
				if(freedomNoMerge != null){
					freedomMoneySum += Integer.parseInt(freedomNoMerge.getFreedomMoney());
					freedomNoMerge.setMergeId(recordIds[recordIds.length-1]);
					revenueSettlementMapper.updateMergeFreedom(freedomNoMerge);
				}
				//最后一条记录计算进去
				freedomMoneySum+=Integer.parseInt(freedomMoneys[recordIds.length-1]);
				
				//合并成最后一条记录
				freedomNoMerge = new FreedomSubjectBean();
				freedomNoMerge.setRecordId(recordIds[recordIds.length-1]);
				freedomNoMerge.setFreedomMoney(String.valueOf(freedomMoneySum));
				revenueSettlementMapper.updateMergeMoneys(freedomNoMerge);
				
			}
		}
		catch (Exception e)
		{
			logger.error("猫咪宝收益结算异常");
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public AccountInvest getSettlementIncomeInvestInfoById(String investId) throws SQLException
	{
		return revenueSettlementMapper.getSettlementIncomeInvestInfoById(investId);
	}
	
	/**
	 * 双十二投资结算
	 * @Description:
	 * @param incomeAmount 收益
	 * @param accountInvest 投资记录
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年12月6日 下午4:35:45
	 */
	@Transactional
	public void incomeSettlement(String incomeAmount, AccountInvest accountInvest)
			throws Exception
	{
		//返还本金
		String returnPrincipal = accountInvest.getInvestMoney();
		
		if("2000000".equals(accountInvest.getInvestMoney())){
			returnPrincipal = String.valueOf(Integer.parseInt(returnPrincipal) - Integer.parseInt(Constants.TWELVE_ACTIVITY_BUY_TWO));
		}else if("3000000".equals(accountInvest.getInvestMoney())){
			returnPrincipal = String.valueOf(Integer.parseInt(returnPrincipal) - Integer.parseInt(Constants.TWELVE_ACTIVITY_BUY_THREE));
		}
		
		// --------------------------------------------------------查询出账户金额 修改金额
		// --------------------------------------------------------
		AccountCapital accountCapital = revenueSettlementMapper.getBalances(accountInvest.getAccountId());
		// 等额本息 归还本金、增加收益
		Integer investmentMoney = Integer.parseInt(accountCapital.getInvestmentMoney())
				- Integer.parseInt(accountInvest.getInvestMoney());
		accountCapital.setInvestmentMoney(String.valueOf(investmentMoney));
		Integer withdrawMoney = Integer.parseInt(accountCapital.getWithdrawMoney())
				+ Integer.parseInt(returnPrincipal) + Integer.parseInt(incomeAmount);
		accountCapital.setWithdrawMoney(String.valueOf(withdrawMoney));
		
		// 修改金额
		revenueSettlementMapper.changeFunds(accountCapital);

		// --------------------------------------------------资金明细----------------------------------------------------------------------
		
		// 资金明细：投资金额-
		CapitalDetail investMent = new CapitalDetail();
		investMent.setAccountId(accountInvest.getAccountId());
		investMent.setMoney(accountInvest.getInvestMoney());
		investMent.setType(Constants.DEVIL_NUM_NINE);
		investMent.setInExpend(Constants.DEVIL_NUM_ONE);
		investMent.setRemark("支出投资金额：" + Double.parseDouble(accountInvest.getInvestMoney()) / 100+"元");
		revenueSettlementMapper.addCapital(investMent);
		// 资金明细：本金+
		CapitalDetail principal = new CapitalDetail();
		principal.setAccountId(accountInvest.getAccountId());
		principal.setMoney(returnPrincipal);
		principal.setType(Constants.DEVIL_NUM_NINE);
		principal.setInExpend(Constants.DEVIL_NUM_ZERO);
		principal.setRemark("收入本金：" + Double.parseDouble(returnPrincipal) / 100+"元");
		revenueSettlementMapper.addCapital(principal);
		
		// 资金明细：收益+
		CapitalDetail income = new CapitalDetail();
		income.setAccountId(accountInvest.getAccountId());
		income.setMoney(incomeAmount);
		income.setType(Constants.DEVIL_NUM_FOUR);
		income.setInExpend(Constants.DEVIL_NUM_ZERO);
		income.setRemark("收入收益：" + Double.parseDouble(incomeAmount) / 100+"元");
		revenueSettlementMapper.addCapital(income);

		// 发送消息
		MessageBean outMessageBean = new MessageBean();
		outMessageBean.setAccountId(accountInvest.getAccountId());
		outMessageBean.setMsgTitle("投资到期");
		outMessageBean.setMsgContent("您投资的标,已产生收益" + Double.parseDouble(incomeAmount) / 100+"元！详情请在我的<a href='javascript:void(0)' onclick='goDetails(1)'>资金明细</a>中查看。");
		messageMapper.addMessageInfo(outMessageBean);

	}
	
	public static void main(String[] args)
	{
		String expenseMoney = "0.0";
		if(1>0){
			expenseMoney =  MoneyUtils.formatFloatNumber(1 * Double.parseDouble("200000") /100);
		}
		expenseMoney = expenseMoney.substring(0, expenseMoney.indexOf("."));
		
		System.out.println(expenseMoney);
	}
	
	
}
