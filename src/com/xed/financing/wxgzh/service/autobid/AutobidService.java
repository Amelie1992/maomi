/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.accountInfo.AccountInfoService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月23日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.autobid;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xed.financing.wxgzh.model.autobid.AutobidInfo;

/**
 * @className:com.xed.financing.wxgzh.service.accountInfo.AccountInfoService
 * @description:
 * @version:v1.0.0
 * @date:2017年3月23日 上午11:34:53
 * @author:ZhangJun
 */
public interface AutobidService
{
	/**
	 * 获取自动投标记录
	 * @Description:
	 * @param request
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年6月15日 下午4:40:00
	 */
	public void getAutobid(HttpServletRequest request) throws Exception;
	
	/**
	 * 设置自动投标
	 * @Description:
	 * @param accountId
	 * @param autobidInfo
	 * @param map
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年6月15日 下午4:40:16
	 */
	public void addAutobid(String accountId,AutobidInfo autobidInfo,Map<String, Object> map) throws Exception;
	
	/**
	 * 取消自动投标
	 * @Description:
	 * @param accountId
	 * @param map
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年6月15日 下午4:40:29
	 */
	public void cancelAutobid(String accountId,Map<String, Object> map) throws Exception;

}
