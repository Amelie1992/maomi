/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.appconfig.impl.AppconfigServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:penggang
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月17日    penggang  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.appconfig.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.appconfig.AppconfigMapper;
import com.xed.financing.wxgzh.model.appconfig.AppconfigBean;
import com.xed.financing.wxgzh.service.appconfig.AppconfigService;

/**
 * @className:com.xed.financing.wxgzh.service.appconfig.impl.AppconfigServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月17日 上午11:05:47
 * @author:penggang
 */
@Service
public class AppconfigServiceImpl implements AppconfigService
{

	@Autowired
	private AppconfigMapper appconfigMapper;
	
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.appconfig.AppconfigService#queryAppConfig(com.xed.financing.wxgzh.model.appconfig.AppconfigBean)
	 */
	@Override
	public List<AppconfigBean> queryAppConfig(AppconfigBean appConfigBean) throws SQLException
	{
		return appconfigMapper.queryAppConfig(appConfigBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.appconfig.AppconfigService#countAppConfig(com.xed.financing.wxgzh.model.appconfig.AppconfigBean)
	 */
	@Override
	public Integer countAppConfig(AppconfigBean appConfigBean) throws SQLException
	{
		return appconfigMapper.countAppConfig(appConfigBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.appconfig.AppconfigService#queryAppConfigById(com.xed.financing.wxgzh.model.appconfig.AppconfigBean)
	 */
	@Override
	public AppconfigBean queryAppConfigById(AppconfigBean appConfigBean) throws SQLException
	{
		return appconfigMapper.queryAppConfigById(appConfigBean);
	}

}
