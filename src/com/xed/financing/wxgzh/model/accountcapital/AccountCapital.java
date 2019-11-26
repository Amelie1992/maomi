/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.accountcapital.AccountCapital
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
package com.xed.financing.wxgzh.model.accountcapital;

/**
 * 用户资金表
 * 
 * @className:com.xed.financing.wxgzh.model.accountcapital.AccountCapital
 * @description:
 * @version:v1.0.0
 * @date:2017年3月20日 下午1:56:05
 * @author:ZhangJun
 */
public class AccountCapital
{
	/**
	 * 资金ID
	 */
	private String capitalId;

	/**
	 * 用户ID
	 */
	private String accountId;

	/**
	 * 投资金额
	 */
	private String investmentMoney;

	/**
	 * 冻结金额
	 */
	private String freezeMoney;

	/**
	 * 可提现金额
	 */
	private String withdrawMoney;

	/**
	 * 不可提现金额
	 */
	private String noWithdrawMoney;

	/**
	 * 提现中金额
	 */
	private String nowWithdrawMoney;

	/**
	 * 猫咪宝金额
	 */
	private String freedomMoney;

	private String txMoney;
	
	private String accountLevel;
	
	private String isChange;
	

	public String getAccountLevel()
	{
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel)
	{
		this.accountLevel = accountLevel;
	}

	public String getIsChange()
	{
		return isChange;
	}

	public void setIsChange(String isChange)
	{
		this.isChange = isChange;
	}

	public String getTxMoney()
	{
		return txMoney;
	}

	public void setTxMoney(String txMoney)
	{
		this.txMoney = txMoney;
	}

	/**
	 * 可用金额（可提现金额+不可提现金额）
	 */
	private String availableBalance;

	/**
	 * 用户真实姓名
	 */
	private String realName;

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public String getAvailableBalance()
	{
		return availableBalance;
	}

	public void setAvailableBalance(String availableBalance)
	{
		this.availableBalance = availableBalance;
	}

	public String getFreedomMoney()
	{
		return freedomMoney;
	}

	public void setFreedomMoney(String freedomMoney)
	{
		this.freedomMoney = freedomMoney;
	}

	public String getCapitalId()
	{
		return capitalId;
	}

	public void setCapitalId(String capitalId)
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

	public String getInvestmentMoney()
	{
		return investmentMoney;
	}

	public void setInvestmentMoney(String investmentMoney)
	{
		this.investmentMoney = investmentMoney;
	}

	public String getFreezeMoney()
	{
		return freezeMoney;
	}

	public void setFreezeMoney(String freezeMoney)
	{
		this.freezeMoney = freezeMoney;
	}

	public String getWithdrawMoney()
	{
		return withdrawMoney;
	}

	public void setWithdrawMoney(String withdrawMoney)
	{
		this.withdrawMoney = withdrawMoney;
	}

	public String getNoWithdrawMoney()
	{
		return noWithdrawMoney;
	}

	public void setNoWithdrawMoney(String noWithdrawMoney)
	{
		this.noWithdrawMoney = noWithdrawMoney;
	}

	public String getNowWithdrawMoney()
	{
		return nowWithdrawMoney;
	}

	public void setNowWithdrawMoney(String nowWithdrawMoney)
	{
		this.nowWithdrawMoney = nowWithdrawMoney;
	}

	/**
	 * @param capitalId
	 * @param accountId
	 * @param investmentMoney
	 * @param freezeMoney
	 * @param withdrawMoney
	 * @param noWithdrawMoney
	 * @param nowWithdrawMoney
	 * @param freedomMoney
	 */
	public AccountCapital(String capitalId, String accountId, String investmentMoney, String freezeMoney,
			String withdrawMoney, String noWithdrawMoney, String nowWithdrawMoney, String freedomMoney)
	{
		super();
		this.capitalId = capitalId;
		this.accountId = accountId;
		this.investmentMoney = investmentMoney;
		this.freezeMoney = freezeMoney;
		this.withdrawMoney = withdrawMoney;
		this.noWithdrawMoney = noWithdrawMoney;
		this.nowWithdrawMoney = nowWithdrawMoney;
		this.freedomMoney = freedomMoney;
	}

	public AccountCapital()
	{
		super();
	}

}
