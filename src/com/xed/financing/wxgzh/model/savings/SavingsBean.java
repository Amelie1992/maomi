package com.xed.financing.wxgzh.model.savings;

/**
 * 猫咪储蓄罐
 * @className:com.xed.financing.wxgzh.model.savings.SavingsBean
 * @description:
 * @version:v1.0.0 
 * @date:2018年1月8日 上午10:44:28
 * @author:Peng Gang
 */
public class SavingsBean
{
	/**
	 * 喵咪储蓄ID
	 */
	private String savingsId;
	
	/**
	 * 用户ID
	 */
	private String accountId;
	
	/**
	 * 金额
	 */
	private String savingsMoney;
	
	/**
	 * 类型（0待领取 1已使用 2已赠送 3已提现）
	 */
	private String savingsType;
	
	/**
	 * 赠送人ID
	 */
	private String giveAccountId;
	
	/**
	 * 来源（0投资）
	 */
	private String savingsFrom;
	
	/**
	 * 添加时间
	 */
	private String addTime;
	
	/**
	 * 有效期：存入数据库时 是天数，从数据库读出来是 时间
	 */
	private String savingsValidity;
	/**
	 * 说明
	 */
	private String remark;
	
	public String getSavingsValidity()
	{
		return savingsValidity;
	}

	public void setSavingsValidity(String savingsValidity)
	{
		this.savingsValidity = savingsValidity;
	}

	public String getSavingsId()
	{
		return savingsId;
	}

	public void setSavingsId(String savingsId)
	{
		this.savingsId = savingsId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getSavingsMoney()
	{
		return savingsMoney;
	}

	public void setSavingsMoney(String savingsMoney)
	{
		this.savingsMoney = savingsMoney;
	}

	public String getSavingsType()
	{
		return savingsType;
	}

	public void setSavingsType(String savingsType)
	{
		this.savingsType = savingsType;
	}

	public String getGiveAccountId()
	{
		return giveAccountId;
	}

	public void setGiveAccountId(String giveAccountId)
	{
		this.giveAccountId = giveAccountId;
	}

	public String getSavingsFrom()
	{
		return savingsFrom;
	}

	public void setSavingsFrom(String savingsFrom)
	{
		this.savingsFrom = savingsFrom;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	
	
}
