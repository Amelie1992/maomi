package com.xed.financing.wxgzh.model.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("FM")
public class CardQueryBean
{
	private String MchntCd = "";
	
	private String Ono = "";
	
	private String Sign = "";

	public String getMchntCd()
	{
		return MchntCd;
	}

	public void setMchntCd(String mchntCd)
	{
		MchntCd = mchntCd;
	}

	public String getOno()
	{
		return Ono;
	}

	public void setOno(String ono)
	{
		Ono = ono;
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
