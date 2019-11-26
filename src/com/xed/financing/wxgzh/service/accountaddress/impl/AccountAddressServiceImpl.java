/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.subject.SubjectServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月16日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.accountaddress.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountaddress.AccountAddressMapper;
import com.xed.financing.wxgzh.model.accountaddress.AccountAddressBean;
import com.xed.financing.wxgzh.service.accountaddress.AccountAddressService;

/**
 * 
 * @className:com.xed.financing.wxgzh.service.accountaddress.impl.AccountAddressServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年4月19日 下午2:54:58
 * @author:Elias Zheng
 */
@Service
public class AccountAddressServiceImpl implements AccountAddressService
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AccountAddressServiceImpl.class);

	@Resource
	private AccountAddressMapper accountAddressMapper;

	@Override
	public List<AccountAddressBean> queryAccountAddress(AccountAddressBean accountAddressBean) throws SQLException
	{

		return this.accountAddressMapper.queryAccountAddress(accountAddressBean);
	}

	@Override
	public Integer countAccountAddress(AccountAddressBean accountAddressBean) throws SQLException
	{

		return this.accountAddressMapper.countAccountAddress(accountAddressBean);
	}

	@Override
	public AccountAddressBean queryAccountAddressDefaultById(AccountAddressBean accountAddressBean) throws SQLException
	{

		return this.accountAddressMapper.queryAccountAddressDefaultById(accountAddressBean);
	}

	@Override
	@Transactional
	public void insertAccountAddress(AccountAddressBean accountAddressBean)
	{

		try
		{
			this.accountAddressMapper.insertAccountAddress(accountAddressBean);
		}
		catch (Exception e)
		{
			logger.error("更新消息记录异常");
			throw new RuntimeException();
		}

	}

	@Override
	public void editAccountAddress(AccountAddressBean accountAddressBean) throws SQLException
	{
		// TODO Auto-generated method stub
		accountAddressMapper.editAccountAddress(accountAddressBean);
	}
}
