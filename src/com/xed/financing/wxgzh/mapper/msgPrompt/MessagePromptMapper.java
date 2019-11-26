/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.message.MessageMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月14日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.msgPrompt;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;
import com.xed.financing.wxgzh.model.subject.SubjectBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.message.MessageMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月14日 下午3:51:37
 * @author:Zhang Jun
 */
public interface MessagePromptMapper
{
	/**
	 * 查找提前3天的提示的投标信息
	 * @Description: 标的结算日期前3天提示前5天未登录的用户
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年7月13日 下午5:03:58
	 */
	public List<AccountInvest> advancePrompt() throws SQLException;
	
	
	/**
	 * 查找当天提示的投标信息
	 * @Description:标的结算日当天提示
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年7月13日 下午5:06:06
	 */
	public List<AccountInvest> sameDayPrompt() throws SQLException;
	
	
	/**
	 * 查找结算日后提示的投标信息
	 * @Description:结算后还是未登录的用户,在7、15、30、60 天发送短信提示
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年7月13日 下午5:07:18
	 */
	public List<AccountInvest> afterwardsPrompt() throws SQLException;
	
	public List<SubjectBean> getEarlyPrompt() throws SQLException;
	
}
