/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.capital.CapitalMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月20日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.capital;

import java.sql.SQLException;

import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.capital.CapitalBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.capital.CapitalMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月20日 下午9:07:22
 * @author:Qian Tao
 */
public interface CapitalMapper
{
	/**
	 * 查询用户总金额
	 * @Description:
	 * @param capitalBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月20日 下午9:08:13
	 */
	public CapitalBean queryCapitalById(CapitalBean capitalBean) throws SQLException;
	
	/**
	 * 修改用户总金额
	 * @Description:
	 * @param capitalBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月20日 下午9:14:57
	 */
	public void editCapitalById(CapitalBean capitalBean) throws SQLException;
	
	/**
	 * 修改用户总金额
	 * @Description:
	 * @param capitalBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月20日 下午9:14:57
	 */
	public void editAccountCapitalById(AccountCapital accountCapital) throws SQLException;
	
	/**
	 * 
	 * @Description:查询用户信息
	 * @param capitalBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月29日 上午9:55:28
	 */
	public CapitalBean queryAccountInfo(CapitalBean capitalBean) throws SQLException;
	
	/**
	 * 添加用户账户信息
	 * @Description:
	 * @param capitalBean 用户ID
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月10日 下午2:53:32
	 */
	public Integer addAccountCapital(CapitalBean capitalBean) throws SQLException;

	public Integer updateCapInfo(AccountCapital accountBean)throws SQLException;
}
