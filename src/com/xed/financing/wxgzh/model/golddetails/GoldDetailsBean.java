/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.golddetails.GoldDetailsBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年5月4日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.golddetails;

/**
 * @className:com.xed.financing.wxgzh.model.golddetails.GoldDetailsBean
 * @description:
 * @version:v1.0.0 
 * @date:2018年5月4日 上午11:58:51
 * @author:ZhangJun
 */
public class GoldDetailsBean
{

	/**
	 * 主键ID
	 */
	private String ID;

	/**
	 * 入账号码
	 */
	private String inCustNo;

	/**
	 * 出账号码
	 */
	private String outCustNo;

	/**
	 * 金额
	 */
	private String money;

	/**
	 * 转账类型(0:公司-投资人 1:投资人-公司 2:公司-借款人 3:借款人-公司 4:借款人-投资人 5:投资人-借款人 )
	 */
	private String transferType;

	/**
	 * 用途(1:投资 2:还款 3:购买鱼干 4:垫资  )
	 */
	private String purpose;

	/**
	 * 操作时间
	 */
	private String dealTime;

	/**
	 * 描述
	 */
	private String remark;

	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	public String getInCustNo()
	{
		return inCustNo;
	}

	public void setInCustNo(String inCustNo)
	{
		this.inCustNo = inCustNo;
	}

	public String getOutCustNo()
	{
		return outCustNo;
	}

	public void setOutCustNo(String outCustNo)
	{
		this.outCustNo = outCustNo;
	}

	public String getMoney()
	{
		return money;
	}

	public void setMoney(String money)
	{
		this.money = money;
	}

	public String getTransferType()
	{
		return transferType;
	}

	public void setTransferType(String transferType)
	{
		this.transferType = transferType;
	}

	public String getPurpose()
	{
		return purpose;
	}

	public void setPurpose(String purpose)
	{
		this.purpose = purpose;
	}

	public String getDealTime()
	{
		return dealTime;
	}

	public void setDealTime(String dealTime)
	{
		this.dealTime = dealTime;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public GoldDetailsBean(String iD, String inCustNo, String outCustNo, String money, String transferType,
			String purpose, String dealTime, String remark)
	{
		super();
		ID = iD;
		this.inCustNo = inCustNo;
		this.outCustNo = outCustNo;
		this.money = money;
		this.transferType = transferType;
		this.purpose = purpose;
		this.dealTime = dealTime;
		this.remark = remark;
	}

	public GoldDetailsBean()
	{
		super();
	}

	
}
