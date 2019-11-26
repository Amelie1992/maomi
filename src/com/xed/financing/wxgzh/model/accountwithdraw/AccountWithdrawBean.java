/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.accountwithdraw.AccountWithdrawBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年6月19日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.accountwithdraw;

/**
 * @className:com.xed.financing.wxgzh.model.accountwithdraw.AccountWithdrawBean
 * @description:
 * @version:v1.0.0
 * @date:2018年6月19日 上午9:51:18
 * @author:ZhangJun
 */
public class AccountWithdrawBean
{
	
	/**
	 * 主键ID
	 */
	private String ID;
	
	/**
	 * 用户ID
	 */
	private String accountId;
	
	/**
	 * 提现金额
	 */
	private String money;
	
	/**
	 * 类型(1:可用余额提现 2:金账户提现 )
	 */
	private String type;
	
	/**
	 * 提现时间
	 */
	private String addTime;
	
	private String capitalDetailId;
	
	public String getCapitalDetailId() {
		return capitalDetailId;
	}

	public void setCapitalDetailId(String capitalDetailId) {
		this.capitalDetailId = capitalDetailId;
	}

	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getMoney()
	{
		return money;
	}

	public void setMoney(String money)
	{
		this.money = money;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}

	public AccountWithdrawBean(String iD, String accountId, String money, String type, String addTime)
	{
		super();
		ID = iD;
		this.accountId = accountId;
		this.money = money;
		this.type = type;
		this.addTime = addTime;
	}

	public AccountWithdrawBean()
	{
		super();
	}

}
