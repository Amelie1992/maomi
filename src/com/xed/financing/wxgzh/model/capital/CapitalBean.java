/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.capital.CapitalBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月20日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.capital;


/**
 * 用户总金额bean
 * 
 * @className:com.xed.financing.wxgzh.model.capital.CapitalBean
 * @description:
 * @version:v1.0.0
 * @date:2017年3月20日 下午8:59:03
 * @author:Qian Tao
 */
public class CapitalBean
{
	/**
	 * 资金id
	 */
	private int capitalId;

	/**
	 * 用户id
	 */
	private String accountId;

	/**
	 * 投资金额
	 */
	private Double investmentMoney;

	/**
	 * 冻结金额
	 */
	private Double freezeMoney;

	/**
	 * 可提现金额
	 */
	private Double withdrawMoney;

	/**
	 * 不可提现金额
	 */
	private Double noWithdrawMoney;
	
	/**
	 * 可用金额（可提现金额+不可提现金额）
	 */
	private Double availableBalance;
	
	/**
	 * 正在提现金额
	 */
	private Double nowWithdrawMoney;
	
	/**
	 * 随存随取金额
	 */
	private Double freedomMoney;

	/**
	 * 用户名
	 */
	private String accountName;

	/**
	 * 手机号
	 */
	private String telePhone;

	/**
	 * 用户积分
	 */
	private String accountScore;

	/**
	 * 用户经验值
	 */
	private String accountExp;

	/**
	 * 用户等级
	 */
	private String accountLevel;
	
	public Double getFreedomMoney()
	{
		return freedomMoney;
	}

	public void setFreedomMoney(Double freedomMoney)
	{
		this.freedomMoney = freedomMoney;
	}

	public Double getAvailableBalance()
	{
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance)
	{
		this.availableBalance = availableBalance;
	}

	public int getCapitalId()
	{
		return capitalId;
	}

	public void setCapitalId(int capitalId)
	{
		this.capitalId = capitalId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public Double getInvestmentMoney()
	{		
		return investmentMoney;
	}

	public void setInvestmentMoney(Double investmentMoney)
	{
		this.investmentMoney = investmentMoney;
	}

	public Double getFreezeMoney()
	{
		return freezeMoney;
	}

	public void setFreezeMoney(Double freezeMoney)
	{
		this.freezeMoney = freezeMoney;
	}

	public Double getWithdrawMoney()
	{
		return withdrawMoney;
	}

	public void setWithdrawMoney(Double withdrawMoney)
	{
		this.withdrawMoney = withdrawMoney;
	}

	public Double getNoWithdrawMoney()
	{
		return noWithdrawMoney;
	}

	public void setNoWithdrawMoney(Double noWithdrawMoney)
	{
		this.noWithdrawMoney = noWithdrawMoney;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public String getTelePhone()
	{
		return telePhone;
	}

	public void setTelePhone(String telePhone)
	{
		this.telePhone = telePhone;
	}

	public String getAccountScore()
	{
		return accountScore;
	}

	public void setAccountScore(String accountScore)
	{
		this.accountScore = accountScore;
	}

	public String getAccountLevel()
	{
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel)
	{
		this.accountLevel = accountLevel;
	}

	public String getAccountExp()
	{
		return accountExp;
	}

	public void setAccountExp(String accountExp)
	{
		this.accountExp = accountExp;
	}

	public Double getNowWithdrawMoney()
	{
		return nowWithdrawMoney;
	}

	public void setNowWithdrawMoney(Double nowWithdrawMoney)
	{
		this.nowWithdrawMoney = nowWithdrawMoney;
	}
	
	
}
