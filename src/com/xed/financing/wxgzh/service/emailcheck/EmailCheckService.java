/**
 * Copyright (C) 2017 FZJT Co.Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.emailcheck.EmailCheckService
 * @description:邮箱验证service层
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
package com.xed.financing.wxgzh.service.emailcheck;

import java.sql.SQLException;

import com.xed.financing.wxgzh.model.emailcheck.EmailCheck;

/**
 * @className:com.xed.financing.wxgzh.service.emailcheck.EmailCheckService
 * @description:邮箱验证service层
 * @version:v1.0.0 
 * @date:2017年3月20日 上午11:12:26
 * @author:WangLin
 */
public interface EmailCheckService
{
	/**
	 * 
	 * @Description:根据用户id查询邮箱是否验证
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月20日 上午11:14:14
	 */
	public EmailCheck getAccountById(String accountId) throws SQLException;
	
	/**
	 * 
	 * @Description:用户邮箱不存在的话，添加用户邮箱
	 * @param emailCheck
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月20日 上午11:14:35
	 */
	public Boolean updateAccountEmail(EmailCheck emailCheck)throws SQLException;
	
	/**
	 * 
	 * @Description:修改邮箱验证状态
	 * @param emailCheck
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月20日 上午11:14:54
	 */
	public Boolean updateIsEmailValidate(EmailCheck emailCheck)throws SQLException;
	
	/**
	 * 
	 * @Description:添加邮箱认证信息
	 * @param emailCheck
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月20日 下午5:13:52
	 */
	public void saveVerInfo(EmailCheck emailCheck)throws SQLException;
	
	/**
	 * 
	 * @Description:获取时效性
	 * @param codeId
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月20日 下午5:41:04
	 */
	public Integer getTimeDiff(Integer codeId)throws SQLException;
	
	/**
	 * 
	 * @Description:查询数据库验证码
	 * @param codeId
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月21日 下午2:50:45
	 */
	public Integer getCodeMsg(EmailCheck emailCheck)throws SQLException;
	
	/**
	 * 查询数据库验证码ID(根据用户ID和验证码)
	 * @Description:
	 * @param emailCheck
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年4月27日 下午4:04:17
	 */
	public Integer getCodeIdByMsg(EmailCheck emailCheck)throws SQLException;
}
