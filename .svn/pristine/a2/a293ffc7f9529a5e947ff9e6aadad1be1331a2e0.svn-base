/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.fuiou.FuiouService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月25日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.fuiou;

import java.util.Map;

/**
 * @className:com.xed.financing.wxgzh.service.fuiou.FuiouService
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月25日 下午2:45:38
 * @author:ZhangJun
 */
public interface FuiouService
{
	/**
	 * 金账户开户
	 * @Description:
	 * @param accountId
	 * @return result :{success:开户成功,error:开户失败,has:已开户}
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月7日 下午1:38:35
	 */
	public Map<String,String>  reg(String accountId)throws Exception;
	
	/**
	 * 检查是否实名认证，绑定银行卡
	 * @Description:
	 * @param accountId
	 * @return result :{noRealName:没有实名认证,noBankCard:没有绑定银行卡,pass:通过}
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月7日 下午1:40:02
	 */
	public Map<String ,String> checkRealNameAndBankCard(String accountId) throws Exception;
	
	/**
	 * 
	 * @Description:
	 * @param repayMap
	 * @param outCustNo
	 * @param inCustNo
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月11日 上午10:11:38
	 */
	public void addGoldTransfer(Map<String, String> repayMap,String outCustNo,String inCustNo)throws Exception;
}
