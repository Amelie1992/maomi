/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月22日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.autobid;

import java.sql.SQLException;

import com.xed.financing.wxgzh.model.autobid.AutobidInfo;

/**
 * 
 * @className:com.xed.financing.wxgzh.mapper.autobid.AutoBidMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月10日 下午2:41:21
 * @author:WangJun
 */
public interface AutoBidMapper
{
	/**
	 * 获取用户最新的一条自动投资记录
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年4月10日 上午11:35:19
	 */
	public AutobidInfo getAccountAutobid(String accountId) throws SQLException;
	
	/**
	 * 添加自动投标
	 * @Description:
	 * @param autobidInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年4月10日 上午11:35:31
	 */
	public Integer addAutobidInfo(AutobidInfo autobidInfo) throws SQLException;
	
	/**
	 * 取消自动投标
	 * @Description:
	 * @param autobidInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年4月10日 上午11:35:47
	 */
	public Integer cancelAutobid(AutobidInfo autobidInfo) throws SQLException;
}
