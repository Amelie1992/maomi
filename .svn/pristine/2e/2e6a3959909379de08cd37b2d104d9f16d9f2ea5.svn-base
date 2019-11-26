/**
 * Copyright (C) 2017 FZJT Co.Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.emailcheck.EmailCheckMapper
 * @description:邮箱认证Dao层
 * 
 * @version:v1.0.0 
 * @author:WangLin
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月18日    WangLin  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.emailcheck;

import java.sql.SQLException;

import com.xed.financing.wxgzh.model.emailcheck.EmailCheck;

/**
 * @className:com.xed.financing.wxgzh.mapper.emailcheck.EmailCheckMapper
 * @description:邮箱认证Dao层
 * @version:v1.0.0 
 * @date:2017年3月18日 下午3:51:45
 * @author:WangLin
 */
public interface EmailCheckMapper
{
	/**
	 * 
	 * @Description:根据用户id查询邮箱是否验证
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月18日 下午4:21:57
	 */
	public EmailCheck getAccountById(String accountId)throws SQLException;
	
	/**
	 * 
	 * @Description:用户邮箱不存在的话，添加用户邮箱
	 * @param emailCheck
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月18日 下午4:30:26
	 */
	public Boolean updateAccountEmail(EmailCheck emailCheck)throws SQLException;
	
	/**
	 * 
	 * @Description:修改邮箱验证状态
	 * @param emailCheck
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月18日 下午4:33:40
	 */
	public Boolean updateIsEmailValidate(EmailCheck emailCheck)throws SQLException;
	
	/**
	 * 
	 * @Description:添加邮箱认证信息
	 * @param emailCheck
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月20日 下午2:57:30
	 */
	public void saveEmailInfo(EmailCheck emailCheck)throws SQLException;
	
	/**
	 * 
	 * @Description:获取时效性
	 * @param sendTime
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月20日 下午5:34:21
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
