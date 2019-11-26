/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.goldtransfer.GoldTransferBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年5月10日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.goldtransfer;

/**
 * 金账户接口调用明细
 * @className:com.xed.financing.wxgzh.model.goldtransfer.GoldTransferBean
 * @description:
 * @version:v1.0.0 
 * @date:2018年5月10日 上午11:44:32
 * @author:QT
 */
public class GoldTransferBean
{
	/**
	 * 响应码
	 */
	private String respCode;   	
	        
	/**
	 * 商户代码
	 */
	private String mchntCd;  

	/**
	 * 请求流水号
	 */
	private String mchntTxnSsn;
	
	/**
	 * 签名数据
	 */
	private String signature;
	
	/**
	 * 入账号
	 */
	private String inCustNo;
	
	/**
	 * 出账号
	 */
	private String outCustNo;
	
	/**
	 * 添加时间
	 */
	private String addTime;

	public String getRespCode()
	{
		return respCode;
	}

	public void setRespCode(String respCode)
	{
		this.respCode = respCode;
	}

	public String getMchntCd()
	{
		return mchntCd;
	}

	public void setMchntCd(String mchntCd)
	{
		this.mchntCd = mchntCd;
	}

	public String getMchntTxnSsn()
	{
		return mchntTxnSsn;
	}

	public void setMchntTxnSsn(String mchntTxnSsn)
	{
		this.mchntTxnSsn = mchntTxnSsn;
	}

	public String getSignature()
	{
		return signature;
	}

	public void setSignature(String signature)
	{
		this.signature = signature;
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

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}
}
