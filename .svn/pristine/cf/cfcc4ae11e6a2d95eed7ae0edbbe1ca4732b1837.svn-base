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
package com.xed.financing.wxgzh.service.accountInfo;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;

/**
 * @className:com.xed.financing.wxgzh.service.accountInfo.AccountInfoService
 * @description:
 * @version:v1.0.0
 * @date:2017年3月23日 上午11:34:53
 * @author:ZhangJun
 */
public interface AccountInfoService
{

	/**
	 * 根据登录用户ID获取用户信息
	 * 
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 上午11:30:47
	 */
	public AccountInfo getLoginAccountInfo(HttpServletRequest request) throws SQLException;
	
	public AccountInfo getLoginAccountInfo(HttpServletRequest request,String accountId) throws SQLException;
	
	/**
	 * ios根据登录用户ID获取用户信息
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午6:20:27
	 */
	public AccountInfo iosGetLoginAccountInfo(String accountId) throws SQLException;

	/**
	 * 检查用户名是否存在
	 * 
	 * @Description:
	 * @param accountName
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 上午11:30:51
	 */
	public Integer checkAccountName(String accountName) throws SQLException;

	/**
	 * 修改用户名
	 * 
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 上午11:31:05
	 */
	public Integer changeAccountName(HttpServletRequest request,String accountName) throws SQLException;
	
	/**
	 * ios修改用户名
	 * @Description:
	 * @param accountName
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午6:20:51
	 */
	public Integer iosChangeAccountName(String accountName,String accountId) throws SQLException;

	/**
	 * 判断登录密码是否正确
	 * 
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 上午11:31:13
	 */
	public Integer checkLoginPassword(HttpServletRequest request,AccountInfo accountInfo) throws SQLException;
	
	/**
	 * ios判断登录密码是否正确
	 * @Description:
	 * @param accountId
	 * @param oldPassword
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午6:21:03
	 */
	public Integer iosCheckLoginPassword(String accountId,String oldPassword) throws SQLException;

	/**
	 * 修改登录密码
	 * 
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 上午11:31:23
	 */
	public Integer changeLoginPassword(HttpServletRequest request,AccountInfo accountInfo) throws SQLException;
	
	/**
	 * ios修改登录密码
	 * @Description:
	 * @param accountId
	 * @param newPassword
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午6:21:21
	 */
	public Integer iosChangeLoginPassword(String accountId,String newPassword) throws SQLException;

	/**
	 * 判断交易密码是否正确
	 * 
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 上午11:31:31
	 */
	public Integer checkDealPassword(HttpServletRequest request,AccountInfo accountInfo) throws SQLException;
	
	/**
	 * ios判断交易密码是否正确
	 * @Description:
	 * @param accountId
	 * @param oldDealPassword
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午6:21:39
	 */
	public Integer iosCheckDealPassword(String accountId,String oldDealPassword) throws SQLException;
 
	/**
	 * 修改交易密码
	 * 
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 上午11:31:41
	 */
	public Integer changeDealPassword(HttpServletRequest request,AccountInfo accountInfo) throws SQLException;
	
	/**
	 * ios修改交易密码
	 * @Description:
	 * @param accountId
	 * @param newDealPassword
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午6:21:49
	 */
	public Integer iosChangeDealPassword(String accountId,String newDealPassword) throws SQLException;

	/**
	 * 检查用户输入的手机号是否为登录的手机号
	 * @Description:
	 * @param request
	 * @param telephone
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月24日 下午5:48:14
	 */
	public Boolean checkAccountTelephone(HttpServletRequest request,String telephone) throws SQLException;
	
	/**
	 * ios检查用户输入的手机号是否为登录的手机号
	 * @Description:
	 * @param accountId
	 * @param telephone
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午6:21:59
	 */
	public Boolean iosCheckAccountTelephone(String accountId,String telephone) throws SQLException;
	
	/**
	 * 
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月11日 下午1:57:34
	 */
	public Boolean certification(AccountInfo accountInfo) throws SQLException;
	
	
	/**
	 * 检查电话号码是否存在
	 * @Description:
	 * @param telephone
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月15日 上午9:50:59
	 */
	public Boolean checkTelephone(String telephone) throws SQLException;
	
	/**
	 * 
	 * @Description:
	 * @param telephone
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月15日 上午10:37:16
	 */
	public AccountInfo getAccountInfoByPhone(String telephone) throws SQLException;
	
	/**
	 * 找回登录密码，修改
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月15日 上午10:47:01
	 */
	public Boolean getBackLoginPassword(AccountInfo accountInfo)throws SQLException;

	/**
	 * 设置交易密码
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午3:40:24
	 */
	public Boolean setDealPassword(AccountInfo accountInfo)throws SQLException;
	
	/**
	 * 绑定QQ号
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午3:41:08
	 */
	public Boolean bindInfo(AccountInfo accountInfo)throws SQLException;
	
	/**
	 * 根据ID获取用户信息
	 * 
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 上午11:30:47
	 */
	public AccountInfo getAccountInfo(String accountId) throws SQLException;
	
	/**
	 * 通过微信accountWX查看用户信息
	 * @Description:
	 * @param telephone
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月13日 下午5:29:30
	 */
	public AccountInfo getAccountInfoByAccountWX(String accountWX) throws SQLException;
	
	/**
	 * 根据unionid获取用户信息
	 * @Description:
	 * @param accountWX
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午2:03:49
	 */
	public AccountInfo getAccountInfoByUnionid(String unionid) throws SQLException;
	
	/**
	 * 根据电话修改用户微信id
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月20日 上午11:21:21
	 */
	public Integer updateAccountInfoAccountWXByPhone(String telephone, AccountInfo accountInfo)throws SQLException;
	
	/**
	 * 检查身份证是否存在
	 * 
	 * @Description:
	 * @param accountName
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 上午11:30:51
	 */
	public Integer checkIdCard(AccountInfo accountInfo) throws SQLException;
	
	/**
	 *  发放邀请奖励
	 * 0:绑定银行卡奖励;1:首次投资奖励;2:二次投资奖励
	 * @Description:
	 * @param accountInfo
	 * @param flag
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年11月16日 下午2:57:53
	 */
	public void sendRecommendReward(AccountInfo accountInfo,int flag, String money) throws SQLException;
	
	/**
	 * 查看用户投资数量
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月29日 上午9:55:07
	 */
	public Integer countInvestSubject(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 检查用户有没有上传过头像
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月9日 下午1:56:33
	 */
	public boolean checkIcon(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 保存用户头像url
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月9日 下午1:58:05
	 */
	public Integer updateAccountIcon(AccountInfo accountInfo) throws SQLException;

	public int updAutoBid(AccountInfo accountInfo)throws SQLException;
	
	/**
	 * 
	 * @Description:根据身份证查询是否有这个用户
	 * @param idCard
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2018年6月27日 上午10:39:50
	 */
	public Integer countAccountInfoByIdCard(@Param(value="idCard") String idCard)throws SQLException;
	
}
