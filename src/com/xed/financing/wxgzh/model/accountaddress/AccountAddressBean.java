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
package com.xed.financing.wxgzh.model.accountaddress;

/**
 * 
 * @className:com.xed.financing.wxgzh.model.accountaddress.AccountAddress
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月19日 下午2:17:37
 * @author:Elias Zheng
 */
public class AccountAddressBean
{
	/**
	 * 地址ID
	 */
	private String addrId;
	
	/**
	 * 用户ID
	 */
	private String accountId;
	
	/**
	 * 收件人姓名
	 */
	private String userName;
	
	/**
	 * 收件人电话
	 */
	private String userTelephone;
	
	/**
	 * 收件人地址
	 */
	private String userAddress;
	
	/**
	 * 是否默认收货地址
	 */
	private String isDefault;

	/**
	 * 省
	 */
	private String province;
	
	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 区
	 */
	private String classify;
	
	/**
	 * 是否发货(0否 1是)
	 */
	private String isSend;
	
	/**
	 * 快递公司
	 */
	private String expressCompany;
	
	/**
	 * 快递单号
	 */
	private String expressCode;
	
	/**
	 * 投资id
	 */
	private String investId;

	/**
	 * 商品id
	 */
	private String goodId;
	
	/**
	 * 描述
	 */
	private String remark;
	
	/**
	 * 上一级城市
	 */
	private String supCityCode;
	
	/**
	 * 颜色
	 */
	private String color;
	
	/**
	 * 套餐
	 */
	private String packages;
	
	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getClassify()
	{
		return classify;
	}

	public void setClassify(String classify)
	{
		this.classify = classify;
	}

	public String getIsSend()
	{
		return isSend;
	}

	public void setIsSend(String isSend)
	{
		this.isSend = isSend;
	}

	public String getExpressCompany()
	{
		return expressCompany;
	}

	public void setExpressCompany(String expressCompany)
	{
		this.expressCompany = expressCompany;
	}

	public String getExpressCode()
	{
		return expressCode;
	}

	public void setExpressCode(String expressCode)
	{
		this.expressCode = expressCode;
	}

	public String getInvestId()
	{
		return investId;
	}

	public void setInvestId(String investId)
	{
		this.investId = investId;
	}

	public String getGoodId()
	{
		return goodId;
	}

	public void setGoodId(String goodId)
	{
		this.goodId = goodId;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getSupCityCode()
	{
		return supCityCode;
	}

	public void setSupCityCode(String supCityCode)
	{
		this.supCityCode = supCityCode;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public String getPackages()
	{
		return packages;
	}

	public void setPackages(String packages)
	{
		this.packages = packages;
	}

	public String getAddrId()
	{
		return addrId;
	}

	public void setAddrId(String addrId)
	{
		this.addrId = addrId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserTelephone()
	{
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone)
	{
		this.userTelephone = userTelephone;
	}

	public String getUserAddress()
	{
		return userAddress;
	}

	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}

	public String getIsDefault()
	{
		return isDefault;
	}

	public void setIsDefault(String isDefault)
	{
		this.isDefault = isDefault;
	}

	@Override
	public String toString()
	{
		return "AccountAddress [addrId=" + addrId + ", accountId=" + accountId + ", userName=" + userName
				+ ", userTelephone=" + userTelephone + ", userAddress=" + userAddress + ", isDefault=" + isDefault
				+ "]";
	}

	/**
	 * @param addrId
	 * @param accountId
	 * @param userName
	 * @param userTelephone
	 * @param userAddress
	 * @param isDefault
	 */
	public AccountAddressBean(String addrId, String accountId, String userName, String userTelephone, String userAddress,
			String isDefault)
	{
		super();
		this.addrId = addrId;
		this.accountId = accountId;
		this.userName = userName;
		this.userTelephone = userTelephone;
		this.userAddress = userAddress;
		this.isDefault = isDefault;
	}

	/**
	 * 
	 */
	public AccountAddressBean()
	{
		super();
	}
	
}
