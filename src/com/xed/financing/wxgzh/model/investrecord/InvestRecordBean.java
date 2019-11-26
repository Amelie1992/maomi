/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.investrecord.InvestRecordBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月23日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.investrecord;

/**
 * 投资记录bean
 * @className:com.xed.financing.wxgzh.model.investrecord.InvestRecordBean
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月23日 下午3:28:46
 * @author:Qian Tao
 */
public class InvestRecordBean
{
	/**
	 * 投标id
	 */
	private String investId;
	
	/**
	 * 标ID
	 */
	private String subjectId;
	
	/**
	 * 用户id
	 */
	private String accountId;
	
	/**
	 * 投标时间
	 */
	private String investTime;
	
	/**
	 * 满标时间
	 */
	private String fullTime;
	
	/**
	 * 投资金额(本金)
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
	 * 投标利率
	 */
	private String subjectRate;
	
	/**
	 * 加息券
	 */
	private String subjectRates;
	
	/**
	 * 标利率
	 */
	private String sRate;
	/**
	 * 编号
	 */
	private String subjectCode;
	
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
	 * 转让id
	 */
	private String creditId;
	
	/**
	 * 转让人ID
	 */
	private String outAccountId;
	
	/**
	 * 接收人id
	 */
	private String inAccountId;
	
	/**
	 * 转让金额
	 */
	private String creditMoney;
	
	/**
	 * 转让方式(0:普通 1:加急 2:平台接盘)
	 */
	private String creditType;
	
	/**
	 * 转让利率
	 */
	private String creditRate;
	
	/**
	 * 实际收益金额
	 */
	private String dealMoney;
	
	/**
	 * 转让时间
	 */
	private String creditTime;
	
	/**
	 * 接受时间
	 */
	private String dealTime;
	
	/**
	 * 是否撤销(0:否 1:是)
	 */
	private String isCancel;
	
	/**
	 * 用户名
	 */
	private String accountName;
	
	/**
	 * 转让人
	 */
	private String outAccountName;

	/**
	 * 接收人
	 */
	private String inAccountName;
	
	/**
	 * 项目名称
	 */
	private String subjectName;
	
	/**
	 * 标的期数
	 */
	private String subjectPeriods;
	
	/**
	 * 期限类型(0:天 1:月 2:年)
	 */
	private String subjectTerm;
	/**
	 * 用户一个标转让的总金额
	 */
	private String totalCreditMoney;
	
	/**
	 * 服务器当前时间
	 */
	public String currentTime;
	
	/**
	 * 收益方式(0:平台支付转让人收益 1:转让人支付接收人收益)
	 */
	public String dealType;
	/**
	 * 标的类型(0:新手专享标 1:普通标 2:爆款标 3:预发布标)
	 */
	private String subjectType;
	
	/**
	 * 结束时间
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
	 * 还款方式(0:等额本息 1:先息后本 2:到期还本还息)
	 */
	private String repeatType;
	
	/**
	 * 是否按天收益(0:否 1:是)
	 */
	private String isDayProfit;
	
	/**
	 * 利率修正收益金额
	 */
	private String outMoney;
	
	/**
	 * 收益显示
	 */
	private String showProfit;
	
	/**
	 * 序号
	 */
	private String rn;
	
	/**
	 * 投资总额
	 */
	private String money;
	
	/**
	 * 电话号码
	 */
	private String telephone;
	
private String flag;
	
	/**
	 * 地址ID
	 */
	private String addrId;
	
	/**
	 * 收件人姓名
	 */
	private String userName;
	
	/**
	 * 收件人电话
	 */
	private String userTelephone;
	
	/**
	 * 收件人地址
	 */
	private String userAddress;
	
	/**
	 * 是否默认收货地址
	 */
	private String isDefault;

	/**
	 * 省
	 */
	private String province;
	
	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 区
	 */
	private String classify;
	
	/**
	 * 是否发货(0否 1是)
	 */
	private String isSend;
	
	/**
	 * 快递公司
	 */
	private String expressCompany;
	
	/**
	 * 快递单号
	 */
	private String expressCode;

	/**
	 * 商品id
	 */
	private String goodId;
	
	/**
	 * 月份差
	 */
	private String months;
	
	/**
	 * 颜色
	 */
	private String color;
	
	/**
	 * 
	 */
	private String vipRate;
	
	/**
	 * 提前还款时间
	 */
	private String earlyTime;
	
