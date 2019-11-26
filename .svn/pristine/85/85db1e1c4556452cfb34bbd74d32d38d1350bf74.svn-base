/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.accountscore.AccountScoreBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月7日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.autobid;

import java.io.Serializable;

/**
 * 
 * @className:com.xed.financing.wxgzh.model.autobid.AutoBidBean
 * @description:
 * @version:v1.0.0
 * @date:2017年4月27日 下午2:46:32
 * @author:WangJun
 */
public class AutobidInfo implements Serializable
{
	/**
	 * 自动投标ID
	 */
	private String autoId;

	/**
	 * 用户ID
	 */
	private String accountId;

	/**
	 * 预约时间
	 */
	private String addTime;

	/**
	 * 修改时间
	 */
	private String updateTime;

	/**
	 * 预约金额
	 */
	private String money;

	/**
	 * 区间上限(99为无限制)
	 */
	private String upperLimit;

	/**
	 * 区间下限(-1为无限制)
	 */
	private String lowerLimit;

	/**
	 * 状态(1.预约中2.取消3.投标完成)
	 */
	private String status;

	/**
	 * 自动投标金账户预约投资金额
	 */
	private String autobidGoldMoney;

	public String getAutobidGoldMoney()
	{
		return autobidGoldMoney;
	}

	public void setAutobidGoldMoney(String autobidGoldMoney)
	{
		this.autobidGoldMoney = autobidGoldMoney;
	}

	public String getAutoId()
	{
		return autoId;
	}

	public void setAutoId(String autoId)
	{
		this.autoId = autoId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}

	public String getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(String updateTime)
	{
		this.updateTime = updateTime;
	}

	public String getMoney()
	{
		return money;
	}

	public void setMoney(String money)
	{
		this.money = money;
	}

	public String getUpperLimit()
	{
		return upperLimit;
	}

	public void setUpperLimit(String upperLimit)
	{
		this.upperLimit = upperLimit;
	}

	public String getLowerLimit()
	{
		return lowerLimit;
	}

	public void setLowerLimit(String lowerLimit)
	{
		this.lowerLimit = lowerLimit;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public AutobidInfo(String autoId, String accountId, String addTime, String updateTime, String money,
			String upperLimit, String lowerLimit, String status)
	{
		super();
		this.autoId = autoId;
		this.accountId = accountId;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.money = money;
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
		this.status = status;
	}

	public AutobidInfo()
	{
		super();
	}

}
