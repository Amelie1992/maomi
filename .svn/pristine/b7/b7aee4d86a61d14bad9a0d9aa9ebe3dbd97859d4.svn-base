/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.version.VersionServiceImpl
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
package com.xed.financing.wxgzh.service.version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.version.VersionMapper;
import com.xed.financing.wxgzh.model.version.VersionBean;

/**
 * @className:com.xed.financing.wxgzh.service.version.VersionServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2018年6月7日 下午4:20:39
 * @author:QT
 */
@Service
public class VersionServiceImpl implements VersionService
{
	@Autowired
	private VersionMapper versionMapper;

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.version.VersionService#queryNewVersion(com.xed.financing.wxgzh.model.version.VersionBean)
	 */
	@Override
	public VersionBean queryNewVersion(VersionBean versionBean) throws Exception
	{
		return versionMapper.queryNewVersion(versionBean);
	}

}
