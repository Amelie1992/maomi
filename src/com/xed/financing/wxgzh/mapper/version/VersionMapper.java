/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.version.VersionMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年6月7日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.version;

import com.xed.financing.wxgzh.model.version.VersionBean;

/**
 * 版本号
 * @className:com.xed.financing.wxgzh.mapper.version.VersionMapper
 * @description:
 * @version:v1.0.0 
 * @date:2018年6月7日 下午4:12:33
 * @author:QT
 */
public interface VersionMapper
{
	/**
	 * 根据版本类型查询最新版本号
	 * @Description:
	 * @param versionBean
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年6月7日 下午4:19:10
	 */
	public VersionBean queryNewVersion(VersionBean versionBean) throws Exception;
}
