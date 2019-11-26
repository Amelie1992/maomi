/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.userlevel.UserLevelService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月10日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.userlevel;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

/**
 * @className:com.xed.financing.wxgzh.service.userlevel.UserLevelService
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月10日 上午9:43:34
 * @author:ZhangJun
 */
public interface UserLevelService
{
	
	/**
	 * 修改用户等级
	 * @Description: 
	 * @param request
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月10日 上午11:13:31
	 */
	public Integer changeUserLevel(HttpServletRequest request) throws SQLException;
}
