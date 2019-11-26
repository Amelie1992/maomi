/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.accountinvest.AccountInvest
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月20日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.accountinvest;

import com.xed.financing.wxgzh.model.couponDetail.CouponDetail;
import com.xed.financing.wxgzh.model.profitreturn.ProfitReturnBean;

/**
 * 投标表
 * 
 * @className:com.xed.financing.wxgzh.model.accountinvest.AccountInvest
 * @description:
 * @version:v1.0.0
 * @date:2017年3月20日 上午11:08:04
 * @author:ZhangJun
 */
public class AccountInvest
{
	/**
	 * 投标ID
	 */
	private String investId;

	/**
	 * 标的ID
	 */
	private String subjectId;

	/**
	 * 用户ID
	 */
	private String accountId;

	/**
	 * 投标时间
	 */
	private String investTime;

	/**
	 * 满标时间(标的收益开始时间)
	 */
	private String fullTime;

	/**
	 * 投标结束时间
	 */
	private String endTime;

	/**
	 * 上次收益结算时间
	 */
	private String lastProfitTime;

	/**
	 * 下次收益日期
	 */
	private String nextProfitTime;

	/**
	 * 投标金额
	 */
	private String investMoney;

	/**
	 * 剩余本金
	 */
	private String surplusMoney;

	/**
	 * 红包(体验金)金额
	 */
	private String couponMoney;

	/**
	 * 投标的利率(可能包含加息券)
	 */
	private String subjectRate;

	/**
	 * 月化收益
	 */
	private String monthProfit;

	/**
	 * 年化收益
	 */
	private String yearProfit;

	/**
	 * 是否组团(0:否 1:是)
	 */
	private String isTeam;

	/**
	 * 是否转让债权(0:否 1:是)
	 */
	private String isCredit;

	/**
	 * 投标状态(0:正常 1:标的正常结束 2:已转让债权)
	 */
	private String investStatus;

	/**
	 * 用户投标方式(0:个人投标;1:自动投标)
	 */
	private String investType;

	/**
	 * 还款方式(0:等额本息 1:先息后本 2:到期还本还息)
	 */
	private String repeatType;

	/**
	 * 是否按天收益(0:否 1:是)
	 */
	private String isDayProfit;

	/**
	 * 收益时间 ：下次收益结算时间-上次收益结算时间
	 */
	private String revenueTime;

	/**
	 * 提前还款时间
	 */
	private String earlyTime;

	/**
	 * 是否提前还款(1否 2是)
	 */
	private String isEarly;

	/**
	 * 补偿金额
	 */
	private String equalizeMoney;

	/**
	 * 提前还款金额
	 */
	private String earlyRepaymentMoney;

	/**
	 * 提前还款剩余本金
	 */
	private String earlySurplusMoney;

	/*
	 * --------------------字段外--------------------
	 */

	/**
	 * 相隔月份
	 */
	private Integer apartMonth;

	/**
	 * 标的期限(月:30天 天:1天)
	 */
	private String subjectPeriods;

	/**
	 * 期限类型(0:天 1:月 2:年)
	 */
	private String subjectTerm;

	/**
	 * 当前时间
	 */
	private String currentTime;

	/**
	 * 使用的优惠券
	 */
	private CouponDetail couponDetail;

	private ProfitReturnBean profitReturnBean;

	private String subjectRates;

	private String subjectName;

	private String subjectType;

	/**
	 * 用户等级
	 */
	private String accountLevel;

	/**
	 * 等级加息
	 */
	private String vipRate;

	/**
	 * 管理费利率
	 */
	private String expenseRate;

	/**
	 * 是否金账户投资(0:否 1:是)
	 */
	private String isGold;

	/**
	 * 借款用户ID
	 */
	private String userId;
	
	/**
	 * 标的状态(-1:暂未发标 0:筹标中 1:已满标 2:满标复审 3:还款中 4:流标 5:正常结束 6:提前还款) 
	 */
	private String subjectStatus;
	
