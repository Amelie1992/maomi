/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月22日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.accountInfo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;

/**
 * 账户信息
 * 
 * @className:com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper
 * @description:
 * @version:v1.0.0
 * @date:2017年3月22日 下午3:40:40
 * @author:ZhangJun
 */
public interface AccountInfoMapper
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
	public AccountInfo getLoginAccountInfo(String accountId) throws SQLException;

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
	public Integer changeAccountName(AccountInfo accountInfo) throws SQLException;

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
	public Integer checkLoginPassword(AccountInfo accountInfo) throws SQLException;

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
	public Integer changeLoginPassword(AccountInfo accountInfo) throws SQLException;

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
	public Integer checkDealPassword(AccountInfo accountInfo) throws SQLException;

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
	public Integer changeDealPassword(AccountInfo accountInfo) throws SQLException;

	/**
	 * 通过电话号码查询用户信息
	 * 
	 * @Description:
	 * @param phone
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月3日 下午4:31:24
	 */
	public AccountInfo getAccountInfoByPhone(String phone) throws SQLException;

	/**
	 * 实名认证
	 * 
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月11日 下午1:59:25
	 */
	public Integer certification(AccountInfo accountInfo) throws SQLException;

	/**
	 * 检查电话号码是否注册过
	 * 
	 * @Description:
	 * @param telephone
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月15日 上午9:52:26
	 */
	public Integer checkTelephone(String telephone) throws SQLException;
	
	/**
	 * 绑定QQ、WB、WX、其他联系人、风险能力测试
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午3:42:51
	 */
	public Integer bindInfo(AccountInfo accountInfo) throws SQLException;
	
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
	 * 判断是否为羊毛党
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月30日 上午10:24:22
	 */
	public Integer countWoolMan(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 
	 * 查询累计天数>=1的所有用户 
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月30日 上午11:54:03
	 */
	public List<AccountInfo> queryMeetThanOne(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 
	 * 修改累计天数
	 * @Description:
	 * @param list
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月30日 上午11:35:56
	 */
	public void editPlusIsReward(List<?> list)throws SQLException;
	
	/**
	 * 
	 * 重置累计天数
	 * @Description:
	 * @param list
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月30日 上午11:36:08
	 */
	public void editResetIsReward(List<?> list)throws SQLException;

	/**
	 * 根据AccountWX获得用户信息
	 * @Description:
	 * @param phone
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月13日 下午5:28:31
	 */
	public AccountInfo getAccountInfoByAccountWX(String phone) throws SQLException;
	
	/**
	 * 根据unionid获取用户信息
	 * @Description:
	 * @param unionid
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午2:00:42
	 */
	public AccountInfo getAccountInfoByUnionid(String unionid) throws SQLException;
	
	/**
	 * 根据telephone更改用户openid
	 * @Description:
	 * @param telephone
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月20日 上午11:14:30
	 */
	public Integer updateAccountInfoAccountWXByTelephone(AccountInfo accountInfo) throws SQLException;
	
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
	 * 查询所有猫咪宝用户金额》0的用户
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年1月10日 下午3:40:33
	 */
	public List<AccountInfo> queryAllUser(AccountInfo accountInfo) throws SQLException;
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
	public String checkIcon(AccountInfo accountInfo) throws SQLException;
	
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
	 * 修改用户开户金账户成功
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月8日 上午9:49:46
	 */
	public Integer changeHaveGold(String accountId)throws SQLException;
	
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
