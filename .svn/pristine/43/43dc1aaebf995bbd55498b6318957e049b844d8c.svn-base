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
package com.xed.financing.wxgzh.service.activityrecord;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.xed.financing.wxgzh.model.activityrecord.ActivityRecordBean;


/**
 * @className:com.xed.financing.wxgzh.service.accountInfo.AccountInfoService
 * @description:
 * @version:v1.0.0
 * @date:2017年3月23日 上午11:34:53
 * @author:ZhangJun
 */
public interface ActivityRecordService
{

	
	
	/**
	 * 判断集字活动是否获得字，并发放
	 * @Description:
	 * @param request 用户信息
	 * @param gainType 获取路径
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月22日 下午5:41:17
	 */
	public String activityCalligraphy(HttpServletRequest request,String gainType) throws SQLException;
	
	
	/**
	 * 获得未兑换的个数（按照编码分类）
	 * @Description:
	 * @param activityRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月22日 下午4:46:49
	 */
	public Integer countNotConvertible(ActivityRecordBean activityRecordBean) throws SQLException;
	
	
	
	/**
	 * 兑换集字
	 * @Description:
	 * @param request
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月22日 下午4:54:50
	 */
	public String exchangeCalligraphy(HttpServletRequest request) throws Exception;



}
