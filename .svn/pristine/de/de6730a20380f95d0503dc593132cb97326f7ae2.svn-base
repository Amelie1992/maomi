/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.city.CityService
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
package com.xed.financing.wxgzh.service.city;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.city.CityBean;

/**
 * @className:com.xed.financing.wxgzh.service.city.CityService
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月26日 下午3:01:13
 * @author:ZhangJun
 */
public interface CityService
{
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
	public List<CityBean> queryCityBySubCode(String subCode) throws SQLException;
	
	/**
	 * 查询省市区
	 * @Description:
	 * @param cityBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月6日 上午10:40:18
	 */
	public List<CityBean> queryCity(CityBean cityBean) throws SQLException;
}
