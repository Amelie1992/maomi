/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.loginRegister.impl.LoginRegisterServiceImpl
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
package com.xed.financing.wxgzh.service.loginRegister.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.loginregister.LoginRegisterMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.service.loginRegister.LoginRegisterService;
import com.xed.financing.wxgzh.util.GetUUID;
import com.xed.financing.wxgzh.util.MD5Util;

/**
 * 登录注册Service实现类
 * @className:com.xed.financing.wxgzh.service.loginRegister.impl.LoginRegisterServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月15日 下午2:40:32
 * @author:ZhangJun
 */
@Service
@Transactional
public class LoginRegisterServiceImpl implements LoginRegisterService
{

	@Resource
	private LoginRegisterMapper mapper;
	
	@Override
	public Boolean checkTelephoneOnly(String telephone) throws SQLException
	{
		
		return mapper.checkTelephoneOnly(telephone)==0;
	}

	
	@Override
	public Boolean checkLogin(AccountInfo accountInfo) throws SQLException
	{
		//将密码MD5加密
		accountInfo.setPassword(MD5Util.getMD5String(accountInfo.getPassword()));
		String accountId = mapper.checkLogin(accountInfo);
		if(accountId!=null && !"".equals(accountId)){
			accountInfo.setAccountId(accountId);
			//登录成功，修改登录时间
			mapper.updateLoginTime(accountInfo);
			return true;
		}
		return false;
	}

	
	@Override
	public Boolean addAccountInfo(AccountInfo accountInfo) throws SQLException
	{
		//将密码MD5加密
		accountInfo.setPassword(MD5Util.getMD5String(accountInfo.getPassword()));
		accountInfo.setDealPassword(accountInfo.getPassword());
		//随机生成用户名
		accountInfo.setAccountName(GetUUID.getUsefulID("MM"));
		return mapper.addAccountInfo(accountInfo)>0;
	}

	
	@Override
	public Boolean checkAccountName(String accountName) throws SQLException
	{
		
		return mapper.checkAccountName(accountName)==0;
	}


	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.loginRegister.LoginRegisterService#queryFriendsCount(com.xed.financing.wxgzh.model.accountinfo.AccountInfo)
	 */
	@Override
	public String queryFriendsCount(AccountInfo accountInfo) throws SQLException
	{
		
		return mapper.queryFriendsCount(accountInfo);
	}


	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.loginRegister.LoginRegisterService#queryFriendsInvest(com.xed.financing.wxgzh.model.accountinfo.AccountInfo)
	 */
	@Override
	public String queryFriendsInvest(AccountInfo accountInfo) throws SQLException
	{
		
		return mapper.queryFriendsInvest(accountInfo);
	}
	
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.loginRegister.LoginRegisterService#queryFriendsCoupon(com.xed.financing.wxgzh.model.accountinfo.AccountInfo)
	 */
	@Override
	public String queryFriendsMoney(AccountInfo accountInfo) throws SQLException
	{
		
		return mapper.queryFriendsMoney(accountInfo);
	}


	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.loginRegister.LoginRegisterService#queryFriendsCoupon(com.xed.financing.wxgzh.model.accountinfo.AccountInfo)
	 */
	@Override
	public String queryFriendsCoupon(AccountInfo accountInfo) throws SQLException
	{
		
		return mapper.queryFriendsCoupon(accountInfo);
	}


	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.loginRegister.LoginRegisterService#queryFriendsPercent(com.xed.financing.wxgzh.model.accountinfo.AccountInfo)
	 */
	@Override
	public String queryFriendsPercent(AccountInfo accountInfo) throws SQLException
	{
		
		return mapper.queryFriendsPercent(accountInfo);
	}


	@Override
	public Boolean checkLoginIsFrozen(AccountInfo accountInfo) throws Exception
	{
		return mapper.checkLoginIsFrozen(accountInfo)>0;
	}


	@Override
	public Boolean addAccountLevel(AccountInfo accountInfo) throws Exception
	{
		return mapper.addAccountLevel(accountInfo)>0;
	}


	@Override
	public Boolean checkAccountWXOnly(String accountWx) throws SQLException
	{
		return mapper.checkAccountWXOnly(accountWx)==0;
	}


	@Override
	public List<AccountInfo> checkFriends(AccountInfo accountInfo) throws SQLException
	{
		List<AccountInfo> accounts = mapper.checkFriends(accountInfo);
		
		if(accounts!=null && accounts.size()>0){
			for (AccountInfo account : accounts)
			{
				if(account.getRealName()!=null && !"".equals(account.getRealName())){
					
					String realName = account.getRealName();
					realName = realName.substring(0, 1);
					if ("0".equals(account.getAccountSex()))
					{
						realName += "先生";
					}
					else
					{
						realName += "女士";
					}
					account.setRealName(realName);
				}
			}
		}
		
		return accounts;
	}

}
