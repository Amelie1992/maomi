/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.payentry.impl.PayEntryInfoServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年5月27日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.payentry.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.payentry.PayEntryInfoMapper;
import com.xed.financing.wxgzh.model.pay.PayEntryInfoBean;
import com.xed.financing.wxgzh.service.payentry.PayEntryInfoService;

/**
 * @className:com.xed.financing.wxgzh.service.payentry.impl.PayEntryInfoServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月27日 上午9:49:30
 * @author:Qian Tao
 */
@Service
public class PayEntryInfoServiceImpl implements PayEntryInfoService
{

	@Autowired
	private PayEntryInfoMapper payEntryInfoMapper;
	
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.payentry.PayEntryInfoService#savePayEntry(com.xed.financing.wxgzh.model.pay.PayEntryInfoBean)
	 */
	@Override
	public boolean savePayEntry(PayEntryInfoBean payEntryInfoBean) throws SQLException
	{
		return payEntryInfoMapper.savePayEntry(payEntryInfoBean);
	}

}
