/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.accountbankcard.AccountBankcardService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年5月26日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.accountbankcard;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.accountbankcard.AccountBankcardBean;

/**
 * @className:com.xed.financing.wxgzh.service.accountbankcard.AccountBankcardService
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月26日 下午4:16:21
 * @author:ZhangJun
 */
public interface AccountBankcardService
{
	/**
	 * 查询用户绑定的银行卡
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月26日 下午4:10:47
	 */
	public AccountBankcardBean getAccountBankcardByAccountId(String accountId)throws SQLException;
	
	
	/**
	 * 添加绑定银行卡
	 * @Description:
	 * @param accountBankcardBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月26日 下午4:33:10
	 */
	public Integer addAccountBankcard(AccountBankcardBean accountBankcardBean)throws SQLException;
	
	
	/**
	 * 修改绑定银行卡
	 * @Description:
	 * @param accountBankcardBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月26日 下午4:37:05
	 */
	public Integer updateAccountBankcard(AccountBankcardBean accountBankcardBean)throws SQLException;
	
	/**
	 * 获取全部银行卡信息
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月1日 下午3:39:15
	 */
	public List<AccountBankcardBean> getAllBankInfo()throws SQLException;
	
	
	public Integer getBankcardCount(String accountId)throws SQLException;
	
}
