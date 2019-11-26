/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.loginRegister.LoginRegisterMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月15日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.loginregister;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;

/**
 * 登录注册模块
 * @className:com.xed.financing.wxgzh.mapper.loginRegister.LoginRegisterMapper
 * @description: 登录注册模块
 * @version:v1.0.0 
 * @date:2017年3月15日 上午10:58:28
 * @author:ZhangJun
 */
public interface LoginRegisterMapper
{
	/**
	 *  检查手机号唯一
	 * @Description: 检查注册时用户所用的手机号是否注册过
	 * @param telephone
	 * @return 注册过>0 ,未注册=0
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 上午11:02:00
	 */
	public Integer checkTelephoneOnly(String telephone) throws SQLException;
	
	/**
	 *  检查登录
	 * @Description: 用户用户名或手机号，和密码检查验证
	 * @param accountInfo
	 * @return 成功返回登录ID 失败返回null
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 上午11:07:51
	 */
	public String checkLogin(AccountInfo accountInfo) throws SQLException;
	
	/**
	 *  用户注册
	 * @Description:用户注册，添加账户信息 
	 * @param accountInfo
	 * @return 注册成功>0 ,注册失败=0
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 上午11:11:34
	 */
	public Integer addAccountInfo(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 检查用户名是否存在
	 * @Description: 在用户修改姓名时是否，用户名是否存在
	 * @param accountName
	 * @return 存在>0 ,不存在=0
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 下午2:18:04
	 */
	public Integer checkAccountName(String accountName) throws SQLException;
	
	/**
	 * 通过账户ID查询全部账户信息
	 * @Description:
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午2:55:25
	 */
	public AccountInfo getAccountInfoById(String accountId) throws SQLException;
	
	/**
	 * 登录成功后更改登录时间
	 * @Description:
	 * @param accountInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月27日 下午2:57:57
	 */
	public void updateLoginTime(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 查询邀请的好友数
	 * @Description:
	 * @param accountInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月15日 下午3:41:58
	 */
	public String queryFriendsCount(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 查询邀请的好友总投资额
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月15日 下午3:42:40
	 */
	public String queryFriendsInvest(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 查询获得的好友奖励次数
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月15日 下午3:44:03
	 */
	public String queryFriendsMoney(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 查询获得的好友奖励次数
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月15日 下午3:44:03
	 */
	public String queryFriendsCoupon(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 查询获得的好友奖励总额
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月15日 下午3:45:00
	 */
	public String queryFriendsPercent(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 判断用户是否为冻结用户
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年10月17日 下午1:51:34
	 */
	public Integer checkLoginIsFrozen(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 
	 * @Description:注册添加用户等级信息
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月9日 下午4:46:24
	 */
	public Integer addAccountLevel(AccountInfo accountInfo) throws SQLException;
	
	/**
	 *  检查微信号唯一
	 * @Description: 检查注册时用户所用的手机号是否注册过
	 * @param telephone
	 * @return 注册过>0 ,未注册=0
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 上午11:02:00
	 */
	public Integer checkAccountWXOnly(String accountWx) throws SQLException;
	
	/**
	 * 通过账户ID查询邀请人相同的账号id
	 * @Description: <限定注册时间>
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午2:55:25
	 */
	public List<AccountInfo> getFriendsList(@Param("accountId")String accountId, @Param("regBegin")String regBegin, @Param("regEnd")String regEnd) throws SQLException;
	
	/**
	 * 通过账户ID查询邀请人相同的账号id 数量
	 * @Description: <限定注册时间>
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午2:55:25
	 */
	public Integer getFriendsCount(@Param("accountId")String accountId, @Param("regBegin")String regBegin, @Param("regEnd")String regEnd) throws SQLException;
	
	/**
	 * 
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月29日 上午10:09:45
	 */
	public List<AccountInfo> checkFriends(AccountInfo accountInfo) throws SQLException;
}
