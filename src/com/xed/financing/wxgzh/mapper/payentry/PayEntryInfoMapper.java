/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.payentry.PayEntryInfoMapper
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
package com.xed.financing.wxgzh.mapper.payentry;

import java.sql.SQLException;

import com.xed.financing.wxgzh.model.pay.PayEntryInfoBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.payentry.PayEntryInfoMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月27日 上午9:45:36
 * @author:Qian Tao
 */
public interface PayEntryInfoMapper
{
	/**
	 * 添加entry
	 * @Description:
	 * @param payEntryInfoBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年5月27日 上午9:46:23
	 */
	public boolean savePayEntry(PayEntryInfoBean payEntryInfoBean) throws SQLException;
}
