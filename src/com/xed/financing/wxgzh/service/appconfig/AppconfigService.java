/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.appconfig.AppconfigService
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
package com.xed.financing.wxgzh.service.appconfig;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.appconfig.AppconfigBean;

/**
 * @className:com.xed.financing.wxgzh.service.appconfig.AppconfigService
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月17日 上午11:05:09
 * @author:penggang
 */
public interface AppconfigService
{
	/**
	 * 查询app图片集合
	 * @Description:
	 * @param appConfigBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年4月16日 上午11:43:56
	 */
	public List<AppconfigBean> queryAppConfig(AppconfigBean appConfigBean) throws SQLException; 
	
	/**
	 * 查询数量
	 * @Description:
	 * @param appConfigBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年4月16日 上午11:44:10
	 */
	public Integer countAppConfig(AppconfigBean appConfigBean) throws SQLException; 
	
	/**
	 * 详情
	 * @Description:
	 * @param appConfigBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年4月16日 上午11:44:16
	 */
	public AppconfigBean queryAppConfigById(AppconfigBean appConfigBean) throws SQLException; 
}
