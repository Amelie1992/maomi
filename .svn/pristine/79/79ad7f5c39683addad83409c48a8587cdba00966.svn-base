/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.integralscore.IntegralScoreService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月14日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.integralscore;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

/**
 * @className:com.xed.financing.wxgzh.service.integralscore.IntegralScoreService
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月14日 下午5:48:06
 * @author:ZhangJun
 */
public interface IntegralScoreService
{
	
	/**
	 * 查询用户信息，将查处来的值直接放入request中
	 * @Description:
	 * @param request
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月14日 下午6:00:17
	 */
	public void sendMessage(HttpServletRequest request) throws SQLException;
	
	public void iosSendMessage(String accountId,JSONObject obj) throws SQLException;
	
	/**
	 * 获取账户余额
	 * @Description:
	 * @param session
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年5月4日 下午2:09:52
	 */
	public Map<String, Object> getBalance(HttpSession session) throws SQLException;
	
	/**
	 * 积分充值
	 * @Description:
	 * @param money
	 * @param request
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月17日 下午3:29:45
	 */
	public String recharge(String money,HttpServletRequest request) throws Exception;
	
	public String iosRecharge(String money,String accountId) throws Exception;
	
	/**
	 * 完善信息，奖励积分
	 * @Description:
	 * @param request
	 * @return 奖励积分数
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月10日 下午2:37:08
	 */
	public Integer perfectInformationIntegralReward(HttpServletRequest request)throws Exception;
	
	public Integer iosPerfectInformationIntegralReward(String accountId)throws Exception;
	
}
