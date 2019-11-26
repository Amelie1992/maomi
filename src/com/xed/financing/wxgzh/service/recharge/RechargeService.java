/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.pay.PayExportInfoService
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
package com.xed.financing.wxgzh.service.recharge;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.bank.BankBean;

/**
 * @className:com.xed.financing.wxgzh.service.pay.PayExportInfoService
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月26日 下午1:58:08
 * @author:Qian Tao
 */
public interface RechargeService
{

	/**
	 * 
	 * @Description:查找
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:WangJun
	 * @date:2017年5月27日 下午3:47:42
	 */
	public List<BankBean> queryRechargeAll()throws SQLException;

	public BankBean queryByCode(String rcd);
}
