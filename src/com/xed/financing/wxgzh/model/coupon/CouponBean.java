/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.coupon.CouponBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月22日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.coupon;

/**
 * @className:com.xed.financing.wxgzh.model.coupon.CouponBean
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月22日 下午4:10:11
 * @author:Qian Tao
 */
public class CouponBean
{
	/**
	 * 主键
	 */
	private String additionalId;
	
	/**
	 * 用户ID
	 */
	private String accountId;
	
	/**
	 * 标id
	 */
	private String subjectId;
	
	/**
	 * 投资表Id
	 */
	private String investId;
	
	/**
	 * 红包id
	 */
	private String couponId;
	
	/**
	 * 是否使用(0:否 1:是)
	 */
	private String isUsed;
	
	/**
	 * 领取时间
	 */
	private String receiveTime;
	
	/**
	 * 使用时间
	 */
	private String usedTime;
	
	/**
	 * 过期时间
	 */
	private String outTime;
	
	/**
	 * 券名称
	 */
	private String couponName;
	
	/**
	 * 券金额
	 */
	private String couponMoney;
	
	/**
	 * 券类型(0:增值券 1:加息券 2:体验金 3:现金券)
	 */
	private String couponType;
	
	/**
	 * 是否被领取(0:否 1:是)
	 */
	private String isReceive;
	
	/**
	 * 优惠券id
	 */
	private String couDetailId;
	
	/**
	 * 0未失效   1已失效
	 */
	private String isBad;
	private String couponCode;
	
	private String isShow;
	
	private String addTime;
	
	/**
	 * 判断标识
	 */
	private String flag;
	
	/**
	 * 计息期限（-1无限制）
	 */
	private String interestDays;
	
	/**
	 * 计息期限(0:天 1:月 2:年)
	 */
	private String interestType;
	
	/**
	 * 起投金额
	 */
	private String startMoney;
	
	/**
	 * 适用标类型
	 */
	private String subjectType;
	
	
	public String getStartMoney()
	{
		return startMoney;
	}

	public void setStartMoney(String startMoney)
	{
		this.startMoney = startMoney;
	}

	public String getSubjectType()
	{
		return subjectType;
	}

	public void setSubjectType(String subjectType)
	{
		this.subjectType = subjectType;
	}

	public String getInterestDays()
	{
		return interestDays;
	}

	public void setInterestDays(String interestDays)
	{
		this.interestDays = interestDays;
	}

	public String getInterestType()
	{
		return interestType;
	}

	public void setInterestType(String interestType)
	{
		this.interestType = interestType;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}

	public String getInvestId()
	{
		return investId;
	}

	public void setInvestId(String investId)
	{
		this.investId = investId;
	}

	public String getIsBad()
	{
		return isBad;
	}

	public void setIsBad(String isBad)
	{
		this.isBad = isBad;
	}

	public String getCouponCode()
	{
		return couponCode;
	}

	public void setCouponCode(String couponCode)
	{
		this.couponCode = couponCode;
	}

	public String getIsShow()
	{
		return isShow;
	}

	public void setIsShow(String isShow)
	{
		this.isShow = isShow;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}

	public String getCouDetailId()
	{
		return couDetailId;
	}

	public void setCouDetailId(String couDetailId)
	{
		this.couDetailId = couDetailId;
	}

	/**
	 * 有效期(天)(-1表示该红包没有时效性)
	 */
	private String validityDays;

	public String getAdditionalId()
	{
		return additionalId;
	}

	public void setAdditionalId(String additionalId)
	{
		this.additionalId = additionalId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getSubjectId()
	{
		return subjectId;
	}

	public void setSubjectId(String subjectId)
	{
		this.subjectId = subjectId;
	}

	public String getCouponId()
	{
		return couponId;
	}

	public void setCouponId(String couponId)
	{
		this.couponId = couponId;
	}

	public String getIsUsed()
	{
		return isUsed;
	}

	public void setIsUsed(String isUsed)
	{
		this.isUsed = isUsed;
	}

	public String getReceiveTime()
	{
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime)
	{
		this.receiveTime = receiveTime;
	}

	public String getUsedTime()
	{
		return usedTime;
	}

	public void setUsedTime(String usedTime)
	{
		this.usedTime = usedTime;
	}

	public String getOutTime()
	{
		return outTime;
	}

	public void setOutTime(String outTime)
	{
		this.outTime = outTime;
	}

	public String getCouponName()
	{
		return couponName;
	}

	public void setCouponName(String couponName)
	{
		this.couponName = couponName;
	}

	public String getCouponMoney()
	{
		return couponMoney;
	}

	public void setCouponMoney(String couponMoney)
	{
		this.couponMoney = couponMoney;
	}

	public String getCouponType()
	{
		return couponType;
	}

	public void setCouponType(String couponType)
	{
		this.couponType = couponType;
	}

	public String getIsReceive()
	{
		return isReceive;
	}

	public void setIsReceive(String isReceive)
	{
		this.isReceive = isReceive;
	}

	public String getValidityDays()
	{
		return validityDays;
	}

	public void setValidityDays(String validityDays)
	{
		this.validityDays = validityDays;
	}
}
