/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.capital.impl.CapitalServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月21日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.capital.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.service.capital.CapitalService;

/**
 * @className:com.xed.financing.wxgzh.service.capital.impl.CapitalServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年3月21日 上午9:54:40
 * @author:Qian Tao
 */
@Service
public class CapitalServiceImpl implements CapitalService
{

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(CapitalServiceImpl.class);
	@Resource
	private CapitalMapper capitalMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xed.financing.wxgzh.service.capital.CapitalService#queryCapitalById
	 * (com.xed.financing.wxgzh.model.capital.CapitalBean)
	 */

	/**
	 * 查询用户总金额
	 */
	@Override
	public CapitalBean queryCapitalById(CapitalBean capitalBean) throws SQLException
	{
		// capitalBean.setInvestmentMoney(MoneyUtils.changeFToY(capitalBean.getInvestmentMoney()));
		return capitalMapper.queryCapitalById(capitalBean);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xed.financing.wxgzh.service.capital.CapitalService#editCapitalById
	 * (com.xed.financing.wxgzh.model.capital.CapitalBean)
	 */

	/**
	 * 修改用户总金额
	 */
	@Override
	@Transactional
	public void editCapitalById(CapitalBean capitalBean)
	{
		try
		{
			capitalMapper.editCapitalById(capitalBean);
		}
		catch (Exception e)
		{
			logger.error("修改用户总金额异常");
			throw new RuntimeException();
		}
	}

	/**
	 * 查询用户账号信息
	 */
	@Override
	public CapitalBean queryAccountInfo(CapitalBean capitalBean) throws SQLException
	{
		return capitalMapper.queryAccountInfo(capitalBean);
	}

	@Override
	@Transactional
	public Integer addAccountCapital(CapitalBean capitalBean)
	{
		try
		{
			return capitalMapper.addAccountCapital(capitalBean);
		}
		catch (Exception e)
		{
			logger.error("添加用户账户信息异常");
			throw new RuntimeException();
		}
	}

	@Override
	public void editAccountCapitalById(AccountCapital accountCapital) throws SQLException
	{
		capitalMapper.editAccountCapitalById(accountCapital);
	}

}
