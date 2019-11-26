/**
 * Copyright (C) 2017 FZJT Co.Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.emailcheck.EmailCheckServiceImpl
 * @description:邮箱验证service实现类
 * 
 * @version:v1.0.0 
 * @author:WangLin
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月20日    WangLin  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.emailcheck.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.emailcheck.EmailCheckMapper;
import com.xed.financing.wxgzh.model.emailcheck.EmailCheck;
import com.xed.financing.wxgzh.service.emailcheck.EmailCheckService;

/**
 * @className:com.xed.financing.wxgzh.service.emailcheck.EmailCheckServiceImpl
 * @description:邮箱验证service实现类
 * @version:v1.0.0 
 * @date:2017年3月20日 上午11:15:58
 * @author:WangLin
 */
@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class EmailCheckServiceImpl implements EmailCheckService
{
	@Resource
	private EmailCheckMapper mapper;
	
	/**
	 * 根据用户id查询邮箱是否验证
	 * @throws SQLException 
	 */
	@Override
	public EmailCheck getAccountById(String accountId) throws SQLException
	{		
		return mapper.getAccountById(accountId);
	}
	
	/**
	 * 用户邮箱不存在的话，添加用户邮箱
	 */
	@Override
	public Boolean updateAccountEmail(EmailCheck emailCheck) throws SQLException
	{		
		return mapper.updateAccountEmail(emailCheck);
	}
	
	/**
	 * 修改邮箱验证状态
	 */
	@Override
	public Boolean updateIsEmailValidate(EmailCheck emailCheck) throws SQLException
	{
		return mapper.updateIsEmailValidate(emailCheck);
	}
	
	/**
	 * 添加邮箱认证信息
	 */
	@Override
	public void saveVerInfo(EmailCheck emailCheck) throws SQLException
	{
		mapper.saveEmailInfo(emailCheck);
		
	}
	
	/**
	 * 获取时效性
	 */
	@Override
	public Integer getTimeDiff(Integer codeId) throws SQLException
	{		
		return mapper.getTimeDiff(codeId);
	}
	
	/**
	 * 查询验证码
	 */
	@Override
	public Integer getCodeMsg(EmailCheck emailCheck) throws SQLException
	{
		return mapper.getCodeMsg(emailCheck);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.emailcheck.EmailCheckService#getCodeIdByMsg(com.xed.financing.wxgzh.model.emailcheck.EmailCheck)
	 */
	@Override
	public Integer getCodeIdByMsg(EmailCheck emailCheck) throws SQLException
	{
		// TODO Auto-generated method stub
		return mapper.getCodeIdByMsg(emailCheck);
	}
}
