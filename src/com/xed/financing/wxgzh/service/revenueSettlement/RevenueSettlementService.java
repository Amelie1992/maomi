/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.revenueSettlement.RevenueSettlementService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月26日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.revenueSettlement;

import java.sql.SQLException;

import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;
import com.xed.financing.wxgzh.model.creditrecord.CreditRecord;


/**
 * @className:com.xed.financing.wxgzh.service.revenueSettlement.RevenueSettlementService
 * @description:收益结算
 * @version:v1.0.0 
 * @date:2017年4月26日 上午9:30:35
 * @author:ZhangJun
 */
public interface RevenueSettlementService
{
	/**
	 * 收益结算
	 * @Description:
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月26日 上午10:29:12
	 */
	public void revenueSettlement()throws Exception;
	
	/**
	 * 修改转让记录
	 * @Description:
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月20日 下午4:26:25
	 */
	public void updateTransferRecord()throws Exception;
	
	/**
	 * 修改转让记录
	 * @Description:
	 * @param creditRecord
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月20日 下午4:32:54
	 */
	public CreditRecord updateTransferAmount(CreditRecord creditRecord)throws Exception;
	
	
	/**
	 * 猫咪宝收益发放
	 * @Description:
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月24日 下午4:52:41
	 */
	public void grantProfit()throws Exception;
	
	/**
	 * 猫咪宝合并记录
	 * @Description:
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月31日 下午4:33:50
	 */
	public void mergeRecord()throws Exception;
	
	/**
	 * 通过investId查询当天结算收益的投标信息
	 * @Description:
	 * @param investId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年9月26日 下午2:13:27
	 */
	public AccountInvest getSettlementIncomeInvestInfoById(String investId) throws SQLException;
	
}
