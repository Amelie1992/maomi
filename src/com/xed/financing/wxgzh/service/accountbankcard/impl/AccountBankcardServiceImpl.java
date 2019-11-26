/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.accountbankcard.impl.AccountBankcardServiceImpl
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
package com.xed.financing.wxgzh.service.accountbankcard.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.accountbankcard.AccountBankcardMapper;
import com.xed.financing.wxgzh.model.accountbankcard.AccountBankcardBean;
import com.xed.financing.wxgzh.service.accountbankcard.AccountBankcardService;

/**
 * @className:com.xed.financing.wxgzh.service.accountbankcard.impl.AccountBankcardServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年5月26日 下午4:16:47
 * @author:ZhangJun
 */
@Service
public class AccountBankcardServiceImpl implements AccountBankcardService
{
	@Resource
	public AccountBankcardMapper accountBankcardMapper;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AccountBankcardServiceImpl.class);

	/**
	 * 查询用户绑定的银行卡
	 * 
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月26日 下午4:10:47
	 */
	@Override
	public AccountBankcardBean getAccountBankcardByAccountId(String accountId) throws SQLException
	{
		return accountBankcardMapper.getAccountBankcardByAccountId(accountId);
	}

	/**
	 * 添加绑定银行卡
	 * 
	 * @Description:
	 * @param accountBankcardBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月26日 下午4:33:10
	 */
	@Override
	public Integer addAccountBankcard(AccountBankcardBean accountBankcardBean) throws SQLException
	{

		return accountBankcardMapper.addAccountBankcard(accountBankcardBean);
	}

	/**
	 * 修改绑定银行卡
	 * 
	 * @Description:
	 * @param accountBankcardBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月26日 下午4:37:05
	 */
	@Override
	public Integer updateAccountBankcard(AccountBankcardBean accountBankcardBean) throws SQLException
	{

		return accountBankcardMapper.updateAccountBankcard(accountBankcardBean);
	}

	
	/**
	 * 获取全部银行卡信息
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月1日 下午3:39:15
	 */
	public List<AccountBankcardBean> getAllBankInfo() throws SQLException
	{
		return accountBankcardMapper.getAllBankInfo();
	}

	@Override
	public Integer getBankcardCount(String accountId) throws SQLException
	{
		
		return accountBankcardMapper.getBankcardCount(accountId);
	}

}
