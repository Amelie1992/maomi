/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.reggold.RegGoldBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年5月3日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.reggold;

/**
 * 富有金账户开户记录
 * 
 * @className:com.xed.financing.wxgzh.model.reggold.RegGoldBean
 * @description:
 * @version:v1.0.0
 * @date:2018年5月3日 下午3:34:13
 * @author:ZhangJun
 */
public class RegGoldBean
{
	/**
	 * 主键ID
	 */
	private String bmuId;

	/**
	 * 投资人ID
	 */
	private String accountId;

	/**
	 * 借款人ID
	 */
	private String userId;

	/**
	 * 真实姓名
	 */
	private String accountName;

	/**
	 * 0身份证，7其他证件
	 */
	private String certifTp;

	/**
	 * 证件号码
	 */
	private String certifId;

	/**
	 * 手机号
	 */
	private String mobileNo;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 开户行地区代码
	 */
	private String cityId;

	/**
	 * 开户行行称
	 */
	private String parentBankId;

	/**
	 * 开户行支行名称
	 */
	private String bankNm;

	/**
	 * 银行卡号
	 */
	private String capAcntNo;

	/**
	 * 提现密码，默认手机号码后6位
	 */
	private String password;

	/**
	 * 登录密码，（不告知用户）默认手机号码后6位
	 */
	private String lpassword;

	/**
	 * 备注
	 */
	private String rem;

	/**
	 * 注册时间
	 */
	private String regTime;

	/**
	 * 请求流水号
	 */
	private String mchntTxnSsn;

	/**
	 * 响应码
	 */
	private String respCode;

	/**
	 * 响应消息
	 */
	private String respDesc;

	public String getRespCode()
	{
		return respCode;
	}

	public void setRespCode(String respCode)
	{
		this.respCode = respCode;
	}

	public String getRespDesc()
	{
		return respDesc;
	}

	public void setRespDesc(String respDesc)
	{
		this.respDesc = respDesc;
	}

	public String getMchntTxnSsn()
	{
		return mchntTxnSsn;
	}

	public void setMchntTxnSsn(String mchntTxnSsn)
	{
		this.mchntTxnSsn = mchntTxnSsn;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getBmuId()
	{
		return bmuId;
	}

	public void setBmuId(String bmuId)
	{
		this.bmuId = bmuId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public String getCertifTp()
	{
		return certifTp;
	}

	public void setCertifTp(String certifTp)
	{
		this.certifTp = certifTp;
	}

	public String getCertifId()
	{
		return certifId;
	}

	public void setCertifId(String certifId)
	{
		this.certifId = certifId;
	}

	public String getMobileNo()
	{
		return mobileNo;
	}

	public void setMobileNo(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getCityId()
	{
		return cityId;
	}

	public void setCityId(String cityId)
	{
		this.cityId = cityId;
	}

	public String getParentBankId()
	{
		return parentBankId;
	}

	public void setParentBankId(String parentBankId)
	{
		this.parentBankId = parentBankId;
	}

	public String getBankNm()
	{
		return bankNm;
	}

	public void setBankNm(String bankNm)
	{
		this.bankNm = bankNm;
	}

	public String getCapAcntNo()
	{
		return capAcntNo;
	}

	public void setCapAcntNo(String capAcntNo)
	{
		this.capAcntNo = capAcntNo;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getLpassword()
	{
		return lpassword;
	}

	public void setLpassword(String lpassword)
	{
		this.lpassword = lpassword;
	}

	public String getRem()
	{
		return rem;
	}

	public void setRem(String rem)
	{
		this.rem = rem;
	}

	public String getRegTime()
	{
		return regTime;
	}

	public void setRegTime(String regTime)
	{
		this.regTime = regTime;
	}

	public RegGoldBean(String bmuId, String accountId, String accountName, String certifTp, String certifId,
			String mobileNo, String email, String cityId, String parentBankId, String bankNm, String capAcntNo,
			String password, String lpassword, String rem, String regTime)
	{
		super();
		this.bmuId = bmuId;
		this.accountId = accountId;
		this.accountName = accountName;
		this.certifTp = certifTp;
		this.certifId = certifId;
		this.mobileNo = mobileNo;
		this.email = email;
		this.cityId = cityId;
		this.parentBankId = parentBankId;
		this.bankNm = bankNm;
		this.capAcntNo = capAcntNo;
		this.password = password;
		this.lpassword = lpassword;
		this.rem = rem;
		this.regTime = regTime;
	}

	public RegGoldBean()
	{
		super();
	}

}
