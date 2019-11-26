/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.signin.SignInMapper
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
package com.xed.financing.wxgzh.mapper.signin;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.signin.SignInBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.signin.SignInMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月13日 下午3:43:32
 * @author:ZhangJun
 */
public interface SignInMapper
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
	public Integer checkSignIn(String signInBean)throws SQLException;
	
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
	 * 补签昨日
	 * @Description:
	 * @param accountInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月16日 上午11:15:23
	 */
	public void signYesterday(AccountInfo accountInfo)throws SQLException;
	
	
	/**
	 * 检查昨日是否未签到
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月16日 下午2:08:56
	 */
	public Integer changeYesterdaySign(AccountInfo accountInfo)throws SQLException;
	
}
