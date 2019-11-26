/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.signin.SignInService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月13日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.signin;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.signin.SignInBean;

/**
 * @className:com.xed.financing.wxgzh.service.signin.SignInService
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月13日 下午4:01:34
 * @author:ZhangJun
 */
public interface SignInService
{
	/**
	 * 查询用户当前月签到总数
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月13日 下午4:05:56
	 */
	public Integer queryCurrentMonthSignInDayCount(String accountId)throws SQLException;
	
	/**
	 * 查询用户当前月鱼干总数
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月13日 下午4:05:56
	 */
	public Integer queryCurrentMonthSignInScoreCount(String accountId)throws SQLException;
	
	/**
	 * 查询用户当前月签到集合
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月13日 下午4:08:38
	 */
	public List<SignInBean> queryCurrentMonthSignInList(String accountId) throws SQLException;
	
	/**
	 * 添加签到
	 * @Description:
	 * @param signInBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月13日 下午4:08:50
	 */
	public Integer addSignIn(SignInBean signInBean)throws SQLException;
	
	/**
	 * 检查今天是否签到
	 * @Description:
	 * @param signInBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月13日 下午5:49:02
	 */
	public Integer checkSignIn(String accountId)throws SQLException;
	
	
	/**
	 * 添加奖励积分
	 * @Description:
	 * @param request
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月14日 上午10:33:00
	 */
	public String addBonusPoints(HttpServletRequest request,String accountId,Map<String, Object> map)throws SQLException;
	
	/**
	 * 国庆活动判断是否满签
	 * @Description:
	 * @param signInBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年9月25日 下午1:47:00
	 */
	public Integer countSignOn(SignInBean signInBean)throws SQLException;
	
	/**
	 * 判断是否补签昨日
	 * @Description:
	 * @param accountInfo
	 * @return notEnough:次数不足 isSign:昨日已签  success:补签成功
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月16日 上午10:12:17
	 */
	public String signingYesterday(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 发送补签昨日奖励鱼干
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月28日 上午9:37:52
	 */
	public String addBonusPointsYesterDay(AccountInfo accountInfo)throws SQLException;
	
	/**
	 * 检查昨日是否签过
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月29日 下午5:42:11
	 */
	public Integer changeYesterdaySign(AccountInfo accountInfo)throws SQLException;
	
}
