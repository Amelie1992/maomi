/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.loginRegister.LoginRegisterService
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
package com.xed.financing.wxgzh.service.loginRegister;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;

/**
 * @className:com.xed.financing.wxgzh.service.loginRegister.LoginRegisterService
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月15日 下午2:37:16
 * @author:ZhangJun
 */
public interface LoginRegisterService
{
	/**
	 *  检查手机号唯一
	 * @Description: 检查注册时用户所用的手机号是否注册过
	 * @param telephone
	 * @return 注册过返回false ,未注册返回true
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 上午11:02:00
	 */
	public Boolean checkTelephoneOnly(String telephone) throws SQLException;
	
	/**
	 *  检查登录
	 * @Description: 用户用户名或手机号，和密码检查验证
	 * @param accountInfo
	 * @return 登录成功返回true ,登录失败false
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 上午11:07:51
	 */
	public Boolean checkLogin(AccountInfo accountInfo) throws SQLException;
	
	/**
	 *  用户注册
	 * @Description:用户注册，添加账户信息 
	 * @param accountInfo
	 * @return 注册成功返回true ,注册失败返回false
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 上午11:11:34
	 */
	public Boolean addAccountInfo(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 检查用户名是否存在
	 * @Description: 在用户修改姓名时是否，用户名是否存在
	 * @param accountName
	 * @return 存在返回false ,不存在返回true
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 下午2:18:04
	 */
	public Boolean checkAccountName(String accountName) throws SQLException;
	
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
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年10月17日 下午1:48:26
	 */
	public Boolean checkLoginIsFrozen(AccountInfo accountInfo)throws Exception;
	
	/**
	 * 
	 * @Description:注册添加用户等级信息
	 * @param accountInfo
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月9日 下午4:44:19
	 */
	public Boolean addAccountLevel(AccountInfo accountInfo)throws Exception;
	
	/**
	 *  检查微信号唯一
	 * @Description: 检查注册时用户所用的手机号是否注册过
	 * @param telephone
	 * @return 注册过>0 ,未注册=0
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 上午11:02:00
	 */
	public Boolean checkAccountWXOnly(String accountWx) throws SQLException;
	
	/**
	 * 查看邀请好友
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月29日 上午10:06:05
	 */
	public List<AccountInfo> checkFriends(AccountInfo accountInfo)throws SQLException;
}
