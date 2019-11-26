/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.couponInfo.CouponInfoBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年5月2日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.couponInfo;

/**
 * 优惠券概述
 * @className:com.xed.financing.wxgzh.model.couponInfo.CouponInfoBean
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月2日 下午3:45:24
 * @author:ZhangJun
 */
public class CouponInfoBean
{
	/**
	 * 券ID
	 */
	private String couponId;
	
	/**
	 * 券名称
	 */
	private String couponName;
	
	/**
	 * 券金额
	 */
	private String couponMoney;
	
	/**
	 * 券类型(0:红包 1:加息券 2:体验金)
	 */
	private String couponType;
	
	/**
	 * 券数量
	 */
	private String couponQuantity;
	
	/**
	 * 添加时间
	 */
	private String addTime;
	
	/**
	 * 有效期(天)(-1表示该红包没有时效性)
	 */
	private String validityDays;

	public String getCouponId()
	{
		return couponId;
	}

	public void setCouponId(String couponId)
	{
		this.couponId = couponId;
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

	public String getCouponQuantity()
	{
		return couponQuantity;
	}

	public void setCouponQuantity(String couponQuantity)
	{
		this.couponQuantity = couponQuantity;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
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