	/**
	 * 是否提前还款(1否  2是)     
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
	
	private String subjectStatus;
	
	public String getSubjectStatus()
	{
		return subjectStatus;
	}

	public void setSubjectStatus(String subjectStatus)
	{
		this.subjectStatus = subjectStatus;
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

	public String getEarlySurplusMoney()
	{
		return earlySurplusMoney;
	}

	public void setEarlySurplusMoney(String earlySurplusMoney)
	{
		this.earlySurplusMoney = earlySurplusMoney;
	}

	public String getVipRate()
	{
		return vipRate;
	}

	public void setVipRate(String vipRate)
	{
		this.vipRate = vipRate;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}

	public String getAddrId()
	{
		return addrId;
	}

	public void setAddrId(String addrId)
	{
		this.addrId = addrId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserTelephone()
	{
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone)
	{
		this.userTelephone = userTelephone;
	}

	public String getUserAddress()
	{
		return userAddress;
	}

	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}

	public String getIsDefault()
	{
		return isDefault;
	}

	public void setIsDefault(String isDefault)
	{
		this.isDefault = isDefault;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getClassify()
	{
		return classify;
	}

	public void setClassify(String classify)
	{
		this.classify = classify;
	}

	public String getIsSend()
	{
		return isSend;
	}

	public void setIsSend(String isSend)
	{
		this.isSend = isSend;
	}

	public String getExpressCompany()
	{
		return expressCompany;
	}

	public void setExpressCompany(String expressCompany)
	{
		this.expressCompany = expressCompany;
	}

	public String getExpressCode()
	{
		return expressCode;
	}

	public void setExpressCode(String expressCode)
	{
		this.expressCode = expressCode;
	}

	public String getGoodId()
	{
		return goodId;
	}

	public void setGoodId(String goodId)
	{
		this.goodId = goodId;
	}

	public String getMonths()
	{
		return months;
	}

	public void setMonths(String months)
	{
		this.months = months;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getMoney()
	{
		return money;
	}

	public void setMoney(String money)
	{
		this.money = money;
	}

	public String getRn()
	{
		return rn;
	}

	public void setRn(String rn)
	{
		this.rn = rn;
	}

	public String getShowProfit()
	{
		return showProfit;
	}

	public void setShowProfit(String showProfit)
	{
		this.showProfit = showProfit;
	}

	public String getsRate() {
		return sRate;
	}

	public void setsRate(String sRate) {
		this.sRate = sRate;
	}

	public String getSubjectCode()
	{
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode)
	{
		this.subjectCode = subjectCode;
	}

	public String getSubjectTerm()
	{
		return subjectTerm;
	}

	public void setSubjectTerm(String subjectTerm)
	{
		this.subjectTerm = subjectTerm;
	}

	public String getOutMoney()
	{
		return outMoney;
	}

	public void setOutMoney(String outMoney)
	{
		this.outMoney = outMoney;
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

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

	public String getIsCancel()
	{
		return isCancel;
	}

	public void setIsCancel(String isCancel)
	{
		this.isCancel = isCancel;
	}

	public String getDealType()
	{
		return dealType;
	}

	public void setDealType(String dealType)
	{
		this.dealType = dealType;
	}

	public String getSurplusMoney()
	{
		return surplusMoney;
	}

	public void setSurplusMoney(String surplusMoney)
	{
		this.surplusMoney = surplusMoney;
	}

	public String getSubjectType()
	{
		return subjectType;
	}

	public void setSubjectType(String subjectType)
	{
		this.subjectType = subjectType;
	}

	public String getCurrentTime()
	{
		return currentTime;
	}

	public void setCurrentTime(String currentTime)
	{
		this.currentTime = currentTime;
	}

	public String getTotalCreditMoney()
	{
		return totalCreditMoney;
	}

	public void setTotalCreditMoney(String totalCreditMoney)
	{
		this.totalCreditMoney = totalCreditMoney;
	}

	public String getSubjectPeriods()
	{
		return subjectPeriods;
	}

	public void setSubjectPeriods(String subjectPeriods)
	{
		this.subjectPeriods = subjectPeriods;
	}

	public String getOutAccountName()
	{
		return outAccountName;
	}

	public void setOutAccountName(String outAccountName)
	{
		this.outAccountName = outAccountName;
	}

	public String getInAccountName()
	{
		return inAccountName;
	}

	public void setInAccountName(String inAccountName)
	{
		this.inAccountName = inAccountName;
	}

	public String getSubjectName()
	{
		return subjectName;
	}

	public void setSubjectName(String subjectName)
	{
		this.subjectName = subjectName;
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

	public String getInvestMoney()
	{
		return investMoney;
	}

	public void setInvestMoney(String investMoney)
	{
		this.investMoney = investMoney;
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

	public String getCreditId()
	{
		return creditId;
	}

	public void setCreditId(String creditId)
	{
		this.creditId = creditId;
	}

	public String getOutAccountId()
	{
		return outAccountId;
	}

	public void setOutAccountId(String outAccountId)
	{
		this.outAccountId = outAccountId;
	}

	public String getInAccountId()
	{
		return inAccountId;
	}

	public void setInAccountId(String inAccountId)
	{
		this.inAccountId = inAccountId;
	}

	public String getCreditMoney()
	{
		return creditMoney;
	}

	public void setCreditMoney(String creditMoney)
	{
		this.creditMoney = creditMoney;
	}

	public String getCreditType()
	{
		return creditType;
	}

	public void setCreditType(String creditType)
	{
		this.creditType = creditType;
	}

	public String getCreditRate()
	{
		return creditRate;
	}

	public void setCreditRate(String creditRate)
	{
		this.creditRate = creditRate;
	}

	public String getDealMoney()
	{
		return dealMoney;
	}

	public void setDealMoney(String dealMoney)
	{
		this.dealMoney = dealMoney;
	}

	public String getCreditTime()
	{
		return creditTime;
	}

	public void setCreditTime(String creditTime)
	{
		this.creditTime = creditTime;
	}

	public String getDealTime()
	{
		return dealTime;
	}

	public void setDealTime(String dealTime)
	{
		this.dealTime = dealTime;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public String getCouponMoney()
	{
		return couponMoney;
	}

	public void setCouponMoney(String couponMoney)
	{
		this.couponMoney = couponMoney;
	}

	public String getSubjectRates()
	{
		return subjectRates;
	}

	public void setSubjectRates(String subjectRates)
	{
		this.subjectRates = subjectRates;
	} 
}
