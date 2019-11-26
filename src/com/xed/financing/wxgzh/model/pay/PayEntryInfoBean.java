/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.signin.SignInBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月13日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * @className:com.xed.financing.wxgzh.model.pay.PayEntryInfoBean
 * @description:
 * @version:v1.0.0
 * @date:2017年5月25日 下午2:29:26
 * @author:WangJun
 */

@XStreamAlias("ORDER")
public class PayEntryInfoBean
{
	private int ENTRYID;

	private int ACCOUNTID;

	private String MCHNTCD = "";

	private String TYPE = "";

	private String VERSION = "";

	private String LOGOTP = "";

	private String MCHNTORDERID = "";

	private String USERID = "";

	private int AMT;

	private String BANKCARD = "";

	private String BACKURL = "";

	private String REURL = "";

	private String HOMEURL = "";

	private String NAME = "";

	private String IDTYPE = "";

	private String IDNO = "";

	private String SIGNTP = "";
	
	private String SIGN = "";
	
	private String REM1 = "";
	
	private String REM2 = "";
	
	private String REM3 = "";
	

	public int getENTRYID()
	{
		return ENTRYID;
	}

	public void setENTRYID(int eNTRYID)
	{
		ENTRYID = eNTRYID;
	}

	public int getACCOUNTID()
	{
		return ACCOUNTID;
	}

	public void setACCOUNTID(int aCCOUNTID)
	{
		ACCOUNTID = aCCOUNTID;
	}

	public String getMCHNTCD()
	{
		return MCHNTCD;
	}

	public void setMCHNTCD(String mCHNTCD)
	{
		MCHNTCD = mCHNTCD;
	}

	public String getTYPE()
	{
		return TYPE;
	}

	public void setTYPE(String tYPE)
	{
		TYPE = tYPE;
	}

	public String getVERSION()
	{
		return VERSION;
	}

	public void setVERSION(String vERSION)
	{
		VERSION = vERSION;
	}

	public String getLOGOTP()
	{
		return LOGOTP;
	}

	public void setLOGOTP(String lOGOTP)
	{
		LOGOTP = lOGOTP;
	}

	public String getMCHNTORDERID()
	{
		return MCHNTORDERID;
	}

	public void setMCHNTORDERID(String mCHNTORDERID)
	{
		MCHNTORDERID = mCHNTORDERID;
	}

	public String getUSERID()
	{
		return USERID;
	}

	public void setUSERID(String uSERID)
	{
		USERID = uSERID;
	}

	public int getAMT()
	{
		return AMT;
	}

	public void setAMT(int aMT)
	{
		AMT = aMT;
	}

	public String getBANKCARD()
	{
		return BANKCARD;
	}

	public void setBANKCARD(String bANKCARD)
	{
		BANKCARD = bANKCARD;
	}

	public String getBACKURL()
	{
		return BACKURL;
	}

	public void setBACKURL(String bACKURL)
	{
		BACKURL = bACKURL;
	}

	public String getREURL()
	{
		return REURL;
	}

	public void setREURL(String rEURL)
	{
		REURL = rEURL;
	}

	public String getHOMEURL()
	{
		return HOMEURL;
	}

	public void setHOMEURL(String hOMEURL)
	{
		HOMEURL = hOMEURL;
	}

	public String getNAME()
	{
		return NAME;
	}

	public void setNAME(String nAME)
	{
		NAME = nAME;
	}

	public String getIDTYPE()
	{
		return IDTYPE;
	}

	public void setIDTYPE(String iDTYPE)
	{
		IDTYPE = iDTYPE;
	}

	public String getIDNO()
	{
		return IDNO;
	}

	public void setIDNO(String iDNO)
	{
		IDNO = iDNO;
	}

	public String getSIGNTP()
	{
		return SIGNTP;
	}

	public void setSIGNTP(String sIGNTP)
	{
		SIGNTP = sIGNTP;
	}

	public String getSIGN()
	{
		return SIGN;
	}

	public void setSIGN(String sIGN)
	{
		SIGN = sIGN;
	}

	public String getREM1()
	{
		return REM1;
	}

	public void setREM1(String rEM1)
	{
		REM1 = rEM1;
	}

	public String getREM2()
	{
		return REM2;
	}

	public void setREM2(String rEM2)
	{
		REM2 = rEM2;
	}

	public String getREM3()
	{
		return REM3;
	}

	public void setREM3(String rEM3)
	{
		REM3 = rEM3;
	}
	
	


}
