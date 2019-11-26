/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.creditrecord.CreditRecord
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月17日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.creditrecord;

import java.util.ArrayList;
import java.util.List;

import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;

/**
 * 债权转让表
 * 
 * @className:com.xed.financing.wxgzh.model.creditrecord.CreditRecord
 * @description: 债权转让表
 * @version:v1.0.0
 * @date:2017年3月17日 下午1:49:12
 * @author:ZhangJun
 */
public class CreditRecord
{
	/**
	 * 转让ID
	 */
	private String creditId;

	/**
	 * 投标ID
	 */
	private String investId;

	/**
	 * 标的ID
	 */
	private String subjectId;

	/**
	 * 项目名
	 */
	private String subjectName;

	/**
	 * 债权详情期限
	 */
	private String subjectDate;

	/**
	 * 转让人ID
	 */
	private String outAccountId;

	/**
	 * 接收人ID
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
	 * 利率修正收益金额
	 */
	private String outMoney;

	/**
	 * 收益方式(0:平台支付转让人收益 1:转让人支付接收人收益)
	 */
	private String dealType;

	/**
	 * 转让时间
	 */
	private String creditTime;
	/**
	 * 接收时间
	 */
	private String dealTime;

	/**
	 * 是否撤销(0:否 1:是)
	 */
	private String isCancel;

	/**
	 * 债权转让集合
	 */
	private List<CreditRecord> creditRecords = new ArrayList<CreditRecord>();

	/**
	 * 总数量
	 */
	private String count;

	/**
	 * 金额总计
	 */
	private String sum;

	/**
	 * 投标记录
	 */
	private AccountInvest accountInvest;

	public String getSubjectDate()
	{
		return subjectDate;
	}

	public void setSubjectDate(String subjectDate)
	{
		this.subjectDate = subjectDate;
	}

	public String getSubjectName()
	{
		return subjectName;
	}

	public void setSubjectName(String subjectName)
	{
		this.subjectName = subjectName;
	}

	public AccountInvest getAccountInvest()
	{
		return accountInvest;
	}

	public void setAccountInvest(AccountInvest accountInvest)
	{
		this.accountInvest = accountInvest;
	}

	public String getDealType()
	{
		return dealType;
	}

	public void setDealType(String dealType)
	{
		this.dealType = dealType;
	}

	public String getCount()
	{
		return count;
	}

	public void setCount(String count)
	{
		this.count = count;
	}

	public String getSum()
	{
		return sum;
	}

	public void setSum(String sum)
	{
		this.sum = sum;
	}

	public List<CreditRecord> getCreditRecords()
	{
		return creditRecords;
	}

	public void setCreditRecords(List<CreditRecord> creditRecords)
	{
		this.creditRecords = creditRecords;
	}

	public String getCreditId()
	{
		return creditId;
	}

	public void setCreditId(String creditId)
	{
		this.creditId = creditId;
	}

	public String getSubjectId()
	{
		return subjectId;
	}

	public void setSubjectId(String subjectId)
	{
		this.subjectId = subjectId;
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

	public CreditRecord()
	{
		super();
	}

	public String getInvestId()
	{
		return investId;
	}

	public void setInvestId(String investId)
	{
		this.investId = investId;
	}

	public String getOutMoney()
	{
		return outMoney;
	}

	public void setOutMoney(String outMoney)
	{
		this.outMoney = outMoney;
	}

	public String getIsCancel()
	{
		return isCancel;
	}

	public void setIsCancel(String isCancel)
	{
		this.isCancel = isCancel;
	}

	public CreditRecord(String creditId, String investId, String subjectId, String outAccountId, String inAccountId,
			String creditMoney, String creditType, String creditRate, String dealMoney, String creditTime,
			String dealTime, List<CreditRecord> creditRecords, String count, String sum)
	{
		super();
		this.creditId = creditId;
		this.investId = investId;
		this.subjectId = subjectId;
		this.outAccountId = outAccountId;
		this.inAccountId = inAccountId;
		this.creditMoney = creditMoney;
		this.creditType = creditType;
		this.creditRate = creditRate;
		this.dealMoney = dealMoney;
		this.creditTime = creditTime;
		this.dealTime = dealTime;
		this.creditRecords = creditRecords;
		this.count = count;
		this.sum = sum;
	}

	public CreditRecord(String creditId)
	{
		super();
		this.creditId = creditId;
	}

	
	
}
