/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.analysis.AnalysisBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年6月8日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.analysis;

/**
 * @className:com.xed.financing.wxgzh.model.analysis.AnalysisBean
 * @description:
 * @version:v1.0.0 
 * @date:2018年6月8日 上午10:53:40
 * @author:QT
 */
public class AnalysisBean
{
	/**
	 * 主键
	 */
	private String analysisId;  
	
	/**
	 * 用户id
	 */
	private String accountId;
	
	/**
	 * 版本号
	 */
	private String verCode;
	
	/**
	 * 开始时间
	 */
	private String beginTime;
	
	/**
	 * 结束时间
	 */
	private String endTime;

	public String getAnalysisId()
	{
		return analysisId;
	}

	public void setAnalysisId(String analysisId)
	{
		this.analysisId = analysisId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getVerCode()
	{
		return verCode;
	}

	public void setVerCode(String verCode)
	{
		this.verCode = verCode;
	}

	public String getBeginTime()
	{
		return beginTime;
	}

	public void setBeginTime(String beginTime)
	{
		this.beginTime = beginTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}  
}