	public String getSubjectStatus()
	{
		return subjectStatus;
	}

	public void setSubjectStatus(String subjectStatus)
	{
		this.subjectStatus = subjectStatus;
	}

	public ProfitReturnBean getProfitReturnBean()
	{
		return profitReturnBean;
	}

	public void setProfitReturnBean(ProfitReturnBean profitReturnBean)
	{
		this.profitReturnBean = profitReturnBean;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getIsGold()
	{
		return isGold;
	}

	public void setIsGold(String isGold)
	{
		this.isGold = isGold;
	}

	public String getEarlySurplusMoney()
	{
		return earlySurplusMoney;
	}

	public void setEarlySurplusMoney(String earlySurplusMoney)
	{
		this.earlySurplusMoney = earlySurplusMoney;
	}

	public String getEarlyTime()
	{
		return earlyTime;
	}

	public void setEarlyTime(String earlyTime)
	{
		this.earlyTime = earlyTime;
	}

	public String getIsEarly()
	{
		return isEarly;
	}

	public void setIsEarly(String isEarly)
	{
		this.isEarly = isEarly;
	}

	public String getEqualizeMoney()
	{
		return equalizeMoney;
	}

	public void setEqualizeMoney(String equalizeMoney)
	{
		this.equalizeMoney = equalizeMoney;
	}

	public String getEarlyRepaymentMoney()
	{
		return earlyRepaymentMoney;
	}

	public void setEarlyRepaymentMoney(String earlyRepaymentMoney)
	{
		this.earlyRepaymentMoney = earlyRepaymentMoney;
	}

	public String getExpenseRate()
	{
		return expenseRate;
	}

	public void setExpenseRate(String expenseRate)
	{
		this.expenseRate = expenseRate;
	}

	public String getVipRate()
	{
		return vipRate;
	}

	public void setVipRate(String vipRate)
	{
		this.vipRate = vipRate;
	}

	public String getAccountLevel()
	{
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel)
	{
		this.accountLevel = accountLevel;
	}

	public String getSubjectType()
	{
		return subjectType;
	}

	public void setSubjectType(String subjectType)
	{
		this.subjectType = subjectType;
	}

	public String getSubjectName()
	{
		return subjectName;
	}

	public void setSubjectName(String subjectName)
	{
		this.subjectName = subjectName;
	}

	public String getSubjectRates()
	{
		return subjectRates;
	}

	public void setSubjectRates(String subjectRates)
	{
		this.subjectRates = subjectRates;
	}

	public String getCurrentTime()
	{
		return currentTime;
	}

	public void setCurrentTime(String currentTime)
	{
		this.currentTime = currentTime;
	}

	public String getSubjectPeriods()
	{
		return subjectPeriods;
	}

	public void setSubjectPeriods(String subjectPeriods)
	{
		this.subjectPeriods = subjectPeriods;
	}

	public String getSubjectTerm()
	{
		return subjectTerm;
	}

	public void setSubjectTerm(String subjectTerm)
	{
		this.subjectTerm = subjectTerm;
	}

	public CouponDetail getCouponDetail()
	{
		return couponDetail;
	}

	public void setCouponDetail(CouponDetail couponDetail)
	{
		this.couponDetail = couponDetail;
	}

	public Integer getApartMonth()
	{
		return apartMonth;
	}

	public void setApartMonth(Integer apartMonth)
	{
		this.apartMonth = apartMonth;
	}

	public String getRevenueTime()
	{
		return revenueTime;
	}

	public void setRevenueTime(String revenueTime)
	{
		this.revenueTime = revenueTime;
	}

	public String getInvestId()
	{
		return investId;
	}

	public void setInvestId(String investId)
	{
		this.investId = investId;
	}

	public String getSubjectId()
	{
		return subjectId;
	}

	public void setSubjectId(String subjectId)
	{
		this.subjectId = subjectId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getInvestTime()
	{
		return investTime;
	}

	public void setInvestTime(String investTime)
	{
		this.investTime = investTime;
	}

	public String getFullTime()
	{
		return fullTime;
	}

	public void setFullTime(String fullTime)
	{
		this.fullTime = fullTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

	public String getLastProfitTime()
	{
		return lastProfitTime;
	}

	public void setLastProfitTime(String lastProfitTime)
	{
		this.lastProfitTime = lastProfitTime;
	}

	public String getNextProfitTime()
	{
		return nextProfitTime;
	}

	public void setNextProfitTime(String nextProfitTime)
	{
		this.nextProfitTime = nextProfitTime;
	}

	public String getInvestMoney()
	{
		return investMoney;
	}

	public void setInvestMoney(String investMoney)
	{
		this.investMoney = investMoney;
	}

	public String getSurplusMoney()
	{
		return surplusMoney;
	}

	public void setSurplusMoney(String surplusMoney)
	{
		this.surplusMoney = surplusMoney;
	}

	public String getCouponMoney()
	{
		return couponMoney;
	}

	public void setCouponMoney(String couponMoney)
	{
		this.couponMoney = couponMoney;
	}

	public String getSubjectRate()
	{
		return subjectRate;
	}

	public void setSubjectRate(String subjectRate)
	{
		this.subjectRate = subjectRate;
	}

	public String getMonthProfit()
	{
		return monthProfit;
	}

	public void setMonthProfit(String monthProfit)
	{
		this.monthProfit = monthProfit;
	}

	public String getYearProfit()
	{
		return yearProfit;
	}

	public void setYearProfit(String yearProfit)
	{
		this.yearProfit = yearProfit;
	}

	public String getIsTeam()
	{
		return isTeam;
	}

	public void setIsTeam(String isTeam)
	{
		this.isTeam = isTeam;
	}

	public String getIsCredit()
	{
		return isCredit;
	}

	public void setIsCredit(String isCredit)
	{
		this.isCredit = isCredit;
	}

	public String getInvestStatus()
	{
		return investStatus;
	}

	public void setInvestStatus(String investStatus)
	{
		this.investStatus = investStatus;
	}

	public String getInvestType()
	{
		return investType;
	}

	public void setInvestType(String investType)
	{
		this.investType = investType;
	}

	public String getRepeatType()
	{
		return repeatType;
	}

	public void setRepeatType(String repeatType)
	{
		this.repeatType = repeatType;
	}

	public String getIsDayProfit()
	{
		return isDayProfit;
	}

	public void setIsDayProfit(String isDayProfit)
	{
		this.isDayProfit = isDayProfit;
	}

	public AccountInvest()
	{
		super();

	}

	public AccountInvest(String investId, String subjectId, String accountId, String investTime, String fullTime,
			String endTime, String lastProfitTime, String nextProfitTime, String investMoney, String surplusMoney,
			String couponMoney, String subjectRate, String monthProfit, String yearProfit, String isTeam,
			String isCredit, String investStatus, String investType, String repeatType, String isDayProfit)
	{
		super();
		this.investId = investId;
		this.subjectId = subjectId;
		this.accountId = accountId;
		this.investTime = investTime;
		this.fullTime = fullTime;
		this.endTime = endTime;
		this.lastProfitTime = lastProfitTime;
		this.nextProfitTime = nextProfitTime;
		this.investMoney = investMoney;
		this.surplusMoney = surplusMoney;
		this.couponMoney = couponMoney;
		this.subjectRate = subjectRate;
		this.monthProfit = monthProfit;
		this.yearProfit = yearProfit;
		this.isTeam = isTeam;
		this.isCredit = isCredit;
		this.investStatus = investStatus;
		this.investType = investType;
		this.repeatType = repeatType;
		this.isDayProfit = isDayProfit;
	}

}
