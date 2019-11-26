/**
 * Copyright (C) 2017 FZJT Co.Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.emailcheck.EmailCheck
 * @description:邮箱认证bean
 * 
 * @version:v1.0.0 
 * @author:WangLin
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月18日    WangLin  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.emailcheck;

/**
 * @className:com.xed.financing.wxgzh.model.emailcheck.EmailCheck
 * @description:邮箱认证bean
 * @version:v1.0.0
 * @date:2017年3月18日 下午3:25:07
 * @author:WangLin
 */
public class EmailCheck
{
	/**
	 * 验证码id
	 */
	private String codeId;

	/**
	 * 用户id
	 */
	private String accountId;

	/**
	 * 验证码类型(预留字段,0:邮箱验证)
	 */
	private String codeType;

	/**
	 * 验证码内容
	 */
	private String codeContent;

	/**
	 * 验证码
	 */
	private String codeMsg;

	/**
	 * 验证码发送时间
	 */
	private String sendTime;

	/**
	 * 验证结束时间
	 */
	private String overTime;

	/**
	 * 用户邮箱是否验证(0:未验证,1:已验证)
	 */
	private Integer isEmailValidate;

	/**
	 * 用户邮箱
	 */
	private String accountEmail;

	public String getCodeId()
	{
		return codeId;
	}

	public void setCodeId(String codeId)
	{
		this.codeId = codeId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getCodeType()
	{
		return codeType;
	}

	public void setCodeType(String codeType)
	{
		this.codeType = codeType;
	}

	public String getCodeContent()
	{
		return codeContent;
	}

	public void setCodeContent(String codeContent)
	{
		this.codeContent = codeContent;
	}

	public String getCodeMsg()
	{
		return codeMsg;
	}

	public void setCodeMsg(String codeMsg)
	{
		this.codeMsg = codeMsg;
	}

	public String getSendTime()
	{
		return sendTime;
	}

	public void setSendTime(String sendTime)
	{
		this.sendTime = sendTime;
	}

	public String getOverTime()
	{
		return overTime;
	}

	public void setOverTime(String overTime)
	{
		this.overTime = overTime;
	}

	public Integer getIsEmailValidate()
	{
		return isEmailValidate;
	}

	public void setIsEmailValidate(Integer isEmailValidate)
	{
		this.isEmailValidate = isEmailValidate;
	}

	public String getAccountEmail()
	{
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail)
	{
		this.accountEmail = accountEmail;
	}

}
