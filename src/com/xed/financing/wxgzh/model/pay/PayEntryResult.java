package com.xed.financing.wxgzh.model.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("FM")
public class PayEntryResult
{
	private String MchntCd = "";

	private String OrderId = "";

	private String Sign = "";

	public String getMchntCd()
	{
		return MchntCd;
	}

	public void setMchntCd(String mchntCd)
	{
		MchntCd = mchntCd;
	}

	public String getOrderId()
	{
		return OrderId;
	}

	public void setOrderId(String orderId)
	{
		OrderId = orderId;
	}

	public String getSign()
	{
		return Sign;
	}

	public void setSign(String sign)
	{
		Sign = sign;
	}

}
