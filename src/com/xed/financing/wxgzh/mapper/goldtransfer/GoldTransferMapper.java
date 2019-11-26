/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.goldtransfer.GoldTransferMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年5月10日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.goldtransfer;

import com.xed.financing.wxgzh.model.goldtransfer.GoldTransferBean;

/**
 * 金账户接口调用明细
 * @className:com.xed.financing.wxgzh.mapper.goldtransfer.GoldTransferMapper
 * @description:
 * @version:v1.0.0 
 * @date:2018年5月10日 上午11:53:22
 * @author:QT
 */
public interface GoldTransferMapper
{
	/**
	 * 添加金账户接口调用明细
	 * @Description:
	 * @param goldTransferBean
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年5月10日 上午11:58:22
	 */
	public void addGoldTransfer(GoldTransferBean goldTransferBean);
}
