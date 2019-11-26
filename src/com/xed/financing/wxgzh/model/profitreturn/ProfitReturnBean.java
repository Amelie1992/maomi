/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.profitreturn.ProfitReturnBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年6月15日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.profitreturn;

/**
 * @className:com.xed.financing.wxgzh.model.profitreturn.ProfitReturnBean
 * @description:
 * @version:v1.0.0
 * @date:2018年6月15日 上午10:25:19
 * @author:ZhangJun
 */
public class ProfitReturnBean
{

	private String profitReturnId;
	private String accountId;
	private String investId;
	private String accountPhone;
	private String userPhone;
	private String subjectId;
	private String crowdfundingId;
	private String type;
	private String profitMoney;
	private String status;
	private String addTime;
	private String transferTime;

	public String getProfitReturnId()
	{
		return profitReturnId;
	}

	public void setProfitReturnId(String profitReturnId)
	{
		this.profitReturnId = profitReturnId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getInvestId()
	{
		return investId;
	}

	public void setInvestId(String investId)
	{
		this.investId = investId;
	}

	public String getAccountPhone()
	{
		return accountPhone;
	}

	public void setAccountPhone(String accountPhone)
	{
		this.accountPhone = accountPhone;
	}

	public String getUserPhone()
	{
		return userPhone;
	}

	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}

	public String getSubjectId()
	{
		return subjectId;
	}

	public void setSubjectId(String subjectId)
	{
		this.subjectId = subjectId;
	}

	public String getCrowdfundingId()
	{
		return crowdfundingId;
	}

	public void setCrowdfundingId(String crowdfundingId)
	{
		this.crowdfundingId = crowdfundingId;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getProfitMoney()
	{
		return profitMoney;
	}

	public void setProfitMoney(String profitMoney)
	{
		this.profitMoney = profitMoney;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}

	public String getTransferTime()
	{
		return transferTime;
	}

	public void setTransferTime(String transferTime)
	{
		this.transferTime = transferTime;
	}

}
