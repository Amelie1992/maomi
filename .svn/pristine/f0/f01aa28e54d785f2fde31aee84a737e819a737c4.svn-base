/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.pay.PayExportInfoServiceImpl
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
package com.xed.financing.wxgzh.service.recharge.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.recharge.RechargeMapper;
import com.xed.financing.wxgzh.model.bank.BankBean;
import com.xed.financing.wxgzh.service.recharge.RechargeService;

/**
 * @className:com.xed.financing.wxgzh.service.pay.PayExportInfoServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月26日 下午1:58:45
 * @author:Qian Tao
 */
@Service
public class RechargeServiceImpl implements RechargeService
{
	@Autowired
	private RechargeMapper rechargeMapper; 
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.pay.PayExportInfoService#savePayExport(com.xed.financing.wxgzh.model.pay.PayExportInfoBean)
	 */

	@Override
	public List<BankBean> queryRechargeAll() throws SQLException
	{
		// TODO Auto-generated method stub
		return rechargeMapper.queryRechargeAll();
	}

	@Override
	public BankBean queryByCode(String rcd)
	{
		// TODO Auto-generated method stub
		return rechargeMapper.queryByCode(rcd);
	}

}
