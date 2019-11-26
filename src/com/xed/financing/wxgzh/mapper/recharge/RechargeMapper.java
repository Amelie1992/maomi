/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.pay.PayExportInfoMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年5月26日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.recharge;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.bank.BankBean;

/**
 * 
 * @className:com.xed.financing.wxgzh.mapper.recharge.RechargeMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月28日 下午4:02:16
 * @author:WangJun
 */
public interface RechargeMapper
{

	/**
	 * 
	 * @Description:查找
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:WangJun
	 * @date:2017年5月27日 下午3:49:59
	 */

	public List<BankBean> queryRechargeAll()throws SQLException;

	public BankBean queryByCode(String rcd);
}
