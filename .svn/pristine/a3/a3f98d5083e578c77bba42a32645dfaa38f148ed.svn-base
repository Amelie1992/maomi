/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.city.impl.CityServiceImpl
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
package com.xed.financing.wxgzh.service.city.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.city.CityMapper;
import com.xed.financing.wxgzh.model.city.CityBean;
import com.xed.financing.wxgzh.service.city.CityService;

/**
 * @className:com.xed.financing.wxgzh.service.city.impl.CityServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月26日 下午3:01:28
 * @author:ZhangJun
 */
@Service
@Transactional
public class CityServiceImpl implements CityService
{

	@Resource
	private CityMapper cityMapper;
	
	/**
	 * 根据上级code查询城市信息
	 * @Description:
	 * @param subCode
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月26日 下午2:47:55
	 */
	@Override
	public List<CityBean> queryCityBySubCode(String subCode) throws SQLException
	{
		
		return cityMapper.queryCityBySubCode(subCode);
	}

	@Override
	public List<CityBean> queryCity(CityBean cityBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return cityMapper.queryCity(cityBean);
	}
	
}
